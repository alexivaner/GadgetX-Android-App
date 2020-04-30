// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

// Referenced classes of package com.inponsel.android.v2:
//            RegisterActivity

class this._cls0
    implements android.widget.ChangeListener
{

    final RegisterActivity this$0;

    public void onCheckedChanged(RadioGroup radiogroup, int i)
    {
        edtHpDigunakan.setText("");
        if (rbPria.isChecked())
        {
            jenisKelamin = "1";
            return;
        } else
        {
            jenisKelamin = "2";
            return;
        }
    }

    tener()
    {
        this$0 = RegisterActivity.this;
        super();
    }
}
