// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.os.AsyncTask;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.actionbarsherlock.ActionBarSherlock;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.ServiceHandler;
import com.inponsel.android.widget.ExpandableHeightGridView;
import fr.castorflex.android.circularprogressbar.CircularProgressBar;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            TurunHargaPonselActivity

private class <init> extends AsyncTask
{

    final TurunHargaPonselActivity this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        {
            avoid = (new ServiceHandler()).makeServiceCall(dataTurunHarga, 1);
            Log.e("Responseharga: ", (new StringBuilder("> ")).append(avoid).toString());
            if (avoid == null)
            {
                break MISSING_BLOCK_LABEL_353;
            }
            ListModel listmodel;
            int i;
            try
            {
                avoid = new JSONObject(avoid);
                inponsel = avoid.getJSONArray("InPonsel");
                suc = avoid.getString("success");
                Log.e("suc", suc);
                counterArray = 0;
                if (!suc.equals("1"))
                {
                    break MISSING_BLOCK_LABEL_360;
                }
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                avoid.printStackTrace();
                break MISSING_BLOCK_LABEL_360;
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                avoid.printStackTrace();
                break MISSING_BLOCK_LABEL_360;
            }
            i = 0;
        }
        if (i >= inponsel.length())
        {
            break MISSING_BLOCK_LABEL_360;
        }
        avoid = TurunHargaPonselActivity.this;
        avoid.counterArray = ((TurunHargaPonselActivity) (avoid)).counterArray + 1;
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
        listmodel.setPenurunan_harga(avoid.getString("penurunan_harga"));
        listmodel.setUpdate_harga(avoid.getString("update_harga"));
        turunHargaArray.add(listmodel);
        i++;
        if (true)
        {
            break MISSING_BLOCK_LABEL_116;
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
        TurunHargaPonselActivity.access$0(TurunHargaPonselActivity.this).setProgressBarIndeterminateVisibility(false);
        TurunHargaPonselActivity.access$0(TurunHargaPonselActivity.this).setProgressBarVisibility(false);
        listPonselOS.setVisibility(0);
        layout_empty.setVisibility(8);
        Log.e("taskLst", "pendatang");
        Log.e("data", dataTurunHarga);
        if (suc.equals("1"))
        {
            break MISSING_BLOCK_LABEL_197;
        }
        grup_header_footer.setVisibility(8);
        progressbar_middle.setVisibility(8);
        listPonselOS.setVisibility(0);
        layout_empty.setVisibility(0);
        txt_empty.setText("Data belum tersedia");
_L1:
        ponselOsAdapter.notifyDataSetChanged();
        Log.e("counterArray", String.valueOf(turunHargaArray.size()));
        if (counterArray < 10)
        {
            grup_header_footer.setVisibility(8);
            return;
        }
        break MISSING_BLOCK_LABEL_211;
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
        grup_header_footer.setVisibility(0);
        return;
    }

    private dapter()
    {
        this$0 = TurunHargaPonselActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
