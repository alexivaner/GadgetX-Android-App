// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.view.View;
import android.widget.AdapterView;
import com.inponsel.android.widget.DroidWriterEditText;

// Referenced classes of package com.inponsel.android.v2:
//            KatAppsReplyFormActivity

class this._cls0
    implements android.widget.ener
{

    final KatAppsReplyFormActivity this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        edt_pop_komen.setImageInsertGrid(KatAppsReplyFormActivity.emotname[i]);
    }

    ()
    {
        this$0 = KatAppsReplyFormActivity.this;
        super();
    }
}
