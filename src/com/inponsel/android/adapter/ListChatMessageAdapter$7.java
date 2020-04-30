// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.adapter;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Toast;

// Referenced classes of package com.inponsel.android.adapter:
//            ListChatMessageAdapter, ListModel

class val.lms
    implements android.view.essageAdapter._cls7
{

    final ListChatMessageAdapter this$0;
    private final ListModel val$lms;

    public boolean onLongClick(View view)
    {
        view = new android.app.>(ListChatMessageAdapter.access$0(ListChatMessageAdapter.this));
        view.ssage("Copy pesan ke clipboard?");
        view.sitiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

            final ListChatMessageAdapter._cls7 this$1;
            private final ListModel val$lms;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                ((ClipboardManager)ListChatMessageAdapter.access$0(this$0).getSystemService("clipboard")).setText(lms.getLast_message());
                Toast.makeText(ListChatMessageAdapter.access$0(this$0), "Pesan berhasil dicopy", 1).show();
            }

            
            {
                this$1 = ListChatMessageAdapter._cls7.this;
                lms = listmodel;
                super();
            }
        });
        view.gativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

            final ListChatMessageAdapter._cls7 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$1 = ListChatMessageAdapter._cls7.this;
                super();
            }
        });
        view._mth7();
        return false;
    }


    _cls2.this._cls1()
    {
        this$0 = final_listchatmessageadapter;
        val$lms = ListModel.this;
        super();
    }
}
