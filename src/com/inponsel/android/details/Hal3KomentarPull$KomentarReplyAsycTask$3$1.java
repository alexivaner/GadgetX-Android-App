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
    implements android.content.AsycTask._cls3._cls1
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

    // Unreferenced inner class com/inponsel/android/details/Hal3KomentarPull$KomentarReplyAsycTask$3

/* anonymous class */
    class Hal3KomentarPull.KomentarReplyAsycTask._cls3
        implements android.view.View.OnClickListener
    {

        final Hal3KomentarPull.KomentarReplyAsycTask this$1;
        private final String val$id_hp;
        private final String val$id_komentar;

        public void onClick(View view)
        {
            if (Hal3KomentarPull.KomentarReplyAsycTask.access$2(Hal3KomentarPull.KomentarReplyAsycTask.this).userFunctions.isUserLoggedIn(Hal3KomentarPull.KomentarReplyAsycTask.access$2(Hal3KomentarPull.KomentarReplyAsycTask.this).getActivity()))
            {
                Hal3KomentarPull.KomentarReplyAsycTask.access$2(Hal3KomentarPull.KomentarReplyAsycTask.this).statuslike = "0";
                Hal3KomentarPull.KomentarReplyAsycTask.access$2(Hal3KomentarPull.KomentarReplyAsycTask.this).idkom_pos = id_komentar;
                Hal3KomentarPull.KomentarReplyAsycTask.access$2(Hal3KomentarPull.KomentarReplyAsycTask.this).querylike = (new StringBuilder("status=")).append(Hal3KomentarPull.KomentarReplyAsycTask.access$2(Hal3KomentarPull.KomentarReplyAsycTask.this).statuslike).append("&id_komen=").append(id_komentar).append("&idhp=").append(id_hp).append("&email=").append(Hal3KomentarPull.KomentarReplyAsycTask.access$2(Hal3KomentarPull.KomentarReplyAsycTask.this).username).append("&id_user=").append(Hal3KomentarPull.KomentarReplyAsycTask.access$2(Hal3KomentarPull.KomentarReplyAsycTask.this).user_id).append("&t=").append(Hal3KomentarPull.KomentarReplyAsycTask.access$2(Hal3KomentarPull.KomentarReplyAsycTask.this).t).toString();
                Log.e("querylike", Hal3KomentarPull.KomentarReplyAsycTask.access$2(Hal3KomentarPull.KomentarReplyAsycTask.this).querylike);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new Hal3KomentarPull.PostBagusKurangTask(Hal3KomentarPull.KomentarReplyAsycTask.access$2(Hal3KomentarPull.KomentarReplyAsycTask.this))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new Hal3KomentarPull.PostBagusKurangTask(Hal3KomentarPull.KomentarReplyAsycTask.access$2(Hal3KomentarPull.KomentarReplyAsycTask.this))).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(Hal3KomentarPull.KomentarReplyAsycTask.access$2(Hal3KomentarPull.KomentarReplyAsycTask.this).getActivity());
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new Hal3KomentarPull.KomentarReplyAsycTask._cls3._cls1());
                view.setNeutralButton("Register", new Hal3KomentarPull.KomentarReplyAsycTask._cls3._cls2());
                view.setNegativeButton("Login", new Hal3KomentarPull.KomentarReplyAsycTask._cls3._cls3());
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

        // Unreferenced inner class com/inponsel/android/details/Hal3KomentarPull$KomentarReplyAsycTask$3$2

/* anonymous class */
        class Hal3KomentarPull.KomentarReplyAsycTask._cls3._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal3KomentarPull.KomentarReplyAsycTask._cls3 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(Hal3KomentarPull.KomentarReplyAsycTask.access$2(this$1).getActivity(), com/inponsel/android/v2/RegisterActivity);
                Hal3KomentarPull.KomentarReplyAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = Hal3KomentarPull.KomentarReplyAsycTask._cls3.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/details/Hal3KomentarPull$KomentarReplyAsycTask$3$3

/* anonymous class */
        class Hal3KomentarPull.KomentarReplyAsycTask._cls3._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal3KomentarPull.KomentarReplyAsycTask._cls3 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(Hal3KomentarPull.KomentarReplyAsycTask.access$2(this$1).getActivity(), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                Hal3KomentarPull.KomentarReplyAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = Hal3KomentarPull.KomentarReplyAsycTask._cls3.this;
                        super();
                    }
        }

    }

}
