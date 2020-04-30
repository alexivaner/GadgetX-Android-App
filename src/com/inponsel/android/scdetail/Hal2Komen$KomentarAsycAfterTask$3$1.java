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
//            Hal2Komen

class this._cls2
    implements android.content.AfterTask._cls3._cls1
{

    final this._cls2 this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }

    l.sc_id()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/scdetail/Hal2Komen$KomentarAsycAfterTask$3

/* anonymous class */
    class Hal2Komen.KomentarAsycAfterTask._cls3
        implements android.view.View.OnClickListener
    {

        final Hal2Komen.KomentarAsycAfterTask this$1;
        private final String val$id_komrss;
        private final String val$sc_id;

        public void onClick(View view)
        {
            if (Hal2Komen.KomentarAsycAfterTask.access$2(Hal2Komen.KomentarAsycAfterTask.this).userFunctions.isUserLoggedIn(Hal2Komen.KomentarAsycAfterTask.access$2(Hal2Komen.KomentarAsycAfterTask.this).getActivity()))
            {
                Hal2Komen.KomentarAsycAfterTask.access$2(Hal2Komen.KomentarAsycAfterTask.this).statuslike = "1";
                Hal2Komen.KomentarAsycAfterTask.access$2(Hal2Komen.KomentarAsycAfterTask.this).idkom_pos = id_komrss;
                Hal2Komen.KomentarAsycAfterTask.access$2(Hal2Komen.KomentarAsycAfterTask.this).querylike = (new StringBuilder("status=")).append(Hal2Komen.KomentarAsycAfterTask.access$2(Hal2Komen.KomentarAsycAfterTask.this).statuslike).append("&id_kom=").append(id_komrss).append("&idsc=").append(sc_id).append("&id_usr=").append(Hal2Komen.KomentarAsycAfterTask.access$2(Hal2Komen.KomentarAsycAfterTask.this).user_id).append("&t=").append(Hal2Komen.KomentarAsycAfterTask.access$2(Hal2Komen.KomentarAsycAfterTask.this).t).toString();
                Log.e("querylike", Hal2Komen.KomentarAsycAfterTask.access$2(Hal2Komen.KomentarAsycAfterTask.this).querylike);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new Hal2Komen.PostBagusKurangTask(Hal2Komen.KomentarAsycAfterTask.access$2(Hal2Komen.KomentarAsycAfterTask.this))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new Hal2Komen.PostBagusKurangTask(Hal2Komen.KomentarAsycAfterTask.access$2(Hal2Komen.KomentarAsycAfterTask.this))).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(Hal2Komen.KomentarAsycAfterTask.access$2(Hal2Komen.KomentarAsycAfterTask.this).getActivity());
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new Hal2Komen.KomentarAsycAfterTask._cls3._cls1());
                view.setNeutralButton("Register", new Hal2Komen.KomentarAsycAfterTask._cls3._cls2());
                view.setNegativeButton("Login", new Hal2Komen.KomentarAsycAfterTask._cls3._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_komentarasycaftertask;
                id_komrss = s;
                sc_id = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/scdetail/Hal2Komen$KomentarAsycAfterTask$3$2

/* anonymous class */
        class Hal2Komen.KomentarAsycAfterTask._cls3._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal2Komen.KomentarAsycAfterTask._cls3 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(Hal2Komen.KomentarAsycAfterTask.access$2(this$1).getActivity(), com/inponsel/android/v2/RegisterActivity);
                Hal2Komen.KomentarAsycAfterTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = Hal2Komen.KomentarAsycAfterTask._cls3.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/scdetail/Hal2Komen$KomentarAsycAfterTask$3$3

/* anonymous class */
        class Hal2Komen.KomentarAsycAfterTask._cls3._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal2Komen.KomentarAsycAfterTask._cls3 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(Hal2Komen.KomentarAsycAfterTask.access$2(this$1).getActivity(), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                Hal2Komen.KomentarAsycAfterTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = Hal2Komen.KomentarAsycAfterTask._cls3.this;
                        super();
                    }
        }

    }

}
