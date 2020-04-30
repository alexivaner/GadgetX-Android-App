// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;

// Referenced classes of package com.inponsel.android.details:
//            KomentarTwitter, ReplyKomTwActivity

class this._cls1
    implements android.content.ckListener
{

    final this._cls1 this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }

    l.user_photo()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/details/KomentarTwitter$10

/* anonymous class */
    class KomentarTwitter._cls10
        implements android.view.View.OnClickListener
    {

        final KomentarTwitter this$0;
        private final String val$id_komtw;
        private final String val$id_tw;
        private final String val$komen_tw;
        private final String val$tanggal_kom;
        private final String val$user_name;
        private final String val$user_photo;

        public void onClick(View view)
        {
            if (userFunctions.isUserLoggedIn(KomentarTwitter.this))
            {
                view = new Intent(KomentarTwitter.this, com/inponsel/android/details/ReplyKomTwActivity);
                view.putExtra("tw_name", tw_name);
                view.putExtra("id_tw", id_tw);
                view.putExtra("id_komtw", id_komtw);
                view.putExtra("user_id", user_id);
                view.putExtra("user_name", user_name);
                view.putExtra("tanggal_kom", tanggal_kom);
                view.putExtra("komen_tw", komen_tw);
                view.putExtra("user_photo", user_photo);
                view.putExtra("top_id", top_id);
                Log.e("id_komtw_to", id_komtw);
                startActivityForResult(view, KomentarTwitter.access$2());
                return;
            } else
            {
                view = new android.app.AlertDialog.Builder(wrapperLight);
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new KomentarTwitter._cls10._cls1());
                view.setNeutralButton("Register", new KomentarTwitter._cls10._cls2());
                view.setNegativeButton("Login", new KomentarTwitter._cls10._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$0 = final_komentartwitter;
                id_tw = s;
                id_komtw = s1;
                user_name = s2;
                tanggal_kom = s3;
                komen_tw = s4;
                user_photo = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/details/KomentarTwitter$10$2

/* anonymous class */
        class KomentarTwitter._cls10._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final KomentarTwitter._cls10 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(this$0, com/inponsel/android/v2/RegisterActivity);
                startActivity(dialoginterface);
            }

                    
                    {
                        this$1 = KomentarTwitter._cls10.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/details/KomentarTwitter$10$3

/* anonymous class */
        class KomentarTwitter._cls10._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final KomentarTwitter._cls10 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(this$0, com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                startActivity(dialoginterface);
            }

                    
                    {
                        this$1 = KomentarTwitter._cls10.this;
                        super();
                    }
        }

    }

}
