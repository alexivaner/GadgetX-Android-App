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
//            Hal2Komen

class this._cls2
    implements android.content.istener
{

    final is._cls1 this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent(ss._mth2(_fld1).getActivity(), com/inponsel/android/v2/RegisterActivity);
        ss._mth2(_fld1).startActivity(dialoginterface);
    }

    l.user_photo()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/scdetail/Hal2Komen$PostKomen$5

/* anonymous class */
    class Hal2Komen.PostKomen._cls5
        implements android.view.View.OnClickListener
    {

        final Hal2Komen.PostKomen this$1;
        private final String val$id_komrss;
        private final String val$komen_rss;
        private final String val$sc_id;
        private final String val$tanggal_kom;
        private final String val$user_name;
        private final String val$user_photo;

        public void onClick(View view)
        {
            if (Hal2Komen.PostKomen.access$2(Hal2Komen.PostKomen.this).userFunctions.isUserLoggedIn(Hal2Komen.PostKomen.access$2(Hal2Komen.PostKomen.this).getActivity()))
            {
                view = new Intent(Hal2Komen.PostKomen.access$2(Hal2Komen.PostKomen.this).getActivity(), com/inponsel/android/v2/SCReplyFormActivity);
                view.putExtra("top_id", Hal2Komen.PostKomen.access$2(Hal2Komen.PostKomen.this).top_id);
                view.putExtra("idkomen", id_komrss);
                view.putExtra("id_sc", sc_id);
                view.putExtra("userkomen", user_name);
                view.putExtra("tanggal", tanggal_kom);
                view.putExtra("isikomentar", komen_rss);
                view.putExtra("userpict", user_photo);
                view.putExtra("sc_nama", "");
                view.putExtra("sc_merk", "");
                Hal2Komen.PostKomen.access$2(Hal2Komen.PostKomen.this).getActivity().startActivityForResult(view, Hal2Komen.access$5());
                return;
            } else
            {
                view = new android.app.AlertDialog.Builder(Hal2Komen.PostKomen.access$2(Hal2Komen.PostKomen.this).wrapperLight);
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new Hal2Komen.PostKomen._cls5._cls1());
                view.setNeutralButton("Register", new Hal2Komen.PostKomen._cls5._cls2());
                view.setNegativeButton("Login", new Hal2Komen.PostKomen._cls5._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_postkomen;
                id_komrss = s;
                sc_id = s1;
                user_name = s2;
                tanggal_kom = s3;
                komen_rss = s4;
                user_photo = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/scdetail/Hal2Komen$PostKomen$5$1

/* anonymous class */
        class Hal2Komen.PostKomen._cls5._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal2Komen.PostKomen._cls5 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = Hal2Komen.PostKomen._cls5.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/scdetail/Hal2Komen$PostKomen$5$3

/* anonymous class */
        class Hal2Komen.PostKomen._cls5._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal2Komen.PostKomen._cls5 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(Hal2Komen.PostKomen.access$2(this$1).getActivity(), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                Hal2Komen.PostKomen.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = Hal2Komen.PostKomen._cls5.this;
                        super();
                    }
        }

    }

}
