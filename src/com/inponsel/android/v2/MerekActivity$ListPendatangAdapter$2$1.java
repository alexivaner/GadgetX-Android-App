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

class this._cls2
    implements android.content.ter._cls2._cls1
{

    final NewsTask.execute this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        SubNews = "1";
        (new NewsTask(_fld1)).execute(new Void[0]);
    }

    l.position()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/MerekActivity$ListPendatangAdapter$2

/* anonymous class */
    class MerekActivity.ListPendatangAdapter._cls2
        implements android.view.View.OnClickListener
    {

        final MerekActivity.ListPendatangAdapter this$1;
        private final int val$position;

        public void onClick(View view)
        {
            id_brand = getListModel(position).getId_merk();
            Log.e("substattext", id_brand);
            statSubNews = getListModel(position).getSubs_status();
            brandSubNews = getListModel(position).getMerk();
            if (userFunctions.isUserLoggedIn(MerekActivity.ListPendatangAdapter.access$0(MerekActivity.ListPendatangAdapter.this)))
            {
                view = new android.app.AlertDialog.Builder(MerekActivity.ListPendatangAdapter.access$0(MerekActivity.ListPendatangAdapter.this));
                view.setMessage("Langganan berita merek ini?");
                view.setPositiveButton("Ya", new MerekActivity.ListPendatangAdapter._cls2._cls1());
                view.setNeutralButton("Tidak", new MerekActivity.ListPendatangAdapter._cls2._cls2());
                view.show();
                return;
            } else
            {
                view = new android.app.AlertDialog.Builder(MerekActivity.ListPendatangAdapter.access$0(MerekActivity.ListPendatangAdapter.this));
                view.setMessage("Untuk berlangganan berita, diharuskan login.");
                view.setPositiveButton("Tutup", new MerekActivity.ListPendatangAdapter._cls2._cls3());
                view.setNeutralButton("Register", new MerekActivity.ListPendatangAdapter._cls2._cls4());
                view.setNegativeButton("Login", new MerekActivity.ListPendatangAdapter._cls2._cls5());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_listpendatangadapter;
                position = I.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/MerekActivity$ListPendatangAdapter$2$2

/* anonymous class */
        class MerekActivity.ListPendatangAdapter._cls2._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final MerekActivity.ListPendatangAdapter._cls2 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = MerekActivity.ListPendatangAdapter._cls2.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/MerekActivity$ListPendatangAdapter$2$3

/* anonymous class */
        class MerekActivity.ListPendatangAdapter._cls2._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final MerekActivity.ListPendatangAdapter._cls2 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = MerekActivity.ListPendatangAdapter._cls2.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/MerekActivity$ListPendatangAdapter$2$4

/* anonymous class */
        class MerekActivity.ListPendatangAdapter._cls2._cls4
            implements android.content.DialogInterface.OnClickListener
        {

            final MerekActivity.ListPendatangAdapter._cls2 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(MerekActivity.ListPendatangAdapter.access$0(this$1), com/inponsel/android/v2/RegisterActivity);
                MerekActivity.ListPendatangAdapter.access$1(this$1).startActivityForResult(dialoginterface, 0);
                MerekActivity.ListPendatangAdapter.access$0(this$1).overridePendingTransition(0x7f040003, 0x7f040004);
            }

                    
                    {
                        this$2 = MerekActivity.ListPendatangAdapter._cls2.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/MerekActivity$ListPendatangAdapter$2$5

/* anonymous class */
        class MerekActivity.ListPendatangAdapter._cls2._cls5
            implements android.content.DialogInterface.OnClickListener
        {

            final MerekActivity.ListPendatangAdapter._cls2 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(MerekActivity.ListPendatangAdapter.access$0(this$1), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                MerekActivity.ListPendatangAdapter.access$1(this$1).startActivityForResult(dialoginterface, 0);
                MerekActivity.ListPendatangAdapter.access$0(this$1).overridePendingTransition(0x7f040003, 0x7f040004);
            }

                    
                    {
                        this$2 = MerekActivity.ListPendatangAdapter._cls2.this;
                        super();
                    }
        }

    }

}
