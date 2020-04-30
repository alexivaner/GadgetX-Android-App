// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.rsstab;

import android.view.View;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import java.net.URLEncoder;

// Referenced classes of package com.inponsel.android.rsstab:
//            RSSTimelineActivity

class this._cls1
    implements android.view.elineOLDTask._cls8
{

    final this._cls1 this$1;

    public void onClick(View view)
    {
        try
        {
            cess._mth2(this._cls1.this).limit = 0;
            view = cess._mth2(this._cls1.this);
            view.page_counter = ((RSSTimelineActivity) (view)).page_counter + 1;
            cess._mth2(this._cls1.this).urlRSSOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rss_all_category").append(Utility.BASE_FORMAT).append("?").append("bottom_id=").append(URLEncoder.encode(cess._mth2(this._cls1.this).bottom_id, "utf-8")).append("&t=").append(cess._mth2(this._cls1.this).t).append("&idusr=").append(cess._mth2(this._cls1.this).user_id).append("&tag=").append(cess._mth2(this._cls1.this).tag_code).append("&page=").append(cess._mth2(this._cls1.this).page_counter).toString();
            Log.e("urlRSSOld", cess._mth2(this._cls1.this).urlRSSOld);
            cess._mth2(this._cls1.this).TimelinePREVTask();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            return;
        }
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
