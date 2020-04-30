// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

// Referenced classes of package com.inponsel.android.v2:
//            RoomPostHasilFotoNoCrop

class this._cls0
    implements android.widget.Listener
{

    final RoomPostHasilFotoNoCrop this$0;

    public void onCheckedChanged(RadioGroup radiogroup, int i)
    {
        if (rbLEDYa.isChecked())
        {
            led_flash = "Ya";
        } else
        {
            led_flash = "Tidak";
        }
        if (led_flash.equals("") || cahaya_kond.equals("") || photo_upload == null)
        {
            if (!led_flash.equals("") || !cahaya_kond.equals("") || photo_upload != null)
            {
                btnSaveAskHp.setEnabled(true);
                return;
            } else
            {
                btnPostAskHp.setEnabled(false);
                btnSaveAskHp.setEnabled(false);
                return;
            }
        }
        if (!led_flash.equals("") || !cahaya_kond.equals("") || photo_upload != null)
        {
            btnSaveAskHp.setEnabled(true);
        }
        btnPostAskHp.setEnabled(true);
    }

    ()
    {
        this$0 = RoomPostHasilFotoNoCrop.this;
        super();
    }
}
