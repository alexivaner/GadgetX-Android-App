// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.statistik;

import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.YourFragmentInterface;

// Referenced classes of package com.inponsel.android.statistik:
//            StatistikPonsel, TestFragmentAdapter

class this._cls0
    implements android.support.v4.view.angeListener
{

    final StatistikPonsel this$0;

    public void onPageScrollStateChanged(int i)
    {
    }

    public void onPageScrolled(int i, float f, int j)
    {
    }

    public void onPageSelected(int i)
    {
        Log.e("onPageSelected", String.valueOf(i));
        pageSelected = i;
        YourFragmentInterface yourfragmentinterface = (YourFragmentInterface)mAdapter.instantiateItem(mPager, i);
        if (yourfragmentinterface != null)
        {
            yourfragmentinterface.fragmentBecameVisible();
        }
    }

    r()
    {
        this$0 = StatistikPonsel.this;
        super();
    }
}
