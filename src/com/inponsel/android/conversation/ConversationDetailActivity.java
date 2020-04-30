// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.conversation;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.google.android.gms.analytics.Tracker;
import com.inponsel.android.adapter.ItemRSSKomen;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.timelinedetail.ReplyKomTLActivity;
import com.inponsel.android.timelinedetail.TLKomenTab;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.NotificationKomenHelper;
import com.inponsel.android.utils.NotificationLikeRSSHelper;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.ServiceHandler;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.v2.AddKomentarPicture;
import com.inponsel.android.v2.ImagePagerActivity;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.ProfileOtherUser;
import com.inponsel.android.v2.RegisterActivity;
import com.inponsel.android.v2.RoomPostArtikel;
import com.inponsel.android.widget.DroidWriterEditText;
import com.inponsel.android.widget.RoundedTransformationBuilder;
import com.inponsel.android.widget.TextViewFixTouchConsume;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.squareup.picasso.Transformation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ConversationDetailActivity extends SherlockFragmentActivity
    implements Observer
{
    public class FavoritTask extends AsyncTask
    {

        final ConversationDetailActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            try
            {
                avoid = (new StringBuilder("idartanya=")).append(id_artikel).append("&idusr=").append(user_id).append("&stat=").append(statFav).append("&type=").append(tl_type).append("&t=").append(t).toString();
                String s = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("add_favartanya").append(Utility.BASE_FORMAT).append("?").append(avoid).toString();
                Log.e("pushURL", s);
                s = HttpPush.getResponse(s);
                Log.e("push", (new StringBuilder(String.valueOf(s))).append(avoid).toString());
                res = s.toString();
                parseJSONAddFav(res);
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
            if (postStatusAddTL.equals("1") || postStatusAddTL.equals("10"))
            {
                if (tl_img_url.equals(""))
                {
                    db.addArtTanya(tl_id, tl_id_hp, merk, model, tl_codename, tl_judul, tl_type, tl_tag, "", tl_content, tl_content_ext, tl_date);
                } else
                {
                    db.addArtTanya(tl_id, tl_id_hp, merk, model, tl_codename, tl_judul, tl_type, tl_tag, tl_img_url, tl_content, tl_content_ext, tl_date);
                }
                list_img_favorite.setBackgroundResource(0x7f02023b);
            } else
            if (postStatusAddTL.equals("00") || postStatusAddTL.equals("0"))
            {
                Toast.makeText(ConversationDetailActivity.this, "Berhasil menghapus", 1).show();
                db.delete_TLbyID(tl_id);
                list_img_favorite.setBackgroundResource(0x7f02023a);
            } else
            if (res.equals("40404"))
            {
                mDialog.dismiss();
            } else
            {
                Toast.makeText(ConversationDetailActivity.this, postMessageAddTL, 1).show();
                list_img_favorite.setBackgroundResource(0x7f02023a);
            }
            ponselBaseApp.getObserver().setUpdateType("favtl");
            ponselBaseApp.getObserver().setStatus_like_ponsel("-");
            mDialog.dismiss();
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            if (statFav.equals("1"))
            {
                mDialog = ProgressDialog.show(ConversationDetailActivity.this, "", "Menambahkan...", true);
            } else
            {
                mDialog = ProgressDialog.show(ConversationDetailActivity.this, "", "Menghapus...", true);
            }
            mDialog.setCancelable(true);
            mDialog.show();
        }

        public FavoritTask()
        {
            this$0 = ConversationDetailActivity.this;
            super();
        }
    }

    public class GetForumContent extends AsyncTask
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
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    avoid = StrictMode.getThreadPolicy();
                    StrictMode.setThreadPolicy((new android.os.StrictMode.ThreadPolicy.Builder(avoid)).permitDiskWrites().build());
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
                Picasso.with(ConversationDetailActivity.this).load((new StringBuilder(String.valueOf(Util.BASE_URL_THUMB_ORI))).append("w=").append(200).append("&src=").append(tl_userphoto).toString()).transform(mTransformation).into(imageAvatar, new Callback() {

                    final GetForumContent this$1;

                    public void onError()
                    {
                    }

                    public void onSuccess()
                    {
                    }

            
            {
                this$1 = GetForumContent.this;
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
            void1 = new android.widget.FrameLayout.LayoutParams(-1, -2);
            imgTLContent.setLayoutParams(void1);
            Picasso.with(ConversationDetailActivity.this).load((new StringBuilder(String.valueOf(Util.BASE_URL_THUMB_ORI))).append("w=").append(i).append("&src=").append(tl_img_url).toString()).into(imgTLContent, new Callback() {

                final GetForumContent this$1;

                public void onError()
                {
                    imgTLContent.setImageResource(0x7f0201b8);
                }

                public void onSuccess()
                {
                    progressbar_imgTLContent.setVisibility(8);
                }

            
            {
                this$1 = GetForumContent.this;
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


        public GetForumContent()
        {
            this$0 = ConversationDetailActivity.this;
            super();
        }
    }

    public class KomentarAsycTask extends AsyncTask
    {

        final ConversationDetailActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient Void doInBackground(String as[])
        {
            Log.e("KomentarAsycTask", "doInBackground");
            JSONObject jsonobject = new JSONObject(getJSONUrl(urlKomen));
            mArrayListData = new ArrayList();
            as = jsonobject.getJSONArray("InPonsel");
            jum_komen_list = jsonobject.getString("total_komen");
            top_id = jsonobject.getString("top_id");
            bottom_id = jsonobject.getString("bottom_id");
            statusKomen = jsonobject.getString("statuskomen");
            countKomOld = 0;
            if (strKonekStat.equals("-"))
            {
                break MISSING_BLOCK_LABEL_309;
            }
            int i = 0;
_L1:
            if (i >= as.length())
            {
                break MISSING_BLOCK_LABEL_309;
            }
            Object obj = ConversationDetailActivity.this;
            obj.countAllKom = ((ConversationDetailActivity) (obj)).countAllKom + 1;
            obj = ConversationDetailActivity.this;
            obj.countKomOld = ((ConversationDetailActivity) (obj)).countKomOld + 1;
            obj = as.getJSONObject(i);
            mArrayListData.add(new ItemRSSKomen(((JSONObject) (obj)).getString("id_kom"), ((JSONObject) (obj)).getString("id_artanya"), ((JSONObject) (obj)).getString("id_user"), ((JSONObject) (obj)).getString("id_user_to"), ((JSONObject) (obj)).getString("komentar"), ((JSONObject) (obj)).getString("tanggal_kom"), ((JSONObject) (obj)).getString("user_photo"), ((JSONObject) (obj)).getString("user_name"), ((JSONObject) (obj)).getString("tanggal_to"), ((JSONObject) (obj)).getString("total_like"), ((JSONObject) (obj)).getString("total_dislike"), ((JSONObject) (obj)).getString("my_like_kom"), ((JSONObject) (obj)).getString("user_name_to"), ((JSONObject) (obj)).getString("komen_to"), ((JSONObject) (obj)).getString("img_kom"), ((JSONObject) (obj)).getString("img_kom_rep")));
            i++;
              goto _L1
            as;
            as.printStackTrace();
            strKonekStat = "0";
            return null;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            int i;
            Log.e("statusKomenTask", statusKomen);
            txtLabelKomentar.setText((new StringBuilder("Komentar (")).append(jum_komen_list).append(")").toString());
            mLinearListView.removeAllViewsInLayout();
            progressbar_komen.setVisibility(8);
            int j;
            if (statusKomen.equals("1"))
            {
                itemTurnNotif.setChecked(true);
            } else
            {
                itemTurnNotif.setChecked(false);
            }
            if (mArrayListData.size() == 0)
            {
                txt_empty_komen.setVisibility(0);
            } else
            if (mArrayListData.size() < 3)
            {
                btn_komenlain.setVisibility(8);
                txt_empty_komen.setVisibility(8);
            } else
            if (Integer.parseInt(jum_komen_list) == 3)
            {
                btn_komenlain.setVisibility(8);
                txt_empty_komen.setVisibility(8);
            } else
            {
                btn_komenlain.setVisibility(0);
                txt_empty_komen.setVisibility(8);
            }
            if (strKonekStat.equals("-")) goto _L2; else goto _L1
_L1:
            i = 0;
_L8:
            ImageView imageview;
            ImageView imageview1;
            final String id_komrss;
            final String tl_id;
            String s;
            final String komen_rss;
            final String tanggal_kom;
            String s1;
            final String user_name;
            try
            {
                j = mArrayListData.size();
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
            if (i < j) goto _L3; else goto _L2
_L2:
            return;
_L3:
            void1 = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f0300ff, null);
            txtUsername = (TextView)void1.findViewById(0x7f0b0419);
            lay_quote = (LinearLayout)void1.findViewById(0x7f0b063a);
            img_kom_picture = (ImageView)void1.findViewById(0x7f0b054b);
            txtIdKom = (TextView)void1.findViewById(0x7f0b054d);
            txtKomentar = (TextViewFixTouchConsume)void1.findViewById(0x7f0b054e);
            txtUsernameQoute = (TextView)void1.findViewById(0x7f0b063b);
            txtKomentarQoute = (TextViewFixTouchConsume)void1.findViewById(0x7f0b063d);
            txtWaktu = (TextView)void1.findViewById(0x7f0b054c);
            txtWaktuQoute = (TextView)void1.findViewById(0x7f0b063c);
            txtTanggapan = (TextView)void1.findViewById(0x7f0b0555);
            imageview = (ImageView)void1.findViewById(0x7f0b054f);
            imageview1 = (ImageView)void1.findViewById(0x7f0b0552);
            txtLikeKom_list = (TextView)void1.findViewById(0x7f0b0551);
            txtdisLikeKom = (TextView)void1.findViewById(0x7f0b0554);
            headName = (LinearLayout)void1.findViewById(0x7f0b0549);
            list_lay_like_kom = (RelativeLayout)void1.findViewById(0x7f0b0342);
            list_lay_dislike_kom = (RelativeLayout)void1.findViewById(0x7f0b0345);
            list_lay_rep_kom = (RelativeLayout)void1.findViewById(0x7f0b063f);
            list_lay_kom_kom = (RelativeLayout)void1.findViewById(0x7f0b0348);
            id_komrss = ((ItemRSSKomen)mArrayListData.get(i)).getId_komrss();
            tl_id = ((ItemRSSKomen)mArrayListData.get(i)).getId_rss();
            s = ((ItemRSSKomen)mArrayListData.get(i)).getId_user();
            ((ItemRSSKomen)mArrayListData.get(i)).getId_user_to();
            komen_rss = ((ItemRSSKomen)mArrayListData.get(i)).getKomen_rss();
            tanggal_kom = ((ItemRSSKomen)mArrayListData.get(i)).getTanggal_kom();
            s1 = ((ItemRSSKomen)mArrayListData.get(i)).getUser_photo();
            user_name = ((ItemRSSKomen)mArrayListData.get(i)).getUser_name();
            ((ItemRSSKomen)mArrayListData.get(i)).getTanggal_to();
            ((ItemRSSKomen)mArrayListData.get(i)).getTotal_like();
            ((ItemRSSKomen)mArrayListData.get(i)).getTotal_dislike();
            ((ItemRSSKomen)mArrayListData.get(i)).getMy_like_kom();
            ((ItemRSSKomen)mArrayListData.get(i)).getKomen_to();
            ((ItemRSSKomen)mArrayListData.get(i)).getUser_name_to();
            ll_img_komen_rep = (RelativeLayout)void1.findViewById(0x7f0b0768);
            ll_img_komen = (RelativeLayout)void1.findViewById(0x7f0b076c);
            imgKomentar_rep = (ImageView)void1.findViewById(0x7f0b076a);
            imgKomentar = (ImageView)void1.findViewById(0x7f0b076e);
            txtTapImage = (TextView)void1.findViewById(0x7f0b076b);
            txtTapImageRep = (TextView)void1.findViewById(0x7f0b0767);
            progressbar_imgkomen = (ProgressBar)void1.findViewById(0x7f0b076d);
            progressbar_imgkomenrep = (ProgressBar)void1.findViewById(0x7f0b0769);
            String s2 = ((ItemRSSKomen)mArrayListData.get(i)).getImg_media();
            String s3 = ((ItemRSSKomen)mArrayListData.get(i)).getImg_media_to();
            check_image_komen(ll_img_komen, ll_img_komen_rep, txtTapImage, txtTapImageRep, imgKomentar, imgKomentar_rep, progressbar_imgkomen, progressbar_imgkomenrep, s2, s3);
            if (!((ItemRSSKomen)mArrayListData.get(i)).getUser_name_to().toString().trim().equals("-") && !((ItemRSSKomen)mArrayListData.get(i)).getUser_name_to().toString().trim().equals("")) goto _L5; else goto _L4
_L4:
            lay_quote.setVisibility(8);
_L9:
            if (!((ItemRSSKomen)mArrayListData.get(i)).getMy_like_kom().toString().equals("1")) goto _L7; else goto _L6
_L6:
            imageview.setBackgroundResource(0x7f02025b);
            imageview1.setBackgroundResource(0x7f0201a3);
            list_lay_like_kom.setEnabled(false);
            list_lay_dislike_kom.setEnabled(true);
_L10:
            if (!((ItemRSSKomen)mArrayListData.get(i)).getUser_photo().trim().contains(".jpg") && !((ItemRSSKomen)mArrayListData.get(i)).getUser_photo().toString().trim().contains(".png") && !((ItemRSSKomen)mArrayListData.get(i)).getUser_photo().toString().trim().contains(".jpeg"))
            {
                break MISSING_BLOCK_LABEL_2015;
            }
            Picasso.with(ConversationDetailActivity.this).load(((ItemRSSKomen)mArrayListData.get(i)).getUser_photo().toString().trim()).into(img_kom_picture, new Callback() {

                final KomentarAsycTask this$1;

                public void onError()
                {
                }

                public void onSuccess()
                {
                    img_kom_picture.setVisibility(0);
                }

            
            {
                this$1 = KomentarAsycTask.this;
                super();
            }
            });
_L11:
            txtIdKom.setText(((ItemRSSKomen)mArrayListData.get(i)).getId_komrss().toString());
            txtdisLikeKom.setText(((ItemRSSKomen)mArrayListData.get(i)).getTotal_dislike().toString());
            txtLikeKom_list.setText(((ItemRSSKomen)mArrayListData.get(i)).getTotal_like().toString());
            txtUsername.setText(((ItemRSSKomen)mArrayListData.get(i)).getUser_name());
            txtKomentar.setText(Html.fromHtml(Utility.parseUrl(((ItemRSSKomen)mArrayListData.get(i)).getKomen_rss())));
            txtKomentar.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
            txtUsernameQoute.setText(Html.fromHtml(((ItemRSSKomen)mArrayListData.get(i)).getUser_name_to()));
            txtKomentarQoute.setText(Html.fromHtml(Utility.parseUrl(((ItemRSSKomen)mArrayListData.get(i)).getKomen_to().toString())));
            txtKomentarQoute.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
            txtWaktu.setText(Utility.convertDate(((ItemRSSKomen)mArrayListData.get(i)).getTanggal_kom()));
            txtWaktuQoute.setText(Utility.convertDate(((ItemRSSKomen)mArrayListData.get(i)).getTanggal_to()));
            mLinearListView.addView(void1);
            img_kom_picture.setOnLongClickListener(s1. new android.view.View.OnLongClickListener() {

                final KomentarAsycTask this$1;
                private final String val$user_photo;

                public boolean onLongClick(View view)
                {
                    view = new ArrayList();
                    view.add((new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(user_photo.toString().trim()).toString());
                    view = (String[])view.toArray(new String[view.size()]);
                    Intent intent = new Intent(_fld0, com/inponsel/android/v2/ImagePagerActivity);
                    intent.putExtra("imgUrl", view);
                    intent.putExtra("pos", 0);
                    startActivity(intent);
                    return false;
                }

            
            {
                this$1 = final_komentarasyctask;
                user_photo = String.this;
                super();
            }
            });
            img_kom_picture.setOnClickListener(s. new android.view.View.OnClickListener() {

                final KomentarAsycTask this$1;
                private final String val$id_user;

                public void onClick(View view)
                {
                    view = new Intent(_fld0, com/inponsel/android/v2/ProfileOtherUser);
                    view.putExtra("id_user_view", id_user);
                    startActivityForResult(view, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$1 = final_komentarasyctask;
                id_user = String.this;
                super();
            }
            });
            list_lay_like_kom.setOnClickListener(tl_id. new android.view.View.OnClickListener() {

                final KomentarAsycTask this$1;
                private final String val$id_komrss;
                private final String val$tl_id;

                public void onClick(View view)
                {
                    if (userFunctions.isUserLoggedIn(_fld0))
                    {
                        statuslike = "1";
                        idkom_pos = id_komrss;
                        querylikeKomen = (new StringBuilder("status=")).append(statuslike).append("&id_kom=").append(id_komrss).append("&tl_id=").append(id_artikel).append("&tl_id=").append(tl_id).append("&id_usr=").append(user_id).append("&t=").append(t).toString();
                        Log.e("querylike", querylikeKomen);
                        if (android.os.Build.VERSION.SDK_INT >= 11)
                        {
                            (new PostBagusKurangKomenTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                            return;
                        } else
                        {
                            (new PostBagusKurangKomenTask()).execute(new Void[0]);
                            return;
                        }
                    } else
                    {
                        view = new android.app.AlertDialog.Builder(_fld0);
                        view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                        view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                            final KomentarAsycTask._cls4 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = KomentarAsycTask._cls4.this;
                super();
            }
                        });
                        view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                            final KomentarAsycTask._cls4 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = KomentarAsycTask._cls4.this;
                super();
            }
                        });
                        view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                            final KomentarAsycTask._cls4 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                                dialoginterface.putExtra("activity", "main");
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = KomentarAsycTask._cls4.this;
                super();
            }
                        });
                        view.show();
                        return;
                    }
                }


            
            {
                this$1 = final_komentarasyctask;
                id_komrss = s;
                tl_id = String.this;
                super();
            }
            });
            list_lay_dislike_kom.setOnClickListener(tl_id. new android.view.View.OnClickListener() {

                final KomentarAsycTask this$1;
                private final String val$id_komrss;
                private final String val$tl_id;

                public void onClick(View view)
                {
                    if (userFunctions.isUserLoggedIn(_fld0))
                    {
                        statuslike = "0";
                        idkom_pos = id_komrss;
                        querylikeKomen = (new StringBuilder("status=")).append(statuslike).append("&id_kom=").append(id_komrss).append("&tl_id=").append(id_artikel).append("&tl_id=").append(tl_id).append("&id_usr=").append(user_id).append("&t=").append(t).toString();
                        Log.e("querylikeKomen", querylikeKomen);
                        if (android.os.Build.VERSION.SDK_INT >= 11)
                        {
                            (new PostBagusKurangKomenTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                            return;
                        } else
                        {
                            (new PostBagusKurangKomenTask()).execute(new Void[0]);
                            return;
                        }
                    } else
                    {
                        view = new android.app.AlertDialog.Builder(_fld0);
                        view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                        view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                            final KomentarAsycTask._cls5 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = KomentarAsycTask._cls5.this;
                super();
            }
                        });
                        view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                            final KomentarAsycTask._cls5 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = KomentarAsycTask._cls5.this;
                super();
            }
                        });
                        view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                            final KomentarAsycTask._cls5 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                                dialoginterface.putExtra("activity", "main");
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = KomentarAsycTask._cls5.this;
                super();
            }
                        });
                        view.show();
                        return;
                    }
                }


            
            {
                this$1 = final_komentarasyctask;
                id_komrss = s;
                tl_id = String.this;
                super();
            }
            });
            list_lay_rep_kom.setOnClickListener(s1. new android.view.View.OnClickListener() {

                final KomentarAsycTask this$1;
                private final String val$id_komrss;
                private final String val$komen_rss;
                private final String val$tanggal_kom;
                private final String val$tl_id;
                private final String val$user_name;
                private final String val$user_photo;

                public void onClick(View view)
                {
                    if (userFunctions.isUserLoggedIn(_fld0))
                    {
                        view = new Intent(_fld0, com/inponsel/android/timelinedetail/ReplyKomTLActivity);
                        view.putExtra("tl_judul", tl_judul);
                        view.putExtra("tl_type", tl_type);
                        view.putExtra("tl_id", tl_id);
                        view.putExtra("id_komrss", id_komrss);
                        view.putExtra("user_id", user_id);
                        view.putExtra("user_name", user_name);
                        view.putExtra("tanggal_kom", tanggal_kom);
                        view.putExtra("komen_rss", komen_rss);
                        view.putExtra("user_photo", user_photo);
                        view.putExtra("top_id", top_id);
                        view.putExtra("bottom_id", bottom_id);
                        Log.e("id_komrss_to", id_komrss);
                        Log.e("tl_id", tl_id);
                        startActivityForResult(view, ConversationDetailActivity.POST_STAT);
                        return;
                    } else
                    {
                        view = new android.app.AlertDialog.Builder(_fld0);
                        view.setMessage("Untuk membalas komentar harus login terlebih dahulu.");
                        view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                            final KomentarAsycTask._cls6 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = KomentarAsycTask._cls6.this;
                super();
            }
                        });
                        view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                            final KomentarAsycTask._cls6 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = KomentarAsycTask._cls6.this;
                super();
            }
                        });
                        view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                            final KomentarAsycTask._cls6 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                                dialoginterface.putExtra("activity", "main");
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = KomentarAsycTask._cls6.this;
                super();
            }
                        });
                        view.show();
                        return;
                    }
                }


            
            {
                this$1 = final_komentarasyctask;
                tl_id = s;
                id_komrss = s1;
                user_name = s2;
                tanggal_kom = s3;
                komen_rss = s4;
                user_photo = String.this;
                super();
            }
            });
            void1.setOnClickListener(s1. new android.view.View.OnClickListener() {

                final KomentarAsycTask this$1;
                private final String val$id_komrss;
                private final String val$komen_rss;
                private final String val$tanggal_kom;
                private final String val$tl_id;
                private final String val$user_name;
                private final String val$user_photo;

                public void onClick(View view)
                {
                    if (userFunctions.isUserLoggedIn(_fld0))
                    {
                        view = new Intent(_fld0, com/inponsel/android/timelinedetail/ReplyKomTLActivity);
                        view.putExtra("tl_judul", tl_judul);
                        view.putExtra("tl_type", tl_type);
                        view.putExtra("tl_id", tl_id);
                        view.putExtra("id_komrss", id_komrss);
                        view.putExtra("user_id", user_id);
                        view.putExtra("user_name", user_name);
                        view.putExtra("tanggal_kom", tanggal_kom);
                        view.putExtra("komen_rss", komen_rss);
                        view.putExtra("user_photo", user_photo);
                        view.putExtra("bottom_id", bottom_id);
                        view.putExtra("top_id", top_id);
                        Log.e("id_komrss_to", id_komrss);
                        Log.e("tl_id", tl_id);
                        startActivityForResult(view, ConversationDetailActivity.POST_STAT);
                        return;
                    } else
                    {
                        view = new android.app.AlertDialog.Builder(_fld0);
                        view.setMessage("Untuk membalas komentar harus login terlebih dahulu.");
                        view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                            final KomentarAsycTask._cls7 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = KomentarAsycTask._cls7.this;
                super();
            }
                        });
                        view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                            final KomentarAsycTask._cls7 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = KomentarAsycTask._cls7.this;
                super();
            }
                        });
                        view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                            final KomentarAsycTask._cls7 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                                dialoginterface.putExtra("activity", "main");
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = KomentarAsycTask._cls7.this;
                super();
            }
                        });
                        view.show();
                        return;
                    }
                }


            
            {
                this$1 = final_komentarasyctask;
                tl_id = s;
                id_komrss = s1;
                user_name = s2;
                tanggal_kom = s3;
                komen_rss = s4;
                user_photo = String.this;
                super();
            }
            });
            i++;
              goto _L8
_L5:
            lay_quote.setVisibility(0);
              goto _L9
_L7:
label0:
            {
                if (!((ItemRSSKomen)mArrayListData.get(i)).getMy_like_kom().toString().equals("0"))
                {
                    break label0;
                }
                imageview.setBackgroundResource(0x7f020257);
                imageview1.setBackgroundResource(0x7f0201a7);
                list_lay_like_kom.setEnabled(true);
                list_lay_dislike_kom.setEnabled(false);
            }
              goto _L10
            list_lay_like_kom.setEnabled(true);
            list_lay_dislike_kom.setEnabled(true);
            imageview.setBackgroundResource(0x7f020257);
            imageview1.setBackgroundResource(0x7f0201a3);
              goto _L10
            img_kom_picture.setImageResource(0x7f020297);
              goto _L11
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            Log.e("KomentarAsycTask", "onPreExecute");
            progressbar_komen.setVisibility(8);
            txt_empty_komen.setVisibility(8);
            btn_komenlain.setVisibility(8);
            mArrayListData.clear();
        }


        public KomentarAsycTask()
        {
            this$0 = ConversationDetailActivity.this;
            super();
        }
    }

    public class MailPostBagusKurangTask extends AsyncTask
    {

        final ConversationDetailActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            try
            {
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    avoid = StrictMode.getThreadPolicy();
                    StrictMode.setThreadPolicy((new android.os.StrictMode.ThreadPolicy.Builder(avoid)).permitDiskWrites().build());
                    StrictMode.setThreadPolicy(avoid);
                }
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("mail_forum_postlike.php?").append(querylike).toString();
                Log.e("pushURL", avoid);
                avoid = HttpPush.getResponse(avoid);
                reslike = avoid.toString();
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
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
        }

        public MailPostBagusKurangTask()
        {
            this$0 = ConversationDetailActivity.this;
            super();
        }
    }

    public class PostBagusKurangKomenTask extends AsyncTask
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
            tot_LikeKom = s.getString("total_like");
            totdis_LikeKom = s.getString("total_dislike");
            Log.e("tot_LikePon", tot_LikeKom);
            Log.e("totdis_LikePon", totdis_LikeKom);
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
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    avoid = StrictMode.getThreadPolicy();
                    StrictMode.setThreadPolicy((new android.os.StrictMode.ThreadPolicy.Builder(avoid)).permitDiskWrites().build());
                    StrictMode.setThreadPolicy(avoid);
                }
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("likedis_komen_artanya.php?").append(querylikeKomen).toString();
                Log.e("pushURL", avoid);
                avoid = HttpPush.getResponse(avoid);
                reslikeKomen = avoid.toString();
                parseJSONLikeKom(reslikeKomen);
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
            if (!postStatusLikeKom.equals("1"))
            {
                break MISSING_BLOCK_LABEL_183;
            }
            if (!statuslike.equals("1"))
            {
                break MISSING_BLOCK_LABEL_141;
            }
            notificationLikeHelper.completed(tl_judul, "Like komentar terkirim");
_L1:
            Log.e("mArrayListData", String.valueOf(mArrayListData.size()));
            Log.e("index_komposlike", idkom_pos);
            updateViewLikeDis(idkom_pos);
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                (new SendMailLikeDisTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                return;
            }
            break MISSING_BLOCK_LABEL_163;
            try
            {
                notificationLikeHelper.completed(tl_judul, "Dislike komentar terkirim");
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
              goto _L1
            (new SendMailLikeDisTask()).execute(new Void[0]);
            return;
            if (statuslike.equals("1"))
            {
                notificationLikeHelper.gagal(tl_judul, postMessageLikeKom);
                return;
            }
            notificationLikeHelper.gagal(tl_judul, postMessageLikeKom);
            return;
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            if (statuslike.equals("1"))
            {
                notificationLikeHelper.createNotification(tl_judul, notificationLikeHelper.likefrontKomen);
                return;
            } else
            {
                notificationLikeHelper.createNotification(tl_judul, notificationLikeHelper.dislikefrontKomen);
                return;
            }
        }

        public PostBagusKurangKomenTask()
        {
            this$0 = ConversationDetailActivity.this;
            super();
        }
    }

    public class PostBagusKurangTask extends AsyncTask
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
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    avoid = StrictMode.getThreadPolicy();
                    StrictMode.setThreadPolicy((new android.os.StrictMode.ThreadPolicy.Builder(avoid)).permitDiskWrites().build());
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
            if (android.os.Build.VERSION.SDK_INT < 11) goto _L10; else goto _L9
_L9:
            (new MailPostBagusKurangTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
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
            (new MailPostBagusKurangTask()).execute(new Void[0]);
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

        public PostBagusKurangTask()
        {
            this$0 = ConversationDetailActivity.this;
            super();
        }
    }

    public class PostFlagTask extends AsyncTask
    {

        final ConversationDetailActivity this$0;

        private void parseJSONFlag(String s)
        {
            try
            {
                s = new JSONObject(s);
                postStatusFlagKom = s.getString("success");
                postMessageFlagKom = s.getString("message");
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
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    avoid = StrictMode.getThreadPolicy();
                    StrictMode.setThreadPolicy((new android.os.StrictMode.ThreadPolicy.Builder(avoid)).permitDiskWrites().build());
                    StrictMode.setThreadPolicy(avoid);
                }
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("flag_artanya.php?").append(queryFlag).toString();
                Log.e("pushURLFlag", avoid);
                avoid = HttpPush.getResponse(avoid);
                resFlag = avoid.toString();
                parseJSONFlag(resFlag);
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
            Toast.makeText(ConversationDetailActivity.this, postMessageFlagKom, 1).show();
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            Toast.makeText(ConversationDetailActivity.this, "Mengirim laporan...", 1).show();
        }

        public PostFlagTask()
        {
            this$0 = ConversationDetailActivity.this;
            super();
        }
    }

    public class PostHits extends AsyncTask
    {

        final ConversationDetailActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            if (android.os.Build.VERSION.SDK_INT > 9)
            {
                StrictMode.setThreadPolicy((new android.os.StrictMode.ThreadPolicy.Builder()).permitAll().build());
            }
            avoid = "-";
            if (!userFunctions.isUserLoggedIn(ConversationDetailActivity.this)) goto _L2; else goto _L1
_L1:
            Object obj = user_id;
_L4:
            avoid = (new StringBuilder("tl_id=")).append(tl_id).append("&user=").append(((String) (obj))).append("&hits=1&t=").append(t).toString();
            avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("hits_forum").append(Utility.BASE_FORMAT).append("?").append(avoid).toString();
            Log.e("pushURL", avoid);
            HttpPush.getResponse(avoid).toString().trim().replaceAll("\\s+", "");
            break MISSING_BLOCK_LABEL_226;
_L2:
            Account aaccount[];
            int j;
            aaccount = AccountManager.get(ConversationDetailActivity.this).getAccounts();
            j = aaccount.length;
            int i = 0;
_L5:
            obj = avoid;
            if (i >= j) goto _L4; else goto _L3
_L3:
            obj = aaccount[i];
            if (((Account) (obj)).name.endsWith("gmail.com"))
            {
                avoid = ((Account) (obj)).name;
            }
            i++;
              goto _L5
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
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
        }

        public PostHits()
        {
            this$0 = ConversationDetailActivity.this;
            super();
        }
    }

    public class PostKomen extends AsyncTask
    {

        final ConversationDetailActivity this$0;

        private void parseJSONKom(String s)
        {
            try
            {
                s = new JSONObject(s);
                postStatus = s.getString("success");
                postMessage = s.getString("message");
                statusKomen = s.getString("statuskomen");
                tot_LikePon = s.getString("total_like");
                totdis_LikePon = s.getString("total_dislike");
                jum_komen = s.getString("total_komen");
                ponselBaseApp.getObserver().setJum_komenLikeTL(jum_komen);
                ponselBaseApp.getObserver().setTot_LikeTL(tot_LikePon);
                Log.e("tl_id", tl_id);
                ponselBaseApp.getObserver().setIndexTL(tl_id);
                Log.e("postStatus", postStatus);
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
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    avoid = StrictMode.getThreadPolicy();
                    StrictMode.setThreadPolicy((new android.os.StrictMode.ThreadPolicy.Builder(avoid)).permitDiskWrites().build());
                    StrictMode.setThreadPolicy(avoid);
                }
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("post_kom_forum").append(Utility.BASE_FORMAT).append("?").append(querypopkomen).toString();
                Log.e("pushURL", avoid);
                avoid = HttpPush.getResponse(avoid);
                res = avoid.toString();
                Log.e("responseKomen", res);
                parseJSONKom(res);
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
            ponselBaseApp.getObserver().setUpdateType("komentarconv");
            ponselBaseApp.getObserver().setStatus_like_ponsel("-");
            if (statusKomen.equals("1"))
            {
                itemTurnNotif.setChecked(true);
            } else
            {
                itemTurnNotif.setChecked(false);
            }
            btn_send_komen.setEnabled(true);
            edt_pop_komen.setEnabled(true);
            edt_pop_komen.setTextColor(Color.parseColor("#FFFFFF"));
            Log.e("postStatus", postStatus);
            if (postStatus.equals("1"))
            {
                mNotificationHelper.completed(tl_judul, mNotificationHelper.SucdiskomStatement);
                edt_pop_komen.setText("");
                try
                {
                    urlKomen = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_forum3").append(Utility.BASE_FORMAT).append("?id=").append(tl_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&sortkom=").append("12").toString();
                    Log.e("urlKomen", urlKomen);
                }
                // Misplaced declaration of an exception variable
                catch (Void void1) { }
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new KomentarAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                } else
                {
                    (new KomentarAsycTask()).execute(new String[0]);
                }
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new SendMailTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new SendMailTask()).execute(new Void[0]);
                    return;
                }
            }
            if (postStatus.equals("040"))
            {
                mNotificationHelper.gagal(tl_judul, postMessage);
                return;
            } else
            {
                mNotificationHelper.gagal(tl_judul, mNotificationHelper.gagalkomStatement);
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(edt_pop_komen.getWindowToken(), 0);
            btn_send_komen.setEnabled(false);
            edt_pop_komen.setEnabled(false);
            edt_pop_komen.setTextColor(Color.parseColor("#cacaca"));
            mNotificationHelper.createNotification(tl_judul, mNotificationHelper.komenPostWords);
        }

        public PostKomen()
        {
            this$0 = ConversationDetailActivity.this;
            super();
        }
    }

    public class SendMailLikeDisTask extends AsyncTask
    {

        final ConversationDetailActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            try
            {
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    avoid = StrictMode.getThreadPolicy();
                    StrictMode.setThreadPolicy((new android.os.StrictMode.ThreadPolicy.Builder(avoid)).permitDiskWrites().build());
                    StrictMode.setThreadPolicy(avoid);
                }
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("mail_like_comtl").append(Utility.BASE_FORMAT).append("?").append(querylike).append("&dens=").append(getResources().getDisplayMetrics().density).toString();
                Log.e("mail_like_com", avoid);
                avoid = HttpPush.getResponse(avoid);
                res = avoid.toString();
                res = res.trim();
                res = res.replaceAll("\\s+", "");
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
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
        }

        public SendMailLikeDisTask()
        {
            this$0 = ConversationDetailActivity.this;
            super();
        }
    }

    public class SendMailTask extends AsyncTask
    {

        final ConversationDetailActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            try
            {
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    avoid = StrictMode.getThreadPolicy();
                    StrictMode.setThreadPolicy((new android.os.StrictMode.ThreadPolicy.Builder(avoid)).permitDiskWrites().build());
                    StrictMode.setThreadPolicy(avoid);
                }
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("mail_comment_tl").append(Utility.BASE_FORMAT).append("?").append(querypopkomen).append("&dens=").append(getResources().getDisplayMetrics().density).toString();
                Log.e("pushURLemail", avoid);
                avoid = HttpPush.getResponse(avoid);
                res = avoid.toString();
                res = res.trim();
                res = res.replaceAll("\\s+", "");
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
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
        }

        public SendMailTask()
        {
            this$0 = ConversationDetailActivity.this;
            super();
        }
    }

    public class TurnOnOffNotifTask extends AsyncTask
    {

        final ConversationDetailActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            avoid = (new ServiceHandler()).makeServiceCall(dataNotifOnOff, 1);
            Log.e("Responseharga: ", (new StringBuilder("> ")).append(avoid).toString());
            if (avoid != null)
            {
                try
                {
                    avoid = new JSONObject(avoid);
                    inponsel = avoid.getJSONArray("InPonsel");
                    suc = avoid.getString("success");
                    messageNotif = avoid.getString("message");
                    kmail_stat = avoid.getString("kmail_stat");
                    Log.e("suc", suc);
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                }
            } else
            {
                Log.e("ServiceHandlerPen", "Couldn't get any data from the url");
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
            itemTurnNotif.setEnabled(true);
            Log.e("kmail_stat", kmail_stat);
            if (kmail_stat.equals("1"))
            {
                itemTurnNotif.setChecked(true);
                return;
            } else
            {
                itemTurnNotif.setChecked(false);
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            itemTurnNotif.setEnabled(false);
        }

        public TurnOnOffNotifTask()
        {
            this$0 = ConversationDetailActivity.this;
            super();
        }
    }


    private static final Pattern NONLATIN = Pattern.compile("[^\\w-]");
    private static int POST_STAT = 0;
    private static final Pattern WHITESPACE = Pattern.compile("[\\s]");
    public static Uri dataurlemail;
    String act;
    String actfrom;
    ActionBar actionBar;
    int actionBarTitleId;
    String bottom_id;
    Button btn_komen_pic;
    Button btn_komenlain;
    Button btn_pop_login;
    Button btn_send_komen;
    int charCount;
    int charCount_list;
    int countAllKom;
    int countKomOld;
    Cursor curRSS;
    Cursor cursor;
    Typeface custom_font;
    String dataNotifOnOff;
    String dataRSS;
    DatabaseHandler db;
    String details;
    Drawable drwEditGaris;
    Drawable drwFlagGaris;
    DroidWriterEditText edt_pop_komen;
    String email_user;
    Bundle extras;
    String fav_stat;
    LinearLayout headName;
    String host;
    String id_artanya;
    String id_artikel;
    String idkom_pos;
    ImageView imageAvatar;
    ImageView imgKomentar;
    ImageView imgKomentar_rep;
    ImageView imgTLContent;
    ImageView img_edit_content;
    ImageView img_flag;
    ImageView img_kom_picture;
    InputMethodManager imm;
    JSONArray inponsel;
    MenuItem itemTurnNotif;
    JSONArray jArray;
    String jum_komen;
    String jum_komen_list;
    String kmail_stat;
    String komencount;
    RelativeLayout lay_pop_komen;
    LinearLayout lay_quote;
    String like_stat;
    ImageView list_img_favorite;
    ImageView list_img_like;
    RelativeLayout list_lay_dislike_kom;
    RelativeLayout list_lay_edit;
    RelativeLayout list_lay_favorite;
    RelativeLayout list_lay_flag;
    RelativeLayout list_lay_kom_kom;
    RelativeLayout list_lay_like;
    RelativeLayout list_lay_like_kom;
    RelativeLayout list_lay_rep_kom;
    RelativeLayout ll_img_komen;
    RelativeLayout ll_img_komen_rep;
    SharedPreferences loginPreference;
    private ArrayList mArrayListData;
    ProgressDialog mDialog;
    private LinearLayout mLinearListView;
    NotificationKomenHelper mNotificationHelper;
    private Transformation mTransformation;
    Menu mainMenu;
    String merk;
    String messageNotif;
    String model;
    LinearLayout myrootlinlist;
    String nama_asli;
    String namalengkap;
    String notif;
    NotificationLikeRSSHelper notificationLikeHelper;
    String passlam;
    PonselBaseApp ponselBaseApp;
    TextView pop_txtCountKomen;
    String postMessage;
    String postMessageAddTL;
    String postMessageContent;
    String postMessageFlagKom;
    String postMessageLikeKom;
    String postMessage_list;
    String postStatus;
    String postStatusAddTL;
    String postStatusContent;
    String postStatusFlagKom;
    String postStatusLikeKom;
    String postStatus_list;
    ProgressBar progressbar_imgTLContent;
    ProgressBar progressbar_imgkomen;
    ProgressBar progressbar_imgkomenrep;
    ProgressBar progressbar_komen;
    ProgressBar progressbar_middle;
    String queryFlag;
    String querylike;
    String querylikeKomen;
    String querypopkomen;
    String res;
    String resFlag;
    String rescontent;
    String reslike;
    String reslikeKomen;
    String resolution;
    String scheme;
    int screenwidth;
    int sdk;
    String statFav;
    String statusKomen;
    String statuslike;
    String strKonekStat;
    String suc;
    String succesStat;
    String t;
    String tl_codename;
    String tl_content;
    String tl_content_ext;
    String tl_date;
    String tl_id;
    String tl_id_hp;
    String tl_id_user;
    int tl_img_height;
    String tl_img_url;
    int tl_img_width;
    String tl_judul;
    String tl_kota;
    String tl_me;
    String tl_tag;
    String tl_type;
    String tl_username;
    String tl_userphoto;
    String top_id;
    String tot_LikeKom;
    String tot_LikePon;
    String tot_LikePon_list;
    String tot_LikeTL;
    String total_like;
    String totdis_LikeKom;
    String totdis_LikePon;
    String totdis_LikePon_list;
    TextView txtForumHashTag;
    TextView txtIdKom;
    TextViewFixTouchConsume txtKomentar;
    TextViewFixTouchConsume txtKomentarQoute;
    TextView txtLabelKomentar;
    TextView txtLikeKom;
    TextView txtLikeKom_list;
    TextView txtTanggapan;
    TextView txtTapImage;
    TextView txtTapImageRep;
    TextView txtUsername;
    TextView txtUsernameQoute;
    TextView txtWaktu;
    TextView txtWaktuQoute;
    TextView txt_empty_komen;
    TextView txt_tl_title;
    TextView txtbencSkor;
    TextView txtbencTitle;
    TextView txtdisLikeKom;
    TextView txtfavoriteKom;
    TextView txthasilfotoTitle;
    TextView txttlSumber;
    TextView txttlTanggal;
    TextView txtweblinkKom;
    String urlGetContent;
    String urlKomen;
    String urlKomenLast;
    String urlKomenOld;
    private boolean useLogo;
    UserFunctions userFunctions;
    String user_id;
    String user_jekel;
    String user_joindate;
    String user_kota;
    String user_photo;
    String user_ponsel1;
    String user_ponsel2;
    String user_profile_update;
    String user_provider1;
    String user_provider2;
    String user_provinsi;
    String user_ttl;
    String username;
    WebView web_tl_srclink;

    public ConversationDetailActivity()
    {
        inponsel = null;
        suc = "";
        actfrom = "";
        resolution = "450";
        t = Utility.session(RestClient.pelihara);
        komencount = "";
        querypopkomen = "";
        reslike = "";
        resFlag = "";
        statFav = "";
        postStatus = "";
        postMessage = "";
        statusKomen = "";
        tot_LikeTL = "0";
        totdis_LikeKom = "0";
        tot_LikePon = "";
        jum_komen = "0";
        dataNotifOnOff = "0";
        postStatusLikeKom = "";
        postMessageLikeKom = "Gagal mengirim";
        postStatusFlagKom = "";
        postMessageFlagKom = "Gagal mengirim";
        user_photo = "";
        username = "";
        querylike = "";
        querylikeKomen = "";
        reslikeKomen = "";
        queryFlag = "";
        id_artikel = "";
        postStatusAddTL = "";
        postMessageAddTL = "";
        postStatusContent = "";
        postMessageContent = "";
        notif = "000";
        tl_img_url = "";
        scheme = "";
        host = "";
        details = "";
        urlGetContent = "";
        rescontent = "";
        act = "";
        urlKomen = "";
        urlKomenOld = "";
        urlKomenLast = "";
        strKonekStat = "";
        bottom_id = "";
        top_id = "0";
        jum_komen_list = "0";
        tot_LikePon_list = "";
        totdis_LikePon_list = "";
        succesStat = "";
        countKomOld = 0;
        countAllKom = 0;
        postStatus_list = "";
        postMessage_list = "";
        tot_LikeKom = "0";
        screenwidth = 1080;
        sdk = android.os.Build.VERSION.SDK_INT;
        messageNotif = "";
        kmail_stat = "";
        useLogo = false;
        actionBarTitleId = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
    }

    private void LoginPopup(String s, String s1)
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle(s);
        builder.setMessage(s1);
        builder.setPositiveButton("Login", new android.content.DialogInterface.OnClickListener() {

            final ConversationDetailActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(ConversationDetailActivity.this, com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                startActivityForResult(dialoginterface, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = ConversationDetailActivity.this;
                super();
            }
        });
        builder.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

            final ConversationDetailActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(ConversationDetailActivity.this, com/inponsel/android/v2/RegisterActivity);
                startActivityForResult(dialoginterface, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = ConversationDetailActivity.this;
                super();
            }
        });
        builder.setNegativeButton("Tutup", new android.content.DialogInterface.OnClickListener() {

            final ConversationDetailActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$0 = ConversationDetailActivity.this;
                super();
            }
        });
        builder.show();
    }

    private void check_image_komen(final RelativeLayout ll_img_komen, final RelativeLayout ll_img_komen_rep, final TextView txtTapImage, final TextView txtTapImageRep, final ImageView imgKomentar, final ImageView imgKomentar_rep, final ProgressBar progressbar_imgkomen, 
            final ProgressBar progressbar_imgkomenrep, final String img_media, final String img_media_to)
    {
        Log.e("img_media", img_media);
        if (img_media.equals("-") || img_media.equals(""))
        {
            txtTapImage.setVisibility(8);
            ll_img_komen.setVisibility(8);
        } else
        {
            txtTapImage.setVisibility(0);
            txtTapImage.setVisibility(8);
            progressbar_imgkomen.setVisibility(0);
            ll_img_komen.setVisibility(0);
        }
        if (img_media_to.equals("-") || img_media_to.equals(""))
        {
            txtTapImageRep.setVisibility(8);
            ll_img_komen_rep.setVisibility(8);
        } else
        {
            ll_img_komen_rep.setVisibility(8);
            txtTapImageRep.setVisibility(0);
        }
        txtTapImage.setOnClickListener(new android.view.View.OnClickListener() {

            final ConversationDetailActivity this$0;
            private final ImageView val$imgKomentar;
            private final String val$img_media;
            private final RelativeLayout val$ll_img_komen;
            private final ProgressBar val$progressbar_imgkomen;
            private final TextView val$txtTapImage;

            public void onClick(View view)
            {
                Log.e("ll_img_komen", img_media);
                txtTapImage.setVisibility(8);
                progressbar_imgkomen.setVisibility(0);
                ll_img_komen.setVisibility(0);
                Picasso.with(getApplicationContext()).load(img_media.trim()).into(imgKomentar, img_media. new Callback() {

                    final _cls23 this$1;
                    private final ImageView val$imgKomentar;
                    private final String val$img_media;
                    private final RelativeLayout val$ll_img_komen;
                    private final ProgressBar val$progressbar_imgkomen;

                    public void onError()
                    {
                        Log.e("ll_img_komen", "onError");
                        progressbar_imgkomen.setVisibility(8);
                        Toast.makeText(getApplicationContext(), "Gagal memuat gambar", 1).show();
                    }

                    public void onSuccess()
                    {
                        Log.e("ll_img_komen", "onSuccess");
                        progressbar_imgkomen.setVisibility(8);
                        imgKomentar.setVisibility(0);
                        ll_img_komen.setClickable(false);
                        imgKomentar.setOnClickListener(img_media. new android.view.View.OnClickListener() {

                            final _cls1 this$2;
                            private final String val$img_media;

                            public void onClick(View view)
                            {
                                view = new ArrayList();
                                Object obj = img_media;
                                obj = ((String) (obj)).substring(((String) (obj)).lastIndexOf("=") + 1);
                                Log.e("img_real", ((String) (obj)));
                                view.add(((String) (obj)).toString().trim());
                                view = (String[])view.toArray(new String[view.size()]);
                                obj = new Intent(getApplicationContext(), com/inponsel/android/v2/ImagePagerActivity);
                                ((Intent) (obj)).putExtra("imgUrl", view);
                                ((Intent) (obj)).putExtra("pos", 0);
                                startActivity(((Intent) (obj)));
                            }

            
            {
                this$2 = final__pcls1;
                img_media = String.this;
                super();
            }
                        });
                    }


            
            {
                this$1 = final__pcls23;
                progressbar_imgkomen = progressbar;
                imgKomentar = imageview;
                ll_img_komen = relativelayout;
                img_media = String.this;
                super();
            }
                });
            }


            
            {
                this$0 = ConversationDetailActivity.this;
                img_media = s;
                txtTapImage = textview;
                progressbar_imgkomen = progressbar;
                ll_img_komen = relativelayout;
                imgKomentar = imageview;
                super();
            }
        });
        txtTapImageRep.setOnClickListener(new android.view.View.OnClickListener() {

            final ConversationDetailActivity this$0;
            private final ImageView val$imgKomentar_rep;
            private final String val$img_media;
            private final String val$img_media_to;
            private final RelativeLayout val$ll_img_komen_rep;
            private final ProgressBar val$progressbar_imgkomenrep;
            private final TextView val$txtTapImageRep;

            public void onClick(View view)
            {
                Log.e("ll_img_komen_rep", img_media);
                ll_img_komen_rep.setVisibility(0);
                txtTapImageRep.setVisibility(8);
                progressbar_imgkomenrep.setVisibility(0);
                try
                {
                    Picasso.with(getApplicationContext()).load(img_media_to.trim()).into(imgKomentar_rep, img_media_to. new Callback() {

                        final _cls24 this$1;
                        private final ImageView val$imgKomentar_rep;
                        private final String val$img_media_to;
                        private final RelativeLayout val$ll_img_komen_rep;
                        private final ProgressBar val$progressbar_imgkomenrep;
                        private final TextView val$txtTapImageRep;

                        public void onError()
                        {
                            Log.e("ll_img_komen_rep", "onError");
                            txtTapImageRep.setVisibility(0);
                            progressbar_imgkomenrep.setVisibility(8);
                            Toast.makeText(getApplicationContext(), "Gagal memuat gambar", 1).show();
                        }

                        public void onSuccess()
                        {
                            Log.e("ll_img_komen_rep", "onSuccess");
                            txtTapImageRep.setVisibility(8);
                            progressbar_imgkomenrep.setVisibility(8);
                            imgKomentar_rep.setVisibility(0);
                            ll_img_komen_rep.setClickable(false);
                            imgKomentar_rep.setOnClickListener(img_media_to. new android.view.View.OnClickListener() {

                                final _cls1 this$2;
                                private final String val$img_media_to;

                                public void onClick(View view)
                                {
                                    view = new ArrayList();
                                    Object obj = img_media_to;
                                    view.add(((String) (obj)).substring(((String) (obj)).lastIndexOf("=") + 1).toString().trim());
                                    view = (String[])view.toArray(new String[view.size()]);
                                    obj = new Intent(getApplicationContext(), com/inponsel/android/v2/ImagePagerActivity);
                                    ((Intent) (obj)).putExtra("imgUrl", view);
                                    ((Intent) (obj)).putExtra("pos", 0);
                                    startActivity(((Intent) (obj)));
                                }

            
            {
                this$2 = final__pcls1;
                img_media_to = String.this;
                super();
            }
                            });
                        }


            
            {
                this$1 = final__pcls24;
                txtTapImageRep = textview;
                progressbar_imgkomenrep = progressbar;
                imgKomentar_rep = imageview;
                ll_img_komen_rep = relativelayout;
                img_media_to = String.this;
                super();
            }
                    });
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    view.printStackTrace();
                }
            }


            
            {
                this$0 = ConversationDetailActivity.this;
                img_media = s;
                ll_img_komen_rep = relativelayout;
                txtTapImageRep = textview;
                progressbar_imgkomenrep = progressbar;
                img_media_to = s1;
                imgKomentar_rep = imageview;
                super();
            }
        });
    }

    private void parseJSONAddFav(String s)
    {
        int i;
        try
        {
            s = new JSONObject(s);
            postStatusAddTL = s.getString("success");
            postMessageAddTL = s.getString("message");
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
            ponselBaseApp.getObserver().setFav_stat_TL(statFav);
            ponselBaseApp.getObserver().setIndexTL(tl_id);
            return;
        }
        i++;
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_44;
        }
    }

    private void setTranslucentStatus(boolean flag)
    {
        Window window = getWindow();
        android.view.WindowManager.LayoutParams layoutparams = window.getAttributes();
        if (flag)
        {
            layoutparams.flags = layoutparams.flags | 0x4000000;
        } else
        {
            layoutparams.flags = layoutparams.flags & 0xfbffffff;
        }
        window.setAttributes(layoutparams);
    }

    public static String toSlug(String s)
    {
        s = Normalizer.normalize(WHITESPACE.matcher(s).replaceAll("-"), java.text.Normalizer.Form.NFD);
        return NONLATIN.matcher(s).replaceAll("").toLowerCase(Locale.ENGLISH);
    }

    public void TurnOnOffNotifTask()
    {
        TurnOnOffNotifTask turnonoffnotiftask;
        loginPreference = getSharedPreferences("com.inponsel.android_preference", 0);
        passlam = EncodeDecodeAES.decrypt(RestClient.pelihara, loginPreference.getString("save", ""));
        passlam = Utility.session(passlam);
        passlam = Utility.session(passlam);
        passlam = Utility.session(passlam);
        passlam = Utility.session(passlam);
        passlam = Utility.session(passlam);
        Log.e("passlama", passlam);
        dataNotifOnOff = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("user_notif_tlkom").append(Utility.BASE_FORMAT).append("?id_usr=").append(user_id).append("&upass=").append(passlam).append("&ktwmail=").append(statusKomen).append("&tl_id=").append(tl_id).append("&t=").append(t).toString();
        Log.e("dataNotifOnOff", dataNotifOnOff);
        turnonoffnotiftask = new TurnOnOffNotifTask();
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            turnonoffnotiftask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        }
        try
        {
            turnonoffnotiftask.execute(new Void[0]);
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return;
    }

    public String getJSONUrl(String s)
    {
        StringBuilder stringbuilder;
        Object obj;
        stringbuilder = new StringBuilder();
        obj = new DefaultHttpClient();
        s = new HttpGet(s);
        s = ((HttpClient) (obj)).execute(s);
        if (s.getStatusLine().getStatusCode() != 200)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        s = new BufferedReader(new InputStreamReader(s.getEntity().getContent()));
_L3:
        obj = s.readLine();
        if (obj != null) goto _L2; else goto _L1
_L1:
        return stringbuilder.toString();
_L2:
        stringbuilder.append(((String) (obj)));
          goto _L3
        try
        {
            Log.e("Log", "Failed to download file..");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
          goto _L1
    }

    protected void onCreate(Bundle bundle)
    {
        dataurlemail = getIntent().getData();
        Log.e("dataurlemail", String.valueOf(dataurlemail));
        extras = getIntent().getExtras();
        if (!String.valueOf(dataurlemail).equals("null") || extras.getString("act").equals("gcm"))
        {
            actionBar = getSupportActionBar();
            actionBar.setDisplayUseLogoEnabled(useLogo);
            actionBar.setBackgroundDrawable(getResources().getDrawable(0x7f0200e6));
            int l = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
            int i = l;
            if (l == 0)
            {
                i = 0x7f0b0037;
            }
            TextView textview = (TextView)findViewById(i);
            textview.setSelected(true);
            textview.setTextColor(Color.parseColor("#FFFFFF"));
            textview.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        } else
        {
            tl_img_url = extras.getString("tl_img_url");
            actionBar = getSupportActionBar();
            actionBar.setDisplayUseLogoEnabled(useLogo);
            actionBar.setBackgroundDrawable(getResources().getDrawable(0x7f0200e6));
            int i1 = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
            int j = i1;
            if (i1 == 0)
            {
                j = 0x7f0b0037;
            }
            TextView textview1 = (TextView)findViewById(j);
            textview1.setSelected(true);
            textview1.setTextColor(Color.parseColor("#FFFFFF"));
            textview1.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        }
        super.onCreate(bundle);
        setContentView(0x7f0300cd);
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            setTranslucentStatus(true);
        }
        bundle = new SystemBarTintManager(this);
        bundle.setStatusBarTintEnabled(true);
        bundle.setStatusBarTintResource(0x7f08018a);
        mTransformation = (new RoundedTransformationBuilder()).borderColor(0).borderWidthDp(0.0F).cornerRadiusDp(5F).oval(false).build();
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
        resolution = extras.getString("resolution");
        drwEditGaris = getResources().getDrawable(0x7f0201aa);
        drwEditGaris.setColorFilter(Color.parseColor("#FF795548"), android.graphics.PorterDuff.Mode.SRC_ATOP);
        drwFlagGaris = getResources().getDrawable(0x7f0201b5);
        drwFlagGaris.setColorFilter(getResources().getColor(0x7f08017c), android.graphics.PorterDuff.Mode.SRC_ATOP);
        if (!String.valueOf(dataurlemail).equals("null"))
        {
            scheme = dataurlemail.getScheme();
            host = dataurlemail.getHost();
            tl_id = (String)dataurlemail.getPathSegments().get(1);
            tl_judul = "";
            notif = "email";
            Log.e("scheme", scheme);
            Log.e("host", host);
        } else
        {
            tl_id = extras.getString("tl_id");
            tl_judul = extras.getString("tl_judul");
        }
        notificationLikeHelper = new NotificationLikeRSSHelper(this);
        t = Utility.session(t);
        myrootlinlist = (LinearLayout)findViewById(0x7f0b0789);
        progressbar_middle = (ProgressBar)findViewById(0x7f0b00ca);
        t = Utility.session(t);
        ponselBaseApp = (PonselBaseApp)getApplication();
        ponselBaseApp.getObserver().addObserver(this);
        mNotificationHelper = new NotificationKomenHelper(this);
        progressbar_imgTLContent = (ProgressBar)findViewById(0x7f0b0658);
        progressbar_imgTLContent.setVisibility(8);
        imageAvatar = (ImageView)findViewById(0x7f0b05e3);
        btn_send_komen = (Button)findViewById(0x7f0b04e0);
        edt_pop_komen = (DroidWriterEditText)findViewById(0x7f0b04de);
        lay_pop_komen = (RelativeLayout)findViewById(0x7f0b04da);
        btn_pop_login = (Button)findViewById(0x7f0b04e1);
        pop_txtCountKomen = (TextView)findViewById(0x7f0b04df);
        txt_empty_komen = (TextView)findViewById(0x7f0b066e);
        btn_komenlain = (Button)findViewById(0x7f0b066f);
        progressbar_komen = (ProgressBar)findViewById(0x7f0b066d);
        mLinearListView = (LinearLayout)findViewById(0x7f0b04d8);
        mArrayListData = new ArrayList();
        txt_tl_title = (TextView)findViewById(0x7f0b065f);
        txt_tl_title.setTextColor(getResources().getColor(0x7f08017f));
        txttlTanggal = (TextView)findViewById(0x7f0b065d);
        txttlSumber = (TextView)findViewById(0x7f0b065c);
        web_tl_srclink = (WebView)findViewById(0x7f0b0662);
        web_tl_srclink.setBackgroundColor(getResources().getColor(0x7f080175));
        txtLabelKomentar = (TextView)findViewById(0x7f0b066c);
        txtLikeKom = (TextView)findViewById(0x7f0b0551);
        txtbencTitle = (TextView)findViewById(0x7f0b0659);
        txtbencSkor = (TextView)findViewById(0x7f0b0660);
        txthasilfotoTitle = (TextView)findViewById(0x7f0b0661);
        txtForumHashTag = (TextView)findViewById(0x7f0b05f3);
        txtfavoriteKom = (TextView)findViewById(0x7f0b0666);
        txtweblinkKom = (TextView)findViewById(0x7f0b0784);
        list_img_like = (ImageView)findViewById(0x7f0b054f);
        list_img_favorite = (ImageView)findViewById(0x7f0b05f1);
        img_edit_content = (ImageView)findViewById(0x7f0b066a);
        img_flag = (ImageView)findViewById(0x7f0b0668);
        list_lay_like = (RelativeLayout)findViewById(0x7f0b0342);
        list_lay_favorite = (RelativeLayout)findViewById(0x7f0b0665);
        list_lay_flag = (RelativeLayout)findViewById(0x7f0b05ee);
        list_lay_edit = (RelativeLayout)findViewById(0x7f0b0669);
        if (sdk < 16)
        {
            img_edit_content.setBackgroundDrawable(drwEditGaris);
        } else
        {
            img_edit_content.setBackground(drwEditGaris);
        }
        if (sdk < 16)
        {
            img_flag.setBackgroundDrawable(drwFlagGaris);
        } else
        {
            img_flag.setBackground(drwFlagGaris);
        }
        userFunctions = new UserFunctions();
        db = new DatabaseHandler(this);
        imm = (InputMethodManager)getSystemService("input_method");
        imgTLContent = (ImageView)findViewById(0x7f0b00a4);
        if (userFunctions.isUserLoggedIn(this))
        {
            btn_send_komen.setVisibility(0);
            btn_pop_login.setVisibility(8);
            edt_pop_komen.setVisibility(0);
            lay_pop_komen.setVisibility(0);
            cursor = db.getAllData();
            cursor.moveToFirst();
            int k;
            int j1;
            try
            {
                user_id = EncodeDecodeAES.decrypt(RestClient.pelihara, cursor.getString(1));
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle) { }
            nama_asli = cursor.getString(2);
            username = cursor.getString(4);
            email_user = cursor.getString(5);
            user_ttl = cursor.getString(6);
            user_provinsi = cursor.getString(7);
            user_kota = cursor.getString(8);
            user_jekel = cursor.getString(9);
            user_ponsel1 = cursor.getString(10);
            user_ponsel2 = cursor.getString(11);
            user_provider1 = cursor.getString(12);
            user_provider2 = cursor.getString(13);
            user_joindate = cursor.getString(14);
            user_profile_update = cursor.getString(15);
            cursor.close();
        } else
        {
            btn_send_komen.setVisibility(8);
            btn_pop_login.setVisibility(0);
            edt_pop_komen.setVisibility(8);
            pop_txtCountKomen.setVisibility(8);
            lay_pop_komen.setVisibility(8);
        }
        web_tl_srclink.setWebViewClient(new WebViewClient() {

            final ConversationDetailActivity this$0;

            public boolean shouldOverrideUrlLoading(WebView webview, String s)
            {
                if (s.endsWith("</iframe>") || s.endsWith(".flv") || s.endsWith("wmv") || s.endsWith("avi"))
                {
                    webview = new Intent("android.intent.action.VIEW");
                    webview.setData(Uri.parse(s));
                    startActivity(webview);
                    return true;
                }
                if (s != null && s.startsWith("http://"))
                {
                    webview.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(s)));
                    return true;
                } else
                {
                    return false;
                }
            }

            
            {
                this$0 = ConversationDetailActivity.this;
                super();
            }
        });
        if (!String.valueOf(dataurlemail).equals("null"))
        {
            urlGetContent = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("get_forum_content").append(Utility.BASE_FORMAT).append("?id=").append(tl_id).append("&id_user=").append(user_id).append("&t=").append(t).toString();
            Log.e("urlGetContent", urlGetContent);
            (new GetForumContent()).execute(new Void[0]);
        } else
        if (extras.getString("act").equals("gcm"))
        {
            tl_id = extras.getString("tl_id");
            tl_judul = extras.getString("tl_judul");
            urlGetContent = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("get_forum_content").append(Utility.BASE_FORMAT).append("?id=").append(tl_id).append("&id_user=").append(user_id).append("&t=").append(t).toString();
            Log.e("urlGetContentGCM", urlGetContent);
            (new GetForumContent()).execute(new Void[0]);
        } else
        if (extras.getString("act").equals("fav"))
        {
            tl_id = extras.getString("tl_id");
            tl_judul = extras.getString("tl_judul");
            tl_content = extras.getString("tl_content");
            tl_content_ext = extras.getString("tl_content_ext");
            tl_codename = extras.getString("tl_codename");
            tl_date = extras.getString("tl_date");
            tl_id = extras.getString("tl_id");
            tl_id_hp = extras.getString("tl_id_hp");
            tl_id_user = extras.getString("tl_id_user");
            tl_img_url = extras.getString("tl_img_url");
            tl_tag = extras.getString("tl_tag");
            tl_type = extras.getString("tl_type");
            tl_username = extras.getString("tl_username");
            tl_kota = extras.getString("tl_kota");
            tl_img_height = extras.getInt("tl_img_height");
            tl_img_width = extras.getInt("tl_img_width");
            tl_userphoto = extras.getString("tl_userphoto");
            total_like = extras.getString("total_like");
            fav_stat = extras.getString("fav_stat");
            like_stat = extras.getString("like_stat");
            try
            {
                Picasso.with(this).load((new StringBuilder(String.valueOf(Util.BASE_URL_THUMB_ORI))).append("w=").append(200).append("&src=").append(tl_userphoto).toString()).transform(mTransformation).into(imageAvatar, new Callback() {

                    final ConversationDetailActivity this$0;

                    public void onError()
                    {
                    }

                    public void onSuccess()
                    {
                    }

            
            {
                this$0 = ConversationDetailActivity.this;
                super();
            }
                });
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                bundle.printStackTrace();
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
                bundle = tl_content_ext.split("-");
                Log.e("tl_content_ext", tl_content_ext);
                txthasilfotoTitle.setText((new StringBuilder("#")).append(bundle[0].trim()).append("\n").append("#").append(bundle[1].trim()).toString());
            } else
            {
                txthasilfotoTitle.setVisibility(8);
            }
            if (tl_type.equals("benchmark"))
            {
                txt_tl_title.setText(Html.fromHtml((new StringBuilder(String.valueOf(tl_judul))).append(" - ").append(tl_tag).toString()));
            } else
            {
                txt_tl_title.setText(Html.fromHtml(tl_judul));
            }
            if (tl_id_hp.equals("0") || tl_id_hp.equals(""))
            {
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
                    txtForumHashTag.setVisibility(0);
                }
            } else
            {
                txtForumHashTag.setVisibility(8);
            }
            urlGetContent = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("get_forum_content").append(Utility.BASE_FORMAT).append("?id=").append(tl_id).append("&id_user=").append(user_id).append("&t=").append(t).toString();
            (new GetForumContent()).execute(new Void[0]);
        } else
        {
            tl_id = extras.getString("tl_id");
            tl_judul = extras.getString("tl_judul");
            tl_content = extras.getString("tl_content");
            tl_content_ext = extras.getString("tl_content_ext");
            tl_codename = extras.getString("tl_codename");
            tl_date = extras.getString("tl_date");
            tl_id = extras.getString("tl_id");
            tl_id_hp = extras.getString("tl_id_hp");
            tl_id_user = extras.getString("tl_id_user");
            tl_img_url = extras.getString("tl_img_url");
            tl_tag = extras.getString("tl_tag");
            tl_type = extras.getString("tl_type");
            tl_username = extras.getString("tl_username");
            tl_kota = extras.getString("tl_kota");
            tl_userphoto = extras.getString("tl_userphoto");
            total_like = extras.getString("total_like");
            fav_stat = extras.getString("fav_stat");
            like_stat = extras.getString("like_stat");
            if (tl_type.equals("artikel") && tl_id_user.equals(user_id))
            {
                list_lay_edit.setVisibility(0);
            } else
            {
                list_lay_edit.setVisibility(8);
            }
            Log.e("tl_type", tl_type);
            Log.e("tl_content_ext", tl_content_ext);
            Log.e("tl_tag", tl_tag);
            idkom_pos = tl_id;
            id_artikel = tl_id;
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
                bundle = tl_content_ext.trim().split("-");
                Log.e("tl_content_ext", tl_content_ext);
                txthasilfotoTitle.setText((new StringBuilder("#")).append(bundle[0].trim()).append("\n").append("#").append(bundle[1].trim()).toString());
            } else
            {
                txthasilfotoTitle.setVisibility(8);
            }
            if (tl_id_hp.equals("0") || tl_id_hp.equals(""))
            {
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
            urlGetContent = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("get_forum_content").append(Utility.BASE_FORMAT).append("?id=").append(tl_id).append("&id_user=").append(user_id).append("&t=").append(t).toString();
            (new GetForumContent()).execute(new Void[0]);
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
            if (!tl_img_url.equals(""))
            {
                progressbar_imgTLContent.setVisibility(0);
                bundle = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(bundle);
                k = ((DisplayMetrics) (bundle)).widthPixels;
                j1 = ((DisplayMetrics) (bundle)).heightPixels;
                screenwidth = k;
                Log.e("scrwh", (new StringBuilder(String.valueOf(String.valueOf(k)))).append("x").append(String.valueOf(j1)).toString());
                Log.e("wh", (new StringBuilder(String.valueOf(String.valueOf(tl_img_width)))).append("x").append(String.valueOf(tl_img_height)).toString());
                Log.e("whif", (new StringBuilder(String.valueOf(String.valueOf(k)))).append("x").append(String.valueOf(j1)).toString());
                bundle = new android.widget.FrameLayout.LayoutParams(-1, -2);
                imgTLContent.setLayoutParams(bundle);
                try
                {
                    Picasso.with(this).load((new StringBuilder(String.valueOf(Util.BASE_URL_THUMB_ORI))).append("w=").append(k).append("&src=").append(tl_img_url).toString()).into(imgTLContent, new Callback() {

                        final ConversationDetailActivity this$0;

                        public void onError()
                        {
                            imgTLContent.setImageResource(0x7f0201b8);
                        }

                        public void onSuccess()
                        {
                            progressbar_imgTLContent.setVisibility(8);
                        }

            
            {
                this$0 = ConversationDetailActivity.this;
                super();
            }
                    });
                }
                // Misplaced declaration of an exception variable
                catch (Bundle bundle)
                {
                    bundle.printStackTrace();
                }
            }
            web_tl_srclink.getSettings().setJavaScriptEnabled(true);
            web_tl_srclink.loadDataWithBaseURL("", (new StringBuilder("<style>img{display: inline;height: auto;max-width: 100%;} iframe{display: inline;height: auto;max-width: 100%;}</style>")).append(tl_content).toString(), "text/html", "UTF-8", "");
        }
        imgTLContent.setOnClickListener(new android.view.View.OnClickListener() {

            final ConversationDetailActivity this$0;

            public void onClick(View view)
            {
                view = new ArrayList();
                view.add((new StringBuilder(String.valueOf(Util.BASE_URL_THUMB_ORI))).append("w=").append(screenwidth).append("&src=").append(tl_img_url.trim()).toString());
                view = (String[])view.toArray(new String[view.size()]);
                Intent intent = new Intent(ConversationDetailActivity.this, com/inponsel/android/v2/ImagePagerActivity);
                intent.putExtra("imgUrl", view);
                intent.putExtra("pos", 0);
                startActivity(intent);
            }

            
            {
                this$0 = ConversationDetailActivity.this;
                super();
            }
        });
        list_lay_edit.setOnClickListener(new android.view.View.OnClickListener() {

            final ConversationDetailActivity this$0;

            public void onClick(View view)
            {
                view = new Intent(ConversationDetailActivity.this, com/inponsel/android/v2/RoomPostArtikel);
                view.putExtra("action", "edit");
                view.putExtra("namalengkap", namalengkap);
                view.putExtra("id_artanya", idkom_pos);
                view.putExtra("act", "first");
                view.putExtra("tl_judul", tl_judul);
                view.putExtra("tl_content", tl_content);
                view.putExtra("tl_content_ext", tl_content_ext);
                view.putExtra("tl_codename", tl_codename);
                view.putExtra("tl_date", tl_date);
                view.putExtra("tl_id", tl_id);
                view.putExtra("tl_id_hp", tl_id_hp);
                view.putExtra("tl_id_user", tl_id_user);
                view.putExtra("tl_img_url", tl_img_url);
                view.putExtra("tl_tag", tl_tag);
                view.putExtra("tl_type", tl_type);
                view.putExtra("tl_username", tl_username);
                view.putExtra("tl_userphoto", tl_userphoto);
                view.putExtra("total_like", total_like);
                view.putExtra("fav_stat", fav_stat);
                view.putExtra("like_stat", like_stat);
                view.putExtra("namalengkap", namalengkap);
                view.putExtra("model", model);
                view.putExtra("merk", merk);
                Log.e("tl_judul", tl_judul);
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
                finish();
            }

            
            {
                this$0 = ConversationDetailActivity.this;
                super();
            }
        });
        list_lay_favorite.setOnClickListener(new android.view.View.OnClickListener() {

            final ConversationDetailActivity this$0;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(ConversationDetailActivity.this))
                {
                    if (db.checkTimelineExist(id_artikel) || fav_stat.equals("1"))
                    {
                        view = new android.app.AlertDialog.Builder(ConversationDetailActivity.this);
                        if (tl_type.equals("faqhp"))
                        {
                            view.setMessage("Hapus pertanyaan ini dari favorit?");
                        } else
                        {
                            view.setMessage("Hapus artikel ini dari favorit?");
                        }
                        view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                            final _cls6 this$1;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                                statFav = "0";
                                (new FavoritTask()).execute(new Void[0]);
                            }

            
            {
                this$1 = _cls6.this;
                super();
            }
                        });
                        view.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                            final _cls6 this$1;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$1 = _cls6.this;
                super();
            }
                        });
                        view.show();
                        return;
                    }
                    view = new android.app.AlertDialog.Builder(ConversationDetailActivity.this);
                    if (tl_type.equals("faqhp"))
                    {
                        view.setMessage("Favoritkan pertanyaan ini?");
                    } else
                    {
                        view.setMessage("Favoritkan artikel ini?");
                    }
                    view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                        final _cls6 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            statFav = "1";
                            (new FavoritTask()).execute(new Void[0]);
                        }

            
            {
                this$1 = _cls6.this;
                super();
            }
                    });
                    view.setNeutralButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                        final _cls6 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls6.this;
                super();
            }
                    });
                    view.show();
                    return;
                } else
                {
                    view = new android.app.AlertDialog.Builder(ConversationDetailActivity.this);
                    view.setMessage("Untuk menambahkan ke favorit harus login terlebih dahulu.");
                    view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                        final _cls6 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls6.this;
                super();
            }
                    });
                    view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls6 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                            startActivity(dialoginterface);
                        }

            
            {
                this$1 = _cls6.this;
                super();
            }
                    });
                    view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls6 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            startActivity(dialoginterface);
                        }

            
            {
                this$1 = _cls6.this;
                super();
            }
                    });
                    view.show();
                    return;
                }
            }


            
            {
                this$0 = ConversationDetailActivity.this;
                super();
            }
        });
        list_lay_like.setOnClickListener(new android.view.View.OnClickListener() {

            final ConversationDetailActivity this$0;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(ConversationDetailActivity.this))
                {
                    statuslike = "1";
                    querylike = (new StringBuilder("status=")).append(statuslike).append("&tl_id=").append(id_artikel).append("&id_usr=").append(user_id).append("&type=").append(tl_type).append("&t=").append(t).toString();
                    Log.e("querylike", querylike);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new PostBagusKurangTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                        return;
                    } else
                    {
                        (new PostBagusKurangTask()).execute(new Void[0]);
                        return;
                    }
                } else
                {
                    LoginPopup("Perhatian", "Untuk memberi penilaian harus login terlebih dahulu.");
                    return;
                }
            }

            
            {
                this$0 = ConversationDetailActivity.this;
                super();
            }
        });
        list_lay_flag.setOnClickListener(new android.view.View.OnClickListener() {

            final ConversationDetailActivity this$0;

            public void onClick(View view)
            {
                view = new android.app.AlertDialog.Builder(ConversationDetailActivity.this);
                view.setMessage("Laporkan konten ini karena tidak sesuai atau mengandung SARA?");
                view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                    final _cls8 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        if (userFunctions.isUserLoggedIn(_fld0))
                        {
                            queryFlag = (new StringBuilder("id_artanya=")).append(idkom_pos).append("&id_usr=").append(user_id).append("&type=").append(tl_type).append("&t=").append(t).toString();
                            Log.e("queryFlag", queryFlag);
                            if (android.os.Build.VERSION.SDK_INT >= 11)
                            {
                                (new PostFlagTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                                return;
                            } else
                            {
                                (new PostFlagTask()).execute(new Void[0]);
                                return;
                            }
                        } else
                        {
                            dialoginterface = new android.app.AlertDialog.Builder(_fld0);
                            dialoginterface.setMessage("Untuk memberi laporan harus login terlebih dahulu.");
                            dialoginterface.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                                final _cls1 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = _cls1.this;
                super();
            }
                            });
                            dialoginterface.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                                final _cls1 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                                    startActivity(dialoginterface);
                                }

            
            {
                this$2 = _cls1.this;
                super();
            }
                            });
                            dialoginterface.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                                final _cls1 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                                    dialoginterface.putExtra("activity", "main");
                                    startActivity(dialoginterface);
                                }

            
            {
                this$2 = _cls1.this;
                super();
            }
                            });
                            dialoginterface.show();
                            return;
                        }
                    }


            
            {
                this$1 = _cls8.this;
                super();
            }
                });
                view.setNegativeButton("Batal", new android.content.DialogInterface.OnClickListener() {

                    final _cls8 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface.dismiss();
                    }

            
            {
                this$1 = _cls8.this;
                super();
            }
                });
                view.show();
            }


            
            {
                this$0 = ConversationDetailActivity.this;
                super();
            }
        });
        btn_pop_login.setOnClickListener(new android.view.View.OnClickListener() {

            final ConversationDetailActivity this$0;

            public void onClick(View view)
            {
                view = new Intent(ConversationDetailActivity.this, com/inponsel/android/v2/LoginActivity);
                view.putExtra("activity", "main");
                startActivity(view);
            }

            
            {
                this$0 = ConversationDetailActivity.this;
                super();
            }
        });
        btn_send_komen.setEnabled(false);
        edt_pop_komen.addTextChangedListener(new TextWatcher() {

            final ConversationDetailActivity this$0;

            public void afterTextChanged(Editable editable)
            {
                if (edt_pop_komen.getText().toString().trim().length() == 0)
                {
                    btn_send_komen.setEnabled(false);
                    pop_txtCountKomen.setText("512");
                    return;
                }
                btn_send_komen.setEnabled(true);
                charCount = 512 - edt_pop_komen.getText().toString().length();
                komencount = edt_pop_komen.getText().toString();
                if (charCount < 0)
                {
                    btn_send_komen.setEnabled(false);
                } else
                if (charCount > 0 && charCount < 4)
                {
                    btn_send_komen.setEnabled(false);
                } else
                {
                    btn_send_komen.setEnabled(true);
                }
                pop_txtCountKomen.setText(String.valueOf(charCount));
            }

            public void beforeTextChanged(CharSequence charsequence, int k1, int l1, int i2)
            {
                if (edt_pop_komen.getText().toString().trim().length() == 0)
                {
                    btn_send_komen.setEnabled(false);
                    pop_txtCountKomen.setText("512");
                    return;
                }
                btn_send_komen.setEnabled(true);
                charCount = 512 - edt_pop_komen.getText().toString().length();
                komencount = edt_pop_komen.getText().toString();
                if (charCount < 0)
                {
                    btn_send_komen.setEnabled(false);
                } else
                if (charCount > 0 && charCount < 4)
                {
                    btn_send_komen.setEnabled(false);
                } else
                {
                    btn_send_komen.setEnabled(true);
                }
                pop_txtCountKomen.setText(String.valueOf(charCount));
            }

            public void onTextChanged(CharSequence charsequence, int k1, int l1, int i2)
            {
                komencount = edt_pop_komen.getText().toString();
                if (edt_pop_komen.getText().toString().trim().length() == 0)
                {
                    btn_send_komen.setEnabled(false);
                    pop_txtCountKomen.setText("512");
                    return;
                }
                btn_send_komen.setEnabled(true);
                charCount = 512 - edt_pop_komen.getText().toString().length();
                if (charCount < 0)
                {
                    btn_send_komen.setEnabled(false);
                } else
                if (charCount > 0 && charCount < 4)
                {
                    btn_send_komen.setEnabled(false);
                } else
                {
                    btn_send_komen.setEnabled(true);
                }
                pop_txtCountKomen.setText(String.valueOf(charCount));
            }

            
            {
                this$0 = ConversationDetailActivity.this;
                super();
            }
        });
        btn_send_komen.setOnClickListener(new android.view.View.OnClickListener() {

            final ConversationDetailActivity this$0;

            public void onClick(View view)
            {
                try
                {
                    view = URLEncoder.encode(edt_pop_komen.getText().toString(), "utf-8");
                    Log.e("top_id", "0");
                    querypopkomen = (new StringBuilder("rplto=0&komen=")).append(view).append("&tl_id=").append(tl_id).append("&type=").append(tl_type).append("&top_id=").append(top_id).append("&t=").append(t).append("&id_usr=").append(user_id).toString();
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    view.printStackTrace();
                }
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new PostKomen()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new PostKomen()).execute(new Void[0]);
                    return;
                }
            }

            
            {
                this$0 = ConversationDetailActivity.this;
                super();
            }
        });
        progressbar_middle.setVisibility(8);
        Log.e("checkIfExistRSS", "exist");
        try
        {
            urlKomen = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_list_forum3").append(Utility.BASE_FORMAT).append("?id=").append(tl_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&sortkom=").append("12").toString();
            Log.e("urlKomen", urlKomen);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle) { }
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            (new KomentarAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        } else
        {
            (new KomentarAsycTask()).execute(new String[0]);
        }
        btn_komenlain.setOnClickListener(new android.view.View.OnClickListener() {

            final ConversationDetailActivity this$0;

            public void onClick(View view)
            {
                view = new Intent(ConversationDetailActivity.this, com/inponsel/android/timelinedetail/TLKomenTab);
                view.putExtra("id_artanya", id_artikel);
                view.putExtra("act", "komen");
                view.putExtra("tl_judul", tl_judul);
                view.putExtra("tl_content", tl_content);
                view.putExtra("tl_content_ext", tl_content_ext);
                view.putExtra("tl_codename", tl_codename);
                view.putExtra("tl_date", tl_date);
                view.putExtra("tl_id", tl_id);
                view.putExtra("tl_id_hp", tl_id_hp);
                view.putExtra("tl_id_user", tl_id_user);
                view.putExtra("tl_img_url", tl_img_url);
                view.putExtra("tl_tag", tl_tag);
                view.putExtra("tl_type", tl_type);
                view.putExtra("tl_username", tl_username);
                view.putExtra("tl_userphoto", tl_userphoto);
                view.putExtra("total_like", total_like);
                view.putExtra("fav_stat", fav_stat);
                view.putExtra("like_stat", like_stat);
                view.putExtra("namalengkap", namalengkap);
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = ConversationDetailActivity.this;
                super();
            }
        });
        try
        {
            bundle = ((PonselBaseApp)getApplication()).getTracker(com.inponsel.android.adapter.PonselBaseApp.TrackerName.APP_TRACKER);
            bundle.setScreenName((new StringBuilder("Forum ")).append(namalengkap).append(" ").append(tl_judul).toString());
            bundle.send((new com.google.android.gms.analytics.HitBuilders.AppViewBuilder()).build());
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        btn_komen_pic = (Button)findViewById(0x7f0b053a);
        btn_komen_pic.setOnClickListener(new android.view.View.OnClickListener() {

            final ConversationDetailActivity this$0;

            public void onClick(View view)
            {
                view = new Intent(ConversationDetailActivity.this, com/inponsel/android/v2/AddKomentarPicture);
                view.putExtra("komen_type", "conversation");
                view.putExtra("forum_id", tl_id);
                view.putExtra("tl_judul", tl_judul);
                view.putExtra("top_id", top_id);
                view.putExtra("tl_type", tl_type);
                startActivityForResult(view, ConversationDetailActivity.POST_STAT);
            }

            
            {
                this$0 = ConversationDetailActivity.this;
                super();
            }
        });
        (new Handler()).postDelayed(new Runnable() {

            final ConversationDetailActivity this$0;

            public void run()
            {
                (new PostHits()).execute(new Void[0]);
            }

            
            {
                this$0 = ConversationDetailActivity.this;
                super();
            }
        }, 3000L);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getSupportMenuInflater().inflate(0x7f0f000f, menu);
        mainMenu = menu;
        itemTurnNotif = menu.findItem(0x7f0b0941);
        Log.e("statusKomenmenu", statusKomen);
        if (statusKomen.equals("1"))
        {
            itemTurnNotif.setChecked(true);
            return true;
        } else
        {
            itemTurnNotif.setChecked(false);
            return true;
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        menuitem.getItemId();
        JVM INSTR lookupswitch 2: default 32
    //                   16908332: 38
    //                   2131429697: 55;
           goto _L1 _L2 _L3
_L1:
        return super.onOptionsItemSelected(menuitem);
_L2:
        finish();
        overridePendingTransition(0x7f040001, 0x7f040002);
        continue; /* Loop/switch isn't completed */
_L3:
        if (userFunctions.isUserLoggedIn(this))
        {
            (new StringBuilder("Aktifkan notifikasi komentar untuk ")).append(tl_judul).append(" ?").toString();
            String s;
            android.app.AlertDialog.Builder builder1;
            if (itemTurnNotif.isChecked())
            {
                statusKomen = "0";
                s = (new StringBuilder("Non aktifkan notifikasi komentar untuk ")).append(tl_judul).append(" ?").toString();
            } else
            {
                statusKomen = "1";
                s = (new StringBuilder("Aktifkan notifikasi komentar untuk ")).append(tl_judul).append(" ?").toString();
            }
            Log.e("statusKomen", statusKomen);
            builder1 = new android.app.AlertDialog.Builder(this);
            builder1.setTitle("Perhatian");
            builder1.setMessage(s);
            builder1.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                final ConversationDetailActivity this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                    TurnOnOffNotifTask();
                }

            
            {
                this$0 = ConversationDetailActivity.this;
                super();
            }
            });
            builder1.setNegativeButton("Batal", new android.content.DialogInterface.OnClickListener() {

                final ConversationDetailActivity this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    if (itemTurnNotif.isChecked())
                    {
                        itemTurnNotif.setChecked(true);
                    } else
                    {
                        itemTurnNotif.setChecked(false);
                    }
                    dialoginterface.dismiss();
                }

            
            {
                this$0 = ConversationDetailActivity.this;
                super();
            }
            });
            builder1.show();
        } else
        {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            builder.setMessage("Untuk mengaktifkan notifikasi komentar harus login terlebih dahulu.");
            builder.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                final ConversationDetailActivity this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$0 = ConversationDetailActivity.this;
                super();
            }
            });
            builder.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                final ConversationDetailActivity this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(ConversationDetailActivity.this, com/inponsel/android/v2/RegisterActivity);
                    startActivity(dialoginterface);
                }

            
            {
                this$0 = ConversationDetailActivity.this;
                super();
            }
            });
            builder.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                final ConversationDetailActivity this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(ConversationDetailActivity.this, com/inponsel/android/v2/LoginActivity);
                    dialoginterface.putExtra("activity", "main");
                    startActivity(dialoginterface);
                }

            
            {
                this$0 = ConversationDetailActivity.this;
                super();
            }
            });
            builder.show();
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void onPause()
    {
        super.onPause();
        try
        {
            Class.forName("android.webkit.WebView").getMethod("onPause", null).invoke(web_tl_srclink, null);
            return;
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            return;
        }
        catch (NoSuchMethodException nosuchmethodexception)
        {
            return;
        }
        catch (InvocationTargetException invocationtargetexception)
        {
            return;
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            return;
        }
    }

    public void update(Observable observable, Object obj)
    {
        userFunctions = new UserFunctions();
        if (userFunctions.isUserLoggedIn(this))
        {
            btn_send_komen.setVisibility(0);
            btn_pop_login.setVisibility(8);
            edt_pop_komen.setVisibility(0);
            lay_pop_komen.setVisibility(0);
            cursor = db.getAllData();
            cursor.moveToFirst();
            try
            {
                user_id = EncodeDecodeAES.decrypt(RestClient.pelihara, cursor.getString(1));
            }
            // Misplaced declaration of an exception variable
            catch (Observable observable) { }
            nama_asli = cursor.getString(2);
            username = cursor.getString(4);
            email_user = cursor.getString(5);
            user_ttl = cursor.getString(6);
            user_provinsi = cursor.getString(7);
            user_kota = cursor.getString(8);
            user_jekel = cursor.getString(9);
            user_ponsel1 = cursor.getString(10);
            user_ponsel2 = cursor.getString(11);
            user_provider1 = cursor.getString(12);
            user_provider2 = cursor.getString(13);
            user_joindate = cursor.getString(14);
            user_profile_update = cursor.getString(15);
            cursor.close();
        } else
        {
            btn_send_komen.setVisibility(8);
            btn_pop_login.setVisibility(0);
            edt_pop_komen.setVisibility(8);
            pop_txtCountKomen.setVisibility(8);
            lay_pop_komen.setVisibility(8);
        }
        if (ponselBaseApp.getObserver().getUpdateType().equals("likertl"))
        {
            txtLikeKom.setText(ponselBaseApp.getObserver().getTot_LikeTL());
            list_img_like.setBackgroundResource(0x7f02020d);
        } else
        {
            if (ponselBaseApp.getObserver().getUpdateType().equals("favtl"))
            {
                if (ponselBaseApp.getObserver().getFav_stat_TL().toString().equals("1"))
                {
                    list_img_favorite.setBackgroundResource(0x7f02023b);
                    return;
                } else
                {
                    list_img_favorite.setBackgroundResource(0x7f02023a);
                    return;
                }
            }
            if (ponselBaseApp.getObserver().getUpdateType().equals("komentarconv"))
            {
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new KomentarAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                    return;
                } else
                {
                    (new KomentarAsycTask()).execute(new String[0]);
                    return;
                }
            }
        }
    }

    public void updateViewLikeDis(String s)
    {
        int i;
        Log.e("id_kom", s);
        Log.e("mLinearListView", String.valueOf(mLinearListView.getChildCount()));
        i = 0;
_L2:
        ImageView imageview;
        ImageView imageview1;
        RelativeLayout relativelayout;
        Object obj;
        if (i >= mLinearListView.getChildCount())
        {
            return;
        }
        obj = mLinearListView.getChildAt(i);
        TextView textview = (TextView)((View) (obj)).findViewById(0x7f0b054d);
        TextView textview1 = (TextView)((View) (obj)).findViewById(0x7f0b0551);
        TextView textview2 = (TextView)((View) (obj)).findViewById(0x7f0b0554);
        imageview = (ImageView)((View) (obj)).findViewById(0x7f0b054f);
        imageview1 = (ImageView)((View) (obj)).findViewById(0x7f0b0552);
        relativelayout = (RelativeLayout)((View) (obj)).findViewById(0x7f0b0342);
        obj = (RelativeLayout)((View) (obj)).findViewById(0x7f0b0345);
        if (textview.getText().toString().equals(s))
        {
            textview1.setText(tot_LikeKom);
            textview2.setText(totdis_LikeKom);
            if (!statuslike.equals("1"))
            {
                break; /* Loop/switch isn't completed */
            }
            imageview.setBackgroundResource(0x7f02025b);
            imageview1.setBackgroundResource(0x7f0201a3);
            relativelayout.setEnabled(false);
            ((RelativeLayout) (obj)).setEnabled(true);
        }
_L4:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        if (!statuslike.equals("0")) goto _L4; else goto _L3
_L3:
        imageview.setBackgroundResource(0x7f020257);
        imageview1.setBackgroundResource(0x7f0201a7);
        relativelayout.setEnabled(true);
        ((RelativeLayout) (obj)).setEnabled(false);
          goto _L4
    }









}
