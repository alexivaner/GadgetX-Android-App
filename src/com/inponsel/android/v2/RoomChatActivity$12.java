// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.widget.AbsListView;
import android.widget.TextView;

// Referenced classes of package com.inponsel.android.v2:
//            RoomChatActivity

class this._cls0
    implements android.widget.Listener
{

    final RoomChatActivity this$0;

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        if (i + j == k)
        {
            if (txt_new_message.getVisibility() != 8)
            {
                txt_new_message.startAnimation(animFadeout);
            }
            txt_new_message.setVisibility(8);
        }
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
    }

    ()
    {
        this$0 = RoomChatActivity.this;
        super();
    }
}
