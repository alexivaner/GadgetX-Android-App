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
        view.setTitle("Pilih EDGE :");
        view.setSingleChoiceItems(edge_hp, -1, new android.content.DialogInterface.OnClickListener() {

            final Hal1Pencarian._cls12 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                i;
                JVM INSTR tableswitch 0 2: default 28
            //                           0 35
            //                           1 68
            //                           2 101;
                   goto _L1 _L2 _L3 _L4
_L1:
                dialoginterface.dismiss();
                return;
_L2:
                btnPencEDGE.setText(edge_hp[0]);
                Hal1Pencarian.strPencEDGE = "nil";
                continue; /* Loop/switch isn't completed */
_L3:
                btnPencEDGE.setText(edge_hp[1]);
                Hal1Pencarian.strPencEDGE = "1";
                continue; /* Loop/switch isn't completed */
_L4:
                btnPencEDGE.setText(edge_hp[2]);
                Hal1Pencarian.strPencEDGE = "2";
                if (true) goto _L1; else goto _L5
_L5:
            }

            
            {
                this$1 = Hal1Pencarian._cls12.this;
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
