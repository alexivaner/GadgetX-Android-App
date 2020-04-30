// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.database.Cursor;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.UserFunctions;

// Referenced classes of package com.inponsel.android.v2:
//            SCUserActivity, LoginActivity

class this._cls0
    implements Runnable
{

    final SCUserActivity this$0;

    public void run()
    {
        if (userFunctions.isUserLoggedIn(getApplicationContext()))
        {
            cursor = db.getAllData();
            cursor.moveToFirst();
            try
            {
                user_id = EncodeDecodeAES.decrypt(RestClient.pelihara, cursor.getString(1));
            }
            catch (Exception exception) { }
            nama_asli = cursor.getString(2);
            username = cursor.getString(4);
            email_user = cursor.getString(5);
            user_ttl = cursor.getString(6);
            user_provinsi = cursor.getString(7);
            user_kota = cursor.getString(8);
            user_jekel = cursor.getString(9);
            user_ponsel1 = cursor.getString(10);
            user_ponsel2 = cursor.getString(11);
            user_provider1 = cursor.getString(12);
            user_provider2 = cursor.getString(13);
            user_joindate = cursor.getString(14);
            user_profile_update = cursor.getString(15);
            cursor.close();
        }
        if (userFunctions.isUserLoggedIn(getApplicationContext()))
        {
            HpUserTask();
            SCKotaTask();
            SCProvTask();
            mylaylogin.setVisibility(0);
            txtSCNotLogin.setVisibility(8);
            txtNotLoginsc_kota.setVisibility(8);
            return;
        } else
        {
            mylaylogin.setVisibility(8);
            txtSCNotLogin.setVisibility(0);
            txtNotLoginsc_kota.setVisibility(0);
            txtSCNotLogin.setText("Fitur ini hanya untuk pengguna terdaftar. Silahkan daftar / login disini");
            SCUserActivity.clickify(txtSCNotLogin, "disini", new com.inponsel.android.utils.ClickSpan.OnClickListener() {

                final SCUserActivity._cls11 this$1;

                public void onClick()
                {
                    Intent intent = new Intent(getApplicationContext(), com/inponsel/android/v2/LoginActivity);
                    intent.putExtra("activity", "main");
                    startActivityForResult(intent, 0);
                    overridePendingTransition(0x7f040001, 0x7f040002);
                }

            
            {
                this$1 = SCUserActivity._cls11.this;
                super();
            }
            });
            return;
        }
    }


    _cls1.this._cls1()
    {
        this$0 = SCUserActivity.this;
        super();
    }
}
