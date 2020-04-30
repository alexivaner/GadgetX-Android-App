// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.adapter;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.NotificationLikeHelper;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import org.apache.http.Header;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.adapter:
//            ListKategoriApps2Adapter, ListModel, PonselBaseApp, ModelObserver

class this._cls1
    implements android.content.er
{

    final this._cls1 this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }

    l.position()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/adapter/ListKategoriApps2Adapter$3

/* anonymous class */
    class ListKategoriApps2Adapter._cls3
        implements android.view.View.OnClickListener
    {

        final ListKategoriApps2Adapter this$0;
        private final ListKategoriApps2Adapter.ViewHolder val$holder;
        private final int val$position;

        public void onClick(final View urlPost)
        {
            if (userFunctions.isUserLoggedIn(ListKategoriApps2Adapter.access$0(ListKategoriApps2Adapter.this)))
            {
                Log.e("postfav", holder.txt_fav_kat_apps_1.getText().toString());
                if (holder.txt_fav_kat_apps_1.getText().toString().equals("1"))
                {
                    fav_stat = "0";
                } else
                {
                    fav_stat = "1";
                }
                urlPost = (new StringBuilder(String.valueOf(Util.BASE_PATH_STORE))).append("add_fav_applist.php?").append("t=f7c1ffed723d0578eca7f57388c8054d4fed52a7&id_user=").append(user_id).append("&status=").append(fav_stat).append("&id_kat=").append(getListModel(position).getId_apps()).toString();
                (new AsyncHttpClient()).get(urlPost, new ListKategoriApps2Adapter._cls3._cls1());
                return;
            } else
            {
                urlPost = new android.app.AlertDialog.Builder(ListKategoriApps2Adapter.access$0(ListKategoriApps2Adapter.this));
                urlPost.setMessage("Untuk menambah ke favorit harus login terlebih dahulu.");
                urlPost.setPositiveButton("Tutup", new ListKategoriApps2Adapter._cls3._cls2());
                urlPost.setNeutralButton("Register", new ListKategoriApps2Adapter._cls3._cls3());
                urlPost.setNegativeButton("Login", new ListKategoriApps2Adapter._cls3._cls4());
                urlPost.show();
                return;
            }
        }


            
            {
                this$0 = final_listkategoriapps2adapter;
                holder = viewholder;
                position = I.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/adapter/ListKategoriApps2Adapter$3$1

/* anonymous class */
        class ListKategoriApps2Adapter._cls3._cls1 extends AsyncHttpResponseHandler
        {

            final ListKategoriApps2Adapter._cls3 this$1;
            private final ListKategoriApps2Adapter.ViewHolder val$holder;
            private final int val$position;
            private final String val$urlPost;

            public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
            {
            }

            public void onRetry(int i)
            {
            }

            public void onStart()
            {
                if (fav_stat.equals("1"))
                {
                    notificationLikeHelper.createNotification(getListModel(position).getKat_apps_name(), "Menambahkan ke favorit");
                } else
                {
                    notificationLikeHelper.createNotification(getListModel(position).getKat_apps_name(), "Menghapus ke favorit");
                }
                Log.e("urlPost", urlPost);
            }

            public void onSuccess(int i, Header aheader[], byte abyte0[])
            {
                aheader = new String(abyte0);
                Log.e("respJson", aheader);
                try
                {
                    aheader = new JSONObject(aheader);
                    fav_stat = aheader.getString("success");
                    holder.txt_fav_kat_apps_1.setText(fav_stat);
                }
                // Misplaced declaration of an exception variable
                catch (Header aheader[]) { }
                if (fav_stat.equals("0"))
                {
                    holder.img_fav_apps_1.setBackgroundResource(0x7f020302);
                } else
                {
                    holder.img_fav_apps_1.setBackgroundResource(0x7f020303);
                }
                if (holder.txt_fav_kat_apps_1.getText().toString().equals("1"))
                {
                    notificationLikeHelper.completed(getListModel(position).getKat_apps_name(), "Berhasil menambahkan ke favorit");
                } else
                {
                    notificationLikeHelper.completed(getListModel(position).getKat_apps_name(), "Berhasil menghapus ke favorit");
                }
                ponselBaseApp.setObserver().setIndexHp(getListModel(position).getId_apps());
                ponselBaseApp.setObserver().setUpdateType("favappsstore");
                ponselBaseApp.setObserver().setStatus_like_ponsel(fav_stat);
                ponselBaseApp.setObserver().setStatus_like_ponsel(holder.txt_fav_kat_apps_1.getText().toString());
            }

                    
                    {
                        this$1 = ListKategoriApps2Adapter._cls3.this;
                        position = i;
                        urlPost = s;
                        holder = viewholder;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/adapter/ListKategoriApps2Adapter$3$3

/* anonymous class */
        class ListKategoriApps2Adapter._cls3._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final ListKategoriApps2Adapter._cls3 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(ListKategoriApps2Adapter.access$0(this$0), com/inponsel/android/v2/RegisterActivity);
                ListKategoriApps2Adapter.access$0(this$0).startActivityForResult(dialoginterface, 0);
                ListKategoriApps2Adapter.access$0(this$0).overridePendingTransition(0x7f040003, 0x7f040004);
            }

                    
                    {
                        this$1 = ListKategoriApps2Adapter._cls3.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/adapter/ListKategoriApps2Adapter$3$4

/* anonymous class */
        class ListKategoriApps2Adapter._cls3._cls4
            implements android.content.DialogInterface.OnClickListener
        {

            final ListKategoriApps2Adapter._cls3 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(ListKategoriApps2Adapter.access$0(this$0), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                ListKategoriApps2Adapter.access$0(this$0).startActivityForResult(dialoginterface, 0);
                ListKategoriApps2Adapter.access$0(this$0).overridePendingTransition(0x7f040003, 0x7f040004);
            }

                    
                    {
                        this$1 = ListKategoriApps2Adapter._cls3.this;
                        super();
                    }
        }

    }

}
