// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.gson.Gson;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Response;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

// Referenced classes of package com.inponsel.android.details:
//            Hal2Spek

private class <init> extends AsyncTask
{

    Response response;
    final Hal2Spek this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        avoid = new HttpGet(dataRatingAVG);
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
        Log.e(getClass().getSimpleName(), (new StringBuilder("Error ")).append(i).append(" for URL ").append(dataRatingAVG).toString());
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
_L1:
        if (!void1.hasNext())
        {
            rata2Desain = nilai_desain;
            rata2Layar = nilai_layar;
            rata2Kinerja = nilai_kinerja;
            rata2Kamera = nilai_kamera;
            rata2Baterai = nilai_baterai;
            rataDesain.setText(oneDForm.format(Double.parseDouble(nilai_desain)));
            rataLayar.setText(oneDForm.format(Double.parseDouble(nilai_layar)));
            rataKinerja.setText(oneDForm.format(Double.parseDouble(nilai_kinerja)));
            rataKamera.setText(oneDForm.format(Double.parseDouble(nilai_kamera)));
            rataBaterai.setText(oneDForm.format(Double.parseDouble(nilai_baterai)));
            ratdobDesain = Double.parseDouble(rata2Desain) * 10D;
            ratintDesain = (int)ratdobDesain;
            ratdobLayar = Double.parseDouble(rata2Layar) * 10D;
            ratintLayar = (int)ratdobLayar;
            ratdobKinerja = Double.parseDouble(rata2Kinerja) * 10D;
            ratintKinerja = (int)ratdobKinerja;
            ratdobApps = Double.parseDouble(rata2Apps) * 10D;
            ratintApps = (int)ratdobApps;
            ratdobKamera = Double.parseDouble(rata2Kamera) * 10D;
            ratintKamera = (int)ratdobKamera;
            ratdobAudio = Double.parseDouble(rata2Audio) * 10D;
            ratintAudio = (int)ratdobAudio;
            ratdobBaterai = Double.parseDouble(rata2Baterai) * 10D;
            ratintBaterai = (int)ratdobBaterai;
            ratdobHarga = Double.parseDouble(rata2Harga) * 10D;
            ratintHarga = (int)ratdobHarga;
            ratingDesain.setAnimation(animationin);
            if (ratintDesain < 67)
            {
                if (ratintDesain >= 34);
            }
            ratingDesain.setProgress(ratintDesain);
            ratingLayar.setAnimation(animationin);
            if (ratintLayar < 67)
            {
                if (ratintLayar >= 34);
            }
            ratingLayar.setProgress(ratintLayar);
            ratingKinerja.setAnimation(animationin);
            if (ratintKinerja < 67)
            {
                if (ratintKinerja >= 34);
            }
            ratingKinerja.setProgress(ratintKinerja);
            ratingKamera.setAnimation(animationin);
            if (ratintKamera < 67)
            {
                if (ratintKamera >= 34);
            }
            ratingKamera.setProgress(ratintKamera);
            ratingBaterai.setAnimation(animationin);
            if (ratintBaterai < 67)
            {
                if (ratintBaterai >= 34);
            }
            ratingBaterai.setProgress(ratintBaterai);
            totalVotes.isSelected();
            if (total_votes.equals("0"))
            {
                totalVotes.setText("Total: 0 suara");
                return;
            }
            break MISSING_BLOCK_LABEL_954;
        }
        try
        {
            ListModel listmodel = (ListModel)void1.next();
            nilai_desain = listmodel.getNilai_desain();
            nilai_layar = listmodel.getNilai_layar();
            nilai_kinerja = listmodel.getNilai_kinerja();
            nilai_kamera = listmodel.getNilai_kamera();
            nilai_baterai = listmodel.getNilai_baterai();
            nilai_overall = listmodel.getNilai_overall();
            total_votes = listmodel.getTotal_votes();
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            return;
        }
          goto _L1
        totalVotes.setText((new StringBuilder("Total : ")).append(nilai_overall).append(", dari ").append(total_votes).append(" suara").toString());
        return;
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
    }

    private _cls9()
    {
        this$0 = Hal2Spek.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
