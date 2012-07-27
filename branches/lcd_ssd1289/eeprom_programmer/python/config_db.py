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

import sqlite3

class access_db:
    "Handle access to the DB file"

    DB_NAME = ":memory:" #config_database.db"

    # Initialize the class, load the database file
    def __init__(self, filename=DB_NAME):
        self.conn = sqlite3.connect(filename)
        self.cursor = self.conn.cursor()

    # Commit changes to the file and close the database
    def close(self):
        self.conn.commit()
        self.conn.close()

    # List available tables names
    def tables(self):
        self.cursor.execute("SELECT name FROM sqlite_master WHERE type='table'")
        return self.cursor.fetchall()

    # Create a new table
    def create_table(self, table_name, pattern):
        self.cursor.execute('CREATE TABLE `%s` (%s)'%(table_name,pattern))

    # Delete a table from the database
    def drop_table(self, table_name):
        self.cursor.execute("drop table %s"%(table_name))

    # Insert data into a table
    def insert(self, table_name, data, pattern=""):
        self.cursor.execute("insert into `%s` %s values (%s)"%(table_name,pattern,data))
    # Read data from a table
    def select(self, table_name, fields="*", filter_=""):
        self.cursor.execute("select %s from `%s` %s"%(fields, table_name, filter_))
        return self.cursor.fetchall()

    # Insert data into a table
    def update(self, table_name, data, filter_=""):
        self.cursor.execute("update `%s` set %s %s"%(table_name,data, filter_))   

    # Remove data from a table
    def delete(self, table_name, filter_=""):
        self.cursor.execute("delete from `%s` %s"%(table_name, filter_))



class config_db:
    "Handle configuration storage"

    LcdConfigs = []
    CamConfigs = []
    HAS_CONFIG_LIST = 0

    # Open the database
    def __init__(self, dbfile=":memory:"):
        print "Opening database..."
        self.db = access_db(dbfile)
        tables = self.db.tables()
        for i in range(0, len(tables)):
           if (tables[i][0] == "CONFIG_LIST"):
               self.HAS_CONFIG_LIST = 1;
        self.init_tables()

    # Initialize the CONFIG_LIST
    def init_tables(self):
        if (self.HAS_CONFIG_LIST == 0):
            print "CONFIG_LIST not found, creating it"
            self.db.create_table("CONFIG_LIST", "id integer primary key, tabname text, desc text, type integer")

    # Display configurations
    def show_available_configs(self):
        print self.db.select("CONFIG_LIST")
        print self.db.tables()

    # Close the database
    def close(self):
        self.db.close()
   

    #### LCD relative configuration
    # Create a new LCD configuration
    def create_lcd_config(self, lcd_name, lcd_desc):
        # Check if the config already exists
        tables= self.db.tables()
        for i in range(0, len(tables)):
            if (tables[i][0]==lcd_name):
                print "Couldn't create table, already exists"
                return -1;

        self.db.create_table(lcd_name, "id integer primary key, type integer, command byte, value integer")
        self.db.insert("CONFIG_LIST", "'%s', '%s', 1"%(lcd_name, lcd_desc), "(tabname, desc, type)")

    
    # Set LCD configuration words
    def set_lcd_config_words(self, lcd_name, set_data, set_x, set_y):
        ## Check if these data are already set
        ## SET_DATA
        _id = self.db.select(lcd_name, "id", "WHERE type=-1")
        if (len(_id) != 0):
            self.db.update(lcd_name, "command=%d"%set_data ,"WHERE id=%s"%(_id[0][0]))
        else :
            self.db.insert(lcd_name, "-1, %d, 0"%set_data, "(type, command, value)")

        ## SET_X
        _id = self.db.select(lcd_name, "id", "WHERE type=-2")
        if (len(_id) != 0):
            self.db.update(lcd_name, "command=%d"%set_x ,"WHERE id=%s"%(_id[0][0]))
        else :
            self.db.insert(lcd_name, "-2, %d, 0"%set_x, "(type, command, value)")

        ## SET_Y
        _id = self.db.select(lcd_name, "id", "WHERE type=-3")
        if (len(_id) != 0):
            self.db.update(lcd_name, "command=%d"%set_y ,"WHERE id=%s"%(_id[0][0]))
        else :
            self.db.insert(lcd_name, "-3, %d, 0"%set_y, "(type, command, value)")

    # Add configuration words and value to LCD configuration sequence
    def add_lcd_config_word(self, lcd_name, address, value):
        self.db.insert(lcd_name, "%d, %d, 0"%(address, value), "(command, value, type)")
  
    # Remove data from configuration sequence
    def remove_lcd_config_word(self, lcd_name, id_):
        self.db.delete(lcd_name, "where id=%d"%(id_))
    
    # Delete a LCD configuration from database
    def delete_lcd(self, lcd_name):
        id_ = self.db.select("CONFIG_LIST", "id", "where tabname='%s'"%(lcd_name))

        if (len(id_) != 0):
            self.db.delete("CONFIG_LIST", "where id=%d"%(id_[0][0]))
            self.db.drop_table(lcd_name)

    # read the configuration words for LCD
    def lcd_get_config_words(self, lcd_name):
        set_data = self.db.select(lcd_name, "command", "where type=-1")
        set_x = self.db.select(lcd_name, "command", "where type=-2")
        set_y = self.db.select(lcd_name, "command", "where type=-3")
    
        if (len(set_data)!=0):
            set_data = set_data[0][0]
        else:
            set_data = -1

        if (len(set_x)!=0):
            set_x = set_x[0][0]
        else:
            set_x = -1
        if (len(set_y)!=0):
            set_y = set_y[0][0]
        else:
            set_y = -1

        return (set_data, set_x, set_y)
    
    # read the configuration sequence for the LCD
    def lcd_get_configuration_sequence(self, lcd_name):
        sequence = self.db.select(lcd_name, "command, value", "where type=0")
        return sequence


    #### CAMERA relative configuration
    # Create a new CAM configuration
    def create_cam_config(self, cam_name, cam_desc):
        # Check if the config already exists
        tables= self.db.tables()
        for i in range(0, len(tables)):
            if (tables[i][0]==cam_name):
                print "Couldn't create table, already exists"
                return -1;

        self.db.create_table(cam_name, "id integer primary key, command byte, value integer")
        self.db.insert("CONFIG_LIST", "'%s', '%s', 0"%(cam_name, cam_desc), "(tabname, desc, type)")

    
    # Add configuration words and value to CAM configuration sequence
    def add_cam_config_word(self, cam_name, address, value):
        self.db.insert(cam_name, "%d, %d"%(address, value), "(command, value)")
  
    # Remove data from configuration sequence
    def remove_cam_config_word(self, cam_name, id_):
        self.db.delete(cam_name, "where id=%d"%(id_))
    
    # Delete a CAM configuration from database
    def delete_cam(self, cam_name):
        id_ = self.db.select("CONFIG_LIST", "id", "where tabname='%s'"%(cam_name))

        if (len(id_) != 0):
            self.db.delete("CONFIG_LIST", "where id=%d"%(id_[0][0]))
            self.db.drop_table(cam_name)

    # read the configuration sequence for the CAM
    def cam_get_configuration_sequence(self, cam_name):
        sequence = self.db.select(cam_name, "command, value")
        return sequence
