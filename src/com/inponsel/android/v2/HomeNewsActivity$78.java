// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.os.AsyncTask;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.nirhart.parallaxscroll.views.ParallaxScrollView;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.v2:
//            HomeNewsActivity

class this._cls0
    implements Runnable
{

    final HomeNewsActivity this$0;

    public void run()
    {
        sv_root.scrollBy(0, 100);
        HomeNewsActivity.access$0(HomeNewsActivity.this).clear();
        Log.e("mArrayListRSSData", String.valueOf(HomeNewsActivity.access$0(HomeNewsActivity.this).size()));
        AsycMoreTask asycmoretask = new AsycMoreTask(HomeNewsActivity.this);
        Log.e("page_count", (new StringBuilder(String.valueOf(String.valueOf(page_count)))).append("-").append(String.valueOf(count_task)).toString());
        if (page_count - count_task == 0)
        {
            HomeNewsActivity homenewsactivity = HomeNewsActivity.this;
            homenewsactivity.page_count = homenewsactivity.page_count + 1;
            urlRSSMore = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rss_all_category").append(Utility.BASE_FORMAT).append("?").append("lmt=").append(limit).append("&t=").append(t).append("&idusr=").append(user_id).append("&tag=").append(tag_code).append("&page=").append(page_count).toString();
            Log.e("urlRSSMore", urlRSSMore);
            if (android.os.T >= 11)
            {
                asycmoretask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
            } else
            {
                asycmoretask.execute(new String[0]);
            }
        }
        Log.e("page_task", (new StringBuilder(String.valueOf(String.valueOf(page_count)))).append("=").append(String.valueOf(count_task)).toString());
        Log.e("MyScrollView", "MyScrollView: Bottom has been reached");
    }

    AsycMoreTask()
    {
        this$0 = HomeNewsActivity.this;
        super();
    }
}
