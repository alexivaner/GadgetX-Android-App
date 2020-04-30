// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.timelinedetail;

import android.content.Intent;
import android.view.View;
import com.inponsel.android.v2.AddKomentarPicture;

// Referenced classes of package com.inponsel.android.timelinedetail:
//            Hal1TLDetailActivity

class this._cls0
    implements android.view.al1TLDetailActivity._cls12
{

    final Hal1TLDetailActivity this$0;

    public void onClick(View view)
    {
        view = new Intent(Hal1TLDetailActivity.this, com/inponsel/android/v2/AddKomentarPicture);
        view.putExtra("komen_type", "forum");
        view.putExtra("forum_id", tl_id);
        view.putExtra("tl_judul", tl_judul);
        view.putExtra("top_id", top_id);
        view.putExtra("tl_type", tl_type);
        startActivityForResult(view, Hal1TLDetailActivity.access$8());
    }

    A()
    {
        this$0 = Hal1TLDetailActivity.this;
        super();
    }
}
