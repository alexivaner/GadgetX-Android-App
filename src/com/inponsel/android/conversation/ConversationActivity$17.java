// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.conversation;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;

// Referenced classes of package com.inponsel.android.conversation:
//            ConversationActivity

class val.fav_stat
    implements android.view.versationActivity._cls17
{

    final ConversationActivity this$0;
    private final String val$fav_stat;
    private final String val$tl_id;
    private final String val$tl_type;

    public void onClick(View view)
    {
        idkom_pos = val$tl_id;
        id_type = val$tl_type;
        if (userFunctions.isUserLoggedIn(ConversationActivity.this))
        {
            if (db.checkTimelineExist(idkom_pos) || val$fav_stat.equals("1"))
            {
                view = new android.app.t>(ConversationActivity.this);
                if (val$tl_type.equals("faqhp"))
                {
                    view.essage("Hapus pertanyaan ini dari favorit?");
                } else
                {
                    view.essage("Hapus artikel ini dari favorit?");
                }
                view.ositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                    final ConversationActivity._cls17 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface.dismiss();
                        stat = "0";
                        (new ConversationActivity.FavoritTask(this$0)).execute(new Void[0]);
                    }

            
            {
                this$1 = ConversationActivity._cls17.this;
                super();
            }
                });
                view.egativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                    final ConversationActivity._cls17 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface.dismiss();
                    }

            
            {
                this$1 = ConversationActivity._cls17.this;
                super();
            }
                });
                view.();
                return;
            }
            view = new android.app.t>(ConversationActivity.this);
            if (val$tl_type.equals("faqhp"))
            {
                view.essage("Favoritkan pertanyaan ini?");
            } else
            {
                view.essage("Favoritkan artikel ini?");
            }
            view.ositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                final ConversationActivity._cls17 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    stat = "1";
                    (new ConversationActivity.FavoritTask(this$0)).execute(new Void[0]);
                }

            
            {
                this$1 = ConversationActivity._cls17.this;
                super();
            }
            });
            view.eutralButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                final ConversationActivity._cls17 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$1 = ConversationActivity._cls17.this;
                super();
            }
            });
            view.();
            return;
        } else
        {
            view = new android.app.t>(wrapperLight);
            view.essage("Untuk menambahkan ke favorit harus login terlebih dahulu.");
            view.ositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                final ConversationActivity._cls17 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$1 = ConversationActivity._cls17.this;
                super();
            }
            });
            view.eutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                final ConversationActivity._cls17 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(this$0, com/inponsel/android/v2/RegisterActivity);
                    startActivity(dialoginterface);
                }

            
            {
                this$1 = ConversationActivity._cls17.this;
                super();
            }
            });
            view.egativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                final ConversationActivity._cls17 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(this$0, com/inponsel/android/v2/LoginActivity);
                    dialoginterface.putExtra("activity", "main");
                    startActivity(dialoginterface);
                }

            
            {
                this$1 = ConversationActivity._cls17.this;
                super();
            }
            });
            view.();
            return;
        }
    }


    _cls7.this._cls1()
    {
        this$0 = final_conversationactivity;
        val$tl_id = s;
        val$tl_type = s1;
        val$fav_stat = String.this;
        super();
    }
}
