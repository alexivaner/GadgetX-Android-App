// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.inponsel.android.tlforum.ForumHPActivity;

// Referenced classes of package com.inponsel.android.details:
//            Hal1Ikhtisar

class this._cls0
    implements android.view.tener
{

    final Hal1Ikhtisar this$0;

    public void onClick(View view)
    {
        view = new Intent(getActivity(), com/inponsel/android/tlforum/ForumHPActivity);
        view.putExtra("id_hph", id_hp);
        view.putExtra("namalengkap", namalengkap);
        view.putExtra("codename", codename);
        view.putExtra("model", model);
        view.putExtra("merk", merk);
        view.putExtra("gambar", gambar);
        view.putExtra("kota", room_kota);
        view.putExtra("kota_id", room_kota_id);
        view.putExtra("prov", room_prov);
        startActivityForResult(view, 0);
        getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
    }

    ()
    {
        this$0 = Hal1Ikhtisar.this;
        super();
    }
}
