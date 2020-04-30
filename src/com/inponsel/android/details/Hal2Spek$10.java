// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;

// Referenced classes of package com.inponsel.android.details:
//            Hal2Spek

class this._cls0
    implements android.view.Listener
{

    final Hal2Spek this$0;

    public void onClick(View view)
    {
        if (userFunction.isUserLoggedIn(getActivity()))
        {
            Hal2Spek.access$9(Hal2Spek.this);
            return;
        } else
        {
            view = new android.app.Builder(wrapper);
            view.setTitle("Perhatian");
            view.setMessage("Untuk memberi komentar anda harus login terlebih dahulu");
            view.setPositiveButton("Login", new android.content.DialogInterface.OnClickListener() {

                final Hal2Spek._cls10 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                    dialoginterface.putExtra("activity", "main");
                    getActivity().startActivityForResult(dialoginterface, 0);
                    getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$1 = Hal2Spek._cls10.this;
                super();
            }
            });
            view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                final Hal2Spek._cls10 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                    getActivity().startActivityForResult(dialoginterface, 0);
                    getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$1 = Hal2Spek._cls10.this;
                super();
            }
            });
            view.setNegativeButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                final Hal2Spek._cls10 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$1 = Hal2Spek._cls10.this;
                super();
            }
            });
            view.show();
            return;
        }
    }


    _cls3.this._cls1()
    {
        this$0 = Hal2Spek.this;
        super();
    }
}
