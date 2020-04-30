// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.utils;

import java.util.List;

// Referenced classes of package com.inponsel.android.utils:
//            JellyBeanSpanFixTextView

private static class spansWithSpacesAfter
{

    public final boolean fixed;
    public final List spansWithSpacesAfter;
    public final List spansWithSpacesBefore;

    public static spansWithSpacesAfter fixed(List list, List list1)
    {
        return new <init>(true, list, list1);
    }

    public static <init> notFixed()
    {
        return new <init>(false, null, null);
    }

    private (boolean flag, List list, List list1)
    {
        fixed = flag;
        spansWithSpacesBefore = list;
        spansWithSpacesAfter = list1;
    }
}
