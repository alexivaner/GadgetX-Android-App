// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.widget;

import android.database.DataSetObserver;

// Referenced classes of package com.inponsel.android.widget:
//            HorizontalListView

class this._cls0 extends DataSetObserver
{

    final HorizontalListView this$0;

    public void onChanged()
    {
        HorizontalListView.access$2(HorizontalListView.this, true);
        HorizontalListView.access$3(HorizontalListView.this, false);
        HorizontalListView.access$4(HorizontalListView.this);
        invalidate();
        requestLayout();
    }

    public void onInvalidated()
    {
        HorizontalListView.access$3(HorizontalListView.this, false);
        HorizontalListView.access$4(HorizontalListView.this);
        HorizontalListView.access$5(HorizontalListView.this);
        invalidate();
        requestLayout();
    }

    ()
    {
        this$0 = HorizontalListView.this;
        super();
    }
}
