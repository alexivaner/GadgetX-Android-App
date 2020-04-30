// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.widget;


// Referenced classes of package com.inponsel.android.widget:
//            HorizontalListView

public static interface ScrollState
{
    public static final class ScrollState extends Enum
    {

        private static final ScrollState ENUM$VALUES[];
        public static final ScrollState SCROLL_STATE_FLING;
        public static final ScrollState SCROLL_STATE_IDLE;
        public static final ScrollState SCROLL_STATE_TOUCH_SCROLL;

        public static ScrollState valueOf(String s)
        {
            return (ScrollState)Enum.valueOf(com/inponsel/android/widget/HorizontalListView$OnScrollStateChangedListener$ScrollState, s);
        }

        public static ScrollState[] values()
        {
            ScrollState ascrollstate[] = ENUM$VALUES;
            int i = ascrollstate.length;
            ScrollState ascrollstate1[] = new ScrollState[i];
            System.arraycopy(ascrollstate, 0, ascrollstate1, 0, i);
            return ascrollstate1;
        }

        static 
        {
            SCROLL_STATE_IDLE = new ScrollState("SCROLL_STATE_IDLE", 0);
            SCROLL_STATE_TOUCH_SCROLL = new ScrollState("SCROLL_STATE_TOUCH_SCROLL", 1);
            SCROLL_STATE_FLING = new ScrollState("SCROLL_STATE_FLING", 2);
            ENUM$VALUES = (new ScrollState[] {
                SCROLL_STATE_IDLE, SCROLL_STATE_TOUCH_SCROLL, SCROLL_STATE_FLING
            });
        }

        private ScrollState(String s, int i)
        {
            super(s, i);
        }
    }


    public abstract void onScrollStateChanged(ScrollState scrollstate);
}
