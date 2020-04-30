// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.widget;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Utility;

// Referenced classes of package com.inponsel.android.widget:
//            DroidWriterEditText

class this._cls0
    implements android.text.iterEditText._cls1
{

    final DroidWriterEditText this$0;

    public Drawable getDrawable(String s)
    {
        Log.e("drwa", s);
        int i = getResources().getIdentifier(s, "drawable", "com.inponsel.android");
        s = getResources().getDrawable(i);
        if (Utility.isTabletMDPI(getContext()))
        {
            s.setBounds(0, 0, 25, 25);
            Log.e("isTabletMDPI", "isTabletMDPI");
            return s;
        }
        if (Utility.isXXHDPI(getContext()))
        {
            Log.e("isXXHDPI", "isXXHDPI");
            s.setBounds(0, 0, 80, 80);
            return s;
        } else
        {
            Log.e("else", "else");
            s.setBounds(0, 0, 90, 90);
            return s;
        }
    }

    ()
    {
        this$0 = DroidWriterEditText.this;
        super();
    }
}
