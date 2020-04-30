// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;

// Referenced classes of package com.inponsel.android.v2:
//            RoomPostHasilFotoNoCrop

class this._cls1
    implements android.content.ner
{

    final ostAskHp this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        cahaya_kond = pilih_cahaya[i];
        btnhasilfoto.setText(cahaya_kond);
        if (led_flash.equals("") || cahaya_kond.equals("") || photo_upload == null)
        {
            if (!led_flash.equals("") || !cahaya_kond.equals("") || photo_upload != null)
            {
                btnSaveAskHp.setEnabled(true);
            } else
            {
                btnPostAskHp.setEnabled(false);
                btnSaveAskHp.setEnabled(false);
            }
        } else
        {
            if (!led_flash.equals("") || !cahaya_kond.equals("") || photo_upload != null)
            {
                btnSaveAskHp.setEnabled(true);
            }
            btnPostAskHp.setEnabled(true);
        }
        dialoginterface.dismiss();
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/RoomPostHasilFotoNoCrop$5

/* anonymous class */
    class RoomPostHasilFotoNoCrop._cls5
        implements android.view.View.OnClickListener
    {

        final RoomPostHasilFotoNoCrop this$0;

        public void onClick(View view)
        {
            view = new android.app.AlertDialog.Builder(RoomPostHasilFotoNoCrop.this);
            view.setTitle("Pilih Kondisi Cahaya :");
            view.setSingleChoiceItems(pilih_cahaya, -1, new RoomPostHasilFotoNoCrop._cls5._cls1());
            view.show();
        }


            
            {
                this$0 = RoomPostHasilFotoNoCrop.this;
                super();
            }
    }

}
