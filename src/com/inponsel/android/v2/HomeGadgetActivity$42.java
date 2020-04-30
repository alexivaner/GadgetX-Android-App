// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;

// Referenced classes of package com.inponsel.android.v2:
//            HomeGadgetActivity

class val.finish
    implements android.content.kListener
{

    final HomeGadgetActivity this$0;
    private final boolean val$finish;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        if (val$finish)
        {
            HomeGadgetActivity.this.finish();
        }
    }

    r()
    {
        this$0 = final_homegadgetactivity;
        val$finish = Z.this;
        super();
    }
}
