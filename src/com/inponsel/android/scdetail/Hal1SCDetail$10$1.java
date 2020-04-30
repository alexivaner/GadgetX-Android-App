// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.scdetail;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

// Referenced classes of package com.inponsel.android.scdetail:
//            Hal1SCDetail

class this._cls1
    implements android.content.ClickListener
{

    final ray this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("https://twitter.com/")).append(tw_array[i].replace("@", "")).toString())));
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/scdetail/Hal1SCDetail$10

/* anonymous class */
    class Hal1SCDetail._cls10
        implements android.view.View.OnClickListener
    {

        final Hal1SCDetail this$0;

        public void onClick(View view)
        {
            if (tw_array.length > 1)
            {
                view = new android.app.AlertDialog.Builder(getActivity());
                view.setSingleChoiceItems(tw_array, -1, new Hal1SCDetail._cls10._cls1());
                view.show();
                return;
            } else
            {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("https://twitter.com/")).append(str_sc_twitter).toString())));
                return;
            }
        }


            
            {
                this$0 = Hal1SCDetail.this;
                super();
            }
    }

}
