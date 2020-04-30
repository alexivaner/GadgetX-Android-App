// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.scdetail;

import android.content.res.Resources;
import android.widget.Button;
import com.inponsel.android.utils.Log;

// Referenced classes of package com.inponsel.android.scdetail:
//            SCDetailPager

class this._cls0
    implements android.support.v4.view.ChangeListener
{

    final SCDetailPager this$0;

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
        if (i == 0)
        {
            btnPENCARIAN.setBackgroundResource(0x7f020145);
            btnHASIL.setBackgroundResource(0x7f02013f);
            btnPENCARIAN.setTextColor(getResources().getColor(0x7f080160));
            btnHASIL.setTextColor(getResources().getColor(0x7f080182));
        } else
        if (i == 1)
        {
            btnPENCARIAN.setBackgroundResource(0x7f02013f);
            btnHASIL.setBackgroundResource(0x7f020145);
            btnPENCARIAN.setTextColor(getResources().getColor(0x7f080182));
            btnHASIL.setTextColor(getResources().getColor(0x7f080160));
            return;
        }
    }

    Listener()
    {
        this$0 = SCDetailPager.this;
        super();
    }
}
