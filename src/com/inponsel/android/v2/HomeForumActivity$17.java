// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.view.View;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.v2:
//            HomeForumActivity, ImagePagerActivity

class val.tl_img_url
    implements android.view.ctivity._cls17
{

    final HomeForumActivity this$0;
    private final String val$tl_img_url;

    public void onClick(View view)
    {
        view = new ArrayList();
        view.add(val$tl_img_url);
        view = (String[])view.toArray(new String[view.size()]);
        Intent intent = new Intent(HomeForumActivity.this, com/inponsel/android/v2/ImagePagerActivity);
        intent.putExtra("imgUrl", view);
        intent.putExtra("pos", 0);
        startActivity(intent);
    }

    ()
    {
        this$0 = final_homeforumactivity;
        val$tl_img_url = String.this;
        super();
    }
}
