// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.pencariangen;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.Html;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.actionbarsherlock.app.SherlockFragment;
import com.android.volley.VolleyError;
import com.inponsel.android.adapter.ItemRSS;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.rssfeeddetail.RSSDetailTab;
import com.inponsel.android.utils.AnimateFirstDisplayListener;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.DelayedTextWatcher;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.MyObjectRequest;
import com.inponsel.android.utils.NotificationLikeRSSHelper;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.v2.ImagePagerActivity;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
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

public class Hal3PencNews extends SherlockFragment
    implements Observer
{
    public class FavoritTask extends AsyncTask
    {

        final Hal3PencNews this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            try
            {
                avoid = (new StringBuilder("idrss=")).append(idkom_pos).append("&idusr=").append(user_id).append("&stat=").append(stat).append("&t=").append(t).toString();
                String s = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("add_favrss").append(Utility.BASE_FORMAT).append("?").append(avoid).toString();
                Log.e("pushURL", s);
                s = HttpPush.getResponse(s);
                Log.e("push", (new StringBuilder(String.valueOf(s))).append(avoid).toString());
                res = s.toString();
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
            updateViewRSSFav(idkom_pos, res, str_srclink);
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            if (stat.equals("1"))
            {
                mDialog = ProgressDialog.show(getActivity(), "", "Menambahkan...", true);
            } else
            {
                mDialog = ProgressDialog.show(getActivity(), "", "Menghapus...", true);
            }
            mDialog.setCancelable(true);
            mDialog.show();
        }

        public FavoritTask()
        {
            this$0 = Hal3PencNews.this;
            super();
        }
    }

    public class PostBagusKurangTask extends AsyncTask
    {

        final Hal3PencNews this$0;

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
            tot_LikeRSS = s.getString("total_like");
            totdis_LikeKom = s.getString("total_dislike");
            Log.e("tot_LikePon", tot_LikeRSS);
            Log.e("totdis_LikePon", totdis_LikeKom);
            ponselBaseApp.getObserver().setJum_komenLikeRSS(jum_komen);
            ponselBaseApp.getObserver().setTot_LikeRSS(tot_LikeRSS);
            ponselBaseApp.getObserver().setIndexRSS(idkom_pos);
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
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("likedis_rss.php?").append(querylike).toString();
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
            ponselBaseApp.getObserver().setUpdateType("likerss");
            ponselBaseApp.getObserver().setStatus_like_ponsel("-");
            Log.e("postStatusLikeKom", postStatusLikeKom);
            if (!postStatusLikeKom.equals("1"))
            {
                break MISSING_BLOCK_LABEL_169;
            }
            if (!statuslike.equals("1"))
            {
                break MISSING_BLOCK_LABEL_144;
            }
            notificationLikeHelper.completed("RSS Feeds", notificationLikeHelper.suclikefrontKomen);
_L1:
            Log.e("mArrayListData", String.valueOf(mArrayListData.size()));
            Log.e("index_komposlike", idkom_pos);
            updateViewLikeDis(idkom_pos);
            return;
            try
            {
                notificationLikeHelper.completed("RSS Feeds", notificationLikeHelper.sucdislikefrontKomen);
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
              goto _L1
            if (statuslike.equals("1"))
            {
                notificationLikeHelper.gagal("RSS Feeds", notificationLikeHelper.gaglikefrontKomen);
                return;
            }
            notificationLikeHelper.gagal("RSS Feeds", notificationLikeHelper.gagdislikefrontKomen);
            return;
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            if (statuslike.equals("1"))
            {
                notificationLikeHelper.createNotification("RSS Feeds", notificationLikeHelper.likefrontKomen);
                return;
            } else
            {
                notificationLikeHelper.createNotification("RSS Feeds", notificationLikeHelper.dislikefrontKomen);
                return;
            }
        }

        public PostBagusKurangTask()
        {
            this$0 = Hal3PencNews.this;
            super();
        }
    }

    public class RSSAsycTask extends AsyncTask
    {

        final Hal3PencNews this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient Void doInBackground(String as[])
        {
            Log.e("RSSAsycTask", "doInBackground");
            JSONObject jsonobject = new JSONObject(getJSONUrl(urlRSS));
            as = jsonobject.getJSONArray("InPonsel");
            bottom_id = jsonobject.getString("bottom_id");
            top_id = jsonobject.getString("top_id");
            succesStat = jsonobject.getString("success");
            Log.e("bottom_id", bottom_id);
            Log.e("top_id", top_id);
            countKomOld = 0;
            if (!succesStat.equals("1"))
            {
                break MISSING_BLOCK_LABEL_336;
            }
            int i = 0;
_L1:
            if (i >= as.length())
            {
                break MISSING_BLOCK_LABEL_336;
            }
            Object obj = Hal3PencNews.this;
            obj.countAllKom = ((Hal3PencNews) (obj)).countAllKom + 1;
            obj = Hal3PencNews.this;
            obj.countKomOld = ((Hal3PencNews) (obj)).countKomOld + 1;
            Log.e("countAllKom", String.valueOf(countAllKom));
            obj = as.getJSONObject(i);
            mArrayListData.add(new ItemRSS(((JSONObject) (obj)).getString("id"), ((JSONObject) (obj)).getString("rss_id"), ((JSONObject) (obj)).getString("rss_title"), ((JSONObject) (obj)).getString("rss_portal"), ((JSONObject) (obj)).getString("rss_desc"), "", ((JSONObject) (obj)).getString("rss_srclink"), ((JSONObject) (obj)).getString("rss_date"), ((JSONObject) (obj)).getString("rss_img_ava"), ((JSONObject) (obj)).getString("rss_img"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("total_like"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("total_komen"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("total_hits"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("my_like_rss"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("my_fav_rss")));
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
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            Log.e("RSSAsycTask", "onPreExecute");
        }

        public RSSAsycTask()
        {
            this$0 = Hal3PencNews.this;
            super();
        }
    }


    private ImageLoadingListener animateFirstListener;
    String bottom_id;
    LinearLayout bottom_list;
    Button btnRefresh;
    int charCount;
    ConnectivityManager cm;
    int countAllKom;
    int countKomOld;
    int countRemIndex;
    int countnext;
    Cursor cursor;
    DatabaseHandler db;
    EditText edtAuto;
    String email_user;
    Bundle extras;
    LinearLayout grup_footer;
    LinearLayout grup_header;
    String idkom_pos;
    ImageLoader imageLoader2;
    ImageView imageMedia;
    ImageView img_kom_picture;
    InputMethodManager imm;
    JSONArray jArray;
    String jum_komen;
    String key;
    String komencount;
    LinearLayout lay_quote;
    LinearLayout layout_empty;
    LinearLayout layout_footerNext;
    LinearLayout layout_header;
    int limit;
    RelativeLayout list_lay_dislike;
    RelativeLayout list_lay_kom;
    RelativeLayout list_lay_like;
    private ArrayList mArrayListData;
    ProgressDialog mDialog;
    private LinearLayout mLinearListView;
    String nama_asli;
    NotificationLikeRSSHelper notificationLikeHelper;
    private DisplayImageOptions options;
    PonselBaseApp ponselBaseApp;
    TextView pop_txt_empty;
    String postMessage;
    String postMessageAddRss;
    String postMessageLikeKom;
    String postStatus;
    String postStatusAddRss;
    String postStatusLikeKom;
    ProgressBar progressbar_middle;
    String querylike;
    String querypopkomen;
    int removeIndex;
    int removeNextIndex;
    int removeStartOld;
    String res;
    String reslike;
    String rss_content;
    ScrollView scrollviewKomen;
    String stat;
    String statuslike;
    String strKonekStat;
    String str_srclink;
    String succesStat;
    String t;
    String top_id;
    String tot_LikePon;
    String tot_LikeRSS;
    String totdis_LikeKom;
    String totdis_LikePon;
    TextView txtIdKom;
    TextView txtImgAva;
    TextView txtImgMedia;
    TextView txtKomentar;
    TextView txtKomentarQoute;
    TextView txtLikeKom;
    TextView txtTanggapan;
    TextView txtTitle;
    TextView txtTotalKom;
    TextView txtUsername;
    TextView txtUsernameQoute;
    TextView txtWaktu;
    TextView txtWaktuQoute;
    TextView txtbtnfooter;
    TextView txtbtnheader;
    TextView txtcari;
    TextView txtdisLikeKom;
    String urlRSS;
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
    ContextThemeWrapper wrapperLight;

    public Hal3PencNews()
    {
        animateFirstListener = new AnimateFirstDisplayListener();
        stat = "";
        countnext = 0;
        urlRSS = "";
        strKonekStat = "";
        bottom_id = "";
        top_id = "0";
        jum_komen = "0";
        tot_LikePon = "";
        totdis_LikePon = "";
        succesStat = "";
        countKomOld = 0;
        countAllKom = 0;
        postStatus = "";
        postMessage = "";
        removeIndex = 0;
        removeStartOld = 0;
        removeNextIndex = 0;
        countRemIndex = 0;
        querylike = "";
        postStatusLikeKom = "";
        postMessageLikeKom = "Gagal mengirim";
        tot_LikeRSS = "0";
        totdis_LikeKom = "0";
        postStatusAddRss = "";
        postMessageAddRss = "";
        limit = 1;
        komencount = "";
        querypopkomen = "";
        user_photo = "";
        username = "";
        t = Utility.session(RestClient.pelihara);
        key = "";
    }

    private void SearchBerita()
    {
        if (limit == 1)
        {
            showProgressDialog();
        }
        Log.e("urlRSS", urlRSS);
        MyObjectRequest myobjectrequest = new MyObjectRequest(urlRSS, new com.android.volley.Response.Listener() {

            final Hal3PencNews this$0;

            public volatile void onResponse(Object obj)
            {
                onResponse((JSONObject)obj);
            }

            public void onResponse(JSONObject jsonobject)
            {
                parseJSON(jsonobject.toString());
                afterParse();
                if (limit == 1)
                {
                    hideProgressDialog();
                }
                layout_empty.setVisibility(8);
                Log.e("counter", String.valueOf(mArrayListData.size()));
                if (mArrayListData.size() == 0)
                {
                    scrollviewKomen.setVisibility(8);
                    layout_empty.setVisibility(0);
                    progressbar_middle.setVisibility(8);
                    pop_txt_empty.setVisibility(0);
                    pop_txt_empty.setText("Berita tidak ditemukan");
                    return;
                }
                if (mArrayListData.size() < 15)
                {
                    grup_footer.setVisibility(8);
                    return;
                } else
                {
                    grup_footer.setVisibility(0);
                    txtbtnfooter.setVisibility(0);
                    return;
                }
            }

            
            {
                this$0 = Hal3PencNews.this;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final Hal3PencNews this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
                hideProgressDialog();
            }

            
            {
                this$0 = Hal3PencNews.this;
                super();
            }
        }, "test", "test");
        PonselBaseApp.getInstance().addToRequestQueue(myobjectrequest, "tag_json_obj");
    }

    private void afterParse()
    {
        View view;
        ImageView imageview;
        ImageView imageview1;
        final TextView txt_fav_news_1;
        final String id_rss;
        final String rss_id;
        final String rss_title;
        final String rss_portal;
        final String rss_desc;
        final String rss_srclink;
        final String rss_date;
        final String rss_img_ava;
        final String rss_img;
        final String total_like;
        final String like_stat;
        final String total_komen;
        final String fav_stat;
        int i;
        if (succesStat.equals("1"))
        {
            Log.e("jumnews", String.valueOf(mArrayListData.size()));
            i = 0;
        } else
        {
            scrollviewKomen.setVisibility(8);
            layout_empty.setVisibility(0);
            progressbar_middle.setVisibility(8);
            pop_txt_empty.setVisibility(0);
            pop_txt_empty.setText("Berita tidak ditemukan");
            return;
        }
        if (i >= mArrayListData.size())
        {
            layout_empty.setVisibility(8);
            scrollviewKomen.setVisibility(0);
            return;
        }
        view = ((LayoutInflater)getActivity().getSystemService("layout_inflater")).inflate(0x7f0300c5, null);
        txtUsername = (TextView)view.findViewById(0x7f0b0419);
        txtTitle = (TextView)view.findViewById(0x7f0b05ec);
        img_kom_picture = (ImageView)view.findViewById(0x7f0b054b);
        imageMedia = (ImageView)view.findViewById(0x7f0b046c);
        txtIdKom = (TextView)view.findViewById(0x7f0b054d);
        txtKomentar = (TextView)view.findViewById(0x7f0b054e);
        txtWaktu = (TextView)view.findViewById(0x7f0b054c);
        txtImgAva = (TextView)view.findViewById(0x7f0b05e9);
        txtImgMedia = (TextView)view.findViewById(0x7f0b05ea);
        imageview = (ImageView)view.findViewById(0x7f0b054f);
        imageview1 = (ImageView)view.findViewById(0x7f0b0552);
        txtLikeKom = (TextView)view.findViewById(0x7f0b0551);
        txtdisLikeKom = (TextView)view.findViewById(0x7f0b0554);
        txtTotalKom = (TextView)view.findViewById(0x7f0b034a);
        bottom_list = (LinearLayout)view.findViewById(0x7f0b0341);
        list_lay_like = (RelativeLayout)view.findViewById(0x7f0b0342);
        list_lay_dislike = (RelativeLayout)view.findViewById(0x7f0b0345);
        list_lay_kom = (RelativeLayout)view.findViewById(0x7f0b0348);
        txt_fav_news_1 = (TextView)view.findViewById(0x7f0b0650);
        id_rss = ((ItemRSS)mArrayListData.get(i)).getId();
        rss_id = ((ItemRSS)mArrayListData.get(i)).getRss_id();
        rss_title = ((ItemRSS)mArrayListData.get(i)).getRss_title();
        rss_portal = ((ItemRSS)mArrayListData.get(i)).getRss_portal();
        rss_desc = ((ItemRSS)mArrayListData.get(i)).getRss_desc();
        rss_srclink = ((ItemRSS)mArrayListData.get(i)).getRss_srclink();
        rss_date = ((ItemRSS)mArrayListData.get(i)).getRss_date();
        rss_img_ava = ((ItemRSS)mArrayListData.get(i)).getRss_img_ava();
        rss_img = ((ItemRSS)mArrayListData.get(i)).getRss_img();
        total_like = ((ItemRSS)mArrayListData.get(i)).getRss_tot_like();
        like_stat = ((ItemRSS)mArrayListData.get(i)).getRss_like_stat();
        total_komen = ((ItemRSS)mArrayListData.get(i)).getRss_tot_komen();
        fav_stat = ((ItemRSS)mArrayListData.get(i)).getRss_fav_stat();
        txt_fav_news_1.setText(fav_stat);
        Log.e("fav1247", fav_stat);
        txtTitle.setText(Html.fromHtml(rss_title));
        txtIdKom.setText(id_rss);
        txtUsername.setText(rss_portal);
        txtImgAva.setText(rss_img_ava);
        txtImgMedia.setText(rss_img);
        txtKomentar.setText(Html.fromHtml(Utility.parseUrl(rss_desc)));
        txtKomentar.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
        txtLikeKom.setText(total_like);
        txtTotalKom.setText(total_komen);
        if (like_stat.toString().equals("1"))
        {
            imageview.setBackgroundResource(0x7f020264);
            list_lay_like.setEnabled(false);
            list_lay_dislike.setEnabled(true);
        } else
        if (like_stat.toString().equals("0"))
        {
            imageview.setBackgroundResource(0x7f020265);
            imageview1.setBackgroundResource(0x7f0201a7);
            list_lay_like.setEnabled(true);
        } else
        {
            list_lay_like.setEnabled(true);
            list_lay_dislike.setEnabled(true);
            imageview.setBackgroundResource(0x7f020265);
            list_lay_like.setBackgroundResource(0x7f020079);
            list_lay_dislike.setBackgroundResource(0x7f020079);
        }
        if (!fav_stat.toString().equals("1")) goto _L2; else goto _L1
_L1:
        imageview1.setBackgroundResource(0x7f020303);
_L3:
        imageLoader2.displayImage((new StringBuilder()).append(((ItemRSS)mArrayListData.get(i)).getRss_img_ava().toString().trim()).toString(), img_kom_picture, options, animateFirstListener);
        if (((ItemRSS)mArrayListData.get(i)).getRss_img().trim().equals(""))
        {
            imageMedia.setVisibility(8);
        } else
        {
            imageLoader2.displayImage((new StringBuilder()).append(((ItemRSS)mArrayListData.get(i)).getRss_img().toString().trim()).toString(), imageMedia, options, animateFirstListener);
        }
        txtWaktu.setText(Utility.convertDate(((ItemRSS)mArrayListData.get(i)).getRss_date()));
        mLinearListView.addView(view);
        imageMedia.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal3PencNews this$0;
            private final String val$rss_img;

            public void onClick(View view1)
            {
                view1 = new ArrayList();
                view1.add(rss_img);
                view1 = (String[])view1.toArray(new String[view1.size()]);
                Intent intent = new Intent(getActivity(), com/inponsel/android/v2/ImagePagerActivity);
                intent.putExtra("imgUrl", view1);
                intent.putExtra("pos", 0);
                startActivity(intent);
            }

            
            {
                this$0 = Hal3PencNews.this;
                rss_img = s;
                super();
            }
        });
        img_kom_picture.setOnLongClickListener(new android.view.View.OnLongClickListener() {

            final Hal3PencNews this$0;
            private final String val$rss_img_ava;

            public boolean onLongClick(View view1)
            {
                view1 = new ArrayList();
                view1.add((new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(rss_img_ava.toString().trim()).toString());
                view1 = (String[])view1.toArray(new String[view1.size()]);
                Intent intent = new Intent(getActivity(), com/inponsel/android/v2/ImagePagerActivity);
                intent.putExtra("imgUrl", view1);
                intent.putExtra("pos", 0);
                startActivity(intent);
                return false;
            }

            
            {
                this$0 = Hal3PencNews.this;
                rss_img_ava = s;
                super();
            }
        });
        list_lay_like.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal3PencNews this$0;
            private final String val$id_rss;

            public void onClick(View view1)
            {
                if (userFunctions.isUserLoggedIn(getActivity()))
                {
                    statuslike = "1";
                    idkom_pos = id_rss;
                    querylike = (new StringBuilder("status=")).append(statuslike).append("&id_rss=").append(id_rss).append("&id_usr=").append(user_id).append("&t=").append(t).toString();
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
                    view1 = new android.app.AlertDialog.Builder(wrapperLight);
                    view1.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                    view1.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

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
                    view1.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls8 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                            startActivity(dialoginterface);
                        }

            
            {
                this$1 = _cls8.this;
                super();
            }
                    });
                    view1.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls8 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            startActivity(dialoginterface);
                        }

            
            {
                this$1 = _cls8.this;
                super();
            }
                    });
                    view1.show();
                    return;
                }
            }


            
            {
                this$0 = Hal3PencNews.this;
                id_rss = s;
                super();
            }
        });
        list_lay_dislike.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal3PencNews this$0;
            private final String val$id_rss;
            private final String val$rss_srclink;
            private final TextView val$txt_fav_news_1;

            public void onClick(View view1)
            {
                idkom_pos = id_rss;
                str_srclink = rss_srclink;
                if (userFunctions.isUserLoggedIn(getActivity()))
                {
                    if (txt_fav_news_1.getText().toString().equals("1"))
                    {
                        view1 = new android.app.AlertDialog.Builder(getActivity());
                        view1.setMessage("Hapus berita ini dari favorit?");
                        view1.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                            final _cls9 this$1;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                                stat = "0";
                                (new FavoritTask()).execute(new Void[0]);
                            }

            
            {
                this$1 = _cls9.this;
                super();
            }
                        });
                        view1.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                            final _cls9 this$1;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$1 = _cls9.this;
                super();
            }
                        });
                        view1.show();
                        return;
                    } else
                    {
                        view1 = new android.app.AlertDialog.Builder(getActivity());
                        view1.setMessage("Favoritkan berita ini?");
                        view1.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                            final _cls9 this$1;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                stat = "1";
                                (new FavoritTask()).execute(new Void[0]);
                            }

            
            {
                this$1 = _cls9.this;
                super();
            }
                        });
                        view1.setNeutralButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                            final _cls9 this$1;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$1 = _cls9.this;
                super();
            }
                        });
                        view1.show();
                        return;
                    }
                } else
                {
                    view1 = new android.app.AlertDialog.Builder(wrapperLight);
                    view1.setMessage("Untuk menambahkan ke favorit harus login terlebih dahulu.");
                    view1.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                        final _cls9 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls9.this;
                super();
            }
                    });
                    view1.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls9 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                            startActivity(dialoginterface);
                        }

            
            {
                this$1 = _cls9.this;
                super();
            }
                    });
                    view1.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls9 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            startActivity(dialoginterface);
                        }

            
            {
                this$1 = _cls9.this;
                super();
            }
                    });
                    view1.show();
                    return;
                }
            }


            
            {
                this$0 = Hal3PencNews.this;
                id_rss = s;
                rss_srclink = s1;
                txt_fav_news_1 = textview;
                super();
            }
        });
        list_lay_kom.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal3PencNews this$0;
            private final String val$fav_stat;
            private final String val$id_rss;
            private final String val$like_stat;
            private final String val$rss_date;
            private final String val$rss_desc;
            private final String val$rss_id;
            private final String val$rss_img;
            private final String val$rss_img_ava;
            private final String val$rss_portal;
            private final String val$rss_srclink;
            private final String val$rss_title;
            private final String val$total_komen;
            private final String val$total_like;

            public void onClick(View view1)
            {
                idkom_pos = id_rss;
                view1 = new Intent(getActivity(), com/inponsel/android/rssfeeddetail/RSSDetailTab);
                view1.putExtra("kategori_tag", "");
                view1.putExtra("act", "komen");
                view1.putExtra("actfrom", "rssfeed");
                view1.putExtra("rss_id", rss_id);
                view1.putExtra("id_rss", id_rss);
                view1.putExtra("rss_title", rss_title);
                view1.putExtra("rss_portal", rss_portal);
                view1.putExtra("rss_desc", rss_desc);
                view1.putExtra("rss_srclink", rss_srclink);
                view1.putExtra("rss_date", rss_date);
                view1.putExtra("rss_img_ava", rss_img_ava);
                view1.putExtra("rss_img", rss_img);
                view1.putExtra("total_like", total_like);
                view1.putExtra("like_stat", like_stat);
                view1.putExtra("total_komen", total_komen);
                view1.putExtra("fav_stat", fav_stat);
                startActivityForResult(view1, 0);
                getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = Hal3PencNews.this;
                id_rss = s;
                rss_id = s1;
                rss_title = s2;
                rss_portal = s3;
                rss_desc = s4;
                rss_srclink = s5;
                rss_date = s6;
                rss_img_ava = s7;
                rss_img = s8;
                total_like = s9;
                like_stat = s10;
                total_komen = s11;
                fav_stat = s12;
                super();
            }
        });
        view.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal3PencNews this$0;
            private final String val$fav_stat;
            private final String val$id_rss;
            private final String val$like_stat;
            private final String val$rss_date;
            private final String val$rss_desc;
            private final String val$rss_id;
            private final String val$rss_img;
            private final String val$rss_img_ava;
            private final String val$rss_portal;
            private final String val$rss_srclink;
            private final String val$rss_title;
            private final String val$total_komen;
            private final String val$total_like;

            public void onClick(View view1)
            {
                idkom_pos = id_rss;
                view1 = new Intent(getActivity(), com/inponsel/android/rssfeeddetail/RSSDetailTab);
                view1.putExtra("actfrom", "rssfeed");
                view1.putExtra("kategori_tag", "");
                view1.putExtra("act", "firsttab");
                view1.putExtra("rss_id", rss_id);
                view1.putExtra("id_rss", id_rss);
                view1.putExtra("rss_title", rss_title);
                view1.putExtra("rss_portal", rss_portal);
                view1.putExtra("rss_desc", rss_desc);
                view1.putExtra("rss_srclink", rss_srclink);
                view1.putExtra("rss_date", rss_date);
                view1.putExtra("rss_img_ava", rss_img_ava);
                view1.putExtra("rss_img", rss_img);
                view1.putExtra("total_like", total_like);
                view1.putExtra("like_stat", like_stat);
                view1.putExtra("total_komen", total_komen);
                view1.putExtra("fav_stat", fav_stat);
                startActivityForResult(view1, 0);
                getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = Hal3PencNews.this;
                id_rss = s;
                rss_id = s1;
                rss_title = s2;
                rss_portal = s3;
                rss_desc = s4;
                rss_srclink = s5;
                rss_date = s6;
                rss_img_ava = s7;
                rss_img = s8;
                total_like = s9;
                like_stat = s10;
                total_komen = s11;
                fav_stat = s12;
                super();
            }
        });
        i++;
        if (false)
        {
            break MISSING_BLOCK_LABEL_1091;
        } else
        {
            break MISSING_BLOCK_LABEL_32;
        }
_L2:
        if (fav_stat.toString().equals("0"))
        {
            imageview1.setBackgroundResource(0x7f020302);
        } else
        {
            imageview1.setBackgroundResource(0x7f020302);
        }
          goto _L3
    }

    private void hideProgressDialog()
    {
        if (progressbar_middle.getVisibility() == 0)
        {
            progressbar_middle.setVisibility(8);
            Log.e("tasksdsurlSearch", urlRSS);
        }
    }

    private void parseJSONAddFav(String s)
    {
        int i;
        try
        {
            s = new JSONObject(s);
            postStatusAddRss = s.getString("success");
            postMessageAddRss = s.getString("message");
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
            ponselBaseApp.getObserver().setFav_stat_rss(stat);
            ponselBaseApp.getObserver().setIndexRSS(idkom_pos);
            ponselBaseApp.getObserver().setUpdateType("favrss");
            ponselBaseApp.getObserver().setStatus_like_ponsel("-");
            return;
        }
        rss_content = jArray.getJSONObject(i).getString("rss_content");
        i++;
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_44;
        }
    }

    private void showProgressDialog()
    {
        if (progressbar_middle.getVisibility() != 0)
        {
            progressbar_middle.setVisibility(0);
        }
        mArrayListData.clear();
        mLinearListView.removeAllViews();
        mLinearListView.removeAllViewsInLayout();
    }

    public void SearchTask()
    {
        if (limit == 1)
        {
            grup_footer.setVisibility(8);
            mArrayListData.clear();
            mLinearListView.removeAllViews();
            urlRSS = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("search_engine").append(Utility.BASE_FORMAT).append("?").append("lmt=").append(limit).append("&kat=3").append("&t=").append(t).append("&idusr=").append(user_id).append("&key=").append(key).toString();
        } else
        {
            mArrayListData.clear();
            grup_footer.setVisibility(0);
            txtbtnfooter.setVisibility(8);
            urlRSS = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("search_engine").append(Utility.BASE_FORMAT).append("?").append("&kat=3").append("&key=").append(key).append("&t=").append(t).append("&idusr=").append(user_id).append("&lmt=").append(limit).toString();
            Log.e("urlRSS", urlRSS);
        }
        Log.e("urlRSS", urlRSS);
        SearchBerita();
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

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = (ViewGroup)layoutinflater.inflate(0x7f030096, null);
        txtcari = (TextView)layoutinflater.findViewById(0x7f0b052c);
        edtAuto = (EditText)layoutinflater.findViewById(0x7f0b008d);
        txtcari.setVisibility(8);
        edtAuto.setHint("Pencarian Berita");
        wrapperLight = new ContextThemeWrapper(getActivity(), 0x103006e);
        ponselBaseApp = (PonselBaseApp)getActivity().getApplication();
        ponselBaseApp.getObserver().addObserver(this);
        userFunctions = new UserFunctions();
        db = new DatabaseHandler(getActivity());
        imm = (InputMethodManager)getActivity().getSystemService("input_method");
        cm = (ConnectivityManager)getActivity().getSystemService("connectivity");
        t = Utility.session(t);
        extras = getActivity().getIntent().getExtras();
        t = Utility.session(t);
        mLinearListView = (LinearLayout)layoutinflater.findViewById(0x7f0b04d8);
        notificationLikeHelper = new NotificationLikeRSSHelper(getActivity());
        mArrayListData = new ArrayList();
        imageLoader2 = ImageLoader.getInstance();
        imageLoader2.init(ImageLoaderConfiguration.createDefault(getActivity()));
        options = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showImageOnLoading(0x7f020209).showImageForEmptyUri(0x7f020297).showImageOnFail(0x7f020209).cacheInMemory(true).imageScaleType(ImageScaleType.EXACTLY_STRETCHED).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).build();
        layout_empty = (LinearLayout)layoutinflater.findViewById(0x7f0b0091);
        scrollviewKomen = (ScrollView)layoutinflater.findViewById(0x7f0b052d);
        progressbar_middle = (ProgressBar)layoutinflater.findViewById(0x7f0b00ca);
        progressbar_middle.setVisibility(8);
        pop_txt_empty = (TextView)layoutinflater.findViewById(0x7f0b04cf);
        pop_txt_empty.setVisibility(8);
        scrollviewKomen.setVisibility(8);
        btnRefresh = (Button)layoutinflater.findViewById(0x7f0b04d0);
        txtbtnfooter = (TextView)layoutinflater.findViewById(0x7f0b04d9);
        txtbtnfooter.setText("Tekan untuk lihat berita lama...");
        grup_footer = (LinearLayout)layoutinflater.findViewById(0x7f0b00be);
        layout_footerNext = (LinearLayout)layoutinflater.findViewById(0x7f0b00c0);
        if (userFunctions.isUserLoggedIn(getActivity()))
        {
            cursor = db.getAllData();
            cursor.moveToFirst();
            try
            {
                user_id = EncodeDecodeAES.decrypt(RestClient.pelihara, cursor.getString(1));
            }
            // Misplaced declaration of an exception variable
            catch (ViewGroup viewgroup) { }
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
        }
        layout_empty.setVisibility(8);
        edtAuto.addTextChangedListener(new DelayedTextWatcher(2000L) {

            final Hal3PencNews this$0;

            public void afterTextChangedDelayed(Editable editable)
            {
label0:
                {
                    if (edtAuto.getText().toString().trim().length() != 0)
                    {
                        if (cm.getActiveNetworkInfo() == null || !cm.getActiveNetworkInfo().isAvailable() || !cm.getActiveNetworkInfo().isConnected())
                        {
                            break label0;
                        }
                        key = edtAuto.getText().toString();
                        try
                        {
                            key = URLEncoder.encode(key, "utf-8");
                        }
                        // Misplaced declaration of an exception variable
                        catch (Editable editable)
                        {
                            editable.printStackTrace();
                        }
                        Log.e("key", key);
                        limit = 1;
                        SearchTask();
                    }
                    return;
                }
                Toast.makeText(getActivity(), 0x7f0c0059, 0).show();
            }

            
            {
                this$0 = Hal3PencNews.this;
                super(l);
            }
        });
        edtAuto.setSingleLine(true);
        edtAuto.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

            final Hal3PencNews this$0;

            public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
            {
label0:
                {
label1:
                    {
                        if (i != 3)
                        {
                            break label0;
                        }
                        if (edtAuto.getText().toString().trim().length() != 0)
                        {
                            if (cm.getActiveNetworkInfo() == null || !cm.getActiveNetworkInfo().isAvailable() || !cm.getActiveNetworkInfo().isConnected())
                            {
                                break label1;
                            }
                            key = edtAuto.getText().toString();
                            try
                            {
                                key = URLEncoder.encode(key, "utf-8");
                            }
                            // Misplaced declaration of an exception variable
                            catch (TextView textview)
                            {
                                textview.printStackTrace();
                            }
                            Log.e("key", key);
                            limit = 1;
                            SearchTask();
                        }
                        return true;
                    }
                    Toast.makeText(getActivity(), 0x7f0c0059, 0).show();
                    return true;
                }
                return false;
            }

            
            {
                this$0 = Hal3PencNews.this;
                super();
            }
        });
        txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal3PencNews this$0;

            public void onClick(View view)
            {
                try
                {
                    view = Hal3PencNews.this;
                    view.limit = ((Hal3PencNews) (view)).limit + 1;
                    SearchTask();
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    return;
                }
            }

            
            {
                this$0 = Hal3PencNews.this;
                super();
            }
        });
        return layoutinflater;
    }

    void parseJSON(String s)
    {
        Log.e("RSSAsycTask", "doInBackground");
        JSONObject jsonobject = new JSONObject(s);
        s = jsonobject.getJSONArray("InPonsel");
        bottom_id = jsonobject.getString("bottom_id");
        top_id = jsonobject.getString("top_id");
        succesStat = jsonobject.getString("success");
        Log.e("bottom_id", bottom_id);
        Log.e("top_id", top_id);
        countKomOld = 0;
        if (!succesStat.equals("1"))
        {
            break MISSING_BLOCK_LABEL_335;
        }
        int i = 0;
_L2:
        if (i >= s.length())
        {
            return;
        }
        countAllKom = countAllKom + 1;
        countKomOld = countKomOld + 1;
        JSONObject jsonobject1 = s.getJSONObject(i);
        mArrayListData.add(new ItemRSS(jsonobject1.getString("id"), jsonobject1.getString("rss_id"), jsonobject1.getString("rss_title"), jsonobject1.getString("rss_portal"), jsonobject1.getString("rss_desc"), "", jsonobject1.getString("rss_srclink"), jsonobject1.getString("rss_date"), jsonobject1.getString("rss_img_ava"), jsonobject1.getString("rss_img"), jsonobject1.getJSONObject("likedislike").getString("total_like"), jsonobject1.getJSONObject("likedislike").getString("total_komen"), jsonobject1.getJSONObject("likedislike").getString("total_hits"), jsonobject1.getJSONObject("likedislike").getString("my_like_rss"), jsonobject1.getJSONObject("likedislike").getString("my_fav_rss")));
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        s;
        scrollviewKomen.setVisibility(8);
        layout_empty.setVisibility(0);
        progressbar_middle.setVisibility(8);
        pop_txt_empty.setVisibility(0);
        pop_txt_empty.setText("Berita tidak ditemukan");
        s.printStackTrace();
    }

    public void update(Observable observable, Object obj)
    {
        int i;
        if (!ponselBaseApp.getObserver().getUpdateType().equals("likerss"))
        {
            break MISSING_BLOCK_LABEL_496;
        }
        Log.e("id_rssup", ponselBaseApp.getObserver().getIndexRSS());
        Log.e("mLinearListView", String.valueOf(mLinearListView.getChildCount()));
        i = 0;
_L3:
        if (i < mLinearListView.getChildCount()) goto _L2; else goto _L1
_L1:
        if (ponselBaseApp.getObserver().getLoginStat().equals("1") && userFunctions.isUserLoggedIn(getActivity()))
        {
            cursor = db.getAllData();
            cursor.moveToFirst();
            ImageView imageview;
            Object obj1;
            try
            {
                user_id = EncodeDecodeAES.decrypt(RestClient.pelihara, cursor.getString(1));
            }
            // Misplaced declaration of an exception variable
            catch (Observable observable) { }
            nama_asli = cursor.getString(2);
            user_photo = (new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(cursor.getString(3)).toString();
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
        }
        return;
_L2:
        obj1 = mLinearListView.getChildAt(i);
        observable = (TextView)((View) (obj1)).findViewById(0x7f0b054d);
        obj = (TextView)((View) (obj1)).findViewById(0x7f0b0551);
        imageview = (ImageView)((View) (obj1)).findViewById(0x7f0b054f);
        obj1 = (TextView)((View) (obj1)).findViewById(0x7f0b034a);
        if (observable.getText().toString().equals(ponselBaseApp.getObserver().getIndexRSS()))
        {
            ((TextView) (obj)).setText(ponselBaseApp.getObserver().getTot_LikeRSS());
            ((TextView) (obj1)).setText(ponselBaseApp.getObserver().getJum_komenLikeRSS());
            imageview.setBackgroundResource(0x7f020264);
        }
        i++;
          goto _L3
        if (ponselBaseApp.getObserver().getUpdateType().equals("favrss"))
        {
            i = 0;
            while (i < mLinearListView.getChildCount()) 
            {
                obj = mLinearListView.getChildAt(i);
                observable = (ImageView)((View) (obj)).findViewById(0x7f0b0552);
                obj = (TextView)((View) (obj)).findViewById(0x7f0b054d);
                Log.e("rssidmatch", (new StringBuilder(String.valueOf(ponselBaseApp.getObserver().getIndexRSS()))).append("=").append(((TextView) (obj)).getText().toString()).toString());
                if (((TextView) (obj)).getText().toString().equals(ponselBaseApp.getObserver().getIndexRSS()))
                {
                    if (ponselBaseApp.getObserver().getFav_stat_rss().toString().equals("1"))
                    {
                        observable.setBackgroundResource(0x7f020303);
                    } else
                    {
                        observable.setBackgroundResource(0x7f020302);
                    }
                }
                i++;
            }
        }
          goto _L1
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
        if (i >= mLinearListView.getChildCount())
        {
            return;
        }
        Object obj = mLinearListView.getChildAt(i);
        TextView textview = (TextView)((View) (obj)).findViewById(0x7f0b054d);
        TextView textview1 = (TextView)((View) (obj)).findViewById(0x7f0b0551);
        TextView textview2 = (TextView)((View) (obj)).findViewById(0x7f0b0554);
        imageview = (ImageView)((View) (obj)).findViewById(0x7f0b054f);
        imageview1 = (ImageView)((View) (obj)).findViewById(0x7f0b0552);
        relativelayout = (RelativeLayout)((View) (obj)).findViewById(0x7f0b0342);
        obj = (RelativeLayout)((View) (obj)).findViewById(0x7f0b0345);
        if (textview.getText().toString().equals(s))
        {
            textview1.setText(tot_LikeRSS);
            textview2.setText(totdis_LikeKom);
            if (!statuslike.equals("1"))
            {
                break; /* Loop/switch isn't completed */
            }
            imageview.setBackgroundResource(0x7f020264);
            relativelayout.setEnabled(false);
            ((RelativeLayout) (obj)).setEnabled(true);
        }
_L4:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        if (!statuslike.equals("0")) goto _L4; else goto _L3
_L3:
        imageview.setBackgroundResource(0x7f020265);
        imageview1.setBackgroundResource(0x7f0201a7);
        relativelayout.setEnabled(true);
          goto _L4
    }

    public void updateViewRSSFav(String s, String s1, String s2)
    {
        Log.e("id_kom", s);
        Log.e("resstat", s1);
        Log.e("mLinearListView", String.valueOf(mLinearListView.getChildCount()));
        int i = 0;
        do
        {
            if (i >= mLinearListView.getChildCount())
            {
                return;
            }
            Object obj = mLinearListView.getChildAt(i);
            TextView textview = (TextView)((View) (obj)).findViewById(0x7f0b054d);
            TextView textview1 = (TextView)((View) (obj)).findViewById(0x7f0b0419);
            TextView textview2 = (TextView)((View) (obj)).findViewById(0x7f0b05ec);
            TextView textview3 = (TextView)((View) (obj)).findViewById(0x7f0b054e);
            TextView textview4 = (TextView)((View) (obj)).findViewById(0x7f0b054c);
            TextView textview5 = (TextView)((View) (obj)).findViewById(0x7f0b05e9);
            TextView textview6 = (TextView)((View) (obj)).findViewById(0x7f0b05ea);
            TextView textview7 = (TextView)((View) (obj)).findViewById(0x7f0b0551);
            TextView textview8 = (TextView)((View) (obj)).findViewById(0x7f0b034a);
            ImageView imageview = (ImageView)((View) (obj)).findViewById(0x7f0b0552);
            obj = (TextView)((View) (obj)).findViewById(0x7f0b0650);
            if (textview.getText().toString().equals(s))
            {
                parseJSONAddFav(s1);
                Log.e("postStatusAddRss", postStatusAddRss);
                if (postStatusAddRss.equals("1") || postStatusAddRss.equals("10"))
                {
                    if (textview6.equals(""))
                    {
                        db.addRSS(textview.getText().toString(), textview1.getText().toString(), textview5.getText().toString(), textview2.getText().toString(), textview3.getText().toString(), rss_content, "", s2, textview4.getText().toString(), textview7.getText().toString(), textview8.getText().toString(), "");
                    } else
                    {
                        db.addRSS(textview.getText().toString(), textview1.getText().toString(), textview5.getText().toString(), textview2.getText().toString(), textview3.getText().toString(), rss_content, textview6.getText().toString(), s2, textview4.getText().toString(), textview7.getText().toString(), textview8.getText().toString(), "");
                    }
                    if (db.getRSSCount() > 0)
                    {
                        Toast.makeText(getActivity(), postMessageAddRss, 1).show();
                        imageview.setBackgroundResource(0x7f020303);
                    } else
                    {
                        Toast.makeText(getActivity(), postMessageAddRss, 1).show();
                        imageview.setBackgroundResource(0x7f020302);
                    }
                    ((TextView) (obj)).setText("1");
                    mDialog.dismiss();
                    return;
                }
                if (postStatusAddRss.equals("00") || postStatusAddRss.equals("0"))
                {
                    db.deleteHP(textview.getText().toString());
                    if (!db.checkIfExist(textview.getText().toString()))
                    {
                        Toast.makeText(getActivity(), "Berhasil menghapus", 1).show();
                        imageview.setBackgroundResource(0x7f020302);
                    } else
                    {
                        Toast.makeText(getActivity(), postMessageAddRss, 1).show();
                        imageview.setBackgroundResource(0x7f020303);
                    }
                    ((TextView) (obj)).setText("0");
                    mDialog.dismiss();
                    return;
                }
                if (res.equals("40404"))
                {
                    mDialog.dismiss();
                    return;
                } else
                {
                    Toast.makeText(getActivity(), postMessageAddRss, 1).show();
                    return;
                }
            }
            i++;
        } while (true);
    }



}
