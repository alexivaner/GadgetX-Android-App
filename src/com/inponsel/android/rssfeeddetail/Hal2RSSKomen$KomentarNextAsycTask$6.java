// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.rssfeeddetail;

import android.os.AsyncTask;
import android.view.View;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;

// Referenced classes of package com.inponsel.android.rssfeeddetail:
//            Hal2RSSKomen

class this._cls1
    implements android.view.omentarNextAsycTask._cls6
{

    final ecute this$1;

    public void onClick(View view)
    {
        try
        {
            cess._mth2(this._cls1.this).limit = 0;
            cess._mth2(this._cls1.this).urlKomenLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_rss_rev").append(Utility.BASE_FORMAT).append("?id_rss=").append(cess._mth2(this._cls1.this).id_rss).append("&bottom_id=").append(cess._mth2(this._cls1.this).bottom_id).append("&t=").append(cess._mth2(this._cls1.this).t).append("&id_usr=").append(cess._mth2(this._cls1.this).user_id).append("&sortkom=").append(cess._mth2(this._cls1.this).sortkom).toString();
            Log.e("urlKomenLast", cess._mth2(this._cls1.this).urlKomenLast);
            if (android.os..urlKomenLast >= 11)
            {
                (new nit>(cess._mth2(this._cls1.this))).ecuteOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            return;
        }
        (new nit>(cess._mth2(this._cls1.this))).ecute(new String[0]);
        return;
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
