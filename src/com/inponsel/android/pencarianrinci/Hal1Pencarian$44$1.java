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

    final ncGPS this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        i;
        JVM INSTR tableswitch 0 2: default 28
    //                   0 35
    //                   1 68
    //                   2 101;
           goto _L1 _L2 _L3 _L4
_L1:
        dialoginterface.dismiss();
        return;
_L2:
        btnPencGPS.setText(cdma_hp[0]);
        Hal1Pencarian.strPencGPS = "nil";
        continue; /* Loop/switch isn't completed */
_L3:
        btnPencGPS.setText(cdma_hp[1]);
        Hal1Pencarian.strPencGPS = "1";
        continue; /* Loop/switch isn't completed */
_L4:
        btnPencGPS.setText(cdma_hp[2]);
        Hal1Pencarian.strPencGPS = "2";
        if (true) goto _L1; else goto _L5
_L5:
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/pencarianrinci/Hal1Pencarian$44

/* anonymous class */
    class Hal1Pencarian._cls44
        implements android.view.View.OnClickListener
    {

        final Hal1Pencarian this$0;

        public void onClick(View view)
        {
            view = new android.app.AlertDialog.Builder(getActivity());
            view.setTitle("Pilih GPS built-in:");
            view.setSingleChoiceItems(cdma_hp, -1, new Hal1Pencarian._cls44._cls1());
            view.show();
        }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }
    }

}
