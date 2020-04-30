// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.text.Editable;
import android.widget.EditText;
import android.widget.Toast;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;

// Referenced classes of package com.inponsel.android.v2:
//            ProfileActivity, HomeNewMainActivity

public class this._cls0 extends AsyncTask
{

    final ProfileActivity this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        try
        {
            if (android.os.ity.PassTask >= 11)
            {
                avoid = StrictMode.getThreadPolicy();
                StrictMode.setThreadPolicy((new android.os.uilder(avoid)).permitDiskWrites().build());
                StrictMode.setThreadPolicy(avoid);
            }
            String s = edtPassProfileLama.getText().toString();
            avoid = edtPassProfileBaru.getText().toString();
            s = Utility.session(Utility.session(Utility.session(Utility.session(Utility.session(s)))));
            avoid = Utility.session(Utility.session(Utility.session(Utility.session(Utility.session(avoid)))));
            query = (new StringBuilder("user_name=")).append(username).append("&user_password=").append(s).append("&user_passwordnew=").append(avoid).append("&t=").append(t).toString();
            avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("mod_passwords").append(Utility.BASE_FORMAT).append("?").append(query).toString();
            Log.e("pushURL", avoid);
            avoid = HttpPush.getResponse(avoid);
            res = avoid.toString();
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
        mDialog.dismiss();
        try
        {
            if (res.equals("1"))
            {
                Toast.makeText(ProfileActivity.this, "Ganti password berhasil", 1).show();
                userFunctions.logoutUser(getApplicationContext());
                void1 = new Intent(getApplicationContext(), com/inponsel/android/v2/HomeNewMainActivity);
                void1.addFlags(0x4000000);
                startActivity(void1);
                finish();
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            return;
        }
        Toast.makeText(ProfileActivity.this, "Update profile gagal", 1).show();
        return;
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        mDialog = ProgressDialog.show(wrapper, "", "Mengubah password...", true);
        mDialog.setCancelable(true);
        mDialog.show();
    }

    public ()
    {
        this$0 = ProfileActivity.this;
        super();
    }
}
