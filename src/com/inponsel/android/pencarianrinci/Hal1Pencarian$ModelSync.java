// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.pencarianrinci;

import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.inponsel.android.adapter.ListMerkAdapter;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.RestClient;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.pencarianrinci:
//            Hal1Pencarian

private class <init> extends AsyncTask
{

    final Hal1Pencarian this$0;

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
        ((RestClient) (obj)).Execute(com.inponsel.android.utils..GET);
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
        model_hp = new String[modelArray.size()];
        model_hp = (String[])modelArray.toArray(model_hp);
        model_hpID = new String[modelArrayID.size()];
        model_hpID = (String[])modelArrayID.toArray(model_hpID);
        saveArray(model_hp, "modelArray", getActivity().getApplicationContext());
        saveArray(model_hpID, "modelArrayID", getActivity().getApplicationContext());
        progressbar_middle_dialog.setVisibility(8);
        jml = String.valueOf(listProvArrayList.size());
        if (!jml.equals("") && !jml.equals("0"))
        {
            break MISSING_BLOCK_LABEL_284;
        }
        txtEmpty.setText(0x7f0c0059);
_L1:
        log((new StringBuilder("lenght arrayList : ")).append(listProvArrayList.size()).toString());
        listMerkAdapter.setListArray(listProvArrayList);
        listMerkAdapter.notifyDataSetChanged();
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
            listProvArrayList = new ArrayList();
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
            jml = String.valueOf(s.length());
            Log.e("jarray", jml);
            return;
        }
        jsonobject = s.getJSONObject(i);
        listmodel = new ListModel();
        listmodel.setMerk(jsonobject.getString("model"));
        listmodel.setId_merk(jsonobject.getString("id"));
        har_model = jsonobject.getString("model");
        har_modelID = jsonobject.getString("id");
        modelArray.add(har_model);
        modelArrayID.add(har_modelID);
        listProvArrayList.add(listmodel);
        i++;
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_56;
        }
    }

    private A()
    {
        this$0 = Hal1Pencarian.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
