// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.pencariangen;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;

// Referenced classes of package com.inponsel.android.pencariangen:
//            Hal3PencNews

class this._cls1
    implements android.content.nClickListener
{

    final this._cls1 this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }

    l.txt_fav_news_1()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/pencariangen/Hal3PencNews$9

/* anonymous class */
    class Hal3PencNews._cls9
        implements android.view.View.OnClickListener
    {

        final Hal3PencNews this$0;
        private final String val$id_rss;
        private final String val$rss_srclink;
        private final TextView val$txt_fav_news_1;

        public void onClick(View view)
        {
            idkom_pos = id_rss;
            str_srclink = rss_srclink;
            if (userFunctions.isUserLoggedIn(getActivity()))
            {
                if (txt_fav_news_1.getText().toString().equals("1"))
                {
                    view = new android.app.AlertDialog.Builder(getActivity());
                    view.setMessage("Hapus berita ini dari favorit?");
                    view.setPositiveButton("Ya", new Hal3PencNews._cls9._cls1());
                    view.setNegativeButton("Tidak", new Hal3PencNews._cls9._cls2());
                    view.show();
                    return;
                } else
                {
                    view = new android.app.AlertDialog.Builder(getActivity());
                    view.setMessage("Favoritkan berita ini?");
                    view.setPositiveButton("Ya", new Hal3PencNews._cls9._cls3());
                    view.setNeutralButton("Tidak", new Hal3PencNews._cls9._cls4());
                    view.show();
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(wrapperLight);
                view.setMessage("Untuk menambahkan ke favorit harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new Hal3PencNews._cls9._cls5());
                view.setNeutralButton("Register", new Hal3PencNews._cls9._cls6());
                view.setNegativeButton("Login", new Hal3PencNews._cls9._cls7());
                view.show();
                return;
            }
        }


            
            {
                this$0 = final_hal3pencnews;
                id_rss = s;
                rss_srclink = s1;
                txt_fav_news_1 = TextView.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/pencariangen/Hal3PencNews$9$1

/* anonymous class */
        class Hal3PencNews._cls9._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal3PencNews._cls9 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
                stat = "0";
                (new Hal3PencNews.FavoritTask(this$0)).execute(new Void[0]);
            }

                    
                    {
                        this$1 = Hal3PencNews._cls9.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/pencariangen/Hal3PencNews$9$3

/* anonymous class */
        class Hal3PencNews._cls9._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal3PencNews._cls9 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                stat = "1";
                (new Hal3PencNews.FavoritTask(this$0)).execute(new Void[0]);
            }

                    
                    {
                        this$1 = Hal3PencNews._cls9.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/pencariangen/Hal3PencNews$9$4

/* anonymous class */
        class Hal3PencNews._cls9._cls4
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal3PencNews._cls9 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = Hal3PencNews._cls9.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/pencariangen/Hal3PencNews$9$5

/* anonymous class */
        class Hal3PencNews._cls9._cls5
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal3PencNews._cls9 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = Hal3PencNews._cls9.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/pencariangen/Hal3PencNews$9$6

/* anonymous class */
        class Hal3PencNews._cls9._cls6
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal3PencNews._cls9 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                startActivity(dialoginterface);
            }

                    
                    {
                        this$1 = Hal3PencNews._cls9.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/pencariangen/Hal3PencNews$9$7

/* anonymous class */
        class Hal3PencNews._cls9._cls7
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal3PencNews._cls9 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                startActivity(dialoginterface);
            }

                    
                    {
                        this$1 = Hal3PencNews._cls9.this;
                        super();
                    }
        }

    }

}
