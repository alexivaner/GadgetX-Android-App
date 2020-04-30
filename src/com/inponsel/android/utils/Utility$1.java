// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.utils;

import android.app.Activity;
import android.content.DialogInterface;

// Referenced classes of package com.inponsel.android.utils:
//            Utility

class val.ct
    implements android.content.rface.OnClickListener
{

    private final Activity val$ct;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        val$ct.finish();
    }

    ckListener()
    {
        val$ct = activity;
        super();
    }
}
