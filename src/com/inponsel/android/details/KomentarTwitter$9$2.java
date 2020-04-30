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

class this._cls1
    implements android.content.ickListener
{

    final tActivity this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
        startActivity(dialoginterface);
    }

    l.id_tw()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/details/KomentarTwitter$9

/* anonymous class */
    class KomentarTwitter._cls9
        implements android.view.View.OnClickListener
    {

        final KomentarTwitter this$0;
        private final String val$id_komtw;
        private final String val$id_tw;

        public void onClick(View view)
        {
            if (userFunctions.isUserLoggedIn(KomentarTwitter.this))
            {
                statuslike = "0";
                idkom_pos = id_komtw;
                querylike = (new StringBuilder("status=")).append(statuslike).append("&id_kom=").append(id_komtw).append("&id_tw=").append(id_tw).append("&id_usr=").append(user_id).append("&t=").append(t).toString();
                Log.e("querylike", querylike);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new KomentarTwitter.PostBagusKurangTask(KomentarTwitter.this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new KomentarTwitter.PostBagusKurangTask(KomentarTwitter.this)).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(wrapperLight);
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new KomentarTwitter._cls9._cls1());
                view.setNeutralButton("Register", new KomentarTwitter._cls9._cls2());
                view.setNegativeButton("Login", new KomentarTwitter._cls9._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$0 = final_komentartwitter;
                id_komtw = s;
                id_tw = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/details/KomentarTwitter$9$1

/* anonymous class */
        class KomentarTwitter._cls9._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final KomentarTwitter._cls9 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = KomentarTwitter._cls9.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/details/KomentarTwitter$9$3

/* anonymous class */
        class KomentarTwitter._cls9._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final KomentarTwitter._cls9 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(this$0, com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                startActivity(dialoginterface);
            }

                    
                    {
                        this$1 = KomentarTwitter._cls9.this;
                        super();
                    }
        }

    }

}
