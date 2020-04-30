// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.DialogInterface;
import android.view.View;
import android.widget.CheckBox;

// Referenced classes of package com.inponsel.android.details:
//            Hal1Ikhtisar

class this._cls1
    implements android.content.nClickListener
{

    final otifKomenHp this$1;

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

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/details/Hal1Ikhtisar$1

/* anonymous class */
    class Hal1Ikhtisar._cls1
        implements android.view.View.OnClickListener
    {

        final Hal1Ikhtisar this$0;

        public void onClick(View view)
        {
            (new StringBuilder("Aktifkan notifikasi komentar untuk ")).append(namalengkap).append(" ?").toString();
            android.app.AlertDialog.Builder builder;
            if (chkNotifKomenHp.isChecked())
            {
                statusKomen = "1";
                view = (new StringBuilder("Aktifkan notifikasi komentar untuk ")).append(namalengkap).append(" ?").toString();
            } else
            {
                statusKomen = "0";
                view = (new StringBuilder("Non aktifkan notifikasi komentar untuk ")).append(namalengkap).append(" ?").toString();
            }
            builder = new android.app.AlertDialog.Builder(wrapper);
            builder.setTitle("Perhatian");
            builder.setMessage(view);
            builder.setPositiveButton("Ya", new Hal1Ikhtisar._cls1._cls1());
            builder.setNegativeButton("Batal", new Hal1Ikhtisar._cls1._cls2());
            builder.show();
        }


            
            {
                this$0 = Hal1Ikhtisar.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/details/Hal1Ikhtisar$1$1

/* anonymous class */
        class Hal1Ikhtisar._cls1._cls1
            implements android.content.DialogInterface.OnClickListener
        {

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
        }

    }

}
