package com.atees.listroom;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "DataTable")

public class Words {

        @PrimaryKey(autoGenerate = true)
        private int id;
        @ColumnInfo(name = "personalname")
        private String name;
        @ColumnInfo(name = "personalemail")

       private String email;
        @ColumnInfo(name = "Type")
        private String persontype;

    public Words(String name, String email,String persontype) {
            this.name = name;
            this.email = email;
            this.persontype=persontype;
        }




    public int getId () {
            return id;
        }

        public void setId ( int id){
            this.id = id;
        }

        public String getName () {
            return name;
        }

        public void setName (String name){
            name = name;
        }

        public String getEmail () {
            return email;
        }

        public void setEmail (String email){
            email = email;
        }

    public String getPersontype() {
        return persontype;
    }

    public void setPersontype(String persontype) {
        this.persontype = persontype;
    }
}
