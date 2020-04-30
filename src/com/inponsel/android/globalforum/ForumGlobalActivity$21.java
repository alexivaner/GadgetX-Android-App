// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.globalforum;

import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.dobmob.dobsliding.DobSlidingMenu;

// Referenced classes of package com.inponsel.android.globalforum:
//            ForumGlobalActivity

class this._cls0
    implements android.view.umGlobalActivity._cls21
{

    final ForumGlobalActivity this$0;

    public void onClick(View view)
    {
        img_empty.setVisibility(8);
        pop_txt_empty.setVisibility(8);
        txt_sublabel_actionbar.setText("Hasil Foto Kamera");
        ForumGlobalActivity.access$2(ForumGlobalActivity.this).collapse();
        tag_timeline = "hasilkamera";
        ll_forumlist.setVisibility(8);
        grid_benchmark.setVisibility(8);
        ll_forumlistbenchmark.setVisibility(8);
        ForumGlobalActivity.access$3(ForumGlobalActivity.this, "now");
    }

    ()
    {
        this$0 = ForumGlobalActivity.this;
        super();
    }
}
