// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.view.View;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.v2:
//            RoomChatActivity, ImagePagerActivity

class this._cls0
    implements android.view.tener
{

    final RoomChatActivity this$0;

    public boolean onLongClick(View view)
    {
        view = new ArrayList();
        view.add(RoomChatActivity.user_photo.trim());
        view = (String[])view.toArray(new String[view.size()]);
        Intent intent = new Intent(getApplicationContext(), com/inponsel/android/v2/ImagePagerActivity);
        intent.putExtra("imgUrl", view);
        intent.putExtra("pos", 0);
        startActivity(intent);
        return false;
    }

    ()
    {
        this$0 = RoomChatActivity.this;
        super();
    }
}
