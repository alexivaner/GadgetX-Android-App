// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.Intent;
import android.view.View;
import com.inponsel.android.utils.Log;
import com.inponsel.android.v2.SCMerkActivity;

// Referenced classes of package com.inponsel.android.details:
//            SCTerdekatActivity

class this._cls0
    implements android.view.dekatActivity._cls8
{

    final SCTerdekatActivity this$0;

    public void onClick(View view)
    {
        Log.e("sc_idmerk1", sc_idmerk1);
        view = new Intent(getApplicationContext(), com/inponsel/android/v2/SCMerkActivity);
        view.putExtra("sc_id_merk", sc_idmerk1);
        startActivityForResult(view, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
    }

    ()
    {
        this$0 = SCTerdekatActivity.this;
        super();
    }
}
