// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.inponsel.android.v2.LoginActivity;

// Referenced classes of package com.inponsel.android.details:
//            Hal2Spek

class this._cls0
    implements android.content.ace.OnClickListener
{

    final Hal2Spek this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
        dialoginterface.putExtra("activity", "main");
        startActivityForResult(dialoginterface, 0);
        getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
    }

    stener()
    {
        this$0 = Hal2Spek.this;
        super();
    }
}
