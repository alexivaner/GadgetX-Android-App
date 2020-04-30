// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.os.AsyncTask;
import android.view.View;
import android.widget.TextView;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;

// Referenced classes of package com.inponsel.android.v2:
//            PlaystoreKategoriKomen

class this._cls1
    implements android.view.terTask._cls10
{

    final te this$1;

    public void onClick(View view)
    {
        try
        {
            ess._mth2(this._cls1.this).txtbtnheader.setVisibility(8);
            view = ess._mth2(this._cls1.this);
            view.limit = ((PlaystoreKategoriKomen) (view)).limit + 15;
            ess._mth2(this._cls1.this).urlKomenOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_playkat").append(Utility.BASE_FORMAT).append("?id_kat=").append(ess._mth2(this._cls1.this).id_kat).append("&top_id=").append(ess._mth2(this._cls1.this).top_id).append("&t=").append(ess._mth2(this._cls1.this).t).append("&id_usr=").append(ess._mth2(this._cls1.this).user_id).append("&sortkom=").append(ess._mth2(this._cls1.this).sortkom).toString();
            Log.e("urlKomenOld", ess._mth2(this._cls1.this).urlKomenOld);
            if (android.os.AfterTask >= 11)
            {
                (new >(ess._mth2(this._cls1.this))).teOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            return;
        }
        (new >(ess._mth2(this._cls1.this))).te(new String[0]);
        return;
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
