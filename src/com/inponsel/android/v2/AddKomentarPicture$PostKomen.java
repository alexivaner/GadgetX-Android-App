// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            AddKomentarPicture

public class this._cls0 extends AsyncTask
{

    String res;
    final AddKomentarPicture this$0;

    private void parseJSONKom(String s)
    {
        try
        {
            s = new JSONObject(s);
            postStatus = s.getString("success");
            postMessage = s.getString("message");
            jum_komen = s.getString("jum_komen");
            tot_LikePon = s.getString("total_like");
            totdis_LikePon = s.getString("total_dislike");
            ponselBaseApp.getObserver().setJum_komenLikePon(jum_komen);
            ponselBaseApp.getObserver().setTot_LikePon(tot_LikePon);
            ponselBaseApp.getObserver().setTotdis_LikePon(totdis_LikePon);
            ponselBaseApp.getObserver().setIndexHp(codename);
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
        if (android.os.re.PostKomen >= 11)
        {
            avoid = StrictMode.getThreadPolicy();
            StrictMode.setThreadPolicy((new android.os.er(avoid)).permitDiskWrites().build());
            StrictMode.setThreadPolicy(avoid);
        }
        avoid = "";
        if (!komen_type.equals("ponsel")) goto _L2; else goto _L1
_L1:
        avoid = url_PostKomen;
        urlEmailNotif = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("mail_forum").append(Utility.BASE_FORMAT).append("?").append("rplto=0").append("&idhp=").append(id_hp).append("&code=").append(codename).append("&email=").append(URLEncoder.encode(email_user, "utf-8")).append("&nama=").append(URLEncoder.encode(username, "utf-8")).append("&komentar=").append(URLEncoder.encode(edtKomentar.getText().toString(), "utf-8")).append("&nmhp=").append(URLEncoder.encode(namalengkap, "utf-8")).append("&top_id=").append(top_id).append("&t=").append(t).append("&idusr=").append(user_id).append("&img=").append(resp).toString();
        Log.e("pushURL", avoid);
        avoid = HttpPush.getResponse(avoid);
_L3:
        res = avoid.toString();
        parseJSONKom(res);
        break MISSING_BLOCK_LABEL_1724;
_L2:
label0:
        {
            if (!komen_type.equals("berita"))
            {
                break label0;
            }
            avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("plus_kom_rss").append(Utility.BASE_FORMAT).append("?").append("rplto=0").append("&komen=").append(URLEncoder.encode(edtKomentar.getText().toString())).append("&id_rss=").append(id_rss).append("&top_id=").append("0").append("&t=").append(t).append("&id_usr=").append(user_id).append("&img=").append(resp).toString();
            urlEmailNotif = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("mail_comment_rss").append(Utility.BASE_FORMAT).append("?").append("rplto=0").append("&komen=").append(URLEncoder.encode(edtKomentar.getText().toString())).append("&id_rss=").append(id_rss).append("&top_id=").append("0").append("&t=").append(t).append("&id_usr=").append(user_id).append("&img=").append(resp).toString();
            Log.e("pushURL", avoid);
            avoid = HttpPush.getResponse(avoid);
        }
          goto _L3
label1:
        {
            if (!komen_type.equals("forum"))
            {
                break label1;
            }
            Log.e("resp", resp);
            avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("post_kom_forum").append(Utility.BASE_FORMAT).append("?").append("rplto=0").append("&komen=").append(URLEncoder.encode(edtKomentar.getText().toString())).append("&tl_id=").append(tl_id).append("&type=").append(tl_type).append("&top_id=").append(top_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&img=").append(resp).toString();
            urlEmailNotif = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("mail_comment_tl").append(Utility.BASE_FORMAT).append("?").append("rplto=0").append("&komen=").append(URLEncoder.encode(edtKomentar.getText().toString())).append("&tl_id=").append(tl_id).append("&type=").append(tl_type).append("&top_id=").append(top_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&img=").append(resp).toString();
            Log.e("pushURL", avoid);
            avoid = HttpPush.getResponse(avoid);
        }
          goto _L3
label2:
        {
            if (!komen_type.equals("servicecenter"))
            {
                break label2;
            }
            avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("post_komen_sc").append(Utility.BASE_FORMAT).append("?").append("idsc=").append(id_sc).append("&idusr=").append(user_id).append("&kom=").append(URLEncoder.encode(edtKomentar.getText().toString())).append("&rplto=").append("0").append("&top_id=").append(top_id).append("&t=").append(t).append("&img=").append(resp).toString();
            Log.e("pushsc_krisan", avoid);
            avoid = HttpPush.getResponse(avoid);
        }
          goto _L3
        if (!komen_type.contains("appskategori")) goto _L5; else goto _L4
_L4:
        avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("post_komen_katapps").append(Utility.BASE_FORMAT).append("?").append("idkat=").append(id_sc).append("&idusr=").append(user_id).append("&kom=").append(URLEncoder.encode(edtKomentar.getText().toString())).append("&rplto=").append("0").append("&top_id=").append(top_id).append("&t=").append(t).append("&img=").append(resp).toString();
        Log.e("pushsc_krisan", avoid);
        avoid = HttpPush.getResponse(avoid);
          goto _L3
_L5:
        if (!komen_type.equals("conversation")) goto _L3; else goto _L6
_L6:
        Log.e("resp", resp);
        avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("post_kom_forum").append(Utility.BASE_FORMAT).append("?").append("rplto=0").append("&komen=").append(URLEncoder.encode(edtKomentar.getText().toString())).append("&tl_id=").append(tl_id).append("&type=").append(tl_type).append("&top_id=").append(top_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&img=").append(resp).toString();
        urlEmailNotif = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("mail_comment_tl").append(Utility.BASE_FORMAT).append("?").append("rplto=0").append("&komen=").append(URLEncoder.encode(edtKomentar.getText().toString())).append("&tl_id=").append(tl_id).append("&type=").append(tl_type).append("&top_id=").append(top_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&img=").append(resp).toString();
        Log.e("pushURL", avoid);
        avoid = HttpPush.getResponse(avoid);
          goto _L3
        avoid;
        avoid.printStackTrace();
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        super.onPostExecute(void1);
        Log.e("postStatus", postStatus);
        if (!postStatus.equals("1")) goto _L2; else goto _L1
_L1:
        notifBerhasil();
        edtKomentar.setText("");
        if (!komen_type.equals("forum")) goto _L4; else goto _L3
_L3:
        ponselBaseApp.getObserver().setUpdateType("komentartl");
_L7:
        ponselBaseApp.getObserver().setStatus_like_ponsel("-");
        if (android.os.er.setStatus_like_ponsel < 11) goto _L6; else goto _L5
_L5:
        (new sk(AddKomentarPicture.this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
_L8:
        Log.e("jsonKom", "res");
        setResult(-1, (new Intent()).putExtra("jsonKom", res));
        finish();
        return;
_L4:
label0:
        {
            if (!komen_type.equals("servicecenter"))
            {
                break label0;
            }
            ponselBaseApp.getObserver().setUpdateType("komentarsc");
        }
          goto _L7
label1:
        {
            if (!komen_type.contains("appskategori"))
            {
                break label1;
            }
            ponselBaseApp.getObserver().setUpdateType("appskategorikom");
        }
          goto _L7
label2:
        {
            if (!komen_type.equals("berita"))
            {
                break label2;
            }
            ponselBaseApp.getObserver().setUpdateType("komentarrss");
        }
          goto _L7
label3:
        {
            if (!komen_type.equals("conversation"))
            {
                break label3;
            }
            ponselBaseApp.getObserver().setUpdateType("komentarconv");
        }
          goto _L7
        try
        {
            ponselBaseApp.getObserver().setUpdateType("komentar");
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            return;
        }
          goto _L7
_L6:
        (new sk(AddKomentarPicture.this)).execute(new Void[0]);
          goto _L8
_L2:
        btnPostAskHp.setEnabled(true);
        edtKomentar.setEnabled(true);
        progbar_send.setVisibility(8);
        if (postStatus.equals("040"))
        {
            void1 = new android.app.e.postStatus(ctw);
            void1.e(postMessage);
            void1.veButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                final AddKomentarPicture.PostKomen this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$1 = AddKomentarPicture.PostKomen.this;
                super();
            }
            });
            void1.PostKomen();
            notifGagal();
            return;
        }
        notifGagal();
        return;
          goto _L7
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        Log.e("url_PostKomen", url_PostKomen);
        btnPostAskHp.setEnabled(false);
        edtKomentar.setEnabled(false);
    }

    public _cls1.this._cls1()
    {
        this$0 = AddKomentarPicture.this;
        super();
    }
}
