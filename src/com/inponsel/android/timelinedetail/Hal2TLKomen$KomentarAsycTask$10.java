// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.timelinedetail;

import android.os.AsyncTask;
import android.view.View;
import android.widget.TextView;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;

// Referenced classes of package com.inponsel.android.timelinedetail:
//            Hal2TLKomen

class this._cls1
    implements android.view.en.KomentarAsycTask._cls10
{

    final execute this$1;

    public void onClick(View view)
    {
        try
        {
            ess._mth2(this._cls1.this).txtbtnheader.setVisibility(8);
            view = ess._mth2(this._cls1.this);
            view.limit = ((Hal2TLKomen) (view)).limit + 15;
            ess._mth2(this._cls1.this).urlKomenOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_forum").append(Utility.BASE_FORMAT).append("?id=").append(ess._mth2(this._cls1.this).tl_id).append("&top_id=").append(ess._mth2(this._cls1.this).top_id).append("&t=").append(ess._mth2(this._cls1.this).t).append("&id_usr=").append(ess._mth2(this._cls1.this).user_id).append("&sortkom=").append(ess._mth2(this._cls1.this).sortkom).toString();
            Log.e("urlKomenOld", ess._mth2(this._cls1.this).urlKomenOld);
            if (android.os.omen.urlKomenOld >= 11)
            {
                (new <init>(ess._mth2(this._cls1.this))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            return;
        }
        (new <init>(ess._mth2(this._cls1.this))).execute(new String[0]);
        return;
    }

    I()
    {
        this$1 = this._cls1.this;
        super();
    }
}
