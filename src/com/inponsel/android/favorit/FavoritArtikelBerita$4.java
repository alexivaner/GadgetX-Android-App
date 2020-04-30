// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.favorit;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.NetworkInfo;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;

// Referenced classes of package com.inponsel.android.favorit:
//            FavoritArtikelBerita

class val.txt_fav_news_1
    implements android.view.ArtikelBerita._cls4
{

    final FavoritArtikelBerita this$0;
    private final String val$id_rss;
    private final String val$rss_srclink;
    private final TextView val$txt_fav_news_1;

    public void onClick(View view)
    {
        idrss_pos = val$id_rss;
        str_srclink = val$rss_srclink;
        if (userFunctions.isUserLoggedIn(FavoritArtikelBerita.this))
        {
            if (val$txt_fav_news_1.getText().toString().equals("1"))
            {
                view = new android.app.it>(FavoritArtikelBerita.this);
                view.Message("Hapus berita ini dari favorit?");
                view.PositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                    final FavoritArtikelBerita._cls4 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface.dismiss();
                        stat = "0";
                        if (netInfo != null && netInfo.isConnected())
                        {
                            (new FavoritArtikelBerita.RemFavoritRSSTask(this$0)).execute(new Void[0]);
                            return;
                        } else
                        {
                            Toast.makeText(this$0, "Tidak ada koneksi internet", 1).show();
                            return;
                        }
                    }

            
            {
                this$1 = FavoritArtikelBerita._cls4.this;
                super();
            }
                });
                view.NegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                    final FavoritArtikelBerita._cls4 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface.dismiss();
                    }

            
            {
                this$1 = FavoritArtikelBerita._cls4.this;
                super();
            }
                });
                view.w();
                return;
            } else
            {
                view = new android.app.it>(FavoritArtikelBerita.this);
                view.Message("Favoritkan berita ini?");
                view.PositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                    final FavoritArtikelBerita._cls4 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        stat = "1";
                        (new FavoritArtikelBerita.FavoritRSSTask(this$0, null)).execute(new String[0]);
                    }

            
            {
                this$1 = FavoritArtikelBerita._cls4.this;
                super();
            }
                });
                view.NeutralButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                    final FavoritArtikelBerita._cls4 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface.dismiss();
                    }

            
            {
                this$1 = FavoritArtikelBerita._cls4.this;
                super();
            }
                });
                view.w();
                return;
            }
        } else
        {
            view = new android.app.it>(wrapperLight);
            view.Message("Untuk menambahkan ke favorit harus login terlebih dahulu.");
            view.PositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                final FavoritArtikelBerita._cls4 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$1 = FavoritArtikelBerita._cls4.this;
                super();
            }
            });
            view.NeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                final FavoritArtikelBerita._cls4 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(this$0, com/inponsel/android/v2/RegisterActivity);
                    startActivity(dialoginterface);
                }

            
            {
                this$1 = FavoritArtikelBerita._cls4.this;
                super();
            }
            });
            view.NegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                final FavoritArtikelBerita._cls4 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(this$0, com/inponsel/android/v2/LoginActivity);
                    dialoginterface.putExtra("activity", "main");
                    startActivity(dialoginterface);
                }

            
            {
                this$1 = FavoritArtikelBerita._cls4.this;
                super();
            }
            });
            view.w();
            return;
        }
    }


    _cls7.this._cls1()
    {
        this$0 = final_favoritartikelberita;
        val$id_rss = s;
        val$rss_srclink = s1;
        val$txt_fav_news_1 = TextView.this;
        super();
    }
}
