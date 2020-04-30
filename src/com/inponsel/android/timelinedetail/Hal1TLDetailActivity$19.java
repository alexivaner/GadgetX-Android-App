// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.timelinedetail;

import android.content.DialogInterface;
import android.content.Intent;
import com.inponsel.android.v2.RegisterActivity;

// Referenced classes of package com.inponsel.android.timelinedetail:
//            Hal1TLDetailActivity

class this._cls0
    implements android.content.istener
{

    final Hal1TLDetailActivity this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent(Hal1TLDetailActivity.this, com/inponsel/android/v2/RegisterActivity);
        startActivity(dialoginterface);
    }

    A()
    {
        this$0 = Hal1TLDetailActivity.this;
        super();
    }
}
