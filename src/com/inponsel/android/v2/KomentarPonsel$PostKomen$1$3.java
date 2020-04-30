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
    implements android.content.er
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

    // Unreferenced inner class com/inponsel/android/v2/KomentarPonsel$PostKomen$1

/* anonymous class */
    class KomentarPonsel.PostKomen._cls1
        implements android.view.View.OnClickListener
    {

        final KomentarPonsel.PostKomen this$1;
        private final String val$id_hp;
        private final String val$id_komentar;

        public void onClick(View view)
        {
            if (KomentarPonsel.PostKomen.access$2(KomentarPonsel.PostKomen.this).userFunctions.isUserLoggedIn(KomentarPonsel.PostKomen.access$2(KomentarPonsel.PostKomen.this)))
            {
                KomentarPonsel.PostKomen.access$2(KomentarPonsel.PostKomen.this).statuslike = "1";
                KomentarPonsel.PostKomen.access$2(KomentarPonsel.PostKomen.this).idkom_pos = id_komentar;
                KomentarPonsel.PostKomen.access$2(KomentarPonsel.PostKomen.this).querylike = (new StringBuilder("status=")).append(KomentarPonsel.PostKomen.access$2(KomentarPonsel.PostKomen.this).statuslike).append("&id_komen=").append(id_komentar).append("&idhp=").append(id_hp).append("&email=").append(KomentarPonsel.PostKomen.access$2(KomentarPonsel.PostKomen.this).username).append("&id_user=").append(KomentarPonsel.PostKomen.access$2(KomentarPonsel.PostKomen.this).user_id).append("&t=").append(KomentarPonsel.PostKomen.access$2(KomentarPonsel.PostKomen.this).t).toString();
                Log.e("querylike", KomentarPonsel.PostKomen.access$2(KomentarPonsel.PostKomen.this).querylike);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new KomentarPonsel.PostBagusKurangTask(KomentarPonsel.PostKomen.access$2(KomentarPonsel.PostKomen.this))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new KomentarPonsel.PostBagusKurangTask(KomentarPonsel.PostKomen.access$2(KomentarPonsel.PostKomen.this))).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(KomentarPonsel.PostKomen.access$2(KomentarPonsel.PostKomen.this).wrapperLight);
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new KomentarPonsel.PostKomen._cls1._cls1());
                view.setNeutralButton("Register", new KomentarPonsel.PostKomen._cls1._cls2());
                view.setNegativeButton("Login", new KomentarPonsel.PostKomen._cls1._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_postkomen;
                id_komentar = s;
                id_hp = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/KomentarPonsel$PostKomen$1$1

/* anonymous class */
        class KomentarPonsel.PostKomen._cls1._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final KomentarPonsel.PostKomen._cls1 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = KomentarPonsel.PostKomen._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/KomentarPonsel$PostKomen$1$2

/* anonymous class */
        class KomentarPonsel.PostKomen._cls1._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final KomentarPonsel.PostKomen._cls1 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(KomentarPonsel.PostKomen.access$2(this$1), com/inponsel/android/v2/RegisterActivity);
                KomentarPonsel.PostKomen.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = KomentarPonsel.PostKomen._cls1.this;
                        super();
                    }
        }

    }

}
