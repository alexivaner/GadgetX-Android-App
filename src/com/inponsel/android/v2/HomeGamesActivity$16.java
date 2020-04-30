// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import com.inponsel.android.adapter.ListAppsAdapter;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Utility;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.nirhart.parallaxscroll.views.ParallaxScrollView;
import fr.castorflex.android.circularprogressbar.CircularProgressBar;
import java.util.ArrayList;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            HomeGamesActivity

class er extends AsyncHttpResponseHandler
{

    final HomeGamesActivity this$0;

    public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
    {
        progbar_appstrending.setVisibility(8);
    }

    public void onRetry(int i)
    {
    }

    public void onStart()
    {
        progbar_appstrending.setVisibility(0);
    }

    public void onSuccess(int i, Header aheader[], byte abyte0[])
    {
        aheader = new String(abyte0);
        progbar_appstrending.setVisibility(8);
        aheader = (new JSONObject(aheader)).getJSONArray("InPonsel");
        i = 0;
_L3:
        if (i < aheader.length()) goto _L2; else goto _L1
_L1:
        aheader = HomeGamesActivity.this;
        aheader.scroll_count = ((HomeGamesActivity) (aheader)).scroll_count + 1;
_L4:
        listAppsTrendingAdapter.notifyDataSetChanged();
        sv_root.scrollTo(0, 0);
        if (Utility.screen_inch(HomeGamesActivity.this) >= 6D)
        {
            aheader = HomeGamesActivity.this;
            aheader.scroll_count = ((HomeGamesActivity) (aheader)).scroll_count + 1;
            HomeGamesActivity.access$0(HomeGamesActivity.this);
        }
        return;
_L2:
        Log.e("iLength", String.valueOf(i));
        abyte0 = aheader.getJSONObject(i);
        ListModel listmodel = new ListModel();
        listmodel.setApppackage(abyte0.getString("app_package"));
        listmodel.setAppname(abyte0.getString("app_name"));
        listmodel.setAppcover(abyte0.getString("icon_image"));
        listmodel.setCategory(abyte0.getString("kategori"));
        listmodel.setAvgrate(abyte0.getString("app_rate"));
        listmodel.setBanner_image(abyte0.getString("banner_image"));
        listmodel.setAppsize(abyte0.getString("app_size"));
        listmodel.setDownloadcount(abyte0.getString("app_download"));
        listmodel.setAppurl(abyte0.getString("app_url"));
        arrayListTrendingApps.add(listmodel);
        i++;
          goto _L3
        aheader;
          goto _L4
    }

    llView()
    {
        this$0 = HomeGamesActivity.this;
        super();
    }
}
