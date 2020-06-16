package com.example.taguefr;

import android.graphics.Paint;
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

    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);

        void articlesSimilairesOnClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }
    public String getSource(int position){
        return mItemList.get(position).getmSource();
    }
    public static class ItemViewholder extends RecyclerView.ViewHolder{
        public ImageView mimageView;
        public TextView mtitle;
        public TextView msource;
        public TextView mdate;

        public ItemViewholder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            mimageView = itemView.findViewById(R.id.imageView);
            mtitle = itemView.findViewById(R.id.titleTextView);
            msource = itemView.findViewById(R.id.sourceTextView);
            msource.setPaintFlags(msource.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
            mdate = itemView.findViewById(R.id.dateTextView);
            ImageView articleImageView = itemView.findViewById(R.id.articles);
            TextView articlesTextView = itemView.findViewById(R.id.articlesTextView);
            
            
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener!=null){
                        int position = getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
            
            articleImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener!=null){
                        int position = getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            listener.articlesSimilairesOnClick(position);
                        }
                    }
                }
            });

            articlesTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener!=null){
                        int position = getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            listener.articlesSimilairesOnClick(position);
                        }
                    }
                }
            });
        }
    }

    public ItemAdapter(ArrayList<Item> ItemList){
        mItemList = ItemList;
    }

    @NonNull
    @Override
    public ItemViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        ItemViewholder IVH = new ItemViewholder(v,mListener);
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
