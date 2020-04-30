// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.pencariangen;

import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.inponsel.android.utils.Log;
import com.inponsel.android.widget.ExpandableHeightGridView;
import java.util.ArrayList;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.pencariangen:
//            Hal1PencPonsel

class this._cls0
    implements com.android.volley.
{

    final Hal1PencPonsel this$0;

    public volatile void onResponse(Object obj)
    {
        onResponse((JSONObject)obj);
    }

    public void onResponse(JSONObject jsonobject)
    {
        parseJSON(jsonobject.toString());
        if (page == 1)
        {
            Hal1PencPonsel.access$3(Hal1PencPonsel.this);
            if (suc.equals("1"))
            {
                progressbar_middle.setVisibility(8);
                listPencarianHp.setVisibility(0);
                layout_empty.setVisibility(8);
            } else
            {
                grup_header_footer.setVisibility(8);
                progressbar_middle.setVisibility(8);
                listPencarianHp.setVisibility(8);
                layout_empty.setVisibility(0);
                txt_empty.setText("Ponsel belum tersedia");
            }
        }
        pencarianAdapter.notifyDataSetChanged();
        Log.e("getChildPencarianPon", String.valueOf(listPencarianHp.getChildCount()));
        Log.e("counterArray", String.valueOf(pencarianArray.size()));
        if (counterArray < 30)
        {
            grup_header_footer.setVisibility(8);
            return;
        } else
        {
            btnMemuatLagi.setVisibility(0);
            grup_header_footer.setVisibility(0);
            return;
        }
    }

    stPencarianAdapter()
    {
        this$0 = Hal1PencPonsel.this;
        super();
    }
}
