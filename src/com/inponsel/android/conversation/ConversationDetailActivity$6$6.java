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
//            ConversationDetailActivity

class this._cls1
    implements android.content.
{

    final tActivity this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
        startActivity(dialoginterface);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/conversation/ConversationDetailActivity$6

/* anonymous class */
    class ConversationDetailActivity._cls6
        implements android.view.View.OnClickListener
    {

        final ConversationDetailActivity this$0;

        public void onClick(View view)
        {
            if (userFunctions.isUserLoggedIn(ConversationDetailActivity.this))
            {
                if (db.checkTimelineExist(id_artikel) || fav_stat.equals("1"))
                {
                    view = new android.app.AlertDialog.Builder(ConversationDetailActivity.this);
                    if (tl_type.equals("faqhp"))
                    {
                        view.setMessage("Hapus pertanyaan ini dari favorit?");
                    } else
                    {
                        view.setMessage("Hapus artikel ini dari favorit?");
                    }
                    view.setPositiveButton("Ya", new ConversationDetailActivity._cls6._cls1());
                    view.setNegativeButton("Tidak", new ConversationDetailActivity._cls6._cls2());
                    view.show();
                    return;
                }
                view = new android.app.AlertDialog.Builder(ConversationDetailActivity.this);
                if (tl_type.equals("faqhp"))
                {
                    view.setMessage("Favoritkan pertanyaan ini?");
                } else
                {
                    view.setMessage("Favoritkan artikel ini?");
                }
                view.setPositiveButton("Ya", new ConversationDetailActivity._cls6._cls3());
                view.setNeutralButton("Tidak", new ConversationDetailActivity._cls6._cls4());
                view.show();
                return;
            } else
            {
                view = new android.app.AlertDialog.Builder(ConversationDetailActivity.this);
                view.setMessage("Untuk menambahkan ke favorit harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new ConversationDetailActivity._cls6._cls5());
                view.setNeutralButton("Register", new ConversationDetailActivity._cls6._cls6());
                view.setNegativeButton("Login", new ConversationDetailActivity._cls6._cls7());
                view.show();
                return;
            }
        }


            
            {
                this$0 = ConversationDetailActivity.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/conversation/ConversationDetailActivity$6$1

/* anonymous class */
        class ConversationDetailActivity._cls6._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final ConversationDetailActivity._cls6 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
                statFav = "0";
                (new ConversationDetailActivity.FavoritTask(this$0)).execute(new Void[0]);
            }

                    
                    {
                        this$1 = ConversationDetailActivity._cls6.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/conversation/ConversationDetailActivity$6$2

/* anonymous class */
        class ConversationDetailActivity._cls6._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final ConversationDetailActivity._cls6 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = ConversationDetailActivity._cls6.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/conversation/ConversationDetailActivity$6$3

/* anonymous class */
        class ConversationDetailActivity._cls6._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final ConversationDetailActivity._cls6 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                statFav = "1";
                (new ConversationDetailActivity.FavoritTask(this$0)).execute(new Void[0]);
            }

                    
                    {
                        this$1 = ConversationDetailActivity._cls6.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/conversation/ConversationDetailActivity$6$4

/* anonymous class */
        class ConversationDetailActivity._cls6._cls4
            implements android.content.DialogInterface.OnClickListener
        {

            final ConversationDetailActivity._cls6 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = ConversationDetailActivity._cls6.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/conversation/ConversationDetailActivity$6$5

/* anonymous class */
        class ConversationDetailActivity._cls6._cls5
            implements android.content.DialogInterface.OnClickListener
        {

            final ConversationDetailActivity._cls6 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = ConversationDetailActivity._cls6.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/conversation/ConversationDetailActivity$6$7

/* anonymous class */
        class ConversationDetailActivity._cls6._cls7
            implements android.content.DialogInterface.OnClickListener
        {

            final ConversationDetailActivity._cls6 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(this$0, com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                startActivity(dialoginterface);
            }

                    
                    {
                        this$1 = ConversationDetailActivity._cls6.this;
                        super();
                    }
        }

    }

}
