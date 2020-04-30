// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.actionbarsherlock.ActionBarSherlock;
import com.inponsel.android.details.DetailsPonsel;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.ServiceHandler;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            SCUserActivity

private class <init> extends AsyncTask
{

    final SCUserActivity this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        {
            avoid = (new ServiceHandler()).makeServiceCall(dataHpUser, 1);
            if (avoid == null)
            {
                break MISSING_BLOCK_LABEL_364;
            }
            int i;
            try
            {
                avoid = new JSONObject(avoid);
                suc = avoid.getString("success");
                Log.e("suc", suc);
                inponsel = avoid.getJSONArray("InPonsel");
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                avoid.printStackTrace();
                break MISSING_BLOCK_LABEL_371;
            }
            i = 0;
        }
        if (i >= inponsel.length())
        {
            break MISSING_BLOCK_LABEL_371;
        }
        avoid = inponsel.getJSONObject(i);
        id_hph = avoid.getString("id_hp");
        id_merk = avoid.getString("id_merk");
        model = avoid.getString("model");
        merk = avoid.getString("merk");
        codename = avoid.getString("codename");
        gambar = avoid.getString("gambar");
        umu_status = avoid.getString("umu_status");
        hrg_baru = avoid.getString("hrg_baru");
        hrg_bekas = avoid.getString("hrg_bekas");
        if (!avoid.getString("id_hp2").equals("0"))
        {
            id_hph2 = avoid.getString("id_hp2");
            id_merk2 = avoid.getString("id_merk2");
            model2 = avoid.getString("model2");
            merk2 = avoid.getString("merk2");
            codename2 = avoid.getString("codename2");
            gambar2 = avoid.getString("gambar2");
            umu_status2 = avoid.getString("umu_status2");
            hrg_baru2 = avoid.getString("hrg_baru2");
            hrg_bekas2 = avoid.getString("hrg_bekas2");
        }
        i++;
        if (true)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        Log.e("ServiceHandler", "Couldn't get any data from the url");
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        super.onPostExecute(void1);
        Log.e("tasksdsurlSearch", dataHpUser);
        layout_sc_Merek1.setVisibility(0);
        progressbar_hp_user.setVisibility(8);
        list_txtMerek.setText((new StringBuilder(String.valueOf(merk))).append(" ").append(model).toString());
        if (!hrg_baru.equals("") && !hrg_baru.equals("0") && !hrg_baru.equals("-")) goto _L2; else goto _L1
_L1:
        list_txtHarga.setVisibility(8);
_L5:
        imageLoader2.displayImage(gambar.trim(), imgHp, SCUserActivity.access$1(SCUserActivity.this), new ImageLoadingListener() {

            final SCUserActivity.HpUserTask this$1;

            public void onLoadingCancelled(String s, View view)
            {
            }

            public void onLoadingComplete(String s, View view, Bitmap bitmap)
            {
                progressbar_item.setVisibility(8);
                imgHp.setVisibility(0);
            }

            public void onLoadingFailed(String s, View view, FailReason failreason)
            {
                progressbar_item.setVisibility(8);
                imgHp.setVisibility(0);
            }

            public void onLoadingStarted(String s, View view)
            {
                progressbar_item.setVisibility(0);
                imgHp.setVisibility(8);
            }

            
            {
                this$1 = SCUserActivity.HpUserTask.this;
                super();
            }
        });
        txtBigsc_Merek1.setText((new StringBuilder("Tampilkan semua service center ")).append(merk).toString());
        mainLayout.setOnClickListener(new android.view.View.OnClickListener() {

            final SCUserActivity.HpUserTask this$1;

            public void onClick(View view)
            {
                view = new Intent(getApplicationContext(), com/inponsel/android/details/DetailsPonsel);
                view.putExtra("id_hph", id_hph);
                view.putExtra("namalengkap", (new StringBuilder(String.valueOf(merk))).append(" ").append(model).toString());
                view.putExtra("codename", codename);
                view.putExtra("model", model);
                view.putExtra("merk", merk);
                view.putExtra("gambar", gambar);
                view.putExtra("hrg_baru", hrg_baru);
                view.putExtra("hrg_bekas", hrg_bekas);
                view.putExtra("tot_like", "");
                view.putExtra("tot_dislike", "");
                view.putExtra("tot_komen", "");
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$1 = SCUserActivity.HpUserTask.this;
                super();
            }
        });
        mainLayout.setVisibility(0);
        if (!id_hph2.equals("0")) goto _L4; else goto _L3
_L3:
        sc_separator.setVisibility(8);
        mainLayout2.setVisibility(8);
        layout_sc_Merek2.setVisibility(8);
_L6:
        SCUserActivity.access$0(SCUserActivity.this).setProgressBarIndeterminateVisibility(false);
        return;
_L2:
        try
        {
            list_txtHarga.setText(hrg_baru);
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            void1.printStackTrace();
            return;
        }
          goto _L5
_L4:
        sc_separator.setVisibility(0);
        list_txtMerek2.setText((new StringBuilder(String.valueOf(merk2))).append(" ").append(model2).toString());
        if (!hrg_baru2.equals("") && !hrg_baru2.equals("0") && !hrg_baru2.equals("-"))
        {
            break MISSING_BLOCK_LABEL_566;
        }
        list_txtHarga2.setVisibility(8);
_L7:
        imageLoader2.displayImage(gambar2.trim(), imgHp2, SCUserActivity.access$1(SCUserActivity.this), new ImageLoadingListener() {

            final SCUserActivity.HpUserTask this$1;

            public void onLoadingCancelled(String s, View view)
            {
            }

            public void onLoadingComplete(String s, View view, Bitmap bitmap)
            {
                progressbar_item2.setVisibility(8);
                imgHp2.setVisibility(0);
            }

            public void onLoadingFailed(String s, View view, FailReason failreason)
            {
                progressbar_item2.setVisibility(8);
                imgHp2.setVisibility(0);
            }

            public void onLoadingStarted(String s, View view)
            {
                progressbar_item2.setVisibility(0);
                imgHp2.setVisibility(8);
            }

            
            {
                this$1 = SCUserActivity.HpUserTask.this;
                super();
            }
        });
        txtBigsc_Merek2.setText((new StringBuilder("Tampilkan semua service center ")).append(merk2).toString());
        mainLayout2.setOnClickListener(new android.view.View.OnClickListener() {

            final SCUserActivity.HpUserTask this$1;

            public void onClick(View view)
            {
                view = new Intent(getApplicationContext(), com/inponsel/android/details/DetailsPonsel);
                view.putExtra("id_hph", id_hph2);
                view.putExtra("namalengkap", (new StringBuilder(String.valueOf(merk2))).append(" ").append(model2).toString());
                view.putExtra("codename", codename2);
                view.putExtra("model", model2);
                view.putExtra("merk", merk2);
                view.putExtra("gambar", gambar2);
                view.putExtra("hrg_baru", hrg_baru2);
                view.putExtra("hrg_bekas", hrg_bekas);
                view.putExtra("tot_like", "");
                view.putExtra("tot_dislike", "");
                view.putExtra("tot_komen", "");
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$1 = SCUserActivity.HpUserTask.this;
                super();
            }
        });
        layout_sc_Merek2.setVisibility(0);
        mainLayout2.setVisibility(0);
          goto _L6
        list_txtHarga2.setText(hrg_baru2);
          goto _L7
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        progressbar_hp_user.setVisibility(0);
        mainLayout.setVisibility(8);
    }


    private _cls4.this._cls1()
    {
        this$0 = SCUserActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
