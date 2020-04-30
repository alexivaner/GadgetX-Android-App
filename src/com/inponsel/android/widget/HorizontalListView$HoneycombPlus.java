// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.widget;

import android.widget.Scroller;

// Referenced classes of package com.inponsel.android.widget:
//            HorizontalListView

private static final class 
{

    public static void setFriction(Scroller scroller, float f)
    {
        if (scroller != null)
        {
            scroller.setFriction(f);
        }
    }

    static 
    {
        if (android.os.ew.HoneycombPlus < 11)
        {
            throw new RuntimeException("Should not get to HoneycombPlus class unless sdk is >= 11!");
        }
    }

    private ()
    {
    }
}
