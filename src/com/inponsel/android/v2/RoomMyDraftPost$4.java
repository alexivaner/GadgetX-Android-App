// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.utils.Log;

// Referenced classes of package com.inponsel.android.v2:
//            RoomMyDraftPost, RoomPostPertanyaan

class this._cls0
    implements android.widget.ClickListener
{

    final RoomMyDraftPost this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = new Intent(getApplicationContext(), com/inponsel/android/v2/RoomPostPertanyaan);
        adapterview.putExtra("id_content", tanyaAdapter.getListModel(i).getId_content());
        adapterview.putExtra("action", "edit");
        adapterview.putExtra("id_hph", tanyaAdapter.getListModel(i).getId_hp());
        adapterview.putExtra("codename", tanyaAdapter.getListModel(i).getCodename());
        adapterview.putExtra("from", "notif");
        adapterview.putExtra("model", "");
        adapterview.putExtra("merk", "");
        adapterview.putExtra("id_date", tanyaAdapter.getListModel(i).getRoom_date());
        Log.e("id_date", tanyaAdapter.getListModel(i).getRoom_date());
        startActivityForResult(adapterview, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
    }

    stTanyaAdapter()
    {
        this$0 = RoomMyDraftPost.this;
        super();
    }
}
