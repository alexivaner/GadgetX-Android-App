// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.ServiceHandler;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            BaseDrawer

private class <init> extends AsyncTask
{

    final BaseDrawer this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        {
            avoid = (new ServiceHandler()).makeServiceCall(dataBrand, 1);
            Log.e("Responseharga: ", (new StringBuilder("> ")).append(avoid).toString());
            if (avoid == null)
            {
                break MISSING_BLOCK_LABEL_312;
            }
            ListModel listmodel;
            int i;
            try
            {
                BaseDrawer.access$0(BaseDrawer.this, "F512991", avoid);
                avoid = new JSONObject(avoid);
                inponsel = avoid.getJSONArray("InPonsel");
                suc = avoid.getString("success");
                stat = avoid.getString("stat");
                count_first_favbrand = avoid.getInt("count_first");
                count_all_favbrand = avoid.getInt("count_all");
                Log.e("suc", suc);
                counterArray = 0;
                if (!suc.equals("1"))
                {
                    break MISSING_BLOCK_LABEL_319;
                }
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                avoid.printStackTrace();
                break MISSING_BLOCK_LABEL_319;
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                avoid.printStackTrace();
                break MISSING_BLOCK_LABEL_319;
            }
            i = 0;
        }
        if (i >= inponsel.length())
        {
            break MISSING_BLOCK_LABEL_319;
        }
        avoid = BaseDrawer.this;
        avoid.counterArray = ((BaseDrawer) (avoid)).counterArray + 1;
        avoid = inponsel.getJSONObject(i);
        listmodel = new ListModel();
        listmodel.setId_hp(avoid.getString("id_brand"));
        listmodel.setModel("");
        listmodel.setMerk(avoid.getString("merk"));
        listmodel.setCodename("");
        listmodel.setGambar(avoid.getString("logo"));
        listmodel.setUmu_status("-");
        listmodel.setHrg_baru("");
        listmodel.setHrg_bekas("");
        favBrandArray.add(listmodel);
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
        if (count_all_favbrand > 3 || count_all_favhp > 3)
        {
            txtMoreBrandFavorit.setVisibility(0);
        } else
        {
            txtMoreBrandFavorit.setVisibility(8);
        }
        Log.e("data", dataBrand);
        Log.e("favHpArray", String.valueOf(favHpArray.size()));
        favBrandAdapter.notifyDataSetChanged();
        Log.e("favBrandArray", String.valueOf(favBrandArray.size()));
        if (counterHpArray != 0 || favBrandArray.size() != 0)
        {
            break MISSING_BLOCK_LABEL_170;
        }
        menu_ListFavorit.setVisibility(8);
_L1:
        img_RefBookmark.setVisibility(0);
        progressbar_Bookmark.setVisibility(8);
        return;
        try
        {
            menu_ListFavorit.setVisibility(0);
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            return;
        }
          goto _L1
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        favBrandArray.clear();
    }

    private ter()
    {
        this$0 = BaseDrawer.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
