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

    final ncInternal this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        i;
        JVM INSTR tableswitch 0 12: default 68
    //                   0 75
    //                   1 108
    //                   2 141
    //                   3 174
    //                   4 207
    //                   5 240
    //                   6 273
    //                   7 307
    //                   8 341
    //                   9 375
    //                   10 409
    //                   11 443
    //                   12 477;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14
_L1:
        dialoginterface.dismiss();
        return;
_L2:
        btnPencInternal.setText(internal_hp[0]);
        Hal1Pencarian.strPencInternal = "nil";
        continue; /* Loop/switch isn't completed */
_L3:
        btnPencInternal.setText(internal_hp[1]);
        Hal1Pencarian.strPencInternal = "128";
        continue; /* Loop/switch isn't completed */
_L4:
        btnPencInternal.setText(internal_hp[2]);
        Hal1Pencarian.strPencInternal = "256";
        continue; /* Loop/switch isn't completed */
_L5:
        btnPencInternal.setText(internal_hp[3]);
        Hal1Pencarian.strPencInternal = "512";
        continue; /* Loop/switch isn't completed */
_L6:
        btnPencInternal.setText(internal_hp[4]);
        Hal1Pencarian.strPencInternal = "768";
        continue; /* Loop/switch isn't completed */
_L7:
        btnPencInternal.setText(internal_hp[5]);
        Hal1Pencarian.strPencInternal = "1000";
        continue; /* Loop/switch isn't completed */
_L8:
        btnPencInternal.setText(internal_hp[6]);
        Hal1Pencarian.strPencInternal = "2000";
        continue; /* Loop/switch isn't completed */
_L9:
        btnPencInternal.setText(internal_hp[7]);
        Hal1Pencarian.strPencInternal = "4000";
        continue; /* Loop/switch isn't completed */
_L10:
        btnPencInternal.setText(internal_hp[8]);
        Hal1Pencarian.strPencInternal = "8000";
        continue; /* Loop/switch isn't completed */
_L11:
        btnPencInternal.setText(internal_hp[9]);
        Hal1Pencarian.strPencInternal = "16000";
        continue; /* Loop/switch isn't completed */
_L12:
        btnPencInternal.setText(internal_hp[10]);
        Hal1Pencarian.strPencInternal = "32000";
        continue; /* Loop/switch isn't completed */
_L13:
        btnPencInternal.setText(internal_hp[11]);
        Hal1Pencarian.strPencInternal = "64000";
        continue; /* Loop/switch isn't completed */
_L14:
        btnPencInternal.setText(internal_hp[12]);
        Hal1Pencarian.strPencInternal = "128000";
        if (true) goto _L1; else goto _L15
_L15:
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/pencarianrinci/Hal1Pencarian$29

/* anonymous class */
    class Hal1Pencarian._cls29
        implements android.view.View.OnClickListener
    {

        final Hal1Pencarian this$0;

        public void onClick(View view)
        {
            view = new android.app.AlertDialog.Builder(getActivity());
            view.setTitle("Pilih Minimal Internal:");
            view.setSingleChoiceItems(internal_hp, -1, new Hal1Pencarian._cls29._cls1());
            view.show();
        }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }
    }

}
