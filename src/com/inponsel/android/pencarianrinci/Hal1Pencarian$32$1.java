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

    final ncKamera this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        i;
        JVM INSTR tableswitch 0 7: default 48
    //                   0 55
    //                   1 88
    //                   2 121
    //                   3 154
    //                   4 187
    //                   5 220
    //                   6 253
    //                   7 287;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L1:
        dialoginterface.dismiss();
        return;
_L2:
        btnPencKamera.setText(kamera_hp[0]);
        Hal1Pencarian.strPencKamera = "nil";
        continue; /* Loop/switch isn't completed */
_L3:
        btnPencKamera.setText(kamera_hp[1]);
        Hal1Pencarian.strPencKamera = "0.3";
        continue; /* Loop/switch isn't completed */
_L4:
        btnPencKamera.setText(kamera_hp[2]);
        Hal1Pencarian.strPencKamera = "1";
        continue; /* Loop/switch isn't completed */
_L5:
        btnPencKamera.setText(kamera_hp[3]);
        Hal1Pencarian.strPencKamera = "2";
        continue; /* Loop/switch isn't completed */
_L6:
        btnPencKamera.setText(kamera_hp[4]);
        Hal1Pencarian.strPencKamera = "3";
        continue; /* Loop/switch isn't completed */
_L7:
        btnPencKamera.setText(kamera_hp[5]);
        Hal1Pencarian.strPencKamera = "5";
        continue; /* Loop/switch isn't completed */
_L8:
        btnPencKamera.setText(kamera_hp[6]);
        Hal1Pencarian.strPencKamera = "8";
        continue; /* Loop/switch isn't completed */
_L9:
        btnPencKamera.setText(kamera_hp[7]);
        Hal1Pencarian.strPencKamera = "12";
        if (true) goto _L1; else goto _L10
_L10:
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/pencarianrinci/Hal1Pencarian$32

/* anonymous class */
    class Hal1Pencarian._cls32
        implements android.view.View.OnClickListener
    {

        final Hal1Pencarian this$0;

        public void onClick(View view)
        {
            view = new android.app.AlertDialog.Builder(getActivity());
            view.setTitle("Pilih Minimal Kamera:");
            view.setSingleChoiceItems(kamera_hp, -1, new Hal1Pencarian._cls32._cls1());
            view.show();
        }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }
    }

}
