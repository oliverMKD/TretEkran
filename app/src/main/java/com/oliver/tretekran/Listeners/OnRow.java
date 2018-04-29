package com.oliver.tretekran.Listeners;

import com.oliver.tretekran.klasi.Slika;
import com.oliver.tretekran.klasi.Vraboteni;

public interface OnRow {
    public void onRowClick(Vraboteni vraboteni, int position);
    public void onSlikaClick(Slika slika,int position);
}
