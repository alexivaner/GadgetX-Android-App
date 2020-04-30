// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.UserFunctions;

// Referenced classes of package com.inponsel.android.v2:
//            KomentarPonsel, ReplyFormActivity, RegisterActivity, LoginActivity

class this._cls2
    implements android.content.ask._cls5._cls1
{

    final this._cls2 this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }

    l.komentarhp()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/KomentarPonsel$KomentarAsycTask$5

/* anonymous class */
    class KomentarPonsel.KomentarAsycTask._cls5
        implements android.view.View.OnClickListener
    {

        final KomentarPonsel.KomentarAsycTask this$1;
        private final String val$codename;
        private final String val$email_komentar;
        private final String val$id_hp;
        private final String val$id_komentar;
        private final String val$komentarhp;
        private final String val$nama_komentar;
        private final String val$tanggal_komentar;
        private final String val$usr_pict_komen;

        public void onClick(View view)
        {
            Log.e("iRep", (new StringBuilder(String.valueOf(id_hp))).append(" - ").append(id_komentar).append(" - ").append(email_komentar).append(" - ").append(nama_komentar).append(" - ").append(tanggal_komentar).append(" - ").append(usr_pict_komen).append(" - ").append(KomentarPonsel.KomentarAsycTask.access$2(KomentarPonsel.KomentarAsycTask.this).namalengkap).append(" - ").append(codename).toString());
            if (KomentarPonsel.KomentarAsycTask.access$2(KomentarPonsel.KomentarAsycTask.this).userFunctions.isUserLoggedIn(KomentarPonsel.KomentarAsycTask.access$2(KomentarPonsel.KomentarAsycTask.this)))
            {
                view = new Intent(KomentarPonsel.KomentarAsycTask.access$2(KomentarPonsel.KomentarAsycTask.this), com/inponsel/android/v2/ReplyFormActivity);
                view.putExtra("idhp", id_hp);
                view.putExtra("idkomen", id_komentar);
                view.putExtra("email_komentar", email_komentar);
                view.putExtra("userkomen", nama_komentar);
                view.putExtra("tanggal", tanggal_komentar);
                view.putExtra("isikomentar", komentarhp);
                view.putExtra("nmlengkap", KomentarPonsel.KomentarAsycTask.access$2(KomentarPonsel.KomentarAsycTask.this).namalengkap);
                view.putExtra("userpict", usr_pict_komen);
                view.putExtra("codename", codename);
                view.putExtra("top_id", KomentarPonsel.KomentarAsycTask.access$2(KomentarPonsel.KomentarAsycTask.this).top_id);
                KomentarPonsel.KomentarAsycTask.access$2(KomentarPonsel.KomentarAsycTask.this).startActivityForResult(view, KomentarPonsel.access$5());
                return;
            } else
            {
                view = new android.app.AlertDialog.Builder(KomentarPonsel.KomentarAsycTask.access$2(KomentarPonsel.KomentarAsycTask.this).wrapperLight);
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new KomentarPonsel.KomentarAsycTask._cls5._cls1());
                view.setNeutralButton("Register", new KomentarPonsel.KomentarAsycTask._cls5._cls2());
                view.setNegativeButton("Login", new KomentarPonsel.KomentarAsycTask._cls5._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_komentarasyctask;
                id_hp = s;
                id_komentar = s1;
                email_komentar = s2;
                nama_komentar = s3;
                tanggal_komentar = s4;
                usr_pict_komen = s5;
                codename = s6;
                komentarhp = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/KomentarPonsel$KomentarAsycTask$5$2

/* anonymous class */
        class KomentarPonsel.KomentarAsycTask._cls5._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final KomentarPonsel.KomentarAsycTask._cls5 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(KomentarPonsel.KomentarAsycTask.access$2(this$1), com/inponsel/android/v2/RegisterActivity);
                KomentarPonsel.KomentarAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = KomentarPonsel.KomentarAsycTask._cls5.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/KomentarPonsel$KomentarAsycTask$5$3

/* anonymous class */
        class KomentarPonsel.KomentarAsycTask._cls5._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final KomentarPonsel.KomentarAsycTask._cls5 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(KomentarPonsel.KomentarAsycTask.access$2(this$1), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                KomentarPonsel.KomentarAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = KomentarPonsel.KomentarAsycTask._cls5.this;
                        super();
                    }
        }

    }

}
