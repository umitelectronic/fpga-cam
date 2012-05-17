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

import sys, os, serial

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
        print "- Sending INIT"
        self.serial_port.write(self.INIT_CMD)

    # Try to write data to the I2C EEPROM
    def write_data(self):
        self.send_init()
        print "- Sending Write command"
        self.serial_port.write(self.WRITE_CMD)
        data = self.serial_port.read()
        print "- Read data : " + data

    # Try to read data from the I2C EEPROM
    def read_data(self):
        self.send_init()
        print "- Sending Read command"
        self.serial_port.write(self.READ_CMD)
        data = self.serial_port.read()
        print "- Read data : " + data

    # Wait for an acknowledge
    def wait_ack(self):
        try_ack=5
        while (try_ack>0):
            print "- Waiting for ACK"
            read_size = self.serial_port.read()
            if (read_size == self.ACK):
                return 1
            else:
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



## Start of the main program
license()

prog = EEPROM_Programmer("/dev/ttyUSB2")
prog.write_data()
prog.read_data()
prog.wait_ack()

prog.close()
