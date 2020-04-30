// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.pencarianrinci;

import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;

// Referenced classes of package com.inponsel.android.pencarianrinci:
//            Hal1Pencarian

class this._cls1
    implements android.content.ClickListener
{

    final encHarga this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        i;
        JVM INSTR tableswitch 0 11: default 64
    //                   0 71
    //                   1 104
    //                   2 137
    //                   3 170
    //                   4 203
    //                   5 236
    //                   6 269
    //                   7 303
    //                   8 337
    //                   9 371
    //                   10 405
    //                   11 439;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13
_L1:
        dialoginterface.dismiss();
        return;
_L2:
        btnPencHarga.setText(harga_hp[0]);
        Hal1Pencarian.strPencHarga = "nil";
        continue; /* Loop/switch isn't completed */
_L3:
        btnPencHarga.setText(harga_hp[1]);
        Hal1Pencarian.strPencHarga = "8000000";
        continue; /* Loop/switch isn't completed */
_L4:
        btnPencHarga.setText(harga_hp[2]);
        Hal1Pencarian.strPencHarga = "5000000";
        continue; /* Loop/switch isn't completed */
_L5:
        btnPencHarga.setText(harga_hp[3]);
        Hal1Pencarian.strPencHarga = "4000000";
        continue; /* Loop/switch isn't completed */
_L6:
        btnPencHarga.setText(harga_hp[4]);
        Hal1Pencarian.strPencHarga = "3000000";
        continue; /* Loop/switch isn't completed */
_L7:
        btnPencHarga.setText(harga_hp[5]);
        Hal1Pencarian.strPencHarga = "2500000";
        continue; /* Loop/switch isn't completed */
_L8:
        btnPencHarga.setText(harga_hp[6]);
        Hal1Pencarian.strPencHarga = "2000000";
        continue; /* Loop/switch isn't completed */
_L9:
        btnPencHarga.setText(harga_hp[7]);
        Hal1Pencarian.strPencHarga = "1500000";
        continue; /* Loop/switch isn't completed */
_L10:
        btnPencHarga.setText(harga_hp[8]);
        Hal1Pencarian.strPencHarga = "1000000";
        continue; /* Loop/switch isn't completed */
_L11:
        btnPencHarga.setText(harga_hp[9]);
        Hal1Pencarian.strPencHarga = "700000";
        continue; /* Loop/switch isn't completed */
_L12:
        btnPencHarga.setText(harga_hp[10]);
        Hal1Pencarian.strPencHarga = "500000";
        continue; /* Loop/switch isn't completed */
_L13:
        btnPencHarga.setText(harga_hp[11]);
        Hal1Pencarian.strPencHarga = "300000";
        if (true) goto _L1; else goto _L14
_L14:
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/pencarianrinci/Hal1Pencarian$7

/* anonymous class */
    class Hal1Pencarian._cls7
        implements android.view.View.OnClickListener
    {

        final Hal1Pencarian this$0;

        public void onClick(View view)
        {
            view = new android.app.AlertDialog.Builder(getActivity());
            view.setTitle("Pilih Harga Maksimal :");
            view.setSingleChoiceItems(harga_hp, -1, new Hal1Pencarian._cls7._cls1());
            view.show();
        }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }
    }

}
