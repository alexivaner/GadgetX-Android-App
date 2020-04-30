// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.scdetail;

import android.os.AsyncTask;
import android.text.Editable;
import android.view.View;
import com.inponsel.android.utils.Log;
import com.inponsel.android.widget.DroidWriterEditText;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

// Referenced classes of package com.inponsel.android.scdetail:
//            Hal1SCDetail

class this._cls0
    implements android.view.tener
{

    final Hal1SCDetail this$0;

    public void onClick(View view)
    {
        try
        {
            view = URLEncoder.encode(edt_pop_komen.getText().toString(), "utf-8");
            Log.e("top_id", "0");
            querypopkomensc = (new StringBuilder("idsc=")).append(str_SC_ID).append("&idusr=").append(user_id).append("&kom=").append(view).append("&rplto=").append("0").append("&top_id=").append(top_id).append("&t=").append(t).toString();
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            view.printStackTrace();
        }
        if (android.os.DK_INT >= 11)
        {
            (new stKomenSC(Hal1SCDetail.this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            (new stKomenSC(Hal1SCDetail.this)).execute(new Void[0]);
            return;
        }
    }

    stKomenSC()
    {
        this$0 = Hal1SCDetail.this;
        super();
    }
}
