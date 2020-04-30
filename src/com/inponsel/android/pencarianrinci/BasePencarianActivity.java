// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.pencarianrinci;

import android.support.v4.view.ViewPager;
import com.astuetz.PagerSlidingTabStrip;
import com.inponsel.android.v2.BaseDrawer;

// Referenced classes of package com.inponsel.android.pencarianrinci:
//            PencRinciFragmentAdapter

public abstract class BasePencarianActivity extends BaseDrawer
{

    public static ViewPager mPager;
    String Hal1Pencarian;
    String Hal2HasilPenc;
    PencRinciFragmentAdapter mAdapter;
    PagerSlidingTabStrip mIndicator;

    public BasePencarianActivity()
    {
    }

    public String getHal1Pencarian()
    {
        return Hal1Pencarian;
    }

    public String getHal2HasilPenc()
    {
        return Hal2HasilPenc;
    }

    public void setHal1Pencarian(String s)
    {
        Hal1Pencarian = s;
    }

    public void setHal2HasilPenc(String s)
    {
        Hal2HasilPenc = s;
    }
}
