// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.inponsel.android.utils.UserFunctions;

// Referenced classes of package com.inponsel.android.v2:
//            RSSFeedByTag, RegisterActivity, LoginActivity

class this._cls2
    implements android.content.er
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

    // Unreferenced inner class com/inponsel/android/v2/RSSFeedByTag$RSSAsycTask$4

/* anonymous class */
    class RSSFeedByTag.RSSAsycTask._cls4
        implements android.view.View.OnClickListener
    {

        final RSSFeedByTag.RSSAsycTask this$1;
        private final String val$id_rss;
        private final String val$rss_srclink;
        private final TextView val$txt_fav_news_1;

        public void onClick(View view)
        {
            RSSFeedByTag.RSSAsycTask.access$2(RSSFeedByTag.RSSAsycTask.this).idkom_pos = id_rss;
            RSSFeedByTag.RSSAsycTask.access$2(RSSFeedByTag.RSSAsycTask.this).str_srclink = rss_srclink;
            if (RSSFeedByTag.RSSAsycTask.access$2(RSSFeedByTag.RSSAsycTask.this).userFunctions.isUserLoggedIn(RSSFeedByTag.RSSAsycTask.access$2(RSSFeedByTag.RSSAsycTask.this)))
            {
                if (txt_fav_news_1.getText().toString().equals("1"))
                {
                    view = new android.app.AlertDialog.Builder(RSSFeedByTag.RSSAsycTask.access$2(RSSFeedByTag.RSSAsycTask.this));
                    view.setMessage("Hapus berita ini dari favorit?");
                    view.setPositiveButton("Ya", new RSSFeedByTag.RSSAsycTask._cls4._cls1());
                    view.setNegativeButton("Tidak", new RSSFeedByTag.RSSAsycTask._cls4._cls2());
                    view.show();
                    return;
                } else
                {
                    view = new android.app.AlertDialog.Builder(RSSFeedByTag.RSSAsycTask.access$2(RSSFeedByTag.RSSAsycTask.this));
                    view.setMessage("Favoritkan berita ini?");
                    view.setPositiveButton("Ya", new RSSFeedByTag.RSSAsycTask._cls4._cls3());
                    view.setNeutralButton("Tidak", new RSSFeedByTag.RSSAsycTask._cls4._cls4());
                    view.show();
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(RSSFeedByTag.RSSAsycTask.access$2(RSSFeedByTag.RSSAsycTask.this).wrapperLight);
                view.setMessage("Untuk menambahkan ke favorit harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new RSSFeedByTag.RSSAsycTask._cls4._cls5());
                view.setNeutralButton("Register", new RSSFeedByTag.RSSAsycTask._cls4._cls6());
                view.setNegativeButton("Login", new RSSFeedByTag.RSSAsycTask._cls4._cls7());
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

        // Unreferenced inner class com/inponsel/android/v2/RSSFeedByTag$RSSAsycTask$4$1

/* anonymous class */
        class RSSFeedByTag.RSSAsycTask._cls4._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final RSSFeedByTag.RSSAsycTask._cls4 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
                RSSFeedByTag.RSSAsycTask.access$2(this$1).stat = "0";
                (new RSSFeedByTag.FavoritTask(RSSFeedByTag.RSSAsycTask.access$2(this$1))).execute(new Void[0]);
            }

                    
                    {
                        this$2 = RSSFeedByTag.RSSAsycTask._cls4.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/RSSFeedByTag$RSSAsycTask$4$2

/* anonymous class */
        class RSSFeedByTag.RSSAsycTask._cls4._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final RSSFeedByTag.RSSAsycTask._cls4 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = RSSFeedByTag.RSSAsycTask._cls4.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/RSSFeedByTag$RSSAsycTask$4$3

/* anonymous class */
        class RSSFeedByTag.RSSAsycTask._cls4._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final RSSFeedByTag.RSSAsycTask._cls4 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                RSSFeedByTag.RSSAsycTask.access$2(this$1).stat = "1";
                (new RSSFeedByTag.FavoritTask(RSSFeedByTag.RSSAsycTask.access$2(this$1))).execute(new Void[0]);
            }

                    
                    {
                        this$2 = RSSFeedByTag.RSSAsycTask._cls4.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/RSSFeedByTag$RSSAsycTask$4$5

/* anonymous class */
        class RSSFeedByTag.RSSAsycTask._cls4._cls5
            implements android.content.DialogInterface.OnClickListener
        {

            final RSSFeedByTag.RSSAsycTask._cls4 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = RSSFeedByTag.RSSAsycTask._cls4.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/RSSFeedByTag$RSSAsycTask$4$6

/* anonymous class */
        class RSSFeedByTag.RSSAsycTask._cls4._cls6
            implements android.content.DialogInterface.OnClickListener
        {

            final RSSFeedByTag.RSSAsycTask._cls4 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(RSSFeedByTag.RSSAsycTask.access$2(this$1), com/inponsel/android/v2/RegisterActivity);
                RSSFeedByTag.RSSAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = RSSFeedByTag.RSSAsycTask._cls4.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/RSSFeedByTag$RSSAsycTask$4$7

/* anonymous class */
        class RSSFeedByTag.RSSAsycTask._cls4._cls7
            implements android.content.DialogInterface.OnClickListener
        {

            final RSSFeedByTag.RSSAsycTask._cls4 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(RSSFeedByTag.RSSAsycTask.access$2(this$1), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                RSSFeedByTag.RSSAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = RSSFeedByTag.RSSAsycTask._cls4.this;
                        super();
                    }
        }

    }

}
