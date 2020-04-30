// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import com.inponsel.android.adapter.ListAppsAdapter;
import com.inponsel.android.adapter.ListModel;

// Referenced classes of package com.inponsel.android.v2:
//            HomeGamesActivity

class this._cls0
    implements android.widget.ickListener
{

    final HomeGamesActivity this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(listAppsWeekAdapter.getListModel(i).getAppurl())));
    }

    ()
    {
        this$0 = HomeGamesActivity.this;
        super();
    }
}
