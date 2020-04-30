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
    implements android.content.ask._cls4._cls1
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

    // Unreferenced inner class com/inponsel/android/v2/PlaystoreKategoriKomen$KomentarAsycAfterTask$4

/* anonymous class */
    class PlaystoreKategoriKomen.KomentarAsycAfterTask._cls4
        implements android.view.View.OnClickListener
    {

        final PlaystoreKategoriKomen.KomentarAsycAfterTask this$1;
        private final String val$id_kat;
        private final String val$id_komrss;

        public void onClick(View view)
        {
            if (PlaystoreKategoriKomen.KomentarAsycAfterTask.access$2(PlaystoreKategoriKomen.KomentarAsycAfterTask.this).userFunctions.isUserLoggedIn(PlaystoreKategoriKomen.KomentarAsycAfterTask.access$2(PlaystoreKategoriKomen.KomentarAsycAfterTask.this)))
            {
                PlaystoreKategoriKomen.KomentarAsycAfterTask.access$2(PlaystoreKategoriKomen.KomentarAsycAfterTask.this).statuslike = "0";
                PlaystoreKategoriKomen.KomentarAsycAfterTask.access$2(PlaystoreKategoriKomen.KomentarAsycAfterTask.this).idkom_pos = id_komrss;
                PlaystoreKategoriKomen.KomentarAsycAfterTask.access$2(PlaystoreKategoriKomen.KomentarAsycAfterTask.this).querylike = (new StringBuilder("status=")).append(PlaystoreKategoriKomen.KomentarAsycAfterTask.access$2(PlaystoreKategoriKomen.KomentarAsycAfterTask.this).statuslike).append("&id_kom=").append(id_komrss).append("&id_kat=").append(id_kat).append("&id_usr=").append(PlaystoreKategoriKomen.KomentarAsycAfterTask.access$2(PlaystoreKategoriKomen.KomentarAsycAfterTask.this).user_id).append("&t=").append(PlaystoreKategoriKomen.KomentarAsycAfterTask.access$2(PlaystoreKategoriKomen.KomentarAsycAfterTask.this).t).toString();
                Log.e("querylike", PlaystoreKategoriKomen.KomentarAsycAfterTask.access$2(PlaystoreKategoriKomen.KomentarAsycAfterTask.this).querylike);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new PlaystoreKategoriKomen.PostBagusKurangTask(PlaystoreKategoriKomen.KomentarAsycAfterTask.access$2(PlaystoreKategoriKomen.KomentarAsycAfterTask.this))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new PlaystoreKategoriKomen.PostBagusKurangTask(PlaystoreKategoriKomen.KomentarAsycAfterTask.access$2(PlaystoreKategoriKomen.KomentarAsycAfterTask.this))).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(PlaystoreKategoriKomen.KomentarAsycAfterTask.access$2(PlaystoreKategoriKomen.KomentarAsycAfterTask.this));
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new PlaystoreKategoriKomen.KomentarAsycAfterTask._cls4._cls1());
                view.setNeutralButton("Register", new PlaystoreKategoriKomen.KomentarAsycAfterTask._cls4._cls2());
                view.setNegativeButton("Login", new PlaystoreKategoriKomen.KomentarAsycAfterTask._cls4._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_komentarasycaftertask;
                id_komrss = s;
                id_kat = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/PlaystoreKategoriKomen$KomentarAsycAfterTask$4$2

/* anonymous class */
        class PlaystoreKategoriKomen.KomentarAsycAfterTask._cls4._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final PlaystoreKategoriKomen.KomentarAsycAfterTask._cls4 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(PlaystoreKategoriKomen.KomentarAsycAfterTask.access$2(this$1), com/inponsel/android/v2/RegisterActivity);
                PlaystoreKategoriKomen.KomentarAsycAfterTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = PlaystoreKategoriKomen.KomentarAsycAfterTask._cls4.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/PlaystoreKategoriKomen$KomentarAsycAfterTask$4$3

/* anonymous class */
        class PlaystoreKategoriKomen.KomentarAsycAfterTask._cls4._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final PlaystoreKategoriKomen.KomentarAsycAfterTask._cls4 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(PlaystoreKategoriKomen.KomentarAsycAfterTask.access$2(this$1), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                PlaystoreKategoriKomen.KomentarAsycAfterTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = PlaystoreKategoriKomen.KomentarAsycAfterTask._cls4.this;
                        super();
                    }
        }

    }

}
