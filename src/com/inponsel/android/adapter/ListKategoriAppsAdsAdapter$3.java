// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.NotificationLikeHelper;
import com.inponsel.android.utils.Util;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import org.apache.http.Header;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.adapter:
//            ListKategoriAppsAdsAdapter, ListModel, PonselBaseApp, ModelObserver

class val.position
    implements android.view.ppsAdsAdapter._cls3
{

    final ListKategoriAppsAdsAdapter this$0;
    private final ewHolder val$holder;
    private final int val$position;

    public void onClick(final View urlPost)
    {
        Log.e("postfav", val$holder.txt_fav_kat_apps_1.getText().toString());
        if (val$holder.txt_fav_kat_apps_1.getText().toString().equals("1"))
        {
            fav_stat = "0";
        } else
        {
            fav_stat = "1";
        }
        urlPost = (new StringBuilder(String.valueOf(Util.BASE_PATH_STORE))).append("add_fav_applist.php?").append("t=f7c1ffed723d0578eca7f57388c8054d4fed52a7&id_user=").append(user_id).append("&status=").append(fav_stat).append("&id_kat=").append(getListModel(val$position).getId_apps()).toString();
        (new AsyncHttpClient()).get(urlPost, new AsyncHttpResponseHandler() {

            final ListKategoriAppsAdsAdapter._cls3 this$1;
            private final ListKategoriAppsAdsAdapter.ViewHolder val$holder;
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
                if (fav_stat.equals("1"))
                {
                    notificationLikeHelper.completed(getListModel(position).getKat_apps_name(), "Berhasil menambahkan ke favorit");
                } else
                {
                    notificationLikeHelper.completed(getListModel(position).getKat_apps_name(), "Berhasil menghapus ke favorit");
                }
                ponselBaseApp.setObserver().setIndexHp(getListModel(position).getId_apps());
                ponselBaseApp.setObserver().setUpdateType("favappsstore");
                ponselBaseApp.setObserver().setStatus_like_ponsel(fav_stat);
            }

            
            {
                this$1 = ListKategoriAppsAdsAdapter._cls3.this;
                position = i;
                urlPost = s;
                holder = viewholder;
                super();
            }
        });
    }


    ewHolder()
    {
        this$0 = final_listkategoriappsadsadapter;
        val$holder = ewholder;
        val$position = I.this;
        super();
    }
}
