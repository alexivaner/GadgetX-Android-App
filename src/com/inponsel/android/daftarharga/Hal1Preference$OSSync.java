// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.daftarharga;

import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.inponsel.android.adapter.ListMerkAdapter;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.RestClient;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.daftarharga:
//            Hal1Preference

private class <init> extends AsyncTask
{

    final Hal1Preference this$0;

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
        ((RestClient) (obj)).Execute(com.inponsel.android.utils.od.GET);
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
        os_hp = new String[osArray.size()];
        os_hp = (String[])osArray.toArray(os_hp);
        os_hpID = new String[osArrayID.size()];
        os_hpID = (String[])osArrayID.toArray(os_hpID);
        saveArray(os_hp, "osArray", getActivity().getApplicationContext());
        saveArray(os_hpID, "osArrayID", getActivity().getApplicationContext());
        progressbar_middle_dialog.setVisibility(8);
        if (listProvArrayList.size() != 0)
        {
            break MISSING_BLOCK_LABEL_247;
        }
        txtEmpty.setText("Gagal terhubung ke server");
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
            Toast.makeText(getActivity(), getString(0x7f0c005a), 0).show();
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
            return;
        }
        jsonobject = s.getJSONObject(i);
        listmodel = new ListModel();
        listmodel.setMerk(jsonobject.getString("os"));
        listmodel.setId_merk(jsonobject.getString("id"));
        sis_os = jsonobject.getString("os");
        sis_osID = jsonobject.getString("id");
        osArray.add(sis_os);
        osArrayID.add(sis_osID);
        listProvArrayList.add(listmodel);
        i++;
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_56;
        }
    }

    private ()
    {
        this$0 = Hal1Preference.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
