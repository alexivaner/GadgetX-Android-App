// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.inponsel.android.v2.DaftarPonselMerkActivity;

// Referenced classes of package com.inponsel.android.details:
//            Hal2Spek

class this._cls0
    implements android.view.Listener
{

    final Hal2Spek this$0;

    public void onClick(View view)
    {
        view = new Intent(getActivity(), com/inponsel/android/v2/DaftarPonselMerkActivity);
        view.putExtra("merk", id_merk);
        view.putExtra("titlemerek", merk);
        getActivity().startActivityForResult(view, 0);
        getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
    }

    ctivity()
    {
        this$0 = Hal2Spek.this;
        super();
    }
}
