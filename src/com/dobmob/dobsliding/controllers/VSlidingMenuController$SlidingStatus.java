// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dobmob.dobsliding.controllers;


// Referenced classes of package com.dobmob.dobsliding.controllers:
//            VSlidingMenuController

public static final class  extends Enum
{

    public static final ANIMATING ANIMATING;
    public static final ANIMATING COLLAPSED;
    private static final ANIMATING ENUM$VALUES[];
    public static final ANIMATING EXPANDED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/dobmob/dobsliding/controllers/VSlidingMenuController$SlidingStatus, s);
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
        COLLAPSED = new <init>("COLLAPSED", 0);
        EXPANDED = new <init>("EXPANDED", 1);
        ANIMATING = new <init>("ANIMATING", 2);
        ENUM$VALUES = (new ENUM.VALUES[] {
            COLLAPSED, EXPANDED, ANIMATING
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
