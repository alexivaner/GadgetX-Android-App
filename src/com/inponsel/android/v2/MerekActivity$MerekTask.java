// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.os.AsyncTask;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.actionbarsherlock.ActionBarSherlock;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.ServiceHandler;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            MerekActivity

private class <init> extends AsyncTask
{

    final MerekActivity this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        {
            avoid = (new ServiceHandler()).makeServiceCall(dataMerek, 1);
            Log.e("Responseharga: ", (new StringBuilder("> ")).append(avoid).toString());
            if (avoid == null)
            {
                break MISSING_BLOCK_LABEL_283;
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
                    break MISSING_BLOCK_LABEL_290;
                }
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                avoid.printStackTrace();
                break MISSING_BLOCK_LABEL_290;
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                avoid.printStackTrace();
                break MISSING_BLOCK_LABEL_290;
            }
            i = 0;
        }
        if (i >= inponsel.length())
        {
            break MISSING_BLOCK_LABEL_290;
        }
        avoid = MerekActivity.this;
        avoid.counterArray = ((MerekActivity) (avoid)).counterArray + 1;
        avoid = inponsel.getJSONObject(i);
        listmodel = new ListModel();
        listmodel.setId_merk(avoid.getString("id_merk"));
        listmodel.setMerk(avoid.getString("merk"));
        listmodel.setTwitter(avoid.getString("twitter"));
        listmodel.setFacebook(avoid.getString("facebook"));
        listmodel.setFacebook_id(avoid.getString("facebook_id"));
        listmodel.setLogo(avoid.getString("logo"));
        listmodel.setSubs_status(avoid.getString("subs_stat"));
        listmodel.setFav_status(avoid.getString("fav_stat"));
        merekHpArray.add(listmodel);
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
        listPonselOS.setVisibility(0);
        layout_empty.setVisibility(8);
        try
        {
            Log.e("taskLst", "pendatang");
            Log.e("data", dataMerek);
            counterArray = 0;
            listPonselOS.setVisibility(0);
            ponselOsAdapter.notifyDataSetChanged();
            Log.e("counterArray", String.valueOf(merekHpArray.size()));
            MerekActivity.access$0(MerekActivity.this).setProgressBarIndeterminateVisibility(false);
            MerekActivity.access$0(MerekActivity.this).setProgressBarVisibility(false);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            layout_empty.setVisibility(0);
        }
        progressbar_middle.setVisibility(8);
        txt_empty.setVisibility(8);
        MerekActivity.access$0(MerekActivity.this).setProgressBarIndeterminateVisibility(false);
        MerekActivity.access$0(MerekActivity.this).setProgressBarVisibility(false);
        btnMerekRefresh.setVisibility(0);
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        btnMerekRefresh.setVisibility(8);
        progressbar_middle.setVisibility(0);
        txt_empty.setVisibility(0);
        layout_empty.setVisibility(0);
    }

    private angAdapter()
    {
        this$0 = MerekActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
