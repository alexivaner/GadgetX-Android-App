// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.rssfeeddetail;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.inponsel.android.v2.RSSFeedByTag;

// Referenced classes of package com.inponsel.android.rssfeeddetail:
//            Hal1RSSDetail

class val.TagName
    implements android.view.ner
{

    final Hal1RSSDetail this$0;
    private final String val$TagName;
    private final String val$lName;

    public void onClick(View view)
    {
        view = new Intent(getActivity(), com/inponsel/android/v2/RSSFeedByTag);
        view.putExtra("tag_code", "3");
        view.putExtra("tag_key", (new StringBuilder("os:")).append(val$lName).toString());
        view.putExtra("kategori_tag", val$TagName);
        getActivity().startActivityForResult(view, 0);
        getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
    }

    _cls9()
    {
        this$0 = final_hal1rssdetail;
        val$lName = s;
        val$TagName = String.this;
        super();
    }
}
