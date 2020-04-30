// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import com.inponsel.android.utils.UserFunctions;

// Referenced classes of package com.inponsel.android.v2:
//            RoomChatActivity, RegisterActivity, LoginActivity

class this._cls1
    implements android.content.kListener
{

    final m_id this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        statJoinChat = "0";
        RoomChatActivity.access$17(_fld0, RoomChatActivity.user_id, codename, "0", t, bottom_id);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/RoomChatActivity$14

/* anonymous class */
    class RoomChatActivity._cls14
        implements android.view.View.OnClickListener
    {

        final RoomChatActivity this$0;

        public void onClick(View view)
        {
            if (userFunctions.isUserLoggedIn(RoomChatActivity.this))
            {
                if (statJoinChat.equals("1"))
                {
                    view = new android.app.AlertDialog.Builder(RoomChatActivity.this);
                    view.setMessage("Berhenti ikuti aktivitas chat room?");
                    view.setPositiveButton("Ya", new RoomChatActivity._cls14._cls1());
                    view.setNegativeButton("Tidak", new RoomChatActivity._cls14._cls2());
                    view.show();
                    return;
                } else
                {
                    view = new android.app.AlertDialog.Builder(RoomChatActivity.this);
                    view.setMessage("Ikuti aktivitas chat room?");
                    view.setPositiveButton("Ya", new RoomChatActivity._cls14._cls3());
                    view.setNeutralButton("Tidak", new RoomChatActivity._cls14._cls4());
                    view.show();
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(RoomChatActivity.this);
                view.setMessage("Untuk berlangganan berita, diharuskan login.");
                view.setPositiveButton("Tutup", new RoomChatActivity._cls14._cls5());
                view.setNeutralButton("Register", new RoomChatActivity._cls14._cls6());
                view.setNegativeButton("Login", new RoomChatActivity._cls14._cls7());
                view.show();
                return;
            }
        }


            
            {
                this$0 = RoomChatActivity.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/RoomChatActivity$14$2

/* anonymous class */
        class RoomChatActivity._cls14._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final RoomChatActivity._cls14 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = RoomChatActivity._cls14.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/RoomChatActivity$14$3

/* anonymous class */
        class RoomChatActivity._cls14._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final RoomChatActivity._cls14 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                statJoinChat = "1";
                RoomChatActivity.access$17(this$0, RoomChatActivity.user_id, codename, "1", t, bottom_id);
            }

                    
                    {
                        this$1 = RoomChatActivity._cls14.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/RoomChatActivity$14$4

/* anonymous class */
        class RoomChatActivity._cls14._cls4
            implements android.content.DialogInterface.OnClickListener
        {

            final RoomChatActivity._cls14 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = RoomChatActivity._cls14.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/RoomChatActivity$14$5

/* anonymous class */
        class RoomChatActivity._cls14._cls5
            implements android.content.DialogInterface.OnClickListener
        {

            final RoomChatActivity._cls14 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = RoomChatActivity._cls14.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/RoomChatActivity$14$6

/* anonymous class */
        class RoomChatActivity._cls14._cls6
            implements android.content.DialogInterface.OnClickListener
        {

            final RoomChatActivity._cls14 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(this$0, com/inponsel/android/v2/RegisterActivity);
                startActivityForResult(dialoginterface, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

                    
                    {
                        this$1 = RoomChatActivity._cls14.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/RoomChatActivity$14$7

/* anonymous class */
        class RoomChatActivity._cls14._cls7
            implements android.content.DialogInterface.OnClickListener
        {

            final RoomChatActivity._cls14 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(this$0, com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                startActivityForResult(dialoginterface, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

                    
                    {
                        this$1 = RoomChatActivity._cls14.this;
                        super();
                    }
        }

    }

}
