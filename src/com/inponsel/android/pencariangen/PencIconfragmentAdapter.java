// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.pencariangen;

import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

// Referenced classes of package com.inponsel.android.pencariangen:
//            Hal1PencPonsel, Hal2PencSC, Hal3PencNews, Hal4PencUser

public class PencIconfragmentAdapter extends PagerAdapter
    implements com.astuetz.PagerSlidingTabStrip.IconTabProvider
{

    private final int ICONS[] = {
        0x7f020208, 0x7f020208, 0x7f020208, 0x7f020208
    };

    public PencIconfragmentAdapter()
    {
    }

    public void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
        viewgroup.removeView((View)obj);
    }

    public int getCount()
    {
        return ICONS.length;
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

    public int getPageIconResId(int i)
    {
        return ICONS[i];
    }

    public Object instantiateItem(ViewGroup viewgroup, int i)
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

    public boolean isViewFromObject(View view, Object obj)
    {
        return view == (View)obj;
    }
}
