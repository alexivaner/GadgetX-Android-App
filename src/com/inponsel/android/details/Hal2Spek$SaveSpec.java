// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.media.MediaScannerConnection;
import android.os.AsyncTask;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;

// Referenced classes of package com.inponsel.android.details:
//            Hal2Spek

public class this._cls0 extends AsyncTask
{

    final Hal2Spek this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        Hal2Spek.access$3(Hal2Spek.this, Hal2Spek.access$2(Hal2Spek.this));
        Hal2Spek.access$3(Hal2Spek.this, Hal2Spek.access$4(Hal2Spek.this));
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        super.onPostExecute(void1);
        btnSaveSpekImage.setEnabled(true);
        btnSaveSpekImage.setText("Download Halaman Spesifikasi");
        txt_namalengkap.setVisibility(8);
        imgWatermark.setVisibility(8);
        Toast.makeText(getActivity(), "Berhasil tersimpan di folder InPonsel", 1).show();
        MediaScannerConnection.scanFile(getActivity(), new String[] {
            Hal2Spek.access$5(Hal2Spek.this).getPath()
        }, new String[] {
            "image/jpeg"
        }, null);
        txt_loadingSaveSpec.setVisibility(8);
        ll_spacekosong.setVisibility(8);
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        txt_namalengkap.setVisibility(0);
        imgWatermark.setVisibility(0);
        btnSaveSpekImage.setEnabled(false);
        btnSaveSpekImage.setText("Menyimpan...");
        txt_loadingSaveSpec.setVisibility(0);
    }

    public ()
    {
        this$0 = Hal2Spek.this;
        super();
    }
}
