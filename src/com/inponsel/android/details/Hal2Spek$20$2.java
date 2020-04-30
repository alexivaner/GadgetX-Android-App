// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.inponsel.android.utils.DatabaseHandler;
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

    // Unreferenced inner class com/inponsel/android/details/Hal2Spek$20

/* anonymous class */
    class Hal2Spek._cls20
        implements android.view.View.OnClickListener
    {

        final Hal2Spek this$0;

        public void onClick(View view)
        {
            if (userFunction.isUserLoggedIn(getActivity()))
            {
                if (db.checkIfExist(id_hp))
                {
                    view = new android.app.AlertDialog.Builder(getActivity());
                    view.setMessage("Hapus perangkat ini dari favorit?");
                    view.setPositiveButton("Ya", new Hal2Spek._cls20._cls1());
                    view.setNegativeButton("Tidak", new Hal2Spek._cls20._cls2());
                    view.show();
                    return;
                } else
                {
                    view = new android.app.AlertDialog.Builder(getActivity());
                    view.setMessage("Favoritkan perangkat ini?");
                    view.setPositiveButton("Ya", new Hal2Spek._cls20._cls3());
                    view.setNeutralButton("Tidak", new Hal2Spek._cls20._cls4());
                    view.show();
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(getActivity());
                view.setMessage("Untuk menambahkan ke favorit, diharuskan login.");
                view.setPositiveButton("Tutup", new Hal2Spek._cls20._cls5());
                view.setNeutralButton("Register", new Hal2Spek._cls20._cls6());
                view.setNegativeButton("Login", new Hal2Spek._cls20._cls7());
                view.show();
                return;
            }
        }


            
            {
                this$0 = Hal2Spek.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/details/Hal2Spek$20$1

/* anonymous class */
        class Hal2Spek._cls20._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal2Spek._cls20 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
                statFavHp = "0";
                (new Hal2Spek.FavoritTask(this$0)).execute(new Void[0]);
            }

                    
                    {
                        this$1 = Hal2Spek._cls20.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/details/Hal2Spek$20$3

/* anonymous class */
        class Hal2Spek._cls20._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal2Spek._cls20 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                statFavHp = "1";
                (new Hal2Spek.FavoritTask(this$0)).execute(new Void[0]);
            }

                    
                    {
                        this$1 = Hal2Spek._cls20.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/details/Hal2Spek$20$4

/* anonymous class */
        class Hal2Spek._cls20._cls4
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal2Spek._cls20 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = Hal2Spek._cls20.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/details/Hal2Spek$20$5

/* anonymous class */
        class Hal2Spek._cls20._cls5
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal2Spek._cls20 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = Hal2Spek._cls20.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/details/Hal2Spek$20$6

/* anonymous class */
        class Hal2Spek._cls20._cls6
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal2Spek._cls20 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                startActivityForResult(dialoginterface, 0);
                getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            }

                    
                    {
                        this$1 = Hal2Spek._cls20.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/details/Hal2Spek$20$7

/* anonymous class */
        class Hal2Spek._cls20._cls7
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal2Spek._cls20 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                startActivityForResult(dialoginterface, 0);
                getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            }

                    
                    {
                        this$1 = Hal2Spek._cls20.this;
                        super();
                    }
        }

    }

}
