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

    final ncUkuranLayar this$1;

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
        btnPencUkuranLayar.setText(inch_hp[0]);
        Hal1Pencarian.strPencUkuranLayar = "nil";
        continue; /* Loop/switch isn't completed */
_L3:
        btnPencUkuranLayar.setText(inch_hp[1]);
        Hal1Pencarian.strPencUkuranLayar = "2";
        continue; /* Loop/switch isn't completed */
_L4:
        btnPencUkuranLayar.setText(inch_hp[2]);
        Hal1Pencarian.strPencUkuranLayar = "2.4";
        continue; /* Loop/switch isn't completed */
_L5:
        btnPencUkuranLayar.setText(inch_hp[3]);
        Hal1Pencarian.strPencUkuranLayar = "2.8";
        continue; /* Loop/switch isn't completed */
_L6:
        btnPencUkuranLayar.setText(inch_hp[4]);
        Hal1Pencarian.strPencUkuranLayar = "3.2";
        continue; /* Loop/switch isn't completed */
_L7:
        btnPencUkuranLayar.setText(inch_hp[5]);
        Hal1Pencarian.strPencUkuranLayar = "3.5";
        continue; /* Loop/switch isn't completed */
_L8:
        btnPencUkuranLayar.setText(inch_hp[6]);
        Hal1Pencarian.strPencUkuranLayar = "4";
        continue; /* Loop/switch isn't completed */
_L9:
        btnPencUkuranLayar.setText(inch_hp[7]);
        Hal1Pencarian.strPencUkuranLayar = "4.5";
        continue; /* Loop/switch isn't completed */
_L10:
        btnPencUkuranLayar.setText(inch_hp[8]);
        Hal1Pencarian.strPencUkuranLayar = "5";
        continue; /* Loop/switch isn't completed */
_L11:
        btnPencUkuranLayar.setText(inch_hp[9]);
        Hal1Pencarian.strPencUkuranLayar = "6";
        continue; /* Loop/switch isn't completed */
_L12:
        btnPencUkuranLayar.setText(inch_hp[10]);
        Hal1Pencarian.strPencUkuranLayar = "7";
        continue; /* Loop/switch isn't completed */
_L13:
        btnPencUkuranLayar.setText(inch_hp[11]);
        Hal1Pencarian.strPencUkuranLayar = "10";
        if (true) goto _L1; else goto _L14
_L14:
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/pencarianrinci/Hal1Pencarian$30

/* anonymous class */
    class Hal1Pencarian._cls30
        implements android.view.View.OnClickListener
    {

        final Hal1Pencarian this$0;

        public void onClick(View view)
        {
            view = new android.app.AlertDialog.Builder(getActivity());
            view.setTitle("Pilih Minimal UkuranLayar:");
            view.setSingleChoiceItems(inch_hp, -1, new Hal1Pencarian._cls30._cls1());
            view.show();
        }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }
    }

}
