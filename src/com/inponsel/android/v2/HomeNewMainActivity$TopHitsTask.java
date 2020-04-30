// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.os.AsyncTask;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.ServiceHandler;
import fr.castorflex.android.circularprogressbar.CircularProgressBar;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            HomeNewMainActivity

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
            avoid = (new ServiceHandler()).makeServiceCall(dataTopHits, 1);
            Log.e("dataTopHits", dataTopHits);
            topHitsArray.clear();
            topHitsStrStat = avoid;
            if (avoid == null)
            {
                break MISSING_BLOCK_LABEL_289;
            }
            ListModel listmodel;
            int i;
            try
            {
                avoid = new JSONObject(avoid);
                inponsel = avoid.getJSONArray("InPonsel");
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                avoid.printStackTrace();
                break MISSING_BLOCK_LABEL_296;
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                avoid.printStackTrace();
                break MISSING_BLOCK_LABEL_296;
            }
            i = 0;
        }
        if (i >= inponsel.length())
        {
            break MISSING_BLOCK_LABEL_296;
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
        listmodel.setBackground_color(avoid.getString("background"));
        topHitsArray.add(listmodel);
        i++;
        if (true)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        Log.e("ServiceHandler", "Couldn't get any data from the url");
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        super.onPostExecute(void1);
        txtMoreTopHits.setVisibility(0);
        progressbar_TopHits.setVisibility(8);
        listTopHits.setVisibility(0);
        if (topHitsStrStat != null)
        {
            break MISSING_BLOCK_LABEL_125;
        }
        if (topHitsArray.size() != 0) goto _L2; else goto _L1
_L1:
        txtMoreTopHits.setText("REFRESH");
_L3:
        txtMoreTopHits.getText().toString().toLowerCase().contains("refresh");
        layout_TopHits.setVisibility(0);
        return;
_L2:
        try
        {
            txtMoreTopHits.setText("MORE");
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            return;
        }
          goto _L3
        topHitsAdapter.notifyDataSetChanged();
          goto _L3
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        txtMoreTopHits.setVisibility(8);
        progressbar_TopHits.setVisibility(0);
    }

    private dapter()
    {
        this$0 = HomeNewMainActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
