// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

// Referenced classes of package com.inponsel.android.details:
//            ProfilPTActivity

class this._cls2
    implements android.content.TaskTask._cls2._cls1
{

    final is._cls1 this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent("android.intent.action.DIAL", Uri.parse((new StringBuilder("tel: ")).append(ss._mth3(_fld1).no_contven_center_array[i].replaceAll("[^0-9]", "")).toString()));
        ss._mth3(_fld1).startActivity(dialoginterface);
    }

    is._cls1()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/details/ProfilPTActivity$ProfilPTTaskTask$2

/* anonymous class */
    class ProfilPTActivity.ProfilPTTaskTask._cls2
        implements android.view.View.OnClickListener
    {

        final ProfilPTActivity.ProfilPTTaskTask this$1;

        public void onClick(View view)
        {
label0:
            {
                if (!ProfilPTActivity.ProfilPTTaskTask.access$3(ProfilPTActivity.ProfilPTTaskTask.this).c_center_pt.equals("Tidak ada informasi"))
                {
                    if (ProfilPTActivity.ProfilPTTaskTask.access$3(ProfilPTActivity.ProfilPTTaskTask.this).no_contven_center_array.length <= 1)
                    {
                        break label0;
                    }
                    view = new android.app.AlertDialog.Builder(ProfilPTActivity.ProfilPTTaskTask.access$3(ProfilPTActivity.ProfilPTTaskTask.this));
                    view.setTitle("Nomor Telepon :");
                    view.setSingleChoiceItems(ProfilPTActivity.ProfilPTTaskTask.access$3(ProfilPTActivity.ProfilPTTaskTask.this).no_contven_center_array, -1, new ProfilPTActivity.ProfilPTTaskTask._cls2._cls1());
                    view.show();
                }
                return;
            }
            view = new Intent("android.intent.action.DIAL", Uri.parse((new StringBuilder("tel: ")).append(ProfilPTActivity.ProfilPTTaskTask.access$3(ProfilPTActivity.ProfilPTTaskTask.this).c_center_pt.replaceAll("[^0-9]", "")).toString()));
            ProfilPTActivity.ProfilPTTaskTask.access$3(ProfilPTActivity.ProfilPTTaskTask.this).startActivity(view);
        }


            
            {
                this$1 = ProfilPTActivity.ProfilPTTaskTask.this;
                super();
            }
    }

}
