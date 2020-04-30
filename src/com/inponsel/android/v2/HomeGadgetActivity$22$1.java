// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

// Referenced classes of package com.inponsel.android.v2:
//            HomeGadgetActivity

class this._cls1
    implements Callback
{

    final this._cls1 this$1;

    public void onError()
    {
    }

    public void onSuccess()
    {
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/HomeGadgetActivity$22

/* anonymous class */
    class HomeGadgetActivity._cls22
        implements Runnable
    {

        final HomeGadgetActivity this$0;

        public void run()
        {
            Log.e("updateObserverLogin", "HomeGadgetActivity");
            if (userFunctions.isUserLoggedIn(getApplicationContext()))
            {
                cursor = db.getAllData();
                cursor.moveToFirst();
                invalidateOptionsMenu();
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
                Picasso.with(HomeGadgetActivity.this).load(user_photo.trim()).tag(HomeGadgetActivity.this).into(menu_imgProfil, new HomeGadgetActivity._cls22._cls1());
                menu_profil.setVisibility(0);
                menu_LoginRegister.setVisibility(8);
                menu_Bookmark.setVisibility(0);
                menu_pesan.setVisibility(0);
                menu_GroupChat.setVisibility(0);
                if (db.getInBoxCount() > 0)
                {
                    Log.e("unread", "getTotalUnread");
                    obj = db.getTotalUnread();
                    ((Cursor) (obj)).moveToFirst();
                    obj = ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndex("total"));
                    if (((String) (obj)).equals("0") || ((String) (obj)).equals(""))
                    {
                        txtUnreadCount.setVisibility(8);
                        txtUnreadCount.setText("0");
                    } else
                    {
                        txtUnreadCount.setText(((CharSequence) (obj)));
                        txtUnreadCount.setVisibility(0);
                    }
                } else
                {
                    Log.e("unread", "getTotalUnreadSQLSEQ");
                    obj = db.getTotalUnreadSQLSEQ();
                    ((Cursor) (obj)).moveToFirst();
                    obj = ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndex("total"));
                    if (((String) (obj)).equals("0") || ((String) (obj)).equals(""))
                    {
                        txtUnreadCount.setVisibility(8);
                        txtUnreadCount.setText("0");
                    } else
                    {
                        txtUnreadCount.setText(((CharSequence) (obj)));
                        txtUnreadCount.setVisibility(0);
                    }
                }
                HomeGadgetActivity.access$3(HomeGadgetActivity.this);
                if (db.getGroupChatCount() > 0)
                {
                    Log.e("getGroupChatCount", "getTotalUnread");
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
                    Log.e("prefUnreadgroup", "getTotalUnread");
                    String s = getApplicationContext().getSharedPreferences("UnreadGroup", 0).getString("unread_group", null);
                    if (s.equals("0") || s.equals(""))
                    {
                        txtUnreadGroupChat.setVisibility(8);
                        txtUnreadGroupChat.setText("0");
                    } else
                    {
                        txtUnreadGroupChat.setText(s);
                        txtUnreadGroupChat.setVisibility(0);
                    }
                }
                txtUnreadCount.getText().toString().equals("0");
                menu_Setting.setVisibility(0);
                userContentFavorit();
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

            
            {
                this$0 = HomeGadgetActivity.this;
                super();
            }
    }

}
