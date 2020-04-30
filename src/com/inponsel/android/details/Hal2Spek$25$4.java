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

    // Unreferenced inner class com/inponsel/android/details/Hal2Spek$25

/* anonymous class */
    class Hal2Spek._cls25
        implements android.view.View.OnClickListener
    {

        final Hal2Spek this$0;

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
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(wrapper);
                builder.setTitle("Nilai Kamera :");
                builder.setSingleChoiceItems(items, -1, new Hal2Spek._cls25._cls1());
                builder.show();
                return;
            } else
            {
                items = new android.app.AlertDialog.Builder(wrapper);
                items.setTitle("Perhatian");
                items.setMessage("Untuk memberi penilaian anda harus login terlebih dahulu");
                items.setPositiveButton("Login", new Hal2Spek._cls25._cls2());
                items.setNeutralButton("Register", new Hal2Spek._cls25._cls3());
                items.setNegativeButton("Tutup", new Hal2Spek._cls25._cls4());
                items.show();
                return;
            }
        }


            
            {
                this$0 = Hal2Spek.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/details/Hal2Spek$25$1

/* anonymous class */
        class Hal2Spek._cls25._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal2Spek._cls25 this$1;
            private final String val$items[];

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
                btnKameraRate.setText(items[i]);
                nilbtnKamera = items[i];
            }

                    
                    {
                        this$1 = Hal2Spek._cls25.this;
                        items = as;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/details/Hal2Spek$25$2

/* anonymous class */
        class Hal2Spek._cls25._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal2Spek._cls25 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                getActivity().startActivityForResult(dialoginterface, 0);
                getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            }

                    
                    {
                        this$1 = Hal2Spek._cls25.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/details/Hal2Spek$25$3

/* anonymous class */
        class Hal2Spek._cls25._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal2Spek._cls25 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                getActivity().startActivityForResult(dialoginterface, 0);
                getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            }

                    
                    {
                        this$1 = Hal2Spek._cls25.this;
                        super();
                    }
        }

    }

}
