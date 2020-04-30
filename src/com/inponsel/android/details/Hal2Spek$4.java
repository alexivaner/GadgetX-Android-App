// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.inponsel.android.utils.Log;

// Referenced classes of package com.inponsel.android.details:
//            Hal2Spek

class this._cls0
    implements android.view.kListener
{

    final Hal2Spek this$0;

    public void onClick(View view)
    {
        if (Hal2Spek.access$6(Hal2Spek.this, "com.twitter.android"))
        {
            Log.e("share", "com.twitter.android");
            view = new Intent("android.intent.action.SEND");
            view.setType("text/plain");
            view.setPackage("com.twitter.android");
            view.putExtra("android.intent.extra.TEXT", (new StringBuilder("Info lengkap ")).append(namalengkap).append(". Spesifikasi, berita, harga,dll. ").append(str_urlspekshare).toString());
            getActivity().startActivity(view);
            return;
        } else
        {
            Log.e("share", "other");
            Hal2Spek.access$7(Hal2Spek.this, "Perhatian", "Aplikasi Twitter tidak tersedia");
            return;
        }
    }

    ()
    {
        this$0 = Hal2Spek.this;
        super();
    }
}
