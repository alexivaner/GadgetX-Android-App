// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

// Referenced classes of package com.inponsel.android.details:
//            SCTerdekatActivity

class this._cls2
    implements android.content.vAdapter._cls1._cls1
{

    final is._cls1 this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent("android.intent.action.DIAL", Uri.parse((new StringBuilder("tel: ")).append(elp_array[i].replaceAll("-", "")).toString()));
        ss._mth0(_fld1).startActivity(dialoginterface);
    }

    is._cls1()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/details/SCTerdekatActivity$ListSCProvAdapter$1

/* anonymous class */
    class SCTerdekatActivity.ListSCProvAdapter._cls1
        implements android.view.View.OnClickListener
    {

        final SCTerdekatActivity.ListSCProvAdapter this$1;

        public void onClick(View view)
        {
            view = new android.app.AlertDialog.Builder(SCTerdekatActivity.ListSCProvAdapter.access$0(SCTerdekatActivity.ListSCProvAdapter.this));
            view.setTitle("Nomor Telepon :");
            view.setSingleChoiceItems(no_telp_array, -1, new SCTerdekatActivity.ListSCProvAdapter._cls1._cls1());
            view.show();
        }


            
            {
                this$1 = SCTerdekatActivity.ListSCProvAdapter.this;
                super();
            }
    }

}
