// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.tlforum;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.tlforum:
//            ForumHPActivity

public class this._cls0 extends AsyncTask
{

    final ForumHPActivity this$0;

    private void parseJSONSubsNews(String s)
    {
        try
        {
            s = new JSONObject(s);
            postStatusSubsStat = s.getString("success");
            postMessageSubsStat = s.getString("sub_status");
            gc_status = s.getString("gc_status");
            kota = s.getString("kota");
            kota_id = s.getString("kota_id");
            prov = s.getString("prov_id");
            Log.e("postMessageSubsStat", postMessageSubsStat);
            jArray = s.getJSONArray("InPonsel");
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
            querySubsStat = (new StringBuilder("idhp=")).append(id_hp).append("&idconv=").append(codename).append("&idusr=").append(ForumHPActivity.user_id).append("&type=").append("all").append("&stat=").append(statSubNews).append("&t=").append(t).toString();
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
        slidingView.findViewById(0x7f0b05db).setVisibility(8);
        Log.e("progbar_roomhp", "gone");
        slidingView.findViewById(0x7f0b040f).setEnabled(true);
        if (userFunctions.isUserLoggedIn(ForumHPActivity.this))
        {
            txtBigRoomPenggunaKota.setText((new StringBuilder("Di ")).append(kota).toString());
        } else
        {
            txtBigRoomPenggunaKota.setText("Di kota anda");
        }
        statJoinChat = gc_status;
        if (postMessageSubsStat.equals("1"))
        {
            img_NotifHp.setBackgroundResource(0x7f02013b);
            img_NotifHp.setText("Hapus");
            img_NotifHp.setTextColor(getResources().getColor(0x7f080182));
            statSubNews = "1";
            return;
        } else
        {
            statSubNews = "0";
            img_NotifHp.setBackgroundResource(0x7f02013a);
            img_NotifHp.setText("Ikuti");
            img_NotifHp.setTextColor(Color.parseColor("#795548"));
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        slidingView.findViewById(0x7f0b05db).setVisibility(0);
        slidingView.findViewById(0x7f0b040f).setEnabled(false);
    }

    public ()
    {
        this$0 = ForumHPActivity.this;
        super();
    }
}
