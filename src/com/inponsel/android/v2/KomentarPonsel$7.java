// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import android.content.Intent;

// Referenced classes of package com.inponsel.android.v2:
//            KomentarPonsel, RegisterActivity

class this._cls0
    implements android.content.nClickListener
{

    final KomentarPonsel this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent(KomentarPonsel.this, com/inponsel/android/v2/RegisterActivity);
        startActivity(dialoginterface);
    }

    stener()
    {
        this$0 = KomentarPonsel.this;
        super();
    }
}
