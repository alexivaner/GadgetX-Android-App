// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;

// Referenced classes of package com.inponsel.android.v2:
//            RSSFeedByTag

public class this._cls0 extends AsyncTask
{

    final RSSFeedByTag this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        try
        {
            avoid = (new StringBuilder("idrss=")).append(idkom_pos).append("&idusr=").append(user_id).append("&stat=").append(stat).append("&t=").append(t).toString();
            String s = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("add_favrss").append(Utility.BASE_FORMAT).append("?").append(avoid).toString();
            Log.e("pushURL", s);
            s = HttpPush.getResponse(s);
            Log.e("push", (new StringBuilder(String.valueOf(s))).append(avoid).toString());
            res = s.toString();
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            avoid.printStackTrace();
        }
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        super.onPostExecute(void1);
        updateViewRSSFav(idkom_pos, res, str_srclink);
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        if (stat.equals("1"))
        {
            mDialog = ProgressDialog.show(RSSFeedByTag.this, "", "Menambahkan...", true);
        } else
        {
            mDialog = ProgressDialog.show(RSSFeedByTag.this, "", "Menghapus...", true);
        }
        mDialog.setCancelable(true);
        mDialog.show();
    }

    public ()
    {
        this$0 = RSSFeedByTag.this;
        super();
    }
}
