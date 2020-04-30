// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.rsstab;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;

// Referenced classes of package com.inponsel.android.rsstab:
//            RSSInteraksiActivity

class this._cls2
    implements android.content.sycTask._cls3._cls3
{

    final is._cls1 this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent(ss._mth2(_fld1), com/inponsel/android/v2/LoginActivity);
        dialoginterface.putExtra("activity", "main");
        ss._mth2(_fld1).startActivity(dialoginterface);
    }

    l.tl_id()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/rsstab/RSSInteraksiActivity$KomentarNextAsycTask$3

/* anonymous class */
    class RSSInteraksiActivity.KomentarNextAsycTask._cls3
        implements android.view.View.OnClickListener
    {

        final RSSInteraksiActivity.KomentarNextAsycTask this$1;
        private final String val$id_komrss;
        private final String val$tl_id;

        public void onClick(View view)
        {
            if (RSSInteraksiActivity.KomentarNextAsycTask.access$2(RSSInteraksiActivity.KomentarNextAsycTask.this).userFunctions.isUserLoggedIn(RSSInteraksiActivity.KomentarNextAsycTask.access$2(RSSInteraksiActivity.KomentarNextAsycTask.this)))
            {
                RSSInteraksiActivity.KomentarNextAsycTask.access$2(RSSInteraksiActivity.KomentarNextAsycTask.this).statuslike = "0";
                RSSInteraksiActivity.KomentarNextAsycTask.access$2(RSSInteraksiActivity.KomentarNextAsycTask.this).idkom_pos = id_komrss;
                RSSInteraksiActivity.KomentarNextAsycTask.access$2(RSSInteraksiActivity.KomentarNextAsycTask.this).querylike = (new StringBuilder("status=")).append(RSSInteraksiActivity.KomentarNextAsycTask.access$2(RSSInteraksiActivity.KomentarNextAsycTask.this).statuslike).append("&id_kom=").append(id_komrss).append("&tl_id=").append(tl_id).append("&id_usr=").append(RSSInteraksiActivity.KomentarNextAsycTask.access$2(RSSInteraksiActivity.KomentarNextAsycTask.this).user_id).append("&t=").append(RSSInteraksiActivity.KomentarNextAsycTask.access$2(RSSInteraksiActivity.KomentarNextAsycTask.this).t).toString();
                Log.e("querylike", RSSInteraksiActivity.KomentarNextAsycTask.access$2(RSSInteraksiActivity.KomentarNextAsycTask.this).querylike);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new RSSInteraksiActivity.PostBagusKurangTask(RSSInteraksiActivity.KomentarNextAsycTask.access$2(RSSInteraksiActivity.KomentarNextAsycTask.this))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new RSSInteraksiActivity.PostBagusKurangTask(RSSInteraksiActivity.KomentarNextAsycTask.access$2(RSSInteraksiActivity.KomentarNextAsycTask.this))).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(RSSInteraksiActivity.KomentarNextAsycTask.access$2(RSSInteraksiActivity.KomentarNextAsycTask.this));
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new RSSInteraksiActivity.KomentarNextAsycTask._cls3._cls1());
                view.setNeutralButton("Register", new RSSInteraksiActivity.KomentarNextAsycTask._cls3._cls2());
                view.setNegativeButton("Login", new RSSInteraksiActivity.KomentarNextAsycTask._cls3._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_komentarnextasyctask;
                id_komrss = s;
                tl_id = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/rsstab/RSSInteraksiActivity$KomentarNextAsycTask$3$1

/* anonymous class */
        class RSSInteraksiActivity.KomentarNextAsycTask._cls3._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final RSSInteraksiActivity.KomentarNextAsycTask._cls3 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = RSSInteraksiActivity.KomentarNextAsycTask._cls3.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/rsstab/RSSInteraksiActivity$KomentarNextAsycTask$3$2

/* anonymous class */
        class RSSInteraksiActivity.KomentarNextAsycTask._cls3._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final RSSInteraksiActivity.KomentarNextAsycTask._cls3 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(RSSInteraksiActivity.KomentarNextAsycTask.access$2(this$1), com/inponsel/android/v2/RegisterActivity);
                RSSInteraksiActivity.KomentarNextAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = RSSInteraksiActivity.KomentarNextAsycTask._cls3.this;
                        super();
                    }
        }

    }

}
