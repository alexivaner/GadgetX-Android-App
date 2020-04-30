// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.inponsel.android.utils.Log;
import com.inponsel.android.v2.ProfileOtherUser;

// Referenced classes of package com.inponsel.android.adapter:
//            ListChatGroupAdapter, ListModel

class val.lms
    implements android.view.tGroupAdapter._cls5
{

    final ListChatGroupAdapter this$0;
    private final ListModel val$lms;

    public void onClick(View view)
    {
        view = new Intent(ListChatGroupAdapter.access$0(ListChatGroupAdapter.this), com/inponsel/android/v2/ProfileOtherUser);
        Log.e("user_name", val$lms.getFrom_name());
        view.putExtra("id_user_view", val$lms.getFrom_name());
        ListChatGroupAdapter.access$0(ListChatGroupAdapter.this).startActivityForResult(view, 0);
        ListChatGroupAdapter.access$0(ListChatGroupAdapter.this).overridePendingTransition(0x7f040003, 0x7f040004);
    }

    _cls9()
    {
        this$0 = final_listchatgroupadapter;
        val$lms = ListModel.this;
        super();
    }
}
