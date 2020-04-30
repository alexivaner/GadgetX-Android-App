// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.pencariangen;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Handler;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import com.inponsel.android.utils.Log;

// Referenced classes of package com.inponsel.android.pencariangen:
//            TabPencarian

class this._cls1
    implements Runnable
{

    final viewpager this$1;

    public void run()
    {
        hsv_viewpager.fullScroll(17);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/pencariangen/TabPencarian$5

/* anonymous class */
    class TabPencarian._cls5
        implements android.support.v4.view.ViewPager.OnPageChangeListener
    {

        final TabPencarian this$0;

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
                break MISSING_BLOCK_LABEL_172;
            }
            (new Handler()).postDelayed(new TabPencarian._cls5._cls1(), 100L);
            btnPONSEL.setBackgroundResource(0x7f020145);
            btnSERVICECENTER.setBackgroundResource(0x7f02013f);
            btnBERITA.setBackgroundResource(0x7f02013f);
            btnPENGGUNA.setBackgroundResource(0x7f02013f);
            btnPONSEL.setTextColor(getResources().getColor(0x7f080160));
            Object obj = getResources().getXml(0x7f080197);
            obj = ColorStateList.createFromXml(getResources(), ((org.xmlpull.v1.XmlPullParser) (obj)));
            btnSERVICECENTER.setTextColor(((ColorStateList) (obj)));
            btnBERITA.setTextColor(((ColorStateList) (obj)));
            btnPENGGUNA.setTextColor(((ColorStateList) (obj)));
_L1:
            return;
            if (i == 1)
            {
                btnPONSEL.setBackgroundResource(0x7f02013f);
                btnSERVICECENTER.setBackgroundResource(0x7f020145);
                btnBERITA.setBackgroundResource(0x7f02013f);
                btnPENGGUNA.setBackgroundResource(0x7f02013f);
                btnSERVICECENTER.setTextColor(getResources().getColor(0x7f080160));
                try
                {
                    Object obj1 = getResources().getXml(0x7f080197);
                    obj1 = ColorStateList.createFromXml(getResources(), ((org.xmlpull.v1.XmlPullParser) (obj1)));
                    btnPONSEL.setTextColor(((ColorStateList) (obj1)));
                    btnBERITA.setTextColor(((ColorStateList) (obj1)));
                    btnPENGGUNA.setTextColor(((ColorStateList) (obj1)));
                    return;
                }
                catch (Exception exception)
                {
                    return;
                }
            }
            if (i == 2)
            {
                btnPONSEL.setBackgroundResource(0x7f02013f);
                btnSERVICECENTER.setBackgroundResource(0x7f02013f);
                btnBERITA.setBackgroundResource(0x7f020145);
                btnPENGGUNA.setBackgroundResource(0x7f02013f);
                btnBERITA.setTextColor(getResources().getColor(0x7f080160));
                try
                {
                    Object obj2 = getResources().getXml(0x7f080197);
                    obj2 = ColorStateList.createFromXml(getResources(), ((org.xmlpull.v1.XmlPullParser) (obj2)));
                    btnPONSEL.setTextColor(((ColorStateList) (obj2)));
                    btnSERVICECENTER.setTextColor(((ColorStateList) (obj2)));
                    btnPENGGUNA.setTextColor(((ColorStateList) (obj2)));
                    return;
                }
                catch (Exception exception1)
                {
                    return;
                }
            }
            if (i == 3)
            {
                (new Handler()).postDelayed(new TabPencarian._cls5._cls2(), 100L);
                btnPONSEL.setBackgroundResource(0x7f02013f);
                btnSERVICECENTER.setBackgroundResource(0x7f02013f);
                btnBERITA.setBackgroundResource(0x7f02013f);
                btnPENGGUNA.setBackgroundResource(0x7f020145);
                btnPENGGUNA.setTextColor(getResources().getColor(0x7f080160));
                try
                {
                    Object obj3 = getResources().getXml(0x7f080197);
                    obj3 = ColorStateList.createFromXml(getResources(), ((org.xmlpull.v1.XmlPullParser) (obj3)));
                    btnPONSEL.setTextColor(((ColorStateList) (obj3)));
                    btnSERVICECENTER.setTextColor(((ColorStateList) (obj3)));
                    btnBERITA.setTextColor(((ColorStateList) (obj3)));
                    return;
                }
                catch (Exception exception2)
                {
                    return;
                }
            }
              goto _L1
            Exception exception3;
            exception3;
        }


            
            {
                this$0 = TabPencarian.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/pencariangen/TabPencarian$5$2

/* anonymous class */
        class TabPencarian._cls5._cls2
            implements Runnable
        {

            final TabPencarian._cls5 this$1;

            public void run()
            {
                hsv_viewpager.fullScroll(66);
            }

                    
                    {
                        this$1 = TabPencarian._cls5.this;
                        super();
                    }
        }

    }

}
