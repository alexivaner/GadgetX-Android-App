// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;

// Referenced classes of package com.inponsel.android.details:
//            TwitterListInPonsel

class this._cls2
    implements android.content.AsycTask._cls6._cls1
{

    final is._cls1 this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        ss._mth2(_fld1).stat = "0";
        (new is._cls1(ss._mth2(_fld1)))._mth1(new Void[0]);
    }

    l.since_id()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/details/TwitterListInPonsel$KomentarNextAsycTask$6

/* anonymous class */
    class TwitterListInPonsel.KomentarNextAsycTask._cls6
        implements android.view.View.OnClickListener
    {

        final TwitterListInPonsel.KomentarNextAsycTask this$1;
        private final String val$since_id;

        public void onClick(View view)
        {
            TwitterListInPonsel.KomentarNextAsycTask.access$2(TwitterListInPonsel.KomentarNextAsycTask.this).idkom_pos = since_id;
            if (TwitterListInPonsel.KomentarNextAsycTask.access$2(TwitterListInPonsel.KomentarNextAsycTask.this).userFunctions.isUserLoggedIn(TwitterListInPonsel.KomentarNextAsycTask.access$2(TwitterListInPonsel.KomentarNextAsycTask.this)))
            {
                if (TwitterListInPonsel.KomentarNextAsycTask.access$2(TwitterListInPonsel.KomentarNextAsycTask.this).db.checkIfExistTW(TwitterListInPonsel.KomentarNextAsycTask.access$2(TwitterListInPonsel.KomentarNextAsycTask.this).idkom_pos))
                {
                    view = new android.app.AlertDialog.Builder(TwitterListInPonsel.KomentarNextAsycTask.access$2(TwitterListInPonsel.KomentarNextAsycTask.this));
                    view.setMessage("Hapus tweet ini dari favorit?");
                    view.setPositiveButton("Ya", new TwitterListInPonsel.KomentarNextAsycTask._cls6._cls1());
                    view.setNegativeButton("Tidak", new TwitterListInPonsel.KomentarNextAsycTask._cls6._cls2());
                    view.show();
                    return;
                } else
                {
                    view = new android.app.AlertDialog.Builder(TwitterListInPonsel.KomentarNextAsycTask.access$2(TwitterListInPonsel.KomentarNextAsycTask.this));
                    view.setMessage("Favoritkan tweet ini?");
                    view.setPositiveButton("Ya", new TwitterListInPonsel.KomentarNextAsycTask._cls6._cls3());
                    view.setNeutralButton("Tidak", new TwitterListInPonsel.KomentarNextAsycTask._cls6._cls4());
                    view.show();
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(TwitterListInPonsel.KomentarNextAsycTask.access$2(TwitterListInPonsel.KomentarNextAsycTask.this).wrapperLight);
                view.setMessage("Untuk menambahkan ke favorit harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new TwitterListInPonsel.KomentarNextAsycTask._cls6._cls5());
                view.setNeutralButton("Register", new TwitterListInPonsel.KomentarNextAsycTask._cls6._cls6());
                view.setNegativeButton("Login", new TwitterListInPonsel.KomentarNextAsycTask._cls6._cls7());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_komentarnextasyctask;
                since_id = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/details/TwitterListInPonsel$KomentarNextAsycTask$6$2

/* anonymous class */
        class TwitterListInPonsel.KomentarNextAsycTask._cls6._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final TwitterListInPonsel.KomentarNextAsycTask._cls6 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = TwitterListInPonsel.KomentarNextAsycTask._cls6.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/details/TwitterListInPonsel$KomentarNextAsycTask$6$3

/* anonymous class */
        class TwitterListInPonsel.KomentarNextAsycTask._cls6._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final TwitterListInPonsel.KomentarNextAsycTask._cls6 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                TwitterListInPonsel.KomentarNextAsycTask.access$2(this$1).stat = "1";
                (new TwitterListInPonsel.FavoritTask(TwitterListInPonsel.KomentarNextAsycTask.access$2(this$1))).execute(new Void[0]);
            }

                    
                    {
                        this$2 = TwitterListInPonsel.KomentarNextAsycTask._cls6.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/details/TwitterListInPonsel$KomentarNextAsycTask$6$4

/* anonymous class */
        class TwitterListInPonsel.KomentarNextAsycTask._cls6._cls4
            implements android.content.DialogInterface.OnClickListener
        {

            final TwitterListInPonsel.KomentarNextAsycTask._cls6 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = TwitterListInPonsel.KomentarNextAsycTask._cls6.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/details/TwitterListInPonsel$KomentarNextAsycTask$6$5

/* anonymous class */
        class TwitterListInPonsel.KomentarNextAsycTask._cls6._cls5
            implements android.content.DialogInterface.OnClickListener
        {

            final TwitterListInPonsel.KomentarNextAsycTask._cls6 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = TwitterListInPonsel.KomentarNextAsycTask._cls6.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/details/TwitterListInPonsel$KomentarNextAsycTask$6$6

/* anonymous class */
        class TwitterListInPonsel.KomentarNextAsycTask._cls6._cls6
            implements android.content.DialogInterface.OnClickListener
        {

            final TwitterListInPonsel.KomentarNextAsycTask._cls6 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(TwitterListInPonsel.KomentarNextAsycTask.access$2(this$1), com/inponsel/android/v2/RegisterActivity);
                TwitterListInPonsel.KomentarNextAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = TwitterListInPonsel.KomentarNextAsycTask._cls6.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/details/TwitterListInPonsel$KomentarNextAsycTask$6$7

/* anonymous class */
        class TwitterListInPonsel.KomentarNextAsycTask._cls6._cls7
            implements android.content.DialogInterface.OnClickListener
        {

            final TwitterListInPonsel.KomentarNextAsycTask._cls6 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(TwitterListInPonsel.KomentarNextAsycTask.access$2(this$1), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                TwitterListInPonsel.KomentarNextAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = TwitterListInPonsel.KomentarNextAsycTask._cls6.this;
                        super();
                    }
        }

    }

}
