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
    implements android.content.AsycTask._cls4._cls3
{

    final is._cls1 this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent(ss._mth2(_fld1).getActivity(), com/inponsel/android/v2/LoginActivity);
        dialoginterface.putExtra("activity", "main");
        ss._mth2(_fld1).startActivity(dialoginterface);
    }

    l.id_hp()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/details/Hal3KomentarPull$KomentarNextAsycTask$4

/* anonymous class */
    class Hal3KomentarPull.KomentarNextAsycTask._cls4
        implements android.view.View.OnClickListener
    {

        final Hal3KomentarPull.KomentarNextAsycTask this$1;
        private final String val$id_hp;
        private final String val$id_komentar;

        public void onClick(View view)
        {
            if (Hal3KomentarPull.KomentarNextAsycTask.access$2(Hal3KomentarPull.KomentarNextAsycTask.this).userFunctions.isUserLoggedIn(Hal3KomentarPull.KomentarNextAsycTask.access$2(Hal3KomentarPull.KomentarNextAsycTask.this).getActivity()))
            {
                Hal3KomentarPull.KomentarNextAsycTask.access$2(Hal3KomentarPull.KomentarNextAsycTask.this).statuslike = "1";
                Hal3KomentarPull.KomentarNextAsycTask.access$2(Hal3KomentarPull.KomentarNextAsycTask.this).idkom_pos = id_komentar;
                Hal3KomentarPull.KomentarNextAsycTask.access$2(Hal3KomentarPull.KomentarNextAsycTask.this).querylike = (new StringBuilder("status=")).append(Hal3KomentarPull.KomentarNextAsycTask.access$2(Hal3KomentarPull.KomentarNextAsycTask.this).statuslike).append("&id_komen=").append(id_komentar).append("&idhp=").append(id_hp).append("&email=").append(Hal3KomentarPull.KomentarNextAsycTask.access$2(Hal3KomentarPull.KomentarNextAsycTask.this).username).append("&t=").append(Hal3KomentarPull.KomentarNextAsycTask.access$2(Hal3KomentarPull.KomentarNextAsycTask.this).t).toString();
                Log.e("querylike", Hal3KomentarPull.KomentarNextAsycTask.access$2(Hal3KomentarPull.KomentarNextAsycTask.this).querylike);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new Hal3KomentarPull.PostBagusKurangTask(Hal3KomentarPull.KomentarNextAsycTask.access$2(Hal3KomentarPull.KomentarNextAsycTask.this))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new Hal3KomentarPull.PostBagusKurangTask(Hal3KomentarPull.KomentarNextAsycTask.access$2(Hal3KomentarPull.KomentarNextAsycTask.this))).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(Hal3KomentarPull.KomentarNextAsycTask.access$2(Hal3KomentarPull.KomentarNextAsycTask.this).wrapperLight);
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new Hal3KomentarPull.KomentarNextAsycTask._cls4._cls1());
                view.setNeutralButton("Register", new Hal3KomentarPull.KomentarNextAsycTask._cls4._cls2());
                view.setNegativeButton("Login", new Hal3KomentarPull.KomentarNextAsycTask._cls4._cls3());
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

        // Unreferenced inner class com/inponsel/android/details/Hal3KomentarPull$KomentarNextAsycTask$4$1

/* anonymous class */
        class Hal3KomentarPull.KomentarNextAsycTask._cls4._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal3KomentarPull.KomentarNextAsycTask._cls4 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = Hal3KomentarPull.KomentarNextAsycTask._cls4.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/details/Hal3KomentarPull$KomentarNextAsycTask$4$2

/* anonymous class */
        class Hal3KomentarPull.KomentarNextAsycTask._cls4._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal3KomentarPull.KomentarNextAsycTask._cls4 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(Hal3KomentarPull.KomentarNextAsycTask.access$2(this$1).getActivity(), com/inponsel/android/v2/RegisterActivity);
                Hal3KomentarPull.KomentarNextAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = Hal3KomentarPull.KomentarNextAsycTask._cls4.this;
                        super();
                    }
        }

    }

}
