// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.utils.Log;
import com.squareup.picasso.Callback;

// Referenced classes of package com.inponsel.android.v2:
//            MerekActivity

class this._cls1
    implements Callback
{

    final wHolder.txt_merek this$1;

    public void onError()
    {
        der.progressbar_item.setVisibility(8);
        der.img_merek.setImageResource(0x7f02033f);
    }

    public void onSuccess()
    {
        Log.e("load_logo", .getMerk());
        der.progressbar_item.setVisibility(8);
        der.img_merek.setVisibility(0);
        der.txt_merek.setVisibility(0);
    }

    wHolder()
    {
        this$1 = this._cls1.this;
        super();
    }
}
