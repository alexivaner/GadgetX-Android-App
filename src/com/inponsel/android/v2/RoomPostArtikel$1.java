// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.inponsel.android.utils.Log;

// Referenced classes of package com.inponsel.android.v2:
//            RoomPostArtikel

class this._cls0
    implements android.widget.edChangeListener
{

    final RoomPostArtikel this$0;

    public void onCheckedChanged(RadioGroup radiogroup, int i)
    {
        if (rbApp.isChecked())
        {
            tag_artikel = "apps";
        } else
        if (rbGames.isChecked())
        {
            tag_artikel = "games";
        } else
        if (rbUmum.isChecked())
        {
            tag_artikel = "umum";
        } else
        if (rbHack.isChecked())
        {
            tag_artikel = "hack";
        } else
        if (rbTips.isChecked())
        {
            tag_artikel = "tips";
        } else
        if (rbAksesoris.isChecked())
        {
            tag_artikel = "aksesoris";
        } else
        if (rbOSFirm.isChecked())
        {
            tag_artikel = "osfirm";
        } else
        {
            tag_artikel = "";
        }
        if (rbAksesoris.isChecked())
        {
            if (edtJudulAskHp.getText().length() > 2)
            {
                btnPostAskHp.setEnabled(true);
                btnSaveAskHp.setEnabled(true);
                btnUpdateAskHp.setEnabled(true);
            } else
            {
                btnPostAskHp.setEnabled(false);
                btnSaveAskHp.setEnabled(false);
                btnUpdateAskHp.setEnabled(false);
            }
        } else
        if (edtJudulAskHp.getText().length() > 2)
        {
            btnPostAskHp.setEnabled(true);
            btnSaveAskHp.setEnabled(true);
            btnUpdateAskHp.setEnabled(true);
        } else
        {
            btnPostAskHp.setEnabled(false);
            btnSaveAskHp.setEnabled(false);
            btnUpdateAskHp.setEnabled(false);
        }
        Log.e("tag_artikel", tag_artikel);
    }

    istener()
    {
        this$0 = RoomPostArtikel.this;
        super();
    }
}
