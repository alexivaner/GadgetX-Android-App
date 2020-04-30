// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.scdetail;

import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

// Referenced classes of package com.inponsel.android.scdetail:
//            SCDetailPager

class this._cls0
    implements android.view.ener
{

    final SCDetailPager this$0;

    public void onClick(View view)
    {
        SCDetailPager.mViewPager.setCurrentItem(1, true);
        btnPENCARIAN.setBackgroundResource(0x7f02013f);
        btnHASIL.setBackgroundResource(0x7f020145);
        btnPENCARIAN.setTextColor(getResources().getColor(0x7f080182));
        btnHASIL.setTextColor(getResources().getColor(0x7f080160));
    }

    ()
    {
        this$0 = SCDetailPager.this;
        super();
    }
}
