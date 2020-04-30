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

class this._cls1
    implements android.view.AsycTask._cls8
{

    final ute this$1;

    public void onClick(View view)
    {
        try
        {
            cess._mth2(this._cls1.this).txtbtnfooter.setVisibility(8);
            view = cess._mth2(this._cls1.this);
            view.limit = ((KomentarPonsel) (view)).limit + 15;
            cess._mth2(this._cls1.this).urlKomenOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_old_hp_rev").append(Utility.BASE_FORMAT).append("?idhp=").append(cess._mth2(this._cls1.this).id_hp).append("&code=").append(URLEncoder.encode(cess._mth2(this._cls1.this).codename, "utf-8")).append("&sortkom=").append(cess._mth2(this._cls1.this).sortkom).append("&lmt=").append(cess._mth2(this._cls1.this).limit).append("&bottom_id=").append(cess._mth2(this._cls1.this).bottom_id).append("&t=").append(cess._mth2(this._cls1.this).t).append("&idusr=").append(cess._mth2(this._cls1.this).user_id).toString();
            Log.e("urlKomenOld", cess._mth2(this._cls1.this).urlKomenOld);
            if (android.os. >= 11)
            {
                (new t>(cess._mth2(this._cls1.this))).uteOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            return;
        }
        (new t>(cess._mth2(this._cls1.this))).ute(new String[0]);
        return;
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
