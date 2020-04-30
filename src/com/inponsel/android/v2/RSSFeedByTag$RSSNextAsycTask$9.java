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
import java.net.URLEncoder;

// Referenced classes of package com.inponsel.android.v2:
//            RSSFeedByTag

class this._cls1
    implements android.view.AsycTask._cls9
{

    final ecute this$1;

    public void onClick(View view)
    {
        try
        {
            cess._mth2(this._cls1.this).txtbtnheader.setVisibility(8);
            cess._mth2(this._cls1.this).limit = 0;
            cess._mth2(this._cls1.this).urlRSSLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rss_by_tag").append(Utility.BASE_FORMAT).append("?").append("&top_id=").append(URLEncoder.encode(cess._mth2(this._cls1.this).top_id, "utf-8")).append("&t=").append(cess._mth2(this._cls1.this).t).append("&idusr=").append(cess._mth2(this._cls1.this).user_id).append("&tag=").append(cess._mth2(this._cls1.this).tag_code).append("&key=").append(cess._mth2(this._cls1.this).tag_key).append("&page=").append(cess._mth2(this._cls1.this).page_counter).toString();
            Log.e("urlRSSLast", cess._mth2(this._cls1.this).urlRSSLast);
            if (android.os.SLast >= 11)
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

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
