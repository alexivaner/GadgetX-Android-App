// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.timelinedetail;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;

// Referenced classes of package com.inponsel.android.timelinedetail:
//            Hal1TLDetailActivity

class this._cls1
    implements android.content.stener
{

    final ritTask.execute this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        statFav = "0";
        (new ritTask(_fld0)).execute(new Void[0]);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/timelinedetail/Hal1TLDetailActivity$7

/* anonymous class */
    class Hal1TLDetailActivity._cls7
        implements android.view.View.OnClickListener
    {

        final Hal1TLDetailActivity this$0;

        public void onClick(View view)
        {
            if (userFunctions.isUserLoggedIn(Hal1TLDetailActivity.this))
            {
                if (db.checkTimelineExist(id_artikel) || fav_stat.equals("1"))
                {
                    view = new android.app.AlertDialog.Builder(Hal1TLDetailActivity.this);
                    if (tl_type.equals("faqhp"))
                    {
                        view.setMessage("Hapus pertanyaan ini dari favorit?");
                    } else
                    {
                        view.setMessage("Hapus artikel ini dari favorit?");
                    }
                    view.setPositiveButton("Ya", new Hal1TLDetailActivity._cls7._cls1());
                    view.setNegativeButton("Tidak", new Hal1TLDetailActivity._cls7._cls2());
                    view.show();
                    return;
                }
                view = new android.app.AlertDialog.Builder(Hal1TLDetailActivity.this);
                if (tl_type.equals("faqhp"))
                {
                    view.setMessage("Favoritkan pertanyaan ini?");
                } else
                {
                    view.setMessage("Favoritkan artikel ini?");
                }
                view.setPositiveButton("Ya", new Hal1TLDetailActivity._cls7._cls3());
                view.setNeutralButton("Tidak", new Hal1TLDetailActivity._cls7._cls4());
                view.show();
                return;
            } else
            {
                view = new android.app.AlertDialog.Builder(Hal1TLDetailActivity.this);
                view.setMessage("Untuk menambahkan ke favorit harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new Hal1TLDetailActivity._cls7._cls5());
                view.setNeutralButton("Register", new Hal1TLDetailActivity._cls7._cls6());
                view.setNegativeButton("Login", new Hal1TLDetailActivity._cls7._cls7());
                view.show();
                return;
            }
        }


            
            {
                this$0 = Hal1TLDetailActivity.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/timelinedetail/Hal1TLDetailActivity$7$2

/* anonymous class */
        class Hal1TLDetailActivity._cls7._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal1TLDetailActivity._cls7 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = Hal1TLDetailActivity._cls7.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/timelinedetail/Hal1TLDetailActivity$7$3

/* anonymous class */
        class Hal1TLDetailActivity._cls7._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal1TLDetailActivity._cls7 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                statFav = "1";
                (new Hal1TLDetailActivity.FavoritTask(this$0)).execute(new Void[0]);
            }

                    
                    {
                        this$1 = Hal1TLDetailActivity._cls7.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/timelinedetail/Hal1TLDetailActivity$7$4

/* anonymous class */
        class Hal1TLDetailActivity._cls7._cls4
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal1TLDetailActivity._cls7 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = Hal1TLDetailActivity._cls7.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/timelinedetail/Hal1TLDetailActivity$7$5

/* anonymous class */
        class Hal1TLDetailActivity._cls7._cls5
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal1TLDetailActivity._cls7 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = Hal1TLDetailActivity._cls7.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/timelinedetail/Hal1TLDetailActivity$7$6

/* anonymous class */
        class Hal1TLDetailActivity._cls7._cls6
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal1TLDetailActivity._cls7 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(this$0, com/inponsel/android/v2/RegisterActivity);
                startActivity(dialoginterface);
            }

                    
                    {
                        this$1 = Hal1TLDetailActivity._cls7.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/timelinedetail/Hal1TLDetailActivity$7$7

/* anonymous class */
        class Hal1TLDetailActivity._cls7._cls7
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal1TLDetailActivity._cls7 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(this$0, com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                startActivity(dialoginterface);
            }

                    
                    {
                        this$1 = Hal1TLDetailActivity._cls7.this;
                        super();
                    }
        }

    }

}
