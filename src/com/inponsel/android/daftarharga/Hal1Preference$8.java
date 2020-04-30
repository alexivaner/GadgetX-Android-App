// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.daftarharga;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

// Referenced classes of package com.inponsel.android.daftarharga:
//            Hal1Preference, BaseDaftarActivity, Hal2Hasil

class this._cls0
    implements android.view.ner
{

    final Hal1Preference this$0;

    public void onClick(View view)
    {
        if (btnRangeHarga.getText().toString().contains("Pilih rentang harga"))
        {
            Toast.makeText(getActivity(), "Rentang harga belum dipilih", 1).show();
            return;
        } else
        {
            view = ((BaseDaftarActivity)getActivity()).getHal2Hasil();
            ((Hal2Hasil)getActivity().getSupportFragmentManager().findFragmentByTag(view)).HargaHpTask();
            BaseDaftarActivity.mPager.setCurrentItem(1, true);
            return;
        }
    }

    y()
    {
        this$0 = Hal1Preference.this;
        super();
    }
}
