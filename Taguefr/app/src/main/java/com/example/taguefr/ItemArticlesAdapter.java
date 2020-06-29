package com.example.taguefr;

import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ItemArticlesAdapter extends RecyclerView.Adapter<ItemArticlesAdapter.ItemArticlesViewHolder> {

    private ArrayList<ItemArticles> mList;

    public ItemArticlesAdapter(ArrayList<ItemArticles> itemArticles){ mList = itemArticles; }

    public class ItemArticlesViewHolder extends RecyclerView.ViewHolder {
        public ImageView mimageView;
        public TextView msource;
        public TextView mtitle;

        public ItemArticlesViewHolder(@NonNull View itemView) {
            super(itemView);
            mimageView = itemView.findViewById(R.id.imageViewArticlesSimilaires);
            msource = itemView.findViewById(R.id.TextViewSourceArticlesSimilaires);
            mtitle = itemView.findViewById(R.id.textTitreViewArticlesSimilaires);
            msource.setPaintFlags(msource.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);


        }
    }

    @NonNull
    @Override
    public ItemArticlesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.articles_similaires_item,parent,false);
        ItemArticlesViewHolder IVH = new ItemArticlesViewHolder(v);
        return IVH;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemArticlesViewHolder holder, int position) {
        ItemArticles currentItem = mList.get(position);

        holder.mimageView.setImageResource(currentItem.getImageArticle());
        holder.msource.setText(currentItem.getSourceArticle());
        holder.mtitle.setText(currentItem.getTitreArticle());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
