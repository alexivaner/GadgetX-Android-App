// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.graphics.Color;
import android.os.AsyncTask;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.ServiceHandler;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.details:
//            Hal1Ikhtisar

public class this._cls0 extends AsyncTask
{

    final Hal1Ikhtisar this$0;

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

    public _cls9()
    {
        this$0 = Hal1Ikhtisar.this;
        super();
    }
}
