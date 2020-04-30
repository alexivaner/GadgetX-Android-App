// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

// Referenced classes of package com.inponsel.android.v2:
//            RegisterActivity

class this._cls0
    implements android.widget.eckedChangeListener
{

    final RegisterActivity this$0;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        if (cb_showPassword.isChecked())
        {
            edtPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            edtRePass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            return;
        } else
        {
            edtPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
            edtRePass.setTransformationMethod(PasswordTransformationMethod.getInstance());
            return;
        }
    }

    ethod()
    {
        this$0 = RegisterActivity.this;
        super();
    }
}
