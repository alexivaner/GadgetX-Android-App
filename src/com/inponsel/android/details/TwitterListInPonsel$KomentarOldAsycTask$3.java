// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.Intent;
import android.view.View;
import com.inponsel.android.v2.ImagePagerActivity;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.details:
//            TwitterListInPonsel

class val.media_url
    implements android.view.arOldAsycTask._cls3
{

    final this._cls1 this$1;
    private final String val$media_url;

    public void onClick(View view)
    {
        view = new ArrayList();
        view.add(val$media_url);
        view = (String[])view.toArray(new String[view.size()]);
        Intent intent = new Intent(cess._mth2(this._cls1.this), com/inponsel/android/v2/ImagePagerActivity);
        intent.putExtra("imgUrl", view);
        intent.putExtra("pos", 0);
        cess._mth2(this._cls1.this).startActivity(intent);
    }

    ()
    {
        this$1 = final_;
        val$media_url = String.this;
        super();
    }
}
