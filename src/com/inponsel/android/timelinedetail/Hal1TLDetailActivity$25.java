// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.timelinedetail;

import android.content.Intent;
import android.view.View;
import com.inponsel.android.utils.Log;
import com.inponsel.android.v2.ImagePagerActivity;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.timelinedetail:
//            Hal1TLDetailActivity

class val.img_media_to
    implements android.view.al1TLDetailActivity._cls25
{

    final Hal1TLDetailActivity this$0;
    private final String val$img_media;
    private final String val$img_media_to;

    public void onClick(View view)
    {
        Log.e("ll_img_komen_rep", val$img_media);
        view = new ArrayList();
        Object obj = val$img_media_to;
        view.add(((String) (obj)).substring(((String) (obj)).lastIndexOf("=") + 1).toString().trim());
        view = (String[])view.toArray(new String[view.size()]);
        obj = new Intent(Hal1TLDetailActivity.this, com/inponsel/android/v2/ImagePagerActivity);
        ((Intent) (obj)).putExtra("imgUrl", view);
        ((Intent) (obj)).putExtra("pos", 0);
        startActivity(((Intent) (obj)));
    }

    A()
    {
        this$0 = final_hal1tldetailactivity;
        val$img_media = s;
        val$img_media_to = String.this;
        super();
    }
}
