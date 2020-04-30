// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

// Referenced classes of package com.inponsel.android.details:
//            DetailsPonsel

class this._cls0
    implements android.view.ener
{

    final DetailsPonsel this$0;

    public void onClick(View view)
    {
        mViewPager.setCurrentItem(1, true);
        btnIKHTISAR.setBackgroundResource(0x7f020135);
        btnSPESIFIKASI.setBackgroundResource(0x7f020145);
        btnKOMENTAR.setBackgroundResource(0x7f020135);
        btnSPESIFIKASI.setTextColor(getResources().getColor(0x7f080160));
        try
        {
            view = getResources().getXml(0x7f080197);
            view = ColorStateList.createFromXml(getResources(), view);
            btnIKHTISAR.setTextColor(view);
            btnKOMENTAR.setTextColor(view);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            return;
        }
    }

    ()
    {
        this$0 = DetailsPonsel.this;
        super();
    }
}
