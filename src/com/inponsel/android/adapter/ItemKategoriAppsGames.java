// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.adapter;


public class ItemKategoriAppsGames
{

    String background;
    String background_img;
    String deskripsi;
    String height;
    String id;
    String jsonarray;
    String kategori;
    String mod_date;
    String myfav;
    String place;
    String position;
    private boolean selected;
    String tag;
    String total_like;
    String type;
    String width;

    public ItemKategoriAppsGames(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8, String s9, String s10, String s11, String s12, String s13, 
            String s14)
    {
        id = "";
        kategori = "";
        tag = "";
        type = "";
        deskripsi = "";
        place = "";
        position = "";
        background = "";
        background_img = "";
        width = "";
        height = "";
        myfav = "";
        mod_date = "";
        total_like = "";
        jsonarray = "";
        id = s;
        kategori = s1;
        tag = s2;
        type = s3;
        deskripsi = s4;
        place = s5;
        position = s6;
        background = s7;
        background_img = s8;
        width = s9;
        height = s10;
        myfav = s11;
        mod_date = s12;
        total_like = s13;
        jsonarray = s14;
    }

    public String getId()
    {
        return id;
    }

    public String getJsonarray()
    {
        return jsonarray;
    }

    public String getbackground()
    {
        return background;
    }

    public String getbackground_img()
    {
        return background_img;
    }

    public String getdeskripsi()
    {
        return deskripsi;
    }

    public String getheight()
    {
        return height;
    }

    public String getkategori()
    {
        return kategori;
    }

    public String getmod_date()
    {
        return mod_date;
    }

    public String getmyfav()
    {
        return myfav;
    }

    public String getplace()
    {
        return place;
    }

    public String getposition()
    {
        return position;
    }

    public String gettag()
    {
        return tag;
    }

    public String gettotal_like()
    {
        return total_like;
    }

    public String gettype()
    {
        return type;
    }

    public String getwidth()
    {
        return width;
    }

    public boolean isSelected()
    {
        return selected;
    }

    public void setId(String s)
    {
        id = s;
    }

    public void setJsonarray(String s)
    {
        jsonarray = s;
    }

    public void setSelected(boolean flag)
    {
        selected = flag;
    }

    public void setbackground(String s)
    {
        background = s;
    }

    public void setbackground_img(String s)
    {
        background_img = s;
    }

    public void setdeskripsi(String s)
    {
        deskripsi = s;
    }

    public void setheight(String s)
    {
        height = s;
    }

    public void setkategori(String s)
    {
        kategori = s;
    }

    public void setmod_date(String s)
    {
        mod_date = s;
    }

    public void setmyfav(String s)
    {
        myfav = s;
    }

    public void setplace(String s)
    {
        place = s;
    }

    public void setposition(String s)
    {
        position = s;
    }

    public void settag(String s)
    {
        tag = s;
    }

    public void settotal_like(String s)
    {
        total_like = s;
    }

    public void settype(String s)
    {
        type = s;
    }

    public void setwidth(String s)
    {
        width = s;
    }
}
