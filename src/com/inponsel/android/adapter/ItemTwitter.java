// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.adapter;


public class ItemTwitter
{

    String avatar;
    String media_url;
    String my_fav_tweet;
    String my_like_tweet;
    String real_name;
    String screen_name;
    private boolean selected;
    String since_id;
    String total_dislike;
    String total_komen;
    String total_like;
    String tweet_content;
    String tweet_time;

    public ItemTwitter(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8, String s9, String s10, String s11)
    {
        since_id = "";
        tweet_content = "";
        media_url = "";
        avatar = "";
        tweet_time = "";
        real_name = "";
        screen_name = "";
        total_like = "";
        total_dislike = "";
        total_komen = "";
        my_like_tweet = "";
        my_fav_tweet = "";
        since_id = s;
        tweet_content = s1;
        media_url = s2;
        avatar = s3;
        tweet_time = s4;
        real_name = s5;
        screen_name = s6;
        total_like = s7;
        total_dislike = s8;
        total_komen = s9;
        my_like_tweet = s10;
        my_fav_tweet = s11;
    }

    public String getAvatar()
    {
        return avatar;
    }

    public String getMedia_url()
    {
        return media_url;
    }

    public String getMy_fav_tweet()
    {
        return my_fav_tweet;
    }

    public String getMy_like_tweet()
    {
        return my_like_tweet;
    }

    public String getReal_name()
    {
        return real_name;
    }

    public String getScreen_name()
    {
        return screen_name;
    }

    public String getSince_id()
    {
        return since_id;
    }

    public String getTotal_dislike()
    {
        return total_dislike;
    }

    public String getTotal_komen()
    {
        return total_komen;
    }

    public String getTotal_like()
    {
        return total_like;
    }

    public String getTweet_content()
    {
        return tweet_content;
    }

    public String getTweet_time()
    {
        return tweet_time;
    }

    public boolean isSelected()
    {
        return selected;
    }

    public void setAvatar(String s)
    {
        avatar = s;
    }

    public void setMedia_url(String s)
    {
        media_url = s;
    }

    public void setMy_fav_tweet(String s)
    {
        my_fav_tweet = s;
    }

    public void setMy_like_tweet(String s)
    {
        my_like_tweet = s;
    }

    public void setReal_name(String s)
    {
        real_name = s;
    }

    public void setScreen_name(String s)
    {
        screen_name = s;
    }

    public void setSelected(boolean flag)
    {
        selected = flag;
    }

    public void setSince_id(String s)
    {
        since_id = s;
    }

    public void setTotal_dislike(String s)
    {
        total_dislike = s;
    }

    public void setTotal_komen(String s)
    {
        total_komen = s;
    }

    public void setTotal_like(String s)
    {
        total_like = s;
    }

    public void setTweet_content(String s)
    {
        tweet_content = s;
    }

    public void setTweet_time(String s)
    {
        tweet_time = s;
    }
}
