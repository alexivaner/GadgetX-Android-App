// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.os.AsyncTask;
import android.view.View;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;

// Referenced classes of package com.inponsel.android.v2:
//            KomentarBaruLainPonsel

class this._cls1
    implements android.view.AsycTask._cls7
{

    final .execute this$1;

    public void onClick(View view)
    {
        try
        {
            view = cess._mth2(this._cls1.this);
            view.counterLoad = ((KomentarBaruLainPonsel) (view)).counterLoad + 1;
            cess._mth2(this._cls1.this).limit = 0;
            cess._mth2(this._cls1.this).urlKomenOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("interaksi_perangkat").append(Utility.BASE_FORMAT).append("?lmt=").append(cess._mth2(this._cls1.this).limit).append("&t=").append(cess._mth2(this._cls1.this).t).append("&idusr=").append(cess._mth2(this._cls1.this).str_id_user).append("&bottom_id=").append(cess._mth2(this._cls1.this).bottom_id).toString();
            Log.e("urlKomenOld", cess._mth2(this._cls1.this).urlKomenOld);
            if (android.os.enOld >= 11)
            {
                (new (cess._mth2(this._cls1.this))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            return;
        }
        (new (cess._mth2(this._cls1.this))).execute(new String[0]);
        return;
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
