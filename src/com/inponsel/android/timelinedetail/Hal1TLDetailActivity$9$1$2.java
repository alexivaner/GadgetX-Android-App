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
    implements android.content.ener
{

    final ctivity this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
        startActivity(dialoginterface);
    }

    ._cls0()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/timelinedetail/Hal1TLDetailActivity$9

/* anonymous class */
    class Hal1TLDetailActivity._cls9
        implements android.view.View.OnClickListener
    {

        final Hal1TLDetailActivity this$0;

        public void onClick(View view)
        {
            view = new android.app.AlertDialog.Builder(Hal1TLDetailActivity.this);
            view.setMessage("Laporkan konten ini karena tidak sesuai atau mengandung SARA?");
            view.setPositiveButton("Ya", new Hal1TLDetailActivity._cls9._cls1());
            view.setNegativeButton("Batal", new Hal1TLDetailActivity._cls9._cls2());
            view.show();
        }


            
            {
                this$0 = Hal1TLDetailActivity.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/timelinedetail/Hal1TLDetailActivity$9$2

/* anonymous class */
        class Hal1TLDetailActivity._cls9._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal1TLDetailActivity._cls9 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = Hal1TLDetailActivity._cls9.this;
                        super();
                    }
        }

    }


    // Unreferenced inner class com/inponsel/android/timelinedetail/Hal1TLDetailActivity$9$1

/* anonymous class */
    class Hal1TLDetailActivity._cls9._cls1
        implements android.content.DialogInterface.OnClickListener
    {

        final Hal1TLDetailActivity._cls9 this$1;

        public void onClick(DialogInterface dialoginterface, int i)
        {
            if (userFunctions.isUserLoggedIn(this$0))
            {
                queryFlag = (new StringBuilder("id_artanya=")).append(idkom_pos).append("&id_usr=").append(user_id).append("&type=").append(tl_type).append("&t=").append(t).toString();
                Log.e("queryFlag", queryFlag);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new Hal1TLDetailActivity.PostFlagTask(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new Hal1TLDetailActivity.PostFlagTask(this$0)).execute(new Void[0]);
                    return;
                }
            } else
            {
                dialoginterface = new android.app.AlertDialog.Builder(this$0);
                dialoginterface.setMessage("Untuk memberi laporan harus login terlebih dahulu.");
                dialoginterface.setPositiveButton("Tutup", new Hal1TLDetailActivity._cls9._cls1._cls1());
                dialoginterface.setNeutralButton("Register", new Hal1TLDetailActivity._cls9._cls1._cls2());
                dialoginterface.setNegativeButton("Login", new Hal1TLDetailActivity._cls9._cls1._cls3());
                dialoginterface.show();
                return;
            }
        }


            
            {
                this$1 = Hal1TLDetailActivity._cls9.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/timelinedetail/Hal1TLDetailActivity$9$1$1

/* anonymous class */
        class Hal1TLDetailActivity._cls9._cls1._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal1TLDetailActivity._cls9._cls1 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = Hal1TLDetailActivity._cls9._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/timelinedetail/Hal1TLDetailActivity$9$1$3

/* anonymous class */
        class Hal1TLDetailActivity._cls9._cls1._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal1TLDetailActivity._cls9._cls1 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(this$0, com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = Hal1TLDetailActivity._cls9._cls1.this;
                        super();
                    }
        }

    }

}
