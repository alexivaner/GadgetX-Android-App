// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.preference.PreferenceManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.widget.DrawerLayout;
import android.text.Html;
import android.util.DisplayMetrics;
import android.util.Patterns;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.android.volley.VolleyError;
import com.facebook.AccessToken;
import com.google.android.gcm.GCMRegistrar;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.inponsel.android.SplashScreen;
import com.inponsel.android.adapter.CustomPagerAdapter;
import com.inponsel.android.adapter.ItemRSS;
import com.inponsel.android.adapter.ListAppsAdapter;
import com.inponsel.android.adapter.ListKategoriApps2Adapter;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.conversation.ConversationActivity;
import com.inponsel.android.daftarharga.DaftarHargaPonsel;
import com.inponsel.android.details.DetailsPonsel;
import com.inponsel.android.favorit.FavoritPonselMerek;
import com.inponsel.android.favorit.LanggananBeritaAll;
import com.inponsel.android.globalforum.ForumGlobalActivity;
import com.inponsel.android.pencariangen.TabPencarian;
import com.inponsel.android.pencarianrinci.PencarianRinciPonsel;
import com.inponsel.android.rssfeeddetail.RSSDetailTab;
import com.inponsel.android.statistik.StatistikPonsel;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.MyObjectRequest;
import com.inponsel.android.utils.NotificationLikeHelper;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.SampleScrollListener;
import com.inponsel.android.utils.ServiceHandler;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.widget.AutoScrollViewPager;
import com.inponsel.android.widget.CircleProgressBar;
import com.inponsel.android.widget.CircleView;
import com.inponsel.android.widget.ExpandableHeightGridView;
import com.inponsel.android.widget.RoundedTransformationBuilder;
import com.inponsel.android.widget.TextViewFixTouchConsume;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.nirhart.parallaxscroll.views.ParallaxScrollView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.sherlock.navigationdrawer.compat.SherlockActionBarDrawerToggle;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.squareup.picasso.Transformation;
import de.hdodenhof.circleimageview.CircleImageView;
import fr.castorflex.android.circularprogressbar.CircularProgressBar;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            BaseDrawer, KomentarPonsel, MerekActivity, RegisterActivity, 
//            LoginActivity, ProfileActivity, ProfilePonselUserActivity, HomeSelengkapActivity, 
//            DaftarPonselMerkActivity, RSSFeedByTag, PonselRekomendasiActivity, TurunHargaPonselActivity, 
//            SCUserActivity, HomeNewsActivity, KomentarBaruLainPonsel, InboxMessageActivity, 
//            RoomGroupChatListActivity, HomeGadgetActivity, HomeAppsActivity, HomeGamesActivity, 
//            AppsByCategory, NotificationCenterActivity

public class HomeNewMainActivity extends BaseDrawer
    implements android.view.View.OnClickListener, Observer, android.view.animation.Animation.AnimationListener, com.nirhart.parallaxscroll.views.ParallaxScrollView.ScrollViewListener
{
    public class CustomInteraksiPagerAdapter extends PagerAdapter
    {

        Activity activity;
        float final_height;
        float final_width;
        private ArrayList lm;
        LayoutInflater mLayoutInflater;
        String str_doodle_height;
        String str_doodle_width;
        final HomeNewMainActivity this$0;

        public void destroyItem(ViewGroup viewgroup, int i, Object obj)
        {
            viewgroup.removeView((LinearLayout)obj);
        }

        public int getCount()
        {
            return lm.size();
        }

        public ListModel getListModel(int i)
        {
            return (ListModel)lm.get(i);
        }

        public Object instantiateItem(ViewGroup viewgroup, int i)
        {
            View view = mLayoutInflater.inflate(0x7f030143, viewgroup, false);
            ListModel listmodel = (ListModel)lm.get(i);
            Object obj = (RelativeLayout)view.findViewById(0x7f0b0910);
            ImageView imageview = (ImageView)view.findViewById(0x7f0b054b);
            TextView textview = (TextView)view.findViewById(0x7f0b0419);
            TextView textview1 = (TextView)view.findViewById(0x7f0b0765);
            TextView textview2 = (TextView)view.findViewById(0x7f0b054c);
            TextView textview3 = (TextView)view.findViewById(0x7f0b054e);
            TextView textview4 = (TextView)view.findViewById(0x7f0b054d);
            textview.setTextColor(Color.parseColor("#ffffff"));
            textview3.setTextColor(Color.parseColor("#ffffff"));
            textview1.setTextColor(Color.parseColor("#ffffff"));
            textview2.setTextColor(Color.parseColor("#ffffff"));
            textview.setText(Html.fromHtml((new StringBuilder("<b>")).append(listmodel.getNama_komentar()).append("</b>").append(" mengomentari <b>").append(listmodel.getNamalengkap()).append("</b>").toString()));
            textview4.setText(listmodel.getId_hp());
            textview3.setText(Html.fromHtml(listmodel.getKomentarhp()));
            textview1.setText((new StringBuilder("Di ")).append(listmodel.getNamalengkap()).toString());
            textview2.setText(Utility.convertDate(listmodel.getTanggal_komentar()));
            ((RelativeLayout) (obj)).setOnTouchListener(new android.view.View.OnTouchListener() {

                int downX;
                int downY;
                int dragthreshold;
                final CustomInteraksiPagerAdapter this$1;

                public boolean onTouch(View view, MotionEvent motionevent)
                {
                    Log.e("ontouch", "ontouch");
                    motionevent.getAction();
                    JVM INSTR tableswitch 0 3: default 40
                //                               0 42
                //                               1 200
                //                               2 62
                //                               3 240;
                       goto _L1 _L2 _L3 _L4 _L5
_L1:
                    return false;
_L2:
                    downX = (int)motionevent.getRawX();
                    downY = (int)motionevent.getRawY();
                    return false;
_L4:
                    int i = Math.abs((int)motionevent.getRawX() - downX);
                    int j = Math.abs((int)motionevent.getRawY() - downY);
                    if (j > i && j > dragthreshold)
                    {
                        view_pager_interaksi.getParent().requestDisallowInterceptTouchEvent(false);
                        sv_root.getParent().requestDisallowInterceptTouchEvent(true);
                        return false;
                    }
                    if (i > j && i > dragthreshold)
                    {
                        view_pager_interaksi.getParent().requestDisallowInterceptTouchEvent(true);
                        sv_root.getParent().requestDisallowInterceptTouchEvent(false);
                        return false;
                    }
                      goto _L1
_L3:
                    sv_root.getParent().requestDisallowInterceptTouchEvent(false);
                    view_pager_interaksi.getParent().requestDisallowInterceptTouchEvent(false);
                    return false;
_L5:
                    view_pager_interaksi.startAutoScroll();
                    return false;
                }

            
            {
                this$1 = CustomInteraksiPagerAdapter.this;
                super();
                dragthreshold = 30;
            }
            });
            ((RelativeLayout) (obj)).setOnClickListener(listmodel. new android.view.View.OnClickListener() {

                final CustomInteraksiPagerAdapter this$1;
                private final ListModel val$lms;

                public void onClick(View view)
                {
                    view = new Intent(activity, com/inponsel/android/v2/KomentarPonsel);
                    view.putExtra("id_hph", lms.getId_hp());
                    view.putExtra("namalengkap", lms.getNamalengkap());
                    view.putExtra("codename", lms.getCodename());
                    view.putExtra("model", lms.getModel());
                    view.putExtra("merk", lms.getMerk());
                    view.putExtra("gambar", "");
                    view.putExtra("hrg_baru", "");
                    view.putExtra("hrg_bekas", "");
                    view.putExtra("tot_like", "");
                    view.putExtra("tot_dislike", "");
                    view.putExtra("tot_komen", "");
                    view.putExtra("actfrom", "komen");
                    activity.startActivityForResult(view, 0);
                    activity.overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$1 = final_custominteraksipageradapter;
                lms = ListModel.this;
                super();
            }
            });
            obj = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(((DisplayMetrics) (obj)));
            i = ((DisplayMetrics) (obj)).widthPixels;
            try
            {
                Picasso.with(activity).load((new StringBuilder(String.valueOf(Util.BASE_URL_THUMB_ORI))).append("w=").append(i).append("&src=").append(listmodel.getAvatar()).toString()).into(imageview, imageview. new Callback() {

                    final CustomInteraksiPagerAdapter this$1;
                    private final ImageView val$img_kom_picture;

                    public void onError()
                    {
                        img_kom_picture.setImageResource(0x7f020297);
                    }

                    public void onSuccess()
                    {
                    }

            
            {
                this$1 = final_custominteraksipageradapter;
                img_kom_picture = ImageView.this;
                super();
            }
                });
            }
            catch (Exception exception) { }
            viewgroup.addView(view);
            return view;
        }

        public boolean isViewFromObject(View view, Object obj)
        {
            return view == (RelativeLayout)obj;
        }

        public void setListArray(ArrayList arraylist)
        {
            lm = arraylist;
        }


        public CustomInteraksiPagerAdapter(Activity activity1, ArrayList arraylist)
        {
            this$0 = HomeNewMainActivity.this;
            super();
            str_doodle_width = "1024";
            str_doodle_height = "600";
            mLayoutInflater = (LayoutInflater)activity1.getSystemService("layout_inflater");
            lm = arraylist;
            activity = activity1;
        }
    }

    private class LatestBrandTask extends AsyncTask
    {

        final HomeNewMainActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            {
                avoid = (new ServiceHandler()).makeServiceCall(datalatestBrand, 1);
                Log.d("ResponselatestBrand: ", datalatestBrand);
                Log.e("jsonStr: ", avoid);
                latestBrandArray.clear();
                latestBrandStrStat = avoid;
                if (avoid == null)
                {
                    break MISSING_BLOCK_LABEL_348;
                }
                ListModel listmodel;
                int i;
                try
                {
                    avoid = new JSONObject(avoid);
                    inponsel = avoid.getJSONArray("InPonsel");
                    lts_brand_idmerk = avoid.getString("id_merk");
                    lts_brand_merk = avoid.getString("merk");
                    lts_brand_total = avoid.getString("total");
                    lts_brand_logo = avoid.getString("logo");
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_355;
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_355;
                }
                i = 0;
            }
            if (i >= inponsel.length())
            {
                break MISSING_BLOCK_LABEL_355;
            }
            avoid = inponsel.getJSONObject(i);
            listmodel = new ListModel();
            listmodel.setId_hp(avoid.getString("id_hp"));
            listmodel.setModel(avoid.getString("model"));
            listmodel.setMerk(avoid.getString("merk"));
            listmodel.setCodename(avoid.getString("codename"));
            listmodel.setGambar(avoid.getString("gambar"));
            listmodel.setUmu_status(avoid.getString("umu_status"));
            listmodel.setHrg_baru(avoid.getString("hrg_baru"));
            listmodel.setHrg_bekas(avoid.getString("hrg_bekas"));
            listmodel.setTotal_like(avoid.getString("total_like"));
            listmodel.setTotal_dislike(avoid.getString("total_dislike"));
            listmodel.setTotal_hits(avoid.getString("total_hits"));
            listmodel.setTotal_kom(avoid.getString("total_kom"));
            listmodel.setMy_like_pon(avoid.getString("my_like_pon"));
            Log.e("codename: ", avoid.getString("codename"));
            latestBrandArray.add(listmodel);
            i++;
            if (true)
            {
                break MISSING_BLOCK_LABEL_135;
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
            progressbar_segmen3.setVisibility(8);
            isFinish3 = true;
            Picasso.with(HomeNewMainActivity.this).load(lts_brand_logo.trim()).tag(this).into(img_brand, new Callback() {

                final LatestBrandTask this$1;

                public void onError()
                {
                }

                public void onSuccess()
                {
                    img_brand.setVisibility(0);
                    layout_TerbaruBrand.setVisibility(0);
                }

            
            {
                this$1 = LatestBrandTask.this;
                super();
            }
            });
            txtBigTerbaruBrand.setText((new StringBuilder("Terbaru dari ")).append(lts_brand_merk).toString());
            listTerbaruBrand.setVisibility(0);
            if (latestBrandStrStat != null)
            {
                break MISSING_BLOCK_LABEL_207;
            }
            if (latestBrandArray.size() != 0) goto _L2; else goto _L1
_L1:
            txtMoreTerbaruBrand.setText("REFRESH");
_L3:
            txtMoreTerbaruBrand.getText().toString().toLowerCase().contains("refresh");
            rl_gadget_merk.setOnClickListener(new android.view.View.OnClickListener() {

                final LatestBrandTask this$1;

                public void onClick(View view)
                {
                    i = new Intent(getApplicationContext(), com/inponsel/android/v2/MerekActivity);
                    startActivityForResult(i, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$1 = LatestBrandTask.this;
                super();
            }
            });
            return;
_L2:
            try
            {
                txtMoreTerbaruBrand.setText("MORE");
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
              goto _L3
            latestBrandAdapter.notifyDataSetChanged();
              goto _L3
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            txtMoreTerbaruBrand.setVisibility(8);
            datalatestBrand = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("gadget_latest_brand").append(Utility.BASE_FORMAT).append("?idusr=").append(user_id).append("&lmt=0&t=").append(t).toString();
        }


        private LatestBrandTask()
        {
            this$0 = HomeNewMainActivity.this;
            super();
        }

        LatestBrandTask(LatestBrandTask latestbrandtask)
        {
            this();
        }
    }

    public class ListPendatangAdapter extends BaseAdapter
        implements Observer
    {

        private Activity activity;
        Context context;
        Cursor cursor;
        DatabaseHandler db;
        String email_user;
        String finalUrl;
        DecimalFormat fmt;
        DecimalFormatSymbols fmts;
        int hargaBaru;
        int hargaBekas;
        String hrg_baru;
        String hrg_bekas;
        String komen;
        private ArrayList lm;
        ListModel lms;
        PonselBaseApp ponselBaseApp;
        int pos;
        String res;
        int resource;
        String response;
        String statusLikeHpPend;
        String statusPendatang;
        String t;
        final HomeNewMainActivity this$0;
        String user;
        UserFunctions userFunctions;

        public int getCount()
        {
            return lm.size();
        }

        public Object getItem(int i)
        {
            return null;
        }

        public long getItemId(int i)
        {
            return 0L;
        }

        public ListModel getListModel(int i)
        {
            return (ListModel)lm.get(i);
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            pos = i;
            if (view == null)
            {
                view = ((LayoutInflater)activity.getSystemService("layout_inflater")).inflate(resource, null);
                viewgroup = new ViewHolder();
                viewgroup.imageHp = (ImageView)view.findViewById(0x7f0b023d);
                viewgroup.list_txtMerek = (TextView)view.findViewById(0x7f0b033c);
                viewgroup.list_txtHarga = (TextView)view.findViewById(0x7f0b033d);
                viewgroup.list_txtCodename = (TextView)view.findViewById(0x7f0b033f);
                viewgroup.list_text_like = (TextView)view.findViewById(0x7f0b0344);
                viewgroup.list_text_dislike = (TextView)view.findViewById(0x7f0b0347);
                viewgroup.list_text_komentar = (TextView)view.findViewById(0x7f0b034a);
                viewgroup.list_like = (ImageView)view.findViewById(0x7f0b0343);
                viewgroup.list_dislike = (ImageView)view.findViewById(0x7f0b0346);
                viewgroup.progressbar_item = (ProgressBar)view.findViewById(0x7f0b00b3);
                viewgroup.ll_master_item = (LinearLayout)view.findViewById(0x7f0b084e);
                viewgroup.list_lay_like = (RelativeLayout)view.findViewById(0x7f0b0342);
                viewgroup.list_lay_dislike = (RelativeLayout)view.findViewById(0x7f0b0345);
                viewgroup.list_lay_kom = (RelativeLayout)view.findViewById(0x7f0b0348);
                viewgroup.rateRate = (RatingBar)view.findViewById(0x7f0b00c9);
                view.setTag(viewgroup);
            } else
            {
                viewgroup = (ViewHolder)view.getTag();
            }
            lms = (ListModel)lm.get(i);
            if (lm != null)
            {
                hrg_baru = lms.getHrg_baru();
                hrg_bekas = lms.getHrg_bekas();
                ((ViewHolder) (viewgroup)).list_txtMerek.setText((new StringBuilder(String.valueOf(lms.getMerk()))).append(" ").append(lms.getModel()).toString());
                ((ViewHolder) (viewgroup)).list_txtCodename.setText(lms.getCodename());
                ((ViewHolder) (viewgroup)).list_text_like.setText(lms.getTotal_like());
                ((ViewHolder) (viewgroup)).list_text_dislike.setText(lms.getTotal_dislike());
                ((ViewHolder) (viewgroup)).list_text_komentar.setText(lms.getTotal_kom());
                if (lms.getMy_like_pon().toString().equals("1"))
                {
                    ((ViewHolder) (viewgroup)).list_like.setBackgroundResource(0x7f02025b);
                    ((ViewHolder) (viewgroup)).list_dislike.setBackgroundResource(0x7f0201a3);
                    ((ViewHolder) (viewgroup)).list_lay_like.setEnabled(false);
                    ((ViewHolder) (viewgroup)).list_lay_dislike.setEnabled(true);
                } else
                if (lms.getMy_like_pon().toString().equals("0"))
                {
                    ((ViewHolder) (viewgroup)).list_like.setBackgroundResource(0x7f020257);
                    ((ViewHolder) (viewgroup)).list_dislike.setBackgroundResource(0x7f0201a7);
                    ((ViewHolder) (viewgroup)).list_lay_like.setEnabled(true);
                    ((ViewHolder) (viewgroup)).list_lay_dislike.setEnabled(false);
                } else
                {
                    ((ViewHolder) (viewgroup)).list_lay_like.setEnabled(true);
                    ((ViewHolder) (viewgroup)).list_lay_dislike.setEnabled(true);
                    ((ViewHolder) (viewgroup)).list_like.setBackgroundResource(0x7f020257);
                    ((ViewHolder) (viewgroup)).list_dislike.setBackgroundResource(0x7f0201a3);
                    ((ViewHolder) (viewgroup)).list_lay_like.setBackgroundResource(0x7f020079);
                    ((ViewHolder) (viewgroup)).list_lay_dislike.setBackgroundResource(0x7f020079);
                }
                if (hrg_bekas.equals("0") && hrg_baru.equals("0") || hrg_bekas.equals("-") && hrg_baru.equals("-"))
                {
                    ((ViewHolder) (viewgroup)).list_txtHarga.setVisibility(8);
                } else
                if (hrg_bekas.equals("0") || hrg_bekas.equals("-"))
                {
                    ((ViewHolder) (viewgroup)).list_txtHarga.setVisibility(8);
                } else
                if (hrg_baru.equals("0") || hrg_baru.equals("-"))
                {
                    ((ViewHolder) (viewgroup)).list_txtHarga.setVisibility(8);
                } else
                {
                    ((ViewHolder) (viewgroup)).list_txtHarga.setVisibility(8);
                }
                ((ViewHolder) (viewgroup)).list_lay_like.setOnClickListener(i. new android.view.View.OnClickListener() {

                    final ListPendatangAdapter this$1;
                    private final int val$position;

                    public void onClick(View view)
                    {
                        if (userFunctions.isUserLoggedIn(activity))
                        {
                            pos = position;
                            statusPendatang = "1";
                            statusLikeHpPend = "1";
                            indexhp = getListModel(position).getId_hp();
                            ponselBaseApp.getObserver().setIndexHp(getListModel(position).getCodename());
                            namalengkapbgskrg = (new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString();
                            try
                            {
                                finalUrl = (new StringBuilder("idhp=")).append(getListModel(position).getId_hp()).append("&email=").append(username).append("&namalengkap=").append(URLEncoder.encode((new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString(), "utf-8")).append("&status=").append(statusPendatang).append("&t=").append(t).toString();
                            }
                            // Misplaced declaration of an exception variable
                            catch (View view)
                            {
                                view.printStackTrace();
                            }
                            Log.e("finalurl", finalUrl);
                            if (android.os.Build.VERSION.SDK_INT >= 11)
                            {
                                (new ListPendatangAdapter.PostBagusKurangTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                                return;
                            } else
                            {
                                (new ListPendatangAdapter.PostBagusKurangTask()).execute(new Void[0]);
                                return;
                            }
                        } else
                        {
                            view = new android.app.AlertDialog.Builder(activity);
                            view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                            view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                                final ListPendatangAdapter._cls1 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = ListPendatangAdapter._cls1.this;
                super();
            }
                            });
                            view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                                final ListPendatangAdapter._cls1 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(activity, com/inponsel/android/v2/RegisterActivity);
                                    activity.startActivityForResult(dialoginterface, 0);
                                    overridePendingTransition(0x7f040003, 0x7f040004);
                                }

            
            {
                this$2 = ListPendatangAdapter._cls1.this;
                super();
            }
                            });
                            view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                                final ListPendatangAdapter._cls1 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(activity, com/inponsel/android/v2/LoginActivity);
                                    dialoginterface.putExtra("activity", "main");
                                    activity.startActivityForResult(dialoginterface, 0);
                                    overridePendingTransition(0x7f040003, 0x7f040004);
                                }

            
            {
                this$2 = ListPendatangAdapter._cls1.this;
                super();
            }
                            });
                            view.show();
                            return;
                        }
                    }


            
            {
                this$1 = final_listpendatangadapter;
                position = I.this;
                super();
            }
                });
                ((ViewHolder) (viewgroup)).list_lay_dislike.setOnClickListener(i. new android.view.View.OnClickListener() {

                    final ListPendatangAdapter this$1;
                    private final int val$position;

                    public void onClick(View view)
                    {
                        if (userFunctions.isUserLoggedIn(activity))
                        {
                            pos = position;
                            indexhp = getListModel(position).getId_hp();
                            ponselBaseApp.getObserver().setIndexHp(getListModel(position).getCodename());
                            statusPendatang = "0";
                            statusLikeHpPend = "0";
                            namalengkapbgskrg = (new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString();
                            try
                            {
                                finalUrl = (new StringBuilder("idhp=")).append(getListModel(position).getId_hp()).append("&email=").append(username).append("&namalengkap=").append(URLEncoder.encode((new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString(), "utf-8")).append("&status=").append(statusPendatang).append("&t=").append(t).toString();
                            }
                            // Misplaced declaration of an exception variable
                            catch (View view)
                            {
                                view.printStackTrace();
                            }
                            Log.e("finalurl", finalUrl);
                            if (android.os.Build.VERSION.SDK_INT >= 11)
                            {
                                (new ListPendatangAdapter.PostBagusKurangTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                                return;
                            } else
                            {
                                (new ListPendatangAdapter.PostBagusKurangTask()).execute(new Void[0]);
                                return;
                            }
                        } else
                        {
                            view = new android.app.AlertDialog.Builder(activity);
                            view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                            view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                                final ListPendatangAdapter._cls2 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = ListPendatangAdapter._cls2.this;
                super();
            }
                            });
                            view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                                final ListPendatangAdapter._cls2 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(activity, com/inponsel/android/v2/RegisterActivity);
                                    activity.startActivityForResult(dialoginterface, 0);
                                    overridePendingTransition(0x7f040003, 0x7f040004);
                                }

            
            {
                this$2 = ListPendatangAdapter._cls2.this;
                super();
            }
                            });
                            view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                                final ListPendatangAdapter._cls2 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(activity, com/inponsel/android/v2/LoginActivity);
                                    dialoginterface.putExtra("activity", "main");
                                    activity.startActivityForResult(dialoginterface, 0);
                                    overridePendingTransition(0x7f040003, 0x7f040004);
                                }

            
            {
                this$2 = ListPendatangAdapter._cls2.this;
                super();
            }
                            });
                            view.show();
                            return;
                        }
                    }


            
            {
                this$1 = final_listpendatangadapter;
                position = I.this;
                super();
            }
                });
                ((ViewHolder) (viewgroup)).list_lay_kom.setOnClickListener(i. new android.view.View.OnClickListener() {

                    final ListPendatangAdapter this$1;
                    private final int val$position;

                    public void onClick(View view)
                    {
                        view = new Intent(getApplicationContext(), com/inponsel/android/v2/KomentarPonsel);
                        view.putExtra("id_hph", getListModel(position).getId_hp());
                        view.putExtra("namalengkap", getListModel(position).getNamalengkap());
                        view.putExtra("codename", getListModel(position).getCodename());
                        view.putExtra("model", getListModel(position).getModel());
                        view.putExtra("merk", getListModel(position).getMerk());
                        view.putExtra("gambar", getListModel(position).getGambar());
                        view.putExtra("hrg_baru", getListModel(position).getHrg_baru());
                        view.putExtra("hrg_bekas", getListModel(position).getHrg_bekas());
                        view.putExtra("tot_like", getListModel(position).getTotal_like());
                        view.putExtra("tot_dislike", getListModel(position).getTotal_dislike());
                        view.putExtra("tot_komen", getListModel(position).getTotal_kom());
                        startActivityForResult(view, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$1 = final_listpendatangadapter;
                position = I.this;
                super();
            }
                });
                try
                {
                    Picasso.with(activity).load((new StringBuilder(String.valueOf(Util.BASE_PATH_NEWIMAGE))).append(lms.getGambar().trim()).toString()).tag(activity).into(((ViewHolder) (viewgroup)).imageHp, viewgroup. new Callback() {

                        final ListPendatangAdapter this$1;
                        private final ListPendatangAdapter.ViewHolder val$holder;

                        public void onError()
                        {
                            holder.progressbar_item.setVisibility(8);
                        }

                        public void onSuccess()
                        {
                            holder.progressbar_item.setVisibility(8);
                            holder.imageHp.setVisibility(0);
                        }

            
            {
                this$1 = final_listpendatangadapter;
                holder = ListPendatangAdapter.ViewHolder.this;
                super();
            }
                    });
                }
                // Misplaced declaration of an exception variable
                catch (ViewGroup viewgroup)
                {
                    return view;
                }
            }
            return view;
        }

        void log(String s)
        {
        }

        public void setListArray(ArrayList arraylist)
        {
            lm = arraylist;
        }

        public void update(Observable observable, Object obj)
        {
            Log.e("getUpdateTypePendatang", ponselBaseApp.getObserver().getUpdateType().toString());
            if (ponselBaseApp.getObserver().getUpdateType().toString().equals("komentar"))
            {
                Log.e("updateViewKomenPonsel", ponselBaseApp.getObserver().getUpdateType().toString());
                updateViewKomenPonsel(ponselBaseApp.getObserver().getIndexHp());
            } else
            if (ponselBaseApp.getObserver().getUpdateType().toString().equals("likedisPonsel"))
            {
                Log.e("updateViewLikeDisPonsel", ponselBaseApp.getObserver().getUpdateType().toString());
                if (random_codename.equals(ponselBaseApp.getObserver().getIndexHp()))
                {
                    load_random_hp();
                }
                updateViewLikeDisPonsel(ponselBaseApp.getObserver().getIndexHp());
                return;
            }
        }

        public void updateViewKomenPonsel(String s)
        {
            Log.e("ponselBaseApp", s);
            int i = 0;
            do
            {
                if (i >= listPendatang.getChildCount())
                {
                    return;
                }
                Log.e("int i", String.valueOf(i));
                View view = listPendatang.getChildAt(i);
                TextView textview = (TextView)view.findViewById(0x7f0b0344);
                TextView textview1 = (TextView)view.findViewById(0x7f0b0347);
                TextView textview2 = (TextView)view.findViewById(0x7f0b034a);
                if (((TextView)view.findViewById(0x7f0b033f)).getText().toString().equals(s))
                {
                    textview.setText(ponselBaseApp.getObserver().getTot_LikePon());
                    textview1.setText(ponselBaseApp.getObserver().getTotdis_LikePon());
                    textview2.setText(ponselBaseApp.getObserver().getJum_komenLikePon());
                }
                i++;
            } while (true);
        }

        public void updateViewLikeDisPonsel(String s)
        {
            int i;
            Log.e("ponselBaseAppPendatang", s);
            i = 0;
_L2:
            ImageView imageview;
            ImageView imageview1;
            RelativeLayout relativelayout;
            Object obj;
            if (i >= listPendatang.getChildCount())
            {
                return;
            }
            Log.e("int i", String.valueOf(i));
            obj = listPendatang.getChildAt(i);
            TextView textview = (TextView)((View) (obj)).findViewById(0x7f0b0344);
            TextView textview1 = (TextView)((View) (obj)).findViewById(0x7f0b0347);
            imageview = (ImageView)((View) (obj)).findViewById(0x7f0b0343);
            imageview1 = (ImageView)((View) (obj)).findViewById(0x7f0b0346);
            TextView textview2 = (TextView)((View) (obj)).findViewById(0x7f0b034a);
            TextView textview3 = (TextView)((View) (obj)).findViewById(0x7f0b033f);
            relativelayout = (RelativeLayout)((View) (obj)).findViewById(0x7f0b0342);
            obj = (RelativeLayout)((View) (obj)).findViewById(0x7f0b0345);
            if (textview3.getText().toString().equals(s))
            {
                Log.e("getTot_LikePonPend", ponselBaseApp.getObserver().getJum_komenLikePon().toString());
                Log.e("getTot_LikePonPend", ponselBaseApp.getObserver().getTot_LikePon().toString());
                Log.e("getTotdis_LikePonPend", ponselBaseApp.getObserver().getTotdis_LikePon().toString());
                textview.setText(ponselBaseApp.getObserver().getTot_LikePon());
                textview1.setText(ponselBaseApp.getObserver().getTotdis_LikePon());
                textview2.setText(ponselBaseApp.getObserver().getJum_komenLikePon());
                if (!ponselBaseApp.getObserver().getStatus_like_ponsel().equals("1"))
                {
                    break; /* Loop/switch isn't completed */
                }
                imageview.setBackgroundResource(0x7f02025b);
                imageview1.setBackgroundResource(0x7f0201a3);
                relativelayout.setEnabled(false);
                ((RelativeLayout) (obj)).setEnabled(true);
            }
_L3:
            i++;
            if (true) goto _L2; else goto _L1
_L1:
            if (ponselBaseApp.getObserver().getStatus_like_ponsel().equals("0"))
            {
                imageview.setBackgroundResource(0x7f020257);
                imageview1.setBackgroundResource(0x7f0201a7);
                relativelayout.setEnabled(true);
                ((RelativeLayout) (obj)).setEnabled(false);
            } else
            {
                imageview.setBackgroundResource(0x7f020257);
                imageview1.setBackgroundResource(0x7f0201a3);
                relativelayout.setBackgroundResource(0x7f020079);
                ((RelativeLayout) (obj)).setBackgroundResource(0x7f020079);
            }
              goto _L3
            if (true) goto _L2; else goto _L4
_L4:
        }



        public ListPendatangAdapter(Activity activity1, int i, ArrayList arraylist)
        {
            this$0 = HomeNewMainActivity.this;
            super();
            fmt = new DecimalFormat();
            fmts = new DecimalFormatSymbols();
            t = Utility.session(RestClient.pelihara);
            user = "";
            komen = "";
            email_user = "";
            finalUrl = "";
            t = Utility.session(t);
            lm = arraylist;
            activity = activity1;
            resource = i;
            ponselBaseApp = (PonselBaseApp)getApplication();
            ponselBaseApp.getObserver().addObserver(this);
            try
            {
                userFunctions = new UserFunctions();
                db = new DatabaseHandler(activity1);
                if (userFunctions.isUserLoggedIn(activity1))
                {
                    cursor = db.getAllData();
                    cursor.moveToFirst();
                    username = cursor.getString(4);
                    email_user = cursor.getString(5);
                }
                t = Utility.session(t);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (HomeNewMainActivity homenewmainactivity)
            {
                return;
            }
        }
    }

    public class ListPendatangAdapter.PostBagusKurangTask extends AsyncTask
    {

        final ListPendatangAdapter this$1;

        private void parseJSONLikePon(String s)
        {
            int i;
            try
            {
                JSONObject jsonobject = new JSONObject(s);
                postStatusPendLikePon = jsonobject.getString("success");
                postMessagePendLikePon = jsonobject.getString("message");
                Log.e("postStatusLikePon", s);
                jArray = jsonobject.getJSONArray("InPonsel");
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
            jum_komenLikePonPend = s.getString("total_kom");
            tot_LikePonPend = s.getString("total_like");
            totdis_LikePonPend = s.getString("total_dislike");
            Log.e("jum_komenLikePon", jum_komenLikePonPend);
            Log.e("tot_LikePon", tot_LikePonPend);
            Log.e("totdis_LikePon", totdis_LikePonPend);
            ponselBaseApp.getObserver().setJum_komenLikePon(jum_komenLikePonPend);
            ponselBaseApp.getObserver().setTot_LikePon(tot_LikePonPend);
            ponselBaseApp.getObserver().setTotdis_LikePon(totdis_LikePonPend);
            ponselBaseApp.getObserver().setUpdateType("likedisPonsel");
            i++;
            if (false)
            {
            } else
            {
                break MISSING_BLOCK_LABEL_65;
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
                if (android.os.Build.VERSION.SDK_INT > 9)
                {
                    StrictMode.setThreadPolicy((new android.os.StrictMode.ThreadPolicy.Builder()).permitAll().build());
                }
                Log.e("posA", String.valueOf(pos));
                avoid = finalUrl;
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("likedis_ponsel").append(Utility.BASE_FORMAT).append("?").append(avoid).toString();
                Log.e("pushURL", avoid);
                avoid = HttpPush.getResponse(avoid);
                res = avoid.toString();
                parseJSONLikePon(res);
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
            Log.e("postStatusLikePon", postStatusPendLikePon);
            if (!postStatusPendLikePon.equals("1"))
            {
                break MISSING_BLOCK_LABEL_121;
            }
            notificationLikeHelper.completed(namalengkapbgskrg, notificationLikeHelper.SucdislikeStatement);
            if (statusLikeHpPend.equals("1"))
            {
                ponselBaseApp.getObserver().setStatus_like_ponsel("1");
                return;
            }
            try
            {
                ponselBaseApp.getObserver().setStatus_like_ponsel("0");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
            notificationLikeHelper.gagal(namalengkapbgskrg, notificationLikeHelper.gagallikeStatement);
            return;
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            if (statusLikeHpPend.equals("1"))
            {
                notificationLikeHelper.createNotification(namalengkapbgskrg, notificationLikeHelper.likeStatement);
                return;
            } else
            {
                notificationLikeHelper.createNotification(namalengkapbgskrg, notificationLikeHelper.dislikeStatement);
                return;
            }
        }

        public ListPendatangAdapter.PostBagusKurangTask()
        {
            this$1 = ListPendatangAdapter.this;
            super();
        }
    }

    class ListPendatangAdapter.ViewHolder
    {

        ImageView imageHp;
        ImageView list_dislike;
        RelativeLayout list_lay_dislike;
        RelativeLayout list_lay_kom;
        RelativeLayout list_lay_like;
        ImageView list_like;
        TextView list_text_dislike;
        TextView list_text_komentar;
        TextView list_text_like;
        TextView list_txtCodename;
        TextView list_txtHarga;
        TextView list_txtMerek;
        LinearLayout ll_master_item;
        ProgressBar progressbar_item;
        RatingBar rateRate;
        final ListPendatangAdapter this$1;

        ListPendatangAdapter.ViewHolder()
        {
            this$1 = ListPendatangAdapter.this;
            super();
        }
    }

    public class ListRilisTerbaruAdapter extends BaseAdapter
        implements Observer
    {

        private Activity activity;
        Context context;
        Cursor cursor;
        DatabaseHandler db;
        String email_user;
        String finalUrl;
        DecimalFormat fmt;
        DecimalFormatSymbols fmts;
        int hargaBaru;
        int hargaBekas;
        String hrg_baru;
        String hrg_bekas;
        String komen;
        private ArrayList lm;
        ListModel lms;
        PonselBaseApp ponselBaseApp;
        int pos;
        String res;
        int resource;
        String response;
        String statusLikeHpRilis;
        String statusRilis;
        String t;
        final HomeNewMainActivity this$0;
        String user;
        UserFunctions userFunctions;

        public int getCount()
        {
            return lm.size();
        }

        public Object getItem(int i)
        {
            return null;
        }

        public long getItemId(int i)
        {
            return 0L;
        }

        public ListModel getListModel(int i)
        {
            return (ListModel)lm.get(i);
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            pos = i;
            if (view == null)
            {
                view = ((LayoutInflater)activity.getSystemService("layout_inflater")).inflate(resource, null);
                viewgroup = new ViewHolder();
                viewgroup.imageHp = (ImageView)view.findViewById(0x7f0b023d);
                viewgroup.list_txtMerek = (TextView)view.findViewById(0x7f0b033c);
                viewgroup.list_txtHarga = (TextView)view.findViewById(0x7f0b033d);
                viewgroup.list_txtCodename = (TextView)view.findViewById(0x7f0b033f);
                viewgroup.list_text_like = (TextView)view.findViewById(0x7f0b0344);
                viewgroup.list_text_dislike = (TextView)view.findViewById(0x7f0b0347);
                viewgroup.list_text_komentar = (TextView)view.findViewById(0x7f0b034a);
                viewgroup.list_like = (ImageView)view.findViewById(0x7f0b0343);
                viewgroup.list_dislike = (ImageView)view.findViewById(0x7f0b0346);
                viewgroup.progressbar_item = (ProgressBar)view.findViewById(0x7f0b00b3);
                viewgroup.ll_master_item = (LinearLayout)view.findViewById(0x7f0b084e);
                viewgroup.list_lay_like = (RelativeLayout)view.findViewById(0x7f0b0342);
                viewgroup.list_lay_dislike = (RelativeLayout)view.findViewById(0x7f0b0345);
                viewgroup.list_lay_kom = (RelativeLayout)view.findViewById(0x7f0b0348);
                viewgroup.rateRate = (RatingBar)view.findViewById(0x7f0b00c9);
                view.setTag(viewgroup);
            } else
            {
                viewgroup = (ViewHolder)view.getTag();
            }
            lms = (ListModel)lm.get(i);
            if (lm != null)
            {
                hrg_baru = lms.getHrg_baru();
                hrg_bekas = lms.getHrg_bekas();
                ((ViewHolder) (viewgroup)).list_txtMerek.setText((new StringBuilder(String.valueOf(lms.getMerk()))).append(" ").append(lms.getModel()).toString());
                ((ViewHolder) (viewgroup)).list_txtCodename.setText(lms.getCodename());
                ((ViewHolder) (viewgroup)).list_text_like.setText(lms.getTotal_like());
                ((ViewHolder) (viewgroup)).list_text_dislike.setText(lms.getTotal_dislike());
                ((ViewHolder) (viewgroup)).list_text_komentar.setText(lms.getTotal_kom());
                if (lms.getMy_like_pon().toString().equals("1"))
                {
                    ((ViewHolder) (viewgroup)).list_like.setBackgroundResource(0x7f02025b);
                    ((ViewHolder) (viewgroup)).list_dislike.setBackgroundResource(0x7f0201a3);
                    ((ViewHolder) (viewgroup)).list_lay_like.setEnabled(false);
                    ((ViewHolder) (viewgroup)).list_lay_dislike.setEnabled(true);
                } else
                if (lms.getMy_like_pon().toString().equals("0"))
                {
                    ((ViewHolder) (viewgroup)).list_like.setBackgroundResource(0x7f020257);
                    ((ViewHolder) (viewgroup)).list_dislike.setBackgroundResource(0x7f0201a7);
                    ((ViewHolder) (viewgroup)).list_lay_like.setEnabled(true);
                    ((ViewHolder) (viewgroup)).list_lay_dislike.setEnabled(false);
                } else
                {
                    ((ViewHolder) (viewgroup)).list_lay_like.setEnabled(true);
                    ((ViewHolder) (viewgroup)).list_lay_dislike.setEnabled(true);
                    ((ViewHolder) (viewgroup)).list_like.setBackgroundResource(0x7f020257);
                    ((ViewHolder) (viewgroup)).list_dislike.setBackgroundResource(0x7f0201a3);
                    ((ViewHolder) (viewgroup)).list_lay_like.setBackgroundResource(0x7f020079);
                    ((ViewHolder) (viewgroup)).list_lay_dislike.setBackgroundResource(0x7f020079);
                }
                if (lms.getUmu_status().equals("3") || hrg_baru.equals("-") || hrg_baru.equals("0"))
                {
                    ((ViewHolder) (viewgroup)).list_txtHarga.setVisibility(8);
                } else
                {
                    ((ViewHolder) (viewgroup)).list_txtHarga.setVisibility(0);
                    ((ViewHolder) (viewgroup)).list_txtHarga.setText((new StringBuilder()).append(hrg_baru).toString());
                }
                ((ViewHolder) (viewgroup)).list_lay_like.setOnClickListener(i. new android.view.View.OnClickListener() {

                    final ListRilisTerbaruAdapter this$1;
                    private final int val$position;

                    public void onClick(View view)
                    {
                        if (userFunctions.isUserLoggedIn(activity))
                        {
                            pos = position;
                            statusRilis = "1";
                            statusLikeHpRilis = "1";
                            indexhp = getListModel(position).getId_hp();
                            ponselBaseApp.getObserver().setIndexHp(getListModel(position).getCodename());
                            namalengkapbgskrg = (new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString();
                            try
                            {
                                finalUrl = (new StringBuilder("idhp=")).append(getListModel(position).getId_hp()).append("&email=").append(username).append("&namalengkap=").append(URLEncoder.encode((new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString(), "utf-8")).append("&status=").append(statusRilis).append("&t=").append(t).toString();
                            }
                            // Misplaced declaration of an exception variable
                            catch (View view)
                            {
                                view.printStackTrace();
                            }
                            Log.e("finalurl", finalUrl);
                            if (android.os.Build.VERSION.SDK_INT >= 11)
                            {
                                (new ListRilisTerbaruAdapter.PostBagusKurangTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                                return;
                            } else
                            {
                                (new ListRilisTerbaruAdapter.PostBagusKurangTask()).execute(new Void[0]);
                                return;
                            }
                        } else
                        {
                            view = new android.app.AlertDialog.Builder(activity);
                            view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                            view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                                final ListRilisTerbaruAdapter._cls1 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = ListRilisTerbaruAdapter._cls1.this;
                super();
            }
                            });
                            view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                                final ListRilisTerbaruAdapter._cls1 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(activity, com/inponsel/android/v2/RegisterActivity);
                                    activity.startActivityForResult(dialoginterface, 0);
                                    overridePendingTransition(0x7f040003, 0x7f040004);
                                }

            
            {
                this$2 = ListRilisTerbaruAdapter._cls1.this;
                super();
            }
                            });
                            view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                                final ListRilisTerbaruAdapter._cls1 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(activity, com/inponsel/android/v2/LoginActivity);
                                    dialoginterface.putExtra("activity", "main");
                                    activity.startActivityForResult(dialoginterface, 0);
                                    overridePendingTransition(0x7f040003, 0x7f040004);
                                }

            
            {
                this$2 = ListRilisTerbaruAdapter._cls1.this;
                super();
            }
                            });
                            view.show();
                            return;
                        }
                    }


            
            {
                this$1 = final_listrilisterbaruadapter;
                position = I.this;
                super();
            }
                });
                ((ViewHolder) (viewgroup)).list_lay_dislike.setOnClickListener(i. new android.view.View.OnClickListener() {

                    final ListRilisTerbaruAdapter this$1;
                    private final int val$position;

                    public void onClick(View view)
                    {
                        if (userFunctions.isUserLoggedIn(activity))
                        {
                            pos = position;
                            indexhp = getListModel(position).getId_hp();
                            ponselBaseApp.getObserver().setIndexHp(getListModel(position).getCodename());
                            statusRilis = "0";
                            statusLikeHpRilis = "0";
                            namalengkapbgskrg = (new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString();
                            try
                            {
                                finalUrl = (new StringBuilder("idhp=")).append(getListModel(position).getId_hp()).append("&email=").append(username).append("&namalengkap=").append(URLEncoder.encode((new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString(), "utf-8")).append("&status=").append(statusRilis).append("&t=").append(t).toString();
                            }
                            // Misplaced declaration of an exception variable
                            catch (View view)
                            {
                                view.printStackTrace();
                            }
                            Log.e("finalurl", finalUrl);
                            if (android.os.Build.VERSION.SDK_INT >= 11)
                            {
                                (new ListRilisTerbaruAdapter.PostBagusKurangTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                                return;
                            } else
                            {
                                (new ListRilisTerbaruAdapter.PostBagusKurangTask()).execute(new Void[0]);
                                return;
                            }
                        } else
                        {
                            view = new android.app.AlertDialog.Builder(activity);
                            view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                            view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                                final ListRilisTerbaruAdapter._cls2 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = ListRilisTerbaruAdapter._cls2.this;
                super();
            }
                            });
                            view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                                final ListRilisTerbaruAdapter._cls2 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(activity, com/inponsel/android/v2/RegisterActivity);
                                    activity.startActivityForResult(dialoginterface, 0);
                                    overridePendingTransition(0x7f040003, 0x7f040004);
                                }

            
            {
                this$2 = ListRilisTerbaruAdapter._cls2.this;
                super();
            }
                            });
                            view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                                final ListRilisTerbaruAdapter._cls2 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(activity, com/inponsel/android/v2/LoginActivity);
                                    dialoginterface.putExtra("activity", "main");
                                    activity.startActivityForResult(dialoginterface, 0);
                                    overridePendingTransition(0x7f040003, 0x7f040004);
                                }

            
            {
                this$2 = ListRilisTerbaruAdapter._cls2.this;
                super();
            }
                            });
                            view.show();
                            return;
                        }
                    }


            
            {
                this$1 = final_listrilisterbaruadapter;
                position = I.this;
                super();
            }
                });
                ((ViewHolder) (viewgroup)).list_lay_kom.setOnClickListener(i. new android.view.View.OnClickListener() {

                    final ListRilisTerbaruAdapter this$1;
                    private final int val$position;

                    public void onClick(View view)
                    {
                        view = new Intent(getApplicationContext(), com/inponsel/android/v2/KomentarPonsel);
                        view.putExtra("id_hph", getListModel(position).getId_hp());
                        view.putExtra("namalengkap", getListModel(position).getNamalengkap());
                        view.putExtra("codename", getListModel(position).getCodename());
                        view.putExtra("model", getListModel(position).getModel());
                        view.putExtra("merk", getListModel(position).getMerk());
                        view.putExtra("gambar", getListModel(position).getGambar());
                        view.putExtra("hrg_baru", getListModel(position).getHrg_baru());
                        view.putExtra("hrg_bekas", getListModel(position).getHrg_bekas());
                        view.putExtra("tot_like", getListModel(position).getTotal_like());
                        view.putExtra("tot_dislike", getListModel(position).getTotal_dislike());
                        view.putExtra("tot_komen", getListModel(position).getTotal_kom());
                        startActivityForResult(view, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$1 = final_listrilisterbaruadapter;
                position = I.this;
                super();
            }
                });
                try
                {
                    Picasso.with(activity).load((new StringBuilder(String.valueOf(Util.BASE_PATH_NEWIMAGE))).append(lms.getGambar().trim()).toString()).tag(activity).into(((ViewHolder) (viewgroup)).imageHp, viewgroup. new Callback() {

                        final ListRilisTerbaruAdapter this$1;
                        private final ListRilisTerbaruAdapter.ViewHolder val$holder;

                        public void onError()
                        {
                            holder.progressbar_item.setVisibility(8);
                        }

                        public void onSuccess()
                        {
                            holder.progressbar_item.setVisibility(8);
                            holder.imageHp.setVisibility(0);
                        }

            
            {
                this$1 = final_listrilisterbaruadapter;
                holder = ListRilisTerbaruAdapter.ViewHolder.this;
                super();
            }
                    });
                }
                // Misplaced declaration of an exception variable
                catch (ViewGroup viewgroup)
                {
                    return view;
                }
            }
            return view;
        }

        void log(String s)
        {
        }

        public void setListArray(ArrayList arraylist)
        {
            lm = arraylist;
        }

        public void update(Observable observable, Object obj)
        {
            Log.e("getUpdateTypeRilis", ponselBaseApp.getObserver().getUpdateType().toString());
            if (ponselBaseApp.getObserver().getUpdateType().toString().equals("komentar"))
            {
                Log.e("updateViewKomenPonsel", ponselBaseApp.getObserver().getUpdateType().toString());
                updateViewKomenPonsel(ponselBaseApp.getObserver().getIndexHp());
            } else
            if (ponselBaseApp.getObserver().getUpdateType().toString().equals("likedisPonsel"))
            {
                Log.e("updateViewLikeDisPonsel", ponselBaseApp.getObserver().getUpdateType().toString());
                updateViewLikeDisPonsel(ponselBaseApp.getObserver().getIndexHp());
                if (random_codename.equals(ponselBaseApp.getObserver().getIndexHp()))
                {
                    load_random_hp();
                    return;
                }
            }
        }

        public void updateViewKomenPonsel(String s)
        {
            Log.e("ponselBaseApp", s);
            int i = 0;
            do
            {
                if (i >= listRilis.getChildCount())
                {
                    return;
                }
                Log.e("int i", String.valueOf(i));
                View view = listRilis.getChildAt(i);
                TextView textview = (TextView)view.findViewById(0x7f0b0344);
                TextView textview1 = (TextView)view.findViewById(0x7f0b0347);
                TextView textview2 = (TextView)view.findViewById(0x7f0b034a);
                if (((TextView)view.findViewById(0x7f0b033f)).getText().toString().equals(s))
                {
                    textview.setText(ponselBaseApp.getObserver().getTot_LikePon());
                    textview1.setText(ponselBaseApp.getObserver().getTotdis_LikePon());
                    textview2.setText(ponselBaseApp.getObserver().getJum_komenLikePon());
                }
                i++;
            } while (true);
        }

        public void updateViewLikeDisPonsel(String s)
        {
            int i;
            Log.e("ponselBaseApp", s);
            Log.e("listRilis.getChildCount()", String.valueOf(listRilis.getChildCount()));
            i = 0;
_L2:
            ImageView imageview;
            ImageView imageview1;
            RelativeLayout relativelayout;
            Object obj;
            if (i >= listRilis.getChildCount())
            {
                return;
            }
            Log.e("int itRilis", String.valueOf(i));
            obj = listRilis.getChildAt(i);
            TextView textview = (TextView)((View) (obj)).findViewById(0x7f0b0344);
            TextView textview1 = (TextView)((View) (obj)).findViewById(0x7f0b0347);
            imageview = (ImageView)((View) (obj)).findViewById(0x7f0b0343);
            imageview1 = (ImageView)((View) (obj)).findViewById(0x7f0b0346);
            TextView textview2 = (TextView)((View) (obj)).findViewById(0x7f0b034a);
            TextView textview3 = (TextView)((View) (obj)).findViewById(0x7f0b033f);
            relativelayout = (RelativeLayout)((View) (obj)).findViewById(0x7f0b0342);
            obj = (RelativeLayout)((View) (obj)).findViewById(0x7f0b0345);
            if (textview3.getText().toString().equals(s))
            {
                Log.e("getTot_LikePonPend", ponselBaseApp.getObserver().getJum_komenLikePon().toString());
                Log.e("getTot_LikePonPend", ponselBaseApp.getObserver().getTot_LikePon().toString());
                Log.e("getTotdis_LikePonPend", ponselBaseApp.getObserver().getTotdis_LikePon().toString());
                textview.setText(ponselBaseApp.getObserver().getTot_LikePon());
                textview1.setText(ponselBaseApp.getObserver().getTotdis_LikePon());
                textview2.setText(ponselBaseApp.getObserver().getJum_komenLikePon());
                if (!ponselBaseApp.getObserver().getStatus_like_ponsel().equals("1"))
                {
                    break; /* Loop/switch isn't completed */
                }
                imageview.setBackgroundResource(0x7f02025b);
                imageview1.setBackgroundResource(0x7f0201a3);
                relativelayout.setEnabled(false);
                ((RelativeLayout) (obj)).setEnabled(true);
            }
_L3:
            i++;
            if (true) goto _L2; else goto _L1
_L1:
            if (ponselBaseApp.getObserver().getStatus_like_ponsel().equals("0"))
            {
                imageview.setBackgroundResource(0x7f020257);
                imageview1.setBackgroundResource(0x7f0201a7);
                relativelayout.setEnabled(true);
                ((RelativeLayout) (obj)).setEnabled(false);
            } else
            {
                relativelayout.setEnabled(true);
                ((RelativeLayout) (obj)).setEnabled(true);
                imageview.setBackgroundResource(0x7f020257);
                imageview1.setBackgroundResource(0x7f0201a3);
                relativelayout.setBackgroundResource(0x7f020079);
                ((RelativeLayout) (obj)).setBackgroundResource(0x7f020079);
            }
              goto _L3
            if (true) goto _L2; else goto _L4
_L4:
        }



        public ListRilisTerbaruAdapter(Activity activity1, int i, ArrayList arraylist)
        {
            this$0 = HomeNewMainActivity.this;
            super();
            fmt = new DecimalFormat();
            fmts = new DecimalFormatSymbols();
            t = Utility.session(RestClient.pelihara);
            user = "";
            komen = "";
            email_user = "";
            finalUrl = "";
            t = Utility.session(t);
            lm = arraylist;
            activity = activity1;
            resource = i;
            ponselBaseApp = (PonselBaseApp)getApplication();
            ponselBaseApp.getObserver().addObserver(this);
            try
            {
                userFunctions = new UserFunctions();
                db = new DatabaseHandler(activity1);
                if (userFunctions.isUserLoggedIn(activity1))
                {
                    cursor = db.getAllData();
                    cursor.moveToFirst();
                    username = cursor.getString(4);
                    email_user = cursor.getString(5);
                }
                t = Utility.session(t);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (HomeNewMainActivity homenewmainactivity)
            {
                return;
            }
        }
    }

    public class ListRilisTerbaruAdapter.PostBagusKurangTask extends AsyncTask
    {

        final ListRilisTerbaruAdapter this$1;

        private void parseJSONLikePon(String s)
        {
            int i;
            try
            {
                JSONObject jsonobject = new JSONObject(s);
                postStatusPendLikePon = jsonobject.getString("success");
                postMessagePendLikePon = jsonobject.getString("message");
                Log.e("postStatusLikePon", s);
                jArray = jsonobject.getJSONArray("InPonsel");
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
            jum_komenLikePonPend = s.getString("total_kom");
            tot_LikePonPend = s.getString("total_like");
            totdis_LikePonPend = s.getString("total_dislike");
            Log.e("jum_komenLikePon", jum_komenLikePonPend);
            Log.e("tot_LikePon", tot_LikePonPend);
            Log.e("totdis_LikePon", totdis_LikePonPend);
            ponselBaseApp.getObserver().setJum_komenLikePon(jum_komenLikePonPend);
            ponselBaseApp.getObserver().setTot_LikePon(tot_LikePonPend);
            ponselBaseApp.getObserver().setTotdis_LikePon(totdis_LikePonPend);
            ponselBaseApp.getObserver().setUpdateType("likedisPonsel");
            i++;
            if (false)
            {
            } else
            {
                break MISSING_BLOCK_LABEL_65;
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
                if (android.os.Build.VERSION.SDK_INT > 9)
                {
                    StrictMode.setThreadPolicy((new android.os.StrictMode.ThreadPolicy.Builder()).permitAll().build());
                }
                Log.e("posA", String.valueOf(pos));
                avoid = finalUrl;
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("likedis_ponsel").append(Utility.BASE_FORMAT).append("?").append(avoid).toString();
                Log.e("pushURL", avoid);
                avoid = HttpPush.getResponse(avoid);
                res = avoid.toString();
                parseJSONLikePon(res);
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
            Log.e("postStatusLikePon", postStatusPendLikePon);
            if (!postStatusPendLikePon.equals("1"))
            {
                break MISSING_BLOCK_LABEL_121;
            }
            notificationLikeHelper.completed(namalengkapbgskrg, notificationLikeHelper.SucdislikeStatement);
            if (statusLikeHpRilis.equals("1"))
            {
                ponselBaseApp.getObserver().setStatus_like_ponsel("1");
                return;
            }
            try
            {
                ponselBaseApp.getObserver().setStatus_like_ponsel("0");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
            notificationLikeHelper.gagal(namalengkapbgskrg, notificationLikeHelper.gagallikeStatement);
            return;
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            if (statusLikeHpRilis.equals("1"))
            {
                notificationLikeHelper.createNotification(namalengkapbgskrg, notificationLikeHelper.likeStatement);
                return;
            } else
            {
                notificationLikeHelper.createNotification(namalengkapbgskrg, notificationLikeHelper.dislikeStatement);
                return;
            }
        }

        public ListRilisTerbaruAdapter.PostBagusKurangTask()
        {
            this$1 = ListRilisTerbaruAdapter.this;
            super();
        }
    }

    class ListRilisTerbaruAdapter.ViewHolder
    {

        ImageView imageHp;
        ImageView list_dislike;
        RelativeLayout list_lay_dislike;
        RelativeLayout list_lay_kom;
        RelativeLayout list_lay_like;
        ImageView list_like;
        TextView list_text_dislike;
        TextView list_text_komentar;
        TextView list_text_like;
        TextView list_txtCodename;
        TextView list_txtHarga;
        TextView list_txtMerek;
        LinearLayout ll_master_item;
        ProgressBar progressbar_item;
        RatingBar rateRate;
        final ListRilisTerbaruAdapter this$1;

        ListRilisTerbaruAdapter.ViewHolder()
        {
            this$1 = ListRilisTerbaruAdapter.this;
            super();
        }
    }

    public class ListRumorAdapter extends BaseAdapter
        implements Observer
    {

        private Activity activity;
        Context context;
        Cursor cursor;
        DatabaseHandler db;
        String email_user;
        String finalUrl;
        DecimalFormat fmt;
        DecimalFormatSymbols fmts;
        int hargaBaru;
        int hargaBekas;
        String hrg_baru;
        String hrg_bekas;
        String komen;
        private ArrayList lm;
        ListModel lms;
        PonselBaseApp ponselBaseApp;
        int pos;
        String res;
        int resource;
        String response;
        String statusLikeHpRumor;
        String statusRumor;
        String t;
        final HomeNewMainActivity this$0;
        String user;
        UserFunctions userFunctions;

        public int getCount()
        {
            return lm.size();
        }

        public Object getItem(int i)
        {
            return null;
        }

        public long getItemId(int i)
        {
            return 0L;
        }

        public ListModel getListModel(int i)
        {
            return (ListModel)lm.get(i);
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            pos = i;
            if (view == null)
            {
                view = ((LayoutInflater)activity.getSystemService("layout_inflater")).inflate(resource, null);
                viewgroup = new ViewHolder();
                viewgroup.imageHp = (ImageView)view.findViewById(0x7f0b023d);
                viewgroup.list_txtMerek = (TextView)view.findViewById(0x7f0b033c);
                viewgroup.list_txtHarga = (TextView)view.findViewById(0x7f0b033d);
                viewgroup.list_txtCodename = (TextView)view.findViewById(0x7f0b033f);
                viewgroup.list_text_like = (TextView)view.findViewById(0x7f0b0344);
                viewgroup.list_text_dislike = (TextView)view.findViewById(0x7f0b0347);
                viewgroup.list_text_komentar = (TextView)view.findViewById(0x7f0b034a);
                viewgroup.list_like = (ImageView)view.findViewById(0x7f0b0343);
                viewgroup.list_dislike = (ImageView)view.findViewById(0x7f0b0346);
                viewgroup.progressbar_item = (ProgressBar)view.findViewById(0x7f0b00b3);
                viewgroup.ll_master_item = (LinearLayout)view.findViewById(0x7f0b084e);
                viewgroup.list_lay_like = (RelativeLayout)view.findViewById(0x7f0b0342);
                viewgroup.list_lay_dislike = (RelativeLayout)view.findViewById(0x7f0b0345);
                viewgroup.list_lay_kom = (RelativeLayout)view.findViewById(0x7f0b0348);
                viewgroup.rateRate = (RatingBar)view.findViewById(0x7f0b00c9);
                view.setTag(viewgroup);
            } else
            {
                viewgroup = (ViewHolder)view.getTag();
            }
            lms = (ListModel)lm.get(i);
            if (lm != null)
            {
                ((ViewHolder) (viewgroup)).ll_master_item.setBackgroundResource(0x7f02007a);
                hrg_baru = lms.getHrg_baru();
                hrg_bekas = lms.getHrg_bekas();
                ((ViewHolder) (viewgroup)).list_txtMerek.setText((new StringBuilder(String.valueOf(lms.getMerk()))).append(" ").append(lms.getModel()).toString());
                ((ViewHolder) (viewgroup)).list_txtCodename.setText(lms.getCodename());
                ((ViewHolder) (viewgroup)).list_text_like.setText(lms.getTotal_like());
                ((ViewHolder) (viewgroup)).list_text_dislike.setText(lms.getTotal_dislike());
                ((ViewHolder) (viewgroup)).list_text_komentar.setText(lms.getTotal_kom());
                if (lms.getMy_like_pon().toString().equals("1"))
                {
                    ((ViewHolder) (viewgroup)).list_like.setBackgroundResource(0x7f02025b);
                    ((ViewHolder) (viewgroup)).list_dislike.setBackgroundResource(0x7f0201a3);
                    ((ViewHolder) (viewgroup)).list_lay_like.setEnabled(false);
                    ((ViewHolder) (viewgroup)).list_lay_dislike.setEnabled(true);
                } else
                if (lms.getMy_like_pon().toString().equals("0"))
                {
                    ((ViewHolder) (viewgroup)).list_like.setBackgroundResource(0x7f020257);
                    ((ViewHolder) (viewgroup)).list_dislike.setBackgroundResource(0x7f0201a7);
                    ((ViewHolder) (viewgroup)).list_lay_like.setEnabled(true);
                    ((ViewHolder) (viewgroup)).list_lay_dislike.setEnabled(false);
                } else
                {
                    ((ViewHolder) (viewgroup)).list_lay_like.setEnabled(true);
                    ((ViewHolder) (viewgroup)).list_lay_dislike.setEnabled(true);
                    ((ViewHolder) (viewgroup)).list_like.setBackgroundResource(0x7f020257);
                    ((ViewHolder) (viewgroup)).list_dislike.setBackgroundResource(0x7f0201a3);
                    ((ViewHolder) (viewgroup)).list_lay_like.setBackgroundResource(0x7f020079);
                    ((ViewHolder) (viewgroup)).list_lay_dislike.setBackgroundResource(0x7f020079);
                }
                if (hrg_bekas.equals("0") && hrg_baru.equals("0") || hrg_bekas.equals("-") && hrg_baru.equals("-"))
                {
                    ((ViewHolder) (viewgroup)).list_txtHarga.setVisibility(8);
                } else
                if (hrg_bekas.equals("0") || hrg_bekas.equals("-"))
                {
                    ((ViewHolder) (viewgroup)).list_txtHarga.setVisibility(8);
                } else
                if (hrg_baru.equals("0") || hrg_baru.equals("-"))
                {
                    ((ViewHolder) (viewgroup)).list_txtHarga.setVisibility(8);
                } else
                {
                    ((ViewHolder) (viewgroup)).list_txtHarga.setVisibility(8);
                }
                ((ViewHolder) (viewgroup)).list_lay_like.setOnClickListener(i. new android.view.View.OnClickListener() {

                    final ListRumorAdapter this$1;
                    private final int val$position;

                    public void onClick(View view)
                    {
                        if (userFunctions.isUserLoggedIn(activity))
                        {
                            pos = position;
                            statusRumor = "1";
                            statusLikeHpRumor = "1";
                            indexhp = getListModel(position).getId_hp();
                            ponselBaseApp.getObserver().setIndexHp(getListModel(position).getCodename());
                            namalengkapbgskrg = (new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString();
                            try
                            {
                                finalUrl = (new StringBuilder("idhp=")).append(getListModel(position).getId_hp()).append("&email=").append(username).append("&namalengkap=").append(URLEncoder.encode((new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString(), "utf-8")).append("&status=").append(statusRumor).append("&t=").append(t).toString();
                            }
                            // Misplaced declaration of an exception variable
                            catch (View view)
                            {
                                view.printStackTrace();
                            }
                            Log.e("finalurl", finalUrl);
                            if (android.os.Build.VERSION.SDK_INT >= 11)
                            {
                                (new ListRumorAdapter.PostBagusKurangTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                                return;
                            } else
                            {
                                (new ListRumorAdapter.PostBagusKurangTask()).execute(new Void[0]);
                                return;
                            }
                        } else
                        {
                            view = new android.app.AlertDialog.Builder(activity);
                            view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                            view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                                final ListRumorAdapter._cls1 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = ListRumorAdapter._cls1.this;
                super();
            }
                            });
                            view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                                final ListRumorAdapter._cls1 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(activity, com/inponsel/android/v2/RegisterActivity);
                                    activity.startActivityForResult(dialoginterface, 0);
                                    overridePendingTransition(0x7f040003, 0x7f040004);
                                }

            
            {
                this$2 = ListRumorAdapter._cls1.this;
                super();
            }
                            });
                            view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                                final ListRumorAdapter._cls1 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(activity, com/inponsel/android/v2/LoginActivity);
                                    dialoginterface.putExtra("activity", "main");
                                    activity.startActivityForResult(dialoginterface, 0);
                                    overridePendingTransition(0x7f040003, 0x7f040004);
                                }

            
            {
                this$2 = ListRumorAdapter._cls1.this;
                super();
            }
                            });
                            view.show();
                            return;
                        }
                    }


            
            {
                this$1 = final_listrumoradapter;
                position = I.this;
                super();
            }
                });
                ((ViewHolder) (viewgroup)).list_lay_dislike.setOnClickListener(i. new android.view.View.OnClickListener() {

                    final ListRumorAdapter this$1;
                    private final int val$position;

                    public void onClick(View view)
                    {
                        if (userFunctions.isUserLoggedIn(activity))
                        {
                            pos = position;
                            indexhp = getListModel(position).getId_hp();
                            ponselBaseApp.getObserver().setIndexHp(getListModel(position).getCodename());
                            statusRumor = "0";
                            statusLikeHpRumor = "0";
                            namalengkapbgskrg = (new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString();
                            try
                            {
                                finalUrl = (new StringBuilder("idhp=")).append(getListModel(position).getId_hp()).append("&email=").append(username).append("&namalengkap=").append(URLEncoder.encode((new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString(), "utf-8")).append("&status=").append(statusRumor).append("&t=").append(t).toString();
                            }
                            // Misplaced declaration of an exception variable
                            catch (View view)
                            {
                                view.printStackTrace();
                            }
                            Log.e("finalurl", finalUrl);
                            if (android.os.Build.VERSION.SDK_INT >= 11)
                            {
                                (new ListRumorAdapter.PostBagusKurangTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                                return;
                            } else
                            {
                                (new ListRumorAdapter.PostBagusKurangTask()).execute(new Void[0]);
                                return;
                            }
                        } else
                        {
                            view = new android.app.AlertDialog.Builder(activity);
                            view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                            view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                                final ListRumorAdapter._cls2 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = ListRumorAdapter._cls2.this;
                super();
            }
                            });
                            view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                                final ListRumorAdapter._cls2 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(activity, com/inponsel/android/v2/RegisterActivity);
                                    activity.startActivityForResult(dialoginterface, 0);
                                    overridePendingTransition(0x7f040003, 0x7f040004);
                                }

            
            {
                this$2 = ListRumorAdapter._cls2.this;
                super();
            }
                            });
                            view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                                final ListRumorAdapter._cls2 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(activity, com/inponsel/android/v2/LoginActivity);
                                    dialoginterface.putExtra("activity", "main");
                                    activity.startActivityForResult(dialoginterface, 0);
                                    overridePendingTransition(0x7f040003, 0x7f040004);
                                }

            
            {
                this$2 = ListRumorAdapter._cls2.this;
                super();
            }
                            });
                            view.show();
                            return;
                        }
                    }


            
            {
                this$1 = final_listrumoradapter;
                position = I.this;
                super();
            }
                });
                ((ViewHolder) (viewgroup)).list_lay_kom.setOnClickListener(i. new android.view.View.OnClickListener() {

                    final ListRumorAdapter this$1;
                    private final int val$position;

                    public void onClick(View view)
                    {
                        view = new Intent(getApplicationContext(), com/inponsel/android/v2/KomentarPonsel);
                        view.putExtra("id_hph", getListModel(position).getId_hp());
                        view.putExtra("namalengkap", getListModel(position).getNamalengkap());
                        view.putExtra("codename", getListModel(position).getCodename());
                        view.putExtra("model", getListModel(position).getModel());
                        view.putExtra("merk", getListModel(position).getMerk());
                        view.putExtra("gambar", getListModel(position).getGambar());
                        view.putExtra("hrg_baru", getListModel(position).getHrg_baru());
                        view.putExtra("hrg_bekas", getListModel(position).getHrg_bekas());
                        view.putExtra("tot_like", getListModel(position).getTotal_like());
                        view.putExtra("tot_dislike", getListModel(position).getTotal_dislike());
                        view.putExtra("tot_komen", getListModel(position).getTotal_kom());
                        startActivityForResult(view, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$1 = final_listrumoradapter;
                position = I.this;
                super();
            }
                });
                try
                {
                    Picasso.with(activity).load((new StringBuilder(String.valueOf(Util.BASE_PATH_NEWIMAGE))).append(lms.getGambar().trim()).toString()).tag(activity).into(((ViewHolder) (viewgroup)).imageHp, viewgroup. new Callback() {

                        final ListRumorAdapter this$1;
                        private final ListRumorAdapter.ViewHolder val$holder;

                        public void onError()
                        {
                            holder.progressbar_item.setVisibility(8);
                        }

                        public void onSuccess()
                        {
                            holder.progressbar_item.setVisibility(8);
                            holder.imageHp.setVisibility(0);
                        }

            
            {
                this$1 = final_listrumoradapter;
                holder = ListRumorAdapter.ViewHolder.this;
                super();
            }
                    });
                }
                // Misplaced declaration of an exception variable
                catch (ViewGroup viewgroup)
                {
                    return view;
                }
            }
            return view;
        }

        void log(String s)
        {
        }

        public void setListArray(ArrayList arraylist)
        {
            lm = arraylist;
        }

        public void update(Observable observable, Object obj)
        {
            Log.e("getUpdateTypeRumor", ponselBaseApp.getObserver().getUpdateType().toString());
            if (ponselBaseApp.getObserver().getUpdateType().toString().equals("komentar"))
            {
                Log.e("updateViewKomenPonsel", ponselBaseApp.getObserver().getUpdateType().toString());
                updateViewKomenPonsel(ponselBaseApp.getObserver().getIndexHp());
            } else
            if (ponselBaseApp.getObserver().getUpdateType().toString().equals("likedisPonsel"))
            {
                Log.e("updateViewLikeDisPonsel", ponselBaseApp.getObserver().getUpdateType().toString());
                if (random_codename.equals(ponselBaseApp.getObserver().getIndexHp()))
                {
                    load_random_hp();
                }
                updateViewLikeDisPonsel(ponselBaseApp.getObserver().getIndexHp());
                return;
            }
        }

        public void updateViewKomenPonsel(String s)
        {
            Log.e("ponselBaseApp", s);
            int i = 0;
            do
            {
                if (i >= listTerbaruBrand.getChildCount())
                {
                    return;
                }
                Log.e("int i", String.valueOf(i));
                View view = listTerbaruBrand.getChildAt(i);
                TextView textview = (TextView)view.findViewById(0x7f0b0344);
                TextView textview1 = (TextView)view.findViewById(0x7f0b0347);
                TextView textview2 = (TextView)view.findViewById(0x7f0b034a);
                if (((TextView)view.findViewById(0x7f0b033f)).getText().toString().equals(s))
                {
                    textview.setText(ponselBaseApp.getObserver().getTot_LikePon());
                    textview1.setText(ponselBaseApp.getObserver().getTotdis_LikePon());
                    textview2.setText(ponselBaseApp.getObserver().getJum_komenLikePon());
                }
                i++;
            } while (true);
        }

        public void updateViewLikeDisPonsel(String s)
        {
            int i;
            Log.e("ponselBaseAppRumor", s);
            i = 0;
_L2:
            ImageView imageview;
            ImageView imageview1;
            RelativeLayout relativelayout;
            Object obj;
            if (i >= listTerbaruBrand.getChildCount())
            {
                return;
            }
            Log.e("int i", String.valueOf(i));
            obj = listTerbaruBrand.getChildAt(i);
            TextView textview = (TextView)((View) (obj)).findViewById(0x7f0b0344);
            TextView textview1 = (TextView)((View) (obj)).findViewById(0x7f0b0347);
            imageview = (ImageView)((View) (obj)).findViewById(0x7f0b0343);
            imageview1 = (ImageView)((View) (obj)).findViewById(0x7f0b0346);
            TextView textview2 = (TextView)((View) (obj)).findViewById(0x7f0b034a);
            TextView textview3 = (TextView)((View) (obj)).findViewById(0x7f0b033f);
            relativelayout = (RelativeLayout)((View) (obj)).findViewById(0x7f0b0342);
            obj = (RelativeLayout)((View) (obj)).findViewById(0x7f0b0345);
            if (textview3.getText().toString().equals(s))
            {
                Log.e("getTot_LikePonPend", ponselBaseApp.getObserver().getJum_komenLikePon().toString());
                Log.e("getTot_LikePonPend", ponselBaseApp.getObserver().getTot_LikePon().toString());
                Log.e("getTotdis_LikePonPend", ponselBaseApp.getObserver().getTotdis_LikePon().toString());
                textview.setText(ponselBaseApp.getObserver().getTot_LikePon());
                textview1.setText(ponselBaseApp.getObserver().getTotdis_LikePon());
                textview2.setText(ponselBaseApp.getObserver().getJum_komenLikePon());
                if (!ponselBaseApp.getObserver().getStatus_like_ponsel().equals("1"))
                {
                    break; /* Loop/switch isn't completed */
                }
                imageview.setBackgroundResource(0x7f02025b);
                imageview1.setBackgroundResource(0x7f0201a3);
                relativelayout.setEnabled(false);
                ((RelativeLayout) (obj)).setEnabled(true);
            }
_L3:
            i++;
            if (true) goto _L2; else goto _L1
_L1:
            if (ponselBaseApp.getObserver().getStatus_like_ponsel().equals("0"))
            {
                imageview.setBackgroundResource(0x7f020257);
                imageview1.setBackgroundResource(0x7f0201a7);
                relativelayout.setEnabled(true);
                ((RelativeLayout) (obj)).setEnabled(false);
            } else
            {
                imageview.setBackgroundResource(0x7f020257);
                imageview1.setBackgroundResource(0x7f0201a3);
                relativelayout.setBackgroundResource(0x7f020079);
                ((RelativeLayout) (obj)).setBackgroundResource(0x7f020079);
            }
              goto _L3
            if (true) goto _L2; else goto _L4
_L4:
        }



        public ListRumorAdapter(Activity activity1, int i, ArrayList arraylist)
        {
            this$0 = HomeNewMainActivity.this;
            super();
            fmt = new DecimalFormat();
            fmts = new DecimalFormatSymbols();
            t = Utility.session(RestClient.pelihara);
            user = "";
            komen = "";
            email_user = "";
            finalUrl = "";
            t = Utility.session(t);
            lm = arraylist;
            activity = activity1;
            resource = i;
            ponselBaseApp = (PonselBaseApp)getApplication();
            ponselBaseApp.getObserver().addObserver(this);
            try
            {
                userFunctions = new UserFunctions();
                db = new DatabaseHandler(activity1);
                if (userFunctions.isUserLoggedIn(activity1))
                {
                    cursor = db.getAllData();
                    cursor.moveToFirst();
                    username = cursor.getString(4);
                    email_user = cursor.getString(5);
                }
                t = Utility.session(t);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (HomeNewMainActivity homenewmainactivity)
            {
                return;
            }
        }
    }

    public class ListRumorAdapter.PostBagusKurangTask extends AsyncTask
    {

        final ListRumorAdapter this$1;

        private void parseJSONLikePon(String s)
        {
            int i;
            try
            {
                JSONObject jsonobject = new JSONObject(s);
                postStatusPendLikePon = jsonobject.getString("success");
                postMessagePendLikePon = jsonobject.getString("message");
                Log.e("postStatusLikePon", s);
                jArray = jsonobject.getJSONArray("InPonsel");
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
            jum_komenLikePonPend = s.getString("total_kom");
            tot_LikePonPend = s.getString("total_like");
            totdis_LikePonPend = s.getString("total_dislike");
            Log.e("jum_komenLikePon", jum_komenLikePonPend);
            Log.e("tot_LikePon", tot_LikePonPend);
            Log.e("totdis_LikePon", totdis_LikePonPend);
            ponselBaseApp.getObserver().setJum_komenLikePon(jum_komenLikePonPend);
            ponselBaseApp.getObserver().setTot_LikePon(tot_LikePonPend);
            ponselBaseApp.getObserver().setTotdis_LikePon(totdis_LikePonPend);
            ponselBaseApp.getObserver().setUpdateType("likedisPonsel");
            i++;
            if (false)
            {
            } else
            {
                break MISSING_BLOCK_LABEL_65;
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
                if (android.os.Build.VERSION.SDK_INT > 9)
                {
                    StrictMode.setThreadPolicy((new android.os.StrictMode.ThreadPolicy.Builder()).permitAll().build());
                }
                Log.e("posA", String.valueOf(pos));
                avoid = finalUrl;
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("likedis_ponsel").append(Utility.BASE_FORMAT).append("?").append(avoid).toString();
                Log.e("pushURL", avoid);
                avoid = HttpPush.getResponse(avoid);
                res = avoid.toString();
                parseJSONLikePon(res);
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
            Log.e("postStatusLikePon", postStatusPendLikePon);
            if (!postStatusPendLikePon.equals("1"))
            {
                break MISSING_BLOCK_LABEL_121;
            }
            notificationLikeHelper.completed(namalengkapbgskrg, notificationLikeHelper.SucdislikeStatement);
            if (statusLikeHpRumor.equals("1"))
            {
                ponselBaseApp.getObserver().setStatus_like_ponsel("1");
                return;
            }
            try
            {
                ponselBaseApp.getObserver().setStatus_like_ponsel("0");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
            notificationLikeHelper.gagal(namalengkapbgskrg, notificationLikeHelper.gagallikeStatement);
            return;
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            if (statusLikeHpRumor.equals("1"))
            {
                notificationLikeHelper.createNotification(namalengkapbgskrg, notificationLikeHelper.likeStatement);
                return;
            } else
            {
                notificationLikeHelper.createNotification(namalengkapbgskrg, notificationLikeHelper.dislikeStatement);
                return;
            }
        }

        public ListRumorAdapter.PostBagusKurangTask()
        {
            this$1 = ListRumorAdapter.this;
            super();
        }
    }

    class ListRumorAdapter.ViewHolder
    {

        ImageView imageHp;
        ImageView list_dislike;
        RelativeLayout list_lay_dislike;
        RelativeLayout list_lay_kom;
        RelativeLayout list_lay_like;
        ImageView list_like;
        TextView list_text_dislike;
        TextView list_text_komentar;
        TextView list_text_like;
        TextView list_txtCodename;
        TextView list_txtHarga;
        TextView list_txtMerek;
        LinearLayout ll_master_item;
        ProgressBar progressbar_item;
        RatingBar rateRate;
        final ListRumorAdapter this$1;

        ListRumorAdapter.ViewHolder()
        {
            this$1 = ListRumorAdapter.this;
            super();
        }
    }

    public class ListSegeraAdapter extends BaseAdapter
        implements Observer
    {

        private Activity activity;
        Context context;
        Cursor cursor;
        DatabaseHandler db;
        String email_user;
        String finalUrl;
        DecimalFormat fmt;
        DecimalFormatSymbols fmts;
        int hargaBaru;
        int hargaBekas;
        String hrg_baru;
        String hrg_bekas;
        String komen;
        private ArrayList lm;
        ListModel lms;
        PonselBaseApp ponselBaseApp;
        int pos;
        String res;
        int resource;
        String response;
        String statusLikeHpSegera;
        String statusSegera;
        String t;
        final HomeNewMainActivity this$0;
        String user;
        UserFunctions userFunctions;

        public int getCount()
        {
            return lm.size();
        }

        public Object getItem(int i)
        {
            return null;
        }

        public long getItemId(int i)
        {
            return 0L;
        }

        public ListModel getListModel(int i)
        {
            return (ListModel)lm.get(i);
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            pos = i;
            if (view == null)
            {
                view = ((LayoutInflater)activity.getSystemService("layout_inflater")).inflate(resource, null);
                viewgroup = new ViewHolder();
                viewgroup.imageHp = (ImageView)view.findViewById(0x7f0b023d);
                viewgroup.list_txtMerek = (TextView)view.findViewById(0x7f0b033c);
                viewgroup.list_txtHarga = (TextView)view.findViewById(0x7f0b033d);
                viewgroup.list_txtCodename = (TextView)view.findViewById(0x7f0b033f);
                viewgroup.list_text_like = (TextView)view.findViewById(0x7f0b0344);
                viewgroup.list_text_dislike = (TextView)view.findViewById(0x7f0b0347);
                viewgroup.list_text_komentar = (TextView)view.findViewById(0x7f0b034a);
                viewgroup.list_like = (ImageView)view.findViewById(0x7f0b0343);
                viewgroup.list_dislike = (ImageView)view.findViewById(0x7f0b0346);
                viewgroup.progressbar_item = (ProgressBar)view.findViewById(0x7f0b00b3);
                viewgroup.ll_master_item = (LinearLayout)view.findViewById(0x7f0b084e);
                viewgroup.bottom_list = (LinearLayout)view.findViewById(0x7f0b0341);
                viewgroup.list_lay_like = (RelativeLayout)view.findViewById(0x7f0b0342);
                viewgroup.list_lay_dislike = (RelativeLayout)view.findViewById(0x7f0b0345);
                viewgroup.list_lay_kom = (RelativeLayout)view.findViewById(0x7f0b0348);
                viewgroup.rateRate = (RatingBar)view.findViewById(0x7f0b00c9);
                view.setTag(viewgroup);
            } else
            {
                viewgroup = (ViewHolder)view.getTag();
            }
            lms = (ListModel)lm.get(i);
            ((ViewHolder) (viewgroup)).bottom_list.setVisibility(8);
            if (lm != null)
            {
                ((ViewHolder) (viewgroup)).ll_master_item.setBackgroundResource(0x7f02007a);
                hrg_baru = lms.getHrg_baru();
                hrg_bekas = lms.getHrg_bekas();
                ((ViewHolder) (viewgroup)).list_txtMerek.setText((new StringBuilder(String.valueOf(lms.getMerk()))).append(" ").append(lms.getModel()).toString());
                ((ViewHolder) (viewgroup)).list_txtCodename.setText(lms.getCodename());
                ((ViewHolder) (viewgroup)).list_text_like.setText(lms.getTotal_like());
                ((ViewHolder) (viewgroup)).list_text_dislike.setText(lms.getTotal_dislike());
                ((ViewHolder) (viewgroup)).list_text_komentar.setText(lms.getTotal_kom());
                if (lms.getMy_like_pon().toString().equals("1"))
                {
                    ((ViewHolder) (viewgroup)).list_like.setBackgroundResource(0x7f02025b);
                    ((ViewHolder) (viewgroup)).list_dislike.setBackgroundResource(0x7f0201a3);
                    ((ViewHolder) (viewgroup)).list_lay_like.setEnabled(false);
                    ((ViewHolder) (viewgroup)).list_lay_dislike.setEnabled(true);
                } else
                if (lms.getMy_like_pon().toString().equals("0"))
                {
                    ((ViewHolder) (viewgroup)).list_like.setBackgroundResource(0x7f020257);
                    ((ViewHolder) (viewgroup)).list_dislike.setBackgroundResource(0x7f0201a7);
                    ((ViewHolder) (viewgroup)).list_lay_like.setEnabled(true);
                    ((ViewHolder) (viewgroup)).list_lay_dislike.setEnabled(false);
                } else
                {
                    ((ViewHolder) (viewgroup)).list_lay_like.setEnabled(true);
                    ((ViewHolder) (viewgroup)).list_lay_dislike.setEnabled(true);
                    ((ViewHolder) (viewgroup)).list_like.setBackgroundResource(0x7f020257);
                    ((ViewHolder) (viewgroup)).list_dislike.setBackgroundResource(0x7f0201a3);
                    ((ViewHolder) (viewgroup)).list_lay_like.setBackgroundResource(0x7f020079);
                    ((ViewHolder) (viewgroup)).list_lay_dislike.setBackgroundResource(0x7f020079);
                }
                if (lms.getUmu_status().equals("3") || hrg_baru.equals("-") || hrg_baru.equals("0"))
                {
                    ((ViewHolder) (viewgroup)).list_txtHarga.setVisibility(4);
                } else
                {
                    ((ViewHolder) (viewgroup)).list_txtHarga.setVisibility(0);
                    ((ViewHolder) (viewgroup)).list_txtHarga.setText((new StringBuilder()).append(hrg_baru).toString());
                }
                ((ViewHolder) (viewgroup)).list_lay_like.setOnClickListener(i. new android.view.View.OnClickListener() {

                    final ListSegeraAdapter this$1;
                    private final int val$position;

                    public void onClick(View view)
                    {
                        if (userFunctions.isUserLoggedIn(activity))
                        {
                            pos = position;
                            statusSegera = "1";
                            statusLikeHpSegera = "1";
                            indexhp = getListModel(position).getId_hp();
                            ponselBaseApp.getObserver().setIndexHp(getListModel(position).getCodename());
                            namalengkapbgskrg = (new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString();
                            try
                            {
                                finalUrl = (new StringBuilder("idhp=")).append(getListModel(position).getId_hp()).append("&email=").append(username).append("&namalengkap=").append(URLEncoder.encode((new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString(), "utf-8")).append("&status=").append(statusSegera).append("&t=").append(t).toString();
                            }
                            // Misplaced declaration of an exception variable
                            catch (View view)
                            {
                                view.printStackTrace();
                            }
                            Log.e("finalurl", finalUrl);
                            if (android.os.Build.VERSION.SDK_INT >= 11)
                            {
                                (new ListSegeraAdapter.PostBagusKurangTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                                return;
                            } else
                            {
                                (new ListSegeraAdapter.PostBagusKurangTask()).execute(new Void[0]);
                                return;
                            }
                        } else
                        {
                            view = new android.app.AlertDialog.Builder(activity);
                            view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                            view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                                final ListSegeraAdapter._cls1 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = ListSegeraAdapter._cls1.this;
                super();
            }
                            });
                            view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                                final ListSegeraAdapter._cls1 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(activity, com/inponsel/android/v2/RegisterActivity);
                                    activity.startActivityForResult(dialoginterface, 0);
                                    overridePendingTransition(0x7f040003, 0x7f040004);
                                }

            
            {
                this$2 = ListSegeraAdapter._cls1.this;
                super();
            }
                            });
                            view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                                final ListSegeraAdapter._cls1 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(activity, com/inponsel/android/v2/LoginActivity);
                                    dialoginterface.putExtra("activity", "main");
                                    activity.startActivityForResult(dialoginterface, 0);
                                    overridePendingTransition(0x7f040003, 0x7f040004);
                                }

            
            {
                this$2 = ListSegeraAdapter._cls1.this;
                super();
            }
                            });
                            view.show();
                            return;
                        }
                    }


            
            {
                this$1 = final_listsegeraadapter;
                position = I.this;
                super();
            }
                });
                ((ViewHolder) (viewgroup)).list_lay_dislike.setOnClickListener(i. new android.view.View.OnClickListener() {

                    final ListSegeraAdapter this$1;
                    private final int val$position;

                    public void onClick(View view)
                    {
                        if (userFunctions.isUserLoggedIn(activity))
                        {
                            pos = position;
                            indexhp = getListModel(position).getId_hp();
                            ponselBaseApp.getObserver().setIndexHp(getListModel(position).getCodename());
                            statusSegera = "0";
                            statusLikeHpSegera = "0";
                            namalengkapbgskrg = (new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString();
                            try
                            {
                                finalUrl = (new StringBuilder("idhp=")).append(getListModel(position).getId_hp()).append("&email=").append(username).append("&namalengkap=").append(URLEncoder.encode((new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString(), "utf-8")).append("&status=").append(statusSegera).append("&t=").append(t).toString();
                            }
                            // Misplaced declaration of an exception variable
                            catch (View view)
                            {
                                view.printStackTrace();
                            }
                            Log.e("finalurl", finalUrl);
                            if (android.os.Build.VERSION.SDK_INT >= 11)
                            {
                                (new ListSegeraAdapter.PostBagusKurangTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                                return;
                            } else
                            {
                                (new ListSegeraAdapter.PostBagusKurangTask()).execute(new Void[0]);
                                return;
                            }
                        } else
                        {
                            view = new android.app.AlertDialog.Builder(activity);
                            view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                            view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                                final ListSegeraAdapter._cls2 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = ListSegeraAdapter._cls2.this;
                super();
            }
                            });
                            view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                                final ListSegeraAdapter._cls2 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(activity, com/inponsel/android/v2/RegisterActivity);
                                    activity.startActivityForResult(dialoginterface, 0);
                                    overridePendingTransition(0x7f040003, 0x7f040004);
                                }

            
            {
                this$2 = ListSegeraAdapter._cls2.this;
                super();
            }
                            });
                            view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                                final ListSegeraAdapter._cls2 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(activity, com/inponsel/android/v2/LoginActivity);
                                    dialoginterface.putExtra("activity", "main");
                                    activity.startActivityForResult(dialoginterface, 0);
                                    overridePendingTransition(0x7f040003, 0x7f040004);
                                }

            
            {
                this$2 = ListSegeraAdapter._cls2.this;
                super();
            }
                            });
                            view.show();
                            return;
                        }
                    }


            
            {
                this$1 = final_listsegeraadapter;
                position = I.this;
                super();
            }
                });
                ((ViewHolder) (viewgroup)).list_lay_kom.setOnClickListener(i. new android.view.View.OnClickListener() {

                    final ListSegeraAdapter this$1;
                    private final int val$position;

                    public void onClick(View view)
                    {
                        view = new Intent(getApplicationContext(), com/inponsel/android/v2/KomentarPonsel);
                        view.putExtra("id_hph", getListModel(position).getId_hp());
                        view.putExtra("namalengkap", getListModel(position).getNamalengkap());
                        view.putExtra("codename", getListModel(position).getCodename());
                        view.putExtra("model", getListModel(position).getModel());
                        view.putExtra("merk", getListModel(position).getMerk());
                        view.putExtra("gambar", getListModel(position).getGambar());
                        view.putExtra("hrg_baru", getListModel(position).getHrg_baru());
                        view.putExtra("hrg_bekas", getListModel(position).getHrg_bekas());
                        view.putExtra("tot_like", getListModel(position).getTotal_like());
                        view.putExtra("tot_dislike", getListModel(position).getTotal_dislike());
                        view.putExtra("tot_komen", getListModel(position).getTotal_kom());
                        startActivityForResult(view, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$1 = final_listsegeraadapter;
                position = I.this;
                super();
            }
                });
                try
                {
                    Picasso.with(activity).load((new StringBuilder(String.valueOf(Util.BASE_PATH_NEWIMAGE))).append(lms.getGambar().trim()).toString()).tag(activity).into(((ViewHolder) (viewgroup)).imageHp, viewgroup. new Callback() {

                        final ListSegeraAdapter this$1;
                        private final ListSegeraAdapter.ViewHolder val$holder;

                        public void onError()
                        {
                            holder.progressbar_item.setVisibility(8);
                        }

                        public void onSuccess()
                        {
                            holder.progressbar_item.setVisibility(8);
                            holder.imageHp.setVisibility(0);
                        }

            
            {
                this$1 = final_listsegeraadapter;
                holder = ListSegeraAdapter.ViewHolder.this;
                super();
            }
                    });
                }
                // Misplaced declaration of an exception variable
                catch (ViewGroup viewgroup)
                {
                    return view;
                }
            }
            return view;
        }

        void log(String s)
        {
        }

        public void setListArray(ArrayList arraylist)
        {
            lm = arraylist;
        }

        public void update(Observable observable, Object obj)
        {
            Log.e("getUpdateTypeSegera", ponselBaseApp.getObserver().getUpdateType().toString());
            if (ponselBaseApp.getObserver().getUpdateType().toString().equals("komentar"))
            {
                Log.e("updateViewKomenPonsel", ponselBaseApp.getObserver().getUpdateType().toString());
                updateViewKomenPonsel(ponselBaseApp.getObserver().getIndexHp());
            } else
            if (ponselBaseApp.getObserver().getUpdateType().toString().equals("likedisPonsel"))
            {
                Log.e("updateViewLikeDisPonsel", ponselBaseApp.getObserver().getUpdateType().toString());
                if (random_codename.equals(ponselBaseApp.getObserver().getIndexHp()))
                {
                    load_random_hp();
                }
                updateViewLikeDisPonsel(ponselBaseApp.getObserver().getIndexHp());
                return;
            }
        }

        public void updateViewKomenPonsel(String s)
        {
            Log.e("ponselBaseApp", s);
            int i = 0;
            do
            {
                if (i >= listSegera.getChildCount())
                {
                    return;
                }
                Log.e("int i", String.valueOf(i));
                View view = listSegera.getChildAt(i);
                TextView textview = (TextView)view.findViewById(0x7f0b0344);
                TextView textview1 = (TextView)view.findViewById(0x7f0b0347);
                TextView textview2 = (TextView)view.findViewById(0x7f0b034a);
                if (((TextView)view.findViewById(0x7f0b033f)).getText().toString().equals(s))
                {
                    textview.setText(ponselBaseApp.getObserver().getTot_LikePon());
                    textview1.setText(ponselBaseApp.getObserver().getTotdis_LikePon());
                    textview2.setText(ponselBaseApp.getObserver().getJum_komenLikePon());
                }
                i++;
            } while (true);
        }

        public void updateViewLikeDisPonsel(String s)
        {
            int i;
            Log.e("ponselBaseApp", s);
            i = 0;
_L2:
            ImageView imageview;
            ImageView imageview1;
            RelativeLayout relativelayout;
            Object obj;
            if (i >= listSegera.getChildCount())
            {
                return;
            }
            Log.e("int i", String.valueOf(i));
            obj = listSegera.getChildAt(i);
            TextView textview = (TextView)((View) (obj)).findViewById(0x7f0b0344);
            TextView textview1 = (TextView)((View) (obj)).findViewById(0x7f0b0347);
            imageview = (ImageView)((View) (obj)).findViewById(0x7f0b0343);
            imageview1 = (ImageView)((View) (obj)).findViewById(0x7f0b0346);
            TextView textview2 = (TextView)((View) (obj)).findViewById(0x7f0b034a);
            TextView textview3 = (TextView)((View) (obj)).findViewById(0x7f0b033f);
            relativelayout = (RelativeLayout)((View) (obj)).findViewById(0x7f0b0342);
            obj = (RelativeLayout)((View) (obj)).findViewById(0x7f0b0345);
            if (textview3.getText().toString().equals(s))
            {
                Log.e("getTot_LikePonPend", ponselBaseApp.getObserver().getJum_komenLikePon().toString());
                Log.e("getTot_LikePonPend", ponselBaseApp.getObserver().getTot_LikePon().toString());
                Log.e("getTotdis_LikePonPend", ponselBaseApp.getObserver().getTotdis_LikePon().toString());
                textview.setText(ponselBaseApp.getObserver().getTot_LikePon());
                textview1.setText(ponselBaseApp.getObserver().getTotdis_LikePon());
                textview2.setText(ponselBaseApp.getObserver().getJum_komenLikePon());
                if (!ponselBaseApp.getObserver().getStatus_like_ponsel().equals("1"))
                {
                    break; /* Loop/switch isn't completed */
                }
                imageview.setBackgroundResource(0x7f02025b);
                imageview1.setBackgroundResource(0x7f0201a3);
                relativelayout.setEnabled(false);
                ((RelativeLayout) (obj)).setEnabled(true);
            }
_L3:
            i++;
            if (true) goto _L2; else goto _L1
_L1:
            if (ponselBaseApp.getObserver().getStatus_like_ponsel().equals("0"))
            {
                imageview.setBackgroundResource(0x7f020257);
                imageview1.setBackgroundResource(0x7f0201a7);
                relativelayout.setEnabled(true);
                ((RelativeLayout) (obj)).setEnabled(false);
            } else
            {
                imageview.setBackgroundResource(0x7f020257);
                imageview1.setBackgroundResource(0x7f0201a3);
                relativelayout.setBackgroundResource(0x7f020079);
                ((RelativeLayout) (obj)).setBackgroundResource(0x7f020079);
            }
              goto _L3
            if (true) goto _L2; else goto _L4
_L4:
        }



        public ListSegeraAdapter(Activity activity1, int i, ArrayList arraylist)
        {
            this$0 = HomeNewMainActivity.this;
            super();
            fmt = new DecimalFormat();
            fmts = new DecimalFormatSymbols();
            t = Utility.session(RestClient.pelihara);
            user = "";
            komen = "";
            email_user = "";
            finalUrl = "";
            t = Utility.session(t);
            lm = arraylist;
            activity = activity1;
            resource = i;
            ponselBaseApp = (PonselBaseApp)getApplication();
            ponselBaseApp.getObserver().addObserver(this);
            try
            {
                userFunctions = new UserFunctions();
                db = new DatabaseHandler(activity1);
                if (userFunctions.isUserLoggedIn(activity1))
                {
                    cursor = db.getAllData();
                    cursor.moveToFirst();
                    username = cursor.getString(4);
                    email_user = cursor.getString(5);
                }
                t = Utility.session(t);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (HomeNewMainActivity homenewmainactivity)
            {
                return;
            }
        }
    }

    public class ListSegeraAdapter.PostBagusKurangTask extends AsyncTask
    {

        final ListSegeraAdapter this$1;

        private void parseJSONLikePon(String s)
        {
            int i;
            try
            {
                JSONObject jsonobject = new JSONObject(s);
                postStatusPendLikePon = jsonobject.getString("success");
                postMessagePendLikePon = jsonobject.getString("message");
                Log.e("postStatusLikePon", s);
                jArray = jsonobject.getJSONArray("InPonsel");
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
            jum_komenLikePonPend = s.getString("total_kom");
            tot_LikePonPend = s.getString("total_like");
            totdis_LikePonPend = s.getString("total_dislike");
            Log.e("jum_komenLikePon", jum_komenLikePonPend);
            Log.e("tot_LikePon", tot_LikePonPend);
            Log.e("totdis_LikePon", totdis_LikePonPend);
            ponselBaseApp.getObserver().setJum_komenLikePon(jum_komenLikePonPend);
            ponselBaseApp.getObserver().setTot_LikePon(tot_LikePonPend);
            ponselBaseApp.getObserver().setTotdis_LikePon(totdis_LikePonPend);
            ponselBaseApp.getObserver().setUpdateType("likedisPonsel");
            i++;
            if (false)
            {
            } else
            {
                break MISSING_BLOCK_LABEL_65;
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
                if (android.os.Build.VERSION.SDK_INT > 9)
                {
                    StrictMode.setThreadPolicy((new android.os.StrictMode.ThreadPolicy.Builder()).permitAll().build());
                }
                Log.e("posA", String.valueOf(pos));
                avoid = finalUrl;
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("likedis_ponsel").append(Utility.BASE_FORMAT).append("?").append(avoid).toString();
                Log.e("pushURL", avoid);
                avoid = HttpPush.getResponse(avoid);
                res = avoid.toString();
                parseJSONLikePon(res);
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
            Log.e("postStatusLikePon", postStatusPendLikePon);
            if (!postStatusPendLikePon.equals("1"))
            {
                break MISSING_BLOCK_LABEL_121;
            }
            notificationLikeHelper.completed(namalengkapbgskrg, notificationLikeHelper.SucdislikeStatement);
            if (statusLikeHpSegera.equals("1"))
            {
                ponselBaseApp.getObserver().setStatus_like_ponsel("1");
                return;
            }
            try
            {
                ponselBaseApp.getObserver().setStatus_like_ponsel("0");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
            notificationLikeHelper.gagal(namalengkapbgskrg, notificationLikeHelper.gagallikeStatement);
            return;
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            if (statusLikeHpSegera.equals("1"))
            {
                notificationLikeHelper.createNotification(namalengkapbgskrg, notificationLikeHelper.likeStatement);
                return;
            } else
            {
                notificationLikeHelper.createNotification(namalengkapbgskrg, notificationLikeHelper.dislikeStatement);
                return;
            }
        }

        public ListSegeraAdapter.PostBagusKurangTask()
        {
            this$1 = ListSegeraAdapter.this;
            super();
        }
    }

    class ListSegeraAdapter.ViewHolder
    {

        LinearLayout bottom_list;
        ImageView imageHp;
        ImageView list_dislike;
        RelativeLayout list_lay_dislike;
        RelativeLayout list_lay_kom;
        RelativeLayout list_lay_like;
        ImageView list_like;
        TextView list_text_dislike;
        TextView list_text_komentar;
        TextView list_text_like;
        TextView list_txtCodename;
        TextView list_txtHarga;
        TextView list_txtMerek;
        LinearLayout ll_master_item;
        ProgressBar progressbar_item;
        RatingBar rateRate;
        final ListSegeraAdapter this$1;

        ListSegeraAdapter.ViewHolder()
        {
            this$1 = ListSegeraAdapter.this;
            super();
        }
    }

    public class ListTopHitsAdapter extends BaseAdapter
        implements Observer
    {

        private Activity activity;
        Context context;
        Cursor cursor;
        DatabaseHandler db;
        String email_user;
        String finalUrl;
        DecimalFormat fmt;
        DecimalFormatSymbols fmts;
        int hargaBaru;
        int hargaBekas;
        String hrg_baru;
        String hrg_bekas;
        String komen;
        private ArrayList lm;
        ListModel lms;
        PonselBaseApp ponselBaseApp;
        int pos;
        String res;
        int resource;
        String response;
        String statusLikeHpRilis;
        String statusRilis;
        String t;
        final HomeNewMainActivity this$0;
        String user;
        UserFunctions userFunctions;

        public int getCount()
        {
            return lm.size();
        }

        public Object getItem(int i)
        {
            return null;
        }

        public long getItemId(int i)
        {
            return 0L;
        }

        public ListModel getListModel(int i)
        {
            return (ListModel)lm.get(i);
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            pos = i;
            if (view == null)
            {
                view = ((LayoutInflater)activity.getSystemService("layout_inflater")).inflate(resource, null);
                viewgroup = new ViewHolder();
                viewgroup.imageHp = (ImageView)view.findViewById(0x7f0b023d);
                viewgroup.txt_no_apps = (TextView)view.findViewById(0x7f0b0905);
                viewgroup.rl_hp_small = (RelativeLayout)view.findViewById(0x7f0b090c);
                viewgroup.img_hp_circle = (CircleView)view.findViewById(0x7f0b0904);
                viewgroup.list_txtMerek = (TextView)view.findViewById(0x7f0b033c);
                viewgroup.list_txtHarga = (TextView)view.findViewById(0x7f0b033d);
                viewgroup.list_txtCodename = (TextView)view.findViewById(0x7f0b033f);
                viewgroup.list_text_like = (TextView)view.findViewById(0x7f0b0344);
                viewgroup.list_text_dislike = (TextView)view.findViewById(0x7f0b0347);
                viewgroup.list_text_komentar = (TextView)view.findViewById(0x7f0b034a);
                viewgroup.list_like = (ImageView)view.findViewById(0x7f0b0343);
                viewgroup.list_dislike = (ImageView)view.findViewById(0x7f0b0346);
                viewgroup.progressbar_item = (ProgressBar)view.findViewById(0x7f0b00b3);
                viewgroup.ll_master_item = (LinearLayout)view.findViewById(0x7f0b084e);
                viewgroup.list_lay_like = (RelativeLayout)view.findViewById(0x7f0b0342);
                viewgroup.list_lay_dislike = (RelativeLayout)view.findViewById(0x7f0b0345);
                viewgroup.list_lay_kom = (RelativeLayout)view.findViewById(0x7f0b0348);
                viewgroup.rateRate = (RatingBar)view.findViewById(0x7f0b00c9);
                view.setTag(viewgroup);
            } else
            {
                viewgroup = (ViewHolder)view.getTag();
            }
            lms = (ListModel)lm.get(i);
            if (lm != null)
            {
                ((ViewHolder) (viewgroup)).txt_no_apps.setText(String.valueOf(pos + 1));
                ((ViewHolder) (viewgroup)).img_hp_circle.setCircleColor(Color.parseColor(lms.getBackground_color()));
                ((ViewHolder) (viewgroup)).img_hp_circle.setLabelColor(0);
                ((ViewHolder) (viewgroup)).img_hp_circle.setLabelText("");
                hrg_baru = lms.getHrg_baru();
                hrg_bekas = lms.getHrg_bekas();
                ((ViewHolder) (viewgroup)).list_txtMerek.setText((new StringBuilder(String.valueOf(lms.getMerk()))).append(" ").append(lms.getModel()).toString());
                ((ViewHolder) (viewgroup)).list_txtCodename.setText(lms.getCodename());
                ((ViewHolder) (viewgroup)).list_text_like.setText(lms.getTotal_like());
                ((ViewHolder) (viewgroup)).list_text_dislike.setText(lms.getTotal_dislike());
                ((ViewHolder) (viewgroup)).list_text_komentar.setText(lms.getTotal_kom());
                if (lms.getMy_like_pon().toString().equals("1"))
                {
                    ((ViewHolder) (viewgroup)).list_like.setBackgroundResource(0x7f02025b);
                    ((ViewHolder) (viewgroup)).list_dislike.setBackgroundResource(0x7f0201a3);
                    ((ViewHolder) (viewgroup)).list_lay_like.setEnabled(false);
                    ((ViewHolder) (viewgroup)).list_lay_dislike.setEnabled(true);
                } else
                if (lms.getMy_like_pon().toString().equals("0"))
                {
                    ((ViewHolder) (viewgroup)).list_like.setBackgroundResource(0x7f020257);
                    ((ViewHolder) (viewgroup)).list_dislike.setBackgroundResource(0x7f0201a7);
                    ((ViewHolder) (viewgroup)).list_lay_like.setEnabled(true);
                    ((ViewHolder) (viewgroup)).list_lay_dislike.setEnabled(false);
                } else
                {
                    ((ViewHolder) (viewgroup)).list_lay_like.setEnabled(true);
                    ((ViewHolder) (viewgroup)).list_lay_dislike.setEnabled(true);
                    ((ViewHolder) (viewgroup)).list_like.setBackgroundResource(0x7f020257);
                    ((ViewHolder) (viewgroup)).list_dislike.setBackgroundResource(0x7f0201a3);
                    ((ViewHolder) (viewgroup)).list_lay_like.setBackgroundResource(0x7f020079);
                    ((ViewHolder) (viewgroup)).list_lay_dislike.setBackgroundResource(0x7f020079);
                }
                ((ViewHolder) (viewgroup)).list_txtHarga.setVisibility(8);
                ((ViewHolder) (viewgroup)).list_lay_like.setOnClickListener(i. new android.view.View.OnClickListener() {

                    final ListTopHitsAdapter this$1;
                    private final int val$position;

                    public void onClick(View view)
                    {
                        if (userFunctions.isUserLoggedIn(activity))
                        {
                            pos = position;
                            statusRilis = "1";
                            statusLikeHpRilis = "1";
                            indexhp = getListModel(position).getId_hp();
                            ponselBaseApp.getObserver().setIndexHp(getListModel(position).getCodename());
                            namalengkapbgskrg = (new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString();
                            try
                            {
                                finalUrl = (new StringBuilder("idhp=")).append(getListModel(position).getId_hp()).append("&email=").append(username).append("&namalengkap=").append(URLEncoder.encode((new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString(), "utf-8")).append("&status=").append(statusRilis).append("&t=").append(t).toString();
                            }
                            // Misplaced declaration of an exception variable
                            catch (View view)
                            {
                                view.printStackTrace();
                            }
                            Log.e("finalurl", finalUrl);
                            if (android.os.Build.VERSION.SDK_INT >= 11)
                            {
                                (new ListTopHitsAdapter.PostBagusKurangTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                                return;
                            } else
                            {
                                (new ListTopHitsAdapter.PostBagusKurangTask()).execute(new Void[0]);
                                return;
                            }
                        } else
                        {
                            view = new android.app.AlertDialog.Builder(activity);
                            view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                            view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                                final ListTopHitsAdapter._cls1 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = ListTopHitsAdapter._cls1.this;
                super();
            }
                            });
                            view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                                final ListTopHitsAdapter._cls1 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(activity, com/inponsel/android/v2/RegisterActivity);
                                    activity.startActivityForResult(dialoginterface, 0);
                                    overridePendingTransition(0x7f040003, 0x7f040004);
                                }

            
            {
                this$2 = ListTopHitsAdapter._cls1.this;
                super();
            }
                            });
                            view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                                final ListTopHitsAdapter._cls1 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(activity, com/inponsel/android/v2/LoginActivity);
                                    dialoginterface.putExtra("activity", "main");
                                    activity.startActivityForResult(dialoginterface, 0);
                                    overridePendingTransition(0x7f040003, 0x7f040004);
                                }

            
            {
                this$2 = ListTopHitsAdapter._cls1.this;
                super();
            }
                            });
                            view.show();
                            return;
                        }
                    }


            
            {
                this$1 = final_listtophitsadapter;
                position = I.this;
                super();
            }
                });
                ((ViewHolder) (viewgroup)).list_lay_dislike.setOnClickListener(i. new android.view.View.OnClickListener() {

                    final ListTopHitsAdapter this$1;
                    private final int val$position;

                    public void onClick(View view)
                    {
                        if (userFunctions.isUserLoggedIn(activity))
                        {
                            pos = position;
                            indexhp = getListModel(position).getId_hp();
                            ponselBaseApp.getObserver().setIndexHp(getListModel(position).getCodename());
                            statusRilis = "0";
                            statusLikeHpRilis = "0";
                            namalengkapbgskrg = (new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString();
                            try
                            {
                                finalUrl = (new StringBuilder("idhp=")).append(getListModel(position).getId_hp()).append("&email=").append(username).append("&namalengkap=").append(URLEncoder.encode((new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString(), "utf-8")).append("&status=").append(statusRilis).append("&t=").append(t).toString();
                            }
                            // Misplaced declaration of an exception variable
                            catch (View view)
                            {
                                view.printStackTrace();
                            }
                            Log.e("finalurl", finalUrl);
                            if (android.os.Build.VERSION.SDK_INT >= 11)
                            {
                                (new ListTopHitsAdapter.PostBagusKurangTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                                return;
                            } else
                            {
                                (new ListTopHitsAdapter.PostBagusKurangTask()).execute(new Void[0]);
                                return;
                            }
                        } else
                        {
                            view = new android.app.AlertDialog.Builder(activity);
                            view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                            view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                                final ListTopHitsAdapter._cls2 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = ListTopHitsAdapter._cls2.this;
                super();
            }
                            });
                            view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                                final ListTopHitsAdapter._cls2 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(activity, com/inponsel/android/v2/RegisterActivity);
                                    activity.startActivityForResult(dialoginterface, 0);
                                    overridePendingTransition(0x7f040003, 0x7f040004);
                                }

            
            {
                this$2 = ListTopHitsAdapter._cls2.this;
                super();
            }
                            });
                            view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                                final ListTopHitsAdapter._cls2 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(activity, com/inponsel/android/v2/LoginActivity);
                                    dialoginterface.putExtra("activity", "main");
                                    activity.startActivityForResult(dialoginterface, 0);
                                    overridePendingTransition(0x7f040003, 0x7f040004);
                                }

            
            {
                this$2 = ListTopHitsAdapter._cls2.this;
                super();
            }
                            });
                            view.show();
                            return;
                        }
                    }


            
            {
                this$1 = final_listtophitsadapter;
                position = I.this;
                super();
            }
                });
                ((ViewHolder) (viewgroup)).list_lay_kom.setOnClickListener(i. new android.view.View.OnClickListener() {

                    final ListTopHitsAdapter this$1;
                    private final int val$position;

                    public void onClick(View view)
                    {
                        view = new Intent(getApplicationContext(), com/inponsel/android/v2/KomentarPonsel);
                        view.putExtra("id_hph", getListModel(position).getId_hp());
                        view.putExtra("namalengkap", getListModel(position).getNamalengkap());
                        view.putExtra("codename", getListModel(position).getCodename());
                        view.putExtra("model", getListModel(position).getModel());
                        view.putExtra("merk", getListModel(position).getMerk());
                        view.putExtra("gambar", getListModel(position).getGambar());
                        view.putExtra("hrg_baru", getListModel(position).getHrg_baru());
                        view.putExtra("hrg_bekas", getListModel(position).getHrg_bekas());
                        view.putExtra("tot_like", getListModel(position).getTotal_like());
                        view.putExtra("tot_dislike", getListModel(position).getTotal_dislike());
                        view.putExtra("tot_komen", getListModel(position).getTotal_kom());
                        startActivityForResult(view, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$1 = final_listtophitsadapter;
                position = I.this;
                super();
            }
                });
                try
                {
                    Picasso.with(activity).load((new StringBuilder(String.valueOf(Util.BASE_PATH_NEWIMAGE))).append(lms.getGambar().trim()).toString()).tag(activity).into(((ViewHolder) (viewgroup)).imageHp, viewgroup. new Callback() {

                        final ListTopHitsAdapter this$1;
                        private final ListTopHitsAdapter.ViewHolder val$holder;

                        public void onError()
                        {
                            holder.progressbar_item.setVisibility(8);
                        }

                        public void onSuccess()
                        {
                            holder.progressbar_item.setVisibility(8);
                            holder.imageHp.setVisibility(0);
                        }

            
            {
                this$1 = final_listtophitsadapter;
                holder = ListTopHitsAdapter.ViewHolder.this;
                super();
            }
                    });
                }
                // Misplaced declaration of an exception variable
                catch (ViewGroup viewgroup)
                {
                    return view;
                }
            }
            return view;
        }

        void log(String s)
        {
        }

        public void setListArray(ArrayList arraylist)
        {
            lm = arraylist;
        }

        public void update(Observable observable, Object obj)
        {
            Log.e("getUpdateTypeRilis", ponselBaseApp.getObserver().getUpdateType().toString());
            if (ponselBaseApp.getObserver().getUpdateType().toString().equals("komentar"))
            {
                Log.e("updateViewKomenPonsel", ponselBaseApp.getObserver().getUpdateType().toString());
                updateViewKomenPonsel(ponselBaseApp.getObserver().getIndexHp());
            } else
            if (ponselBaseApp.getObserver().getUpdateType().toString().equals("likedisPonsel"))
            {
                Log.e("updateViewLikeDisPonsel", ponselBaseApp.getObserver().getUpdateType().toString());
                if (random_codename.equals(ponselBaseApp.getObserver().getIndexHp()))
                {
                    load_random_hp();
                }
                updateViewLikeDisPonsel(ponselBaseApp.getObserver().getIndexHp());
                return;
            }
        }

        public void updateViewKomenPonsel(String s)
        {
            Log.e("ponselBaseApp", s);
            int i = 0;
            do
            {
                if (i >= listRilis.getChildCount())
                {
                    return;
                }
                Log.e("int i", String.valueOf(i));
                View view = listRilis.getChildAt(i);
                TextView textview = (TextView)view.findViewById(0x7f0b0344);
                TextView textview1 = (TextView)view.findViewById(0x7f0b0347);
                TextView textview2 = (TextView)view.findViewById(0x7f0b034a);
                if (((TextView)view.findViewById(0x7f0b033f)).getText().toString().equals(s))
                {
                    textview.setText(ponselBaseApp.getObserver().getTot_LikePon());
                    textview1.setText(ponselBaseApp.getObserver().getTotdis_LikePon());
                    textview2.setText(ponselBaseApp.getObserver().getJum_komenLikePon());
                }
                i++;
            } while (true);
        }

        public void updateViewLikeDisPonsel(String s)
        {
            int i;
            Log.e("ponselBaseApp", s);
            Log.e("listRilis.getChildCount()", String.valueOf(listRilis.getChildCount()));
            i = 0;
_L2:
            ImageView imageview;
            ImageView imageview1;
            RelativeLayout relativelayout;
            Object obj;
            if (i >= listRilis.getChildCount())
            {
                return;
            }
            Log.e("int itRilis", String.valueOf(i));
            obj = listRilis.getChildAt(i);
            TextView textview = (TextView)((View) (obj)).findViewById(0x7f0b0344);
            TextView textview1 = (TextView)((View) (obj)).findViewById(0x7f0b0347);
            imageview = (ImageView)((View) (obj)).findViewById(0x7f0b0343);
            imageview1 = (ImageView)((View) (obj)).findViewById(0x7f0b0346);
            TextView textview2 = (TextView)((View) (obj)).findViewById(0x7f0b034a);
            TextView textview3 = (TextView)((View) (obj)).findViewById(0x7f0b033f);
            relativelayout = (RelativeLayout)((View) (obj)).findViewById(0x7f0b0342);
            obj = (RelativeLayout)((View) (obj)).findViewById(0x7f0b0345);
            if (textview3.getText().toString().equals(s))
            {
                Log.e("getTot_LikePonPend", ponselBaseApp.getObserver().getJum_komenLikePon().toString());
                Log.e("getTot_LikePonPend", ponselBaseApp.getObserver().getTot_LikePon().toString());
                Log.e("getTotdis_LikePonPend", ponselBaseApp.getObserver().getTotdis_LikePon().toString());
                textview.setText(ponselBaseApp.getObserver().getTot_LikePon());
                textview1.setText(ponselBaseApp.getObserver().getTotdis_LikePon());
                textview2.setText(ponselBaseApp.getObserver().getJum_komenLikePon());
                if (!ponselBaseApp.getObserver().getStatus_like_ponsel().equals("1"))
                {
                    break; /* Loop/switch isn't completed */
                }
                imageview.setBackgroundResource(0x7f02025b);
                imageview1.setBackgroundResource(0x7f0201a3);
                relativelayout.setEnabled(false);
                ((RelativeLayout) (obj)).setEnabled(true);
            }
_L3:
            i++;
            if (true) goto _L2; else goto _L1
_L1:
            if (ponselBaseApp.getObserver().getStatus_like_ponsel().equals("0"))
            {
                imageview.setBackgroundResource(0x7f020257);
                imageview1.setBackgroundResource(0x7f0201a7);
                relativelayout.setEnabled(true);
                ((RelativeLayout) (obj)).setEnabled(false);
            } else
            {
                relativelayout.setEnabled(true);
                ((RelativeLayout) (obj)).setEnabled(true);
                imageview.setBackgroundResource(0x7f020257);
                imageview1.setBackgroundResource(0x7f0201a3);
                relativelayout.setBackgroundResource(0x7f020079);
                ((RelativeLayout) (obj)).setBackgroundResource(0x7f020079);
            }
              goto _L3
            if (true) goto _L2; else goto _L4
_L4:
        }



        public ListTopHitsAdapter(Activity activity1, int i, ArrayList arraylist)
        {
            this$0 = HomeNewMainActivity.this;
            super();
            fmt = new DecimalFormat();
            fmts = new DecimalFormatSymbols();
            t = Utility.session(RestClient.pelihara);
            user = "";
            komen = "";
            email_user = "";
            finalUrl = "";
            t = Utility.session(t);
            lm = arraylist;
            activity = activity1;
            resource = i;
            ponselBaseApp = (PonselBaseApp)getApplication();
            ponselBaseApp.getObserver().addObserver(this);
            try
            {
                userFunctions = new UserFunctions();
                db = new DatabaseHandler(activity1);
                if (userFunctions.isUserLoggedIn(activity1))
                {
                    cursor = db.getAllData();
                    cursor.moveToFirst();
                    username = cursor.getString(4);
                    email_user = cursor.getString(5);
                }
                t = Utility.session(t);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (HomeNewMainActivity homenewmainactivity)
            {
                return;
            }
        }
    }

    public class ListTopHitsAdapter.PostBagusKurangTask extends AsyncTask
    {

        final ListTopHitsAdapter this$1;

        private void parseJSONLikePon(String s)
        {
            int i;
            try
            {
                JSONObject jsonobject = new JSONObject(s);
                postStatusPendLikePon = jsonobject.getString("success");
                postMessagePendLikePon = jsonobject.getString("message");
                Log.e("postStatusLikePon", s);
                jArray = jsonobject.getJSONArray("InPonsel");
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
            jum_komenLikePonPend = s.getString("total_kom");
            tot_LikePonPend = s.getString("total_like");
            totdis_LikePonPend = s.getString("total_dislike");
            Log.e("jum_komenLikePon", jum_komenLikePonPend);
            Log.e("tot_LikePon", tot_LikePonPend);
            Log.e("totdis_LikePon", totdis_LikePonPend);
            ponselBaseApp.getObserver().setJum_komenLikePon(jum_komenLikePonPend);
            ponselBaseApp.getObserver().setTot_LikePon(tot_LikePonPend);
            ponselBaseApp.getObserver().setTotdis_LikePon(totdis_LikePonPend);
            ponselBaseApp.getObserver().setUpdateType("likedisPonsel");
            i++;
            if (false)
            {
            } else
            {
                break MISSING_BLOCK_LABEL_65;
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
                if (android.os.Build.VERSION.SDK_INT > 9)
                {
                    StrictMode.setThreadPolicy((new android.os.StrictMode.ThreadPolicy.Builder()).permitAll().build());
                }
                Log.e("posA", String.valueOf(pos));
                avoid = finalUrl;
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("likedis_ponsel").append(Utility.BASE_FORMAT).append("?").append(avoid).toString();
                Log.e("pushURL", avoid);
                avoid = HttpPush.getResponse(avoid);
                res = avoid.toString();
                parseJSONLikePon(res);
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
            Log.e("postStatusLikePon", postStatusPendLikePon);
            if (!postStatusPendLikePon.equals("1"))
            {
                break MISSING_BLOCK_LABEL_121;
            }
            notificationLikeHelper.completed(namalengkapbgskrg, notificationLikeHelper.SucdislikeStatement);
            if (statusLikeHpRilis.equals("1"))
            {
                ponselBaseApp.getObserver().setStatus_like_ponsel("1");
                return;
            }
            try
            {
                ponselBaseApp.getObserver().setStatus_like_ponsel("0");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
            notificationLikeHelper.gagal(namalengkapbgskrg, notificationLikeHelper.gagallikeStatement);
            return;
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            if (statusLikeHpRilis.equals("1"))
            {
                notificationLikeHelper.createNotification(namalengkapbgskrg, notificationLikeHelper.likeStatement);
                return;
            } else
            {
                notificationLikeHelper.createNotification(namalengkapbgskrg, notificationLikeHelper.dislikeStatement);
                return;
            }
        }

        public ListTopHitsAdapter.PostBagusKurangTask()
        {
            this$1 = ListTopHitsAdapter.this;
            super();
        }
    }

    class ListTopHitsAdapter.ViewHolder
    {

        ImageView imageHp;
        CircleView img_hp_circle;
        ImageView list_dislike;
        RelativeLayout list_lay_dislike;
        RelativeLayout list_lay_kom;
        RelativeLayout list_lay_like;
        ImageView list_like;
        TextView list_text_dislike;
        TextView list_text_komentar;
        TextView list_text_like;
        TextView list_txtCodename;
        TextView list_txtHarga;
        TextView list_txtMerek;
        LinearLayout ll_master_item;
        ProgressBar progressbar_item;
        RatingBar rateRate;
        RelativeLayout rl_hp_small;
        final ListTopHitsAdapter this$1;
        TextView txt_no_apps;

        ListTopHitsAdapter.ViewHolder()
        {
            this$1 = ListTopHitsAdapter.this;
            super();
        }
    }

    static abstract class MyMenuItemStuffListener
        implements android.view.View.OnClickListener, android.view.View.OnLongClickListener
    {

        private String hint;
        private View view;

        public abstract void onClick(View view1);

        public boolean onLongClick(View view1)
        {
            view1 = new int[2];
            Rect rect = new Rect();
            view.getLocationOnScreen(view1);
            view.getWindowVisibleDisplayFrame(rect);
            Object obj = view.getContext();
            int i = view.getWidth();
            int j = view.getHeight();
            int k = view1[1];
            int l = j / 2;
            int i1 = ((Context) (obj)).getResources().getDisplayMetrics().widthPixels;
            obj = Toast.makeText(((Context) (obj)), hint, 0);
            if (k + l < rect.height())
            {
                ((Toast) (obj)).setGravity(53, i1 - view1[0] - i / 2, j);
            } else
            {
                ((Toast) (obj)).setGravity(81, 0, j);
            }
            ((Toast) (obj)).show();
            return true;
        }

        MyMenuItemStuffListener(View view1, String s)
        {
            view = view1;
            hint = s;
            view1.setOnClickListener(this);
            view1.setOnLongClickListener(this);
        }
    }

    public class NetworkReceiver extends BroadcastReceiver
    {

        final HomeNewMainActivity this$0;

        public void onReceive(Context context, Intent intent)
        {
            context = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
            if ("Wi-Fi".equals(HomeNewMainActivity.sPref) && context != null && context.getType() == 1)
            {
                HomeNewMainActivity.refreshDisplay = true;
                return;
            }
            if (context != null && context.isConnected())
            {
                HomeNewMainActivity.refreshDisplay = true;
                return;
            }
            if ("Any".equals(HomeNewMainActivity.sPref) && context != null)
            {
                HomeNewMainActivity.refreshDisplay = true;
                return;
            } else
            {
                HomeNewMainActivity.refreshDisplay = false;
                showErrorPage();
                return;
            }
        }

        public NetworkReceiver()
        {
            this$0 = HomeNewMainActivity.this;
            super();
        }
    }

    private class PalingHotTask extends AsyncTask
    {

        final HomeNewMainActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            {
                avoid = (new ServiceHandler()).makeServiceCall(dataPalingHot, 1);
                palingHotArray.clear();
                palingHotStrStat = avoid;
                if (avoid == null)
                {
                    break MISSING_BLOCK_LABEL_267;
                }
                ListModel listmodel;
                int i;
                try
                {
                    avoid = new JSONObject(avoid);
                    inponsel = avoid.getJSONArray("InPonsel");
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_274;
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_274;
                }
                i = 0;
            }
            if (i >= inponsel.length())
            {
                break MISSING_BLOCK_LABEL_274;
            }
            avoid = inponsel.getJSONObject(i);
            listmodel = new ListModel();
            listmodel.setId_hp(avoid.getString("id_hp"));
            listmodel.setModel(avoid.getString("model"));
            listmodel.setMerk(avoid.getString("merk"));
            listmodel.setCodename(avoid.getString("codename"));
            listmodel.setGambar(avoid.getString("gambar"));
            listmodel.setUmu_status(avoid.getString("umu_status"));
            listmodel.setHrg_baru(avoid.getString("hrg_baru"));
            listmodel.setHrg_bekas(avoid.getString("hrg_bekas"));
            listmodel.setTotal_like(avoid.getString("total_like"));
            listmodel.setTotal_dislike(avoid.getString("total_dislike"));
            listmodel.setTotal_hits(avoid.getString("total_hits"));
            listmodel.setTotal_kom(avoid.getString("total_kom"));
            listmodel.setMy_like_pon(avoid.getString("my_like_pon"));
            palingHotArray.add(listmodel);
            i++;
            if (true)
            {
                break MISSING_BLOCK_LABEL_65;
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
            listPalingHot.setVisibility(0);
            isFinish3 = true;
            if (palingHotStrStat != null)
            {
                break MISSING_BLOCK_LABEL_99;
            }
            if (palingHotArray.size() != 0) goto _L2; else goto _L1
_L1:
            txtMorePalingHot.setText("REFRESH");
_L3:
            txtMorePalingHot.getText().toString().toLowerCase().contains("refresh");
            return;
_L2:
            try
            {
                txtMorePalingHot.setText("MORE");
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
              goto _L3
            palingHotAdapter.notifyDataSetChanged();
              goto _L3
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            txtMorePalingHot.setVisibility(8);
        }

        private PalingHotTask()
        {
            this$0 = HomeNewMainActivity.this;
            super();
        }

        PalingHotTask(PalingHotTask palinghottask)
        {
            this();
        }
    }

    private class PendatangTask extends AsyncTask
    {

        final HomeNewMainActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            {
                avoid = (new ServiceHandler()).makeServiceCall(dataPendatang, 1);
                Log.d("Responsependatang: ", (new StringBuilder("> ")).append(avoid).toString());
                pendatangArray.clear();
                pendatangStrStat = avoid;
                if (avoid == null)
                {
                    break MISSING_BLOCK_LABEL_288;
                }
                ListModel listmodel;
                int i;
                try
                {
                    avoid = new JSONObject(avoid);
                    inponsel = avoid.getJSONArray("InPonsel");
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_295;
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_295;
                }
                i = 0;
            }
            if (i >= inponsel.length())
            {
                break MISSING_BLOCK_LABEL_295;
            }
            avoid = inponsel.getJSONObject(i);
            listmodel = new ListModel();
            listmodel.setId_hp(avoid.getString("id_hp"));
            listmodel.setModel(avoid.getString("model"));
            listmodel.setMerk(avoid.getString("merk"));
            listmodel.setCodename(avoid.getString("codename"));
            listmodel.setGambar(avoid.getString("gambar"));
            listmodel.setUmu_status(avoid.getString("umu_status"));
            listmodel.setHrg_baru(avoid.getString("hrg_baru"));
            listmodel.setHrg_bekas(avoid.getString("hrg_bekas"));
            listmodel.setTotal_like(avoid.getString("total_like"));
            listmodel.setTotal_dislike(avoid.getString("total_dislike"));
            listmodel.setTotal_hits(avoid.getString("total_hits"));
            listmodel.setTotal_kom(avoid.getString("total_kom"));
            listmodel.setMy_like_pon(avoid.getString("my_like_pon"));
            pendatangArray.add(listmodel);
            i++;
            if (true)
            {
                break MISSING_BLOCK_LABEL_86;
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
            txtMorePendatang.setVisibility(0);
            progressbar_pendatang.setVisibility(8);
            listPendatang.setVisibility(0);
            if (pendatangStrStat != null)
            {
                break MISSING_BLOCK_LABEL_114;
            }
            if (pendatangArray.size() != 0) goto _L2; else goto _L1
_L1:
            txtMorePendatang.setText("REFRESH");
_L3:
            txtMorePendatang.getText().toString().toLowerCase().contains("refresh");
            return;
_L2:
            try
            {
                txtMorePendatang.setText("MORE");
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
              goto _L3
            pendatangAdapter.notifyDataSetChanged();
              goto _L3
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            txtMorePendatang.setVisibility(8);
        }

        private PendatangTask()
        {
            this$0 = HomeNewMainActivity.this;
            super();
        }

        PendatangTask(PendatangTask pendatangtask)
        {
            this();
        }
    }

    public class PostBagusKurangTask extends AsyncTask
    {

        final HomeNewMainActivity this$0;

        private void parseJSONLikePon(String s)
        {
            try
            {
                JSONObject jsonobject = new JSONObject(s);
                postStatusLikePon = jsonobject.getString("success");
                postMessageLikePon = jsonobject.getString("message");
                Log.e("postStatusLikePon", s);
                jArray = jsonobject.getJSONArray("InPonsel");
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
                if (android.os.Build.VERSION.SDK_INT > 9)
                {
                    StrictMode.setThreadPolicy((new android.os.StrictMode.ThreadPolicy.Builder()).permitAll().build());
                }
                avoid = (new StringBuilder("idhp=")).append(random_id_hp).append("&email=").append(username).append("&namalengkap=").append(URLEncoder.encode(random_merek_hp, "utf-8")).append("&status=").append(statusLikeHp).append("&t=").append(t).toString();
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("likedis_ponsel").append(Utility.BASE_FORMAT).append("?").append(avoid).toString();
                Log.e("pushURL", avoid);
                parseJSONLikePon(HttpPush.getResponse(avoid).toString());
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
            Log.e("postStatusLikePon", postStatusLikePon);
            if (!postStatusLikePon.equals("1"))
            {
                break MISSING_BLOCK_LABEL_120;
            }
            img_likerandom_ponsel.setEnabled(false);
            img_dislikerandom_ponsel.setEnabled(false);
            if (!statusLikeHp.equals("1"))
            {
                break MISSING_BLOCK_LABEL_104;
            }
            img_likerandom_ponsel.setBackgroundResource(0x7f02020b);
_L2:
            (new Handler()).postDelayed(new Runnable() {

                final PostBagusKurangTask this$1;

                public void run()
                {
                    load_random_hp();
                }

            
            {
                this$1 = PostBagusKurangTask.this;
                super();
            }
            }, 2000L);
            return;
            img_dislikerandom_ponsel.setBackgroundResource(0x7f0201f2);
            if (true) goto _L2; else goto _L1
_L1:
            void1;
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
        }


        public PostBagusKurangTask()
        {
            this$0 = HomeNewMainActivity.this;
            super();
        }
    }

    public class RSSAsycTask extends AsyncTask
    {

        final HomeNewMainActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient Void doInBackground(String as[])
        {
            Log.e("RSSAsycTask", "doInBackground");
            as = new JSONObject(getJSONUrl(urlRSS));
            Log.e("rss_home", getJSONUrl(urlRSS));
            bottom_id = as.getString("bottom_id");
            top_id = as.getString("top_id");
            succesStat = as.getString("success");
            Log.e("bottom_id", bottom_id);
            Log.e("top_id", top_id);
            countKomOld = 0;
            as = as.getJSONArray("InPonsel");
            if (!succesStat.equals("1"))
            {
                break MISSING_BLOCK_LABEL_390;
            }
            mArrayListRSSData.clear();
            listBerita.removeAllViewsInLayout();
            int i = 0;
_L1:
            if (i >= as.length())
            {
                break MISSING_BLOCK_LABEL_390;
            }
            Object obj = HomeNewMainActivity.this;
            obj.countAllKom = ((HomeNewMainActivity) (obj)).countAllKom + 1;
            obj = HomeNewMainActivity.this;
            obj.countKomOld = ((HomeNewMainActivity) (obj)).countKomOld + 1;
            obj = as.getJSONObject(i);
            mArrayListRSSData.add(new ItemRSS(((JSONObject) (obj)).getString("id"), ((JSONObject) (obj)).getString("rss_id"), ((JSONObject) (obj)).getString("rss_title"), ((JSONObject) (obj)).getString("rss_portal"), ((JSONObject) (obj)).getString("rss_desc"), "", ((JSONObject) (obj)).getString("rss_srclink"), ((JSONObject) (obj)).getString("rss_date"), ((JSONObject) (obj)).getString("rss_img_ava"), ((JSONObject) (obj)).getString("rss_img"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("total_like"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("total_komen"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("total_hits"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("my_like_rss"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("my_fav_rss")));
            i++;
              goto _L1
            as;
            as.printStackTrace();
            strKonekStat = "0";
            ll_body.setVisibility(0);
            break MISSING_BLOCK_LABEL_390;
            as;
            as.printStackTrace();
            ll_body.setVisibility(0);
            return null;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            progressbar_LatestNews.setVisibility(8);
            if (!succesStat.equals("1")) goto _L2; else goto _L1
_L1:
            int i = 0;
_L5:
            if (i < mArrayListRSSData.size()) goto _L3; else goto _L2
_L2:
            return;
_L3:
            void1 = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f0300c7, null);
            txtUsername = (TextView)void1.findViewById(0x7f0b0419);
            txtTitle = (TextView)void1.findViewById(0x7f0b05ec);
            txtTitle.setTypeface(Typeface.DEFAULT, 0);
            img_kom_picture = (ImageView)void1.findViewById(0x7f0b054b);
            imageMedia = (ImageView)void1.findViewById(0x7f0b046c);
            txtIdKom = (TextView)void1.findViewById(0x7f0b054d);
            txtKomentar = (TextViewFixTouchConsume)void1.findViewById(0x7f0b054e);
            txtWaktu = (TextView)void1.findViewById(0x7f0b054c);
            txtImgAva = (TextView)void1.findViewById(0x7f0b05e9);
            txtImgMedia = (TextView)void1.findViewById(0x7f0b05ea);
            final String id_rss = (ImageView)void1.findViewById(0x7f0b054f);
            id_rss = (ImageView)void1.findViewById(0x7f0b0552);
            txtLikeKom = (TextView)void1.findViewById(0x7f0b0551);
            txtdisLikeKom = (TextView)void1.findViewById(0x7f0b0554);
            id_rss = ((ItemRSS)mArrayListRSSData.get(i)).getId();
            final String rss_id = ((ItemRSS)mArrayListRSSData.get(i)).getRss_id();
            final String rss_title = ((ItemRSS)mArrayListRSSData.get(i)).getRss_title();
            final String rss_portal = ((ItemRSS)mArrayListRSSData.get(i)).getRss_portal();
            final String rss_desc = ((ItemRSS)mArrayListRSSData.get(i)).getRss_desc();
            ((ItemRSS)mArrayListRSSData.get(i)).getRss_content();
            final String rss_srclink = ((ItemRSS)mArrayListRSSData.get(i)).getRss_srclink();
            final String rss_date = ((ItemRSS)mArrayListRSSData.get(i)).getRss_date();
            final String rss_img_ava = ((ItemRSS)mArrayListRSSData.get(i)).getRss_img_ava();
            final String rss_img = ((ItemRSS)mArrayListRSSData.get(i)).getRss_img();
            final String total_like = ((ItemRSS)mArrayListRSSData.get(i)).getRss_tot_like();
            final String like_stat = ((ItemRSS)mArrayListRSSData.get(i)).getRss_like_stat();
            final String total_komen = ((ItemRSS)mArrayListRSSData.get(i)).getRss_tot_komen();
            String s = ((ItemRSS)mArrayListRSSData.get(i)).getRss_fav_stat();
            txtTitle.setText(Html.fromHtml(rss_title));
            txtIdKom.setText(id_rss);
            txtUsername.setText((new StringBuilder(String.valueOf(rss_portal))).append(" - ").append(Utility.convertDate(rss_date)).toString());
            txtImgAva.setText(rss_img_ava);
            txtImgMedia.setText(rss_img);
            txtKomentar.setText((new StringBuilder()).append(Html.fromHtml(Utility.parseUrl(rss_desc))).toString());
            txtKomentar.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
            txtKomentar.setVisibility(8);
            txtLikeKom.setText(total_like);
            if (((ItemRSS)mArrayListRSSData.get(i)).getRss_img().trim().equals(""))
            {
                imageMedia.setVisibility(0);
                imageMedia.setImageResource(0x7f020243);
            } else
            {
                Picasso.with(HomeNewMainActivity.this).load(((ItemRSS)mArrayListRSSData.get(i)).getRss_img().toString().trim()).tag(HomeNewMainActivity.this).placeholder(0x7f020243).error(0x7f020243).into(imageMedia, new Callback() {

                    final RSSAsycTask this$1;

                    public void onError()
                    {
                    }

                    public void onSuccess()
                    {
                        imageMedia.setVisibility(0);
                    }

            
            {
                this$1 = RSSAsycTask.this;
                super();
            }
                });
            }
            txtWaktu.setText(Utility.convertDate(((ItemRSS)mArrayListRSSData.get(i)).getRss_date()));
            listBerita.addView(void1);
            void1.setOnClickListener(s. new android.view.View.OnClickListener() {

                final RSSAsycTask this$1;
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

                public void onClick(View view)
                {
                    idkom_pos = id_rss;
                    view = new Intent(_fld0, com/inponsel/android/rssfeeddetail/RSSDetailTab);
                    view.putExtra("actfrom", "rssfeed");
                    view.putExtra("kategori_tag", "");
                    view.putExtra("act", "firsttab");
                    view.putExtra("rss_id", rss_id);
                    view.putExtra("id_rss", id_rss);
                    view.putExtra("rss_title", rss_title);
                    view.putExtra("rss_portal", rss_portal);
                    view.putExtra("rss_desc", rss_desc);
                    view.putExtra("rss_srclink", rss_srclink);
                    view.putExtra("rss_date", rss_date);
                    view.putExtra("rss_img_ava", rss_img_ava);
                    view.putExtra("rss_img", rss_img);
                    view.putExtra("total_like", total_like);
                    view.putExtra("like_stat", like_stat);
                    view.putExtra("total_komen", total_komen);
                    view.putExtra("fav_stat", fav_stat);
                    startActivityForResult(view, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$1 = final_rssasyctask;
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
                fav_stat = String.this;
                super();
            }
            });
            i++;
            if (true) goto _L5; else goto _L4
_L4:
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            Log.e("RSSAsycTask", "onPreExecute");
        }


        public RSSAsycTask()
        {
            this$0 = HomeNewMainActivity.this;
            super();
        }
    }

    private class RilisTask extends AsyncTask
    {

        final HomeNewMainActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            {
                avoid = (new ServiceHandler()).makeServiceCall(dataRilis, 1);
                Log.d("dataRilis", dataRilis);
                rilisTerbaruArray.clear();
                rilisStrStat = avoid;
                if (avoid == null)
                {
                    break MISSING_BLOCK_LABEL_279;
                }
                ListModel listmodel;
                int i;
                try
                {
                    avoid = new JSONObject(avoid);
                    inponsel = avoid.getJSONArray("InPonsel");
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_286;
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_286;
                }
                i = 0;
            }
            if (i >= inponsel.length())
            {
                break MISSING_BLOCK_LABEL_286;
            }
            avoid = inponsel.getJSONObject(i);
            listmodel = new ListModel();
            listmodel.setId_hp(avoid.getString("id_hp"));
            listmodel.setModel(avoid.getString("model"));
            listmodel.setMerk(avoid.getString("merk"));
            listmodel.setCodename(avoid.getString("codename"));
            listmodel.setGambar(avoid.getString("gambar"));
            listmodel.setUmu_status(avoid.getString("umu_status"));
            listmodel.setHrg_baru(avoid.getString("hrg_baru"));
            listmodel.setHrg_bekas(avoid.getString("hrg_bekas"));
            listmodel.setTotal_like(avoid.getString("total_like"));
            listmodel.setTotal_dislike(avoid.getString("total_dislike"));
            listmodel.setTotal_hits(avoid.getString("total_hits"));
            listmodel.setTotal_kom(avoid.getString("total_kom"));
            listmodel.setMy_like_pon(avoid.getString("my_like_pon"));
            rilisTerbaruArray.add(listmodel);
            i++;
            if (true)
            {
                break MISSING_BLOCK_LABEL_77;
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
            txtMoreRilis.setVisibility(0);
            progressbar_rilis.setVisibility(8);
            listRilis.setVisibility(0);
            if (rilisStrStat != null)
            {
                break MISSING_BLOCK_LABEL_125;
            }
            if (rilisTerbaruArray.size() != 0) goto _L2; else goto _L1
_L1:
            txtMoreRilis.setText("REFRESH");
_L3:
            txtMoreRilis.getText().toString().toLowerCase().contains("refresh");
            layout_rilis.setVisibility(0);
            return;
_L2:
            try
            {
                txtMoreRilis.setText("MORE");
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
              goto _L3
            rilisTerbaruAdapter.notifyDataSetChanged();
              goto _L3
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            txtMoreRilis.setVisibility(8);
        }

        private RilisTask()
        {
            this$0 = HomeNewMainActivity.this;
            super();
        }

        RilisTask(RilisTask rilistask)
        {
            this();
        }
    }

    private class SegeraTask extends AsyncTask
    {

        final HomeNewMainActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            {
                avoid = (new ServiceHandler()).makeServiceCall(dataSegera, 1);
                segeraArray.clear();
                segeraStrStat = avoid;
                if (avoid == null)
                {
                    break MISSING_BLOCK_LABEL_267;
                }
                ListModel listmodel;
                int i;
                try
                {
                    avoid = new JSONObject(avoid);
                    inponsel = avoid.getJSONArray("InPonsel");
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_274;
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_274;
                }
                i = 0;
            }
            if (i >= inponsel.length())
            {
                break MISSING_BLOCK_LABEL_274;
            }
            avoid = inponsel.getJSONObject(i);
            listmodel = new ListModel();
            listmodel.setId_hp(avoid.getString("id_hp"));
            listmodel.setModel(avoid.getString("model"));
            listmodel.setMerk(avoid.getString("merk"));
            listmodel.setCodename(avoid.getString("codename"));
            listmodel.setGambar(avoid.getString("gambar"));
            listmodel.setUmu_status(avoid.getString("umu_status"));
            listmodel.setHrg_baru(avoid.getString("hrg_baru"));
            listmodel.setHrg_bekas(avoid.getString("hrg_bekas"));
            listmodel.setTotal_like(avoid.getString("total_like"));
            listmodel.setTotal_dislike(avoid.getString("total_dislike"));
            listmodel.setTotal_hits(avoid.getString("total_hits"));
            listmodel.setTotal_kom(avoid.getString("total_kom"));
            listmodel.setMy_like_pon(avoid.getString("my_like_pon"));
            segeraArray.add(listmodel);
            i++;
            if (true)
            {
                break MISSING_BLOCK_LABEL_65;
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
            txtMoreSegera.setVisibility(0);
            progressbar_segera.setVisibility(8);
            listSegera.setVisibility(0);
            if (segeraStrStat != null)
            {
                break MISSING_BLOCK_LABEL_114;
            }
            if (segeraArray.size() != 0) goto _L2; else goto _L1
_L1:
            txtMoreSegera.setText("REFRESH");
_L3:
            txtMoreSegera.getText().toString().toLowerCase().contains("refresh");
            return;
_L2:
            try
            {
                txtMoreSegera.setText("MORE");
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
              goto _L3
            segeraAdapter.notifyDataSetChanged();
            layout_segera.setVisibility(0);
              goto _L3
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            dataSegera = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("home_segera").append(Utility.BASE_FORMAT).append("?idusr=").append(user_id).append("&lmt=0&t=").append(t).toString();
            txtMoreSegera.setVisibility(8);
            progressbar_segera.setVisibility(0);
        }

        private SegeraTask()
        {
            this$0 = HomeNewMainActivity.this;
            super();
        }

        SegeraTask(SegeraTask segeratask)
        {
            this();
        }
    }

    private class TopHitsTask extends AsyncTask
    {

        final HomeNewMainActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            {
                avoid = (new ServiceHandler()).makeServiceCall(dataTopHits, 1);
                Log.e("dataTopHits", dataTopHits);
                topHitsArray.clear();
                topHitsStrStat = avoid;
                if (avoid == null)
                {
                    break MISSING_BLOCK_LABEL_289;
                }
                ListModel listmodel;
                int i;
                try
                {
                    avoid = new JSONObject(avoid);
                    inponsel = avoid.getJSONArray("InPonsel");
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_296;
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_296;
                }
                i = 0;
            }
            if (i >= inponsel.length())
            {
                break MISSING_BLOCK_LABEL_296;
            }
            avoid = inponsel.getJSONObject(i);
            listmodel = new ListModel();
            listmodel.setId_hp(avoid.getString("id_hp"));
            listmodel.setModel(avoid.getString("model"));
            listmodel.setMerk(avoid.getString("merk"));
            listmodel.setCodename(avoid.getString("codename"));
            listmodel.setGambar(avoid.getString("gambar"));
            listmodel.setUmu_status(avoid.getString("umu_status"));
            listmodel.setHrg_baru(avoid.getString("hrg_baru"));
            listmodel.setHrg_bekas(avoid.getString("hrg_bekas"));
            listmodel.setTotal_like(avoid.getString("total_like"));
            listmodel.setTotal_dislike(avoid.getString("total_dislike"));
            listmodel.setTotal_hits(avoid.getString("total_hits"));
            listmodel.setTotal_kom(avoid.getString("total_kom"));
            listmodel.setMy_like_pon(avoid.getString("my_like_pon"));
            listmodel.setBackground_color(avoid.getString("background"));
            topHitsArray.add(listmodel);
            i++;
            if (true)
            {
                break MISSING_BLOCK_LABEL_77;
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
            txtMoreTopHits.setVisibility(0);
            progressbar_TopHits.setVisibility(8);
            listTopHits.setVisibility(0);
            if (topHitsStrStat != null)
            {
                break MISSING_BLOCK_LABEL_125;
            }
            if (topHitsArray.size() != 0) goto _L2; else goto _L1
_L1:
            txtMoreTopHits.setText("REFRESH");
_L3:
            txtMoreTopHits.getText().toString().toLowerCase().contains("refresh");
            layout_TopHits.setVisibility(0);
            return;
_L2:
            try
            {
                txtMoreTopHits.setText("MORE");
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
              goto _L3
            topHitsAdapter.notifyDataSetChanged();
              goto _L3
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            txtMoreTopHits.setVisibility(8);
            progressbar_TopHits.setVisibility(0);
        }

        private TopHitsTask()
        {
            this$0 = HomeNewMainActivity.this;
            super();
        }

        TopHitsTask(TopHitsTask tophitstask)
        {
            this();
        }
    }


    public static final String ANY = "Any";
    public static final String ARG_ITEM_ID = "home_fragment";
    public static final String WIFI = "Wi-Fi";
    private static boolean mobileConnected = false;
    public static boolean refreshDisplay = true;
    public static String sPref = null;
    private static boolean wifiConnected = false;
    int CONNECTION_STAT;
    AlertDialog alertDialog;
    Animation animMove;
    Animation animMove2;
    ArrayList arrayListAds;
    ArrayList arrayListInteraksi;
    ArrayList arrayListKat2Apps;
    ArrayList arrayListWeekApps;
    String background_interaksi;
    String bottom_id;
    RelativeLayout btnMorePendatang;
    RelativeLayout btnMoreRilis;
    RelativeLayout btnMoreSegera;
    RelativeLayout btnMoreTerbaruBrand;
    RelativeLayout btnMoreTopHits;
    Button btnRefreshconnection;
    Button btn_doodle_action;
    Button btn_head_banner_refresh;
    int charCount;
    CircleProgressBar circle_progress_doodle;
    String codename;
    int countAllKom;
    int countKomOld;
    int countRemIndex;
    int counterLoad;
    CircularProgressBar cpb_home;
    CustomInteraksiPagerAdapter customInteraksiPagerAdapter;
    CustomPagerAdapter customPagerAdapter;
    String dataPalingHot;
    String dataPendatang;
    String dataRilis;
    String dataSegera;
    String dataTopHits;
    String dataTopRate;
    String datalatestBrand;
    Bundle extras;
    int fb_ads_count;
    float final_height;
    float final_width;
    String gambar;
    String gcmMessage;
    String gcmNotiftype;
    String gcmTitle;
    final Handler handler = new Handler();
    RelativeLayout home_menu_Conversation;
    LinearLayout home_menu_gadget_pilihan;
    RelativeLayout home_menu_gadget_rumor;
    RelativeLayout home_menu_gadget_segera;
    RelativeLayout home_menu_news_tips;
    LinearLayout home_menu_turun_harga;
    RelativeLayout home_menu_user_ponsel;
    int hot_number;
    String hrg_baru;
    String hrg_bekas;
    String id_hph;
    String id_news1;
    String id_news2;
    String idkom_pos;
    ImageView imageMedia;
    ImageView image_news1;
    ImageView image_news2;
    ImageView imgHpRandom;
    ImageView img_Notification;
    ImageView img_brand;
    ImageView img_dislikerandom_ponsel;
    ImageView img_head_banner;
    ImageView img_kom_picture;
    ImageView img_likerandom_ponsel;
    ImageView img_menubottom_conv;
    ImageView img_menubottom_forum;
    ImageView img_menubottom_hprumor;
    ImageView img_menubottom_panduanbel;
    ImageView img_menubottom_pencrinci;
    ImageView img_menubottom_rekomendasi;
    ImageView img_refresh_fbads;
    ImageView img_refresh_interaksi;
    String img_urlnews1;
    String img_urlnews2;
    CircleImageView img_user_ponsel;
    String indexhp;
    boolean isFinish2;
    boolean isFinish3;
    String jum_komen;
    String jum_komenLikePonPend;
    ListSegeraAdapter latestBrandAdapter;
    ArrayList latestBrandArray;
    String latestBrandStrStat;
    LinearLayout lay_quote;
    LinearLayout layout_TerbaruBrand;
    LinearLayout layout_TopHits;
    LinearLayout layout_pendatang;
    LinearLayout layout_rilis;
    LinearLayout layout_segera;
    int limit;
    ExpandableHeightGridView listAppsMingguIni;
    ListAppsAdapter listAppsWeekAdapter;
    LinearLayout listBerita;
    ListKategoriApps2Adapter listKatApps2Adapter;
    ExpandableHeightGridView listKategori2Apps;
    GridView listPalingHot;
    GridView listPendatang;
    GridView listRilis;
    GridView listSegera;
    GridView listTerbaruBrand;
    GridView listTopHits;
    TextView list_txtHargaRandom;
    TextView list_txtMerekRandom;
    RelativeLayout ll_RekomendApps;
    LinearLayout ll_body;
    LinearLayout ll_connection;
    LinearLayout ll_home_aplikasi;
    LinearLayout ll_home_chatroom;
    LinearLayout ll_home_forum;
    LinearLayout ll_home_gadget;
    LinearLayout ll_home_games;
    LinearLayout ll_home_inbox;
    LinearLayout ll_home_news;
    LinearLayout ll_home_sc;
    LinearLayout ll_home_setting;
    LinearLayout ll_home_turunharga;
    LinearLayout ll_menu_banner;
    LinearLayout ll_segmen_1;
    LinearLayout ll_segmen_2;
    LinearLayout ll_segmen_3;
    LinearLayout ll_segmen_4;
    String lts_brand_idmerk;
    String lts_brand_logo;
    String lts_brand_merk;
    String lts_brand_total;
    private ArrayList mArrayListRSSData;
    private Transformation mTransformation;
    String menu_img_conv;
    String menu_img_forum;
    String menu_img_hprumor;
    String menu_img_panduanbelanja;
    String menu_img_pencrinci;
    String menu_img_rekomendasi;
    String merk;
    String message;
    String model;
    String namalengkap;
    String namalengkapbgskrg;
    LinearLayout nativeAdContainer;
    NotificationLikeHelper notificationLikeHelper;
    DisplayImageOptions optionsDoodle;
    ListSegeraAdapter palingHotAdapter;
    ArrayList palingHotArray;
    String palingHotStrStat;
    ListPendatangAdapter pendatangAdapter;
    ArrayList pendatangArray;
    String pendatangStrStat;
    TextView pop_txt_empty;
    int position1;
    int position2;
    int position3;
    int position4;
    String postMessage;
    String postMessageLikePon;
    String postMessagePendLikePon;
    String postStatus;
    String postStatusLikePon;
    String postStatusPendLikePon;
    SharedPreferences prefGCM;
    CircularProgressBar progbar_appsrecomend;
    CircularProgressBar progressbar_LatestNews;
    CircularProgressBar progressbar_TopHits;
    CircularProgressBar progressbar_connection;
    CircularProgressBar progressbar_hp_random;
    CircularProgressBar progressbar_pendatang;
    CircularProgressBar progressbar_rilis;
    ProgressBar progressbar_segera;
    CircularProgressBar progressbar_segmen1;
    CircularProgressBar progressbar_segmen2;
    CircularProgressBar progressbar_segmen3;
    CircularProgressBar progressbar_segmen4;
    CircularProgressBar progressbar_viewpager_ads;
    CircularProgressBar progressbar_viewpager_head_news;
    CircularProgressBar progressbar_viewpager_interaksi;
    CircularProgressBar progressbar_viewpager_tips_news;
    String random_background;
    String random_codename;
    String random_harga_hp;
    String random_id_hp;
    String random_img_url;
    String random_like;
    String random_merek_hp;
    String random_umu_status;
    private NetworkReceiver receiver;
    String regid;
    int removeIndex;
    int removeNextIndex;
    int removeStartOld;
    String rilisStrStat;
    ListRilisTerbaruAdapter rilisTerbaruAdapter;
    ArrayList rilisTerbaruArray;
    RelativeLayout rl_background_random;
    RelativeLayout rl_campaign_text;
    RelativeLayout rl_gadget_merk;
    RelativeLayout rl_head_banner;
    RelativeLayout rl_hp_random;
    RelativeLayout rl_menubottom_conv;
    RelativeLayout rl_menubottom_forum;
    RelativeLayout rl_menubottom_hprumor;
    RelativeLayout rl_menubottom_panduanbel;
    RelativeLayout rl_menubottom_pencrinci;
    RelativeLayout rl_menubottom_rekomendasi;
    RelativeLayout rl_rekomendasi_apps;
    RelativeLayout rl_root_news;
    RelativeLayout rl_root_news2;
    RelativeLayout rl_slideshow_ads;
    RelativeLayout rl_slideshow_head_news;
    RelativeLayout rl_slideshow_interaksi;
    RelativeLayout rl_slideshow_tips_news;
    int scroll_count;
    ListSegeraAdapter segeraAdapter;
    ArrayList segeraArray;
    String segeraStrStat;
    String statusLikeHp;
    boolean stopSlidingAds;
    boolean stopSlidingInteraksi;
    boolean stopSlidingTipsNews;
    String strKonekStat;
    String str_doodle_action;
    String str_doodle_height;
    String str_doodle_img;
    String str_doodle_subtitle;
    String str_doodle_text_action;
    String str_doodle_title;
    String str_doodle_url;
    String str_doodle_width;
    String str_id_user;
    String succesStat;
    ParallaxScrollView sv_root;
    Timer timer1;
    Timer timer2;
    Timer timer3;
    Timer timer4;
    TimerTask timerTask1;
    TimerTask timerTask2;
    TimerTask timerTask3;
    TimerTask timerTask4;
    String title_news1;
    String title_news2;
    ListTopHitsAdapter topHitsAdapter;
    ArrayList topHitsArray;
    String topHitsStrStat;
    String top_id;
    String tot_LikePon;
    String tot_LikePonPend;
    String tot_dislike;
    String tot_komen;
    String tot_like;
    String totdis_LikePon;
    String totdis_LikePonPend;
    TextView txtBigLatestNewsBARU;
    TextView txtBigPENDATANGBARU;
    TextView txtBigRILISTERBARU;
    TextView txtBigTerbaruBrand;
    TextView txtBigTopHitsBARU;
    TextView txtIdKom;
    TextView txtImgAva;
    TextView txtImgMedia;
    TextViewFixTouchConsume txtKomentar;
    TextViewFixTouchConsume txtKomentarQoute;
    TextView txtLikeKom;
    TextView txtMoreInteraksi;
    TextView txtMoreJempolInPonsel;
    TextView txtMoreLatestNews;
    TextView txtMorePalingHot;
    TextView txtMorePendatang;
    TextView txtMoreRilis;
    TextView txtMoreSegera;
    TextView txtMoreTerbaruBrand;
    TextView txtMoreTopHits;
    TextView txtMoreTopRecomended;
    TextView txtNamaHp;
    TextView txtTanggapan;
    TextView txtTitle;
    TextView txtUnreadCountMenu;
    TextView txtUnreadCountgroupchat;
    TextView txtUsername;
    TextView txtUsernameQoute;
    TextView txtWaktu;
    TextView txtWaktuQoute;
    TextView txt_connection;
    TextView txt_doodle_subtitle;
    TextView txt_doodle_title;
    TextView txt_home_inponsel;
    TextView txt_judul_news;
    TextView txt_judul_news2;
    TextView txt_menubottom_conv;
    TextView txt_menubottom_forum;
    TextView txt_menubottom_panduanbelanja;
    TextView txt_menubottom_pencrinci;
    TextView txt_menubottom_rekomendasi;
    TextView txt_menubottom_rumor;
    TextView txt_notif_count;
    TextView txt_user_name_1;
    TextView txt_user_ponsel_1;
    TextView txt_user_ponseldesc_1;
    TextView txtdisLikeKom;
    String urlAds;
    String urlHeadline;
    String urlInteraksiHp;
    String urlRSS;
    String urlTipsNews;
    private AutoScrollViewPager view_pager_ads;
    private AutoScrollViewPager view_pager_interaksi;

    public HomeNewMainActivity()
    {
        hot_number = 0;
        postStatus = "";
        postMessage = "";
        limit = 0;
        removeIndex = 0;
        removeStartOld = 0;
        removeNextIndex = 0;
        countRemIndex = 0;
        counterLoad = 1;
        str_id_user = "";
        regid = "";
        arrayListWeekApps = null;
        scroll_count = 1;
        isFinish2 = false;
        isFinish3 = false;
        receiver = new NetworkReceiver();
        CONNECTION_STAT = 10;
        urlRSS = "";
        bottom_id = "";
        top_id = "0";
        jum_komen = "0";
        tot_LikePon = "";
        totdis_LikePon = "";
        succesStat = "";
        strKonekStat = "";
        stopSlidingInteraksi = false;
        stopSlidingTipsNews = false;
        stopSlidingAds = false;
        arrayListAds = null;
        arrayListInteraksi = null;
        urlAds = "";
        pendatangArray = null;
        postStatusPendLikePon = "";
        postMessagePendLikePon = "";
        tot_LikePonPend = "0";
        totdis_LikePonPend = "0";
        jum_komenLikePonPend = "0";
        indexhp = "";
        dataPendatang = "";
        pendatangStrStat = "";
        dataRilis = "";
        rilisStrStat = "";
        urlHeadline = "";
        urlInteraksiHp = "";
        statusLikeHp = "";
        urlTipsNews = "";
        rilisTerbaruArray = null;
        topHitsArray = null;
        dataTopHits = "";
        topHitsStrStat = "";
        background_interaksi = "";
        arrayListKat2Apps = null;
        fb_ads_count = 0;
        postStatusLikePon = "";
        postMessageLikePon = "";
        countKomOld = 0;
        countAllKom = 0;
        str_doodle_width = "1024";
        str_doodle_height = "600";
        gcmNotiftype = "";
        position1 = 0;
        position2 = 0;
        position3 = 0;
        position4 = 0;
        segeraArray = null;
        latestBrandArray = null;
        lts_brand_idmerk = "";
        lts_brand_merk = "";
        lts_brand_total = "";
        lts_brand_logo = "";
        latestBrandStrStat = "";
        datalatestBrand = "";
        dataPalingHot = "";
        dataTopRate = "";
        palingHotArray = null;
    }

    private void PushOnlineStat(String s)
    {
        s = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("user_last_seen").append(Utility.BASE_FORMAT).append("?").append("id_user=").append(user_id).append("&reg_id=").append("0").append("&stat=").append(s).append("&t=").append(t).toString();
        Log.e("pushOnline", s);
        s = new MyObjectRequest(s, new com.android.volley.Response.Listener() {

            final HomeNewMainActivity this$0;

            public volatile void onResponse(Object obj)
            {
                onResponse((JSONObject)obj);
            }

            public void onResponse(JSONObject jsonobject)
            {
                Log.e("response", jsonobject.toString());
                JSONObject jsonobject2;
                int i;
                try
                {
                    JSONObject jsonobject1 = new JSONObject(jsonobject.toString());
                    Log.e("UpdateEmail", jsonobject.toString());
                    jsonobject = jsonobject1.getJSONArray("InPonsel");
                }
                // Misplaced declaration of an exception variable
                catch (JSONObject jsonobject)
                {
                    jsonobject.printStackTrace();
                    return;
                }
                i = 0;
                if (i >= jsonobject.length())
                {
                    return;
                }
                jsonobject2 = jsonobject.getJSONObject(i);
                db.update_EmailbyID(jsonobject2.getString("email"));
                i++;
                if (false)
                {
                } else
                {
                    break MISSING_BLOCK_LABEL_39;
                }
            }

            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final HomeNewMainActivity this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
            }

            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
        }, "test", "test");
        PonselBaseApp.getInstance().addToRequestQueue(s, "");
    }

    private void UpdateGCMReg(String s)
    {
        Object obj;
        String s1;
        String s2;
        String s3;
        String s5;
        s3 = "";
        s5 = "";
        obj = "";
        s2 = s5;
        s1 = ((String) (obj));
        String s4 = URLEncoder.encode(Build.MODEL, "utf-8");
        s3 = s4;
        s2 = s5;
        s1 = ((String) (obj));
        s5 = String.valueOf(android.os.Build.VERSION.SDK_INT);
        s3 = s4;
        s2 = s5;
        s1 = ((String) (obj));
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        s3 = s4;
        s2 = s5;
        s1 = ((String) (obj));
        Account aaccount[] = AccountManager.get(this).getAccounts();
        s3 = s4;
        s2 = s5;
        s1 = ((String) (obj));
        int j = aaccount.length;
        int i = 0;
_L3:
        if (i < j) goto _L2; else goto _L1
_L1:
        s2 = s5;
        s3 = s4;
_L4:
        s = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("login_updategcm").append(Utility.BASE_FORMAT).append("?").append("id_user=").append(user_id).append("&reg=").append(s).append("&email=").append(((String) (obj))).append("&dev=").append(s3).append("&dos=").append(s2).append("&t=").append(t).toString();
        Log.e("urlUpdateGCM", s);
        s = new MyObjectRequest(s, new com.android.volley.Response.Listener() {

            final HomeNewMainActivity this$0;

            public volatile void onResponse(Object obj1)
            {
                onResponse((JSONObject)obj1);
            }

            public void onResponse(JSONObject jsonobject)
            {
            }

            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final HomeNewMainActivity this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
            }

            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
        }, "test", "test");
        PonselBaseApp.getInstance().addToRequestQueue(s, "tag_json_obj");
        return;
_L2:
        String s6;
        Account account;
        account = aaccount[i];
        s6 = ((String) (obj));
        s3 = s4;
        s2 = s5;
        s1 = ((String) (obj));
        if (!pattern.matcher(account.name).matches())
        {
            break MISSING_BLOCK_LABEL_321;
        }
        s3 = s4;
        s2 = s5;
        s1 = ((String) (obj));
        s6 = account.name;
        i++;
        obj = s6;
          goto _L3
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        unsupportedencodingexception.printStackTrace();
        unsupportedencodingexception = s1;
          goto _L4
    }

    private boolean appInstalledOrNot(String s)
    {
        PackageManager packagemanager = getPackageManager();
        try
        {
            packagemanager.getPackageInfo(s, 1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        return true;
    }

    private void load_image_doodle()
    {
        Log.e("load_image_doodle", str_doodle_img);
        try
        {
            ImageLoader.getInstance().displayImage(str_doodle_img, img_head_banner, optionsDoodle, new SimpleImageLoadingListener() {

                final HomeNewMainActivity this$0;

                public void onLoadingComplete(String s, View view, Bitmap bitmap)
                {
                    FadeInBitmapDisplayer.animate(img_head_banner, 500);
                    circle_progress_doodle.setVisibility(8);
                }

                public void onLoadingFailed(String s, View view, FailReason failreason)
                {
                    circle_progress_doodle.setVisibility(8);
                    btn_head_banner_refresh.setVisibility(0);
                    btn_head_banner_refresh.setOnClickListener(new android.view.View.OnClickListener() {

                        final _cls65 this$1;

                        public void onClick(View view)
                        {
                            load_image_doodle();
                        }

            
            {
                this$1 = _cls65.this;
                super();
            }
                    });
                }

                public void onLoadingStarted(String s, View view)
                {
                    circle_progress_doodle.setProgress(0.0F);
                    circle_progress_doodle.setVisibility(0);
                    btn_head_banner_refresh.setVisibility(8);
                }


            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
            }, new ImageLoadingProgressListener() {

                final HomeNewMainActivity this$0;

                public void onProgressUpdate(String s, View view, int i, int j)
                {
                    circle_progress_doodle.setProgress(Math.round((100F * (float)i) / (float)j));
                }

            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
            });
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    private void load_random_hp()
    {
        String s = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("home_random_hp").append(Utility.BASE_FORMAT).append("?t=").append(t).append("&id_user=").append(user_id).toString();
        Log.e("randomhp", s);
        (new AsyncHttpClient()).get(s, new AsyncHttpResponseHandler() {

            final HomeNewMainActivity this$0;

            public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
            {
                ll_segmen_2.setVisibility(0);
            }

            public void onRetry(int i)
            {
            }

            public void onStart()
            {
                progressbar_hp_random.setVisibility(0);
            }

            public void onSuccess(int i, Header aheader[], byte abyte0[])
            {
                aheader = new String(abyte0);
                isFinish2 = true;
                aheader = (new JSONObject(aheader)).getJSONArray("InPonsel");
                i = 0;
_L3:
                if (i < 1) goto _L2; else goto _L1
_L1:
                list_txtMerekRandom.setText(random_merek_hp);
                try
                {
                    rl_background_random.setBackgroundColor(Color.parseColor(random_background));
                }
                // Misplaced declaration of an exception variable
                catch (Header aheader[]) { }
                if (random_umu_status.equals("3") || random_harga_hp.equals("-") || random_harga_hp.equals("0"))
                {
                    list_txtHargaRandom.setVisibility(8);
                } else
                {
                    list_txtHargaRandom.setText(random_harga_hp);
                }
                if (random_like.equals("1"))
                {
                    img_likerandom_ponsel.setBackgroundResource(0x7f02020b);
                    img_dislikerandom_ponsel.setBackgroundResource(0x7f0201f1);
                    img_likerandom_ponsel.setEnabled(false);
                    img_dislikerandom_ponsel.setEnabled(true);
                } else
                if (random_like.equals("0"))
                {
                    img_likerandom_ponsel.setBackgroundResource(0x7f02020a);
                    img_dislikerandom_ponsel.setBackgroundResource(0x7f0201f2);
                    img_likerandom_ponsel.setEnabled(true);
                    img_dislikerandom_ponsel.setEnabled(false);
                } else
                {
                    img_likerandom_ponsel.setEnabled(true);
                    img_dislikerandom_ponsel.setEnabled(true);
                    img_likerandom_ponsel.setBackgroundResource(0x7f02020a);
                    img_dislikerandom_ponsel.setBackgroundResource(0x7f0201f1);
                }
                imgHpRandom.setOnClickListener(new android.view.View.OnClickListener() {

                    final _cls54 this$1;

                    public void onClick(View view)
                    {
                        view = new Intent(getApplicationContext(), com/inponsel/android/details/DetailsPonsel);
                        view.putExtra("id_hph", random_id_hp);
                        view.putExtra("namalengkap", random_merek_hp);
                        view.putExtra("codename", random_codename);
                        view.putExtra("model", "");
                        view.putExtra("merk", "");
                        view.putExtra("gambar", "");
                        view.putExtra("hrg_baru", "");
                        view.putExtra("hrg_bekas", "");
                        view.putExtra("tot_like", "");
                        view.putExtra("tot_dislike", "");
                        view.putExtra("tot_komen", "");
                        startActivityForResult(view, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$1 = _cls54.this;
                super();
            }
                });
                Picasso.with(HomeNewMainActivity.this).load(random_img_url.trim()).tag(this).into(imgHpRandom, new Callback() {

                    final _cls54 this$1;

                    public void onError()
                    {
                        progressbar_hp_random.setVisibility(8);
                    }

                    public void onSuccess()
                    {
                        progressbar_hp_random.setVisibility(8);
                    }

            
            {
                this$1 = _cls54.this;
                super();
            }
                });
                rl_hp_random.setVisibility(0);
                ll_segmen_2.setVisibility(0);
                img_likerandom_ponsel.setEnabled(true);
                img_dislikerandom_ponsel.setEnabled(true);
                (new Handler()).postDelayed(new Runnable() {

                    final _cls54 this$1;

                    public void run()
                    {
                        progressbar_segmen2.setVisibility(8);
                    }

            
            {
                this$1 = _cls54.this;
                super();
            }
                }, 2000L);
                return;
_L2:
                abyte0 = aheader.getJSONObject(i);
                random_id_hp = abyte0.getString("id_hp");
                random_codename = abyte0.getString("codename");
                random_umu_status = abyte0.getString("umu_status");
                random_img_url = abyte0.getString("gambar");
                random_merek_hp = (new StringBuilder(String.valueOf(abyte0.getString("merk")))).append(" ").append(abyte0.getString("model")).toString();
                namalengkapbgskrg = random_merek_hp;
                random_harga_hp = abyte0.getString("hrg_baru");
                random_like = abyte0.getString("my_like_pon");
                random_background = abyte0.getString("background");
                i++;
                  goto _L3
                aheader;
                aheader.printStackTrace();
                  goto _L1
            }


            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
        });
    }

    private void load_segmen_1()
    {
        Log.e("load_segmen", "load_segmen_1");
        if (sPref.equals("Any") || wifiConnected || mobileConnected || sPref.equals("Wi-Fi") || wifiConnected)
        {
            urlRSS = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rss_reader_home").append(Utility.BASE_FORMAT).append("?").append("lmt=").append(limit).append("&t=").append(t).append("&idusr=").append(user_id).append("&tag=").toString();
            Log.e("urlRSS", urlRSS);
            if (pendatangArray.size() == 0)
            {
                PendatangTask();
            }
            sendRequestAds();
            String s;
            if (mArrayListRSSData.size() == 0)
            {
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new RSSAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                } else
                {
                    (new RSSAsycTask()).execute(new String[0]);
                }
            }
            ll_body.setVisibility(0);
            ll_connection.setVisibility(8);
            progressbar_segmen1.setVisibility(8);
            ll_segmen_1.setVisibility(0);
            s = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("home_head_banner").append(Utility.BASE_FORMAT).append("?t=").append(t).append("&id_user=").append(user_id).append("&page=1").toString();
            Log.e("str_head_banner", s);
            (new AsyncHttpClient()).get(s, new AsyncHttpResponseHandler() {

                final HomeNewMainActivity this$0;

                public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
                {
                }

                public void onRetry(int i)
                {
                }

                public void onStart()
                {
                }

                public void onSuccess(int i, Header aheader[], byte abyte0[])
                {
                    aheader = new String(abyte0);
                    Log.e("respJson", aheader);
                    aheader = (new JSONObject(aheader)).getJSONArray("InPonsel");
                    i = 0;
_L3:
                    int j = aheader.length();
                    if (i < j) goto _L2; else goto _L1
_L1:
                    aheader = ((WindowManager)getSystemService("window")).getDefaultDisplay();
                    abyte0 = new DisplayMetrics();
                    aheader.getMetrics(abyte0);
                    i = ((DisplayMetrics) (abyte0)).widthPixels;
                    float f1 = Utility.aspectratio(Integer.parseInt(str_doodle_width), Integer.parseInt(str_doodle_height));
                    float f = (float)Integer.parseInt(str_doodle_width) / f1;
                    f1 = (float)Integer.parseInt(str_doodle_height) / f1;
                    Log.e("ratio", String.valueOf((new StringBuilder(String.valueOf(f))).append(" : ").append(f1).toString()));
                    float f2 = i;
                    if (f > f1)
                    {
                        final_width = f2;
                        final_height = Math.round((f2 * f1) / f);
                        Log.e("ratioFinal", String.valueOf((new StringBuilder(String.valueOf(final_width))).append(" : ").append(final_height).toString()));
                    } else
                    {
                        final_width = Math.round((f2 * f1) / f);
                        final_height = f2;
                        Log.e("ratioFinal", String.valueOf((new StringBuilder(String.valueOf(final_width))).append(" : ").append(final_height).toString()));
                    }
                    img_head_banner.setLayoutParams(new android.widget.RelativeLayout.LayoutParams((int)final_width, (int)final_height));
                    if (str_doodle_title.equals("") && str_doodle_subtitle.equals(""))
                    {
                        rl_campaign_text.setVisibility(8);
                    }
                    txt_doodle_subtitle.setText(str_doodle_subtitle);
                    txt_doodle_title.setText(str_doodle_title);
                    btn_doodle_action.setText(str_doodle_text_action);
                    btn_doodle_action.setOnClickListener(new android.view.View.OnClickListener() {

                        final _cls52 this$1;

                        public void onClick(View view)
                        {
                            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str_doodle_url)));
                        }

            
            {
                this$1 = _cls52.this;
                super();
            }
                    });
                    load_image_doodle();
                    return;
_L2:
                    abyte0 = aheader.getJSONObject(i);
                    str_doodle_action = abyte0.getString("action");
                    str_doodle_img = abyte0.getString("image");
                    str_doodle_subtitle = abyte0.getString("campaign");
                    str_doodle_title = abyte0.getString("title");
                    str_doodle_url = abyte0.getString("url");
                    str_doodle_width = abyte0.getString("width");
                    str_doodle_height = abyte0.getString("height");
                    str_doodle_text_action = abyte0.getString("text_action");
                    i++;
                      goto _L3
                    aheader;
                    aheader.printStackTrace();
                    str_doodle_title = "";
                    str_doodle_subtitle = "";
                      goto _L1
                }


            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
            });
            if (Utility.screen_inch(this) >= 6D)
            {
                scroll_count = scroll_count + 1;
                load_segmen_2();
            }
        }
    }

    private void load_segmen_2()
    {
        Log.e("load_segmen", "load_segmen_2");
        progressbar_segmen2.setVisibility(0);
        (new Handler()).postDelayed(new Runnable() {

            final HomeNewMainActivity this$0;

            public void run()
            {
                if (rilisTerbaruArray.size() == 0)
                {
                    RilisTask();
                }
                load_random_hp();
                if (topHitsArray.size() == 0)
                {
                    TopHitsTask();
                } else
                {
                    progressbar_segmen3.setVisibility(8);
                }
                if (segeraArray.size() == 0)
                {
                    SegeraTask();
                }
            }

            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
        }, 1000L);
    }

    private void load_segmen_3()
    {
        Log.e("load_segmen", "load_segmen_3");
        (new Handler()).postDelayed(new Runnable() {

            final HomeNewMainActivity this$0;

            public void run()
            {
                progressbar_segmen3.setVisibility(0);
                ll_segmen_3.setVisibility(0);
                if (latestBrandArray.size() == 0)
                {
                    LatestBrandTask();
                }
                sendRequestHeadNews();
                if (palingHotArray.size() == 0)
                {
                    PalingHotTask();
                }
            }

            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
        }, 1000L);
        (new Handler()).postDelayed(new Runnable() {

            final HomeNewMainActivity this$0;

            public void run()
            {
                progressbar_segmen3.setVisibility(8);
            }

            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
        }, 3000L);
    }

    private void load_segmen_4()
    {
        Log.e("load_segmen", "load_segmen_4");
        progressbar_segmen4.setVisibility(0);
        (new Handler()).postDelayed(new Runnable() {

            final HomeNewMainActivity this$0;

            public void run()
            {
                progressbar_segmen4.setVisibility(8);
                sendRequestInteraksi();
                txt_home_inponsel.setVisibility(8);
                load_image_menu_bottom();
                ll_segmen_4.setVisibility(0);
            }

            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
        }, 1000L);
    }

    private void sendRequestAds()
    {
        urlAds = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("list_ads_home").append(Utility.BASE_FORMAT).append("?hal=46").append("&pver=").append(SplashScreen.curVersion).append("&t=").append(t).append("&idusr=").append(user_id).append("&tag=tagall").toString();
        Log.e("urlAds", urlAds);
        AsyncHttpClient asynchttpclient = new AsyncHttpClient();
        asynchttpclient.setMaxRetriesAndTimeout(5, 10000);
        asynchttpclient.get(urlAds, new AsyncHttpResponseHandler() {

            final HomeNewMainActivity this$0;

            public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
            {
            }

            public void onRetry(int i)
            {
            }

            public void onStart()
            {
                arrayListAds.clear();
            }

            public void onSuccess(int i, Header aheader[], byte abyte0[])
            {
                aheader = new String(abyte0);
                Log.e("responseHeadNews", aheader);
                aheader = new JSONObject(aheader);
                if (aheader.getBoolean("success")) goto _L2; else goto _L1
_L1:
                rl_slideshow_ads.setVisibility(8);
_L3:
                Log.e("arrayListAds", String.valueOf(arrayListAds.size()));
                if (arrayListAds.size() != 0)
                {
                    view_pager_ads.setAdapter(customPagerAdapter);
                    aheader = ((WindowManager)getSystemService("window")).getDefaultDisplay();
                    abyte0 = new DisplayMetrics();
                    aheader.getMetrics(abyte0);
                    i = ((DisplayMetrics) (abyte0)).widthPixels;
                    float f1 = Utility.aspectratio(Integer.parseInt(str_doodle_width), Integer.parseInt(str_doodle_height));
                    float f = (float)Integer.parseInt(str_doodle_width) / f1;
                    f1 = (float)Integer.parseInt(str_doodle_height) / f1;
                    Log.e("ratio", String.valueOf((new StringBuilder(String.valueOf(f))).append(" : ").append(f1).toString()));
                    float f2 = i;
                    ListModel listmodel;
                    if (f > f1)
                    {
                        final_width = f2;
                        final_height = Math.round((f2 * f1) / f);
                        Log.e("ratioFinal", String.valueOf((new StringBuilder(String.valueOf(final_width))).append(" : ").append(final_height).toString()));
                    } else
                    {
                        final_width = Math.round((f2 * f1) / f);
                        final_height = f2;
                        Log.e("ratioFinal", String.valueOf((new StringBuilder(String.valueOf(final_width))).append(" : ").append(final_height).toString()));
                    }
                    rl_slideshow_ads.setLayoutParams(new android.widget.LinearLayout.LayoutParams((int)final_width, (int)final_height));
                }
                return;
_L2:
                aheader = aheader.getJSONArray("InPonsel");
                i = 0;
_L4:
                try
                {
                    if (i < aheader.length())
                    {
                        break MISSING_BLOCK_LABEL_377;
                    }
                    rl_slideshow_ads.setVisibility(0);
                }
                // Misplaced declaration of an exception variable
                catch (Header aheader[])
                {
                    aheader.printStackTrace();
                }
                  goto _L3
                abyte0 = aheader.getJSONObject(i);
                listmodel = new ListModel();
                listmodel.setId_ads(abyte0.getString("id_ads"));
                listmodel.setAds_title(abyte0.getString("ads_title"));
                listmodel.setAds_campaign(abyte0.getString("ads_campaign"));
                listmodel.setAds_cover(abyte0.getString("ads_image"));
                listmodel.setAds_icon(abyte0.getString("logo_pub"));
                listmodel.setAds_type(abyte0.getString("ads_type"));
                listmodel.setAds_link(abyte0.getString("ads_link"));
                listmodel.setAds_method(abyte0.getString("ads_method"));
                listmodel.setAds_title_color(abyte0.getString("ads_title_color"));
                listmodel.setAds_campaign_color(abyte0.getString("ads_campaign_color"));
                listmodel.setAds_back_color(abyte0.getString("ads_back_color"));
                listmodel.setAds_btn_text_color(abyte0.getString("ads_btn_text_color"));
                listmodel.setAds_btn_text_action(abyte0.getString("ads_btn_text_action"));
                arrayListAds.add(listmodel);
                i++;
                  goto _L4
            }

            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
        });
    }

    private void sendRequestHeadNews()
    {
        urlHeadline = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("home_rss_headline").append(Utility.BASE_FORMAT).append("?lmt=0&t=").append(t).append("&idusr=").append(user_id).append("&tag=tagall").toString();
        Log.e("urlHeadline", urlHeadline);
        AsyncHttpClient asynchttpclient = new AsyncHttpClient();
        asynchttpclient.setMaxRetriesAndTimeout(5, 10000);
        asynchttpclient.get(urlHeadline, new AsyncHttpResponseHandler() {

            final HomeNewMainActivity this$0;

            public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
            {
            }

            public void onRetry(int i)
            {
            }

            public void onStart()
            {
                progressbar_viewpager_head_news.setVisibility(0);
            }

            public void onSuccess(int i, Header aheader[], byte abyte0[])
            {
                isFinish3 = true;
                aheader = new String(abyte0);
                Log.e("responseHeadNews", aheader);
                rl_root_news = (RelativeLayout)findViewById(0x7f0b0263);
                image_news1 = (ImageView)findViewById(0x7f0b0264);
                txt_judul_news = (TextView)findViewById(0x7f0b0265);
                float f;
                float f1;
                float f2;
                try
                {
                    aheader = (new JSONObject(aheader)).getJSONArray("InPonsel").getJSONObject(0);
                    id_news1 = aheader.getString("rss_id");
                    title_news1 = aheader.getString("rss_title");
                    img_urlnews1 = aheader.getString("rss_img");
                }
                // Misplaced declaration of an exception variable
                catch (Header aheader[])
                {
                    aheader.printStackTrace();
                }
                progressbar_viewpager_head_news.setVisibility(0);
                aheader = ((WindowManager)getSystemService("window")).getDefaultDisplay();
                abyte0 = new DisplayMetrics();
                aheader.getMetrics(abyte0);
                i = ((DisplayMetrics) (abyte0)).widthPixels;
                f1 = Utility.aspectratio(Integer.parseInt(str_doodle_width), Integer.parseInt(str_doodle_height));
                f = (float)Integer.parseInt(str_doodle_width) / f1;
                f1 = (float)Integer.parseInt(str_doodle_height) / f1;
                Log.e("ratio", String.valueOf((new StringBuilder(String.valueOf(f))).append(" : ").append(f1).toString()));
                f2 = i;
                if (f > f1)
                {
                    final_width = f2;
                    final_height = Math.round((f2 * f1) / f);
                    Log.e("ratioFinal", String.valueOf((new StringBuilder(String.valueOf(final_width))).append(" : ").append(final_height).toString()));
                } else
                {
                    final_width = Math.round((f2 * f1) / f);
                    final_height = f2;
                    Log.e("ratioFinal", String.valueOf((new StringBuilder(String.valueOf(final_width))).append(" : ").append(final_height).toString()));
                }
                image_news1.setLayoutParams(new android.widget.RelativeLayout.LayoutParams((int)final_width, (int)final_height));
                rl_root_news.setLayoutParams(new android.widget.RelativeLayout.LayoutParams((int)final_width, (int)final_height));
                txt_judul_news.setText(title_news1);
                Picasso.with(HomeNewMainActivity.this).load(img_urlnews1).into(image_news1, new Callback() {

                    final _cls59 this$1;

                    public void onError()
                    {
                        image_news1.setImageResource(0x7f020209);
                    }

                    public void onSuccess()
                    {
                        progressbar_viewpager_head_news.setVisibility(8);
                    }

            
            {
                this$1 = _cls59.this;
                super();
            }
                });
                image_news1.setOnClickListener(new android.view.View.OnClickListener() {

                    final _cls59 this$1;

                    public void onClick(View view)
                    {
                        Log.e("judul", String.valueOf(id_news1));
                        view = new Intent();
                        view.setClass(_fld0, com/inponsel/android/rssfeeddetail/RSSDetailTab);
                        view.putExtra("id_rss", id_news1);
                        view.putExtra("rss_title", title_news1);
                        view.putExtra("notif", "gcm");
                        view.putExtra("actfrom", "rssfeed");
                        view.putExtra("act", "firsttab");
                        startActivityForResult(view, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$1 = _cls59.this;
                super();
            }
                });
            }


            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
        });
    }

    private void sendRequestInteraksi()
    {
        urlInteraksiHp = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("home_interaksi").append(Utility.BASE_FORMAT).append("?lmt=").append(limit).append("&t=").append(t).append("&idusr=").append(str_id_user).toString();
        Log.e("urlInteraksiHp", urlInteraksiHp);
        AsyncHttpClient asynchttpclient = new AsyncHttpClient();
        asynchttpclient.setMaxRetriesAndTimeout(5, 10000);
        asynchttpclient.get(urlInteraksiHp, new AsyncHttpResponseHandler() {

            final HomeNewMainActivity this$0;

            public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
            {
            }

            public void onRetry(int i)
            {
            }

            public void onStart()
            {
            }

            public void onSuccess(int i, Header aheader[], byte abyte0[])
            {
                aheader = new String(abyte0);
                Log.e("responseHeadNews", aheader);
                abyte0 = new JSONObject(aheader);
                aheader = abyte0.getJSONArray("InPonsel");
                background_interaksi = abyte0.getString("background");
                i = 0;
_L3:
                int j = aheader.length();
                if (i < j) goto _L2; else goto _L1
_L1:
                Log.e("arrayListInteraksi", String.valueOf(arrayListInteraksi.size()));
                customInteraksiPagerAdapter.notifyDataSetChanged();
                rl_slideshow_interaksi.setBackgroundColor(Color.parseColor(background_interaksi));
                return;
_L2:
                abyte0 = aheader.getJSONObject(i);
                ListModel listmodel = new ListModel();
                listmodel.setId_komentar(abyte0.getString("id_komentar"));
                listmodel.setId_hp(abyte0.getString("id_hp"));
                listmodel.setCodename(abyte0.getString("codename"));
                listmodel.setNamalengkap(abyte0.getString("namalengkap"));
                listmodel.setMerk(abyte0.getString("merk"));
                listmodel.setModel(abyte0.getString("model"));
                listmodel.setNama_komentar(abyte0.getString("nama_komentar"));
                listmodel.setKomentarhp(abyte0.getString("komentarhp"));
                listmodel.setTanggal_komentar(abyte0.getString("tanggal_komentar"));
                listmodel.setAvatar(abyte0.getString("usr_pict_komen"));
                arrayListInteraksi.add(listmodel);
                i++;
                  goto _L3
                aheader;
                aheader.printStackTrace();
                  goto _L1
            }

            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
        });
    }

    private void sendRequestTipsNews()
    {
        urlTipsNews = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rss_random").append(Utility.BASE_FORMAT).append("?lmt=0&t=").append(t).append("&idusr=").append(user_id).append("&tag=tips-trik").toString();
        Log.e("urlTipsNews", urlTipsNews);
        AsyncHttpClient asynchttpclient = new AsyncHttpClient();
        asynchttpclient.setMaxRetriesAndTimeout(5, 10000);
        asynchttpclient.get(urlTipsNews, new AsyncHttpResponseHandler() {

            final HomeNewMainActivity this$0;

            public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
            {
            }

            public void onRetry(int i)
            {
            }

            public void onStart()
            {
                progressbar_viewpager_tips_news.setVisibility(0);
            }

            public void onSuccess(int i, Header aheader[], byte abyte0[])
            {
                aheader = new String(abyte0);
                Log.e("responseHeadNews", aheader);
                rl_root_news2 = (RelativeLayout)findViewById(0x7f0b026a);
                image_news2 = (ImageView)findViewById(0x7f0b026b);
                txt_judul_news2 = (TextView)findViewById(0x7f0b026c);
                aheader = new JSONObject(aheader);
                if (!aheader.getString("bottom_id").equals("0") || !aheader.getString("top_id").equals("0")) goto _L2; else goto _L1
_L1:
                rl_slideshow_tips_news.setVisibility(8);
_L3:
                isFinish3 = true;
                return;
_L2:
                float f;
                float f1;
                aheader = aheader.getJSONArray("InPonsel");
                rl_slideshow_tips_news.setVisibility(0);
                aheader = aheader.getJSONObject(0);
                id_news2 = aheader.getString("rss_id");
                title_news2 = aheader.getString("rss_title");
                img_urlnews2 = aheader.getString("rss_img");
                progressbar_viewpager_tips_news.setVisibility(8);
                aheader = ((WindowManager)getSystemService("window")).getDefaultDisplay();
                abyte0 = new DisplayMetrics();
                aheader.getMetrics(abyte0);
                i = ((DisplayMetrics) (abyte0)).widthPixels;
                f1 = Utility.aspectratio(Integer.parseInt(str_doodle_width), Integer.parseInt(str_doodle_height));
                f = (float)Integer.parseInt(str_doodle_width) / f1;
                f1 = (float)Integer.parseInt(str_doodle_height) / f1;
                Log.e("ratio", String.valueOf((new StringBuilder(String.valueOf(f))).append(" : ").append(f1).toString()));
                float f2;
                f2 = i;
                if (f <= f1)
                {
                    break MISSING_BLOCK_LABEL_563;
                }
                final_width = f2;
                final_height = Math.round((f2 * f1) / f);
                Log.e("ratioFinal", String.valueOf((new StringBuilder(String.valueOf(final_width))).append(" : ").append(final_height).toString()));
_L4:
                image_news2.setLayoutParams(new android.widget.RelativeLayout.LayoutParams((int)final_width, (int)final_height));
                rl_root_news2.setLayoutParams(new android.widget.RelativeLayout.LayoutParams((int)final_width, (int)final_height));
                txt_judul_news2.setText(title_news2);
                Picasso.with(HomeNewMainActivity.this).load(img_urlnews2).into(image_news2, new Callback() {

                    final _cls60 this$1;

                    public void onError()
                    {
                        image_news2.setImageResource(0x7f020209);
                    }

                    public void onSuccess()
                    {
                    }

            
            {
                this$1 = _cls60.this;
                super();
            }
                });
                image_news2.setOnClickListener(new android.view.View.OnClickListener() {

                    final _cls60 this$1;

                    public void onClick(View view)
                    {
                        Log.e("judul", String.valueOf(id_news2));
                        view = new Intent();
                        view.setClass(_fld0, com/inponsel/android/rssfeeddetail/RSSDetailTab);
                        view.putExtra("id_rss", id_news2);
                        view.putExtra("rss_title", title_news2);
                        view.putExtra("notif", "gcm");
                        view.putExtra("actfrom", "rssfeed");
                        view.putExtra("act", "firsttab");
                        startActivityForResult(view, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$1 = _cls60.this;
                super();
            }
                });
                  goto _L3
                aheader;
                aheader.printStackTrace();
                  goto _L3
                final_width = Math.round((f2 * f1) / f);
                final_height = f2;
                Log.e("ratioFinal", String.valueOf((new StringBuilder(String.valueOf(final_width))).append(" : ").append(final_height).toString()));
                  goto _L4
            }


            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
        });
    }

    private void set_menu_apps()
    {
        Object obj = ((WindowManager)getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((Display) (obj)).getMetrics(displaymetrics);
        int i = displaymetrics.widthPixels;
        float f = Utility.aspectratio(300, 98);
        float f2 = (float)300 / f;
        float f3 = (float)98 / f;
        Log.e("ratio", String.valueOf((new StringBuilder(String.valueOf(f2))).append(" : ").append(f3).toString()));
        f = i;
        float f1;
        if (f2 > f3)
        {
            f1 = f;
            f = Math.round((f * f3) / f2);
            Log.e("ratioFinal", String.valueOf((new StringBuilder(String.valueOf(f1))).append(" : ").append(f).toString()));
        } else
        {
            f1 = Math.round((f * f3) / f2);
            Log.e("ratioFinal", String.valueOf((new StringBuilder(String.valueOf(f1))).append(" : ").append(f).toString()));
        }
        ll_home_aplikasi.setLayoutParams(new android.widget.LinearLayout.LayoutParams((int)((float)((int)f1 / 2) - Utility.convertDpToPixel(7.5F, this)), (int)((float)((int)f / 2) - Utility.convertDpToPixel(5F, this))));
        ll_home_games.setLayoutParams(new android.widget.LinearLayout.LayoutParams((int)((float)((int)f1 / 2) - Utility.convertDpToPixel(7.5F, this)), (int)((float)((int)f / 2) - Utility.convertDpToPixel(5F, this))));
        obj = new android.view.ViewGroup.MarginLayoutParams(ll_home_games.getLayoutParams());
        ((android.view.ViewGroup.MarginLayoutParams) (obj)).setMargins((int)Utility.convertDpToPixel(5F, this), 0, 0, 0);
        ll_home_games.setLayoutParams(new android.widget.LinearLayout.LayoutParams(((android.view.ViewGroup.MarginLayoutParams) (obj))));
        ll_home_aplikasi.setBackgroundResource(0x7f020270);
        ll_home_games.setBackgroundResource(0x7f020271);
    }

    private void showErrorPage()
    {
        Log.e("networkStateReceiver", "false");
        ll_connection.setVisibility(0);
        ll_body.setVisibility(4);
        ll_segmen_1.setVisibility(4);
        ll_segmen_2.setVisibility(4);
        ll_segmen_3.setVisibility(4);
        ll_segmen_4.setVisibility(4);
        progressbar_segmen2.setVisibility(8);
        progressbar_segmen3.setVisibility(8);
        progressbar_segmen4.setVisibility(8);
        txt_connection.setText("Tidak ada koneksi internet");
        txt_connection.setVisibility(0);
        progressbar_connection.setVisibility(8);
        btnRefreshconnection.setVisibility(0);
        ll_menu_banner.setVisibility(8);
        btnRefreshconnection.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewMainActivity this$0;

            public void onClick(View view)
            {
                scroll_count = 1;
                view = ((ConnectivityManager)getSystemService("connectivity")).getActiveNetworkInfo();
                if (view != null && view.isConnected())
                {
                    txt_connection.setVisibility(8);
                    btnRefreshconnection.setVisibility(8);
                    progressbar_connection.setVisibility(8);
                    progressbar_segmen2.setVisibility(8);
                    progressbar_segmen3.setVisibility(8);
                    progressbar_segmen4.setVisibility(8);
                    ll_connection.setVisibility(8);
                    load_segmen_1();
                }
            }

            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
        });
    }

    private void updateConnectedFlags()
    {
        boolean flag1 = true;
        NetworkInfo networkinfo = ((ConnectivityManager)getSystemService("connectivity")).getActiveNetworkInfo();
        if (networkinfo != null && networkinfo.isConnected())
        {
            boolean flag;
            if (networkinfo.getType() == 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            wifiConnected = flag;
            if (networkinfo.getType() == 0)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            mobileConnected = flag;
            return;
        } else
        {
            wifiConnected = false;
            mobileConnected = false;
            return;
        }
    }

    public void LatestBrandTask()
    {
        LatestBrandTask latestbrandtask = new LatestBrandTask(null);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            latestbrandtask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            latestbrandtask.execute(new Void[0]);
            return;
        }
    }

    public void PalingHotTask()
    {
        PalingHotTask palinghottask = new PalingHotTask(null);
        dataPalingHot = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("gadget_most_comment").append(Utility.BASE_FORMAT).append("?idusr=").append(user_id).append("&lmt=0&t=").append(t).toString();
        Log.e("dataPalingHot", dataPalingHot);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            palinghottask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            palinghottask.execute(new Void[0]);
            return;
        }
    }

    public void PendatangTask()
    {
        dataPendatang = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("home_penbaru").append(Utility.BASE_FORMAT).append("?idusr=").append(user_id).append("&lmt=0&t=").append(t).toString();
        Log.e("dataPendatang", dataPendatang);
        PendatangTask pendatangtask = new PendatangTask(null);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            pendatangtask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            pendatangtask.execute(new Void[0]);
            return;
        }
    }

    public void RilisTask()
    {
        dataRilis = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("home_rilis").append(Utility.BASE_FORMAT).append("?idusr=").append(user_id).append("&lmt=0&t=").append(t).toString();
        RilisTask rilistask = new RilisTask(null);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            rilistask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            rilistask.execute(new Void[0]);
            return;
        }
    }

    public void SegeraTask()
    {
        SegeraTask segeratask = new SegeraTask(null);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            segeratask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            segeratask.execute(new Void[0]);
            return;
        }
    }

    public void TopHitsTask()
    {
        dataTopHits = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("home_top_hits").append(Utility.BASE_FORMAT).append("?idusr=").append(user_id).append("&lmt=0&t=").append(t).toString();
        TopHitsTask tophitstask = new TopHitsTask(null);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            tophitstask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            tophitstask.execute(new Void[0]);
            return;
        }
    }

    public void endScroll()
    {
        if (scroll_count != 2) goto _L2; else goto _L1
_L1:
        load_segmen_2();
        scroll_count = scroll_count + 1;
_L4:
        return;
_L2:
        if (scroll_count != 3)
        {
            continue; /* Loop/switch isn't completed */
        }
        Log.e("isFinish2", String.valueOf(isFinish2));
        if (isFinish2)
        {
            Log.e("load_segmen", "load_segmen_3");
            progressbar_segmen3.setVisibility(0);
            load_segmen_3();
            scroll_count = scroll_count + 1;
            return;
        }
        continue; /* Loop/switch isn't completed */
        if (scroll_count != 4) goto _L4; else goto _L3
_L3:
        Log.e("isFinish3", String.valueOf(isFinish3));
        if (isFinish3)
        {
            progressbar_segmen4.setVisibility(0);
            load_segmen_4();
            scroll_count = scroll_count + 1;
            return;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public String getJSONUrl(String s)
    {
        StringBuilder stringbuilder;
        Object obj;
        BasicHttpContext basichttpcontext;
        stringbuilder = new StringBuilder();
        obj = new DefaultHttpClient();
        basichttpcontext = new BasicHttpContext();
        basichttpcontext.setAttribute("http.useragent", (new StringBuilder("InPonsel Android ")).append(SplashScreen.curVersion).toString());
        s = new HttpGet(s);
        s = ((HttpClient) (obj)).execute(s, basichttpcontext);
        if (s.getStatusLine().getStatusCode() != 200)
        {
            break MISSING_BLOCK_LABEL_147;
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

    public boolean isLoggedIn()
    {
        return AccessToken.getCurrentAccessToken() != null;
    }

    public void load_image_menu_bottom()
    {
        String s = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("list_menu_home_bottom").append(Utility.BASE_FORMAT).append("?t=").append(t).toString();
        Log.e("load_image_menu_bottom", s);
        (new AsyncHttpClient()).get(s, new AsyncHttpResponseHandler() {

            final HomeNewMainActivity this$0;

            public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
            {
            }

            public void onRetry(int i)
            {
            }

            public void onStart()
            {
            }

            public void onSuccess(int i, Header aheader[], byte abyte0[])
            {
                aheader = new String(abyte0);
                Log.e("respJson", aheader);
                aheader = (new JSONObject(aheader)).getJSONArray("InPonsel");
                Log.e("jsonArray.length()", String.valueOf(aheader.length()));
                i = 0;
_L3:
                int j = aheader.length();
                if (i < j)
                {
                    break MISSING_BLOCK_LABEL_801;
                }
_L1:
                aheader = ((WindowManager)getSystemService("window")).getDefaultDisplay();
                abyte0 = new DisplayMetrics();
                aheader.getMetrics(abyte0);
                i = ((DisplayMetrics) (abyte0)).widthPixels;
                float f = Utility.aspectratio(600, 314);
                float f2 = (float)600 / f;
                float f3 = (float)314 / f;
                Log.e("ratio", String.valueOf((new StringBuilder(String.valueOf(f2))).append(" : ").append(f3).toString()));
                f = i;
                float f1;
                if (f2 > f3)
                {
                    f1 = f;
                    f = Math.round((f * f3) / f2);
                    Log.e("ratioFinal", String.valueOf((new StringBuilder(String.valueOf(f1))).append(" : ").append(f).toString()));
                } else
                {
                    f1 = Math.round((f * f3) / f2);
                    Log.e("ratioFinal", String.valueOf((new StringBuilder(String.valueOf(f1))).append(" : ").append(f).toString()));
                }
                rl_menubottom_conv.setLayoutParams(new android.widget.LinearLayout.LayoutParams((int)f1 / 2, (int)f / 2));
                rl_menubottom_forum.setLayoutParams(new android.widget.LinearLayout.LayoutParams((int)f1 / 2, (int)f / 2));
                rl_menubottom_hprumor.setLayoutParams(new android.widget.LinearLayout.LayoutParams((int)f1 / 2, (int)f / 2));
                rl_menubottom_panduanbel.setLayoutParams(new android.widget.LinearLayout.LayoutParams((int)f1 / 2, (int)f / 2));
                rl_menubottom_pencrinci.setLayoutParams(new android.widget.LinearLayout.LayoutParams((int)f1 / 2, (int)f / 2));
                rl_menubottom_rekomendasi.setLayoutParams(new android.widget.LinearLayout.LayoutParams((int)f1 / 2, (int)f / 2));
                img_menubottom_conv.setLayoutParams(new android.widget.RelativeLayout.LayoutParams((int)f1 / 2, (int)f / 2));
                img_menubottom_forum.setLayoutParams(new android.widget.RelativeLayout.LayoutParams((int)f1 / 2, (int)f / 2));
                img_menubottom_hprumor.setLayoutParams(new android.widget.RelativeLayout.LayoutParams((int)f1 / 2, (int)f / 2));
                img_menubottom_panduanbel.setLayoutParams(new android.widget.RelativeLayout.LayoutParams((int)f1 / 2, (int)f / 2));
                img_menubottom_pencrinci.setLayoutParams(new android.widget.RelativeLayout.LayoutParams((int)f1 / 2, (int)f / 2));
                img_menubottom_rekomendasi.setLayoutParams(new android.widget.RelativeLayout.LayoutParams((int)f1 / 2, (int)f / 2));
                Picasso.with(HomeNewMainActivity.this).load(menu_img_conv).into(img_menubottom_conv, new Callback() {

                    final _cls68 this$1;

                    public void onError()
                    {
                        txt_menubottom_conv.setVisibility(0);
                    }

                    public void onSuccess()
                    {
                        txt_menubottom_conv.setVisibility(8);
                    }

            
            {
                this$1 = _cls68.this;
                super();
            }
                });
                Log.e("menu_img_forum", menu_img_forum);
                Picasso.with(HomeNewMainActivity.this).load(menu_img_forum).into(img_menubottom_forum, new Callback() {

                    final _cls68 this$1;

                    public void onError()
                    {
                        txt_menubottom_forum.setVisibility(0);
                    }

                    public void onSuccess()
                    {
                        txt_menubottom_forum.setVisibility(8);
                    }

            
            {
                this$1 = _cls68.this;
                super();
            }
                });
                Log.e("menu_img_hprumor", menu_img_hprumor);
                Picasso.with(HomeNewMainActivity.this).load(menu_img_hprumor).into(img_menubottom_hprumor, new Callback() {

                    final _cls68 this$1;

                    public void onError()
                    {
                        txt_menubottom_rumor.setVisibility(0);
                    }

                    public void onSuccess()
                    {
                        txt_menubottom_rumor.setVisibility(8);
                    }

            
            {
                this$1 = _cls68.this;
                super();
            }
                });
                Log.e("menu_img_panduanbelanja", menu_img_panduanbelanja);
                Picasso.with(HomeNewMainActivity.this).load(menu_img_panduanbelanja).into(img_menubottom_panduanbel, new Callback() {

                    final _cls68 this$1;

                    public void onError()
                    {
                        txt_menubottom_panduanbelanja.setVisibility(0);
                    }

                    public void onSuccess()
                    {
                        txt_menubottom_panduanbelanja.setVisibility(8);
                    }

            
            {
                this$1 = _cls68.this;
                super();
            }
                });
                Log.e("menu_img_pencrinci", menu_img_pencrinci);
                Picasso.with(HomeNewMainActivity.this).load(menu_img_pencrinci).into(img_menubottom_pencrinci, new Callback() {

                    final _cls68 this$1;

                    public void onError()
                    {
                        txt_menubottom_pencrinci.setVisibility(0);
                    }

                    public void onSuccess()
                    {
                        txt_menubottom_pencrinci.setVisibility(8);
                    }

            
            {
                this$1 = _cls68.this;
                super();
            }
                });
                Picasso.with(HomeNewMainActivity.this).load(menu_img_rekomendasi).into(img_menubottom_rekomendasi, new Callback() {

                    final _cls68 this$1;

                    public void onError()
                    {
                        txt_menubottom_rekomendasi.setVisibility(0);
                    }

                    public void onSuccess()
                    {
                        txt_menubottom_rekomendasi.setVisibility(8);
                    }

            
            {
                this$1 = _cls68.this;
                super();
            }
                });
                return;
label0:
                {
                    abyte0 = aheader.getJSONObject(i);
                    if (abyte0.getString("menu_name").contains("Hape Rumor"))
                    {
                        menu_img_hprumor = abyte0.getString("menu_image");
                        break MISSING_BLOCK_LABEL_1056;
                    }
                    try
                    {
                        if (abyte0.getString("menu_name").contains("Conversation"))
                        {
                            menu_img_conv = abyte0.getString("menu_image");
                            break MISSING_BLOCK_LABEL_1056;
                        }
                        break label0;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Header aheader[])
                    {
                        aheader.printStackTrace();
                    }
                }
                  goto _L1
                if (abyte0.getString("menu_name").contains("Forum"))
                {
                    menu_img_forum = abyte0.getString("menu_image");
                    break MISSING_BLOCK_LABEL_1056;
                }
                if (abyte0.getString("menu_name").contains("Panduan Belanja"))
                {
                    menu_img_panduanbelanja = abyte0.getString("menu_image");
                    break MISSING_BLOCK_LABEL_1056;
                }
                if (abyte0.getString("menu_name").contains("Pencarian Rinci"))
                {
                    menu_img_pencrinci = abyte0.getString("menu_image");
                    break MISSING_BLOCK_LABEL_1056;
                }
                if (abyte0.getString("menu_name").contains("Rekomendasi"))
                {
                    menu_img_rekomendasi = abyte0.getString("menu_image");
                }
                i++;
                if (true) goto _L3; else goto _L2
_L2:
            }


            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
        });
    }

    public void onAnimationEnd(Animation animation)
    {
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    public void onBackPressed()
    {
        if (mDrawerLayout.isDrawerOpen(0x800003))
        {
            mDrawerLayout.closeDrawers();
            Log.e("vis", "on");
            return;
        } else
        {
            Log.e("vis", "off");
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            builder.setMessage("Keluar dari InPonsel?");
            builder.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                final HomeNewMainActivity this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    if (userFunctions.isUserLoggedIn(getApplicationContext()))
                    {
                        PushOnlineStat("0");
                    }
                    finish();
                }

            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
            });
            builder.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                final HomeNewMainActivity this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
            });
            builder.show();
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f030145, null, false);
        mDrawerLayout.addView(bundle, 0);
        ponselBaseApp = (PonselBaseApp)getApplication();
        ponselBaseApp.getObserver().addObserver(this);
        actionBar = getSupportActionBar();
        actionBar.setDisplayUseLogoEnabled(useLogo);
        actionBar.setBackgroundDrawable(getResources().getDrawable(0x7f0200e5));
        int j = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        int i = j;
        if (j == 0)
        {
            i = 0x7f0b0037;
        }
        bundle = (TextView)findViewById(i);
        bundle.setSelected(true);
        bundle.setTextColor(Color.parseColor("#FFFFFF"));
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFFFFF'>INPONSEL</font>"));
        prefGCM = getApplicationContext().getSharedPreferences("GCMPref", 0);
        extras = getIntent().getExtras();
        Log.e("inch", (new StringBuilder("screen ")).append(String.valueOf(Utility.screen_inch(this))).toString());
        float f;
        float f1;
        float f2;
        DisplayMetrics displaymetrics;
        try
        {
            gcmTitle = extras.getString("title");
            gcmMessage = extras.getString("message");
            gcmNotiftype = extras.getString("notif");
            Log.e("gcmnot", gcmMessage);
            if (gcmNotiftype.equals("0"))
            {
                bundle = new android.app.AlertDialog.Builder(this);
                bundle.setTitle(gcmTitle);
                bundle.setMessage(gcmMessage);
                bundle.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                    final HomeNewMainActivity this$0;

                    public void onClick(DialogInterface dialoginterface, int k)
                    {
                        dialoginterface.cancel();
                    }

            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
                });
                bundle.show();
            }
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle) { }
        animMove = AnimationUtils.loadAnimation(getApplicationContext(), 0x7f040014);
        animMove2 = AnimationUtils.loadAnimation(getApplicationContext(), 0x7f040015);
        animMove.setAnimationListener(this);
        animMove2.setAnimationListener(this);
        txt_home_inponsel = (TextView)findViewById(0x7f0b0219);
        bundle = Calendar.getInstance();
        txt_home_inponsel.setText((new StringBuilder("InPonsel @ ")).append(bundle.get(1)).toString());
        txt_home_inponsel.setVisibility(8);
        optionsDoodle = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showImageOnLoading(0x7f02033f).showImageForEmptyUri(0x7f020209).cacheInMemory(true).cacheOnDisk(true).considerExifParams(true).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).build();
        circle_progress_doodle = (CircleProgressBar)findViewById(0x7f0b08a1);
        btn_head_banner_refresh = (Button)findViewById(0x7f0b08a0);
        ll_connection = (LinearLayout)findViewById(0x7f0b01f9);
        ll_body = (LinearLayout)findViewById(0x7f0b0913);
        ll_menu_banner = (LinearLayout)findViewById(0x7f0b01fd);
        progressbar_connection = (CircularProgressBar)findViewById(0x7f0b01fa);
        btnRefreshconnection = (Button)findViewById(0x7f0b01fc);
        txt_connection = (TextView)findViewById(0x7f0b01fb);
        pop_txt_empty = (TextView)findViewById(0x7f0b04cf);
        progbar_appsrecomend = (CircularProgressBar)findViewById(0x7f0b0275);
        progressbar_segmen1 = (CircularProgressBar)findViewById(0x7f0b08ab);
        progressbar_segmen2 = (CircularProgressBar)findViewById(0x7f0b08b9);
        progressbar_segmen3 = (CircularProgressBar)findViewById(0x7f0b08d4);
        progressbar_segmen4 = (CircularProgressBar)findViewById(0x7f0b0914);
        progressbar_segmen2.setVisibility(8);
        progressbar_segmen3.setVisibility(8);
        progressbar_segmen4.setVisibility(8);
        home_menu_gadget_pilihan = (LinearLayout)findViewById(0x7f0b022a);
        home_menu_turun_harga = (LinearLayout)findViewById(0x7f0b022e);
        rl_rekomendasi_apps = (RelativeLayout)findViewById(0x7f0b0279);
        rl_slideshow_tips_news = (RelativeLayout)findViewById(0x7f0b0279);
        ll_RekomendApps = (RelativeLayout)findViewById(0x7f0b0272);
        listBerita = (LinearLayout)findViewById(0x7f0b0220);
        mArrayListRSSData = new ArrayList();
        ll_segmen_1 = (LinearLayout)findViewById(0x7f0b021a);
        ll_segmen_2 = (LinearLayout)findViewById(0x7f0b0233);
        ll_segmen_3 = (LinearLayout)findViewById(0x7f0b0250);
        ll_segmen_4 = (LinearLayout)findViewById(0x7f0b0271);
        ll_connection.setVisibility(8);
        ll_body.setVisibility(0);
        ll_segmen_1.setVisibility(8);
        ll_segmen_2.setVisibility(8);
        ll_segmen_3.setVisibility(8);
        ll_segmen_4.setVisibility(8);
        bundle = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        receiver = new NetworkReceiver();
        registerReceiver(receiver, bundle);
        sv_root = (ParallaxScrollView)findViewById(0x7f0b089e);
        sv_root.setScrollViewListener(this);
        ll_home_inbox = (LinearLayout)findViewById(0x7f0b01fe);
        ll_home_chatroom = (LinearLayout)findViewById(0x7f0b0200);
        ll_home_forum = (LinearLayout)findViewById(0x7f0b00f5);
        ll_home_setting = (LinearLayout)findViewById(0x7f0b0202);
        ll_home_news = (LinearLayout)findViewById(0x7f0b00f4);
        ll_home_gadget = (LinearLayout)findViewById(0x7f0b00f2);
        ll_home_aplikasi = (LinearLayout)findViewById(0x7f0b0205);
        ll_home_games = (LinearLayout)findViewById(0x7f0b0206);
        ll_home_sc = (LinearLayout)findViewById(0x7f0b0203);
        ll_home_turunharga = (LinearLayout)findViewById(0x7f0b0204);
        txtUnreadCountMenu = (TextView)findViewById(0x7f0b01ff);
        txtUnreadCountgroupchat = (TextView)findViewById(0x7f0b0201);
        txt_user_name_1 = (TextView)findViewById(0x7f0b0912);
        txt_user_ponsel_1 = (TextView)findViewById(0x7f0b02e9);
        txt_user_ponsel_1.setSelected(true);
        txt_user_ponseldesc_1 = (TextView)findViewById(0x7f0b02ea);
        home_menu_user_ponsel = (RelativeLayout)findViewById(0x7f0b02e6);
        home_menu_Conversation = (RelativeLayout)findViewById(0x7f0b0298);
        img_user_ponsel = (CircleImageView)findViewById(0x7f0b02e7);
        listPendatang = (GridView)findViewById(0x7f0b0226);
        layout_pendatang = (LinearLayout)findViewById(0x7f0b0221);
        btnMorePendatang = (RelativeLayout)findViewById(0x7f0b0222);
        progressbar_pendatang = (CircularProgressBar)findViewById(0x7f0b0224);
        txtBigPENDATANGBARU = (TextView)findViewById(0x7f0b0223);
        txtMorePendatang = (TextView)findViewById(0x7f0b0225);
        pendatangArray = new ArrayList();
        pendatangAdapter = new ListPendatangAdapter(this, 0x7f03013b, pendatangArray);
        listPendatang.setAdapter(pendatangAdapter);
        listRilis = (GridView)findViewById(0x7f0b0239);
        layout_rilis = (LinearLayout)findViewById(0x7f0b0234);
        btnMoreRilis = (RelativeLayout)findViewById(0x7f0b0235);
        progressbar_rilis = (CircularProgressBar)findViewById(0x7f0b0237);
        txtBigRILISTERBARU = (TextView)findViewById(0x7f0b0236);
        txtBigLatestNewsBARU = (TextView)findViewById(0x7f0b021d);
        txtMoreRilis = (TextView)findViewById(0x7f0b0238);
        rilisTerbaruArray = new ArrayList();
        rilisTerbaruAdapter = new ListRilisTerbaruAdapter(this, 0x7f03013b, rilisTerbaruArray);
        listRilis.setAdapter(rilisTerbaruAdapter);
        listTopHits = (GridView)findViewById(0x7f0b0249);
        layout_TopHits = (LinearLayout)findViewById(0x7f0b0244);
        btnMoreTopHits = (RelativeLayout)findViewById(0x7f0b0245);
        progressbar_TopHits = (CircularProgressBar)findViewById(0x7f0b0247);
        txtBigTopHitsBARU = (TextView)findViewById(0x7f0b0246);
        txtMoreTopHits = (TextView)findViewById(0x7f0b0248);
        txtMoreInteraksi = (TextView)findViewById(0x7f0b0297);
        txtMoreTopRecomended = (TextView)findViewById(0x7f0b0276);
        rl_head_banner = (RelativeLayout)findViewById(0x7f0b089f);
        rl_campaign_text = (RelativeLayout)findViewById(0x7f0b08a2);
        img_head_banner = (ImageView)findViewById(0x7f0b04ca);
        txt_doodle_title = (TextView)findViewById(0x7f0b08a4);
        txt_doodle_subtitle = (TextView)findViewById(0x7f0b08a5);
        btn_doodle_action = (Button)findViewById(0x7f0b08a3);
        bundle = ((WindowManager)getSystemService("window")).getDefaultDisplay();
        displaymetrics = new DisplayMetrics();
        bundle.getMetrics(displaymetrics);
        i = displaymetrics.widthPixels;
        f1 = Utility.aspectratio(Integer.parseInt(str_doodle_width), Integer.parseInt(str_doodle_height));
        f = (float)Integer.parseInt(str_doodle_width) / f1;
        f1 = (float)Integer.parseInt(str_doodle_height) / f1;
        Log.e("ratio", String.valueOf((new StringBuilder(String.valueOf(f))).append(" : ").append(f1).toString()));
        f2 = i;
        if (f > f1)
        {
            final_width = f2;
            final_height = Math.round((f2 * f1) / f);
            Log.e("ratioFinal", String.valueOf((new StringBuilder(String.valueOf(final_width))).append(" : ").append(final_height).toString()));
        } else
        {
            final_width = Math.round((f2 * f1) / f);
            final_height = f2;
            Log.e("ratioFinal", String.valueOf((new StringBuilder(String.valueOf(final_width))).append(" : ").append(final_height).toString()));
        }
        rl_head_banner.setLayoutParams(new android.widget.FrameLayout.LayoutParams((int)final_width, (int)final_height));
        img_head_banner.setLayoutParams(new android.widget.RelativeLayout.LayoutParams((int)final_width, (int)final_height));
        topHitsArray = new ArrayList();
        topHitsAdapter = new ListTopHitsAdapter(this, 0x7f03013c, topHitsArray);
        listTopHits.setAdapter(topHitsAdapter);
        listSegera = (GridView)findViewById(0x7f0b024f);
        listSegera.setOnScrollListener(new SampleScrollListener(this));
        btnMoreSegera = (RelativeLayout)findViewById(0x7f0b024b);
        progressbar_segera = (ProgressBar)findViewById(0x7f0b024d);
        txtMoreSegera = (TextView)findViewById(0x7f0b024e);
        layout_segera = (LinearLayout)findViewById(0x7f0b024a);
        layout_segera.setVisibility(8);
        segeraArray = new ArrayList();
        segeraAdapter = new ListSegeraAdapter(this, 0x7f030117, segeraArray);
        listSegera.setAdapter(segeraAdapter);
        listSegera.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final HomeNewMainActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int k, long l)
            {
                listPendatang.playSoundEffect(0);
                id_hph = segeraAdapter.getListModel(k).getId_hp().toString();
                model = segeraAdapter.getListModel(k).getModel().toString();
                merk = segeraAdapter.getListModel(k).getMerk().toString();
                gambar = segeraAdapter.getListModel(k).getGambar().toString();
                namalengkap = (new StringBuilder(String.valueOf(merk))).append(" ").append(model).toString();
                tot_like = segeraAdapter.getListModel(k).getTotal_like().toString();
                tot_dislike = segeraAdapter.getListModel(k).getTotal_dislike().toString();
                tot_komen = segeraAdapter.getListModel(k).getTotal_kom().toString();
                hrg_baru = segeraAdapter.getListModel(k).getHrg_baru().toString();
                hrg_bekas = segeraAdapter.getListModel(k).getHrg_bekas().toString();
                codename = segeraAdapter.getListModel(k).getCodename().toString();
                adapterview = new Intent(getApplicationContext(), com/inponsel/android/details/DetailsPonsel);
                adapterview.putExtra("id_hph", id_hph);
                adapterview.putExtra("namalengkap", namalengkap);
                adapterview.putExtra("codename", codename);
                adapterview.putExtra("model", model);
                adapterview.putExtra("merk", merk);
                adapterview.putExtra("gambar", gambar);
                adapterview.putExtra("hrg_baru", hrg_baru);
                adapterview.putExtra("hrg_bekas", hrg_bekas);
                adapterview.putExtra("tot_like", tot_like);
                adapterview.putExtra("tot_dislike", tot_dislike);
                adapterview.putExtra("tot_komen", tot_komen);
                startActivityForResult(adapterview, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
        });
        listTerbaruBrand = (GridView)findViewById(0x7f0b0257);
        txtBigTerbaruBrand = (TextView)findViewById(0x7f0b0253);
        txtMoreTerbaruBrand = (TextView)findViewById(0x7f0b0255);
        rl_gadget_merk = (RelativeLayout)findViewById(0x7f0b0258);
        img_brand = (ImageView)findViewById(0x7f0b0256);
        layout_TerbaruBrand = (LinearLayout)findViewById(0x7f0b0251);
        layout_TerbaruBrand.setVisibility(8);
        latestBrandArray = new ArrayList();
        latestBrandAdapter = new ListSegeraAdapter(this, 0x7f030117, latestBrandArray);
        listTerbaruBrand.setAdapter(latestBrandAdapter);
        listTerbaruBrand.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final HomeNewMainActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int k, long l)
            {
                listTerbaruBrand.playSoundEffect(0);
                id_hph = latestBrandAdapter.getListModel(k).getId_hp().toString();
                model = latestBrandAdapter.getListModel(k).getModel().toString();
                merk = latestBrandAdapter.getListModel(k).getMerk().toString();
                gambar = latestBrandAdapter.getListModel(k).getGambar().toString();
                tot_like = latestBrandAdapter.getListModel(k).getTotal_like().toString();
                tot_dislike = latestBrandAdapter.getListModel(k).getTotal_dislike().toString();
                tot_komen = latestBrandAdapter.getListModel(k).getTotal_kom().toString();
                hrg_baru = latestBrandAdapter.getListModel(k).getHrg_baru().toString();
                hrg_bekas = latestBrandAdapter.getListModel(k).getHrg_bekas().toString();
                codename = latestBrandAdapter.getListModel(k).getCodename().toString();
                namalengkap = (new StringBuilder(String.valueOf(merk))).append(" ").append(model).toString();
                adapterview = new Intent(getApplicationContext(), com/inponsel/android/details/DetailsPonsel);
                adapterview.putExtra("id_hph", id_hph);
                adapterview.putExtra("namalengkap", namalengkap);
                adapterview.putExtra("codename", codename);
                adapterview.putExtra("model", model);
                adapterview.putExtra("merk", merk);
                adapterview.putExtra("gambar", gambar);
                adapterview.putExtra("hrg_baru", hrg_baru);
                adapterview.putExtra("hrg_bekas", hrg_bekas);
                adapterview.putExtra("tot_like", tot_like);
                adapterview.putExtra("tot_dislike", tot_dislike);
                adapterview.putExtra("tot_komen", tot_komen);
                startActivityForResult(adapterview, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
        });
        listPalingHot = (GridView)findViewById(0x7f0b0260);
        txtMorePalingHot = (TextView)findViewById(0x7f0b025f);
        palingHotArray = new ArrayList();
        palingHotAdapter = new ListSegeraAdapter(this, 0x7f030117, palingHotArray);
        listPalingHot.setAdapter(palingHotAdapter);
        listPalingHot.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final HomeNewMainActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int k, long l)
            {
                listPalingHot.playSoundEffect(0);
                id_hph = palingHotAdapter.getListModel(k).getId_hp().toString();
                model = palingHotAdapter.getListModel(k).getModel().toString();
                merk = palingHotAdapter.getListModel(k).getMerk().toString();
                gambar = palingHotAdapter.getListModel(k).getGambar().toString();
                tot_like = palingHotAdapter.getListModel(k).getTotal_like().toString();
                tot_dislike = palingHotAdapter.getListModel(k).getTotal_dislike().toString();
                tot_komen = palingHotAdapter.getListModel(k).getTotal_kom().toString();
                hrg_baru = palingHotAdapter.getListModel(k).getHrg_baru().toString();
                hrg_bekas = palingHotAdapter.getListModel(k).getHrg_bekas().toString();
                codename = palingHotAdapter.getListModel(k).getCodename().toString();
                namalengkap = (new StringBuilder(String.valueOf(merk))).append(" ").append(model).toString();
                adapterview = new Intent(getApplicationContext(), com/inponsel/android/details/DetailsPonsel);
                adapterview.putExtra("id_hph", id_hph);
                adapterview.putExtra("namalengkap", namalengkap);
                adapterview.putExtra("codename", codename);
                adapterview.putExtra("model", model);
                adapterview.putExtra("merk", merk);
                adapterview.putExtra("gambar", gambar);
                adapterview.putExtra("hrg_baru", hrg_baru);
                adapterview.putExtra("hrg_bekas", hrg_bekas);
                adapterview.putExtra("tot_like", tot_like);
                adapterview.putExtra("tot_dislike", tot_dislike);
                adapterview.putExtra("tot_komen", tot_komen);
                startActivityForResult(adapterview, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
        });
        rl_menubottom_hprumor = (RelativeLayout)findViewById(0x7f0b0207);
        rl_menubottom_rekomendasi = (RelativeLayout)findViewById(0x7f0b020a);
        rl_menubottom_panduanbel = (RelativeLayout)findViewById(0x7f0b020d);
        rl_menubottom_pencrinci = (RelativeLayout)findViewById(0x7f0b0210);
        rl_menubottom_forum = (RelativeLayout)findViewById(0x7f0b0213);
        rl_menubottom_conv = (RelativeLayout)findViewById(0x7f0b0216);
        img_menubottom_hprumor = (ImageView)findViewById(0x7f0b0208);
        img_menubottom_rekomendasi = (ImageView)findViewById(0x7f0b020b);
        img_menubottom_panduanbel = (ImageView)findViewById(0x7f0b020e);
        img_menubottom_pencrinci = (ImageView)findViewById(0x7f0b0211);
        img_menubottom_forum = (ImageView)findViewById(0x7f0b0214);
        img_menubottom_conv = (ImageView)findViewById(0x7f0b0217);
        txt_menubottom_rumor = (TextView)findViewById(0x7f0b0209);
        txt_menubottom_rekomendasi = (TextView)findViewById(0x7f0b020c);
        txt_menubottom_panduanbelanja = (TextView)findViewById(0x7f0b020f);
        txt_menubottom_pencrinci = (TextView)findViewById(0x7f0b0212);
        txt_menubottom_forum = (TextView)findViewById(0x7f0b0215);
        txt_menubottom_conv = (TextView)findViewById(0x7f0b0218);
        rl_menubottom_hprumor.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewMainActivity this$0;

            public void onClick(View view)
            {
                view = new Intent(getApplicationContext(), com/inponsel/android/v2/HomeSelengkapActivity);
                view.putExtra("status", "rumor");
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
        });
        rl_menubottom_rekomendasi.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewMainActivity this$0;

            public void onClick(View view)
            {
                view = new Intent(getApplicationContext(), com/inponsel/android/v2/PonselRekomendasiActivity);
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
        });
        rl_menubottom_panduanbel.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewMainActivity this$0;

            public void onClick(View view)
            {
                i = new Intent(getApplicationContext(), com/inponsel/android/daftarharga/DaftarHargaPonsel);
                startActivityForResult(i, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
        });
        rl_menubottom_pencrinci.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewMainActivity this$0;

            public void onClick(View view)
            {
                i = new Intent(getApplicationContext(), com/inponsel/android/pencarianrinci/PencarianRinciPonsel);
                startActivityForResult(i, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
        });
        rl_menubottom_forum.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewMainActivity this$0;

            public void onClick(View view)
            {
                i = new Intent(getApplicationContext(), com/inponsel/android/globalforum/ForumGlobalActivity);
                startActivityForResult(i, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
        });
        rl_menubottom_conv.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewMainActivity this$0;

            public void onClick(View view)
            {
                i = new Intent(getApplicationContext(), com/inponsel/android/conversation/ConversationActivity);
                startActivityForResult(i, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
        });
        img_likerandom_ponsel = (ImageView)findViewById(0x7f0b028c);
        img_dislikerandom_ponsel = (ImageView)findViewById(0x7f0b028d);
        imgHpRandom = (ImageView)findViewById(0x7f0b028a);
        progressbar_hp_random = (CircularProgressBar)findViewById(0x7f0b0289);
        rl_hp_random = (RelativeLayout)findViewById(0x7f0b0280);
        rl_background_random = (RelativeLayout)findViewById(0x7f0b0283);
        list_txtMerekRandom = (TextView)findViewById(0x7f0b0287);
        list_txtHargaRandom = (TextView)findViewById(0x7f0b028b);
        txtMoreLatestNews = (TextView)findViewById(0x7f0b021f);
        rl_hp_random.setVisibility(8);
        img_refresh_interaksi = (ImageView)findViewById(0x7f0b0293);
        img_refresh_fbads = (ImageView)findViewById(0x7f0b027a);
        notificationLikeHelper = new NotificationLikeHelper(this);
        listAppsMingguIni = (ExpandableHeightGridView)findViewById(0x7f0b0277);
        listAppsMingguIni.setExpanded(true);
        arrayListWeekApps = new ArrayList();
        listAppsWeekAdapter = new ListAppsAdapter(this, 0x7f030137, arrayListWeekApps);
        listAppsMingguIni.setAdapter(listAppsWeekAdapter);
        arrayListAds = new ArrayList();
        view_pager_ads = (AutoScrollViewPager)findViewById(0x7f0b01f8);
        view_pager_ads.setOffscreenPageLimit(5);
        customPagerAdapter = new CustomPagerAdapter(this, arrayListAds, view_pager_ads, sv_root);
        view_pager_ads.setInterval(5000L);
        view_pager_ads.startAutoScroll();
        bundle = ((WindowManager)getSystemService("window")).getDefaultDisplay();
        displaymetrics = new DisplayMetrics();
        bundle.getMetrics(displaymetrics);
        (new android.widget.FrameLayout.LayoutParams(displaymetrics.widthPixels - (int)Utility.convertDpToPixel(50F, this), (int)Utility.convertDpToPixel(200F, this))).gravity = 1;
        rl_slideshow_ads = (RelativeLayout)findViewById(0x7f0b01f6);
        progressbar_viewpager_ads = (CircularProgressBar)findViewById(0x7f0b01f7);
        arrayListInteraksi = new ArrayList();
        view_pager_interaksi = (AutoScrollViewPager)findViewById(0x7f0b0295);
        view_pager_interaksi.setOffscreenPageLimit(5);
        customInteraksiPagerAdapter = new CustomInteraksiPagerAdapter(this, arrayListInteraksi);
        view_pager_interaksi.setAdapter(customInteraksiPagerAdapter);
        view_pager_interaksi.setInterval(5000L);
        view_pager_interaksi.startAutoScroll();
        rl_slideshow_interaksi = (RelativeLayout)findViewById(0x7f0b0292);
        progressbar_viewpager_interaksi = (CircularProgressBar)findViewById(0x7f0b0294);
        progressbar_LatestNews = (CircularProgressBar)findViewById(0x7f0b021e);
        rl_slideshow_head_news = (RelativeLayout)findViewById(0x7f0b0261);
        progressbar_viewpager_head_news = (CircularProgressBar)findViewById(0x7f0b0262);
        progressbar_viewpager_tips_news = (CircularProgressBar)findViewById(0x7f0b0269);
        listKategori2Apps = (ExpandableHeightGridView)findViewById(0x7f0b0278);
        listKategori2Apps.setExpanded(true);
        arrayListKat2Apps = new ArrayList();
        listKatApps2Adapter = new ListKategoriApps2Adapter(this, 0x7f03013a, arrayListKat2Apps);
        listKategori2Apps.setAdapter(listKatApps2Adapter);
        if (userFunctions.isUserLoggedIn(this))
        {
            if (db.getInBoxCount() > 0)
            {
                Log.e("unread", "getTotalUnread");
                bundle = db.getTotalUnread();
                bundle.moveToFirst();
                bundle = bundle.getString(bundle.getColumnIndex("total"));
                if (bundle.equals("0") || bundle.equals(""))
                {
                    txtUnreadCount.setVisibility(8);
                    txtUnreadCount.setText("0");
                    txtUnreadCountMenu.setVisibility(8);
                    txtUnreadCountMenu.setText("0");
                } else
                {
                    txtUnreadCount.setText(bundle);
                    txtUnreadCount.setVisibility(0);
                    txtUnreadCountMenu.setText(bundle);
                    txtUnreadCountMenu.setVisibility(0);
                }
            } else
            {
                Log.e("unread", "getTotalUnreadSQLSEQ");
                bundle = db.getTotalUnreadSQLSEQ();
                bundle.moveToFirst();
                bundle = bundle.getString(bundle.getColumnIndex("total"));
                if (bundle.equals("0") || bundle.equals(""))
                {
                    txtUnreadCount.setVisibility(8);
                    txtUnreadCount.setText("0");
                    txtUnreadCountMenu.setVisibility(8);
                    txtUnreadCountMenu.setText("0");
                } else
                {
                    txtUnreadCount.setText(bundle);
                    txtUnreadCount.setVisibility(0);
                    txtUnreadCountMenu.setText(bundle);
                    txtUnreadCountMenu.setVisibility(0);
                }
            }
            if (db.getGroupChatCount() > 0)
            {
                bundle = db.getTotalUnreadGroupChat();
                bundle.moveToFirst();
                bundle = bundle.getString(bundle.getColumnIndex("total"));
                if (bundle.equals("0") || bundle.equals(""))
                {
                    txtUnreadGroupChat.setVisibility(8);
                    txtUnreadGroupChat.setText("0");
                    txtUnreadCountgroupchat.setText("0");
                    txtUnreadCountgroupchat.setVisibility(8);
                } else
                {
                    txtUnreadGroupChat.setText(bundle);
                    txtUnreadGroupChat.setVisibility(0);
                    txtUnreadCountgroupchat.setVisibility(0);
                    txtUnreadCountgroupchat.setText(bundle);
                }
                img_user_ponsel.setVisibility(0);
            } else
            {
                bundle = getApplicationContext().getSharedPreferences("UnreadGroup", 0).getString("unread_group", null);
                if (bundle.equals("0") || bundle.equals(""))
                {
                    txtUnreadGroupChat.setVisibility(8);
                    txtUnreadGroupChat.setText("0");
                    txtUnreadCountgroupchat.setText("0");
                    txtUnreadCountgroupchat.setVisibility(8);
                } else
                {
                    txtUnreadGroupChat.setText(bundle);
                    txtUnreadGroupChat.setVisibility(0);
                    txtUnreadCountgroupchat.setVisibility(0);
                    txtUnreadCountgroupchat.setText(bundle);
                }
            }
            mTransformation = (new RoundedTransformationBuilder()).borderColor(0).borderWidthDp(0.0F).cornerRadiusDp(10F).oval(false).build();
            Picasso.with(this).load((new StringBuilder(String.valueOf(Util.BASE_URL_THUMB2))).append(Utility.BASE_FORMAT).append("?w=").append(200).append("&src=").append(user_photo).toString()).transform(mTransformation).into(img_user_ponsel, new Callback() {

                final HomeNewMainActivity this$0;

                public void onError()
                {
                    img_user_ponsel.setVisibility(0);
                    img_user_ponsel.setImageResource(0x7f020297);
                }

                public void onSuccess()
                {
                }

            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
            });
            txt_user_name_1.setText(username);
            txt_user_ponsel_1.setText(user_ponsel1);
            txt_user_ponseldesc_1.setText("Login / Daftar");
            txt_user_name_1.setVisibility(0);
            img_user_ponsel.setOnClickListener(new android.view.View.OnClickListener() {

                final HomeNewMainActivity this$0;

                public void onClick(View view)
                {
                    i = new Intent(getApplicationContext(), com/inponsel/android/v2/ProfileActivity);
                    startActivityForResult(i, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
            });
            txt_user_name_1.setOnClickListener(new android.view.View.OnClickListener() {

                final HomeNewMainActivity this$0;

                public void onClick(View view)
                {
                    i = new Intent(getApplicationContext(), com/inponsel/android/v2/ProfileActivity);
                    startActivityForResult(i, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
            });
            txt_user_ponsel_1.setOnClickListener(new android.view.View.OnClickListener() {

                final HomeNewMainActivity this$0;

                public void onClick(View view)
                {
                    i = new Intent(getApplicationContext(), com/inponsel/android/v2/ProfilePonselUserActivity);
                    i.putExtra("namalengkap", user_ponsel1);
                    startActivityForResult(i, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
            });
            txt_user_ponseldesc_1.setVisibility(8);
            txt_user_name_1.setVisibility(0);
            txt_user_ponsel_1.setVisibility(0);
            img_user_ponsel.setVisibility(0);
        } else
        {
            txt_user_ponseldesc_1.setText("Login / Daftar");
            txt_user_ponseldesc_1.setVisibility(0);
            txt_user_name_1.setVisibility(8);
            txt_user_ponsel_1.setVisibility(8);
            img_user_ponsel.setVisibility(8);
        }
        home_menu_gadget_rumor = (RelativeLayout)findViewById(0x7f0b0227);
        home_menu_gadget_segera = (RelativeLayout)findViewById(0x7f0b023a);
        home_menu_news_tips = (RelativeLayout)findViewById(0x7f0b026d);
        btnMoreSegera = (RelativeLayout)findViewById(0x7f0b024b);
        btnMoreTerbaruBrand = (RelativeLayout)findViewById(0x7f0b0252);
        txtMoreJempolInPonsel = (TextView)findViewById(0x7f0b0285);
        txtMoreJempolInPonsel.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewMainActivity this$0;

            public void onClick(View view)
            {
                load_random_hp();
            }

            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
        });
        home_menu_gadget_rumor.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewMainActivity this$0;

            public void onClick(View view)
            {
                view = new Intent(getApplicationContext(), com/inponsel/android/v2/HomeSelengkapActivity);
                view.putExtra("status", "rumor");
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
        });
        btnMoreSegera.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewMainActivity this$0;

            public void onClick(View view)
            {
                view = new Intent(getApplicationContext(), com/inponsel/android/v2/HomeSelengkapActivity);
                view.putExtra("status", "segera");
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
        });
        btnMoreTerbaruBrand.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewMainActivity this$0;

            public void onClick(View view)
            {
                view = new Intent(getApplicationContext(), com/inponsel/android/v2/DaftarPonselMerkActivity);
                view.putExtra("merk", lts_brand_idmerk);
                view.putExtra("titlemerek", lts_brand_merk);
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
        });
        home_menu_news_tips.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewMainActivity this$0;

            public void onClick(View view)
            {
                view = new Intent(HomeNewMainActivity.this, com/inponsel/android/v2/RSSFeedByTag);
                view.putExtra("tag_code", "0");
                view.putExtra("kategori_tag", "Tips & Trik");
                view.putExtra("tag_key", "gn:tips-trik");
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
        });
        img_refresh_interaksi.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewMainActivity this$0;

            public void onClick(View view)
            {
                sendRequestInteraksi();
            }

            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
        });
        home_menu_gadget_pilihan.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewMainActivity this$0;

            public void onClick(View view)
            {
                view = new Intent(getApplicationContext(), com/inponsel/android/v2/PonselRekomendasiActivity);
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
        });
        ll_home_turunharga.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewMainActivity this$0;

            public void onClick(View view)
            {
                i = new Intent(getApplicationContext(), com/inponsel/android/v2/TurunHargaPonselActivity);
                startActivityForResult(i, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
        });
        ll_home_sc.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewMainActivity this$0;

            public void onClick(View view)
            {
                i = new Intent(getApplicationContext(), com/inponsel/android/v2/SCUserActivity);
                startActivityForResult(i, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
        });
        txtMoreLatestNews.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewMainActivity this$0;

            public void onClick(View view)
            {
                i = new Intent(getApplicationContext(), com/inponsel/android/v2/HomeNewsActivity);
                i.putExtra("tag_timeline", "terbaru");
                i.putExtra("tag_code", "tagall");
                i.putExtra("tag_page", "1");
                startActivityForResult(i, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
        });
        txtMorePendatang.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewMainActivity this$0;

            public void onClick(View view)
            {
                view = new Intent(getApplicationContext(), com/inponsel/android/v2/HomeSelengkapActivity);
                view.putExtra("status", "pendatang");
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
        });
        txtMoreInteraksi.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewMainActivity this$0;

            public void onClick(View view)
            {
                view = new Intent(HomeNewMainActivity.this, com/inponsel/android/v2/KomentarBaruLainPonsel);
                view.putExtra("str_id_user", user_id);
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
        });
        txtMoreRilis.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewMainActivity this$0;

            public void onClick(View view)
            {
                view = new Intent(getApplicationContext(), com/inponsel/android/v2/HomeSelengkapActivity);
                view.putExtra("status", "rilis");
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
        });
        txtMoreTopHits.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewMainActivity this$0;

            public void onClick(View view)
            {
                i = new Intent(getApplicationContext(), com/inponsel/android/statistik/StatistikPonsel);
                i.putExtra("pager_pos", "0");
                startActivityForResult(i, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
        });
        img_likerandom_ponsel.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewMainActivity this$0;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(getApplicationContext()))
                {
                    statusLikeHp = "1";
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
                    view = new android.app.AlertDialog.Builder(HomeNewMainActivity.this);
                    view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                    view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                        final _cls29 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls29.this;
                super();
            }
                    });
                    view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls29 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                            startActivityForResult(dialoginterface, 0);
                            overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls29.this;
                super();
            }
                    });
                    view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls29 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            startActivityForResult(dialoginterface, 0);
                            overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls29.this;
                super();
            }
                    });
                    view.show();
                    return;
                }
            }


            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
        });
        img_dislikerandom_ponsel.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewMainActivity this$0;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(getApplicationContext()))
                {
                    statusLikeHp = "0";
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
                    view = new android.app.AlertDialog.Builder(HomeNewMainActivity.this);
                    view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                    view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                        final _cls30 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls30.this;
                super();
            }
                    });
                    view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls30 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                            startActivityForResult(dialoginterface, 0);
                            overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls30.this;
                super();
            }
                    });
                    view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls30 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            startActivityForResult(dialoginterface, 0);
                            overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls30.this;
                super();
            }
                    });
                    view.show();
                    return;
                }
            }


            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
        });
        home_menu_user_ponsel.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewMainActivity this$0;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(HomeNewMainActivity.this))
                {
                    i = new Intent(getApplicationContext(), com/inponsel/android/v2/ProfilePonselUserActivity);
                    i.putExtra("namalengkap", user_ponsel1);
                    startActivityForResult(i, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                    return;
                } else
                {
                    view = new android.app.AlertDialog.Builder(HomeNewMainActivity.this);
                    view.setMessage("Fitur ini hanya untuk pengguna terdaftar.");
                    view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                        final _cls31 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls31.this;
                super();
            }
                    });
                    view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls31 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                            startActivityForResult(dialoginterface, 0);
                            overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls31.this;
                super();
            }
                    });
                    view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls31 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            startActivityForResult(dialoginterface, 0);
                            overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls31.this;
                super();
            }
                    });
                    view.show();
                    return;
                }
            }


            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
        });
        home_menu_Conversation.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewMainActivity this$0;

            public void onClick(View view)
            {
                i = new Intent(getApplicationContext(), com/inponsel/android/conversation/ConversationActivity);
                startActivityForResult(i, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
        });
        ll_home_inbox.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewMainActivity this$0;

            public void onClick(View view)
            {
                i = new Intent(getApplicationContext(), com/inponsel/android/v2/InboxMessageActivity);
                startActivityForResult(i, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
        });
        ll_home_chatroom.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewMainActivity this$0;

            public void onClick(View view)
            {
                i = new Intent(getApplicationContext(), com/inponsel/android/v2/RoomGroupChatListActivity);
                startActivityForResult(i, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
        });
        ll_home_forum.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewMainActivity this$0;

            public void onClick(View view)
            {
                i = new Intent(getApplicationContext(), com/inponsel/android/favorit/FavoritPonselMerek);
                startActivityForResult(i, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
        });
        ll_home_setting.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewMainActivity this$0;

            public void onClick(View view)
            {
                i = new Intent(getApplicationContext(), com/inponsel/android/favorit/LanggananBeritaAll);
                startActivityForResult(i, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
        });
        ll_home_news.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewMainActivity this$0;

            public void onClick(View view)
            {
                i = new Intent(getApplicationContext(), com/inponsel/android/v2/HomeNewsActivity);
                i.putExtra("tag_timeline", "terbaru");
                i.putExtra("tag_code", "tagall");
                i.putExtra("tag_page", "1");
                startActivityForResult(i, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
        });
        ll_home_gadget.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewMainActivity this$0;

            public void onClick(View view)
            {
                i = new Intent(getApplicationContext(), com/inponsel/android/v2/HomeGadgetActivity);
                startActivityForResult(i, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
        });
        ll_home_aplikasi.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewMainActivity this$0;

            public void onClick(View view)
            {
                i = new Intent(getApplicationContext(), com/inponsel/android/v2/HomeAppsActivity);
                startActivityForResult(i, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
        });
        set_menu_apps();
        ll_home_games.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewMainActivity this$0;

            public void onClick(View view)
            {
                i = new Intent(getApplicationContext(), com/inponsel/android/v2/HomeGamesActivity);
                startActivityForResult(i, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
        });
        if (userFunctions.isUserLoggedIn(getApplicationContext()))
        {
            PushOnlineStat("1");
        }
        listAppsMingguIni.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final HomeNewMainActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int k, long l)
            {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse(listAppsWeekAdapter.getListModel(k).getAppurl())));
                Log.e("whatsnew", listAppsWeekAdapter.getListModel(k).getAppurl());
            }

            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
        });
        if (userFunctions.isUserLoggedIn(this))
        {
            regid = prefGCM.getString("gcm_id", null);
            Log.e("regid", regid);
            if (regid.equals(""))
            {
                regid = GCMRegistrar.getRegistrationId(this);
                prefGCM = getApplicationContext().getSharedPreferences("GCMPref", 0);
                bundle = prefGCM.edit();
                bundle.putString("gcm_id", regid);
                bundle.commit();
                UpdateGCMReg(regid);
            } else
            {
                UpdateGCMReg(regid);
            }
        }
        listPendatang.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final HomeNewMainActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int k, long l)
            {
                listPendatang.playSoundEffect(0);
                adapterview = new Intent(getApplicationContext(), com/inponsel/android/details/DetailsPonsel);
                adapterview.putExtra("id_hph", pendatangAdapter.getListModel(k).getId_hp().toString());
                adapterview.putExtra("namalengkap", (new StringBuilder(String.valueOf(pendatangAdapter.getListModel(k).getMerk().toString()))).append(" ").append(pendatangAdapter.getListModel(k).getModel().toString()).toString());
                adapterview.putExtra("codename", pendatangAdapter.getListModel(k).getCodename().toString());
                adapterview.putExtra("model", pendatangAdapter.getListModel(k).getModel().toString());
                adapterview.putExtra("merk", pendatangAdapter.getListModel(k).getMerk().toString());
                adapterview.putExtra("gambar", pendatangAdapter.getListModel(k).getGambar().toString());
                adapterview.putExtra("hrg_baru", pendatangAdapter.getListModel(k).getHrg_baru().toString());
                adapterview.putExtra("hrg_bekas", pendatangAdapter.getListModel(k).getHrg_bekas().toString());
                adapterview.putExtra("tot_like", pendatangAdapter.getListModel(k).getTotal_like().toString());
                adapterview.putExtra("tot_dislike", pendatangAdapter.getListModel(k).getTotal_dislike().toString());
                adapterview.putExtra("tot_komen", pendatangAdapter.getListModel(k).getTotal_kom().toString());
                startActivityForResult(adapterview, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
        });
        listRilis.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final HomeNewMainActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int k, long l)
            {
                listRilis.playSoundEffect(0);
                adapterview = new Intent(getApplicationContext(), com/inponsel/android/details/DetailsPonsel);
                adapterview.putExtra("id_hph", rilisTerbaruAdapter.getListModel(k).getId_hp().toString());
                adapterview.putExtra("namalengkap", (new StringBuilder(String.valueOf(rilisTerbaruAdapter.getListModel(k).getMerk().toString()))).append(" ").append(rilisTerbaruAdapter.getListModel(k).getModel().toString()).toString());
                adapterview.putExtra("codename", rilisTerbaruAdapter.getListModel(k).getCodename().toString());
                adapterview.putExtra("model", rilisTerbaruAdapter.getListModel(k).getModel().toString());
                adapterview.putExtra("merk", rilisTerbaruAdapter.getListModel(k).getMerk().toString());
                adapterview.putExtra("gambar", rilisTerbaruAdapter.getListModel(k).getGambar().toString());
                adapterview.putExtra("hrg_baru", rilisTerbaruAdapter.getListModel(k).getHrg_baru().toString());
                adapterview.putExtra("hrg_bekas", rilisTerbaruAdapter.getListModel(k).getHrg_bekas().toString());
                adapterview.putExtra("tot_like", rilisTerbaruAdapter.getListModel(k).getTotal_like().toString());
                adapterview.putExtra("tot_dislike", rilisTerbaruAdapter.getListModel(k).getTotal_dislike().toString());
                adapterview.putExtra("tot_komen", rilisTerbaruAdapter.getListModel(k).getTotal_kom().toString());
                startActivityForResult(adapterview, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
        });
        listTopHits.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final HomeNewMainActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int k, long l)
            {
                listTopHits.playSoundEffect(0);
                adapterview = new Intent(getApplicationContext(), com/inponsel/android/details/DetailsPonsel);
                adapterview.putExtra("id_hph", topHitsAdapter.getListModel(k).getId_hp().toString());
                adapterview.putExtra("namalengkap", (new StringBuilder(String.valueOf(topHitsAdapter.getListModel(k).getMerk().toString()))).append(" ").append(topHitsAdapter.getListModel(k).getModel().toString()).toString());
                adapterview.putExtra("codename", topHitsAdapter.getListModel(k).getCodename().toString());
                adapterview.putExtra("model", topHitsAdapter.getListModel(k).getModel().toString());
                adapterview.putExtra("merk", topHitsAdapter.getListModel(k).getMerk().toString());
                adapterview.putExtra("gambar", topHitsAdapter.getListModel(k).getGambar().toString());
                adapterview.putExtra("hrg_baru", topHitsAdapter.getListModel(k).getHrg_baru().toString());
                adapterview.putExtra("hrg_bekas", topHitsAdapter.getListModel(k).getHrg_bekas().toString());
                adapterview.putExtra("tot_like", topHitsAdapter.getListModel(k).getTotal_like().toString());
                adapterview.putExtra("tot_dislike", topHitsAdapter.getListModel(k).getTotal_dislike().toString());
                adapterview.putExtra("tot_komen", topHitsAdapter.getListModel(k).getTotal_kom().toString());
                startActivityForResult(adapterview, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
        });
        bundle = (LayoutInflater)getSystemService("layout_inflater");
        listKategori2Apps.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final HomeNewMainActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int k, long l)
            {
                adapterview = new Intent(getApplicationContext(), com/inponsel/android/v2/AppsByCategory);
                adapterview.putExtra("id", listKatApps2Adapter.getListModel(k).getId_apps());
                adapterview.putExtra("kategori", listKatApps2Adapter.getListModel(k).getKat_apps_name());
                adapterview.putExtra("tag", listKatApps2Adapter.getListModel(k).getKat_apps_tag());
                adapterview.putExtra("deskripsi", listKatApps2Adapter.getListModel(k).getKat_apps_desc());
                adapterview.putExtra("mod_date", listKatApps2Adapter.getListModel(k).getKat_apps_date());
                adapterview.putExtra("background", listKatApps2Adapter.getListModel(k).getKat_apps_background());
                adapterview.putExtra("background_img", listKatApps2Adapter.getListModel(k).getKat_apps_background_img());
                adapterview.putExtra("total_like", listKatApps2Adapter.getListModel(k).getKat_total_like());
                adapterview.putExtra("mystat", listKatApps2Adapter.getListModel(k).getKat_like_status());
                adapterview.putExtra("myfav", listKatApps2Adapter.getListModel(k).getKat_fav_status());
                adapterview.putExtra("width_img", listKatApps2Adapter.getListModel(k).getKat_img_width());
                adapterview.putExtra("height_img", listKatApps2Adapter.getListModel(k).getKat_img_height());
                adapterview.putExtra("type", listKatApps2Adapter.getListModel(k).getKat_type());
                startActivityForResult(adapterview, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        if (userFunctions.isUserLoggedIn(getApplicationContext()))
        {
            getSupportMenuInflater().inflate(0x7f0f000e, menu);
            View view = menu.findItem(0x7f0b0942).getActionView();
            txt_notif_count = (TextView)view.findViewById(0x7f0b0062);
            img_Notification = (ImageView)view.findViewById(0x7f0b047f);
            txt_notif_count.setVisibility(4);
            updateHotCount(hot_number);
            new MyMenuItemStuffListener(view, "Notifikasi") {

                final HomeNewMainActivity this$0;

                public void onClick(View view1)
                {
                    txt_notif_count.setVisibility(4);
                    img_Notification.setBackgroundResource(0x7f02021f);
                    view1 = new Intent(HomeNewMainActivity.this, com/inponsel/android/v2/NotificationCenterActivity);
                    startActivityForResult(view1, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$0 = HomeNewMainActivity.this;
                super(view, s);
            }
            };
        } else
        {
            getSupportMenuInflater().inflate(0x7f0f0002, menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (receiver != null)
        {
            unregisterReceiver(receiver);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        switch (i)
        {
        default:
            return super.onKeyDown(i, keyevent);

        case 82: // 'R'
            break;
        }
        if (mDrawerLayout.isDrawerOpen(0x800003))
        {
            mDrawerLayout.closeDrawers();
        } else
        {
            mDrawerLayout.openDrawer(0x800003);
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return true;

        case 16908332: 
            mDrawerToggle.onOptionsItemSelected(menuitem);
            return true;

        case 2131429682: 
            startActivity(new Intent(getApplicationContext(), com/inponsel/android/pencariangen/TabPencarian));
            break;
        }
        return true;
    }

    public void onPause()
    {
        progressbar_viewpager_ads.setVisibility(8);
        progressbar_viewpager_interaksi.setVisibility(8);
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
    }

    public void onScrollChanged(ParallaxScrollView parallaxscrollview, int i, int j, int k, int l)
    {
        i = parallaxscrollview.getChildAt(parallaxscrollview.getChildCount() - 1).getBottom() - (parallaxscrollview.getHeight() + parallaxscrollview.getScrollY());
        Log.e("diff", String.valueOf(i));
        if (scroll_count == 1)
        {
            scroll_count = scroll_count + 1;
        }
        if (i <= 80 && scroll_count == 2)
        {
            progressbar_segmen2.setVisibility(0);
        }
        if (i <= 30)
        {
            Log.e("bottom", (new StringBuilder("endscroll")).append(String.valueOf(scroll_count)).toString());
            endScroll();
        }
    }

    public void onStart()
    {
        super.onStart();
        GoogleAnalytics.getInstance(this).reportActivityStart(this);
        sPref = PreferenceManager.getDefaultSharedPreferences(this).getString("listPref", "Wi-Fi");
        updateConnectedFlags();
        if (refreshDisplay)
        {
            load_segmen_1();
        }
    }

    public void update(Observable observable, Object obj)
    {
        if (ponselBaseApp.getObserver().getUpdateType().toString().equals("likedisPonsel"))
        {
            Log.e("updateViewLikeDisPonselRandom", ponselBaseApp.getObserver().getUpdateType().toString());
            Log.e("random_id_hp", (new StringBuilder(String.valueOf(random_id_hp))).append("=").append(ponselBaseApp.getObserver().getIndexHp()).toString());
            if (random_codename.equals(ponselBaseApp.getObserver().getIndexHp()))
            {
                load_random_hp();
            }
        }
        if (ponselBaseApp.getObserver().getLoginStat().equals("1"))
        {
            runOnUiThread(new Runnable() {

                final HomeNewMainActivity this$0;

                public void run()
                {
                    if (userFunctions.isUserLoggedIn(HomeNewMainActivity.this))
                    {
                        Object obj1;
                        if (db.getInBoxCount() > 0)
                        {
                            Log.e("unread", "getTotalUnread");
                            obj1 = db.getTotalUnread();
                            ((Cursor) (obj1)).moveToFirst();
                            obj1 = ((Cursor) (obj1)).getString(((Cursor) (obj1)).getColumnIndex("total"));
                            if (((String) (obj1)).equals("0") || ((String) (obj1)).equals(""))
                            {
                                txtUnreadCount.setVisibility(8);
                                txtUnreadCount.setText("0");
                                txtUnreadCountMenu.setVisibility(8);
                                txtUnreadCountMenu.setText("0");
                            } else
                            {
                                txtUnreadCount.setText(((CharSequence) (obj1)));
                                txtUnreadCount.setVisibility(0);
                                txtUnreadCountMenu.setText(((CharSequence) (obj1)));
                                txtUnreadCountMenu.setVisibility(0);
                            }
                        } else
                        {
                            Log.e("unread", "getTotalUnreadSQLSEQ");
                            obj1 = db.getTotalUnreadSQLSEQ();
                            ((Cursor) (obj1)).moveToFirst();
                            obj1 = ((Cursor) (obj1)).getString(((Cursor) (obj1)).getColumnIndex("total"));
                            if (((String) (obj1)).equals("0") || ((String) (obj1)).equals(""))
                            {
                                txtUnreadCount.setVisibility(8);
                                txtUnreadCount.setText("0");
                                txtUnreadCountMenu.setVisibility(8);
                                txtUnreadCountMenu.setText("0");
                            } else
                            {
                                txtUnreadCount.setText(((CharSequence) (obj1)));
                                txtUnreadCount.setVisibility(0);
                                txtUnreadCountMenu.setText(((CharSequence) (obj1)));
                                txtUnreadCountMenu.setVisibility(0);
                            }
                        }
                        if (db.getGroupChatCount() > 0)
                        {
                            obj1 = db.getTotalUnreadGroupChat();
                            ((Cursor) (obj1)).moveToFirst();
                            obj1 = ((Cursor) (obj1)).getString(((Cursor) (obj1)).getColumnIndex("total"));
                            if (((String) (obj1)).equals("0") || ((String) (obj1)).equals(""))
                            {
                                txtUnreadGroupChat.setVisibility(8);
                                txtUnreadGroupChat.setText("0");
                                txtUnreadCountgroupchat.setText("0");
                                txtUnreadCountgroupchat.setVisibility(8);
                            } else
                            {
                                txtUnreadGroupChat.setText(((CharSequence) (obj1)));
                                txtUnreadGroupChat.setVisibility(0);
                                txtUnreadCountgroupchat.setVisibility(0);
                                txtUnreadCountgroupchat.setText(((CharSequence) (obj1)));
                            }
                            img_user_ponsel.setVisibility(0);
                        } else
                        {
                            String s = getApplicationContext().getSharedPreferences("UnreadGroup", 0).getString("unread_group", null);
                            if (s.equals("0") || s.equals(""))
                            {
                                txtUnreadGroupChat.setVisibility(8);
                                txtUnreadGroupChat.setText("0");
                                txtUnreadCountgroupchat.setText("0");
                                txtUnreadCountgroupchat.setVisibility(8);
                            } else
                            {
                                txtUnreadGroupChat.setText(s);
                                txtUnreadGroupChat.setVisibility(0);
                                txtUnreadCountgroupchat.setVisibility(0);
                                txtUnreadCountgroupchat.setText(s);
                            }
                            img_user_ponsel.setVisibility(8);
                        }
                        mTransformation = (new RoundedTransformationBuilder()).borderColor(0).borderWidthDp(0.0F).cornerRadiusDp(10F).oval(false).build();
                        img_user_ponsel.setOnClickListener(new android.view.View.OnClickListener() {

                            final _cls67 this$1;

                            public void onClick(View view)
                            {
                                i = new Intent(getApplicationContext(), com/inponsel/android/v2/ProfileActivity);
                                startActivityForResult(i, 0);
                                overridePendingTransition(0x7f040003, 0x7f040004);
                            }

            
            {
                this$1 = _cls67.this;
                super();
            }
                        });
                        txt_user_name_1.setOnClickListener(new android.view.View.OnClickListener() {

                            final _cls67 this$1;

                            public void onClick(View view)
                            {
                                i = new Intent(getApplicationContext(), com/inponsel/android/v2/ProfileActivity);
                                startActivityForResult(i, 0);
                                overridePendingTransition(0x7f040003, 0x7f040004);
                            }

            
            {
                this$1 = _cls67.this;
                super();
            }
                        });
                        txt_user_ponsel_1.setOnClickListener(new android.view.View.OnClickListener() {

                            final _cls67 this$1;

                            public void onClick(View view)
                            {
                                i = new Intent(getApplicationContext(), com/inponsel/android/v2/ProfilePonselUserActivity);
                                i.putExtra("namalengkap", user_ponsel1);
                                startActivityForResult(i, 0);
                                overridePendingTransition(0x7f040003, 0x7f040004);
                            }

            
            {
                this$1 = _cls67.this;
                super();
            }
                        });
                        cursor = db.getAllData();
                        cursor.moveToFirst();
                        username = cursor.getString(4);
                        user_photo = (new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(cursor.getString(3)).toString();
                        user_ponsel1 = cursor.getString(10);
                        user_provider1 = cursor.getString(12);
                        menu_profil.setVisibility(0);
                        menu_username.setText((new StringBuilder()).append(username).toString());
                        menu_ponsel_pengguna.setText((new StringBuilder()).append(user_ponsel1).toString());
                        menu_sim_pengguna.setText((new StringBuilder()).append(user_provider1).toString());
                        Picasso.with(HomeNewMainActivity.this).load((new StringBuilder(String.valueOf(Util.BASE_URL_THUMB2))).append(Utility.BASE_FORMAT).append("?w=").append(200).append("&src=").append(user_photo).toString()).transform(mTransformation).into(img_user_ponsel, new Callback() {

                            final _cls67 this$1;

                            public void onError()
                            {
                            }

                            public void onSuccess()
                            {
                            }

            
            {
                this$1 = _cls67.this;
                super();
            }
                        });
                        txt_user_name_1.setText(username);
                        txt_user_ponsel_1.setText(user_ponsel1);
                        txt_user_ponseldesc_1.setText("Login / Daftar");
                        txt_user_name_1.setVisibility(0);
                        txt_user_ponseldesc_1.setVisibility(8);
                        txt_user_name_1.setVisibility(0);
                        txt_user_ponsel_1.setVisibility(0);
                        img_user_ponsel.setVisibility(0);
                        imageLoader2.displayImage((new StringBuilder("http://tools.inponsel.com/thumb/thumb.php?w=300&src=")).append(user_photo.trim()).toString(), menu_imgProfil, options, animateFirstListener);
                        menu_profil.setVisibility(0);
                        menu_LoginRegister.setVisibility(8);
                        menu_Bookmark.setVisibility(0);
                        menu_pesan.setVisibility(0);
                        ll_menu_msg.setVisibility(0);
                        menu_GroupChat.setVisibility(0);
                        menu_Setting.setVisibility(0);
                        return;
                    } else
                    {
                        txt_user_ponseldesc_1.setText("Login / Daftar");
                        txt_user_ponseldesc_1.setVisibility(0);
                        txt_user_name_1.setVisibility(8);
                        menu_GroupChat.setVisibility(8);
                        menu_pesan.setVisibility(8);
                        ll_menu_msg.setVisibility(8);
                        menu_LoginRegister.setVisibility(0);
                        menu_Bookmark.setVisibility(8);
                        menu_Setting.setVisibility(8);
                        menu_profil.setVisibility(8);
                        return;
                    }
                }


            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
            });
        }
    }

    public void updateHotCount(int i)
    {
        String s = Utility.session(Utility.session(Utility.session(RestClient.pelihara)));
        s = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("user_notif_count").append(Utility.BASE_FORMAT).append("?").append("lmt=0&t=").append(s).append("&idusr=").append(user_id).toString();
        Log.e("urlNotif", s);
        AsyncHttpClient asynchttpclient = new AsyncHttpClient();
        asynchttpclient.setMaxRetriesAndTimeout(5, 10000);
        asynchttpclient.get(s, new AsyncHttpResponseHandler() {

            final HomeNewMainActivity this$0;

            public void onFailure(int j, Header aheader[], byte abyte0[], Throwable throwable)
            {
            }

            public void onRetry(int j)
            {
            }

            public void onStart()
            {
            }

            public void onSuccess(int j, Header aheader[], byte abyte0[])
            {
                aheader = new String(abyte0);
                Log.e("responseNotif", aheader);
                aheader = new JSONObject(aheader);
                hot_number = aheader.getJSONObject("InPonsel").getJSONObject("data").getInt("activities");
                Log.e("activities", String.valueOf(hot_number));
                if (txt_notif_count == null)
                {
                    return;
                }
                try
                {
                    runOnUiThread(new Runnable() {

                        final _cls64 this$1;

                        public void run()
                        {
                            Log.e("new_hot_number", Integer.toString(hot_number));
                            if (hot_number == 0)
                            {
                                Log.e("notif", "kosong");
                                txt_notif_count.setVisibility(4);
                                img_Notification.setBackgroundResource(0x7f02021f);
                                return;
                            }
                            Log.e("notif", "ada");
                            if (hot_number > 99)
                            {
                                txt_notif_count.setText("99+");
                            } else
                            {
                                txt_notif_count.setText(Integer.toString(hot_number));
                            }
                            txt_notif_count.setVisibility(0);
                            img_Notification.setBackgroundResource(0x7f020220);
                        }

            
            {
                this$1 = _cls64.this;
                super();
            }
                    });
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Header aheader[])
                {
                    aheader.printStackTrace();
                }
                return;
            }


            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }
        });
    }













}
