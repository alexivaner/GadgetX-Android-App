// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android;

import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.Log;
import com.inponsel.android.v2.HomeNewMainActivity;
import com.inponsel.android.v2.LoginActivity;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android:
//            SplashScreen

class this._cls0
    implements com.android.volley.er
{

    final SplashScreen this$0;

    public volatile void onResponse(Object obj)
    {
        onResponse((JSONObject)obj);
    }

    public void onResponse(JSONObject jsonobject)
    {
        Log.e("response", jsonobject.toString());
        parseJSON(jsonobject.toString());
        Log.e("login_stat", login_stat);
        if (login_stat.equals("1"))
        {
            jsonobject = new Intent(SplashScreen.this, com/inponsel/android/v2/HomeNewMainActivity);
            startActivityForResult(jsonobject, 0);
            overridePendingTransition(0x7f040003, 0x7f040004);
            finish();
            return;
        } else
        {
            notifManager.cancelAll();
            db.removeAll();
            jsonobject = new android.app.lder(wrapper);
            jsonobject.setMessage(login_msg);
            jsonobject.setCancelable(false);
            jsonobject.setPositiveButton("Lanjutkan", new android.content.DialogInterface.OnClickListener() {

                final SplashScreen._cls7 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(this$0, com/inponsel/android/v2/LoginActivity);
                    dialoginterface.addFlags(0x4000000);
                    dialoginterface.addFlags(32768);
                    dialoginterface.putExtra("activity", "splash");
                    startActivityForResult(dialoginterface, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                    finish();
                }

            
            {
                this$1 = SplashScreen._cls7.this;
                super();
            }
            });
            jsonobject.show();
            return;
        }
    }


    _cls1.this._cls1()
    {
        this$0 = SplashScreen.this;
        super();
    }
}
