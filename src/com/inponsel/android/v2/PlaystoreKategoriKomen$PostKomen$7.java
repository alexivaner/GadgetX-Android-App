// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.os.AsyncTask;
import android.text.Editable;
import android.view.View;
import com.inponsel.android.utils.Log;
import com.inponsel.android.widget.DroidWriterEditText;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

// Referenced classes of package com.inponsel.android.v2:
//            PlaystoreKategoriKomen

class this._cls1
    implements android.view.ostKomen._cls7
{

    final ecute this$1;

    public void onClick(View view)
    {
        try
        {
            view = URLEncoder.encode(cess._mth2(this._cls1.this).edt_pop_komen.getText().toString(), "utf-8");
            Log.e("top_id", cess._mth2(this._cls1.this).top_id);
            cess._mth2(this._cls1.this).querypopkomen = (new StringBuilder("idkat=")).append(cess._mth2(this._cls1.this).id_kat).append("&idusr=").append(cess._mth2(this._cls1.this).user_id).append("&kom=").append(view).append("&rplto=").append("0").append("&top_id=").append(cess._mth2(this._cls1.this).top_id).append("&t=").append(cess._mth2(this._cls1.this).t).toString();
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            view.printStackTrace();
        }
        if (android.os.kTrace >= 11)
        {
            (new nit>(cess._mth2(this._cls1.this))).ecuteOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            (new nit>(cess._mth2(this._cls1.this))).ecute(new Void[0]);
            return;
        }
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
