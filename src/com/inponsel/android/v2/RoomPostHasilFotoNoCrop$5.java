// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;

// Referenced classes of package com.inponsel.android.v2:
//            RoomPostHasilFotoNoCrop

class this._cls0
    implements android.view.toNoCrop._cls5
{

    final RoomPostHasilFotoNoCrop this$0;

    public void onClick(View view)
    {
        view = new android.app.(RoomPostHasilFotoNoCrop.this);
        view.le("Pilih Kondisi Cahaya :");
        view.gleChoiceItems(pilih_cahaya, -1, new android.content.DialogInterface.OnClickListener() {

            final RoomPostHasilFotoNoCrop._cls5 this$1;

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

            
            {
                this$1 = RoomPostHasilFotoNoCrop._cls5.this;
                super();
            }
        });
        view._mth5();
    }


    _cls1.this._cls1()
    {
        this$0 = RoomPostHasilFotoNoCrop.this;
        super();
    }
}
