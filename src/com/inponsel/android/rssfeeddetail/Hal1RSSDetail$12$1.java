// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.rssfeeddetail;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;

// Referenced classes of package com.inponsel.android.rssfeeddetail:
//            Hal1RSSDetail

class this._cls1
    implements android.content.lickListener
{

    final this._cls1 this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/rssfeeddetail/Hal1RSSDetail$12

/* anonymous class */
    class Hal1RSSDetail._cls12
        implements android.view.View.OnClickListener
    {

        final Hal1RSSDetail this$0;

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
                    (new Hal1RSSDetail.PostBagusKurangTask(Hal1RSSDetail.this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new Hal1RSSDetail.PostBagusKurangTask(Hal1RSSDetail.this)).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(getActivity());
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new Hal1RSSDetail._cls12._cls1());
                view.setNeutralButton("Register", new Hal1RSSDetail._cls12._cls2());
                view.setNegativeButton("Login", new Hal1RSSDetail._cls12._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$0 = Hal1RSSDetail.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/rssfeeddetail/Hal1RSSDetail$12$2

/* anonymous class */
        class Hal1RSSDetail._cls12._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal1RSSDetail._cls12 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                startActivity(dialoginterface);
            }

                    
                    {
                        this$1 = Hal1RSSDetail._cls12.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/rssfeeddetail/Hal1RSSDetail$12$3

/* anonymous class */
        class Hal1RSSDetail._cls12._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal1RSSDetail._cls12 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                startActivity(dialoginterface);
            }

                    
                    {
                        this$1 = Hal1RSSDetail._cls12.this;
                        super();
                    }
        }

    }

}
