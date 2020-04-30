// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.globalforum;

import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;

// Referenced classes of package com.inponsel.android.globalforum:
//            ForumGlobalActivity

class this._cls1
    implements android.content.stener
{

    final rutkan_benchmark this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        i;
        JVM INSTR tableswitch 0 1: default 24
    //                   0 43
    //                   1 73;
           goto _L1 _L2 _L3
_L1:
        ForumGlobalActivity.access$4(_fld0, "now");
        dialoginterface.dismiss();
        return;
_L2:
        btn_sort_benchmark.setText("Berdasarkan skor tertinggi");
        str_urutkan_benchmark = "1";
        continue; /* Loop/switch isn't completed */
_L3:
        btn_sort_benchmark.setText("Berdasarkan skor terendah");
        str_urutkan_benchmark = "2";
        if (true) goto _L1; else goto _L4
_L4:
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/globalforum/ForumGlobalActivity$22

/* anonymous class */
    class ForumGlobalActivity._cls22
        implements android.view.View.OnClickListener
    {

        final ForumGlobalActivity this$0;

        public void onClick(View view)
        {
            view = new android.app.AlertDialog.Builder(ForumGlobalActivity.this);
            view.setTitle("Urutkan benchmark :");
            view.setItems(benchmark_urutkan, new ForumGlobalActivity._cls22._cls1());
            view.show();
        }


            
            {
                this$0 = ForumGlobalActivity.this;
                super();
            }
    }

}
