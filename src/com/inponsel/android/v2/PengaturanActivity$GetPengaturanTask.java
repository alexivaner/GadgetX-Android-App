// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.os.AsyncTask;
import android.os.StrictMode;
import android.widget.Button;
import android.widget.CheckBox;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;

// Referenced classes of package com.inponsel.android.v2:
//            PengaturanActivity

public class this._cls0 extends AsyncTask
{

    final PengaturanActivity this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        try
        {
            if (android.os.ngaturanTask >= 11)
            {
                avoid = StrictMode.getThreadPolicy();
                StrictMode.setThreadPolicy((new android.os.>(avoid)).tDiskWrites().());
                StrictMode.setThreadPolicy(avoid);
            }
            query = (new StringBuilder("id=")).append(user_id).append("&t=").append(t).toString();
            avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("user_pengaturan").append(Utility.BASE_FORMAT).append("?").append(query).toString();
            Log.e("pushURL", avoid);
            avoid = HttpPush.getResponse(avoid);
            res = avoid.toString();
            Log.e("url.............", res);
            Log.e("status", res);
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
        parseJSON(res);
        progbar_pengaturan.setVisibility(4);
        btnset_saveset.setEnabled(true);
        chkEmailNotif.setEnabled(true);
        chkPushNotif.setEnabled(true);
        chkRSSPush.setEnabled(true);
        chkRSSEmail.setEnabled(true);
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        progbar_pengaturan.setVisibility(0);
        btnset_saveset.setEnabled(false);
    }

    public ()
    {
        this$0 = PengaturanActivity.this;
        super();
    }
}
