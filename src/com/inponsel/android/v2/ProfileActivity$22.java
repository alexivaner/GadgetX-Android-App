// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.widget.RadioButton;
import android.widget.RadioGroup;

// Referenced classes of package com.inponsel.android.v2:
//            ProfileActivity

class this._cls0
    implements android.widget.dChangeListener
{

    final ProfileActivity this$0;

    public void onCheckedChanged(RadioGroup radiogroup, int i)
    {
        if (rbPriaProfile.isChecked())
        {
            user_jekel_cb = "1";
            return;
        } else
        {
            user_jekel_cb = "2";
            return;
        }
    }

    stener()
    {
        this$0 = ProfileActivity.this;
        super();
    }
}
