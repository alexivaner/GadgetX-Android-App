// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.rssfeeddetail;

import android.content.Intent;
import android.view.View;
import com.inponsel.android.utils.Log;
import com.inponsel.android.v2.ImagePagerActivity;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.rssfeeddetail:
//            Hal1RSSDetail

class val.img_media_to
    implements android.view.ner
{

    final Hal1RSSDetail this$0;
    private final String val$img_media;
    private final String val$img_media_to;

    public void onClick(View view)
    {
        Log.e("ll_img_komen_rep", val$img_media);
        view = new ArrayList();
        Object obj = val$img_media_to;
        view.add(((String) (obj)).substring(((String) (obj)).lastIndexOf("=") + 1).toString().trim());
        view = (String[])view.toArray(new String[view.size()]);
        obj = new Intent(getActivity(), com/inponsel/android/v2/ImagePagerActivity);
        ((Intent) (obj)).putExtra("imgUrl", view);
        ((Intent) (obj)).putExtra("pos", 0);
        startActivity(((Intent) (obj)));
    }

    _cls9()
    {
        this$0 = final_hal1rssdetail;
        val$img_media = s;
        val$img_media_to = String.this;
        super();
    }
}
