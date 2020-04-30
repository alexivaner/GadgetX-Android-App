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
    implements android.content.r
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

    // Unreferenced inner class com/inponsel/android/details/KomentarTwitter$PostKomen$5

/* anonymous class */
    class KomentarTwitter.PostKomen._cls5
        implements android.view.View.OnClickListener
    {

        final KomentarTwitter.PostKomen this$1;
        private final String val$id_komtw;
        private final String val$id_tw;

        public void onClick(View view)
        {
            if (KomentarTwitter.PostKomen.access$2(KomentarTwitter.PostKomen.this).userFunctions.isUserLoggedIn(KomentarTwitter.PostKomen.access$2(KomentarTwitter.PostKomen.this)))
            {
                KomentarTwitter.PostKomen.access$2(KomentarTwitter.PostKomen.this).statuslike = "0";
                KomentarTwitter.PostKomen.access$2(KomentarTwitter.PostKomen.this).idkom_pos = id_komtw;
                KomentarTwitter.PostKomen.access$2(KomentarTwitter.PostKomen.this).querylike = (new StringBuilder("status=")).append(KomentarTwitter.PostKomen.access$2(KomentarTwitter.PostKomen.this).statuslike).append("&id_kom=").append(id_komtw).append("&id_tw=").append(id_tw).append("&id_usr=").append(KomentarTwitter.PostKomen.access$2(KomentarTwitter.PostKomen.this).user_id).append("&t=").append(KomentarTwitter.PostKomen.access$2(KomentarTwitter.PostKomen.this).t).toString();
                Log.e("querylike", KomentarTwitter.PostKomen.access$2(KomentarTwitter.PostKomen.this).querylike);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new KomentarTwitter.PostBagusKurangTask(KomentarTwitter.PostKomen.access$2(KomentarTwitter.PostKomen.this))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new KomentarTwitter.PostBagusKurangTask(KomentarTwitter.PostKomen.access$2(KomentarTwitter.PostKomen.this))).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(KomentarTwitter.PostKomen.access$2(KomentarTwitter.PostKomen.this).wrapperLight);
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new KomentarTwitter.PostKomen._cls5._cls1());
                view.setNeutralButton("Register", new KomentarTwitter.PostKomen._cls5._cls2());
                view.setNegativeButton("Login", new KomentarTwitter.PostKomen._cls5._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_postkomen;
                id_komtw = s;
                id_tw = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/details/KomentarTwitter$PostKomen$5$1

/* anonymous class */
        class KomentarTwitter.PostKomen._cls5._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final KomentarTwitter.PostKomen._cls5 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = KomentarTwitter.PostKomen._cls5.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/details/KomentarTwitter$PostKomen$5$2

/* anonymous class */
        class KomentarTwitter.PostKomen._cls5._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final KomentarTwitter.PostKomen._cls5 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(KomentarTwitter.PostKomen.access$2(this$1), com/inponsel/android/v2/RegisterActivity);
                KomentarTwitter.PostKomen.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = KomentarTwitter.PostKomen._cls5.this;
                        super();
                    }
        }

    }

}
