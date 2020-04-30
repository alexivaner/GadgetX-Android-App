// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.net.Uri;
import android.view.View;
import com.facebook.share.widget.ShareDialog;
import com.inponsel.android.utils.Log;

// Referenced classes of package com.inponsel.android.details:
//            Hal2Spek

class this._cls0
    implements android.view.kListener
{

    final Hal2Spek this$0;

    public void onClick(View view)
    {
        if (Hal2Spek.access$6(Hal2Spek.this, "com.facebook.katana"))
        {
            Log.e("share", "facebook");
            view = ((com.facebook.share.model.ntent.Builder)(new com.facebook.share.model.ntent.Builder()).setContentTitle((new StringBuilder(String.valueOf(namalengkap))).append(" - Berita, Spesifikasi, Review, Galeri foto, Harga, Service Center").toString()).setImageUrl(Uri.parse(gambar)).setContentDescription((new StringBuilder("Spesifikasi lengkap ")).append(namalengkap).append(". Diumumkan pada ").append(str_share_diumumkan).append(". Fitur ").append(str_share_desc).toString()).setContentUrl(Uri.parse(str_urlspekshare))).build();
            shareDialog.show(view);
            return;
        } else
        {
            Log.e("share", "other");
            Hal2Spek.access$7(Hal2Spek.this, "Perhatian", "Aplikasi Facebook tidak tersedia");
            return;
        }
    }

    t.Builder()
    {
        this$0 = Hal2Spek.this;
        super();
    }
}
