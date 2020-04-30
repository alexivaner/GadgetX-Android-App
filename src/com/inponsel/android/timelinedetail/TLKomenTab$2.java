// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.timelinedetail;

import android.database.Cursor;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;

// Referenced classes of package com.inponsel.android.timelinedetail:
//            TLKomenTab

class this._cls0
    implements Runnable
{

    final TLKomenTab this$0;

    public void run()
    {
        if (userFunctions.isUserLoggedIn(getApplicationContext()))
        {
            cursor = db.getAllData();
            cursor.moveToFirst();
            try
            {
                TLKomenTab.user_id = EncodeDecodeAES.decrypt(RestClient.pelihara, cursor.getString(1));
            }
            catch (Exception exception) { }
            TLKomenTab.nama_asli = cursor.getString(2);
            TLKomenTab.user_photo = (new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(cursor.getString(3)).toString();
            TLKomenTab.username = cursor.getString(4);
            TLKomenTab.email_user = cursor.getString(5);
            TLKomenTab.user_ttl = cursor.getString(6);
            TLKomenTab.user_provinsi = cursor.getString(7);
            TLKomenTab.user_kota = cursor.getString(8);
            TLKomenTab.user_jekel = cursor.getString(9);
            TLKomenTab.user_ponsel1 = cursor.getString(10);
            TLKomenTab.user_ponsel2 = cursor.getString(11);
            TLKomenTab.user_provider1 = cursor.getString(12);
            TLKomenTab.user_provider2 = cursor.getString(13);
            TLKomenTab.user_joindate = cursor.getString(14);
            TLKomenTab.user_profile_update = cursor.getString(15);
        }
    }

    ()
    {
        this$0 = TLKomenTab.this;
        super();
    }
}
