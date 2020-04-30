// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.ServiceHandler;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.details:
//            Hal2Spek, RivalTerdekatActivity

public class this._cls0 extends AsyncTask
{

    final Hal2Spek this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        avoid = (new ServiceHandler()).makeServiceCall(dataRival, 1);
        jsonRival = avoid;
        Log.e("ResponseRival: ", (new StringBuilder("> ")).append(jsonRival).toString());
        if (avoid != null)
        {
            try
            {
                avoid = new JSONObject(avoid);
                inponsel = avoid.getJSONArray("InPonsel");
                suc = avoid.getString("success");
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                avoid.printStackTrace();
            }
        }
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        super.onPostExecute(void1);
        try
        {
            if (suc.equals("1"))
            {
                layout_RivalTerdekat.setEnabled(true);
                txtBigRivalTerdekat.setTextColor(Color.parseColor("#616161"));
                layout_RivalTerdekat.setOnClickListener(new android.view.View.OnClickListener() {

                    final Hal2Spek.RivalTask this$1;

                    public void onClick(View view)
                    {
                        view = new Intent(getActivity(), com/inponsel/android/details/RivalTerdekatActivity);
                        view.putExtra("codename", codename);
                        view.putExtra("model", model);
                        view.putExtra("merk", merk);
                        view.putExtra("gambar", gambar);
                        view.putExtra("hrg_baru", hrg_baru);
                        view.putExtra("hrg_bekas", hrg_bekas);
                        view.putExtra("jsonRival", jsonRival);
                        view.putExtra("id_hp", id_hp);
                        getActivity().startActivity(view);
                        getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$1 = Hal2Spek.RivalTask.this;
                super();
            }
                });
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            return;
        }
        layout_RivalTerdekat.setEnabled(false);
        txtBigRivalTerdekat.setTextColor(Color.parseColor("#cacaca"));
        return;
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
    }


    public _cls1.this._cls1()
    {
        this$0 = Hal2Spek.this;
        super();
    }
}
