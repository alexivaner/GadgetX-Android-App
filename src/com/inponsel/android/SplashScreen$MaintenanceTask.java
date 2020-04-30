// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android;

import android.content.DialogInterface;
import android.os.AsyncTask;
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

// Referenced classes of package com.inponsel.android:
//            SplashScreen

private class <init> extends AsyncTask
{

    String maintenanceMsg;
    String maintenanceStat;
    Response response;
    final SplashScreen this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        avoid = new HttpGet(dataMaintenance);
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
        Log.e(getClass().getSimpleName(), (new StringBuilder("Error ")).append(i).append(" for URL ").append(dataMaintenance).toString());
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
        Log.e("taskLst", "dataMaintenance");
        Log.e("data", dataMaintenance);
        void1 = response.InPonsel.iterator();
        do
        {
            ListModel listmodel;
            do
            {
                if (!void1.hasNext())
                {
                    return;
                }
                listmodel = (ListModel)void1.next();
            } while (listmodel.getMaintenanceStat().equals("-") && listmodel.getMaintenanceMsg().equals("-"));
            maintenanceStat = listmodel.getMaintenanceStat();
            maintenanceMsg = listmodel.getMaintenanceMsg();
            if (maintenanceStat.equals("1"))
            {
                progressbar_middle.setVisibility(4);
                android.app.stener stener = new android.app.sbar_middle(wrapper);
                stener.("Peringatan");
                stener.e(maintenanceMsg);
                stener.veButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                    final SplashScreen.MaintenanceTask this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface.dismiss();
                        finish();
                    }

            
            {
                this$1 = SplashScreen.MaintenanceTask.this;
                super();
            }
                });
                stener.anceTask();
            } else
            {
                SplashScreen.access$1(SplashScreen.this);
            }
        } while (true);
    }


    private _cls1.this._cls1()
    {
        this$0 = SplashScreen.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
