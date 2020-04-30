// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.ServiceHandler;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import fr.castorflex.android.circularprogressbar.CircularProgressBar;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            HomeNewMainActivity, MerekActivity

private class <init> extends AsyncTask
{

    final HomeNewMainActivity this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        {
            avoid = (new ServiceHandler()).makeServiceCall(datalatestBrand, 1);
            Log.d("ResponselatestBrand: ", datalatestBrand);
            Log.e("jsonStr: ", avoid);
            latestBrandArray.clear();
            latestBrandStrStat = avoid;
            if (avoid == null)
            {
                break MISSING_BLOCK_LABEL_348;
            }
            ListModel listmodel;
            int i;
            try
            {
                avoid = new JSONObject(avoid);
                inponsel = avoid.getJSONArray("InPonsel");
                lts_brand_idmerk = avoid.getString("id_merk");
                lts_brand_merk = avoid.getString("merk");
                lts_brand_total = avoid.getString("total");
                lts_brand_logo = avoid.getString("logo");
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                avoid.printStackTrace();
                break MISSING_BLOCK_LABEL_355;
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                avoid.printStackTrace();
                break MISSING_BLOCK_LABEL_355;
            }
            i = 0;
        }
        if (i >= inponsel.length())
        {
            break MISSING_BLOCK_LABEL_355;
        }
        avoid = inponsel.getJSONObject(i);
        listmodel = new ListModel();
        listmodel.setId_hp(avoid.getString("id_hp"));
        listmodel.setModel(avoid.getString("model"));
        listmodel.setMerk(avoid.getString("merk"));
        listmodel.setCodename(avoid.getString("codename"));
        listmodel.setGambar(avoid.getString("gambar"));
        listmodel.setUmu_status(avoid.getString("umu_status"));
        listmodel.setHrg_baru(avoid.getString("hrg_baru"));
        listmodel.setHrg_bekas(avoid.getString("hrg_bekas"));
        listmodel.setTotal_like(avoid.getString("total_like"));
        listmodel.setTotal_dislike(avoid.getString("total_dislike"));
        listmodel.setTotal_hits(avoid.getString("total_hits"));
        listmodel.setTotal_kom(avoid.getString("total_kom"));
        listmodel.setMy_like_pon(avoid.getString("my_like_pon"));
        Log.e("codename: ", avoid.getString("codename"));
        latestBrandArray.add(listmodel);
        i++;
        if (true)
        {
            break MISSING_BLOCK_LABEL_135;
        }
        Log.e("ServiceHandlerPen", "Couldn't get any data from the url");
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        super.onPostExecute(void1);
        progressbar_segmen3.setVisibility(8);
        isFinish3 = true;
        Picasso.with(HomeNewMainActivity.this).load(lts_brand_logo.trim()).tag(this).into(img_brand, new Callback() {

            final HomeNewMainActivity.LatestBrandTask this$1;

            public void onError()
            {
            }

            public void onSuccess()
            {
                img_brand.setVisibility(0);
                layout_TerbaruBrand.setVisibility(0);
            }

            
            {
                this$1 = HomeNewMainActivity.LatestBrandTask.this;
                super();
            }
        });
        txtBigTerbaruBrand.setText((new StringBuilder("Terbaru dari ")).append(lts_brand_merk).toString());
        listTerbaruBrand.setVisibility(0);
        if (latestBrandStrStat != null)
        {
            break MISSING_BLOCK_LABEL_207;
        }
        if (latestBrandArray.size() != 0) goto _L2; else goto _L1
_L1:
        txtMoreTerbaruBrand.setText("REFRESH");
_L3:
        txtMoreTerbaruBrand.getText().toString().toLowerCase().contains("refresh");
        rl_gadget_merk.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewMainActivity.LatestBrandTask this$1;

            public void onClick(View view)
            {
                i = new Intent(getApplicationContext(), com/inponsel/android/v2/MerekActivity);
                startActivityForResult(i, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$1 = HomeNewMainActivity.LatestBrandTask.this;
                super();
            }
        });
        return;
_L2:
        try
        {
            txtMoreTerbaruBrand.setText("MORE");
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            return;
        }
          goto _L3
        latestBrandAdapter.notifyDataSetChanged();
          goto _L3
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        txtMoreTerbaruBrand.setVisibility(8);
        datalatestBrand = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("gadget_latest_brand").append(Utility.BASE_FORMAT).append("?idusr=").append(user_id).append("&lmt=0&t=").append(t).toString();
    }


    private _cls2.this._cls1()
    {
        this$0 = HomeNewMainActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
