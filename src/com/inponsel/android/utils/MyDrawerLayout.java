// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.utils;

import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.util.AttributeSet;
import android.view.KeyEvent;

public class MyDrawerLayout extends DrawerLayout
{

    public MyDrawerLayout(Context context)
    {
        super(context);
    }

    public MyDrawerLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public MyDrawerLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 4)
        {
            return false;
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyevent)
    {
        if (i == 4)
        {
            return false;
        } else
        {
            return super.onKeyUp(i, keyevent);
        }
    }
}
