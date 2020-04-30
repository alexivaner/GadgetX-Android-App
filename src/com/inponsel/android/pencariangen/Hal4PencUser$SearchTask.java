// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.pencariangen;

import android.os.AsyncTask;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.ServiceHandler;
import com.inponsel.android.widget.ExpandableHeightGridView;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.pencariangen:
//            Hal4PencUser

private class <init> extends AsyncTask
{

    final Hal4PencUser this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        {
            avoid = (new ServiceHandler()).makeServiceCall(dataSearch, 1);
            if (avoid == null)
            {
                break MISSING_BLOCK_LABEL_200;
            }
            ListModel listmodel;
            int i;
            try
            {
                avoid = new JSONObject(avoid);
                suc = avoid.getString("success");
                jumSC = avoid.getString("count");
                Log.e("suc", suc);
                inponsel = avoid.getJSONArray("InPonsel");
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                avoid.printStackTrace();
                break MISSING_BLOCK_LABEL_207;
            }
            i = 0;
        }
        if (i >= inponsel.length())
        {
            break MISSING_BLOCK_LABEL_207;
        }
        avoid = inponsel.getJSONObject(i);
        listmodel = new ListModel();
        listmodel.setId_user(avoid.getString("id"));
        listmodel.setNama_asli(avoid.getString("nama"));
        listmodel.setUsername(avoid.getString("username"));
        listmodel.setAvatar(avoid.getString("avatar"));
        Log.e("nama: ", avoid.getString("nama"));
        scpencarianArray.add(listmodel);
        i++;
        if (true)
        {
            break MISSING_BLOCK_LABEL_85;
        }
        Log.e("ServiceHandler", "Couldn't get any data from the url");
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        super.onPostExecute(void1);
        Log.e("tasksdsurlSearch", dataSearch);
        Log.e("tasksdsurlSearch", String.valueOf(scpencarianArray.size()));
        progressbar_middleSC.setVisibility(8);
        scpencarianAdapter.notifyDataSetChanged();
        if (scpencarianArray.size() != 0) goto _L2; else goto _L1
_L1:
        Log.e("listsc", "gone");
        txt_empty.setText("User tidak ditemukan");
        layout_empty.setVisibility(0);
_L3:
        Log.e("counterArray", String.valueOf(scpencarianArray.size()));
        if (scpencarianArray.size() >= 15)
        {
            break MISSING_BLOCK_LABEL_204;
        }
        grup_header_footer.setVisibility(8);
_L4:
        edtAuto.post(new Runnable() {

            final Hal4PencUser.SearchTask this$1;

            public void run()
            {
                edtAuto.requestFocus();
            }

            
            {
                this$1 = Hal4PencUser.SearchTask.this;
                super();
            }
        });
        return;
_L2:
        try
        {
            Log.e("listsc", "visible");
            layout_empty.setVisibility(8);
            listSCManual.setVisibility(0);
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            void1.printStackTrace();
            return;
        }
          goto _L3
        btnMemuatLagi.setVisibility(0);
        grup_header_footer.setVisibility(0);
          goto _L4
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        if (limit == 0)
        {
            scpencarianArray.clear();
            progressbar_middleSC.setVisibility(0);
            return;
        } else
        {
            btnMemuatLagi.setVisibility(8);
            return;
        }
    }


    private _cls1.this._cls1()
    {
        this$0 = Hal4PencUser.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
