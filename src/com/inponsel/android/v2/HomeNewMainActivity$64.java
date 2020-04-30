// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.widget.ImageView;
import android.widget.TextView;
import com.inponsel.android.utils.Log;
import com.loopj.android.http.AsyncHttpResponseHandler;
import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            HomeNewMainActivity

class  extends AsyncHttpResponseHandler
{

    final HomeNewMainActivity this$0;

    public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
    {
    }

    public void onRetry(int i)
    {
    }

    public void onStart()
    {
    }

    public void onSuccess(int i, Header aheader[], byte abyte0[])
    {
        aheader = new String(abyte0);
        Log.e("responseNotif", aheader);
        aheader = new JSONObject(aheader);
        hot_number = aheader.getJSONObject("InPonsel").getJSONObject("data").getInt("activities");
        Log.e("activities", String.valueOf(hot_number));
        if (txt_notif_count == null)
        {
            return;
        }
        try
        {
            runOnUiThread(new Runnable() {

                final HomeNewMainActivity._cls64 this$1;

                public void run()
                {
                    Log.e("new_hot_number", Integer.toString(hot_number));
                    if (hot_number == 0)
                    {
                        Log.e("notif", "kosong");
                        txt_notif_count.setVisibility(4);
                        img_Notification.setBackgroundResource(0x7f02021f);
                        return;
                    }
                    Log.e("notif", "ada");
                    if (hot_number > 99)
                    {
                        txt_notif_count.setText("99+");
                    } else
                    {
                        txt_notif_count.setText(Integer.toString(hot_number));
                    }
                    txt_notif_count.setVisibility(0);
                    img_Notification.setBackgroundResource(0x7f020220);
                }

            
            {
                this$1 = HomeNewMainActivity._cls64.this;
                super();
            }
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Header aheader[])
        {
            aheader.printStackTrace();
        }
        return;
    }


    _cls1.this._cls1()
    {
        this$0 = HomeNewMainActivity.this;
        super();
    }
}
