// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.inponsel.android.adapter.ListHPPeopleAdapter;
import com.inponsel.android.adapter.ListModel;

// Referenced classes of package com.inponsel.android.v2:
//            RoomPenggunaHp, ProfileOtherUser

class this._cls0
    implements android.widget.mClickListener
{

    final RoomPenggunaHp this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = new Intent(getApplicationContext(), com/inponsel/android/v2/ProfileOtherUser);
        adapterview.putExtra("id_user_view", hpPeopleAdapter.getListModel(i).getUsername());
        startActivityForResult(adapterview, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
    }

    Adapter()
    {
        this$0 = RoomPenggunaHp.this;
        super();
    }
}
