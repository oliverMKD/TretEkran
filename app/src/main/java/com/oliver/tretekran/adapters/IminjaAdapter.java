package com.oliver.tretekran.adapters;

import android.content.Context;
import android.provider.Contacts;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.oliver.tretekran.Listeners.OnRow;
import com.oliver.tretekran.R;
import com.oliver.tretekran.klasi.Vraboteni;
import com.oliver.tretekran.klasi.VraboteniModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IminjaAdapter extends RecyclerView.Adapter<IminjaAdapter.ViewHolder> {
    public Context mContext;
    Vraboteni vraboteni;
    VraboteniModel model;
    OnRow onRowClickListener;

    public ArrayList<Vraboteni> peopleList ;
    public void setItems(ArrayList<Vraboteni> peopleList1) {
        peopleList = peopleList1;
        notifyDataSetChanged();
    }


    public IminjaAdapter (Context mContext,ArrayList<Vraboteni> vrabotenis,OnRow _onRowClick) {
        this.mContext = mContext;
        peopleList = vrabotenis;
        this.onRowClickListener = _onRowClick;


    }

    @Override
    public IminjaAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.vraboteni_row,parent,false);
        IminjaAdapter.ViewHolder viewHolder = new IminjaAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(IminjaAdapter.ViewHolder holder, final int position) {
        final Vraboteni people = peopleList.get(position);
        holder.vrabotenite.setText(peopleList.get(position).getName());
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRowClickListener.onRowClick(people,position);
            }
        });
//        holder.vrabotenite.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                peopleList.remove(peopleList.get(position));
//                notifyDataSetChanged();
//                return true;
//            }
//        });
//
//
    }

    @Override
    public int getItemCount() {
        if (peopleList==null){
            return 0;
        }
        return peopleList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.checkbox)
        CheckBox checkBox;
        @BindView(R.id.iminja)
        TextView vrabotenite;

        public ViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    peopleList.remove(peopleList.get(getAdapterPosition()));
                    notifyItemRemoved(getAdapterPosition());
                    return true;
                }
            });
//
        }
    }
    public void clear() {
        final int size = peopleList.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                peopleList.remove(0);
            }

            notifyItemRangeRemoved(0, size);
        }
    }

}
