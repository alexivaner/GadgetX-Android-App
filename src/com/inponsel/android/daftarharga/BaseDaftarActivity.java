// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.daftarharga;

import android.support.v4.view.ViewPager;
import com.astuetz.PagerSlidingTabStrip;
import com.inponsel.android.v2.BaseDrawer;

// Referenced classes of package com.inponsel.android.daftarharga:
//            TestFragmentAdapter

public abstract class BaseDaftarActivity extends BaseDrawer
{

    public static ViewPager mPager;
    String Hal1Pref;
    String Hal2Hasil;
    TestFragmentAdapter mAdapter;
    PagerSlidingTabStrip mIndicator;

    public BaseDaftarActivity()
    {
    }

    public String getHal1Pref()
    {
        return Hal1Pref;
    }

    public String getHal2Hasil()
    {
        return Hal2Hasil;
    }

    public void setHal1Pref(String s)
    {
        Hal1Pref = s;
    }

    public void setHal2Hasil(String s)
    {
        Hal2Hasil = s;
    }
}
