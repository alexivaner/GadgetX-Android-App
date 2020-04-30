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

class val.tl_type
    implements android.content.ckListener
{

    final Activity this$1;
    private final String val$tl_type;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (userFunctions.isUserLoggedIn(_fld0))
        {
            queryFlag = (new StringBuilder("id_artanya=")).append(idkom_pos).append("&id_usr=").append(ForumHPActivity.user_id).append("&type=").append(val$tl_type).append("&t=").append(t).toString();
            Log.e("queryFlag", queryFlag);
            if (android.os. >= 11)
            {
                (new lagTask(_fld0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                return;
            } else
            {
                (new lagTask(_fld0)).execute(new Void[0]);
                return;
            }
        } else
        {
            dialoginterface = new android.app.init>(_fld0);
            dialoginterface.etMessage("Untuk memberi laporan harus login terlebih dahulu.");
            dialoginterface.etPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                final ForumHPActivity._cls44._cls1 this$2;

                public void onClick(DialogInterface dialoginterface1, int j)
                {
                    dialoginterface1.dismiss();
                }

            
            {
                this$2 = ForumHPActivity._cls44._cls1.this;
                super();
            }
            });
            dialoginterface.etNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                final ForumHPActivity._cls44._cls1 this$2;

                public void onClick(DialogInterface dialoginterface1, int j)
                {
                    dialoginterface1 = new Intent(this$0, com/inponsel/android/v2/RegisterActivity);
                    startActivity(dialoginterface1);
                }

            
            {
                this$2 = ForumHPActivity._cls44._cls1.this;
                super();
            }
            });
            dialoginterface.etNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                final ForumHPActivity._cls44._cls1 this$2;

                public void onClick(DialogInterface dialoginterface1, int j)
                {
                    dialoginterface1 = new Intent(this$0, com/inponsel/android/v2/LoginActivity);
                    dialoginterface1.putExtra("activity", "main");
                    startActivity(dialoginterface1);
                }

            
            {
                this$2 = ForumHPActivity._cls44._cls1.this;
                super();
            }
            });
            dialoginterface.how();
            return;
        }
    }


    l.tl_type()
    {
        this$1 = final_tl_type1;
        val$tl_type = String.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/tlforum/ForumHPActivity$44

/* anonymous class */
    class ForumHPActivity._cls44
        implements android.view.View.OnClickListener
    {

        final ForumHPActivity this$0;
        private final String val$tl_id;
        private final String val$tl_type;

        public void onClick(View view)
        {
            idkom_pos = tl_id;
            id_type = tl_type;
            view = new android.app.AlertDialog.Builder(ForumHPActivity.this);
            view.setMessage("Laporkan konten ini karena tidak sesuai atau mengandung SARA?");
            view.setPositiveButton("Ya", tl_type. new ForumHPActivity._cls44._cls1());
            view.setNegativeButton("Batal", new ForumHPActivity._cls44._cls2());
            view.show();
        }


            
            {
                this$0 = final_forumhpactivity;
                tl_id = s;
                tl_type = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/tlforum/ForumHPActivity$44$2

/* anonymous class */
        class ForumHPActivity._cls44._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final ForumHPActivity._cls44 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = ForumHPActivity._cls44.this;
                        super();
                    }
        }

    }

}
