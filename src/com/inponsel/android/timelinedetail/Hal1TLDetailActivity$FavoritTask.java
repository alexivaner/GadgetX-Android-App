// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.timelinedetail;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.Toast;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;

// Referenced classes of package com.inponsel.android.timelinedetail:
//            Hal1TLDetailActivity

public class this._cls0 extends AsyncTask
{

    final Hal1TLDetailActivity this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        try
        {
            avoid = (new StringBuilder("idartanya=")).append(id_artikel).append("&idusr=").append(user_id).append("&stat=").append(statFav).append("&type=").append(tl_type).append("&t=").append(t).toString();
            String s = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("add_favartanya").append(Utility.BASE_FORMAT).append("?").append(avoid).toString();
            Log.e("pushURL", s);
            s = HttpPush.getResponse(s);
            Log.e("push", (new StringBuilder(String.valueOf(s))).append(avoid).toString());
            res = s.toString();
            Hal1TLDetailActivity.access$0(Hal1TLDetailActivity.this, res);
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
        if (postStatusAddTL.equals("1") || postStatusAddTL.equals("10"))
        {
            if (tl_img_url.equals(""))
            {
                db.addArtTanya(tl_id, tl_id_hp, merk, model, tl_codename, tl_judul, tl_type, tl_tag, "", tl_content, tl_content_ext, tl_date);
            } else
            {
                db.addArtTanya(tl_id, tl_id_hp, merk, model, tl_codename, tl_judul, tl_type, tl_tag, tl_img_url, tl_content, tl_content_ext, tl_date);
            }
        } else
        if (postStatusAddTL.equals("00") || postStatusAddTL.equals("0"))
        {
            Toast.makeText(Hal1TLDetailActivity.this, "Berhasil menghapus", 1).show();
            db.delete_TLbyID(tl_id);
            list_img_favorite.setBackgroundResource(0x7f02023c);
        } else
        if (res.equals("40404"))
        {
            mDialog.dismiss();
        } else
        {
            Toast.makeText(Hal1TLDetailActivity.this, postMessageAddTL, 1).show();
        }
        ponselBaseApp.getObserver().setUpdateType("favtl");
        ponselBaseApp.getObserver().setStatus_like_ponsel("-");
        mDialog.dismiss();
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        if (statFav.equals("1"))
        {
            mDialog = ProgressDialog.show(Hal1TLDetailActivity.this, "", "Menambahkan...", true);
        } else
        {
            mDialog = ProgressDialog.show(Hal1TLDetailActivity.this, "", "Menghapus...", true);
        }
        mDialog.setCancelable(true);
        mDialog.show();
    }

    public ()
    {
        this$0 = Hal1TLDetailActivity.this;
        super();
    }
}
