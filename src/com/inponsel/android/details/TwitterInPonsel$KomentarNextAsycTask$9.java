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
//            TwitterInPonsel

class this._cls1
    implements android.view.rNextAsycTask._cls9
{

    final ecute this$1;

    public void onClick(View view)
    {
        try
        {
            cess._mth2(this._cls1.this).txtbtnheader.setVisibility(8);
            cess._mth2(this._cls1.this).limit = 0;
            cess._mth2(this._cls1.this).urlKomenLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("vendor_twitter").append(Utility.BASE_FORMAT).append("?screen_name=").append(cess._mth2(this._cls1.this).twitter).append("&since_id=").append(cess._mth2(this._cls1.this).top_id).append("&t=").append(cess._mth2(this._cls1.this).t).append("&idusr=").append(cess._mth2(this._cls1.this).user_id).toString();
            Log.e("urlKomenLast", cess._mth2(this._cls1.this).urlKomenLast);
            if (android.os.menLast >= 11)
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

    I()
    {
        this$1 = this._cls1.this;
        super();
    }
}
