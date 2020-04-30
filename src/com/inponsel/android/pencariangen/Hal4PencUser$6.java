// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.pencariangen;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.utils.Log;
import com.inponsel.android.v2.ProfileOtherUser;

// Referenced classes of package com.inponsel.android.pencariangen:
//            Hal4PencUser

class this._cls0
    implements android.widget.temClickListener
{

    final Hal4PencUser this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = new Intent(getActivity(), com/inponsel/android/v2/ProfileOtherUser);
        Log.e("user_name", scpencarianAdapter.getListModel(i).getUsername());
        adapterview.putExtra("id_user_view", scpencarianAdapter.getListModel(i).getUsername());
        startActivityForResult(adapterview, 0);
        getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
    }

    stSCProvAdapter()
    {
        this$0 = Hal4PencUser.this;
        super();
    }
}
