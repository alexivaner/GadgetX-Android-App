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

class this._cls1
    implements android.view.arNewAsycTask._cls9
{

    final xecute this$1;

    public void onClick(View view)
    {
        try
        {
            cess._mth2(this._cls1.this).limit = 0;
            cess._mth2(this._cls1.this).urlKomenTwLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_last_tw").append(Utility.BASE_FORMAT).append("?id_tw=").append(cess._mth2(this._cls1.this).id_tw).append("&bottom_id=").append(cess._mth2(this._cls1.this).bottom_id).append("&t=").append(cess._mth2(this._cls1.this).t).append("&id_usr=").append(cess._mth2(this._cls1.this).user_id).toString();
            Log.e("urlKomenTwLast", cess._mth2(this._cls1.this).urlKomenTwLast);
            if (android.os.omenTwLast >= 11)
            {
                (new init>(cess._mth2(this._cls1.this))).xecuteOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            return;
        }
        (new init>(cess._mth2(this._cls1.this))).xecute(new String[0]);
        return;
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
