// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import com.inponsel.android.utils.Log;

// Referenced classes of package com.inponsel.android.v2:
//            RoomPostBenchmark

class this._cls0
    implements android.content.ickListener
{

    final RoomPostBenchmark this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        RoomPostBenchmark.access$8(RoomPostBenchmark.this, RoomPostBenchmark.access$7(RoomPostBenchmark.this));
        RoomPostBenchmark.access$8(RoomPostBenchmark.this, RoomPostBenchmark.access$9(RoomPostBenchmark.this));
        if (i == 0)
        {
            RoomPostBenchmark.access$10(RoomPostBenchmark.this);
        } else
        {
            RoomPostBenchmark.access$11(RoomPostBenchmark.this);
        }
        Log.e("startActivityForResult", String.valueOf(-1));
    }

    ner()
    {
        this$0 = RoomPostBenchmark.this;
        super();
    }
}
