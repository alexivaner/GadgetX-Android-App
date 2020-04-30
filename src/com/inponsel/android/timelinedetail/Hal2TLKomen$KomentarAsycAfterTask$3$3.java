// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.timelinedetail;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;

// Referenced classes of package com.inponsel.android.timelinedetail:
//            Hal2TLKomen

class this._cls2
    implements android.content.arAsycAfterTask._cls3._cls3
{

    final is._cls1 this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent(ss._mth2(_fld1).getActivity(), com/inponsel/android/v2/LoginActivity);
        dialoginterface.putExtra("activity", "main");
        ss._mth2(_fld1).startActivity(dialoginterface);
    }

    l.tl_id()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/timelinedetail/Hal2TLKomen$KomentarAsycAfterTask$3

/* anonymous class */
    class Hal2TLKomen.KomentarAsycAfterTask._cls3
        implements android.view.View.OnClickListener
    {

        final Hal2TLKomen.KomentarAsycAfterTask this$1;
        private final String val$id_komrss;
        private final String val$tl_id;

        public void onClick(View view)
        {
            if (Hal2TLKomen.KomentarAsycAfterTask.access$2(Hal2TLKomen.KomentarAsycAfterTask.this).userFunctions.isUserLoggedIn(Hal2TLKomen.KomentarAsycAfterTask.access$2(Hal2TLKomen.KomentarAsycAfterTask.this).getActivity()))
            {
                Hal2TLKomen.KomentarAsycAfterTask.access$2(Hal2TLKomen.KomentarAsycAfterTask.this).statuslike = "1";
                Hal2TLKomen.KomentarAsycAfterTask.access$2(Hal2TLKomen.KomentarAsycAfterTask.this).idkom_pos = id_komrss;
                Hal2TLKomen.KomentarAsycAfterTask.access$2(Hal2TLKomen.KomentarAsycAfterTask.this).querylike = (new StringBuilder("status=")).append(Hal2TLKomen.KomentarAsycAfterTask.access$2(Hal2TLKomen.KomentarAsycAfterTask.this).statuslike).append("&id_kom=").append(id_komrss).append("&tl_id=").append(tl_id).append("&id_usr=").append(Hal2TLKomen.KomentarAsycAfterTask.access$2(Hal2TLKomen.KomentarAsycAfterTask.this).user_id).append("&t=").append(Hal2TLKomen.KomentarAsycAfterTask.access$2(Hal2TLKomen.KomentarAsycAfterTask.this).t).toString();
                Log.e("querylike", Hal2TLKomen.KomentarAsycAfterTask.access$2(Hal2TLKomen.KomentarAsycAfterTask.this).querylike);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new Hal2TLKomen.PostBagusKurangTask(Hal2TLKomen.KomentarAsycAfterTask.access$2(Hal2TLKomen.KomentarAsycAfterTask.this))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new Hal2TLKomen.PostBagusKurangTask(Hal2TLKomen.KomentarAsycAfterTask.access$2(Hal2TLKomen.KomentarAsycAfterTask.this))).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(Hal2TLKomen.KomentarAsycAfterTask.access$2(Hal2TLKomen.KomentarAsycAfterTask.this).getActivity());
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new Hal2TLKomen.KomentarAsycAfterTask._cls3._cls1());
                view.setNeutralButton("Register", new Hal2TLKomen.KomentarAsycAfterTask._cls3._cls2());
                view.setNegativeButton("Login", new Hal2TLKomen.KomentarAsycAfterTask._cls3._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_komentarasycaftertask;
                id_komrss = s;
                tl_id = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/timelinedetail/Hal2TLKomen$KomentarAsycAfterTask$3$1

/* anonymous class */
        class Hal2TLKomen.KomentarAsycAfterTask._cls3._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal2TLKomen.KomentarAsycAfterTask._cls3 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = Hal2TLKomen.KomentarAsycAfterTask._cls3.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/timelinedetail/Hal2TLKomen$KomentarAsycAfterTask$3$2

/* anonymous class */
        class Hal2TLKomen.KomentarAsycAfterTask._cls3._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal2TLKomen.KomentarAsycAfterTask._cls3 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(Hal2TLKomen.KomentarAsycAfterTask.access$2(this$1).getActivity(), com/inponsel/android/v2/RegisterActivity);
                Hal2TLKomen.KomentarAsycAfterTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = Hal2TLKomen.KomentarAsycAfterTask._cls3.this;
                        super();
                    }
        }

    }

}
