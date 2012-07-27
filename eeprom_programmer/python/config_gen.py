#!/usr/bin/python

# This program has been developped to generate Intel Hex files
# to load into the I2C EEPROM of the SpartCam project.

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

import config_db
import content_parser

cp = content_parser.file_parser("lcd.txt")
parsed = cp.parse_file()
print 'Size = ', len(parsed)
for i in range(0, len(parsed)):
    print 'Cmd : 0x%02X, param : 0x%04X, Comment : %s'%(parsed[i])
