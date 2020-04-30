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

class Holder extends AsyncHttpResponseHandler
{

    final stat this$1;
    private final Holder val$holder;
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
            notificationLikeHelper.createNotification(getListModel(val$position).getKat_apps_name(), "Menambahkan ke favorit");
        } else
        {
            notificationLikeHelper.createNotification(getListModel(val$position).getKat_apps_name(), "Menghapus ke favorit");
        }
        Log.e("urlPost", val$urlPost);
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
            val$holder.img_fav_apps_1.setBackgroundResource(0x7f020302);
        } else
        {
            val$holder.img_fav_apps_1.setBackgroundResource(0x7f020303);
        }
        if (fav_stat.equals("1"))
        {
            notificationLikeHelper.completed(getListModel(val$position).getKat_apps_name(), "Berhasil menambahkan ke favorit");
        } else
        {
            notificationLikeHelper.completed(getListModel(val$position).getKat_apps_name(), "Berhasil menghapus ke favorit");
        }
        ponselBaseApp.setObserver().setIndexHp(getListModel(val$position).getId_apps());
        ponselBaseApp.setObserver().setUpdateType("favappsstore");
        ponselBaseApp.setObserver().setStatus_like_ponsel(fav_stat);
    }

    Holder()
    {
        this$1 = final_holder1;
        val$position = i;
        val$urlPost = s;
        val$holder = Holder.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/adapter/ListKategoriAppsAdsAdapter$3

/* anonymous class */
    class ListKategoriAppsAdsAdapter._cls3
        implements android.view.View.OnClickListener
    {

        final ListKategoriAppsAdsAdapter this$0;
        private final ListKategoriAppsAdsAdapter.ViewHolder val$holder;
        private final int val$position;

        public void onClick(final View urlPost)
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
            (new AsyncHttpClient()).get(urlPost, holder. new ListKategoriAppsAdsAdapter._cls3._cls1());
        }


            
            {
                this$0 = final_listkategoriappsadsadapter;
                holder = viewholder;
                position = I.this;
                super();
            }
    }

}
