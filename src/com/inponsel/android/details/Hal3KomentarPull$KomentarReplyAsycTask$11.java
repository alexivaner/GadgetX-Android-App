// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.os.AsyncTask;
import android.text.Editable;
import android.view.View;
import com.inponsel.android.utils.Log;
import com.inponsel.android.widget.DroidWriterEditText;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

// Referenced classes of package com.inponsel.android.details:
//            Hal3KomentarPull

class this._cls1
    implements android.view.eplyAsycTask._cls11
{

    final this._cls1 this$1;

    public void onClick(View view)
    {
        try
        {
            view = URLEncoder.encode(ess._mth2(this._cls1.this).edt_pop_komen.getText().toString(), "utf-8");
            Log.e("top_id", ess._mth2(this._cls1.this).top_id);
            ess._mth2(this._cls1.this).querypopkomen = (new StringBuilder("rplto=0&idhp=")).append(ess._mth2(this._cls1.this).id_hp).append("&code=").append(ess._mth2(this._cls1.this).codename).append("&email=").append(URLEncoder.encode(ess._mth2(this._cls1.this).email_user, "utf-8")).append("&nama=").append(URLEncoder.encode(ess._mth2(this._cls1.this).username, "utf-8")).append("&komentar=").append(view).append("&nmhp=").append(URLEncoder.encode(ess._mth2(this._cls1.this).namalengkap, "utf-8")).append("&top_id=").append(ess._mth2(this._cls1.this).top_id).append("&t=").append(ess._mth2(this._cls1.this).t).append("&idusr=").append(ess._mth2(this._cls1.this).user_id).toString();
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            view.printStackTrace();
        }
        if (android.os. >= 11)
        {
            (new this._cls1(ess._mth2(this._cls1.this))).or(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            (new or(ess._mth2(this._cls1.this)))._mth1(new Void[0]);
            return;
        }
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
