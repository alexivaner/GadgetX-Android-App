// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.adapter;


public class ItemRSSTag
{

    private String codeTagName;
    private String mRealName;
    private String mTagName;
    private String sub_status;

    public ItemRSSTag(String s, String s1, String s2, String s3)
    {
        mRealName = s;
        mTagName = s1;
        codeTagName = s2;
        sub_status = s3;
    }

    public String getCodeTagName()
    {
        return codeTagName;
    }

    public String getSub_status()
    {
        return sub_status;
    }

    public String getmRealName()
    {
        return mRealName;
    }

    public String getmTagName()
    {
        return mTagName;
    }

    public void setCodeTagName(String s)
    {
        codeTagName = s;
    }

    public void setSub_status(String s)
    {
        sub_status = s;
    }

    public void setmRealName(String s)
    {
        mRealName = s;
    }

    public void setmTagName(String s)
    {
        mTagName = s;
    }
}
