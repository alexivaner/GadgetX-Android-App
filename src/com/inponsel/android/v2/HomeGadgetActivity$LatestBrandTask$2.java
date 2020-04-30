// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.view.View;

// Referenced classes of package com.inponsel.android.v2:
//            HomeGadgetActivity, MerekActivity

class this._cls1
    implements android.view.randTask._cls2
{

    final nsition this$1;

    public void onClick(View view)
    {
        cess._mth3(this._cls1.this).i = new Intent(cess._mth3(this._cls1.this).getApplicationContext(), com/inponsel/android/v2/MerekActivity);
        cess._mth3(this._cls1.this).startActivityForResult(cess._mth3(this._cls1.this).i, 0);
        cess._mth3(this._cls1.this).overridePendingTransition(0x7f040003, 0x7f040004);
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
