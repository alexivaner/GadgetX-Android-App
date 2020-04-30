// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Utility;
import com.loopj.android.http.AsyncHttpResponseHandler;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            HomeNewMainActivity

class this._cls1
    implements android.view.ivity._cls52._cls1
{

    final oodle_url this$1;

    public void onClick(View view)
    {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str_doodle_url)));
    }

    init>()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/HomeNewMainActivity$52

/* anonymous class */
    class HomeNewMainActivity._cls52 extends AsyncHttpResponseHandler
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
            Log.e("respJson", aheader);
            aheader = (new JSONObject(aheader)).getJSONArray("InPonsel");
            i = 0;
_L3:
            int j = aheader.length();
            if (i < j) goto _L2; else goto _L1
_L1:
            aheader = ((WindowManager)getSystemService("window")).getDefaultDisplay();
            abyte0 = new DisplayMetrics();
            aheader.getMetrics(abyte0);
            i = ((DisplayMetrics) (abyte0)).widthPixels;
            float f1 = Utility.aspectratio(Integer.parseInt(str_doodle_width), Integer.parseInt(str_doodle_height));
            float f = (float)Integer.parseInt(str_doodle_width) / f1;
            f1 = (float)Integer.parseInt(str_doodle_height) / f1;
            Log.e("ratio", String.valueOf((new StringBuilder(String.valueOf(f))).append(" : ").append(f1).toString()));
            float f2 = i;
            if (f > f1)
            {
                final_width = f2;
                final_height = Math.round((f2 * f1) / f);
                Log.e("ratioFinal", String.valueOf((new StringBuilder(String.valueOf(final_width))).append(" : ").append(final_height).toString()));
            } else
            {
                final_width = Math.round((f2 * f1) / f);
                final_height = f2;
                Log.e("ratioFinal", String.valueOf((new StringBuilder(String.valueOf(final_width))).append(" : ").append(final_height).toString()));
            }
            img_head_banner.setLayoutParams(new android.widget.RelativeLayout.LayoutParams((int)final_width, (int)final_height));
            if (str_doodle_title.equals("") && str_doodle_subtitle.equals(""))
            {
                rl_campaign_text.setVisibility(8);
            }
            txt_doodle_subtitle.setText(str_doodle_subtitle);
            txt_doodle_title.setText(str_doodle_title);
            btn_doodle_action.setText(str_doodle_text_action);
            btn_doodle_action.setOnClickListener(new HomeNewMainActivity._cls52._cls1());
            HomeNewMainActivity.access$6(HomeNewMainActivity.this);
            return;
_L2:
            abyte0 = aheader.getJSONObject(i);
            str_doodle_action = abyte0.getString("action");
            str_doodle_img = abyte0.getString("image");
            str_doodle_subtitle = abyte0.getString("campaign");
            str_doodle_title = abyte0.getString("title");
            str_doodle_url = abyte0.getString("url");
            str_doodle_width = abyte0.getString("width");
            str_doodle_height = abyte0.getString("height");
            str_doodle_text_action = abyte0.getString("text_action");
            i++;
              goto _L3
            aheader;
            aheader.printStackTrace();
            str_doodle_title = "";
            str_doodle_subtitle = "";
              goto _L1
        }


            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
    }

}
