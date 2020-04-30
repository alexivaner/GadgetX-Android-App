// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.actionbarsherlock.ActionBarSherlock;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.utils.ExpandedListView;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.ServiceHandler;
import com.inponsel.android.utils.Util;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            SCUserActivity

private class <init> extends AsyncTask
{

    final SCUserActivity this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        {
            avoid = (new ServiceHandler()).makeServiceCall(dataSCProv, 1);
            if (avoid == null)
            {
                break MISSING_BLOCK_LABEL_405;
            }
            ListModel listmodel;
            int i;
            try
            {
                avoid = new JSONObject(avoid);
                suc = avoid.getString("success");
                Log.e("suc", suc);
                inponsel = avoid.getJSONArray("InPonsel");
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                avoid.printStackTrace();
                break MISSING_BLOCK_LABEL_412;
            }
            i = 0;
        }
        if (i >= inponsel.length())
        {
            break MISSING_BLOCK_LABEL_412;
        }
        avoid = inponsel.getJSONObject(i);
        listmodel = new ListModel();
        listmodel.setId_sc(avoid.getString("id_sc"));
        listmodel.setSc_nama(avoid.getString("sc_nama"));
        listmodel.setSc_merk(avoid.getString("sc_merk"));
        listmodel.setSc_fb(avoid.getString("sc_fb"));
        listmodel.setSc_ytube(avoid.getString("sc_ytube"));
        listmodel.setSc_fb_id(avoid.getString("sc_fb_id"));
        listmodel.setSc_tw(avoid.getString("sc_tw"));
        listmodel.setSc_logo((new StringBuilder(String.valueOf(Util.BASE_PATH_BRANDS))).append(avoid.getString("sc_logo")).toString());
        listmodel.setSc_ket_tambahan(avoid.getString("ket_tambahan"));
        listmodel.setSc_provinsi(avoid.getString("provinsi"));
        listmodel.setSc_kota(avoid.getString("kota"));
        listmodel.setSc_alamat(avoid.getString("alamat"));
        listmodel.setSc_no_telp(avoid.getString("no_telp"));
        listmodel.setSc_no_telp_ket(avoid.getString("no_telp_ket"));
        listmodel.setSc_c_center(avoid.getString("c_center"));
        listmodel.setSc_ven_center(avoid.getString("sc_c_center"));
        listmodel.setSc_email(avoid.getString("email"));
        listmodel.setSc_web_url(avoid.getString("web_url"));
        listmodel.setSc_rate(avoid.getString("sc_rateAvg"));
        listmodel.setSc_rate5(avoid.getString("sc_rate5"));
        listmodel.setSc_rate4(avoid.getString("sc_rate4"));
        listmodel.setSc_rate3(avoid.getString("sc_rate3"));
        listmodel.setSc_rate2(avoid.getString("sc_rate2"));
        listmodel.setSc_rate1(avoid.getString("sc_rate1"));
        listmodel.setSc_total_rate(avoid.getString("total_rate"));
        scProvArray.add(listmodel);
        i++;
        if (true)
        {
            break MISSING_BLOCK_LABEL_72;
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
        Log.e("tasksdsurlSearch", dataSCProv);
        Log.e("tasksdsurlSearch", String.valueOf(scProvArray.size()));
        progressbar_sc_provinsi.setVisibility(8);
        if (scProvArray.size() != 0)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        listsc_provinsi.setVisibility(8);
        txtemptysc_provinsi.setVisibility(0);
_L1:
        scProvAdapter.notifyDataSetChanged();
        SCUserActivity.access$0(SCUserActivity.this).setProgressBarIndeterminateVisibility(false);
        return;
        try
        {
            listsc_provinsi.setVisibility(0);
            txtemptysc_provinsi.setVisibility(8);
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            void1.printStackTrace();
            return;
        }
          goto _L1
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        scProvArray.clear();
        progressbar_sc_provinsi.setVisibility(0);
    }

    private dapter()
    {
        this$0 = SCUserActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
