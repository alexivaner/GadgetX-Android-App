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
    implements android.view.tener
{

    final Hal1SCDetail this$0;

    public void onClick(View view)
    {
        try
        {
            view = getOpenFacebookIntent(getActivity());
            startActivity(view);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("http://m.facebook.com/")).append(str_sc_fb).toString())));
        }
    }

    ()
    {
        this$0 = Hal1SCDetail.this;
        super();
    }
}
