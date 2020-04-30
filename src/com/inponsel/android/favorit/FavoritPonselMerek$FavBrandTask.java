// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.favorit;

import android.os.AsyncTask;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.ServiceHandler;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.favorit:
//            FavoritPonselMerek

private class <init> extends AsyncTask
{

    final FavoritPonselMerek this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        {
            avoid = (new ServiceHandler()).makeServiceCall(dataBrand, 1);
            Log.e("Responseharga: ", (new StringBuilder("> ")).append(avoid).toString());
            if (avoid == null)
            {
                break MISSING_BLOCK_LABEL_312;
            }
            ListModel listmodel;
            int i;
            try
            {
                avoid = new JSONObject(avoid);
                inponsel = avoid.getJSONArray("InPonsel");
                suc = avoid.getString("success");
                stat = avoid.getString("stat");
                count_first_favbrand = avoid.getInt("count_first");
                count_all_favbrand = avoid.getInt("count_all");
                Log.e("suc", suc);
                counterArray = 0;
                if (!suc.equals("1"))
                {
                    break MISSING_BLOCK_LABEL_319;
                }
                favBrandArray.clear();
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                avoid.printStackTrace();
                break MISSING_BLOCK_LABEL_319;
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                avoid.printStackTrace();
                break MISSING_BLOCK_LABEL_319;
            }
            i = 0;
        }
        if (i >= inponsel.length())
        {
            break MISSING_BLOCK_LABEL_319;
        }
        avoid = FavoritPonselMerek.this;
        avoid.counterArray = ((FavoritPonselMerek) (avoid)).counterArray + 1;
        avoid = inponsel.getJSONObject(i);
        listmodel = new ListModel();
        listmodel.setId_hp(avoid.getString("id_brand"));
        listmodel.setModel("");
        listmodel.setMerk(avoid.getString("merk"));
        listmodel.setCodename("");
        listmodel.setGambar(avoid.getString("logo"));
        listmodel.setUmu_status("-");
        listmodel.setHrg_baru("");
        listmodel.setHrg_bekas("");
        favBrandArray.add(listmodel);
        i++;
        if (true)
        {
            break MISSING_BLOCK_LABEL_165;
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
        progressbar_middle.setVisibility(8);
        Log.e("data", dataBrand);
        (new Handler()).postDelayed(new Runnable() {

            final FavoritPonselMerek.FavBrandTask this$1;

            public void run()
            {
                scrolView.fullScroll(33);
            }

            
            {
                this$1 = FavoritPonselMerek.FavBrandTask.this;
                super();
            }
        }, 100L);
        Log.e("favBrandArray", String.valueOf(favBrandArray.size()));
        favBrandAdapter.notifyDataSetChanged();
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
    }


    private _cls1.this._cls1()
    {
        this$0 = FavoritPonselMerek.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
