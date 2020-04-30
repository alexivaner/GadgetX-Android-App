// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.inponsel.android.rssfeeddetail.RSSDetailTab;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Utility;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import fr.castorflex.android.circularprogressbar.CircularProgressBar;
import org.apache.http.Header;
import org.json.JSONArray;
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
        progressbar_viewpager_head_news.setVisibility(0);
    }

    public void onSuccess(int i, Header aheader[], byte abyte0[])
    {
        isFinish3 = true;
        aheader = new String(abyte0);
        Log.e("responseHeadNews", aheader);
        rl_root_news = (RelativeLayout)findViewById(0x7f0b0263);
        image_news1 = (ImageView)findViewById(0x7f0b0264);
        txt_judul_news = (TextView)findViewById(0x7f0b0265);
        float f;
        float f1;
        float f2;
        try
        {
            aheader = (new JSONObject(aheader)).getJSONArray("InPonsel").getJSONObject(0);
            id_news1 = aheader.getString("rss_id");
            title_news1 = aheader.getString("rss_title");
            img_urlnews1 = aheader.getString("rss_img");
        }
        // Misplaced declaration of an exception variable
        catch (Header aheader[])
        {
            aheader.printStackTrace();
        }
        progressbar_viewpager_head_news.setVisibility(0);
        aheader = ((WindowManager)getSystemService("window")).getDefaultDisplay();
        abyte0 = new DisplayMetrics();
        aheader.getMetrics(abyte0);
        i = ((DisplayMetrics) (abyte0)).widthPixels;
        f1 = Utility.aspectratio(Integer.parseInt(str_doodle_width), Integer.parseInt(str_doodle_height));
        f = (float)Integer.parseInt(str_doodle_width) / f1;
        f1 = (float)Integer.parseInt(str_doodle_height) / f1;
        Log.e("ratio", String.valueOf((new StringBuilder(String.valueOf(f))).append(" : ").append(f1).toString()));
        f2 = i;
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
        image_news1.setLayoutParams(new android.widget.rams((int)final_width, (int)final_height));
        rl_root_news.setLayoutParams(new android.widget.rams((int)final_width, (int)final_height));
        txt_judul_news.setText(title_news1);
        Picasso.with(HomeNewMainActivity.this).load(img_urlnews1).into(image_news1, new Callback() {

            final HomeNewMainActivity._cls59 this$1;

            public void onError()
            {
                image_news1.setImageResource(0x7f020209);
            }

            public void onSuccess()
            {
                progressbar_viewpager_head_news.setVisibility(8);
            }

            
            {
                this$1 = HomeNewMainActivity._cls59.this;
                super();
            }
        });
        image_news1.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewMainActivity._cls59 this$1;

            public void onClick(View view)
            {
                Log.e("judul", String.valueOf(id_news1));
                view = new Intent();
                view.setClass(this$0, com/inponsel/android/rssfeeddetail/RSSDetailTab);
                view.putExtra("id_rss", id_news1);
                view.putExtra("rss_title", title_news1);
                view.putExtra("notif", "gcm");
                view.putExtra("actfrom", "rssfeed");
                view.putExtra("act", "firsttab");
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$1 = HomeNewMainActivity._cls59.this;
                super();
            }
        });
    }


    _cls2.this._cls1()
    {
        this$0 = HomeNewMainActivity.this;
        super();
    }
}
