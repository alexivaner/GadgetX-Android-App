// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.pencarianrinci;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

// Referenced classes of package com.inponsel.android.pencarianrinci:
//            PencarianRinciPonsel

class this._cls0
    implements android.view.PencarianRinciPonsel._cls2
{

    final PencarianRinciPonsel this$0;

    public void onClick(View view)
    {
        PencarianRinciPonsel.mPager.setCurrentItem(1, true);
        btnPENCARIAN.setBackgroundResource(0x7f02013f);
        btnHASIL.setBackgroundResource(0x7f020145);
        btnHASIL.setTextColor(getResources().getColor(0x7f080160));
        try
        {
            view = getResources().getXml(0x7f080197);
            view = ColorStateList.createFromXml(getResources(), view);
            btnPENCARIAN.setTextColor(view);
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
        this$0 = PencarianRinciPonsel.this;
        super();
    }
}