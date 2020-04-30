// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.os.AsyncTask;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.adapter.ListOperatorAdapter;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.RestClient;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            ProfileActivity

private class <init> extends AsyncTask
{

    final ProfileActivity this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    protected transient Void doInBackground(String as[])
    {
        int i;
        int j;
        j = as.length;
        i = 0;
_L3:
        if (i >= j)
        {
            return null;
        }
        Object obj = new RestClient(as[i]);
        ((RestClient) (obj)).Execute(com.inponsel.android.utils.GET);
_L1:
        Exception exception1;
        try
        {
            obj = ((RestClient) (obj)).getResponse();
            getJson = ((String) (obj));
            parseJSON(((String) (obj)));
        }
        catch (Exception exception) { }
        break MISSING_BLOCK_LABEL_65;
        exception1;
        exception1.printStackTrace();
          goto _L1
        i++;
        if (true) goto _L3; else goto _L2
_L2:
    }

    void log(String s)
    {
        Log.e("Near", s);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        super.onPostExecute(void1);
        kota_strarray = new String[kotaArray.size()];
        kota_strarray = (String[])kotaArray.toArray(kota_strarray);
        kota_strarrayID = new String[kotaArrayID.size()];
        kota_strarrayID = (String[])kotaArrayID.toArray(kota_strarrayID);
        Log.e("preference", provinsiprefrence);
        saveArray(kota_strarray, provinsiprefrence, getApplicationContext());
        saveArray(kota_strarrayID, provinsiidprefrence, getApplicationContext());
        progressbar_search.setVisibility(8);
        if (jml != 0)
        {
            break MISSING_BLOCK_LABEL_271;
        }
        txtEmpty.setText(0x7f0c0058);
        layout_empty.setVisibility(0);
_L1:
        log((new StringBuilder("lenght arrayList : ")).append(listKotaArrayList.size()).toString());
        listOperatorAdapter.setListArray(listKotaArrayList);
        listOperatorAdapter.notifyDataSetChanged();
        return;
        try
        {
            layout_empty.setVisibility(8);
            listHp.setVisibility(0);
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            return;
        }
          goto _L1
    }

    protected void onPreExcute()
    {
        super.onPreExecute();
    }

    void parseJSON(String s)
    {
        JSONObject jsonobject;
        ListModel listmodel;
        int i;
        try
        {
            s = new JSONObject(s);
            listKotaArrayList = new ArrayList();
            s = s.getJSONArray("InPonsel");
            log((new StringBuilder("lenght: ")).append(s.length()).toString());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return;
        }
        i = 0;
        if (i >= s.length())
        {
            jml = s.length();
            Log.e("jarray", String.valueOf(jml));
            return;
        }
        jsonobject = s.getJSONObject(i);
        listmodel = new ListModel();
        listmodel.setKota_id(jsonobject.getString("id"));
        listmodel.setProvinsi_id(jsonobject.getString("provinsi_id"));
        listmodel.setNm_op(jsonobject.getString("kota"));
        kota_str = jsonobject.getString("kota");
        kota_strID = jsonobject.getString("id");
        kotaArray.add(kota_str);
        kotaArrayID.add(kota_strID);
        listKotaArrayList.add(listmodel);
        i++;
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_56;
        }
    }

    private od()
    {
        this$0 = ProfileActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
