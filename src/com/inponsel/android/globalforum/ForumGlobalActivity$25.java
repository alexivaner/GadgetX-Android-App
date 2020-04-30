// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.globalforum;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.tlforum.ForumHPActivity;

// Referenced classes of package com.inponsel.android.globalforum:
//            ForumGlobalActivity

class this._cls0
    implements android.widget.Listener
{

    final ForumGlobalActivity this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = ponselOsAdapter.getListModel(i).getId_hp();
        view = ponselOsAdapter.getListModel(i).getMerk();
        String s = ponselOsAdapter.getListModel(i).getModel();
        String s1 = ponselOsAdapter.getListModel(i).getCodename();
        String s2 = ponselOsAdapter.getListModel(i).getGambar();
        Intent intent = new Intent(ForumGlobalActivity.this, com/inponsel/android/tlforum/ForumHPActivity);
        intent.putExtra("id_hph", adapterview);
        intent.putExtra("namalengkap", (new StringBuilder(String.valueOf(view))).append(" ").append(s).toString());
        intent.putExtra("codename", s1);
        intent.putExtra("model", s);
        intent.putExtra("merk", view);
        intent.putExtra("gambar", s2);
        startActivityForResult(intent, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
    }

    tPendatangAdapter()
    {
        this$0 = ForumGlobalActivity.this;
        super();
    }
}
