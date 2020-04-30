// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.statistik;

import android.support.v4.view.ViewPager;
import com.inponsel.android.v2.BaseDrawer;
import com.viewpagerindicator.PageIndicator;

// Referenced classes of package com.inponsel.android.statistik:
//            TestFragmentAdapter

public abstract class BaseStatistikActivity extends BaseDrawer
{

    public static PageIndicator mIndicator;
    TestFragmentAdapter mAdapter;
    ViewPager mPager;

    public BaseStatistikActivity()
    {
    }
}
