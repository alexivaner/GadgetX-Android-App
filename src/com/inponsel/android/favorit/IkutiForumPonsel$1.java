// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.favorit;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.tlforum.ForumHPActivity;
import com.inponsel.android.widget.ExpandableHeightGridView;

// Referenced classes of package com.inponsel.android.favorit:
//            IkutiForumPonsel

class this._cls0
    implements android.widget.lickListener
{

    final IkutiForumPonsel this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        listPendatang.playSoundEffect(0);
        adapterview = new Intent(IkutiForumPonsel.this, com/inponsel/android/tlforum/ForumHPActivity);
        adapterview.putExtra("id_hph", ForumHpAdapter.getListModel(i).getId_hp());
        adapterview.putExtra("namalengkap", (new StringBuilder(String.valueOf(ForumHpAdapter.getListModel(i).getMerk()))).append(" ").append(ForumHpAdapter.getListModel(i).getModel()).toString());
        adapterview.putExtra("codename", ForumHpAdapter.getListModel(i).getCodename());
        adapterview.putExtra("model", ForumHpAdapter.getListModel(i).getModel());
        adapterview.putExtra("merk", ForumHpAdapter.getListModel(i).getMerk());
        adapterview.putExtra("gambar", ForumHpAdapter.getListModel(i).getGambar());
        startActivityForResult(adapterview, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
    }

    stForumHpAdapter()
    {
        this$0 = IkutiForumPonsel.this;
        super();
    }
}
