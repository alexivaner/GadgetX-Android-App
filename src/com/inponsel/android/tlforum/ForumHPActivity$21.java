// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.tlforum;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.dobmob.dobsliding.DobSlidingMenu;
import com.inponsel.android.utils.ExpandedGridView;

// Referenced classes of package com.inponsel.android.tlforum:
//            ForumHPActivity

class this._cls0
    implements android.view.r
{

    final ForumHPActivity this$0;

    public void onClick(View view)
    {
        img_empty.setVisibility(8);
        pop_txt_empty.setVisibility(8);
        txt_sublabel_actionbar.setText("Hasil Foto Kamera");
        ForumHPActivity.access$2(ForumHPActivity.this).collapse();
        tag_timeline = "hasilkamera";
        ll_forumlist.setVisibility(8);
        grid_benchmark.setVisibility(8);
        ll_forumlistbenchmark.setVisibility(8);
        ForumHPActivity.access$4(ForumHPActivity.this, "now");
    }

    ()
    {
        this$0 = ForumHPActivity.this;
        super();
    }
}
