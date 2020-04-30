// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.UserFunctions;

// Referenced classes of package com.inponsel.android.v2:
//            ProfileOtherUser, InboxMessageActivity, MessageActivity, RegisterActivity, 
//            LoginActivity

class this._cls1
    implements android.content.ckListener
{

    final er this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/ProfileOtherUser$9

/* anonymous class */
    class ProfileOtherUser._cls9
        implements android.view.View.OnClickListener
    {

        final ProfileOtherUser this$0;

        public void onClick(View view)
        {
            if (userFunctions.isUserLoggedIn(ProfileOtherUser.this))
            {
                if (strMeStat.equals("yes"))
                {
                    i = new Intent(getApplicationContext(), com/inponsel/android/v2/InboxMessageActivity);
                    startActivityForResult(i, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                    return;
                } else
                {
                    i = new Intent(getApplicationContext(), com/inponsel/android/v2/MessageActivity);
                    i.putExtra("id_msg", "");
                    i.putExtra("id_to", str_id_user);
                    i.putExtra("to_name", username);
                    i.putExtra("to_photo", user_photo);
                    i.putExtra("id_from", user_id);
                    i.putExtra("from_name", str_username);
                    i.putExtra("from_photo", str_srcimguser.trim());
                    i.putExtra("last_message", "");
                    i.putExtra("message_type", "");
                    i.putExtra("unread_msg", "");
                    i.putExtra("msg_date", "");
                    Log.e("id_to", str_id_user);
                    Log.e("id_from", user_id);
                    startActivityForResult(i, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(ProfileOtherUser.this);
                view.setMessage("Untuk mengirim pesan harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new ProfileOtherUser._cls9._cls1());
                view.setNeutralButton("Register", new ProfileOtherUser._cls9._cls2());
                view.setNegativeButton("Login", new ProfileOtherUser._cls9._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$0 = ProfileOtherUser.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/ProfileOtherUser$9$2

/* anonymous class */
        class ProfileOtherUser._cls9._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final ProfileOtherUser._cls9 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(this$0, com/inponsel/android/v2/RegisterActivity);
                startActivityForResult(dialoginterface, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

                    
                    {
                        this$1 = ProfileOtherUser._cls9.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/ProfileOtherUser$9$3

/* anonymous class */
        class ProfileOtherUser._cls9._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final ProfileOtherUser._cls9 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(this$0, com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                startActivityForResult(dialoginterface, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

                    
                    {
                        this$1 = ProfileOtherUser._cls9.this;
                        super();
                    }
        }

    }

}
