// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.view.View;
import java.util.Calendar;

// Referenced classes of package com.inponsel.android.v2:
//            RegisterActivity

class this._cls0
    implements android.view.
{

    final RegisterActivity this$0;

    public void onClick(View view)
    {
        mYear = c.get(1);
        mMonth = c.get(2);
        mDay = c.get(5);
        maxYear = mYear - 7;
        maxMonth = mMonth;
        maxDay = mDay;
        minYear = mYear - 18;
        minMonth = mMonth;
        minDay = mDay;
        showDialog(999);
    }

    ()
    {
        this$0 = RegisterActivity.this;
        super();
    }
}
