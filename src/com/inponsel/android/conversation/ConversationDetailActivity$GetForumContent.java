// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.conversation;

import android.os.AsyncTask;
import android.os.StrictMode;
import android.text.Html;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.conversation:
//            ConversationDetailActivity

public class this._cls0 extends AsyncTask
{

    final ConversationDetailActivity this$0;

    private void parseJSONcontent(String s)
    {
        int i;
        try
        {
            s = new JSONObject(s);
            postStatusContent = s.getString("success");
            postMessageContent = s.getString("message");
            resolution = s.getString("resolution");
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
        tl_judul = s.getString("judul");
        tl_content = s.getString("content");
        tl_content_ext = s.getString("content_ext");
        tl_codename = s.getString("codename");
        tl_date = s.getString("date");
        tl_id = s.getString("id");
        tl_id_hp = s.getString("id_hp");
        tl_id_user = s.getString("id_user");
        tl_img_url = s.getString("img_url");
        tl_tag = s.getString("tag");
        tl_type = s.getString("type");
        tl_me = s.getString("me");
        tl_username = s.getString("user_name");
        tl_kota = s.getString("user_kota");
        tl_img_height = s.getInt("height");
        tl_img_width = s.getInt("width");
        tl_userphoto = s.getString("user_photo");
        idkom_pos = tl_id;
        model = s.getString("model");
        merk = s.getString("merk");
        total_like = s.getJSONObject("likedislike").getString("total_like");
        fav_stat = s.getJSONObject("likedislike").getString("my_fav_tl");
        like_stat = s.getJSONObject("likedislike").getString("my_like_tl");
        jum_komen = s.getJSONObject("likedislike").getString("total_komen");
        id_artikel = tl_id;
        i++;
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_63;
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
            if (android.os.tivity.GetForumContent >= 11)
            {
                avoid = StrictMode.getThreadPolicy();
                StrictMode.setThreadPolicy((new android.os.tivity.GetForumContent(avoid)).rites().rites());
                StrictMode.setThreadPolicy(avoid);
            }
            avoid = urlGetContent;
            Log.e("pushURL", avoid);
            avoid = HttpPush.getResponse(avoid);
            rescontent = avoid.toString();
            parseJSONcontent(rescontent);
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
        if (tl_type.equals("artikel") && tl_me.equals("yes"))
        {
            list_lay_edit.setVisibility(0);
        } else
        {
            list_lay_edit.setVisibility(8);
        }
        Log.e("tl_content", tl_content);
        Log.e("tl_userphoto", tl_userphoto);
        try
        {
            Picasso.with(ConversationDetailActivity.this).load((new StringBuilder(String.valueOf(Util.BASE_URL_THUMB_ORI))).append("w=").append(200).append("&src=").append(tl_userphoto).toString()).transform(ConversationDetailActivity.access$1(ConversationDetailActivity.this)).into(imageAvatar, new Callback() {

                final ConversationDetailActivity.GetForumContent this$1;

                public void onError()
                {
                }

                public void onSuccess()
                {
                }

            
            {
                this$1 = ConversationDetailActivity.GetForumContent.this;
                super();
            }
            });
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            void1.printStackTrace();
        }
        web_tl_srclink.getSettings().setJavaScriptEnabled(true);
        web_tl_srclink.loadDataWithBaseURL("", (new StringBuilder("<style>img{display: inline;height: auto;max-width: 100%;} iframe{display: inline;height: auto;max-width: 100%;}</style>")).append(tl_content).toString(), "text/html", "UTF-8", "");
        if (tl_type.equals("benchmark"))
        {
            txtbencTitle.setVisibility(8);
            txtbencSkor.setVisibility(0);
            txtbencSkor.setText((new StringBuilder("Skor: ")).append(tl_content_ext).toString());
        } else
        {
            txtbencTitle.setVisibility(8);
            txtbencSkor.setVisibility(8);
        }
        if (tl_type.equals("hasilkamera"))
        {
            txthasilfotoTitle.setVisibility(0);
            tl_content_ext = tl_content_ext.replaceAll("\\s+", "");
            void1 = tl_content_ext.trim().split("-");
            Log.e("tl_content_ext", tl_content_ext);
            txthasilfotoTitle.setText((new StringBuilder("#")).append(void1[0].trim()).append("\n").append("#").append(void1[1].trim()).toString());
        } else
        {
            txthasilfotoTitle.setVisibility(8);
        }
        if (tl_id_hp.equals("0") || tl_id_hp.equals(""))
        {
            int i;
            int j;
            if (tl_tag.equals("") || tl_tag.equals("0"))
            {
                txtForumHashTag.setText("");
            } else
            {
                txtForumHashTag.setText((new StringBuilder("#")).append(tl_tag.replace(",", "\n#")).toString());
                txtForumHashTag.setVisibility(0);
            }
            if (tl_type.equals("conversation"))
            {
                txtForumHashTag.setVisibility(8);
            } else
            {
                txtForumHashTag.setVisibility(8);
            }
        } else
        {
            txtForumHashTag.setVisibility(8);
        }
        if (tl_type.equals("benchmark"))
        {
            txt_tl_title.setText(Html.fromHtml((new StringBuilder(String.valueOf(tl_judul))).append(" - ").append(tl_tag).toString()));
        } else
        {
            txt_tl_title.setText(Html.fromHtml(tl_judul));
        }
        txtLikeKom.setText(total_like);
        txttlSumber.setText(Html.fromHtml((new StringBuilder("<b>")).append(tl_username).append("</b>").append(" di ").append("<b>").append(tl_kota).append("</b>").toString()));
        txttlTanggal.setText(Utility.convertDate(tl_date));
        if (like_stat.equals("1"))
        {
            list_img_like.setBackgroundResource(0x7f02020d);
            list_lay_like.setEnabled(false);
        } else
        if (like_stat.equals("0"))
        {
            list_img_like.setBackgroundResource(0x7f02020e);
            list_lay_like.setEnabled(true);
        }
        Log.e("fav_stat", fav_stat);
        if (fav_stat.equals("1"))
        {
            list_img_favorite.setBackgroundResource(0x7f02023b);
        } else
        {
            list_img_favorite.setBackgroundResource(0x7f02023a);
        }
        if (tl_img_url.equals(""))
        {
            break MISSING_BLOCK_LABEL_1024;
        }
        progressbar_imgTLContent.setVisibility(0);
        void1 = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(void1);
        i = ((DisplayMetrics) (void1)).widthPixels;
        j = ((DisplayMetrics) (void1)).heightPixels;
        screenwidth = i;
        Log.e("scrwh", (new StringBuilder(String.valueOf(String.valueOf(i)))).append("x").append(String.valueOf(j)).toString());
        Log.e("wh", (new StringBuilder(String.valueOf(String.valueOf(tl_img_width)))).append("x").append(String.valueOf(tl_img_height)).toString());
        void1 = new android.widget.ty.tl_img_height(-1, -2);
        imgTLContent.setLayoutParams(void1);
        Picasso.with(ConversationDetailActivity.this).load((new StringBuilder(String.valueOf(Util.BASE_URL_THUMB_ORI))).append("w=").append(i).append("&src=").append(tl_img_url).toString()).into(imgTLContent, new Callback() {

            final ConversationDetailActivity.GetForumContent this$1;

            public void onError()
            {
                imgTLContent.setImageResource(0x7f0201b8);
            }

            public void onSuccess()
            {
                progressbar_imgTLContent.setVisibility(8);
            }

            
            {
                this$1 = ConversationDetailActivity.GetForumContent.this;
                super();
            }
        });
        return;
        void1;
        void1.printStackTrace();
        return;
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        Log.e("urlGetContent", urlGetContent);
    }


    public _cls2.this._cls1()
    {
        this$0 = ConversationDetailActivity.this;
        super();
    }
}
