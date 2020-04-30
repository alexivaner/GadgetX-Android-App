// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

// Referenced classes of package com.inponsel.android.v2:
//            RoomInfoChat, ImagePagerActivity

class this._cls0
    implements android.widget.temClickListener
{

    final RoomInfoChat this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = new Intent(RoomInfoChat.this, com/inponsel/android/v2/ImagePagerActivity);
        adapterview.putExtra("imgUrl", image);
        adapterview.putExtra("pos", i);
        startActivity(adapterview);
    }

    ity()
    {
        this$0 = RoomInfoChat.this;
        super();
    }
}
