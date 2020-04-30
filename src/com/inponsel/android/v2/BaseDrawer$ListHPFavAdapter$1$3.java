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

class this._cls2
    implements android.content.ter._cls1._cls3
{

    final this._cls2 this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }

    l.position()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/BaseDrawer$ListHPFavAdapter$1

/* anonymous class */
    class BaseDrawer.ListHPFavAdapter._cls1
        implements android.view.View.OnClickListener
    {

        final BaseDrawer.ListHPFavAdapter this$1;
        private final int val$position;

        public void onClick(View view)
        {
            if (userFunctions.isUserLoggedIn(BaseDrawer.ListHPFavAdapter.access$0(BaseDrawer.ListHPFavAdapter.this).getApplicationContext()))
            {
                view = new android.app.AlertDialog.Builder(BaseDrawer.ListHPFavAdapter.access$0(BaseDrawer.ListHPFavAdapter.this).getApplicationContext());
                view.setMessage("Hentikan langganan forum perangkat ini?");
                view.setPositiveButton("Ya", new BaseDrawer.ListHPFavAdapter._cls1._cls1());
                view.setNegativeButton("Tidak", new BaseDrawer.ListHPFavAdapter._cls1._cls2());
                view.show();
                return;
            } else
            {
                view = new android.app.AlertDialog.Builder(BaseDrawer.ListHPFavAdapter.access$0(BaseDrawer.ListHPFavAdapter.this).getApplicationContext());
                view.setMessage("Untuk berlangganan forum, diharuskan login.");
                view.setPositiveButton("Tutup", new BaseDrawer.ListHPFavAdapter._cls1._cls3());
                view.setNeutralButton("Register", new BaseDrawer.ListHPFavAdapter._cls1._cls4());
                view.setNegativeButton("Login", new BaseDrawer.ListHPFavAdapter._cls1._cls5());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_listhpfavadapter;
                position = I.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/BaseDrawer$ListHPFavAdapter$1$1

/* anonymous class */
        class BaseDrawer.ListHPFavAdapter._cls1._cls1
            implements android.content.DialogInterface.OnClickListener
        {

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
        }


        // Unreferenced inner class com/inponsel/android/v2/BaseDrawer$ListHPFavAdapter$1$2

/* anonymous class */
        class BaseDrawer.ListHPFavAdapter._cls1._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final BaseDrawer.ListHPFavAdapter._cls1 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = BaseDrawer.ListHPFavAdapter._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/BaseDrawer$ListHPFavAdapter$1$4

/* anonymous class */
        class BaseDrawer.ListHPFavAdapter._cls1._cls4
            implements android.content.DialogInterface.OnClickListener
        {

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
        }


        // Unreferenced inner class com/inponsel/android/v2/BaseDrawer$ListHPFavAdapter$1$5

/* anonymous class */
        class BaseDrawer.ListHPFavAdapter._cls1._cls5
            implements android.content.DialogInterface.OnClickListener
        {

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
        }

    }

}
