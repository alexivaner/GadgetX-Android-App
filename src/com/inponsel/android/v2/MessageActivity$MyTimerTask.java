// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.net.NetworkInfo;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Utility;
import java.util.ArrayList;
import java.util.TimerTask;

// Referenced classes of package com.inponsel.android.v2:
//            MessageActivity

class this._cls0 extends TimerTask
{

    final MessageActivity this$0;

    public void run()
    {
        Log.e("timertask", "running");
        runOnUiThread(new Runnable() {

            final MessageActivity.MyTimerTask this$1;

            public void run()
            {
label0:
                {
                    MessageActivity messageactivity = this$0;
                    messageactivity.countRefresh = messageactivity.countRefresh + 1;
                    Log.e("update_msgread", "ok");
                    db.update_msgread(from_name);
                    if (netInfo != null && netInfo.isConnected())
                    {
                        try
                        {
                            Utility.removeMSGNotif(getApplicationContext(), Integer.parseInt(id_to));
                        }
                        catch (NumberFormatException numberformatexception)
                        {
                            numberformatexception.printStackTrace();
                        }
                        catch (Exception exception)
                        {
                            exception.printStackTrace();
                        }
                        if (listpMessageArrayList.size() != 0)
                        {
                            break label0;
                        }
                        MessageActivity.access$3(this$0, id_from, id_to, t);
                    }
                    return;
                }
                MessageActivity.access$4(this$0, id_from, id_to, t, bottom_id);
            }

            
            {
                this$1 = MessageActivity.MyTimerTask.this;
                super();
            }
        });
    }


    _cls1.this._cls1()
    {
        this$0 = MessageActivity.this;
        super();
    }
}
