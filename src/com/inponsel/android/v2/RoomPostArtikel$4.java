// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import com.inponsel.android.utils.Log;

// Referenced classes of package com.inponsel.android.v2:
//            RoomPostArtikel

class this._cls0
    implements android.content.ClickListener
{

    final RoomPostArtikel this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        RoomPostArtikel.access$4(RoomPostArtikel.this, RoomPostArtikel.access$3(RoomPostArtikel.this));
        RoomPostArtikel.access$4(RoomPostArtikel.this, RoomPostArtikel.access$5(RoomPostArtikel.this));
        if (i == 0)
        {
            RoomPostArtikel.access$6(RoomPostArtikel.this);
        } else
        {
            RoomPostArtikel.access$7(RoomPostArtikel.this);
        }
        Log.e("startActivityForResult", String.valueOf(-1));
    }

    tener()
    {
        this$0 = RoomPostArtikel.this;
        super();
    }
}
