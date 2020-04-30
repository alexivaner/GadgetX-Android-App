// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.conversation;

import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.inponsel.android.utils.Log;
import java.util.ArrayList;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.conversation:
//            ConversationActivity

class val.nextprev
    implements com.android.volley.ionActivity._cls25
{

    final ConversationActivity this$0;
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
        if (val$nextprev.equals("now"))
        {
            ConversationActivity.access$4(ConversationActivity.this);
        }
    }

    oKameraAdapter()
    {
        this$0 = final_conversationactivity;
        val$nextprev = String.this;
        super();
    }
}
