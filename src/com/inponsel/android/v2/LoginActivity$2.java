// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.net.Uri;
import android.view.View;

// Referenced classes of package com.inponsel.android.v2:
//            LoginActivity

class this._cls0
    implements android.view.ener
{

    final LoginActivity this$0;

    public void onClick(View view)
    {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://inponsel.co.id/member/reset/kata-sandi")));
    }

    ()
    {
        this$0 = LoginActivity.this;
        super();
    }
}
