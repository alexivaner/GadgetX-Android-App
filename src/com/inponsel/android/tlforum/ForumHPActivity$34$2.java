// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.tlforum;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;

// Referenced classes of package com.inponsel.android.tlforum:
//            ForumHPActivity

class this._cls1
    implements android.content.ckListener
{

    final Activity this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
        startActivity(dialoginterface);
    }

    l.tl_type()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/tlforum/ForumHPActivity$34

/* anonymous class */
    class ForumHPActivity._cls34
        implements android.view.View.OnClickListener
    {

        final ForumHPActivity this$0;
        private final String val$tl_id;
        private final String val$tl_type;

        public void onClick(View view)
        {
            if (userFunctions.isUserLoggedIn(ForumHPActivity.this))
            {
                statuslike = "1";
                idkom_pos = tl_id;
                id_type = tl_type;
                querylike = (new StringBuilder("status=")).append(statuslike).append("&tl_id=").append(idkom_pos).append("&id_usr=").append(ForumHPActivity.user_id).append("&type=").append(id_type).append("&t=").append(t).toString();
                Log.e("querylike", querylike);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new ForumHPActivity.PostBagusKurangTask(ForumHPActivity.this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new ForumHPActivity.PostBagusKurangTask(ForumHPActivity.this)).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(wrapperLight);
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new ForumHPActivity._cls34._cls1());
                view.setNeutralButton("Register", new ForumHPActivity._cls34._cls2());
                view.setNegativeButton("Login", new ForumHPActivity._cls34._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$0 = final_forumhpactivity;
                tl_id = s;
                tl_type = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/tlforum/ForumHPActivity$34$1

/* anonymous class */
        class ForumHPActivity._cls34._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final ForumHPActivity._cls34 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = ForumHPActivity._cls34.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/tlforum/ForumHPActivity$34$3

/* anonymous class */
        class ForumHPActivity._cls34._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final ForumHPActivity._cls34 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(this$0, com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                startActivity(dialoginterface);
            }

                    
                    {
                        this$1 = ForumHPActivity._cls34.this;
                        super();
                    }
        }

    }

}
