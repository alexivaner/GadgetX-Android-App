// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.text.Editable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.RestClient;

// Referenced classes of package com.inponsel.android.v2:
//            LoginActivity

class this._cls0
    implements android.view.ener
{

    final LoginActivity this$0;

    public void onClick(View view)
    {
        if (!inputEmail.getText().toString().equals("") || !inputPassword.getText().toString().equals("")) goto _L2; else goto _L1
_L1:
        Toast.makeText(getApplicationContext(), "Username dan password belum diisi", 1).show();
        btnLogin.setEnabled(false);
_L8:
        return;
_L2:
        if (view != btnLogin) goto _L4; else goto _L3
_L3:
        ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(inputEmail.getWindowToken(), 0);
        LoginActivity.emails = inputEmail.getText().toString().trim();
        LoginActivity.passwords = inputPassword.getText().toString();
        LoginActivity.savePass = EncodeDecodeAES.encrypt(RestClient.pelihara, inputPassword.getText().toString());
        loginPrefEditor.putString("save", LoginActivity.savePass);
        if (!chkRemember.isChecked()) goto _L6; else goto _L5
_L5:
        loginPrefEditor.putBoolean("saveLogin", true);
        loginPrefEditor.putString("email", LoginActivity.emails);
        loginPrefEditor.putString("pref", LoginActivity.savePass);
_L9:
        loginPrefEditor.commit();
_L4:
        if (LoginActivity.cm.getActiveNetworkInfo() == null || !LoginActivity.cm.getActiveNetworkInfo().isAvailable() || !LoginActivity.cm.getActiveNetworkInfo().isConnected()) goto _L8; else goto _L7
_L7:
        if (android.os.K_INT >= 11)
        {
            (new ginTask(LoginActivity.this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            (new ginTask(LoginActivity.this)).execute(new Void[0]);
            return;
        }
_L6:
        loginPrefEditor.clear();
          goto _L9
        view;
        view.printStackTrace();
          goto _L4
    }

    ginTask()
    {
        this$0 = LoginActivity.this;
        super();
    }
}
