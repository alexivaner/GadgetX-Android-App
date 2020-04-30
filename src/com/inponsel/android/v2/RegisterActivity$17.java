// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.text.Editable;
import android.text.TextWatcher;

// Referenced classes of package com.inponsel.android.v2:
//            RegisterActivity

class this._cls0
    implements TextWatcher
{

    final RegisterActivity this$0;

    public void afterTextChanged(Editable editable)
    {
        checkField();
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    ()
    {
        this$0 = RegisterActivity.this;
        super();
    }
}
