// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.statistik;

import android.os.AsyncTask;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.google.gson.Gson;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Response;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

// Referenced classes of package com.inponsel.android.statistik:
//            Hal4Tahun

private class <init> extends AsyncTask
{

    Response response;
    final Hal4Tahun this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        avoid = new HttpGet(dataStatistik);
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
        Log.e(getClass().getSimpleName(), (new StringBuilder("Error ")).append(i).append(" for URL ").append(dataStatistik).toString());
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
        progressbar_middle.setVisibility(8);
        layout_empty.setVisibility(8);
        statistikArray.clear();
        no = 0;
        void1 = response.InPonsel.iterator();
_L1:
        if (!void1.hasNext())
        {
            lainAdapter.notifyDataSetChanged();
            return;
        }
        try
        {
            ListModel listmodel = (ListModel)void1.next();
            Hal4Tahun hal4tahun = Hal4Tahun.this;
            hal4tahun.no = hal4tahun.no + 1;
            listmodel.setNourut(String.valueOf(no));
            statistikArray.add(listmodel);
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            return;
        }
          goto _L1
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
    }

    private ()
    {
        this$0 = Hal4Tahun.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
