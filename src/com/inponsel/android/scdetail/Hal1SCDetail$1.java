// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.scdetail;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

// Referenced classes of package com.inponsel.android.scdetail:
//            Hal1SCDetail

class this._cls0
    implements TextWatcher
{

    final Hal1SCDetail this$0;

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        if (edtKoreksiUserSC.getText().length() < 4)
        {
            btnKirimErrorSC.setEnabled(false);
            return;
        } else
        {
            btnKirimErrorSC.setEnabled(true);
            return;
        }
    }

    ()
    {
        this$0 = Hal1SCDetail.this;
        super();
    }
}
