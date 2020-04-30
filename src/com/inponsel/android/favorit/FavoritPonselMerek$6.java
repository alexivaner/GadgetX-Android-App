// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.favorit;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;

// Referenced classes of package com.inponsel.android.favorit:
//            FavoritPonselMerek

class val.id_rss
    implements android.view.itPonselMerek._cls6
{

    final FavoritPonselMerek this$0;
    private final String val$id_rss;

    public void onClick(View view)
    {
        if (userFunctions.isUserLoggedIn(FavoritPonselMerek.this))
        {
            statuslike = "1";
            idrss_pos = val$id_rss;
            querylikeRSS = (new StringBuilder("status=")).append(statuslike).append("&id_rss=").append(val$id_rss).append("&id_usr=").append(user_id).append("&t=").append(t).toString();
            Log.e("querylikeRSS", querylikeRSS);
            if (android.os. >= 11)
            {
                (new stBagusKurangRSSTask(FavoritPonselMerek.this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                return;
            } else
            {
                (new stBagusKurangRSSTask(FavoritPonselMerek.this)).execute(new Void[0]);
                return;
            }
        } else
        {
            view = new android.app.init>(wrapperLight);
            view.etMessage("Untuk memberi penilaian harus login terlebih dahulu.");
            view.etPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                final FavoritPonselMerek._cls6 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$1 = FavoritPonselMerek._cls6.this;
                super();
            }
            });
            view.etNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                final FavoritPonselMerek._cls6 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(this$0, com/inponsel/android/v2/RegisterActivity);
                    startActivity(dialoginterface);
                }

            
            {
                this$1 = FavoritPonselMerek._cls6.this;
                super();
            }
            });
            view.etNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                final FavoritPonselMerek._cls6 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(this$0, com/inponsel/android/v2/LoginActivity);
                    dialoginterface.putExtra("activity", "main");
                    startActivity(dialoginterface);
                }

            
            {
                this$1 = FavoritPonselMerek._cls6.this;
                super();
            }
            });
            view.how();
            return;
        }
    }


    _cls3.this._cls1()
    {
        this$0 = final_favoritponselmerek;
        val$id_rss = String.this;
        super();
    }
}
