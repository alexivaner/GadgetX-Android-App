// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.scdetail;

import android.content.DialogInterface;

// Referenced classes of package com.inponsel.android.scdetail:
//            Hal2Komen

class this._cls0
    implements android.content.ace.OnClickListener
{

    final Hal2Komen this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        TurnOnOffNotifTask();
    }

    tener()
    {
        this$0 = Hal2Komen.this;
        super();
    }
}
