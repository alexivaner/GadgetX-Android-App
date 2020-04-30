// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import com.inponsel.android.utils.Log;

// Referenced classes of package com.inponsel.android.v2:
//            RoomPostPertanyaan

class this._cls0
    implements android.content.ckListener
{

    final RoomPostPertanyaan this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        RoomPostPertanyaan.access$4(RoomPostPertanyaan.this, RoomPostPertanyaan.access$3(RoomPostPertanyaan.this));
        RoomPostPertanyaan.access$4(RoomPostPertanyaan.this, RoomPostPertanyaan.access$5(RoomPostPertanyaan.this));
        if (i == 0)
        {
            RoomPostPertanyaan.access$6(RoomPostPertanyaan.this);
        } else
        {
            RoomPostPertanyaan.access$7(RoomPostPertanyaan.this);
        }
        Log.e("startActivityForResult", String.valueOf(-1));
    }

    er()
    {
        this$0 = RoomPostPertanyaan.this;
        super();
    }
}
