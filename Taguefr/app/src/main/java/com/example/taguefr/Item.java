package com.example.taguefr;

public class Item {
    private int mImageRessource;
    private String mTitle;
    private String mSource;
    private String mDate;

    public Item(int ImageRessource, String Title,String Source, String Date){
        mImageRessource = ImageRessource;
        mTitle = Title;
        mDate = Date;
        mSource = Source;
    }
    public int getmImageRessource(){
        return mImageRessource;
    }
    public String getmTitle(){
        return mTitle;
    }
    public String getmSource(){
        return mSource;
    }
    public String getmDate(){
        return mDate;
    }
}
