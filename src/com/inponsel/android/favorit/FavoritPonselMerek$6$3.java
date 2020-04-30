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

class this._cls1
    implements android.content.Listener
{

    final tActivity this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
        dialoginterface.putExtra("activity", "main");
        startActivity(dialoginterface);
    }

    l.id_rss()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/favorit/FavoritPonselMerek$6

/* anonymous class */
    class FavoritPonselMerek._cls6
        implements android.view.View.OnClickListener
    {

        final FavoritPonselMerek this$0;
        private final String val$id_rss;

        public void onClick(View view)
        {
            if (userFunctions.isUserLoggedIn(FavoritPonselMerek.this))
            {
                statuslike = "1";
                idrss_pos = id_rss;
                querylikeRSS = (new StringBuilder("status=")).append(statuslike).append("&id_rss=").append(id_rss).append("&id_usr=").append(user_id).append("&t=").append(t).toString();
                Log.e("querylikeRSS", querylikeRSS);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new FavoritPonselMerek.PostBagusKurangRSSTask(FavoritPonselMerek.this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new FavoritPonselMerek.PostBagusKurangRSSTask(FavoritPonselMerek.this)).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(wrapperLight);
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new FavoritPonselMerek._cls6._cls1());
                view.setNeutralButton("Register", new FavoritPonselMerek._cls6._cls2());
                view.setNegativeButton("Login", new FavoritPonselMerek._cls6._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$0 = final_favoritponselmerek;
                id_rss = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/favorit/FavoritPonselMerek$6$1

/* anonymous class */
        class FavoritPonselMerek._cls6._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final FavoritPonselMerek._cls6 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = FavoritPonselMerek._cls6.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/favorit/FavoritPonselMerek$6$2

/* anonymous class */
        class FavoritPonselMerek._cls6._cls2
            implements android.content.DialogInterface.OnClickListener
        {

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
        }

    }

}
