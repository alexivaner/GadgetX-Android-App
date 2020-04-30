// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;

// Referenced classes of package com.inponsel.android.v2:
//            RoomPostHasilFotoNoCrop

class this._cls0
    implements TextWatcher
{

    final RoomPostHasilFotoNoCrop this$0;

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
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
