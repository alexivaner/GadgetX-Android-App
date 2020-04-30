// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.tlforum;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.inponsel.android.utils.ExpandedGridView;
import com.inponsel.android.utils.Log;
import java.util.ArrayList;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.tlforum:
//            ForumHPActivity

class val.nextprev
    implements com.android.volley.tivity._cls55
{

    final ForumHPActivity this$0;
    private final String val$nextprev;

    public volatile void onResponse(Object obj)
    {
        onResponse((JSONObject)obj);
    }

    public void onResponse(JSONObject jsonobject)
    {
        parseJSONFoto(jsonobject.toString());
        mFotoKameraAdapter.setListArray(fotoKameraArrayList);
        grid_hasilfoto.setVisibility(0);
        ll_forumlistFoto.setVisibility(0);
        mFotoKameraAdapter.notifyDataSetChanged();
        Log.e("countter", String.valueOf(fotoKameraArrayList.size()));
        if (counterFoto < 8)
        {
            txtbtnfooterFoto.setVisibility(8);
            grup_footerFoto.setVisibility(8);
        } else
        {
            layout_footerProgFoto.setVisibility(8);
            txtbtnfooterFoto.setVisibility(0);
        }
        progressbar_TimelineHP.setVisibility(8);
        if (val$nextprev.equals("now"))
        {
            if (fotoKameraArrayList.size() == 0)
            {
                pop_txt_empty.setVisibility(0);
                img_empty.setVisibility(0);
                pop_txt_empty.setText("Konten masih kosong");
            }
            ForumHPActivity.access$10(ForumHPActivity.this);
        }
    }

    oKameraAdapter()
    {
        this$0 = final_forumhpactivity;
        val$nextprev = String.this;
        super();
    }
}
