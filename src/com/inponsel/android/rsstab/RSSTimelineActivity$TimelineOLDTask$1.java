// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.rsstab;

import android.content.Intent;
import android.view.View;
import com.inponsel.android.v2.ImagePagerActivity;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.rsstab:
//            RSSTimelineActivity

class val.rss_img
    implements android.view.elineOLDTask._cls1
{

    final this._cls1 this$1;
    private final String val$rss_img;

    public void onClick(View view)
    {
        view = new ArrayList();
        view.add(val$rss_img);
        view = (String[])view.toArray(new String[view.size()]);
        Intent intent = new Intent(cess._mth2(this._cls1.this), com/inponsel/android/v2/ImagePagerActivity);
        intent.putExtra("imgUrl", view);
        intent.putExtra("pos", 0);
        cess._mth2(this._cls1.this).startActivity(intent);
    }

    ()
    {
        this$1 = final_;
        val$rss_img = String.this;
        super();
    }
}
