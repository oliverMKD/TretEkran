package com.oliver.tretekran.klasi;

import java.io.Serializable;

public class Vraboteni implements Serializable {
   public String name;
   public boolean isChecked;

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public Vraboteni(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
