// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.rssfeeddetail;

import android.content.ClipboardManager;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Toast;

// Referenced classes of package com.inponsel.android.rssfeeddetail:
//            Hal1RSSDetail

class this._cls0
    implements android.view.ener
{

    final Hal1RSSDetail this$0;

    public void onClick(View view)
    {
        str_detlink = str_detlink.replace("news/", "berita/d/");
        ((ClipboardManager)getActivity().getSystemService("clipboard")).setText(str_detlink);
        Toast.makeText(getActivity(), (new StringBuilder("Link URL berita tercopy : ")).append(str_detlink).toString(), 1).show();
    }

    ()
    {
        this$0 = Hal1RSSDetail.this;
        super();
    }
}
