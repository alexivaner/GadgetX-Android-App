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

class this._cls1
    implements android.content.r
{

    final this._cls1 this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/ProfilePonselUserActivity$1

/* anonymous class */
    class ProfilePonselUserActivity._cls1
        implements android.view.View.OnClickListener
    {

        final ProfilePonselUserActivity this$0;

        public void onClick(View view)
        {
            if (userFunctions.isUserLoggedIn(ProfilePonselUserActivity.this))
            {
                if (statSubNews.equals("1"))
                {
                    view = new android.app.AlertDialog.Builder(ProfilePonselUserActivity.this);
                    view.setMessage("Hentikan langganan berita perangkat ini?");
                    view.setPositiveButton("Ya", new ProfilePonselUserActivity._cls1._cls1());
                    view.setNegativeButton("Tidak", new ProfilePonselUserActivity._cls1._cls2());
                    view.show();
                    return;
                } else
                {
                    view = new android.app.AlertDialog.Builder(ProfilePonselUserActivity.this);
                    view.setMessage("Langganan berita perangkat ini?");
                    view.setPositiveButton("Ya", new ProfilePonselUserActivity._cls1._cls3());
                    view.setNeutralButton("Tidak", new ProfilePonselUserActivity._cls1._cls4());
                    view.show();
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(ProfilePonselUserActivity.this);
                view.setMessage("Untuk berlangganan berita, diharuskan login.");
                view.setPositiveButton("Tutup", new ProfilePonselUserActivity._cls1._cls5());
                view.setNeutralButton("Register", new ProfilePonselUserActivity._cls1._cls6());
                view.setNegativeButton("Login", new ProfilePonselUserActivity._cls1._cls7());
                view.show();
                return;
            }
        }


            
            {
                this$0 = ProfilePonselUserActivity.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/ProfilePonselUserActivity$1$1

/* anonymous class */
        class ProfilePonselUserActivity._cls1._cls1
            implements android.content.DialogInterface.OnClickListener
        {

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
        }


        // Unreferenced inner class com/inponsel/android/v2/ProfilePonselUserActivity$1$2

/* anonymous class */
        class ProfilePonselUserActivity._cls1._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final ProfilePonselUserActivity._cls1 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = ProfilePonselUserActivity._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/ProfilePonselUserActivity$1$3

/* anonymous class */
        class ProfilePonselUserActivity._cls1._cls3
            implements android.content.DialogInterface.OnClickListener
        {

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
        }


        // Unreferenced inner class com/inponsel/android/v2/ProfilePonselUserActivity$1$4

/* anonymous class */
        class ProfilePonselUserActivity._cls1._cls4
            implements android.content.DialogInterface.OnClickListener
        {

            final ProfilePonselUserActivity._cls1 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = ProfilePonselUserActivity._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/ProfilePonselUserActivity$1$6

/* anonymous class */
        class ProfilePonselUserActivity._cls1._cls6
            implements android.content.DialogInterface.OnClickListener
        {

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
        }


        // Unreferenced inner class com/inponsel/android/v2/ProfilePonselUserActivity$1$7

/* anonymous class */
        class ProfilePonselUserActivity._cls1._cls7
            implements android.content.DialogInterface.OnClickListener
        {

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
        }

    }

}
