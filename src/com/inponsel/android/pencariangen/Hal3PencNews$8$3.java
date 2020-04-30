// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.pencariangen;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;

// Referenced classes of package com.inponsel.android.pencariangen:
//            Hal3PencNews

class this._cls1
    implements android.content.nClickListener
{

    final tActivity this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
        dialoginterface.putExtra("activity", "main");
        startActivity(dialoginterface);
    }

    l.id_rss()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/pencariangen/Hal3PencNews$8

/* anonymous class */
    class Hal3PencNews._cls8
        implements android.view.View.OnClickListener
    {

        final Hal3PencNews this$0;
        private final String val$id_rss;

        public void onClick(View view)
        {
            if (userFunctions.isUserLoggedIn(getActivity()))
            {
                statuslike = "1";
                idkom_pos = id_rss;
                querylike = (new StringBuilder("status=")).append(statuslike).append("&id_rss=").append(id_rss).append("&id_usr=").append(user_id).append("&t=").append(t).toString();
                Log.e("querylike", querylike);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new Hal3PencNews.PostBagusKurangTask(Hal3PencNews.this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new Hal3PencNews.PostBagusKurangTask(Hal3PencNews.this)).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(wrapperLight);
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new Hal3PencNews._cls8._cls1());
                view.setNeutralButton("Register", new Hal3PencNews._cls8._cls2());
                view.setNegativeButton("Login", new Hal3PencNews._cls8._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$0 = final_hal3pencnews;
                id_rss = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/pencariangen/Hal3PencNews$8$1

/* anonymous class */
        class Hal3PencNews._cls8._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal3PencNews._cls8 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = Hal3PencNews._cls8.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/pencariangen/Hal3PencNews$8$2

/* anonymous class */
        class Hal3PencNews._cls8._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal3PencNews._cls8 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                startActivity(dialoginterface);
            }

                    
                    {
                        this$1 = Hal3PencNews._cls8.this;
                        super();
                    }
        }

    }

}
