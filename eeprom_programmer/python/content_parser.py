#!/usr/bin/python
# Parse HDL Like data to a data matrix

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

class file_parser:
    "Parse data from HDL-like file to the database"
    
    # Read the data from the file
    def __init__(self, filename):
        _file = open(filename,"r")
        self.data = _file.readlines()
        _file.close()

    def parse_file(self):
        content = content_parser()
        return content.parse_data(self.data)

class content_parser:
    "Parse content from data buffer"

    def parse_data(self, data):
        out = []
        for i in range(0, len(data)):
            dt = self.parse_line(data[i])
            if (dt != None):
                out.append(dt)
        return out


    def parse_line(self, line):
        data = line.upper().split('&')

        comment = ''
        command = 0
        param = 0

        for i in range(0, len(data)):
            data[i] = data[i].strip()

        if (data[0][0] == '-'):
            return None

        elif (data[0][0] == '('):
            #process data
            for i in range(0, len(data)):
                comment_ = data[i].split("--")
                
                if (len(comment_)>1):
                    comment = comment_[1].strip()
                
                data[i] = data[i].replace('(', '').replace(')', '').replace(',', '').strip().split("--",1)[0].split(' ');
                cmd = 0 # execute or
                cont = 0;
                for j in range(0, len(data[i])):
                    if (data[i][j] != ''):
                        if (data[i][j][0] == 'X'):
                            parsed = int(data[i][j].strip('X"'), 16)
                            if (cmd==0):
                                cont = cont | parsed
                            elif (cmd==1):
                                cont = cont & parsed

                        elif (data[i][j] == "OR"):
                            cmd = 0
                        elif (data[i][j] == 'AND'):
                            cmd = 1
                        else:
                            print 'unrecognised : ', data[i][j]

                if (i == 0):
                    command = cont
                elif (i==1):
                    param = cont
                
        else:
            print 'invalid content'

        return (command, param, comment)
