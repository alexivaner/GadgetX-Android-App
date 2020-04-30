// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.Intent;
import android.database.Cursor;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.v2.LoginActivity;

// Referenced classes of package com.inponsel.android.details:
//            SCTerdekatActivity

class this._cls1
    implements com.inponsel.android.utils.r
{

    final idePendingTransition this$1;

    public void onClick()
    {
        Intent intent = new Intent(getApplicationContext(), com/inponsel/android/v2/LoginActivity);
        intent.putExtra("activity", "main");
        startActivityForResult(intent, 0);
        overridePendingTransition(0x7f040001, 0x7f040002);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/details/SCTerdekatActivity$10

/* anonymous class */
    class SCTerdekatActivity._cls10
        implements Runnable
    {

        final SCTerdekatActivity this$0;

        public void run()
        {
            if (SCTerdekatActivity.access$1(SCTerdekatActivity.this).isUserLoggedIn(getApplicationContext()))
            {
                SCTerdekatActivity.access$3(SCTerdekatActivity.this, SCTerdekatActivity.access$2(SCTerdekatActivity.this).getAllData());
                SCTerdekatActivity.access$4(SCTerdekatActivity.this).moveToFirst();
                try
                {
                    user_id = EncodeDecodeAES.decrypt(RestClient.pelihara, SCTerdekatActivity.access$4(SCTerdekatActivity.this).getString(1));
                }
                catch (Exception exception) { }
                nama_asli = SCTerdekatActivity.access$4(SCTerdekatActivity.this).getString(2);
                username = SCTerdekatActivity.access$4(SCTerdekatActivity.this).getString(4);
                email_user = SCTerdekatActivity.access$4(SCTerdekatActivity.this).getString(5);
                user_ttl = SCTerdekatActivity.access$4(SCTerdekatActivity.this).getString(6);
                user_provinsi = SCTerdekatActivity.access$4(SCTerdekatActivity.this).getString(7);
                user_kota = SCTerdekatActivity.access$4(SCTerdekatActivity.this).getString(8);
                user_jekel = SCTerdekatActivity.access$4(SCTerdekatActivity.this).getString(9);
                user_ponsel1 = SCTerdekatActivity.access$4(SCTerdekatActivity.this).getString(10);
                user_ponsel2 = SCTerdekatActivity.access$4(SCTerdekatActivity.this).getString(11);
                user_provider1 = SCTerdekatActivity.access$4(SCTerdekatActivity.this).getString(12);
                user_provider2 = SCTerdekatActivity.access$4(SCTerdekatActivity.this).getString(13);
                user_joindate = SCTerdekatActivity.access$4(SCTerdekatActivity.this).getString(14);
                user_profile_update = SCTerdekatActivity.access$4(SCTerdekatActivity.this).getString(15);
                SCTerdekatActivity.access$4(SCTerdekatActivity.this).close();
            }
            if (SCTerdekatActivity.access$1(SCTerdekatActivity.this).isUserLoggedIn(getApplicationContext()))
            {
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
                SCTerdekatActivity.clickify(txtSCNotLogin, "disini", new SCTerdekatActivity._cls10._cls1());
                return;
            }
        }


            
            {
                this$0 = SCTerdekatActivity.this;
                super();
            }
    }

}
