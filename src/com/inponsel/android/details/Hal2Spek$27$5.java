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

class this._cls1
    implements android.content.e.OnClickListener
{

    final ener this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/details/Hal2Spek$27

/* anonymous class */
    class Hal2Spek._cls27
        implements android.view.View.OnClickListener
    {

        final Hal2Spek this$0;

        public void onClick(View view)
        {
            if (userFunction.isUserLoggedIn(getActivity()))
            {
                view = new android.app.AlertDialog.Builder(wrapper);
                view.setTitle((new StringBuilder("Penilaian ")).append(namalengkap).toString());
                view.setMessage((new StringBuilder("Desain : ")).append(nilbtnDesain).append("\nLayar : ").append(nilbtnLayar).append("\nKinerja : ").append(nilbtnKinerja).append("\nKamera : ").append(nilbtnKamera).append("\nBaterai : ").append(nilbtnBaterai).toString());
                view.setPositiveButton("Ya", new Hal2Spek._cls27._cls1());
                view.setNegativeButton("Tidak", new Hal2Spek._cls27._cls2());
                view.show();
                return;
            } else
            {
                view = new android.app.AlertDialog.Builder(wrapper);
                view.setTitle("Perhatian");
                view.setMessage("Untuk memberi penilaian anda harus login terlebih dahulu");
                view.setPositiveButton("Login", new Hal2Spek._cls27._cls3());
                view.setNeutralButton("Register", new Hal2Spek._cls27._cls4());
                view.setNegativeButton("Tutup", new Hal2Spek._cls27._cls5());
                view.show();
                return;
            }
        }


            
            {
                this$0 = Hal2Spek.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/details/Hal2Spek$27$1

/* anonymous class */
        class Hal2Spek._cls27._cls1
            implements android.content.DialogInterface.OnClickListener
        {

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
        }


        // Unreferenced inner class com/inponsel/android/details/Hal2Spek$27$2

/* anonymous class */
        class Hal2Spek._cls27._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal2Spek._cls27 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = Hal2Spek._cls27.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/details/Hal2Spek$27$3

/* anonymous class */
        class Hal2Spek._cls27._cls3
            implements android.content.DialogInterface.OnClickListener
        {

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
        }


        // Unreferenced inner class com/inponsel/android/details/Hal2Spek$27$4

/* anonymous class */
        class Hal2Spek._cls27._cls4
            implements android.content.DialogInterface.OnClickListener
        {

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
        }

    }

}
