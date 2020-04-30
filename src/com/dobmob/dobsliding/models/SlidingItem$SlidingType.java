// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dobmob.dobsliding.models;


// Referenced classes of package com.dobmob.dobsliding.models:
//            SlidingItem

public static final class  extends Enum
{

    private static final MOVE ENUM$VALUES[];
    public static final MOVE MOVE;
    public static final MOVE SIZE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/dobmob/dobsliding/models/SlidingItem$SlidingType, s);
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
        SIZE = new <init>("SIZE", 0);
        MOVE = new <init>("MOVE", 1);
        ENUM$VALUES = (new ENUM.VALUES[] {
            SIZE, MOVE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
