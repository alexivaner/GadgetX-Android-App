// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.utils:
//            CropOption

public class CropOptionAdapter extends ArrayAdapter
{

    private LayoutInflater mInflater;
    private ArrayList mOptions;

    public CropOptionAdapter(Context context, ArrayList arraylist)
    {
        super(context, 0x7f030020, arraylist);
        mOptions = arraylist;
        mInflater = LayoutInflater.from(context);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        viewgroup = view;
        if (view == null)
        {
            viewgroup = mInflater.inflate(0x7f030020, null);
        }
        view = (CropOption)mOptions.get(i);
        if (view != null)
        {
            ((ImageView)viewgroup.findViewById(0x7f0b007d)).setImageDrawable(((CropOption) (view)).icon);
            ((TextView)viewgroup.findViewById(0x7f0b007e)).setTextColor(0xff000000);
            ((TextView)viewgroup.findViewById(0x7f0b007e)).setText(((CropOption) (view)).title);
            return viewgroup;
        } else
        {
            return null;
        }
    }
}
