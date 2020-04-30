// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;

// Referenced classes of package com.inponsel.android.v2:
//            RoomChatActivity

private class <init>
{

    private final ActionBar mActionBar;
    final RoomChatActivity this$0;

    public void init()
    {
        mActionBar.setDisplayHomeAsUpEnabled(true);
        mActionBar.setHomeButtonEnabled(true);
    }

    public void onDrawerClosed()
    {
    }

    public void onDrawerOpened()
    {
    }

    private ()
    {
        this$0 = RoomChatActivity.this;
        super();
        mActionBar = getSupportActionBar();
    }

    portActionBar(portActionBar portactionbar)
    {
        this();
    }
}
