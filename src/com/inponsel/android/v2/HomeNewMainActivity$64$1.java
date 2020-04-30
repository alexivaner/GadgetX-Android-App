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

class this._cls1
    implements Runnable
{

    final otification this$1;

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

    init>()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/HomeNewMainActivity$64

/* anonymous class */
    class HomeNewMainActivity._cls64 extends AsyncHttpResponseHandler
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
                runOnUiThread(new HomeNewMainActivity._cls64._cls1());
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Header aheader[])
            {
                aheader.printStackTrace();
            }
            return;
        }


            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
    }

}
