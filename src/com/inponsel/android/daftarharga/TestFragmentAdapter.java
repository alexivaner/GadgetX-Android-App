// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.daftarharga;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.Html;
import com.viewpagerindicator.IconPagerAdapter;

// Referenced classes of package com.inponsel.android.daftarharga:
//            Hal1Preference, Hal2Hasil

class TestFragmentAdapter extends FragmentPagerAdapter
    implements IconPagerAdapter
{

    public static String CONTENT[] = {
        "<font color='#FFFFFF'>PENCARIAN</font>", "<font color='#CACACA'>HASIL</font>"
    };
    protected static final int ICONS[] = {
        0x7f020208, 0x7f020208, 0x7f020208
    };
    private int mCount;

    public TestFragmentAdapter(FragmentManager fragmentmanager)
    {
        super(fragmentmanager);
        mCount = CONTENT.length;
    }

    public int getCount()
    {
        return mCount;
    }

    public int getIconResId(int i)
    {
        return ICONS[i % ICONS.length];
    }

    public Fragment getItem(int i)
    {
        switch (i)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder("not this many fragments: ")).append(i).toString());

        case 0: // '\0'
            return new Hal1Preference();

        case 1: // '\001'
            return new Hal2Hasil();
        }
    }

    public CharSequence getPageTitle(int i)
    {
        return Html.fromHtml(CONTENT[i]);
    }

    public void setCount(int i)
    {
        if (i > 0 && i <= 10)
        {
            mCount = i;
            notifyDataSetChanged();
        }
    }

}
