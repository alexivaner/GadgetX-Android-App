// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.adapter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

// Referenced classes of package com.inponsel.android.adapter:
//            ListChatGroupAdapter, ListModel

class val.lms
    implements android.view.tGroupAdapter._cls2
{

    final ListChatGroupAdapter this$0;
    private final ListModel val$lms;

    public void onClick(View view)
    {
        view = (new StringBuilder("geo:")).append(val$lms.getKordinat()).append("?q=").append(val$lms.getKordinat()).toString();
        ListChatGroupAdapter.access$0(ListChatGroupAdapter.this).startActivity(new Intent("android.intent.action.VIEW", Uri.parse(view)));
    }

    _cls9()
    {
        this$0 = final_listchatgroupadapter;
        val$lms = ListModel.this;
        super();
    }
}
