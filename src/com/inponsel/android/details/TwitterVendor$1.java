// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;

// Referenced classes of package com.inponsel.android.details:
//            TwitterVendor

class this._cls0
    implements android.widget.emClickListener
{

    final TwitterVendor this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = new android.app.der(wrapper);
        adapterview.setMessage("Ingin mengunjungi twitter TMCPoldaMetro?");
        adapterview.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

            final TwitterVendor._cls1 this$1;

            public void onClick(DialogInterface dialoginterface, int j)
            {
            }

            
            {
                this$1 = TwitterVendor._cls1.this;
                super();
            }
        });
        adapterview.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

            final TwitterVendor._cls1 this$1;

            public void onClick(DialogInterface dialoginterface, int j)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$1 = TwitterVendor._cls1.this;
                super();
            }
        });
    }

    _cls2.this._cls1()
    {
        this$0 = TwitterVendor.this;
        super();
    }
}
