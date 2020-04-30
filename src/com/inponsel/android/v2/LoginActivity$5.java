// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.text.Editable;
import android.text.TextWatcher;

// Referenced classes of package com.inponsel.android.v2:
//            LoginActivity

class this._cls0
    implements TextWatcher
{

    final LoginActivity this$0;

    public void afterTextChanged(Editable editable)
    {
        checkField();
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        checkField();
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        checkField();
    }

    ()
    {
        this$0 = LoginActivity.this;
        super();
    }
}
