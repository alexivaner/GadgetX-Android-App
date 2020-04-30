// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.widget;

import android.widget.Scroller;

// Referenced classes of package com.inponsel.android.widget:
//            HorizontalListView

private static final class I
{

    public static float getCurrVelocity(Scroller scroller)
    {
        return scroller.getCurrVelocity();
    }

    static 
    {
        if (android.os.reamSandwichPlus < 14)
        {
            throw new RuntimeException("Should not get to IceCreamSandwichPlus class unless sdk is >= 14!");
        }
    }

    private I()
    {
    }
}
