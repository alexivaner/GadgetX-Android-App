// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.adapter;


public class ItemRSS
{

    String id;
    String rss_content;
    String rss_date;
    String rss_desc;
    String rss_fav_stat;
    String rss_id;
    String rss_img;
    String rss_img_ava;
    String rss_like_stat;
    String rss_portal;
    String rss_srclink;
    String rss_title;
    String rss_tot_hits;
    String rss_tot_komen;
    String rss_tot_like;
    private boolean selected;

    public ItemRSS(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8, String s9, String s10, String s11, String s12, String s13, 
            String s14)
    {
        id = "";
        rss_id = "";
        rss_title = "";
        rss_portal = "";
        rss_desc = "";
        rss_content = "";
        rss_srclink = "";
        rss_date = "";
        rss_img = "";
        rss_img_ava = "";
        rss_tot_like = "";
        rss_tot_komen = "";
        rss_tot_hits = "";
        rss_like_stat = "";
        rss_fav_stat = "";
        id = s;
        rss_id = s1;
        rss_title = s2;
        rss_portal = s3;
        rss_desc = s4;
        rss_content = s5;
        rss_srclink = s6;
        rss_date = s7;
        rss_img_ava = s8;
        rss_img = s9;
        rss_tot_like = s10;
        rss_tot_komen = s11;
        rss_tot_hits = s12;
        rss_like_stat = s13;
        rss_fav_stat = s14;
    }

    public String getId()
    {
        return id;
    }

    public String getRss_content()
    {
        return rss_content;
    }

    public String getRss_date()
    {
        return rss_date;
    }

    public String getRss_desc()
    {
        return rss_desc;
    }

    public String getRss_fav_stat()
    {
        return rss_fav_stat;
    }

    public String getRss_id()
    {
        return rss_id;
    }

    public String getRss_img()
    {
        return rss_img;
    }

    public String getRss_img_ava()
    {
        return rss_img_ava;
    }

    public String getRss_like_stat()
    {
        return rss_like_stat;
    }

    public String getRss_portal()
    {
        return rss_portal;
    }

    public String getRss_srclink()
    {
        return rss_srclink;
    }

    public String getRss_title()
    {
        return rss_title;
    }

    public String getRss_tot_hits()
    {
        return rss_tot_hits;
    }

    public String getRss_tot_komen()
    {
        return rss_tot_komen;
    }

    public String getRss_tot_like()
    {
        return rss_tot_like;
    }

    public boolean isSelected()
    {
        return selected;
    }

    public void setId(String s)
    {
        id = s;
    }

    public void setRss_content(String s)
    {
        rss_content = s;
    }

    public void setRss_date(String s)
    {
        rss_date = s;
    }

    public void setRss_desc(String s)
    {
        rss_desc = s;
    }

    public void setRss_fav_stat(String s)
    {
        rss_fav_stat = s;
    }

    public void setRss_id(String s)
    {
        rss_id = s;
    }

    public void setRss_img(String s)
    {
        rss_img = s;
    }

    public void setRss_img_ava(String s)
    {
        rss_img_ava = s;
    }

    public void setRss_like_stat(String s)
    {
        rss_like_stat = s;
    }

    public void setRss_portal(String s)
    {
        rss_portal = s;
    }

    public void setRss_srclink(String s)
    {
        rss_srclink = s;
    }

    public void setRss_title(String s)
    {
        rss_title = s;
    }

    public void setRss_tot_hits(String s)
    {
        rss_tot_hits = s;
    }

    public void setRss_tot_komen(String s)
    {
        rss_tot_komen = s;
    }

    public void setRss_tot_like(String s)
    {
        rss_tot_like = s;
    }

    public void setSelected(boolean flag)
    {
        selected = flag;
    }
}
