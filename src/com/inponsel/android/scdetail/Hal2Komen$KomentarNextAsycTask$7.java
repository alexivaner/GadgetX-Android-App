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
//            Hal2Komen

class this._cls1
    implements android.view.arNextAsycTask._cls7
{

    final this._cls1 this$1;

    public void onClick(View view)
    {
        try
        {
            view = URLEncoder.encode(cess._mth2(this._cls1.this).edt_pop_komen.getText().toString(), "utf-8");
            Log.e("top_id", cess._mth2(this._cls1.this).top_id);
            cess._mth2(this._cls1.this).querypopkomen = (new StringBuilder("rplto=0&kom=")).append(view).append("&idsc=").append(cess._mth2(this._cls1.this).sc_id).append("&top_id=").append(cess._mth2(this._cls1.this).top_id).append("&t=").append(cess._mth2(this._cls1.this).t).append("&idusr=").append(cess._mth2(this._cls1.this).user_id).toString();
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            view.printStackTrace();
        }
        if (android.os.ackTrace >= 11)
        {
            (new this._cls1(cess._mth2(this._cls1.this))).utor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            (new utor(cess._mth2(this._cls1.this)))._mth1(new Void[0]);
            return;
        }
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
