package com.arcadekd.justexample;

public class DataModel
{
    private String text;
    private int imgRes;

    public DataModel(String text, int imgRes)
    {
        this.text = text;
        this.imgRes = imgRes;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public int getImgRes()
    {
        return imgRes;
    }

    public void setImgRes(int imgRes)
    {
        this.imgRes = imgRes;
    }
}
