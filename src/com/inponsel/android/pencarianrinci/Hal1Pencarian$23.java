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
        view.setTitle("Pilih Maksimal Panjang:");
        view.setSingleChoiceItems(panjang_hp, -1, new android.content.DialogInterface.OnClickListener() {

            final Hal1Pencarian._cls23 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                i;
                JVM INSTR tableswitch 0 7: default 48
            //                           0 55
            //                           1 88
            //                           2 121
            //                           3 154
            //                           4 187
            //                           5 220
            //                           6 253
            //                           7 287;
                   goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L1:
                dialoginterface.dismiss();
                return;
_L2:
                btnPencPanjang.setText(panjang_hp[0]);
                Hal1Pencarian.strPencPanjang = "nil";
                continue; /* Loop/switch isn't completed */
_L3:
                btnPencPanjang.setText(panjang_hp[1]);
                Hal1Pencarian.strPencPanjang = "300";
                continue; /* Loop/switch isn't completed */
_L4:
                btnPencPanjang.setText(panjang_hp[2]);
                Hal1Pencarian.strPencPanjang = "200";
                continue; /* Loop/switch isn't completed */
_L5:
                btnPencPanjang.setText(panjang_hp[3]);
                Hal1Pencarian.strPencPanjang = "150";
                continue; /* Loop/switch isn't completed */
_L6:
                btnPencPanjang.setText(panjang_hp[4]);
                Hal1Pencarian.strPencPanjang = "120";
                continue; /* Loop/switch isn't completed */
_L7:
                btnPencPanjang.setText(panjang_hp[5]);
                Hal1Pencarian.strPencPanjang = "100";
                continue; /* Loop/switch isn't completed */
_L8:
                btnPencPanjang.setText(panjang_hp[6]);
                Hal1Pencarian.strPencPanjang = "90";
                continue; /* Loop/switch isn't completed */
_L9:
                btnPencPanjang.setText(panjang_hp[7]);
                Hal1Pencarian.strPencPanjang = "80";
                if (true) goto _L1; else goto _L10
_L10:
            }

            
            {
                this$1 = Hal1Pencarian._cls23.this;
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
