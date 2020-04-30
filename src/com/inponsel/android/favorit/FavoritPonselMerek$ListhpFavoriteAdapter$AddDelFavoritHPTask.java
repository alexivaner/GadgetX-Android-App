// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.favorit;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.Toast;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;

// Referenced classes of package com.inponsel.android.favorit:
//            FavoritPonselMerek

public class this._cls1 extends AsyncTask
{

    final this._cls1 this$1;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        try
        {
            doInBackground(this._cls1.this).querydel = (new StringBuilder("idhp=")).append(this._mth1(this._cls1.this).id_hp_del).append("&idusr=").append(this._mth1(this._cls1.this).user_id).append("&stat=").append(this._mth1(this._cls1.this).statusdel).append("&t=").append(_fld1).toString();
            this._mth1(this._cls1.this).pushURLdel = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("add_favhp").append(Utility.BASE_FORMAT).append("?").append(this._mth1(this._cls1.this).querydel).toString();
            Log.e("pushURL", this._mth1(this._cls1.this).pushURLdel);
            avoid = HttpPush.getResponse(this._mth1(this._cls1.this).pushURLdel);
            Log.e("push", (new StringBuilder(String.valueOf(avoid))).append(this._mth1(this._cls1.this).querydel).toString());
            this._mth1(this._cls1.this).resdel = avoid.toString();
            Log.e("url ", this._mth1(this._cls1.this).resdel);
            this._mth1(this._cls1.this).resdel = this._mth1(this._cls1.this).resdel.trim();
            this._mth1(this._cls1.this).resdel = this._mth1(this._cls1.this).resdel.replaceAll("\\s+", "");
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
        if (!onPostExecute(this._cls1.this).resdel.equals("1") && !this._mth1(this._cls1.this).resdel.equals("10"))
        {
            break MISSING_BLOCK_LABEL_196;
        }
        _fld1.addHP(this._mth1(this._cls1.this).id_hp_del, this._mth1(this._cls1.this).merk, this._mth1(this._cls1.this).model, this._mth1(this._cls1.this).gambar, this._mth1(this._cls1.this).codename);
        if (_fld1.getHPCount() <= 0)
        {
            break MISSING_BLOCK_LABEL_177;
        }
        Toast.makeText(this._mth1(this._cls1.this), "Berhasil menambahkan", 1).show();
_L1:
        _fld1.dismiss();
        this._mth1(this._cls1.this).ponselBaseApp.getObserver().setUpdateType("sidemenufav");
        this._mth1(this._cls1.this).ponselBaseApp.getObserver().setLoginStat("1");
        return;
        try
        {
            Toast.makeText(this._mth1(this._cls1.this), "Gagal menambahkan", 1).show();
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            return;
        }
          goto _L1
        if (!this._mth1(this._cls1.this).resdel.equals("00") && !this._mth1(this._cls1.this).resdel.equals("0"))
        {
            break MISSING_BLOCK_LABEL_344;
        }
        _fld1.deleteHP(this._mth1(this._cls1.this).id_hp_del);
        this._mth1(this._cls1.this).loadDataHP();
        this._mth1(this._cls1.this).hpFavoriteAdapter.();
        if (.checkIfExist((this._cls1.this).id_hp_del))
        {
            break MISSING_BLOCK_LABEL_325;
        }
        Toast.makeText(this._mth1(this._cls1.this), "Berhasil menghapus", 1).show();
_L3:
        _fld1.dismiss();
        return;
        Toast.makeText(this._mth1(this._cls1.this), "Berhasil menghapus", 1).show();
        if (true) goto _L3; else goto _L2
_L2:
        if (this._mth1(this._cls1.this).resdel.equals("40404"))
        {
            _fld1.dismiss();
            return;
        }
        Toast.makeText(this._mth1(this._cls1.this), "Gagal menambahkan", 1).show();
        return;
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        this._mth1(this._cls1.this).statusdel = "";
        if (this._mth1(this._cls1.this).statdel.equals("1"))
        {
            _fld1 = ProgressDialog.show(this._mth1(this._cls1.this), "", "Menambahkan...", true);
        } else
        {
            _fld1 = ProgressDialog.show(this._mth1(this._cls1.this), "", "Menghapus...", true);
        }
        _fld1.setCancelable(true);
        _fld1.show();
    }

    public ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
