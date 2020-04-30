// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.widget;


// Referenced classes of package com.inponsel.android.widget:
//            HorizontalListView

public static final class  extends Enum
{

    private static final SCROLL_STATE_FLING ENUM$VALUES[];
    public static final SCROLL_STATE_FLING SCROLL_STATE_FLING;
    public static final SCROLL_STATE_FLING SCROLL_STATE_IDLE;
    public static final SCROLL_STATE_FLING SCROLL_STATE_TOUCH_SCROLL;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/inponsel/android/widget/HorizontalListView$OnScrollStateChangedListener$ScrollState, s);
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
        SCROLL_STATE_IDLE = new <init>("SCROLL_STATE_IDLE", 0);
        SCROLL_STATE_TOUCH_SCROLL = new <init>("SCROLL_STATE_TOUCH_SCROLL", 1);
        SCROLL_STATE_FLING = new <init>("SCROLL_STATE_FLING", 2);
        ENUM$VALUES = (new ENUM.VALUES[] {
            SCROLL_STATE_IDLE, SCROLL_STATE_TOUCH_SCROLL, SCROLL_STATE_FLING
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
