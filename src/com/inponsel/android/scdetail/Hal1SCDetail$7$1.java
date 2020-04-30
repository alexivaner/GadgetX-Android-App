// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.scdetail;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;

// Referenced classes of package com.inponsel.android.scdetail:
//            Hal1SCDetail

class this._cls1
    implements android.content.nClickListener
{

    final tActivity this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent("android.intent.action.DIAL", Uri.parse((new StringBuilder("tel: ")).append(no_telp_array[i].replaceAll("-", "")).toString()));
        startActivity(dialoginterface);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/scdetail/Hal1SCDetail$7

/* anonymous class */
    class Hal1SCDetail._cls7
        implements android.view.View.OnClickListener
    {

        final Hal1SCDetail this$0;

        public void onClick(View view)
        {
            if (str_sc_telp.equals("Tidak ada informasi"))
            {
                txt_sc_telp.setTextColor(Color.parseColor("#4F4E4F"));
                return;
            }
            txt_sc_telp.setTextColor(Color.parseColor("#33B5E5"));
            if (no_telp_array.length > 1)
            {
                view = new android.app.AlertDialog.Builder(getActivity());
                view.setTitle("Nomor Telepon :");
                view.setSingleChoiceItems(no_telp_array, -1, new Hal1SCDetail._cls7._cls1());
                view.show();
                return;
            } else
            {
                view = new Intent("android.intent.action.DIAL", Uri.parse((new StringBuilder("tel: ")).append(str_sc_telp.replaceAll("-", "")).toString()));
                startActivity(view);
                return;
            }
        }


            
            {
                this$0 = Hal1SCDetail.this;
                super();
            }
    }

}
