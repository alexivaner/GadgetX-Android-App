// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.timelinedetail;

import android.content.DialogInterface;
import com.inponsel.android.utils.Log;

// Referenced classes of package com.inponsel.android.timelinedetail:
//            ReplyKomTLActivity

class this._cls0
    implements android.content.ckListener
{

    final ReplyKomTLActivity this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        ReplyKomTLActivity.access$3(ReplyKomTLActivity.this, ReplyKomTLActivity.access$2(ReplyKomTLActivity.this));
        ReplyKomTLActivity.access$3(ReplyKomTLActivity.this, ReplyKomTLActivity.access$4(ReplyKomTLActivity.this));
        if (i == 0)
        {
            ReplyKomTLActivity.access$8(ReplyKomTLActivity.this);
        } else
        {
            ReplyKomTLActivity.access$5(ReplyKomTLActivity.this);
        }
        Log.e("startActivityForResult", String.valueOf(-1));
    }

    ()
    {
        this$0 = ReplyKomTLActivity.this;
        super();
    }
}
