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
//            PlaystoreKategoriKomen, RegisterActivity, LoginActivity

class this._cls2
    implements android.content.ask._cls1._cls1
{

    final this._cls2 this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }

    l.id_kat()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/PlaystoreKategoriKomen$KomentarNextAsycTask$1

/* anonymous class */
    class PlaystoreKategoriKomen.KomentarNextAsycTask._cls1
        implements android.view.View.OnClickListener
    {

        final PlaystoreKategoriKomen.KomentarNextAsycTask this$1;
        private final String val$id_kat;
        private final String val$id_komrss;

        public void onClick(View view)
        {
            if (PlaystoreKategoriKomen.KomentarNextAsycTask.access$2(PlaystoreKategoriKomen.KomentarNextAsycTask.this).userFunctions.isUserLoggedIn(PlaystoreKategoriKomen.KomentarNextAsycTask.access$2(PlaystoreKategoriKomen.KomentarNextAsycTask.this)))
            {
                PlaystoreKategoriKomen.KomentarNextAsycTask.access$2(PlaystoreKategoriKomen.KomentarNextAsycTask.this).statuslike = "1";
                PlaystoreKategoriKomen.KomentarNextAsycTask.access$2(PlaystoreKategoriKomen.KomentarNextAsycTask.this).idkom_pos = id_komrss;
                PlaystoreKategoriKomen.KomentarNextAsycTask.access$2(PlaystoreKategoriKomen.KomentarNextAsycTask.this).querylike = (new StringBuilder("status=")).append(PlaystoreKategoriKomen.KomentarNextAsycTask.access$2(PlaystoreKategoriKomen.KomentarNextAsycTask.this).statuslike).append("&id_kom=").append(id_komrss).append("&id_kat=").append(id_kat).append("&id_usr=").append(PlaystoreKategoriKomen.KomentarNextAsycTask.access$2(PlaystoreKategoriKomen.KomentarNextAsycTask.this).user_id).append("&t=").append(PlaystoreKategoriKomen.KomentarNextAsycTask.access$2(PlaystoreKategoriKomen.KomentarNextAsycTask.this).t).toString();
                Log.e("querylike", PlaystoreKategoriKomen.KomentarNextAsycTask.access$2(PlaystoreKategoriKomen.KomentarNextAsycTask.this).querylike);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new PlaystoreKategoriKomen.PostBagusKurangTask(PlaystoreKategoriKomen.KomentarNextAsycTask.access$2(PlaystoreKategoriKomen.KomentarNextAsycTask.this))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new PlaystoreKategoriKomen.PostBagusKurangTask(PlaystoreKategoriKomen.KomentarNextAsycTask.access$2(PlaystoreKategoriKomen.KomentarNextAsycTask.this))).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(PlaystoreKategoriKomen.KomentarNextAsycTask.access$2(PlaystoreKategoriKomen.KomentarNextAsycTask.this));
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new PlaystoreKategoriKomen.KomentarNextAsycTask._cls1._cls1());
                view.setNeutralButton("Register", new PlaystoreKategoriKomen.KomentarNextAsycTask._cls1._cls2());
                view.setNegativeButton("Login", new PlaystoreKategoriKomen.KomentarNextAsycTask._cls1._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_komentarnextasyctask;
                id_komrss = s;
                id_kat = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/PlaystoreKategoriKomen$KomentarNextAsycTask$1$2

/* anonymous class */
        class PlaystoreKategoriKomen.KomentarNextAsycTask._cls1._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final PlaystoreKategoriKomen.KomentarNextAsycTask._cls1 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(PlaystoreKategoriKomen.KomentarNextAsycTask.access$2(this$1), com/inponsel/android/v2/RegisterActivity);
                PlaystoreKategoriKomen.KomentarNextAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = PlaystoreKategoriKomen.KomentarNextAsycTask._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/PlaystoreKategoriKomen$KomentarNextAsycTask$1$3

/* anonymous class */
        class PlaystoreKategoriKomen.KomentarNextAsycTask._cls1._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final PlaystoreKategoriKomen.KomentarNextAsycTask._cls1 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(PlaystoreKategoriKomen.KomentarNextAsycTask.access$2(this$1), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                PlaystoreKategoriKomen.KomentarNextAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = PlaystoreKategoriKomen.KomentarNextAsycTask._cls1.this;
                        super();
                    }
        }

    }

}
