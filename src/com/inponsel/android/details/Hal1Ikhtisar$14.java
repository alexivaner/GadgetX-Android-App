// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;

// Referenced classes of package com.inponsel.android.details:
//            Hal1Ikhtisar

class this._cls0
    implements android.view.ener
{

    final Hal1Ikhtisar this$0;

    public void onClick(final View items)
    {
        if (userFunction.isUserLoggedIn(getActivity()))
        {
            items = new String[10];
            items[0] = "1";
            items[1] = "2";
            items[2] = "3";
            items[3] = "4";
            items[4] = "5";
            items[5] = "6";
            items[6] = "7";
            items[7] = "8";
            items[8] = "9";
            items[9] = "10";
            android.app.der der = new android.app.der(wrapper);
            der.setTitle("Nilai Desain :");
            der.setSingleChoiceItems(items, -1, new android.content.DialogInterface.OnClickListener() {

                final Hal1Ikhtisar._cls14 this$1;
                private final String val$items[];

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                    btnDesainRate.setText(items[i]);
                    nilbtnDesain = items[i];
                }

            
            {
                this$1 = Hal1Ikhtisar._cls14.this;
                items = as;
                super();
            }
            });
            der.show();
            return;
        } else
        {
            items = new android.app.der(wrapper);
            items.setTitle("Perhatian");
            items.setMessage("Untuk memberi penilaian anda harus login terlebih dahulu");
            items.setPositiveButton("Login", new android.content.DialogInterface.OnClickListener() {

                final Hal1Ikhtisar._cls14 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                    dialoginterface.putExtra("activity", "main");
                    getActivity().startActivityForResult(dialoginterface, 0);
                    getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$1 = Hal1Ikhtisar._cls14.this;
                super();
            }
            });
            items.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                final Hal1Ikhtisar._cls14 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                    getActivity().startActivityForResult(dialoginterface, 0);
                    getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$1 = Hal1Ikhtisar._cls14.this;
                super();
            }
            });
            items.setNegativeButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                final Hal1Ikhtisar._cls14 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$1 = Hal1Ikhtisar._cls14.this;
                super();
            }
            });
            items.show();
            return;
        }
    }


    _cls4.this._cls1()
    {
        this$0 = Hal1Ikhtisar.this;
        super();
    }
}
