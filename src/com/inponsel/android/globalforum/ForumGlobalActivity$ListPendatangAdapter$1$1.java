// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.globalforum;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;

// Referenced classes of package com.inponsel.android.globalforum:
//            ForumGlobalActivity

class val.position
    implements android.content.atangAdapter._cls1._cls1
{

    final is._cls1 this$2;
    private final int val$position;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        ss._mth0(_fld1).id_hp_del = istModel(val$position).getId_hp();
        SubNews = "0";
        (new SubNews(ss._mth0(_fld1)))._mth1(new Void[0]);
    }

    l.position()
    {
        this$2 = final_position1;
        val$position = I.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/globalforum/ForumGlobalActivity$ListPendatangAdapter$1

/* anonymous class */
    class ForumGlobalActivity.ListPendatangAdapter._cls1
        implements android.view.View.OnClickListener
    {

        final ForumGlobalActivity.ListPendatangAdapter this$1;
        private final int val$position;

        public void onClick(View view)
        {
            if (userFunctions.isUserLoggedIn(ForumGlobalActivity.ListPendatangAdapter.access$0(ForumGlobalActivity.ListPendatangAdapter.this)))
            {
                view = new android.app.AlertDialog.Builder(ForumGlobalActivity.ListPendatangAdapter.access$0(ForumGlobalActivity.ListPendatangAdapter.this));
                view.setMessage("Hentikan langganan forum perangkat ini?");
                view.setPositiveButton("Ya", position. new ForumGlobalActivity.ListPendatangAdapter._cls1._cls1());
                view.setNegativeButton("Tidak", new ForumGlobalActivity.ListPendatangAdapter._cls1._cls2());
                view.show();
                return;
            } else
            {
                view = new android.app.AlertDialog.Builder(ForumGlobalActivity.ListPendatangAdapter.access$0(ForumGlobalActivity.ListPendatangAdapter.this));
                view.setMessage("Untuk berlangganan forum, diharuskan login.");
                view.setPositiveButton("Tutup", new ForumGlobalActivity.ListPendatangAdapter._cls1._cls3());
                view.setNeutralButton("Register", new ForumGlobalActivity.ListPendatangAdapter._cls1._cls4());
                view.setNegativeButton("Login", new ForumGlobalActivity.ListPendatangAdapter._cls1._cls5());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_listpendatangadapter;
                position = I.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/globalforum/ForumGlobalActivity$ListPendatangAdapter$1$2

/* anonymous class */
        class ForumGlobalActivity.ListPendatangAdapter._cls1._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final ForumGlobalActivity.ListPendatangAdapter._cls1 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = ForumGlobalActivity.ListPendatangAdapter._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/globalforum/ForumGlobalActivity$ListPendatangAdapter$1$3

/* anonymous class */
        class ForumGlobalActivity.ListPendatangAdapter._cls1._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final ForumGlobalActivity.ListPendatangAdapter._cls1 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = ForumGlobalActivity.ListPendatangAdapter._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/globalforum/ForumGlobalActivity$ListPendatangAdapter$1$4

/* anonymous class */
        class ForumGlobalActivity.ListPendatangAdapter._cls1._cls4
            implements android.content.DialogInterface.OnClickListener
        {

            final ForumGlobalActivity.ListPendatangAdapter._cls1 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(ForumGlobalActivity.ListPendatangAdapter.access$0(this$1), com/inponsel/android/v2/RegisterActivity);
                ForumGlobalActivity.ListPendatangAdapter.access$0(this$1).startActivityForResult(dialoginterface, 0);
                ForumGlobalActivity.ListPendatangAdapter.access$0(this$1).overridePendingTransition(0x7f040003, 0x7f040004);
            }

                    
                    {
                        this$2 = ForumGlobalActivity.ListPendatangAdapter._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/globalforum/ForumGlobalActivity$ListPendatangAdapter$1$5

/* anonymous class */
        class ForumGlobalActivity.ListPendatangAdapter._cls1._cls5
            implements android.content.DialogInterface.OnClickListener
        {

            final ForumGlobalActivity.ListPendatangAdapter._cls1 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(ForumGlobalActivity.ListPendatangAdapter.access$0(this$1), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                ForumGlobalActivity.ListPendatangAdapter.access$0(this$1).startActivityForResult(dialoginterface, 0);
                ForumGlobalActivity.ListPendatangAdapter.access$0(this$1).overridePendingTransition(0x7f040003, 0x7f040004);
            }

                    
                    {
                        this$2 = ForumGlobalActivity.ListPendatangAdapter._cls1.this;
                        super();
                    }
        }

    }

}
