// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.favorit;

import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.widget.LinearLayout;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.favorit:
//            FavoritArtikelForum

private class <init> extends AsyncTask
{

    final FavoritArtikelForum this$0;

    private void parseJSONLangganan(String s)
    {
        int i;
        try
        {
            s = new JSONObject(s);
            jArray = s.getJSONArray("InPonsel");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return;
        }
        i = 0;
        if (i >= jArray.length())
        {
            return;
        }
        s = jArray.getJSONObject(i);
        if (!db.checkTimelineExist(s.getString("id")))
        {
            db.addArtTanya(s.getString("id"), s.getString("id_hp"), s.getString("merk"), s.getString("model"), s.getString("codename"), s.getString("judul"), s.getString("type"), s.getString("tag"), s.getString("img_url"), s.getString("content"), s.getString("content_ext"), s.getString("date"));
        }
        i++;
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_24;
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
            avoid = HttpPush.getResponse(dataFav);
            Log.e("push", (new StringBuilder(String.valueOf(avoid))).append(dataFav).toString());
            avoid = avoid.toString();
            Log.e("url ", avoid);
            parseJSONLangganan(avoid);
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
        layout_empty.setVisibility(8);
        FavoritArtikelForum.access$0(FavoritArtikelForum.this);
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        layout_empty.setVisibility(0);
        if (netInfo != null && netInfo.isConnected())
        {
            db.resetTLTables();
        }
    }

    private ()
    {
        this$0 = FavoritArtikelForum.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
