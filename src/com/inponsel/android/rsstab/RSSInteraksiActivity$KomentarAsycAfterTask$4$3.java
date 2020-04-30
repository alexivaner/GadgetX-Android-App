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
    implements android.content.terTask._cls4._cls3
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

    // Unreferenced inner class com/inponsel/android/rsstab/RSSInteraksiActivity$KomentarAsycAfterTask$4

/* anonymous class */
    class RSSInteraksiActivity.KomentarAsycAfterTask._cls4
        implements android.view.View.OnClickListener
    {

        final RSSInteraksiActivity.KomentarAsycAfterTask this$1;
        private final String val$id_komrss;
        private final String val$tl_id;

        public void onClick(View view)
        {
            if (RSSInteraksiActivity.KomentarAsycAfterTask.access$2(RSSInteraksiActivity.KomentarAsycAfterTask.this).userFunctions.isUserLoggedIn(RSSInteraksiActivity.KomentarAsycAfterTask.access$2(RSSInteraksiActivity.KomentarAsycAfterTask.this)))
            {
                RSSInteraksiActivity.KomentarAsycAfterTask.access$2(RSSInteraksiActivity.KomentarAsycAfterTask.this).statuslike = "0";
                RSSInteraksiActivity.KomentarAsycAfterTask.access$2(RSSInteraksiActivity.KomentarAsycAfterTask.this).idkom_pos = id_komrss;
                RSSInteraksiActivity.KomentarAsycAfterTask.access$2(RSSInteraksiActivity.KomentarAsycAfterTask.this).querylike = (new StringBuilder("status=")).append(RSSInteraksiActivity.KomentarAsycAfterTask.access$2(RSSInteraksiActivity.KomentarAsycAfterTask.this).statuslike).append("&id_kom=").append(id_komrss).append("&tl_id=").append(tl_id).append("&id_usr=").append(RSSInteraksiActivity.KomentarAsycAfterTask.access$2(RSSInteraksiActivity.KomentarAsycAfterTask.this).user_id).append("&t=").append(RSSInteraksiActivity.KomentarAsycAfterTask.access$2(RSSInteraksiActivity.KomentarAsycAfterTask.this).t).toString();
                Log.e("querylike", RSSInteraksiActivity.KomentarAsycAfterTask.access$2(RSSInteraksiActivity.KomentarAsycAfterTask.this).querylike);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new RSSInteraksiActivity.PostBagusKurangTask(RSSInteraksiActivity.KomentarAsycAfterTask.access$2(RSSInteraksiActivity.KomentarAsycAfterTask.this))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new RSSInteraksiActivity.PostBagusKurangTask(RSSInteraksiActivity.KomentarAsycAfterTask.access$2(RSSInteraksiActivity.KomentarAsycAfterTask.this))).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(RSSInteraksiActivity.KomentarAsycAfterTask.access$2(RSSInteraksiActivity.KomentarAsycAfterTask.this));
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new RSSInteraksiActivity.KomentarAsycAfterTask._cls4._cls1());
                view.setNeutralButton("Register", new RSSInteraksiActivity.KomentarAsycAfterTask._cls4._cls2());
                view.setNegativeButton("Login", new RSSInteraksiActivity.KomentarAsycAfterTask._cls4._cls3());
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

        // Unreferenced inner class com/inponsel/android/rsstab/RSSInteraksiActivity$KomentarAsycAfterTask$4$1

/* anonymous class */
        class RSSInteraksiActivity.KomentarAsycAfterTask._cls4._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final RSSInteraksiActivity.KomentarAsycAfterTask._cls4 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = RSSInteraksiActivity.KomentarAsycAfterTask._cls4.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/rsstab/RSSInteraksiActivity$KomentarAsycAfterTask$4$2

/* anonymous class */
        class RSSInteraksiActivity.KomentarAsycAfterTask._cls4._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final RSSInteraksiActivity.KomentarAsycAfterTask._cls4 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(RSSInteraksiActivity.KomentarAsycAfterTask.access$2(this$1), com/inponsel/android/v2/RegisterActivity);
                RSSInteraksiActivity.KomentarAsycAfterTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = RSSInteraksiActivity.KomentarAsycAfterTask._cls4.this;
                        super();
                    }
        }

    }

}
