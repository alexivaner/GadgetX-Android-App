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
//            ListKategoriApps3Adapter, PonselBaseApp, ListModel, ModelObserver

class val.position extends AsyncHttpResponseHandler
{

    final elBaseApp this$1;
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
        Log.e("urlPost", val$urlPost);
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
        ponselBaseApp.setObserver().setIndexHp(getListModel(val$position).getId_apps());
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

    l.position()
    {
        this$1 = final_position1;
        val$urlPost = s;
        val$position = I.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/adapter/ListKategoriApps3Adapter$2

/* anonymous class */
    class ListKategoriApps3Adapter._cls2
        implements android.view.View.OnClickListener
    {

        final ListKategoriApps3Adapter this$0;
        private final int val$position;

        public void onClick(final View urlPost)
        {
            Log.e("postlike", getListModel(position).getKat_apps_name());
            urlPost = (new StringBuilder(String.valueOf(Util.BASE_PATH_STORE))).append("post_like_applist.php?").append("t=f7c1ffed723d0578eca7f57388c8054d4fed52a7&id_user=").append(user_id).append("&id_kat=").append(getListModel(position).getId_apps()).toString();
            (new AsyncHttpClient()).get(urlPost, position. new ListKategoriApps3Adapter._cls2._cls1());
        }


            
            {
                this$0 = final_listkategoriapps3adapter;
                position = I.this;
                super();
            }
    }

}
