// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import com.inponsel.android.utils.UserFunctions;

// Referenced classes of package com.inponsel.android.v2:
//            ProfilePonselUserActivity, RegisterActivity, LoginActivity

class this._cls0
    implements android.view.Activity._cls1
{

    final ProfilePonselUserActivity this$0;

    public void onClick(View view)
    {
        if (userFunctions.isUserLoggedIn(ProfilePonselUserActivity.this))
        {
            if (statSubNews.equals("1"))
            {
                view = new android.app.rActivity.statSubNews(ProfilePonselUserActivity.this);
                view.ge("Hentikan langganan berita perangkat ini?");
                view.iveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                    final ProfilePonselUserActivity._cls1 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface.dismiss();
                        statSubNews = "0";
                        (new ProfilePonselUserActivity.SubsNewsTask(this$0)).execute(new Void[0]);
                    }

            
            {
                this$1 = ProfilePonselUserActivity._cls1.this;
                super();
            }
                });
                view.iveButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                    final ProfilePonselUserActivity._cls1 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface.dismiss();
                    }

            
            {
                this$1 = ProfilePonselUserActivity._cls1.this;
                super();
            }
                });
                view._mth1();
                return;
            } else
            {
                view = new android.app.rActivity._cls1(ProfilePonselUserActivity.this);
                view.ge("Langganan berita perangkat ini?");
                view.iveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                    final ProfilePonselUserActivity._cls1 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        statSubNews = "1";
                        (new ProfilePonselUserActivity.SubsNewsTask(this$0)).execute(new Void[0]);
                    }

            
            {
                this$1 = ProfilePonselUserActivity._cls1.this;
                super();
            }
                });
                view.alButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                    final ProfilePonselUserActivity._cls1 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface.dismiss();
                    }

            
            {
                this$1 = ProfilePonselUserActivity._cls1.this;
                super();
            }
                });
                view._mth1();
                return;
            }
        } else
        {
            view = new android.app.rActivity._cls1(ProfilePonselUserActivity.this);
            view.ge("Untuk berlangganan berita, diharuskan login.");
            view.iveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                final ProfilePonselUserActivity._cls1 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$1 = ProfilePonselUserActivity._cls1.this;
                super();
            }
            });
            view.alButton("Register", new android.content.DialogInterface.OnClickListener() {

                final ProfilePonselUserActivity._cls1 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(this$0, com/inponsel/android/v2/RegisterActivity);
                    startActivityForResult(dialoginterface, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$1 = ProfilePonselUserActivity._cls1.this;
                super();
            }
            });
            view.iveButton("Login", new android.content.DialogInterface.OnClickListener() {

                final ProfilePonselUserActivity._cls1 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(this$0, com/inponsel/android/v2/LoginActivity);
                    dialoginterface.putExtra("activity", "main");
                    startActivityForResult(dialoginterface, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$1 = ProfilePonselUserActivity._cls1.this;
                super();
            }
            });
            view._mth1();
            return;
        }
    }


    _cls7.this._cls1()
    {
        this$0 = ProfilePonselUserActivity.this;
        super();
    }
}
