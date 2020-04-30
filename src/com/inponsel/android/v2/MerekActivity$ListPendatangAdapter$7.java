// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.view.View;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.details.ProfilPTActivity;

// Referenced classes of package com.inponsel.android.v2:
//            MerekActivity

class val.position
    implements android.view.gAdapter._cls7
{

    final on this$1;
    private final int val$position;

    public void onClick(View view)
    {
        view = new Intent(cess._mth1(this._cls1.this).getApplicationContext(), com/inponsel/android/details/ProfilPTActivity);
        view.putExtra("id_merk", tListModel(val$position).getId_merk().toString());
        view.putExtra("titlemerek", cess._mth1(this._cls1.this).merk);
        cess._mth1(this._cls1.this).startActivityForResult(view, 0);
        cess._mth1(this._cls1.this).overridePendingTransition(0x7f040003, 0x7f040004);
    }

    ()
    {
        this$1 = final_;
        val$position = I.this;
        super();
    }
}
