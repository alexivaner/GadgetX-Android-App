// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.os.AsyncTask;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.inponsel.android.adapter.ListAdapter;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            ProfileActivity

private class <init> extends AsyncTask
{

    String suc;
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
        ((RestClient) (obj)).Execute(com.inponsel.android.utils.nBackground);
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
        progressbar_search.setVisibility(8);
        if (!suc.equals("0"))
        {
            break MISSING_BLOCK_LABEL_173;
        }
        if (android.os.SearchHpSync.suc < 13)
        {
            txtEmpty.setTextColor(-1);
        }
        txtEmpty.setText("Tidak temukan silahkan tulis ponsel anda di bawah ini");
        layout_empty.setVisibility(0);
        btnSubmitHp.setVisibility(0);
        btnSubmitHp.setVisibility(0);
        edtHpKetik.setVisibility(0);
        listHp.setVisibility(8);
_L1:
        log((new StringBuilder("lenght arrayList : ")).append(listArrayList.size()).toString());
        listAdapter.setListArray(listArrayList);
        listAdapter.notifyDataSetChanged();
        return;
        try
        {
            layout_empty.setVisibility(8);
            btnSubmitHp.setVisibility(8);
            edtHpKetik.setVisibility(8);
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
        Log.e("search", (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("home_search").append(Utility.BASE_FORMAT).append("?lmt=0&key=").append(edtAuto.getText().toString()).append("&t=").append(t).toString());
    }

    void parseJSON(String s)
    {
        JSONObject jsonobject1;
        ListModel listmodel;
        int i;
        try
        {
            JSONObject jsonobject = new JSONObject(s);
            listArrayList = new ArrayList();
            s = jsonobject.getJSONArray("InPonsel");
            suc = jsonobject.getString("success");
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
        jsonobject1 = s.getJSONObject(i);
        listmodel = new ListModel();
        listmodel.setId_hp(jsonobject1.getString("id_hp"));
        listmodel.setGambar(jsonobject1.getString("gambar"));
        listmodel.setNamalengkap((new StringBuilder(String.valueOf(jsonobject1.getString("merk")))).append(" ").append(jsonobject1.getString("model")).toString());
        listmodel.setModel(jsonobject1.getString("model"));
        listmodel.setMerk(jsonobject1.getString("merk"));
        listmodel.setCodename(jsonobject1.getString("codename"));
        listArrayList.add(listmodel);
        i++;
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_66;
        }
    }

    private ()
    {
        this$0 = ProfileActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
