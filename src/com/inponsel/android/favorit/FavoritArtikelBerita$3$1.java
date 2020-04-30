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
//            FavoritArtikelBerita

class this._cls1
    implements android.content.stener
{

    final this._cls1 this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }

    l.id_rss()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/favorit/FavoritArtikelBerita$3

/* anonymous class */
    class FavoritArtikelBerita._cls3
        implements android.view.View.OnClickListener
    {

        final FavoritArtikelBerita this$0;
        private final String val$id_rss;

        public void onClick(View view)
        {
            if (userFunctions.isUserLoggedIn(FavoritArtikelBerita.this))
            {
                statuslike = "1";
                idrss_pos = id_rss;
                querylikeRSS = (new StringBuilder("status=")).append(statuslike).append("&id_rss=").append(id_rss).append("&id_usr=").append(user_id).append("&t=").append(t).toString();
                Log.e("querylikeRSS", querylikeRSS);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new FavoritArtikelBerita.PostBagusKurangRSSTask(FavoritArtikelBerita.this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new FavoritArtikelBerita.PostBagusKurangRSSTask(FavoritArtikelBerita.this)).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(wrapperLight);
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new FavoritArtikelBerita._cls3._cls1());
                view.setNeutralButton("Register", new FavoritArtikelBerita._cls3._cls2());
                view.setNegativeButton("Login", new FavoritArtikelBerita._cls3._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$0 = final_favoritartikelberita;
                id_rss = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/favorit/FavoritArtikelBerita$3$2

/* anonymous class */
        class FavoritArtikelBerita._cls3._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final FavoritArtikelBerita._cls3 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(this$0, com/inponsel/android/v2/RegisterActivity);
                startActivity(dialoginterface);
            }

                    
                    {
                        this$1 = FavoritArtikelBerita._cls3.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/favorit/FavoritArtikelBerita$3$3

/* anonymous class */
        class FavoritArtikelBerita._cls3._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final FavoritArtikelBerita._cls3 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(this$0, com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                startActivity(dialoginterface);
            }

                    
                    {
                        this$1 = FavoritArtikelBerita._cls3.this;
                        super();
                    }
        }

    }

}
