// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.widget.TextView;
import com.inponsel.android.utils.UserFunctions;

// Referenced classes of package com.inponsel.android.v2:
//            ProfileOtherUser

class this._cls0
    implements Runnable
{

    final ProfileOtherUser this$0;

    public void run()
    {
label0:
        {
            if (userFunctions.isUserLoggedIn(getApplicationContext()))
            {
                if (!user_id.equals(str_id_user))
                {
                    break label0;
                }
                txt_pmesssage.setText("Pesan Masuk");
            }
            return;
        }
        txt_pmesssage.setText("Kirim Pesan");
    }

    ()
    {
        this$0 = ProfileOtherUser.this;
        super();
    }
}
