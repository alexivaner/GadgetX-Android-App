// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.widget.Toast;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import org.json.JSONObject;

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
            if (android.os.RegisterTask >= 11)
            {
                avoid = StrictMode.getThreadPolicy();
                StrictMode.setThreadPolicy((new android.os.r(avoid)).permitDiskWrites().build());
                StrictMode.setThreadPolicy(avoid);
            }
            nama = nama.replace(" ", "%20");
            pass = pass.replace(" ", "%20");
            provinsi = provinsi.replace(" ", "%20");
            kota = kota.replace(" ", "%20");
            namaHp = namaHp.replace(" ", "%20");
            namaHp = namaHp.replace("+", "%2B");
            if (namaHp2.equals(""))
            {
                namaHp2 = "NULL";
            }
            namaHp2 = namaHp2.replace(" ", "%20");
            namaHp2 = namaHp2.replace("+", "%2B");
            provider = provider.replace(" ", "%20");
            if (provider2.equals(""))
            {
                provider2 = "NULL";
            }
            provider2 = provider2.replace(" ", "%20");
            avoid = (new StringBuilder("user_nama_asli=")).append(nama).append("&user_name=").append(usernama).append("&user_photo=").append("NULL").append("&user_password=").append(pass).append("&user_email=").append(email).append("&user_ttl=").append(selectDate).append("&user_provinsi=").append(provinsi).append("&user_kota=").append(kota).append("&user_kec=").append(kecamatan_id).append("&user_jekel=").append(jenisKelamin).append("&user_ponsel_1=").append(namaHp).append("&user_ponsel_2=").append(namaHp2).append("&user_operator_1=").append(provider).append("&user_operator_2=").append(provider2).append("&t=").append(t).toString();
            String s = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("register_account").append(Utility.BASE_FORMAT).append("?").append(avoid).toString();
            Log.e("pushURLDaftar", s);
            mail_register = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("mail_register_account").append(Utility.BASE_FORMAT).append("?").append(avoid).toString();
            s = HttpPush.getResponse(s);
            Log.e("push", (new StringBuilder(String.valueOf(s))).append(" ").append(Util.BASE_PATH2).append("register_account").append(Utility.BASE_FORMAT).append("?").append(avoid).toString());
            res = s.toString();
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
        mDialog.dismiss();
        try
        {
            void1 = new JSONObject(res);
            if (void1.getString("success").equals("1"))
            {
                mail_register = (new StringBuilder(String.valueOf(mail_register))).append("&activation_key=").append(void1.getString("activation_key")).toString();
                RegisterActivity.access$6(RegisterActivity.this, mail_register);
                void1 = new android.app.ail_register(wrapper);
                void1.rapper("Perhatian!");
                void1.((new StringBuilder("Tautan aktivasi akun sudah terkirim ke email ")).append(email).append(". Silahkan hubungi support@inponsel.co.id jika anda mengalami masalah lebih lanjut.").toString());
                void1.eButton("Ok", new android.content.DialogInterface.OnClickListener() {

                    final RegisterActivity.RegisterTask this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        finish();
                    }

            
            {
                this$1 = RegisterActivity.RegisterTask.this;
                super();
            }
                });
                void1.egisterTask();
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            return;
        }
        if (res.equals("404"))
        {
            Toast.makeText(RegisterActivity.this, "Username sudah terdaftar", 1).show();
            return;
        }
        if (res.equals("40404"))
        {
            Toast.makeText(RegisterActivity.this, "Email sudah terdaftar", 1).show();
            return;
        }
        Toast.makeText(RegisterActivity.this, "Register gagal", 1).show();
        return;
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        mDialog = ProgressDialog.show(wrapper, "", "Registering...", true);
        mDialog.setCancelable(false);
        mDialog.show();
    }


    public _cls1.this._cls1()
    {
        this$0 = RegisterActivity.this;
        super();
    }
}
