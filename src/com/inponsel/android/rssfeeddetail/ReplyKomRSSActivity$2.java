// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.rssfeeddetail;

import android.view.View;
import android.widget.AdapterView;
import com.inponsel.android.widget.DroidWriterEditText;

// Referenced classes of package com.inponsel.android.rssfeeddetail:
//            ReplyKomRSSActivity

class this._cls0
    implements android.widget.kListener
{

    final ReplyKomRSSActivity this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        edt_pop_komen.setImageInsertGrid(ReplyKomRSSActivity.emotname[i]);
    }

    ()
    {
        this$0 = ReplyKomRSSActivity.this;
        super();
    }
}
