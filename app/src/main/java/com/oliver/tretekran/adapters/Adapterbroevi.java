package com.oliver.tretekran.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.oliver.tretekran.R;
import com.oliver.tretekran.klasi.User;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Adapterbroevi extends RecyclerView.Adapter<Adapterbroevi.ViewHolder>{

    ArrayList<User> broevi = new ArrayList<>();
    Context context;


    public Adapterbroevi(Context context, ArrayList<User> broevi){
        this.context = context;
        this.broevi = broevi;
    }




    @Override
    public Adapterbroevi.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.broevi_layout,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(Adapterbroevi.ViewHolder holder, final int position) {


        final User broevii = broevi.get(position);
        holder.textbroevi.setText(String.valueOf(broevii.getNumber()));


    }

    @Override
    public int getItemCount() {
        if (broevi==null){
            return 0;
        }
        return broevi.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.textbroevi)
        TextView textbroevi;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
