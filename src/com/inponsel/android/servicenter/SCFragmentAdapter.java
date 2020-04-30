// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.servicenter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.viewpagerindicator.IconPagerAdapter;

// Referenced classes of package com.inponsel.android.servicenter:
//            Hal1SCManual, Hal2SCHasil

class SCFragmentAdapter extends FragmentPagerAdapter
    implements IconPagerAdapter
{

    protected static final String CONTENT[] = {
        "Pencarian", "Hasil"
    };
    protected static final int ICONS[] = {
        0x7f020208, 0x7f020208, 0x7f020208, 0x7f020208
    };
    private int mCount;

    public SCFragmentAdapter(FragmentManager fragmentmanager)
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
            return new Hal1SCManual();

        case 1: // '\001'
            return new Hal2SCHasil();
        }
    }

    public CharSequence getPageTitle(int i)
    {
        return CONTENT[i % CONTENT.length].toUpperCase();
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
