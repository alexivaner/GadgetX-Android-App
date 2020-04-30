// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Utility;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            HomeNewMainActivity

class this._cls1
    implements Callback
{

    final enubottom_rekomendasi this$1;

    public void onError()
    {
        txt_menubottom_rekomendasi.setVisibility(0);
    }

    public void onSuccess()
    {
        txt_menubottom_rekomendasi.setVisibility(8);
    }

    init>()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/HomeNewMainActivity$68

/* anonymous class */
    class HomeNewMainActivity._cls68 extends AsyncHttpResponseHandler
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
            Log.e("jsonArray.length()", String.valueOf(aheader.length()));
            i = 0;
_L3:
            int j = aheader.length();
            if (i < j)
            {
                break MISSING_BLOCK_LABEL_801;
            }
_L1:
            aheader = ((WindowManager)getSystemService("window")).getDefaultDisplay();
            abyte0 = new DisplayMetrics();
            aheader.getMetrics(abyte0);
            i = ((DisplayMetrics) (abyte0)).widthPixels;
            float f = Utility.aspectratio(600, 314);
            float f2 = (float)600 / f;
            float f3 = (float)314 / f;
            Log.e("ratio", String.valueOf((new StringBuilder(String.valueOf(f2))).append(" : ").append(f3).toString()));
            f = i;
            float f1;
            if (f2 > f3)
            {
                f1 = f;
                f = Math.round((f * f3) / f2);
                Log.e("ratioFinal", String.valueOf((new StringBuilder(String.valueOf(f1))).append(" : ").append(f).toString()));
            } else
            {
                f1 = Math.round((f * f3) / f2);
                Log.e("ratioFinal", String.valueOf((new StringBuilder(String.valueOf(f1))).append(" : ").append(f).toString()));
            }
            rl_menubottom_conv.setLayoutParams(new android.widget.LinearLayout.LayoutParams((int)f1 / 2, (int)f / 2));
            rl_menubottom_forum.setLayoutParams(new android.widget.LinearLayout.LayoutParams((int)f1 / 2, (int)f / 2));
            rl_menubottom_hprumor.setLayoutParams(new android.widget.LinearLayout.LayoutParams((int)f1 / 2, (int)f / 2));
            rl_menubottom_panduanbel.setLayoutParams(new android.widget.LinearLayout.LayoutParams((int)f1 / 2, (int)f / 2));
            rl_menubottom_pencrinci.setLayoutParams(new android.widget.LinearLayout.LayoutParams((int)f1 / 2, (int)f / 2));
            rl_menubottom_rekomendasi.setLayoutParams(new android.widget.LinearLayout.LayoutParams((int)f1 / 2, (int)f / 2));
            img_menubottom_conv.setLayoutParams(new android.widget.RelativeLayout.LayoutParams((int)f1 / 2, (int)f / 2));
            img_menubottom_forum.setLayoutParams(new android.widget.RelativeLayout.LayoutParams((int)f1 / 2, (int)f / 2));
            img_menubottom_hprumor.setLayoutParams(new android.widget.RelativeLayout.LayoutParams((int)f1 / 2, (int)f / 2));
            img_menubottom_panduanbel.setLayoutParams(new android.widget.RelativeLayout.LayoutParams((int)f1 / 2, (int)f / 2));
            img_menubottom_pencrinci.setLayoutParams(new android.widget.RelativeLayout.LayoutParams((int)f1 / 2, (int)f / 2));
            img_menubottom_rekomendasi.setLayoutParams(new android.widget.RelativeLayout.LayoutParams((int)f1 / 2, (int)f / 2));
            Picasso.with(HomeNewMainActivity.this).load(menu_img_conv).into(img_menubottom_conv, new HomeNewMainActivity._cls68._cls1());
            Log.e("menu_img_forum", menu_img_forum);
            Picasso.with(HomeNewMainActivity.this).load(menu_img_forum).into(img_menubottom_forum, new HomeNewMainActivity._cls68._cls2());
            Log.e("menu_img_hprumor", menu_img_hprumor);
            Picasso.with(HomeNewMainActivity.this).load(menu_img_hprumor).into(img_menubottom_hprumor, new HomeNewMainActivity._cls68._cls3());
            Log.e("menu_img_panduanbelanja", menu_img_panduanbelanja);
            Picasso.with(HomeNewMainActivity.this).load(menu_img_panduanbelanja).into(img_menubottom_panduanbel, new HomeNewMainActivity._cls68._cls4());
            Log.e("menu_img_pencrinci", menu_img_pencrinci);
            Picasso.with(HomeNewMainActivity.this).load(menu_img_pencrinci).into(img_menubottom_pencrinci, new HomeNewMainActivity._cls68._cls5());
            Picasso.with(HomeNewMainActivity.this).load(menu_img_rekomendasi).into(img_menubottom_rekomendasi, new HomeNewMainActivity._cls68._cls6());
            return;
label0:
            {
                abyte0 = aheader.getJSONObject(i);
                if (abyte0.getString("menu_name").contains("Hape Rumor"))
                {
                    menu_img_hprumor = abyte0.getString("menu_image");
                    break MISSING_BLOCK_LABEL_1056;
                }
                try
                {
                    if (abyte0.getString("menu_name").contains("Conversation"))
                    {
                        menu_img_conv = abyte0.getString("menu_image");
                        break MISSING_BLOCK_LABEL_1056;
                    }
                    break label0;
                }
                // Misplaced declaration of an exception variable
                catch (Header aheader[])
                {
                    aheader.printStackTrace();
                }
            }
              goto _L1
            if (abyte0.getString("menu_name").contains("Forum"))
            {
                menu_img_forum = abyte0.getString("menu_image");
                break MISSING_BLOCK_LABEL_1056;
            }
            if (abyte0.getString("menu_name").contains("Panduan Belanja"))
            {
                menu_img_panduanbelanja = abyte0.getString("menu_image");
                break MISSING_BLOCK_LABEL_1056;
            }
            if (abyte0.getString("menu_name").contains("Pencarian Rinci"))
            {
                menu_img_pencrinci = abyte0.getString("menu_image");
                break MISSING_BLOCK_LABEL_1056;
            }
            if (abyte0.getString("menu_name").contains("Rekomendasi"))
            {
                menu_img_rekomendasi = abyte0.getString("menu_image");
            }
            i++;
            if (true) goto _L3; else goto _L2
_L2:
        }


            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/HomeNewMainActivity$68$1

/* anonymous class */
        class HomeNewMainActivity._cls68._cls1
            implements Callback
        {

            final HomeNewMainActivity._cls68 this$1;

            public void onError()
            {
                txt_menubottom_conv.setVisibility(0);
            }

            public void onSuccess()
            {
                txt_menubottom_conv.setVisibility(8);
            }

                    
                    {
                        this$1 = HomeNewMainActivity._cls68.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/HomeNewMainActivity$68$2

/* anonymous class */
        class HomeNewMainActivity._cls68._cls2
            implements Callback
        {

            final HomeNewMainActivity._cls68 this$1;

            public void onError()
            {
                txt_menubottom_forum.setVisibility(0);
            }

            public void onSuccess()
            {
                txt_menubottom_forum.setVisibility(8);
            }

                    
                    {
                        this$1 = HomeNewMainActivity._cls68.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/HomeNewMainActivity$68$3

/* anonymous class */
        class HomeNewMainActivity._cls68._cls3
            implements Callback
        {

            final HomeNewMainActivity._cls68 this$1;

            public void onError()
            {
                txt_menubottom_rumor.setVisibility(0);
            }

            public void onSuccess()
            {
                txt_menubottom_rumor.setVisibility(8);
            }

                    
                    {
                        this$1 = HomeNewMainActivity._cls68.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/HomeNewMainActivity$68$4

/* anonymous class */
        class HomeNewMainActivity._cls68._cls4
            implements Callback
        {

            final HomeNewMainActivity._cls68 this$1;

            public void onError()
            {
                txt_menubottom_panduanbelanja.setVisibility(0);
            }

            public void onSuccess()
            {
                txt_menubottom_panduanbelanja.setVisibility(8);
            }

                    
                    {
                        this$1 = HomeNewMainActivity._cls68.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/HomeNewMainActivity$68$5

/* anonymous class */
        class HomeNewMainActivity._cls68._cls5
            implements Callback
        {

            final HomeNewMainActivity._cls68 this$1;

            public void onError()
            {
                txt_menubottom_pencrinci.setVisibility(0);
            }

            public void onSuccess()
            {
                txt_menubottom_pencrinci.setVisibility(8);
            }

                    
                    {
                        this$1 = HomeNewMainActivity._cls68.this;
                        super();
                    }
        }

    }

}
