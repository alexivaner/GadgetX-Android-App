// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.view.View;
import com.inponsel.android.details.DetailsPonsel;

// Referenced classes of package com.inponsel.android.v2:
//            AktivitasLainPonselUser

class val.codename
    implements android.view.AsycTask._cls3
{

    final ion this$1;
    private final String val$codename;
    private final String val$id_hp;
    private final String val$my_like_kom;

    public void onClick(View view)
    {
        view = new Intent(cess._mth2(this._cls1.this).getApplicationContext(), com/inponsel/android/details/DetailsPonsel);
        view.putExtra("id_hph", val$id_hp);
        view.putExtra("namalengkap", val$my_like_kom);
        view.putExtra("codename", val$codename);
        view.putExtra("model", "");
        view.putExtra("merk", "");
        view.putExtra("gambar", "");
        view.putExtra("hrg_baru", "");
        view.putExtra("hrg_bekas", "");
        view.putExtra("tot_like", "");
        view.putExtra("tot_dislike", "");
        view.putExtra("tot_komen", "");
        view.putExtra("actfrom", "komen");
        cess._mth2(this._cls1.this).startActivityForResult(view, 0);
        cess._mth2(this._cls1.this).overridePendingTransition(0x7f040003, 0x7f040004);
    }

    ()
    {
        this$1 = final_;
        val$id_hp = s;
        val$my_like_kom = s1;
        val$codename = String.this;
        super();
    }
}
