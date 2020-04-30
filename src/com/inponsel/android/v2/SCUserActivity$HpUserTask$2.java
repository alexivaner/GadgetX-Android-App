// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.view.View;
import com.inponsel.android.details.DetailsPonsel;

// Referenced classes of package com.inponsel.android.v2:
//            SCUserActivity

class this._cls1
    implements android.view.UserTask._cls2
{

    final ngTransition this$1;

    public void onClick(View view)
    {
        view = new Intent(cess._mth3(this._cls1.this).getApplicationContext(), com/inponsel/android/details/DetailsPonsel);
        view.putExtra("id_hph", cess._mth3(this._cls1.this).id_hph);
        view.putExtra("namalengkap", (new StringBuilder(String.valueOf(cess._mth3(this._cls1.this).merk))).append(" ").append(cess._mth3(this._cls1.this).model).toString());
        view.putExtra("codename", cess._mth3(this._cls1.this).codename);
        view.putExtra("model", cess._mth3(this._cls1.this).model);
        view.putExtra("merk", cess._mth3(this._cls1.this).merk);
        view.putExtra("gambar", cess._mth3(this._cls1.this).gambar);
        view.putExtra("hrg_baru", cess._mth3(this._cls1.this).hrg_baru);
        view.putExtra("hrg_bekas", cess._mth3(this._cls1.this).hrg_bekas);
        view.putExtra("tot_like", "");
        view.putExtra("tot_dislike", "");
        view.putExtra("tot_komen", "");
        cess._mth3(this._cls1.this).startActivityForResult(view, 0);
        cess._mth3(this._cls1.this).overridePendingTransition(0x7f040003, 0x7f040004);
    }

    _cls9()
    {
        this$1 = this._cls1.this;
        super();
    }
}
