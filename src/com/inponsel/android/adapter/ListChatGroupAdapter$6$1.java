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
    implements android.content.stener
{

    final is._cls0 this$1;
    private final ListModel val$lms;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        ((ClipboardManager)ListChatGroupAdapter.access$0(_fld0).getSystemService("clipboard")).setText(val$lms.getLast_message());
        Toast.makeText(ListChatGroupAdapter.access$0(_fld0), "Pesan berhasil dicopy", 1).show();
    }

    l.lms()
    {
        this$1 = final_lms1;
        val$lms = ListModel.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/adapter/ListChatGroupAdapter$6

/* anonymous class */
    class ListChatGroupAdapter._cls6
        implements android.view.View.OnLongClickListener
    {

        final ListChatGroupAdapter this$0;
        private final ListModel val$lms;

        public boolean onLongClick(View view)
        {
            view = new android.app.AlertDialog.Builder(ListChatGroupAdapter.access$0(ListChatGroupAdapter.this));
            view.setMessage("Copy pesan ke clipboard?");
            view.setPositiveButton("Ya", lms. new ListChatGroupAdapter._cls6._cls1());
            view.setNegativeButton("Tidak", new ListChatGroupAdapter._cls6._cls2());
            view.show();
            return false;
        }


            
            {
                this$0 = final_listchatgroupadapter;
                lms = ListModel.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/adapter/ListChatGroupAdapter$6$2

/* anonymous class */
        class ListChatGroupAdapter._cls6._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final ListChatGroupAdapter._cls6 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = ListChatGroupAdapter._cls6.this;
                        super();
                    }
        }

    }

}
