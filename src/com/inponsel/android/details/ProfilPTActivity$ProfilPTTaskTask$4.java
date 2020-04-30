// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

// Referenced classes of package com.inponsel.android.details:
//            ProfilPTActivity

class this._cls1
    implements android.view.filPTTaskTask._cls4
{

    final this._cls1 this$1;

    public void onClick(View view)
    {
        if (cess._mth3(this._cls1.this).tw_array.length > 1)
        {
            view = new android.app._array(cess._mth3(this._cls1.this));
            view.tems(cess._mth3(this._cls1.this).tw_array, -1, new android.content.DialogInterface.OnClickListener() {

                final ProfilPTActivity.ProfilPTTaskTask._cls4 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    ProfilPTActivity.ProfilPTTaskTask.access$3(this$1).startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("https://twitter.com/")).append(ProfilPTActivity.ProfilPTTaskTask.access$3(this$1).tw_array[i].replace("@", "")).toString())));
                }

            
            {
                this$2 = ProfilPTActivity.ProfilPTTaskTask._cls4.this;
                super();
            }
            });
            view._mth4();
            return;
        } else
        {
            cess._mth3(this._cls1.this).startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("https://twitter.com/")).append(cess._mth3(this._cls1.this).twitter_pt).toString())));
            return;
        }
    }


    _cls1.this._cls2()
    {
        this$1 = this._cls1.this;
        super();
    }
}
