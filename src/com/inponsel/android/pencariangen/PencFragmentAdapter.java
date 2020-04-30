// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.pencariangen;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.viewpagerindicator.IconPagerAdapter;

// Referenced classes of package com.inponsel.android.pencariangen:
//            Hal1PencPonsel, Hal2PencSC, Hal3PencNews, Hal4PencUser

class PencFragmentAdapter extends FragmentPagerAdapter
    implements IconPagerAdapter
{

    protected static final String CONTENT[] = {
        "PONSEL", "SERVICE CENTER", "BERITA", "PENGGUNA"
    };
    protected static final int ICONS[] = {
        0x7f020208, 0x7f020208, 0x7f020208, 0x7f020208
    };
    private int mCount;

    public PencFragmentAdapter(FragmentManager fragmentmanager)
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
            return new Hal1PencPonsel();

        case 1: // '\001'
            return new Hal2PencSC();

        case 2: // '\002'
            return new Hal3PencNews();

        case 3: // '\003'
            return new Hal4PencUser();
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
