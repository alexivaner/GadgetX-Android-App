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
//            KomentarTwitter

class this._cls2
    implements android.content.AsycTask._cls5._cls1
{

    final this._cls2 this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }

    l.id_tw()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/details/KomentarTwitter$KomentarAsycTask$5

/* anonymous class */
    class KomentarTwitter.KomentarAsycTask._cls5
        implements android.view.View.OnClickListener
    {

        final KomentarTwitter.KomentarAsycTask this$1;
        private final String val$id_komtw;
        private final String val$id_tw;

        public void onClick(View view)
        {
            if (KomentarTwitter.KomentarAsycTask.access$2(KomentarTwitter.KomentarAsycTask.this).userFunctions.isUserLoggedIn(KomentarTwitter.KomentarAsycTask.access$2(KomentarTwitter.KomentarAsycTask.this)))
            {
                KomentarTwitter.KomentarAsycTask.access$2(KomentarTwitter.KomentarAsycTask.this).statuslike = "0";
                KomentarTwitter.KomentarAsycTask.access$2(KomentarTwitter.KomentarAsycTask.this).idkom_pos = id_komtw;
                KomentarTwitter.KomentarAsycTask.access$2(KomentarTwitter.KomentarAsycTask.this).querylike = (new StringBuilder("status=")).append(KomentarTwitter.KomentarAsycTask.access$2(KomentarTwitter.KomentarAsycTask.this).statuslike).append("&id_kom=").append(id_komtw).append("&id_tw=").append(id_tw).append("&id_usr=").append(KomentarTwitter.KomentarAsycTask.access$2(KomentarTwitter.KomentarAsycTask.this).user_id).append("&t=").append(KomentarTwitter.KomentarAsycTask.access$2(KomentarTwitter.KomentarAsycTask.this).t).toString();
                Log.e("querylike", KomentarTwitter.KomentarAsycTask.access$2(KomentarTwitter.KomentarAsycTask.this).querylike);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new KomentarTwitter.PostBagusKurangTask(KomentarTwitter.KomentarAsycTask.access$2(KomentarTwitter.KomentarAsycTask.this))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new KomentarTwitter.PostBagusKurangTask(KomentarTwitter.KomentarAsycTask.access$2(KomentarTwitter.KomentarAsycTask.this))).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(KomentarTwitter.KomentarAsycTask.access$2(KomentarTwitter.KomentarAsycTask.this).wrapperLight);
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new KomentarTwitter.KomentarAsycTask._cls5._cls1());
                view.setNeutralButton("Register", new KomentarTwitter.KomentarAsycTask._cls5._cls2());
                view.setNegativeButton("Login", new KomentarTwitter.KomentarAsycTask._cls5._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_komentarasyctask;
                id_komtw = s;
                id_tw = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/details/KomentarTwitter$KomentarAsycTask$5$2

/* anonymous class */
        class KomentarTwitter.KomentarAsycTask._cls5._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final KomentarTwitter.KomentarAsycTask._cls5 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(KomentarTwitter.KomentarAsycTask.access$2(this$1), com/inponsel/android/v2/RegisterActivity);
                KomentarTwitter.KomentarAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = KomentarTwitter.KomentarAsycTask._cls5.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/details/KomentarTwitter$KomentarAsycTask$5$3

/* anonymous class */
        class KomentarTwitter.KomentarAsycTask._cls5._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final KomentarTwitter.KomentarAsycTask._cls5 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(KomentarTwitter.KomentarAsycTask.access$2(this$1), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                KomentarTwitter.KomentarAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = KomentarTwitter.KomentarAsycTask._cls5.this;
                        super();
                    }
        }

    }

}
