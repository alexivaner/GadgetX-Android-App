// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.database.Cursor;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.nostra13.universalimageloader.core.ImageLoader;

// Referenced classes of package com.inponsel.android.v2:
//            RoomChatActivity

class this._cls0
    implements Runnable
{

    final RoomChatActivity this$0;

    public void run()
    {
        if (userFunctions.isUserLoggedIn(getApplicationContext()))
        {
            cursor = db.getAllData();
            cursor.moveToFirst();
            try
            {
                RoomChatActivity.user_id = EncodeDecodeAES.decrypt(RestClient.pelihara, cursor.getString(1));
            }
            catch (Exception exception) { }
            RoomChatActivity.nama_asli = cursor.getString(2);
            RoomChatActivity.user_photo = (new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(cursor.getString(3)).toString();
            RoomChatActivity.username = cursor.getString(4);
            RoomChatActivity.email_user = cursor.getString(5);
            RoomChatActivity.user_ttl = cursor.getString(6);
            RoomChatActivity.user_provinsi = cursor.getString(7);
            RoomChatActivity.user_kota = cursor.getString(8);
            RoomChatActivity.user_jekel = cursor.getString(9);
            RoomChatActivity.user_ponsel1 = cursor.getString(10);
            RoomChatActivity.user_ponsel2 = cursor.getString(11);
            RoomChatActivity.user_provider1 = cursor.getString(12);
            RoomChatActivity.user_provider2 = cursor.getString(13);
            RoomChatActivity.user_joindate = cursor.getString(14);
            RoomChatActivity.user_profile_update = cursor.getString(15);
            menu_profil.setVisibility(0);
            menu_username.setText((new StringBuilder()).append(RoomChatActivity.username).toString());
            menu_ponsel_pengguna.setText((new StringBuilder()).append(RoomChatActivity.user_ponsel1).toString());
            menu_sim_pengguna.setText((new StringBuilder()).append(RoomChatActivity.user_provider1).toString());
            imageLoader2.displayImage(RoomChatActivity.user_photo.trim(), menu_imgProfil, RoomChatActivity.access$18(RoomChatActivity.this), RoomChatActivity.access$5(RoomChatActivity.this));
            menu_profil.setVisibility(0);
            return;
        } else
        {
            menu_profil.setVisibility(8);
            return;
        }
    }

    Loader()
    {
        this$0 = RoomChatActivity.this;
        super();
    }
}
