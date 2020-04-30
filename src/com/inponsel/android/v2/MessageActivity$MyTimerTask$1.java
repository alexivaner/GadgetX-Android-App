// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.net.NetworkInfo;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Utility;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.v2:
//            MessageActivity

class this._cls1
    implements Runnable
{

    final this._cls1 this$1;

    public void run()
    {
label0:
        {
            MessageActivity messageactivity = cess._mth0(this._cls1.this);
            messageactivity.countRefresh = messageactivity.countRefresh + 1;
            Log.e("update_msgread", "ok");
            cess._mth0(this._cls1.this).db.update_msgread(cess._mth0(this._cls1.this).from_name);
            if (cess._mth0(this._cls1.this).netInfo != null && cess._mth0(this._cls1.this).netInfo.isConnected())
            {
                try
                {
                    Utility.removeMSGNotif(cess._mth0(this._cls1.this).getApplicationContext(), Integer.parseInt(cess._mth0(this._cls1.this).id_to));
                }
                catch (NumberFormatException numberformatexception)
                {
                    numberformatexception.printStackTrace();
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                }
                if (cess._mth0(this._cls1.this).listpMessageArrayList.size() != 0)
                {
                    break label0;
                }
                MessageActivity.access$3(cess._mth0(this._cls1.this), cess._mth0(this._cls1.this).id_from, cess._mth0(this._cls1.this).id_to, cess._mth0(this._cls1.this).t);
            }
            return;
        }
        MessageActivity.access$4(cess._mth0(this._cls1.this), cess._mth0(this._cls1.this).id_from, cess._mth0(this._cls1.this).id_to, cess._mth0(this._cls1.this).t, cess._mth0(this._cls1.this).bottom_id);
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
