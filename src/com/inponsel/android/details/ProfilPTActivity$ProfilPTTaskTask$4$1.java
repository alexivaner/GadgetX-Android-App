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
    implements android.content.TaskTask._cls4._cls1
{

    final is._cls1 this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        ss._mth3(_fld1).startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("https://twitter.com/")).append(ss._mth3(_fld1).tw_array[i].replace("@", "")).toString())));
    }

    is._cls1()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/details/ProfilPTActivity$ProfilPTTaskTask$4

/* anonymous class */
    class ProfilPTActivity.ProfilPTTaskTask._cls4
        implements android.view.View.OnClickListener
    {

        final ProfilPTActivity.ProfilPTTaskTask this$1;

        public void onClick(View view)
        {
            if (ProfilPTActivity.ProfilPTTaskTask.access$3(ProfilPTActivity.ProfilPTTaskTask.this).tw_array.length > 1)
            {
                view = new android.app.AlertDialog.Builder(ProfilPTActivity.ProfilPTTaskTask.access$3(ProfilPTActivity.ProfilPTTaskTask.this));
                view.setSingleChoiceItems(ProfilPTActivity.ProfilPTTaskTask.access$3(ProfilPTActivity.ProfilPTTaskTask.this).tw_array, -1, new ProfilPTActivity.ProfilPTTaskTask._cls4._cls1());
                view.show();
                return;
            } else
            {
                ProfilPTActivity.ProfilPTTaskTask.access$3(ProfilPTActivity.ProfilPTTaskTask.this).startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("https://twitter.com/")).append(ProfilPTActivity.ProfilPTTaskTask.access$3(ProfilPTActivity.ProfilPTTaskTask.this).twitter_pt).toString())));
                return;
            }
        }


            
            {
                this$1 = ProfilPTActivity.ProfilPTTaskTask.this;
                super();
            }
    }

}
