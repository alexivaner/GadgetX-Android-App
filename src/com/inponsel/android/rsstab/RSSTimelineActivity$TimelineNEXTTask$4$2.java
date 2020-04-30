// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.rsstab;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;

// Referenced classes of package com.inponsel.android.rsstab:
//            RSSTimelineActivity

class this._cls2
    implements android.content.EXTTask._cls4._cls2
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

    // Unreferenced inner class com/inponsel/android/rsstab/RSSTimelineActivity$TimelineNEXTTask$4

/* anonymous class */
    class RSSTimelineActivity.TimelineNEXTTask._cls4
        implements android.view.View.OnClickListener
    {

        final RSSTimelineActivity.TimelineNEXTTask this$1;
        private final String val$id_rss;
        private final String val$rss_srclink;
        private final TextView val$txt_fav_news_1;

        public void onClick(View view)
        {
            RSSTimelineActivity.TimelineNEXTTask.access$2(RSSTimelineActivity.TimelineNEXTTask.this).idkom_pos = id_rss;
            RSSTimelineActivity.TimelineNEXTTask.access$2(RSSTimelineActivity.TimelineNEXTTask.this).str_srclink = rss_srclink;
            if (RSSTimelineActivity.TimelineNEXTTask.access$2(RSSTimelineActivity.TimelineNEXTTask.this).userFunctions.isUserLoggedIn(RSSTimelineActivity.TimelineNEXTTask.access$2(RSSTimelineActivity.TimelineNEXTTask.this)))
            {
                if (txt_fav_news_1.getText().toString().equals("1"))
                {
                    view = new android.app.AlertDialog.Builder(RSSTimelineActivity.TimelineNEXTTask.access$2(RSSTimelineActivity.TimelineNEXTTask.this));
                    view.setMessage("Hapus berita ini dari favorit?");
                    view.setPositiveButton("Ya", new RSSTimelineActivity.TimelineNEXTTask._cls4._cls1());
                    view.setNegativeButton("Tidak", new RSSTimelineActivity.TimelineNEXTTask._cls4._cls2());
                    view.show();
                    return;
                } else
                {
                    view = new android.app.AlertDialog.Builder(RSSTimelineActivity.TimelineNEXTTask.access$2(RSSTimelineActivity.TimelineNEXTTask.this));
                    view.setMessage("Favoritkan berita ini?");
                    view.setPositiveButton("Ya", new RSSTimelineActivity.TimelineNEXTTask._cls4._cls3());
                    view.setNeutralButton("Tidak", new RSSTimelineActivity.TimelineNEXTTask._cls4._cls4());
                    view.show();
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(RSSTimelineActivity.TimelineNEXTTask.access$2(RSSTimelineActivity.TimelineNEXTTask.this).wrapperLight);
                view.setMessage("Untuk menambahkan ke favorit harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new RSSTimelineActivity.TimelineNEXTTask._cls4._cls5());
                view.setNeutralButton("Register", new RSSTimelineActivity.TimelineNEXTTask._cls4._cls6());
                view.setNegativeButton("Login", new RSSTimelineActivity.TimelineNEXTTask._cls4._cls7());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_timelinenexttask;
                id_rss = s;
                rss_srclink = s1;
                txt_fav_news_1 = TextView.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/rsstab/RSSTimelineActivity$TimelineNEXTTask$4$1

/* anonymous class */
        class RSSTimelineActivity.TimelineNEXTTask._cls4._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final RSSTimelineActivity.TimelineNEXTTask._cls4 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
                RSSTimelineActivity.TimelineNEXTTask.access$2(this$1).stat = "0";
                (new RSSTimelineActivity.FavoritTask(RSSTimelineActivity.TimelineNEXTTask.access$2(this$1))).execute(new Void[0]);
            }

                    
                    {
                        this$2 = RSSTimelineActivity.TimelineNEXTTask._cls4.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/rsstab/RSSTimelineActivity$TimelineNEXTTask$4$3

/* anonymous class */
        class RSSTimelineActivity.TimelineNEXTTask._cls4._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final RSSTimelineActivity.TimelineNEXTTask._cls4 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                RSSTimelineActivity.TimelineNEXTTask.access$2(this$1).stat = "1";
                (new RSSTimelineActivity.FavoritTask(RSSTimelineActivity.TimelineNEXTTask.access$2(this$1))).execute(new Void[0]);
            }

                    
                    {
                        this$2 = RSSTimelineActivity.TimelineNEXTTask._cls4.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/rsstab/RSSTimelineActivity$TimelineNEXTTask$4$4

/* anonymous class */
        class RSSTimelineActivity.TimelineNEXTTask._cls4._cls4
            implements android.content.DialogInterface.OnClickListener
        {

            final RSSTimelineActivity.TimelineNEXTTask._cls4 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = RSSTimelineActivity.TimelineNEXTTask._cls4.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/rsstab/RSSTimelineActivity$TimelineNEXTTask$4$5

/* anonymous class */
        class RSSTimelineActivity.TimelineNEXTTask._cls4._cls5
            implements android.content.DialogInterface.OnClickListener
        {

            final RSSTimelineActivity.TimelineNEXTTask._cls4 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = RSSTimelineActivity.TimelineNEXTTask._cls4.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/rsstab/RSSTimelineActivity$TimelineNEXTTask$4$6

/* anonymous class */
        class RSSTimelineActivity.TimelineNEXTTask._cls4._cls6
            implements android.content.DialogInterface.OnClickListener
        {

            final RSSTimelineActivity.TimelineNEXTTask._cls4 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(RSSTimelineActivity.TimelineNEXTTask.access$2(this$1), com/inponsel/android/v2/RegisterActivity);
                RSSTimelineActivity.TimelineNEXTTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = RSSTimelineActivity.TimelineNEXTTask._cls4.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/rsstab/RSSTimelineActivity$TimelineNEXTTask$4$7

/* anonymous class */
        class RSSTimelineActivity.TimelineNEXTTask._cls4._cls7
            implements android.content.DialogInterface.OnClickListener
        {

            final RSSTimelineActivity.TimelineNEXTTask._cls4 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(RSSTimelineActivity.TimelineNEXTTask.access$2(this$1), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                RSSTimelineActivity.TimelineNEXTTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = RSSTimelineActivity.TimelineNEXTTask._cls4.this;
                        super();
                    }
        }

    }

}
