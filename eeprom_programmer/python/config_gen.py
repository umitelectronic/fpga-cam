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

db = config_db.config_db("config.db")
db.create_cam_config("OV7660", "30fps VGA camera")
db.create_lcd_config("SSD1298", "3.2\" LCD")
db.set_lcd_config_words("SSD1298", 0x22, 0x4E, 0x4F)
db.add_lcd_config_word("SSD1298", 0x01, 0x5)

db.add_cam_config_word("OV7660", 0x45, 0x00)
db.show_available_configs()
#db.delete_lcd("SSD1298")
#db.show_available_configs()
print 'LCD CONFIG WORDS : ', db.lcd_get_config_words("SSD1298")
print 'init sequence : ', db.lcd_get_configuration_sequence('SSD1298')

print 'Cam init_seq :', db.cam_get_configuration_sequence("OV7660")
db.close()
