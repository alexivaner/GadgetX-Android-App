// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.widget.ScrollView;
import com.inponsel.android.adapter.ListKategoriAppsAdapter;
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
_L3:
        int j = aheader.length();
        if (i < j) goto _L2; else goto _L1
_L1:
        listKatAppsAdapter.notifyDataSetChanged();
        sv_root.scrollTo(0, 0);
        return;
_L2:
        abyte0 = aheader.getJSONObject(i);
        ListModel listmodel = new ListModel();
        Log.e("kategori_random", abyte0.getString("background_img"));
        listmodel.setId_apps(abyte0.getString("id"));
        listmodel.setKat_apps_name(abyte0.getString("kategori"));
        listmodel.setKat_apps_desc(abyte0.getString("deskripsi"));
        listmodel.setKat_img_height(abyte0.getString("height"));
        listmodel.setKat_apps_background(abyte0.getString("background"));
        listmodel.setKat_apps_background_img(abyte0.getString("background_img"));
        listmodel.setKat_like_status(abyte0.getString("mystat"));
        listmodel.setKat_fav_status(abyte0.getString("myfav"));
        listmodel.setKat_type(abyte0.getString("type"));
        listmodel.setKat_apps_tag(abyte0.getString("tag"));
        listmodel.setKat_apps_date("mod_date");
        listmodel.setKat_img_width(abyte0.getString("width"));
        listmodel.setKat_img_height(abyte0.getString("height"));
        listmodel.setRatio_h(abyte0.getString("ratioH"));
        listmodel.setRatio_w(abyte0.getString("ratioW"));
        arrayListKatApps.add(listmodel);
        i++;
          goto _L3
        aheader;
          goto _L1
    }

    iAppsAdapter()
    {
        this$0 = AppsSelengkap.this;
        super();
    }
}
