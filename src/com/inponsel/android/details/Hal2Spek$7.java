// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;

// Referenced classes of package com.inponsel.android.details:
//            Hal2Spek

class this._cls0
    implements android.view.kListener
{

    final Hal2Spek this$0;

    public void onClick(View view)
    {
        view = (new StringBuilder("Spesifikasi ")).append(namalengkap).toString();
        String s = (new StringBuilder("Info lengkap ")).append(namalengkap).append(". Spesifikasi, berita, harga,dll. ").append(str_urlspekshare).toString();
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("message/rfc822");
        intent.putExtra("android.intent.extra.EMAIL", new String[] {
            ""
        });
        intent.putExtra("android.intent.extra.SUBJECT", view);
        intent.putExtra("android.intent.extra.TEXT", s);
        getActivity().startActivity(Intent.createChooser(intent, "Pilih email anda:"));
    }

    ()
    {
        this$0 = Hal2Spek.this;
        super();
    }
}
