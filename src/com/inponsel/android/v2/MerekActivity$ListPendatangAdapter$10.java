// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.inponsel.android.adapter.ListModel;

// Referenced classes of package com.inponsel.android.v2:
//            MerekActivity

class val.position
    implements android.view.Adapter._cls10
{

    final _sc_fb this$1;
    private final int val$position;

    public void onClick(View view)
    {
        _sc_fb = ListModel.this.ListModel(val$position).getFacebook().toString();
        _sc_fb_id = ListModel.this.ListModel(val$position).getFacebook_id().toString();
        array = _sc_fb.split(",");
        if (_sc_fb.equals("") || _sc_fb.equals("-"))
        {
            break MISSING_BLOCK_LABEL_126;
        }
        view = OpenFacebookIntent(ess._mth1(this._cls1.this).getApplicationContext());
        ess._mth1(this._cls1.this).startActivity(view);
        return;
        view;
        ess._mth1(this._cls1.this).startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("http://m.facebook.com/")).append(_sc_fb).toString())));
        return;
    }

    ()
    {
        this$1 = final_;
        val$position = I.this;
        super();
    }
}
