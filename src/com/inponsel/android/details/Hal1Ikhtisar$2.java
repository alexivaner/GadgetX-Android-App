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
//            Hal1Ikhtisar

class this._cls0
    implements android.view.tener
{

    final Hal1Ikhtisar this$0;

    public void onClick(View view)
    {
        if (userFunction.isUserLoggedIn(getActivity()))
        {
            if (db.checkIfExist(id_hp))
            {
                view = new android.app.lder(getActivity());
                view.setMessage("Hapus perangkat ini dari favorit?");
                view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                    final Hal1Ikhtisar._cls2 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface.dismiss();
                        stat = "0";
                        (new Hal1Ikhtisar.FavoritTask(this$0)).execute(new Void[0]);
                    }

            
            {
                this$1 = Hal1Ikhtisar._cls2.this;
                super();
            }
                });
                view.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                    final Hal1Ikhtisar._cls2 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface.dismiss();
                    }

            
            {
                this$1 = Hal1Ikhtisar._cls2.this;
                super();
            }
                });
                view.show();
                return;
            } else
            {
                view = new android.app.lder(getActivity());
                view.setMessage("Favoritkan perangkat ini?");
                view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                    final Hal1Ikhtisar._cls2 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        stat = "1";
                        (new Hal1Ikhtisar.FavoritTask(this$0)).execute(new Void[0]);
                    }

            
            {
                this$1 = Hal1Ikhtisar._cls2.this;
                super();
            }
                });
                view.setNeutralButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                    final Hal1Ikhtisar._cls2 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface.dismiss();
                    }

            
            {
                this$1 = Hal1Ikhtisar._cls2.this;
                super();
            }
                });
                view.show();
                return;
            }
        } else
        {
            view = new android.app.lder(getActivity());
            view.setMessage("Untuk menambahkan ke favorit, diharuskan login.");
            view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                final Hal1Ikhtisar._cls2 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$1 = Hal1Ikhtisar._cls2.this;
                super();
            }
            });
            view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                final Hal1Ikhtisar._cls2 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                    startActivityForResult(dialoginterface, 0);
                    getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$1 = Hal1Ikhtisar._cls2.this;
                super();
            }
            });
            view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                final Hal1Ikhtisar._cls2 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                    dialoginterface.putExtra("activity", "main");
                    startActivityForResult(dialoginterface, 0);
                    getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$1 = Hal1Ikhtisar._cls2.this;
                super();
            }
            });
            view.show();
            return;
        }
    }


    _cls7.this._cls1()
    {
        this$0 = Hal1Ikhtisar.this;
        super();
    }
}
