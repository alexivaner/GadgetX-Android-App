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
    implements android.content.men._cls3._cls3
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

    // Unreferenced inner class com/inponsel/android/v2/PlaystoreKategoriKomen$PostKomen$3

/* anonymous class */
    class PlaystoreKategoriKomen.PostKomen._cls3
        implements android.view.View.OnClickListener
    {

        final PlaystoreKategoriKomen.PostKomen this$1;
        private final String val$id_kat;
        private final String val$id_komrss;

        public void onClick(View view)
        {
            if (PlaystoreKategoriKomen.PostKomen.access$2(PlaystoreKategoriKomen.PostKomen.this).userFunctions.isUserLoggedIn(PlaystoreKategoriKomen.PostKomen.access$2(PlaystoreKategoriKomen.PostKomen.this)))
            {
                PlaystoreKategoriKomen.PostKomen.access$2(PlaystoreKategoriKomen.PostKomen.this).statuslike = "1";
                PlaystoreKategoriKomen.PostKomen.access$2(PlaystoreKategoriKomen.PostKomen.this).idkom_pos = id_komrss;
                PlaystoreKategoriKomen.PostKomen.access$2(PlaystoreKategoriKomen.PostKomen.this).querylike = (new StringBuilder("status=")).append(PlaystoreKategoriKomen.PostKomen.access$2(PlaystoreKategoriKomen.PostKomen.this).statuslike).append("&id_kom=").append(id_komrss).append("&id_kat=").append(id_kat).append("&id_usr=").append(PlaystoreKategoriKomen.PostKomen.access$2(PlaystoreKategoriKomen.PostKomen.this).user_id).append("&t=").append(PlaystoreKategoriKomen.PostKomen.access$2(PlaystoreKategoriKomen.PostKomen.this).t).toString();
                Log.e("querylike", PlaystoreKategoriKomen.PostKomen.access$2(PlaystoreKategoriKomen.PostKomen.this).querylike);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new PlaystoreKategoriKomen.PostBagusKurangTask(PlaystoreKategoriKomen.PostKomen.access$2(PlaystoreKategoriKomen.PostKomen.this))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new PlaystoreKategoriKomen.PostBagusKurangTask(PlaystoreKategoriKomen.PostKomen.access$2(PlaystoreKategoriKomen.PostKomen.this))).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(PlaystoreKategoriKomen.PostKomen.access$2(PlaystoreKategoriKomen.PostKomen.this));
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new PlaystoreKategoriKomen.PostKomen._cls3._cls1());
                view.setNeutralButton("Register", new PlaystoreKategoriKomen.PostKomen._cls3._cls2());
                view.setNegativeButton("Login", new PlaystoreKategoriKomen.PostKomen._cls3._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_postkomen;
                id_komrss = s;
                id_kat = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/PlaystoreKategoriKomen$PostKomen$3$1

/* anonymous class */
        class PlaystoreKategoriKomen.PostKomen._cls3._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final PlaystoreKategoriKomen.PostKomen._cls3 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = PlaystoreKategoriKomen.PostKomen._cls3.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/PlaystoreKategoriKomen$PostKomen$3$2

/* anonymous class */
        class PlaystoreKategoriKomen.PostKomen._cls3._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final PlaystoreKategoriKomen.PostKomen._cls3 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(PlaystoreKategoriKomen.PostKomen.access$2(this$1), com/inponsel/android/v2/RegisterActivity);
                PlaystoreKategoriKomen.PostKomen.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = PlaystoreKategoriKomen.PostKomen._cls3.this;
                        super();
                    }
        }

    }

}
