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
    implements android.view.filPTTaskTask._cls2
{

    final this._cls1 this$1;

    public void onClick(View view)
    {
label0:
        {
            if (!cess._mth3(this._cls1.this).c_center_pt.equals("Tidak ada informasi"))
            {
                if (cess._mth3(this._cls1.this).no_contven_center_array.length <= 1)
                {
                    break label0;
                }
                view = new android.app._contven_center_array(cess._mth3(this._cls1.this));
                view.ofilPTTaskTask("Nomor Telepon :");
                view.tems(cess._mth3(this._cls1.this).no_contven_center_array, -1, new android.content.DialogInterface.OnClickListener() {

                    final ProfilPTActivity.ProfilPTTaskTask._cls2 this$2;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface = new Intent("android.intent.action.DIAL", Uri.parse((new StringBuilder("tel: ")).append(ProfilPTActivity.ProfilPTTaskTask.access$3(this$1).no_contven_center_array[i].replaceAll("[^0-9]", "")).toString()));
                        ProfilPTActivity.ProfilPTTaskTask.access$3(this$1).startActivity(dialoginterface);
                    }

            
            {
                this$2 = ProfilPTActivity.ProfilPTTaskTask._cls2.this;
                super();
            }
                });
                view._mth2();
            }
            return;
        }
        view = new Intent("android.intent.action.DIAL", Uri.parse((new StringBuilder("tel: ")).append(cess._mth3(this._cls1.this).c_center_pt.replaceAll("[^0-9]", "")).toString()));
        cess._mth3(this._cls1.this).startActivity(view);
    }


    _cls1.this._cls2()
    {
        this$1 = this._cls1.this;
        super();
    }
}
