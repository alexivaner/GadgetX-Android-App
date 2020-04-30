// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import java.net.URLEncoder;

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
        if (android.os.RegisterTask >= 11)
        {
            avoid = StrictMode.getThreadPolicy();
            StrictMode.setThreadPolicy((new android.os.er(avoid)).permitDiskWrites().build());
            StrictMode.setThreadPolicy(avoid);
        }
        passProfile = passProfile.replace(" ", "%20");
        provinsiProfile = URLEncoder.encode(provinsiProfile, "utf-8");
        kotaProfile = URLEncoder.encode(kotaProfile, "utf-8");
        hpPenggunaProfile = URLEncoder.encode(btnHpDigunakanProfile.getText().toString(), "utf-8");
        if (hpPengguna2Profile.equals(""))
        {
            hpPengguna2Profile = "NULL";
        }
        hpPengguna2Profile = URLEncoder.encode(btnHpDigunakan2Profile.getText().toString(), "utf-8");
        provider = URLEncoder.encode(provider, "utf-8");
        currentDateandTime = currentDateandTime.replace(" ", "%20");
        if (provider2.equals(""))
        {
            provider2 = "NULL";
        }
        provider2 = URLEncoder.encode(provider2, "utf-8");
        if (ProfileActivity.access$2(ProfileActivity.this) != 0 || ProfileActivity.access$4(ProfileActivity.this) != 0 || ProfileActivity.access$5(ProfileActivity.this) != 0) goto _L2; else goto _L1
_L1:
        selectDate = user_ttl;
_L4:
        if (repassProfile.equals("63027d7630360e4203c0e3f970ec2ffcfe5f8f1b"))
        {
            repassProfile = "0";
        }
        namaProfile = URLEncoder.encode(namaProfile, "utf-8");
        emailProfile = URLEncoder.encode(emailProfile, "utf-8");
        user_jekel = user_jekel_cb;
        query = (new StringBuilder("user_nama_asli=")).append(namaProfile).append("&user_name=").append(username).append("&user_photo=").append("NULL").append("&user_password=").append(passProfile).append("&user_email=").append(emailProfile).append("&user_ttl=").append(selectDate).append("&user_provinsi=").append(provinsiProfile).append("&user_kota=").append(kotaProfile).append("&user_kecamatan=").append(kecamatan_id).append("&user_jekel=").append(user_jekel).append("&user_ponsel_1=").append(hpPenggunaProfile).append("&user_ponsel_2=").append(hpPengguna2Profile).append("&user_operator_1=").append(provider).append("&user_operator_2=").append(provider2).append("&modtime=").append(currentDateandTime).append("&t=").append(t).toString();
        avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("modifi_member_inponsel").append(Utility.BASE_FORMAT).append("?").append(query).toString();
        Log.e("pushURL", avoid);
        avoid = HttpPush.getResponse(avoid);
        Log.e("push", (new StringBuilder(String.valueOf(avoid))).append(" ").append(Util.BASE_PATH2).append("modifi_member_inponsel").append(Utility.BASE_FORMAT).append("?").append(query).toString());
        res = avoid.toString();
        Log.e("url.............", res);
        res = res.trim();
        res = res.replaceAll("\\s+", "");
        Log.e("status", res);
        break MISSING_BLOCK_LABEL_880;
_L2:
        selectDate = String.valueOf((new StringBuilder(String.valueOf(ProfileActivity.access$2(ProfileActivity.this)))).append("-").append(ProfileActivity.access$4(ProfileActivity.this)).append("-").append(ProfileActivity.access$5(ProfileActivity.this)).toString());
        if (true) goto _L4; else goto _L3
_L3:
        avoid;
        avoid.printStackTrace();
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
                db.update_byID(edtNamaProfile.getText().toString(), username, edtEmailProfile.getText().toString(), selectDate, btnProvProfile.getText().toString(), btnKotaProfile.getText().toString(), user_jekel, btnHpDigunakanProfile.getText().toString(), btnHpDigunakan2Profile.getText().toString(), btnOperatorDigunakanProfile.getText().toString(), btnOperatorDigunakan2Profile.getText().toString(), user_joindate, currentDateandTime, ucodename1, ucodename2, kecamatanProfile);
                Toast.makeText(ProfileActivity.this, "Update profile berhasil", 1).show();
                void1 = new Intent(getApplicationContext(), com/inponsel/android/v2/HomeNewMainActivity);
                void1.setFlags(0x10008000);
                startActivityForResult(void1, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
                finish();
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            return;
        }
        if (res.equals("U404"))
        {
            void1 = new android.app.es(ProfileActivity.this);
            void1.e("Username anda tidak terdaftar");
            void1.veButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                final ProfileActivity.RegisterTask this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$1 = ProfileActivity.RegisterTask.this;
                super();
            }
            });
            void1.egisterTask();
            return;
        }
        Toast.makeText(ProfileActivity.this, "Update profile gagal", 1).show();
        return;
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        mDialog = ProgressDialog.show(wrapper, "", "Updating...", true);
        mDialog.setCancelable(true);
        mDialog.show();
    }

    public _cls1.this._cls1()
    {
        this$0 = ProfileActivity.this;
        super();
    }
}
