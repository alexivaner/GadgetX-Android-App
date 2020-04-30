// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

// Referenced classes of package com.inponsel.android.details:
//            Hal2Spek

class this._cls0
    implements android.view.Listener
{

    final Hal2Spek this$0;

    public void onClick(View view)
    {
        view = (new StringBuilder("Koreksi (")).append(namalengkap).append(")").toString();
        String s = edtKoreksiUser.getText().toString();
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("message/rfc822");
        intent.putExtra("android.intent.extra.EMAIL", new String[] {
            "support@inponsel.co.id"
        });
        intent.putExtra("android.intent.extra.SUBJECT", view);
        intent.putExtra("android.intent.extra.TEXT", s);
        getActivity().startActivity(Intent.createChooser(intent, "Pilih email anda:"));
    }

    ()
    {
        this$0 = Hal2Spek.this;
        super();
    }
}
