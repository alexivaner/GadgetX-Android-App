// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;

// Referenced classes of package com.inponsel.android.details:
//            KomentarTwitter

class val.id_tw
    implements android.view.er
{

    final KomentarTwitter this$0;
    private final String val$id_komtw;
    private final String val$id_tw;

    public void onClick(View view)
    {
        if (userFunctions.isUserLoggedIn(KomentarTwitter.this))
        {
            statuslike = "1";
            idkom_pos = val$id_komtw;
            querylike = (new StringBuilder("status=")).append(statuslike).append("&id_kom=").append(val$id_komtw).append("&id_tw=").append(val$id_tw).append("&id_usr=").append(user_id).append("&t=").append(t).toString();
            Log.e("querylike", querylike);
            if (android.os.INT >= 11)
            {
                (new stBagusKurangTask(KomentarTwitter.this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                return;
            } else
            {
                (new stBagusKurangTask(KomentarTwitter.this)).execute(new Void[0]);
                return;
            }
        } else
        {
            view = new android.app.r(wrapperLight);
            view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
            view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                final KomentarTwitter._cls8 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$1 = KomentarTwitter._cls8.this;
                super();
            }
            });
            view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                final KomentarTwitter._cls8 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(this$0, com/inponsel/android/v2/RegisterActivity);
                    startActivity(dialoginterface);
                }

            
            {
                this$1 = KomentarTwitter._cls8.this;
                super();
            }
            });
            view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                final KomentarTwitter._cls8 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(this$0, com/inponsel/android/v2/LoginActivity);
                    dialoginterface.putExtra("activity", "main");
                    startActivity(dialoginterface);
                }

            
            {
                this$1 = KomentarTwitter._cls8.this;
                super();
            }
            });
            view.show();
            return;
        }
    }


    _cls3.this._cls1()
    {
        this$0 = final_komentartwitter;
        val$id_komtw = s;
        val$id_tw = String.this;
        super();
    }
}
