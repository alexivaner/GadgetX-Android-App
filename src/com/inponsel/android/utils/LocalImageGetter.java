// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

// Referenced classes of package com.inponsel.android.utils:
//            Log

public class LocalImageGetter
    implements android.text.Html.ImageGetter
{

    Context c;

    public LocalImageGetter(Context context)
    {
        c = context;
    }

    public Drawable getDrawable(String s)
    {
        int j = c.getResources().getIdentifier(s, "drawable", c.getPackageName());
        int i = j;
        if (j == 0)
        {
            i = c.getResources().getIdentifier(s, "drawable", "android");
        }
        if (i == 0)
        {
            Log.e("HtmlTextView", (new StringBuilder("source could not be found: ")).append(s).toString());
            return null;
        } else
        {
            s = c.getResources().getDrawable(i);
            s.setBounds(0, 0, s.getIntrinsicWidth(), s.getIntrinsicHeight());
            return s;
        }
    }
}
