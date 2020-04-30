// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.net.NetworkInfo;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Utility;
import java.util.ArrayList;
import java.util.TimerTask;

// Referenced classes of package com.inponsel.android.v2:
//            RoomChatActivity

class this._cls0 extends TimerTask
{

    final RoomChatActivity this$0;

    public void run()
    {
        Log.e("timertask", "running");
        runOnUiThread(new Runnable() {

            final RoomChatActivity.MyTimerTask this$1;

            public void run()
            {
label0:
                {
                    RoomChatActivity roomchatactivity = this$0;
                    roomchatactivity.countRefresh = roomchatactivity.countRefresh + 1;
                    if (netInfo != null && netInfo.isConnected())
                    {
                        Utility.removeMSGNotif(getApplicationContext(), Integer.parseInt((new StringBuilder("-")).append(id_hp).toString()));
                        if (listpMessageArrayList.size() != 0)
                        {
                            break label0;
                        }
                        RoomChatActivity.access$6(this$0, id_from, codename, t);
                        RoomChatActivity.access$7(this$0, codename, t);
                    }
                    return;
                }
                RoomChatActivity.access$7(this$0, codename, t);
                RoomChatActivity.access$8(this$0, id_from, codename, t, bottom_id);
            }

            
            {
                this$1 = RoomChatActivity.MyTimerTask.this;
                super();
            }
        });
    }


    _cls1.this._cls1()
    {
        this$0 = RoomChatActivity.this;
        super();
    }
}
