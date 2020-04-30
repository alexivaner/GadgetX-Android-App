// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.view.View;
import com.sherlock.navigationdrawer.compat.SherlockActionBarDrawerToggle;

// Referenced classes of package com.inponsel.android.v2:
//            RoomChatActivity

private class <init>
    implements android.support.v4.widget.nit>
{

    final RoomChatActivity this$0;

    public void onDrawerClosed(View view)
    {
        RoomChatActivity.access$0(RoomChatActivity.this).onDrawerClosed(view);
        RoomChatActivity.access$1(RoomChatActivity.this).rawerClosed();
    }

    public void onDrawerOpened(View view)
    {
        RoomChatActivity.access$0(RoomChatActivity.this).onDrawerOpened(view);
        RoomChatActivity.access$1(RoomChatActivity.this).rawerOpened();
    }

    public void onDrawerSlide(View view, float f)
    {
        RoomChatActivity.access$0(RoomChatActivity.this).onDrawerSlide(view, f);
    }

    public void onDrawerStateChanged(int i)
    {
        RoomChatActivity.access$0(RoomChatActivity.this).onDrawerStateChanged(i);
    }

    private Toggle()
    {
        this$0 = RoomChatActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
