// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.view.View;
import com.inponsel.android.adapter.ListModel;

// Referenced classes of package com.inponsel.android.v2:
//            MerekActivity, DaftarPonselMerkActivity

class val.position
    implements android.view.gAdapter._cls5
{

    final on this$1;
    private final int val$position;

    public void onClick(View view)
    {
        cess._mth1(this._cls1.this).merk = tListModel(val$position).getId_merk().toString();
        cess._mth1(this._cls1.this).titlemerek = tListModel(val$position).getMerk().toString();
        view = new Intent(cess._mth1(this._cls1.this).getApplicationContext(), com/inponsel/android/v2/DaftarPonselMerkActivity);
        view.putExtra("merk", cess._mth1(this._cls1.this).merk);
        view.putExtra("titlemerek", cess._mth1(this._cls1.this).titlemerek);
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
