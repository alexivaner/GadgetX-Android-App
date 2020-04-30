// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.favorit;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.favorit:
//            FavoritArtikelForum

public class this._cls0 extends AsyncTask
{

    final FavoritArtikelForum this$0;

    private void parseJSONDel(String s)
    {
        try
        {
            s = new JSONObject(s);
            postStatusDelTL = s.getString("success");
            postMessageDelTL = s.getString("message");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
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
            avoid = (new StringBuilder("idartanya=")).append(id_tl).append("&idusr=").append(FavoritArtikelForum.user_id).append("&stat=").append("0").append("&type=").append(id_type).append("&t=").append(t).toString();
            String s = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("add_favartanya").append(Utility.BASE_FORMAT).append("?").append(avoid).toString();
            Log.e("pushURL", s);
            s = HttpPush.getResponse(s);
            Log.e("push", (new StringBuilder(String.valueOf(s))).append(avoid).toString());
            parseJSONDel(s.toString());
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
        if (postStatusDelTL.equals("1"))
        {
            db.delete_TLbyID(id_tl);
            onResume();
        }
        mDialog.dismiss();
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        mDialog = ProgressDialog.show(FavoritArtikelForum.this, "", "Menghapus...", true);
        mDialog.setCancelable(true);
        mDialog.show();
    }

    public ()
    {
        this$0 = FavoritArtikelForum.this;
        super();
    }
}
