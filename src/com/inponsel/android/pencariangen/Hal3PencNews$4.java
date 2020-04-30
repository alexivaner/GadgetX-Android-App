// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.pencariangen;

import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import com.inponsel.android.utils.Log;
import java.util.ArrayList;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.pencariangen:
//            Hal3PencNews

class this._cls0
    implements com.android.volley.er
{

    final Hal3PencNews this$0;

    public volatile void onResponse(Object obj)
    {
        onResponse((JSONObject)obj);
    }

    public void onResponse(JSONObject jsonobject)
    {
        parseJSON(jsonobject.toString());
        Hal3PencNews.access$1(Hal3PencNews.this);
        if (limit == 1)
        {
            Hal3PencNews.access$2(Hal3PencNews.this);
        }
        layout_empty.setVisibility(8);
        Log.e("counter", String.valueOf(Hal3PencNews.access$0(Hal3PencNews.this).size()));
        if (Hal3PencNews.access$0(Hal3PencNews.this).size() == 0)
        {
            scrollviewKomen.setVisibility(8);
            layout_empty.setVisibility(0);
            progressbar_middle.setVisibility(8);
            pop_txt_empty.setVisibility(0);
            pop_txt_empty.setText("Berita tidak ditemukan");
            return;
        }
        if (Hal3PencNews.access$0(Hal3PencNews.this).size() < 15)
        {
            grup_footer.setVisibility(8);
            return;
        } else
        {
            grup_footer.setVisibility(0);
            txtbtnfooter.setVisibility(0);
            return;
        }
    }

    ()
    {
        this$0 = Hal3PencNews.this;
        super();
    }
}
