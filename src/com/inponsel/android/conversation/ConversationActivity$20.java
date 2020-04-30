// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.conversation;

import android.database.Cursor;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;

// Referenced classes of package com.inponsel.android.conversation:
//            ConversationActivity

class this._cls0
    implements Runnable
{

    final ConversationActivity this$0;

    public void run()
    {
        Log.e("updateObserverLogin", "MainActivity");
        if (userFunctions.isUserLoggedIn(getApplicationContext()))
        {
            cursor = db.getAllData();
            cursor.moveToFirst();
            try
            {
                ConversationActivity.user_id = EncodeDecodeAES.decrypt(RestClient.pelihara, cursor.getString(1));
            }
            catch (Exception exception) { }
            ConversationActivity.nama_asli = cursor.getString(2);
            ConversationActivity.user_photo = (new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(cursor.getString(3)).toString();
            ConversationActivity.username = cursor.getString(4);
            ConversationActivity.email_user = cursor.getString(5);
            ConversationActivity.user_ttl = cursor.getString(6);
            ConversationActivity.user_provinsi = cursor.getString(7);
            ConversationActivity.user_kota = cursor.getString(8);
            ConversationActivity.user_kecamatan = cursor.getString(cursor.getColumnIndex("user_kecamatan"));
            ConversationActivity.user_jekel = cursor.getString(9);
            ConversationActivity.user_ponsel1 = cursor.getString(10);
            ConversationActivity.user_ponsel2 = cursor.getString(11);
            ConversationActivity.user_provider1 = cursor.getString(12);
            ConversationActivity.user_provider2 = cursor.getString(13);
            ConversationActivity.user_joindate = cursor.getString(14);
            ConversationActivity.user_profile_update = cursor.getString(15);
        }
    }

    ()
    {
        this$0 = ConversationActivity.this;
        super();
    }
}
