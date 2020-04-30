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

    final ncGSMCDMA this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        i;
        JVM INSTR tableswitch 0 5: default 40
    //                   0 47
    //                   1 80
    //                   2 113
    //                   3 146
    //                   4 176
    //                   5 209;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        dialoginterface.dismiss();
        return;
_L2:
        btnPencMultiGSMCDMA.setText(simcardtype4[0]);
        Hal1Pencarian.strPencGSMCDMA = "nil";
        continue; /* Loop/switch isn't completed */
_L3:
        btnPencMultiGSMCDMA.setText(simcardtype4[1]);
        Hal1Pencarian.strPencGSMCDMA = "7";
        continue; /* Loop/switch isn't completed */
_L4:
        btnPencMultiGSMCDMA.setText(simcardtype4[2]);
        Hal1Pencarian.strPencGSMCDMA = "8";
        continue; /* Loop/switch isn't completed */
_L5:
        btnPencMultiGSMCDMA.setText(simcardtype4[2]);
        Hal1Pencarian.strPencGSMCDMA = "9";
_L6:
        btnPencMultiGSMCDMA.setText(simcardtype4[2]);
        Hal1Pencarian.strPencGSMCDMA = "10";
        continue; /* Loop/switch isn't completed */
_L7:
        btnPencMultiGSMCDMA.setText(simcardtype4[2]);
        Hal1Pencarian.strPencGSMCDMA = "11";
        if (true) goto _L1; else goto _L8
_L8:
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/pencarianrinci/Hal1Pencarian$21

/* anonymous class */
    class Hal1Pencarian._cls21
        implements android.view.View.OnClickListener
    {

        final Hal1Pencarian this$0;

        public void onClick(View view)
        {
            view = new android.app.AlertDialog.Builder(getActivity());
            view.setTitle("Pilih Kombinasi Jaringan:");
            if (!Hal1Pencarian.strPencMulti.equals("1")) goto _L2; else goto _L1
_L1:
            view.setSingleChoiceItems(simcardtype, -1, new Hal1Pencarian._cls21._cls1());
_L4:
            view.show();
            return;
_L2:
            if (Hal1Pencarian.strPencMulti.equals("2"))
            {
                view.setSingleChoiceItems(simcardtype3, -1, new Hal1Pencarian._cls21._cls2());
            } else
            if (Hal1Pencarian.strPencMulti.equals("3"))
            {
                view.setSingleChoiceItems(simcardtype4, -1, new Hal1Pencarian._cls21._cls3());
            }
            if (true) goto _L4; else goto _L3
_L3:
        }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/pencarianrinci/Hal1Pencarian$21$1

/* anonymous class */
        class Hal1Pencarian._cls21._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal1Pencarian._cls21 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                i;
                JVM INSTR tableswitch 0 3: default 32
            //                           0 39
            //                           1 72
            //                           2 105
            //                           3 138;
                   goto _L1 _L2 _L3 _L4 _L5
_L1:
                dialoginterface.dismiss();
                return;
_L2:
                btnPencMultiGSMCDMA.setText(simcardtype[0]);
                Hal1Pencarian.strPencGSMCDMA = "nil";
                continue; /* Loop/switch isn't completed */
_L3:
                btnPencMultiGSMCDMA.setText(simcardtype[1]);
                Hal1Pencarian.strPencGSMCDMA = "1";
                continue; /* Loop/switch isn't completed */
_L4:
                btnPencMultiGSMCDMA.setText(simcardtype[2]);
                Hal1Pencarian.strPencGSMCDMA = "2";
                continue; /* Loop/switch isn't completed */
_L5:
                btnPencMultiGSMCDMA.setText(simcardtype[2]);
                Hal1Pencarian.strPencGSMCDMA = "3";
                if (true) goto _L1; else goto _L6
_L6:
            }

                    
                    {
                        this$1 = Hal1Pencarian._cls21.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/pencarianrinci/Hal1Pencarian$21$2

/* anonymous class */
        class Hal1Pencarian._cls21._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal1Pencarian._cls21 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                i;
                JVM INSTR tableswitch 0 4: default 36
            //                           0 43
            //                           1 76
            //                           2 109
            //                           3 142
            //                           4 172;
                   goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
                dialoginterface.dismiss();
                return;
_L2:
                btnPencMultiGSMCDMA.setText(simcardtype3[0]);
                Hal1Pencarian.strPencGSMCDMA = "nil";
                continue; /* Loop/switch isn't completed */
_L3:
                btnPencMultiGSMCDMA.setText(simcardtype3[1]);
                Hal1Pencarian.strPencGSMCDMA = "4";
                continue; /* Loop/switch isn't completed */
_L4:
                btnPencMultiGSMCDMA.setText(simcardtype3[2]);
                Hal1Pencarian.strPencGSMCDMA = "5";
                continue; /* Loop/switch isn't completed */
_L5:
                btnPencMultiGSMCDMA.setText(simcardtype3[2]);
                Hal1Pencarian.strPencGSMCDMA = "6";
_L6:
                btnPencMultiGSMCDMA.setText(simcardtype3[2]);
                Hal1Pencarian.strPencGSMCDMA = "7";
                if (true) goto _L1; else goto _L7
_L7:
            }

                    
                    {
                        this$1 = Hal1Pencarian._cls21.this;
                        super();
                    }
        }

    }

}
