// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.os.AsyncTask;
import android.view.View;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;

// Referenced classes of package com.inponsel.android.details:
//            KomentarTwitter

class this._cls0
    implements android.view.r
{

    final KomentarTwitter this$0;

    public void onClick(View view)
    {
        try
        {
            limit = 0;
            urlKomenTwLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_last_tw").append(Utility.BASE_FORMAT).append("?id_tw=").append(id_tw).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&id_usr=").append(user_id).toString();
            Log.e("urlKomenTwLast", urlKomenTwLast);
            if (android.os.NT >= 11)
            {
                (new entarNextAsycTask(KomentarTwitter.this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            return;
        }
        (new entarNextAsycTask(KomentarTwitter.this)).execute(new String[0]);
        return;
    }

    entarNextAsycTask()
    {
        this$0 = KomentarTwitter.this;
        super();
    }
}
