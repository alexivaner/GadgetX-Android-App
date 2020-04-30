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

class this._cls2
    implements android.content.tRSSTask._cls3._cls3
{

    final is._cls1 this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent(ss._mth3(_fld1), com/inponsel/android/v2/LoginActivity);
        dialoginterface.putExtra("activity", "main");
        ss._mth3(_fld1).startActivity(dialoginterface);
    }

    l.id_rss()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/favorit/FavoritPonselMerek$FavoritRSSTask$3

/* anonymous class */
    class FavoritPonselMerek.FavoritRSSTask._cls3
        implements android.view.View.OnClickListener
    {

        final FavoritPonselMerek.FavoritRSSTask this$1;
        private final String val$id_rss;

        public void onClick(View view)
        {
            if (FavoritPonselMerek.FavoritRSSTask.access$3(FavoritPonselMerek.FavoritRSSTask.this).userFunctions.isUserLoggedIn(FavoritPonselMerek.FavoritRSSTask.access$3(FavoritPonselMerek.FavoritRSSTask.this)))
            {
                FavoritPonselMerek.FavoritRSSTask.access$3(FavoritPonselMerek.FavoritRSSTask.this).statuslike = "1";
                FavoritPonselMerek.FavoritRSSTask.access$3(FavoritPonselMerek.FavoritRSSTask.this).idrss_pos = id_rss;
                FavoritPonselMerek.FavoritRSSTask.access$3(FavoritPonselMerek.FavoritRSSTask.this).querylikeRSS = (new StringBuilder("status=")).append(FavoritPonselMerek.FavoritRSSTask.access$3(FavoritPonselMerek.FavoritRSSTask.this).statuslike).append("&id_rss=").append(id_rss).append("&id_usr=").append(FavoritPonselMerek.FavoritRSSTask.access$3(FavoritPonselMerek.FavoritRSSTask.this).user_id).append("&t=").append(FavoritPonselMerek.FavoritRSSTask.access$3(FavoritPonselMerek.FavoritRSSTask.this).t).toString();
                Log.e("querylikeRSS", FavoritPonselMerek.FavoritRSSTask.access$3(FavoritPonselMerek.FavoritRSSTask.this).querylikeRSS);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new FavoritPonselMerek.PostBagusKurangRSSTask(FavoritPonselMerek.FavoritRSSTask.access$3(FavoritPonselMerek.FavoritRSSTask.this))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new FavoritPonselMerek.PostBagusKurangRSSTask(FavoritPonselMerek.FavoritRSSTask.access$3(FavoritPonselMerek.FavoritRSSTask.this))).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(FavoritPonselMerek.FavoritRSSTask.access$3(FavoritPonselMerek.FavoritRSSTask.this).wrapperLight);
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new FavoritPonselMerek.FavoritRSSTask._cls3._cls1());
                view.setNeutralButton("Register", new FavoritPonselMerek.FavoritRSSTask._cls3._cls2());
                view.setNegativeButton("Login", new FavoritPonselMerek.FavoritRSSTask._cls3._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_favoritrsstask;
                id_rss = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/favorit/FavoritPonselMerek$FavoritRSSTask$3$1

/* anonymous class */
        class FavoritPonselMerek.FavoritRSSTask._cls3._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final FavoritPonselMerek.FavoritRSSTask._cls3 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = FavoritPonselMerek.FavoritRSSTask._cls3.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/favorit/FavoritPonselMerek$FavoritRSSTask$3$2

/* anonymous class */
        class FavoritPonselMerek.FavoritRSSTask._cls3._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final FavoritPonselMerek.FavoritRSSTask._cls3 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(FavoritPonselMerek.FavoritRSSTask.access$3(this$1), com/inponsel/android/v2/RegisterActivity);
                FavoritPonselMerek.FavoritRSSTask.access$3(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = FavoritPonselMerek.FavoritRSSTask._cls3.this;
                        super();
                    }
        }

    }

}
