// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.daftarharga;

import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

// Referenced classes of package com.inponsel.android.daftarharga:
//            Hal1Preference

class this._cls1
    implements android.content.lickListener
{

    final aAtas this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        i;
        JVM INSTR tableswitch 0 7: default 48
    //                   0 69
    //                   1 107
    //                   2 145
    //                   3 183
    //                   4 221
    //                   5 259
    //                   6 297
    //                   7 336;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L1:
        btnRangeHargaSearch.setEnabled(true);
        dialoginterface.dismiss();
        return;
_L2:
        btnRangeHarga.setText(range[0]);
        Hal1Preference.hargaBawah = "10";
        Hal1Preference.hargaAtas = "5000000000";
        continue; /* Loop/switch isn't completed */
_L3:
        btnRangeHarga.setText(range[1]);
        Hal1Preference.hargaBawah = "10";
        Hal1Preference.hargaAtas = "500000";
        continue; /* Loop/switch isn't completed */
_L4:
        btnRangeHarga.setText(range[2]);
        Hal1Preference.hargaBawah = "500000";
        Hal1Preference.hargaAtas = "1500000";
        continue; /* Loop/switch isn't completed */
_L5:
        btnRangeHarga.setText(range[3]);
        Hal1Preference.hargaBawah = "1500000";
        Hal1Preference.hargaAtas = "2500000";
        continue; /* Loop/switch isn't completed */
_L6:
        btnRangeHarga.setText(range[4]);
        Hal1Preference.hargaBawah = "2500000";
        Hal1Preference.hargaAtas = "3500000";
        continue; /* Loop/switch isn't completed */
_L7:
        btnRangeHarga.setText(range[5]);
        Hal1Preference.hargaBawah = "3500000";
        Hal1Preference.hargaAtas = "4500000";
        continue; /* Loop/switch isn't completed */
_L8:
        btnRangeHarga.setText(range[6]);
        Hal1Preference.hargaBawah = "4500000";
        Hal1Preference.hargaAtas = "5500000";
        continue; /* Loop/switch isn't completed */
_L9:
        btnRangeHarga.setText(range[7]);
        Hal1Preference.hargaBawah = "5500000";
        Hal1Preference.hargaAtas = "1000000000";
        if (true) goto _L1; else goto _L10
_L10:
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/daftarharga/Hal1Preference$4

/* anonymous class */
    class Hal1Preference._cls4
        implements android.view.View.OnClickListener
    {

        final Hal1Preference this$0;

        public void onClick(View view)
        {
            view = new android.app.AlertDialog.Builder(getActivity());
            view.setTitle("Pilih Harga Maksimal :");
            view.setSingleChoiceItems(range, -1, new Hal1Preference._cls4._cls1());
            view.show();
        }


            
            {
                this$0 = Hal1Preference.this;
                super();
            }
    }

}
