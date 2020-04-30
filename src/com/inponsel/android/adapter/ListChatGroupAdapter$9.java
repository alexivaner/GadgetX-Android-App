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
//            ListChatGroupAdapter, ListModel

class val.lms
    implements android.view.r
{

    final ListChatGroupAdapter this$0;
    private final ListModel val$lms;

    public boolean onLongClick(View view)
    {
        view = new android.app.it>(ListChatGroupAdapter.access$0(ListChatGroupAdapter.this));
        view.Message("Copy pesan ke clipboard?");
        view.PositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

            final ListChatGroupAdapter._cls9 this$1;
            private final ListModel val$lms;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                ((ClipboardManager)ListChatGroupAdapter.access$0(this$0).getSystemService("clipboard")).setText(lms.getLast_message());
                Toast.makeText(ListChatGroupAdapter.access$0(this$0), "Pesan berhasil dicopy", 1).show();
            }

            
            {
                this$1 = ListChatGroupAdapter._cls9.this;
                lms = listmodel;
                super();
            }
        });
        view.NegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

            final ListChatGroupAdapter._cls9 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$1 = ListChatGroupAdapter._cls9.this;
                super();
            }
        });
        view.w();
        return false;
    }


    _cls2.this._cls1()
    {
        this$0 = final_listchatgroupadapter;
        val$lms = ListModel.this;
        super();
    }
}
