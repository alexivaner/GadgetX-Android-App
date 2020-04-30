// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.adapter;

import android.view.View;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.adapter:
//            ListKategoriAppsAdsAdapter, ListModel, PonselBaseApp, ModelObserver

class val.position
    implements android.view.ppsAdsAdapter._cls2
{

    final ListKategoriAppsAdsAdapter this$0;
    private final int val$position;

    public void onClick(final View urlPost)
    {
        Log.e("postlike", getListModel(val$position).getKat_apps_name());
        urlPost = (new StringBuilder(String.valueOf(Util.BASE_PATH_STORE))).append("post_like_applist.php?").append("t=f7c1ffed723d0578eca7f57388c8054d4fed52a7&id_user=").append(user_id).append("&id_kat=").append(getListModel(val$position).getId_apps()).toString();
        (new AsyncHttpClient()).get(urlPost, new AsyncHttpResponseHandler() {

            final ListKategoriAppsAdsAdapter._cls2 this$1;
            private final int val$position;
            private final String val$urlPost;

            public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
            {
            }

            public void onRetry(int i)
            {
            }

            public void onStart()
            {
                Log.e("urlPost", urlPost);
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
                ponselBaseApp.setObserver().setIndexHp(getListModel(position).getId_apps());
                ponselBaseApp.setObserver().setUpdateType("appsstore");
                ponselBaseApp.setObserver().setStatus_like_ponsel("1");
                return;
_L2:
                abyte0 = aheader.getJSONObject(i);
                ponselBaseApp.getObserver().setTot_LikePon(abyte0.getString("total_like"));
                i++;
                  goto _L3
                aheader;
                  goto _L1
            }

            
            {
                this$1 = ListKategoriAppsAdsAdapter._cls2.this;
                urlPost = s;
                position = i;
                super();
            }
        });
    }


    _cls1.val.position()
    {
        this$0 = final_listkategoriappsadsadapter;
        val$position = I.this;
        super();
    }
}
