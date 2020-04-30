// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.globalforum;

import android.database.Cursor;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;

// Referenced classes of package com.inponsel.android.globalforum:
//            ForumGlobalActivity

class this._cls0
    implements Runnable
{

    final ForumGlobalActivity this$0;

    public void run()
    {
        Log.e("updateObserverLogin", "MainActivity");
        if (userFunctions.isUserLoggedIn(getApplicationContext()))
        {
            cursor = db.getAllData();
            cursor.moveToFirst();
            try
            {
                ForumGlobalActivity.user_id = EncodeDecodeAES.decrypt(RestClient.pelihara, cursor.getString(1));
            }
            catch (Exception exception) { }
            ForumGlobalActivity.nama_asli = cursor.getString(2);
            ForumGlobalActivity.user_photo = (new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(cursor.getString(3)).toString();
            ForumGlobalActivity.username = cursor.getString(4);
            ForumGlobalActivity.email_user = cursor.getString(5);
            ForumGlobalActivity.user_ttl = cursor.getString(6);
            ForumGlobalActivity.user_provinsi = cursor.getString(7);
            ForumGlobalActivity.user_kota = cursor.getString(8);
            ForumGlobalActivity.user_kecamatan = cursor.getString(cursor.getColumnIndex("user_kecamatan"));
            ForumGlobalActivity.user_jekel = cursor.getString(9);
            ForumGlobalActivity.user_ponsel1 = cursor.getString(10);
            ForumGlobalActivity.user_ponsel2 = cursor.getString(11);
            ForumGlobalActivity.user_provider1 = cursor.getString(12);
            ForumGlobalActivity.user_provider2 = cursor.getString(13);
            ForumGlobalActivity.user_joindate = cursor.getString(14);
            ForumGlobalActivity.user_profile_update = cursor.getString(15);
        }
    }

    ()
    {
        this$0 = ForumGlobalActivity.this;
        super();
    }
}
