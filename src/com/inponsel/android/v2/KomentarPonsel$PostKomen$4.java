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
//            KomentarPonsel

class val.codename
    implements android.view.ostKomen._cls4
{

    final sycTask.execute this$1;
    private final String val$codename;
    private final String val$id_hp;

    public void onClick(View view)
    {
        try
        {
            cess._mth2(this._cls1.this).txtbtnfooter.setVisibility(8);
            view = cess._mth2(this._cls1.this);
            view.limit = ((KomentarPonsel) (view)).limit + 15;
            cess._mth2(this._cls1.this).urlKomenOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_old_hp_rev").append(Utility.BASE_FORMAT).append("?idhp=").append(val$id_hp).append("&code=").append(URLEncoder.encode(val$codename, "utf-8")).append("&sortkom=").append(cess._mth2(this._cls1.this).sortkom).append("&lmt=").append(cess._mth2(this._cls1.this).limit).append("&bottom_id=").append(cess._mth2(this._cls1.this).bottom_id).append("&t=").append(cess._mth2(this._cls1.this).t).append("&idusr=").append(cess._mth2(this._cls1.this).user_id).toString();
            Log.e("urlKomenOld", cess._mth2(this._cls1.this).urlKomenOld);
            if (android.os..urlKomenOld >= 11)
            {
                (new sycTask(cess._mth2(this._cls1.this))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            return;
        }
        (new sycTask(cess._mth2(this._cls1.this))).execute(new String[0]);
        return;
    }

    sycTask()
    {
        this$1 = final_syctask;
        val$id_hp = s;
        val$codename = String.this;
        super();
    }
}
