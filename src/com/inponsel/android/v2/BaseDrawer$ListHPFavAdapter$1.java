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
//            BaseDrawer, RegisterActivity, LoginActivity

class val.position
    implements android.view.vAdapter._cls1
{

    final sition this$1;
    private final int val$position;

    public void onClick(View view)
    {
        if (erFunctions.isUserLoggedIn(cess._mth0(this._cls1.this).getApplicationContext()))
        {
            view = new android.app.icationContext(cess._mth0(this._cls1.this).getApplicationContext());
            view.("Hentikan langganan forum perangkat ini?");
            view.eButton("Ya", new android.content.DialogInterface.OnClickListener() {

                final BaseDrawer.ListHPFavAdapter._cls1 this$2;
                private final int val$position;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                    BaseDrawer.ListHPFavAdapter.access$0(this$1).id_hp_del = getListModel(position).getId_hp();
                    statSubNews = "0";
                    (new BaseDrawer.DeleteHpFavTask(BaseDrawer.ListHPFavAdapter.access$0(this$1))).execute(new Void[0]);
                }

            
            {
                this$2 = BaseDrawer.ListHPFavAdapter._cls1.this;
                position = i;
                super();
            }
            });
            view.eButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                final BaseDrawer.ListHPFavAdapter._cls1 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$2 = BaseDrawer.ListHPFavAdapter._cls1.this;
                super();
            }
            });
            view._mth1();
            return;
        } else
        {
            view = new android.app.avAdapter._cls1(cess._mth0(this._cls1.this).getApplicationContext());
            view.("Untuk berlangganan forum, diharuskan login.");
            view.eButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                final BaseDrawer.ListHPFavAdapter._cls1 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$2 = BaseDrawer.ListHPFavAdapter._cls1.this;
                super();
            }
            });
            view.Button("Register", new android.content.DialogInterface.OnClickListener() {

                final BaseDrawer.ListHPFavAdapter._cls1 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(BaseDrawer.ListHPFavAdapter.access$0(this$1).getApplicationContext(), com/inponsel/android/v2/RegisterActivity);
                    BaseDrawer.ListHPFavAdapter.access$0(this$1).startActivityForResult(dialoginterface, 0);
                    BaseDrawer.ListHPFavAdapter.access$0(this$1).overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$2 = BaseDrawer.ListHPFavAdapter._cls1.this;
                super();
            }
            });
            view.eButton("Login", new android.content.DialogInterface.OnClickListener() {

                final BaseDrawer.ListHPFavAdapter._cls1 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(BaseDrawer.ListHPFavAdapter.access$0(this$1).getApplicationContext(), com/inponsel/android/v2/LoginActivity);
                    dialoginterface.putExtra("activity", "main");
                    BaseDrawer.ListHPFavAdapter.access$0(this$1).startActivityForResult(dialoginterface, 0);
                    BaseDrawer.ListHPFavAdapter.access$0(this$1).overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$2 = BaseDrawer.ListHPFavAdapter._cls1.this;
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
