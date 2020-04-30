// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

// Referenced classes of package com.inponsel.android.v2:
//            RoomPostArtikel

class this._cls0
    implements TextWatcher
{

    final RoomPostArtikel this$0;

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        if (rbAksesoris.isChecked())
        {
            if (edtJudulAskHp.getText().length() > 2)
            {
                btnPostAskHp.setEnabled(true);
                btnSaveAskHp.setEnabled(true);
                btnUpdateAskHp.setEnabled(true);
                return;
            } else
            {
                btnPostAskHp.setEnabled(false);
                btnSaveAskHp.setEnabled(false);
                btnUpdateAskHp.setEnabled(false);
                return;
            }
        }
        if (edtJudulAskHp.getText().length() > 2)
        {
            btnPostAskHp.setEnabled(true);
            btnSaveAskHp.setEnabled(true);
            btnUpdateAskHp.setEnabled(true);
            return;
        } else
        {
            btnPostAskHp.setEnabled(false);
            btnSaveAskHp.setEnabled(false);
            btnUpdateAskHp.setEnabled(false);
            return;
        }
    }

    ()
    {
        this$0 = RoomPostArtikel.this;
        super();
    }
}
