// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import com.inponsel.android.utils.Log;

// Referenced classes of package com.inponsel.android.v2:
//            ReplyFormActivity

class this._cls0
    implements android.content.ickListener
{

    final ReplyFormActivity this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        ReplyFormActivity.access$3(ReplyFormActivity.this, ReplyFormActivity.access$2(ReplyFormActivity.this));
        ReplyFormActivity.access$3(ReplyFormActivity.this, ReplyFormActivity.access$4(ReplyFormActivity.this));
        if (i == 0)
        {
            ReplyFormActivity.access$8(ReplyFormActivity.this);
        } else
        {
            ReplyFormActivity.access$5(ReplyFormActivity.this);
        }
        Log.e("startActivityForResult", String.valueOf(-1));
    }

    ner()
    {
        this$0 = ReplyFormActivity.this;
        super();
    }
}
