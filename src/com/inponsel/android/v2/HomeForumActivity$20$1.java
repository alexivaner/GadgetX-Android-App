// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.UserFunctions;

// Referenced classes of package com.inponsel.android.v2:
//            HomeForumActivity, RegisterActivity, LoginActivity

class this._cls1
    implements android.content.Listener
{

    final itTask.execute this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        stat = "0";
        (new itTask(_fld0)).execute(new Void[0]);
    }

    l.fav_stat()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/HomeForumActivity$20

/* anonymous class */
    class HomeForumActivity._cls20
        implements android.view.View.OnClickListener
    {

        final HomeForumActivity this$0;
        private final String val$fav_stat;
        private final String val$tl_id;
        private final String val$tl_type;

        public void onClick(View view)
        {
            idkom_pos = tl_id;
            id_type = tl_type;
            if (userFunctions.isUserLoggedIn(HomeForumActivity.this))
            {
                if (db.checkTimelineExist(idkom_pos) || fav_stat.equals("1"))
                {
                    view = new android.app.AlertDialog.Builder(HomeForumActivity.this);
                    if (tl_type.equals("faqhp"))
                    {
                        view.setMessage("Hapus pertanyaan ini dari favorit?");
                    } else
                    {
                        view.setMessage("Hapus artikel ini dari favorit?");
                    }
                    view.setPositiveButton("Ya", new HomeForumActivity._cls20._cls1());
                    view.setNegativeButton("Tidak", new HomeForumActivity._cls20._cls2());
                    view.show();
                    return;
                }
                view = new android.app.AlertDialog.Builder(HomeForumActivity.this);
                if (tl_type.equals("faqhp"))
                {
                    view.setMessage("Favoritkan pertanyaan ini?");
                } else
                {
                    view.setMessage("Favoritkan artikel ini?");
                }
                view.setPositiveButton("Ya", new HomeForumActivity._cls20._cls3());
                view.setNeutralButton("Tidak", new HomeForumActivity._cls20._cls4());
                view.show();
                return;
            } else
            {
                view = new android.app.AlertDialog.Builder(wrapperLight);
                view.setMessage("Untuk menambahkan ke favorit harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new HomeForumActivity._cls20._cls5());
                view.setNeutralButton("Register", new HomeForumActivity._cls20._cls6());
                view.setNegativeButton("Login", new HomeForumActivity._cls20._cls7());
                view.show();
                return;
            }
        }


            
            {
                this$0 = final_homeforumactivity;
                tl_id = s;
                tl_type = s1;
                fav_stat = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/HomeForumActivity$20$2

/* anonymous class */
        class HomeForumActivity._cls20._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final HomeForumActivity._cls20 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = HomeForumActivity._cls20.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/HomeForumActivity$20$3

/* anonymous class */
        class HomeForumActivity._cls20._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final HomeForumActivity._cls20 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                stat = "1";
                (new HomeForumActivity.FavoritTask(this$0)).execute(new Void[0]);
            }

                    
                    {
                        this$1 = HomeForumActivity._cls20.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/HomeForumActivity$20$4

/* anonymous class */
        class HomeForumActivity._cls20._cls4
            implements android.content.DialogInterface.OnClickListener
        {

            final HomeForumActivity._cls20 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = HomeForumActivity._cls20.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/HomeForumActivity$20$5

/* anonymous class */
        class HomeForumActivity._cls20._cls5
            implements android.content.DialogInterface.OnClickListener
        {

            final HomeForumActivity._cls20 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = HomeForumActivity._cls20.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/HomeForumActivity$20$6

/* anonymous class */
        class HomeForumActivity._cls20._cls6
            implements android.content.DialogInterface.OnClickListener
        {

            final HomeForumActivity._cls20 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(this$0, com/inponsel/android/v2/RegisterActivity);
                startActivity(dialoginterface);
            }

                    
                    {
                        this$1 = HomeForumActivity._cls20.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/HomeForumActivity$20$7

/* anonymous class */
        class HomeForumActivity._cls20._cls7
            implements android.content.DialogInterface.OnClickListener
        {

            final HomeForumActivity._cls20 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(this$0, com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                startActivity(dialoginterface);
            }

                    
                    {
                        this$1 = HomeForumActivity._cls20.this;
                        super();
                    }
        }

    }

}
