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

class val.position
    implements android.view.gAdapter._cls1
{

    final on this$1;
    private final int val$position;

    public void onClick(View view)
    {
        if (erFunctions.isUserLoggedIn(cess._mth0(this._cls1.this)))
        {
            view = new android.app.ngAdapter(cess._mth0(this._cls1.this));
            view.ngAdapter("Hentikan langganan forum perangkat ini?");
            view.ngAdapter("Ya", new android.content.DialogInterface.OnClickListener() {

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
            });
            view._mth1("Tidak", new android.content.DialogInterface.OnClickListener() {

                final HomeForumActivity.ListPendatangAdapter._cls1 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$2 = HomeForumActivity.ListPendatangAdapter._cls1.this;
                super();
            }
            });
            view._mth1();
            return;
        } else
        {
            view = new android.app.ngAdapter._cls1(cess._mth0(this._cls1.this));
            view.ngAdapter("Untuk berlangganan forum, diharuskan login.");
            view.ngAdapter("Tutup", new android.content.DialogInterface.OnClickListener() {

                final HomeForumActivity.ListPendatangAdapter._cls1 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$2 = HomeForumActivity.ListPendatangAdapter._cls1.this;
                super();
            }
            });
            view._mth1("Register", new android.content.DialogInterface.OnClickListener() {

                final HomeForumActivity.ListPendatangAdapter._cls1 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(HomeForumActivity.ListPendatangAdapter.access$0(this$1), com/inponsel/android/v2/RegisterActivity);
                    HomeForumActivity.ListPendatangAdapter.access$0(this$1).startActivityForResult(dialoginterface, 0);
                    HomeForumActivity.ListPendatangAdapter.access$0(this$1).overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$2 = HomeForumActivity.ListPendatangAdapter._cls1.this;
                super();
            }
            });
            view._mth1("Login", new android.content.DialogInterface.OnClickListener() {

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
            });
            view._mth1();
            return;
        }
    }


    _cls5.this._cls2()
    {
        this$1 = final__pcls2;
        val$position = I.this;
        super();
    }
}
