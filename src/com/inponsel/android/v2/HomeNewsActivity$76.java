// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import com.inponsel.android.adapter.CustomNewsPagerAdapter;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.utils.Log;
import com.loopj.android.http.AsyncHttpResponseHandler;
import java.util.ArrayList;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            HomeNewsActivity

class ler extends AsyncHttpResponseHandler
{

    final HomeNewsActivity this$0;

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
        Log.e("jsonArray", (new StringBuilder("jsonArray")).append(String.valueOf(aheader.length())).toString());
        i = 0;
_L3:
        int j = aheader.length();
        if (i < j) goto _L2; else goto _L1
_L1:
        Log.e("arrayListNews", (new StringBuilder("arrayListNews")).append(String.valueOf(arrayListNews.size())).toString());
        customNewsPagerAdapter.notifyDataSetChanged();
        return;
_L2:
        abyte0 = aheader.getJSONObject(i);
        ListModel listmodel = new ListModel();
        listmodel.setId_rss(Integer.parseInt(abyte0.getString("id")));
        listmodel.setName(abyte0.getString("rss_title"));
        listmodel.setSumber(abyte0.getString("rss_portal"));
        listmodel.setImageUrl(abyte0.getString("rss_img"));
        arrayListNews.add(listmodel);
        i++;
          goto _L3
        aheader;
        aheader.printStackTrace();
          goto _L1
    }

    Adapter()
    {
        this$0 = HomeNewsActivity.this;
        super();
    }
}
