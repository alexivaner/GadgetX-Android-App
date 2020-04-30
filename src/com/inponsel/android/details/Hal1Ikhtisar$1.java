// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.DialogInterface;
import android.view.View;
import android.widget.CheckBox;

// Referenced classes of package com.inponsel.android.details:
//            Hal1Ikhtisar

class this._cls0
    implements android.view.tener
{

    final Hal1Ikhtisar this$0;

    public void onClick(View view)
    {
        (new StringBuilder("Aktifkan notifikasi komentar untuk ")).append(namalengkap).append(" ?").toString();
        android.app.lder lder;
        if (chkNotifKomenHp.isChecked())
        {
            statusKomen = "1";
            view = (new StringBuilder("Aktifkan notifikasi komentar untuk ")).append(namalengkap).append(" ?").toString();
        } else
        {
            statusKomen = "0";
            view = (new StringBuilder("Non aktifkan notifikasi komentar untuk ")).append(namalengkap).append(" ?").toString();
        }
        lder = new android.app.lder(wrapper);
        lder.setTitle("Perhatian");
        lder.setMessage(view);
        lder.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

            final Hal1Ikhtisar._cls1 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
                TurnOnOffNotifTask();
            }

            
            {
                this$1 = Hal1Ikhtisar._cls1.this;
                super();
            }
        });
        lder.setNegativeButton("Batal", new android.content.DialogInterface.OnClickListener() {

            final Hal1Ikhtisar._cls1 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                if (chkNotifKomenHp.isChecked())
                {
                    chkNotifKomenHp.setChecked(false);
                } else
                {
                    chkNotifKomenHp.setChecked(true);
                }
                dialoginterface.dismiss();
            }

            
            {
                this$1 = Hal1Ikhtisar._cls1.this;
                super();
            }
        });
        lder.show();
    }


    _cls2.this._cls1()
    {
        this$0 = Hal1Ikhtisar.this;
        super();
    }
}
