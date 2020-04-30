// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;

// Referenced classes of package com.inponsel.android.v2:
//            HomeNewsActivity

class val.finish
    implements android.content.ickListener
{

    final HomeNewsActivity this$0;
    private final boolean val$finish;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        if (val$finish)
        {
            HomeNewsActivity.this.finish();
        }
    }

    ner()
    {
        this$0 = final_homenewsactivity;
        val$finish = Z.this;
        super();
    }
}
