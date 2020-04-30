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

class val.user_photo
    implements android.view.omen.PostKomen._cls5
{

    final y this$1;
    private final String val$id_komrss;
    private final String val$komen_rss;
    private final String val$sc_id;
    private final String val$tanggal_kom;
    private final String val$user_name;
    private final String val$user_photo;

    public void onClick(View view)
    {
        if (cess._mth2(this._cls1.this).userFunctions.isUserLoggedIn(cess._mth2(this._cls1.this).getActivity()))
        {
            view = new Intent(cess._mth2(this._cls1.this).getActivity(), com/inponsel/android/v2/SCReplyFormActivity);
            view.putExtra("top_id", cess._mth2(this._cls1.this).top_id);
            view.putExtra("idkomen", val$id_komrss);
            view.putExtra("id_sc", val$sc_id);
            view.putExtra("userkomen", val$user_name);
            view.putExtra("tanggal", val$tanggal_kom);
            view.putExtra("isikomentar", val$komen_rss);
            view.putExtra("userpict", val$user_photo);
            view.putExtra("sc_nama", "");
            view.putExtra("sc_merk", "");
            cess._mth2(this._cls1.this).getActivity().startActivityForResult(view, Hal2Komen.access$5());
            return;
        } else
        {
            view = new android.app.nit>(cess._mth2(this._cls1.this).wrapperLight);
            view.tMessage("Untuk memberi penilaian harus login terlebih dahulu.");
            view.tPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                final Hal2Komen.PostKomen._cls5 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$2 = Hal2Komen.PostKomen._cls5.this;
                super();
            }
            });
            view.tNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                final Hal2Komen.PostKomen._cls5 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(Hal2Komen.PostKomen.access$2(this$1).getActivity(), com/inponsel/android/v2/RegisterActivity);
                    Hal2Komen.PostKomen.access$2(this$1).startActivity(dialoginterface);
                }

            
            {
                this$2 = Hal2Komen.PostKomen._cls5.this;
                super();
            }
            });
            view.tNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

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
            });
            view.ow();
            return;
        }
    }


    _cls3.this._cls2()
    {
        this$1 = final__pcls2;
        val$id_komrss = s;
        val$sc_id = s1;
        val$user_name = s2;
        val$tanggal_kom = s3;
        val$komen_rss = s4;
        val$user_photo = String.this;
        super();
    }
}
