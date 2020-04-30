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

class this._cls1
    implements android.view.er.PostKomen._cls11
{

    final ycTask.execute this$1;

    public void onClick(View view)
    {
        try
        {
            ess._mth2(this._cls1.this).txtbtnheader.setVisibility(8);
            ess._mth2(this._cls1.this).limit = 0;
            ess._mth2(this._cls1.this).urlKomenTwOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_old_tw").append(Utility.BASE_FORMAT).append("?id_tw=").append(ess._mth2(this._cls1.this).id_tw).append("&top_id=").append(ess._mth2(this._cls1.this).top_id).append("&t=").append(ess._mth2(this._cls1.this).t).append("&id_usr=").append(ess._mth2(this._cls1.this).user_id).toString();
            Log.e("urlKomenTwOld", ess._mth2(this._cls1.this).urlKomenTwOld);
            if (android.os.tter.urlKomenTwOld >= 11)
            {
                (new ycTask(ess._mth2(this._cls1.this))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            return;
        }
        (new ycTask(ess._mth2(this._cls1.this))).execute(new String[0]);
        return;
    }

    ycTask()
    {
        this$1 = this._cls1.this;
        super();
    }
}
