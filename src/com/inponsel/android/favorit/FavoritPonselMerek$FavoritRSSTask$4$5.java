// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.favorit;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;

// Referenced classes of package com.inponsel.android.favorit:
//            FavoritPonselMerek

class this._cls2
    implements android.content.tRSSTask._cls4._cls5
{

    final this._cls2 this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }

    l.txt_fav_news_1()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/favorit/FavoritPonselMerek$FavoritRSSTask$4

/* anonymous class */
    class FavoritPonselMerek.FavoritRSSTask._cls4
        implements android.view.View.OnClickListener
    {

        final FavoritPonselMerek.FavoritRSSTask this$1;
        private final String val$id_rss;
        private final String val$rss_srclink;
        private final TextView val$txt_fav_news_1;

        public void onClick(View view)
        {
            FavoritPonselMerek.FavoritRSSTask.access$3(FavoritPonselMerek.FavoritRSSTask.this).idrss_pos = id_rss;
            FavoritPonselMerek.FavoritRSSTask.access$3(FavoritPonselMerek.FavoritRSSTask.this).str_srclink = rss_srclink;
            if (FavoritPonselMerek.FavoritRSSTask.access$3(FavoritPonselMerek.FavoritRSSTask.this).userFunctions.isUserLoggedIn(FavoritPonselMerek.FavoritRSSTask.access$3(FavoritPonselMerek.FavoritRSSTask.this)))
            {
                if (txt_fav_news_1.getText().toString().equals("1"))
                {
                    view = new android.app.AlertDialog.Builder(FavoritPonselMerek.FavoritRSSTask.access$3(FavoritPonselMerek.FavoritRSSTask.this));
                    view.setMessage("Hapus berita ini dari favorit?");
                    view.setPositiveButton("Ya", new FavoritPonselMerek.FavoritRSSTask._cls4._cls1());
                    view.setNegativeButton("Tidak", new FavoritPonselMerek.FavoritRSSTask._cls4._cls2());
                    view.show();
                    return;
                } else
                {
                    view = new android.app.AlertDialog.Builder(FavoritPonselMerek.FavoritRSSTask.access$3(FavoritPonselMerek.FavoritRSSTask.this));
                    view.setMessage("Favoritkan berita ini?");
                    view.setPositiveButton("Ya", new FavoritPonselMerek.FavoritRSSTask._cls4._cls3());
                    view.setNeutralButton("Tidak", new FavoritPonselMerek.FavoritRSSTask._cls4._cls4());
                    view.show();
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(FavoritPonselMerek.FavoritRSSTask.access$3(FavoritPonselMerek.FavoritRSSTask.this).wrapperLight);
                view.setMessage("Untuk menambahkan ke favorit harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new FavoritPonselMerek.FavoritRSSTask._cls4._cls5());
                view.setNeutralButton("Register", new FavoritPonselMerek.FavoritRSSTask._cls4._cls6());
                view.setNegativeButton("Login", new FavoritPonselMerek.FavoritRSSTask._cls4._cls7());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_favoritrsstask;
                id_rss = s;
                rss_srclink = s1;
                txt_fav_news_1 = TextView.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/favorit/FavoritPonselMerek$FavoritRSSTask$4$1

/* anonymous class */
        class FavoritPonselMerek.FavoritRSSTask._cls4._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final FavoritPonselMerek.FavoritRSSTask._cls4 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
                FavoritPonselMerek.FavoritRSSTask.access$3(this$1).stat = "0";
                (new FavoritPonselMerek.RemFavoritRSSTask(FavoritPonselMerek.FavoritRSSTask.access$3(this$1))).execute(new Void[0]);
            }

                    
                    {
                        this$2 = FavoritPonselMerek.FavoritRSSTask._cls4.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/favorit/FavoritPonselMerek$FavoritRSSTask$4$2

/* anonymous class */
        class FavoritPonselMerek.FavoritRSSTask._cls4._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final FavoritPonselMerek.FavoritRSSTask._cls4 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = FavoritPonselMerek.FavoritRSSTask._cls4.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/favorit/FavoritPonselMerek$FavoritRSSTask$4$3

/* anonymous class */
        class FavoritPonselMerek.FavoritRSSTask._cls4._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final FavoritPonselMerek.FavoritRSSTask._cls4 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                FavoritPonselMerek.FavoritRSSTask.access$3(this$1).stat = "1";
                (new FavoritPonselMerek.FavoritRSSTask(FavoritPonselMerek.FavoritRSSTask.access$3(this$1), null)).execute(new String[0]);
            }

                    
                    {
                        this$2 = FavoritPonselMerek.FavoritRSSTask._cls4.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/favorit/FavoritPonselMerek$FavoritRSSTask$4$4

/* anonymous class */
        class FavoritPonselMerek.FavoritRSSTask._cls4._cls4
            implements android.content.DialogInterface.OnClickListener
        {

            final FavoritPonselMerek.FavoritRSSTask._cls4 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = FavoritPonselMerek.FavoritRSSTask._cls4.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/favorit/FavoritPonselMerek$FavoritRSSTask$4$6

/* anonymous class */
        class FavoritPonselMerek.FavoritRSSTask._cls4._cls6
            implements android.content.DialogInterface.OnClickListener
        {

            final FavoritPonselMerek.FavoritRSSTask._cls4 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(FavoritPonselMerek.FavoritRSSTask.access$3(this$1), com/inponsel/android/v2/RegisterActivity);
                FavoritPonselMerek.FavoritRSSTask.access$3(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = FavoritPonselMerek.FavoritRSSTask._cls4.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/favorit/FavoritPonselMerek$FavoritRSSTask$4$7

/* anonymous class */
        class FavoritPonselMerek.FavoritRSSTask._cls4._cls7
            implements android.content.DialogInterface.OnClickListener
        {

            final FavoritPonselMerek.FavoritRSSTask._cls4 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(FavoritPonselMerek.FavoritRSSTask.access$3(this$1), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                FavoritPonselMerek.FavoritRSSTask.access$3(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = FavoritPonselMerek.FavoritRSSTask._cls4.this;
                        super();
                    }
        }

    }

}
