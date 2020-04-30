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

class this._cls0
    implements android.view.er
{

    final ForumHPActivity this$0;

    public void onClick(View view)
    {
        if (userFunctions.isUserLoggedIn(ForumHPActivity.this))
        {
            if (statSubNews.equals("1"))
            {
                view = new android.app.r(ForumHPActivity.this);
                view.setMessage("Hentikan langganan forum perangkat ini?");
                view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                    final ForumHPActivity._cls8 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface.dismiss();
                        statSubNews = "0";
                        (new ForumHPActivity.SubsNewsTask(this$0)).execute(new Void[0]);
                    }

            
            {
                this$1 = ForumHPActivity._cls8.this;
                super();
            }
                });
                view.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                    final ForumHPActivity._cls8 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface.dismiss();
                    }

            
            {
                this$1 = ForumHPActivity._cls8.this;
                super();
            }
                });
                view.show();
                return;
            } else
            {
                view = new android.app.r(ForumHPActivity.this);
                view.setMessage("Langganan forum perangkat ini?");
                view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

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
                });
                view.setNeutralButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                    final ForumHPActivity._cls8 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface.dismiss();
                    }

            
            {
                this$1 = ForumHPActivity._cls8.this;
                super();
            }
                });
                view.show();
                return;
            }
        } else
        {
            view = new android.app.r(ForumHPActivity.this);
            view.setMessage("Untuk berlangganan forum, diharuskan login.");
            view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                final ForumHPActivity._cls8 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$1 = ForumHPActivity._cls8.this;
                super();
            }
            });
            view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

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
            });
            view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

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
            });
            view.show();
            return;
        }
    }


    _cls7.this._cls1()
    {
        this$0 = ForumHPActivity.this;
        super();
    }
}
