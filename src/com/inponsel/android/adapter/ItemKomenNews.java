// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.adapter;


public class ItemKomenNews
{

    String email_komentar;
    String id_komentar;
    String id_rss;
    String id_user;
    String komen_bagus;
    String komen_kurang;
    String komen_to;
    String komentar;
    String my_like_kom;
    String nama_komentar;
    String nama_to;
    String news_title;
    String reply_to;
    private boolean selected;
    String tanggal_komentar;
    String tanggal_to;
    String usr_pict_komen;

    public ItemKomenNews(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8, String s9, String s10, String s11, String s12, String s13, 
            String s14, String s15)
    {
        id_komentar = "";
        id_rss = "";
        news_title = "";
        id_user = "";
        nama_komentar = "";
        email_komentar = "";
        tanggal_komentar = "";
        komentar = "";
        komen_bagus = "";
        komen_kurang = "";
        usr_pict_komen = "";
        reply_to = "";
        nama_to = "";
        komen_to = "";
        tanggal_to = "";
        my_like_kom = "";
        id_komentar = s;
        id_rss = s1;
        news_title = s2;
        id_user = s3;
        nama_komentar = s4;
        email_komentar = s5;
        tanggal_komentar = s6;
        komentar = s7;
        komen_bagus = s8;
        komen_kurang = s9;
        usr_pict_komen = s10;
        reply_to = s11;
        nama_to = s12;
        komen_to = s13;
        tanggal_to = s14;
        my_like_kom = s15;
    }

    public String getEmail_komentar()
    {
        return email_komentar;
    }

    public String getId_komentar()
    {
        return id_komentar;
    }

    public String getId_rss()
    {
        return id_rss;
    }

    public String getId_user()
    {
        return id_user;
    }

    public String getKomen_bagus()
    {
        return komen_bagus;
    }

    public String getKomen_kurang()
    {
        return komen_kurang;
    }

    public String getKomen_to()
    {
        return komen_to;
    }

    public String getKomentar()
    {
        return komentar;
    }

    public String getMy_like_kom()
    {
        return my_like_kom;
    }

    public String getNama_komentar()
    {
        return nama_komentar;
    }

    public String getNama_to()
    {
        return nama_to;
    }

    public String getNews_title()
    {
        return news_title;
    }

    public String getReply_to()
    {
        return reply_to;
    }

    public String getTanggal_komentar()
    {
        return tanggal_komentar;
    }

    public String getTanggal_to()
    {
        return tanggal_to;
    }

    public String getUsr_pict_komen()
    {
        return usr_pict_komen;
    }

    public boolean isSelected()
    {
        return selected;
    }

    public void setEmail_komentar(String s)
    {
        email_komentar = s;
    }

    public void setId_komentar(String s)
    {
        id_komentar = s;
    }

    public void setId_rss(String s)
    {
        id_rss = s;
    }

    public void setId_user(String s)
    {
        id_user = s;
    }

    public void setKomen_bagus(String s)
    {
        komen_bagus = s;
    }

    public void setKomen_kurang(String s)
    {
        komen_kurang = s;
    }

    public void setKomen_to(String s)
    {
        komen_to = s;
    }

    public void setKomentar(String s)
    {
        komentar = s;
    }

    public void setMy_like_kom(String s)
    {
        my_like_kom = s;
    }

    public void setNama_komentar(String s)
    {
        nama_komentar = s;
    }

    public void setNama_to(String s)
    {
        nama_to = s;
    }

    public void setNews_title(String s)
    {
        news_title = s;
    }

    public void setReply_to(String s)
    {
        reply_to = s;
    }

    public void setSelected(boolean flag)
    {
        selected = flag;
    }

    public void setTanggal_komentar(String s)
    {
        tanggal_komentar = s;
    }

    public void setTanggal_to(String s)
    {
        tanggal_to = s;
    }

    public void setUsr_pict_komen(String s)
    {
        usr_pict_komen = s;
    }
}
