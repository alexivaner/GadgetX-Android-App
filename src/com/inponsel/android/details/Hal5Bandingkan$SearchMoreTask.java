// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.widget.Button;
import android.widget.LinearLayout;
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

// Referenced classes of package com.inponsel.android.details:
//            Hal5Bandingkan

private class <init> extends AsyncTask
{

    Response response;
    final Hal5Bandingkan this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        avoid = new HttpGet(dataSearchMore);
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
        Log.e(getClass().getSimpleName(), (new StringBuilder("Error ")).append(i).append(" for URL ").append(dataSearchMore).toString());
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
        Log.e("tasksdsurlSearch", dataSearch);
        counterArray = 0;
        void1 = response.InPonsel.iterator();
_L3:
        if (void1.hasNext()) goto _L2; else goto _L1
_L1:
        pencarianAdapter.notifyDataSetChanged();
        Log.e("counterArray", String.valueOf(pencarianArray.size()));
        if (pencarianArray.size() >= 20)
        {
            break MISSING_BLOCK_LABEL_248;
        }
        grup_header_footer.setVisibility(8);
_L4:
        getActivity().setProgressBarIndeterminateVisibility(false);
        getActivity().setProgressBarVisibility(false);
        return;
_L2:
        ListModel listmodel;
label0:
        {
            listmodel = (ListModel)void1.next();
            Hal5Bandingkan hal5bandingkan = Hal5Bandingkan.this;
            hal5bandingkan.counterArray = hal5bandingkan.counterArray + 1;
            if (!listmodel.getId_hp().equals("-") || !listmodel.getModel().equals("-"))
            {
                break label0;
            }
            grup_header_footer.setVisibility(8);
            listPencarianHp.setVisibility(8);
            layout_empty.setVisibility(0);
        }
          goto _L3
        try
        {
            pencarianArray.add(listmodel);
            listPencarianHp.setVisibility(0);
            layout_empty.setVisibility(8);
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            return;
        }
          goto _L3
        btnMemuatLagi.setVisibility(0);
        grup_header_footer.setVisibility(0);
          goto _L4
    }

    private apter()
    {
        this$0 = Hal5Bandingkan.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
