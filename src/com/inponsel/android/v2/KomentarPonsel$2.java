// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.TextView;
import com.inponsel.android.widget.DroidWriterEditText;

// Referenced classes of package com.inponsel.android.v2:
//            KomentarPonsel

class this._cls0
    implements TextWatcher
{

    final KomentarPonsel this$0;

    public void afterTextChanged(Editable editable)
    {
        if (edt_pop_komen.getText().toString().trim().length() == 0)
        {
            btn_send_komen.setEnabled(false);
            pop_txtCountKomen.setText("512");
            return;
        }
        btn_send_komen.setEnabled(true);
        charCount = 512 - edt_pop_komen.getText().toString().length();
        komencount = edt_pop_komen.getText().toString();
        pop_txtCountKomen.setText(String.valueOf(charCount));
        if (charCount < 0)
        {
            btn_send_komen.setEnabled(false);
            return;
        }
        if (charCount > 0 && charCount < 4)
        {
            btn_send_komen.setEnabled(false);
            return;
        } else
        {
            btn_send_komen.setEnabled(true);
            return;
        }
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        if (edt_pop_komen.getText().toString().trim().length() == 0)
        {
            btn_send_komen.setEnabled(false);
            pop_txtCountKomen.setText("512");
            return;
        }
        btn_send_komen.setEnabled(true);
        charCount = 512 - edt_pop_komen.getText().toString().length();
        komencount = edt_pop_komen.getText().toString();
        pop_txtCountKomen.setText(String.valueOf(charCount));
        if (charCount < 0)
        {
            btn_send_komen.setEnabled(false);
            return;
        }
        if (charCount > 0 && charCount < 4)
        {
            btn_send_komen.setEnabled(false);
            return;
        } else
        {
            btn_send_komen.setEnabled(true);
            return;
        }
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        komencount = edt_pop_komen.getText().toString();
        if (edt_pop_komen.getText().toString().trim().length() == 0)
        {
            btn_send_komen.setEnabled(false);
            pop_txtCountKomen.setText("512");
            return;
        }
        btn_send_komen.setEnabled(true);
        charCount = 512 - edt_pop_komen.getText().toString().length();
        pop_txtCountKomen.setText(String.valueOf(charCount));
        if (charCount < 0)
        {
            btn_send_komen.setEnabled(false);
            return;
        }
        if (charCount > 0 && charCount < 4)
        {
            btn_send_komen.setEnabled(false);
            return;
        } else
        {
            btn_send_komen.setEnabled(true);
            return;
        }
    }

    itText()
    {
        this$0 = KomentarPonsel.this;
        super();
    }
}
