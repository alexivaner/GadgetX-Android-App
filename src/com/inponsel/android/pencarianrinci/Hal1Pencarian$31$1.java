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
    implements android.content.lickListener
{

    final ncKerapatanLayar this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        i;
        JVM INSTR tableswitch 0 8: default 52
    //                   0 59
    //                   1 92
    //                   2 125
    //                   3 158
    //                   4 188
    //                   5 221
    //                   6 254
    //                   7 288
    //                   8 322;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L1:
        dialoginterface.dismiss();
        return;
_L2:
        btnPencKerapatanLayar.setText(ppi_hp[0]);
        Hal1Pencarian.strPencKerapatanLayar = "nil";
        continue; /* Loop/switch isn't completed */
_L3:
        btnPencKerapatanLayar.setText(ppi_hp[1]);
        Hal1Pencarian.strPencKerapatanLayar = "130";
        continue; /* Loop/switch isn't completed */
_L4:
        btnPencKerapatanLayar.setText(ppi_hp[2]);
        Hal1Pencarian.strPencKerapatanLayar = "160";
        continue; /* Loop/switch isn't completed */
_L5:
        btnPencKerapatanLayar.setText(ppi_hp[3]);
        Hal1Pencarian.strPencKerapatanLayar = "200";
_L6:
        btnPencKerapatanLayar.setText(ppi_hp[4]);
        Hal1Pencarian.strPencKerapatanLayar = "240";
        continue; /* Loop/switch isn't completed */
_L7:
        btnPencKerapatanLayar.setText(ppi_hp[5]);
        Hal1Pencarian.strPencKerapatanLayar = "300";
        continue; /* Loop/switch isn't completed */
_L8:
        btnPencKerapatanLayar.setText(ppi_hp[6]);
        Hal1Pencarian.strPencKerapatanLayar = "350";
        continue; /* Loop/switch isn't completed */
_L9:
        btnPencKerapatanLayar.setText(ppi_hp[7]);
        Hal1Pencarian.strPencKerapatanLayar = "400";
        continue; /* Loop/switch isn't completed */
_L10:
        btnPencKerapatanLayar.setText(ppi_hp[8]);
        Hal1Pencarian.strPencKerapatanLayar = "500";
        if (true) goto _L1; else goto _L11
_L11:
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/pencarianrinci/Hal1Pencarian$31

/* anonymous class */
    class Hal1Pencarian._cls31
        implements android.view.View.OnClickListener
    {

        final Hal1Pencarian this$0;

        public void onClick(View view)
        {
            view = new android.app.AlertDialog.Builder(getActivity());
            view.setTitle("Pilih Kerapatan Layar:");
            view.setSingleChoiceItems(ppi_hp, -1, new Hal1Pencarian._cls31._cls1());
            view.show();
        }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }
    }

}
