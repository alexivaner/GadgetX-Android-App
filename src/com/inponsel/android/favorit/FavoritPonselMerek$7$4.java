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
//            FavoritPonselMerek

class this._cls1
    implements android.content.Listener
{

    final this._cls1 this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }

    l.txt_fav_news_1()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/favorit/FavoritPonselMerek$7

/* anonymous class */
    class FavoritPonselMerek._cls7
        implements android.view.View.OnClickListener
    {

        final FavoritPonselMerek this$0;
        private final String val$id_rss;
        private final String val$rss_srclink;
        private final TextView val$txt_fav_news_1;

        public void onClick(View view)
        {
            idrss_pos = id_rss;
            str_srclink = rss_srclink;
            if (userFunctions.isUserLoggedIn(FavoritPonselMerek.this))
            {
                if (txt_fav_news_1.getText().toString().equals("1"))
                {
                    view = new android.app.AlertDialog.Builder(FavoritPonselMerek.this);
                    view.setMessage("Hapus berita ini dari favorit?");
                    view.setPositiveButton("Ya", new FavoritPonselMerek._cls7._cls1());
                    view.setNegativeButton("Tidak", new FavoritPonselMerek._cls7._cls2());
                    view.show();
                    return;
                } else
                {
                    view = new android.app.AlertDialog.Builder(FavoritPonselMerek.this);
                    view.setMessage("Favoritkan berita ini?");
                    view.setPositiveButton("Ya", new FavoritPonselMerek._cls7._cls3());
                    view.setNeutralButton("Tidak", new FavoritPonselMerek._cls7._cls4());
                    view.show();
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(wrapperLight);
                view.setMessage("Untuk menambahkan ke favorit harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new FavoritPonselMerek._cls7._cls5());
                view.setNeutralButton("Register", new FavoritPonselMerek._cls7._cls6());
                view.setNegativeButton("Login", new FavoritPonselMerek._cls7._cls7());
                view.show();
                return;
            }
        }


            
            {
                this$0 = final_favoritponselmerek;
                id_rss = s;
                rss_srclink = s1;
                txt_fav_news_1 = TextView.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/favorit/FavoritPonselMerek$7$1

/* anonymous class */
        class FavoritPonselMerek._cls7._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final FavoritPonselMerek._cls7 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
                stat = "0";
                if (netInfo != null && netInfo.isConnected())
                {
                    (new FavoritPonselMerek.RemFavoritRSSTask(this$0)).execute(new Void[0]);
                    return;
                } else
                {
                    Toast.makeText(this$0, "Tidak ada koneksi internet", 1).show();
                    return;
                }
            }

                    
                    {
                        this$1 = FavoritPonselMerek._cls7.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/favorit/FavoritPonselMerek$7$2

/* anonymous class */
        class FavoritPonselMerek._cls7._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final FavoritPonselMerek._cls7 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = FavoritPonselMerek._cls7.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/favorit/FavoritPonselMerek$7$3

/* anonymous class */
        class FavoritPonselMerek._cls7._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final FavoritPonselMerek._cls7 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                stat = "1";
                (new FavoritPonselMerek.FavoritRSSTask(this$0, null)).execute(new String[0]);
            }

                    
                    {
                        this$1 = FavoritPonselMerek._cls7.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/favorit/FavoritPonselMerek$7$5

/* anonymous class */
        class FavoritPonselMerek._cls7._cls5
            implements android.content.DialogInterface.OnClickListener
        {

            final FavoritPonselMerek._cls7 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = FavoritPonselMerek._cls7.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/favorit/FavoritPonselMerek$7$6

/* anonymous class */
        class FavoritPonselMerek._cls7._cls6
            implements android.content.DialogInterface.OnClickListener
        {

            final FavoritPonselMerek._cls7 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(this$0, com/inponsel/android/v2/RegisterActivity);
                startActivity(dialoginterface);
            }

                    
                    {
                        this$1 = FavoritPonselMerek._cls7.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/favorit/FavoritPonselMerek$7$7

/* anonymous class */
        class FavoritPonselMerek._cls7._cls7
            implements android.content.DialogInterface.OnClickListener
        {

            final FavoritPonselMerek._cls7 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(this$0, com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                startActivity(dialoginterface);
            }

                    
                    {
                        this$1 = FavoritPonselMerek._cls7.this;
                        super();
                    }
        }

    }

}
