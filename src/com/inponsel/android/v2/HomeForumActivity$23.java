// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.database.Cursor;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;

// Referenced classes of package com.inponsel.android.v2:
//            HomeForumActivity

class this._cls0
    implements Runnable
{

    final HomeForumActivity this$0;

    public void run()
    {
        Log.e("updateObserverLogin", "MainActivity");
        if (userFunctions.isUserLoggedIn(getApplicationContext()))
        {
            cursor = db.getAllData();
            cursor.moveToFirst();
            try
            {
                HomeForumActivity.user_id = EncodeDecodeAES.decrypt(RestClient.pelihara, cursor.getString(1));
            }
            catch (Exception exception) { }
            HomeForumActivity.nama_asli = cursor.getString(2);
            HomeForumActivity.user_photo = (new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(cursor.getString(3)).toString();
            HomeForumActivity.username = cursor.getString(4);
            HomeForumActivity.email_user = cursor.getString(5);
            HomeForumActivity.user_ttl = cursor.getString(6);
            HomeForumActivity.user_provinsi = cursor.getString(7);
            HomeForumActivity.user_kota = cursor.getString(8);
            HomeForumActivity.user_kecamatan = cursor.getString(cursor.getColumnIndex("user_kecamatan"));
            HomeForumActivity.user_jekel = cursor.getString(9);
            HomeForumActivity.user_ponsel1 = cursor.getString(10);
            HomeForumActivity.user_ponsel2 = cursor.getString(11);
            HomeForumActivity.user_provider1 = cursor.getString(12);
            HomeForumActivity.user_provider2 = cursor.getString(13);
            HomeForumActivity.user_joindate = cursor.getString(14);
            HomeForumActivity.user_profile_update = cursor.getString(15);
        }
    }

    ()
    {
        this$0 = HomeForumActivity.this;
        super();
    }
}
