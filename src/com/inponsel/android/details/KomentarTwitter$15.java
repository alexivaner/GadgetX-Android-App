// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.os.AsyncTask;
import android.view.View;
import android.widget.TextView;
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
            txtbtnheader.setVisibility(8);
            limit = 0;
            urlKomenTwOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_old_tw").append(Utility.BASE_FORMAT).append("?id_tw=").append(id_tw).append("&top_id=").append(top_id).append("&t=").append(t).append("&id_usr=").append(user_id).toString();
            Log.e("urlKomenTwOld", urlKomenTwOld);
            if (android.os.NT >= 11)
            {
                (new entarNewAsycTask(KomentarTwitter.this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            return;
        }
        (new entarNewAsycTask(KomentarTwitter.this)).execute(new String[0]);
        return;
    }

    entarNewAsycTask()
    {
        this$0 = KomentarTwitter.this;
        super();
    }
}
