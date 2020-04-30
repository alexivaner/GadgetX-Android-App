// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.inponsel.android.details.DetailsPonsel;
import com.inponsel.android.utils.Log;
import com.loopj.android.http.AsyncHttpResponseHandler;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            HomeNewsActivity

class ler extends AsyncHttpResponseHandler
{

    final HomeNewsActivity this$0;

    public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
    {
    }

    public void onRetry(int i)
    {
    }

    public void onStart()
    {
        Log.e("urlTurunHp", urlTurunHp);
    }

    public void onSuccess(int i, Header aheader[], byte abyte0[])
    {
        aheader = new String(abyte0);
        aheader = (new JSONObject(aheader)).getJSONArray("InPonsel");
        i = 0;
_L2:
        if (i >= aheader.length())
        {
            if (id_hp.equals("-") || id_hp.equals(""))
            {
                mLinearViewTurun.setVisibility(8);
                return;
            }
            break; /* Loop/switch isn't completed */
        }
        abyte0 = aheader.getJSONObject(i);
        id_hp = abyte0.getString("id_hp");
        merk = abyte0.getString("merk");
        model = abyte0.getString("model");
        codename = abyte0.getString("codename");
        gambar = abyte0.getString("gambar");
        penurunan_harga = abyte0.getString("penurunan_harga");
        hrg_baru = abyte0.getString("hrg_baru");
        hrg_bekas = abyte0.getString("hrg_bekas");
        tot_like = abyte0.getString("total_like");
        tot_dislike = abyte0.getString("total_dislike");
        tot_komen = abyte0.getString("total_kom");
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        try
        {
            list_txtMerek.setText((new StringBuilder(String.valueOf(merk))).append(" ").append(model).toString());
            list_txtHarga.setText(penurunan_harga);
            mLinearViewTurun.setOnClickListener(new android.view.View.OnClickListener() {

                final HomeNewsActivity._cls70 this$1;

                public void onClick(View view)
                {
                    view = new Intent(getApplicationContext(), com/inponsel/android/details/DetailsPonsel);
                    view.putExtra("id_hph", id_hp);
                    view.putExtra("namalengkap", (new StringBuilder(String.valueOf(merk))).append(" ").append(model).toString());
                    view.putExtra("codename", codename);
                    view.putExtra("model", model);
                    view.putExtra("merk", merk);
                    view.putExtra("gambar", gambar);
                    view.putExtra("hrg_baru", hrg_baru);
                    view.putExtra("hrg_bekas", hrg_bekas);
                    view.putExtra("tot_like", tot_like);
                    view.putExtra("tot_dislike", tot_dislike);
                    view.putExtra("tot_komen", tot_komen);
                    startActivityForResult(view, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$1 = HomeNewsActivity._cls70.this;
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
        this$0 = HomeNewsActivity.this;
        super();
    }
}
