// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.scdetail;

import android.os.AsyncTask;
import android.view.View;
import android.widget.TextView;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;

// Referenced classes of package com.inponsel.android.scdetail:
//            Hal2Komen

class this._cls1
    implements android.view.rReplyAsycTask._cls5
{

    final ute this$1;

    public void onClick(View view)
    {
        cess._mth2(this._cls1.this).txtbtnheader.setVisibility(8);
        view = cess._mth2(this._cls1.this);
        view.limit = ((Hal2Komen) (view)).limit + 15;
        if (!cess._mth2(this._cls1.this).komen_type.equals("katapps"))
        {
            break MISSING_BLOCK_LABEL_228;
        }
        cess._mth2(this._cls1.this).urlKomenOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_katapps").append(Utility.BASE_FORMAT).append("?idkat=").append(cess._mth2(this._cls1.this).sc_id).append("&top_id=").append(cess._mth2(this._cls1.this).top_id).append("&t=").append(cess._mth2(this._cls1.this).t).append("&id_usr=").append(cess._mth2(this._cls1.this).user_id).append("&sortkom=").append(cess._mth2(this._cls1.this).sortkom).toString();
_L1:
        Log.e("urlKomenOld", cess._mth2(this._cls1.this).urlKomenOld);
        if (android.os.menOld >= 11)
        {
            (new t>(cess._mth2(this._cls1.this))).uteOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
            return;
        }
        break MISSING_BLOCK_LABEL_358;
        try
        {
            cess._mth2(this._cls1.this).urlKomenOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_sc").append(Utility.BASE_FORMAT).append("?idsc=").append(cess._mth2(this._cls1.this).sc_id).append("&top_id=").append(cess._mth2(this._cls1.this).top_id).append("&t=").append(cess._mth2(this._cls1.this).t).append("&id_usr=").append(cess._mth2(this._cls1.this).user_id).append("&sortkom=").append(cess._mth2(this._cls1.this).sortkom).toString();
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            return;
        }
          goto _L1
        (new t>(cess._mth2(this._cls1.this))).ute(new String[0]);
        return;
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
