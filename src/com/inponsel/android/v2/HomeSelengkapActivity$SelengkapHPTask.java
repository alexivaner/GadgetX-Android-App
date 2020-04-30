// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.os.AsyncTask;
import android.widget.Button;
import android.widget.LinearLayout;
import com.actionbarsherlock.ActionBarSherlock;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.ServiceHandler;
import com.inponsel.android.widget.ExpandableHeightListView2;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            HomeSelengkapActivity

private class <init> extends AsyncTask
{

    final HomeSelengkapActivity this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        {
            avoid = (new ServiceHandler()).makeServiceCall(dataSelengkap, 1);
            Log.e("Responseharga: ", (new StringBuilder("> ")).append(avoid).toString());
            if (avoid == null)
            {
                break MISSING_BLOCK_LABEL_333;
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
                    break MISSING_BLOCK_LABEL_340;
                }
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                avoid.printStackTrace();
                break MISSING_BLOCK_LABEL_340;
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                avoid.printStackTrace();
                break MISSING_BLOCK_LABEL_340;
            }
            i = 0;
        }
        if (i >= inponsel.length())
        {
            break MISSING_BLOCK_LABEL_340;
        }
        avoid = HomeSelengkapActivity.this;
        avoid.counterArray = ((HomeSelengkapActivity) (avoid)).counterArray + 1;
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
        hpMoreArray.add(listmodel);
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
        listSelengkap.setVisibility(0);
        layout_empty.setVisibility(8);
        Log.e("taskLst", "pendatang");
        Log.e("data", dataSelengkap);
        if (!suc.equals("1")) goto _L2; else goto _L1
_L1:
        listSelengkap.setVisibility(0);
_L5:
        selengkapAdapter.notifyDataSetChanged();
        Log.e("counterArray", String.valueOf(counterArray));
        if (hpMoreArray.size() != 30) goto _L4; else goto _L3
_L3:
        grup_header_footer.setVisibility(8);
        btnMemuatLagi.setVisibility(8);
_L6:
        Log.e("counterArray", String.valueOf(counterArray));
        HomeSelengkapActivity.access$0(HomeSelengkapActivity.this).setProgressBarIndeterminateVisibility(false);
        HomeSelengkapActivity.access$0(HomeSelengkapActivity.this).setProgressBarVisibility(false);
        return;
_L2:
        try
        {
            grup_header_footer.setVisibility(8);
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            return;
        }
          goto _L5
_L4:
label0:
        {
            if (counterArray != 0)
            {
                break label0;
            }
            grup_header_footer.setVisibility(8);
            btnMemuatLagi.setVisibility(8);
        }
          goto _L6
        btnMemuatLagi.setVisibility(0);
        grup_header_footer.setVisibility(0);
          goto _L6
    }

    private pter()
    {
        this$0 = HomeSelengkapActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
