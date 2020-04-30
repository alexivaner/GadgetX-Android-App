// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.adapter;


// Referenced classes of package com.inponsel.android.adapter:
//            PonselBaseApp

public static final class  extends Enum
{

    public static final ECOMMERCE_TRACKER APP_TRACKER;
    public static final ECOMMERCE_TRACKER ECOMMERCE_TRACKER;
    private static final ECOMMERCE_TRACKER ENUM$VALUES[];
    public static final ECOMMERCE_TRACKER GLOBAL_TRACKER;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/inponsel/android/adapter/PonselBaseApp$TrackerName, s);
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
        APP_TRACKER = new <init>("APP_TRACKER", 0);
        GLOBAL_TRACKER = new <init>("GLOBAL_TRACKER", 1);
        ECOMMERCE_TRACKER = new <init>("ECOMMERCE_TRACKER", 2);
        ENUM$VALUES = (new ENUM.VALUES[] {
            APP_TRACKER, GLOBAL_TRACKER, ECOMMERCE_TRACKER
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
