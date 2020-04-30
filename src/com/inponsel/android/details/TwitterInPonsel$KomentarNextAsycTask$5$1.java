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
//            TwitterInPonsel

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

    // Unreferenced inner class com/inponsel/android/details/TwitterInPonsel$KomentarNextAsycTask$5

/* anonymous class */
    class TwitterInPonsel.KomentarNextAsycTask._cls5
        implements android.view.View.OnClickListener
    {

        final TwitterInPonsel.KomentarNextAsycTask this$1;
        private final String val$since_id;

        public void onClick(View view)
        {
            if (TwitterInPonsel.KomentarNextAsycTask.access$2(TwitterInPonsel.KomentarNextAsycTask.this).userFunctions.isUserLoggedIn(TwitterInPonsel.KomentarNextAsycTask.access$2(TwitterInPonsel.KomentarNextAsycTask.this)))
            {
                TwitterInPonsel.KomentarNextAsycTask.access$2(TwitterInPonsel.KomentarNextAsycTask.this).statuslike = "1";
                TwitterInPonsel.KomentarNextAsycTask.access$2(TwitterInPonsel.KomentarNextAsycTask.this).idkom_pos = since_id;
                TwitterInPonsel.KomentarNextAsycTask.access$2(TwitterInPonsel.KomentarNextAsycTask.this).querylike = (new StringBuilder("status=")).append(TwitterInPonsel.KomentarNextAsycTask.access$2(TwitterInPonsel.KomentarNextAsycTask.this).statuslike).append("&id_tw=").append(since_id).append("&id_usr=").append(TwitterInPonsel.KomentarNextAsycTask.access$2(TwitterInPonsel.KomentarNextAsycTask.this).user_id).append("&t=").append(TwitterInPonsel.KomentarNextAsycTask.access$2(TwitterInPonsel.KomentarNextAsycTask.this).t).toString();
                Log.e("querylike", TwitterInPonsel.KomentarNextAsycTask.access$2(TwitterInPonsel.KomentarNextAsycTask.this).querylike);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new TwitterInPonsel.PostBagusKurangTask(TwitterInPonsel.KomentarNextAsycTask.access$2(TwitterInPonsel.KomentarNextAsycTask.this))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new TwitterInPonsel.PostBagusKurangTask(TwitterInPonsel.KomentarNextAsycTask.access$2(TwitterInPonsel.KomentarNextAsycTask.this))).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(TwitterInPonsel.KomentarNextAsycTask.access$2(TwitterInPonsel.KomentarNextAsycTask.this).wrapperLight);
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new TwitterInPonsel.KomentarNextAsycTask._cls5._cls1());
                view.setNeutralButton("Register", new TwitterInPonsel.KomentarNextAsycTask._cls5._cls2());
                view.setNegativeButton("Login", new TwitterInPonsel.KomentarNextAsycTask._cls5._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_komentarnextasyctask;
                since_id = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/details/TwitterInPonsel$KomentarNextAsycTask$5$2

/* anonymous class */
        class TwitterInPonsel.KomentarNextAsycTask._cls5._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final TwitterInPonsel.KomentarNextAsycTask._cls5 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(TwitterInPonsel.KomentarNextAsycTask.access$2(this$1), com/inponsel/android/v2/RegisterActivity);
                TwitterInPonsel.KomentarNextAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = TwitterInPonsel.KomentarNextAsycTask._cls5.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/details/TwitterInPonsel$KomentarNextAsycTask$5$3

/* anonymous class */
        class TwitterInPonsel.KomentarNextAsycTask._cls5._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final TwitterInPonsel.KomentarNextAsycTask._cls5 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(TwitterInPonsel.KomentarNextAsycTask.access$2(this$1), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                TwitterInPonsel.KomentarNextAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = TwitterInPonsel.KomentarNextAsycTask._cls5.this;
                        super();
                    }
        }

    }

}
