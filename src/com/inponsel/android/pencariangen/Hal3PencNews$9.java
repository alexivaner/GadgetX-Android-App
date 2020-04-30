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

class val.txt_fav_news_1
    implements android.view.tener
{

    final Hal3PencNews this$0;
    private final String val$id_rss;
    private final String val$rss_srclink;
    private final TextView val$txt_fav_news_1;

    public void onClick(View view)
    {
        idkom_pos = val$id_rss;
        str_srclink = val$rss_srclink;
        if (userFunctions.isUserLoggedIn(getActivity()))
        {
            if (val$txt_fav_news_1.getText().toString().equals("1"))
            {
                view = new android.app.lder(getActivity());
                view.setMessage("Hapus berita ini dari favorit?");
                view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

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
                });
                view.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                    final Hal3PencNews._cls9 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface.dismiss();
                    }

            
            {
                this$1 = Hal3PencNews._cls9.this;
                super();
            }
                });
                view.show();
                return;
            } else
            {
                view = new android.app.lder(getActivity());
                view.setMessage("Favoritkan berita ini?");
                view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

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
                });
                view.setNeutralButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                    final Hal3PencNews._cls9 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface.dismiss();
                    }

            
            {
                this$1 = Hal3PencNews._cls9.this;
                super();
            }
                });
                view.show();
                return;
            }
        } else
        {
            view = new android.app.lder(wrapperLight);
            view.setMessage("Untuk menambahkan ke favorit harus login terlebih dahulu.");
            view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                final Hal3PencNews._cls9 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$1 = Hal3PencNews._cls9.this;
                super();
            }
            });
            view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

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
            });
            view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

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
            });
            view.show();
            return;
        }
    }


    _cls7.this._cls1()
    {
        this$0 = final_hal3pencnews;
        val$id_rss = s;
        val$rss_srclink = s1;
        val$txt_fav_news_1 = TextView.this;
        super();
    }
}
