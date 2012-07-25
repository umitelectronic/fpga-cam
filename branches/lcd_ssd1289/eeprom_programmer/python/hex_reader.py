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
import binascii

class hex_data:
    size = []
    base = []
    data = []

    def fill(self, base, data):
        print 'Base %04X, Data len %2X'%(base, len(data))
        self.data = []
        self.size = []
        self.base = []

        while (len(data)>16):
            self.size.append(16)
            self.base.append(base)
            data_out = []
            base = base + 16
            for i in range(0, 16):
                data_out.append(data.pop(0))
            self.data.append(data_out)

        self.size.append(len(data))
        self.base.append(base)
        data_out = []
        while (len(data)>0):
            data_out.append(data.pop(0))
        self.data.append(data_out)
    

class hex_reader:
    "Intel HEX file access"

    def __init__(self, filename):
        self.fname = filename
        
        
    def read(self):
        self.f = open(self.fname, 'r')

        result = hex_data()
        lines = self.f.readlines()
        
        for i in range(0, len(lines)):
            if (lines[i][0] != ':'):
                print "Invalid line format"
                return -1
            count = int(lines[i][1]+lines[i][2],16)
            base = int(lines[i][3]+lines[i][4]+lines[i][5]+lines[i][6],16)
            t = int(lines[i][7]+lines[i][8], 16)
            data = []
            if (t==0):
                cs = count
                cs = cs + (base/256) + (base%256)
                cs = cs + t
                for j in range(0, count):
                    data.append(chr(int(lines[i][9+(2*j)]+lines[i][10+(2*j)], 16)))
                    cs = cs + ord(data[j])
                if ((cs+int(lines[i][count*2 + 9] + lines[i][count*2+10],16))%256 == 0):
                    result.size.append(count)
                    result.base.append(base)
                    result.data.append(data)
                else:
                    print "Checksum error"

            else:
                print "Finished"
                self.f.close()
                return result;

    def write(self, data):
        self.f = open(self.fname, 'w')

        for i in range(0, len(data.size)):
            cs = 0
            cs = data.size[i] + data.base[i]/256 + data.base[i]%256
            self.f.write(':')
            self.f.write('%02X%04X00'%(data.size[i],data.base[i]))
            for j in range(0, data.size[i]):
                self.f.write('%02X'%(ord(data.data[i][j])))
                cs = cs+ord(data.data[i][j])
 
            self.f.write('%02X'%(256-(cs%256)))
            self.f.write("\n")

        self.f.write(":00000001FF\n")
        self.f.close()

