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
    implements android.content.AsycTask._cls5._cls3
{

    final is._cls1 this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent(ss._mth2(_fld1), com/inponsel/android/v2/LoginActivity);
        dialoginterface.putExtra("activity", "main");
        ss._mth2(_fld1).startActivity(dialoginterface);
    }

    l.since_id()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/details/TwitterInPonsel$KomentarOldAsycTask$5

/* anonymous class */
    class TwitterInPonsel.KomentarOldAsycTask._cls5
        implements android.view.View.OnClickListener
    {

        final TwitterInPonsel.KomentarOldAsycTask this$1;
        private final String val$since_id;

        public void onClick(View view)
        {
            if (TwitterInPonsel.KomentarOldAsycTask.access$2(TwitterInPonsel.KomentarOldAsycTask.this).userFunctions.isUserLoggedIn(TwitterInPonsel.KomentarOldAsycTask.access$2(TwitterInPonsel.KomentarOldAsycTask.this)))
            {
                TwitterInPonsel.KomentarOldAsycTask.access$2(TwitterInPonsel.KomentarOldAsycTask.this).statuslike = "1";
                TwitterInPonsel.KomentarOldAsycTask.access$2(TwitterInPonsel.KomentarOldAsycTask.this).idkom_pos = since_id;
                TwitterInPonsel.KomentarOldAsycTask.access$2(TwitterInPonsel.KomentarOldAsycTask.this).querylike = (new StringBuilder("status=")).append(TwitterInPonsel.KomentarOldAsycTask.access$2(TwitterInPonsel.KomentarOldAsycTask.this).statuslike).append("&id_tw=").append(since_id).append("&id_usr=").append(TwitterInPonsel.KomentarOldAsycTask.access$2(TwitterInPonsel.KomentarOldAsycTask.this).user_id).append("&t=").append(TwitterInPonsel.KomentarOldAsycTask.access$2(TwitterInPonsel.KomentarOldAsycTask.this).t).toString();
                Log.e("querylike", TwitterInPonsel.KomentarOldAsycTask.access$2(TwitterInPonsel.KomentarOldAsycTask.this).querylike);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new TwitterInPonsel.PostBagusKurangTask(TwitterInPonsel.KomentarOldAsycTask.access$2(TwitterInPonsel.KomentarOldAsycTask.this))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new TwitterInPonsel.PostBagusKurangTask(TwitterInPonsel.KomentarOldAsycTask.access$2(TwitterInPonsel.KomentarOldAsycTask.this))).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(TwitterInPonsel.KomentarOldAsycTask.access$2(TwitterInPonsel.KomentarOldAsycTask.this).wrapperLight);
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new TwitterInPonsel.KomentarOldAsycTask._cls5._cls1());
                view.setNeutralButton("Register", new TwitterInPonsel.KomentarOldAsycTask._cls5._cls2());
                view.setNegativeButton("Login", new TwitterInPonsel.KomentarOldAsycTask._cls5._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_komentaroldasyctask;
                since_id = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/details/TwitterInPonsel$KomentarOldAsycTask$5$1

/* anonymous class */
        class TwitterInPonsel.KomentarOldAsycTask._cls5._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final TwitterInPonsel.KomentarOldAsycTask._cls5 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = TwitterInPonsel.KomentarOldAsycTask._cls5.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/details/TwitterInPonsel$KomentarOldAsycTask$5$2

/* anonymous class */
        class TwitterInPonsel.KomentarOldAsycTask._cls5._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final TwitterInPonsel.KomentarOldAsycTask._cls5 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(TwitterInPonsel.KomentarOldAsycTask.access$2(this$1), com/inponsel/android/v2/RegisterActivity);
                TwitterInPonsel.KomentarOldAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = TwitterInPonsel.KomentarOldAsycTask._cls5.this;
                        super();
                    }
        }

    }

}
