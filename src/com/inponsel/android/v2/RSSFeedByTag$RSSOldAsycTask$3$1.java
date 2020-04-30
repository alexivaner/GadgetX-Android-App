// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.UserFunctions;

// Referenced classes of package com.inponsel.android.v2:
//            RSSFeedByTag, RegisterActivity, LoginActivity

class this._cls2
    implements android.content.ask._cls3._cls1
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

    // Unreferenced inner class com/inponsel/android/v2/RSSFeedByTag$RSSOldAsycTask$3

/* anonymous class */
    class RSSFeedByTag.RSSOldAsycTask._cls3
        implements android.view.View.OnClickListener
    {

        final RSSFeedByTag.RSSOldAsycTask this$1;
        private final String val$id_rss;

        public void onClick(View view)
        {
            if (RSSFeedByTag.RSSOldAsycTask.access$2(RSSFeedByTag.RSSOldAsycTask.this).userFunctions.isUserLoggedIn(RSSFeedByTag.RSSOldAsycTask.access$2(RSSFeedByTag.RSSOldAsycTask.this)))
            {
                RSSFeedByTag.RSSOldAsycTask.access$2(RSSFeedByTag.RSSOldAsycTask.this).statuslike = "1";
                RSSFeedByTag.RSSOldAsycTask.access$2(RSSFeedByTag.RSSOldAsycTask.this).idkom_pos = id_rss;
                RSSFeedByTag.RSSOldAsycTask.access$2(RSSFeedByTag.RSSOldAsycTask.this).querylike = (new StringBuilder("status=")).append(RSSFeedByTag.RSSOldAsycTask.access$2(RSSFeedByTag.RSSOldAsycTask.this).statuslike).append("&id_rss=").append(id_rss).append("&id_usr=").append(RSSFeedByTag.RSSOldAsycTask.access$2(RSSFeedByTag.RSSOldAsycTask.this).user_id).append("&t=").append(RSSFeedByTag.RSSOldAsycTask.access$2(RSSFeedByTag.RSSOldAsycTask.this).t).toString();
                Log.e("querylike", RSSFeedByTag.RSSOldAsycTask.access$2(RSSFeedByTag.RSSOldAsycTask.this).querylike);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new RSSFeedByTag.PostBagusKurangTask(RSSFeedByTag.RSSOldAsycTask.access$2(RSSFeedByTag.RSSOldAsycTask.this))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new RSSFeedByTag.PostBagusKurangTask(RSSFeedByTag.RSSOldAsycTask.access$2(RSSFeedByTag.RSSOldAsycTask.this))).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(RSSFeedByTag.RSSOldAsycTask.access$2(RSSFeedByTag.RSSOldAsycTask.this).wrapperLight);
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new RSSFeedByTag.RSSOldAsycTask._cls3._cls1());
                view.setNeutralButton("Register", new RSSFeedByTag.RSSOldAsycTask._cls3._cls2());
                view.setNegativeButton("Login", new RSSFeedByTag.RSSOldAsycTask._cls3._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_rssoldasyctask;
                id_rss = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/RSSFeedByTag$RSSOldAsycTask$3$2

/* anonymous class */
        class RSSFeedByTag.RSSOldAsycTask._cls3._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final RSSFeedByTag.RSSOldAsycTask._cls3 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(RSSFeedByTag.RSSOldAsycTask.access$2(this$1), com/inponsel/android/v2/RegisterActivity);
                RSSFeedByTag.RSSOldAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = RSSFeedByTag.RSSOldAsycTask._cls3.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/RSSFeedByTag$RSSOldAsycTask$3$3

/* anonymous class */
        class RSSFeedByTag.RSSOldAsycTask._cls3._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final RSSFeedByTag.RSSOldAsycTask._cls3 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(RSSFeedByTag.RSSOldAsycTask.access$2(this$1), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                RSSFeedByTag.RSSOldAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = RSSFeedByTag.RSSOldAsycTask._cls3.this;
                        super();
                    }
        }

    }

}
