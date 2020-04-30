// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.rssfeeddetail;

import android.content.DialogInterface;
import com.actionbarsherlock.view.MenuItem;

// Referenced classes of package com.inponsel.android.rssfeeddetail:
//            Hal2RSSKomen

class this._cls0
    implements android.content..OnClickListener
{

    final Hal2RSSKomen this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (itemTurnNotif.isChecked())
        {
            itemTurnNotif.setChecked(true);
        } else
        {
            itemTurnNotif.setChecked(false);
        }
        dialoginterface.dismiss();
    }

    ()
    {
        this$0 = Hal2RSSKomen.this;
        super();
    }
}
