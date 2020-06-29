package com.example.taguefr;

public class ItemArticles {
    private String mSource;
    private String mTitre;
    private int mImage;

    public ItemArticles(String Source, String Titre, int Image){
        mSource = Source;
        mTitre = Titre;
        mImage = Image;
    }

    public String getSourceArticle(){ return mSource; }
    public String getTitreArticle(){ return mTitre; }
    public int getImageArticle(){ return mImage; }
}
