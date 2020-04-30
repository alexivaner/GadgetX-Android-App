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
            avoid = (new ServiceHandler()).makeServiceCall(dataLangganOperator, 1);
            Log.e("Responseharga: ", (new StringBuilder("> ")).append(avoid).toString());
            if (avoid == null)
            {
                break MISSING_BLOCK_LABEL_302;
            }
            ListModel listmodel;
            int i;
            try
            {
                avoid = new JSONObject(avoid);
                inponsel = avoid.getJSONArray("InPonsel");
                suc = avoid.getString("success");
                stat = avoid.getString("stat");
                count_first_OperatorLangganan = avoid.getInt("count_first");
                count_all_OperatorLangganan = avoid.getInt("count_all");
                Log.e("suc", suc);
                counterArray = 0;
                if (!suc.equals("1"))
                {
                    break MISSING_BLOCK_LABEL_309;
                }
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                avoid.printStackTrace();
                break MISSING_BLOCK_LABEL_309;
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                avoid.printStackTrace();
                break MISSING_BLOCK_LABEL_309;
            }
            i = 0;
        }
        if (i >= inponsel.length())
        {
            break MISSING_BLOCK_LABEL_309;
        }
        avoid = BaseDrawer.this;
        avoid.counterArray = ((BaseDrawer) (avoid)).counterArray + 1;
        avoid = inponsel.getJSONObject(i);
        listmodel = new ListModel();
        listmodel.setId_hp(avoid.getString("id_hp"));
        listmodel.setModel("");
        listmodel.setMerk(avoid.getString("merk"));
        listmodel.setCodename("");
        listmodel.setGambar(avoid.getString("gambar"));
        listmodel.setUmu_status("-");
        listmodel.setHrg_baru("");
        listmodel.setHrg_bekas("");
        langganOpArray.add(listmodel);
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
            Log.e("langganOpArray", String.valueOf(langganOpArray.size()));
            Log.e("dataLangganOperator", dataLangganOperator);
            Log.e("langganOpArray", String.valueOf(langganOpArray.size()));
            langganOpAdapter.notifyDataSetChanged();
            Log.e("counterArray", String.valueOf(langganOpArray.size()));
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
        langganOpArray.clear();
    }

    private r()
    {
        this$0 = BaseDrawer.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
