// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;

// Referenced classes of package com.inponsel.android.v2:
//            HomeNewsActivity

public class this._cls0 extends AsyncTask
{

    final HomeNewsActivity this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        try
        {
            avoid = (new StringBuilder("idrss=")).append(idkom_pos).append("&idusr=").append(user_id).append("&stat=").append(statFav).append("&t=").append(t).toString();
            String s = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("add_favrss").append(Utility.BASE_FORMAT).append("?").append(avoid).toString();
            Log.e("pushURL", s);
            s = HttpPush.getResponse(s);
            Log.e("push", (new StringBuilder(String.valueOf(s))).append(avoid).toString());
            resFav = s.toString();
            HomeNewsActivity.access$2(HomeNewsActivity.this, resFav);
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            avoid.printStackTrace();
        }
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        super.onPostExecute(void1);
        ponselBaseApp.getObserver().setUpdateType("favrss");
        ponselBaseApp.getObserver().setStatus_like_ponsel("-");
        if (postStatusAddRss.equals("1") || postStatusAddRss.equals("10"))
        {
            if (rss_img.equals(""))
            {
                db.addRSS(id_rss, rss_portal, rss_img_ava, rss_title, rss_desc, rss_content, "", rss_srclink, rss_date, txtLikeKom.getText().toString(), total_komen, "");
            } else
            {
                db.addRSS(id_rss, rss_portal, rss_img_ava, rss_title, rss_desc, rss_content, rss_img, rss_srclink, rss_date, txtLikeKom.getText().toString(), total_komen, "");
            }
        } else
        if (postStatusAddRss.equals("00") || postStatusAddRss.equals("0"))
        {
            Toast.makeText(HomeNewsActivity.this, "Berhasil menghapus", 1).show();
            db.deleteIDRSS(id_rss);
        } else
        if (resFav.equals("40404"))
        {
            mDialog.dismiss();
        } else
        {
            Toast.makeText(HomeNewsActivity.this, postMessageAddRss, 1).show();
        }
        mDialog.dismiss();
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        if (statFav.equals("1"))
        {
            mDialog = ProgressDialog.show(HomeNewsActivity.this, "", "Menambahkan...", true);
        } else
        {
            mDialog = ProgressDialog.show(HomeNewsActivity.this, "", "Menghapus...", true);
        }
        mDialog.setCancelable(true);
        mDialog.show();
    }

    public ()
    {
        this$0 = HomeNewsActivity.this;
        super();
    }
}
