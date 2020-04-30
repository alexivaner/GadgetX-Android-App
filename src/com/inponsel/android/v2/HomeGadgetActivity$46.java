// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import com.inponsel.android.adapter.CustomPagerAdapter;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.utils.Log;
import com.loopj.android.http.AsyncHttpResponseHandler;
import java.util.ArrayList;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            HomeGadgetActivity

class r extends AsyncHttpResponseHandler
{

    final HomeGadgetActivity this$0;

    public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
    {
    }

    public void onRetry(int i)
    {
    }

    public void onStart()
    {
    }

    public void onSuccess(int i, Header aheader[], byte abyte0[])
    {
        aheader = new String(abyte0);
        Log.e("responseHeadNews", aheader);
        aheader = (new JSONObject(aheader)).getJSONArray("InPonsel");
        i = 0;
_L3:
        int j = aheader.length();
        if (i < j) goto _L2; else goto _L1
_L1:
        Log.e("array2ListAds", String.valueOf(array2ListAds.size()));
        custom2PagerAdapter.notifyDataSetChanged();
        return;
_L2:
        abyte0 = aheader.getJSONObject(i);
        ListModel listmodel = new ListModel();
        listmodel.setId_ads(abyte0.getString("id_ads"));
        listmodel.setAds_title(abyte0.getString("ads_title"));
        listmodel.setAds_campaign(abyte0.getString("ads_campaign"));
        listmodel.setAds_cover(abyte0.getString("ads_image"));
        listmodel.setAds_icon(abyte0.getString("logo_pub"));
        listmodel.setAds_type(abyte0.getString("ads_type"));
        listmodel.setAds_link(abyte0.getString("ads_link"));
        listmodel.setAds_method(abyte0.getString("ads_method"));
        listmodel.setAds_title_color(abyte0.getString("ads_title_color"));
        listmodel.setAds_campaign_color(abyte0.getString("ads_campaign_color"));
        listmodel.setAds_back_color(abyte0.getString("ads_back_color"));
        listmodel.setAds_btn_text_color(abyte0.getString("ads_btn_text_color"));
        listmodel.setAds_btn_text_action(abyte0.getString("ads_btn_text_action"));
        array2ListAds.add(listmodel);
        i++;
          goto _L3
        aheader;
        aheader.printStackTrace();
          goto _L1
    }

    r()
    {
        this$0 = HomeGadgetActivity.this;
        super();
    }
}
