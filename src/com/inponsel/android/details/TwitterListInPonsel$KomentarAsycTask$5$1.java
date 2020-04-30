// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;

// Referenced classes of package com.inponsel.android.details:
//            TwitterListInPonsel

class this._cls2
    implements android.content.AsycTask._cls5._cls1
{

    final this._cls2 this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }

    l.since_id()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/details/TwitterListInPonsel$KomentarAsycTask$5

/* anonymous class */
    class TwitterListInPonsel.KomentarAsycTask._cls5
        implements android.view.View.OnClickListener
    {

        final TwitterListInPonsel.KomentarAsycTask this$1;
        private final String val$since_id;

        public void onClick(View view)
        {
            if (TwitterListInPonsel.KomentarAsycTask.access$2(TwitterListInPonsel.KomentarAsycTask.this).userFunctions.isUserLoggedIn(TwitterListInPonsel.KomentarAsycTask.access$2(TwitterListInPonsel.KomentarAsycTask.this)))
            {
                TwitterListInPonsel.KomentarAsycTask.access$2(TwitterListInPonsel.KomentarAsycTask.this).statuslike = "1";
                TwitterListInPonsel.KomentarAsycTask.access$2(TwitterListInPonsel.KomentarAsycTask.this).idkom_pos = since_id;
                TwitterListInPonsel.KomentarAsycTask.access$2(TwitterListInPonsel.KomentarAsycTask.this).querylike = (new StringBuilder("status=")).append(TwitterListInPonsel.KomentarAsycTask.access$2(TwitterListInPonsel.KomentarAsycTask.this).statuslike).append("&id_tw=").append(since_id).append("&id_usr=").append(TwitterListInPonsel.KomentarAsycTask.access$2(TwitterListInPonsel.KomentarAsycTask.this).user_id).append("&t=").append(TwitterListInPonsel.KomentarAsycTask.access$2(TwitterListInPonsel.KomentarAsycTask.this).t).toString();
                Log.e("querylike", TwitterListInPonsel.KomentarAsycTask.access$2(TwitterListInPonsel.KomentarAsycTask.this).querylike);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new TwitterListInPonsel.PostBagusKurangTask(TwitterListInPonsel.KomentarAsycTask.access$2(TwitterListInPonsel.KomentarAsycTask.this))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new TwitterListInPonsel.PostBagusKurangTask(TwitterListInPonsel.KomentarAsycTask.access$2(TwitterListInPonsel.KomentarAsycTask.this))).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(TwitterListInPonsel.KomentarAsycTask.access$2(TwitterListInPonsel.KomentarAsycTask.this).wrapperLight);
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new TwitterListInPonsel.KomentarAsycTask._cls5._cls1());
                view.setNeutralButton("Register", new TwitterListInPonsel.KomentarAsycTask._cls5._cls2());
                view.setNegativeButton("Login", new TwitterListInPonsel.KomentarAsycTask._cls5._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_komentarasyctask;
                since_id = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/details/TwitterListInPonsel$KomentarAsycTask$5$2

/* anonymous class */
        class TwitterListInPonsel.KomentarAsycTask._cls5._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final TwitterListInPonsel.KomentarAsycTask._cls5 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(TwitterListInPonsel.KomentarAsycTask.access$2(this$1), com/inponsel/android/v2/RegisterActivity);
                TwitterListInPonsel.KomentarAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = TwitterListInPonsel.KomentarAsycTask._cls5.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/details/TwitterListInPonsel$KomentarAsycTask$5$3

/* anonymous class */
        class TwitterListInPonsel.KomentarAsycTask._cls5._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final TwitterListInPonsel.KomentarAsycTask._cls5 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(TwitterListInPonsel.KomentarAsycTask.access$2(this$1), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                TwitterListInPonsel.KomentarAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = TwitterListInPonsel.KomentarAsycTask._cls5.this;
                        super();
                    }
        }

    }

}
