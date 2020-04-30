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

    final u_core this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        i;
        JVM INSTR tableswitch 0 7: default 48
    //                   0 55
    //                   1 137
    //                   2 199
    //                   3 261
    //                   4 323
    //                   5 385
    //                   6 447
    //                   7 510;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L1:
        dialoginterface.dismiss();
        return;
_L2:
        btnPencProsessor.setText(clock_hp[0]);
        Hal1Pencarian.strPencProsessor = "nil";
        btnPencCore.setEnabled(false);
        rl_cpu_core.setBackgroundResource(0x7f080176);
        btnPencCore.setText("Abaikan");
        Hal1Pencarian.strPencCore = "nil";
        continue; /* Loop/switch isn't completed */
_L3:
        btnPencProsessor.setText(clock_hp[1]);
        Hal1Pencarian.strPencProsessor = "600";
        btnPencCore.setEnabled(true);
        rl_cpu_core.setBackgroundResource(0x7f08014c);
        continue; /* Loop/switch isn't completed */
_L4:
        btnPencProsessor.setText(clock_hp[2]);
        Hal1Pencarian.strPencProsessor = "800";
        btnPencCore.setEnabled(true);
        rl_cpu_core.setBackgroundResource(0x7f08014c);
        continue; /* Loop/switch isn't completed */
_L5:
        btnPencProsessor.setText(clock_hp[3]);
        Hal1Pencarian.strPencProsessor = "1000";
        btnPencCore.setEnabled(true);
        rl_cpu_core.setBackgroundResource(0x7f08014c);
        continue; /* Loop/switch isn't completed */
_L6:
        btnPencProsessor.setText(clock_hp[4]);
        Hal1Pencarian.strPencProsessor = "1200";
        btnPencCore.setEnabled(true);
        rl_cpu_core.setBackgroundResource(0x7f08014c);
        continue; /* Loop/switch isn't completed */
_L7:
        btnPencProsessor.setText(clock_hp[5]);
        Hal1Pencarian.strPencProsessor = "1500";
        btnPencCore.setEnabled(true);
        rl_cpu_core.setBackgroundResource(0x7f08014c);
        continue; /* Loop/switch isn't completed */
_L8:
        btnPencProsessor.setText(clock_hp[6]);
        Hal1Pencarian.strPencProsessor = "2000";
        btnPencCore.setEnabled(true);
        rl_cpu_core.setBackgroundResource(0x7f08014c);
        continue; /* Loop/switch isn't completed */
_L9:
        btnPencProsessor.setText(clock_hp[7]);
        Hal1Pencarian.strPencProsessor = "2500";
        btnPencCore.setEnabled(true);
        rl_cpu_core.setBackgroundResource(0x7f08014c);
        if (true) goto _L1; else goto _L10
_L10:
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/pencarianrinci/Hal1Pencarian$27

/* anonymous class */
    class Hal1Pencarian._cls27
        implements android.view.View.OnClickListener
    {

        final Hal1Pencarian this$0;

        public void onClick(View view)
        {
            view = new android.app.AlertDialog.Builder(getActivity());
            view.setTitle("Pilih Minimal Clock:");
            view.setSingleChoiceItems(clock_hp, -1, new Hal1Pencarian._cls27._cls1());
            view.show();
        }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }
    }

}
