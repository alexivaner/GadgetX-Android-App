// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.daftarharga;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

// Referenced classes of package com.inponsel.android.daftarharga:
//            Hal1Preference, BaseDaftarActivity, Hal2Hasil

class this._cls0
    implements android.view.ner
{

    final Hal1Preference this$0;

    public void onClick(View view)
    {
        if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected())
        {
            if (edtHarga.getText().length() == 0)
            {
                Toast.makeText(getActivity(), "Harga belum diisi", 1).show();
                return;
            }
            Hal1Preference.hargaBawah = "10";
            Hal1Preference.hargaAtas = edtHarga.getText().toString().trim();
            Hal1Preference.hargaAtas = Hal1Preference.hargaAtas.replace(".", "").trim();
            if (Integer.parseInt(Hal1Preference.hargaAtas) < 0x186a0)
            {
                Toast.makeText(getActivity(), "Budget minimal 100.000", 1).show();
                return;
            }
            ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(edtHarga.getWindowToken(), 0);
            int i = Integer.parseInt(Hal1Preference.hargaAtas);
            int j;
            if (i >= 0x7a120 && i <= 0xf4240)
            {
                j = i - 0x249f0;
                i += 0x249f0;
            } else
            if (i >= 0xf4240 && i <= 0x1e8480)
            {
                j = i - 0x2ab98;
                i += 0x2ab98;
            } else
            if (i >= 0x1e8480 && i <= 0x2dc6c0)
            {
                j = i - 0x3d090;
                i += 0x3d090;
            } else
            if (i >= 0x2dc6c0 && i <= 0x3d0900)
            {
                j = i - 0x55730;
                i += 0x55730;
            } else
            if (i >= 0x3d0900 && i <= 0x53ec60)
            {
                j = i - 0x6ddd0;
                i += 0x6ddd0;
            } else
            if (i >= 0x53ec60)
            {
                j = i - 0x86470;
                i += 0x86470;
            } else
            {
                j = i - (i - 10000);
                i += i - 10000;
            }
            Hal1Preference.hargaBawah = String.valueOf(j);
            Hal1Preference.hargaAtas = String.valueOf(i);
            count = 0;
            view = ((BaseDaftarActivity)getActivity()).getHal2Hasil();
            ((Hal2Hasil)getActivity().getSupportFragmentManager().findFragmentByTag(view)).HargaHpTask();
            BaseDaftarActivity.mPager.setCurrentItem(1, true);
            return;
        } else
        {
            Toast.makeText(getActivity(), "Tidak ada koneksi internet", 0).show();
            return;
        }
    }

    y()
    {
        this$0 = Hal1Preference.this;
        super();
    }
}
