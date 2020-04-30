// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;

// Referenced classes of package com.inponsel.android.v2:
//            RegisterActivity

public class this._cls0 extends AsyncTask
{

    final RegisterActivity this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        try
        {
            if (android.os.serCheckTask >= 11)
            {
                avoid = StrictMode.getThreadPolicy();
                StrictMode.setThreadPolicy((new android.os.(avoid)).permitDiskWrites().build());
                StrictMode.setThreadPolicy(avoid);
            }
            avoid = (new StringBuilder("user_email=")).append(edtUserName.getText().toString()).append("&t=").append(t).toString();
            String s = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("email_check").append(Utility.BASE_FORMAT).append("?").append(avoid).toString();
            Log.e("pushURL", s);
            s = HttpPush.getResponse(s);
            Log.e("push", (new StringBuilder(String.valueOf(s))).append(" ").append(Util.BASE_PATH2).append("email_check").append(Utility.BASE_FORMAT).append("?").append(avoid).toString());
            res = s.toString();
            Log.e("url.............", res);
            res = res.trim();
            res = res.replaceAll("\\s+", "");
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
        progressbar_username.setVisibility(8);
        if (!res.equals("1")) goto _L2; else goto _L1
_L1:
        txtcekusername.setVisibility(0);
        Log.e("valid", "1");
        txtcekusername.setText("Username tersedia");
        txtcekusername.setTextColor(Color.parseColor("#26A908"));
_L5:
        checkField();
        return;
_L2:
        if (!res.equals("404")) goto _L4; else goto _L3
_L3:
        txtcekusername.setVisibility(0);
        txtcekusername.setText("Username sudah terdaftar");
        txtcekusername.setTextColor(Color.parseColor("#db261e"));
        btnSubmit.setEnabled(false);
        edtUserName.startAnimation(animation);
          goto _L5
_L4:
        if (!res.equals("40404")) goto _L5; else goto _L6
_L6:
        Log.e("valid", "40404");
        Toast.makeText(RegisterActivity.this, "Email sudah terdaftar", 1).show();
          goto _L5
        void1;
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        progressbar_username.setVisibility(0);
    }

    public ()
    {
        this$0 = RegisterActivity.this;
        super();
    }
}
