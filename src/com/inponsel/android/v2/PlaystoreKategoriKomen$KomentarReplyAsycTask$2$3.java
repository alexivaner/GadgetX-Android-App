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
//            PlaystoreKategoriKomen, LoginActivity, RegisterActivity

class this._cls2
    implements android.content.ask._cls2._cls3
{

    final is._cls1 this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent(ss._mth2(_fld1), com/inponsel/android/v2/LoginActivity);
        dialoginterface.putExtra("activity", "main");
        ss._mth2(_fld1).startActivity(dialoginterface);
    }

    l.id_kat()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/PlaystoreKategoriKomen$KomentarReplyAsycTask$2

/* anonymous class */
    class PlaystoreKategoriKomen.KomentarReplyAsycTask._cls2
        implements android.view.View.OnClickListener
    {

        final PlaystoreKategoriKomen.KomentarReplyAsycTask this$1;
        private final String val$id_kat;
        private final String val$id_komrss;

        public void onClick(View view)
        {
            if (PlaystoreKategoriKomen.KomentarReplyAsycTask.access$2(PlaystoreKategoriKomen.KomentarReplyAsycTask.this).userFunctions.isUserLoggedIn(PlaystoreKategoriKomen.KomentarReplyAsycTask.access$2(PlaystoreKategoriKomen.KomentarReplyAsycTask.this)))
            {
                PlaystoreKategoriKomen.KomentarReplyAsycTask.access$2(PlaystoreKategoriKomen.KomentarReplyAsycTask.this).statuslike = "0";
                PlaystoreKategoriKomen.KomentarReplyAsycTask.access$2(PlaystoreKategoriKomen.KomentarReplyAsycTask.this).idkom_pos = id_komrss;
                PlaystoreKategoriKomen.KomentarReplyAsycTask.access$2(PlaystoreKategoriKomen.KomentarReplyAsycTask.this).querylike = (new StringBuilder("status=")).append(PlaystoreKategoriKomen.KomentarReplyAsycTask.access$2(PlaystoreKategoriKomen.KomentarReplyAsycTask.this).statuslike).append("&id_kom=").append(id_komrss).append("&id_kat=").append(id_kat).append("&id_usr=").append(PlaystoreKategoriKomen.KomentarReplyAsycTask.access$2(PlaystoreKategoriKomen.KomentarReplyAsycTask.this).user_id).append("&t=").append(PlaystoreKategoriKomen.KomentarReplyAsycTask.access$2(PlaystoreKategoriKomen.KomentarReplyAsycTask.this).t).toString();
                Log.e("querylike", PlaystoreKategoriKomen.KomentarReplyAsycTask.access$2(PlaystoreKategoriKomen.KomentarReplyAsycTask.this).querylike);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new PlaystoreKategoriKomen.PostBagusKurangTask(PlaystoreKategoriKomen.KomentarReplyAsycTask.access$2(PlaystoreKategoriKomen.KomentarReplyAsycTask.this))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new PlaystoreKategoriKomen.PostBagusKurangTask(PlaystoreKategoriKomen.KomentarReplyAsycTask.access$2(PlaystoreKategoriKomen.KomentarReplyAsycTask.this))).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(PlaystoreKategoriKomen.KomentarReplyAsycTask.access$2(PlaystoreKategoriKomen.KomentarReplyAsycTask.this));
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new PlaystoreKategoriKomen.KomentarReplyAsycTask._cls2._cls1());
                view.setNeutralButton("Register", new PlaystoreKategoriKomen.KomentarReplyAsycTask._cls2._cls2());
                view.setNegativeButton("Login", new PlaystoreKategoriKomen.KomentarReplyAsycTask._cls2._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_komentarreplyasyctask;
                id_komrss = s;
                id_kat = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/PlaystoreKategoriKomen$KomentarReplyAsycTask$2$1

/* anonymous class */
        class PlaystoreKategoriKomen.KomentarReplyAsycTask._cls2._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final PlaystoreKategoriKomen.KomentarReplyAsycTask._cls2 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = PlaystoreKategoriKomen.KomentarReplyAsycTask._cls2.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/PlaystoreKategoriKomen$KomentarReplyAsycTask$2$2

/* anonymous class */
        class PlaystoreKategoriKomen.KomentarReplyAsycTask._cls2._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final PlaystoreKategoriKomen.KomentarReplyAsycTask._cls2 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(PlaystoreKategoriKomen.KomentarReplyAsycTask.access$2(this$1), com/inponsel/android/v2/RegisterActivity);
                PlaystoreKategoriKomen.KomentarReplyAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = PlaystoreKategoriKomen.KomentarReplyAsycTask._cls2.this;
                        super();
                    }
        }

    }

}