// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.inponsel.android.v2.ImagePagerActivity;

// Referenced classes of package com.inponsel.android.details:
//            Hal4Galleri

class this._cls0
    implements android.widget.ItemClickListener
{

    final Hal4Galleri this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = new Intent(getActivity(), com/inponsel/android/v2/ImagePagerActivity);
        adapterview.putExtra("imgUrl", image);
        adapterview.putExtra("pos", i);
        startActivity(adapterview);
    }

    ner()
    {
        this$0 = Hal4Galleri.this;
        super();
    }
}
