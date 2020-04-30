// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.Intent;
import android.net.Uri;
import android.view.View;

// Referenced classes of package com.inponsel.android.details:
//            ProfilPTActivity

class this._cls1
    implements android.view.filPTTaskTask._cls5
{

    final this._cls1 this$1;

    public void onClick(View view)
    {
        if (cess._mth3(this._cls1.this).youtube_pt.contains("http"))
        {
            cess._mth3(this._cls1.this).startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("http://")).append(cess._mth3(this._cls1.this).youtube_pt.trim()).toString())));
            return;
        } else
        {
            cess._mth3(this._cls1.this).startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("http://www.youtube.com/user/")).append(cess._mth3(this._cls1.this).youtube_pt).toString())));
            return;
        }
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
