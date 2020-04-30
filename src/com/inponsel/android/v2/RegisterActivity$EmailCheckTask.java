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
            if (android.os.ailCheckTask >= 11)
            {
                avoid = StrictMode.getThreadPolicy();
                StrictMode.setThreadPolicy((new android.os.<init>(avoid)).permitDiskWrites().build());
                StrictMode.setThreadPolicy(avoid);
            }
            avoid = (new StringBuilder("user_email=")).append(edtEmail.getText().toString()).append("&t=").append(t).toString();
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
        progressbar_email.setVisibility(8);
        if (!res.equals("1")) goto _L2; else goto _L1
_L1:
        Log.e("valid", "1");
        txtcekemail.setVisibility(8);
_L3:
        checkField();
        return;
_L2:
label0:
        {
            if (!res.equals("404"))
            {
                break label0;
            }
            Toast.makeText(RegisterActivity.this, "Username sudah terdaftar", 1).show();
        }
          goto _L3
label1:
        {
            if (!res.equals("40404"))
            {
                break label1;
            }
            Log.e("valid", "40404");
            txtcekemail.setVisibility(0);
            txtcekemail.setText("Email sudah terdaftar");
            txtcekemail.setTextColor(Color.parseColor("#db261e"));
            btnSubmit.setEnabled(false);
            edtEmail.startAnimation(animation);
        }
          goto _L3
label2:
        {
            if (!res.equals("1240404"))
            {
                break label2;
            }
            txtcekemail.setVisibility(0);
            txtcekemail.setText("Email tidak valid");
            txtcekemail.setTextColor(Color.parseColor("#db261e"));
            btnSubmit.setEnabled(false);
            edtEmail.startAnimation(animation);
        }
          goto _L3
        try
        {
            Toast.makeText(RegisterActivity.this, "Posting gagal", 1).show();
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            return;
        }
          goto _L3
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        progressbar_email.setVisibility(0);
    }

    public ()
    {
        this$0 = RegisterActivity.this;
        super();
    }
}
