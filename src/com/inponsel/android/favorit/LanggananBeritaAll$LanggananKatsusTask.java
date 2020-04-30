// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.favorit;

import android.os.AsyncTask;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.ServiceHandler;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.favorit:
//            LanggananBeritaAll

private class <init> extends AsyncTask
{

    final LanggananBeritaAll this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        {
            avoid = (new ServiceHandler()).makeServiceCall(dataKatsus, 1);
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
                inponselKatsus = avoid.getJSONArray("InPonsel");
                sucKatsus = avoid.getString("success");
                statKatsus = avoid.getString("stat");
                count_first_katsus = avoid.getInt("count_first");
                count_all_katsus = avoid.getInt("count_all");
                Log.e("suc", sucKatsus);
                counterKatsusArray = 0;
                if (!sucKatsus.equals("1"))
                {
                    break MISSING_BLOCK_LABEL_319;
                }
                langganKatsusArray.clear();
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
        if (i >= inponselKatsus.length())
        {
            break MISSING_BLOCK_LABEL_319;
        }
        avoid = LanggananBeritaAll.this;
        avoid.counterKatsusArray = ((LanggananBeritaAll) (avoid)).counterKatsusArray + 1;
        avoid = inponselKatsus.getJSONObject(i);
        listmodel = new ListModel();
        listmodel.setId_hp(avoid.getString("id_hp"));
        listmodel.setModel("");
        listmodel.setMerk(avoid.getString("merk"));
        listmodel.setCodename("");
        listmodel.setGambar(avoid.getString("gambar"));
        listmodel.setUmu_status("-");
        listmodel.setHrg_baru("");
        listmodel.setHrg_bekas("");
        langganKatsusArray.add(listmodel);
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
        try
        {
            Log.e("favHpArraybefore", String.valueOf(langganKatsusArray.size()));
            Log.e("data", dataKatsus);
            Log.e("langganKatsusArray", String.valueOf(langganKatsusArray.size()));
            langganKatsusAdapter.notifyDataSetChanged();
            Log.e("counterKatsusArray", String.valueOf(langganKatsusArray.size()));
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
        langganKatsusArray.clear();
    }

    private pter()
    {
        this$0 = LanggananBeritaAll.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
