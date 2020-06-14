package com.example.taguefr;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewholder> {

    private ArrayList<Item> mItemList;
    public static class ItemViewholder extends RecyclerView.ViewHolder{
        public ImageView mimageView;
        public TextView mtitle;
        public TextView msource;
        public TextView mdate;

        public ItemViewholder(@NonNull View itemView) {
            super(itemView);
            mimageView = itemView.findViewById(R.id.imageView);
            mtitle = itemView.findViewById(R.id.titleTextView);
            msource = itemView.findViewById(R.id.sourceTextView);
            mdate = itemView.findViewById(R.id.dateTextView);

        }
    }

    public ItemAdapter(ArrayList<Item> ItemList){
        mItemList = ItemList;
    }

    @NonNull
    @Override
    public ItemViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        ItemViewholder IVH = new ItemViewholder(v);
        return IVH;

    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewholder holder, int position) {
        Item currentItem = mItemList.get(position);

        holder.mimageView.setImageResource(currentItem.getmImageRessource());
        holder.mtitle.setText(currentItem.getmTitle());
        holder.mdate.setText(currentItem.getmDate());
        holder.msource.setText(currentItem.getmSource());
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }
}
