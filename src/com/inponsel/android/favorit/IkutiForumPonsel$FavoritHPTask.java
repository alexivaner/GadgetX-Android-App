// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.favorit;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.ServiceHandler;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.favorit:
//            IkutiForumPonsel

private class <init> extends AsyncTask
{

    final IkutiForumPonsel this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        {
            avoid = (new ServiceHandler()).makeServiceCall(dataForumPonsel, 1);
            Log.e("Responseharga: ", (new StringBuilder("> ")).append(avoid).toString());
            if (avoid == null)
            {
                break MISSING_BLOCK_LABEL_320;
            }
            ListModel listmodel;
            int i;
            try
            {
                avoid = new JSONObject(avoid);
                inponsel = avoid.getJSONArray("InPonsel");
                suc = avoid.getString("success");
                stat = avoid.getString("stat");
                count_first_HPForum = avoid.getInt("count_first");
                count_all_HPForum = avoid.getInt("count_all");
                Log.e("suc", suc);
                counterArray = 0;
                if (!suc.equals("1"))
                {
                    break MISSING_BLOCK_LABEL_327;
                }
                ForumHpArray.clear();
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                avoid.printStackTrace();
                break MISSING_BLOCK_LABEL_327;
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                avoid.printStackTrace();
                break MISSING_BLOCK_LABEL_327;
            }
            i = 0;
        }
        if (i >= inponsel.length())
        {
            break MISSING_BLOCK_LABEL_327;
        }
        avoid = IkutiForumPonsel.this;
        avoid.counterArray = ((IkutiForumPonsel) (avoid)).counterArray + 1;
        avoid = inponsel.getJSONObject(i);
        listmodel = new ListModel();
        listmodel.setId_hp(avoid.getString("id_hp"));
        listmodel.setModel(avoid.getString("model"));
        listmodel.setMerk(avoid.getString("merk"));
        listmodel.setCodename(avoid.getString("codename"));
        listmodel.setGambar(avoid.getString("gambar"));
        listmodel.setUmu_status("");
        listmodel.setHrg_baru("");
        listmodel.setHrg_bekas("");
        ForumHpArray.add(listmodel);
        i++;
        if (true)
        {
            break MISSING_BLOCK_LABEL_165;
        }
        Log.e("ServiceHandlerPen", "Couldn't get any data from the url");
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
            Log.e("ForumHpArray", String.valueOf(ForumHpArray.size()));
            Log.e("dataForumPonsel", dataForumPonsel);
            Log.e("ForumHpArray", String.valueOf(ForumHpArray.size()));
            ForumHpAdapter.notifyDataSetChanged();
            Log.e("counterArray", String.valueOf(ForumHpArray.size()));
        }
        // Misplaced declaration of an exception variable
        catch (Void void1) { }
        progressbar_middle.setVisibility(8);
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        progressbar_middle.setVisibility(0);
    }

    private pter()
    {
        this$0 = IkutiForumPonsel.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
