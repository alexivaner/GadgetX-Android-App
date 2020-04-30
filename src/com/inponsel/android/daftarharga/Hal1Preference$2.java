// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.daftarharga;

import android.widget.RadioButton;
import android.widget.RadioGroup;

// Referenced classes of package com.inponsel.android.daftarharga:
//            Hal1Preference

class this._cls0
    implements android.widget.kedChangeListener
{

    final Hal1Preference this$0;

    public void onCheckedChanged(RadioGroup radiogroup, int i)
    {
        if (rbPonselTablet.isChecked())
        {
            Hal1Preference.devices = "67";
            return;
        }
        if (rbTablet.isChecked())
        {
            Hal1Preference.devices = "7";
            return;
        } else
        {
            Hal1Preference.devices = "6";
            return;
        }
    }

    ()
    {
        this$0 = Hal1Preference.this;
        super();
    }
}
