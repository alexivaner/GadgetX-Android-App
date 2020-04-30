// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import com.inponsel.android.adapter.ListAppsHorizontalAdapter;
import com.inponsel.android.adapter.ListModel;

// Referenced classes of package com.inponsel.android.v2:
//            AppsByCategory

class this._cls0
    implements android.widget.ClickListener
{

    final AppsByCategory this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(listAppsCateforyAdapter.getListModel(i).getAppurl())));
    }

    ontalAdapter()
    {
        this$0 = AppsByCategory.this;
        super();
    }
}
