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
//            KomentarPonsel, LoginActivity, RegisterActivity

class this._cls2
    implements android.content.ask._cls4._cls3
{

    final is._cls1 this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent(ss._mth2(_fld1), com/inponsel/android/v2/LoginActivity);
        dialoginterface.putExtra("activity", "main");
        ss._mth2(_fld1).startActivity(dialoginterface);
    }

    l.id_hp()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/KomentarPonsel$KomentarNextAsycTask$4

/* anonymous class */
    class KomentarPonsel.KomentarNextAsycTask._cls4
        implements android.view.View.OnClickListener
    {

        final KomentarPonsel.KomentarNextAsycTask this$1;
        private final String val$id_hp;
        private final String val$id_komentar;

        public void onClick(View view)
        {
            if (KomentarPonsel.KomentarNextAsycTask.access$2(KomentarPonsel.KomentarNextAsycTask.this).userFunctions.isUserLoggedIn(KomentarPonsel.KomentarNextAsycTask.access$2(KomentarPonsel.KomentarNextAsycTask.this)))
            {
                KomentarPonsel.KomentarNextAsycTask.access$2(KomentarPonsel.KomentarNextAsycTask.this).statuslike = "0";
                KomentarPonsel.KomentarNextAsycTask.access$2(KomentarPonsel.KomentarNextAsycTask.this).idkom_pos = id_komentar;
                KomentarPonsel.KomentarNextAsycTask.access$2(KomentarPonsel.KomentarNextAsycTask.this).querylike = (new StringBuilder("status=")).append(KomentarPonsel.KomentarNextAsycTask.access$2(KomentarPonsel.KomentarNextAsycTask.this).statuslike).append("&id_komen=").append(id_komentar).append("&idhp=").append(id_hp).append("&email=").append(KomentarPonsel.KomentarNextAsycTask.access$2(KomentarPonsel.KomentarNextAsycTask.this).username).append("&t=").append(KomentarPonsel.KomentarNextAsycTask.access$2(KomentarPonsel.KomentarNextAsycTask.this).t).toString();
                Log.e("querylike", KomentarPonsel.KomentarNextAsycTask.access$2(KomentarPonsel.KomentarNextAsycTask.this).querylike);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new KomentarPonsel.PostBagusKurangTask(KomentarPonsel.KomentarNextAsycTask.access$2(KomentarPonsel.KomentarNextAsycTask.this))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new KomentarPonsel.PostBagusKurangTask(KomentarPonsel.KomentarNextAsycTask.access$2(KomentarPonsel.KomentarNextAsycTask.this))).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(KomentarPonsel.KomentarNextAsycTask.access$2(KomentarPonsel.KomentarNextAsycTask.this).wrapperLight);
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new KomentarPonsel.KomentarNextAsycTask._cls4._cls1());
                view.setNeutralButton("Register", new KomentarPonsel.KomentarNextAsycTask._cls4._cls2());
                view.setNegativeButton("Login", new KomentarPonsel.KomentarNextAsycTask._cls4._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_komentarnextasyctask;
                id_komentar = s;
                id_hp = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/KomentarPonsel$KomentarNextAsycTask$4$1

/* anonymous class */
        class KomentarPonsel.KomentarNextAsycTask._cls4._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final KomentarPonsel.KomentarNextAsycTask._cls4 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = KomentarPonsel.KomentarNextAsycTask._cls4.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/KomentarPonsel$KomentarNextAsycTask$4$2

/* anonymous class */
        class KomentarPonsel.KomentarNextAsycTask._cls4._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final KomentarPonsel.KomentarNextAsycTask._cls4 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(KomentarPonsel.KomentarNextAsycTask.access$2(this$1), com/inponsel/android/v2/RegisterActivity);
                KomentarPonsel.KomentarNextAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = KomentarPonsel.KomentarNextAsycTask._cls4.this;
                        super();
                    }
        }

    }

}
