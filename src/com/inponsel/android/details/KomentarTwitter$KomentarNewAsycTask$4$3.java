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
    implements android.content.AsycTask._cls4._cls3
{

    final is._cls1 this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent(ss._mth2(_fld1), com/inponsel/android/v2/LoginActivity);
        dialoginterface.putExtra("activity", "main");
        ss._mth2(_fld1).startActivity(dialoginterface);
    }

    l.id_tw()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/details/KomentarTwitter$KomentarNewAsycTask$4

/* anonymous class */
    class KomentarTwitter.KomentarNewAsycTask._cls4
        implements android.view.View.OnClickListener
    {

        final KomentarTwitter.KomentarNewAsycTask this$1;
        private final String val$id_komtw;
        private final String val$id_tw;

        public void onClick(View view)
        {
            if (KomentarTwitter.KomentarNewAsycTask.access$2(KomentarTwitter.KomentarNewAsycTask.this).userFunctions.isUserLoggedIn(KomentarTwitter.KomentarNewAsycTask.access$2(KomentarTwitter.KomentarNewAsycTask.this)))
            {
                KomentarTwitter.KomentarNewAsycTask.access$2(KomentarTwitter.KomentarNewAsycTask.this).statuslike = "1";
                KomentarTwitter.KomentarNewAsycTask.access$2(KomentarTwitter.KomentarNewAsycTask.this).idkom_pos = id_komtw;
                KomentarTwitter.KomentarNewAsycTask.access$2(KomentarTwitter.KomentarNewAsycTask.this).querylike = (new StringBuilder("status=")).append(KomentarTwitter.KomentarNewAsycTask.access$2(KomentarTwitter.KomentarNewAsycTask.this).statuslike).append("&id_kom=").append(id_komtw).append("&id_tw=").append(id_tw).append("&id_usr=").append(KomentarTwitter.KomentarNewAsycTask.access$2(KomentarTwitter.KomentarNewAsycTask.this).user_id).append("&t=").append(KomentarTwitter.KomentarNewAsycTask.access$2(KomentarTwitter.KomentarNewAsycTask.this).t).toString();
                Log.e("querylike", KomentarTwitter.KomentarNewAsycTask.access$2(KomentarTwitter.KomentarNewAsycTask.this).querylike);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new KomentarTwitter.PostBagusKurangTask(KomentarTwitter.KomentarNewAsycTask.access$2(KomentarTwitter.KomentarNewAsycTask.this))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new KomentarTwitter.PostBagusKurangTask(KomentarTwitter.KomentarNewAsycTask.access$2(KomentarTwitter.KomentarNewAsycTask.this))).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(KomentarTwitter.KomentarNewAsycTask.access$2(KomentarTwitter.KomentarNewAsycTask.this).wrapperLight);
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new KomentarTwitter.KomentarNewAsycTask._cls4._cls1());
                view.setNeutralButton("Register", new KomentarTwitter.KomentarNewAsycTask._cls4._cls2());
                view.setNegativeButton("Login", new KomentarTwitter.KomentarNewAsycTask._cls4._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_komentarnewasyctask;
                id_komtw = s;
                id_tw = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/details/KomentarTwitter$KomentarNewAsycTask$4$1

/* anonymous class */
        class KomentarTwitter.KomentarNewAsycTask._cls4._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final KomentarTwitter.KomentarNewAsycTask._cls4 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = KomentarTwitter.KomentarNewAsycTask._cls4.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/details/KomentarTwitter$KomentarNewAsycTask$4$2

/* anonymous class */
        class KomentarTwitter.KomentarNewAsycTask._cls4._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final KomentarTwitter.KomentarNewAsycTask._cls4 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(KomentarTwitter.KomentarNewAsycTask.access$2(this$1), com/inponsel/android/v2/RegisterActivity);
                KomentarTwitter.KomentarNewAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = KomentarTwitter.KomentarNewAsycTask._cls4.this;
                        super();
                    }
        }

    }

}
