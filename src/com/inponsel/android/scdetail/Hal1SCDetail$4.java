// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.scdetail;

import android.content.Intent;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

// Referenced classes of package com.inponsel.android.scdetail:
//            Hal1SCDetail

class this._cls0
    implements android.view.tener
{

    final Hal1SCDetail this$0;

    public void onClick(View view)
    {
        view = (new StringBuilder("Koreksi ")).append(str_SC_merk).append(" ").append(str_SC_NAMA).toString();
        String s = edtKoreksiUserSC.getText().toString();
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("message/rfc822");
        intent.putExtra("android.intent.extra.EMAIL", new String[] {
            "support@inponsel.com"
        });
        intent.putExtra("android.intent.extra.SUBJECT", view);
        intent.putExtra("android.intent.extra.TEXT", s);
        startActivity(Intent.createChooser(intent, "Pilih email anda:"));
    }

    ()
    {
        this$0 = Hal1SCDetail.this;
        super();
    }
}
