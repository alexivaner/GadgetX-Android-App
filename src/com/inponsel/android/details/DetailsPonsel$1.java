// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.DialogInterface;
import android.view.View;

// Referenced classes of package com.inponsel.android.details:
//            DetailsPonsel

class this._cls0
    implements android.view.ener
{

    final DetailsPonsel this$0;

    public void onClick(View view)
    {
        view = new android.app.der(DetailsPonsel.this);
        view.setTitle(namalengkap);
        view.setMessage(namalengkap);
        view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

            final DetailsPonsel._cls1 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$1 = DetailsPonsel._cls1.this;
                super();
            }
        });
        view.show();
    }

    _cls1.this._cls1()
    {
        this$0 = DetailsPonsel.this;
        super();
    }
}
