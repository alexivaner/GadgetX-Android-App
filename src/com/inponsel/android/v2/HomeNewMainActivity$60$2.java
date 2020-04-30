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

class this._cls1
    implements android.view.ivity._cls60._cls2
{

    final idePendingTransition this$1;

    public void onClick(View view)
    {
        Log.e("judul", String.valueOf(id_news2));
        view = new Intent();
        view.setClass(_fld0, com/inponsel/android/rssfeeddetail/RSSDetailTab);
        view.putExtra("id_rss", id_news2);
        view.putExtra("rss_title", title_news2);
        view.putExtra("notif", "gcm");
        view.putExtra("actfrom", "rssfeed");
        view.putExtra("act", "firsttab");
        startActivityForResult(view, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
    }

    init>()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/HomeNewMainActivity$60

/* anonymous class */
    class HomeNewMainActivity._cls60 extends AsyncHttpResponseHandler
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
            progressbar_viewpager_tips_news.setVisibility(0);
        }

        public void onSuccess(int i, Header aheader[], byte abyte0[])
        {
            aheader = new String(abyte0);
            Log.e("responseHeadNews", aheader);
            rl_root_news2 = (RelativeLayout)findViewById(0x7f0b026a);
            image_news2 = (ImageView)findViewById(0x7f0b026b);
            txt_judul_news2 = (TextView)findViewById(0x7f0b026c);
            aheader = new JSONObject(aheader);
            if (!aheader.getString("bottom_id").equals("0") || !aheader.getString("top_id").equals("0")) goto _L2; else goto _L1
_L1:
            rl_slideshow_tips_news.setVisibility(8);
_L3:
            isFinish3 = true;
            return;
_L2:
            float f;
            float f1;
            aheader = aheader.getJSONArray("InPonsel");
            rl_slideshow_tips_news.setVisibility(0);
            aheader = aheader.getJSONObject(0);
            id_news2 = aheader.getString("rss_id");
            title_news2 = aheader.getString("rss_title");
            img_urlnews2 = aheader.getString("rss_img");
            progressbar_viewpager_tips_news.setVisibility(8);
            aheader = ((WindowManager)getSystemService("window")).getDefaultDisplay();
            abyte0 = new DisplayMetrics();
            aheader.getMetrics(abyte0);
            i = ((DisplayMetrics) (abyte0)).widthPixels;
            f1 = Utility.aspectratio(Integer.parseInt(str_doodle_width), Integer.parseInt(str_doodle_height));
            f = (float)Integer.parseInt(str_doodle_width) / f1;
            f1 = (float)Integer.parseInt(str_doodle_height) / f1;
            Log.e("ratio", String.valueOf((new StringBuilder(String.valueOf(f))).append(" : ").append(f1).toString()));
            float f2;
            f2 = i;
            if (f <= f1)
            {
                break MISSING_BLOCK_LABEL_563;
            }
            final_width = f2;
            final_height = Math.round((f2 * f1) / f);
            Log.e("ratioFinal", String.valueOf((new StringBuilder(String.valueOf(final_width))).append(" : ").append(final_height).toString()));
_L4:
            image_news2.setLayoutParams(new android.widget.RelativeLayout.LayoutParams((int)final_width, (int)final_height));
            rl_root_news2.setLayoutParams(new android.widget.RelativeLayout.LayoutParams((int)final_width, (int)final_height));
            txt_judul_news2.setText(title_news2);
            Picasso.with(HomeNewMainActivity.this).load(img_urlnews2).into(image_news2, new HomeNewMainActivity._cls60._cls1());
            image_news2.setOnClickListener(new HomeNewMainActivity._cls60._cls2());
              goto _L3
            aheader;
            aheader.printStackTrace();
              goto _L3
            final_width = Math.round((f2 * f1) / f);
            final_height = f2;
            Log.e("ratioFinal", String.valueOf((new StringBuilder(String.valueOf(final_width))).append(" : ").append(final_height).toString()));
              goto _L4
        }


            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/HomeNewMainActivity$60$1

/* anonymous class */
        class HomeNewMainActivity._cls60._cls1
            implements Callback
        {

            final HomeNewMainActivity._cls60 this$1;

            public void onError()
            {
                image_news2.setImageResource(0x7f020209);
            }

            public void onSuccess()
            {
            }

                    
                    {
                        this$1 = HomeNewMainActivity._cls60.this;
                        super();
                    }
        }

    }

}
