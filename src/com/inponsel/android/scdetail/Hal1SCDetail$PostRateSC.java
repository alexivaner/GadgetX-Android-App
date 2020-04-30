// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.scdetail;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.widget.Toast;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.scdetail:
//            Hal1SCDetail

public class this._cls0 extends AsyncTask
{

    final Hal1SCDetail this$0;

    private void parseJSONSC(String s)
    {
        JSONObject jsonobject;
        int i;
        try
        {
            s = (new JSONObject(s)).getJSONArray("InPonsel");
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
        jsonobject = s.getJSONObject(i);
        postStatus = jsonobject.getString("success");
        postMessage = jsonobject.getString("message");
        i++;
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_16;
        }
    }

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        try
        {
            if (android.os.CDetail.PostRateSC >= 11)
            {
                avoid = StrictMode.getThreadPolicy();
                StrictMode.setThreadPolicy((new android.os.Builder(avoid)).permitDiskWrites().build());
                StrictMode.setThreadPolicy(avoid);
            }
            avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("sc_rate").append(Utility.BASE_FORMAT).append("?").append(querypopratesc).toString();
            Log.e("pushURL", avoid);
            avoid = HttpPush.getResponse(avoid);
            res = avoid.toString();
            parseJSONSC(res);
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            avoid.printStackTrace();
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
            mDialog.dismiss();
            if (postStatus.equals("1"))
            {
                Toast.makeText(getActivity(), postMessage, 1).show();
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            return;
        }
        void1 = new android.app.t>(getActivity());
        void1.essage(postMessage);
        void1.ositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

            final Hal1SCDetail.PostRateSC this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$1 = Hal1SCDetail.PostRateSC.this;
                super();
            }
        });
        void1.();
        return;
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        mDialog = ProgressDialog.show(getActivity(), "", "Posting...", true);
        mDialog.setCancelable(true);
        mDialog.show();
    }

    public _cls1.this._cls1()
    {
        this$0 = Hal1SCDetail.this;
        super();
    }
}
