// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.inponsel.android.fonts.Roboto;

public class NativelyCustomTextView extends TextView
{

    public NativelyCustomTextView(Context context)
    {
        super(context);
        setTypeface(Roboto.getInstance(context).getTypeFace());
    }

    public NativelyCustomTextView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        setTypeface(Roboto.getInstance(context).getTypeFace());
    }

    public NativelyCustomTextView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        setTypeface(Roboto.getInstance(context).getTypeFace());
    }
}
