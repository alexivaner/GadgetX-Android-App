// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

// Referenced classes of package com.inponsel.android.v2:
//            SCUserActivity, SCMoreActivity

class this._cls0
    implements android.view.ner
{

    final SCUserActivity this$0;

    public void onClick(View view)
    {
        view = new Intent(getApplicationContext(), com/inponsel/android/v2/SCMoreActivity);
        view.putExtra("strKey", edtAutoSC.getText().toString());
        startActivityForResult(view, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
    }

    ()
    {
        this$0 = SCUserActivity.this;
        super();
    }
}
