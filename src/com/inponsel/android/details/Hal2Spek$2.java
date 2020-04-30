// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

// Referenced classes of package com.inponsel.android.details:
//            Hal2Spek

class this._cls0
    implements TextWatcher
{

    final Hal2Spek this$0;

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        if (edtKoreksiUser.getText().length() < 4)
        {
            btnKirimError.setEnabled(false);
            return;
        } else
        {
            btnKirimError.setEnabled(true);
            return;
        }
    }

    ()
    {
        this$0 = Hal2Spek.this;
        super();
    }
}
