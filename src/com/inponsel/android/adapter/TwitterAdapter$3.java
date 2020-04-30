// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.inponsel.android.v2.ImagePagerActivity;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.adapter:
//            TwitterAdapter, TrafficModel

class val.lms
    implements android.view.ner
{

    final TwitterAdapter this$0;
    private final TrafficModel val$lms;

    public void onClick(View view)
    {
        view = new ArrayList();
        view.add(val$lms.getMedia_url().trim());
        view = (String[])view.toArray(new String[view.size()]);
        Intent intent = new Intent(activity, com/inponsel/android/v2/ImagePagerActivity);
        intent.putExtra("imgUrl", view);
        intent.putExtra("pos", 0);
        activity.startActivity(intent);
    }

    ()
    {
        this$0 = final_twitteradapter;
        val$lms = TrafficModel.this;
        super();
    }
}
