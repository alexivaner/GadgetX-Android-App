// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.graphics.Color;
import android.widget.RelativeLayout;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.utils.Log;
import com.loopj.android.http.AsyncHttpResponseHandler;
import java.util.ArrayList;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            HomeNewMainActivity

class  extends AsyncHttpResponseHandler
{

    final HomeNewMainActivity this$0;

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
        abyte0 = new JSONObject(aheader);
        aheader = abyte0.getJSONArray("InPonsel");
        background_interaksi = abyte0.getString("background");
        i = 0;
_L3:
        int j = aheader.length();
        if (i < j) goto _L2; else goto _L1
_L1:
        Log.e("arrayListInteraksi", String.valueOf(arrayListInteraksi.size()));
        customInteraksiPagerAdapter.notifyDataSetChanged();
        rl_slideshow_interaksi.setBackgroundColor(Color.parseColor(background_interaksi));
        return;
_L2:
        abyte0 = aheader.getJSONObject(i);
        ListModel listmodel = new ListModel();
        listmodel.setId_komentar(abyte0.getString("id_komentar"));
        listmodel.setId_hp(abyte0.getString("id_hp"));
        listmodel.setCodename(abyte0.getString("codename"));
        listmodel.setNamalengkap(abyte0.getString("namalengkap"));
        listmodel.setMerk(abyte0.getString("merk"));
        listmodel.setModel(abyte0.getString("model"));
        listmodel.setNama_komentar(abyte0.getString("nama_komentar"));
        listmodel.setKomentarhp(abyte0.getString("komentarhp"));
        listmodel.setTanggal_komentar(abyte0.getString("tanggal_komentar"));
        listmodel.setAvatar(abyte0.getString("usr_pict_komen"));
        arrayListInteraksi.add(listmodel);
        i++;
          goto _L3
        aheader;
        aheader.printStackTrace();
          goto _L1
    }

    tomInteraksiPagerAdapter()
    {
        this$0 = HomeNewMainActivity.this;
        super();
    }
}
