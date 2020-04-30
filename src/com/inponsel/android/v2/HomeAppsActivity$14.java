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
//            HomeAppsActivity

class ler extends AsyncHttpResponseHandler
{

    final HomeAppsActivity this$0;

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
        float f;
        float f1;
        float f2;
        aheader = new String(abyte0);
        try
        {
            aheader = new JSONObject(aheader);
            if (aheader.getString("success").equals("0"))
            {
                rl_head_banner.setVisibility(8);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Header aheader[])
        {
            aheader.printStackTrace();
            return;
        }
        aheader = aheader.getJSONArray("InPonsel");
        i = 0;
_L3:
        if (i < aheader.length()) goto _L2; else goto _L1
_L1:
        aheader = ((WindowManager)getSystemService("window")).getDefaultDisplay();
        abyte0 = new DisplayMetrics();
        aheader.getMetrics(abyte0);
        i = ((DisplayMetrics) (abyte0)).widthPixels;
        f1 = Utility.aspectratio(Integer.parseInt(str_doodle_width), Integer.parseInt(str_doodle_height));
        f = (float)Integer.parseInt(str_doodle_width) / f1;
        f1 = (float)Integer.parseInt(str_doodle_height) / f1;
        Log.e("ratio", String.valueOf((new StringBuilder(String.valueOf(f))).append(" : ").append(f1).toString()));
        f2 = i;
        if (f <= f1)
        {
            break MISSING_BLOCK_LABEL_548;
        }
        final_width = f2;
        final_height = Math.round((f2 * f1) / f);
        Log.e("ratioFinal", String.valueOf((new StringBuilder(String.valueOf(final_width))).append(" : ").append(final_height).toString()));
_L4:
        img_head_banner.setLayoutParams(new android.widget.tParams((int)final_width, (int)final_height));
        if (str_doodle_title.equals("") && str_doodle_subtitle.equals(""))
        {
            rl_campaign_text.setVisibility(8);
        }
        txt_doodle_subtitle.setText(str_doodle_subtitle);
        txt_doodle_title.setText(str_doodle_title);
        btn_doodle_action.setText(str_doodle_text_action);
        btn_doodle_action.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeAppsActivity._cls14 this$1;

            public void onClick(View view)
            {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str_doodle_url)));
            }

            
            {
                this$1 = HomeAppsActivity._cls14.this;
                super();
            }
        });
        HomeAppsActivity.access$2(HomeAppsActivity.this);
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
        final_width = Math.round((f2 * f1) / f);
        final_height = f2;
        Log.e("ratioFinal", String.valueOf((new StringBuilder(String.valueOf(final_width))).append(" : ").append(final_height).toString()));
          goto _L4
    }


    _cls1.this._cls1()
    {
        this$0 = HomeAppsActivity.this;
        super();
    }
}
