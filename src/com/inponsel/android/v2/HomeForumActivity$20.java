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

class val.fav_stat
    implements android.view.ctivity._cls20
{

    final HomeForumActivity this$0;
    private final String val$fav_stat;
    private final String val$tl_id;
    private final String val$tl_type;

    public void onClick(View view)
    {
        idkom_pos = val$tl_id;
        id_type = val$tl_type;
        if (userFunctions.isUserLoggedIn(HomeForumActivity.this))
        {
            if (db.checkTimelineExist(idkom_pos) || val$fav_stat.equals("1"))
            {
                view = new android.app.init>(HomeForumActivity.this);
                if (val$tl_type.equals("faqhp"))
                {
                    view.etMessage("Hapus pertanyaan ini dari favorit?");
                } else
                {
                    view.etMessage("Hapus artikel ini dari favorit?");
                }
                view.etPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                    final HomeForumActivity._cls20 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface.dismiss();
                        stat = "0";
                        (new HomeForumActivity.FavoritTask(this$0)).execute(new Void[0]);
                    }

            
            {
                this$1 = HomeForumActivity._cls20.this;
                super();
            }
                });
                view.etNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                    final HomeForumActivity._cls20 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface.dismiss();
                    }

            
            {
                this$1 = HomeForumActivity._cls20.this;
                super();
            }
                });
                view.how();
                return;
            }
            view = new android.app.init>(HomeForumActivity.this);
            if (val$tl_type.equals("faqhp"))
            {
                view.etMessage("Favoritkan pertanyaan ini?");
            } else
            {
                view.etMessage("Favoritkan artikel ini?");
            }
            view.etPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

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
            });
            view.etNeutralButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                final HomeForumActivity._cls20 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$1 = HomeForumActivity._cls20.this;
                super();
            }
            });
            view.how();
            return;
        } else
        {
            view = new android.app.init>(wrapperLight);
            view.etMessage("Untuk menambahkan ke favorit harus login terlebih dahulu.");
            view.etPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                final HomeForumActivity._cls20 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$1 = HomeForumActivity._cls20.this;
                super();
            }
            });
            view.etNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

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
            });
            view.etNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

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
            });
            view.how();
            return;
        }
    }


    _cls7.this._cls1()
    {
        this$0 = final_homeforumactivity;
        val$tl_id = s;
        val$tl_type = s1;
        val$fav_stat = String.this;
        super();
    }
}
