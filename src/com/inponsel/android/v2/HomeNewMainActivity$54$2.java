// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.inponsel.android.details.DetailsPonsel;
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
    implements Callback
{

    final rProgressBar.setVisibility this$1;

    public void onError()
    {
        progressbar_hp_random.setVisibility(8);
    }

    public void onSuccess()
    {
        progressbar_hp_random.setVisibility(8);
    }

    init>()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/HomeNewMainActivity$54

/* anonymous class */
    class HomeNewMainActivity._cls54 extends AsyncHttpResponseHandler
    {

        final HomeNewMainActivity this$0;

        public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
        {
            ll_segmen_2.setVisibility(0);
        }

        public void onRetry(int i)
        {
        }

        public void onStart()
        {
            progressbar_hp_random.setVisibility(0);
        }

        public void onSuccess(int i, Header aheader[], byte abyte0[])
        {
            aheader = new String(abyte0);
            isFinish2 = true;
            aheader = (new JSONObject(aheader)).getJSONArray("InPonsel");
            i = 0;
_L3:
            if (i < 1) goto _L2; else goto _L1
_L1:
            list_txtMerekRandom.setText(random_merek_hp);
            try
            {
                rl_background_random.setBackgroundColor(Color.parseColor(random_background));
            }
            // Misplaced declaration of an exception variable
            catch (Header aheader[]) { }
            if (random_umu_status.equals("3") || random_harga_hp.equals("-") || random_harga_hp.equals("0"))
            {
                list_txtHargaRandom.setVisibility(8);
            } else
            {
                list_txtHargaRandom.setText(random_harga_hp);
            }
            if (random_like.equals("1"))
            {
                img_likerandom_ponsel.setBackgroundResource(0x7f02020b);
                img_dislikerandom_ponsel.setBackgroundResource(0x7f0201f1);
                img_likerandom_ponsel.setEnabled(false);
                img_dislikerandom_ponsel.setEnabled(true);
            } else
            if (random_like.equals("0"))
            {
                img_likerandom_ponsel.setBackgroundResource(0x7f02020a);
                img_dislikerandom_ponsel.setBackgroundResource(0x7f0201f2);
                img_likerandom_ponsel.setEnabled(true);
                img_dislikerandom_ponsel.setEnabled(false);
            } else
            {
                img_likerandom_ponsel.setEnabled(true);
                img_dislikerandom_ponsel.setEnabled(true);
                img_likerandom_ponsel.setBackgroundResource(0x7f02020a);
                img_dislikerandom_ponsel.setBackgroundResource(0x7f0201f1);
            }
            imgHpRandom.setOnClickListener(new HomeNewMainActivity._cls54._cls1());
            Picasso.with(HomeNewMainActivity.this).load(random_img_url.trim()).tag(this).into(imgHpRandom, new HomeNewMainActivity._cls54._cls2());
            rl_hp_random.setVisibility(0);
            ll_segmen_2.setVisibility(0);
            img_likerandom_ponsel.setEnabled(true);
            img_dislikerandom_ponsel.setEnabled(true);
            (new Handler()).postDelayed(new HomeNewMainActivity._cls54._cls3(), 2000L);
            return;
_L2:
            abyte0 = aheader.getJSONObject(i);
            random_id_hp = abyte0.getString("id_hp");
            random_codename = abyte0.getString("codename");
            random_umu_status = abyte0.getString("umu_status");
            random_img_url = abyte0.getString("gambar");
            random_merek_hp = (new StringBuilder(String.valueOf(abyte0.getString("merk")))).append(" ").append(abyte0.getString("model")).toString();
            namalengkapbgskrg = random_merek_hp;
            random_harga_hp = abyte0.getString("hrg_baru");
            random_like = abyte0.getString("my_like_pon");
            random_background = abyte0.getString("background");
            i++;
              goto _L3
            aheader;
            aheader.printStackTrace();
              goto _L1
        }


            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/HomeNewMainActivity$54$1

/* anonymous class */
        class HomeNewMainActivity._cls54._cls1
            implements android.view.View.OnClickListener
        {

            final HomeNewMainActivity._cls54 this$1;

            public void onClick(View view)
            {
                view = new Intent(getApplicationContext(), com/inponsel/android/details/DetailsPonsel);
                view.putExtra("id_hph", random_id_hp);
                view.putExtra("namalengkap", random_merek_hp);
                view.putExtra("codename", random_codename);
                view.putExtra("model", "");
                view.putExtra("merk", "");
                view.putExtra("gambar", "");
                view.putExtra("hrg_baru", "");
                view.putExtra("hrg_bekas", "");
                view.putExtra("tot_like", "");
                view.putExtra("tot_dislike", "");
                view.putExtra("tot_komen", "");
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

                    
                    {
                        this$1 = HomeNewMainActivity._cls54.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/HomeNewMainActivity$54$3

/* anonymous class */
        class HomeNewMainActivity._cls54._cls3
            implements Runnable
        {

            final HomeNewMainActivity._cls54 this$1;

            public void run()
            {
                progressbar_segmen2.setVisibility(8);
            }

                    
                    {
                        this$1 = HomeNewMainActivity._cls54.this;
                        super();
                    }
        }

    }

}
