// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.rssfeeddetail;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;

// Referenced classes of package com.inponsel.android.rssfeeddetail:
//            Hal1RSSDetail

class this._cls1
    implements android.content.lickListener
{

    final this._cls1 this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/rssfeeddetail/Hal1RSSDetail$13

/* anonymous class */
    class Hal1RSSDetail._cls13
        implements android.view.View.OnClickListener
    {

        final Hal1RSSDetail this$0;

        public void onClick(View view)
        {
            idkom_pos = id_rss;
            str_srclink = rss_srclink;
            if (userFunctions.isUserLoggedIn(getActivity()))
            {
                if (db.checkIfExistRSS(idkom_pos) || fav_stat.equals("1"))
                {
                    view = new android.app.AlertDialog.Builder(getActivity());
                    view.setMessage("Hapus berita ini dari favorit?");
                    view.setPositiveButton("Ya", new Hal1RSSDetail._cls13._cls1());
                    view.setNegativeButton("Tidak", new Hal1RSSDetail._cls13._cls2());
                    view.show();
                    return;
                } else
                {
                    view = new android.app.AlertDialog.Builder(getActivity());
                    view.setMessage("Favoritkan berita ini?");
                    view.setPositiveButton("Ya", new Hal1RSSDetail._cls13._cls3());
                    view.setNeutralButton("Tidak", new Hal1RSSDetail._cls13._cls4());
                    view.show();
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(getActivity());
                view.setMessage("Untuk menambahkan ke favorit harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new Hal1RSSDetail._cls13._cls5());
                view.setNeutralButton("Register", new Hal1RSSDetail._cls13._cls6());
                view.setNegativeButton("Login", new Hal1RSSDetail._cls13._cls7());
                view.show();
                return;
            }
        }


            
            {
                this$0 = Hal1RSSDetail.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/rssfeeddetail/Hal1RSSDetail$13$1

/* anonymous class */
        class Hal1RSSDetail._cls13._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal1RSSDetail._cls13 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
                statFav = "0";
                (new Hal1RSSDetail.FavoritTask(this$0)).execute(new Void[0]);
            }

                    
                    {
                        this$1 = Hal1RSSDetail._cls13.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/rssfeeddetail/Hal1RSSDetail$13$3

/* anonymous class */
        class Hal1RSSDetail._cls13._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal1RSSDetail._cls13 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                statFav = "1";
                (new Hal1RSSDetail.FavoritTask(this$0)).execute(new Void[0]);
            }

                    
                    {
                        this$1 = Hal1RSSDetail._cls13.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/rssfeeddetail/Hal1RSSDetail$13$4

/* anonymous class */
        class Hal1RSSDetail._cls13._cls4
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal1RSSDetail._cls13 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = Hal1RSSDetail._cls13.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/rssfeeddetail/Hal1RSSDetail$13$5

/* anonymous class */
        class Hal1RSSDetail._cls13._cls5
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal1RSSDetail._cls13 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = Hal1RSSDetail._cls13.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/rssfeeddetail/Hal1RSSDetail$13$6

/* anonymous class */
        class Hal1RSSDetail._cls13._cls6
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal1RSSDetail._cls13 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                startActivity(dialoginterface);
            }

                    
                    {
                        this$1 = Hal1RSSDetail._cls13.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/rssfeeddetail/Hal1RSSDetail$13$7

/* anonymous class */
        class Hal1RSSDetail._cls13._cls7
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal1RSSDetail._cls13 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                startActivity(dialoginterface);
            }

                    
                    {
                        this$1 = Hal1RSSDetail._cls13.this;
                        super();
                    }
        }

    }

}
