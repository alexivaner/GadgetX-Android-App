// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.nostra13.universalimageloader.core.ImageLoader;

// Referenced classes of package com.inponsel.android.v2:
//            BaseDrawer

class this._cls0
    implements Runnable
{

    final BaseDrawer this$0;

    public void run()
    {
        Log.e("update", "BaseDrawer");
        if (userFunctions.isUserLoggedIn(getApplicationContext()))
        {
            cursor = db.getAllData();
            cursor.moveToFirst();
            Object obj;
            try
            {
                user_id = EncodeDecodeAES.decrypt(RestClient.pelihara, cursor.getString(1));
            }
            catch (Exception exception) { }
            nama_asli = cursor.getString(2);
            user_photo = (new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(cursor.getString(3)).toString();
            username = cursor.getString(4);
            email_user = cursor.getString(5);
            user_ttl = cursor.getString(6);
            user_provinsi = cursor.getString(7);
            user_kota = cursor.getString(8);
            user_kecamatan = cursor.getString(cursor.getColumnIndex("user_kecamatan"));
            user_jekel = cursor.getString(9);
            user_ponsel1 = cursor.getString(10);
            user_ponsel2 = cursor.getString(11);
            user_provider1 = cursor.getString(12);
            user_provider2 = cursor.getString(13);
            user_joindate = cursor.getString(14);
            user_profile_update = cursor.getString(15);
            menu_profil.setVisibility(0);
            menu_username.setText((new StringBuilder()).append(username).toString());
            menu_ponsel_pengguna.setText((new StringBuilder()).append(user_ponsel1).toString());
            menu_sim_pengguna.setText((new StringBuilder()).append(user_provider1).toString());
            BaseDrawer.access$1(BaseDrawer.this);
            if (db.getGroupChatCount() > 0)
            {
                Log.e("unread", "getTotalUnread");
                obj = db.getTotalUnreadGroupChat();
                ((Cursor) (obj)).moveToFirst();
                obj = ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndex("total"));
                Log.e("getGroupChatCount()", ((String) (obj)));
                if (((String) (obj)).equals("0") || ((String) (obj)).equals(""))
                {
                    txtUnreadGroupChat.setVisibility(8);
                    txtUnreadGroupChat.setText("0");
                } else
                {
                    txtUnreadGroupChat.setText(((CharSequence) (obj)));
                    txtUnreadGroupChat.setVisibility(0);
                }
            } else
            {
                obj = getApplicationContext().getSharedPreferences("UnreadGroup", 0).getString("unread_group", null);
                if (((String) (obj)).equals("0") || ((String) (obj)).equals(""))
                {
                    txtUnreadGroupChat.setVisibility(8);
                    txtUnreadGroupChat.setText("0");
                } else
                {
                    txtUnreadGroupChat.setText(((CharSequence) (obj)));
                    txtUnreadGroupChat.setVisibility(0);
                }
            }
            if (db.getInBoxCount() > 0)
            {
                obj = db.getTotalUnread();
                ((Cursor) (obj)).moveToFirst();
                obj = ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndex("total"));
                if (((String) (obj)).equals("0") || ((String) (obj)).equals(""))
                {
                    txtUnreadCount.setVisibility(8);
                } else
                {
                    txtUnreadCount.setText(((CharSequence) (obj)));
                    txtUnreadCount.setVisibility(0);
                }
            } else
            {
                Object obj1 = db.getTotalUnreadSQLSEQ();
                ((Cursor) (obj1)).moveToFirst();
                obj1 = ((Cursor) (obj1)).getString(((Cursor) (obj1)).getColumnIndex("total"));
                if (((String) (obj1)).equals("0") || ((String) (obj1)).equals(""))
                {
                    txtUnreadCount.setVisibility(8);
                } else
                {
                    txtUnreadCount.setText(((CharSequence) (obj1)));
                    txtUnreadCount.setVisibility(0);
                }
            }
            Log.e("user_photo", user_photo);
            imageLoader2.displayImage((new StringBuilder("http://tools.inponsel.com/thumb/thumb.php?w=300&src=")).append(user_photo.trim()).toString(), menu_imgProfil, options, animateFirstListener);
            menu_profil.setVisibility(0);
            menu_LoginRegister.setVisibility(8);
            menu_Bookmark.setVisibility(0);
            menu_pesan.setVisibility(0);
            menu_GroupChat.setVisibility(0);
            if (!ponselBaseApp.getObserver().getUpdateType().equals("inboxchatroom"))
            {
                userContentFavorit();
            }
            return;
        } else
        {
            menu_GroupChat.setVisibility(8);
            menu_pesan.setVisibility(8);
            menu_LoginRegister.setVisibility(0);
            menu_Bookmark.setVisibility(8);
            menu_Setting.setVisibility(8);
            menu_profil.setVisibility(8);
            return;
        }
    }

    rver()
    {
        this$0 = BaseDrawer.this;
        super();
    }
}
