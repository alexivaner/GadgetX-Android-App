// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.tlforum;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;

// Referenced classes of package com.inponsel.android.tlforum:
//            ForumHPActivity

class this._cls1
    implements android.content.ickListener
{

    final NewsTask.execute this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        statSubNews = "0";
        (new NewsTask(_fld0)).execute(new Void[0]);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/tlforum/ForumHPActivity$8

/* anonymous class */
    class ForumHPActivity._cls8
        implements android.view.View.OnClickListener
    {

        final ForumHPActivity this$0;

        public void onClick(View view)
        {
            if (userFunctions.isUserLoggedIn(ForumHPActivity.this))
            {
                if (statSubNews.equals("1"))
                {
                    view = new android.app.AlertDialog.Builder(ForumHPActivity.this);
                    view.setMessage("Hentikan langganan forum perangkat ini?");
                    view.setPositiveButton("Ya", new ForumHPActivity._cls8._cls1());
                    view.setNegativeButton("Tidak", new ForumHPActivity._cls8._cls2());
                    view.show();
                    return;
                } else
                {
                    view = new android.app.AlertDialog.Builder(ForumHPActivity.this);
                    view.setMessage("Langganan forum perangkat ini?");
                    view.setPositiveButton("Ya", new ForumHPActivity._cls8._cls3());
                    view.setNeutralButton("Tidak", new ForumHPActivity._cls8._cls4());
                    view.show();
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(ForumHPActivity.this);
                view.setMessage("Untuk berlangganan forum, diharuskan login.");
                view.setPositiveButton("Tutup", new ForumHPActivity._cls8._cls5());
                view.setNeutralButton("Register", new ForumHPActivity._cls8._cls6());
                view.setNegativeButton("Login", new ForumHPActivity._cls8._cls7());
                view.show();
                return;
            }
        }


            
            {
                this$0 = ForumHPActivity.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/tlforum/ForumHPActivity$8$2

/* anonymous class */
        class ForumHPActivity._cls8._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final ForumHPActivity._cls8 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = ForumHPActivity._cls8.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/tlforum/ForumHPActivity$8$3

/* anonymous class */
        class ForumHPActivity._cls8._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final ForumHPActivity._cls8 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                statSubNews = "1";
                (new ForumHPActivity.SubsNewsTask(this$0)).execute(new Void[0]);
            }

                    
                    {
                        this$1 = ForumHPActivity._cls8.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/tlforum/ForumHPActivity$8$4

/* anonymous class */
        class ForumHPActivity._cls8._cls4
            implements android.content.DialogInterface.OnClickListener
        {

            final ForumHPActivity._cls8 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = ForumHPActivity._cls8.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/tlforum/ForumHPActivity$8$5

/* anonymous class */
        class ForumHPActivity._cls8._cls5
            implements android.content.DialogInterface.OnClickListener
        {

            final ForumHPActivity._cls8 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = ForumHPActivity._cls8.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/tlforum/ForumHPActivity$8$6

/* anonymous class */
        class ForumHPActivity._cls8._cls6
            implements android.content.DialogInterface.OnClickListener
        {

            final ForumHPActivity._cls8 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(this$0, com/inponsel/android/v2/RegisterActivity);
                startActivityForResult(dialoginterface, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

                    
                    {
                        this$1 = ForumHPActivity._cls8.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/tlforum/ForumHPActivity$8$7

/* anonymous class */
        class ForumHPActivity._cls8._cls7
            implements android.content.DialogInterface.OnClickListener
        {

            final ForumHPActivity._cls8 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(this$0, com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                startActivityForResult(dialoginterface, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

                    
                    {
                        this$1 = ForumHPActivity._cls8.this;
                        super();
                    }
        }

    }

}
