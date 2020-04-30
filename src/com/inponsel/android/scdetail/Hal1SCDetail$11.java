// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.scdetail;

import android.content.Intent;
import android.net.Uri;
import android.view.View;

// Referenced classes of package com.inponsel.android.scdetail:
//            Hal1SCDetail

class this._cls0
    implements android.view.ener
{

    final Hal1SCDetail this$0;

    public void onClick(View view)
    {
        if (str_sc_ytube.contains("http"))
        {
            str_sc_ytube = str_sc_ytube.trim().replace("http: //", "");
            str_sc_ytube = str_sc_ytube.trim().replace("http://", "");
            str_sc_ytube = str_sc_ytube.trim().replace("http//", "");
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("http://")).append(str_sc_ytube.trim()).toString())));
            return;
        } else
        {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("http://www.youtube.com/user/")).append(str_sc_ytube).toString())));
            return;
        }
    }

    ()
    {
        this$0 = Hal1SCDetail.this;
        super();
    }
}
