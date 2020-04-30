// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

// Referenced classes of package com.inponsel.android.widget:
//            DroidWriterEditText

class this._cls0
    implements android.text.iterEditText._cls6
{

    final DroidWriterEditText this$0;

    public Drawable getDrawable(String s)
    {
        int i = getResources().getIdentifier(s, "drawable", getContext().getPackageName());
        s = getResources().getDrawable(i);
        s.setBounds(0, 0, 25, 25);
        return s;
    }

    ()
    {
        this$0 = DroidWriterEditText.this;
        super();
    }
}
