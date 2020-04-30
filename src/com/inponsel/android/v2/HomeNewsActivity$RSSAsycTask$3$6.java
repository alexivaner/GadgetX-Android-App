// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.UserFunctions;

// Referenced classes of package com.inponsel.android.v2:
//            HomeNewsActivity, RegisterActivity, LoginActivity

class this._cls2
    implements android.content.ask._cls3._cls6
{

    final is._cls1 this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent(ss._mth2(_fld1), com/inponsel/android/v2/RegisterActivity);
        ss._mth2(_fld1).startActivity(dialoginterface);
    }

    l.txt_fav_news_1()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/HomeNewsActivity$RSSAsycTask$3

/* anonymous class */
    class HomeNewsActivity.RSSAsycTask._cls3
        implements android.view.View.OnClickListener
    {

        final HomeNewsActivity.RSSAsycTask this$1;
        private final String val$id_rss;
        private final String val$rss_srclink;
        private final TextView val$txt_fav_news_1;

        public void onClick(View view)
        {
            HomeNewsActivity.RSSAsycTask.access$2(HomeNewsActivity.RSSAsycTask.this).idkom_pos = id_rss;
            HomeNewsActivity.RSSAsycTask.access$2(HomeNewsActivity.RSSAsycTask.this).str_srclink = rss_srclink;
            if (HomeNewsActivity.RSSAsycTask.access$2(HomeNewsActivity.RSSAsycTask.this).userFunctions.isUserLoggedIn(HomeNewsActivity.RSSAsycTask.access$2(HomeNewsActivity.RSSAsycTask.this)))
            {
                Log.e("idkom_posfav", HomeNewsActivity.RSSAsycTask.access$2(HomeNewsActivity.RSSAsycTask.this).idkom_pos);
                if (txt_fav_news_1.getText().toString().equals("1"))
                {
                    view = new android.app.AlertDialog.Builder(HomeNewsActivity.RSSAsycTask.access$2(HomeNewsActivity.RSSAsycTask.this));
                    view.setMessage("Hapus berita ini dari favorit?");
                    view.setPositiveButton("Ya", new HomeNewsActivity.RSSAsycTask._cls3._cls1());
                    view.setNegativeButton("Tidak", new HomeNewsActivity.RSSAsycTask._cls3._cls2());
                    view.show();
                    return;
                } else
                {
                    view = new android.app.AlertDialog.Builder(HomeNewsActivity.RSSAsycTask.access$2(HomeNewsActivity.RSSAsycTask.this));
                    view.setMessage("Favoritkan berita ini?");
                    view.setPositiveButton("Ya", new HomeNewsActivity.RSSAsycTask._cls3._cls3());
                    view.setNeutralButton("Tidak", new HomeNewsActivity.RSSAsycTask._cls3._cls4());
                    view.show();
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(HomeNewsActivity.RSSAsycTask.access$2(HomeNewsActivity.RSSAsycTask.this));
                view.setMessage("Untuk menambahkan ke favorit harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new HomeNewsActivity.RSSAsycTask._cls3._cls5());
                view.setNeutralButton("Register", new HomeNewsActivity.RSSAsycTask._cls3._cls6());
                view.setNegativeButton("Login", new HomeNewsActivity.RSSAsycTask._cls3._cls7());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_rssasyctask;
                id_rss = s;
                rss_srclink = s1;
                txt_fav_news_1 = TextView.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/HomeNewsActivity$RSSAsycTask$3$1

/* anonymous class */
        class HomeNewsActivity.RSSAsycTask._cls3._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final HomeNewsActivity.RSSAsycTask._cls3 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
                HomeNewsActivity.RSSAsycTask.access$2(this$1).statFav = "0";
                (new HomeNewsActivity.FavoritTask(HomeNewsActivity.RSSAsycTask.access$2(this$1))).execute(new Void[0]);
            }

                    
                    {
                        this$2 = HomeNewsActivity.RSSAsycTask._cls3.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/HomeNewsActivity$RSSAsycTask$3$2

/* anonymous class */
        class HomeNewsActivity.RSSAsycTask._cls3._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final HomeNewsActivity.RSSAsycTask._cls3 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = HomeNewsActivity.RSSAsycTask._cls3.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/HomeNewsActivity$RSSAsycTask$3$3

/* anonymous class */
        class HomeNewsActivity.RSSAsycTask._cls3._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final HomeNewsActivity.RSSAsycTask._cls3 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                HomeNewsActivity.RSSAsycTask.access$2(this$1).statFav = "1";
                (new HomeNewsActivity.FavoritTask(HomeNewsActivity.RSSAsycTask.access$2(this$1))).execute(new Void[0]);
            }

                    
                    {
                        this$2 = HomeNewsActivity.RSSAsycTask._cls3.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/HomeNewsActivity$RSSAsycTask$3$4

/* anonymous class */
        class HomeNewsActivity.RSSAsycTask._cls3._cls4
            implements android.content.DialogInterface.OnClickListener
        {

            final HomeNewsActivity.RSSAsycTask._cls3 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = HomeNewsActivity.RSSAsycTask._cls3.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/HomeNewsActivity$RSSAsycTask$3$5

/* anonymous class */
        class HomeNewsActivity.RSSAsycTask._cls3._cls5
            implements android.content.DialogInterface.OnClickListener
        {

            final HomeNewsActivity.RSSAsycTask._cls3 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = HomeNewsActivity.RSSAsycTask._cls3.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/HomeNewsActivity$RSSAsycTask$3$7

/* anonymous class */
        class HomeNewsActivity.RSSAsycTask._cls3._cls7
            implements android.content.DialogInterface.OnClickListener
        {

            final HomeNewsActivity.RSSAsycTask._cls3 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(HomeNewsActivity.RSSAsycTask.access$2(this$1), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                HomeNewsActivity.RSSAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = HomeNewsActivity.RSSAsycTask._cls3.this;
                        super();
                    }
        }

    }

}
