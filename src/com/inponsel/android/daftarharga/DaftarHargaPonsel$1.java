// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.daftarharga;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

// Referenced classes of package com.inponsel.android.daftarharga:
//            DaftarHargaPonsel

class this._cls0
    implements android.view.
{

    final DaftarHargaPonsel this$0;

    public void onClick(View view)
    {
        DaftarHargaPonsel.mPager.setCurrentItem(0, true);
        btnPENCARIAN.setBackgroundResource(0x7f020145);
        btnHASIL.setBackgroundResource(0x7f020135);
        btnPENCARIAN.setTextColor(getResources().getColor(0x7f080160));
        try
        {
            view = getResources().getXml(0x7f080197);
            view = ColorStateList.createFromXml(getResources(), view);
            btnHASIL.setTextColor(view);
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
        this$0 = DaftarHargaPonsel.this;
        super();
    }
}
