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
    implements android.content.ineTask._cls3._cls3
{

    final is._cls1 this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent(ss._mth2(_fld1), com/inponsel/android/v2/LoginActivity);
        dialoginterface.putExtra("activity", "main");
        ss._mth2(_fld1).startActivity(dialoginterface);
    }

    l.id_rss()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/rsstab/RSSTimelineActivity$TimelineTask$3

/* anonymous class */
    class RSSTimelineActivity.TimelineTask._cls3
        implements android.view.View.OnClickListener
    {

        final RSSTimelineActivity.TimelineTask this$1;
        private final String val$id_rss;

        public void onClick(View view)
        {
            if (RSSTimelineActivity.TimelineTask.access$2(RSSTimelineActivity.TimelineTask.this).userFunctions.isUserLoggedIn(RSSTimelineActivity.TimelineTask.access$2(RSSTimelineActivity.TimelineTask.this)))
            {
                RSSTimelineActivity.TimelineTask.access$2(RSSTimelineActivity.TimelineTask.this).statuslike = "1";
                RSSTimelineActivity.TimelineTask.access$2(RSSTimelineActivity.TimelineTask.this).idkom_pos = id_rss;
                RSSTimelineActivity.TimelineTask.access$2(RSSTimelineActivity.TimelineTask.this).querylike = (new StringBuilder("status=")).append(RSSTimelineActivity.TimelineTask.access$2(RSSTimelineActivity.TimelineTask.this).statuslike).append("&id_rss=").append(id_rss).append("&id_usr=").append(RSSTimelineActivity.TimelineTask.access$2(RSSTimelineActivity.TimelineTask.this).user_id).append("&t=").append(RSSTimelineActivity.TimelineTask.access$2(RSSTimelineActivity.TimelineTask.this).t).toString();
                Log.e("querylike", RSSTimelineActivity.TimelineTask.access$2(RSSTimelineActivity.TimelineTask.this).querylike);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new RSSTimelineActivity.PostBagusKurangTask(RSSTimelineActivity.TimelineTask.access$2(RSSTimelineActivity.TimelineTask.this))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new RSSTimelineActivity.PostBagusKurangTask(RSSTimelineActivity.TimelineTask.access$2(RSSTimelineActivity.TimelineTask.this))).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(RSSTimelineActivity.TimelineTask.access$2(RSSTimelineActivity.TimelineTask.this).wrapperLight);
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new RSSTimelineActivity.TimelineTask._cls3._cls1());
                view.setNeutralButton("Register", new RSSTimelineActivity.TimelineTask._cls3._cls2());
                view.setNegativeButton("Login", new RSSTimelineActivity.TimelineTask._cls3._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_timelinetask;
                id_rss = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/rsstab/RSSTimelineActivity$TimelineTask$3$1

/* anonymous class */
        class RSSTimelineActivity.TimelineTask._cls3._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final RSSTimelineActivity.TimelineTask._cls3 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = RSSTimelineActivity.TimelineTask._cls3.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/rsstab/RSSTimelineActivity$TimelineTask$3$2

/* anonymous class */
        class RSSTimelineActivity.TimelineTask._cls3._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final RSSTimelineActivity.TimelineTask._cls3 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(RSSTimelineActivity.TimelineTask.access$2(this$1), com/inponsel/android/v2/RegisterActivity);
                RSSTimelineActivity.TimelineTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = RSSTimelineActivity.TimelineTask._cls3.this;
                        super();
                    }
        }

    }

}
