// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.timelinedetail;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;

// Referenced classes of package com.inponsel.android.timelinedetail:
//            Hal1TLDetailActivity

class this._cls0
    implements android.view.Hal1TLDetailActivity._cls7
{

    final Hal1TLDetailActivity this$0;

    public void onClick(View view)
    {
        if (userFunctions.isUserLoggedIn(Hal1TLDetailActivity.this))
        {
            if (db.checkTimelineExist(id_artikel) || fav_stat.equals("1"))
            {
                view = new android.app.it>(Hal1TLDetailActivity.this);
                if (tl_type.equals("faqhp"))
                {
                    view.Message("Hapus pertanyaan ini dari favorit?");
                } else
                {
                    view.Message("Hapus artikel ini dari favorit?");
                }
                view.PositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                    final Hal1TLDetailActivity._cls7 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface.dismiss();
                        statFav = "0";
                        (new Hal1TLDetailActivity.FavoritTask(this$0)).execute(new Void[0]);
                    }

            
            {
                this$1 = Hal1TLDetailActivity._cls7.this;
                super();
            }
                });
                view.NegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                    final Hal1TLDetailActivity._cls7 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface.dismiss();
                    }

            
            {
                this$1 = Hal1TLDetailActivity._cls7.this;
                super();
            }
                });
                view.w();
                return;
            }
            view = new android.app.it>(Hal1TLDetailActivity.this);
            if (tl_type.equals("faqhp"))
            {
                view.Message("Favoritkan pertanyaan ini?");
            } else
            {
                view.Message("Favoritkan artikel ini?");
            }
            view.PositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                final Hal1TLDetailActivity._cls7 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    statFav = "1";
                    (new Hal1TLDetailActivity.FavoritTask(this$0)).execute(new Void[0]);
                }

            
            {
                this$1 = Hal1TLDetailActivity._cls7.this;
                super();
            }
            });
            view.NeutralButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                final Hal1TLDetailActivity._cls7 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$1 = Hal1TLDetailActivity._cls7.this;
                super();
            }
            });
            view.w();
            return;
        } else
        {
            view = new android.app.it>(Hal1TLDetailActivity.this);
            view.Message("Untuk menambahkan ke favorit harus login terlebih dahulu.");
            view.PositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                final Hal1TLDetailActivity._cls7 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$1 = Hal1TLDetailActivity._cls7.this;
                super();
            }
            });
            view.NeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                final Hal1TLDetailActivity._cls7 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(this$0, com/inponsel/android/v2/RegisterActivity);
                    startActivity(dialoginterface);
                }

            
            {
                this$1 = Hal1TLDetailActivity._cls7.this;
                super();
            }
            });
            view.NegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                final Hal1TLDetailActivity._cls7 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(this$0, com/inponsel/android/v2/LoginActivity);
                    dialoginterface.putExtra("activity", "main");
                    startActivity(dialoginterface);
                }

            
            {
                this$1 = Hal1TLDetailActivity._cls7.this;
                super();
            }
            });
            view.w();
            return;
        }
    }


    _cls7.this._cls1()
    {
        this$0 = Hal1TLDetailActivity.this;
        super();
    }
}
