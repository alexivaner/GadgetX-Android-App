// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

// Referenced classes of package com.inponsel.android.details:
//            Hal1Ikhtisar

class this._cls2
    implements android.content.
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

    // Unreferenced inner class com/inponsel/android/details/Hal1Ikhtisar$ListSCAdapter$1

/* anonymous class */
    class Hal1Ikhtisar.ListSCAdapter._cls1
        implements android.view.View.OnClickListener
    {

        final Hal1Ikhtisar.ListSCAdapter this$1;

        public void onClick(View view)
        {
            view = new android.app.AlertDialog.Builder(Hal1Ikhtisar.ListSCAdapter.access$0(Hal1Ikhtisar.ListSCAdapter.this).getActivity());
            view.setTitle("Nomor Telepon :");
            view.setSingleChoiceItems(no_telp_array, -1, new Hal1Ikhtisar.ListSCAdapter._cls1._cls1());
            view.show();
        }


            
            {
                this$1 = Hal1Ikhtisar.ListSCAdapter.this;
                super();
            }
    }

}
