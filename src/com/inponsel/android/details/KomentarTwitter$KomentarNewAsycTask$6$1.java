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

class this._cls2
    implements android.content.AsycTask._cls6._cls1
{

    final this._cls2 this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }

    l.user_photo()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/details/KomentarTwitter$KomentarNewAsycTask$6

/* anonymous class */
    class KomentarTwitter.KomentarNewAsycTask._cls6
        implements android.view.View.OnClickListener
    {

        final KomentarTwitter.KomentarNewAsycTask this$1;
        private final String val$id_komtw;
        private final String val$id_tw;
        private final String val$komen_tw;
        private final String val$tanggal_kom;
        private final String val$user_name;
        private final String val$user_photo;

        public void onClick(View view)
        {
            if (KomentarTwitter.KomentarNewAsycTask.access$2(KomentarTwitter.KomentarNewAsycTask.this).userFunctions.isUserLoggedIn(KomentarTwitter.KomentarNewAsycTask.access$2(KomentarTwitter.KomentarNewAsycTask.this)))
            {
                view = new Intent(KomentarTwitter.KomentarNewAsycTask.access$2(KomentarTwitter.KomentarNewAsycTask.this), com/inponsel/android/details/ReplyKomTwActivity);
                view.putExtra("tw_name", KomentarTwitter.KomentarNewAsycTask.access$2(KomentarTwitter.KomentarNewAsycTask.this).tw_name);
                view.putExtra("id_tw", id_tw);
                view.putExtra("id_komtw", id_komtw);
                view.putExtra("user_id", KomentarTwitter.KomentarNewAsycTask.access$2(KomentarTwitter.KomentarNewAsycTask.this).user_id);
                view.putExtra("user_name", user_name);
                view.putExtra("tanggal_kom", tanggal_kom);
                view.putExtra("komen_tw", komen_tw);
                view.putExtra("user_photo", user_photo);
                view.putExtra("top_id", KomentarTwitter.KomentarNewAsycTask.access$2(KomentarTwitter.KomentarNewAsycTask.this).top_id);
                Log.e("id_komtw_to", id_komtw);
                KomentarTwitter.KomentarNewAsycTask.access$2(KomentarTwitter.KomentarNewAsycTask.this).startActivityForResult(view, KomentarTwitter.access$2());
                return;
            } else
            {
                view = new android.app.AlertDialog.Builder(KomentarTwitter.KomentarNewAsycTask.access$2(KomentarTwitter.KomentarNewAsycTask.this).wrapperLight);
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new KomentarTwitter.KomentarNewAsycTask._cls6._cls1());
                view.setNeutralButton("Register", new KomentarTwitter.KomentarNewAsycTask._cls6._cls2());
                view.setNegativeButton("Login", new KomentarTwitter.KomentarNewAsycTask._cls6._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_komentarnewasyctask;
                id_tw = s;
                id_komtw = s1;
                user_name = s2;
                tanggal_kom = s3;
                komen_tw = s4;
                user_photo = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/details/KomentarTwitter$KomentarNewAsycTask$6$2

/* anonymous class */
        class KomentarTwitter.KomentarNewAsycTask._cls6._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final KomentarTwitter.KomentarNewAsycTask._cls6 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(KomentarTwitter.KomentarNewAsycTask.access$2(this$1), com/inponsel/android/v2/RegisterActivity);
                KomentarTwitter.KomentarNewAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = KomentarTwitter.KomentarNewAsycTask._cls6.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/details/KomentarTwitter$KomentarNewAsycTask$6$3

/* anonymous class */
        class KomentarTwitter.KomentarNewAsycTask._cls6._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final KomentarTwitter.KomentarNewAsycTask._cls6 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(KomentarTwitter.KomentarNewAsycTask.access$2(this$1), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                KomentarTwitter.KomentarNewAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = KomentarTwitter.KomentarNewAsycTask._cls6.this;
                        super();
                    }
        }

    }

}
