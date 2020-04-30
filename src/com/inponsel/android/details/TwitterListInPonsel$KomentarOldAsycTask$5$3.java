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

    // Unreferenced inner class com/inponsel/android/details/TwitterListInPonsel$KomentarOldAsycTask$5

/* anonymous class */
    class TwitterListInPonsel.KomentarOldAsycTask._cls5
        implements android.view.View.OnClickListener
    {

        final TwitterListInPonsel.KomentarOldAsycTask this$1;
        private final String val$since_id;

        public void onClick(View view)
        {
            if (TwitterListInPonsel.KomentarOldAsycTask.access$2(TwitterListInPonsel.KomentarOldAsycTask.this).userFunctions.isUserLoggedIn(TwitterListInPonsel.KomentarOldAsycTask.access$2(TwitterListInPonsel.KomentarOldAsycTask.this)))
            {
                TwitterListInPonsel.KomentarOldAsycTask.access$2(TwitterListInPonsel.KomentarOldAsycTask.this).statuslike = "1";
                TwitterListInPonsel.KomentarOldAsycTask.access$2(TwitterListInPonsel.KomentarOldAsycTask.this).idkom_pos = since_id;
                TwitterListInPonsel.KomentarOldAsycTask.access$2(TwitterListInPonsel.KomentarOldAsycTask.this).querylike = (new StringBuilder("status=")).append(TwitterListInPonsel.KomentarOldAsycTask.access$2(TwitterListInPonsel.KomentarOldAsycTask.this).statuslike).append("&id_tw=").append(since_id).append("&id_usr=").append(TwitterListInPonsel.KomentarOldAsycTask.access$2(TwitterListInPonsel.KomentarOldAsycTask.this).user_id).append("&t=").append(TwitterListInPonsel.KomentarOldAsycTask.access$2(TwitterListInPonsel.KomentarOldAsycTask.this).t).toString();
                Log.e("querylike", TwitterListInPonsel.KomentarOldAsycTask.access$2(TwitterListInPonsel.KomentarOldAsycTask.this).querylike);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new TwitterListInPonsel.PostBagusKurangTask(TwitterListInPonsel.KomentarOldAsycTask.access$2(TwitterListInPonsel.KomentarOldAsycTask.this))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new TwitterListInPonsel.PostBagusKurangTask(TwitterListInPonsel.KomentarOldAsycTask.access$2(TwitterListInPonsel.KomentarOldAsycTask.this))).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(TwitterListInPonsel.KomentarOldAsycTask.access$2(TwitterListInPonsel.KomentarOldAsycTask.this).wrapperLight);
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new TwitterListInPonsel.KomentarOldAsycTask._cls5._cls1());
                view.setNeutralButton("Register", new TwitterListInPonsel.KomentarOldAsycTask._cls5._cls2());
                view.setNegativeButton("Login", new TwitterListInPonsel.KomentarOldAsycTask._cls5._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_komentaroldasyctask;
                since_id = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/details/TwitterListInPonsel$KomentarOldAsycTask$5$1

/* anonymous class */
        class TwitterListInPonsel.KomentarOldAsycTask._cls5._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final TwitterListInPonsel.KomentarOldAsycTask._cls5 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = TwitterListInPonsel.KomentarOldAsycTask._cls5.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/details/TwitterListInPonsel$KomentarOldAsycTask$5$2

/* anonymous class */
        class TwitterListInPonsel.KomentarOldAsycTask._cls5._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final TwitterListInPonsel.KomentarOldAsycTask._cls5 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(TwitterListInPonsel.KomentarOldAsycTask.access$2(this$1), com/inponsel/android/v2/RegisterActivity);
                TwitterListInPonsel.KomentarOldAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = TwitterListInPonsel.KomentarOldAsycTask._cls5.this;
                        super();
                    }
        }

    }

}
