// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.scdetail;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;
import com.inponsel.android.v2.SCReplyFormActivity;

// Referenced classes of package com.inponsel.android.scdetail:
//            Hal1SCDetail

class this._cls2
    implements android.content.rAsycTask._cls5._cls1
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

    // Unreferenced inner class com/inponsel/android/scdetail/Hal1SCDetail$KomentarAsycTask$5

/* anonymous class */
    class Hal1SCDetail.KomentarAsycTask._cls5
        implements android.view.View.OnClickListener
    {

        final Hal1SCDetail.KomentarAsycTask this$1;
        private final String val$id_komrss;
        private final String val$komen_rss;
        private final String val$tanggal_kom;
        private final String val$user_name;
        private final String val$user_photo;

        public void onClick(View view)
        {
            Hal1SCDetail.KomentarAsycTask.access$2(Hal1SCDetail.KomentarAsycTask.this).idkom_pos = id_komrss;
            if (Hal1SCDetail.KomentarAsycTask.access$2(Hal1SCDetail.KomentarAsycTask.this).userFunctions.isUserLoggedIn(Hal1SCDetail.KomentarAsycTask.access$2(Hal1SCDetail.KomentarAsycTask.this).getActivity()))
            {
                view = new Intent(Hal1SCDetail.KomentarAsycTask.access$2(Hal1SCDetail.KomentarAsycTask.this).getActivity(), com/inponsel/android/v2/SCReplyFormActivity);
                view.putExtra("top_id", Hal1SCDetail.KomentarAsycTask.access$2(Hal1SCDetail.KomentarAsycTask.this).top_id);
                view.putExtra("idkomen", Hal1SCDetail.KomentarAsycTask.access$2(Hal1SCDetail.KomentarAsycTask.this).idkom_pos);
                view.putExtra("id_sc", Hal1SCDetail.KomentarAsycTask.access$2(Hal1SCDetail.KomentarAsycTask.this).str_SC_ID);
                view.putExtra("userkomen", user_name);
                view.putExtra("tanggal", tanggal_kom);
                view.putExtra("isikomentar", komen_rss);
                view.putExtra("userpict", user_photo);
                view.putExtra("sc_nama", Hal1SCDetail.KomentarAsycTask.access$2(Hal1SCDetail.KomentarAsycTask.this).str_SC_NAMA);
                view.putExtra("sc_merk", Hal1SCDetail.KomentarAsycTask.access$2(Hal1SCDetail.KomentarAsycTask.this).str_SC_merk);
                Hal1SCDetail.KomentarAsycTask.access$2(Hal1SCDetail.KomentarAsycTask.this).getActivity().startActivityForResult(view, Hal1SCDetail.access$6());
                return;
            } else
            {
                view = new android.app.AlertDialog.Builder(Hal1SCDetail.KomentarAsycTask.access$2(Hal1SCDetail.KomentarAsycTask.this).getActivity());
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new Hal1SCDetail.KomentarAsycTask._cls5._cls1());
                view.setNeutralButton("Register", new Hal1SCDetail.KomentarAsycTask._cls5._cls2());
                view.setNegativeButton("Login", new Hal1SCDetail.KomentarAsycTask._cls5._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_komentarasyctask;
                id_komrss = s;
                user_name = s1;
                tanggal_kom = s2;
                komen_rss = s3;
                user_photo = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/scdetail/Hal1SCDetail$KomentarAsycTask$5$2

/* anonymous class */
        class Hal1SCDetail.KomentarAsycTask._cls5._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal1SCDetail.KomentarAsycTask._cls5 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(Hal1SCDetail.KomentarAsycTask.access$2(this$1).getActivity(), com/inponsel/android/v2/RegisterActivity);
                Hal1SCDetail.KomentarAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = Hal1SCDetail.KomentarAsycTask._cls5.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/scdetail/Hal1SCDetail$KomentarAsycTask$5$3

/* anonymous class */
        class Hal1SCDetail.KomentarAsycTask._cls5._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal1SCDetail.KomentarAsycTask._cls5 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(Hal1SCDetail.KomentarAsycTask.access$2(this$1).getActivity(), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                Hal1SCDetail.KomentarAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = Hal1SCDetail.KomentarAsycTask._cls5.this;
                        super();
                    }
        }

    }

}
