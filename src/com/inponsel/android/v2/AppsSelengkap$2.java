// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import com.inponsel.android.adapter.ListAppsHorizontalAdapter;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.utils.Log;
import com.loopj.android.http.AsyncHttpResponseHandler;
import java.util.ArrayList;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            AppsSelengkap

class Handler extends AsyncHttpResponseHandler
{

    final AppsSelengkap this$0;

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
        Log.e("respJson", aheader);
        aheader = (new JSONObject(aheader)).getJSONArray("InPonsel");
        i = 0;
_L5:
        int j = aheader.length();
        if (i < j) goto _L2; else goto _L1
_L1:
        listAppsCateforyAdapter.notifyDataSetChanged();
        return;
_L2:
        Log.e("iLength", String.valueOf(i));
        abyte0 = aheader.getJSONObject(i);
        if (abyte0.getString("app_rate") == null)
        {
            break; /* Loop/switch isn't completed */
        }
        try
        {
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
            arrayListCategoryApps.add(listmodel);
            break; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Header aheader[]) { }
        if (true) goto _L1; else goto _L3
_L3:
        i++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    izontalAdapter()
    {
        this$0 = AppsSelengkap.this;
        super();
    }
}
