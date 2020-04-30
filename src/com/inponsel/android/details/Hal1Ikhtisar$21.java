// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;

// Referenced classes of package com.inponsel.android.details:
//            Hal1Ikhtisar

class this._cls0
    implements android.view.ener
{

    final Hal1Ikhtisar this$0;

    public void onClick(View view)
    {
        ponselBaseApp.getObserver().setIndexHp(codename);
        if (userFunction.isUserLoggedIn(getActivity()))
        {
            statusLikeHp = "1";
            if (android.os.K_INT >= 11)
            {
                (new tBagusKurangTask(Hal1Ikhtisar.this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                return;
            } else
            {
                (new tBagusKurangTask(Hal1Ikhtisar.this)).execute(new Void[0]);
                return;
            }
        } else
        {
            view = new android.app.der(getActivity());
            view.setTitle("Perhatian");
            view.setMessage("Untuk memberi penilaian anda harus login terlebih dahulu");
            view.setPositiveButton("Login", new android.content.DialogInterface.OnClickListener() {

                final Hal1Ikhtisar._cls21 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                    dialoginterface.putExtra("activity", "main");
                    startActivityForResult(dialoginterface, 0);
                    getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$1 = Hal1Ikhtisar._cls21.this;
                super();
            }
            });
            view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                final Hal1Ikhtisar._cls21 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                    startActivityForResult(dialoginterface, 0);
                    getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$1 = Hal1Ikhtisar._cls21.this;
                super();
            }
            });
            view.setNegativeButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                final Hal1Ikhtisar._cls21 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$1 = Hal1Ikhtisar._cls21.this;
                super();
            }
            });
            view.show();
            return;
        }
    }


    _cls3.this._cls1()
    {
        this$0 = Hal1Ikhtisar.this;
        super();
    }
}
