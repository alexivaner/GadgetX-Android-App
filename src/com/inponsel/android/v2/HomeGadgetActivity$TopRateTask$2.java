// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.view.View;
import com.inponsel.android.details.DetailsPonsel;

// Referenced classes of package com.inponsel.android.v2:
//            HomeGadgetActivity

class this._cls1
    implements android.view.RateTask._cls2
{

    final gTransition this$1;

    public void onClick(View view)
    {
        view = new Intent(cess._mth3(this._cls1.this).getApplicationContext(), com/inponsel/android/details/DetailsPonsel);
        view.putExtra("id_hph", cess._mth3(this._cls1.this).reco_id_hp);
        view.putExtra("namalengkap", (new StringBuilder(String.valueOf(cess._mth3(this._cls1.this).reco_merk))).append(" ").append(cess._mth3(this._cls1.this).reco_model).toString());
        view.putExtra("codename", cess._mth3(this._cls1.this).reco_codename);
        view.putExtra("model", "");
        view.putExtra("merk", "");
        view.putExtra("gambar", "");
        view.putExtra("hrg_baru", "");
        view.putExtra("hrg_bekas", "");
        view.putExtra("tot_like", "");
        view.putExtra("tot_dislike", "");
        view.putExtra("tot_komen", "");
        cess._mth3(this._cls1.this).startActivityForResult(view, 0);
        cess._mth3(this._cls1.this).overridePendingTransition(0x7f040003, 0x7f040004);
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
