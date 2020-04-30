// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.res.Resources;
import android.os.AsyncTask;
import android.widget.Button;
import android.widget.TextView;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            RoomInfoChat

public class this._cls0 extends AsyncTask
{

    final RoomInfoChat this$0;

    private void parseJSONSubsNews(String s)
    {
        try
        {
            s = new JSONObject(s);
            gc_status = s.getString("gc_status");
            kota = s.getString("kota");
            kota_id = s.getString("kota_id");
            prov = s.getString("prov_id");
            statJoinChat = s.getString("gc_status");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
    }

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        try
        {
            querySubsStat = (new StringBuilder("idhp=")).append(id_hp).append("&idconv=").append(codename).append("&idusr=").append(user_id).append("&type=").append("all").append("&t=").append(t).toString();
            pushURLSubsStat = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("user_forum_notif").append(Utility.BASE_FORMAT).append("?").append(querySubsStat).toString();
            Log.e("pushURLSubsStat", pushURLSubsStat);
            avoid = HttpPush.getResponse(pushURLSubsStat);
            Log.e("push", (new StringBuilder(String.valueOf(avoid))).append(querySubs).toString());
            resSubsStat = avoid.toString();
            Log.e("url ", resSubsStat);
            parseJSONSubsNews(resSubsStat);
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
        txtBigAnggotaDiKota.setText((new StringBuilder("Anggota di ")).append(kota).toString());
        if (gc_status.equals("1"))
        {
            btn_AktifkanNotifikasi.setBackgroundResource(0x7f02013b);
            btn_AktifkanNotifikasi.setText("Hapus");
            btn_AktifkanNotifikasi.setTextColor(getResources().getColor(0x7f080182));
        } else
        {
            btn_AktifkanNotifikasi.setBackgroundResource(0x7f02013a);
            btn_AktifkanNotifikasi.setText("Ikuti");
            btn_AktifkanNotifikasi.setTextColor(getResources().getColor(0x7f080181));
        }
        RoomInfoChat.access$1(RoomInfoChat.this);
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
    }

    public ()
    {
        this$0 = RoomInfoChat.this;
        super();
    }
}
