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
//            Hal1Ikhtisar

class this._cls1
    implements android.content.nClickListener
{

    final dePendingTransition this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
        dialoginterface.putExtra("activity", "main");
        startActivityForResult(dialoginterface, 0);
        getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/details/Hal1Ikhtisar$3

/* anonymous class */
    class Hal1Ikhtisar._cls3
        implements android.view.View.OnClickListener
    {

        final Hal1Ikhtisar this$0;

        public void onClick(View view)
        {
            if (userFunction.isUserLoggedIn(getActivity()))
            {
                if (statSubNews.equals("1"))
                {
                    view = new android.app.AlertDialog.Builder(getActivity());
                    view.setMessage("Hentikan langganan berita perangkat ini?");
                    view.setPositiveButton("Ya", new Hal1Ikhtisar._cls3._cls1());
                    view.setNegativeButton("Tidak", new Hal1Ikhtisar._cls3._cls2());
                    view.show();
                    return;
                } else
                {
                    view = new android.app.AlertDialog.Builder(getActivity());
                    view.setMessage("Langganan berita perangkat ini?");
                    view.setPositiveButton("Ya", new Hal1Ikhtisar._cls3._cls3());
                    view.setNeutralButton("Tidak", new Hal1Ikhtisar._cls3._cls4());
                    view.show();
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(getActivity());
                view.setMessage("Untuk berlangganan berita, diharuskan login.");
                view.setPositiveButton("Tutup", new Hal1Ikhtisar._cls3._cls5());
                view.setNeutralButton("Register", new Hal1Ikhtisar._cls3._cls6());
                view.setNegativeButton("Login", new Hal1Ikhtisar._cls3._cls7());
                view.show();
                return;
            }
        }


            
            {
                this$0 = Hal1Ikhtisar.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/details/Hal1Ikhtisar$3$1

/* anonymous class */
        class Hal1Ikhtisar._cls3._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal1Ikhtisar._cls3 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
                statSubNews = "0";
                (new Hal1Ikhtisar.SubsNewsTask(this$0)).execute(new Void[0]);
            }

                    
                    {
                        this$1 = Hal1Ikhtisar._cls3.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/details/Hal1Ikhtisar$3$2

/* anonymous class */
        class Hal1Ikhtisar._cls3._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal1Ikhtisar._cls3 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = Hal1Ikhtisar._cls3.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/details/Hal1Ikhtisar$3$3

/* anonymous class */
        class Hal1Ikhtisar._cls3._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal1Ikhtisar._cls3 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                statSubNews = "1";
                (new Hal1Ikhtisar.SubsNewsTask(this$0)).execute(new Void[0]);
            }

                    
                    {
                        this$1 = Hal1Ikhtisar._cls3.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/details/Hal1Ikhtisar$3$4

/* anonymous class */
        class Hal1Ikhtisar._cls3._cls4
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal1Ikhtisar._cls3 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = Hal1Ikhtisar._cls3.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/details/Hal1Ikhtisar$3$5

/* anonymous class */
        class Hal1Ikhtisar._cls3._cls5
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal1Ikhtisar._cls3 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = Hal1Ikhtisar._cls3.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/details/Hal1Ikhtisar$3$6

/* anonymous class */
        class Hal1Ikhtisar._cls3._cls6
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal1Ikhtisar._cls3 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                startActivityForResult(dialoginterface, 0);
                getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            }

                    
                    {
                        this$1 = Hal1Ikhtisar._cls3.this;
                        super();
                    }
        }

    }

}
