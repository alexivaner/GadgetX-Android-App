// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.globalforum;

import android.content.Intent;
import android.view.View;
import com.inponsel.android.v2.ImagePagerActivity;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.globalforum:
//            ForumGlobalActivity

class val.tl_img_url
    implements android.view.umGlobalActivity._cls33
{

    final ForumGlobalActivity this$0;
    private final String val$tl_img_url;

    public void onClick(View view)
    {
        view = new ArrayList();
        view.add(val$tl_img_url);
        view = (String[])view.toArray(new String[view.size()]);
        Intent intent = new Intent(ForumGlobalActivity.this, com/inponsel/android/v2/ImagePagerActivity);
        intent.putExtra("imgUrl", view);
        intent.putExtra("pos", 0);
        startActivity(intent);
    }

    ()
    {
        this$0 = final_forumglobalactivity;
        val$tl_img_url = String.this;
        super();
    }
}
