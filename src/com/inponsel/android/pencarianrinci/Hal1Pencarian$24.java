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
        view.setTitle("Pilih Maksimal Lebar:");
        view.setSingleChoiceItems(lebar_hp, -1, new android.content.DialogInterface.OnClickListener() {

            final Hal1Pencarian._cls24 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                i;
                JVM INSTR tableswitch 0 8: default 52
            //                           0 59
            //                           1 92
            //                           2 125
            //                           3 158
            //                           4 191
            //                           5 224
            //                           6 257
            //                           7 291
            //                           8 325;
                   goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L1:
                dialoginterface.dismiss();
                return;
_L2:
                btnPencLebar.setText(lebar_hp[0]);
                Hal1Pencarian.strPencLebar = "nil";
                continue; /* Loop/switch isn't completed */
_L3:
                btnPencLebar.setText(lebar_hp[1]);
                Hal1Pencarian.strPencLebar = "200";
                continue; /* Loop/switch isn't completed */
_L4:
                btnPencLebar.setText(lebar_hp[2]);
                Hal1Pencarian.strPencLebar = "160";
                continue; /* Loop/switch isn't completed */
_L5:
                btnPencLebar.setText(lebar_hp[3]);
                Hal1Pencarian.strPencLebar = "130";
                continue; /* Loop/switch isn't completed */
_L6:
                btnPencLebar.setText(lebar_hp[4]);
                Hal1Pencarian.strPencLebar = "100";
                continue; /* Loop/switch isn't completed */
_L7:
                btnPencLebar.setText(lebar_hp[5]);
                Hal1Pencarian.strPencLebar = "80";
                continue; /* Loop/switch isn't completed */
_L8:
                btnPencLebar.setText(lebar_hp[6]);
                Hal1Pencarian.strPencLebar = "60";
                continue; /* Loop/switch isn't completed */
_L9:
                btnPencLebar.setText(lebar_hp[7]);
                Hal1Pencarian.strPencLebar = "50";
                continue; /* Loop/switch isn't completed */
_L10:
                btnPencLebar.setText(lebar_hp[7]);
                Hal1Pencarian.strPencLebar = "40";
                if (true) goto _L1; else goto _L11
_L11:
            }

            
            {
                this$1 = Hal1Pencarian._cls24.this;
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
