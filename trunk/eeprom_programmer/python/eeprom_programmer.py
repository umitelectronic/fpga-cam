#!/usr/bin/python
# EEPROM Programme for SPARTCAM project
#   This program is used to read/write configuration data
#   from/to the I2C EEPROM used to store camera configuration

# Copyright (C) 2012   Aurelien VALADE <wolvi.lataniere@free.fr>
#
#    This program is free software: you can redistribute it and/or modify
#    it under the terms of the GNU General Public License as published by
#    the Free Software Foundation, either version 3 of the License, or
#    (at your option) any later version.
#
#    This program is distributed in the hope that it will be useful,
#    but WITHOUT ANY WARRANTY; without even the implied warranty of
#    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
#    GNU General Public License for more details.
#
#    You should have received a copy of the GNU General Public License
#    along with this program.  If not, see <http://www.gnu.org/licenses/>.

import sys, os, serial, getopt, time
sys.path.append(os.path.abspath('./'))
import hex_reader

## Start of EEPROM_Programmer class
# This class handles communications with the EEPROM Programmer
# hardware (implemented in the Papilio ONE FPGA) in order to
# process data read/write from/to the I2C EEPROM on the Spartcam Megawing
#
class EEPROM_Programmer:
    "I2C EEPROM Programmer for SPARTCAM Project"
    # Constants
    INIT_CMD = '\xAA'
    READ_CMD = '\x01'
    WRITE_CMD = '\x02'
    ACK = '\x55'
    NACK = '\xCC'
    EOF = '\x0F'

    # Programmer class initialization
    def __init__(self, port):
        try:
            from serial.tools.list_ports import comports
        except ImportError:
            comports = None

        self.serial_port = serial.Serial(port=port, baudrate=3000000,
                                         timeout=1)

    # Send the start of frame to the FPGA
    def send_init(self):
        #print "- Sending INIT"
        self.serial_port.write(self.INIT_CMD)

    # Try to write data to the I2C EEPROM
    def write_data(self, base, count, data):
        time.sleep(0.1)
        self.send_init()
        #print "- Sending Write command"
        self.serial_port.write(self.WRITE_CMD)
        # Check the ACK
        if (self.wait_ack()<0):
            print "FPGA didn't ACK"
            return -1
        self.serial_port.write(chr(base/256)+chr(base%256));
        self.serial_port.write(chr(count));
        if (self.wait_ack()<0):
            print "FPGA didn't ACK"
            return -1
        
        for i in range(0, count) :
            self.serial_port.write(data[i])
            if i < count-1:
                if (self.wait_ack()<0):
                    print "FPGA didn't ACK"
                    return -1;

        data = self.serial_port.read()
        #if (data == self.EOF):
        #   print "EOF OK"
        #print "- Read data : " + data

    # Try to read data from the I2C EEPROM
    def read_data(self, base, count):
        data = []
        self.send_init()
        #print "- Sending Read command"
        self.serial_port.write(self.READ_CMD)
        if (self.wait_ack()<0):
           print "FPGA didn't ACK"
           return -1
        self.serial_port.write(chr(base/256)+chr(base%256));
        self.serial_port.write(chr(count));
        # Check the ACK
        if (self.wait_ack()<0):
           print "FPGA didn't ACK"
           return -1

        for i in range(0, count) :
            data.append(self.serial_port.read())
            #print "- Read data : " + hex(ord(data[i]))

        if (self.wait_ack()<0):
           print "FPGA didn't ACK"
           return -1

        return data


    # Wait for an acknowledge
    def wait_ack(self):
        try_ack=5
        while (try_ack>0):
           # print "- Waiting for ACK"
            read_size = self.serial_port.read()
            if (read_size == self.ACK):
            #    print "ACK received"
                return 1
            if (read_size == self.EOF):
            #    print "EOF received"
                return 0
            if (read_size == self.NACK):
            #    print "NACK received"
                return -1
            try_ack = try_ack -1
        return -1
        
    # Close the communication interface
    def close(self):
        self.serial_port.close()

## End of EEPROM_Programmer Class



# Display de program license
def license():
    print "\n I2C EEPROM Programmer for SPARCAM"
    print " Copyright (C) 2012   Aurelien VALADE"
    print "This program comes with ABSOLUTELY NO WARRANTY; for details type `show w'."
    print "This is free software, and you are welcome to redistribute it"
    print "under certain conditions; type `show c' for details.\n"


# Display the program usage
def usage():
    print "Usage : " + sys.argv[0] + " -t TTY_NAME -H HEXFILE -m mode [-s size]"
    print "\n\t-t : Set the TTY name to communicate with the FPGA"
    print "\t-H : HEXFILE name of the hexfile to read from/write to"
    print "\t-m : Operating mode : read : read data from the EEPROM (store to the file)"
    print "\t                      write : write data to the EEPROM (read from the file)"
    print "\t-s : size of the EEPROM (in kbits)"
    print "\n\nExemple : "+sys.argv[0]+ " -t /dev/ttyUSB1 -H test.hex -m read -s 128"



## Start of the main program
def main(argv):
    license()

    port_name = ""
    hexfile = ""
    mode=""
    eesize=0

    try:
        opts, args = getopt.getopt(argv, "t:H:m:hs:", ["tty", "help", "mode", "hex", "size"])
    except getopt.GetoptError:
        usage()
        sys.exit(2)
        
    for opt, arg in opts:
        if opt in ("-t", "--tty"):
            port_name=arg
        elif opt in ("-H", "--hex"):
            hexfile = arg
        elif opt in ("-m", "--mode"):
            mode = arg
        elif opt in ("-s", "--size"):
            print 'eesize : %s'%(arg)
            eesize = int(arg)
        else:
            if opt in ("-h", "--help"):
                usage()
                sys.exit(0)
    
    if port_name=="" or hexfile=="" or mode=="":
        usage() 
        sys.exit(0)

    if mode in ("read", "r", "R"):
        if (eesize>0 and eesize<65536/1024*8):
            read_eeprom(port_name, hexfile, eesize)
        else:
            usage()
            sys.exit(0)
    elif mode in ("write", "w", "W"):
        program(port_name, hexfile)
    elif mode in ("erase", "e", "E"):
        if (eesize>0 and eesize<65536/1024*8):
            erase_eeprom(port_name, eesize)
        else:
            usage()
            sys.exit(0)
    else:
        usage()
        sys.exit(0)


def program(port_name, hexfile):
    prog = EEPROM_Programmer(port_name)
    infile = hex_reader.hex_reader(hexfile)
    hexdat = infile.read()

    for i in range(0, len(hexdat.size)):
        while (hexdat.size[i]>8):
            prog.write_data(hexdat.base[i], 8, hexdat.data[i])
            hexdat.base[i] = hexdat.base[i] + 8;
            hexdat.data[i] = hexdat.data[i][7:-1]
            hexdat.size[i] = hexdat.size[i]-8

        prog.write_data(hexdat.base[i], hexdat.size[i], hexdat.data[i])


    time.sleep(1)

    for i in range(0, len(hexdat.size)):
        while (hexdat.size[i]>8):
            data = prog.read_data(hexdat.base[i], 8)
            prog.write_data(hexdat.base[i], 8, hexdat.data[i])
            hexdat.base[i] = hexdat.base[i] + 8;
            if (data != hexdat.data[0:7]):
                print 'Verify failed for base 0x%02X-%02X'%((hexdat.base[i]/256),(hexdat.base[i]%256))
                exit -1
            hexdat.data[i] = hexdat.data[i][8:-1]
            hexdat.size[i] = hexdat.size[i]-8

        data = prog.read_data(hexdat.base[i], hexdat.size[i])
        if (data != hexdat.data[i]):
            print 'Verify failed for base 0x%02X+%02X'%((hexdat.base[i]/256),(hexdat.base[i]%256))
            exit(-1)

    print "Programmation done with success"
        
    prog.close()



def read_eeprom(port_name, hexfile, eesize):
    print 'Reading %d kbytes'%(eesize)
    prog = EEPROM_Programmer(port_name)
    outfile = hex_reader.hex_reader(hexfile)

    hexdat = hex_reader.hex_data()

    data=[];

    for i in range(0, (eesize*1024)/64):
        data.extend(prog.read_data(i*8, 8))
                    
    print "EEPROM Read, Filling data block"
    hexdat.fill(0, data)
    print "Writting output file"
    outfile.write(hexdat)
    
    print "EEPROM read succeeded"
        
    prog.close()



def erase_eeprom(port_name, eesize):
    print 'Erasing %d kbytes'%(eesize)
    prog = EEPROM_Programmer(port_name)

    data = ['\xff', '\xff', '\xff', '\xff', '\xff', '\xff', '\xff', '\xff']

    for i in range(0, (eesize*1024)/64):
        print 'Erasing %d/100'%(100*i/(eesize*1024/64))
        prog.write_data(i*8, 8, data)

    time.sleep(0.1)

    for i in range(0, (eesize*1024)/64):
        data_read = prog.read_data(i*8, 8)
        if (data_read != data):
            print "Erased failed"
            exit(0)
                    
    print "EEPROM erased"
        
    prog.close()




## Route to the main program
if __name__ == "__main__":
    main(sys.argv[1:])
