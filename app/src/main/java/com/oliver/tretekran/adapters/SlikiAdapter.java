package com.oliver.tretekran.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.oliver.tretekran.R;
import com.oliver.tretekran.klasi.Slika;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SlikiAdapter extends RecyclerView.Adapter<SlikiAdapter.ViewHolder> {
    public Context mcontext;
    public ArrayList<Slika> mSliki;

    public SlikiAdapter(Context context, ArrayList<Slika> sliki) {
        this.mcontext = context;
        this.mSliki = sliki;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row,parent,false);
        SlikiAdapter.ViewHolder viewHolder = new SlikiAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Slika foto = mSliki.get(position);
        Picasso.with(mcontext).load(foto.getSlika()).fit().centerInside().into(holder.slika);


    }

    @Override
    public int getItemCount() {

        if (mSliki==null){
            return 0;
        }
        return mSliki.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.slika)
        ImageView slika;
//        @BindView(R.id.checkbox)
//        CheckBox checkBox;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
