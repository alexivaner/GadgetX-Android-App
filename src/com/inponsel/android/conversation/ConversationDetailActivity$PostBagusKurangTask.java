// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.conversation;

import android.os.AsyncTask;
import android.os.StrictMode;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.NotificationLikeRSSHelper;
import com.inponsel.android.utils.Util;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.conversation:
//            ConversationDetailActivity

public class this._cls0 extends AsyncTask
{

    final ConversationDetailActivity this$0;

    private void parseJSONLikeKom(String s)
    {
        int i;
        try
        {
            s = new JSONObject(s);
            postStatusLikeKom = s.getString("success");
            postMessageLikeKom = s.getString("message");
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
        jum_komen = s.getString("total_komen");
        tot_LikeTL = s.getString("total_like");
        totdis_LikeKom = s.getString("total_dislike");
        Log.e("tot_LikePon", tot_LikeTL);
        Log.e("totdis_LikePon", totdis_LikeKom);
        ponselBaseApp.getObserver().setJum_komenLikeTL(jum_komen);
        ponselBaseApp.getObserver().setTot_LikeTL(tot_LikeTL);
        ponselBaseApp.getObserver().setIndexTL(id_artikel);
        i++;
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_50;
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
            if (android.os.ty.PostBagusKurangTask >= 11)
            {
                avoid = StrictMode.getThreadPolicy();
                StrictMode.setThreadPolicy((new android.os.ty.PostBagusKurangTask(avoid)).s().s());
                StrictMode.setThreadPolicy(avoid);
            }
            avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("likedis_artanya.php?").append(querylike).toString();
            Log.e("pushURL", avoid);
            avoid = HttpPush.getResponse(avoid);
            reslike = avoid.toString();
            parseJSONLikeKom(reslike);
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
        Log.e("postStatusLikeKom", postStatusLikeKom);
        if (!postStatusLikeKom.equals("1")) goto _L2; else goto _L1
_L1:
        ponselBaseApp.getObserver().setUpdateType("liketl");
        ponselBaseApp.getObserver().setStatus_like_ponsel("-");
        if (!tl_type.equals("faqhp")) goto _L4; else goto _L3
_L3:
        if (!statuslike.equals("1")) goto _L6; else goto _L5
_L5:
        notificationLikeHelper.completed("Tanya Ponsel", notificationLikeHelper.likefrontKomen);
_L11:
        Log.e("index_komposlike", id_artikel);
        Log.e("statuslikeTask", statuslike);
        if (!statuslike.equals("1")) goto _L8; else goto _L7
_L7:
        list_img_like.setBackgroundResource(0x7f02020d);
        list_lay_like.setEnabled(false);
_L13:
        if (android.os.ty.list_lay_like < 11) goto _L10; else goto _L9
_L9:
        (new ask(ConversationDetailActivity.this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
_L14:
        txtLikeKom.setText(tot_LikeTL);
        return;
_L6:
        try
        {
            notificationLikeHelper.completed("Tanya Ponsel", notificationLikeHelper.dislikefrontKomen);
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            return;
        }
          goto _L11
_L4:
label0:
        {
            if (!tl_type.equals("benchmark"))
            {
                break MISSING_BLOCK_LABEL_332;
            }
            if (!statuslike.equals("1"))
            {
                break label0;
            }
            notificationLikeHelper.completed("Benchmark Ponsel", notificationLikeHelper.likefrontKomen);
        }
          goto _L11
        notificationLikeHelper.completed("Benchmark Ponsel", notificationLikeHelper.dislikefrontKomen);
          goto _L11
label1:
        {
            if (!tl_type.equals("hasilkamera"))
            {
                break MISSING_BLOCK_LABEL_415;
            }
            if (!statuslike.equals("1"))
            {
                break label1;
            }
            notificationLikeHelper.completed("Hasil Foto Ponsel", notificationLikeHelper.likefrontKomen);
        }
          goto _L11
        notificationLikeHelper.completed("Hasil Foto Ponsel", notificationLikeHelper.dislikefrontKomen);
          goto _L11
label2:
        {
            if (!statuslike.equals("1"))
            {
                break label2;
            }
            notificationLikeHelper.completed("Artikel Ponsel", notificationLikeHelper.likefrontKomen);
        }
          goto _L11
        notificationLikeHelper.completed("Artikel Ponsel", notificationLikeHelper.dislikefrontKomen);
          goto _L11
_L8:
        if (!statuslike.equals("0")) goto _L13; else goto _L12
_L12:
        list_img_like.setBackgroundResource(0x7f02020e);
        list_lay_like.setEnabled(true);
          goto _L13
_L10:
        (new ask(ConversationDetailActivity.this)).execute(new Void[0]);
          goto _L14
_L2:
label3:
        {
            if (!tl_type.equals("faqhp"))
            {
                break MISSING_BLOCK_LABEL_621;
            }
            if (!statuslike.equals("1"))
            {
                break label3;
            }
            notificationLikeHelper.gagal("Tanya Ponsel", postMessageLikeKom);
        }
          goto _L14
        notificationLikeHelper.gagal("Tanya Ponsel", postMessageLikeKom);
          goto _L14
label4:
        {
            if (!tl_type.equals("benchmark"))
            {
                break MISSING_BLOCK_LABEL_698;
            }
            if (!statuslike.equals("1"))
            {
                break label4;
            }
            notificationLikeHelper.gagal("Benchmark Ponsel", postMessageLikeKom);
        }
          goto _L14
        notificationLikeHelper.gagal("Benchmark Ponsel", postMessageLikeKom);
          goto _L14
label5:
        {
            if (!tl_type.equals("hasilkamera"))
            {
                break MISSING_BLOCK_LABEL_775;
            }
            if (!statuslike.equals("1"))
            {
                break label5;
            }
            notificationLikeHelper.gagal("Hasil Foto Ponsel", postMessageLikeKom);
        }
          goto _L14
        notificationLikeHelper.gagal("Hasil Foto Ponsel", postMessageLikeKom);
          goto _L14
label6:
        {
            if (!statuslike.equals("1"))
            {
                break label6;
            }
            notificationLikeHelper.gagal("Artikel Ponsel", postMessageLikeKom);
        }
          goto _L14
        notificationLikeHelper.gagal("Artikel Ponsel", postMessageLikeKom);
          goto _L14
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        if (tl_type.equals("faqhp"))
        {
            if (statuslike.equals("1"))
            {
                notificationLikeHelper.createNotification("Tanya Ponsel", notificationLikeHelper.likefrontKomen);
                return;
            } else
            {
                notificationLikeHelper.createNotification("Tanya Ponsel", notificationLikeHelper.dislikefrontKomen);
                return;
            }
        }
        if (statuslike.equals("1"))
        {
            notificationLikeHelper.createNotification("Artikel Ponsel", notificationLikeHelper.likefrontKomen);
            return;
        } else
        {
            notificationLikeHelper.createNotification("Artikel Ponsel", notificationLikeHelper.dislikefrontKomen);
            return;
        }
    }

    public ask()
    {
        this$0 = ConversationDetailActivity.this;
        super();
    }
}
