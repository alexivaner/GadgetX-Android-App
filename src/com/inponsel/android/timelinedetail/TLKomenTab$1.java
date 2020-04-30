// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.timelinedetail;

import com.inponsel.android.utils.Log;

// Referenced classes of package com.inponsel.android.timelinedetail:
//            TLKomenTab

class this._cls0
    implements android.support.v4.view.ageChangeListener
{

    final TLKomenTab this$0;

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
    }

    tener()
    {
        this$0 = TLKomenTab.this;
        super();
    }
}
