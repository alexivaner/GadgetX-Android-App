// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.widget.DrawerLayout;
import android.text.Html;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
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
import com.google.android.gms.analytics.Tracker;
import com.inponsel.android.SplashScreen;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.details.DetailsPonsel;
import com.inponsel.android.pencariangen.TabPencarian;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.NotificationLikeHelper;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.ServiceHandler;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.widget.DroidWriterEditText;
import com.inponsel.android.widget.ExpandableHeightGridView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.sherlock.navigationdrawer.compat.SherlockActionBarDrawerToggle;
import fr.castorflex.android.circularprogressbar.CircularProgressBar;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            BaseDrawer, ImagePagerActivity, SCUserActivity, RegisterActivity, 
//            LoginActivity, KomentarPonsel

public class TurunHargaPonselActivity extends BaseDrawer
    implements android.view.View.OnClickListener, Observer
{
    private class InAdsTask extends AsyncTask
    {

        final TurunHargaPonselActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            {
                avoid = (new ServiceHandler()).makeServiceCall(dataInAds, 1);
                if (avoid == null)
                {
                    break MISSING_BLOCK_LABEL_291;
                }
                int i;
                try
                {
                    avoid = new JSONObject(avoid);
                    sucads = avoid.getString("success");
                    Log.e("sucads", sucads);
                    inponsel = avoid.getJSONArray("InPonsel");
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_298;
                }
                i = 0;
            }
            if (i >= inponsel.length())
            {
                break MISSING_BLOCK_LABEL_298;
            }
            avoid = inponsel.getJSONObject(i);
            id_ads = avoid.getString("id_ads");
            id_user = avoid.getString("id_user");
            publisher_name = avoid.getString("publisher_name");
            title_ads = avoid.getString("ads_title");
            campaign = avoid.getString("ads_campaign");
            no_ads = avoid.getString("ads_no");
            image_ads = (new StringBuilder(String.valueOf(Util.BASE_PATH_IKADV))).append(avoid.getString("ads_image")).toString();
            link_ads = avoid.getString("ads_link");
            ads_method = avoid.getString("ads_method");
            ads_start = avoid.getString("ads_start");
            ads_finish = avoid.getString("ads_finish");
            ads_status = avoid.getString("ads_status");
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
            try
            {
                Log.e("image_ads", image_ads.replaceAll(" ", ""));
                if (sucads.equals("0"))
                {
                    lay_advertising.setVisibility(8);
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
            imgAdv.setLayoutParams(new android.widget.LinearLayout.LayoutParams(Utility.getBmapWidth(TurunHargaPonselActivity.this), Utility.getBmapHeight(TurunHargaPonselActivity.this)));
            imgAdv.setMaxWidth(Utility.getBmapWidth(TurunHargaPonselActivity.this));
            imgAdv.setMaxHeight(Utility.getBmapHeight(TurunHargaPonselActivity.this));
            if (!title_ads.equals("")) goto _L2; else goto _L1
_L1:
            txtAdvJudul2.setVisibility(8);
_L7:
            if (!campaign.equals("")) goto _L4; else goto _L3
_L3:
            txtAdvDesc.setVisibility(8);
_L8:
            if (!ads_method.equals("")) goto _L6; else goto _L5
_L5:
            btnAdvDownload.setVisibility(8);
_L9:
            if (!ads_status.equals("0"))
            {
                break MISSING_BLOCK_LABEL_382;
            }
            lay_advertising.setVisibility(8);
_L10:
            imgAdv.setOnClickListener(new android.view.View.OnClickListener() {

                final InAdsTask this$1;

                public void onClick(View view)
                {
                    view = new ArrayList();
                    view.add(image_ads.replaceAll(" ", "").trim());
                    view = (String[])view.toArray(new String[view.size()]);
                    Intent intent = new Intent(_fld0, com/inponsel/android/v2/ImagePagerActivity);
                    intent.putExtra("imgUrl", view);
                    intent.putExtra("pos", 0);
                    startActivity(intent);
                }

            
            {
                this$1 = InAdsTask.this;
                super();
            }
            });
            btnAdvDownload.setOnClickListener(new android.view.View.OnClickListener() {

                final InAdsTask this$1;

                public void onClick(View view)
                {
                    if (link_ads.contains("play.google.com"))
                    {
                        try
                        {
                            startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("market://details?id=")).append(link_ads.substring(link_ads.lastIndexOf("id=") + 3)).toString())));
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (View view)
                        {
                            startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("http://play.google.com/store/apps/details?id=")).append(link_ads.substring(link_ads.lastIndexOf("id=") + 3)).toString())));
                        }
                        return;
                    }
                    if (ads_method.equals("activity"))
                    {
                        view = new Intent(_fld0, com/inponsel/android/v2/SCUserActivity);
                        view.putExtra("activity", "main");
                        startActivityForResult(view, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                        return;
                    }
                    if (ads_method.toLowerCase().equals("ponsel"))
                    {
                        view = new Intent(getApplicationContext(), com/inponsel/android/details/DetailsPonsel);
                        view.putExtra("id_hph", link_ads);
                        view.putExtra("namalengkap", "");
                        view.putExtra("codename", "");
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
                        return;
                    } else
                    {
                        view = new Intent("android.intent.action.VIEW");
                        view.setData(Uri.parse(link_ads.replaceAll(" ", "")));
                        startActivity(view);
                        return;
                    }
                }

            
            {
                this$1 = InAdsTask.this;
                super();
            }
            });
            return;
_L2:
            txtAdvJudul2.setText(title_ads);
              goto _L7
_L4:
            txtAdvDesc.setText(campaign);
              goto _L8
_L6:
label0:
            {
                if (!ads_method.contains("Download"))
                {
                    break label0;
                }
                btnAdvDownload.setText("Download");
            }
              goto _L9
label1:
            {
                if (!ads_method.equals("activity"))
                {
                    break label1;
                }
                btnAdvDownload.setText("Arahkan");
            }
              goto _L9
            btnAdvDownload.setText("Arahkan");
              goto _L9
            imageLoaderAds.displayImage(image_ads.replaceAll(" ", ""), imgAdv, loaderoptionsAds, new ImageLoadingListener() {

                final InAdsTask this$1;

                public void onLoadingCancelled(String s, View view)
                {
                }

                public void onLoadingComplete(String s, View view, Bitmap bitmap)
                {
                    lay_advertising.setVisibility(0);
                    imgAdv.setVisibility(0);
                }

                public void onLoadingFailed(String s, View view, FailReason failreason)
                {
                    lay_advertising.setVisibility(0);
                    imgAdv.setVisibility(0);
                }

                public void onLoadingStarted(String s, View view)
                {
                    lay_advertising.setVisibility(8);
                    imgAdv.setVisibility(8);
                }

            
            {
                this$1 = InAdsTask.this;
                super();
            }
            });
              goto _L10
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
        }


        private InAdsTask()
        {
            this$0 = TurunHargaPonselActivity.this;
            super();
        }

        InAdsTask(InAdsTask inadstask)
        {
            this();
        }
    }

    public class ListTurunHargaAdapter extends BaseAdapter
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
        int hargaTurun;
        String hrg_baru;
        String hrg_bekas;
        String hrg_turun;
        ImageLoader imageLoader2;
        String indexhp;
        String komen;
        private ArrayList lm;
        ListModel lms;
        private DisplayImageOptions options;
        PonselBaseApp ponselBaseApp;
        int pos;
        String res;
        int resource;
        String response;
        String statusLikeHp;
        String t;
        final TurunHargaPonselActivity this$0;
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
            viewgroup = (LayoutInflater)activity.getSystemService("layout_inflater");
            View view1;
            if (i == 10000)
            {
                view1 = viewgroup.inflate(0x7f0300be, null);
            } else
            {
                if (view == null)
                {
                    view = viewgroup.inflate(resource, null);
                    viewgroup = new ViewHolder();
                    viewgroup.imageHp = (ImageView)view.findViewById(0x7f0b023d);
                    viewgroup.list_txtMerek = (TextView)view.findViewById(0x7f0b033c);
                    viewgroup.list_txtHarga = (TextView)view.findViewById(0x7f0b033d);
                    viewgroup.list_text_like = (TextView)view.findViewById(0x7f0b0344);
                    viewgroup.list_text_dislike = (TextView)view.findViewById(0x7f0b0347);
                    viewgroup.list_text_komentar = (TextView)view.findViewById(0x7f0b034a);
                    viewgroup.list_txtCodename = (TextView)view.findViewById(0x7f0b033f);
                    viewgroup.list_like = (ImageView)view.findViewById(0x7f0b0343);
                    viewgroup.list_dislike = (ImageView)view.findViewById(0x7f0b0346);
                    viewgroup.progressbar_item = (ProgressBar)view.findViewById(0x7f0b00b3);
                    viewgroup.list_lay_like = (RelativeLayout)view.findViewById(0x7f0b0342);
                    viewgroup.list_lay_dislike = (RelativeLayout)view.findViewById(0x7f0b0345);
                    viewgroup.list_lay_kom = (RelativeLayout)view.findViewById(0x7f0b0348);
                    viewgroup.rateRate = (RatingBar)view.findViewById(0x7f0b00c9);
                    viewgroup.list_txtBigRight = (TextView)view.findViewById(0x7f0b034d);
                    viewgroup.imgIklan = (ImageView)view.findViewById(0x7f0b0484);
                    viewgroup.headIklan = (LinearLayout)view.findViewById(0x7f0b0482);
                    viewgroup.progressbar_item_iklan = (ProgressBar)view.findViewById(0x7f0b0483);
                    viewgroup.headHp = (LinearLayout)view.findViewById(0x7f0b0481);
                    viewgroup.headImage = (LinearLayout)view.findViewById(0x7f0b029f);
                    view.setTag(viewgroup);
                } else
                {
                    viewgroup = (ViewHolder)view.getTag();
                }
                lms = (ListModel)lm.get(i);
                view1 = view;
                if (lm != null)
                {
                    hrg_baru = lms.getHrg_baru();
                    hrg_bekas = lms.getHrg_bekas();
                    hrg_turun = lms.getPenurunan_harga();
                    ((ViewHolder) (viewgroup)).list_txtMerek.setText((new StringBuilder(String.valueOf(lms.getMerk()))).append(" ").append(lms.getModel()).toString());
                    ((ViewHolder) (viewgroup)).list_txtCodename.setText(lms.getCodename());
                    if (hrg_turun.equals("-"))
                    {
                        ((ViewHolder) (viewgroup)).list_txtBigRight.setVisibility(8);
                    } else
                    {
                        ((ViewHolder) (viewgroup)).list_txtBigRight.setText(hrg_turun);
                        ((ViewHolder) (viewgroup)).list_txtBigRight.setTextSize(30F);
                        ((ViewHolder) (viewgroup)).list_txtBigRight.setTextColor(Color.parseColor("#e1eace"));
                        ((ViewHolder) (viewgroup)).list_txtBigRight.setVisibility(0);
                    }
                    ((ViewHolder) (viewgroup)).list_text_like.setText(lms.getTotal_like());
                    ((ViewHolder) (viewgroup)).list_text_dislike.setText(lms.getTotal_dislike());
                    ((ViewHolder) (viewgroup)).list_text_komentar.setText(lms.getTotal_kom());
                    if (lms.getUmu_status().equals("3") || hrg_baru.equals("-") || hrg_baru.equals("0"))
                    {
                        ((ViewHolder) (viewgroup)).list_txtHarga.setVisibility(8);
                    } else
                    {
                        ((ViewHolder) (viewgroup)).list_txtHarga.setVisibility(0);
                        ((ViewHolder) (viewgroup)).list_txtHarga.setText((new StringBuilder()).append(hrg_baru).append("\nDiperbarui ").append(Utility.convertDateYMD(lms.getUpdate_harga())).toString());
                    }
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
                    ((ViewHolder) (viewgroup)).list_lay_like.setOnClickListener(i. new android.view.View.OnClickListener() {

                        final ListTurunHargaAdapter this$1;
                        private final int val$position;

                        public void onClick(View view)
                        {
                            indexhp = getListModel(position).getId_hp();
                            ponselBaseApp.getObserver().setIndexHp(getListModel(position).getCodename());
                            Log.e("getNamalengkap", getListModel(position).getCodename());
                            statusLikeHp = "1";
                            namalengkapbgskrg = (new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString();
                            if (userFunctions.isUserLoggedIn(activity))
                            {
                                pos = position;
                                try
                                {
                                    finalUrl = (new StringBuilder("idhp=")).append(getListModel(position).getId_hp()).append("&email=").append(username).append("&namalengkap=").append(URLEncoder.encode((new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString(), "utf-8")).append("&status=").append(statusLikeHp).append("&t=").append(t).toString();
                                }
                                // Misplaced declaration of an exception variable
                                catch (View view)
                                {
                                    view.printStackTrace();
                                }
                                Log.e("finalurl", finalUrl);
                                if (android.os.Build.VERSION.SDK_INT >= 11)
                                {
                                    (new ListTurunHargaAdapter.PostBagusKurangTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                                    return;
                                } else
                                {
                                    (new ListTurunHargaAdapter.PostBagusKurangTask()).execute(new Void[0]);
                                    return;
                                }
                            } else
                            {
                                view = new android.app.AlertDialog.Builder(activity);
                                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                                view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                                    final ListTurunHargaAdapter._cls1 this$2;

                                    public void onClick(DialogInterface dialoginterface, int i)
                                    {
                                        dialoginterface.dismiss();
                                    }

            
            {
                this$2 = ListTurunHargaAdapter._cls1.this;
                super();
            }
                                });
                                view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                                    final ListTurunHargaAdapter._cls1 this$2;

                                    public void onClick(DialogInterface dialoginterface, int i)
                                    {
                                        dialoginterface = new Intent(activity, com/inponsel/android/v2/RegisterActivity);
                                        activity.startActivity(dialoginterface);
                                    }

            
            {
                this$2 = ListTurunHargaAdapter._cls1.this;
                super();
            }
                                });
                                view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                                    final ListTurunHargaAdapter._cls1 this$2;

                                    public void onClick(DialogInterface dialoginterface, int i)
                                    {
                                        dialoginterface = new Intent(activity, com/inponsel/android/v2/LoginActivity);
                                        dialoginterface.putExtra("activity", "main");
                                        activity.startActivity(dialoginterface);
                                    }

            
            {
                this$2 = ListTurunHargaAdapter._cls1.this;
                super();
            }
                                });
                                view.show();
                                return;
                            }
                        }


            
            {
                this$1 = final_listturunhargaadapter;
                position = I.this;
                super();
            }
                    });
                    ((ViewHolder) (viewgroup)).list_lay_dislike.setOnClickListener(i. new android.view.View.OnClickListener() {

                        final ListTurunHargaAdapter this$1;
                        private final int val$position;

                        public void onClick(View view)
                        {
                            indexhp = getListModel(position).getId_hp();
                            ponselBaseApp.getObserver().setIndexHp(getListModel(position).getCodename());
                            Log.e("getNamalengkap", getListModel(position).getCodename());
                            statusLikeHp = "0";
                            namalengkapbgskrg = (new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString();
                            if (userFunctions.isUserLoggedIn(activity))
                            {
                                pos = position;
                                try
                                {
                                    finalUrl = (new StringBuilder("idhp=")).append(getListModel(position).getId_hp()).append("&email=").append(username).append("&namalengkap=").append(URLEncoder.encode((new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString(), "utf-8")).append("&status=").append(statusLikeHp).append("&t=").append(t).toString();
                                }
                                // Misplaced declaration of an exception variable
                                catch (View view)
                                {
                                    view.printStackTrace();
                                }
                                Log.e("finalurl", finalUrl);
                                if (android.os.Build.VERSION.SDK_INT >= 11)
                                {
                                    (new ListTurunHargaAdapter.PostBagusKurangTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                                    return;
                                } else
                                {
                                    (new ListTurunHargaAdapter.PostBagusKurangTask()).execute(new Void[0]);
                                    return;
                                }
                            } else
                            {
                                view = new android.app.AlertDialog.Builder(activity);
                                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                                view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                                    final ListTurunHargaAdapter._cls2 this$2;

                                    public void onClick(DialogInterface dialoginterface, int i)
                                    {
                                        dialoginterface.dismiss();
                                    }

            
            {
                this$2 = ListTurunHargaAdapter._cls2.this;
                super();
            }
                                });
                                view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                                    final ListTurunHargaAdapter._cls2 this$2;

                                    public void onClick(DialogInterface dialoginterface, int i)
                                    {
                                        dialoginterface = new Intent(activity, com/inponsel/android/v2/RegisterActivity);
                                        activity.startActivity(dialoginterface);
                                    }

            
            {
                this$2 = ListTurunHargaAdapter._cls2.this;
                super();
            }
                                });
                                view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                                    final ListTurunHargaAdapter._cls2 this$2;

                                    public void onClick(DialogInterface dialoginterface, int i)
                                    {
                                        dialoginterface = new Intent(activity, com/inponsel/android/v2/LoginActivity);
                                        dialoginterface.putExtra("activity", "main");
                                        activity.startActivity(dialoginterface);
                                    }

            
            {
                this$2 = ListTurunHargaAdapter._cls2.this;
                super();
            }
                                });
                                view.show();
                                return;
                            }
                        }


            
            {
                this$1 = final_listturunhargaadapter;
                position = I.this;
                super();
            }
                    });
                    ((ViewHolder) (viewgroup)).list_lay_kom.setOnClickListener(i. new android.view.View.OnClickListener() {

                        final ListTurunHargaAdapter this$1;
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
                this$1 = final_listturunhargaadapter;
                position = I.this;
                super();
            }
                    });
                    try
                    {
                        imageLoader2.displayImage((new StringBuilder(String.valueOf(Util.BASE_PATH_NEWIMAGE))).append(lms.getGambar().trim()).toString(), ((ViewHolder) (viewgroup)).imageHp, options, viewgroup. new ImageLoadingListener() {

                            final ListTurunHargaAdapter this$1;
                            private final ListTurunHargaAdapter.ViewHolder val$holder;

                            public void onLoadingCancelled(String s, View view)
                            {
                            }

                            public void onLoadingComplete(String s, View view, Bitmap bitmap)
                            {
                                holder.progressbar_item.setVisibility(8);
                                holder.imageHp.setVisibility(0);
                            }

                            public void onLoadingFailed(String s, View view, FailReason failreason)
                            {
                                holder.progressbar_item.setVisibility(8);
                                holder.imageHp.setVisibility(0);
                            }

                            public void onLoadingStarted(String s, View view)
                            {
                                holder.progressbar_item.setVisibility(0);
                                holder.imageHp.setVisibility(8);
                            }

            
            {
                this$1 = final_listturunhargaadapter;
                holder = ListTurunHargaAdapter.ViewHolder.this;
                super();
            }
                        });
                    }
                    // Misplaced declaration of an exception variable
                    catch (ViewGroup viewgroup)
                    {
                        return view;
                    }
                    return view;
                }
            }
            return view1;
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
            Log.e("getUpdateType", ponselBaseApp.getObserver().getUpdateType().toString());
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
            Log.e("indexArrayListCarpon", String.valueOf(listPonselOS.getChildCount()));
            int i = 0;
            do
            {
                if (i >= listPonselOS.getChildCount())
                {
                    return;
                }
                Log.e("int i", String.valueOf(i));
                View view = listPonselOS.getChildAt(i);
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
            Log.e("indexArrayListCarpon", String.valueOf(listPonselOS.getChildCount()));
            i = 0;
_L2:
            ImageView imageview;
            ImageView imageview1;
            RelativeLayout relativelayout;
            Object obj;
            if (i >= listPonselOS.getChildCount())
            {
                return;
            }
            Log.e("int i", String.valueOf(i));
            obj = listPonselOS.getChildAt(i);
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
                Log.e("getTot_LikePon", ponselBaseApp.getObserver().getJum_komenLikePon().toString());
                Log.e("getTot_LikePon", ponselBaseApp.getObserver().getTot_LikePon().toString());
                Log.e("getTotdis_LikePon", ponselBaseApp.getObserver().getTotdis_LikePon().toString());
                textview.setText(ponselBaseApp.getObserver().getTot_LikePon().toString());
                textview1.setText(ponselBaseApp.getObserver().getTotdis_LikePon().toString());
                textview2.setText(ponselBaseApp.getObserver().getJum_komenLikePon().toString());
                Log.e("getUpdateTypeBef", ponselBaseApp.getObserver().getUpdateType().toString());
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



        public ListTurunHargaAdapter(Activity activity1, int i, ArrayList arraylist)
        {
            this$0 = TurunHargaPonselActivity.this;
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
                imageLoader2 = ImageLoader.getInstance();
                imageLoader2.init(ImageLoaderConfiguration.createDefault(activity.getApplicationContext()));
                options = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showImageForEmptyUri(0x7f020208).cacheInMemory(true).imageScaleType(ImageScaleType.EXACTLY).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).build();
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
            catch (TurunHargaPonselActivity turunhargaponselactivity)
            {
                return;
            }
        }
    }

    public class ListTurunHargaAdapter.PostBagusKurangTask extends AsyncTask
    {

        final ListTurunHargaAdapter this$1;

        private void parseJSONLikePon(String s)
        {
            int i;
            try
            {
                JSONObject jsonobject = new JSONObject(s);
                postStatusLikePon = jsonobject.getString("success");
                postMessageLikePon = jsonobject.getString("message");
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
            jum_komenLikePon = s.getString("total_kom");
            tot_LikePon = s.getString("total_like");
            totdis_LikePon = s.getString("total_dislike");
            Log.e("jum_komenLikePon", jum_komenLikePon);
            Log.e("tot_LikePon", tot_LikePon);
            Log.e("totdis_LikePon", totdis_LikePon);
            ponselBaseApp.getObserver().setJum_komenLikePon(jum_komenLikePon);
            ponselBaseApp.getObserver().setTot_LikePon(tot_LikePon);
            ponselBaseApp.getObserver().setTotdis_LikePon(totdis_LikePon);
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
            Log.e("postStatusLikePon", postStatusLikePon);
            if (!postStatusLikePon.equals("1"))
            {
                break MISSING_BLOCK_LABEL_121;
            }
            notificationLikeHelper.completed(namalengkapbgskrg, notificationLikeHelper.SucdislikeStatement);
            if (statusLikeHp.equals("1"))
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

        public ListTurunHargaAdapter.PostBagusKurangTask()
        {
            this$1 = ListTurunHargaAdapter.this;
            super();
        }
    }

    class ListTurunHargaAdapter.ViewHolder
    {

        LinearLayout headHp;
        LinearLayout headIklan;
        LinearLayout headImage;
        ImageView imageHp;
        ImageView imgIklan;
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
        ProgressBar progressbar_item;
        ProgressBar progressbar_item_iklan;
        RatingBar rateRate;
        final ListTurunHargaAdapter this$1;

        ListTurunHargaAdapter.ViewHolder()
        {
            this$1 = ListTurunHargaAdapter.this;
            super();
        }
    }

    private class TurunHargaTask extends AsyncTask
    {

        final TurunHargaPonselActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            {
                avoid = (new ServiceHandler()).makeServiceCall(dataTurunHarga, 1);
                Log.e("Responseharga: ", (new StringBuilder("> ")).append(avoid).toString());
                if (avoid == null)
                {
                    break MISSING_BLOCK_LABEL_353;
                }
                ListModel listmodel;
                int i;
                try
                {
                    avoid = new JSONObject(avoid);
                    inponsel = avoid.getJSONArray("InPonsel");
                    suc = avoid.getString("success");
                    Log.e("suc", suc);
                    counterArray = 0;
                    if (!suc.equals("1"))
                    {
                        break MISSING_BLOCK_LABEL_360;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_360;
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_360;
                }
                i = 0;
            }
            if (i >= inponsel.length())
            {
                break MISSING_BLOCK_LABEL_360;
            }
            avoid = TurunHargaPonselActivity.this;
            avoid.counterArray = ((TurunHargaPonselActivity) (avoid)).counterArray + 1;
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
            listmodel.setPenurunan_harga(avoid.getString("penurunan_harga"));
            listmodel.setUpdate_harga(avoid.getString("update_harga"));
            turunHargaArray.add(listmodel);
            i++;
            if (true)
            {
                break MISSING_BLOCK_LABEL_116;
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
            getSherlock().setProgressBarIndeterminateVisibility(false);
            getSherlock().setProgressBarVisibility(false);
            listPonselOS.setVisibility(0);
            layout_empty.setVisibility(8);
            Log.e("taskLst", "pendatang");
            Log.e("data", dataTurunHarga);
            if (suc.equals("1"))
            {
                break MISSING_BLOCK_LABEL_197;
            }
            grup_header_footer.setVisibility(8);
            progressbar_middle.setVisibility(8);
            listPonselOS.setVisibility(0);
            layout_empty.setVisibility(0);
            txt_empty.setText("Data belum tersedia");
_L1:
            ponselOsAdapter.notifyDataSetChanged();
            Log.e("counterArray", String.valueOf(turunHargaArray.size()));
            if (counterArray < 10)
            {
                grup_header_footer.setVisibility(8);
                return;
            }
            break MISSING_BLOCK_LABEL_211;
            try
            {
                listPonselOS.setVisibility(0);
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
              goto _L1
            btnMemuatLagi.setVisibility(0);
            grup_header_footer.setVisibility(0);
            return;
        }

        private TurunHargaTask()
        {
            this$0 = TurunHargaPonselActivity.this;
            super();
        }

        TurunHargaTask(TurunHargaTask turunhargatask)
        {
            this();
        }
    }


    private String TAG;
    String ads_finish;
    String ads_method;
    String ads_start;
    String ads_status;
    Button btnAdvDownload;
    Button btnLoadMoreKom;
    Button btnLoadMoreNextKom;
    Button btnMemuatLagi;
    Button btn_pop_komen;
    Button btn_pop_login;
    String campaign;
    int charCount;
    ConnectivityManager cm;
    String codename;
    String codenameKomen;
    int countAllKom;
    int countKomOld;
    int counterArray;
    String dataInAds;
    String dataTurunHarga;
    DroidWriterEditText edt_pop_komen;
    String email_komentar;
    Bundle extras;
    LinearLayout footerView;
    String gambar;
    LinearLayout grup_header_footer;
    LinearLayout headerView;
    String hrg_baru;
    String hrg_bekas;
    String id_ads;
    String id_hp;
    String id_hph;
    String id_hpkom;
    String id_kom;
    String id_user;
    String idhpstatus;
    ImageLoader imageLoaderAds;
    String image_ads;
    ImageView imgAdv;
    LinearLayout imgUserKiri;
    JSONArray inponsel;
    String isikomentar;
    JSONArray jArray;
    JSONObject json;
    String jum_komenLikePon;
    String lastid;
    RelativeLayout lay_adv_atas;
    LinearLayout lay_advertising;
    LinearLayout lay_pop_komen;
    LayoutInflater layoutInflater;
    LinearLayout layout_empty;
    LinearLayout layout_footer;
    LinearLayout layout_loading;
    LinearLayout layout_loadingNext;
    int limit;
    String link_ads;
    ListView listKomen;
    ExpandableHeightGridView listPonselOS;
    ImageLoaderConfiguration loaderConfigurationAds;
    private DisplayImageOptions loaderoptionsAds;
    String merk;
    String model;
    String namalengkap;
    String namalengkapbgskrg;
    int newBmapHeight;
    int newBmapWidth;
    String no_ads;
    NotificationLikeHelper notificationLikeHelper;
    String oldid;
    public ListTurunHargaAdapter ponselOsAdapter;
    ArrayList popKomenArray;
    LinearLayout pop_layout_empty;
    ProgressBar pop_progressbar_middle;
    TextView pop_txtCountKomen;
    TextView pop_txt_empty;
    int poslike;
    String postMessage;
    String postMessageLikePon;
    String postStatus;
    String postStatusLikePon;
    CircularProgressBar progressbar_middle;
    String publisher_name;
    String querylike;
    String querypopkomen;
    String res;
    String reslike;
    String statuslike;
    String suc;
    String sucads;
    String sucads2;
    String t;
    String tanggal;
    String title_ads;
    String tot_LikePon;
    String tot_dislike;
    String tot_komen;
    String tot_like;
    String totdis_LikePon;
    public ArrayList turunHargaArray;
    TextView txtAdvDesc;
    TextView txtAdvJudul1;
    TextView txtAdvJudul2;
    TextView txt_empty;
    TextView txt_footer;
    String urlKomen;
    String urlKomenLast;
    String urlKomenOld;
    String urlSearch;
    String userkomen;
    String userpict;

    public TurunHargaPonselActivity()
    {
        TAG = getClass().getSimpleName();
        turunHargaArray = null;
        querypopkomen = "";
        limit = 0;
        t = Utility.session(RestClient.pelihara);
        oldid = "";
        lastid = "0";
        urlKomen = "";
        urlKomenOld = "";
        urlKomenLast = "";
        countKomOld = 0;
        countAllKom = 0;
        postStatusLikePon = "";
        postMessageLikePon = "Gagal mengirim";
        tot_LikePon = "0";
        totdis_LikePon = "0";
        jum_komenLikePon = "0";
        postStatus = "";
        postMessage = "";
        publisher_name = "";
        title_ads = "";
        campaign = "";
        image_ads = "";
        link_ads = "";
        ads_status = "";
        inponsel = null;
        suc = "";
        sucads = "0";
        sucads2 = "0";
    }

    public void InAdsTask()
    {
        Log.e("dataInAds", dataInAds);
        InAdsTask inadstask = new InAdsTask(null);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            inadstask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            inadstask.execute(new Void[0]);
            return;
        }
    }

    public void TurunHargaTask()
    {
        getSherlock().setProgressBarIndeterminateVisibility(true);
        getSherlock().setProgressBarVisibility(true);
        TurunHargaTask turunhargatask = new TurunHargaTask(null);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            turunhargatask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            turunhargatask.execute(new Void[0]);
            return;
        }
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
            overridePendingTransition(0x7f040001, 0x7f040002);
            return;
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        mDrawerToggle.onConfigurationChanged(configuration);
        imgAdv.setLayoutParams(new android.widget.LinearLayout.LayoutParams(Utility.getBmapWidth(this), Utility.getBmapHeight(this)));
        imgAdv.setMaxWidth(Utility.getBmapWidth(this));
        imgAdv.setMaxHeight(Utility.getBmapHeight(this));
        if (!image_ads.equals(""))
        {
            imageLoader2.loadImage(image_ads.replaceAll(" ", ""), new SimpleImageLoadingListener() {

                final TurunHargaPonselActivity this$0;

                public void onLoadingComplete(String s, View view, Bitmap bitmap)
                {
                    imgAdv.setImageBitmap(bitmap);
                    if (ads_status.equals("1"))
                    {
                        lay_advertising.setVisibility(0);
                        return;
                    } else
                    {
                        lay_advertising.setVisibility(8);
                        return;
                    }
                }

            
            {
                this$0 = TurunHargaPonselActivity.this;
                super();
            }
            });
        }
        int i = configuration.orientation;
        i = configuration.orientation;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f0300f2, null, false);
        mDrawerLayout.addView(bundle, 0);
        int i;
        int j;
        try
        {
            bundle = ((PonselBaseApp)getApplication()).getTracker(com.inponsel.android.adapter.PonselBaseApp.TrackerName.APP_TRACKER);
            bundle.setScreenName("Turun Harga Ponsel");
            bundle.send((new com.google.android.gms.analytics.HitBuilders.AppViewBuilder()).build());
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        notificationLikeHelper = new NotificationLikeHelper(this);
        actionBar = getSupportActionBar();
        actionBar.setDisplayUseLogoEnabled(useLogo);
        actionBar.setBackgroundDrawable(getResources().getDrawable(0x7f0200e5));
        j = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        i = j;
        if (j == 0)
        {
            i = 0x7f0b0037;
        }
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFFFFF'>Turun Harga</font>"));
        bundle = (TextView)findViewById(i);
        bundle.setSelected(true);
        bundle.setTextColor(Color.parseColor("#FFFFFF"));
        bundle.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        listPonselOS = (ExpandableHeightGridView)findViewById(0x7f0b052e);
        listPonselOS.setExpanded(true);
        layout_empty = (LinearLayout)findViewById(0x7f0b0091);
        txt_empty = (TextView)findViewById(0x7f0b0093);
        progressbar_middle = (CircularProgressBar)findViewById(0x7f0b00ca);
        txt_empty.setText("Memuat...");
        t = Utility.session(t);
        turunHargaArray = new ArrayList();
        ponselOsAdapter = new ListTurunHargaAdapter(this, 0x7f03011b, turunHargaArray);
        cm = (ConnectivityManager)getSystemService("connectivity");
        extras = getIntent().getExtras();
        imgAdv = (ImageView)findViewById(0x7f0b006d);
        txtAdvJudul1 = (TextView)findViewById(0x7f0b006c);
        txtAdvJudul2 = (TextView)findViewById(0x7f0b006f);
        txtAdvDesc = (TextView)findViewById(0x7f0b0070);
        btnAdvDownload = (Button)findViewById(0x7f0b006e);
        lay_advertising = (LinearLayout)findViewById(0x7f0b006a);
        lay_adv_atas = (RelativeLayout)findViewById(0x7f0b006b);
        lay_advertising.setVisibility(8);
        imageLoaderAds = ImageLoader.getInstance();
        loaderoptionsAds = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showImageForEmptyUri(0x7f020208).cacheInMemory(true).cacheOnDisk(true).imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).build();
        loaderConfigurationAds = (new com.nostra13.universalimageloader.core.ImageLoaderConfiguration.Builder(this)).defaultDisplayImageOptions(loaderoptionsAds).build();
        imageLoaderAds.init(loaderConfigurationAds);
        btnMemuatLagi = (Button)findViewById(0x7f0b00bc);
        btnMemuatLagi.setText(0x7f0c0054);
        t = Utility.session(t);
        layout_footer = (LinearLayout)findViewById(0x7f0b00b9);
        grup_header_footer = (LinearLayout)findViewById(0x7f0b00b7);
        txt_footer = (TextView)findViewById(0x7f0b00bb);
        txt_footer.setText("Memuat");
        grup_header_footer.setVisibility(8);
        listPonselOS.setAdapter(ponselOsAdapter);
        if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected())
        {
            limit = 0;
            dataTurunHarga = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("list_turun_harga").append(Utility.BASE_FORMAT).append("?lmt=").append(limit).append("&t=").append(t).append("&idusr=").append(user_id).toString();
            TurunHargaTask();
            dataInAds = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("inads").append(Utility.BASE_FORMAT).append("?pver=").append(SplashScreen.curVersion).append("&hal=P12-01").append("&t=").append(t).toString();
            InAdsTask();
        }
        btnMemuatLagi.setOnClickListener(new android.view.View.OnClickListener() {

            final TurunHargaPonselActivity this$0;

            public void onClick(View view)
            {
                btnMemuatLagi.setVisibility(8);
                if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected())
                {
                    view = TurunHargaPonselActivity.this;
                    view.limit = ((TurunHargaPonselActivity) (view)).limit + 10;
                    dataTurunHarga = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("list_turun_harga").append(Utility.BASE_FORMAT).append("?lmt=").append(limit).append("&t=").append(t).append("&idusr=").append(user_id).toString();
                    Log.e("data", dataTurunHarga);
                    TurunHargaTask();
                }
            }

            
            {
                this$0 = TurunHargaPonselActivity.this;
                super();
            }
        });
        listPonselOS.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final TurunHargaPonselActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int k, long l)
            {
                listPonselOS.playSoundEffect(0);
                id_hph = ponselOsAdapter.getListModel(k).getId_hp().toString();
                model = ponselOsAdapter.getListModel(k).getModel().toString();
                merk = ponselOsAdapter.getListModel(k).getMerk().toString();
                gambar = ponselOsAdapter.getListModel(k).getGambar().toString();
                tot_like = ponselOsAdapter.getListModel(k).getTotal_like().toString();
                tot_dislike = ponselOsAdapter.getListModel(k).getTotal_dislike().toString();
                tot_komen = ponselOsAdapter.getListModel(k).getTotal_kom().toString();
                hrg_baru = ponselOsAdapter.getListModel(k).getHrg_baru().toString();
                hrg_bekas = ponselOsAdapter.getListModel(k).getHrg_bekas().toString();
                codename = ponselOsAdapter.getListModel(k).getCodename().toString();
                namalengkap = (new StringBuilder(String.valueOf(merk))).append(" ").append(model).toString();
                if (id_hph.contains("iklan"))
                {
                    adapterview = new Intent("android.intent.action.VIEW");
                    adapterview.setData(Uri.parse(codename.replace(" ", "")));
                    startActivity(adapterview);
                    return;
                } else
                {
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
                    return;
                }
            }

            
            {
                this$0 = TurunHargaPonselActivity.this;
                super();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getSupportMenuInflater().inflate(0x7f0f0002, menu);
        return super.onCreateOptionsMenu(menu);
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


}
