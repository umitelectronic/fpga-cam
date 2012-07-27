#!/usr/bin/env python

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

# import local libraries
import config_db
import content_parser
# import pyGTK library
import pygtk
pygtk.require('2.0')
import gtk

class config_gui:
    "This class builds an GUI to manage configuration database"

    def __init__(self):
        # create the window
        self.window = gtk.Window(gtk.WINDOW_TOPLEVEL)
        self.window.set_title("SPARTCAM EEPROM configuration management")
        self.window.connect("delete_event", self.delete)
        self.window.connect("destroy", self.destroy)

        # create the global vbox
        self.vbox = gtk.VBox()
        self.window.add(self.vbox)
        
        # create the menu bar
        self.menu_bar = gtk.MenuBar()

        file_mi = gtk.MenuItem("File")

        # Create the File Menu
        file_menu = gtk.Menu()
        file_menu.set_title("File")

        # Setup the File menu
        item = gtk.MenuItem("Quit")
        file_menu.append(item)

        item.connect("activate", self.destroy)

        # Append the menu to the menubar
        file_mi.set_submenu(file_menu)

        self.menu_bar.append(file_mi)

        # Pack the whole data to the window
        self.vbox.pack_start(self.menu_bar)

        self.window.show_all()

    def delete(self, widget, event, data=None): 
        return False

    def destroy(self, widget, data=None):
        gtk.main_quit()

    def run(self):
        gtk.main()





if __name__=="__main__":
    gui = config_gui()
    gui.run()
