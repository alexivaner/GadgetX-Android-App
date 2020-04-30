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
//            KomentarBaruLainPonsel

class this._cls1
    implements android.view.AsycTask._cls6
{

    final k.execute this$1;

    public void onClick(View view)
    {
        try
        {
            cess._mth2(this._cls1.this).txtbtnheader.setVisibility(8);
            view = cess._mth2(this._cls1.this);
            view.limit = ((KomentarBaruLainPonsel) (view)).limit + 15;
            cess._mth2(this._cls1.this).urlKomenLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("interaksi_perangkat").append(Utility.BASE_FORMAT).append("?lmt=").append(cess._mth2(this._cls1.this).limit).append("&t=").append(cess._mth2(this._cls1.this).t).append("&idusr=").append(cess._mth2(this._cls1.this).str_id_user).append("&top_id=").append(cess._mth2(this._cls1.this).top_id).toString();
            Log.e("urlKomenLast", cess._mth2(this._cls1.this).urlKomenLast);
            if (android.os.enLast >= 11)
            {
                (new k(cess._mth2(this._cls1.this))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            return;
        }
        (new k(cess._mth2(this._cls1.this))).execute(new String[0]);
        return;
    }

    k()
    {
        this$1 = this._cls1.this;
        super();
    }
}
