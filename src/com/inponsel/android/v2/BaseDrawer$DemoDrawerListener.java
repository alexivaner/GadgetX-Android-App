// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.view.View;
import com.sherlock.navigationdrawer.compat.SherlockActionBarDrawerToggle;

// Referenced classes of package com.inponsel.android.v2:
//            BaseDrawer

private class <init>
    implements android.support.v4.widget.nit>
{

    final BaseDrawer this$0;

    public void onDrawerClosed(View view)
    {
        mDrawerToggle.onDrawerClosed(view);
        mActionBar.rawerClosed();
    }

    public void onDrawerOpened(View view)
    {
        mDrawerToggle.onDrawerOpened(view);
        mActionBar.rawerOpened();
    }

    public void onDrawerSlide(View view, float f)
    {
        mDrawerToggle.onDrawerSlide(view, f);
    }

    public void onDrawerStateChanged(int i)
    {
        mDrawerToggle.onDrawerStateChanged(i);
    }

    private DrawerToggle()
    {
        this$0 = BaseDrawer.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
