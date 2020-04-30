// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.UserFunctions;

// Referenced classes of package com.inponsel.android.v2:
//            MerekActivity, RegisterActivity, LoginActivity

class val.position
    implements android.view.gAdapter._cls1
{

    final this._cls1 this$1;
    private final int val$position;

    public void onClick(View view)
    {
        _brand = tListModel(val$position).getId_merk();
        Log.e("substattext", _brand);
        atSubNews = tListModel(val$position).getSubs_status();
        andSubNews = tListModel(val$position).getMerk();
        if (erFunctions.isUserLoggedIn(cess._mth0(this._cls1.this)))
        {
            view = new android.app.ngAdapter(cess._mth0(this._cls1.this));
            view.ngAdapter("Hentikan langganan berita merek ini?");
            view.("Ya", new android.content.DialogInterface.OnClickListener() {

                final MerekActivity.ListPendatangAdapter._cls1 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                    statSubNews = "0";
                    (new MerekActivity.ListPendatangAdapter.SubsNewsTask(this$1)).execute(new Void[0]);
                }

            
            {
                this$2 = MerekActivity.ListPendatangAdapter._cls1.this;
                super();
            }
            });
            view.("Tidak", new android.content.DialogInterface.OnClickListener() {

                final MerekActivity.ListPendatangAdapter._cls1 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$2 = MerekActivity.ListPendatangAdapter._cls1.this;
                super();
            }
            });
            view._mth1();
            return;
        } else
        {
            view = new android.app.ngAdapter._cls1(cess._mth0(this._cls1.this));
            view.ngAdapter("Untuk berlangganan berita, diharuskan login.");
            view.("Tutup", new android.content.DialogInterface.OnClickListener() {

                final MerekActivity.ListPendatangAdapter._cls1 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$2 = MerekActivity.ListPendatangAdapter._cls1.this;
                super();
            }
            });
            view._mth1("Register", new android.content.DialogInterface.OnClickListener() {

                final MerekActivity.ListPendatangAdapter._cls1 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(MerekActivity.ListPendatangAdapter.access$0(this$1), com/inponsel/android/v2/RegisterActivity);
                    MerekActivity.ListPendatangAdapter.access$1(this$1).startActivityForResult(dialoginterface, 0);
                    MerekActivity.ListPendatangAdapter.access$0(this$1).overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$2 = MerekActivity.ListPendatangAdapter._cls1.this;
                super();
            }
            });
            view.("Login", new android.content.DialogInterface.OnClickListener() {

                final MerekActivity.ListPendatangAdapter._cls1 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(MerekActivity.ListPendatangAdapter.access$0(this$1), com/inponsel/android/v2/LoginActivity);
                    dialoginterface.putExtra("activity", "main");
                    MerekActivity.ListPendatangAdapter.access$1(this$1).startActivityForResult(dialoginterface, 0);
                    MerekActivity.ListPendatangAdapter.access$0(this$1).overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$2 = MerekActivity.ListPendatangAdapter._cls1.this;
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
