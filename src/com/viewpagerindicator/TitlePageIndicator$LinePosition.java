// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.viewpagerindicator;


// Referenced classes of package com.viewpagerindicator:
//            TitlePageIndicator

public static final class value extends Enum
{

    public static final Top Bottom;
    private static final Top ENUM$VALUES[];
    public static final Top Top;
    public final int value;

    public static value fromValue(int i)
    {
        value avalue[];
        int j;
        int k;
        avalue = values();
        k = avalue.length;
        j = 0;
_L6:
        if (j < k) goto _L2; else goto _L1
_L1:
        value value1 = null;
_L4:
        return value1;
_L2:
        value value2;
        value2 = avalue[j];
        value1 = value2;
        if (value2.value == i) goto _L4; else goto _L3
_L3:
        j++;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static value valueOf(String s)
    {
        return (value)Enum.valueOf(com/viewpagerindicator/TitlePageIndicator$LinePosition, s);
    }

    public static value[] values()
    {
        value avalue[] = ENUM$VALUES;
        int i = avalue.length;
        value avalue1[] = new ENUM.VALUES[i];
        System.arraycopy(avalue, 0, avalue1, 0, i);
        return avalue1;
    }

    static 
    {
        Bottom = new <init>("Bottom", 0, 0);
        Top = new <init>("Top", 1, 1);
        ENUM$VALUES = (new ENUM.VALUES[] {
            Bottom, Top
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        value = j;
    }
}
