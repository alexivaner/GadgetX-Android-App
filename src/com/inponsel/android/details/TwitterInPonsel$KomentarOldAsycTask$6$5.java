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
//            TwitterInPonsel

class this._cls2
    implements android.content.AsycTask._cls6._cls5
{

    final this._cls2 this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }

    l.since_id()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/details/TwitterInPonsel$KomentarOldAsycTask$6

/* anonymous class */
    class TwitterInPonsel.KomentarOldAsycTask._cls6
        implements android.view.View.OnClickListener
    {

        final TwitterInPonsel.KomentarOldAsycTask this$1;
        private final String val$since_id;

        public void onClick(View view)
        {
            TwitterInPonsel.KomentarOldAsycTask.access$2(TwitterInPonsel.KomentarOldAsycTask.this).idkom_pos = since_id;
            if (TwitterInPonsel.KomentarOldAsycTask.access$2(TwitterInPonsel.KomentarOldAsycTask.this).userFunctions.isUserLoggedIn(TwitterInPonsel.KomentarOldAsycTask.access$2(TwitterInPonsel.KomentarOldAsycTask.this)))
            {
                if (TwitterInPonsel.KomentarOldAsycTask.access$2(TwitterInPonsel.KomentarOldAsycTask.this).db.checkIfExistTW(TwitterInPonsel.KomentarOldAsycTask.access$2(TwitterInPonsel.KomentarOldAsycTask.this).idkom_pos))
                {
                    view = new android.app.AlertDialog.Builder(TwitterInPonsel.KomentarOldAsycTask.access$2(TwitterInPonsel.KomentarOldAsycTask.this));
                    view.setMessage("Hapus tweet ini dari favorit?");
                    view.setPositiveButton("Ya", new TwitterInPonsel.KomentarOldAsycTask._cls6._cls1());
                    view.setNegativeButton("Tidak", new TwitterInPonsel.KomentarOldAsycTask._cls6._cls2());
                    view.show();
                    return;
                } else
                {
                    view = new android.app.AlertDialog.Builder(TwitterInPonsel.KomentarOldAsycTask.access$2(TwitterInPonsel.KomentarOldAsycTask.this));
                    view.setMessage("Favoritkan tweet ini?");
                    view.setPositiveButton("Ya", new TwitterInPonsel.KomentarOldAsycTask._cls6._cls3());
                    view.setNeutralButton("Tidak", new TwitterInPonsel.KomentarOldAsycTask._cls6._cls4());
                    view.show();
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(TwitterInPonsel.KomentarOldAsycTask.access$2(TwitterInPonsel.KomentarOldAsycTask.this).wrapperLight);
                view.setMessage("Untuk menambahkan ke favorit harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new TwitterInPonsel.KomentarOldAsycTask._cls6._cls5());
                view.setNeutralButton("Register", new TwitterInPonsel.KomentarOldAsycTask._cls6._cls6());
                view.setNegativeButton("Login", new TwitterInPonsel.KomentarOldAsycTask._cls6._cls7());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_komentaroldasyctask;
                since_id = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/details/TwitterInPonsel$KomentarOldAsycTask$6$1

/* anonymous class */
        class TwitterInPonsel.KomentarOldAsycTask._cls6._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final TwitterInPonsel.KomentarOldAsycTask._cls6 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
                TwitterInPonsel.KomentarOldAsycTask.access$2(this$1).stat = "0";
                (new TwitterInPonsel.FavoritTask(TwitterInPonsel.KomentarOldAsycTask.access$2(this$1))).execute(new Void[0]);
            }

                    
                    {
                        this$2 = TwitterInPonsel.KomentarOldAsycTask._cls6.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/details/TwitterInPonsel$KomentarOldAsycTask$6$2

/* anonymous class */
        class TwitterInPonsel.KomentarOldAsycTask._cls6._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final TwitterInPonsel.KomentarOldAsycTask._cls6 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = TwitterInPonsel.KomentarOldAsycTask._cls6.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/details/TwitterInPonsel$KomentarOldAsycTask$6$3

/* anonymous class */
        class TwitterInPonsel.KomentarOldAsycTask._cls6._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final TwitterInPonsel.KomentarOldAsycTask._cls6 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                TwitterInPonsel.KomentarOldAsycTask.access$2(this$1).stat = "1";
                (new TwitterInPonsel.FavoritTask(TwitterInPonsel.KomentarOldAsycTask.access$2(this$1))).execute(new Void[0]);
            }

                    
                    {
                        this$2 = TwitterInPonsel.KomentarOldAsycTask._cls6.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/details/TwitterInPonsel$KomentarOldAsycTask$6$4

/* anonymous class */
        class TwitterInPonsel.KomentarOldAsycTask._cls6._cls4
            implements android.content.DialogInterface.OnClickListener
        {

            final TwitterInPonsel.KomentarOldAsycTask._cls6 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = TwitterInPonsel.KomentarOldAsycTask._cls6.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/details/TwitterInPonsel$KomentarOldAsycTask$6$6

/* anonymous class */
        class TwitterInPonsel.KomentarOldAsycTask._cls6._cls6
            implements android.content.DialogInterface.OnClickListener
        {

            final TwitterInPonsel.KomentarOldAsycTask._cls6 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(TwitterInPonsel.KomentarOldAsycTask.access$2(this$1), com/inponsel/android/v2/RegisterActivity);
                TwitterInPonsel.KomentarOldAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = TwitterInPonsel.KomentarOldAsycTask._cls6.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/details/TwitterInPonsel$KomentarOldAsycTask$6$7

/* anonymous class */
        class TwitterInPonsel.KomentarOldAsycTask._cls6._cls7
            implements android.content.DialogInterface.OnClickListener
        {

            final TwitterInPonsel.KomentarOldAsycTask._cls6 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(TwitterInPonsel.KomentarOldAsycTask.access$2(this$1), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                TwitterInPonsel.KomentarOldAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = TwitterInPonsel.KomentarOldAsycTask._cls6.this;
                        super();
                    }
        }

    }

}