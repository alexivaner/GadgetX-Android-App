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
//            Hal2Spek

class val.items
    implements android.content.e.OnClickListener
{

    final val.items this$1;
    private final String val$items[];

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        btnLayarRate.setText(val$items[i]);
        nilbtnLayar = val$items[i];
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$items = _5B_Ljava.lang.String_3B_.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/details/Hal2Spek$23

/* anonymous class */
    class Hal2Spek._cls23
        implements android.view.View.OnClickListener
    {

        final Hal2Spek this$0;

        public void onClick(View view)
        {
            if (userFunction.isUserLoggedIn(getActivity()))
            {
                view = new String[10];
                view[0] = "1";
                view[1] = "2";
                view[2] = "3";
                view[3] = "4";
                view[4] = "5";
                view[5] = "6";
                view[6] = "7";
                view[7] = "8";
                view[8] = "9";
                view[9] = "10";
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(wrapper);
                builder.setTitle("Nilai Layar :");
                builder.setSingleChoiceItems(view, -1, view. new Hal2Spek._cls23._cls1());
                builder.show();
                return;
            } else
            {
                view = new android.app.AlertDialog.Builder(wrapper);
                view.setTitle("Perhatian");
                view.setMessage("Untuk memberi penilaian anda harus login terlebih dahulu");
                view.setPositiveButton("Login", new Hal2Spek._cls23._cls2());
                view.setNeutralButton("Register", new Hal2Spek._cls23._cls3());
                view.setNegativeButton("Tutup", new Hal2Spek._cls23._cls4());
                view.show();
                return;
            }
        }


            
            {
                this$0 = Hal2Spek.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/details/Hal2Spek$23$2

/* anonymous class */
        class Hal2Spek._cls23._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal2Spek._cls23 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                getActivity().startActivityForResult(dialoginterface, 0);
                getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            }

                    
                    {
                        this$1 = Hal2Spek._cls23.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/details/Hal2Spek$23$3

/* anonymous class */
        class Hal2Spek._cls23._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal2Spek._cls23 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                getActivity().startActivityForResult(dialoginterface, 0);
                getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            }

                    
                    {
                        this$1 = Hal2Spek._cls23.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/details/Hal2Spek$23$4

/* anonymous class */
        class Hal2Spek._cls23._cls4
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal2Spek._cls23 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = Hal2Spek._cls23.this;
                        super();
                    }
        }

    }

}
