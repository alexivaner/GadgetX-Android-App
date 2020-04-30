// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.adapter;


public class ItemTwKomen
{

    String id_komtw;
    String id_tw;
    String id_user;
    String id_user_to;
    String komen_to;
    String komen_tw;
    String my_like_kom;
    private boolean selected;
    String tanggal_kom;
    String tanggal_to;
    String total_dislike;
    String total_like;
    String user_name;
    String user_name_to;
    String user_photo;

    public ItemTwKomen(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8, String s9, String s10, String s11, String s12, String s13)
    {
        id_komtw = "";
        id_tw = "";
        id_user = "";
        id_user_to = "";
        komen_tw = "";
        tanggal_kom = "";
        user_photo = "";
        user_name = "";
        tanggal_to = "";
        total_like = "";
        total_dislike = "";
        my_like_kom = "";
        user_name_to = "";
        komen_to = "";
        id_komtw = s;
        id_tw = s1;
        id_user = s2;
        id_user_to = s3;
        komen_tw = s4;
        tanggal_kom = s5;
        user_photo = s6;
        user_name = s7;
        tanggal_to = s8;
        total_like = s9;
        total_dislike = s10;
        my_like_kom = s11;
        user_name_to = s12;
        komen_to = s13;
    }

    public String getId_komtw()
    {
        return id_komtw;
    }

    public String getId_tw()
    {
        return id_tw;
    }

    public String getId_user()
    {
        return id_user;
    }

    public String getId_user_to()
    {
        return id_user_to;
    }

    public String getKomen_to()
    {
        return komen_to;
    }

    public String getKomen_tw()
    {
        return komen_tw;
    }

    public String getMy_like_kom()
    {
        return my_like_kom;
    }

    public String getTanggal_kom()
    {
        return tanggal_kom;
    }

    public String getTanggal_to()
    {
        return tanggal_to;
    }

    public String getTotal_dislike()
    {
        return total_dislike;
    }

    public String getTotal_like()
    {
        return total_like;
    }

    public String getUser_name()
    {
        return user_name;
    }

    public String getUser_name_to()
    {
        return user_name_to;
    }

    public String getUser_photo()
    {
        return user_photo;
    }

    public boolean isSelected()
    {
        return selected;
    }

    public void setId_komtw(String s)
    {
        id_komtw = s;
    }

    public void setId_tw(String s)
    {
        id_tw = s;
    }

    public void setId_user(String s)
    {
        id_user = s;
    }

    public void setId_user_to(String s)
    {
        id_user_to = s;
    }

    public void setKomen_to(String s)
    {
        komen_to = s;
    }

    public void setKomen_tw(String s)
    {
        komen_tw = s;
    }

    public void setMy_like_kom(String s)
    {
        my_like_kom = s;
    }

    public void setSelected(boolean flag)
    {
        selected = flag;
    }

    public void setTanggal_kom(String s)
    {
        tanggal_kom = s;
    }

    public void setTanggal_to(String s)
    {
        tanggal_to = s;
    }

    public void setTotal_dislike(String s)
    {
        total_dislike = s;
    }

    public void setTotal_like(String s)
    {
        total_like = s;
    }

    public void setUser_name(String s)
    {
        user_name = s;
    }

    public void setUser_name_to(String s)
    {
        user_name_to = s;
    }

    public void setUser_photo(String s)
    {
        user_photo = s;
    }
}
