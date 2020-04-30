// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.utils.ExpandedGridView;
import com.inponsel.android.utils.Log;
import fr.castorflex.android.circularprogressbar.CircularProgressBar;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            HomeForumActivity

class val.nextprev
    implements com.android.volley.y._cls30
{

    final HomeForumActivity this$0;
    private final String val$nextprev;

    private void parseJSONBenchmark(String s)
    {
        JSONObject jsonobject = new JSONObject(s);
        s = jsonobject.getJSONArray("InPonsel");
        bottom_id = jsonobject.getString("bottom_id");
        top_id = jsonobject.getString("top_id");
        if (jsonobject.getString("success").equals("0"))
        {
            break MISSING_BLOCK_LABEL_396;
        }
        counterBench = s.length();
        int i = 0;
_L2:
        if (i >= s.length())
        {
            return;
        }
        JSONObject jsonobject1 = s.getJSONObject(i);
        ListModel listmodel = new ListModel();
        listmodel.setForum_id(jsonobject1.getString("id"));
        listmodel.setId_hp(jsonobject1.getString("id_hp"));
        listmodel.setCodename(jsonobject1.getString("codename"));
        listmodel.setMerk(jsonobject1.getString("merk"));
        listmodel.setModel(jsonobject1.getString("model"));
        listmodel.setId_user(jsonobject1.getString("id_user"));
        listmodel.setUsername(jsonobject1.getString("user_name"));
        listmodel.setKota(jsonobject1.getString("user_kota"));
        listmodel.setImg_height(jsonobject1.getString("height"));
        listmodel.setImg_width(jsonobject1.getString("width"));
        listmodel.setForum_short_content(jsonobject1.getString("short_content"));
        listmodel.setForum_totkomen(jsonobject1.getJSONObject("likedislike").getString("total_komen"));
        listmodel.setForum_tothits(jsonobject1.getJSONObject("likedislike").getString("total_hits"));
        listmodel.setAvatar(jsonobject1.getString("user_photo"));
        listmodel.setForum_content(jsonobject1.getString("content"));
        listmodel.setForum_date(jsonobject1.getString("date"));
        listmodel.setForum_img(jsonobject1.getString("img_url"));
        listmodel.setForum_img_compress(jsonobject1.getString("img_compress"));
        listmodel.setForum_judul(jsonobject1.getString("judul"));
        listmodel.setForum_type(jsonobject1.getString("type"));
        listmodel.setForum_content_ext(jsonobject1.getString("content_ext"));
        listmodel.setForum_like(jsonobject1.getJSONObject("likedislike").getString("total_like"));
        listmodel.setForum_myfav(jsonobject1.getJSONObject("likedislike").getString("my_fav_tl"));
        listmodel.setForum_mylike(jsonobject1.getJSONObject("likedislike").getString("my_like_tl"));
        listmodel.setForum_tag(jsonobject1.getString("tag"));
        BenchArrayList.add(listmodel);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        s;
        s.printStackTrace();
    }

    public volatile void onResponse(Object obj)
    {
        onResponse((JSONObject)obj);
    }

    public void onResponse(JSONObject jsonobject)
    {
        parseJSONBenchmark(jsonobject.toString());
        mBenchAdapter.setListArray(BenchArrayList);
        grid_benchmark.setVisibility(0);
        ll_forumlistbenchmark.setVisibility(0);
        mBenchAdapter.notifyDataSetChanged();
        Log.e("countter", String.valueOf(BenchArrayList.size()));
        progressbar_TimelineHP.setVisibility(8);
        btn_sort_benchmark.setVisibility(0);
        if (counterBench < 8)
        {
            txtbtnfooterbenchmark.setVisibility(8);
            grup_footerbenchmark.setVisibility(8);
        } else
        {
            layout_footerProgbenchmark.setVisibility(8);
            txtbtnfooterbenchmark.setVisibility(0);
        }
        if (val$nextprev.equals("now"))
        {
            HomeForumActivity.access$7(HomeForumActivity.this);
        }
    }

    cularProgressBar()
    {
        this$0 = final_homeforumactivity;
        val$nextprev = String.this;
        super();
    }
}
