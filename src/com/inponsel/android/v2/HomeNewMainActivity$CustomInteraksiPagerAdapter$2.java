// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.inponsel.android.adapter.ListModel;

// Referenced classes of package com.inponsel.android.v2:
//            HomeNewMainActivity, KomentarPonsel

class val.lms
    implements android.view.rAdapter._cls2
{

    final tivity this$1;
    private final ListModel val$lms;

    public void onClick(View view)
    {
        view = new Intent(tivity, com/inponsel/android/v2/KomentarPonsel);
        view.putExtra("id_hph", val$lms.getId_hp());
        view.putExtra("namalengkap", val$lms.getNamalengkap());
        view.putExtra("codename", val$lms.getCodename());
        view.putExtra("model", val$lms.getModel());
        view.putExtra("merk", val$lms.getMerk());
        view.putExtra("gambar", "");
        view.putExtra("hrg_baru", "");
        view.putExtra("hrg_bekas", "");
        view.putExtra("tot_like", "");
        view.putExtra("tot_dislike", "");
        view.putExtra("tot_komen", "");
        view.putExtra("actfrom", "komen");
        tivity.startActivityForResult(view, 0);
        tivity.overridePendingTransition(0x7f040003, 0x7f040004);
    }

    ()
    {
        this$1 = final_;
        val$lms = ListModel.this;
        super();
    }
}
