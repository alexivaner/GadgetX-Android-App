// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.os.Handler;
import android.widget.TextView;
import com.inponsel.android.adapter.ListAppsAdapter;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.utils.Log;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.nirhart.parallaxscroll.views.ParallaxScrollView;
import fr.castorflex.android.circularprogressbar.CircularProgressBar;
import java.util.ArrayList;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            HomeAppsActivity

class this._cls1
    implements Runnable
{

    final lView.scrollTo this$1;

    public void run()
    {
        sv_root.scrollTo(0, 0);
    }

    r()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/HomeAppsActivity$15

/* anonymous class */
    class HomeAppsActivity._cls15 extends AsyncHttpResponseHandler
    {

        final HomeAppsActivity this$0;

        public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
        {
        }

        public void onRetry(int i)
        {
            progbar_appsweek.setVisibility(8);
        }

        public void onStart()
        {
            progbar_appsweek.setVisibility(0);
        }

        public void onSuccess(int i, Header aheader[], byte abyte0[])
        {
            aheader = new String(abyte0);
            progbar_appsweek.setVisibility(8);
            abyte0 = new JSONObject(aheader);
            aheader = abyte0.getJSONArray("InPonsel");
            str_trending_date = abyte0.getString("date");
            i = 0;
_L3:
            int j = aheader.length();
            if (i < j) goto _L2; else goto _L1
_L1:
            txt_trending_date.setVisibility(0);
            txt_trending_date.setText(str_trending_date);
            listAppsWeekAdapter.notifyDataSetChanged();
            (new Handler()).postDelayed(new HomeAppsActivity._cls15._cls1(), 1000L);
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
            arrayListWeekApps.add(listmodel);
            i++;
              goto _L3
            aheader;
            aheader.printStackTrace();
              goto _L1
        }


            
            {
                this$0 = HomeAppsActivity.this;
                super();
            }
    }

}
