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
//            KomentarPonsel, RegisterActivity, LoginActivity

class this._cls2
    implements android.content.ask._cls2._cls1
{

    final this._cls2 this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }

    l.id_hp()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/KomentarPonsel$KomentarReplyAsycTask$2

/* anonymous class */
    class KomentarPonsel.KomentarReplyAsycTask._cls2
        implements android.view.View.OnClickListener
    {

        final KomentarPonsel.KomentarReplyAsycTask this$1;
        private final String val$id_hp;
        private final String val$id_komentar;

        public void onClick(View view)
        {
            if (KomentarPonsel.KomentarReplyAsycTask.access$2(KomentarPonsel.KomentarReplyAsycTask.this).userFunctions.isUserLoggedIn(KomentarPonsel.KomentarReplyAsycTask.access$2(KomentarPonsel.KomentarReplyAsycTask.this)))
            {
                KomentarPonsel.KomentarReplyAsycTask.access$2(KomentarPonsel.KomentarReplyAsycTask.this).statuslike = "0";
                KomentarPonsel.KomentarReplyAsycTask.access$2(KomentarPonsel.KomentarReplyAsycTask.this).idkom_pos = id_komentar;
                KomentarPonsel.KomentarReplyAsycTask.access$2(KomentarPonsel.KomentarReplyAsycTask.this).querylike = (new StringBuilder("status=")).append(KomentarPonsel.KomentarReplyAsycTask.access$2(KomentarPonsel.KomentarReplyAsycTask.this).statuslike).append("&id_komen=").append(id_komentar).append("&idhp=").append(id_hp).append("&email=").append(KomentarPonsel.KomentarReplyAsycTask.access$2(KomentarPonsel.KomentarReplyAsycTask.this).username).append("&id_user=").append(KomentarPonsel.KomentarReplyAsycTask.access$2(KomentarPonsel.KomentarReplyAsycTask.this).user_id).append("&t=").append(KomentarPonsel.KomentarReplyAsycTask.access$2(KomentarPonsel.KomentarReplyAsycTask.this).t).toString();
                Log.e("querylike", KomentarPonsel.KomentarReplyAsycTask.access$2(KomentarPonsel.KomentarReplyAsycTask.this).querylike);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new KomentarPonsel.PostBagusKurangTask(KomentarPonsel.KomentarReplyAsycTask.access$2(KomentarPonsel.KomentarReplyAsycTask.this))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new KomentarPonsel.PostBagusKurangTask(KomentarPonsel.KomentarReplyAsycTask.access$2(KomentarPonsel.KomentarReplyAsycTask.this))).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(KomentarPonsel.KomentarReplyAsycTask.access$2(KomentarPonsel.KomentarReplyAsycTask.this));
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new KomentarPonsel.KomentarReplyAsycTask._cls2._cls1());
                view.setNeutralButton("Register", new KomentarPonsel.KomentarReplyAsycTask._cls2._cls2());
                view.setNegativeButton("Login", new KomentarPonsel.KomentarReplyAsycTask._cls2._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_komentarreplyasyctask;
                id_komentar = s;
                id_hp = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/KomentarPonsel$KomentarReplyAsycTask$2$2

/* anonymous class */
        class KomentarPonsel.KomentarReplyAsycTask._cls2._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final KomentarPonsel.KomentarReplyAsycTask._cls2 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(KomentarPonsel.KomentarReplyAsycTask.access$2(this$1), com/inponsel/android/v2/RegisterActivity);
                KomentarPonsel.KomentarReplyAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = KomentarPonsel.KomentarReplyAsycTask._cls2.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/KomentarPonsel$KomentarReplyAsycTask$2$3

/* anonymous class */
        class KomentarPonsel.KomentarReplyAsycTask._cls2._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final KomentarPonsel.KomentarReplyAsycTask._cls2 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(KomentarPonsel.KomentarReplyAsycTask.access$2(this$1), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                KomentarPonsel.KomentarReplyAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = KomentarPonsel.KomentarReplyAsycTask._cls2.this;
                        super();
                    }
        }

    }

}
