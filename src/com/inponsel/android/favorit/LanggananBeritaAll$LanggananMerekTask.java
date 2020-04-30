// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.favorit;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.gson.Gson;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Response;
import com.inponsel.android.widget.ExpandableHeightGridView;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

// Referenced classes of package com.inponsel.android.favorit:
//            LanggananBeritaAll

private class <init> extends AsyncTask
{

    Response response;
    final LanggananBeritaAll this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        avoid = new HttpGet(dataMerek);
        Object obj;
        int i;
        try
        {
            obj = (new DefaultHttpClient()).execute(avoid);
            i = ((HttpResponse) (obj)).getStatusLine().getStatusCode();
        }
        catch (IOException ioexception)
        {
            avoid.abort();
            return null;
        }
        if (i == 200)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        Log.e(getClass().getSimpleName(), (new StringBuilder("Error ")).append(i).append(" for URL ").append(dataFav).toString());
        return null;
        obj = new InputStreamReader(((HttpResponse) (obj)).getEntity().getContent());
        response = (Response)(new Gson()).fromJson(((java.io.Reader) (obj)), com/inponsel/android/utils/Response);
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        super.onPostExecute(void1);
        void1 = response.InPonsel.iterator();
_L3:
        if (void1.hasNext()) goto _L2; else goto _L1
_L1:
        mereknAdapter.notifyDataSetChanged();
        listLanggananMerek.setVisibility(0);
        Log.e("listLangganan", String.valueOf(merekArray.size()));
_L4:
        progressbar_Merek.setVisibility(8);
        return;
_L2:
        ListModel listmodel;
        listmodel = (ListModel)void1.next();
        if (!listmodel.getId_hp().equals("-") || !listmodel.getModel().equals("-"))
        {
            break MISSING_BLOCK_LABEL_157;
        }
        progressbar_Merek.setVisibility(8);
        txt_empty_merek.setText("Belum langganan berita");
        txt_empty_merek.setVisibility(0);
          goto _L3
        void1;
        void1.printStackTrace();
          goto _L4
        txt_empty_merek.setVisibility(8);
        id_hph = listmodel.getId_hp();
        merk = listmodel.getMerk();
        model = listmodel.getModel();
        gambar = listmodel.getGambar();
        type = listmodel.getType();
        merekArray.add(listmodel);
          goto _L3
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        progressbar_Merek.setVisibility(0);
        merekArray.clear();
    }

    private r()
    {
        this$0 = LanggananBeritaAll.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
