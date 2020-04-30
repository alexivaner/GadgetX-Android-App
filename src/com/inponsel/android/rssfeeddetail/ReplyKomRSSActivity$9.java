// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.rssfeeddetail;

import android.content.DialogInterface;
import com.inponsel.android.utils.Log;

// Referenced classes of package com.inponsel.android.rssfeeddetail:
//            ReplyKomRSSActivity

class this._cls0
    implements android.content.kListener
{

    final ReplyKomRSSActivity this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        ReplyKomRSSActivity.access$3(ReplyKomRSSActivity.this, ReplyKomRSSActivity.access$2(ReplyKomRSSActivity.this));
        ReplyKomRSSActivity.access$3(ReplyKomRSSActivity.this, ReplyKomRSSActivity.access$4(ReplyKomRSSActivity.this));
        if (i == 0)
        {
            ReplyKomRSSActivity.access$8(ReplyKomRSSActivity.this);
        } else
        {
            ReplyKomRSSActivity.access$5(ReplyKomRSSActivity.this);
        }
        Log.e("startActivityForResult", String.valueOf(-1));
    }

    ()
    {
        this$0 = ReplyKomRSSActivity.this;
        super();
    }
}
