// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dobmob.dobsliding.animations;


// Referenced classes of package com.dobmob.dobsliding.animations:
//            AnimationExecutor

public static final class  extends Enum
{

    public static final BOTTOM_TO_TOP BOTTOM_TO_TOP;
    private static final BOTTOM_TO_TOP ENUM$VALUES[];
    public static final BOTTOM_TO_TOP TOP_TO_BOTTOM;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/dobmob/dobsliding/animations/AnimationExecutor$MovingType, s);
    }

    public static [] values()
    {
         a[] = ENUM$VALUES;
        int i = a.length;
         a1[] = new ENUM.VALUES[i];
        System.arraycopy(a, 0, a1, 0, i);
        return a1;
    }

    static 
    {
        TOP_TO_BOTTOM = new <init>("TOP_TO_BOTTOM", 0);
        BOTTOM_TO_TOP = new <init>("BOTTOM_TO_TOP", 1);
        ENUM$VALUES = (new ENUM.VALUES[] {
            TOP_TO_BOTTOM, BOTTOM_TO_TOP
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
