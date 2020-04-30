// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import com.inponsel.android.utils.Log;

// Referenced classes of package com.inponsel.android.v2:
//            SCReplyFormActivity

class this._cls0
    implements android.content.kListener
{

    final SCReplyFormActivity this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        SCReplyFormActivity.access$3(SCReplyFormActivity.this, SCReplyFormActivity.access$2(SCReplyFormActivity.this));
        SCReplyFormActivity.access$3(SCReplyFormActivity.this, SCReplyFormActivity.access$4(SCReplyFormActivity.this));
        if (i == 0)
        {
            SCReplyFormActivity.access$8(SCReplyFormActivity.this);
        } else
        {
            SCReplyFormActivity.access$5(SCReplyFormActivity.this);
        }
        Log.e("startActivityForResult", String.valueOf(-1));
    }

    r()
    {
        this$0 = SCReplyFormActivity.this;
        super();
    }
}
