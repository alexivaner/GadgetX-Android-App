// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.os.AsyncTask;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.ServiceHandler;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            BaseDrawer

private class <init> extends AsyncTask
{

    final BaseDrawer this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        {
            avoid = (new ServiceHandler()).makeServiceCall(dataPonsel, 1);
            Log.e("Responsefavhp: ", (new StringBuilder("> ")).append(avoid).toString());
            if (avoid == null)
            {
                break MISSING_BLOCK_LABEL_322;
            }
            ListModel listmodel;
            int i;
            try
            {
                avoid = new JSONObject(avoid);
                inponsel = avoid.getJSONArray("InPonsel");
                suc = avoid.getString("success");
                stat = avoid.getString("stat");
                count_first_favhp = avoid.getInt("count_first");
                count_all_favhp = avoid.getInt("count_all");
                Log.e("suc", suc);
                counterHpArray = 0;
                if (!suc.equals("1"))
                {
                    break MISSING_BLOCK_LABEL_329;
                }
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                avoid.printStackTrace();
                break MISSING_BLOCK_LABEL_329;
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                avoid.printStackTrace();
                break MISSING_BLOCK_LABEL_329;
            }
            i = 0;
        }
        if (i >= inponsel.length())
        {
            break MISSING_BLOCK_LABEL_329;
        }
        avoid = BaseDrawer.this;
        avoid.counterHpArray = ((BaseDrawer) (avoid)).counterHpArray + 1;
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
        favHpArray.add(listmodel);
        i++;
        if (true)
        {
            break MISSING_BLOCK_LABEL_155;
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
            Log.e("data", dataPonsel);
            Log.e("favHpArrayafter", String.valueOf(favHpArray.size()));
            favHpAdapter.notifyDataSetChanged();
            Log.e("counterArray", String.valueOf(favHpArray.size()));
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
        favHpArray.clear();
    }

    private er()
    {
        this$0 = BaseDrawer.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}