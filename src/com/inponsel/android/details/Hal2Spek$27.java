// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
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
            view = new android.app.Builder(wrapper);
            view.setTitle((new StringBuilder("Penilaian ")).append(namalengkap).toString());
            view.setMessage((new StringBuilder("Desain : ")).append(nilbtnDesain).append("\nLayar : ").append(nilbtnLayar).append("\nKinerja : ").append(nilbtnKinerja).append("\nKamera : ").append(nilbtnKamera).append("\nBaterai : ").append(nilbtnBaterai).toString());
            view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                final Hal2Spek._cls27 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new Hal2Spek.PostNilaiTask(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                        return;
                    }
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new Hal2Spek.PostNilaiTask(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                        return;
                    } else
                    {
                        (new Hal2Spek.PostNilaiTask(this$0)).execute(new Void[0]);
                        return;
                    }
                }

            
            {
                this$1 = Hal2Spek._cls27.this;
                super();
            }
            });
            view.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                final Hal2Spek._cls27 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$1 = Hal2Spek._cls27.this;
                super();
            }
            });
            view.show();
            return;
        } else
        {
            view = new android.app.Builder(wrapper);
            view.setTitle("Perhatian");
            view.setMessage("Untuk memberi penilaian anda harus login terlebih dahulu");
            view.setPositiveButton("Login", new android.content.DialogInterface.OnClickListener() {

                final Hal2Spek._cls27 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                    dialoginterface.putExtra("activity", "main");
                    getActivity().startActivityForResult(dialoginterface, 0);
                    getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$1 = Hal2Spek._cls27.this;
                super();
            }
            });
            view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                final Hal2Spek._cls27 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                    getActivity().startActivityForResult(dialoginterface, 0);
                    getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$1 = Hal2Spek._cls27.this;
                super();
            }
            });
            view.setNegativeButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                final Hal2Spek._cls27 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$1 = Hal2Spek._cls27.this;
                super();
            }
            });
            view.show();
            return;
        }
    }


    _cls5.this._cls1()
    {
        this$0 = Hal2Spek.this;
        super();
    }
}
