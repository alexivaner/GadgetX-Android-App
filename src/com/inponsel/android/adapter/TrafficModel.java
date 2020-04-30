// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.adapter;


public class TrafficModel
{

    String avatar;
    String media_url;
    String screen_name;
    String since_id;
    String tweet_content;
    String tweet_time;

    public TrafficModel()
    {
    }

    public String getAvatar()
    {
        return avatar;
    }

    public String getMedia_url()
    {
        return media_url;
    }

    public String getScreen_name()
    {
        return screen_name;
    }

    public String getSince_id()
    {
        return since_id;
    }

    public String getTweet_content()
    {
        return tweet_content;
    }

    public String getTweet_time()
    {
        return tweet_time;
    }

    public void setAvatar(String s)
    {
        avatar = s;
    }

    public void setMedia_url(String s)
    {
        media_url = s;
    }

    public void setScreen_name(String s)
    {
        screen_name = s;
    }

    public void setSince_id(String s)
    {
        since_id = s;
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
