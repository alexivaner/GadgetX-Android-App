// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.database.Cursor;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;

// Referenced classes of package com.inponsel.android.details:
//            DetailsPonsel

class this._cls0
    implements Runnable
{

    final DetailsPonsel this$0;

    public void run()
    {
        Log.e("updateObserverLogin", "HomeNewMainActivity");
        if (userFunctions.isUserLoggedIn(DetailsPonsel.this))
        {
            cursor = db.getAllData();
            cursor.moveToFirst();
            try
            {
                DetailsPonsel.user_id = EncodeDecodeAES.decrypt(RestClient.pelihara, cursor.getString(1));
            }
            catch (Exception exception) { }
            DetailsPonsel.nama_asli = cursor.getString(2);
            DetailsPonsel.user_photo = (new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(cursor.getString(3)).toString();
            DetailsPonsel.username = cursor.getString(4);
            DetailsPonsel.email_user = cursor.getString(5);
            DetailsPonsel.user_ttl = cursor.getString(6);
            DetailsPonsel.user_provinsi = cursor.getString(7);
            DetailsPonsel.user_kota = cursor.getString(8);
            DetailsPonsel.user_kecamatan = cursor.getString(cursor.getColumnIndex("user_kecamatan"));
            DetailsPonsel.user_jekel = cursor.getString(9);
            DetailsPonsel.user_ponsel1 = cursor.getString(10);
            DetailsPonsel.user_ponsel2 = cursor.getString(11);
            DetailsPonsel.user_provider1 = cursor.getString(12);
            DetailsPonsel.user_provider2 = cursor.getString(13);
            DetailsPonsel.user_joindate = cursor.getString(14);
            DetailsPonsel.user_profile_update = cursor.getString(15);
        }
    }

    ()
    {
        this$0 = DetailsPonsel.this;
        super();
    }
}
