// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.net.NetworkInfo;
import com.inponsel.android.utils.Utility;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.v2:
//            RoomChatActivity

class this._cls1
    implements Runnable
{

    final this._cls1 this$1;

    public void run()
    {
label0:
        {
            RoomChatActivity roomchatactivity = cess._mth0(this._cls1.this);
            roomchatactivity.countRefresh = roomchatactivity.countRefresh + 1;
            if (cess._mth0(this._cls1.this).netInfo != null && cess._mth0(this._cls1.this).netInfo.isConnected())
            {
                Utility.removeMSGNotif(cess._mth0(this._cls1.this).getApplicationContext(), Integer.parseInt((new StringBuilder("-")).append(cess._mth0(this._cls1.this).id_hp).toString()));
                if (cess._mth0(this._cls1.this).listpMessageArrayList.size() != 0)
                {
                    break label0;
                }
                RoomChatActivity.access$6(cess._mth0(this._cls1.this), cess._mth0(this._cls1.this).id_from, cess._mth0(this._cls1.this).codename, cess._mth0(this._cls1.this).t);
                RoomChatActivity.access$7(cess._mth0(this._cls1.this), cess._mth0(this._cls1.this).codename, cess._mth0(this._cls1.this).t);
            }
            return;
        }
        RoomChatActivity.access$7(cess._mth0(this._cls1.this), cess._mth0(this._cls1.this).codename, cess._mth0(this._cls1.this).t);
        RoomChatActivity.access$8(cess._mth0(this._cls1.this), cess._mth0(this._cls1.this).id_from, cess._mth0(this._cls1.this).codename, cess._mth0(this._cls1.this).t, cess._mth0(this._cls1.this).bottom_id);
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
