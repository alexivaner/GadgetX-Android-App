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
//            Hal3KomentarPull

class this._cls2
    implements android.content.AsycTask._cls5._cls2
{

    final is._cls1 this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent(ss._mth2(_fld1).getActivity(), com/inponsel/android/v2/RegisterActivity);
        ss._mth2(_fld1).startActivity(dialoginterface);
    }

    l.id_hp()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/details/Hal3KomentarPull$KomentarOldAsycTask$5

/* anonymous class */
    class Hal3KomentarPull.KomentarOldAsycTask._cls5
        implements android.view.View.OnClickListener
    {

        final Hal3KomentarPull.KomentarOldAsycTask this$1;
        private final String val$id_hp;
        private final String val$id_komentar;

        public void onClick(View view)
        {
            if (Hal3KomentarPull.KomentarOldAsycTask.access$2(Hal3KomentarPull.KomentarOldAsycTask.this).userFunctions.isUserLoggedIn(Hal3KomentarPull.KomentarOldAsycTask.access$2(Hal3KomentarPull.KomentarOldAsycTask.this).getActivity()))
            {
                Hal3KomentarPull.KomentarOldAsycTask.access$2(Hal3KomentarPull.KomentarOldAsycTask.this).statuslike = "0";
                Hal3KomentarPull.KomentarOldAsycTask.access$2(Hal3KomentarPull.KomentarOldAsycTask.this).idkom_pos = id_komentar;
                Hal3KomentarPull.KomentarOldAsycTask.access$2(Hal3KomentarPull.KomentarOldAsycTask.this).querylike = (new StringBuilder("status=")).append(Hal3KomentarPull.KomentarOldAsycTask.access$2(Hal3KomentarPull.KomentarOldAsycTask.this).statuslike).append("&id_komen=").append(id_komentar).append("&idhp=").append(id_hp).append("&email=").append(Hal3KomentarPull.KomentarOldAsycTask.access$2(Hal3KomentarPull.KomentarOldAsycTask.this).username).append("&id_user=").append(Hal3KomentarPull.KomentarOldAsycTask.access$2(Hal3KomentarPull.KomentarOldAsycTask.this).user_id).append("&t=").append(Hal3KomentarPull.KomentarOldAsycTask.access$2(Hal3KomentarPull.KomentarOldAsycTask.this).t).toString();
                Log.e("querylike", Hal3KomentarPull.KomentarOldAsycTask.access$2(Hal3KomentarPull.KomentarOldAsycTask.this).querylike);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new Hal3KomentarPull.PostBagusKurangTask(Hal3KomentarPull.KomentarOldAsycTask.access$2(Hal3KomentarPull.KomentarOldAsycTask.this))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new Hal3KomentarPull.PostBagusKurangTask(Hal3KomentarPull.KomentarOldAsycTask.access$2(Hal3KomentarPull.KomentarOldAsycTask.this))).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(Hal3KomentarPull.KomentarOldAsycTask.access$2(Hal3KomentarPull.KomentarOldAsycTask.this).wrapperLight);
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new Hal3KomentarPull.KomentarOldAsycTask._cls5._cls1());
                view.setNeutralButton("Register", new Hal3KomentarPull.KomentarOldAsycTask._cls5._cls2());
                view.setNegativeButton("Login", new Hal3KomentarPull.KomentarOldAsycTask._cls5._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_komentaroldasyctask;
                id_komentar = s;
                id_hp = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/details/Hal3KomentarPull$KomentarOldAsycTask$5$1

/* anonymous class */
        class Hal3KomentarPull.KomentarOldAsycTask._cls5._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal3KomentarPull.KomentarOldAsycTask._cls5 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = Hal3KomentarPull.KomentarOldAsycTask._cls5.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/details/Hal3KomentarPull$KomentarOldAsycTask$5$3

/* anonymous class */
        class Hal3KomentarPull.KomentarOldAsycTask._cls5._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal3KomentarPull.KomentarOldAsycTask._cls5 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(Hal3KomentarPull.KomentarOldAsycTask.access$2(this$1).getActivity(), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                Hal3KomentarPull.KomentarOldAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = Hal3KomentarPull.KomentarOldAsycTask._cls5.this;
                        super();
                    }
        }

    }

}
