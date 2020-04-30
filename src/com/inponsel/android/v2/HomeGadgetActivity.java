// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.SQLException;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.StrictMode;
import android.preference.PreferenceManager;
import android.support.v4.widget.DrawerLayout;
import android.text.Editable;
import android.text.Html;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.actionbarsherlock.ActionBarSherlock;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.android.volley.VolleyError;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import com.inponsel.android.SplashScreen;
import com.inponsel.android.adapter.CustomPagerAdapter;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.daftarharga.DaftarHargaPonsel;
import com.inponsel.android.details.DetailsPonsel;
import com.inponsel.android.favorit.FavoritPonselMerek;
import com.inponsel.android.pencariangen.TabPencarian;
import com.inponsel.android.pencarianrinci.PencarianRinciPonsel;
import com.inponsel.android.rssfeeddetail.RSSDetailTab;
import com.inponsel.android.rsstab.RSSTimelineActivity;
import com.inponsel.android.statistik.StatistikPonsel;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.EncodeDecodeAES;
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
import com.inponsel.android.widget.DroidWriterEditText;
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
import fr.castorflex.android.circularprogressbar.CircularProgressBar;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
import org.apache.http.Header;
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

// Referenced classes of package com.inponsel.android.v2:
//            BaseDrawer, MerekActivity, RegisterActivity, LoginActivity, 
//            KomentarPonsel, RSSFeedByTag, HomeSelengkapActivity, SCUserActivity, 
//            PengaturanActivity, FAQActivity, KebijakanActivity, PersyaratanActivity, 
//            TentangActivity, ProfileActivity, RoomGroupChatListActivity, InboxMessageActivity

public class HomeGadgetActivity extends BaseDrawer
    implements android.view.View.OnClickListener, com.nirhart.parallaxscroll.views.ParallaxScrollView.ScrollViewListener, Observer, android.view.animation.Animation.AnimationListener
{
    private class CancelListener
        implements android.content.DialogInterface.OnCancelListener
    {

        AsyncTask cancellableTask;
        final HomeGadgetActivity this$0;

        public void onCancel(DialogInterface dialoginterface)
        {
            cancellableTask.cancel(true);
        }

        public CancelListener(AsyncTask asynctask)
        {
            this$0 = HomeGadgetActivity.this;
            super();
            cancellableTask = asynctask;
        }
    }

    private class LatestBrandTask extends AsyncTask
    {

        final HomeGadgetActivity this$0;

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
            progressbar_segmen2.setVisibility(8);
            Picasso.with(HomeGadgetActivity.this).load(lts_brand_logo.trim()).tag(this).into(img_brand, new Callback() {

                final LatestBrandTask this$1;

                public void onError()
                {
                }

                public void onSuccess()
                {
                    img_brand.setVisibility(0);
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
                break MISSING_BLOCK_LABEL_183;
            }
            if (latestBrandArray.size() == 0)
            {
                txtMoreTerbaruBrand.setText("REFRESH");
            }
_L1:
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
            try
            {
                latestBrandAdapter.notifyDataSetChanged();
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
            txtMoreTerbaruBrand.setVisibility(8);
        }


        private LatestBrandTask()
        {
            this$0 = HomeGadgetActivity.this;
            super();
        }

        LatestBrandTask(LatestBrandTask latestbrandtask)
        {
            this();
        }
    }

    public class ListDiminatiAdapter extends BaseAdapter
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
        String statusDiminati;
        String statusLikeHpDiminati;
        String t;
        final HomeGadgetActivity this$0;
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
                viewgroup.txtTitleReco1 = (TextView)view.findViewById(0x7f0b034b);
                viewgroup.txtTitleReco2 = (TextView)view.findViewById(0x7f0b034c);
                viewgroup.list_like = (ImageView)view.findViewById(0x7f0b0343);
                viewgroup.list_dislike = (ImageView)view.findViewById(0x7f0b0346);
                viewgroup.progressbar_item = (ProgressBar)view.findViewById(0x7f0b00b3);
                viewgroup.ll_master_item = (LinearLayout)view.findViewById(0x7f0b084e);
                viewgroup.list_lay_like = (RelativeLayout)view.findViewById(0x7f0b0342);
                viewgroup.list_lay_dislike = (RelativeLayout)view.findViewById(0x7f0b0345);
                viewgroup.list_lay_kom = (RelativeLayout)view.findViewById(0x7f0b0348);
                viewgroup.ratingDirekomen = (RatingBar)view.findViewById(0x7f0b033e);
                viewgroup.list_txtBigRight = (TextView)view.findViewById(0x7f0b034d);
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
                ((ViewHolder) (viewgroup)).list_txtBigRight.setText(lms.getAvg_all());
                Log.e("ratingRekomen", lms.getAvg_all());
                ((ViewHolder) (viewgroup)).ratingDirekomen.setRating(Float.parseFloat(lms.getAvg_all()));
                ((ViewHolder) (viewgroup)).txtTitleReco1.setText((new StringBuilder("Apa saja yang menarik dari ")).append(lms.getMerk()).append(" ").append(lms.getModel()).append("?").toString());
                ((ViewHolder) (viewgroup)).txtTitleReco2.setText(Html.fromHtml("Telusuri fitur, pendapat pengunjung, ulasan pengguna dan isu-isu dibelakangnya <i>disini</i>"));
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
                    ((ViewHolder) (viewgroup)).list_lay_like.setBackgroundResource(0x7f02007a);
                    ((ViewHolder) (viewgroup)).list_lay_dislike.setBackgroundResource(0x7f02007a);
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

                    final ListDiminatiAdapter this$1;
                    private final int val$position;

                    public void onClick(View view)
                    {
                        if (userFunctions.isUserLoggedIn(activity))
                        {
                            pos = position;
                            statusDiminati = "1";
                            statusLikeHpDiminati = "1";
                            indexhp = getListModel(position).getId_hp();
                            ponselBaseApp.getObserver().setIndexHp(getListModel(position).getCodename());
                            namalengkapbgskrg = (new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString();
                            try
                            {
                                finalUrl = (new StringBuilder("idhp=")).append(getListModel(position).getId_hp()).append("&email=").append(username).append("&namalengkap=").append(URLEncoder.encode((new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString(), "utf-8")).append("&status=").append(statusDiminati).append("&t=").append(t).toString();
                            }
                            // Misplaced declaration of an exception variable
                            catch (View view)
                            {
                                view.printStackTrace();
                            }
                            Log.e("finalurl", finalUrl);
                            if (android.os.Build.VERSION.SDK_INT >= 11)
                            {
                                (new ListDiminatiAdapter.PostBagusKurangTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                                return;
                            } else
                            {
                                (new ListDiminatiAdapter.PostBagusKurangTask()).execute(new Void[0]);
                                return;
                            }
                        } else
                        {
                            view = new android.app.AlertDialog.Builder(activity);
                            view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                            view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                                final ListDiminatiAdapter._cls1 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = ListDiminatiAdapter._cls1.this;
                super();
            }
                            });
                            view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                                final ListDiminatiAdapter._cls1 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(activity, com/inponsel/android/v2/RegisterActivity);
                                    activity.startActivityForResult(dialoginterface, 0);
                                    overridePendingTransition(0x7f040003, 0x7f040004);
                                }

            
            {
                this$2 = ListDiminatiAdapter._cls1.this;
                super();
            }
                            });
                            view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                                final ListDiminatiAdapter._cls1 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(activity, com/inponsel/android/v2/LoginActivity);
                                    dialoginterface.putExtra("activity", "main");
                                    activity.startActivityForResult(dialoginterface, 0);
                                    overridePendingTransition(0x7f040003, 0x7f040004);
                                }

            
            {
                this$2 = ListDiminatiAdapter._cls1.this;
                super();
            }
                            });
                            view.show();
                            return;
                        }
                    }


            
            {
                this$1 = final_listdiminatiadapter;
                position = I.this;
                super();
            }
                });
                ((ViewHolder) (viewgroup)).list_lay_dislike.setOnClickListener(i. new android.view.View.OnClickListener() {

                    final ListDiminatiAdapter this$1;
                    private final int val$position;

                    public void onClick(View view)
                    {
                        if (userFunctions.isUserLoggedIn(activity))
                        {
                            pos = position;
                            indexhp = getListModel(position).getId_hp();
                            ponselBaseApp.getObserver().setIndexHp(getListModel(position).getCodename());
                            statusDiminati = "0";
                            statusLikeHpDiminati = "0";
                            namalengkapbgskrg = (new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString();
                            try
                            {
                                finalUrl = (new StringBuilder("idhp=")).append(getListModel(position).getId_hp()).append("&email=").append(username).append("&namalengkap=").append(URLEncoder.encode((new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString(), "utf-8")).append("&status=").append(statusDiminati).append("&t=").append(t).toString();
                            }
                            // Misplaced declaration of an exception variable
                            catch (View view)
                            {
                                view.printStackTrace();
                            }
                            Log.e("finalurl", finalUrl);
                            if (android.os.Build.VERSION.SDK_INT >= 11)
                            {
                                (new ListDiminatiAdapter.PostBagusKurangTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                                return;
                            } else
                            {
                                (new ListDiminatiAdapter.PostBagusKurangTask()).execute(new Void[0]);
                                return;
                            }
                        } else
                        {
                            view = new android.app.AlertDialog.Builder(activity);
                            view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                            view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                                final ListDiminatiAdapter._cls2 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = ListDiminatiAdapter._cls2.this;
                super();
            }
                            });
                            view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                                final ListDiminatiAdapter._cls2 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(activity, com/inponsel/android/v2/RegisterActivity);
                                    activity.startActivityForResult(dialoginterface, 0);
                                    overridePendingTransition(0x7f040003, 0x7f040004);
                                }

            
            {
                this$2 = ListDiminatiAdapter._cls2.this;
                super();
            }
                            });
                            view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                                final ListDiminatiAdapter._cls2 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(activity, com/inponsel/android/v2/LoginActivity);
                                    dialoginterface.putExtra("activity", "main");
                                    activity.startActivityForResult(dialoginterface, 0);
                                    overridePendingTransition(0x7f040003, 0x7f040004);
                                }

            
            {
                this$2 = ListDiminatiAdapter._cls2.this;
                super();
            }
                            });
                            view.show();
                            return;
                        }
                    }


            
            {
                this$1 = final_listdiminatiadapter;
                position = I.this;
                super();
            }
                });
                ((ViewHolder) (viewgroup)).list_lay_kom.setOnClickListener(i. new android.view.View.OnClickListener() {

                    final ListDiminatiAdapter this$1;
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
                this$1 = final_listdiminatiadapter;
                position = I.this;
                super();
            }
                });
                try
                {
                    Picasso.with(activity).load((new StringBuilder(String.valueOf(Util.BASE_PATH_NEWIMAGE))).append(lms.getGambar().trim()).toString()).tag(activity).into(((ViewHolder) (viewgroup)).imageHp, viewgroup. new Callback() {

                        final ListDiminatiAdapter this$1;
                        private final ListDiminatiAdapter.ViewHolder val$holder;

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
                this$1 = final_listdiminatiadapter;
                holder = ListDiminatiAdapter.ViewHolder.this;
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
            Log.e("getUpdateTypeDiminati", ponselBaseApp.getObserver().getUpdateType().toString());
            if (ponselBaseApp.getObserver().getUpdateType().toString().equals("komentar"))
            {
                Log.e("updateViewKomenPonsel", ponselBaseApp.getObserver().getUpdateType().toString());
                updateViewKomenPonsel(ponselBaseApp.getObserver().getIndexHp());
            } else
            if (ponselBaseApp.getObserver().getUpdateType().toString().equals("likedisPonsel"))
            {
                Log.e("updateViewLikeDisPonsel", ponselBaseApp.getObserver().getUpdateType().toString());
                updateViewLikeDisPonsel(ponselBaseApp.getObserver().getIndexHp());
                return;
            }
        }

        public void updateViewKomenPonsel(String s)
        {
            Log.e("ponselBaseApp", s);
        }

        public void updateViewLikeDisPonsel(String s)
        {
            Log.e("ponselBaseApp", s);
        }



        public ListDiminatiAdapter(Activity activity1, int i, ArrayList arraylist)
        {
            this$0 = HomeGadgetActivity.this;
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
            catch (HomeGadgetActivity homegadgetactivity)
            {
                return;
            }
        }
    }

    public class ListDiminatiAdapter.PostBagusKurangTask extends AsyncTask
    {

        final ListDiminatiAdapter this$1;

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
            if (statusLikeHpDiminati.equals("1"))
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
            if (statusLikeHpDiminati.equals("1"))
            {
                notificationLikeHelper.createNotification(namalengkapbgskrg, notificationLikeHelper.likeStatement);
                return;
            } else
            {
                notificationLikeHelper.createNotification(namalengkapbgskrg, notificationLikeHelper.dislikeStatement);
                return;
            }
        }

        public ListDiminatiAdapter.PostBagusKurangTask()
        {
            this$1 = ListDiminatiAdapter.this;
            super();
        }
    }

    class ListDiminatiAdapter.ViewHolder
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
        TextView list_txtBigRight;
        TextView list_txtCodename;
        TextView list_txtHarga;
        TextView list_txtMerek;
        LinearLayout ll_master_item;
        ProgressBar progressbar_item;
        RatingBar ratingDirekomen;
        final ListDiminatiAdapter this$1;
        TextView txtTitleReco1;
        TextView txtTitleReco2;

        ListDiminatiAdapter.ViewHolder()
        {
            this$1 = ListDiminatiAdapter.this;
            super();
        }
    }

    public class ListPencarianAdapter extends BaseAdapter
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
        String statusLikeHpPencarian;
        String statusPencarian;
        String t;
        final HomeGadgetActivity this$0;
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
                if (lms.getUmu_status().equals("3") || hrg_baru.equals("-") || hrg_baru.equals("0"))
                {
                    ((ViewHolder) (viewgroup)).list_txtHarga.setVisibility(4);
                } else
                {
                    ((ViewHolder) (viewgroup)).list_txtHarga.setVisibility(0);
                    ((ViewHolder) (viewgroup)).list_txtHarga.setText((new StringBuilder()).append(hrg_baru).toString());
                }
                ((ViewHolder) (viewgroup)).list_lay_like.setOnClickListener(i. new android.view.View.OnClickListener() {

                    final ListPencarianAdapter this$1;
                    private final int val$position;

                    public void onClick(View view)
                    {
                        if (userFunctions.isUserLoggedIn(activity))
                        {
                            namalengkapbgskrg = (new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString();
                            pos = position;
                            statusPencarian = "1";
                            statusLikeHpPencarian = "1";
                            indexhp = getListModel(position).getId_hp();
                            ponselBaseApp.getObserver().setIndexHp(getListModel(position).getCodename());
                            try
                            {
                                finalUrl = (new StringBuilder("idhp=")).append(getListModel(position).getId_hp()).append("&email=").append(username).append("&namalengkap=").append(URLEncoder.encode((new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString(), "utf-8")).append("&status=").append(statusPencarian).append("&t=").append(t).toString();
                            }
                            // Misplaced declaration of an exception variable
                            catch (View view)
                            {
                                view.printStackTrace();
                            }
                            Log.e("finalurl", finalUrl);
                            if (android.os.Build.VERSION.SDK_INT >= 11)
                            {
                                (new ListPencarianAdapter.PostBagusKurangTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                                return;
                            } else
                            {
                                (new ListPencarianAdapter.PostBagusKurangTask()).execute(new Void[0]);
                                return;
                            }
                        } else
                        {
                            view = new android.app.AlertDialog.Builder(activity);
                            view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                            view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                                final ListPencarianAdapter._cls1 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = ListPencarianAdapter._cls1.this;
                super();
            }
                            });
                            view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                                final ListPencarianAdapter._cls1 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(activity, com/inponsel/android/v2/RegisterActivity);
                                    activity.startActivityForResult(dialoginterface, 0);
                                    overridePendingTransition(0x7f040003, 0x7f040004);
                                }

            
            {
                this$2 = ListPencarianAdapter._cls1.this;
                super();
            }
                            });
                            view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                                final ListPencarianAdapter._cls1 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(activity, com/inponsel/android/v2/LoginActivity);
                                    dialoginterface.putExtra("activity", "main");
                                    activity.startActivityForResult(dialoginterface, 0);
                                    overridePendingTransition(0x7f040003, 0x7f040004);
                                }

            
            {
                this$2 = ListPencarianAdapter._cls1.this;
                super();
            }
                            });
                            view.show();
                            return;
                        }
                    }


            
            {
                this$1 = final_listpencarianadapter;
                position = I.this;
                super();
            }
                });
                ((ViewHolder) (viewgroup)).list_lay_dislike.setOnClickListener(i. new android.view.View.OnClickListener() {

                    final ListPencarianAdapter this$1;
                    private final int val$position;

                    public void onClick(View view)
                    {
                        if (userFunctions.isUserLoggedIn(activity))
                        {
                            pos = position;
                            indexhp = getListModel(position).getId_hp();
                            ponselBaseApp.getObserver().setIndexHp(getListModel(position).getCodename());
                            statusPencarian = "0";
                            statusLikeHpPencarian = "0";
                            namalengkapbgskrg = (new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString();
                            try
                            {
                                finalUrl = (new StringBuilder("idhp=")).append(getListModel(position).getId_hp()).append("&email=").append(username).append("&namalengkap=").append(URLEncoder.encode((new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString(), "utf-8")).append("&status=").append(statusPencarian).append("&t=").append(t).toString();
                            }
                            // Misplaced declaration of an exception variable
                            catch (View view)
                            {
                                view.printStackTrace();
                            }
                            Log.e("finalurl", finalUrl);
                            if (android.os.Build.VERSION.SDK_INT >= 11)
                            {
                                (new ListPencarianAdapter.PostBagusKurangTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                                return;
                            } else
                            {
                                (new ListPencarianAdapter.PostBagusKurangTask()).execute(new Void[0]);
                                return;
                            }
                        } else
                        {
                            view = new android.app.AlertDialog.Builder(activity);
                            view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                            view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                                final ListPencarianAdapter._cls2 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = ListPencarianAdapter._cls2.this;
                super();
            }
                            });
                            view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                                final ListPencarianAdapter._cls2 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(activity, com/inponsel/android/v2/RegisterActivity);
                                    activity.startActivityForResult(dialoginterface, 0);
                                    overridePendingTransition(0x7f040003, 0x7f040004);
                                }

            
            {
                this$2 = ListPencarianAdapter._cls2.this;
                super();
            }
                            });
                            view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                                final ListPencarianAdapter._cls2 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(activity, com/inponsel/android/v2/LoginActivity);
                                    dialoginterface.putExtra("activity", "main");
                                    activity.startActivityForResult(dialoginterface, 0);
                                    overridePendingTransition(0x7f040003, 0x7f040004);
                                }

            
            {
                this$2 = ListPencarianAdapter._cls2.this;
                super();
            }
                            });
                            view.show();
                            return;
                        }
                    }


            
            {
                this$1 = final_listpencarianadapter;
                position = I.this;
                super();
            }
                });
                ((ViewHolder) (viewgroup)).list_lay_kom.setOnClickListener(i. new android.view.View.OnClickListener() {

                    final ListPencarianAdapter this$1;
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
                this$1 = final_listpencarianadapter;
                position = I.this;
                super();
            }
                });
                try
                {
                    Picasso.with(activity).load((new StringBuilder(String.valueOf(Util.BASE_PATH_NEWIMAGE))).append(lms.getGambar().trim()).toString()).tag(activity).into(((ViewHolder) (viewgroup)).imageHp, viewgroup. new Callback() {

                        final ListPencarianAdapter this$1;
                        private final ListPencarianAdapter.ViewHolder val$holder;

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
                this$1 = final_listpencarianadapter;
                holder = ListPencarianAdapter.ViewHolder.this;
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
            Log.e("getUpdateTypePencarian", ponselBaseApp.getObserver().getUpdateType().toString());
            if (ponselBaseApp.getObserver().getUpdateType().toString().equals("komentar"))
            {
                Log.e("updateViewKomenPonsel", ponselBaseApp.getObserver().getUpdateType().toString());
                updateViewKomenPonsel(ponselBaseApp.getObserver().getIndexHp());
            } else
            if (ponselBaseApp.getObserver().getUpdateType().toString().equals("likedisPonsel"))
            {
                Log.e("updateViewLikeDisPonsel", ponselBaseApp.getObserver().getUpdateType().toString());
                updateViewLikeDisPonsel(ponselBaseApp.getObserver().getIndexHp());
                return;
            }
        }

        public void updateViewKomenPonsel(String s)
        {
            Log.e("ponselBaseApp", s);
        }

        public void updateViewLikeDisPonsel(String s)
        {
            Log.e("ponselBaseApp", s);
        }



        public ListPencarianAdapter(Activity activity1, int i, ArrayList arraylist)
        {
            this$0 = HomeGadgetActivity.this;
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
            catch (HomeGadgetActivity homegadgetactivity)
            {
                return;
            }
        }
    }

    public class ListPencarianAdapter.PostBagusKurangTask extends AsyncTask
    {

        final ListPencarianAdapter this$1;

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
            if (statusLikeHpPencarian.equals("1"))
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
            if (statusLikeHpPencarian.equals("1"))
            {
                notificationLikeHelper.createNotification(namalengkapbgskrg, notificationLikeHelper.likeStatement);
                return;
            } else
            {
                notificationLikeHelper.createNotification(namalengkapbgskrg, notificationLikeHelper.dislikeStatement);
                return;
            }
        }

        public ListPencarianAdapter.PostBagusKurangTask()
        {
            this$1 = ListPencarianAdapter.this;
            super();
        }
    }

    class ListPencarianAdapter.ViewHolder
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
        final ListPencarianAdapter this$1;

        ListPencarianAdapter.ViewHolder()
        {
            this$1 = ListPencarianAdapter.this;
            super();
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
        final HomeGadgetActivity this$0;
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
                ((ViewHolder) (viewgroup)).list_txtHarga.setVisibility(8);
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
            this$0 = HomeGadgetActivity.this;
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
            catch (HomeGadgetActivity homegadgetactivity)
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
        final HomeGadgetActivity this$0;
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
                if (lms.getUmu_status().equals("3") || hrg_baru.equals("-") || hrg_baru.equals("0"))
                {
                    ((ViewHolder) (viewgroup)).list_txtHarga.setVisibility(4);
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



        public ListRilisTerbaruAdapter(Activity activity1, int i, ArrayList arraylist)
        {
            this$0 = HomeGadgetActivity.this;
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
            catch (HomeGadgetActivity homegadgetactivity)
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
        final HomeGadgetActivity this$0;
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
                if (i >= listRumor.getChildCount())
                {
                    return;
                }
                Log.e("int i", String.valueOf(i));
                View view = listRumor.getChildAt(i);
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
            if (i >= listRumor.getChildCount())
            {
                return;
            }
            Log.e("int i", String.valueOf(i));
            obj = listRumor.getChildAt(i);
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
            this$0 = HomeGadgetActivity.this;
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
            catch (HomeGadgetActivity homegadgetactivity)
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
        final HomeGadgetActivity this$0;
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
            this$0 = HomeGadgetActivity.this;
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
            catch (HomeGadgetActivity homegadgetactivity)
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

    public class ListTopRateAdapter extends BaseAdapter
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
        final HomeGadgetActivity this$0;
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
                ((ViewHolder) (viewgroup)).list_txtHarga.setVisibility(8);
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

        public ListTopRateAdapter(Activity activity1, int i, ArrayList arraylist)
        {
            this$0 = HomeGadgetActivity.this;
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
            catch (HomeGadgetActivity homegadgetactivity)
            {
                return;
            }
        }
    }

    class ListTopRateAdapter.ViewHolder
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
        final ListTopRateAdapter this$1;

        ListTopRateAdapter.ViewHolder()
        {
            this$1 = ListTopRateAdapter.this;
            super();
        }
    }

    public class NetworkReceiver extends BroadcastReceiver
    {

        final HomeGadgetActivity this$0;

        public void onReceive(Context context, Intent intent)
        {
            context = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
            if ("Wi-Fi".equals(HomeGadgetActivity.sPref) && context != null && context.getType() == 1)
            {
                HomeGadgetActivity.refreshDisplay = true;
                return;
            }
            if (context != null && context.isConnected())
            {
                HomeGadgetActivity.refreshDisplay = true;
                return;
            }
            if ("Any".equals(HomeGadgetActivity.sPref) && context != null)
            {
                HomeGadgetActivity.refreshDisplay = true;
                return;
            } else
            {
                HomeGadgetActivity.refreshDisplay = false;
                showErrorPage();
                return;
            }
        }

        public NetworkReceiver()
        {
            this$0 = HomeGadgetActivity.this;
            super();
        }
    }

    private class PalingHotTask extends AsyncTask
    {

        final HomeGadgetActivity this$0;

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
            txtMorePalingHot.setVisibility(0);
            listPalingHot.setVisibility(0);
            if (palingHotStrStat != null)
            {
                break MISSING_BLOCK_LABEL_87;
            }
            if (palingHotArray.size() == 0)
            {
                txtMorePalingHot.setText("REFRESH");
            }
_L1:
            txtMorePalingHot.getText().toString().toLowerCase().contains("refresh");
            return;
            try
            {
                palingHotAdapter.notifyDataSetChanged();
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
            txtMorePalingHot.setVisibility(8);
        }

        private PalingHotTask()
        {
            this$0 = HomeGadgetActivity.this;
            super();
        }

        PalingHotTask(PalingHotTask palinghottask)
        {
            this();
        }
    }

    private class PendatangTask extends AsyncTask
    {

        final HomeGadgetActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            {
                avoid = (new ServiceHandler()).makeServiceCall(dataPendatang, 1);
                Log.d("Responsependatang: ", dataPendatang);
                Log.e("jsonStr: ", avoid);
                pendatangArray.clear();
                pendatangStrStat = avoid;
                if (avoid == null)
                {
                    break MISSING_BLOCK_LABEL_296;
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
                    break MISSING_BLOCK_LABEL_303;
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_303;
                }
                i = 0;
            }
            if (i >= inponsel.length())
            {
                break MISSING_BLOCK_LABEL_303;
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
            pendatangArray.add(listmodel);
            i++;
            if (true)
            {
                break MISSING_BLOCK_LABEL_83;
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
                break MISSING_BLOCK_LABEL_99;
            }
            if (pendatangArray.size() == 0)
            {
                txtMorePendatang.setText("REFRESH");
            }
_L1:
            txtMorePendatang.getText().toString().toLowerCase().contains("refresh");
            return;
            try
            {
                pendatangAdapter.notifyDataSetChanged();
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
            txtMorePendatang.setVisibility(8);
            progressbar_pendatang.setVisibility(0);
        }

        private PendatangTask()
        {
            this$0 = HomeGadgetActivity.this;
            super();
        }

        PendatangTask(PendatangTask pendatangtask)
        {
            this();
        }
    }

    public class PostBagusKurangTask extends AsyncTask
    {

        final HomeGadgetActivity this$0;

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
                break MISSING_BLOCK_LABEL_146;
            }
            notificationLikeHelper.completed(namalengkapbgskrg, notificationLikeHelper.SucdislikeStatement);
            img_likerandom_ponsel.setEnabled(false);
            img_dislikerandom_ponsel.setEnabled(false);
            if (!statusLikeHp.equals("1"))
            {
                break MISSING_BLOCK_LABEL_131;
            }
            img_likerandom_ponsel.setBackgroundResource(0x7f02020b);
_L1:
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
            try
            {
                img_dislikerandom_ponsel.setBackgroundResource(0x7f0201f2);
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
              goto _L1
            notificationLikeHelper.gagal(namalengkapbgskrg, notificationLikeHelper.gagallikeStatement);
            return;
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            if (statusLikeHp.equals("1"))
            {
                notificationLikeHelper.createNotification(namalengkapbgskrg, notificationLikeHelper.likeStatement);
                return;
            } else
            {
                notificationLikeHelper.createNotification(namalengkapbgskrg, notificationLikeHelper.dislikeStatement);
                return;
            }
        }


        public PostBagusKurangTask()
        {
            this$0 = HomeGadgetActivity.this;
            super();
        }
    }

    private class RilisTask extends AsyncTask
    {

        final HomeGadgetActivity this$0;

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
            progressbar_segmen1.setVisibility(8);
            txtMoreRilis.setVisibility(0);
            progressbar_rilis.setVisibility(8);
            listRilis.setVisibility(0);
            if (rilisStrStat != null)
            {
                break MISSING_BLOCK_LABEL_111;
            }
            if (rilisTerbaruArray.size() == 0)
            {
                txtMoreRilis.setText("REFRESH");
            }
_L1:
            txtMoreRilis.getText().toString().toLowerCase().contains("refresh");
            return;
            try
            {
                rilisTerbaruAdapter.notifyDataSetChanged();
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
            txtMoreRilis.setVisibility(8);
            progressbar_rilis.setVisibility(0);
        }

        private RilisTask()
        {
            this$0 = HomeGadgetActivity.this;
            super();
        }

        RilisTask(RilisTask rilistask)
        {
            this();
        }
    }

    private class RumorTask extends AsyncTask
    {

        final HomeGadgetActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            {
                avoid = (new ServiceHandler()).makeServiceCall(dataRumor, 1);
                rumorArray.clear();
                rumorStrStat = avoid;
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
            rumorArray.add(listmodel);
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
            progressbar_rumor.setVisibility(8);
            txtMoreRumor.setVisibility(0);
            listRumor.setVisibility(0);
            if (rumorStrStat != null)
            {
                break MISSING_BLOCK_LABEL_99;
            }
            if (rumorArray.size() == 0)
            {
                txtMoreRumor.setText("REFRESH");
            }
_L1:
            txtMoreRumor.getText().toString().toLowerCase().contains("refresh");
            return;
            try
            {
                Log.e("notifyDataSetChanged", "yes");
                rumorAdapter.notifyDataSetChanged();
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
            txtMoreRumor.setVisibility(8);
            progressbar_rumor.setVisibility(0);
        }

        private RumorTask()
        {
            this$0 = HomeGadgetActivity.this;
            super();
        }

        RumorTask(RumorTask rumortask)
        {
            this();
        }
    }

    private class SegeraTask extends AsyncTask
    {

        final HomeGadgetActivity this$0;

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
                break MISSING_BLOCK_LABEL_99;
            }
            if (segeraArray.size() == 0)
            {
                txtMoreSegera.setText("REFRESH");
            }
_L1:
            txtMoreSegera.getText().toString().toLowerCase().contains("refresh");
            return;
            try
            {
                segeraAdapter.notifyDataSetChanged();
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
            txtMoreSegera.setVisibility(8);
            progressbar_segera.setVisibility(0);
        }

        private SegeraTask()
        {
            this$0 = HomeGadgetActivity.this;
            super();
        }

        SegeraTask(SegeraTask segeratask)
        {
            this();
        }
    }

    private class TopRateTask extends AsyncTask
    {

        final HomeGadgetActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            avoid = (new ServiceHandler()).makeServiceCall(dataTopRate, 1);
            topRateArray.clear();
            topRateStrStat = avoid;
            if (avoid == null) goto _L2; else goto _L1
_L1:
            avoid = new JSONObject(avoid);
            inponsel = avoid.getJSONArray("InPonsel");
            int i = 0;
_L9:
            if (i < inponsel.length()) goto _L4; else goto _L3
_L4:
            avoid = inponsel.getJSONObject(i);
            if (i != 1) goto _L6; else goto _L5
_L5:
            reco_id_hp = avoid.getString("id_hp");
            reco_model = avoid.getString("model");
            reco_merk = avoid.getString("merk");
            reco_gambar = avoid.getString("gambar");
            reco_codename = avoid.getString("codename");
            reco_hrg_baru = avoid.getString("hrg_baru");
            reco_hrg_bekas = avoid.getString("hrg_bekas");
            reco_likepersen = avoid.getString("likepersen");
            reco_avg_all = avoid.getString("avg_all");
            reco_total_hits = avoid.getString("total_hits");
            reco_total_kom = avoid.getString("total_kom");
            reco_total_like = avoid.getString("total_like");
            reco_total_dislike = avoid.getString("total_dislike");
            reco_total_vote = avoid.getString("total_kom");
              goto _L7
_L6:
            ListModel listmodel = new ListModel();
            listmodel.setId_hp(avoid.getString("id_hp"));
            listmodel.setModel(avoid.getString("model"));
            listmodel.setMerk(avoid.getString("merk"));
            listmodel.setCodename(avoid.getString("codename"));
            listmodel.setGambar(avoid.getString("gambar"));
            listmodel.setUmu_status(avoid.getString("umu_status"));
            listmodel.setHrg_baru(avoid.getString("hrg_baru"));
            listmodel.setHrg_bekas(avoid.getString("hrg_bekas"));
            listmodel.setTotal_like((new StringBuilder(String.valueOf(avoid.getString("likepersen")))).append("%").toString());
            listmodel.setTotal_dislike(avoid.getString("avg_all"));
            listmodel.setTotal_hits(avoid.getString("total_hits"));
            listmodel.setTotal_kom(avoid.getString("total_kom"));
            listmodel.setMy_like_pon(avoid.getString("total_vote"));
            topRateArray.add(listmodel);
              goto _L7
            avoid;
            avoid.printStackTrace();
              goto _L3
            avoid;
            avoid.printStackTrace();
              goto _L3
_L2:
            Log.e("ServiceHandler", "Couldn't get any data from the url");
_L3:
            return null;
_L7:
            i++;
            if (true) goto _L9; else goto _L8
_L8:
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            super.onPostExecute(void1);
            Log.e("topRateArray", (new StringBuilder("topRateArray")).append(String.valueOf(topRateArray.size())).toString());
            progressbar_segmen3.setVisibility(8);
            Picasso.with(HomeGadgetActivity.this).load((new StringBuilder(String.valueOf(Util.BASE_PATH_NEWIMAGE))).append(reco_gambar.trim()).toString()).tag(HomeGadgetActivity.this).into(imgHp_reco, new Callback() {

                final TopRateTask this$1;

                public void onError()
                {
                }

                public void onSuccess()
                {
                    imgHp_reco.setVisibility(0);
                }

            
            {
                this$1 = TopRateTask.this;
                super();
            }
            });
            rl_head_reco.setOnClickListener(new android.view.View.OnClickListener() {

                final TopRateTask this$1;

                public void onClick(View view)
                {
                    view = new Intent(getApplicationContext(), com/inponsel/android/details/DetailsPonsel);
                    view.putExtra("id_hph", reco_id_hp);
                    view.putExtra("namalengkap", (new StringBuilder(String.valueOf(reco_merk))).append(" ").append(reco_model).toString());
                    view.putExtra("codename", reco_codename);
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
                this$1 = TopRateTask.this;
                super();
            }
            });
            txtValueKetertarikan_reco.setText(reco_likepersen);
            txtKetertarikan_reco.setText((new StringBuilder("Ketertariakan\n")).append(reco_total_like).append(" likes, ").append(reco_total_dislike).append(" dislikes").toString());
            txtReview_reco.setText(reco_avg_all);
            txtValueReview_reco.setText((new StringBuilder("Review Pengunjung\n")).append(reco_total_vote).append(" suara").toString());
            circle_ValueKetertarikan_reco.setProgress(Float.parseFloat(reco_likepersen));
            txtNamaLengkap_reco.setText((new StringBuilder(String.valueOf(reco_merk))).append(" ").append(reco_model).toString());
            int i = Math.round(Float.parseFloat(reco_avg_all) * 10F);
            circle_ValueReview_reco.setProgress(i);
            listDirekomendasikan.setVisibility(0);
            if (topRateStrStat == null)
            {
                topRateArray.size();
                return;
            }
            try
            {
                topRateAdapter.notifyDataSetChanged();
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
        }


        private TopRateTask()
        {
            this$0 = HomeGadgetActivity.this;
            super();
        }

        TopRateTask(TopRateTask topratetask)
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
    long ANIM_VIEWPAGER_DELAY;
    int CONNECTION_STAT;
    final int RESULT_SPEECH = 1;
    EditText act_edt_search;
    AlertDialog alertDialog;
    Animation animMove;
    Animation animMove2;
    ArrayList array2ListAds;
    ArrayList arrayListAds;
    String bottom_id;
    LinearLayout bottom_list;
    private BufferedReader breader;
    Button btnLoadMoreKom;
    Button btnLoadMoreNextKom;
    RelativeLayout btnMorePendatang;
    RelativeLayout btnMoreRilis;
    RelativeLayout btnMoreRumor;
    RelativeLayout btnMoreSegera;
    Button btn_doodle_action;
    Button btn_head_banner_refresh;
    Button btn_pop_komen;
    Button btn_pop_login;
    android.app.AlertDialog.Builder builderKomen;
    Calendar c;
    int charCount;
    CircleProgressBar circle_ValueKetertarikan_reco;
    CircleProgressBar circle_ValueReview_reco;
    CircleProgressBar circle_progress_doodle;
    ConnectivityManager cm;
    String codename;
    String codenameKomen;
    int countAllKom;
    int countKomOld;
    CustomPagerAdapter custom2PagerAdapter;
    CustomPagerAdapter customPagerAdapter;
    String dataKomen;
    String dataMaintenance;
    String dataPalingHot;
    String dataPendatang;
    String dataRilis;
    String dataRumor;
    String dataSegera;
    String dataTopRate;
    String datalatestBrand;
    String diminatiStrStat;
    String diminatigetJson;
    DroidWriterEditText edt_pop_komen;
    String email_komentar;
    Bundle extras;
    float final_height;
    float final_width;
    LinearLayout footerView;
    String gambar;
    final Handler handler = new Handler();
    LinearLayout headerView;
    RelativeLayout home_menu_news_tips;
    int hours;
    String hrg_baru;
    String hrg_bekas;
    String id_hp;
    String id_hph;
    String id_hpkom;
    String id_kom;
    String id_news1;
    String idkom_pos;
    ImageView imageMedia;
    ImageView image_news1;
    ImageView imgHpRandom;
    ImageView imgHp_reco;
    LinearLayout imgUserKiri;
    ImageView img_brand;
    ImageView img_dislikerandom_ponsel;
    ImageView img_head_banner;
    ImageView img_kom_picture;
    ImageView img_likerandom_ponsel;
    String img_urlnews1;
    String indexhp;
    JSONArray inponsel;
    boolean isFinish2;
    boolean isFinish3;
    String isikomentar;
    JSONArray jArray;
    JSONObject json;
    String jum_komen;
    String jum_komenLikePonPend;
    String kategori_tag;
    String lastid;
    ListRumorAdapter latestBrandAdapter;
    ArrayList latestBrandArray;
    String latestBrandStrStat;
    LinearLayout lay_pop_komen;
    LinearLayout lay_quote;
    LayoutInflater layoutInflater;
    LinearLayout layout_loading;
    LinearLayout layout_loadingNext;
    LinearLayout layout_pendatang;
    LinearLayout layout_rilis;
    LinearLayout layout_rumor;
    LinearLayout layout_segera;
    int limit;
    GridView listDirekomendasikan;
    ListView listKomen;
    GridView listPalingHot;
    GridView listPendatang;
    public GridView listRilis;
    GridView listRumor;
    GridView listSegera;
    GridView listTerbaruBrand;
    RelativeLayout list_lay_dislike;
    RelativeLayout list_lay_kom;
    RelativeLayout list_lay_like;
    TextView list_txtHargaRandom;
    TextView list_txtMerekRandom;
    LinearLayout ll_recomended;
    LinearLayout ll_segmen_1;
    LinearLayout ll_segmen_2;
    LinearLayout ll_segmen_3;
    LinearLayout ll_segmen_4;
    String lts_brand_idmerk;
    String lts_brand_logo;
    String lts_brand_merk;
    String lts_brand_total;
    String maintenanceMsg;
    String maintenanceStat;
    String merk;
    String message;
    int minutes;
    String model;
    String namalengkap;
    String namalengkapbgskrg;
    int newBmapHeight;
    int newBmapWidth;
    NotificationLikeHelper notificationLikeHelper;
    String oldid;
    DisplayImageOptions optionsDoodle;
    ListSegeraAdapter palingHotAdapter;
    ArrayList palingHotArray;
    String palingHotStrStat;
    ListPendatangAdapter pendatangAdapter;
    ArrayList pendatangArray;
    String pendatangStrStat;
    Picasso picasso;
    ArrayList popKomenArray;
    LinearLayout pop_layout_empty;
    ProgressBar pop_progressbar_middle;
    TextView pop_txtCountKomen;
    TextView pop_txt_empty;
    String populerStrStat;
    String populergetJson;
    int position1;
    int position2;
    int position3;
    int position4;
    int poslike;
    String postMessage;
    String postMessageLikePon;
    String postMessagePendLikePon;
    String postStatus;
    String postStatusLikePon;
    String postStatusPendLikePon;
    CircularProgressBar progressbar_hp_random;
    ProgressBar progressbar_pendatang;
    ProgressBar progressbar_rilis;
    ProgressBar progressbar_rumor;
    ProgressBar progressbar_segera;
    CircularProgressBar progressbar_segmen1;
    CircularProgressBar progressbar_segmen2;
    CircularProgressBar progressbar_segmen3;
    CircularProgressBar progressbar_segmen4;
    CircularProgressBar progressbar_viewpager_2_ads;
    CircularProgressBar progressbar_viewpager_ads;
    CircularProgressBar progressbar_viewpager_head_news;
    CircularProgressBar progressbar_viewpager_tips_news;
    String querylike;
    String querypopkomen;
    String random_background;
    String random_codename;
    String random_harga_hp;
    String random_id_hp;
    String random_img_url;
    String random_like;
    String random_merek_hp;
    String random_umu_status;
    private NetworkReceiver receiver;
    public String reco_avg_all;
    public String reco_codename;
    public String reco_gambar;
    public String reco_hrg_baru;
    public String reco_hrg_bekas;
    public String reco_id_hp;
    public String reco_likepersen;
    public String reco_merk;
    public String reco_model;
    public String reco_total_dislike;
    public String reco_total_hits;
    public String reco_total_kom;
    public String reco_total_like;
    public String reco_total_vote;
    String regexURL;
    String res;
    String reslike;
    String rilisStrStat;
    ListRilisTerbaruAdapter rilisTerbaruAdapter;
    ArrayList rilisTerbaruArray;
    String rilisgetJson;
    RelativeLayout rl_background_random;
    RelativeLayout rl_campaign_text;
    RelativeLayout rl_gadget_KATALOG;
    RelativeLayout rl_gadget_merk;
    RelativeLayout rl_gadget_panduan;
    RelativeLayout rl_gadget_pencarian;
    RelativeLayout rl_gadget_tophits;
    RelativeLayout rl_head_banner;
    RelativeLayout rl_head_reco;
    RelativeLayout rl_hp_random;
    RelativeLayout rl_root_news;
    RelativeLayout rl_slideshow_2_ads;
    RelativeLayout rl_slideshow_ads;
    RelativeLayout rl_slideshow_tips_news;
    ListRumorAdapter rumorAdapter;
    ArrayList rumorArray;
    String rumorStrStat;
    String rumorgetJson;
    int scroll_count;
    String searchcode;
    ListSegeraAdapter segeraAdapter;
    ArrayList segeraArray;
    ArrayList segeraList;
    String segeraStrStat;
    String segeragetJson;
    String statusLikeHp;
    String statuslike;
    boolean stopSliding2Ads;
    boolean stopSlidingAds;
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
    String suc;
    String succesStat;
    ParallaxScrollView sv_root;
    String t;
    String tanggal;
    Timer timer1;
    Timer timer2;
    Timer timer3;
    Timer timer4;
    TimerTask timerTask1;
    TimerTask timerTask2;
    TimerTask timerTask3;
    TimerTask timerTask4;
    String title_news1;
    ListTopRateAdapter topRateAdapter;
    ArrayList topRateArray;
    String topRateStrStat;
    String top_id;
    String tot_LikePon;
    String tot_LikePonPend;
    String tot_dislike;
    String tot_komen;
    String tot_like;
    String totdis_LikePon;
    String totdis_LikePonPend;
    TextView txtBigPENDATANGBARU;
    TextView txtBigRILISTERBARU;
    TextView txtBigRUMOR;
    TextView txtBigSEGERAHADIR;
    TextView txtBigTerbaruBrand;
    TextView txtIdKom;
    TextView txtImgAva;
    TextView txtImgMedia;
    TextView txtKetertarikan_reco;
    TextView txtKomentar;
    TextView txtKomentarQoute;
    TextView txtLikeKom;
    TextView txtMoreJempolInPonsel;
    TextView txtMorePalingHot;
    TextView txtMorePendatang;
    TextView txtMoreRilis;
    TextView txtMoreRumor;
    TextView txtMoreSegera;
    TextView txtMoreTerbaruBrand;
    TextView txtNamaHp;
    TextView txtNamaLengkap_reco;
    TextView txtReview_reco;
    TextView txtTanggapan;
    TextView txtTitle;
    TextView txtTotalKom;
    TextView txtUsername;
    TextView txtUsernameQoute;
    TextView txtValueKetertarikan_reco;
    TextView txtValueReview_reco;
    TextView txtWaktu;
    TextView txtWaktuQoute;
    TextView txt_doodle_subtitle;
    TextView txt_doodle_title;
    TextView txt_home_inponsel;
    TextView txt_judul_news;
    TextView txtdisLikeKom;
    String url2Ads;
    String urlAds;
    String urlKomen;
    String urlKomenHomeTerbaru;
    String urlKomenLast;
    String urlKomenOld;
    String urlRSS;
    String urlSearch;
    String urlTipsNews;
    String userkomen;
    String userpict;
    View viewMenu;
    private AutoScrollViewPager view_pager_2_ads;
    private AutoScrollViewPager view_pager_ads;

    public HomeGadgetActivity()
    {
        statusLikeHp = "";
        strKonekStat = "";
        topRateStrStat = "";
        urlRSS = "";
        pendatangArray = null;
        kategori_tag = "";
        idkom_pos = "";
        rilisTerbaruArray = null;
        segeraArray = null;
        latestBrandArray = null;
        palingHotArray = null;
        topRateArray = null;
        rumorArray = null;
        scroll_count = 1;
        isFinish2 = false;
        isFinish3 = false;
        inponsel = null;
        suc = "";
        lts_brand_idmerk = "";
        lts_brand_merk = "";
        lts_brand_total = "";
        lts_brand_logo = "";
        t = Utility.session(RestClient.pelihara);
        searchcode = "";
        regexURL = "<\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]>";
        oldid = "";
        lastid = "0";
        urlKomen = "";
        urlKomenOld = "";
        urlKomenLast = "";
        countKomOld = 0;
        countAllKom = 0;
        postStatusLikePon = "";
        postMessageLikePon = "";
        postStatus = "";
        postMessage = "";
        limit = 0;
        urlKomenHomeTerbaru = "";
        id_hpkom = "";
        querypopkomen = "";
        indexhp = "";
        c = Calendar.getInstance();
        postStatusPendLikePon = "";
        postMessagePendLikePon = "";
        tot_LikePonPend = "0";
        totdis_LikePonPend = "0";
        jum_komenLikePonPend = "0";
        bottom_id = "";
        top_id = "0";
        jum_komen = "0";
        tot_LikePon = "";
        totdis_LikePon = "";
        succesStat = "";
        CONNECTION_STAT = 10;
        receiver = new NetworkReceiver();
        palingHotStrStat = "";
        str_doodle_width = "1024";
        str_doodle_height = "600";
        arrayListAds = null;
        stopSlidingAds = false;
        array2ListAds = null;
        urlAds = "";
        latestBrandStrStat = "";
        datalatestBrand = "";
        dataPalingHot = "";
        dataTopRate = "";
        stopSliding2Ads = false;
        url2Ads = "";
        stopSlidingTipsNews = false;
        ANIM_VIEWPAGER_DELAY = 5000L;
        urlTipsNews = "";
        position1 = 0;
        position2 = 0;
        position3 = 0;
        position4 = 0;
        reco_gambar = "";
    }

    private void GetInboxGroupList()
    {
        t = Utility.session(t);
        t = Utility.session(t);
        MyObjectRequest myobjectrequest = new MyObjectRequest((new StringBuilder(String.valueOf(Util.BASE_PATH_MSG))).append("list_chat_group").append(Utility.BASE_FORMAT).append("?").append("id_user=").append(user_id).append("&t=").append(t).toString(), new com.android.volley.Response.Listener() {

            final HomeGadgetActivity this$0;

            public volatile void onResponse(Object obj)
            {
                onResponse((JSONObject)obj);
            }

            public void onResponse(JSONObject jsonobject)
            {
                parseJSONGroupChat(jsonobject.toString());
                ponselBaseApp.getObserver().setLoginStat("1");
            }

            
            {
                this$0 = HomeGadgetActivity.this;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final HomeGadgetActivity this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
            }

            
            {
                this$0 = HomeGadgetActivity.this;
                super();
            }
        }, "test", "test");
        PonselBaseApp.getInstance().addToRequestQueue(myobjectrequest, "tag_json_obj");
    }

    private void loadPage()
    {
        if (sPref.equals("Any") || wifiConnected || mobileConnected || sPref.equals("Wi-Fi") || wifiConnected)
        {
            Log.e("networkStateReceiver", "isOnline");
            if (pendatangArray.size() <= 0)
            {
                startTask();
            }
            return;
        } else
        {
            showErrorPage();
            return;
        }
    }

    private void load_image_doodle()
    {
        try
        {
            ImageLoader.getInstance().displayImage(str_doodle_img, img_head_banner, optionsDoodle, new SimpleImageLoadingListener() {

                final HomeGadgetActivity this$0;

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

                        final _cls48 this$1;

                        public void onClick(View view)
                        {
                            load_image_doodle();
                        }

            
            {
                this$1 = _cls48.this;
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
                this$0 = HomeGadgetActivity.this;
                super();
            }
            }, new ImageLoadingProgressListener() {

                final HomeGadgetActivity this$0;

                public void onProgressUpdate(String s, View view, int i, int j)
                {
                    circle_progress_doodle.setProgress(Math.round((100F * (float)i) / (float)j));
                }

            
            {
                this$0 = HomeGadgetActivity.this;
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
        (new AsyncHttpClient()).get((new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("home_random_hp").append(Utility.BASE_FORMAT).append("?t=").append(t).append("&id_user=").append(user_id).toString(), new AsyncHttpResponseHandler() {

            final HomeGadgetActivity this$0;

            public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
            {
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
                aheader = (new JSONObject(aheader)).getJSONArray("InPonsel");
                i = 0;
_L3:
                if (i < 1) goto _L2; else goto _L1
_L1:
                rl_hp_random.setVisibility(0);
                rl_background_random.setBackgroundColor(Color.parseColor(random_background));
                list_txtMerekRandom.setText(random_merek_hp);
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

                    final _cls43 this$1;

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
                this$1 = _cls43.this;
                super();
            }
                });
                Picasso.with(HomeGadgetActivity.this).load(random_img_url.trim()).tag(this).into(imgHpRandom, new Callback() {

                    final _cls43 this$1;

                    public void onError()
                    {
                        progressbar_hp_random.setVisibility(8);
                    }

                    public void onSuccess()
                    {
                        progressbar_hp_random.setVisibility(8);
                    }

            
            {
                this$1 = _cls43.this;
                super();
            }
                });
                img_likerandom_ponsel.setEnabled(true);
                img_dislikerandom_ponsel.setEnabled(true);
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
                this$0 = HomeGadgetActivity.this;
                super();
            }
        });
    }

    private void load_segmen_1()
    {
        Log.e("load", "segmen 1");
        progressbar_segmen1.setVisibility(0);
        if (pendatangArray.size() == 0)
        {
            PendatangTask();
        }
        ll_segmen_1.setVisibility(0);
        sendRequestAds();
        if (rilisTerbaruArray.size() == 0)
        {
            RilisTask();
        }
        scroll_count = scroll_count + 1;
    }

    private void load_segmen_2()
    {
        progressbar_segmen3.setVisibility(8);
        Log.e("load", "segmen 2");
        (new Handler()).postDelayed(new Runnable() {

            final HomeGadgetActivity this$0;

            public void run()
            {
                sv_root.scrollBy(0, 100);
                load_random_hp();
                if (segeraArray.size() == 0)
                {
                    SegeraTask();
                }
                ll_segmen_2.setVisibility(0);
                if (latestBrandArray.size() == 0)
                {
                    LatestBrandTask();
                }
                isFinish2 = true;
            }

            
            {
                this$0 = HomeGadgetActivity.this;
                super();
            }
        }, 1000L);
    }

    private void load_segmen_3()
    {
        (new Handler()).postDelayed(new Runnable() {

            final HomeGadgetActivity this$0;

            public void run()
            {
                sv_root.scrollBy(0, 100);
                Log.e("load", "segmen 3");
                if (rumorArray.size() == 0)
                {
                    RumorTask();
                }
                ll_segmen_3.setVisibility(0);
                sendRequestTipsNews();
                if (palingHotArray.size() == 0)
                {
                    PalingHotTask();
                }
                if (topRateArray.size() == 0)
                {
                    TopRateTask();
                }
                txt_home_inponsel.setVisibility(0);
            }

            
            {
                this$0 = HomeGadgetActivity.this;
                super();
            }
        }, 1000L);
    }

    private void sendRequest2Ads()
    {
        url2Ads = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("list_ads_home").append(Utility.BASE_FORMAT).append("?hal=46").append("&pver=").append(SplashScreen.curVersion).append("&t=").append(t).append("&idusr=").append(user_id).append("&tag=tagall").toString();
        AsyncHttpClient asynchttpclient = new AsyncHttpClient();
        asynchttpclient.setMaxRetriesAndTimeout(5, 10000);
        asynchttpclient.get(url2Ads, new AsyncHttpResponseHandler() {

            final HomeGadgetActivity this$0;

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
                aheader = (new JSONObject(aheader)).getJSONArray("InPonsel");
                i = 0;
_L3:
                int j = aheader.length();
                if (i < j) goto _L2; else goto _L1
_L1:
                Log.e("array2ListAds", String.valueOf(array2ListAds.size()));
                custom2PagerAdapter.notifyDataSetChanged();
                return;
_L2:
                abyte0 = aheader.getJSONObject(i);
                ListModel listmodel = new ListModel();
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
                array2ListAds.add(listmodel);
                i++;
                  goto _L3
                aheader;
                aheader.printStackTrace();
                  goto _L1
            }

            
            {
                this$0 = HomeGadgetActivity.this;
                super();
            }
        });
    }

    private void sendRequestAds()
    {
        urlAds = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("list_ads_home").append(Utility.BASE_FORMAT).append("?hal=46").append("&pver=").append(SplashScreen.curVersion).append("&t=").append(t).append("&idusr=").append(user_id).append("&tag=tagall").toString();
        AsyncHttpClient asynchttpclient = new AsyncHttpClient();
        asynchttpclient.setMaxRetriesAndTimeout(5, 10000);
        asynchttpclient.get(urlAds, new AsyncHttpResponseHandler() {

            final HomeGadgetActivity this$0;

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
                aheader = (new JSONObject(aheader)).getJSONArray("InPonsel");
                i = 0;
_L3:
                int j = aheader.length();
                if (i < j) goto _L2; else goto _L1
_L1:
                Log.e("arrayListAds", String.valueOf(arrayListAds.size()));
                customPagerAdapter.notifyDataSetChanged();
                return;
_L2:
                abyte0 = aheader.getJSONObject(i);
                ListModel listmodel = new ListModel();
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
                  goto _L3
                aheader;
                aheader.printStackTrace();
                  goto _L1
            }

            
            {
                this$0 = HomeGadgetActivity.this;
                super();
            }
        });
    }

    private void sendRequestTipsNews()
    {
        urlTipsNews = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rss_tips_month").append(Utility.BASE_FORMAT).append("?lmt=0&t=").append(t).append("&idusr=").append(user_id).append("&tag=firmware").toString();
        Log.e("urlTipsNews", urlTipsNews);
        AsyncHttpClient asynchttpclient = new AsyncHttpClient();
        asynchttpclient.setMaxRetriesAndTimeout(5, 10000);
        asynchttpclient.get(urlTipsNews, new AsyncHttpResponseHandler() {

            final HomeGadgetActivity this$0;

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
                Picasso.with(HomeGadgetActivity.this).load(img_urlnews1).into(image_news1, new Callback() {

                    final _cls47 this$1;

                    public void onError()
                    {
                        image_news1.setImageResource(0x7f020209);
                    }

                    public void onSuccess()
                    {
                        progressbar_viewpager_tips_news.setVisibility(8);
                    }

            
            {
                this$1 = _cls47.this;
                super();
            }
                });
                image_news1.setOnClickListener(new android.view.View.OnClickListener() {

                    final _cls47 this$1;

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
                this$1 = _cls47.this;
                super();
            }
                });
            }


            
            {
                this$0 = HomeGadgetActivity.this;
                super();
            }
        });
    }

    private void showErrorPage()
    {
        Log.e("networkStateReceiver", "false");
        progressbar_pendatang.setVisibility(8);
        progressbar_rilis.setVisibility(8);
        progressbar_segera.setVisibility(8);
        progressbar_rumor.setVisibility(8);
    }

    private void startTask()
    {
        Log.e("task", "start");
        dataPendatang = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("home_penbaru").append(Utility.BASE_FORMAT).append("?idusr=").append(user_id).append("&lmt=0&t=").append(t).toString();
        dataRilis = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("home_rilis").append(Utility.BASE_FORMAT).append("?idusr=").append(user_id).append("&lmt=0&t=").append(t).toString();
        dataSegera = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("home_segera").append(Utility.BASE_FORMAT).append("?idusr=").append(user_id).append("&lmt=0&t=").append(t).toString();
        datalatestBrand = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("gadget_latest_brand").append(Utility.BASE_FORMAT).append("?idusr=").append(user_id).append("&lmt=0&t=").append(t).toString();
        dataPalingHot = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("gadget_most_comment").append(Utility.BASE_FORMAT).append("?idusr=").append(user_id).append("&lmt=0&t=").append(t).toString();
        dataTopRate = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("gadget_recomended").append(Utility.BASE_FORMAT).append("?idusr=").append(user_id).append("&lmt=0&t=").append(t).toString();
        dataRumor = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("home_rumor").append(Utility.BASE_FORMAT).append("?idusr=").append(user_id).append("&lmt=0&t=").append(t).toString();
        urlRSS = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rss_reader_home").append(Utility.BASE_FORMAT).append("?").append("lmt=").append(limit).append("&t=").append(t).append("&idusr=").append(user_id).append("&tag=").toString();
        urlKomenHomeTerbaru = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("home_komenall_baru").append(Utility.BASE_FORMAT).append("?lmt=0&t=").append(t).append("&idusr=").append(user_id).toString();
        Log.e("dataTopRate", dataTopRate);
        Log.e("headlineRss", "start");
        Log.e("hitsTask", String.valueOf(hours + minutes));
        home_menu_news_tips.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeGadgetActivity this$0;

            public void onClick(View view)
            {
                view = new Intent(HomeGadgetActivity.this, com/inponsel/android/v2/RSSFeedByTag);
                view.putExtra("tag_code", "0");
                view.putExtra("kategori_tag", "Firmware");
                view.putExtra("tag_key", "gn:firmware");
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = HomeGadgetActivity.this;
                super();
            }
        });
        load_segmen_1();
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

    public void RumorTask()
    {
        RumorTask rumortask = new RumorTask(null);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            rumortask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            rumortask.execute(new Void[0]);
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

    public void TopRateTask()
    {
        TopRateTask topratetask = new TopRateTask(null);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            topratetask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            topratetask.execute(new Void[0]);
            return;
        }
    }

    public boolean checkURL(String s)
    {
        return s.matches(regexURL);
    }

    public void endScroll()
    {
        if (scroll_count == 2)
        {
            progressbar_segmen2.setVisibility(0);
            load_segmen_2();
            scroll_count = scroll_count + 1;
        } else
        if (scroll_count == 3 && isFinish2)
        {
            progressbar_segmen3.setVisibility(0);
            load_segmen_3();
            scroll_count = scroll_count + 1;
            return;
        }
    }

    public String getJSONFile(String s)
        throws Exception
    {
        File file = new File(Environment.getExternalStorageDirectory(), (new StringBuilder("/Android/data/")).append(getPackageName()).append("/cache/").append(s).toString());
        s = new StringBuilder();
        breader = new BufferedReader(new FileReader(file));
        do
        {
            String s1 = breader.readLine();
            if (s1 == null)
            {
                EncodeDecodeAES.decrypt(RestClient.pelihara, String.valueOf(s));
                return EncodeDecodeAES.decrypt(RestClient.pelihara, String.valueOf(s));
            }
            s.append(s1);
            s.append('\n');
        } while (true);
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

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        Utility.session(Utility.session(Utility.session(RestClient.pelihara)));
        i;
        JVM INSTR tableswitch 1 1: default 40
    //                   1 41;
           goto _L1 _L2
_L1:
        return;
_L2:
        if (j == -1 && intent != null)
        {
            intent = intent.getStringArrayListExtra("android.speech.extra.RESULTS");
            act_edt_search.setText((CharSequence)intent.get(0));
            Log.e("urlSearch", "search");
            if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected())
            {
                if (act_edt_search.getText().toString().trim().equals(""))
                {
                    Log.e("urlSearch", "kosong");
                    return;
                }
                try
                {
                    urlSearch = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("home_search").append(Utility.BASE_FORMAT).append("?key=").append(URLEncoder.encode(act_edt_search.getText().toString(), "utf-8")).append("&lmt=0&t=").append(searchcode).append("&idusr=").append(user_id).toString();
                }
                // Misplaced declaration of an exception variable
                catch (Intent intent)
                {
                    intent.printStackTrace();
                }
                Log.e("urlSearch", urlSearch);
                return;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
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
            finish();
            return;
        }
    }

    public void onClick(View view)
    {
        if (view != btnMorePendatang) goto _L2; else goto _L1
_L1:
        btnMorePendatang.playSoundEffect(0);
        if (!txtMorePendatang.getText().toString().toLowerCase().contains("refresh")) goto _L4; else goto _L3
_L3:
        PendatangTask();
_L6:
        return;
_L4:
        (new Handler()).postDelayed(new Runnable() {

            final HomeGadgetActivity this$0;

            public void run()
            {
                Intent intent = new Intent(getApplicationContext(), com/inponsel/android/v2/HomeSelengkapActivity);
                intent.putExtra("status", "pendatang");
                startActivityForResult(intent, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = HomeGadgetActivity.this;
                super();
            }
        }, 250L);
        return;
_L2:
        if (view == btnMoreRilis)
        {
            btnMoreRilis.playSoundEffect(0);
            if (txtMoreRilis.getText().toString().toLowerCase().contains("refresh"))
            {
                RilisTask();
                return;
            } else
            {
                (new Handler()).postDelayed(new Runnable() {

                    final HomeGadgetActivity this$0;

                    public void run()
                    {
                        Intent intent = new Intent(getApplicationContext(), com/inponsel/android/v2/HomeSelengkapActivity);
                        intent.putExtra("status", "rilis");
                        startActivityForResult(intent, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$0 = HomeGadgetActivity.this;
                super();
            }
                }, 250L);
                return;
            }
        }
        if (view == btnMoreSegera)
        {
            btnMoreSegera.playSoundEffect(0);
            if (txtMoreSegera.getText().toString().toLowerCase().contains("refresh"))
            {
                SegeraTask();
                return;
            } else
            {
                (new Handler()).postDelayed(new Runnable() {

                    final HomeGadgetActivity this$0;

                    public void run()
                    {
                        Intent intent = new Intent(getApplicationContext(), com/inponsel/android/v2/HomeSelengkapActivity);
                        intent.putExtra("status", "segera");
                        startActivityForResult(intent, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$0 = HomeGadgetActivity.this;
                super();
            }
                }, 250L);
                return;
            }
        }
        if (view == btnMoreRumor)
        {
            btnMoreRumor.playSoundEffect(0);
            if (txtMoreRumor.getText().toString().toLowerCase().contains("refresh"))
            {
                RumorTask();
                return;
            } else
            {
                (new Handler()).postDelayed(new Runnable() {

                    final HomeGadgetActivity this$0;

                    public void run()
                    {
                        Intent intent = new Intent(getApplicationContext(), com/inponsel/android/v2/HomeSelengkapActivity);
                        intent.putExtra("status", "rumor");
                        startActivityForResult(intent, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$0 = HomeGadgetActivity.this;
                super();
            }
                }, 250L);
                return;
            }
        }
        if (view == menu_katalog)
        {
            mDrawerLayout.closeDrawers();
            (new Handler()).postDelayed(new Runnable() {

                final HomeGadgetActivity this$0;

                public void run()
                {
                    i = new Intent(getApplicationContext(), com/inponsel/android/v2/MerekActivity);
                    startActivityForResult(i, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$0 = HomeGadgetActivity.this;
                super();
            }
            }, 250L);
            return;
        }
        if (view == menu_Berita)
        {
            mDrawerLayout.closeDrawers();
            (new Handler()).postDelayed(new Runnable() {

                final HomeGadgetActivity this$0;

                public void run()
                {
                    i = new Intent(getApplicationContext(), com/inponsel/android/rsstab/RSSTimelineActivity);
                    i.putExtra("tag_timeline", "terbaru");
                    i.putExtra("tag_code", "tagall");
                    i.putExtra("tag_page", "1");
                    startActivityForResult(i, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$0 = HomeGadgetActivity.this;
                super();
            }
            }, 250L);
            return;
        }
        if (view == menu_PusatLayanan)
        {
            mDrawerLayout.closeDrawers();
            (new Handler()).postDelayed(new Runnable() {

                final HomeGadgetActivity this$0;

                public void run()
                {
                    i = new Intent(getApplicationContext(), com/inponsel/android/v2/SCUserActivity);
                    startActivityForResult(i, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$0 = HomeGadgetActivity.this;
                super();
            }
            }, 250L);
            return;
        }
        if (view == menu_LoginRegister)
        {
            mDrawerLayout.closeDrawers();
            (new Handler()).postDelayed(new Runnable() {

                final HomeGadgetActivity this$0;

                public void run()
                {
                    i = new Intent(getApplicationContext(), com/inponsel/android/v2/LoginActivity);
                    i.putExtra("activity", "main");
                    startActivityForResult(i, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$0 = HomeGadgetActivity.this;
                super();
            }
            }, 250L);
            return;
        }
        if (view == menu_Bookmark)
        {
            mDrawerLayout.closeDrawers();
            (new Handler()).postDelayed(new Runnable() {

                final HomeGadgetActivity this$0;

                public void run()
                {
                    i = new Intent(getApplicationContext(), com/inponsel/android/favorit/FavoritPonselMerek);
                    startActivityForResult(i, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$0 = HomeGadgetActivity.this;
                super();
            }
            }, 250L);
            return;
        }
        if (view == menu_Setting)
        {
            mDrawerLayout.closeDrawers();
            (new Handler()).postDelayed(new Runnable() {

                final HomeGadgetActivity this$0;

                public void run()
                {
                    i = new Intent(getApplicationContext(), com/inponsel/android/v2/PengaturanActivity);
                    startActivityForResult(i, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$0 = HomeGadgetActivity.this;
                super();
            }
            }, 250L);
            return;
        }
        if (view == menu_FAQ)
        {
            mDrawerLayout.closeDrawers();
            (new Handler()).postDelayed(new Runnable() {

                final HomeGadgetActivity this$0;

                public void run()
                {
                    i = new Intent(getApplicationContext(), com/inponsel/android/v2/FAQActivity);
                    startActivityForResult(i, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$0 = HomeGadgetActivity.this;
                super();
            }
            }, 250L);
            return;
        }
        if (view == menu_KebijakanPrivasi)
        {
            mDrawerLayout.closeDrawers();
            (new Handler()).postDelayed(new Runnable() {

                final HomeGadgetActivity this$0;

                public void run()
                {
                    i = new Intent(getApplicationContext(), com/inponsel/android/v2/KebijakanActivity);
                    startActivityForResult(i, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$0 = HomeGadgetActivity.this;
                super();
            }
            }, 250L);
            return;
        }
        if (view == menu_Persyaratan)
        {
            mDrawerLayout.closeDrawers();
            (new Handler()).postDelayed(new Runnable() {

                final HomeGadgetActivity this$0;

                public void run()
                {
                    i = new Intent(getApplicationContext(), com/inponsel/android/v2/PersyaratanActivity);
                    startActivityForResult(i, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$0 = HomeGadgetActivity.this;
                super();
            }
            }, 250L);
            return;
        }
        if (view == menu_Tentang)
        {
            mDrawerLayout.closeDrawers();
            (new Handler()).postDelayed(new Runnable() {

                final HomeGadgetActivity this$0;

                public void run()
                {
                    i = new Intent(getApplicationContext(), com/inponsel/android/v2/TentangActivity);
                    startActivityForResult(i, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$0 = HomeGadgetActivity.this;
                super();
            }
            }, 250L);
            return;
        }
        if (view == menu_profil)
        {
            mDrawerLayout.closeDrawers();
            (new Handler()).postDelayed(new Runnable() {

                final HomeGadgetActivity this$0;

                public void run()
                {
                    i = new Intent(getApplicationContext(), com/inponsel/android/v2/ProfileActivity);
                    startActivityForResult(i, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$0 = HomeGadgetActivity.this;
                super();
            }
            }, 250L);
            return;
        }
        if (view == menu_GroupChat)
        {
            mDrawerLayout.closeDrawers();
            (new Handler()).postDelayed(new Runnable() {

                final HomeGadgetActivity this$0;

                public void run()
                {
                    i = new Intent(getApplicationContext(), com/inponsel/android/v2/RoomGroupChatListActivity);
                    startActivityForResult(i, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$0 = HomeGadgetActivity.this;
                super();
            }
            }, 250L);
            return;
        }
        if (view == menu_pesan)
        {
            mDrawerLayout.closeDrawers();
            (new Handler()).postDelayed(new Runnable() {

                final HomeGadgetActivity this$0;

                public void run()
                {
                    i = new Intent(getApplicationContext(), com/inponsel/android/v2/InboxMessageActivity);
                    startActivityForResult(i, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$0 = HomeGadgetActivity.this;
                super();
            }
            }, 250L);
            return;
        }
        if (view == menu_beranda)
        {
            i = new Intent(getApplicationContext(), com/inponsel/android/v2/HomeGadgetActivity);
            i.addFlags(0x4000000);
            startActivityForResult(i, 0);
            overridePendingTransition(0x7f040003, 0x7f040004);
            finish();
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        mDrawerToggle.onConfigurationChanged(configuration);
        getSupportActionBar().setTitle(Html.fromHtml((new StringBuilder("<font color='#FFFFFF'>")).append(getString(0x7f0c0035)).append("</font>").toString()));
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f030130, null, false);
        mDrawerLayout.addView(bundle, 0);
        bundle = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        receiver = new NetworkReceiver();
        registerReceiver(receiver, bundle);
        ponselBaseApp = (PonselBaseApp)getApplication();
        ponselBaseApp.getObserver().addObserver(this);
        t = Utility.session(t);
        DisplayMetrics displaymetrics;
        int i;
        int j;
        try
        {
            bundle = ((PonselBaseApp)getApplication()).getTracker(com.inponsel.android.adapter.PonselBaseApp.TrackerName.APP_TRACKER);
            bundle.setScreenName("Halaman Gadget");
            bundle.send((new com.google.android.gms.analytics.HitBuilders.AppViewBuilder()).build());
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        hours = c.get(11);
        minutes = c.get(12);
        cm = (ConnectivityManager)getSystemService("connectivity");
        t = Utility.session(t);
        searchcode = t;
        getSherlock().setProgressBarIndeterminateVisibility(false);
        getSherlock().setProgressBarVisibility(false);
        actionBar = getSupportActionBar();
        actionBar.setDisplayUseLogoEnabled(useLogo);
        actionBar.setBackgroundDrawable(getResources().getDrawable(0x7f0200e5));
        j = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        i = j;
        if (j == 0)
        {
            i = 0x7f0b0037;
        }
        bundle = (TextView)findViewById(i);
        bundle.setTextColor(Color.parseColor("#FFFFFF"));
        bundle.setSelected(true);
        bundle.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        bundle.setTypeface(Typeface.SANS_SERIF);
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFFFFF'>Gadget</font>"));
        notificationLikeHelper = new NotificationLikeHelper(this);
        extras = getIntent().getExtras();
        bundle = ((WindowManager)getSystemService("window")).getDefaultDisplay();
        displaymetrics = new DisplayMetrics();
        bundle.getMetrics(displaymetrics);
        (new android.widget.FrameLayout.LayoutParams(displaymetrics.widthPixels - (int)Utility.convertDpToPixel(50F, this), (int)Utility.convertDpToPixel(200F, this))).gravity = 1;
        txtUnreadCount = (TextView)findViewById(0x7f0b0423);
        txtUnreadGroupChat = (TextView)findViewById(0x7f0b0427);
        txtUnreadCount.setVisibility(8);
        txtUnreadGroupChat.setVisibility(8);
        picasso = Picasso.with(this);
        optionsDoodle = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showImageOnLoading(0x7f02033f).showImageForEmptyUri(0x7f020209).cacheInMemory(true).cacheOnDisk(true).considerExifParams(true).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).build();
        circle_progress_doodle = (CircleProgressBar)findViewById(0x7f0b08a1);
        btn_head_banner_refresh = (Button)findViewById(0x7f0b08a0);
        animMove = AnimationUtils.loadAnimation(getApplicationContext(), 0x7f040014);
        animMove2 = AnimationUtils.loadAnimation(getApplicationContext(), 0x7f040015);
        animMove.setAnimationListener(this);
        animMove2.setAnimationListener(this);
        rl_gadget_tophits = (RelativeLayout)findViewById(0x7f0b08cf);
        rl_gadget_KATALOG = (RelativeLayout)findViewById(0x7f0b08d0);
        rl_gadget_panduan = (RelativeLayout)findViewById(0x7f0b08d1);
        rl_gadget_pencarian = (RelativeLayout)findViewById(0x7f0b08d2);
        txt_home_inponsel = (TextView)findViewById(0x7f0b0219);
        bundle = Calendar.getInstance();
        txt_home_inponsel.setText((new StringBuilder("InPonsel @ ")).append(bundle.get(1)).toString());
        txt_home_inponsel.setVisibility(8);
        rl_head_banner = (RelativeLayout)findViewById(0x7f0b089f);
        rl_campaign_text = (RelativeLayout)findViewById(0x7f0b08a2);
        img_head_banner = (ImageView)findViewById(0x7f0b04ca);
        txt_doodle_title = (TextView)findViewById(0x7f0b08a4);
        txt_doodle_subtitle = (TextView)findViewById(0x7f0b08a5);
        btn_doodle_action = (Button)findViewById(0x7f0b08a3);
        txtMorePalingHot = (TextView)findViewById(0x7f0b025f);
        txtBigTerbaruBrand = (TextView)findViewById(0x7f0b0253);
        txtMoreTerbaruBrand = (TextView)findViewById(0x7f0b0255);
        rl_gadget_merk = (RelativeLayout)findViewById(0x7f0b0258);
        img_brand = (ImageView)findViewById(0x7f0b0256);
        progressbar_segmen1 = (CircularProgressBar)findViewById(0x7f0b08ab);
        progressbar_segmen2 = (CircularProgressBar)findViewById(0x7f0b08b9);
        progressbar_segmen3 = (CircularProgressBar)findViewById(0x7f0b08d4);
        ll_recomended = (LinearLayout)findViewById(0x7f0b08d5);
        rl_head_reco = (RelativeLayout)findViewById(0x7f0b08d6);
        imgHp_reco = (ImageView)findViewById(0x7f0b08d8);
        circle_ValueKetertarikan_reco = (CircleProgressBar)findViewById(0x7f0b08da);
        circle_ValueReview_reco = (CircleProgressBar)findViewById(0x7f0b08dd);
        txtValueKetertarikan_reco = (TextView)findViewById(0x7f0b08db);
        txtNamaLengkap_reco = (TextView)findViewById(0x7f0b08d9);
        txtKetertarikan_reco = (TextView)findViewById(0x7f0b08dc);
        txtReview_reco = (TextView)findViewById(0x7f0b08de);
        txtValueReview_reco = (TextView)findViewById(0x7f0b08df);
        ll_segmen_1 = (LinearLayout)findViewById(0x7f0b021a);
        ll_segmen_2 = (LinearLayout)findViewById(0x7f0b0233);
        ll_segmen_3 = (LinearLayout)findViewById(0x7f0b0250);
        ll_segmen_1.setVisibility(8);
        ll_segmen_2.setVisibility(8);
        ll_segmen_3.setVisibility(8);
        progressbar_segmen1.setVisibility(8);
        progressbar_segmen2.setVisibility(8);
        progressbar_segmen3.setVisibility(8);
        sv_root = (ParallaxScrollView)findViewById(0x7f0b089e);
        sv_root.setScrollViewListener(this);
        bundle = ((WindowManager)getSystemService("window")).getDefaultDisplay();
        displaymetrics = new DisplayMetrics();
        bundle.getMetrics(displaymetrics);
        i = displaymetrics.widthPixels;
        j = displaymetrics.heightPixels;
        img_head_banner.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(i, Math.min((int)(((double)i / (double)Integer.parseInt(str_doodle_width)) * (double)Integer.parseInt(str_doodle_height)), j / 3)));
        arrayListAds = new ArrayList();
        view_pager_ads = (AutoScrollViewPager)findViewById(0x7f0b01f8);
        view_pager_ads.setOffscreenPageLimit(5);
        customPagerAdapter = new CustomPagerAdapter(this, arrayListAds, view_pager_ads, sv_root);
        view_pager_ads.setAdapter(customPagerAdapter);
        view_pager_ads.setInterval(5000L);
        view_pager_ads.startAutoScroll();
        rl_slideshow_ads = (RelativeLayout)findViewById(0x7f0b01f6);
        progressbar_viewpager_ads = (CircularProgressBar)findViewById(0x7f0b01f7);
        array2ListAds = new ArrayList();
        view_pager_2_ads = (AutoScrollViewPager)findViewById(0x7f0b08c2);
        view_pager_2_ads.setOffscreenPageLimit(5);
        custom2PagerAdapter = new CustomPagerAdapter(this, array2ListAds, view_pager_2_ads, sv_root);
        view_pager_2_ads.setAdapter(custom2PagerAdapter);
        view_pager_2_ads.setInterval(5000L);
        view_pager_2_ads.startAutoScroll();
        rl_slideshow_2_ads = (RelativeLayout)findViewById(0x7f0b08c0);
        progressbar_viewpager_2_ads = (CircularProgressBar)findViewById(0x7f0b08c1);
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
                } else
                {
                    txtUnreadCount.setText(bundle);
                    txtUnreadCount.setVisibility(0);
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
                } else
                {
                    txtUnreadCount.setText(bundle);
                    txtUnreadCount.setVisibility(0);
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
                } else
                {
                    txtUnreadGroupChat.setText(bundle);
                    txtUnreadGroupChat.setVisibility(0);
                }
            } else
            {
                bundle = getApplicationContext().getSharedPreferences("UnreadGroup", 0).getString("unread_group", null);
                if (bundle.equals("0") || bundle.equals(""))
                {
                    txtUnreadGroupChat.setVisibility(8);
                    txtUnreadGroupChat.setText("0");
                } else
                {
                    txtUnreadGroupChat.setText(bundle);
                    txtUnreadGroupChat.setVisibility(0);
                }
            }
            txtUnreadCount.getText().toString().equals("0");
        }
        layout_pendatang = (LinearLayout)findViewById(0x7f0b0221);
        layout_rilis = (LinearLayout)findViewById(0x7f0b0234);
        layout_segera = (LinearLayout)findViewById(0x7f0b024a);
        layout_rumor = (LinearLayout)findViewById(0x7f0b02b0);
        listTerbaruBrand = (GridView)findViewById(0x7f0b0257);
        listPalingHot = (GridView)findViewById(0x7f0b0260);
        listDirekomendasikan = (GridView)findViewById(0x7f0b08e0);
        listPendatang = (GridView)findViewById(0x7f0b0226);
        listPendatang.setOnScrollListener(new SampleScrollListener(this));
        btnMorePendatang = (RelativeLayout)findViewById(0x7f0b0222);
        progressbar_pendatang = (ProgressBar)findViewById(0x7f0b0224);
        txtBigPENDATANGBARU = (TextView)findViewById(0x7f0b0223);
        txtMorePendatang = (TextView)findViewById(0x7f0b0225);
        txtMoreRilis = (TextView)findViewById(0x7f0b0238);
        txtMoreSegera = (TextView)findViewById(0x7f0b024e);
        txtMoreRumor = (TextView)findViewById(0x7f0b02b4);
        txtBigRILISTERBARU = (TextView)findViewById(0x7f0b0236);
        txtBigSEGERAHADIR = (TextView)findViewById(0x7f0b024c);
        txtBigRUMOR = (TextView)findViewById(0x7f0b02b2);
        listRilis = (GridView)findViewById(0x7f0b0239);
        listRilis.setOnScrollListener(new SampleScrollListener(this));
        btnMoreRilis = (RelativeLayout)findViewById(0x7f0b0235);
        progressbar_rilis = (ProgressBar)findViewById(0x7f0b0237);
        listSegera = (GridView)findViewById(0x7f0b024f);
        listSegera.setOnScrollListener(new SampleScrollListener(this));
        btnMoreSegera = (RelativeLayout)findViewById(0x7f0b024b);
        progressbar_segera = (ProgressBar)findViewById(0x7f0b024d);
        listRumor = (GridView)findViewById(0x7f0b02b5);
        listRumor.setOnScrollListener(new SampleScrollListener(this));
        btnMoreRumor = (RelativeLayout)findViewById(0x7f0b02b1);
        progressbar_rumor = (ProgressBar)findViewById(0x7f0b02b3);
        img_likerandom_ponsel = (ImageView)findViewById(0x7f0b028c);
        img_dislikerandom_ponsel = (ImageView)findViewById(0x7f0b028d);
        imgHpRandom = (ImageView)findViewById(0x7f0b028a);
        progressbar_hp_random = (CircularProgressBar)findViewById(0x7f0b0289);
        rl_hp_random = (RelativeLayout)findViewById(0x7f0b0280);
        rl_background_random = (RelativeLayout)findViewById(0x7f0b0283);
        list_txtMerekRandom = (TextView)findViewById(0x7f0b0287);
        list_txtHargaRandom = (TextView)findViewById(0x7f0b028b);
        pendatangArray = new ArrayList();
        pendatangAdapter = new ListPendatangAdapter(this, 0x7f030117, pendatangArray);
        listPendatang.setAdapter(pendatangAdapter);
        rilisTerbaruArray = new ArrayList();
        rilisTerbaruAdapter = new ListRilisTerbaruAdapter(this, 0x7f030117, rilisTerbaruArray);
        listRilis.setAdapter(rilisTerbaruAdapter);
        segeraArray = new ArrayList();
        segeraAdapter = new ListSegeraAdapter(this, 0x7f030117, segeraArray);
        listSegera.setAdapter(segeraAdapter);
        latestBrandArray = new ArrayList();
        latestBrandAdapter = new ListRumorAdapter(this, 0x7f030117, latestBrandArray);
        listTerbaruBrand.setAdapter(latestBrandAdapter);
        palingHotArray = new ArrayList();
        palingHotAdapter = new ListSegeraAdapter(this, 0x7f030117, palingHotArray);
        listPalingHot.setAdapter(palingHotAdapter);
        topRateArray = new ArrayList();
        topRateAdapter = new ListTopRateAdapter(this, 0x7f030118, topRateArray);
        listDirekomendasikan.setAdapter(topRateAdapter);
        rumorArray = new ArrayList();
        rumorAdapter = new ListRumorAdapter(this, 0x7f030117, rumorArray);
        listRumor.setAdapter(rumorAdapter);
        btnMorePendatang.setOnClickListener(this);
        btnMoreRilis.setOnClickListener(this);
        btnMoreSegera.setOnClickListener(this);
        btnMoreRumor.setOnClickListener(this);
        menu_beranda.setOnClickListener(this);
        menu_pesan.setOnClickListener(this);
        menu_GroupChat.setOnClickListener(this);
        menu_katalog.setOnClickListener(this);
        menu_Berita.setOnClickListener(this);
        menu_PusatLayanan.setOnClickListener(this);
        menu_LoginRegister.setOnClickListener(this);
        menu_Bookmark.setOnClickListener(this);
        menu_Setting.setOnClickListener(this);
        menu_KebijakanPrivasi.setOnClickListener(this);
        menu_Tentang.setOnClickListener(this);
        menu_FAQ.setOnClickListener(this);
        menu_profil.setOnClickListener(this);
        rl_gadget_tophits.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeGadgetActivity this$0;

            public void onClick(View view)
            {
                i = new Intent(getApplicationContext(), com/inponsel/android/statistik/StatistikPonsel);
                i.putExtra("pager_pos", "0");
                startActivityForResult(i, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = HomeGadgetActivity.this;
                super();
            }
        });
        rl_gadget_KATALOG.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeGadgetActivity this$0;

            public void onClick(View view)
            {
                i = new Intent(getApplicationContext(), com/inponsel/android/v2/MerekActivity);
                startActivityForResult(i, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = HomeGadgetActivity.this;
                super();
            }
        });
        rl_gadget_panduan.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeGadgetActivity this$0;

            public void onClick(View view)
            {
                i = new Intent(getApplicationContext(), com/inponsel/android/daftarharga/DaftarHargaPonsel);
                startActivityForResult(i, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = HomeGadgetActivity.this;
                super();
            }
        });
        rl_gadget_pencarian.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeGadgetActivity this$0;

            public void onClick(View view)
            {
                i = new Intent(getApplicationContext(), com/inponsel/android/pencarianrinci/PencarianRinciPonsel);
                startActivityForResult(i, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = HomeGadgetActivity.this;
                super();
            }
        });
        img_likerandom_ponsel.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeGadgetActivity this$0;

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
                    view = new android.app.AlertDialog.Builder(HomeGadgetActivity.this);
                    view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                    view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                        final _cls5 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls5.this;
                super();
            }
                    });
                    view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls5 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                            startActivityForResult(dialoginterface, 0);
                            overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls5.this;
                super();
            }
                    });
                    view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls5 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            startActivityForResult(dialoginterface, 0);
                            overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls5.this;
                super();
            }
                    });
                    view.show();
                    return;
                }
            }


            
            {
                this$0 = HomeGadgetActivity.this;
                super();
            }
        });
        img_dislikerandom_ponsel.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeGadgetActivity this$0;

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
                    view = new android.app.AlertDialog.Builder(HomeGadgetActivity.this);
                    view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
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
                            startActivityForResult(dialoginterface, 0);
                            overridePendingTransition(0x7f040003, 0x7f040004);
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
                            startActivityForResult(dialoginterface, 0);
                            overridePendingTransition(0x7f040003, 0x7f040004);
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
                this$0 = HomeGadgetActivity.this;
                super();
            }
        });
        rl_slideshow_tips_news = (RelativeLayout)findViewById(0x7f0b0268);
        home_menu_news_tips = (RelativeLayout)findViewById(0x7f0b026d);
        progressbar_viewpager_tips_news = (CircularProgressBar)findViewById(0x7f0b0269);
        txtMoreJempolInPonsel = (TextView)findViewById(0x7f0b0285);
        txtMoreJempolInPonsel.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeGadgetActivity this$0;

            public void onClick(View view)
            {
                load_random_hp();
            }

            
            {
                this$0 = HomeGadgetActivity.this;
                super();
            }
        });
        btnMorePendatang.setOnLongClickListener(new android.view.View.OnLongClickListener() {

            final HomeGadgetActivity this$0;

            public boolean onLongClick(View view)
            {
                btnMorePendatang.playSoundEffect(0);
                if (!txtMorePendatang.getText().toString().toLowerCase().contains("refresh"))
                {
                    PendatangTask();
                }
                return true;
            }

            
            {
                this$0 = HomeGadgetActivity.this;
                super();
            }
        });
        btnMoreRilis.setOnLongClickListener(new android.view.View.OnLongClickListener() {

            final HomeGadgetActivity this$0;

            public boolean onLongClick(View view)
            {
                if (!txtMoreRilis.getText().toString().toLowerCase().contains("refresh"))
                {
                    RilisTask();
                }
                return true;
            }

            
            {
                this$0 = HomeGadgetActivity.this;
                super();
            }
        });
        btnMoreSegera.setOnLongClickListener(new android.view.View.OnLongClickListener() {

            final HomeGadgetActivity this$0;

            public boolean onLongClick(View view)
            {
                if (!txtMoreSegera.getText().toString().toLowerCase().contains("refresh"))
                {
                    SegeraTask();
                }
                return true;
            }

            
            {
                this$0 = HomeGadgetActivity.this;
                super();
            }
        });
        btnMoreRumor.setOnLongClickListener(new android.view.View.OnLongClickListener() {

            final HomeGadgetActivity this$0;

            public boolean onLongClick(View view)
            {
                if (!txtMoreRumor.getText().toString().toLowerCase().contains("refresh"))
                {
                    RumorTask();
                }
                return true;
            }

            
            {
                this$0 = HomeGadgetActivity.this;
                super();
            }
        });
        listPendatang.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final HomeGadgetActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int k, long l)
            {
                listPendatang.playSoundEffect(0);
                id_hph = pendatangAdapter.getListModel(k).getId_hp().toString();
                model = pendatangAdapter.getListModel(k).getModel().toString();
                merk = pendatangAdapter.getListModel(k).getMerk().toString();
                gambar = pendatangAdapter.getListModel(k).getGambar().toString();
                tot_like = pendatangAdapter.getListModel(k).getTotal_like().toString();
                tot_dislike = pendatangAdapter.getListModel(k).getTotal_dislike().toString();
                tot_komen = pendatangAdapter.getListModel(k).getTotal_kom().toString();
                hrg_baru = pendatangAdapter.getListModel(k).getHrg_baru().toString();
                hrg_bekas = pendatangAdapter.getListModel(k).getHrg_bekas().toString();
                codename = pendatangAdapter.getListModel(k).getCodename().toString();
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
                this$0 = HomeGadgetActivity.this;
                super();
            }
        });
        listRilis.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final HomeGadgetActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int k, long l)
            {
                listPendatang.playSoundEffect(0);
                id_hph = rilisTerbaruAdapter.getListModel(k).getId_hp().toString();
                model = rilisTerbaruAdapter.getListModel(k).getModel().toString();
                merk = rilisTerbaruAdapter.getListModel(k).getMerk().toString();
                gambar = rilisTerbaruAdapter.getListModel(k).getGambar().toString();
                tot_like = rilisTerbaruAdapter.getListModel(k).getTotal_like().toString();
                tot_dislike = rilisTerbaruAdapter.getListModel(k).getTotal_dislike().toString();
                tot_komen = rilisTerbaruAdapter.getListModel(k).getTotal_kom().toString();
                hrg_baru = rilisTerbaruAdapter.getListModel(k).getHrg_baru().toString();
                hrg_bekas = rilisTerbaruAdapter.getListModel(k).getHrg_bekas().toString();
                codename = rilisTerbaruAdapter.getListModel(k).getCodename().toString();
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
                this$0 = HomeGadgetActivity.this;
                super();
            }
        });
        listSegera.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final HomeGadgetActivity this$0;

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
                this$0 = HomeGadgetActivity.this;
                super();
            }
        });
        listRumor.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final HomeGadgetActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int k, long l)
            {
                listPendatang.playSoundEffect(0);
                id_hph = rumorAdapter.getListModel(k).getId_hp().toString();
                model = rumorAdapter.getListModel(k).getModel().toString();
                merk = rumorAdapter.getListModel(k).getMerk().toString();
                gambar = rumorAdapter.getListModel(k).getGambar().toString();
                tot_like = rumorAdapter.getListModel(k).getTotal_like().toString();
                tot_dislike = rumorAdapter.getListModel(k).getTotal_dislike().toString();
                tot_komen = rumorAdapter.getListModel(k).getTotal_kom().toString();
                hrg_baru = rumorAdapter.getListModel(k).getHrg_baru().toString();
                hrg_bekas = rumorAdapter.getListModel(k).getHrg_bekas().toString();
                codename = rumorAdapter.getListModel(k).getCodename().toString();
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
                this$0 = HomeGadgetActivity.this;
                super();
            }
        });
        listDirekomendasikan.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final HomeGadgetActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int k, long l)
            {
                listDirekomendasikan.playSoundEffect(0);
                id_hph = topRateAdapter.getListModel(k).getId_hp().toString();
                model = topRateAdapter.getListModel(k).getModel().toString();
                merk = topRateAdapter.getListModel(k).getMerk().toString();
                gambar = topRateAdapter.getListModel(k).getGambar().toString();
                tot_like = topRateAdapter.getListModel(k).getTotal_like().toString();
                tot_dislike = topRateAdapter.getListModel(k).getTotal_dislike().toString();
                tot_komen = topRateAdapter.getListModel(k).getTotal_kom().toString();
                hrg_baru = topRateAdapter.getListModel(k).getHrg_baru().toString();
                hrg_bekas = topRateAdapter.getListModel(k).getHrg_bekas().toString();
                codename = topRateAdapter.getListModel(k).getCodename().toString();
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
                this$0 = HomeGadgetActivity.this;
                super();
            }
        });
        listPalingHot.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final HomeGadgetActivity this$0;

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
                this$0 = HomeGadgetActivity.this;
                super();
            }
        });
        listTerbaruBrand.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final HomeGadgetActivity this$0;

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
                this$0 = HomeGadgetActivity.this;
                super();
            }
        });
        (new AsyncHttpClient()).get((new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("home_head_banner").append(Utility.BASE_FORMAT).append("?t=").append(t).append("&id_user=").append(user_id).append("&page=4").toString(), new AsyncHttpResponseHandler() {

            final HomeGadgetActivity this$0;

            public void onFailure(int k, Header aheader[], byte abyte0[], Throwable throwable)
            {
            }

            public void onRetry(int k)
            {
            }

            public void onStart()
            {
            }

            public void onSuccess(int k, Header aheader[], byte abyte0[])
            {
                float f;
                float f1;
                float f2;
                aheader = new String(abyte0);
                try
                {
                    aheader = new JSONObject(aheader);
                    if (aheader.getString("success").equals("0"))
                    {
                        rl_head_banner.setVisibility(8);
                        return;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (Header aheader[])
                {
                    aheader.printStackTrace();
                    return;
                }
                aheader = aheader.getJSONArray("InPonsel");
                k = 0;
_L3:
                if (k < 1) goto _L2; else goto _L1
_L1:
                aheader = ((WindowManager)getSystemService("window")).getDefaultDisplay();
                abyte0 = new DisplayMetrics();
                aheader.getMetrics(abyte0);
                k = ((DisplayMetrics) (abyte0)).widthPixels;
                f1 = Utility.aspectratio(Integer.parseInt(str_doodle_width), Integer.parseInt(str_doodle_height));
                f = (float)Integer.parseInt(str_doodle_width) / f1;
                f1 = (float)Integer.parseInt(str_doodle_height) / f1;
                Log.e("ratio", String.valueOf((new StringBuilder(String.valueOf(f))).append(" : ").append(f1).toString()));
                f2 = k;
                if (f <= f1)
                {
                    break MISSING_BLOCK_LABEL_545;
                }
                final_width = f2;
                final_height = Math.round((f2 * f1) / f);
                Log.e("ratioFinal", String.valueOf((new StringBuilder(String.valueOf(final_width))).append(" : ").append(final_height).toString()));
_L4:
                img_head_banner.setLayoutParams(new android.widget.RelativeLayout.LayoutParams((int)final_width, (int)final_height));
                if (str_doodle_title.equals("") && str_doodle_subtitle.equals(""))
                {
                    rl_campaign_text.setVisibility(8);
                }
                txt_doodle_subtitle.setText(str_doodle_subtitle);
                txt_doodle_title.setText(str_doodle_title);
                btn_doodle_action.setText(str_doodle_text_action);
                btn_doodle_action.setOnClickListener(new android.view.View.OnClickListener() {

                    final _cls19 this$1;

                    public void onClick(View view)
                    {
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str_doodle_url)));
                    }

            
            {
                this$1 = _cls19.this;
                super();
            }
                });
                load_image_doodle();
                return;
_L2:
                abyte0 = aheader.getJSONObject(k);
                str_doodle_action = abyte0.getString("action");
                str_doodle_img = abyte0.getString("image");
                str_doodle_subtitle = abyte0.getString("campaign");
                str_doodle_title = abyte0.getString("title");
                str_doodle_url = abyte0.getString("url");
                str_doodle_width = abyte0.getString("width");
                str_doodle_height = abyte0.getString("height");
                str_doodle_text_action = abyte0.getString("text_action");
                k++;
                  goto _L3
                final_width = Math.round((f2 * f1) / f);
                final_height = f2;
                Log.e("ratioFinal", String.valueOf((new StringBuilder(String.valueOf(final_width))).append(" : ").append(final_height).toString()));
                  goto _L4
            }


            
            {
                this$0 = HomeGadgetActivity.this;
                super();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getSupportMenuInflater().inflate(0x7f0f0002, menu);
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

    public void onRefreshStarted(View view)
    {
        pendatangArray.clear();
        rilisTerbaruArray.clear();
        rumorArray.clear();
        segeraArray.clear();
        startTask();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
    }

    public void onScrollChanged(ParallaxScrollView parallaxscrollview, int i, int j, int k, int l)
    {
        i = parallaxscrollview.getChildAt(parallaxscrollview.getChildCount() - 1).getBottom() - (parallaxscrollview.getHeight() + parallaxscrollview.getScrollY());
        if (i <= 50 && scroll_count == 2)
        {
            progressbar_segmen2.setVisibility(0);
        }
        if (i <= 30)
        {
            Log.e("bottom", "oke");
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
            loadPage();
        }
    }

    public void onStop()
    {
        super.onStop();
        GoogleAnalytics.getInstance(this).reportActivityStart(this);
    }

    void parseJSONGroupChat(String s)
    {
        JSONObject jsonobject;
        jsonobject = new JSONObject(s);
        s = jsonobject.getJSONArray("InPonsel");
        if (jsonobject.getString("success").equals("0")) goto _L2; else goto _L1
_L1:
        int i = 0;
_L7:
        Object obj;
        try
        {
            if (i >= s.length())
            {
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return;
        }
        jsonobject = s.getJSONObject(i);
        if (!db.checkIfGroupExist(jsonobject.getString("codename"))) goto _L4; else goto _L3
_L3:
        db.update_groupmsg(jsonobject.getString("codename"), jsonobject.getString("username"), jsonobject.getString("message"), jsonobject.getString("type"), jsonobject.getString("post_date"), jsonobject.getString("me"), jsonobject.getString("unread"));
          goto _L5
_L4:
        db.addGroupChat(jsonobject.getString("id"), jsonobject.getString("merk"), jsonobject.getString("model"), jsonobject.getString("codename"), jsonobject.getString("hp_gambar"), jsonobject.getString("username"), jsonobject.getString("message"), jsonobject.getString("type"), jsonobject.getString("unread"), jsonobject.getString("me"), jsonobject.getString("post_date"));
          goto _L5
        obj;
        ((SQLException) (obj)).printStackTrace();
          goto _L5
        obj;
        ((Exception) (obj)).printStackTrace();
          goto _L5
_L2:
        return;
_L5:
        i++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void showAlertDialog(String s, final boolean finish)
    {
        alertDialog = (new android.app.AlertDialog.Builder(this)).create();
        alertDialog.setMessage(s);
        alertDialog.setCancelable(false);
        alertDialog.setButton(-1, "OK", new android.content.DialogInterface.OnClickListener() {

            final HomeGadgetActivity this$0;
            private final boolean val$finish;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
                if (finish)
                {
                    HomeGadgetActivity.this.finish();
                }
            }

            
            {
                this$0 = HomeGadgetActivity.this;
                finish = flag;
                super();
            }
        });
    }

    public void update(Observable observable, Object obj)
    {
        if (ponselBaseApp.getObserver().getLoginStat().equals("1"))
        {
            runOnUiThread(new Runnable() {

                final HomeGadgetActivity this$0;

                public void run()
                {
                    Log.e("updateObserverLogin", "HomeGadgetActivity");
                    if (userFunctions.isUserLoggedIn(getApplicationContext()))
                    {
                        cursor = db.getAllData();
                        cursor.moveToFirst();
                        invalidateOptionsMenu();
                        Object obj1;
                        try
                        {
                            user_id = EncodeDecodeAES.decrypt(RestClient.pelihara, cursor.getString(1));
                        }
                        catch (Exception exception) { }
                        nama_asli = cursor.getString(2);
                        user_photo = (new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(cursor.getString(3)).toString();
                        username = cursor.getString(4);
                        email_user = cursor.getString(5);
                        user_ttl = cursor.getString(6);
                        user_provinsi = cursor.getString(7);
                        user_kota = cursor.getString(8);
                        user_kecamatan = cursor.getString(cursor.getColumnIndex("user_kecamatan"));
                        user_jekel = cursor.getString(9);
                        user_ponsel1 = cursor.getString(10);
                        user_ponsel2 = cursor.getString(11);
                        user_provider1 = cursor.getString(12);
                        user_provider2 = cursor.getString(13);
                        user_joindate = cursor.getString(14);
                        user_profile_update = cursor.getString(15);
                        menu_profil.setVisibility(0);
                        menu_username.setText((new StringBuilder()).append(username).toString());
                        menu_ponsel_pengguna.setText((new StringBuilder()).append(user_ponsel1).toString());
                        menu_sim_pengguna.setText((new StringBuilder()).append(user_provider1).toString());
                        Picasso.with(HomeGadgetActivity.this).load(user_photo.trim()).tag(HomeGadgetActivity.this).into(menu_imgProfil, new Callback() {

                            final _cls22 this$1;

                            public void onError()
                            {
                            }

                            public void onSuccess()
                            {
                            }

            
            {
                this$1 = _cls22.this;
                super();
            }
                        });
                        menu_profil.setVisibility(0);
                        menu_LoginRegister.setVisibility(8);
                        menu_Bookmark.setVisibility(0);
                        menu_pesan.setVisibility(0);
                        menu_GroupChat.setVisibility(0);
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
                            } else
                            {
                                txtUnreadCount.setText(((CharSequence) (obj1)));
                                txtUnreadCount.setVisibility(0);
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
                            } else
                            {
                                txtUnreadCount.setText(((CharSequence) (obj1)));
                                txtUnreadCount.setVisibility(0);
                            }
                        }
                        GetInboxGroupList();
                        if (db.getGroupChatCount() > 0)
                        {
                            Log.e("getGroupChatCount", "getTotalUnread");
                            obj1 = db.getTotalUnreadGroupChat();
                            ((Cursor) (obj1)).moveToFirst();
                            obj1 = ((Cursor) (obj1)).getString(((Cursor) (obj1)).getColumnIndex("total"));
                            Log.e("getGroupChatCount()", ((String) (obj1)));
                            if (((String) (obj1)).equals("0") || ((String) (obj1)).equals(""))
                            {
                                txtUnreadGroupChat.setVisibility(8);
                                txtUnreadGroupChat.setText("0");
                            } else
                            {
                                txtUnreadGroupChat.setText(((CharSequence) (obj1)));
                                txtUnreadGroupChat.setVisibility(0);
                            }
                        } else
                        {
                            Log.e("prefUnreadgroup", "getTotalUnread");
                            String s = getApplicationContext().getSharedPreferences("UnreadGroup", 0).getString("unread_group", null);
                            if (s.equals("0") || s.equals(""))
                            {
                                txtUnreadGroupChat.setVisibility(8);
                                txtUnreadGroupChat.setText("0");
                            } else
                            {
                                txtUnreadGroupChat.setText(s);
                                txtUnreadGroupChat.setVisibility(0);
                            }
                        }
                        txtUnreadCount.getText().toString().equals("0");
                        menu_Setting.setVisibility(0);
                        userContentFavorit();
                        return;
                    } else
                    {
                        menu_GroupChat.setVisibility(8);
                        menu_pesan.setVisibility(8);
                        menu_LoginRegister.setVisibility(0);
                        menu_Bookmark.setVisibility(8);
                        menu_Setting.setVisibility(8);
                        menu_profil.setVisibility(8);
                        return;
                    }
                }

            
            {
                this$0 = HomeGadgetActivity.this;
                super();
            }
            });
        }
    }






}
