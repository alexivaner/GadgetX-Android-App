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
    implements android.view.filPTTaskTask._cls3
{

    final this._cls1 this$1;

    public void onClick(View view)
    {
        try
        {
            view = cess._mth3(this._cls1.this).getOpenFacebookIntent(cess._mth3(this._cls1.this));
            cess._mth3(this._cls1.this).startActivity(view);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            cess._mth3(this._cls1.this).startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("http://m.facebook.com/")).append(cess._mth3(this._cls1.this).fb_pt).toString())));
        }
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
