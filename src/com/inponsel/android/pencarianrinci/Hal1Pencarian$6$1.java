// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.pencarianrinci;

import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

// Referenced classes of package com.inponsel.android.pencarianrinci:
//            Hal1Pencarian

class this._cls1
    implements android.content.ClickListener
{

    final encHarga this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        i;
        JVM INSTR tableswitch 0 6: default 44
    //                   0 51
    //                   1 133
    //                   2 215
    //                   3 277
    //                   4 359
    //                   5 441
    //                   6 523;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
        dialoginterface.dismiss();
        return;
_L2:
        btnPencStatus.setText(status_hp[0]);
        Hal1Pencarian.strPencStatus = "nil";
        btnPencHarga.setEnabled(false);
        rl_Harga.setBackgroundResource(0x7f080176);
        btnPencHarga.setText("Abaikan");
        Hal1Pencarian.strPencHarga = "nil";
        continue; /* Loop/switch isn't completed */
_L3:
        btnPencStatus.setText(status_hp[1]);
        Hal1Pencarian.strPencStatus = "1";
        btnPencHarga.setEnabled(false);
        rl_Harga.setBackgroundResource(0x7f080176);
        btnPencHarga.setText("Abaikan");
        Hal1Pencarian.strPencHarga = "nil";
        continue; /* Loop/switch isn't completed */
_L4:
        btnPencStatus.setText(status_hp[2]);
        Hal1Pencarian.strPencStatus = "2";
        btnPencHarga.setEnabled(true);
        rl_Harga.setBackgroundResource(0x7f08014c);
        continue; /* Loop/switch isn't completed */
_L5:
        btnPencStatus.setText(status_hp[3]);
        Hal1Pencarian.strPencStatus = "3";
        btnPencHarga.setEnabled(false);
        rl_Harga.setBackgroundResource(0x7f080176);
        btnPencHarga.setText("Abaikan");
        Hal1Pencarian.strPencHarga = "nil";
        continue; /* Loop/switch isn't completed */
_L6:
        btnPencStatus.setText(status_hp[4]);
        Hal1Pencarian.strPencStatus = "4";
        btnPencHarga.setEnabled(false);
        rl_Harga.setBackgroundResource(0x7f080176);
        btnPencHarga.setText("Abaikan");
        Hal1Pencarian.strPencHarga = "nil";
        continue; /* Loop/switch isn't completed */
_L7:
        btnPencStatus.setText(status_hp[5]);
        Hal1Pencarian.strPencStatus = "5";
        btnPencHarga.setEnabled(false);
        rl_Harga.setBackgroundResource(0x7f080176);
        btnPencHarga.setText("Abaikan");
        Hal1Pencarian.strPencHarga = "nil";
        continue; /* Loop/switch isn't completed */
_L8:
        btnPencStatus.setText(status_hp[6]);
        Hal1Pencarian.strPencStatus = "6";
        btnPencHarga.setEnabled(false);
        rl_Harga.setBackgroundResource(0x7f080176);
        btnPencHarga.setText("Abaikan");
        Hal1Pencarian.strPencHarga = "nil";
        if (true) goto _L1; else goto _L9
_L9:
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/pencarianrinci/Hal1Pencarian$6

/* anonymous class */
    class Hal1Pencarian._cls6
        implements android.view.View.OnClickListener
    {

        final Hal1Pencarian this$0;

        public void onClick(View view)
        {
            view = new android.app.AlertDialog.Builder(getActivity());
            view.setTitle("Pilih Status :");
            view.setSingleChoiceItems(status_hp, -1, new Hal1Pencarian._cls6._cls1());
            view.show();
        }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }
    }

}