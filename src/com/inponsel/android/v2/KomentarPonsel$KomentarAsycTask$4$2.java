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
    implements android.content.ask._cls4._cls2
{

    final is._cls1 this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent(ss._mth2(_fld1), com/inponsel/android/v2/RegisterActivity);
        ss._mth2(_fld1).startActivity(dialoginterface);
    }

    l.id_hp()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/KomentarPonsel$KomentarAsycTask$4

/* anonymous class */
    class KomentarPonsel.KomentarAsycTask._cls4
        implements android.view.View.OnClickListener
    {

        final KomentarPonsel.KomentarAsycTask this$1;
        private final String val$id_hp;
        private final String val$id_komentar;

        public void onClick(View view)
        {
            if (KomentarPonsel.KomentarAsycTask.access$2(KomentarPonsel.KomentarAsycTask.this).userFunctions.isUserLoggedIn(KomentarPonsel.KomentarAsycTask.access$2(KomentarPonsel.KomentarAsycTask.this)))
            {
                KomentarPonsel.KomentarAsycTask.access$2(KomentarPonsel.KomentarAsycTask.this).statuslike = "0";
                KomentarPonsel.KomentarAsycTask.access$2(KomentarPonsel.KomentarAsycTask.this).idkom_pos = id_komentar;
                KomentarPonsel.KomentarAsycTask.access$2(KomentarPonsel.KomentarAsycTask.this).querylike = (new StringBuilder("status=")).append(KomentarPonsel.KomentarAsycTask.access$2(KomentarPonsel.KomentarAsycTask.this).statuslike).append("&id_komen=").append(id_komentar).append("&idhp=").append(id_hp).append("&email=").append(KomentarPonsel.KomentarAsycTask.access$2(KomentarPonsel.KomentarAsycTask.this).username).append("&id_user=").append(KomentarPonsel.KomentarAsycTask.access$2(KomentarPonsel.KomentarAsycTask.this).user_id).append("&t=").append(KomentarPonsel.KomentarAsycTask.access$2(KomentarPonsel.KomentarAsycTask.this).t).toString();
                Log.e("querylike", KomentarPonsel.KomentarAsycTask.access$2(KomentarPonsel.KomentarAsycTask.this).querylike);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new KomentarPonsel.PostBagusKurangTask(KomentarPonsel.KomentarAsycTask.access$2(KomentarPonsel.KomentarAsycTask.this))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new KomentarPonsel.PostBagusKurangTask(KomentarPonsel.KomentarAsycTask.access$2(KomentarPonsel.KomentarAsycTask.this))).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(KomentarPonsel.KomentarAsycTask.access$2(KomentarPonsel.KomentarAsycTask.this).wrapperLight);
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new KomentarPonsel.KomentarAsycTask._cls4._cls1());
                view.setNeutralButton("Register", new KomentarPonsel.KomentarAsycTask._cls4._cls2());
                view.setNegativeButton("Login", new KomentarPonsel.KomentarAsycTask._cls4._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_komentarasyctask;
                id_komentar = s;
                id_hp = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/KomentarPonsel$KomentarAsycTask$4$1

/* anonymous class */
        class KomentarPonsel.KomentarAsycTask._cls4._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final KomentarPonsel.KomentarAsycTask._cls4 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = KomentarPonsel.KomentarAsycTask._cls4.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/KomentarPonsel$KomentarAsycTask$4$3

/* anonymous class */
        class KomentarPonsel.KomentarAsycTask._cls4._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final KomentarPonsel.KomentarAsycTask._cls4 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(KomentarPonsel.KomentarAsycTask.access$2(this$1), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                KomentarPonsel.KomentarAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = KomentarPonsel.KomentarAsycTask._cls4.this;
                        super();
                    }
        }

    }

}
