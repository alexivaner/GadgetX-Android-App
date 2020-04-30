// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.widget.Button;
import com.inponsel.android.utils.Log;

// Referenced classes of package com.inponsel.android.details:
//            DetailsPonsel

class this._cls0
    implements android.support.v4.view.ChangeListener
{

    final DetailsPonsel this$0;

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
            break MISSING_BLOCK_LABEL_127;
        }
        btnIKHTISAR.setBackgroundResource(0x7f020145);
        btnSPESIFIKASI.setBackgroundResource(0x7f020135);
        btnKOMENTAR.setBackgroundResource(0x7f020135);
        btnIKHTISAR.setTextColor(getResources().getColor(0x7f080160));
        Object obj = getResources().getXml(0x7f080197);
        obj = ColorStateList.createFromXml(getResources(), ((org.xmlpull.v1.XmlPullParser) (obj)));
        btnKOMENTAR.setTextColor(((ColorStateList) (obj)));
        btnSPESIFIKASI.setTextColor(((ColorStateList) (obj)));
_L1:
        return;
        if (i == 1)
        {
            btnIKHTISAR.setBackgroundResource(0x7f020135);
            btnSPESIFIKASI.setBackgroundResource(0x7f020145);
            btnKOMENTAR.setBackgroundResource(0x7f020135);
            btnSPESIFIKASI.setTextColor(getResources().getColor(0x7f080160));
            try
            {
                Object obj1 = getResources().getXml(0x7f080197);
                obj1 = ColorStateList.createFromXml(getResources(), ((org.xmlpull.v1.XmlPullParser) (obj1)));
                btnIKHTISAR.setTextColor(((ColorStateList) (obj1)));
                btnKOMENTAR.setTextColor(((ColorStateList) (obj1)));
                return;
            }
            catch (Exception exception)
            {
                return;
            }
        }
        if (i == 2)
        {
            btnIKHTISAR.setBackgroundResource(0x7f020135);
            btnSPESIFIKASI.setBackgroundResource(0x7f020135);
            btnKOMENTAR.setBackgroundResource(0x7f020145);
            btnKOMENTAR.setTextColor(getResources().getColor(0x7f080160));
            try
            {
                Object obj2 = getResources().getXml(0x7f080197);
                obj2 = ColorStateList.createFromXml(getResources(), ((org.xmlpull.v1.XmlPullParser) (obj2)));
                btnIKHTISAR.setTextColor(((ColorStateList) (obj2)));
                btnSPESIFIKASI.setTextColor(((ColorStateList) (obj2)));
                return;
            }
            catch (Exception exception1)
            {
                return;
            }
        }
          goto _L1
        Exception exception2;
        exception2;
    }

    eListener()
    {
        this$0 = DetailsPonsel.this;
        super();
    }
}
