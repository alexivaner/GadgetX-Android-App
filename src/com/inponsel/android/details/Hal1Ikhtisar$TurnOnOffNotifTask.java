// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.os.AsyncTask;
import android.widget.CheckBox;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.ServiceHandler;
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;
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
        avoid = (new ServiceHandler()).makeServiceCall(dataNotifOnOff, 1);
        Log.e("Responseharga: ", (new StringBuilder("> ")).append(avoid).toString());
        if (avoid != null)
        {
            try
            {
                avoid = new JSONObject(avoid);
                inponsel = avoid.getJSONArray("InPonsel");
                suc = avoid.getString("success");
                messageNotif = avoid.getString("message");
                kmail_stat = avoid.getString("kmail_stat");
                Log.e("suc", suc);
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                avoid.printStackTrace();
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                avoid.printStackTrace();
            }
        } else
        {
            Log.e("ServiceHandlerPen", "Couldn't get any data from the url");
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
        progbar_notifHP.setVisibility(8);
        chkNotifKomenHp.setEnabled(true);
        if (kmail_stat.equals("1"))
        {
            chkNotifKomenHp.setChecked(true);
            return;
        } else
        {
            chkNotifKomenHp.setChecked(false);
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        progbar_notifHP.setVisibility(0);
        chkNotifKomenHp.setEnabled(false);
    }

    public ()
    {
        this$0 = Hal1Ikhtisar.this;
        super();
    }
}
