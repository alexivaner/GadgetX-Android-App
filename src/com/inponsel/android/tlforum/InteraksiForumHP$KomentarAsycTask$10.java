// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.tlforum;

import android.os.AsyncTask;
import android.view.View;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;

// Referenced classes of package com.inponsel.android.tlforum:
//            InteraksiForumHP

class this._cls1
    implements android.view.ntarAsycTask._cls10
{

    final .execute this$1;

    public void onClick(View view)
    {
        try
        {
            ess._mth2(this._cls1.this).limit = 0;
            ess._mth2(this._cls1.this).urlKomenLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("timeline_interaksi_hp").append(Utility.BASE_FORMAT).append("?id_hp=").append(ess._mth2(this._cls1.this).id_hp).append("&code=").append(ess._mth2(this._cls1.this).codename).append("&bottom_id=").append(ess._mth2(this._cls1.this).bottom_id).append("&t=").append(ess._mth2(this._cls1.this).t).append("&id_usr=").append(ess._mth2(this._cls1.this).user_id).append("&sortkom=").append(ess._mth2(this._cls1.this).sortkom).toString();
            Log.e("urlKomenLast", ess._mth2(this._cls1.this).urlKomenLast);
            if (android.os.lKomenLast >= 11)
            {
                (new (ess._mth2(this._cls1.this))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            return;
        }
        (new (ess._mth2(this._cls1.this))).execute(new String[0]);
        return;
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
