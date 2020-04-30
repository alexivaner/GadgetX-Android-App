// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.os.AsyncTask;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.actionbarsherlock.ActionBarSherlock;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.ServiceHandler;
import com.inponsel.android.widget.ExpandableHeightGridView;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            PonselRekomendasiActivity

private class <init> extends AsyncTask
{

    final PonselRekomendasiActivity this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        {
            avoid = (new ServiceHandler()).makeServiceCall(dataPonsel, 1);
            Log.e("Responseharga: ", (new StringBuilder("> ")).append(avoid).toString());
            if (avoid == null)
            {
                break MISSING_BLOCK_LABEL_366;
            }
            ListModel listmodel;
            int i;
            try
            {
                avoid = new JSONObject(avoid);
                inponsel = avoid.getJSONArray("InPonsel");
                suc = avoid.getString("success");
                stat = avoid.getString("stat");
                Log.e("suc", suc);
                counterArray = 0;
                if (!suc.equals("1"))
                {
                    break MISSING_BLOCK_LABEL_373;
                }
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                avoid.printStackTrace();
                break MISSING_BLOCK_LABEL_373;
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                avoid.printStackTrace();
                break MISSING_BLOCK_LABEL_373;
            }
            i = 0;
        }
        if (i >= inponsel.length())
        {
            break MISSING_BLOCK_LABEL_373;
        }
        avoid = PonselRekomendasiActivity.this;
        avoid.counterArray = ((PonselRekomendasiActivity) (avoid)).counterArray + 1;
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
        listmodel.setTotal_votes(avoid.getString("total_vote"));
        listmodel.setAvg_all(avoid.getString("total_avg"));
        ponselMerekArray.add(listmodel);
        i++;
        if (true)
        {
            break MISSING_BLOCK_LABEL_129;
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
        PonselRekomendasiActivity.access$0(PonselRekomendasiActivity.this).setProgressBarIndeterminateVisibility(false);
        PonselRekomendasiActivity.access$0(PonselRekomendasiActivity.this).setProgressBarVisibility(false);
        listPonselOS.setVisibility(0);
        layout_empty.setVisibility(8);
        Log.e("ponselMerekArraybefore", String.valueOf(ponselMerekArray.size()));
        Log.e("data", dataPonsel);
        if (suc.equals("1"))
        {
            break MISSING_BLOCK_LABEL_248;
        }
        grup_header_footer.setVisibility(8);
        progressbar_middle.setVisibility(8);
        listPonselOS.setVisibility(0);
        layout_empty.setVisibility(0);
        txt_empty.setText("Data belum tersedia");
_L1:
        Log.e("ponselMerekArrayafter", String.valueOf(ponselMerekArray.size()));
        ponselOsAdapter.notifyDataSetChanged();
        listPonselOS.invalidateViews();
        listPonselOS.refreshDrawableState();
        Log.e("counterArray", String.valueOf(ponselMerekArray.size()));
        if (counterArray < 10)
        {
            grup_header_footer.setVisibility(8);
            return;
        }
        break MISSING_BLOCK_LABEL_262;
        try
        {
            listPonselOS.setVisibility(0);
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            return;
        }
          goto _L1
        btnMemuatLagi.setVisibility(0);
        return;
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
    }

    private apter()
    {
        this$0 = PonselRekomendasiActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
