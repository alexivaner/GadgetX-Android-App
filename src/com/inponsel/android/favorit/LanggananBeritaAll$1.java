// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.favorit;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.v2.RSSFeedByTag;

// Referenced classes of package com.inponsel.android.favorit:
//            LanggananBeritaAll

class this._cls0
    implements android.widget.ckListener
{

    final LanggananBeritaAll this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = new Intent(LanggananBeritaAll.this, com/inponsel/android/v2/RSSFeedByTag);
        adapterview.putExtra("tag_code", "5");
        adapterview.putExtra("tag_key", (new StringBuilder("hp:")).append(langgananAdapter.getListModel(i).getId_hp()).toString());
        adapterview.putExtra("kategori_tag", (new StringBuilder(String.valueOf(langgananAdapter.getListModel(i).getMerk()))).append(" ").append(langgananAdapter.getListModel(i).getModel()).toString());
        startActivityForResult(adapterview, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
    }

    stLanggananAdapter()
    {
        this$0 = LanggananBeritaAll.this;
        super();
    }
}
