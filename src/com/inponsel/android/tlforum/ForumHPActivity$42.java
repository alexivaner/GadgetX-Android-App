// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.tlforum;

import android.content.Intent;
import android.view.View;
import com.inponsel.android.utils.Util;
import com.inponsel.android.v2.ImagePagerActivity;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.tlforum:
//            ForumHPActivity

class val.tl_img_url
    implements android.view.r
{

    final ForumHPActivity this$0;
    private final String val$tl_img_url;

    public void onClick(View view)
    {
        view = new ArrayList();
        view.add((new StringBuilder(String.valueOf(Util.BASE_URL_THUMB_ORI))).append("w=").append(1000).append("&src=").append(val$tl_img_url).toString());
        view = (String[])view.toArray(new String[view.size()]);
        Intent intent = new Intent(ForumHPActivity.this, com/inponsel/android/v2/ImagePagerActivity);
        intent.putExtra("imgUrl", view);
        intent.putExtra("pos", 0);
        startActivity(intent);
    }

    ()
    {
        this$0 = final_forumhpactivity;
        val$tl_img_url = String.this;
        super();
    }
}
