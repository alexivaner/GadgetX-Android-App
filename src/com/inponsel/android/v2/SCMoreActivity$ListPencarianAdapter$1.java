// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

// Referenced classes of package com.inponsel.android.v2:
//            SCMoreActivity

class this._cls1
    implements android.view.nAdapter._cls1
{

    final this._cls1 this$1;

    public void onClick(View view)
    {
        view = new android.app.anAdapter._cls1(cess._mth0(this._cls1.this));
        view.anAdapter("Nomor Telepon :");
        view.ms(_telp_array, -1, new android.content.DialogInterface.OnClickListener() {

            final SCMoreActivity.ListPencarianAdapter._cls1 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent("android.intent.action.DIAL", Uri.parse((new StringBuilder("tel: ")).append(no_telp_array[i].replaceAll("-", "")).toString()));
                SCMoreActivity.ListPencarianAdapter.access$0(this$1).startActivity(dialoginterface);
            }

            
            {
                this$2 = SCMoreActivity.ListPencarianAdapter._cls1.this;
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
