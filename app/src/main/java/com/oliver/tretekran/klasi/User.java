package com.oliver.tretekran.klasi;

import java.io.Serializable;

public class User implements Serializable{

    public int number;

    public User(int number) {
        this.number = number;
    }

    public User() {

    }



    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
