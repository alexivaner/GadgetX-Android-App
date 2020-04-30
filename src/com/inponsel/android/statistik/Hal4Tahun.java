// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.statistik;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.FragmentActivity;
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
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.MenuItem;
import com.android.volley.VolleyError;
import com.google.android.gms.analytics.Tracker;
import com.google.gson.Gson;
import com.inponsel.android.SplashScreen;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.details.DetailsPonsel;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.MyObjectRequest;
import com.inponsel.android.utils.NotificationLikeHelper;
import com.inponsel.android.utils.Response;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.ServiceHandler;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.utils.YourFragmentInterface;
import com.inponsel.android.v2.BaseDrawer;
import com.inponsel.android.v2.ImagePagerActivity;
import com.inponsel.android.v2.KomentarPonsel;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;
import com.inponsel.android.v2.SCUserActivity;
import com.inponsel.android.widget.DroidWriterEditText;
import com.inponsel.android.widget.ExpandableHeightGridView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Hal4Tahun extends SherlockFragment
    implements Observer, YourFragmentInterface
{
    private class InAdsTask extends AsyncTask
    {

        final Hal4Tahun this$0;

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
            imgAdv.setLayoutParams(new android.widget.LinearLayout.LayoutParams(Utility.getBmapWidth(getActivity()), Utility.getBmapHeight(getActivity())));
            imgAdv.setMaxWidth(Utility.getBmapWidth(getActivity()));
            imgAdv.setMaxHeight(Utility.getBmapHeight(getActivity()));
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
                break MISSING_BLOCK_LABEL_394;
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
                    Intent intent = new Intent(getActivity(), com/inponsel/android/v2/ImagePagerActivity);
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
                        view = new Intent(getActivity(), com/inponsel/android/v2/SCUserActivity);
                        view.putExtra("activity", "main");
                        startActivityForResult(view, 0);
                        getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                        return;
                    }
                    if (ads_method.toLowerCase().equals("ponsel"))
                    {
                        view = new Intent(getActivity(), com/inponsel/android/details/DetailsPonsel);
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
                        getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
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
            this$0 = Hal4Tahun.this;
            super();
        }

        InAdsTask(InAdsTask inadstask)
        {
            this();
        }
    }

    public class ListStatAdapter extends BaseAdapter
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
        ImageLoader imageLoader2;
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
        final Hal4Tahun this$0;
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
                viewgroup.txtNumber = (TextView)view.findViewById(0x7f0b00c6);
                viewgroup.headImage = (LinearLayout)view.findViewById(0x7f0b029f);
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
                ((ViewHolder) (viewgroup)).txtNumber.setVisibility(8);
                ((ViewHolder) (viewgroup)).txtNumber.setText(lms.getNourut());
                ((ViewHolder) (viewgroup)).list_txtMerek.setText((new StringBuilder(String.valueOf(lms.getNourut()))).append(". ").append(lms.getMerk()).append(" ").append(lms.getModel()).toString());
                ((ViewHolder) (viewgroup)).list_txtCodename.setText(lms.getCodename());
                ((ViewHolder) (viewgroup)).list_text_like.setText(lms.getTotal_like());
                ((ViewHolder) (viewgroup)).list_text_dislike.setText(lms.getTotal_dislike());
                ((ViewHolder) (viewgroup)).list_text_komentar.setText(lms.getTotal_kom());
                ((ViewHolder) (viewgroup)).list_txtBigRight.setText((new StringBuilder(String.valueOf(lms.getTotal_hits()))).append(" hits").toString());
                ((ViewHolder) (viewgroup)).list_txtBigRight.setTextColor(Color.parseColor("#80f2dfc7"));
                ((ViewHolder) (viewgroup)).list_txtBigRight.setVisibility(0);
                if (lms.getUmu_status().equals("3") || hrg_baru.equals("-") || hrg_baru.equals("0"))
                {
                    ((ViewHolder) (viewgroup)).list_txtHarga.setVisibility(8);
                } else
                {
                    ((ViewHolder) (viewgroup)).list_txtHarga.setVisibility(0);
                    ((ViewHolder) (viewgroup)).list_txtHarga.setText((new StringBuilder()).append(hrg_baru).toString());
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

                    final ListStatAdapter this$1;
                    private final int val$position;

                    public void onClick(View view)
                    {
                        Log.e("position", String.valueOf(position));
                        if (userFunctions.isUserLoggedIn(activity))
                        {
                            pos = position;
                            statusLikeHp = "1";
                            indexhp = getListModel(position).getId_hp();
                            ponselBaseApp.getObserver().setIndexHp(getListModel(position).getCodename());
                            Log.e("getNamalengkap", getListModel(position).getCodename());
                            namalengkapbgskrg = (new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString();
                            ponselBaseApp.getObserver().setId_hp(indexhp);
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
                                (new ListStatAdapter.PostBagusKurangTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                                return;
                            } else
                            {
                                (new ListStatAdapter.PostBagusKurangTask()).execute(new Void[0]);
                                return;
                            }
                        } else
                        {
                            view = new android.app.AlertDialog.Builder(activity);
                            view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                            view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                                final ListStatAdapter._cls1 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = ListStatAdapter._cls1.this;
                super();
            }
                            });
                            view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                                final ListStatAdapter._cls1 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(activity, com/inponsel/android/v2/RegisterActivity);
                                    activity.startActivity(dialoginterface);
                                }

            
            {
                this$2 = ListStatAdapter._cls1.this;
                super();
            }
                            });
                            view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                                final ListStatAdapter._cls1 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(activity, com/inponsel/android/v2/LoginActivity);
                                    dialoginterface.putExtra("activity", "main");
                                    activity.startActivity(dialoginterface);
                                }

            
            {
                this$2 = ListStatAdapter._cls1.this;
                super();
            }
                            });
                            view.show();
                            return;
                        }
                    }


            
            {
                this$1 = final_liststatadapter;
                position = I.this;
                super();
            }
                });
                ((ViewHolder) (viewgroup)).list_lay_dislike.setOnClickListener(i. new android.view.View.OnClickListener() {

                    final ListStatAdapter this$1;
                    private final int val$position;

                    public void onClick(View view)
                    {
                        if (userFunctions.isUserLoggedIn(activity))
                        {
                            pos = position;
                            statusLikeHp = "0";
                            indexhp = getListModel(position).getId_hp();
                            ponselBaseApp.getObserver().setIndexHp(getListModel(position).getCodename());
                            Log.e("getNamalengkap", getListModel(position).getCodename());
                            namalengkapbgskrg = (new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString();
                            ponselBaseApp.getObserver().setId_hp(indexhp);
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
                                (new ListStatAdapter.PostBagusKurangTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                                return;
                            } else
                            {
                                (new ListStatAdapter.PostBagusKurangTask()).execute(new Void[0]);
                                return;
                            }
                        } else
                        {
                            view = new android.app.AlertDialog.Builder(activity);
                            view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                            view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                                final ListStatAdapter._cls2 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = ListStatAdapter._cls2.this;
                super();
            }
                            });
                            view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                                final ListStatAdapter._cls2 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(activity, com/inponsel/android/v2/RegisterActivity);
                                    activity.startActivity(dialoginterface);
                                }

            
            {
                this$2 = ListStatAdapter._cls2.this;
                super();
            }
                            });
                            view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                                final ListStatAdapter._cls2 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(activity, com/inponsel/android/v2/LoginActivity);
                                    dialoginterface.putExtra("activity", "main");
                                    activity.startActivity(dialoginterface);
                                }

            
            {
                this$2 = ListStatAdapter._cls2.this;
                super();
            }
                            });
                            view.show();
                            return;
                        }
                    }


            
            {
                this$1 = final_liststatadapter;
                position = I.this;
                super();
            }
                });
                ((ViewHolder) (viewgroup)).list_lay_kom.setOnClickListener(i. new android.view.View.OnClickListener() {

                    final ListStatAdapter this$1;
                    private final int val$position;

                    public void onClick(View view)
                    {
                        view = new Intent(getActivity(), com/inponsel/android/v2/KomentarPonsel);
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
                        getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$1 = final_liststatadapter;
                position = I.this;
                super();
            }
                });
                try
                {
                    imageLoader2.displayImage((new StringBuilder(String.valueOf(Util.BASE_PATH_NEWIMAGE))).append(lms.getGambar().trim()).toString(), ((ViewHolder) (viewgroup)).imageHp, options, viewgroup. new ImageLoadingListener() {

                        final ListStatAdapter this$1;
                        private final ListStatAdapter.ViewHolder val$holder;

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
                this$1 = final_liststatadapter;
                holder = ListStatAdapter.ViewHolder.this;
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
            Log.e("getUpdateTypeHargaHp", ponselBaseApp.getObserver().getUpdateType().toString());
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
                if (i >= listStat.getChildCount())
                {
                    return;
                }
                Log.e("int i", String.valueOf(i));
                View view = listStat.getChildAt(i);
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
            if (i >= listStat.getChildCount())
            {
                return;
            }
            Log.e("int i", String.valueOf(i));
            obj = listStat.getChildAt(i);
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



        public ListStatAdapter(Activity activity1, int i, ArrayList arraylist)
        {
            this$0 = Hal4Tahun.this;
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
            ponselBaseApp = (PonselBaseApp)getActivity().getApplication();
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
            catch (Hal4Tahun hal4tahun)
            {
                return;
            }
        }
    }

    public class ListStatAdapter.PostBagusKurangTask extends AsyncTask
    {

        final ListStatAdapter this$1;

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

        public ListStatAdapter.PostBagusKurangTask()
        {
            this$1 = ListStatAdapter.this;
            super();
        }
    }

    class ListStatAdapter.ViewHolder
    {

        LinearLayout headImage;
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
        ProgressBar progressbar_item;
        RatingBar rateRate;
        final ListStatAdapter this$1;
        TextView txtNumber;

        ListStatAdapter.ViewHolder()
        {
            this$1 = ListStatAdapter.this;
            super();
        }
    }

    private class ReStatistikTask extends AsyncTask
    {

        Response response;
        final Hal4Tahun this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            avoid = new HttpGet(dataStatistik);
            Object obj;
            int i;
            try
            {
                obj = (new DefaultHttpClient()).execute(avoid);
                i = ((HttpResponse) (obj)).getStatusLine().getStatusCode();
            }
            catch (IOException ioexception)
            {
                avoid.abort();
                return null;
            }
            if (i == 200)
            {
                break MISSING_BLOCK_LABEL_89;
            }
            Log.e(getClass().getSimpleName(), (new StringBuilder("Error ")).append(i).append(" for URL ").append(dataStatistik).toString());
            return null;
            obj = new InputStreamReader(((HttpResponse) (obj)).getEntity().getContent());
            response = (Response)(new Gson()).fromJson(((java.io.Reader) (obj)), com/inponsel/android/utils/Response);
            return null;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            super.onPostExecute(void1);
            progressbar_middle.setVisibility(8);
            layout_empty.setVisibility(8);
            statistikArray.clear();
            no = 0;
            void1 = response.InPonsel.iterator();
_L1:
            if (!void1.hasNext())
            {
                lainAdapter.notifyDataSetChanged();
                return;
            }
            try
            {
                ListModel listmodel = (ListModel)void1.next();
                Hal4Tahun hal4tahun = Hal4Tahun.this;
                hal4tahun.no = hal4tahun.no + 1;
                listmodel.setNourut(String.valueOf(no));
                statistikArray.add(listmodel);
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
        }

        private ReStatistikTask()
        {
            this$0 = Hal4Tahun.this;
            super();
        }

        ReStatistikTask(ReStatistikTask restatistiktask)
        {
            this();
        }
    }


    protected static final String TAG = com/inponsel/android/v2/BaseDrawer.getName();
    static ConnectivityManager cm;
    public static String komencount = "";
    String ads_finish;
    String ads_method;
    String ads_start;
    String ads_status;
    Button btnAdvDownload;
    Button btnLoadMore;
    Button btnLoadMoreNext;
    Button btn_pop_komen;
    Button btn_pop_login;
    String campaign;
    int charCount;
    String codename;
    String codenameKomen;
    int countAllKom;
    int countKomOld;
    Cursor cursor;
    String dataInAds;
    String dataKomen;
    String dataStatistik;
    DatabaseHandler db;
    int decimalPlace;
    DroidWriterEditText edt_pop_komen;
    String email_komentar;
    String email_user;
    Bundle extras;
    LinearLayout footerView;
    String gambar;
    String getJson;
    String getJsonLain;
    int hasilQ;
    LinearLayout headerView;
    String hrg_baru;
    String hrg_bekas;
    String id_ads;
    String id_hp;
    String id_hph;
    String id_kom;
    String id_user;
    ImageLoader imageLoaderAds;
    String image_ads;
    ImageView imgAdv;
    String indexhp;
    JSONArray inponsel;
    String isikomentar;
    MenuItem itemRefresh;
    JSONArray jArray;
    String jum_komenLikePon;
    ListStatAdapter lainAdapter;
    String lastid;
    RelativeLayout lay_adv_atas;
    LinearLayout lay_advertising;
    LinearLayout lay_pop_komen;
    LayoutInflater layoutInflater;
    LinearLayout layout_empty;
    LinearLayout layout_loading;
    LinearLayout layout_loadingNext;
    int limit;
    String link_ads;
    ListView listKomen;
    ExpandableHeightGridView listStat;
    ImageLoaderConfiguration loaderConfigurationAds;
    private DisplayImageOptions loaderoptionsAds;
    String merk;
    String model;
    String nama_asli;
    String namalengkap;
    String namalengkapbgskrg;
    int newBmapHeight;
    int newBmapWidth;
    int no;
    String no_ads;
    NotificationLikeHelper notificationLikeHelper;
    String oldid;
    String pager_pos;
    PonselBaseApp ponselBaseApp;
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
    ProgressBar progressbar_middle;
    String publisher_name;
    String querylike;
    String querypopkomen;
    String res;
    String reslike;
    ViewGroup root;
    ArrayList statistikArray;
    String statistikStrStat;
    String statuslike;
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
    TextView txtAdvDesc;
    TextView txtAdvJudul1;
    TextView txtAdvJudul2;
    TextView txt_empty;
    String urlKomen;
    String urlKomenLast;
    String urlKomenOld;
    String urutan;
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
    String userkomen;
    String username;
    String userpict;

    public Hal4Tahun()
    {
        statistikArray = null;
        postStatusLikePon = "";
        postMessageLikePon = "";
        tot_LikePon = "0";
        totdis_LikePon = "0";
        jum_komenLikePon = "0";
        indexhp = "";
        t = Utility.session(RestClient.pelihara);
        inponsel = null;
        querypopkomen = "";
        postStatus = "";
        postMessage = "";
        limit = 0;
        oldid = "";
        lastid = "0";
        urlKomen = "";
        urlKomenOld = "";
        urlKomenLast = "";
        countKomOld = 0;
        countAllKom = 0;
        getJson = "";
        getJsonLain = "";
        decimalPlace = 2;
        user_photo = "";
        username = "";
        publisher_name = "";
        title_ads = "";
        campaign = "";
        image_ads = "";
        link_ads = "";
        ads_status = "";
        sucads = "0";
        sucads2 = "0";
        pager_pos = "0";
    }

    private void Get4StatHP()
    {
        MyObjectRequest myobjectrequest = new MyObjectRequest(dataStatistik, new com.android.volley.Response.Listener() {

            final Hal4Tahun this$0;

            public volatile void onResponse(Object obj)
            {
                onResponse((JSONObject)obj);
            }

            public void onResponse(JSONObject jsonobject)
            {
                parseJSONGroupChat(jsonobject.toString());
                progressbar_middle.setVisibility(8);
                layout_empty.setVisibility(8);
                no = 0;
                lainAdapter.notifyDataSetChanged();
                Log.e("", String.valueOf(statistikArray.size()));
                listStat.setVisibility(0);
            }

            
            {
                this$0 = Hal4Tahun.this;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final Hal4Tahun this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
            }

            
            {
                this$0 = Hal4Tahun.this;
                super();
            }
        }, "test", "test");
        PonselBaseApp.getInstance().addToRequestQueue(myobjectrequest, "tag_json_obj");
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

    public void ReStatistikTask()
    {
        ReStatistikTask restatistiktask = new ReStatistikTask(null);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            restatistiktask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            restatistiktask.execute(new Void[0]);
            return;
        }
    }

    public void StatistikTask()
    {
        int i = android.os.Build.VERSION.SDK_INT;
    }

    public void fragmentBecameVisible()
    {
        if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected() && statistikArray.size() == 0)
        {
            dataInAds = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("inads").append(Utility.BASE_FORMAT).append("?pver=").append(SplashScreen.curVersion).append("&hal=P08-01").append("&t=").append(t).toString();
            layout_empty.setVisibility(0);
            Get4StatHP();
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        imgAdv.setLayoutParams(new android.widget.LinearLayout.LayoutParams(Utility.getBmapWidth(getActivity()), Utility.getBmapHeight(getActivity())));
        imgAdv.setMaxWidth(Utility.getBmapWidth(getActivity()));
        imgAdv.setMaxHeight(Utility.getBmapHeight(getActivity()));
        if (!image_ads.equals(""))
        {
            imageLoaderAds.loadImage(image_ads.replaceAll(" ", ""), new SimpleImageLoadingListener() {

                final Hal4Tahun this$0;

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
                this$0 = Hal4Tahun.this;
                super();
            }
            });
        }
        int i = configuration.orientation;
        i = configuration.orientation;
    }

    public void onCreate(Bundle bundle)
    {
        setRetainInstance(true);
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        setHasOptionsMenu(true);
        t = Utility.session(t);
        extras = getActivity().getIntent().getExtras();
        pager_pos = extras.getString("pager_pos");
        try
        {
            viewgroup = ((PonselBaseApp)getActivity().getApplication()).getTracker(com.inponsel.android.adapter.PonselBaseApp.TrackerName.APP_TRACKER);
            viewgroup.setScreenName("Hal4Tahun");
            viewgroup.send((new com.google.android.gms.analytics.HitBuilders.AppViewBuilder()).build());
        }
        // Misplaced declaration of an exception variable
        catch (ViewGroup viewgroup)
        {
            viewgroup.printStackTrace();
        }
        userFunctions = new UserFunctions();
        db = new DatabaseHandler(getActivity());
        notificationLikeHelper = new NotificationLikeHelper(getActivity());
        ponselBaseApp = (PonselBaseApp)getActivity().getApplication();
        ponselBaseApp.getObserver().addObserver(this);
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
        root = (ViewGroup)layoutinflater.inflate(0x7f0300f0, null);
        listStat = (ExpandableHeightGridView)root.findViewById(0x7f0b06f1);
        statistikArray = new ArrayList();
        listStat.setExpanded(true);
        lainAdapter = new ListStatAdapter(getActivity(), 0x7f03011b, statistikArray);
        listStat.setAdapter(lainAdapter);
        t = Utility.session(t);
        progressbar_middle = (ProgressBar)root.findViewById(0x7f0b00ca);
        layout_empty = (LinearLayout)root.findViewById(0x7f0b0091);
        layout_empty.setVisibility(8);
        txt_empty = (TextView)root.findViewById(0x7f0b0093);
        txt_empty.setText(0x7f0c0053);
        imgAdv = (ImageView)root.findViewById(0x7f0b006d);
        txtAdvJudul1 = (TextView)root.findViewById(0x7f0b006c);
        txtAdvJudul2 = (TextView)root.findViewById(0x7f0b006f);
        txtAdvDesc = (TextView)root.findViewById(0x7f0b0070);
        btnAdvDownload = (Button)root.findViewById(0x7f0b006e);
        lay_advertising = (LinearLayout)root.findViewById(0x7f0b006a);
        lay_adv_atas = (RelativeLayout)root.findViewById(0x7f0b006b);
        lay_advertising.setVisibility(8);
        imageLoaderAds = ImageLoader.getInstance();
        loaderoptionsAds = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showImageForEmptyUri(0x7f020208).cacheInMemory(true).cacheOnDisk(true).imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).build();
        loaderConfigurationAds = (new com.nostra13.universalimageloader.core.ImageLoaderConfiguration.Builder(getActivity())).defaultDisplayImageOptions(loaderoptionsAds).build();
        imageLoaderAds.init(loaderConfigurationAds);
        dataStatistik = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("stat_hp_list").append(Utility.BASE_FORMAT).append("?stat=4").append("&lmt=0&t=").append(t).append("&idusr=").append(user_id).toString();
        Log.e("dataStatistik", dataStatistik);
        listStat.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final Hal4Tahun this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                listStat.playSoundEffect(0);
                id_hph = lainAdapter.getListModel(i).getId_hp().toString();
                model = lainAdapter.getListModel(i).getModel().toString();
                merk = lainAdapter.getListModel(i).getMerk().toString();
                gambar = lainAdapter.getListModel(i).getGambar().toString();
                tot_like = lainAdapter.getListModel(i).getTotal_like().toString();
                tot_dislike = lainAdapter.getListModel(i).getTotal_dislike().toString();
                tot_komen = lainAdapter.getListModel(i).getTotal_kom().toString();
                hrg_baru = lainAdapter.getListModel(i).getHrg_baru().toString();
                hrg_bekas = lainAdapter.getListModel(i).getHrg_bekas().toString();
                codename = lainAdapter.getListModel(i).getCodename().toString();
                namalengkap = (new StringBuilder(String.valueOf(merk))).append(" ").append(model).toString();
                adapterview = new Intent(getActivity(), com/inponsel/android/details/DetailsPonsel);
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
                getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = Hal4Tahun.this;
                super();
            }
        });
        progressbar_middle.setVisibility(0);
        cm = (ConnectivityManager)getActivity().getSystemService("connectivity");
        if (pager_pos.equals("3") && cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected() && statistikArray.size() == 0)
        {
            dataInAds = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("inads").append(Utility.BASE_FORMAT).append("?pver=").append(SplashScreen.curVersion).append("&hal=P08-01").append("&t=").append(t).toString();
            layout_empty.setVisibility(0);
            Get4StatHP();
        }
        return root;
    }

    void parseJSONGroupChat(String s)
    {
        ListModel listmodel;
        int i;
        try
        {
            inponsel = (new JSONObject(s)).getJSONArray("InPonsel");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return;
        }
        i = 0;
        if (i >= inponsel.length())
        {
            return;
        }
        s = inponsel.getJSONObject(i);
        listmodel = new ListModel();
        listmodel.setId_hp(s.getString("id_hp"));
        listmodel.setModel(s.getString("model"));
        listmodel.setMerk(s.getString("merk"));
        listmodel.setCodename(s.getString("codename"));
        listmodel.setGambar(s.getString("gambar"));
        listmodel.setUmu_status(s.getString("umu_status"));
        listmodel.setHrg_baru(s.getString("hrg_baru"));
        listmodel.setHrg_bekas(s.getString("hrg_bekas"));
        listmodel.setTotal_like(s.getString("total_like"));
        listmodel.setTotal_dislike(s.getString("total_dislike"));
        listmodel.setTotal_hits(s.getString("total_hits"));
        listmodel.setTotal_kom(s.getString("total_kom"));
        listmodel.setMy_like_pon(s.getString("my_like_pon"));
        no = no + 1;
        listmodel.setNourut(String.valueOf(no));
        statistikArray.add(listmodel);
        i++;
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_20;
        }
    }

    public void scaleImage(ImageView imageview, int i)
    {
        Object obj = ((BitmapDrawable)imageview.getDrawable()).getBitmap();
        int j = ((Bitmap) (obj)).getWidth();
        int k = ((Bitmap) (obj)).getHeight();
        float f = (float)i / (float)j;
        float f1 = (float)i / (float)k;
        Object obj1;
        if (f > f1)
        {
            f = f1;
        }
        obj1 = new Matrix();
        ((Matrix) (obj1)).postScale(f, f);
        obj = Bitmap.createBitmap(((Bitmap) (obj)), 0, 0, j, k, ((Matrix) (obj1)), true);
        obj1 = new BitmapDrawable(((Bitmap) (obj)));
        i = ((Bitmap) (obj)).getWidth();
        j = ((Bitmap) (obj)).getHeight();
        imageview.setImageDrawable(((android.graphics.drawable.Drawable) (obj1)));
        obj = (android.widget.LinearLayout.LayoutParams)imageview.getLayoutParams();
        obj.width = i;
        obj.height = j;
        imageview.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
    }

    public void update(Observable observable, Object obj)
    {
        if (ponselBaseApp.getObserver().getLoginStat().equals("1") && userFunctions.isUserLoggedIn(getActivity()))
        {
            cursor = db.getAllData();
            cursor.moveToFirst();
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
    }


}
