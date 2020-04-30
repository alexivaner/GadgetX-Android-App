// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.os.AsyncTask;
import android.os.StrictMode;
import android.widget.Toast;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.NotificationLikeHelper;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

// Referenced classes of package com.inponsel.android.details:
//            Hal2Spek

public class this._cls0 extends AsyncTask
{

    final Hal2Spek this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        if (android.os. > 9)
        {
            StrictMode.setThreadPolicy((new android.os..Builder()).permitAll().build());
        }
        namalengkap = URLEncoder.encode(namalengkap, "utf-8");
_L2:
        avoid = (new StringBuilder("idhp=")).append(id_hp).append("&email=").append(username).append("&namalengkap=").append(namalengkap).append("&").append("desain=").append(nilbtnDesain).append("&layar=").append(nilbtnLayar).append("&kinerja=").append(nilbtnKinerja).append("&apps=").append("0").append("&kamera=").append(nilbtnKamera).append("&audio=").append("0").append("&baterai=").append(nilbtnBaterai).append("&harga=").append("0").append("&t=").append(t).toString();
        avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("ratingnilaihp").append(Utility.BASE_FORMAT).append("?").append(avoid).toString();
        Log.e("pushURL", avoid);
        avoid = HttpPush.getResponse(avoid);
        res = avoid.toString();
        res = res.trim();
        res = res.replaceAll("\\s+", "");
        break MISSING_BLOCK_LABEL_334;
        avoid;
        avoid.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
        avoid;
        avoid.printStackTrace();
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        super.onPostExecute(void1);
        try
        {
            if (res.equals("1"))
            {
                Toast.makeText(getActivity(), 0x7f0c0061, 1).show();
                notificationLikeHelper.completed(namalengkapbgskrg, getString(0x7f0c0061));
                RatingAVGTask();
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            return;
        }
        if (res.equals("4"))
        {
            notificationLikeHelper.completed(namalengkapbgskrg, getString(0x7f0c0061));
            RatingAVGTask();
            return;
        }
        if (res.equals("3"))
        {
            notificationLikeHelper.gagal(namalengkapbgskrg, notificationLikeHelper.gagallikeStatement);
            return;
        }
        if (res.equals("1209"))
        {
            notificationLikeHelper.gagal(namalengkapbgskrg, "Anda telah memberikan nilai sama sebelumnya");
            return;
        }
        if (res.equals("K404"))
        {
            break MISSING_BLOCK_LABEL_274;
        }
        if (res.equals("U404"))
        {
            notificationLikeHelper.gagal(namalengkapbgskrg, "Username anda tidak terdaftar");
            return;
        }
        notificationLikeHelper.gagal(namalengkapbgskrg, notificationLikeHelper.gagallikeStatement);
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        notificationLikeHelper.createNotification(namalengkapbgskrg, notificationLikeHelper.nilaiStatement);
    }

    public _cls9()
    {
        this$0 = Hal2Spek.this;
        super();
    }
}
