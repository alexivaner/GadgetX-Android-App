// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.pencarianrinci;

import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;

// Referenced classes of package com.inponsel.android.pencarianrinci:
//            Hal1Pencarian

class this._cls0
    implements android.view.ner
{

    final Hal1Pencarian this$0;

    public void onClick(View view)
    {
        view = new android.app.er(getActivity());
        view.setTitle("Pilih Minimal Baterai:");
        view.setSingleChoiceItems(baterai_hp, -1, new android.content.DialogInterface.OnClickListener() {

            final Hal1Pencarian._cls45 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                i;
                JVM INSTR tableswitch 0 9: default 56
            //                           0 63
            //                           1 96
            //                           2 129
            //                           3 162
            //                           4 195
            //                           5 228
            //                           6 261
            //                           7 295
            //                           8 329
            //                           9 363;
                   goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L1:
                dialoginterface.dismiss();
                return;
_L2:
                btnPencBaterai.setText(baterai_hp[0]);
                Hal1Pencarian.strPencBaterai = "nil";
                continue; /* Loop/switch isn't completed */
_L3:
                btnPencBaterai.setText(baterai_hp[1]);
                Hal1Pencarian.strPencBaterai = "800";
                continue; /* Loop/switch isn't completed */
_L4:
                btnPencBaterai.setText(baterai_hp[2]);
                Hal1Pencarian.strPencBaterai = "1000";
                continue; /* Loop/switch isn't completed */
_L5:
                btnPencBaterai.setText(baterai_hp[3]);
                Hal1Pencarian.strPencBaterai = "1300";
                continue; /* Loop/switch isn't completed */
_L6:
                btnPencBaterai.setText(baterai_hp[4]);
                Hal1Pencarian.strPencBaterai = "1600";
                continue; /* Loop/switch isn't completed */
_L7:
                btnPencBaterai.setText(baterai_hp[5]);
                Hal1Pencarian.strPencBaterai = "2000";
                continue; /* Loop/switch isn't completed */
_L8:
                btnPencBaterai.setText(baterai_hp[6]);
                Hal1Pencarian.strPencBaterai = "2500";
                continue; /* Loop/switch isn't completed */
_L9:
                btnPencBaterai.setText(baterai_hp[7]);
                Hal1Pencarian.strPencBaterai = "3000";
                continue; /* Loop/switch isn't completed */
_L10:
                btnPencBaterai.setText(baterai_hp[8]);
                Hal1Pencarian.strPencBaterai = "5000";
                continue; /* Loop/switch isn't completed */
_L11:
                btnPencBaterai.setText(baterai_hp[9]);
                Hal1Pencarian.strPencBaterai = "10000";
                if (true) goto _L1; else goto _L12
_L12:
            }

            
            {
                this$1 = Hal1Pencarian._cls45.this;
                super();
            }
        });
        view.show();
    }


    _cls1.this._cls1()
    {
        this$0 = Hal1Pencarian.this;
        super();
    }
}
