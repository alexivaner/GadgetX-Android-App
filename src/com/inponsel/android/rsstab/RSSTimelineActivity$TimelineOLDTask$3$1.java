// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.rsstab;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;

// Referenced classes of package com.inponsel.android.rsstab:
//            RSSTimelineActivity

class this._cls2
    implements android.content.OLDTask._cls3._cls1
{

    final this._cls2 this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }

    l.id_rss()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/rsstab/RSSTimelineActivity$TimelineOLDTask$3

/* anonymous class */
    class RSSTimelineActivity.TimelineOLDTask._cls3
        implements android.view.View.OnClickListener
    {

        final RSSTimelineActivity.TimelineOLDTask this$1;
        private final String val$id_rss;

        public void onClick(View view)
        {
            if (RSSTimelineActivity.TimelineOLDTask.access$2(RSSTimelineActivity.TimelineOLDTask.this).userFunctions.isUserLoggedIn(RSSTimelineActivity.TimelineOLDTask.access$2(RSSTimelineActivity.TimelineOLDTask.this)))
            {
                RSSTimelineActivity.TimelineOLDTask.access$2(RSSTimelineActivity.TimelineOLDTask.this).statuslike = "1";
                RSSTimelineActivity.TimelineOLDTask.access$2(RSSTimelineActivity.TimelineOLDTask.this).idkom_pos = id_rss;
                RSSTimelineActivity.TimelineOLDTask.access$2(RSSTimelineActivity.TimelineOLDTask.this).querylike = (new StringBuilder("status=")).append(RSSTimelineActivity.TimelineOLDTask.access$2(RSSTimelineActivity.TimelineOLDTask.this).statuslike).append("&id_rss=").append(id_rss).append("&id_usr=").append(RSSTimelineActivity.TimelineOLDTask.access$2(RSSTimelineActivity.TimelineOLDTask.this).user_id).append("&t=").append(RSSTimelineActivity.TimelineOLDTask.access$2(RSSTimelineActivity.TimelineOLDTask.this).t).toString();
                Log.e("querylike", RSSTimelineActivity.TimelineOLDTask.access$2(RSSTimelineActivity.TimelineOLDTask.this).querylike);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new RSSTimelineActivity.PostBagusKurangTask(RSSTimelineActivity.TimelineOLDTask.access$2(RSSTimelineActivity.TimelineOLDTask.this))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new RSSTimelineActivity.PostBagusKurangTask(RSSTimelineActivity.TimelineOLDTask.access$2(RSSTimelineActivity.TimelineOLDTask.this))).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(RSSTimelineActivity.TimelineOLDTask.access$2(RSSTimelineActivity.TimelineOLDTask.this).wrapperLight);
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new RSSTimelineActivity.TimelineOLDTask._cls3._cls1());
                view.setNeutralButton("Register", new RSSTimelineActivity.TimelineOLDTask._cls3._cls2());
                view.setNegativeButton("Login", new RSSTimelineActivity.TimelineOLDTask._cls3._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_timelineoldtask;
                id_rss = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/rsstab/RSSTimelineActivity$TimelineOLDTask$3$2

/* anonymous class */
        class RSSTimelineActivity.TimelineOLDTask._cls3._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final RSSTimelineActivity.TimelineOLDTask._cls3 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(RSSTimelineActivity.TimelineOLDTask.access$2(this$1), com/inponsel/android/v2/RegisterActivity);
                RSSTimelineActivity.TimelineOLDTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = RSSTimelineActivity.TimelineOLDTask._cls3.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/rsstab/RSSTimelineActivity$TimelineOLDTask$3$3

/* anonymous class */
        class RSSTimelineActivity.TimelineOLDTask._cls3._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final RSSTimelineActivity.TimelineOLDTask._cls3 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(RSSTimelineActivity.TimelineOLDTask.access$2(this$1), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                RSSTimelineActivity.TimelineOLDTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = RSSTimelineActivity.TimelineOLDTask._cls3.this;
                        super();
                    }
        }

    }

}
