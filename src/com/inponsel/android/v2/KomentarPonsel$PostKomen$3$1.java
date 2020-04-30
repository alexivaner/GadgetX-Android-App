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
    implements android.content.er
{

    final this._cls2 this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }

    l.usr_pict_komen()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/KomentarPonsel$PostKomen$3

/* anonymous class */
    class KomentarPonsel.PostKomen._cls3
        implements android.view.View.OnClickListener
    {

        final KomentarPonsel.PostKomen this$1;
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
            Log.e("iRep", (new StringBuilder(String.valueOf(id_hp))).append(" - ").append(id_komentar).append(" - ").append(email_komentar).append(" - ").append(nama_komentar).append(" - ").append(tanggal_komentar).append(" - ").append(komentarhp).append(" - ").append(KomentarPonsel.PostKomen.access$2(KomentarPonsel.PostKomen.this).namalengkap).append(" - ").append(codename).toString());
            if (KomentarPonsel.PostKomen.access$2(KomentarPonsel.PostKomen.this).userFunctions.isUserLoggedIn(KomentarPonsel.PostKomen.access$2(KomentarPonsel.PostKomen.this)))
            {
                view = new Intent(KomentarPonsel.PostKomen.access$2(KomentarPonsel.PostKomen.this), com/inponsel/android/v2/ReplyFormActivity);
                view.putExtra("idhp", id_hp);
                view.putExtra("idkomen", id_komentar);
                view.putExtra("email_komentar", email_komentar);
                view.putExtra("userkomen", nama_komentar);
                view.putExtra("tanggal", tanggal_komentar);
                view.putExtra("isikomentar", komentarhp);
                view.putExtra("nmlengkap", KomentarPonsel.PostKomen.access$2(KomentarPonsel.PostKomen.this).namalengkap);
                view.putExtra("userpict", usr_pict_komen);
                view.putExtra("codename", codename);
                view.putExtra("top_id", KomentarPonsel.PostKomen.access$2(KomentarPonsel.PostKomen.this).top_id);
                KomentarPonsel.PostKomen.access$2(KomentarPonsel.PostKomen.this).startActivityForResult(view, KomentarPonsel.access$5());
                return;
            } else
            {
                view = new android.app.AlertDialog.Builder(KomentarPonsel.PostKomen.access$2(KomentarPonsel.PostKomen.this));
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new KomentarPonsel.PostKomen._cls3._cls1());
                view.setNeutralButton("Register", new KomentarPonsel.PostKomen._cls3._cls2());
                view.setNegativeButton("Login", new KomentarPonsel.PostKomen._cls3._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_postkomen;
                id_hp = s;
                id_komentar = s1;
                email_komentar = s2;
                nama_komentar = s3;
                tanggal_komentar = s4;
                komentarhp = s5;
                codename = s6;
                usr_pict_komen = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/KomentarPonsel$PostKomen$3$2

/* anonymous class */
        class KomentarPonsel.PostKomen._cls3._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final KomentarPonsel.PostKomen._cls3 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(KomentarPonsel.PostKomen.access$2(this$1), com/inponsel/android/v2/RegisterActivity);
                KomentarPonsel.PostKomen.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = KomentarPonsel.PostKomen._cls3.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/KomentarPonsel$PostKomen$3$3

/* anonymous class */
        class KomentarPonsel.PostKomen._cls3._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final KomentarPonsel.PostKomen._cls3 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(KomentarPonsel.PostKomen.access$2(this$1), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                KomentarPonsel.PostKomen.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = KomentarPonsel.PostKomen._cls3.this;
                        super();
                    }
        }

    }

}
