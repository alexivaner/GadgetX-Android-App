// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

// Referenced classes of package com.inponsel.android.details:
//            ReplyKomTwActivity

private static class mLayoutInflater extends BaseAdapter
{

    private LayoutInflater mLayoutInflater;

    public int getCount()
    {
        return ReplyKomTwActivity.emotname.length;
    }

    public Object getItem(int i)
    {
        return Integer.valueOf(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (view == null)
        {
            view = mLayoutInflater.inflate(0x7f0300bc, viewgroup, false);
            viewgroup = new >();
            viewgroup.eView = (ImageView)view.findViewById(0x7f0b0631);
            viewgroup.View = (TextView)view.findViewById(0x7f0b0632);
            ((View) (viewgroup)).View.setMovementMethod(com.inponsel.android.widget.vementMethod.getInstance());
            ((ementMethod.getInstance) (viewgroup)).eView.setScaleType(android.widget.ewHolder.mImageView);
            ((eView) (viewgroup)).eView.setPadding(8, 8, 8, 8);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (eView)view.getTag();
        }
        ((eView) (viewgroup)).View.setMovementMethod(com.inponsel.android.widget.vementMethod.getInstance());
        ((ementMethod.getInstance) (viewgroup)).View.setFocusable(false);
        ((View) (viewgroup)).View.setText(ReplyKomTwActivity.emotname[i]);
        return view;
    }

    public ementMethod(Context context)
    {
        mLayoutInflater = LayoutInflater.from(context);
    }
}
