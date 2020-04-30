// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;
import android.text.Editable;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            LoginActivity

public class this._cls0 extends AsyncTask
{

    final LoginActivity this$0;

    private void parseJSONLogin(String s)
    {
        try
        {
            s = new JSONObject(s);
            loginStatus = s.getString("success");
            loginMessage = s.getString("message");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
    }

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        String s1;
        String s2;
        String s3;
        avoid = "";
        s1 = "";
        s2 = inputEmail.getText().toString().trim();
        s3 = Utility.session(Utility.session(Utility.session(Utility.session(Utility.session(inputPassword.getText().toString())))));
        String s = URLEncoder.encode(Build.MODEL, "utf-8");
        avoid = s;
        int i = android.os.ty.inputPassword;
        s1 = String.valueOf(i);
        avoid = s;
_L2:
        UnsupportedEncodingException unsupportedencodingexception;
        try
        {
            regid = prefGCM.getString("gcm_id", null);
            query = (new StringBuilder("user_name=")).append(s2).append("&user_password=").append(s3).append("&t=").append(t).append("&reg=").append(regid).append("&dev=").append(avoid).append("&dos=").append(s1).toString();
            pushURL = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("login_user").append(Utility.BASE_FORMAT).append("?").append(query).toString();
            Log.e("pushURL", pushURL);
            avoid = HttpPush.getResponse(pushURL);
            Log.e("push", (new StringBuilder(String.valueOf(avoid))).append(query).toString());
            res = avoid.toString();
            Log.e("url ", res);
            parseJSONLogin(res);
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            avoid.printStackTrace();
            return null;
        }
        return null;
        unsupportedencodingexception;
        unsupportedencodingexception.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void execute(String s)
    {
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        super.onPostExecute(void1);
        try
        {
            if (loginStatus.equals("0"))
            {
                Toast.makeText(LoginActivity.this, loginMessage, 1).show();
                LoginActivity.access$0(LoginActivity.this).setVisibility(8);
                inputEmail.setEnabled(true);
                inputPassword.setEnabled(true);
                chkRemember.setEnabled(true);
                btnLogin.setEnabled(true);
                btnLinkToRegister.setEnabled(true);
                btnSkip.setEnabled(true);
                txtKebijakan.setEnabled(true);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            return;
        }
        try
        {
            (new <init>(LoginActivity.this, null)).execute(new String[] {
                pushURL
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Void void1) { }
        void1.printStackTrace();
        return;
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        status = "";
        txtKebijakan.setEnabled(false);
        inputEmail.setEnabled(false);
        inputPassword.setEnabled(false);
        chkRemember.setEnabled(false);
        btnLogin.setEnabled(false);
        btnLinkToRegister.setEnabled(false);
        btnSkip.setEnabled(false);
        LoginActivity.access$0(LoginActivity.this).setVisibility(0);
    }

    public ogressBar()
    {
        this$0 = LoginActivity.this;
        super();
    }
}
