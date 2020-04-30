// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.widget.CheckBox;
import android.widget.CompoundButton;

// Referenced classes of package com.inponsel.android.v2:
//            PengaturanActivity

class this._cls0
    implements android.widget.edChangeListener
{

    final PengaturanActivity this$0;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        if (chkForumMail.isChecked())
        {
            forum_mail_mod = "1";
            return;
        } else
        {
            forum_mail_mod = "0";
            return;
        }
    }

    istener()
    {
        this$0 = PengaturanActivity.this;
        super();
    }
}
