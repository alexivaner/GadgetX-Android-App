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

class this._cls0
    implements android.view.tener
{

    final RoomInfoChat this$0;

    public void onClick(View view)
    {
        if (userFunctions.isUserLoggedIn(RoomInfoChat.this))
        {
            if (statJoinChat.equals("1"))
            {
                view = new android.app.lder(RoomInfoChat.this);
                view.setMessage("Berhenti ikuti aktivitas chat room?");
                view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

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
                });
                view.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                    final RoomInfoChat._cls3 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface.dismiss();
                    }

            
            {
                this$1 = RoomInfoChat._cls3.this;
                super();
            }
                });
                view.show();
                return;
            } else
            {
                view = new android.app.lder(RoomInfoChat.this);
                view.setMessage("Ikuti aktivitas chat room?");
                view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

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
                });
                view.setNeutralButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                    final RoomInfoChat._cls3 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface.dismiss();
                    }

            
            {
                this$1 = RoomInfoChat._cls3.this;
                super();
            }
                });
                view.show();
                return;
            }
        } else
        {
            view = new android.app.lder(RoomInfoChat.this);
            view.setMessage("Untuk berlangganan berita, diharuskan login.");
            view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                final RoomInfoChat._cls3 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$1 = RoomInfoChat._cls3.this;
                super();
            }
            });
            view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

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
            });
            view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

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
            });
            view.show();
            return;
        }
    }


    _cls7.this._cls1()
    {
        this$0 = RoomInfoChat.this;
        super();
    }
}