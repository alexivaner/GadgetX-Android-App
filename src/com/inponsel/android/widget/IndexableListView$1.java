// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.widget;

import android.view.MotionEvent;

// Referenced classes of package com.inponsel.android.widget:
//            IndexableListView, IndexScroller

class ener extends android.view.leOnGestureListener
{

    final IndexableListView this$0;

    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        IndexableListView.access$0(IndexableListView.this).show();
        return super.onFling(motionevent, motionevent1, f, f1);
    }

    ener()
    {
        this$0 = IndexableListView.this;
        super();
    }
}
