// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.widget;

import android.os.Handler;
import android.os.Message;
import android.widget.ListView;

// Referenced classes of package com.inponsel.android.widget:
//            IndexScroller

class this._cls0 extends Handler
{

    final IndexScroller this$0;

    public void handleMessage(Message message)
    {
        super.handleMessage(message);
        switch (IndexScroller.access$0(IndexScroller.this))
        {
        case 2: // '\002'
        default:
            return;

        case 1: // '\001'
            message = IndexScroller.this;
            IndexScroller.access$2(message, (float)((double)IndexScroller.access$1(message) + (double)(1.0F - IndexScroller.access$1(IndexScroller.this)) * 0.20000000000000001D));
            if ((double)IndexScroller.access$1(IndexScroller.this) > 0.90000000000000002D)
            {
                IndexScroller.access$2(IndexScroller.this, 1.0F);
                IndexScroller.access$3(IndexScroller.this, 2);
            }
            IndexScroller.access$4(IndexScroller.this).invalidate();
            IndexScroller.access$5(IndexScroller.this, 10L);
            return;

        case 3: // '\003'
            message = IndexScroller.this;
            IndexScroller.access$2(message, (float)((double)IndexScroller.access$1(message) - (double)IndexScroller.access$1(IndexScroller.this) * 0.20000000000000001D));
            break;
        }
        if ((double)IndexScroller.access$1(IndexScroller.this) < 0.10000000000000001D)
        {
            IndexScroller.access$2(IndexScroller.this, 0.0F);
        }
        IndexScroller.access$4(IndexScroller.this).invalidate();
        IndexScroller.access$5(IndexScroller.this, 10L);
    }

    ()
    {
        this$0 = IndexScroller.this;
        super();
    }
}
