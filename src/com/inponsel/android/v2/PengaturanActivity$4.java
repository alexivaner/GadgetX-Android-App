// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.widget.CheckBox;
import android.widget.CompoundButton;

// Referenced classes of package com.inponsel.android.v2:
//            PengaturanActivity

class this._cls0
    implements android.widget.kedChangeListener
{

    final PengaturanActivity this$0;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        if (chkRSSEmail.isChecked())
        {
            statusEmail_rssmod = "1";
            return;
        } else
        {
            statusEmail_rssmod = "0";
            return;
        }
    }

    Listener()
    {
        this$0 = PengaturanActivity.this;
        super();
    }
}
