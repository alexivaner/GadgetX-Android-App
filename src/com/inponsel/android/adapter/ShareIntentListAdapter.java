// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.adapter;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ShareIntentListAdapter extends ArrayAdapter
{

    private final Activity context;
    Object items[];

    public ShareIntentListAdapter(Activity activity, Object aobj[])
    {
        super(activity, 0x7f030080, aobj);
        context = activity;
        items = aobj;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        view = context.getLayoutInflater().inflate(0x7f030080, null, true);
        viewgroup = (TextView)view.findViewById(0x7f0b0499);
        ImageView imageview = (ImageView)view.findViewById(0x7f0b0498);
        viewgroup.setText(((ResolveInfo)items[i]).activityInfo.applicationInfo.loadLabel(context.getPackageManager()).toString());
        imageview.setImageDrawable(((ResolveInfo)items[i]).activityInfo.applicationInfo.loadIcon(context.getPackageManager()));
        return view;
    }
}
