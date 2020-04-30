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
//            TwitterListInPonsel

class this._cls1
    implements android.view.rOldAsycTask._cls11
{

    final ecute this$1;

    public void onClick(View view)
    {
        try
        {
            ess._mth2(this._cls1.this).txtbtnheader.setVisibility(8);
            ess._mth2(this._cls1.this).limit = 0;
            ess._mth2(this._cls1.this).urlKomenLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("vendor_twitter_list").append(Utility.BASE_FORMAT).append("?slug=").append(ess._mth2(this._cls1.this).listtwitter).append("&screen_name=").append(ess._mth2(this._cls1.this).twitter).append("&since_id=").append(ess._mth2(this._cls1.this).top_id).append("&t=").append(ess._mth2(this._cls1.this).t).append("&idusr=").append(ess._mth2(this._cls1.this).user_id).toString();
            Log.e("urlKomenLast", ess._mth2(this._cls1.this).urlKomenLast);
            if (android.os.menLast >= 11)
            {
                (new nit>(ess._mth2(this._cls1.this))).ecuteOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            return;
        }
        (new nit>(ess._mth2(this._cls1.this))).ecute(new String[0]);
        return;
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
