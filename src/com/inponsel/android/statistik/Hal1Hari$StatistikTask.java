// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.statistik;

import android.os.AsyncTask;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.ServiceHandler;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.statistik:
//            Hal1Hari

private class <init> extends AsyncTask
{

    final Hal1Hari this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        {
            avoid = (new ServiceHandler()).makeServiceCall(dataStatistik, 1);
            statistikArray.clear();
            statistikStrStat = avoid;
            if (avoid == null)
            {
                break MISSING_BLOCK_LABEL_296;
            }
            Object obj;
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
                break MISSING_BLOCK_LABEL_303;
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                avoid.printStackTrace();
                break MISSING_BLOCK_LABEL_303;
            }
            i = 0;
        }
        if (i >= inponsel.length())
        {
            break MISSING_BLOCK_LABEL_303;
        }
        obj = inponsel.getJSONObject(i);
        avoid = new ListModel();
        avoid.setId_hp(((JSONObject) (obj)).getString("id_hp"));
        avoid.setModel(((JSONObject) (obj)).getString("model"));
        avoid.setMerk(((JSONObject) (obj)).getString("merk"));
        avoid.setCodename(((JSONObject) (obj)).getString("codename"));
        avoid.setGambar(((JSONObject) (obj)).getString("gambar"));
        avoid.setUmu_status(((JSONObject) (obj)).getString("umu_status"));
        avoid.setHrg_baru(((JSONObject) (obj)).getString("hrg_baru"));
        avoid.setHrg_bekas(((JSONObject) (obj)).getString("hrg_bekas"));
        avoid.setTotal_like(((JSONObject) (obj)).getString("total_like"));
        avoid.setTotal_dislike(((JSONObject) (obj)).getString("total_dislike"));
        avoid.setTotal_hits(((JSONObject) (obj)).getString("total_hits"));
        avoid.setTotal_kom(((JSONObject) (obj)).getString("total_kom"));
        avoid.setMy_like_pon(((JSONObject) (obj)).getString("my_like_pon"));
        obj = Hal1Hari.this;
        obj.no = ((Hal1Hari) (obj)).no + 1;
        avoid.setNourut(String.valueOf(no));
        statistikArray.add(avoid);
        i++;
        if (true)
        {
            break MISSING_BLOCK_LABEL_65;
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
        try
        {
            progressbar_middle.setVisibility(8);
            layout_empty.setVisibility(8);
            no = 0;
            lainAdapter.notifyDataSetChanged();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        progressbar_middle.setVisibility(0);
        layout_empty.setVisibility(0);
        statistikArray.clear();
    }

    private r()
    {
        this$0 = Hal1Hari.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
