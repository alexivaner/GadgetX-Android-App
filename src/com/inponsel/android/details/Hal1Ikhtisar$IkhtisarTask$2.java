// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;

// Referenced classes of package com.inponsel.android.details:
//            Hal1Ikhtisar, RivalTerdekatActivity

class this._cls1
    implements android.view..IkhtisarTask._cls2
{

    final ansition this$1;

    public void onClick(View view)
    {
        view = new Intent(cess._mth3(this._cls1.this).getActivity(), com/inponsel/android/details/RivalTerdekatActivity);
        view.putExtra("codename", cess._mth3(this._cls1.this).codename);
        view.putExtra("model", cess._mth3(this._cls1.this).model);
        view.putExtra("merk", cess._mth3(this._cls1.this).merk);
        view.putExtra("gambar", cess._mth3(this._cls1.this).gambar);
        view.putExtra("hrg_baru", cess._mth3(this._cls1.this).hrg_baru);
        view.putExtra("hrg_bekas", cess._mth3(this._cls1.this).hrg_bekas);
        view.putExtra("jsonRival", cess._mth3(this._cls1.this).jsonRival);
        view.putExtra("id_hp", cess._mth3(this._cls1.this).id_hp);
        cess._mth3(this._cls1.this).getActivity().startActivity(view);
        cess._mth3(this._cls1.this).getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
