// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.scdetail;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;

// Referenced classes of package com.inponsel.android.scdetail:
//            Hal1SCDetail

class this._cls2
    implements android.content.rAsycTask._cls3._cls3
{

    final is._cls1 this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent(ss._mth2(_fld1).getActivity(), com/inponsel/android/v2/LoginActivity);
        dialoginterface.putExtra("activity", "main");
        ss._mth2(_fld1).startActivity(dialoginterface);
    }

    l.id_komrss()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/scdetail/Hal1SCDetail$KomentarAsycTask$3

/* anonymous class */
    class Hal1SCDetail.KomentarAsycTask._cls3
        implements android.view.View.OnClickListener
    {

        final Hal1SCDetail.KomentarAsycTask this$1;
        private final String val$id_komrss;

        public void onClick(View view)
        {
            if (Hal1SCDetail.KomentarAsycTask.access$2(Hal1SCDetail.KomentarAsycTask.this).userFunctions.isUserLoggedIn(Hal1SCDetail.KomentarAsycTask.access$2(Hal1SCDetail.KomentarAsycTask.this).getActivity()))
            {
                Hal1SCDetail.KomentarAsycTask.access$2(Hal1SCDetail.KomentarAsycTask.this).statuslike = "1";
                Hal1SCDetail.KomentarAsycTask.access$2(Hal1SCDetail.KomentarAsycTask.this).idkom_pos = id_komrss;
                Hal1SCDetail.KomentarAsycTask.access$2(Hal1SCDetail.KomentarAsycTask.this).querylikeKomen = (new StringBuilder("status=")).append(Hal1SCDetail.KomentarAsycTask.access$2(Hal1SCDetail.KomentarAsycTask.this).statuslike).append("&idkomen=").append(Hal1SCDetail.KomentarAsycTask.access$2(Hal1SCDetail.KomentarAsycTask.this).idkom_pos).append("&idsc=").append(Hal1SCDetail.KomentarAsycTask.access$2(Hal1SCDetail.KomentarAsycTask.this).str_SC_ID).append("&idusr=").append(Hal1SCDetail.KomentarAsycTask.access$2(Hal1SCDetail.KomentarAsycTask.this).user_id).append("&t=").append(Hal1SCDetail.KomentarAsycTask.access$2(Hal1SCDetail.KomentarAsycTask.this).t).toString();
                Log.e("querylike", Hal1SCDetail.KomentarAsycTask.access$2(Hal1SCDetail.KomentarAsycTask.this).querylikeKomen);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new Hal1SCDetail.PostBagusKurangKomenTask(Hal1SCDetail.KomentarAsycTask.access$2(Hal1SCDetail.KomentarAsycTask.this))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new Hal1SCDetail.PostBagusKurangKomenTask(Hal1SCDetail.KomentarAsycTask.access$2(Hal1SCDetail.KomentarAsycTask.this))).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(Hal1SCDetail.KomentarAsycTask.access$2(Hal1SCDetail.KomentarAsycTask.this).getActivity());
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new Hal1SCDetail.KomentarAsycTask._cls3._cls1());
                view.setNeutralButton("Register", new Hal1SCDetail.KomentarAsycTask._cls3._cls2());
                view.setNegativeButton("Login", new Hal1SCDetail.KomentarAsycTask._cls3._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_komentarasyctask;
                id_komrss = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/scdetail/Hal1SCDetail$KomentarAsycTask$3$1

/* anonymous class */
        class Hal1SCDetail.KomentarAsycTask._cls3._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal1SCDetail.KomentarAsycTask._cls3 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = Hal1SCDetail.KomentarAsycTask._cls3.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/scdetail/Hal1SCDetail$KomentarAsycTask$3$2

/* anonymous class */
        class Hal1SCDetail.KomentarAsycTask._cls3._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal1SCDetail.KomentarAsycTask._cls3 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(Hal1SCDetail.KomentarAsycTask.access$2(this$1).getActivity(), com/inponsel/android/v2/RegisterActivity);
                Hal1SCDetail.KomentarAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = Hal1SCDetail.KomentarAsycTask._cls3.this;
                        super();
                    }
        }

    }

}
