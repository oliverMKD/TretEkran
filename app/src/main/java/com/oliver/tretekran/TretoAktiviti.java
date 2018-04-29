package com.oliver.tretekran;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.oliver.tretekran.Listeners.OnRow;
import com.oliver.tretekran.adapters.IminjaAdapter;
import com.oliver.tretekran.adapters.SlikiAdapter;
import com.oliver.tretekran.klasi.Slika;
import com.oliver.tretekran.klasi.User;
import com.oliver.tretekran.klasi.Vraboteni;
import com.oliver.tretekran.klasi.VraboteniModel;

import java.lang.reflect.Type;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TretoAktiviti extends AppCompatActivity {
    Context context;
    @BindView(R.id.MyRV)
    RecyclerView rv;
    @BindView(R.id.kopce_svedski)
    Button svedski;
    @BindView(R.id.kopce_engleski)
    Button engleski;
    @BindView(R.id.poraka)
    TextView tekst;
    @BindView(R.id.poraka_edit)
    EditText editText;
    @BindView(R.id.MyRV2)
    RecyclerView rv2;
    @BindView(R.id.kopce_nazad)
    Button nazad;
    @BindView(R.id.kopce_prati)
    Button prati;
    @BindView(R.id.kopce_edit)
    Button kopceEdit;
    @BindView(R.id.kopce_dodaj_vraboten)
    Button plus;
    @BindView(R.id.kopce_izbrisi_vraboten)
    Button minus;
    public IminjaAdapter adapter;
    VraboteniModel model;
    public ArrayList<Vraboteni> model2;
    Vraboteni vraboteni;
    public boolean isChecked;
    public SlikiAdapter adapter2;
    public ArrayList<Slika> fotografii;
    String aaa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treto_aktiviti);
        context = this;
        ButterKnife.bind(this);
        LoadVraboteni();
//        createVraboteni();
        createSliki();
        buildSlikiRecycler();
        buildRecyclerView();
    }

    public void createVraboteni() {
        model2 = new ArrayList<>();
        model2.add(new Vraboteni("Oliver"));
        model2.add(new Vraboteni("Goran"));
        model2.add(new Vraboteni("Pane"));
    }
        public void buildRecyclerView(){
            rv2.setHasFixedSize(true);
            adapter = new IminjaAdapter(this,model2, new OnRow() {
                @Override
                public void onRowClick(Vraboteni vraboteni, int position) {


                        tekst.setText(R.string.tekst_na_angliski + "\n" + vraboteni.name);

}

                @Override
                public void onSlikaClick(Slika slika, int position) {

                }
            });
            rv2.setLayoutManager(new LinearLayoutManager(this));
            rv2.setAdapter(adapter);
        }

    public void createSliki() {
        fotografii = new ArrayList<>();
//        fotografii.add(new Slika(R.drawable.cetri,true));
//        fotografii.add(new Slika(R.drawable.pet,true));
//        fotografii.add(new Slika(R.drawable.prvo,true));
//        fotografii.add(new Slika(R.drawable.vtoro,false));
//        fotografii.add(new Slika(R.drawable.treto,false));
        fotografii.add(new Slika(R.drawable.index,true));

    }

        public void buildSlikiRecycler(){
            rv.setHasFixedSize(true);
            adapter2 = new SlikiAdapter(this, fotografii, new OnRow() {
                @Override
                public void onRowClick(Vraboteni vraboteni, int position) {

                }

                @Override
                public void onSlikaClick(Slika slika, int position) {
                    ZacuvajSliki();
                    Toast.makeText(context, "dodadeno vo izbrani sliki", Toast.LENGTH_LONG).show();
                }
            });
            LinearLayoutManager layoutManager
                    = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            rv.setLayoutManager(layoutManager);
            rv.setAdapter(adapter2);
        }


    @OnClick(R.id.kopce_svedski)
    public void onKlik(View view){
        tekst.setText(R.string.tekst_na_svedski);
        editText.setVisibility(View.INVISIBLE);
        }
    @OnClick(R.id.kopce_engleski)
    public void onKlik2(View view){
        tekst.setText(R.string.tekst_na_angliski);
        editText.setVisibility(View.INVISIBLE);
    }
    @OnClick(R.id.kopce_nazad)
    public void onKlik3(View view){
        Intent intent = new Intent(this,PrethodnoActivity.class);
        startActivity(intent);
    }
    @OnClick(R.id.kopce_edit)
    public void onKlik4(View view){
        editText.setVisibility(View.VISIBLE);
        editText.setContextClickable(true);
    }
    @OnClick(R.id.kopce_dodaj_vraboten)
    public void onKlik5(View view){
        popUpEditText();
//        SaveData();
        adapter.notifyDataSetChanged();
//
    }

    @OnClick(R.id.kopce_izbrisi_vraboten)
    public void onKlik6(View view){
        adapter.clear();
        adapter.notifyDataSetChanged();
    }

    @OnClick (R.id.kopce_prati)
    public void Onklik7(View view){
        android.content.SharedPreferences sharedPreferences2 = getSharedPreferences("preff", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences2.getString("broevi",null);
        android.content.SharedPreferences sharedPreferences3 = getSharedPreferences("preff", MODE_PRIVATE);
        Gson gson1 = new Gson();
        String json1 = sharedPreferences3.getString("sliki",null);
//        Uri uri = Uri.parse(json1);
//        Intent i = new Intent(Intent.ACTION_SEND);
//        i.putExtra("address",json);
//        i.putExtra("sms_body","This is the text mms");
//        i.putExtra(Intent.EXTRA_STREAM,uri);
//        i.setType("image/png/jpg");
//        startActivity(i);

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra("sms_body", "Hi how are you");
        intent.putExtra("address",json);
        Uri uri = Uri.parse(json1);
        intent.putExtra(Intent.EXTRA_STREAM,uri );
        intent.setType("image/png");
        startActivity(Intent.createChooser(intent,"Send"));
    }
    public void popUpEditText() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("DODADI VRABOTEN");
        final EditText input = new EditText(this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        input.setLayoutParams(lp);
        builder.setView(input);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                model2.add(new Vraboteni(input.getText().toString()));
                SaveData();
                adapter.notifyDataSetChanged();

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();

    }

    public void SaveData(){
        SharedPreferences sharedPreferences = getSharedPreferences("preff",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(model2);
        editor.putString("vraboteni",json);
        editor.apply();
    }
    public void LoadVraboteni(){
        SharedPreferences sharedPreferences = getSharedPreferences("preff",MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("vraboteni",null);
        Type type = new TypeToken<ArrayList<Vraboteni>>() {}.getType();
        model2 = gson.fromJson(json,type);

    }
    public void ZacuvajSliki(){
        SharedPreferences sharedPreferences = getSharedPreferences("preff",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(fotografii);
        editor.putString("sliki",json);
        editor.apply();
    }
}
