// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.scdetail;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

// Referenced classes of package com.inponsel.android.scdetail:
//            Hal1SCDetail

class this._cls0
    implements android.view.tener
{

    final Hal1SCDetail this$0;

    public void onClick(View view)
    {
label0:
        {
            if (!str_cont_center.equals("Tidak ada informasi"))
            {
                if (no_contven_center_array.length <= 1)
                {
                    break label0;
                }
                view = new android.app.lder(getActivity());
                view.setTitle("Nomor Telepon :");
                view.setSingleChoiceItems(no_contven_center_array, -1, new android.content.DialogInterface.OnClickListener() {

                    final Hal1SCDetail._cls8 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface = new Intent("android.intent.action.DIAL", Uri.parse((new StringBuilder("tel: ")).append(no_contven_center_array[i].replaceAll("[^0-9]", "")).toString()));
                        startActivity(dialoginterface);
                    }

            
            {
                this$1 = Hal1SCDetail._cls8.this;
                super();
            }
                });
                view.show();
            }
            return;
        }
        view = new Intent("android.intent.action.DIAL", Uri.parse((new StringBuilder("tel: ")).append(str_contven_center.replaceAll("[^0-9]", "")).toString()));
        startActivity(view);
    }


    _cls1.this._cls1()
    {
        this$0 = Hal1SCDetail.this;
        super();
    }
}
