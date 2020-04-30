// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import com.inponsel.android.utils.Log;

// Referenced classes of package com.inponsel.android.v2:
//            KatAppsReplyFormActivity

class this._cls0
    implements android.content.ener
{

    final KatAppsReplyFormActivity this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        KatAppsReplyFormActivity.access$6(KatAppsReplyFormActivity.this, KatAppsReplyFormActivity.access$5(KatAppsReplyFormActivity.this));
        KatAppsReplyFormActivity.access$6(KatAppsReplyFormActivity.this, KatAppsReplyFormActivity.access$7(KatAppsReplyFormActivity.this));
        if (i == 0)
        {
            KatAppsReplyFormActivity.access$8(KatAppsReplyFormActivity.this);
        } else
        {
            KatAppsReplyFormActivity.access$9(KatAppsReplyFormActivity.this);
        }
        Log.e("startActivityForResult", String.valueOf(-1));
    }

    ()
    {
        this$0 = KatAppsReplyFormActivity.this;
        super();
    }
}
