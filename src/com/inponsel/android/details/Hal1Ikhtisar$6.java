// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;

// Referenced classes of package com.inponsel.android.details:
//            Hal1Ikhtisar, PilihPonselBanding

class this._cls0
    implements android.view.tener
{

    final Hal1Ikhtisar this$0;

    public void onClick(View view)
    {
        view = new Intent(getActivity(), com/inponsel/android/details/PilihPonselBanding);
        view.putExtra("id_hph", id_hp);
        view.putExtra("namalengkap", namalengkap);
        view.putExtra("codename", codename);
        view.putExtra("model", model);
        view.putExtra("merk", merk);
        view.putExtra("gambar", gambar);
        view.putExtra("hrg_baru", hrg_baru);
        view.putExtra("hrg_bekas", hrg_bekas);
        view.putExtra("tot_like", tnggp_bgs);
        view.putExtra("tot_dislike", tnggp_krg);
        view.putExtra("tot_komen", jml_komentar);
        startActivityForResult(view, 0);
        getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
    }

    ing()
    {
        this$0 = Hal1Ikhtisar.this;
        super();
    }
}
