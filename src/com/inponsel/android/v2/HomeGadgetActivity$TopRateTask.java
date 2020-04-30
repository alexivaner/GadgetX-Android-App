// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.details.DetailsPonsel;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.ServiceHandler;
import com.inponsel.android.utils.Util;
import com.inponsel.android.widget.CircleProgressBar;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import fr.castorflex.android.circularprogressbar.CircularProgressBar;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            HomeGadgetActivity

private class <init> extends AsyncTask
{

    final HomeGadgetActivity this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        avoid = (new ServiceHandler()).makeServiceCall(dataTopRate, 1);
        topRateArray.clear();
        topRateStrStat = avoid;
        if (avoid == null) goto _L2; else goto _L1
_L1:
        avoid = new JSONObject(avoid);
        inponsel = avoid.getJSONArray("InPonsel");
        int i = 0;
_L9:
        if (i < inponsel.length()) goto _L4; else goto _L3
_L4:
        avoid = inponsel.getJSONObject(i);
        if (i != 1) goto _L6; else goto _L5
_L5:
        reco_id_hp = avoid.getString("id_hp");
        reco_model = avoid.getString("model");
        reco_merk = avoid.getString("merk");
        reco_gambar = avoid.getString("gambar");
        reco_codename = avoid.getString("codename");
        reco_hrg_baru = avoid.getString("hrg_baru");
        reco_hrg_bekas = avoid.getString("hrg_bekas");
        reco_likepersen = avoid.getString("likepersen");
        reco_avg_all = avoid.getString("avg_all");
        reco_total_hits = avoid.getString("total_hits");
        reco_total_kom = avoid.getString("total_kom");
        reco_total_like = avoid.getString("total_like");
        reco_total_dislike = avoid.getString("total_dislike");
        reco_total_vote = avoid.getString("total_kom");
          goto _L7
_L6:
        ListModel listmodel = new ListModel();
        listmodel.setId_hp(avoid.getString("id_hp"));
        listmodel.setModel(avoid.getString("model"));
        listmodel.setMerk(avoid.getString("merk"));
        listmodel.setCodename(avoid.getString("codename"));
        listmodel.setGambar(avoid.getString("gambar"));
        listmodel.setUmu_status(avoid.getString("umu_status"));
        listmodel.setHrg_baru(avoid.getString("hrg_baru"));
        listmodel.setHrg_bekas(avoid.getString("hrg_bekas"));
        listmodel.setTotal_like((new StringBuilder(String.valueOf(avoid.getString("likepersen")))).append("%").toString());
        listmodel.setTotal_dislike(avoid.getString("avg_all"));
        listmodel.setTotal_hits(avoid.getString("total_hits"));
        listmodel.setTotal_kom(avoid.getString("total_kom"));
        listmodel.setMy_like_pon(avoid.getString("total_vote"));
        topRateArray.add(listmodel);
          goto _L7
        avoid;
        avoid.printStackTrace();
          goto _L3
        avoid;
        avoid.printStackTrace();
          goto _L3
_L2:
        Log.e("ServiceHandler", "Couldn't get any data from the url");
_L3:
        return null;
_L7:
        i++;
        if (true) goto _L9; else goto _L8
_L8:
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        super.onPostExecute(void1);
        Log.e("topRateArray", (new StringBuilder("topRateArray")).append(String.valueOf(topRateArray.size())).toString());
        progressbar_segmen3.setVisibility(8);
        Picasso.with(HomeGadgetActivity.this).load((new StringBuilder(String.valueOf(Util.BASE_PATH_NEWIMAGE))).append(reco_gambar.trim()).toString()).tag(HomeGadgetActivity.this).into(imgHp_reco, new Callback() {

            final HomeGadgetActivity.TopRateTask this$1;

            public void onError()
            {
            }

            public void onSuccess()
            {
                imgHp_reco.setVisibility(0);
            }

            
            {
                this$1 = HomeGadgetActivity.TopRateTask.this;
                super();
            }
        });
        rl_head_reco.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeGadgetActivity.TopRateTask this$1;

            public void onClick(View view)
            {
                view = new Intent(getApplicationContext(), com/inponsel/android/details/DetailsPonsel);
                view.putExtra("id_hph", reco_id_hp);
                view.putExtra("namalengkap", (new StringBuilder(String.valueOf(reco_merk))).append(" ").append(reco_model).toString());
                view.putExtra("codename", reco_codename);
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
                this$1 = HomeGadgetActivity.TopRateTask.this;
                super();
            }
        });
        txtValueKetertarikan_reco.setText(reco_likepersen);
        txtKetertarikan_reco.setText((new StringBuilder("Ketertariakan\n")).append(reco_total_like).append(" likes, ").append(reco_total_dislike).append(" dislikes").toString());
        txtReview_reco.setText(reco_avg_all);
        txtValueReview_reco.setText((new StringBuilder("Review Pengunjung\n")).append(reco_total_vote).append(" suara").toString());
        circle_ValueKetertarikan_reco.setProgress(Float.parseFloat(reco_likepersen));
        txtNamaLengkap_reco.setText((new StringBuilder(String.valueOf(reco_merk))).append(" ").append(reco_model).toString());
        int i = Math.round(Float.parseFloat(reco_avg_all) * 10F);
        circle_ValueReview_reco.setProgress(i);
        listDirekomendasikan.setVisibility(0);
        if (topRateStrStat == null)
        {
            topRateArray.size();
            return;
        }
        try
        {
            topRateAdapter.notifyDataSetChanged();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            void1.printStackTrace();
        }
        return;
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
    }


    private _cls2.this._cls1()
    {
        this$0 = HomeGadgetActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
