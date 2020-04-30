// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.pencariangen;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

// Referenced classes of package com.inponsel.android.pencariangen:
//            Hal2PencSC

class this._cls1
    implements android.view..ListSCProvAdapter._cls1
{

    final this._cls1 this$1;

    public void onClick(View view)
    {
        view = new android.app.ener(cess._mth0(this._cls1.this).getActivity());
        view.getActivity("Nomor Telepon :");
        view.oiceItems(_telp_array, -1, new android.content.DialogInterface.OnClickListener() {

            final Hal2PencSC.ListSCProvAdapter._cls1 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent("android.intent.action.DIAL", Uri.parse((new StringBuilder("tel: ")).append(no_telp_array[i].replaceAll("-", "")).toString()));
                Hal2PencSC.ListSCProvAdapter.access$0(this$1).startActivity(dialoginterface);
            }

            
            {
                this$2 = Hal2PencSC.ListSCProvAdapter._cls1.this;
                super();
            }
        });
        view._mth1();
    }


    _cls1.this._cls2()
    {
        this$1 = this._cls1.this;
        super();
    }
}
