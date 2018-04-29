package com.oliver.tretekran.klasi;

import java.io.Serializable;

public class Slika implements Serializable {

    int Slika;
    boolean favorit;

    public Slika(int slika, boolean favorit) {
        Slika = slika;
        this.favorit = favorit;
    }

    public int getSlika() {
        return Slika;
    }

    public void setSlika(int slika) {
        Slika = slika;
    }

    public boolean isFavorit() {
        return favorit;
    }

    public void setFavorit(boolean favorit) {
        this.favorit = favorit;
    }
}
