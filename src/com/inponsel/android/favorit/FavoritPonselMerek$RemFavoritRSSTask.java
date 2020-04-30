// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.favorit;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;

// Referenced classes of package com.inponsel.android.favorit:
//            FavoritPonselMerek

public class this._cls0 extends AsyncTask
{

    final FavoritPonselMerek this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        try
        {
            avoid = (new StringBuilder("idrss=")).append(idrss_pos).append("&idusr=").append(user_id).append("&stat=").append(stat).append("&t=").append(t).toString();
            String s = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("add_favrss").append(Utility.BASE_FORMAT).append("?").append(avoid).toString();
            Log.e("pushURL", s);
            s = HttpPush.getResponse(s);
            Log.e("push", (new StringBuilder(String.valueOf(s))).append(avoid).toString());
            res = s.toString();
            Log.e("url ", res);
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
        mDialog.cancel();
        db.deleteIDRSS(idrss_pos);
        FavoritRSSTask();
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        if (stat.equals("1"))
        {
            mDialog = ProgressDialog.show(FavoritPonselMerek.this, "", "Menambahkan...", true);
        } else
        {
            mDialog = ProgressDialog.show(FavoritPonselMerek.this, "", "Menghapus...", true);
        }
        mDialog.setCancelable(true);
        mDialog.show();
    }

    public ()
    {
        this$0 = FavoritPonselMerek.this;
        super();
    }
}
