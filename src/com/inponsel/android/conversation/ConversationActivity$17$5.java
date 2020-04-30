// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.conversation;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;

// Referenced classes of package com.inponsel.android.conversation:
//            ConversationActivity

class this._cls1
    implements android.content.tener
{

    final this._cls1 this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }

    l.fav_stat()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/conversation/ConversationActivity$17

/* anonymous class */
    class ConversationActivity._cls17
        implements android.view.View.OnClickListener
    {

        final ConversationActivity this$0;
        private final String val$fav_stat;
        private final String val$tl_id;
        private final String val$tl_type;

        public void onClick(View view)
        {
            idkom_pos = tl_id;
            id_type = tl_type;
            if (userFunctions.isUserLoggedIn(ConversationActivity.this))
            {
                if (db.checkTimelineExist(idkom_pos) || fav_stat.equals("1"))
                {
                    view = new android.app.AlertDialog.Builder(ConversationActivity.this);
                    if (tl_type.equals("faqhp"))
                    {
                        view.setMessage("Hapus pertanyaan ini dari favorit?");
                    } else
                    {
                        view.setMessage("Hapus artikel ini dari favorit?");
                    }
                    view.setPositiveButton("Ya", new ConversationActivity._cls17._cls1());
                    view.setNegativeButton("Tidak", new ConversationActivity._cls17._cls2());
                    view.show();
                    return;
                }
                view = new android.app.AlertDialog.Builder(ConversationActivity.this);
                if (tl_type.equals("faqhp"))
                {
                    view.setMessage("Favoritkan pertanyaan ini?");
                } else
                {
                    view.setMessage("Favoritkan artikel ini?");
                }
                view.setPositiveButton("Ya", new ConversationActivity._cls17._cls3());
                view.setNeutralButton("Tidak", new ConversationActivity._cls17._cls4());
                view.show();
                return;
            } else
            {
                view = new android.app.AlertDialog.Builder(wrapperLight);
                view.setMessage("Untuk menambahkan ke favorit harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new ConversationActivity._cls17._cls5());
                view.setNeutralButton("Register", new ConversationActivity._cls17._cls6());
                view.setNegativeButton("Login", new ConversationActivity._cls17._cls7());
                view.show();
                return;
            }
        }


            
            {
                this$0 = final_conversationactivity;
                tl_id = s;
                tl_type = s1;
                fav_stat = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/conversation/ConversationActivity$17$1

/* anonymous class */
        class ConversationActivity._cls17._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final ConversationActivity._cls17 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
                stat = "0";
                (new ConversationActivity.FavoritTask(this$0)).execute(new Void[0]);
            }

                    
                    {
                        this$1 = ConversationActivity._cls17.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/conversation/ConversationActivity$17$2

/* anonymous class */
        class ConversationActivity._cls17._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final ConversationActivity._cls17 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = ConversationActivity._cls17.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/conversation/ConversationActivity$17$3

/* anonymous class */
        class ConversationActivity._cls17._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final ConversationActivity._cls17 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                stat = "1";
                (new ConversationActivity.FavoritTask(this$0)).execute(new Void[0]);
            }

                    
                    {
                        this$1 = ConversationActivity._cls17.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/conversation/ConversationActivity$17$4

/* anonymous class */
        class ConversationActivity._cls17._cls4
            implements android.content.DialogInterface.OnClickListener
        {

            final ConversationActivity._cls17 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = ConversationActivity._cls17.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/conversation/ConversationActivity$17$6

/* anonymous class */
        class ConversationActivity._cls17._cls6
            implements android.content.DialogInterface.OnClickListener
        {

            final ConversationActivity._cls17 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(this$0, com/inponsel/android/v2/RegisterActivity);
                startActivity(dialoginterface);
            }

                    
                    {
                        this$1 = ConversationActivity._cls17.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/conversation/ConversationActivity$17$7

/* anonymous class */
        class ConversationActivity._cls17._cls7
            implements android.content.DialogInterface.OnClickListener
        {

            final ConversationActivity._cls17 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(this$0, com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                startActivity(dialoginterface);
            }

                    
                    {
                        this$1 = ConversationActivity._cls17.this;
                        super();
                    }
        }

    }

}
