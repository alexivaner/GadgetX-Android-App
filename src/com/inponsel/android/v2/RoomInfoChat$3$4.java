// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import com.inponsel.android.utils.UserFunctions;

// Referenced classes of package com.inponsel.android.v2:
//            RoomInfoChat, RegisterActivity, LoginActivity

class this._cls1
    implements android.content.nClickListener
{

    final stener this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/RoomInfoChat$3

/* anonymous class */
    class RoomInfoChat._cls3
        implements android.view.View.OnClickListener
    {

        final RoomInfoChat this$0;

        public void onClick(View view)
        {
            if (userFunctions.isUserLoggedIn(RoomInfoChat.this))
            {
                if (statJoinChat.equals("1"))
                {
                    view = new android.app.AlertDialog.Builder(RoomInfoChat.this);
                    view.setMessage("Berhenti ikuti aktivitas chat room?");
                    view.setPositiveButton("Ya", new RoomInfoChat._cls3._cls1());
                    view.setNegativeButton("Tidak", new RoomInfoChat._cls3._cls2());
                    view.show();
                    return;
                } else
                {
                    view = new android.app.AlertDialog.Builder(RoomInfoChat.this);
                    view.setMessage("Ikuti aktivitas chat room?");
                    view.setPositiveButton("Ya", new RoomInfoChat._cls3._cls3());
                    view.setNeutralButton("Tidak", new RoomInfoChat._cls3._cls4());
                    view.show();
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(RoomInfoChat.this);
                view.setMessage("Untuk berlangganan berita, diharuskan login.");
                view.setPositiveButton("Tutup", new RoomInfoChat._cls3._cls5());
                view.setNeutralButton("Register", new RoomInfoChat._cls3._cls6());
                view.setNegativeButton("Login", new RoomInfoChat._cls3._cls7());
                view.show();
                return;
            }
        }


            
            {
                this$0 = RoomInfoChat.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/RoomInfoChat$3$1

/* anonymous class */
        class RoomInfoChat._cls3._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final RoomInfoChat._cls3 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
                statJoinChat = "0";
                RoomInfoChat.access$2(this$0, user_id, codename, "0", t, bottom_id);
            }

                    
                    {
                        this$1 = RoomInfoChat._cls3.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/RoomInfoChat$3$2

/* anonymous class */
        class RoomInfoChat._cls3._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final RoomInfoChat._cls3 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = RoomInfoChat._cls3.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/RoomInfoChat$3$3

/* anonymous class */
        class RoomInfoChat._cls3._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final RoomInfoChat._cls3 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                statJoinChat = "1";
                RoomInfoChat.access$2(this$0, user_id, codename, "1", t, bottom_id);
            }

                    
                    {
                        this$1 = RoomInfoChat._cls3.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/RoomInfoChat$3$5

/* anonymous class */
        class RoomInfoChat._cls3._cls5
            implements android.content.DialogInterface.OnClickListener
        {

            final RoomInfoChat._cls3 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = RoomInfoChat._cls3.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/RoomInfoChat$3$6

/* anonymous class */
        class RoomInfoChat._cls3._cls6
            implements android.content.DialogInterface.OnClickListener
        {

            final RoomInfoChat._cls3 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(this$0, com/inponsel/android/v2/RegisterActivity);
                startActivityForResult(dialoginterface, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

                    
                    {
                        this$1 = RoomInfoChat._cls3.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/RoomInfoChat$3$7

/* anonymous class */
        class RoomInfoChat._cls3._cls7
            implements android.content.DialogInterface.OnClickListener
        {

            final RoomInfoChat._cls3 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(this$0, com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                startActivityForResult(dialoginterface, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

                    
                    {
                        this$1 = RoomInfoChat._cls3.this;
                        super();
                    }
        }

    }

}
