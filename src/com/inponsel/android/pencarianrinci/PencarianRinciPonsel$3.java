// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.pencarianrinci;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.widget.Button;
import com.inponsel.android.utils.Log;

// Referenced classes of package com.inponsel.android.pencarianrinci:
//            PencarianRinciPonsel

class this._cls0
    implements android.support.v4.view.istener
{

    final PencarianRinciPonsel this$0;

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
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_104;
        }
        btnPENCARIAN.setBackgroundResource(0x7f020145);
        btnHASIL.setBackgroundResource(0x7f02013f);
        btnPENCARIAN.setTextColor(getResources().getColor(0x7f080160));
        Object obj = getResources().getXml(0x7f080197);
        obj = ColorStateList.createFromXml(getResources(), ((org.xmlpull.v1.XmlPullParser) (obj)));
        btnHASIL.setTextColor(((ColorStateList) (obj)));
_L1:
        return;
        if (i == 1)
        {
            btnPENCARIAN.setBackgroundResource(0x7f02013f);
            btnHASIL.setBackgroundResource(0x7f020145);
            btnHASIL.setTextColor(getResources().getColor(0x7f080160));
            try
            {
                Object obj1 = getResources().getXml(0x7f080197);
                obj1 = ColorStateList.createFromXml(getResources(), ((org.xmlpull.v1.XmlPullParser) (obj1)));
                btnPENCARIAN.setTextColor(((ColorStateList) (obj1)));
                return;
            }
            catch (Exception exception)
            {
                return;
            }
        }
          goto _L1
        Exception exception1;
        exception1;
    }

    ()
    {
        this$0 = PencarianRinciPonsel.this;
        super();
    }
}
