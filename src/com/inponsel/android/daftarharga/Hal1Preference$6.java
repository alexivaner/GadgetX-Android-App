// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.daftarharga;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

// Referenced classes of package com.inponsel.android.daftarharga:
//            Hal1Preference, BaseDaftarActivity, Hal2Hasil

class this._cls0
    implements android.widget.ActionListener
{

    final Hal1Preference this$0;

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        Hal1Preference.hargaBawah = "10";
        Hal1Preference.hargaAtas = edtHarga.getText().toString().trim();
        Hal1Preference.hargaAtas = Hal1Preference.hargaAtas.replace(".", "").trim();
        if (edtHarga.getText().length() != 0) goto _L2; else goto _L1
_L1:
        Toast.makeText(getActivity(), "Harga belum diisi", 1).show();
_L4:
        return false;
_L2:
        int j;
        if (Integer.parseInt(Hal1Preference.hargaAtas) < 0x186a0)
        {
            Toast.makeText(getActivity(), "Budget minimal 100.000", 1).show();
            continue; /* Loop/switch isn't completed */
        }
        ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(edtHarga.getWindowToken(), 0);
        i = Integer.parseInt(Hal1Preference.hargaAtas);
        if (i < 0x7a120 || i > 0xf4240)
        {
            break; /* Loop/switch isn't completed */
        }
        j = i - 0x249f0;
        i += 0x249f0;
_L5:
        Hal1Preference.hargaBawah = String.valueOf(j);
        Hal1Preference.hargaAtas = String.valueOf(i);
        count = 0;
        textview = ((BaseDaftarActivity)getActivity()).getHal2Hasil();
        ((Hal2Hasil)getActivity().getSupportFragmentManager().findFragmentByTag(textview)).HargaHpTask();
        BaseDaftarActivity.mPager.setCurrentItem(1, true);
        if (true) goto _L4; else goto _L3
_L3:
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
          goto _L5
        if (true) goto _L4; else goto _L6
_L6:
    }

    y()
    {
        this$0 = Hal1Preference.this;
        super();
    }
}
