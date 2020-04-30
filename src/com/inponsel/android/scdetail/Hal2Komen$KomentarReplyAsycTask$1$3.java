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
    implements android.content.yAsycTask._cls1._cls3
{

    final is._cls1 this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent(ss._mth2(_fld1).getActivity(), com/inponsel/android/v2/LoginActivity);
        dialoginterface.putExtra("activity", "main");
        ss._mth2(_fld1).startActivity(dialoginterface);
    }

    l.sc_id()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/scdetail/Hal2Komen$KomentarReplyAsycTask$1

/* anonymous class */
    class Hal2Komen.KomentarReplyAsycTask._cls1
        implements android.view.View.OnClickListener
    {

        final Hal2Komen.KomentarReplyAsycTask this$1;
        private final String val$id_komrss;
        private final String val$sc_id;

        public void onClick(View view)
        {
            if (Hal2Komen.KomentarReplyAsycTask.access$2(Hal2Komen.KomentarReplyAsycTask.this).userFunctions.isUserLoggedIn(Hal2Komen.KomentarReplyAsycTask.access$2(Hal2Komen.KomentarReplyAsycTask.this).getActivity()))
            {
                Hal2Komen.KomentarReplyAsycTask.access$2(Hal2Komen.KomentarReplyAsycTask.this).statuslike = "1";
                Hal2Komen.KomentarReplyAsycTask.access$2(Hal2Komen.KomentarReplyAsycTask.this).idkom_pos = id_komrss;
                Hal2Komen.KomentarReplyAsycTask.access$2(Hal2Komen.KomentarReplyAsycTask.this).querylike = (new StringBuilder("status=")).append(Hal2Komen.KomentarReplyAsycTask.access$2(Hal2Komen.KomentarReplyAsycTask.this).statuslike).append("&idkomen=").append(Hal2Komen.KomentarReplyAsycTask.access$2(Hal2Komen.KomentarReplyAsycTask.this).idkom_pos).append("&idsc=").append(sc_id).append("&idusr=").append(Hal2Komen.KomentarReplyAsycTask.access$2(Hal2Komen.KomentarReplyAsycTask.this).user_id).append("&t=").append(Hal2Komen.KomentarReplyAsycTask.access$2(Hal2Komen.KomentarReplyAsycTask.this).t).toString();
                Log.e("querylike", Hal2Komen.KomentarReplyAsycTask.access$2(Hal2Komen.KomentarReplyAsycTask.this).querylike);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new Hal2Komen.PostBagusKurangTask(Hal2Komen.KomentarReplyAsycTask.access$2(Hal2Komen.KomentarReplyAsycTask.this))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new Hal2Komen.PostBagusKurangTask(Hal2Komen.KomentarReplyAsycTask.access$2(Hal2Komen.KomentarReplyAsycTask.this))).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(Hal2Komen.KomentarReplyAsycTask.access$2(Hal2Komen.KomentarReplyAsycTask.this).getActivity());
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new Hal2Komen.KomentarReplyAsycTask._cls1._cls1());
                view.setNeutralButton("Register", new Hal2Komen.KomentarReplyAsycTask._cls1._cls2());
                view.setNegativeButton("Login", new Hal2Komen.KomentarReplyAsycTask._cls1._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_komentarreplyasyctask;
                id_komrss = s;
                sc_id = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/scdetail/Hal2Komen$KomentarReplyAsycTask$1$1

/* anonymous class */
        class Hal2Komen.KomentarReplyAsycTask._cls1._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal2Komen.KomentarReplyAsycTask._cls1 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = Hal2Komen.KomentarReplyAsycTask._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/scdetail/Hal2Komen$KomentarReplyAsycTask$1$2

/* anonymous class */
        class Hal2Komen.KomentarReplyAsycTask._cls1._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal2Komen.KomentarReplyAsycTask._cls1 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(Hal2Komen.KomentarReplyAsycTask.access$2(this$1).getActivity(), com/inponsel/android/v2/RegisterActivity);
                Hal2Komen.KomentarReplyAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = Hal2Komen.KomentarReplyAsycTask._cls1.this;
                        super();
                    }
        }

    }

}
