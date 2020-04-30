// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.widget.RoundedTransformationBuilder;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import de.hdodenhof.circleimageview.CircleImageView;

// Referenced classes of package com.inponsel.android.v2:
//            HomeNewMainActivity, ProfilePonselUserActivity, ProfileActivity

class this._cls1
    implements android.view.ivity._cls67._cls3
{

    final idePendingTransition this$1;

    public void onClick(View view)
    {
        i = new Intent(getApplicationContext(), com/inponsel/android/v2/ProfilePonselUserActivity);
        i.putExtra("namalengkap", user_ponsel1);
        startActivityForResult(i, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/HomeNewMainActivity$67

/* anonymous class */
    class HomeNewMainActivity._cls67
        implements Runnable
    {

        final HomeNewMainActivity this$0;

        public void run()
        {
            if (userFunctions.isUserLoggedIn(HomeNewMainActivity.this))
            {
                Object obj;
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
                        txtUnreadCountMenu.setVisibility(8);
                        txtUnreadCountMenu.setText("0");
                    } else
                    {
                        txtUnreadCount.setText(((CharSequence) (obj)));
                        txtUnreadCount.setVisibility(0);
                        txtUnreadCountMenu.setText(((CharSequence) (obj)));
                        txtUnreadCountMenu.setVisibility(0);
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
                        txtUnreadCountMenu.setVisibility(8);
                        txtUnreadCountMenu.setText("0");
                    } else
                    {
                        txtUnreadCount.setText(((CharSequence) (obj)));
                        txtUnreadCount.setVisibility(0);
                        txtUnreadCountMenu.setText(((CharSequence) (obj)));
                        txtUnreadCountMenu.setVisibility(0);
                    }
                }
                if (db.getGroupChatCount() > 0)
                {
                    obj = db.getTotalUnreadGroupChat();
                    ((Cursor) (obj)).moveToFirst();
                    obj = ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndex("total"));
                    if (((String) (obj)).equals("0") || ((String) (obj)).equals(""))
                    {
                        txtUnreadGroupChat.setVisibility(8);
                        txtUnreadGroupChat.setText("0");
                        txtUnreadCountgroupchat.setText("0");
                        txtUnreadCountgroupchat.setVisibility(8);
                    } else
                    {
                        txtUnreadGroupChat.setText(((CharSequence) (obj)));
                        txtUnreadGroupChat.setVisibility(0);
                        txtUnreadCountgroupchat.setVisibility(0);
                        txtUnreadCountgroupchat.setText(((CharSequence) (obj)));
                    }
                    img_user_ponsel.setVisibility(0);
                } else
                {
                    String s = getApplicationContext().getSharedPreferences("UnreadGroup", 0).getString("unread_group", null);
                    if (s.equals("0") || s.equals(""))
                    {
                        txtUnreadGroupChat.setVisibility(8);
                        txtUnreadGroupChat.setText("0");
                        txtUnreadCountgroupchat.setText("0");
                        txtUnreadCountgroupchat.setVisibility(8);
                    } else
                    {
                        txtUnreadGroupChat.setText(s);
                        txtUnreadGroupChat.setVisibility(0);
                        txtUnreadCountgroupchat.setVisibility(0);
                        txtUnreadCountgroupchat.setText(s);
                    }
                    img_user_ponsel.setVisibility(8);
                }
                HomeNewMainActivity.access$10(HomeNewMainActivity.this, (new RoundedTransformationBuilder()).borderColor(0).borderWidthDp(0.0F).cornerRadiusDp(10F).oval(false).build());
                img_user_ponsel.setOnClickListener(new HomeNewMainActivity._cls67._cls1());
                txt_user_name_1.setOnClickListener(new HomeNewMainActivity._cls67._cls2());
                txt_user_ponsel_1.setOnClickListener(new HomeNewMainActivity._cls67._cls3());
                cursor = db.getAllData();
                cursor.moveToFirst();
                username = cursor.getString(4);
                user_photo = (new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(cursor.getString(3)).toString();
                user_ponsel1 = cursor.getString(10);
                user_provider1 = cursor.getString(12);
                menu_profil.setVisibility(0);
                menu_username.setText((new StringBuilder()).append(username).toString());
                menu_ponsel_pengguna.setText((new StringBuilder()).append(user_ponsel1).toString());
                menu_sim_pengguna.setText((new StringBuilder()).append(user_provider1).toString());
                Picasso.with(HomeNewMainActivity.this).load((new StringBuilder(String.valueOf(Util.BASE_URL_THUMB2))).append(Utility.BASE_FORMAT).append("?w=").append(200).append("&src=").append(user_photo).toString()).transform(HomeNewMainActivity.access$11(HomeNewMainActivity.this)).into(img_user_ponsel, new HomeNewMainActivity._cls67._cls4());
                txt_user_name_1.setText(username);
                txt_user_ponsel_1.setText(user_ponsel1);
                txt_user_ponseldesc_1.setText("Login / Daftar");
                txt_user_name_1.setVisibility(0);
                txt_user_ponseldesc_1.setVisibility(8);
                txt_user_name_1.setVisibility(0);
                txt_user_ponsel_1.setVisibility(0);
                img_user_ponsel.setVisibility(0);
                imageLoader2.displayImage((new StringBuilder("http://tools.inponsel.com/thumb/thumb.php?w=300&src=")).append(user_photo.trim()).toString(), menu_imgProfil, options, animateFirstListener);
                menu_profil.setVisibility(0);
                menu_LoginRegister.setVisibility(8);
                menu_Bookmark.setVisibility(0);
                menu_pesan.setVisibility(0);
                ll_menu_msg.setVisibility(0);
                menu_GroupChat.setVisibility(0);
                menu_Setting.setVisibility(0);
                return;
            } else
            {
                txt_user_ponseldesc_1.setText("Login / Daftar");
                txt_user_ponseldesc_1.setVisibility(0);
                txt_user_name_1.setVisibility(8);
                menu_GroupChat.setVisibility(8);
                menu_pesan.setVisibility(8);
                ll_menu_msg.setVisibility(8);
                menu_LoginRegister.setVisibility(0);
                menu_Bookmark.setVisibility(8);
                menu_Setting.setVisibility(8);
                menu_profil.setVisibility(8);
                return;
            }
        }


            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/HomeNewMainActivity$67$1

/* anonymous class */
        class HomeNewMainActivity._cls67._cls1
            implements android.view.View.OnClickListener
        {

            final HomeNewMainActivity._cls67 this$1;

            public void onClick(View view)
            {
                i = new Intent(getApplicationContext(), com/inponsel/android/v2/ProfileActivity);
                startActivityForResult(i, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

                    
                    {
                        this$1 = HomeNewMainActivity._cls67.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/HomeNewMainActivity$67$2

/* anonymous class */
        class HomeNewMainActivity._cls67._cls2
            implements android.view.View.OnClickListener
        {

            final HomeNewMainActivity._cls67 this$1;

            public void onClick(View view)
            {
                i = new Intent(getApplicationContext(), com/inponsel/android/v2/ProfileActivity);
                startActivityForResult(i, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

                    
                    {
                        this$1 = HomeNewMainActivity._cls67.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/HomeNewMainActivity$67$4

/* anonymous class */
        class HomeNewMainActivity._cls67._cls4
            implements Callback
        {

            final HomeNewMainActivity._cls67 this$1;

            public void onError()
            {
            }

            public void onSuccess()
            {
            }

                    
                    {
                        this$1 = HomeNewMainActivity._cls67.this;
                        super();
                    }
        }

    }

}
