// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.inponsel.android.utils.Util;
import com.inponsel.android.v2.ImageFullActivity;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.adapter:
//            ListChatGroupAdapter, ListModel

class val.lms
    implements android.view.GroupAdapter._cls11
{

    final ListChatGroupAdapter this$0;
    private final ListModel val$lms;

    public void onClick(View view)
    {
        view = new ArrayList();
        view.add((new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(val$lms.getLast_message().toString().trim()).toString());
        view = (String[])view.toArray(new String[view.size()]);
        Intent intent = new Intent(ListChatGroupAdapter.access$0(ListChatGroupAdapter.this), com/inponsel/android/v2/ImageFullActivity);
        intent.putExtra("imgUrl", view);
        intent.putExtra("pos", 0);
        ListChatGroupAdapter.access$0(ListChatGroupAdapter.this).startActivity(intent);
    }

    ()
    {
        this$0 = final_listchatgroupadapter;
        val$lms = ListModel.this;
        super();
    }
}