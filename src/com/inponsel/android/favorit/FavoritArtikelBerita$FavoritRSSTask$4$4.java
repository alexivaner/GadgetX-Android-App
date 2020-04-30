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
//            FavoritArtikelBerita

class this._cls2
    implements android.content.tRSSTask._cls4._cls4
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

    // Unreferenced inner class com/inponsel/android/favorit/FavoritArtikelBerita$FavoritRSSTask$4

/* anonymous class */
    class FavoritArtikelBerita.FavoritRSSTask._cls4
        implements android.view.View.OnClickListener
    {

        final FavoritArtikelBerita.FavoritRSSTask this$1;
        private final String val$id_rss;
        private final String val$rss_srclink;
        private final TextView val$txt_fav_news_1;

        public void onClick(View view)
        {
            FavoritArtikelBerita.FavoritRSSTask.access$3(FavoritArtikelBerita.FavoritRSSTask.this).idrss_pos = id_rss;
            FavoritArtikelBerita.FavoritRSSTask.access$3(FavoritArtikelBerita.FavoritRSSTask.this).str_srclink = rss_srclink;
            if (FavoritArtikelBerita.FavoritRSSTask.access$3(FavoritArtikelBerita.FavoritRSSTask.this).userFunctions.isUserLoggedIn(FavoritArtikelBerita.FavoritRSSTask.access$3(FavoritArtikelBerita.FavoritRSSTask.this)))
            {
                if (txt_fav_news_1.getText().toString().equals("1"))
                {
                    view = new android.app.AlertDialog.Builder(FavoritArtikelBerita.FavoritRSSTask.access$3(FavoritArtikelBerita.FavoritRSSTask.this));
                    view.setMessage("Hapus berita ini dari favorit?");
                    view.setPositiveButton("Ya", new FavoritArtikelBerita.FavoritRSSTask._cls4._cls1());
                    view.setNegativeButton("Tidak", new FavoritArtikelBerita.FavoritRSSTask._cls4._cls2());
                    view.show();
                    return;
                } else
                {
                    view = new android.app.AlertDialog.Builder(FavoritArtikelBerita.FavoritRSSTask.access$3(FavoritArtikelBerita.FavoritRSSTask.this));
                    view.setMessage("Favoritkan berita ini?");
                    view.setPositiveButton("Ya", new FavoritArtikelBerita.FavoritRSSTask._cls4._cls3());
                    view.setNeutralButton("Tidak", new FavoritArtikelBerita.FavoritRSSTask._cls4._cls4());
                    view.show();
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(FavoritArtikelBerita.FavoritRSSTask.access$3(FavoritArtikelBerita.FavoritRSSTask.this).wrapperLight);
                view.setMessage("Untuk menambahkan ke favorit harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new FavoritArtikelBerita.FavoritRSSTask._cls4._cls5());
                view.setNeutralButton("Register", new FavoritArtikelBerita.FavoritRSSTask._cls4._cls6());
                view.setNegativeButton("Login", new FavoritArtikelBerita.FavoritRSSTask._cls4._cls7());
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

        // Unreferenced inner class com/inponsel/android/favorit/FavoritArtikelBerita$FavoritRSSTask$4$1

/* anonymous class */
        class FavoritArtikelBerita.FavoritRSSTask._cls4._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final FavoritArtikelBerita.FavoritRSSTask._cls4 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
                FavoritArtikelBerita.FavoritRSSTask.access$3(this$1).stat = "0";
                (new FavoritArtikelBerita.RemFavoritRSSTask(FavoritArtikelBerita.FavoritRSSTask.access$3(this$1))).execute(new Void[0]);
            }

                    
                    {
                        this$2 = FavoritArtikelBerita.FavoritRSSTask._cls4.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/favorit/FavoritArtikelBerita$FavoritRSSTask$4$2

/* anonymous class */
        class FavoritArtikelBerita.FavoritRSSTask._cls4._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final FavoritArtikelBerita.FavoritRSSTask._cls4 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = FavoritArtikelBerita.FavoritRSSTask._cls4.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/favorit/FavoritArtikelBerita$FavoritRSSTask$4$3

/* anonymous class */
        class FavoritArtikelBerita.FavoritRSSTask._cls4._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final FavoritArtikelBerita.FavoritRSSTask._cls4 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                FavoritArtikelBerita.FavoritRSSTask.access$3(this$1).stat = "1";
                (new FavoritArtikelBerita.FavoritRSSTask(FavoritArtikelBerita.FavoritRSSTask.access$3(this$1), null)).execute(new String[0]);
            }

                    
                    {
                        this$2 = FavoritArtikelBerita.FavoritRSSTask._cls4.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/favorit/FavoritArtikelBerita$FavoritRSSTask$4$5

/* anonymous class */
        class FavoritArtikelBerita.FavoritRSSTask._cls4._cls5
            implements android.content.DialogInterface.OnClickListener
        {

            final FavoritArtikelBerita.FavoritRSSTask._cls4 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = FavoritArtikelBerita.FavoritRSSTask._cls4.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/favorit/FavoritArtikelBerita$FavoritRSSTask$4$6

/* anonymous class */
        class FavoritArtikelBerita.FavoritRSSTask._cls4._cls6
            implements android.content.DialogInterface.OnClickListener
        {

            final FavoritArtikelBerita.FavoritRSSTask._cls4 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(FavoritArtikelBerita.FavoritRSSTask.access$3(this$1), com/inponsel/android/v2/RegisterActivity);
                FavoritArtikelBerita.FavoritRSSTask.access$3(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = FavoritArtikelBerita.FavoritRSSTask._cls4.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/favorit/FavoritArtikelBerita$FavoritRSSTask$4$7

/* anonymous class */
        class FavoritArtikelBerita.FavoritRSSTask._cls4._cls7
            implements android.content.DialogInterface.OnClickListener
        {

            final FavoritArtikelBerita.FavoritRSSTask._cls4 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(FavoritArtikelBerita.FavoritRSSTask.access$3(this$1), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                FavoritArtikelBerita.FavoritRSSTask.access$3(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = FavoritArtikelBerita.FavoritRSSTask._cls4.this;
                        super();
                    }
        }

    }

}
