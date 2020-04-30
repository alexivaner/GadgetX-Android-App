// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dobmob.dobsliding.utils;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import com.dobmob.dobsliding.controllers.VSlidingMenuController;
import com.dobmob.dobsliding.exceptions.NoActionBarException;
import com.dobmob.dobsliding.models.SlidingItem;

public class Initializer
{

    public Initializer()
    {
    }

    public static View getActionBarView(ViewGroup viewgroup)
        throws NoActionBarException
    {
        Context context = viewgroup.getContext();
        View view1 = viewgroup.findViewById(0x102002c);
        View view = view1;
        if (view1 == null)
        {
            view = viewgroup.findViewById(context.getResources().getIdentifier("abs__home", "id", context.getPackageName()));
        }
        viewgroup = (View)view.getParent().getParent().getParent();
        if (viewgroup == null)
        {
            throw new NoActionBarException();
        } else
        {
            return viewgroup;
        }
    }

    public static ImageView initHandle(Context context, VSlidingMenuController vslidingmenucontroller, SlidingItem slidingitem)
    {
        context = new ImageView(context);
        context.setImageResource(slidingitem.getHandleCollapsedIcon());
        context.setScaleType(android.widget.ImageView.ScaleType.CENTER);
        context.setContentDescription("");
        context.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-2, -2, 81));
        return context;
    }
}
