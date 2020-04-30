// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.adapter;


public class ItemKomenAll
{

    String avatar;
    String comment_id;
    String comment_val;
    String date_post;
    String kategori;
    private boolean selected;
    String title;
    String title_id;
    String username;

    public ItemKomenAll(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7)
    {
        title_id = "";
        comment_id = "";
        title = "";
        username = "";
        avatar = "";
        comment_val = "";
        date_post = "";
        kategori = "";
        title_id = s;
        comment_id = s1;
        title = s2;
        username = s3;
        avatar = s4;
        comment_val = s5;
        date_post = s6;
        kategori = s7;
    }

    public String getAvatar()
    {
        return avatar;
    }

    public String getComment_id()
    {
        return comment_id;
    }

    public String getComment_val()
    {
        return comment_val;
    }

    public String getDate_post()
    {
        return date_post;
    }

    public String getKategori()
    {
        return kategori;
    }

    public String getTitle()
    {
        return title;
    }

    public String getTitle_id()
    {
        return title_id;
    }

    public String getUsername()
    {
        return username;
    }

    public boolean isSelected()
    {
        return selected;
    }

    public void setAvatar(String s)
    {
        avatar = s;
    }

    public void setComment_id(String s)
    {
        comment_id = s;
    }

    public void setComment_val(String s)
    {
        comment_val = s;
    }

    public void setDate_post(String s)
    {
        date_post = s;
    }

    public void setKategori(String s)
    {
        kategori = s;
    }

    public void setSelected(boolean flag)
    {
        selected = flag;
    }

    public void setTitle(String s)
    {
        title = s;
    }

    public void setTitle_id(String s)
    {
        title_id = s;
    }

    public void setUsername(String s)
    {
        username = s;
    }
}
