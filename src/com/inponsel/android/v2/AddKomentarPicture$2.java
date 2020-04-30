// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

// Referenced classes of package com.inponsel.android.v2:
//            AddKomentarPicture

class this._cls0
    implements TextWatcher
{

    final AddKomentarPicture this$0;

    public void afterTextChanged(Editable editable)
    {
        if (edtKomentar.getText().toString().trim().length() == 0)
        {
            btnPostAskHp.setEnabled(false);
            pop_txtCountKomen.setText("512");
            return;
        }
        btnPostAskHp.setEnabled(true);
        charCount = 512 - edtKomentar.getText().toString().length();
        komencount = edtKomentar.getText().toString();
        pop_txtCountKomen.setText(String.valueOf(charCount));
        if (charCount < 0)
        {
            btnPostAskHp.setEnabled(false);
            return;
        }
        if (charCount > 0 && charCount < 4)
        {
            btnPostAskHp.setEnabled(false);
            return;
        } else
        {
            btnPostAskHp.setEnabled(true);
            return;
        }
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        if (edtKomentar.getText().toString().trim().length() == 0)
        {
            btnPostAskHp.setEnabled(false);
            pop_txtCountKomen.setText("512");
            return;
        }
        btnPostAskHp.setEnabled(true);
        charCount = 512 - edtKomentar.getText().toString().length();
        komencount = edtKomentar.getText().toString();
        pop_txtCountKomen.setText(String.valueOf(charCount));
        if (charCount < 0)
        {
            btnPostAskHp.setEnabled(false);
            return;
        }
        if (charCount > 0 && charCount < 4)
        {
            btnPostAskHp.setEnabled(false);
            return;
        } else
        {
            btnPostAskHp.setEnabled(true);
            return;
        }
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        komencount = edtKomentar.getText().toString();
        if (edtKomentar.getText().toString().trim().length() == 0)
        {
            btnPostAskHp.setEnabled(false);
            pop_txtCountKomen.setText("512");
            return;
        }
        btnPostAskHp.setEnabled(true);
        charCount = 512 - edtKomentar.getText().toString().length();
        pop_txtCountKomen.setText(String.valueOf(charCount));
        if (charCount < 0)
        {
            btnPostAskHp.setEnabled(false);
            return;
        }
        if (charCount > 0 && charCount < 4)
        {
            btnPostAskHp.setEnabled(false);
            return;
        } else
        {
            btnPostAskHp.setEnabled(true);
            return;
        }
    }

    ()
    {
        this$0 = AddKomentarPicture.this;
        super();
    }
}
