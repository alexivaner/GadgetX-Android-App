// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.utils.UserFunctions;

// Referenced classes of package com.inponsel.android.v2:
//            HomeForumActivity, RegisterActivity, LoginActivity

class this._cls2
    implements android.content.ter._cls1._cls4
{

    final  this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent(ss._mth0(_fld1), com/inponsel/android/v2/RegisterActivity);
        ss._mth0(_fld1).startActivityForResult(dialoginterface, 0);
        ss._mth0(_fld1).overridePendingTransition(0x7f040003, 0x7f040004);
    }

    l.position()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/HomeForumActivity$ListPendatangAdapter$1

/* anonymous class */
    class HomeForumActivity.ListPendatangAdapter._cls1
        implements android.view.View.OnClickListener
    {

        final HomeForumActivity.ListPendatangAdapter this$1;
        private final int val$position;

        public void onClick(View view)
        {
            if (userFunctions.isUserLoggedIn(HomeForumActivity.ListPendatangAdapter.access$0(HomeForumActivity.ListPendatangAdapter.this)))
            {
                view = new android.app.AlertDialog.Builder(HomeForumActivity.ListPendatangAdapter.access$0(HomeForumActivity.ListPendatangAdapter.this));
                view.setMessage("Hentikan langganan forum perangkat ini?");
                view.setPositiveButton("Ya", new HomeForumActivity.ListPendatangAdapter._cls1._cls1());
                view.setNegativeButton("Tidak", new HomeForumActivity.ListPendatangAdapter._cls1._cls2());
                view.show();
                return;
            } else
            {
                view = new android.app.AlertDialog.Builder(HomeForumActivity.ListPendatangAdapter.access$0(HomeForumActivity.ListPendatangAdapter.this));
                view.setMessage("Untuk berlangganan forum, diharuskan login.");
                view.setPositiveButton("Tutup", new HomeForumActivity.ListPendatangAdapter._cls1._cls3());
                view.setNeutralButton("Register", new HomeForumActivity.ListPendatangAdapter._cls1._cls4());
                view.setNegativeButton("Login", new HomeForumActivity.ListPendatangAdapter._cls1._cls5());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_listpendatangadapter;
                position = I.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/HomeForumActivity$ListPendatangAdapter$1$1

/* anonymous class */
        class HomeForumActivity.ListPendatangAdapter._cls1._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final HomeForumActivity.ListPendatangAdapter._cls1 this$2;
            private final int val$position;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
                HomeForumActivity.ListPendatangAdapter.access$0(this$1).id_hp_del = getListModel(position).getId_hp();
                statSubNews = "0";
                (new HomeForumActivity.SubsNewsTask(HomeForumActivity.ListPendatangAdapter.access$0(this$1))).execute(new Void[0]);
            }

                    
                    {
                        this$2 = HomeForumActivity.ListPendatangAdapter._cls1.this;
                        position = i;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/HomeForumActivity$ListPendatangAdapter$1$2

/* anonymous class */
        class HomeForumActivity.ListPendatangAdapter._cls1._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final HomeForumActivity.ListPendatangAdapter._cls1 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = HomeForumActivity.ListPendatangAdapter._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/HomeForumActivity$ListPendatangAdapter$1$3

/* anonymous class */
        class HomeForumActivity.ListPendatangAdapter._cls1._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final HomeForumActivity.ListPendatangAdapter._cls1 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = HomeForumActivity.ListPendatangAdapter._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/HomeForumActivity$ListPendatangAdapter$1$5

/* anonymous class */
        class HomeForumActivity.ListPendatangAdapter._cls1._cls5
            implements android.content.DialogInterface.OnClickListener
        {

            final HomeForumActivity.ListPendatangAdapter._cls1 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(HomeForumActivity.ListPendatangAdapter.access$0(this$1), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                HomeForumActivity.ListPendatangAdapter.access$0(this$1).startActivityForResult(dialoginterface, 0);
                HomeForumActivity.ListPendatangAdapter.access$0(this$1).overridePendingTransition(0x7f040003, 0x7f040004);
            }

                    
                    {
                        this$2 = HomeForumActivity.ListPendatangAdapter._cls1.this;
                        super();
                    }
        }

    }

}
