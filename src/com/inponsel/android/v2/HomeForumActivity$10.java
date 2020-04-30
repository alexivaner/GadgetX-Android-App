// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.Log;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            HomeForumActivity

class this._cls0
    implements com.android.volley.y._cls10
{

    final HomeForumActivity this$0;

    public volatile void onResponse(Object obj)
    {
        onResponse((JSONObject)obj);
    }

    public void onResponse(JSONObject jsonobject)
    {
        Log.e("jsonGlobal", jsonobject.toString());
        parseJSON(jsonobject.toString());
        HomeForumActivity.access$3(HomeForumActivity.this);
        HomeForumActivity.access$4(HomeForumActivity.this);
        if (succesStat.equals("0"))
        {
            pop_txt_empty.setVisibility(0);
            img_empty.setVisibility(0);
            pop_txt_empty.setText("Konten belum tersedia");
        } else
        {
            ll_forumlist.setVisibility(0);
        }
        ponselBaseApp.getObserver().setLoginStat("1");
    }

    ()
    {
        this$0 = HomeForumActivity.this;
        super();
    }
}
