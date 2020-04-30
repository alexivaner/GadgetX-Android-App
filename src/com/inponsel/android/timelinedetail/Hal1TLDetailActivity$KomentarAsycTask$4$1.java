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
//            Hal1TLDetailActivity

class this._cls2
    implements android.content.omentarAsycTask._cls4._cls1
{

    final this._cls2 this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }

    l.tl_id()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/timelinedetail/Hal1TLDetailActivity$KomentarAsycTask$4

/* anonymous class */
    class Hal1TLDetailActivity.KomentarAsycTask._cls4
        implements android.view.View.OnClickListener
    {

        final Hal1TLDetailActivity.KomentarAsycTask this$1;
        private final String val$id_komrss;
        private final String val$tl_id;

        public void onClick(View view)
        {
            if (Hal1TLDetailActivity.KomentarAsycTask.access$2(Hal1TLDetailActivity.KomentarAsycTask.this).userFunctions.isUserLoggedIn(Hal1TLDetailActivity.KomentarAsycTask.access$2(Hal1TLDetailActivity.KomentarAsycTask.this)))
            {
                Hal1TLDetailActivity.KomentarAsycTask.access$2(Hal1TLDetailActivity.KomentarAsycTask.this).statuslike = "0";
                Hal1TLDetailActivity.KomentarAsycTask.access$2(Hal1TLDetailActivity.KomentarAsycTask.this).idkom_pos = id_komrss;
                Hal1TLDetailActivity.KomentarAsycTask.access$2(Hal1TLDetailActivity.KomentarAsycTask.this).querylikeKomen = (new StringBuilder("status=")).append(Hal1TLDetailActivity.KomentarAsycTask.access$2(Hal1TLDetailActivity.KomentarAsycTask.this).statuslike).append("&id_kom=").append(id_komrss).append("&id_artanya=").append(Hal1TLDetailActivity.KomentarAsycTask.access$2(Hal1TLDetailActivity.KomentarAsycTask.this).id_artikel).append("&tl_id=").append(tl_id).append("&id_usr=").append(Hal1TLDetailActivity.KomentarAsycTask.access$2(Hal1TLDetailActivity.KomentarAsycTask.this).user_id).append("&t=").append(Hal1TLDetailActivity.KomentarAsycTask.access$2(Hal1TLDetailActivity.KomentarAsycTask.this).t).toString();
                Log.e("querylikeKomen", Hal1TLDetailActivity.KomentarAsycTask.access$2(Hal1TLDetailActivity.KomentarAsycTask.this).querylikeKomen);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new Hal1TLDetailActivity.PostBagusKurangKomenTask(Hal1TLDetailActivity.KomentarAsycTask.access$2(Hal1TLDetailActivity.KomentarAsycTask.this))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new Hal1TLDetailActivity.PostBagusKurangKomenTask(Hal1TLDetailActivity.KomentarAsycTask.access$2(Hal1TLDetailActivity.KomentarAsycTask.this))).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(Hal1TLDetailActivity.KomentarAsycTask.access$2(Hal1TLDetailActivity.KomentarAsycTask.this));
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new Hal1TLDetailActivity.KomentarAsycTask._cls4._cls1());
                view.setNeutralButton("Register", new Hal1TLDetailActivity.KomentarAsycTask._cls4._cls2());
                view.setNegativeButton("Login", new Hal1TLDetailActivity.KomentarAsycTask._cls4._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_komentarasyctask;
                id_komrss = s;
                tl_id = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/timelinedetail/Hal1TLDetailActivity$KomentarAsycTask$4$2

/* anonymous class */
        class Hal1TLDetailActivity.KomentarAsycTask._cls4._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal1TLDetailActivity.KomentarAsycTask._cls4 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(Hal1TLDetailActivity.KomentarAsycTask.access$2(this$1), com/inponsel/android/v2/RegisterActivity);
                Hal1TLDetailActivity.KomentarAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = Hal1TLDetailActivity.KomentarAsycTask._cls4.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/timelinedetail/Hal1TLDetailActivity$KomentarAsycTask$4$3

/* anonymous class */
        class Hal1TLDetailActivity.KomentarAsycTask._cls4._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal1TLDetailActivity.KomentarAsycTask._cls4 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(Hal1TLDetailActivity.KomentarAsycTask.access$2(this$1), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                Hal1TLDetailActivity.KomentarAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = Hal1TLDetailActivity.KomentarAsycTask._cls4.this;
                        super();
                    }
        }

    }

}
