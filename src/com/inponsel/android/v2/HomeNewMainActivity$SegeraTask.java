// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.os.AsyncTask;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.ServiceHandler;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
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
            avoid = (new ServiceHandler()).makeServiceCall(dataSegera, 1);
            segeraArray.clear();
            segeraStrStat = avoid;
            if (avoid == null)
            {
                break MISSING_BLOCK_LABEL_267;
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
                break MISSING_BLOCK_LABEL_274;
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                avoid.printStackTrace();
                break MISSING_BLOCK_LABEL_274;
            }
            i = 0;
        }
        if (i >= inponsel.length())
        {
            break MISSING_BLOCK_LABEL_274;
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
        segeraArray.add(listmodel);
        i++;
        if (true)
        {
            break MISSING_BLOCK_LABEL_65;
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
        txtMoreSegera.setVisibility(0);
        progressbar_segera.setVisibility(8);
        listSegera.setVisibility(0);
        if (segeraStrStat != null)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        if (segeraArray.size() != 0) goto _L2; else goto _L1
_L1:
        txtMoreSegera.setText("REFRESH");
_L3:
        txtMoreSegera.getText().toString().toLowerCase().contains("refresh");
        return;
_L2:
        try
        {
            txtMoreSegera.setText("MORE");
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            return;
        }
          goto _L3
        segeraAdapter.notifyDataSetChanged();
        layout_segera.setVisibility(0);
          goto _L3
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        dataSegera = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("home_segera").append(Utility.BASE_FORMAT).append("?idusr=").append(user_id).append("&lmt=0&t=").append(t).toString();
        txtMoreSegera.setVisibility(8);
        progressbar_segera.setVisibility(0);
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
