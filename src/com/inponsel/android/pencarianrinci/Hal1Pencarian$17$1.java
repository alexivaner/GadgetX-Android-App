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
    implements android.content.lickListener
{

    final ncJenisSentuh this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        i;
        JVM INSTR tableswitch 0 2: default 28
    //                   0 35
    //                   1 117
    //                   2 179;
           goto _L1 _L2 _L3 _L4
_L1:
        dialoginterface.dismiss();
        return;
_L2:
        btnPencLayarSentuh.setText(cdma_hp[0]);
        Hal1Pencarian.strPencLayarSentuh = "nil";
        btnPencJenisSentuh.setEnabled(false);
        rl_layar_sentuh.setBackgroundResource(0x7f080176);
        btnPencJenisSentuh.setText("Abaikan");
        Hal1Pencarian.strPencJenisSentuh = "nil";
        continue; /* Loop/switch isn't completed */
_L3:
        btnPencLayarSentuh.setText(cdma_hp[1]);
        Hal1Pencarian.strPencLayarSentuh = "1";
        btnPencJenisSentuh.setEnabled(true);
        rl_layar_sentuh.setBackgroundResource(0x7f08014c);
        continue; /* Loop/switch isn't completed */
_L4:
        btnPencLayarSentuh.setText(cdma_hp[2]);
        Hal1Pencarian.strPencLayarSentuh = "2";
        btnPencJenisSentuh.setEnabled(false);
        rl_layar_sentuh.setBackgroundResource(0x7f080176);
        btnPencJenisSentuh.setText("Abaikan");
        Hal1Pencarian.strPencJenisSentuh = "nil";
        if (true) goto _L1; else goto _L5
_L5:
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/pencarianrinci/Hal1Pencarian$17

/* anonymous class */
    class Hal1Pencarian._cls17
        implements android.view.View.OnClickListener
    {

        final Hal1Pencarian this$0;

        public void onClick(View view)
        {
            view = new android.app.AlertDialog.Builder(getActivity());
            view.setTitle("Pilih Layar Sentuh :");
            view.setSingleChoiceItems(cdma_hp, -1, new Hal1Pencarian._cls17._cls1());
            view.show();
        }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }
    }

}
