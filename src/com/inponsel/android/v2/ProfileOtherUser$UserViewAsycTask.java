// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.os.AsyncTask;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            ProfileOtherUser

public class this._cls0 extends AsyncTask
{

    final ProfileOtherUser this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    protected transient Void doInBackground(String as[])
    {
        Log.e("UserViewAsycTask", "doInBackground");
        as = (new JSONObject(getJSONUrl(urlUserView))).getJSONArray("InPonsel");
        int i = 0;
_L1:
        if (i >= as.length())
        {
            break MISSING_BLOCK_LABEL_403;
        }
        JSONObject jsonobject = as.getJSONObject(i);
        str_id_user = jsonobject.getString("id");
        str_nmlengkap = jsonobject.getString("name");
        str_username = jsonobject.getString("uname");
        str_jekel = jsonobject.getString("ugen");
        str_kab = jsonobject.getString("uprov");
        str_kota = jsonobject.getString("ucity");
        strTotalLikes = jsonobject.getString("total_like");
        strTotalDisLikes = jsonobject.getString("total_dislike");
        strTotalPost = jsonobject.getString("totpost");
        strIDHP1 = jsonobject.getString("id_hp1");
        strIDHP2 = jsonobject.getString("id_hp2");
        strCodename1 = jsonobject.getString("codename1");
        strCodename2 = jsonobject.getString("codename2");
        strMerek1 = jsonobject.getString("uphone1");
        strMerek2 = jsonobject.getString("uphone2");
        strHarga1 = jsonobject.getString("uprice1");
        strHarga2 = jsonobject.getString("uprice2");
        stroperator1 = jsonobject.getString("uope1");
        stroperator2 = jsonobject.getString("uope2");
        stroperatorgbr1 = jsonobject.getString("uopegbr1");
        stroperatorgbr2 = jsonobject.getString("uopegbr2");
        str_srcimguser = jsonobject.getString("avatar");
        str_srcimghp1 = jsonobject.getString("upichp1");
        str_srcimghp2 = jsonobject.getString("upichp2");
        strJoinDate = jsonobject.getString("ujdate");
        strMeStat = jsonobject.getString("me");
        i++;
          goto _L1
        as;
        as.printStackTrace();
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        layout_empty.setVisibility(8);
        if (strMeStat.equals("yes"))
        {
            txt_pmesssage.setText("Pesan Masuk");
        } else
        {
            txt_pmesssage.setText("Kirim Pesan");
        }
        if (strIDHP1.equals(""))
        {
            break MISSING_BLOCK_LABEL_317;
        }
        ProfileOtherUser.access$0(ProfileOtherUser.this);
        if (!db.checkIfExistUserView(str_username))
        {
            break MISSING_BLOCK_LABEL_334;
        }
        db.updateUserView(str_id_user, str_nmlengkap, str_srcimguser, str_username, str_kab, str_kota, str_jekel, strIDHP1, strIDHP2, strMerek1, strMerek2, strHarga1, strHarga2, str_srcimghp1, str_srcimghp2, (new StringBuilder(String.valueOf(stroperator1))).append("#").append(stroperatorgbr1).toString(), (new StringBuilder(String.valueOf(stroperator2))).append("#").append(stroperatorgbr2).toString(), strTotalPost, strTotalLikes, strTotalDisLikes, strMeStat, strJoinDate, strCodename1, strCodename2);
        return;
        try
        {
            db.addUserView(str_id_user, str_nmlengkap, str_srcimguser, str_username, str_kab, str_kota, str_jekel, strIDHP1, strIDHP2, strMerek1, strMerek2, strHarga1, strHarga2, str_srcimghp1, str_srcimghp2, (new StringBuilder(String.valueOf(stroperator1))).append("#").append(stroperatorgbr1).toString(), (new StringBuilder(String.valueOf(stroperator2))).append("#").append(stroperatorgbr2).toString(), strTotalPost, strTotalLikes, strTotalDisLikes, strMeStat, strJoinDate, strCodename1, strCodename2);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            void1.printStackTrace();
        }
        return;
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        Log.e("UserViewAsycTask", "onPreExecute");
    }

    public ()
    {
        this$0 = ProfileOtherUser.this;
        super();
    }
}
