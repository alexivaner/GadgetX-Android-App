// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.favorit;

import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.ProgressBar;
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
            avoid = (new ServiceHandler()).makeServiceCall(dataSearch, 1);
            Log.e("Responseharga: ", (new StringBuilder("> ")).append(avoid).toString());
            if (avoid == null)
            {
                break MISSING_BLOCK_LABEL_264;
            }
            ListModel listmodel;
            int i;
            try
            {
                avoid = new JSONObject(avoid);
                inponsel = avoid.getJSONArray("InPonsel");
                suc = avoid.getString("success");
                stat = avoid.getString("stat");
                counterArray = 0;
                if (!suc.equals("1"))
                {
                    break MISSING_BLOCK_LABEL_271;
                }
                listSearchArrayList.clear();
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                avoid.printStackTrace();
                break MISSING_BLOCK_LABEL_271;
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                avoid.printStackTrace();
                break MISSING_BLOCK_LABEL_271;
            }
            i = 0;
        }
        if (i >= inponsel.length())
        {
            break MISSING_BLOCK_LABEL_271;
        }
        avoid = LanggananBeritaAll.this;
        avoid.counterArray = ((LanggananBeritaAll) (avoid)).counterArray + 1;
        avoid = inponsel.getJSONObject(i);
        listmodel = new ListModel();
        listmodel.setUni_id(avoid.getString("id"));
        listmodel.setUni_name(avoid.getString("nama"));
        listmodel.setUni_gambar(avoid.getString("gambar"));
        listmodel.setUni_type(avoid.getString("type"));
        listmodel.setUni_stat(avoid.getString("favorit"));
        listSearchArrayList.add(listmodel);
        i++;
        if (true)
        {
            break MISSING_BLOCK_LABEL_127;
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
            progressbar_search.setVisibility(8);
            listSearchAdapter.notifyDataSetChanged();
            listFindDev.setVisibility(0);
            Log.e("counterArray", String.valueOf(listSearchArrayList.size()));
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
    }

    private ()
    {
        this$0 = LanggananBeritaAll.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
