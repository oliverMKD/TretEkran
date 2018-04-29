package com.oliver.tretekran;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.oliver.tretekran.adapters.Adapterbroevi;
import com.oliver.tretekran.klasi.User;

import java.lang.reflect.Type;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PrethodnoActivity extends AppCompatActivity {

    @BindView(R.id.broj)
    EditText broj;
    String dodadiBroj = " ";
    public ArrayList<User> broevi;
    @BindView(R.id.recyclerriew_broevi)
    RecyclerView recyclerView;
    Adapterbroevi adapterbroevi;
    public User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prethodno);
        ButterKnife.bind(this);

       Loaddata();



        LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(PrethodnoActivity.this, LinearLayoutManager.VERTICAL, false);
        adapterbroevi = new Adapterbroevi(this,broevi);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager (horizontalLayoutManagaer);
        recyclerView.setAdapter(adapterbroevi);




    }



    @OnClick(R.id.broj0)
    public void OnClick0(View view) {
        dodadiBroj = "0";
        broj.setText( broj.getText()+  dodadiBroj.toString());
        broj.setSelection(broj.getText().length());



    }

    @OnClick(R.id.broj1)
    public void OnClick1(View view) {
        dodadiBroj = "1";
        broj.setText( broj.getText()+  dodadiBroj.toString());
        broj.setSelection(broj.getText().length());



    }
    @OnClick(R.id.broj2)
    public void OnClick2(View view) {
        dodadiBroj = "2";
        broj.setText( broj.getText()+  dodadiBroj.toString());
        broj.setSelection(broj.getText().length());



    }
    @OnClick(R.id.broj3)
    public void OnClick3(View view) {
        dodadiBroj = "3";
        broj.setText( broj.getText()+  dodadiBroj.toString());
        broj.setSelection(broj.getText().length());



    }
    @OnClick(R.id.broj4)
    public void OnClick4(View view) {
        dodadiBroj = "4";
        broj.setText( broj.getText()+  dodadiBroj.toString());
        broj.setSelection(broj.getText().length());



    }
    @OnClick(R.id.broj5)
    public void OnClick5(View view) {
        dodadiBroj = "5";
        broj.setText( broj.getText()+  dodadiBroj.toString());
        broj.setSelection(broj.getText().length());



    }
    @OnClick(R.id.broj6)
    public void OnClick6(View view) {
        dodadiBroj = "6";
        broj.setText( broj.getText()+  dodadiBroj.toString());
        broj.setSelection(broj.getText().length());



    }
    @OnClick(R.id.broj7)
    public void OnClick7(View view) {
        dodadiBroj = "7";
        broj.setText( broj.getText()+  dodadiBroj.toString());
        broj.setSelection(broj.getText().length());



    }
    @OnClick(R.id.broj8)
    public void OnClick8(View view) {
        dodadiBroj = "8";
        broj.setText( broj.getText()+  dodadiBroj.toString());
        broj.setSelection(broj.getText().length());



    }
    @OnClick(R.id.broj9)
    public void OnClick9(View view) {
        dodadiBroj = "9";
        broj.setText( broj.getText()+  dodadiBroj.toString());
        broj.setSelection(broj.getText().length());



    }
    @OnClick(R.id.backspace)
    public void OnClick10(View v) {

        if (dodadiBroj != null && dodadiBroj.length() > 0){

            String kratenka = broj.getText().toString();
            dodadiBroj = kratenka.substring(0,kratenka.length() - 1);
            broj.setText(dodadiBroj);
            broj.setSelection(broj.getText().length());
        }




    }

    @OnClick(R.id.next)
    public void Onclicknext(View view){
        Intent intent = new Intent(PrethodnoActivity.this, TretoAktiviti.class);
        startActivity(intent);
    }

    @OnClick(R.id.save)
    public void saveUserDetails(){

//        broevi = new ArrayList<>();
        broevi.add(new User(Integer.parseInt(broj.getText().toString())));
        Savedata();
        adapterbroevi.notifyDataSetChanged();



    }
    @OnClick (R.id.l)
    public void shownumber(){

        Loaddata();
        adapterbroevi.notifyDataSetChanged();



    }


    public void Savedata (){
        android.content.SharedPreferences sharedPreferences = getSharedPreferences("preff", MODE_PRIVATE);
        android.content.SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(broevi);
        editor.putString("broevi",json);
        editor.apply();
        adapterbroevi.notifyDataSetChanged();


    }

    public void Loaddata(){
        android.content.SharedPreferences sharedPreferences = getSharedPreferences("preff", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("broevi",null);
        Type type = new TypeToken<ArrayList<User>>() {}.getType();
        broevi = gson.fromJson(json,type);
        broj.getText();

    }

}

