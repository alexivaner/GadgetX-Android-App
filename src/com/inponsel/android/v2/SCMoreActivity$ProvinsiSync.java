// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Context;
import android.os.AsyncTask;
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

// Referenced classes of package com.inponsel.android.v2:
//            SCMoreActivity

private class <init> extends AsyncTask
{

    final SCMoreActivity this$0;

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
        ((RestClient) (obj)).Execute(com.inponsel.android.utils.);
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
        merk_hp = new String[merkArray.size()];
        merk_hp = (String[])merkArray.toArray(merk_hp);
        merk_hpID = new String[merkArrayID.size()];
        merk_hpID = (String[])merkArrayID.toArray(merk_hpID);
        saveArray(merk_hp, "merkArray", getApplicationContext().getApplicationContext());
        saveArray(merk_hpID, "merkArrayID", getApplicationContext().getApplicationContext());
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
        listmodel.setMerk(jsonobject.getString("merk"));
        listmodel.setId_merk(jsonobject.getString("id_merk"));
        merk_ven = jsonobject.getString("merk");
        merk_venID = jsonobject.getString("id_merk");
        merkArray.add(merk_ven);
        merkArrayID.add(merk_venID);
        listProvArrayList.add(listmodel);
        i++;
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_56;
        }
    }

    private _cls9()
    {
        this$0 = SCMoreActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
