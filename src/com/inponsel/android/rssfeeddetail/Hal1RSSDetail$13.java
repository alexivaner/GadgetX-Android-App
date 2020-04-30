// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.rssfeeddetail;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;

// Referenced classes of package com.inponsel.android.rssfeeddetail:
//            Hal1RSSDetail

class this._cls0
    implements android.view.ner
{

    final Hal1RSSDetail this$0;

    public void onClick(View view)
    {
        idkom_pos = id_rss;
        str_srclink = rss_srclink;
        if (userFunctions.isUserLoggedIn(getActivity()))
        {
            if (db.checkIfExistRSS(idkom_pos) || fav_stat.equals("1"))
            {
                view = new android.app.er(getActivity());
                view.setMessage("Hapus berita ini dari favorit?");
                view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                    final Hal1RSSDetail._cls13 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface.dismiss();
                        statFav = "0";
                        (new Hal1RSSDetail.FavoritTask(this$0)).execute(new Void[0]);
                    }

            
            {
                this$1 = Hal1RSSDetail._cls13.this;
                super();
            }
                });
                view.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                    final Hal1RSSDetail._cls13 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface.dismiss();
                    }

            
            {
                this$1 = Hal1RSSDetail._cls13.this;
                super();
            }
                });
                view.show();
                return;
            } else
            {
                view = new android.app.er(getActivity());
                view.setMessage("Favoritkan berita ini?");
                view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                    final Hal1RSSDetail._cls13 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        statFav = "1";
                        (new Hal1RSSDetail.FavoritTask(this$0)).execute(new Void[0]);
                    }

            
            {
                this$1 = Hal1RSSDetail._cls13.this;
                super();
            }
                });
                view.setNeutralButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                    final Hal1RSSDetail._cls13 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface.dismiss();
                    }

            
            {
                this$1 = Hal1RSSDetail._cls13.this;
                super();
            }
                });
                view.show();
                return;
            }
        } else
        {
            view = new android.app.er(getActivity());
            view.setMessage("Untuk menambahkan ke favorit harus login terlebih dahulu.");
            view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                final Hal1RSSDetail._cls13 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$1 = Hal1RSSDetail._cls13.this;
                super();
            }
            });
            view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                final Hal1RSSDetail._cls13 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                    startActivity(dialoginterface);
                }

            
            {
                this$1 = Hal1RSSDetail._cls13.this;
                super();
            }
            });
            view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                final Hal1RSSDetail._cls13 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                    dialoginterface.putExtra("activity", "main");
                    startActivity(dialoginterface);
                }

            
            {
                this$1 = Hal1RSSDetail._cls13.this;
                super();
            }
            });
            view.show();
            return;
        }
    }


    _cls7.this._cls1()
    {
        this$0 = Hal1RSSDetail.this;
        super();
    }
}
