// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.scdetail;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;

// Referenced classes of package com.inponsel.android.scdetail:
//            Hal1SCDetail, SCKomenPager

class this._cls0
    implements android.view.tener
{

    final Hal1SCDetail this$0;

    public void onClick(View view)
    {
        view = new Intent(getActivity(), com/inponsel/android/scdetail/SCKomenPager);
        view.putExtra("sc_id", str_SC_ID);
        view.putExtra("sc_judul", str_SC_NAMA);
        view.putExtra("sc_logo", "");
        view.putExtra("sc_nama", str_SC_NAMA);
        view.putExtra("sc_merk", str_SC_merk);
        startActivityForResult(view, 0);
        getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
    }

    ()
    {
        this$0 = Hal1SCDetail.this;
        super();
    }
}
