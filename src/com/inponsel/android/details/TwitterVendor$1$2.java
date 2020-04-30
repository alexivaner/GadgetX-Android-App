// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;

// Referenced classes of package com.inponsel.android.details:
//            TwitterVendor

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

    // Unreferenced inner class com/inponsel/android/details/TwitterVendor$1

/* anonymous class */
    class TwitterVendor._cls1
        implements android.widget.AdapterView.OnItemClickListener
    {

        final TwitterVendor this$0;

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            adapterview = new android.app.AlertDialog.Builder(wrapper);
            adapterview.setMessage("Ingin mengunjungi twitter TMCPoldaMetro?");
            adapterview.setPositiveButton("Ya", new TwitterVendor._cls1._cls1());
            adapterview.setNegativeButton("Tidak", new TwitterVendor._cls1._cls2());
        }

            
            {
                this$0 = TwitterVendor.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/details/TwitterVendor$1$1

/* anonymous class */
        class TwitterVendor._cls1._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final TwitterVendor._cls1 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
            }

                    
                    {
                        this$1 = TwitterVendor._cls1.this;
                        super();
                    }
        }

    }

}
