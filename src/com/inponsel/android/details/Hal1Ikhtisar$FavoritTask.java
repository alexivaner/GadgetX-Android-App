// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

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
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

// Referenced classes of package com.inponsel.android.details:
//            Hal1Ikhtisar

public class this._cls0 extends AsyncTask
{

    final Hal1Ikhtisar this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        try
        {
            query = (new StringBuilder("idhp=")).append(id_hp).append("&idusr=").append(user_id).append("&stat=").append(stat).append("&t=").append(t).toString();
            pushURL = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("add_favhp").append(Utility.BASE_FORMAT).append("?").append(query).toString();
            Log.e("pushURL", pushURL);
            avoid = HttpPush.getResponse(pushURL);
            Log.e("push", (new StringBuilder(String.valueOf(avoid))).append(query).toString());
            res = avoid.toString();
            Log.e("url ", res);
            res = res.trim();
            res = res.replaceAll("\\s+", "");
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
        ponselBaseApp.getObserver().setUpdateType("sidemenufav");
        ponselBaseApp.getObserver().setLoginStat("1");
        if (res.equals("1") || res.equals("10"))
        {
            try
            {
                db.addHP(id_hp, URLDecoder.decode(merk, "utf-8"), URLDecoder.decode(model, "utf-8"), gambar, codename);
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                void1.printStackTrace();
            }
            if (db.getHPCount() > 0)
            {
                Toast.makeText(getActivity(), "Berhasil menambahkan", 1).show();
                if (sdk < 16)
                {
                    detail_favorite.setBackgroundDrawable(drwKurang);
                } else
                {
                    detail_favorite.setBackground(drwKurang);
                }
            } else
            {
                Toast.makeText(getActivity(), "Gagal menambahkan", 1).show();
                if (sdk < 16)
                {
                    detail_favorite.setBackgroundDrawable(drw);
                } else
                {
                    detail_favorite.setBackground(drw);
                }
            }
            mDialog.dismiss();
            return;
        }
        if (res.equals("00") || res.equals("0"))
        {
            db.deleteHP(id_hp);
            if (!db.checkIfExist(id_hp))
            {
                Toast.makeText(getActivity(), "Berhasil menghapus", 1).show();
                if (sdk < 16)
                {
                    detail_favorite.setBackgroundDrawable(drw);
                } else
                {
                    detail_favorite.setBackground(drw);
                }
            } else
            {
                Toast.makeText(getActivity(), "Gagal menghapus", 1).show();
                if (sdk < 16)
                {
                    detail_favorite.setBackgroundDrawable(drwKurang);
                } else
                {
                    detail_favorite.setBackground(drwKurang);
                }
            }
            mDialog.dismiss();
            return;
        }
        if (res.equals("40404"))
        {
            mDialog.dismiss();
            return;
        }
        Toast.makeText(getActivity(), "Gagal menambahkan", 1).show();
        if (sdk < 16)
        {
            detail_favorite.setBackgroundDrawable(drw);
            return;
        } else
        {
            detail_favorite.setBackground(drw);
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        if (stat.equals("1"))
        {
            mDialog = ProgressDialog.show(getActivity(), "", "Menambahkan...", true);
        } else
        {
            mDialog = ProgressDialog.show(getActivity(), "", "Menghapus...", true);
        }
        mDialog.setCancelable(true);
        mDialog.show();
    }

    public ()
    {
        this$0 = Hal1Ikhtisar.this;
        super();
    }
}
