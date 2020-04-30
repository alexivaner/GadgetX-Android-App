// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.RestClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            LoginActivity, HomeNewMainActivity

private class <init> extends AsyncTask
{

    final LoginActivity this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    protected transient Void doInBackground(String as[])
    {
        int i;
        int j;
        j = as.length;
        i = 0;
_L3:
        if (i >= j)
        {
            return null;
        }
        Object obj = new RestClient(as[i]);
        ((RestClient) (obj)).Execute(com.inponsel.android.utils..GET);
_L1:
        Exception exception1;
        try
        {
            obj = ((RestClient) (obj)).getResponse();
            getJson = ((String) (obj));
            parseJSON(((String) (obj)));
        }
        catch (Exception exception) { }
        break MISSING_BLOCK_LABEL_65;
        exception1;
        exception1.printStackTrace();
          goto _L1
        i++;
        if (true) goto _L3; else goto _L2
_L2:
    }

    void log(String s)
    {
        Log.e("Near", s);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        super.onPostExecute(void1);
        Log.e("login", "success");
        ponselBaseApp.getObserver().setLoginStat("1");
        if (classname.equals("com.inponsel.android.SplashScreen"))
        {
            Log.e("stack", "1");
            void1 = new Intent(LoginActivity.this, com/inponsel/android/v2/HomeNewMainActivity);
            void1.addFlags(0x4000000);
            void1.addFlags(32768);
            startActivityForResult(void1, 0);
            overridePendingTransition(0x7f040003, 0x7f040004);
            finish();
        } else
        {
            Log.e("stack", "2");
            finish();
        }
        finish();
    }

    protected void onPreExcute()
    {
        super.onPreExecute();
        db.resetUnreadMSGTables();
    }

    void parseJSON(String s)
        throws Exception
    {
        JSONObject jsonobject;
        DatabaseHandler databasehandler;
        String s1;
        String s2;
        String s3;
        String s4;
        String s5;
        String s6;
        String s7;
        String s8;
        String s9;
        String s10;
        String s11;
        String s12;
        String s13;
        String s14;
        String s15;
        String s16;
        String s17;
        String s18;
        String s19;
        String s20;
        String s21;
        String s22;
        String s23;
        String s24;
        String s25;
        android.content. ;
        int i;
        try
        {
            s = (new JSONObject(s)).getJSONArray("InPonsel");
            log((new StringBuilder("lenght: ")).append(s.length()).toString());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return;
        }
        i = 0;
        if (i >= s.length())
        {
            return;
        }
        jsonobject = s.getJSONObject(i);
        databasehandler = new DatabaseHandler(getApplicationContext());
        s1 = jsonobject.getString("id");
        s2 = jsonobject.getString("name");
        s3 = jsonobject.getString("avatar");
        s4 = jsonobject.getString("uname");
        s5 = jsonobject.getString("umail");
        s6 = jsonobject.getString("uborn");
        s7 = jsonobject.getString("uprov");
        s8 = jsonobject.getString("ucity");
        s9 = jsonobject.getString("ugen");
        s10 = jsonobject.getString("uphone1");
        s11 = jsonobject.getString("uphone2");
        s12 = jsonobject.getString("uope1");
        s13 = jsonobject.getString("uope2");
        s14 = jsonobject.getString("ujdate");
        s15 = jsonobject.getString("modified_date");
        s16 = jsonobject.getString("mailnotif");
        s17 = jsonobject.getString("pushnotif");
        s18 = jsonobject.getString("komnotif");
        s19 = jsonobject.getString("likenotif");
        s20 = jsonobject.getString("tanggapnotif");
        s21 = jsonobject.getString("komennotif_push");
        s22 = jsonobject.getString("likenotif_push");
        s23 = jsonobject.getString("tanggapnotif_push");
        s24 = jsonobject.getString("codephone1");
        s25 = jsonobject.getString("codephone2");
        databasehandler.addUnread(jsonobject.getString("unread"));
         = getApplicationContext().getSharedPreferences("UnreadGroup", 0).edit();
        .putString("unread_group", jsonobject.getString("unread_group"));
        .commit();
        Log.e("user_id_encr", EncodeDecodeAES.encrypt(RestClient.pelihara, s1));
        databasehandler.addUser(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16, s17, s18, s19, s20, s21, s22, s23, s24, s25, jsonobject.getString("ukec"));
        i++;
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_40;
        }
    }

    private hod()
    {
        this$0 = LoginActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
