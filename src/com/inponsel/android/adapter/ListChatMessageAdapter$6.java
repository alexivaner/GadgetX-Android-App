// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.adapter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

// Referenced classes of package com.inponsel.android.adapter:
//            ListChatMessageAdapter, ListModel

class val.lms
    implements android.view.essageAdapter._cls6
{

    final ListChatMessageAdapter this$0;
    private final ListModel val$lms;

    public void onClick(View view)
    {
        view = (new StringBuilder("geo:")).append(val$lms.getKordinat()).append("?q=").append(val$lms.getKordinat()).toString();
        ListChatMessageAdapter.access$0(ListChatMessageAdapter.this).startActivity(new Intent("android.intent.action.VIEW", Uri.parse(view)));
    }

    ()
    {
        this$0 = final_listchatmessageadapter;
        val$lms = ListModel.this;
        super();
    }
}
