// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.globalforum;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;

// Referenced classes of package com.inponsel.android.globalforum:
//            ForumGlobalActivity

class val.fav_stat
    implements android.view.umGlobalActivity._cls36
{

    final ForumGlobalActivity this$0;
    private final String val$fav_stat;
    private final String val$tl_id;
    private final String val$tl_type;

    public void onClick(View view)
    {
        idkom_pos = val$tl_id;
        id_type = val$tl_type;
        if (userFunctions.isUserLoggedIn(ForumGlobalActivity.this))
        {
            if (db.checkTimelineExist(idkom_pos) || val$fav_stat.equals("1"))
            {
                view = new android.app.it>(ForumGlobalActivity.this);
                if (val$tl_type.equals("faqhp"))
                {
                    view.Message("Hapus pertanyaan ini dari favorit?");
                } else
                {
                    view.Message("Hapus artikel ini dari favorit?");
                }
                view.PositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                    final ForumGlobalActivity._cls36 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface.dismiss();
                        stat = "0";
                        (new ForumGlobalActivity.FavoritTask(this$0)).execute(new Void[0]);
                    }

            
            {
                this$1 = ForumGlobalActivity._cls36.this;
                super();
            }
                });
                view.NegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                    final ForumGlobalActivity._cls36 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface.dismiss();
                    }

            
            {
                this$1 = ForumGlobalActivity._cls36.this;
                super();
            }
                });
                view.w();
                return;
            }
            view = new android.app.it>(ForumGlobalActivity.this);
            if (val$tl_type.equals("faqhp"))
            {
                view.Message("Favoritkan pertanyaan ini?");
            } else
            {
                view.Message("Favoritkan artikel ini?");
            }
            view.PositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                final ForumGlobalActivity._cls36 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    stat = "1";
                    (new ForumGlobalActivity.FavoritTask(this$0)).execute(new Void[0]);
                }

            
            {
                this$1 = ForumGlobalActivity._cls36.this;
                super();
            }
            });
            view.NeutralButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                final ForumGlobalActivity._cls36 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$1 = ForumGlobalActivity._cls36.this;
                super();
            }
            });
            view.w();
            return;
        } else
        {
            view = new android.app.it>(wrapperLight);
            view.Message("Untuk menambahkan ke favorit harus login terlebih dahulu.");
            view.PositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                final ForumGlobalActivity._cls36 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$1 = ForumGlobalActivity._cls36.this;
                super();
            }
            });
            view.NeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                final ForumGlobalActivity._cls36 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(this$0, com/inponsel/android/v2/RegisterActivity);
                    startActivity(dialoginterface);
                }

            
            {
                this$1 = ForumGlobalActivity._cls36.this;
                super();
            }
            });
            view.NegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                final ForumGlobalActivity._cls36 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(this$0, com/inponsel/android/v2/LoginActivity);
                    dialoginterface.putExtra("activity", "main");
                    startActivity(dialoginterface);
                }

            
            {
                this$1 = ForumGlobalActivity._cls36.this;
                super();
            }
            });
            view.w();
            return;
        }
    }


    _cls7.this._cls1()
    {
        this$0 = final_forumglobalactivity;
        val$tl_id = s;
        val$tl_type = s1;
        val$fav_stat = String.this;
        super();
    }
}
