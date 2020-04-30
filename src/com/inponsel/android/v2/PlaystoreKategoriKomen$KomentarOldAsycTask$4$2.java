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
    implements android.content.ask._cls4._cls2
{

    final is._cls1 this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent(ss._mth2(_fld1), com/inponsel/android/v2/RegisterActivity);
        ss._mth2(_fld1).startActivity(dialoginterface);
    }

    l.id_kat()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/PlaystoreKategoriKomen$KomentarOldAsycTask$4

/* anonymous class */
    class PlaystoreKategoriKomen.KomentarOldAsycTask._cls4
        implements android.view.View.OnClickListener
    {

        final PlaystoreKategoriKomen.KomentarOldAsycTask this$1;
        private final String val$id_kat;
        private final String val$id_komrss;

        public void onClick(View view)
        {
            if (PlaystoreKategoriKomen.KomentarOldAsycTask.access$2(PlaystoreKategoriKomen.KomentarOldAsycTask.this).userFunctions.isUserLoggedIn(PlaystoreKategoriKomen.KomentarOldAsycTask.access$2(PlaystoreKategoriKomen.KomentarOldAsycTask.this)))
            {
                PlaystoreKategoriKomen.KomentarOldAsycTask.access$2(PlaystoreKategoriKomen.KomentarOldAsycTask.this).statuslike = "0";
                PlaystoreKategoriKomen.KomentarOldAsycTask.access$2(PlaystoreKategoriKomen.KomentarOldAsycTask.this).idkom_pos = id_komrss;
                PlaystoreKategoriKomen.KomentarOldAsycTask.access$2(PlaystoreKategoriKomen.KomentarOldAsycTask.this).querylike = (new StringBuilder("status=")).append(PlaystoreKategoriKomen.KomentarOldAsycTask.access$2(PlaystoreKategoriKomen.KomentarOldAsycTask.this).statuslike).append("&id_kom=").append(id_komrss).append("&id_kat=").append(id_kat).append("&id_usr=").append(PlaystoreKategoriKomen.KomentarOldAsycTask.access$2(PlaystoreKategoriKomen.KomentarOldAsycTask.this).user_id).append("&t=").append(PlaystoreKategoriKomen.KomentarOldAsycTask.access$2(PlaystoreKategoriKomen.KomentarOldAsycTask.this).t).toString();
                Log.e("querylike", PlaystoreKategoriKomen.KomentarOldAsycTask.access$2(PlaystoreKategoriKomen.KomentarOldAsycTask.this).querylike);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new PlaystoreKategoriKomen.PostBagusKurangTask(PlaystoreKategoriKomen.KomentarOldAsycTask.access$2(PlaystoreKategoriKomen.KomentarOldAsycTask.this))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new PlaystoreKategoriKomen.PostBagusKurangTask(PlaystoreKategoriKomen.KomentarOldAsycTask.access$2(PlaystoreKategoriKomen.KomentarOldAsycTask.this))).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(PlaystoreKategoriKomen.KomentarOldAsycTask.access$2(PlaystoreKategoriKomen.KomentarOldAsycTask.this));
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new PlaystoreKategoriKomen.KomentarOldAsycTask._cls4._cls1());
                view.setNeutralButton("Register", new PlaystoreKategoriKomen.KomentarOldAsycTask._cls4._cls2());
                view.setNegativeButton("Login", new PlaystoreKategoriKomen.KomentarOldAsycTask._cls4._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_komentaroldasyctask;
                id_komrss = s;
                id_kat = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/PlaystoreKategoriKomen$KomentarOldAsycTask$4$1

/* anonymous class */
        class PlaystoreKategoriKomen.KomentarOldAsycTask._cls4._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final PlaystoreKategoriKomen.KomentarOldAsycTask._cls4 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = PlaystoreKategoriKomen.KomentarOldAsycTask._cls4.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/PlaystoreKategoriKomen$KomentarOldAsycTask$4$3

/* anonymous class */
        class PlaystoreKategoriKomen.KomentarOldAsycTask._cls4._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final PlaystoreKategoriKomen.KomentarOldAsycTask._cls4 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(PlaystoreKategoriKomen.KomentarOldAsycTask.access$2(this$1), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                PlaystoreKategoriKomen.KomentarOldAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = PlaystoreKategoriKomen.KomentarOldAsycTask._cls4.this;
                        super();
                    }
        }

    }

}
