// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.DialogInterface;
import android.view.View;

// Referenced classes of package com.inponsel.android.details:
//            DetailsPonsel

class this._cls1
    implements android.content.ClickListener
{

    final  this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/details/DetailsPonsel$1

/* anonymous class */
    class DetailsPonsel._cls1
        implements android.view.View.OnClickListener
    {

        final DetailsPonsel this$0;

        public void onClick(View view)
        {
            view = new android.app.AlertDialog.Builder(DetailsPonsel.this);
            view.setTitle(namalengkap);
            view.setMessage(namalengkap);
            view.setPositiveButton("Ya", new DetailsPonsel._cls1._cls1());
            view.show();
        }

            
            {
                this$0 = DetailsPonsel.this;
                super();
            }
    }

}
