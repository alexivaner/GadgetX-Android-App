// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.tlforum;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;

// Referenced classes of package com.inponsel.android.tlforum:
//            ForumHPActivity

class this._cls1
    implements android.content.ckListener
{

    final Activity this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
        startActivity(dialoginterface);
    }

    l.fav_stat()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/tlforum/ForumHPActivity$36

/* anonymous class */
    class ForumHPActivity._cls36
        implements android.view.View.OnClickListener
    {

        final ForumHPActivity this$0;
        private final String val$fav_stat;
        private final String val$tl_id;
        private final String val$tl_type;

        public void onClick(View view)
        {
            idkom_pos = tl_id;
            id_type = tl_type;
            if (userFunctions.isUserLoggedIn(ForumHPActivity.this))
            {
                if (db.checkTimelineExist(idkom_pos) || fav_stat.equals("1"))
                {
                    view = new android.app.AlertDialog.Builder(ForumHPActivity.this);
                    if (tl_type.equals("faqhp"))
                    {
                        view.setMessage("Hapus pertanyaan ini dari favorit?");
                    } else
                    {
                        view.setMessage("Hapus artikel ini dari favorit?");
                    }
                    view.setPositiveButton("Ya", new ForumHPActivity._cls36._cls1());
                    view.setNegativeButton("Tidak", new ForumHPActivity._cls36._cls2());
                    view.show();
                    return;
                }
                view = new android.app.AlertDialog.Builder(ForumHPActivity.this);
                if (tl_type.equals("faqhp"))
                {
                    view.setMessage("Favoritkan pertanyaan ini?");
                } else
                {
                    view.setMessage("Favoritkan artikel ini?");
                }
                view.setPositiveButton("Ya", new ForumHPActivity._cls36._cls3());
                view.setNeutralButton("Tidak", new ForumHPActivity._cls36._cls4());
                view.show();
                return;
            } else
            {
                view = new android.app.AlertDialog.Builder(wrapperLight);
                view.setMessage("Untuk menambahkan ke favorit harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new ForumHPActivity._cls36._cls5());
                view.setNeutralButton("Register", new ForumHPActivity._cls36._cls6());
                view.setNegativeButton("Login", new ForumHPActivity._cls36._cls7());
                view.show();
                return;
            }
        }


            
            {
                this$0 = final_forumhpactivity;
                tl_id = s;
                tl_type = s1;
                fav_stat = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/tlforum/ForumHPActivity$36$1

/* anonymous class */
        class ForumHPActivity._cls36._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final ForumHPActivity._cls36 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
                stat = "0";
                (new ForumHPActivity.FavoritTask(this$0)).execute(new Void[0]);
            }

                    
                    {
                        this$1 = ForumHPActivity._cls36.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/tlforum/ForumHPActivity$36$2

/* anonymous class */
        class ForumHPActivity._cls36._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final ForumHPActivity._cls36 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = ForumHPActivity._cls36.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/tlforum/ForumHPActivity$36$3

/* anonymous class */
        class ForumHPActivity._cls36._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final ForumHPActivity._cls36 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                stat = "1";
                (new ForumHPActivity.FavoritTask(this$0)).execute(new Void[0]);
            }

                    
                    {
                        this$1 = ForumHPActivity._cls36.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/tlforum/ForumHPActivity$36$4

/* anonymous class */
        class ForumHPActivity._cls36._cls4
            implements android.content.DialogInterface.OnClickListener
        {

            final ForumHPActivity._cls36 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = ForumHPActivity._cls36.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/tlforum/ForumHPActivity$36$5

/* anonymous class */
        class ForumHPActivity._cls36._cls5
            implements android.content.DialogInterface.OnClickListener
        {

            final ForumHPActivity._cls36 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = ForumHPActivity._cls36.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/tlforum/ForumHPActivity$36$7

/* anonymous class */
        class ForumHPActivity._cls36._cls7
            implements android.content.DialogInterface.OnClickListener
        {

            final ForumHPActivity._cls36 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(this$0, com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                startActivity(dialoginterface);
            }

                    
                    {
                        this$1 = ForumHPActivity._cls36.this;
                        super();
                    }
        }

    }

}
