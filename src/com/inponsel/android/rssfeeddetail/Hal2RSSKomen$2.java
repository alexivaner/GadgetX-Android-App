// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.rssfeeddetail;

import android.content.Intent;
import android.view.View;
import com.inponsel.android.v2.AddKomentarPicture;

// Referenced classes of package com.inponsel.android.rssfeeddetail:
//            Hal2RSSKomen

class this._cls0
    implements android.view.tener
{

    final Hal2RSSKomen this$0;

    public void onClick(View view)
    {
        view = new Intent(getActivity(), com/inponsel/android/v2/AddKomentarPicture);
        view.putExtra("komen_type", "berita");
        view.putExtra("id_rss", id_rss);
        view.putExtra("user_id", user_id);
        view.putExtra("top_id", top_id);
        startActivityForResult(view, Hal2RSSKomen.access$5());
    }

    ()
    {
        this$0 = Hal2RSSKomen.this;
        super();
    }
}
