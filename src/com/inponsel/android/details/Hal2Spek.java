// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.media.MediaScannerConnection;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.android.volley.VolleyError;
import com.facebook.CallbackManager;
import com.facebook.share.widget.ShareDialog;
import com.google.android.gms.analytics.Tracker;
import com.google.gson.Gson;
import com.inponsel.android.SplashScreen;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.adapter.ShareIntentListAdapter;
import com.inponsel.android.pencariangen.TabPencarian;
import com.inponsel.android.tlforum.ForumHPActivity;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.MyObjectRequest;
import com.inponsel.android.utils.NotificationKomenHelper;
import com.inponsel.android.utils.NotificationLikeHelper;
import com.inponsel.android.utils.Response;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.ServiceHandler;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.v2.BaseDrawer;
import com.inponsel.android.v2.DaftarPonselMerkActivity;
import com.inponsel.android.v2.ImagePagerActivity;
import com.inponsel.android.v2.KomentarPonsel;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RSSFeedByTag;
import com.inponsel.android.v2.RegisterActivity;
import com.inponsel.android.v2.RoomChatActivity;
import com.inponsel.android.v2.SCUserActivity;
import com.inponsel.android.widget.CircleProgressBar;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import fr.castorflex.android.circularprogressbar.CircularProgressBar;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
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

// Referenced classes of package com.inponsel.android.details:
//            DetailsPonsel, RivalTerdekatActivity, PilihPonselBanding, GalleriFotoHp, 
//            ProfilPTActivity, SCTerdekatActivity, TwitterInPonsel

public class Hal2Spek extends SherlockFragment
    implements Observer
{
    public class FavoritTask extends AsyncTask
    {

        final Hal2Spek this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            try
            {
                queryHp = (new StringBuilder("idhp=")).append(id_hp).append("&idusr=").append(user_id).append("&stat=").append(statFavHp).append("&t=").append(t).toString();
                pushURLHp = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("add_favhp").append(Utility.BASE_FORMAT).append("?").append(queryHp).toString();
                Log.e("pushURL", pushURLHp);
                avoid = HttpPush.getResponse(pushURLHp);
                Log.e("push", (new StringBuilder(String.valueOf(avoid))).append(queryHp).toString());
                res = avoid.toString();
                Log.e("url ", res);
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
            ponselBaseApp.getObserver().setUpdateType("sidemenufav");
            ponselBaseApp.getObserver().setLoginStat("1");
            if (res.equals("1") || res.equals("10"))
            {
                try
                {
                    db.addHP(id_hp, URLDecoder.decode(merk, "utf-8"), URLDecoder.decode(model, "utf-8"), gambar, codename);
                }
                // Misplaced declaration of an exception variable
                catch (Void void1)
                {
                    void1.printStackTrace();
                }
                if (db.getHPCount() > 0)
                {
                    Toast.makeText(getActivity(), "Berhasil menambahkan", 1).show();
                    if (sdk < 16)
                    {
                        detail_favorite.setBackgroundDrawable(drwKurang);
                    } else
                    {
                        detail_favorite.setBackground(drwKurang);
                    }
                } else
                {
                    Toast.makeText(getActivity(), "Gagal menambahkan", 1).show();
                    if (sdk < 16)
                    {
                        detail_favorite.setBackgroundDrawable(drw);
                    } else
                    {
                        detail_favorite.setBackground(drw);
                    }
                }
                mDialog.dismiss();
                return;
            }
            if (res.equals("00") || res.equals("0"))
            {
                db.deleteHP(id_hp);
                if (!db.checkIfExist(id_hp))
                {
                    Toast.makeText(getActivity(), "Berhasil menghapus", 1).show();
                    if (sdk < 16)
                    {
                        detail_favorite.setBackgroundDrawable(drw);
                    } else
                    {
                        detail_favorite.setBackground(drw);
                    }
                } else
                {
                    Toast.makeText(getActivity(), "Gagal menghapus", 1).show();
                    if (sdk < 16)
                    {
                        detail_favorite.setBackgroundDrawable(drwKurang);
                    } else
                    {
                        detail_favorite.setBackground(drwKurang);
                    }
                }
                mDialog.dismiss();
                return;
            }
            if (res.equals("40404"))
            {
                mDialog.dismiss();
                return;
            }
            Toast.makeText(getActivity(), "Gagal menambahkan", 1).show();
            if (sdk < 16)
            {
                detail_favorite.setBackgroundDrawable(drw);
                return;
            } else
            {
                detail_favorite.setBackground(drw);
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            if (statFavHp.equals("1"))
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
            this$0 = Hal2Spek.this;
            super();
        }
    }

    public class GetMyNilai extends AsyncTask
    {

        JSONArray jArray;
        final Hal2Spek this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient Void doInBackground(String as[])
        {
            int i;
            int j;
            j = as.length;
            i = 0;
_L3:
            if (i >= j)
            {
                return null;
            }
            Object obj = new RestClient(as[i]);
            ((RestClient) (obj)).Execute(com.inponsel.android.utils.RestClient.RequestMethod.GET);
_L1:
            Exception exception1;
            try
            {
                obj = ((RestClient) (obj)).getResponse();
                getJson = ((String) (obj));
                parseJSON(((String) (obj)));
            }
            catch (Exception exception) { }
            break MISSING_BLOCK_LABEL_65;
            exception1;
            exception1.printStackTrace();
              goto _L1
            i++;
            if (true) goto _L3; else goto _L2
_L2:
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
                btnDesainRate.setText(nilbtnDesain);
                btnLayarRate.setText(nilbtnLayar);
                btnKinerjaRate.setText(nilbtnKinerja);
                btnKameraRate.setText(nilbtnKamera);
                btnBateraiRate.setText(nilbtnBaterai);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
        }

        void parseJSON(String s)
        {
            int i;
            try
            {
                jArray = (new JSONObject(s)).getJSONArray("InPonsel");
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
            nilbtnDesain = s.getString("rating_hp_desain");
            nilbtnLayar = s.getString("rating_hp_layar");
            nilbtnKinerja = s.getString("rating_hp_kinerja");
            nilbtnKamera = s.getString("rating_hp_kamera");
            nilbtnBaterai = s.getString("rating_hp_baterai");
            i++;
            if (false)
            {
            } else
            {
                break MISSING_BLOCK_LABEL_19;
            }
        }

        public GetMyNilai()
        {
            this$0 = Hal2Spek.this;
            super();
        }
    }

    private class InAds2Task extends AsyncTask
    {

        final Hal2Spek this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            {
                avoid = (new ServiceHandler()).makeServiceCall(dataInAds2, 1);
                if (avoid == null)
                {
                    break MISSING_BLOCK_LABEL_291;
                }
                int i;
                try
                {
                    avoid = new JSONObject(avoid);
                    sucads2 = avoid.getString("success");
                    Log.e("sucads2", sucads2);
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
            id_ads2 = avoid.getString("id_ads");
            id_user2 = avoid.getString("id_user");
            publisher_name2 = avoid.getString("publisher_name");
            title_ads2 = avoid.getString("ads_title");
            campaign2 = avoid.getString("ads_campaign");
            no_ads2 = avoid.getString("ads_no");
            image_ads2 = (new StringBuilder(String.valueOf(Util.BASE_PATH_IKADV))).append(avoid.getString("ads_image")).toString();
            link_ads2 = avoid.getString("ads_link");
            ads_method2 = avoid.getString("ads_method");
            ads_start2 = avoid.getString("ads_start");
            ads_finish2 = avoid.getString("ads_finish");
            ads_status2 = avoid.getString("ads_status");
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
                Log.e("image_ads2spek", image_ads2.replaceAll(" ", ""));
                if (sucads2.equals("0"))
                {
                    lay_advertising2.setVisibility(8);
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
            txtAdvJudul22.setText(title_ads2);
            txtAdvDesc2.setText(campaign2);
            if (!link_ads2.contains("play.google.com")) goto _L2; else goto _L1
_L1:
            btnAdvDownload2.setText("Download");
_L3:
            if (!ads_status2.equals("0"))
            {
                break MISSING_BLOCK_LABEL_272;
            }
            lay_advertising.setVisibility(8);
_L4:
            imgAdv2.setOnClickListener(new android.view.View.OnClickListener() {

                final InAds2Task this$1;

                public void onClick(View view)
                {
                    view = new ArrayList();
                    view.add(image_ads2.replaceAll(" ", "").trim());
                    view = (String[])view.toArray(new String[view.size()]);
                    Intent intent = new Intent(getActivity(), com/inponsel/android/v2/ImagePagerActivity);
                    intent.putExtra("imgUrl", view);
                    intent.putExtra("pos", 0);
                    startActivity(intent);
                }

            
            {
                this$1 = InAds2Task.this;
                super();
            }
            });
            btnAdvDownload2.setOnClickListener(new android.view.View.OnClickListener() {

                final InAds2Task this$1;

                public void onClick(View view)
                {
                    if (link_ads2.contains("play.google.com"))
                    {
                        try
                        {
                            startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("market://details?id=")).append(link_ads2.substring(link_ads2.lastIndexOf("id=") + 3)).toString())));
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (View view)
                        {
                            startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("http://play.google.com/store/apps/details?id=")).append(link_ads2.substring(link_ads2.lastIndexOf("id=") + 3)).toString())));
                        }
                        return;
                    }
                    if (ads_method2.equals("activity"))
                    {
                        view = new Intent(getActivity(), com/inponsel/android/v2/SCUserActivity);
                        view.putExtra("activity", "main");
                        startActivityForResult(view, 0);
                        getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                        return;
                    } else
                    {
                        view = new Intent("android.intent.action.VIEW");
                        view.setData(Uri.parse(link_ads2.replaceAll(" ", "")));
                        startActivity(view);
                        return;
                    }
                }

            
            {
                this$1 = InAds2Task.this;
                super();
            }
            });
            return;
_L2:
            btnAdvDownload2.setText("Arahkan");
              goto _L3
            imageLoaderAds.displayImage(image_ads2.replaceAll(" ", ""), imgAdv2, loaderoptionsAds, new ImageLoadingListener() {

                final InAds2Task this$1;

                public void onLoadingCancelled(String s, View view)
                {
                }

                public void onLoadingComplete(String s, View view, Bitmap bitmap)
                {
                    lay_advertising2.setVisibility(0);
                    imgAdv2.setVisibility(0);
                }

                public void onLoadingFailed(String s, View view, FailReason failreason)
                {
                    lay_advertising2.setVisibility(0);
                    imgAdv2.setVisibility(0);
                }

                public void onLoadingStarted(String s, View view)
                {
                    lay_advertising2.setVisibility(8);
                    imgAdv2.setVisibility(8);
                }

            
            {
                this$1 = InAds2Task.this;
                super();
            }
            });
              goto _L4
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
        }


        private InAds2Task()
        {
            this$0 = Hal2Spek.this;
            super();
        }

        InAds2Task(InAds2Task inads2task)
        {
            this();
        }
    }

    private class InAdsTask extends AsyncTask
    {

        final Hal2Spek this$0;

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
                Log.e("image_adsspek", image_ads.replaceAll(" ", ""));
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
                    lay_advertising.setVisibility(8);
                    imgAdv.setVisibility(8);
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
            this$0 = Hal2Spek.this;
            super();
        }

        InAdsTask(InAdsTask inadstask)
        {
            this();
        }
    }

    public class PostBagusKurangTask extends AsyncTask
    {

        final Hal2Spek this$0;

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
                break MISSING_BLOCK_LABEL_56;
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
                avoid = (new StringBuilder("idhp=")).append(id_hp).append("&email=").append(username).append("&namalengkap=").append(URLEncoder.encode(namalengkap, "utf-8")).append("&status=").append(statusLikeHp).append("&t=").append(t).toString();
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
                break MISSING_BLOCK_LABEL_107;
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
            notificationLikeHelper.gagal(namalengkapbgskrg, postMessageLikePon);
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
            this$0 = Hal2Spek.this;
            super();
        }
    }

    public class PostKomen extends AsyncTask
    {

        final Hal2Spek this$0;

        private void parseJSONKom(String s)
        {
            try
            {
                s = new JSONObject(s);
                postStatus = s.getString("success");
                postMessage = s.getString("message");
                tot_LikePon = s.getString("total_like");
                totdis_LikePon = s.getString("total_dislike");
                jum_komen = s.getString("jum_komen");
                ponselBaseApp.getObserver().setJum_komenLikePon(jum_komen);
                ponselBaseApp.getObserver().setTot_LikePon(tot_LikePon);
                ponselBaseApp.getObserver().setTotdis_LikePon(totdis_LikePon);
                ponselBaseApp.getObserver().setIndexHp(codename);
                Log.e("postStatus", postStatus);
                postStatus.equals("1");
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
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("post_kom_hp").append(Utility.BASE_FORMAT).append("?").append(querypopkomen).toString();
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
label0:
            {
label1:
                {
                    super.onPostExecute(void1);
                    ponselBaseApp.getObserver().setUpdateType("komentar");
                    ponselBaseApp.getObserver().setStatus_like_ponsel("-");
                    if (postStatus.equals("1"))
                    {
                        if (!postStatus.equals("1"))
                        {
                            break label0;
                        }
                        btnKomentarHp.setText((new StringBuilder("Komentar (")).append(jum_komen).append(")").toString());
                        mNotificationHelper.completed(namalengkap, mNotificationHelper.SucdiskomStatement);
                        if (android.os.Build.VERSION.SDK_INT < 11)
                        {
                            break label1;
                        }
                        (new SendMailTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    }
                    return;
                }
                (new SendMailTask()).execute(new Void[0]);
                return;
            }
            Log.e("postStatus040", "040");
            layout_empty.setVisibility(8);
            if (postStatus.equals("040"))
            {
                mNotificationHelper.gagal(namalengkap, postMessage);
                return;
            } else
            {
                mNotificationHelper.gagal(namalengkap, mNotificationHelper.gagalkomStatement);
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            mNotificationHelper.createNotification(namalengkap, mNotificationHelper.komenPostWords);
        }

        public PostKomen()
        {
            this$0 = Hal2Spek.this;
            super();
        }
    }

    public class PostNilaiTask extends AsyncTask
    {

        final Hal2Spek this$0;

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
            namalengkap = URLEncoder.encode(namalengkap, "utf-8");
_L2:
            avoid = (new StringBuilder("idhp=")).append(id_hp).append("&email=").append(username).append("&namalengkap=").append(namalengkap).append("&").append("desain=").append(nilbtnDesain).append("&layar=").append(nilbtnLayar).append("&kinerja=").append(nilbtnKinerja).append("&apps=").append("0").append("&kamera=").append(nilbtnKamera).append("&audio=").append("0").append("&baterai=").append(nilbtnBaterai).append("&harga=").append("0").append("&t=").append(t).toString();
            avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("ratingnilaihp").append(Utility.BASE_FORMAT).append("?").append(avoid).toString();
            Log.e("pushURL", avoid);
            avoid = HttpPush.getResponse(avoid);
            res = avoid.toString();
            res = res.trim();
            res = res.replaceAll("\\s+", "");
            break MISSING_BLOCK_LABEL_334;
            avoid;
            avoid.printStackTrace();
            if (true) goto _L2; else goto _L1
_L1:
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
            try
            {
                if (res.equals("1"))
                {
                    Toast.makeText(getActivity(), 0x7f0c0061, 1).show();
                    notificationLikeHelper.completed(namalengkapbgskrg, getString(0x7f0c0061));
                    RatingAVGTask();
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
            if (res.equals("4"))
            {
                notificationLikeHelper.completed(namalengkapbgskrg, getString(0x7f0c0061));
                RatingAVGTask();
                return;
            }
            if (res.equals("3"))
            {
                notificationLikeHelper.gagal(namalengkapbgskrg, notificationLikeHelper.gagallikeStatement);
                return;
            }
            if (res.equals("1209"))
            {
                notificationLikeHelper.gagal(namalengkapbgskrg, "Anda telah memberikan nilai sama sebelumnya");
                return;
            }
            if (res.equals("K404"))
            {
                break MISSING_BLOCK_LABEL_274;
            }
            if (res.equals("U404"))
            {
                notificationLikeHelper.gagal(namalengkapbgskrg, "Username anda tidak terdaftar");
                return;
            }
            notificationLikeHelper.gagal(namalengkapbgskrg, notificationLikeHelper.gagallikeStatement);
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            notificationLikeHelper.createNotification(namalengkapbgskrg, notificationLikeHelper.nilaiStatement);
        }

        public PostNilaiTask()
        {
            this$0 = Hal2Spek.this;
            super();
        }
    }

    private class RatingAVGTask extends AsyncTask
    {

        Response response;
        final Hal2Spek this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            avoid = new HttpGet(dataRatingAVG);
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
            Log.e(getClass().getSimpleName(), (new StringBuilder("Error ")).append(i).append(" for URL ").append(dataRatingAVG).toString());
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
            void1 = response.InPonsel.iterator();
_L1:
            if (!void1.hasNext())
            {
                rata2Desain = nilai_desain;
                rata2Layar = nilai_layar;
                rata2Kinerja = nilai_kinerja;
                rata2Kamera = nilai_kamera;
                rata2Baterai = nilai_baterai;
                rataDesain.setText(oneDForm.format(Double.parseDouble(nilai_desain)));
                rataLayar.setText(oneDForm.format(Double.parseDouble(nilai_layar)));
                rataKinerja.setText(oneDForm.format(Double.parseDouble(nilai_kinerja)));
                rataKamera.setText(oneDForm.format(Double.parseDouble(nilai_kamera)));
                rataBaterai.setText(oneDForm.format(Double.parseDouble(nilai_baterai)));
                ratdobDesain = Double.parseDouble(rata2Desain) * 10D;
                ratintDesain = (int)ratdobDesain;
                ratdobLayar = Double.parseDouble(rata2Layar) * 10D;
                ratintLayar = (int)ratdobLayar;
                ratdobKinerja = Double.parseDouble(rata2Kinerja) * 10D;
                ratintKinerja = (int)ratdobKinerja;
                ratdobApps = Double.parseDouble(rata2Apps) * 10D;
                ratintApps = (int)ratdobApps;
                ratdobKamera = Double.parseDouble(rata2Kamera) * 10D;
                ratintKamera = (int)ratdobKamera;
                ratdobAudio = Double.parseDouble(rata2Audio) * 10D;
                ratintAudio = (int)ratdobAudio;
                ratdobBaterai = Double.parseDouble(rata2Baterai) * 10D;
                ratintBaterai = (int)ratdobBaterai;
                ratdobHarga = Double.parseDouble(rata2Harga) * 10D;
                ratintHarga = (int)ratdobHarga;
                ratingDesain.setAnimation(animationin);
                if (ratintDesain < 67)
                {
                    if (ratintDesain >= 34);
                }
                ratingDesain.setProgress(ratintDesain);
                ratingLayar.setAnimation(animationin);
                if (ratintLayar < 67)
                {
                    if (ratintLayar >= 34);
                }
                ratingLayar.setProgress(ratintLayar);
                ratingKinerja.setAnimation(animationin);
                if (ratintKinerja < 67)
                {
                    if (ratintKinerja >= 34);
                }
                ratingKinerja.setProgress(ratintKinerja);
                ratingKamera.setAnimation(animationin);
                if (ratintKamera < 67)
                {
                    if (ratintKamera >= 34);
                }
                ratingKamera.setProgress(ratintKamera);
                ratingBaterai.setAnimation(animationin);
                if (ratintBaterai < 67)
                {
                    if (ratintBaterai >= 34);
                }
                ratingBaterai.setProgress(ratintBaterai);
                totalVotes.isSelected();
                if (total_votes.equals("0"))
                {
                    totalVotes.setText("Total: 0 suara");
                    return;
                }
                break MISSING_BLOCK_LABEL_954;
            }
            try
            {
                ListModel listmodel = (ListModel)void1.next();
                nilai_desain = listmodel.getNilai_desain();
                nilai_layar = listmodel.getNilai_layar();
                nilai_kinerja = listmodel.getNilai_kinerja();
                nilai_kamera = listmodel.getNilai_kamera();
                nilai_baterai = listmodel.getNilai_baterai();
                nilai_overall = listmodel.getNilai_overall();
                total_votes = listmodel.getTotal_votes();
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
              goto _L1
            totalVotes.setText((new StringBuilder("Total : ")).append(nilai_overall).append(", dari ").append(total_votes).append(" suara").toString());
            return;
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
        }

        private RatingAVGTask()
        {
            this$0 = Hal2Spek.this;
            super();
        }

        RatingAVGTask(RatingAVGTask ratingavgtask)
        {
            this();
        }
    }

    public class RivalTask extends AsyncTask
    {

        final Hal2Spek this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            avoid = (new ServiceHandler()).makeServiceCall(dataRival, 1);
            jsonRival = avoid;
            Log.e("ResponseRival: ", (new StringBuilder("> ")).append(jsonRival).toString());
            if (avoid != null)
            {
                try
                {
                    avoid = new JSONObject(avoid);
                    inponsel = avoid.getJSONArray("InPonsel");
                    suc = avoid.getString("success");
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                }
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
            try
            {
                if (suc.equals("1"))
                {
                    layout_RivalTerdekat.setEnabled(true);
                    txtBigRivalTerdekat.setTextColor(Color.parseColor("#616161"));
                    layout_RivalTerdekat.setOnClickListener(new android.view.View.OnClickListener() {

                        final RivalTask this$1;

                        public void onClick(View view)
                        {
                            view = new Intent(getActivity(), com/inponsel/android/details/RivalTerdekatActivity);
                            view.putExtra("codename", codename);
                            view.putExtra("model", model);
                            view.putExtra("merk", merk);
                            view.putExtra("gambar", gambar);
                            view.putExtra("hrg_baru", hrg_baru);
                            view.putExtra("hrg_bekas", hrg_bekas);
                            view.putExtra("jsonRival", jsonRival);
                            view.putExtra("id_hp", id_hp);
                            getActivity().startActivity(view);
                            getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = RivalTask.this;
                super();
            }
                    });
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
            layout_RivalTerdekat.setEnabled(false);
            txtBigRivalTerdekat.setTextColor(Color.parseColor("#cacaca"));
            return;
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
        }


        public RivalTask()
        {
            this$0 = Hal2Spek.this;
            super();
        }
    }

    public class SaveSpec extends AsyncTask
    {

        final Hal2Spek this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            mFileTemp = createFolders();
            mFileTemp = getNextFileName();
            return null;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            super.onPostExecute(void1);
            btnSaveSpekImage.setEnabled(true);
            btnSaveSpekImage.setText("Download Halaman Spesifikasi");
            txt_namalengkap.setVisibility(8);
            imgWatermark.setVisibility(8);
            Toast.makeText(getActivity(), "Berhasil tersimpan di folder InPonsel", 1).show();
            MediaScannerConnection.scanFile(getActivity(), new String[] {
                mFileTemp.getPath()
            }, new String[] {
                "image/jpeg"
            }, null);
            txt_loadingSaveSpec.setVisibility(8);
            ll_spacekosong.setVisibility(8);
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            txt_namalengkap.setVisibility(0);
            imgWatermark.setVisibility(0);
            btnSaveSpekImage.setEnabled(false);
            btnSaveSpekImage.setText("Menyimpan...");
            txt_loadingSaveSpec.setVisibility(0);
        }

        public SaveSpec()
        {
            this$0 = Hal2Spek.this;
            super();
        }
    }

    public class SendMailTask extends AsyncTask
    {

        final Hal2Spek this$0;

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
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("mail_comment_hp").append(Utility.BASE_FORMAT).append("?").append(querypopkomen).append("&dens=").append(getResources().getDisplayMetrics().density).toString();
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
            this$0 = Hal2Spek.this;
            super();
        }
    }

    public class SpekLengkapTask extends AsyncTask
    {

        Response response;
        final Hal2Spek this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            avoid = new HttpGet(dataSpek);
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
            Log.e(getClass().getSimpleName(), (new StringBuilder("Error ")).append(i).append(" for URL ").append(dataSpek).toString());
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
            void1 = response.InPonsel.iterator();
_L20:
            if (void1.hasNext()) goto _L2; else goto _L1
_L1:
            if (!twitter.equals("")) goto _L4; else goto _L3
_L3:
            layout_Twitter.setEnabled(false);
            txtBigTwitter.setTextColor(Color.parseColor("#cacaca"));
_L21:
            if (!my_like_pon.equals("1")) goto _L6; else goto _L5
_L5:
            detail_like.setBackgroundResource(0x7f02025b);
            detail_dislike.setBackgroundResource(0x7f0201a3);
            detail_lay_like.setEnabled(false);
            detail_lay_dislike.setEnabled(true);
_L22:
            if (!tnggp_bgs.toString().equals("0") || !tnggp_krg.toString().equals("0")) goto _L8; else goto _L7
_L7:
            ratingLikeDis.setProgress(50);
            circle_LikeDis.setProgress(50F);
            Log.e("likedis", "50");
_L23:
            totalVotes.isSelected();
            Log.e("total_votes", total_votes);
            if (!statSubNews.equals("1")) goto _L10; else goto _L9
_L9:
            if (sdk >= 16) goto _L12; else goto _L11
_L11:
            detail_favoritenews.setBackgroundDrawable(drwKurang);
_L24:
            if (!total_votes.equals("0")) goto _L14; else goto _L13
_L13:
            txtValueReviewFitur.setText(Html.fromHtml("<b>Belum ada review pengunjung</b>"));
            ratingReviewFitur.setProgress(0);
            circle_ReviewFitur.setProgress(0.0F);
_L25:
            rata2Desain = nilai_desain;
            rata2Layar = nilai_layar;
            rata2Kinerja = nilai_kinerja;
            rata2Kamera = nilai_kamera;
            rata2Baterai = nilai_baterai;
            rataDesain.setText(oneDForm.format(Double.parseDouble(nilai_desain)));
            rataLayar.setText(oneDForm.format(Double.parseDouble(nilai_layar)));
            rataKinerja.setText(oneDForm.format(Double.parseDouble(nilai_kinerja)));
            rataKamera.setText(oneDForm.format(Double.parseDouble(nilai_kamera)));
            rataBaterai.setText(oneDForm.format(Double.parseDouble(nilai_baterai)));
            ratdobDesain = Double.parseDouble(rata2Desain) * 10D;
            ratintDesain = (int)ratdobDesain;
            ratdobLayar = Double.parseDouble(rata2Layar) * 10D;
            ratintLayar = (int)ratdobLayar;
            ratdobKinerja = Double.parseDouble(rata2Kinerja) * 10D;
            ratintKinerja = (int)ratdobKinerja;
            ratdobApps = Double.parseDouble(rata2Apps) * 10D;
            ratintApps = (int)ratdobApps;
            ratdobKamera = Double.parseDouble(rata2Kamera) * 10D;
            ratintKamera = (int)ratdobKamera;
            ratdobAudio = Double.parseDouble(rata2Audio) * 10D;
            ratintAudio = (int)ratdobAudio;
            ratdobBaterai = Double.parseDouble(rata2Baterai) * 10D;
            ratintBaterai = (int)ratdobBaterai;
            ratdobHarga = Double.parseDouble(rata2Harga) * 10D;
            ratintHarga = (int)ratdobHarga;
            ratingDesain.setAnimation(animationin);
            if (ratintDesain < 67)
            {
                if (ratintDesain >= 34);
            }
            ratingDesain.setProgress(ratintDesain);
            ratingLayar.setAnimation(animationin);
            if (ratintLayar < 67)
            {
                if (ratintLayar >= 34);
            }
            ratingLayar.setProgress(ratintLayar);
            ratingKinerja.setAnimation(animationin);
            if (ratintKinerja < 67)
            {
                if (ratintKinerja >= 34);
            }
            ratingKinerja.setProgress(ratintKinerja);
            ratingKamera.setAnimation(animationin);
            if (ratintKamera < 67)
            {
                if (ratintKamera >= 34);
            }
            ratingKamera.setProgress(ratintKamera);
            ratingBaterai.setAnimation(animationin);
            if (ratintBaterai < 67)
            {
                if (ratintBaterai >= 34);
            }
            ratingBaterai.setProgress(ratintBaterai);
            totalVotes.isSelected();
            if (!total_votes.equals("0")) goto _L16; else goto _L15
_L15:
            totalVotes.setText("Total: 0 suara");
_L26:
            detail_txtMerek.setText(namalengkap);
            imageLoader2.displayImage(gambar.trim(), imgHpDetail, options, new ImageLoadingListener() {

                final SpekLengkapTask this$1;

                public void onLoadingCancelled(String s, View view)
                {
                }

                public void onLoadingComplete(String s, View view, Bitmap bitmap)
                {
                    det_prog_item.setVisibility(8);
                    imgHpDetail.setVisibility(0);
                }

                public void onLoadingFailed(String s, View view, FailReason failreason)
                {
                    det_prog_item.setVisibility(8);
                    imgHpDetail.setVisibility(0);
                }

                public void onLoadingStarted(String s, View view)
                {
                    det_prog_item.setVisibility(0);
                    imgHpDetail.setVisibility(8);
                }

            
            {
                this$1 = SpekLengkapTask.this;
                super();
            }
            });
            Log.e("total_hitspek", total_hits);
            detail_text_like.setText(tnggp_bgs);
            detail_text_dislike.setText(tnggp_krg);
            Hal2Spek.detail_text_komentar.setText(jml_komentar);
            btnKomentarHp.setText((new StringBuilder("Komentar (")).append(jml_komentar).append(")").toString());
            txtBigKomentarHp.setText((new StringBuilder("Komentar (")).append(jml_komentar).append(")").toString());
            if (jar_2g_status.equals("1"))
            {
                void1 = Hal2Spek.this;
                void1.str_share_desc = (new StringBuilder(String.valueOf(((Hal2Spek) (void1)).str_share_desc))).append("2G").toString();
            }
            if (jar_3g_status.equals("1"))
            {
                void1 = Hal2Spek.this;
                void1.str_share_desc = (new StringBuilder(String.valueOf(((Hal2Spek) (void1)).str_share_desc))).append(". 3G").toString();
            }
            if (jar_4g_status.equals("1"))
            {
                void1 = Hal2Spek.this;
                void1.str_share_desc = (new StringBuilder(String.valueOf(((Hal2Spek) (void1)).str_share_desc))).append(". 4G").toString();
            }
            if (!lay_size_diagonal.equals("") && !lay_size_diagonal.equals("-") && !lay_size_ppi.equals("-") && !lay_size_ppi.equals("")) goto _L18; else goto _L17
_L17:
            edtLayarUkuran.setText("");
_L27:
            if (id_hp.equals("-"))
            {
                txt_empty.setText("Gagal terhubung ke server");
                midProgressBar.setVisibility(8);
                return;
            }
              goto _L19
_L2:
            try
            {
                ListModel listmodel = (ListModel)void1.next();
                id_hp = listmodel.getId_hp();
                gambar = listmodel.getGambar();
                model = listmodel.getModel();
                id_merk = listmodel.getId_merk();
                twitter = listmodel.getTwitter();
                merk = listmodel.getMerk();
                codename = listmodel.getCodename();
                namalengkap = listmodel.getNamalengkap();
                jml_komentar = listmodel.getJml_komentar();
                tot_komen = listmodel.getJml_komentar();
                tnggp_bgs = listmodel.getTnggp_bgs().toString();
                tnggp_krg = listmodel.getTnggp_krg().toString();
                str_urlspekshare = listmodel.getUrl_share().toString();
                my_like_pon = listmodel.getMy_like_pon();
                total_hits = listmodel.getTotal_hits();
                ketamb = listmodel.getKetamb();
                jar_2g_status = listmodel.getJar_2g_status();
                jar_2g_gsm_status = listmodel.getJar_2g_gsm_status();
                jar_2g_gsm = listmodel.getJar_2g_gsm();
                jar_2g_cdma_status = listmodel.getJar_2g_cdma_status();
                jar_2g_cdma = listmodel.getJar_2g_cdma();
                jar_3g_status = listmodel.getJar_3g_status();
                jar_3g = listmodel.getJar_3g();
                jar_4g_status = listmodel.getJar_4g_status();
                jar_4g = listmodel.getJar_4g();
                jar_gprs_status = listmodel.getJar_gprs_status();
                jar_gprs = listmodel.getJar_gprs();
                jar_edge_status = listmodel.getJar_edge_status();
                jar_edge = listmodel.getJar_edge();
                jar_multi_status = listmodel.getJar_multi_status();
                jar_multi_ket = listmodel.getJar_multi_ket();
                jar_multi_tipe1 = listmodel.getJar_multi_tipe1();
                jar_multi_tipe2 = listmodel.getJar_multi_tipe2();
                jar_dualon = listmodel.getJar_dualon();
                jar_sc = listmodel.getJar_sc();
                jar_sc_ket = listmodel.getJar_sc_ket();
                jar_bwidth = listmodel.getJar_bwidth();
                umu_dim_panjang = listmodel.getUmu_dim_panjang();
                umu_dim_lebar = listmodel.getUmu_dim_lebar();
                umu_dim_tebal = listmodel.getUmu_dim_tebal();
                umu_dim_ket = listmodel.getUmu_dim_ket();
                umu_bobot = listmodel.getUmu_bobot();
                umu_bobot_ket = listmodel.getUmu_bobot_ket();
                umu_diumumkan_sta = listmodel.getUmu_diumumkan_sta();
                umu_diumumkan = listmodel.getUmu_diumumkan();
                umu_status = listmodel.getUmu_status();
                umu_status_ket = listmodel.getUmu_status_ket();
                umu_model = listmodel.getUmu_model();
                umu_warna_ponsel = listmodel.getUmu_warna_ponsel();
                lay_size_diagonal = listmodel.getLay_size_diagonal();
                lay_size_vertikal = listmodel.getLay_size_vertikal();
                lay_size_horizontal = listmodel.getLay_size_horizontal();
                lay_size_diagonal_ket = listmodel.getLay_size_diagonal_ket();
                lay_size_ppi = listmodel.getLay_size_ppi();
                lay_tipe_layar = listmodel.getLay_tipe_layar();
                lay_size_status = listmodel.getLay_size_status();
                lay_touchscreen = listmodel.getLay_touchscreen();
                lay_touchscreen_status = listmodel.getLay_touchscreen_status();
                lay_warna_layar = listmodel.getLay_warna_layar();
                lay_warna_ket = listmodel.getLay_warna_ket();
                lay_sensor = listmodel.getLay_sensor();
                lay_sensor_status = listmodel.getLay_sensor_status();
                lay_proteksi = listmodel.getLay_proteksi();
                lay_proteksi_status = listmodel.getLay_proteksi_status();
                lay_multitouch = listmodel.getLay_multitouch();
                lay_multitouch_status = listmodel.getLay_multitouch_status();
                lay_ext = listmodel.getLay_ext();
                lay_tambahan = listmodel.getLay_tambahan();
                mem_all_ket = listmodel.getMem_all_ket();
                hard_all_ket = listmodel.getHard_all_ket();
                har_info = listmodel.getHar_info();
                har_chipset = listmodel.getHar_chipset();
                har_cpu_core = listmodel.getHar_cpu_core();
                har_cpu_clock = listmodel.getHar_cpu_clock();
                har_cpu_jenpros = listmodel.getHar_cpu_jenpros();
                har_gpu = listmodel.getHar_gpu();
                sof_os = listmodel.getSof_os();
                sof_os_versi = listmodel.getSof_os_versi();
                sof_java = listmodel.getSof_java();
                sof_java_status = listmodel.getSof_java_status();
                kam_utama = listmodel.getKam_utama();
                kam_utama_ket = listmodel.getKam_utama_ket();
                kam_utama2 = listmodel.getKam_utama2();
                kam_utama_status = listmodel.getKam_utama_status();
                kam_led_flash_status = listmodel.getKam_led_flash_status();
                kam_led_flash = listmodel.getKam_led_flash();
                kam_fitur = listmodel.getKam_fitur();
                kam_video = listmodel.getKam_video();
                kam_video_status = listmodel.getKam_video_status();
                kam_video_hd = listmodel.getKam_video_hd();
                kam_depan = listmodel.getKam_depan();
                kam_depan_status = listmodel.getKam_depan_status();
                kam_nat_vcall = listmodel.getKam_nat_vcall();
                mem_internal = listmodel.getMem_internal();
                mem_eksternal = listmodel.getMem_eksternal();
                mem_eksternal_kap = listmodel.getMem_eksternal_kap();
                mem_eksternal_s = listmodel.getMem_eksternal_s();
                mem_ram = listmodel.getMem_ram();
                mem_rom = listmodel.getMem_rom();
                mem_internal_ket = listmodel.getMem_internal_ket();
                mem_ram_ket = listmodel.getMem_ram_ket();
                mem_rom_ket = listmodel.getMem_rom_ket();
                mem_ekternal_ket = listmodel.getMem_ekternal_ket();
                internal = listmodel.getMem_all();
                mem_phonebook = listmodel.getMem_phonebook();
                kon_wlan = listmodel.getKon_wlan();
                kon_wlan_status = listmodel.getKon_wlan_status();
                kon_bluetooth = listmodel.getKon_bluetooth();
                kon_bluetooth_status = listmodel.getKon_bluetooth_status();
                kon_usb = listmodel.getKon_usb();
                kon_usb_status = listmodel.getKon_usb_status();
                kon_35mm_jack = listmodel.getKon_35mm_jack();
                kon_35mm_jack_ket = listmodel.getKon_35mm_jack_ket();
                kon_infrared = listmodel.getKon_infrared();
                kon_infrared_ket = listmodel.getKon_infrared_ket();
                kon_hdmi_status = listmodel.getKon_hdmi_status();
                kon_hdmi = listmodel.getKon_hdmi();
                kon_tvoutput_status = listmodel.getKon_tvoutput_status();
                kon_tvoutput = listmodel.getKon_tvoutput();
                kon_nfc = listmodel.getKon_nfc();
                kon_nfc_status = listmodel.getKon_nfc_status();
                fit_musik_status = listmodel.getFit_musik_status();
                fit_musik = listmodel.getFit_musik();
                fit_radio_status = listmodel.getFit_radio_status();
                fit_radio = listmodel.getFit_radio();
                fit_gps_status = listmodel.getFit_gps_status();
                fit_gps = listmodel.getFit_gps();
                fit_tvanalog = listmodel.getFit_tvanalog();
                fit_tvanalog_ket = listmodel.getFit_tvanalog_ket();
                fit_browser_status = listmodel.getFit_browser_status();
                fit_browser = listmodel.getFit_browser();
                fit_pesan = listmodel.getFit_pesan();
                fit_lain = listmodel.getFit_lain();
                bat_kapasitas = listmodel.getBat_kapasitas();
                bat_kapasitas_s = listmodel.getBat_kapasitas_s();
                bat_model = listmodel.getBat_model();
                bat_bicara = listmodel.getBat_bicara();
                bat_siaga = listmodel.getBat_siaga();
                bat_musik = listmodel.getBat_musik();
                hrg_baru = listmodel.getHrg_baru();
                hrg_bekas = listmodel.getHrg_bekas();
                har_infotmbh = listmodel.getInfo_tambahan();
                sta_garansi = listmodel.getSta_garansi();
                update_harga = listmodel.getUpdate_harga();
                nilai_desain = listmodel.getNilai_desain();
                nilai_layar = listmodel.getNilai_layar();
                nilai_kinerja = listmodel.getNilai_kinerja();
                nilai_kamera = listmodel.getNilai_kamera();
                nilai_baterai = listmodel.getNilai_baterai();
                nilai_overall = listmodel.getNilai_overall();
                total_votes = listmodel.getTotal_votes();
                total_hits = listmodel.getTotal_hits();
                statSubNews = listmodel.getSubs_status();
                likepersen = listmodel.getLikepersen().toString();
                spekArray.add(listmodel);
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                void1.printStackTrace();
                layout_empty.setVisibility(0);
                midProgressBar.setVisibility(8);
                txt_empty.setVisibility(8);
                btnRefresh.setVisibility(0);
                return;
            }
              goto _L20
_L4:
            txtBigTwitter.setText((new StringBuilder("Twitter ")).append(twitter).toString());
              goto _L21
_L6:
label0:
            {
                if (!my_like_pon.equals("0"))
                {
                    break label0;
                }
                detail_like.setBackgroundResource(0x7f020257);
                detail_dislike.setBackgroundResource(0x7f0201a7);
                detail_lay_like.setEnabled(true);
                detail_lay_dislike.setEnabled(false);
            }
              goto _L22
            detail_like.setBackgroundResource(0x7f020257);
            detail_dislike.setBackgroundResource(0x7f0201a3);
            detail_lay_like.setEnabled(true);
            detail_lay_dislike.setEnabled(true);
              goto _L22
_L8:
            float f = Integer.parseInt(tnggp_bgs);
            f /= f + (float)Integer.parseInt(tnggp_krg);
            Log.e("likedis", String.valueOf(f));
            ratintLikeDis = Math.round(100F * f);
            ratingLikeDis.setProgress(ratintLikeDis);
            circle_LikeDis.setProgress(ratintLikeDis);
              goto _L23
_L12:
            detail_favoritenews.setBackground(drwKurang);
              goto _L24
_L10:
label1:
            {
                if (sdk >= 16)
                {
                    break label1;
                }
                detail_favoritenews.setBackgroundDrawable(drw);
            }
              goto _L24
            detail_favoritenews.setBackground(drw);
              goto _L24
_L14:
            txtValueReviewFitur.setText(Html.fromHtml((new StringBuilder("<b>Review pengunjung</b> ")).append(nilai_overall).append(" (").append(total_votes).append(" suara)").toString()));
            Log.e("nilai_overall", (new StringBuilder(String.valueOf(nilai_overall))).append(" : ").append(String.valueOf(10F - Float.parseFloat(nilai_overall))).toString());
            txtPercentReviewFitur.setText(nilai_overall);
            ratingReviewFitur.setProgress(Math.round(Float.parseFloat(nilai_overall)));
            circle_ReviewFitur.setProgress(Math.round(Float.parseFloat(nilai_overall)));
              goto _L25
_L16:
            totalVotes.setText((new StringBuilder("Total : ")).append(nilai_overall).append(", dari ").append(total_votes).append(" suara").toString());
              goto _L26
_L18:
label2:
            {
                int i = Math.round(Float.parseFloat(lay_size_ppi));
                lay_size_ppi = String.valueOf(i);
                if (!lay_size_diagonal_ket.equals(""))
                {
                    break label2;
                }
                edtLayarUkuran.setText((new StringBuilder(String.valueOf(lay_size_diagonal))).append(" inch, ").append(lay_size_horizontal).append(" x ").append(lay_size_vertikal).append(" pixels (").append(lay_size_ppi).append(" ppi)").toString());
                void1 = Hal2Spek.this;
                void1.str_share_desc = (new StringBuilder(String.valueOf(((Hal2Spek) (void1)).str_share_desc))).append(", ").append(lay_size_diagonal).append(" inch, ").append(lay_size_horizontal).append(" x ").append(lay_size_vertikal).append(" pixels (").append(lay_size_ppi).append(" ppi)").toString();
            }
              goto _L27
            edtLayarUkuran.setText((new StringBuilder(String.valueOf(lay_size_diagonal))).append(" inch, ").append(lay_size_horizontal).append(" x ").append(lay_size_vertikal).append(" pixels (").append(lay_size_ppi).append(" ppi)").append(" (").append(lay_size_diagonal_ket).append(")").toString());
            void1 = Hal2Spek.this;
            void1.str_share_desc = (new StringBuilder(String.valueOf(((Hal2Spek) (void1)).str_share_desc))).append(", ").append(lay_size_diagonal).append(" inch, ").append(lay_size_horizontal).append(" x ").append(lay_size_vertikal).append(" pixels (").append(lay_size_ppi).append(" ppi)").append(" (").append(lay_size_diagonal_ket).append(")").toString();
              goto _L27
_L19:
            layout_empty.setVisibility(8);
            linIkhtisar.setVisibility(0);
            btnShowComment.setText((new StringBuilder("Baca komentar (")).append(jml_komentar).append(")").toString());
            if (ketamb.equals("") || ketamb.equals("-"))
            {
                spek_head_ketamb.setVisibility(8);
            }
            ketamb = ketamb.replace("\n", "\n\u2022 ");
            edtKeteranganTambahan.setText((new StringBuilder("\u2022 ")).append(ketamb).toString());
            if (!jar_2g_gsm_status.equals("1") || !jar_2g_cdma_status.equals("1")) goto _L29; else goto _L28
_L28:
            edtJar2g.setText((new StringBuilder("GSM ")).append(jar_2g_gsm).append("\nCDMA ").append(jar_2g_cdma).toString());
_L136:
            if (!jar_3g_status.equals("2") && !jar_3g_status.equals("3")) goto _L31; else goto _L30
_L30:
            edtJar3g.setText("Tidak");
_L137:
            if (jar_4g_status.equals("2") || jar_4g_status.equals("3"))
            {
                spek_head_4g.setVisibility(8);
            }
            edtJar4g.setText((new StringBuilder(String.valueOf(jar_4g))).toString());
            if (!jar_gprs_status.equals("2")) goto _L33; else goto _L32
_L32:
            edtJarGPRS.setText("Tidak");
_L138:
            if (!jar_edge_status.equals("2")) goto _L35; else goto _L34
_L34:
            edtJarEdge.setText("Tidak");
_L139:
            if (jar_bwidth.equals(""))
            {
                spek_head_Bandwidth.setVisibility(8);
            }
            edtJarBandwidth.setText(jar_bwidth);
            if (jar_sc.equals(""))
            {
                spek_head_SIM.setVisibility(8);
            }
            if (!jar_sc_ket.equals("")) goto _L37; else goto _L36
_L36:
            edtJarSimCard.setText(jar_sc);
_L140:
            if (!jar_multi_status.equals("2")) goto _L39; else goto _L38
_L38:
            spek_head_MultiSIM.setVisibility(8);
_L141:
            umu_model = umu_model.replace("1", "Bar");
            umu_model = umu_model.replace("2", "Flip");
            umu_model = umu_model.replace("3", "Swivel");
            umu_model = umu_model.replace("4", "Slide");
            umu_model = umu_model.replace("5", "QWERTY");
            umu_model = umu_model.replace("6", "Full Touchscreen");
            umu_model = umu_model.replace("7", "Touchscreen & Keyboard");
            umu_model = umu_model.replace("8", "Tablet PC");
            if (!umu_dim_panjang.equals("") && !umu_dim_lebar.equals("") && !umu_dim_tebal.equals("") && !umu_dim_panjang.equals("-") && !umu_dim_lebar.equals("-") && !umu_dim_tebal.equals("-")) goto _L41; else goto _L40
_L40:
            edtUmumDim.setText("");
_L142:
            if (!umu_bobot.equals("") && !umu_bobot.equals("-")) goto _L43; else goto _L42
_L42:
            edtUmumBobot.setText("");
            spek_head_Bobot.setVisibility(8);
_L143:
            if (umu_warna_ponsel.equals(""))
            {
                spek_head_Warna.setVisibility(8);
            }
            edtUmumWarna.setText(umu_warna_ponsel);
            if (!umu_status.equals("5") && !umu_status.toLowerCase().equals("rumor")) goto _L45; else goto _L44
_L44:
            edtUmumDiUm.setText("");
_L144:
            edtUmumStatus.setText(umu_status);
            if (!lay_tipe_layar.equals("")) goto _L47; else goto _L46
_L46:
            if (!lay_warna_ket.equals("")) goto _L49; else goto _L48
_L48:
            edtLayarTipe.setText((new StringBuilder(String.valueOf(lay_touchscreen))).append(lay_warna_layar).toString());
            void1 = Hal2Spek.this;
            void1.str_share_desc = (new StringBuilder(String.valueOf(((Hal2Spek) (void1)).str_share_desc))).append(", ").append(lay_touchscreen).append(lay_warna_layar).toString();
_L145:
            if (!lay_multitouch_status.equals("1") || lay_multitouch.equals("")) goto _L51; else goto _L50
_L50:
            edtLayarMultitouch.setText((new StringBuilder("Ya, ")).append(lay_multitouch).toString());
_L146:
            if (mem_all_ket.equals("")) goto _L53; else goto _L52
_L52:
            spek_head_MemoriAllKet.setVisibility(0);
            mem_all_ket = mem_all_ket.replace("\n", "\n\u2022 ");
            edtMemoriAllKet.setText((new StringBuilder("\u2022 ")).append(mem_all_ket).toString());
_L150:
            if (hard_all_ket.equals("")) goto _L55; else goto _L54
_L54:
            spek_head_hard_ket.setVisibility(0);
            hard_all_ket = hard_all_ket.replace("\n", "\n\u2022 ");
            edtHardAllKet.setText((new StringBuilder("\u2022 ")).append(hard_all_ket).toString());
_L151:
            if (lay_ext.equals("")) goto _L57; else goto _L56
_L56:
            spek_head_Lay_EXT.setVisibility(0);
            lay_ext = lay_ext.replace("\n", "\n\u2022 ");
            edtLayarEXT.setText((new StringBuilder("\u2022 ")).append(lay_ext).toString());
_L152:
            if (lay_tambahan.equals("")) goto _L59; else goto _L58
_L58:
            spek_head_Lay_Tambahan.setVisibility(0);
            lay_tambahan = lay_tambahan.replace("\n", "\n\u2022 ");
            edtLayarTambahan.setText((new StringBuilder("\u2022 ")).append(lay_tambahan).toString());
_L153:
            if (!lay_sensor.equals("")) goto _L61; else goto _L60
_L60:
            spek_head_Sensor.setVisibility(8);
_L154:
            if (!lay_proteksi_status.equals("1")) goto _L63; else goto _L62
_L62:
            edtLayarProteksi.setText((new StringBuilder("Ya, ")).append(lay_proteksi).toString());
_L155:
            if (har_info.equals("2"))
            {
                parentHardware.setVisibility(8);
            }
            if (!har_chipset.equals("")) goto _L65; else goto _L64
_L64:
            spek_head_Chipset.setVisibility(8);
_L156:
            if (!har_gpu.equals("")) goto _L67; else goto _L66
_L66:
            spek_head_GPU.setVisibility(8);
_L157:
            edtSoftOS.setText((new StringBuilder(String.valueOf(sof_os))).append(sof_os_versi).toString());
            if (!sof_java_status.equals("1") || sof_java.equals("")) goto _L69; else goto _L68
_L68:
            edtSoftJava.setText((new StringBuilder("Ya, ")).append(sof_java).toString());
_L158:
            if (kam_utama_status.equals("2")) goto _L71; else goto _L70
_L70:
            if (!kam_utama.equals("0.3")) goto _L73; else goto _L72
_L72:
            if (!kam_utama_ket.equals("")) goto _L75; else goto _L74
_L74:
            edtKameraUtama.setText("VGA");
            void1 = Hal2Spek.this;
            void1.str_share_desc = (new StringBuilder(String.valueOf(((Hal2Spek) (void1)).str_share_desc))).append(", VGA").toString();
_L159:
            if (!har_cpu_clock.equals("") || !har_cpu_jenpros.equals("")) goto _L77; else goto _L76
_L76:
            edtHardCPU.setText("");
_L160:
            if (!kam_led_flash_status.equals("1")) goto _L79; else goto _L78
_L78:
            if (kam_led_flash.equals("")) goto _L81; else goto _L80
_L80:
            edtKameraLamKil.setText((new StringBuilder("Ya, ")).append(kam_led_flash).toString());
_L161:
            if (!kam_fitur.equals("")) goto _L83; else goto _L82
_L82:
            spek_head_FitKam.setVisibility(8);
_L162:
            if (!kam_video_status.equals("1") || kam_video.equals("") || kam_video_hd.equals("") && kam_video_hd.equals("N/A")) goto _L85; else goto _L84
_L84:
            edtKameraVidRec.setText((new StringBuilder("Ya, ")).append(kam_video).toString());
_L163:
            if (!kam_depan_status.equals("2")) goto _L87; else goto _L86
_L86:
            edtKameraDepan.setText("Tidak");
_L167:
            if (!kam_nat_vcall.equals("1")) goto _L89; else goto _L88
_L88:
            edtNatVidCall.setText("Ya");
_L168:
            edtMemoriInternal.setText(internal);
            Log.e("mem_eksternal_s", mem_eksternal_s);
            if (!mem_eksternal_s.equals("2")) goto _L91; else goto _L90
_L90:
            edtMemoriExternal.setText("Tidak");
_L171:
            spek_head_MemPhoneBook.setVisibility(8);
            if (!kon_bluetooth_status.equals("1") || !kon_bluetooth.equals("")) goto _L93; else goto _L92
_L92:
            edtKonekBlue.setText("Ya");
_L176:
            if (!kon_usb_status.equals("1") || !kon_usb.equals("")) goto _L95; else goto _L94
_L94:
            edtKonekUSB.setText("Ya");
_L177:
            if (!kon_35mm_jack.equals("1")) goto _L97; else goto _L96
_L96:
            if (!kon_35mm_jack_ket.equals("")) goto _L99; else goto _L98
_L98:
            edtKonek35Jack.setText("Ya");
_L178:
            if (!kon_wlan_status.equals("1") || !kon_wlan.equals("")) goto _L101; else goto _L100
_L100:
            edtKonekWLAN.setText("Ya");
_L179:
            if (!kon_nfc_status.equals("3")) goto _L103; else goto _L102
_L102:
            spek_head_NFC.setVisibility(8);
_L180:
            if (!kon_hdmi_status.equals("3")) goto _L105; else goto _L104
_L104:
            spek_head_HDMI.setVisibility(8);
_L184:
            if (!kon_tvoutput_status.equals("3")) goto _L107; else goto _L106
_L106:
            spek_head_TV.setVisibility(8);
_L188:
            if (!kon_infrared.equals("1")) goto _L109; else goto _L108
_L108:
            if (!kon_infrared_ket.equals("")) goto _L111; else goto _L110
_L110:
            edtKonekInfrared.setText("Ya");
_L192:
            if (!fit_musik_status.equals("1") || fit_musik.equals("")) goto _L113; else goto _L112
_L112:
            edtLain2Musik.setText((new StringBuilder("Ya, ")).append(fit_musik).toString());
_L193:
            if (!fit_radio_status.equals("1") || fit_radio.equals("")) goto _L115; else goto _L114
_L114:
            edtLain2Radio.setText((new StringBuilder("Ya, ")).append(fit_radio).toString());
_L194:
            if (!fit_tvanalog.equals("1") || fit_tvanalog_ket.equals("")) goto _L117; else goto _L116
_L116:
            edtLain2Analog.setText((new StringBuilder("Ya (")).append(fit_tvanalog_ket).append(")").toString());
_L195:
            if (!fit_gps_status.equals("1") || fit_gps.equals("")) goto _L119; else goto _L118
_L118:
            edtLain2GPS.setText((new StringBuilder("GPS Built-in, ")).append(fit_gps).toString());
_L196:
            if (!fit_browser_status.equals("1") || fit_browser.equals("")) goto _L121; else goto _L120
_L120:
            edtLain2Browser.setText((new StringBuilder()).append(fit_browser).toString());
_L197:
            if (fit_pesan.equals("")) goto _L123; else goto _L122
_L122:
            edtLain2Pesan.setText((new StringBuilder()).append(fit_pesan).toString());
_L198:
            if (!fit_lain.equals("")) goto _L125; else goto _L124
_L124:
            edtLain2Fiturlain.setText("");
_L199:
            if (bat_kapasitas.equals("")) goto _L127; else goto _L126
_L126:
            edtBatJenis.setText((new StringBuilder(String.valueOf(bat_kapasitas_s))).append(" ").append(bat_kapasitas).append(" mAh").toString());
_L200:
            if (!bat_bicara.equals("")) goto _L129; else goto _L128
_L128:
            edtBatBicara.setText("Tidak ada informasi");
_L201:
            if (!bat_siaga.equals("")) goto _L131; else goto _L130
_L130:
            edtBatSiaga.setText("Tidak ada informasi");
_L202:
            if (!bat_musik.equals("")) goto _L133; else goto _L132
_L132:
            spek_head_BateraiIsiBox.setVisibility(8);
_L203:
            try
            {
                void1 = (new SimpleDateFormat("yyyy-MM-dd")).parse(update_harga);
                SimpleDateFormat simpledateformat = new SimpleDateFormat("d MMMM yyyy", Locale.US);
                tgglHarga = simpledateformat.format(void1);
                tgglHarga = tgglHarga.replace("January", "Januari");
                tgglHarga = tgglHarga.replace("February", "Februari");
                tgglHarga = tgglHarga.replace("March", "Maret");
                tgglHarga = tgglHarga.replace("April", "April");
                tgglHarga = tgglHarga.replace("May", "Mei");
                tgglHarga = tgglHarga.replace("June", "Juni");
                tgglHarga = tgglHarga.replace("July", "Juli");
                tgglHarga = tgglHarga.replace("August", "Agustus");
                tgglHarga = tgglHarga.replace("September", "September");
                tgglHarga = tgglHarga.replace("October", "Oktober");
                tgglHarga = tgglHarga.replace("November", "November");
                tgglHarga = tgglHarga.replace("December", "Desember");
            }
            // Misplaced declaration of an exception variable
            catch (Void void1) { }
            if (!umu_status.equals("Dihentikan") || !hrg_bekas.equals("") && hrg_bekas != null) goto _L135; else goto _L134
_L134:
            spek_head_Garansi.setVisibility(8);
_L204:
            if (!likepersen.equals(""))
            {
                break MISSING_BLOCK_LABEL_14994;
            }
            lay_Ketertarikan.setVisibility(8);
_L205:
            txtBigHpLain.setText((new StringBuilder("Ponsel ")).append(merk).append(" lainnya").toString());
            ll_tinjauan_pengunjung.setVisibility(0);
            ll_menu_bottom_spek.setVisibility(0);
            ll_report_hp.setVisibility(8);
            edtHargaBaru.setText((new StringBuilder()).append(hrg_baru).toString());
            edtHargaBekas.setText((new StringBuilder()).append(hrg_bekas).toString());
            dataRival = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("details_list_rival").append(Utility.BASE_FORMAT).append("?hmin=").append(hargaBawah).append("&hmax=").append(hargaAtas).append("&lmin=").append(disBawah).append("&lmax=").append(disAtas).append("&idhp=").append(id_hp).append("&limit=").append("0").append("&t=").append(t).append("&idusr=").append(user_id).toString();
            Log.e("urlRival", dataRival);
            if (umu_status.equals("3") || umu_status.equals("Dihentikan") || edtHargaBaru.getText().toString().equals(""))
            {
                layout_RivalTerdekat.setVisibility(0);
                layout_RivalTerdekat.setEnabled(false);
                txtBigRivalTerdekat.setTextColor(Color.parseColor("#cacaca"));
                Log.e("RivalTask", "0");
                return;
            }
            break MISSING_BLOCK_LABEL_15107;
_L29:
label3:
            {
                if (!jar_2g_gsm_status.equals("1"))
                {
                    break label3;
                }
                edtJar2g.setText((new StringBuilder("GSM ")).append(jar_2g_gsm).toString());
            }
              goto _L136
label4:
            {
                if (!jar_2g_cdma_status.equals("1"))
                {
                    break label4;
                }
                edtJar2g.setText((new StringBuilder("CDMA ")).append(jar_2g_cdma).toString());
            }
              goto _L136
            edtJar2g.setText("Tidak");
              goto _L136
_L31:
            edtJar3g.setText((new StringBuilder(String.valueOf(jar_3g))).toString());
              goto _L137
_L33:
label5:
            {
                if (!jar_gprs_status.equals("3"))
                {
                    break label5;
                }
                edtJarGPRS.setText("");
            }
              goto _L138
label6:
            {
                if (!jar_gprs.equals(""))
                {
                    break label6;
                }
                edtJarGPRS.setText("Ya");
            }
              goto _L138
            edtJarGPRS.setText((new StringBuilder("Ya, ")).append(jar_gprs).toString());
              goto _L138
_L35:
label7:
            {
                if (!jar_edge_status.equals("3"))
                {
                    break label7;
                }
                edtJarEdge.setText("");
            }
              goto _L139
label8:
            {
                if (!jar_edge.equals(""))
                {
                    break label8;
                }
                edtJarEdge.setText("Ya");
            }
              goto _L139
            edtJarEdge.setText((new StringBuilder("Ya, ")).append(jar_edge).toString());
              goto _L139
_L37:
            edtJarSimCard.setText((new StringBuilder(String.valueOf(jar_sc))).append(" (").append(jar_sc_ket).append(")").toString());
              goto _L140
_L39:
label9:
            {
                if (!jar_multi_status.equals("3"))
                {
                    break label9;
                }
                edtJarMultiSimCard.setText("");
            }
              goto _L141
label10:
            {
                if (!jar_multi_tipe1.equals("0"))
                {
                    break label10;
                }
                spek_head_MultiSIM.setVisibility(8);
            }
              goto _L141
label11:
            {
                if (!jar_multi_ket.equals(""))
                {
                    break label11;
                }
                edtJarMultiSimCard.setText((new StringBuilder()).append(jar_multi_tipe2).append(jar_dualon).toString());
            }
              goto _L141
            edtJarMultiSimCard.setText((new StringBuilder()).append(jar_multi_tipe2).append(jar_dualon).append(" (").append(jar_multi_ket).append(")").toString());
              goto _L141
_L41:
label12:
            {
                if (!umu_dim_ket.equals(""))
                {
                    break label12;
                }
                edtUmumDim.setText((new StringBuilder(String.valueOf(umu_dim_panjang))).append(" x ").append(umu_dim_lebar).append(" x ").append(umu_dim_tebal).append(" mm").toString());
            }
              goto _L142
            edtUmumDim.setText((new StringBuilder(String.valueOf(umu_dim_panjang))).append(" x ").append(umu_dim_lebar).append(" x ").append(umu_dim_tebal).append(" mm").append(" (").append(umu_dim_ket).append(")").toString());
              goto _L142
_L43:
            edtUmumBobot.setText((new StringBuilder(String.valueOf(umu_bobot))).append(" gram").toString());
              goto _L143
_L45:
            try
            {
                void1 = (new SimpleDateFormat("yyyy-MM-dd")).parse(umu_diumumkan);
                void1 = (new SimpleDateFormat("MMMM yyyy", Locale.US)).format(void1).replace("January", "Januari,").replace("February", "Februari,").replace("March", "Maret,").replace("April", "April,").replace("May", "Mei,").replace("June", "Juni,").replace("July", "Juli,").replace("August", "Agustus,").replace("September", "September,").replace("October", "Oktober,").replace("November", "November,").replace("December", "Desember,");
                str_share_diumumkan = void1;
                edtUmumDiUm.setText(void1);
            }
            // Misplaced declaration of an exception variable
            catch (Void void1) { }
              goto _L144
_L49:
            edtLayarTipe.setText((new StringBuilder(String.valueOf(lay_touchscreen))).append(lay_warna_layar).append(" (").append(lay_warna_ket).append(")").toString());
            void1 = Hal2Spek.this;
            void1.str_share_desc = (new StringBuilder(String.valueOf(((Hal2Spek) (void1)).str_share_desc))).append(", ").append(lay_touchscreen).append(lay_warna_layar).append(" (").append(lay_warna_ket).append(")").toString();
              goto _L145
_L47:
label13:
            {
                if (!lay_touchscreen.equals(""))
                {
                    break MISSING_BLOCK_LABEL_9699;
                }
                if (!lay_warna_ket.equals(""))
                {
                    break label13;
                }
                edtLayarTipe.setText((new StringBuilder(String.valueOf(lay_tipe_layar))).append(" ").append(lay_touchscreen).append(lay_warna_layar).toString());
                void1 = Hal2Spek.this;
                void1.str_share_desc = (new StringBuilder(String.valueOf(((Hal2Spek) (void1)).str_share_desc))).append(", ").append(lay_tipe_layar).append(" ").append(lay_touchscreen).append(lay_warna_layar).toString();
            }
              goto _L145
            edtLayarTipe.setText((new StringBuilder(String.valueOf(lay_tipe_layar))).append(" ").append(lay_touchscreen).append(lay_warna_layar).append(" (").append(lay_warna_ket).append(")").toString());
            void1 = Hal2Spek.this;
            void1.str_share_desc = (new StringBuilder(String.valueOf(((Hal2Spek) (void1)).str_share_desc))).append(", ").append(lay_tipe_layar).append(" ").append(lay_touchscreen).append(lay_warna_layar).append(" (").append(lay_warna_ket).append(")").toString();
              goto _L145
label14:
            {
                if (!lay_warna_ket.equals(""))
                {
                    break label14;
                }
                edtLayarTipe.setText((new StringBuilder(String.valueOf(lay_tipe_layar))).append(" ").append(lay_touchscreen).append(lay_warna_layar).toString());
                void1 = Hal2Spek.this;
                void1.str_share_desc = (new StringBuilder(String.valueOf(((Hal2Spek) (void1)).str_share_desc))).append(", ").append(lay_tipe_layar).append(" ").append(lay_touchscreen).append(lay_warna_layar).toString();
            }
              goto _L145
            edtLayarTipe.setText((new StringBuilder(String.valueOf(lay_tipe_layar))).append(" ").append(lay_touchscreen).append(lay_warna_layar).append(" (").append(lay_warna_ket).append(")").toString());
            void1 = Hal2Spek.this;
            void1.str_share_desc = (new StringBuilder(String.valueOf(((Hal2Spek) (void1)).str_share_desc))).append(", ").append(lay_tipe_layar).append(" ").append(lay_touchscreen).append(lay_warna_layar).append(" (").append(lay_warna_ket).append(")").toString();
              goto _L145
_L51:
label15:
            {
                if (!lay_multitouch.equals("") || !lay_multitouch_status.equals("1"))
                {
                    break label15;
                }
                edtLayarMultitouch.setText("Ya");
            }
              goto _L146
            if (!lay_multitouch_status.equals("2") && !lay_touchscreen_status.equals("2")) goto _L148; else goto _L147
_L147:
            spek_head_Multitouch.setVisibility(8);
              goto _L146
_L148:
            if (!lay_multitouch_status.equals("3")) goto _L146; else goto _L149
_L149:
            spek_head_Multitouch.setVisibility(8);
              goto _L146
_L53:
            spek_head_MemoriAllKet.setVisibility(8);
              goto _L150
_L55:
            spek_head_hard_ket.setVisibility(8);
              goto _L151
_L57:
            spek_head_Lay_EXT.setVisibility(8);
              goto _L152
_L59:
            spek_head_Lay_Tambahan.setVisibility(8);
              goto _L153
_L61:
label16:
            {
                if (!lay_sensor.equals("2"))
                {
                    break label16;
                }
                spek_head_Sensor.setVisibility(8);
            }
              goto _L154
            lay_sensor = lay_sensor.replace("1", "Accelerometer");
            lay_sensor = lay_sensor.replace("2", "");
            lay_sensor = lay_sensor.replace("3", "Proximity");
            lay_sensor = lay_sensor.replace("4", "Ambient");
            lay_sensor = lay_sensor.replace("5", "Gyro Sensor");
            lay_sensor = lay_sensor.replace("6", "Compass");
            lay_sensor = lay_sensor.replace("7", "Barometer");
            lay_sensor = lay_sensor.replace("8", "RGB Sensor");
            lay_sensor = lay_sensor.replace("9", "Magnetometer");
            edtLayarSensor.setText(lay_sensor);
              goto _L154
_L63:
label17:
            {
                if (!lay_proteksi_status.equals("2") && !lay_proteksi_status.equals("3"))
                {
                    break label17;
                }
                spek_head_Proteksi.setVisibility(8);
            }
              goto _L155
            spek_head_Proteksi.setVisibility(8);
              goto _L155
_L65:
            edtHardChipset.setText(har_chipset);
              goto _L156
_L67:
            edtHardGPU.setText(har_gpu);
              goto _L157
_L69:
label18:
            {
                if (!sof_java_status.equals("1") || !sof_java.equals(""))
                {
                    break label18;
                }
                edtSoftJava.setText("Ya");
            }
              goto _L158
label19:
            {
                if (!sof_java_status.equals("2"))
                {
                    break label19;
                }
                edtSoftJava.setText("Tidak");
            }
              goto _L158
            edtSoftJava.setText("");
              goto _L158
_L75:
            edtKameraUtama.setText((new StringBuilder("VGA (")).append(kam_utama_ket).append(")").toString());
            void1 = Hal2Spek.this;
            void1.str_share_desc = (new StringBuilder(String.valueOf(((Hal2Spek) (void1)).str_share_desc))).append(", VGA (").append(kam_utama_ket).append(")").toString();
              goto _L159
_L73:
label20:
            {
                if (kam_utama_status.equals("2") || !kam_utama.equals(""))
                {
                    break MISSING_BLOCK_LABEL_10841;
                }
                if (!kam_utama_ket.equals(""))
                {
                    break label20;
                }
                edtKameraUtama.setText("Ya");
            }
              goto _L159
            edtKameraUtama.setText((new StringBuilder("Ya (")).append(kam_utama_ket).append(")").toString());
              goto _L159
label21:
            {
                if (kam_utama.equals("") || !kam_utama2.equals(""))
                {
                    break MISSING_BLOCK_LABEL_11104;
                }
                if (!kam_utama_ket.equals(""))
                {
                    break label21;
                }
                edtKameraUtama.setText((new StringBuilder(String.valueOf(kam_utama))).append(" MP").toString());
                void1 = Hal2Spek.this;
                void1.str_share_desc = (new StringBuilder(String.valueOf(((Hal2Spek) (void1)).str_share_desc))).append(", ").append(kam_utama).append(" MP").toString();
            }
              goto _L159
            edtKameraUtama.setText((new StringBuilder(String.valueOf(kam_utama))).append(" MP").append(" (").append(kam_utama_ket).append(")").toString());
            void1 = Hal2Spek.this;
            void1.str_share_desc = (new StringBuilder(String.valueOf(((Hal2Spek) (void1)).str_share_desc))).append(", ").append(kam_utama).append(" MP").append(" (").append(kam_utama_ket).append(")").toString();
              goto _L159
label22:
            {
                if (!kam_utama_ket.equals(""))
                {
                    break label22;
                }
                edtKameraUtama.setText((new StringBuilder(String.valueOf(kam_utama))).append(" MP, ").append(kam_utama2).append(" pixels").toString());
                void1 = Hal2Spek.this;
                void1.str_share_desc = (new StringBuilder(String.valueOf(((Hal2Spek) (void1)).str_share_desc))).append(", ").append(kam_utama).append(" MP, ").append(kam_utama2).append(" pixels").toString();
            }
              goto _L159
            edtKameraUtama.setText((new StringBuilder(String.valueOf(kam_utama))).append(" MP, ").append(kam_utama2).append(" pixels").append(" (").append(kam_utama_ket).append(")").toString());
            void1 = Hal2Spek.this;
            void1.str_share_desc = (new StringBuilder(String.valueOf(((Hal2Spek) (void1)).str_share_desc))).append(", ").append(kam_utama).append(" MP, ").append(kam_utama2).append(" pixels").append(" (").append(kam_utama_ket).append(")").toString();
              goto _L159
_L71:
            edtKameraUtama.setText("Tidak");
              goto _L159
_L77:
label23:
            {
                if (!har_cpu_jenpros.equals(""))
                {
                    break label23;
                }
                edtHardCPU.setText((new StringBuilder(String.valueOf(har_cpu_core))).append(" ").append(har_cpu_clock).toString());
                void1 = Hal2Spek.this;
                void1.str_share_desc = (new StringBuilder(String.valueOf(((Hal2Spek) (void1)).str_share_desc))).append(", ").append(har_cpu_core).append(" ").append(har_cpu_clock).toString();
            }
              goto _L160
            edtHardCPU.setText((new StringBuilder(String.valueOf(har_cpu_core))).append(" ").append(har_cpu_clock).append(", ").append(har_cpu_jenpros).toString());
            void1 = Hal2Spek.this;
            void1.str_share_desc = (new StringBuilder(String.valueOf(((Hal2Spek) (void1)).str_share_desc))).append(", ").append(har_cpu_core).append(" ").append(har_cpu_clock).append(", ").append(har_cpu_jenpros).toString();
              goto _L160
_L81:
label24:
            {
                if (!kam_led_flash_status.equals("2"))
                {
                    break label24;
                }
                edtKameraLamKil.setText("Tidak");
            }
              goto _L161
label25:
            {
                if (!kam_led_flash.equals(""))
                {
                    break label25;
                }
                edtKameraLamKil.setText("Ya");
            }
              goto _L161
            spek_head_LamKil.setVisibility(8);
              goto _L161
_L79:
label26:
            {
                if (!kam_led_flash_status.equals("2"))
                {
                    break label26;
                }
                edtKameraLamKil.setText("Tidak");
            }
              goto _L161
            spek_head_LamKil.setVisibility(8);
              goto _L161
_L83:
            edtKameraFitKam.setText(kam_fitur);
              goto _L162
_L85:
label27:
            {
                if (!kam_video_status.equals("1") || kam_video.equals(""))
                {
                    break label27;
                }
                edtKameraVidRec.setText((new StringBuilder("Ya, ")).append(kam_video).toString());
            }
              goto _L163
label28:
            {
                if (!kam_video_status.equals("1") || !kam_video.equals(""))
                {
                    break label28;
                }
                edtKameraVidRec.setText("Ya");
            }
              goto _L163
            if (!kam_video_status.equals("2")) goto _L165; else goto _L164
_L164:
            spek_head_VidRec.setVisibility(8);
              goto _L163
_L165:
            if (!kam_video_status.equals("3")) goto _L163; else goto _L166
_L166:
            spek_head_VidRec.setVisibility(8);
              goto _L163
_L87:
label29:
            {
                if (!kam_depan_status.equals("1") || !kam_nat_vcall.equals("1") || kam_depan.equals(""))
                {
                    break label29;
                }
                edtKameraDepan.setText((new StringBuilder("Ya, ")).append(kam_depan).append(", ").append("mendukung native video call").toString());
            }
              goto _L167
label30:
            {
                if (!kam_depan_status.equals("1") || !kam_nat_vcall.equals("1"))
                {
                    break label30;
                }
                edtKameraDepan.setText("Ya, mendukung native video call");
            }
              goto _L167
label31:
            {
                if (!kam_depan_status.equals("1") || kam_depan.equals(""))
                {
                    break label31;
                }
                edtKameraDepan.setText((new StringBuilder("Ya, ")).append(kam_depan).toString());
            }
              goto _L167
label32:
            {
                if (!kam_depan_status.equals("1"))
                {
                    break label32;
                }
                edtKameraDepan.setText("Ya");
            }
              goto _L167
            edtKameraDepan.setText("");
              goto _L167
_L89:
label33:
            {
                if (!kam_nat_vcall.equals("2"))
                {
                    break label33;
                }
                spek_head_NatVidCall.setVisibility(8);
            }
              goto _L168
            spek_head_NatVidCall.setVisibility(8);
              goto _L168
_L91:
            if (!mem_eksternal_kap.equals("1")) goto _L170; else goto _L169
_L169:
            mem_eksternal_kap = "2 GB";
_L172:
            if (mem_eksternal.equals("") || mem_eksternal_kap.equals(""))
            {
                break MISSING_BLOCK_LABEL_12773;
            }
            if (!mem_ekternal_ket.equals(""))
            {
                break MISSING_BLOCK_LABEL_12702;
            }
            edtMemoriExternal.setText((new StringBuilder(String.valueOf(mem_eksternal))).append(", hingga ").append(mem_eksternal_kap).toString());
              goto _L171
_L170:
label34:
            {
                if (!mem_eksternal_kap.equals("2"))
                {
                    break label34;
                }
                mem_eksternal_kap = "4 GB";
            }
              goto _L172
label35:
            {
                if (!mem_eksternal_kap.equals("3"))
                {
                    break label35;
                }
                mem_eksternal_kap = "8 GB";
            }
              goto _L172
label36:
            {
                if (!mem_eksternal_kap.equals("4"))
                {
                    break label36;
                }
                mem_eksternal_kap = "16 GB";
            }
              goto _L172
label37:
            {
                if (!mem_eksternal_kap.equals("5"))
                {
                    break label37;
                }
                mem_eksternal_kap = "32 GB";
            }
              goto _L172
label38:
            {
                if (!mem_eksternal_kap.equals("6"))
                {
                    break label38;
                }
                mem_eksternal_kap = "64 GB";
            }
              goto _L172
label39:
            {
                if (!mem_eksternal_kap.equals("7"))
                {
                    break label39;
                }
                mem_eksternal_kap = "128 GB";
            }
              goto _L172
label40:
            {
                if (!mem_eksternal_kap.equals("8"))
                {
                    break label40;
                }
                mem_eksternal_kap = "256 GB";
            }
              goto _L172
label41:
            {
                if (!mem_eksternal_kap.equals("9"))
                {
                    break label41;
                }
                mem_eksternal_kap = "512 GB";
            }
              goto _L172
            if (!mem_eksternal_kap.equals("10")) goto _L174; else goto _L173
_L173:
            mem_eksternal_kap = "1 TB";
              goto _L172
_L174:
            if (!mem_eksternal_kap.equals("100")) goto _L172; else goto _L175
_L175:
            mem_eksternal_kap = "";
              goto _L172
            edtMemoriExternal.setText((new StringBuilder(String.valueOf(mem_eksternal))).append(", hingga ").append(mem_eksternal_kap).append(" (").append(mem_ekternal_ket).append(")").toString());
              goto _L171
label42:
            {
                if (!mem_eksternal_s.equals("2"))
                {
                    break label42;
                }
                edtMemoriExternal.setText("Tidak");
            }
              goto _L171
label43:
            {
                if (!mem_eksternal_kap.equals(""))
                {
                    break MISSING_BLOCK_LABEL_12910;
                }
                if (!mem_ekternal_ket.equals(""))
                {
                    break label43;
                }
                edtMemoriExternal.setText(mem_eksternal);
            }
              goto _L171
            edtMemoriExternal.setText((new StringBuilder(String.valueOf(mem_eksternal))).append(" (").append(mem_ekternal_ket).append(")").toString());
              goto _L171
            edtMemoriExternal.setText("");
              goto _L171
_L93:
label44:
            {
                if (!kon_bluetooth_status.equals("1") || kon_bluetooth.equals(""))
                {
                    break label44;
                }
                edtKonekBlue.setText((new StringBuilder("Ya, ")).append(kon_bluetooth).toString());
            }
              goto _L176
label45:
            {
                if (!kon_bluetooth_status.equals("2"))
                {
                    break label45;
                }
                edtKonekBlue.setText("Tidak");
            }
              goto _L176
            edtKonekBlue.setText("");
              goto _L176
_L95:
label46:
            {
                if (!kon_usb_status.equals("1") || kon_usb.equals(""))
                {
                    break label46;
                }
                edtKonekUSB.setText((new StringBuilder("Ya, ")).append(kon_usb).toString());
            }
              goto _L177
label47:
            {
                if (!kon_usb_status.equals("2"))
                {
                    break label47;
                }
                edtKonekUSB.setText("Tidak");
            }
              goto _L177
            edtKonekUSB.setText("");
              goto _L177
_L99:
            edtKonek35Jack.setText((new StringBuilder("Ya (")).append(kon_35mm_jack_ket).append(")").toString());
              goto _L178
_L97:
label48:
            {
                if (!kon_35mm_jack.equals("2"))
                {
                    break label48;
                }
                edtKonek35Jack.setText("Tidak");
            }
              goto _L178
            edtKonek35Jack.setText("");
              goto _L178
_L101:
label49:
            {
                if (!kon_wlan_status.equals("1") || kon_wlan.equals(""))
                {
                    break label49;
                }
                edtKonekWLAN.setText((new StringBuilder()).append(kon_wlan).toString());
            }
              goto _L179
label50:
            {
                if (!kon_wlan_status.equals("2"))
                {
                    break label50;
                }
                edtKonekWLAN.setText("Tidak");
            }
              goto _L179
            edtKonekWLAN.setText("");
              goto _L179
_L103:
label51:
            {
                if (!kon_nfc_status.equals("1") || kon_nfc.equals(""))
                {
                    break label51;
                }
                edtKonekNFC.setText((new StringBuilder("Ya, ")).append(kon_nfc).toString());
            }
              goto _L180
            if (!kon_nfc_status.equals("1")) goto _L182; else goto _L181
_L181:
            edtKonekNFC.setText("Ya");
              goto _L180
_L182:
            if (!kon_nfc_status.equals("2")) goto _L180; else goto _L183
_L183:
            spek_head_NFC.setVisibility(8);
              goto _L180
_L105:
label52:
            {
                if (!kon_hdmi_status.equals("1") || kon_hdmi.equals(""))
                {
                    break label52;
                }
                edtKonekHDMI.setText((new StringBuilder("Ya, ")).append(kon_hdmi).toString());
            }
              goto _L184
            if (!kon_hdmi_status.equals("1")) goto _L186; else goto _L185
_L185:
            edtKonekHDMI.setText("Ya");
              goto _L184
_L186:
            if (!kon_hdmi_status.equals("2")) goto _L184; else goto _L187
_L187:
            spek_head_HDMI.setVisibility(8);
              goto _L184
_L107:
label53:
            {
                if (!kon_tvoutput_status.equals("1") || kon_tvoutput.equals(""))
                {
                    break label53;
                }
                edtKonekTV.setText((new StringBuilder("Ya, ")).append(kon_tvoutput).toString());
            }
              goto _L188
            if (!kon_tvoutput_status.equals("1")) goto _L190; else goto _L189
_L189:
            edtKonekTV.setText("Ya");
              goto _L188
_L190:
            if (!kon_tvoutput_status.equals("2")) goto _L188; else goto _L191
_L191:
            spek_head_TV.setVisibility(8);
              goto _L188
_L111:
            edtKonekInfrared.setText((new StringBuilder("Ya (")).append(kon_infrared_ket).append(")").toString());
              goto _L192
_L109:
label54:
            {
                if (!kon_infrared.equals("2"))
                {
                    break label54;
                }
                spek_head_Infrared.setVisibility(8);
            }
              goto _L192
            spek_head_Infrared.setVisibility(8);
              goto _L192
_L113:
label55:
            {
                if (!fit_musik_status.equals("1") || !fit_musik.equals(""))
                {
                    break label55;
                }
                edtLain2Musik.setText("Ya");
            }
              goto _L193
label56:
            {
                if (!fit_musik_status.equals("2"))
                {
                    break label56;
                }
                edtLain2Musik.setText("Tidak");
            }
              goto _L193
            edtLain2Musik.setText("");
              goto _L193
_L115:
label57:
            {
                if (!fit_radio_status.equals("1") || !fit_radio.equals(""))
                {
                    break label57;
                }
                edtLain2Radio.setText("Ya");
            }
              goto _L194
label58:
            {
                if (!fit_radio_status.equals("2"))
                {
                    break label58;
                }
                edtLain2Radio.setText("Tidak");
            }
              goto _L194
            edtLain2Radio.setText("");
              goto _L194
_L117:
label59:
            {
                if (!fit_tvanalog.equals("1") || !fit_tvanalog_ket.equals(""))
                {
                    break label59;
                }
                edtLain2Analog.setText("Ya");
            }
              goto _L195
label60:
            {
                if (!fit_tvanalog.equals("2"))
                {
                    break label60;
                }
                spek_head_TVAnalog.setVisibility(8);
            }
              goto _L195
            spek_head_TVAnalog.setVisibility(8);
              goto _L195
_L119:
label61:
            {
                if (!fit_gps_status.equals("1") || !fit_gps.equals(""))
                {
                    break label61;
                }
                edtLain2GPS.setText("Ya");
            }
              goto _L196
label62:
            {
                if (!fit_gps_status.equals("2"))
                {
                    break label62;
                }
                edtLain2GPS.setText("Tidak");
            }
              goto _L196
            edtLain2GPS.setText("");
              goto _L196
_L121:
label63:
            {
                if (!fit_browser_status.equals("1") || !fit_browser.equals(""))
                {
                    break label63;
                }
                edtLain2Browser.setText("Ya");
            }
              goto _L197
label64:
            {
                if (!fit_browser_status.equals("2"))
                {
                    break label64;
                }
                edtLain2Browser.setText("Tidak");
            }
              goto _L197
            edtLain2Browser.setText("");
              goto _L197
_L123:
label65:
            {
                if (!fit_pesan.equals(""))
                {
                    break label65;
                }
                edtLain2Pesan.setText("Ya");
            }
              goto _L198
            edtLain2Pesan.setText("Tidak");
              goto _L198
_L125:
            fit_lain = fit_lain.replace("\n", "\n\u2022 ");
            edtLain2Fiturlain.setText((new StringBuilder("\u2022 ")).append(fit_lain).toString());
              goto _L199
_L127:
label66:
            {
                if (bat_model.equals("") || bat_model.equals(""))
                {
                    break label66;
                }
                edtBatJenis.setText((new StringBuilder(String.valueOf(bat_kapasitas_s))).append(" ").append(bat_kapasitas).append(" mAh, ").append(bat_model).toString());
            }
              goto _L200
            edtBatJenis.setText("");
              goto _L200
_L129:
            edtBatBicara.setText(bat_bicara);
              goto _L201
_L131:
            edtBatSiaga.setText(bat_siaga);
              goto _L202
_L133:
            spek_head_BateraiIsiBox.setVisibility(0);
            edtBatIsiBox.setText(bat_musik);
              goto _L203
_L135:
label67:
            {
                if (!update_harga.equals("") && !update_harga.equals("-") && !update_harga.equals("0000-00-00"))
                {
                    break label67;
                }
                edtHargaGaransi.setText("");
                spek_head_Garansi.setVisibility(8);
            }
              goto _L204
label68:
            {
                if (!sta_garansi.equals("NA") && !sta_garansi.equals("-") || update_harga.equals("-") && update_harga.equals(""))
                {
                    break label68;
                }
                edtHargaGaransi.setText((new StringBuilder("Diperbarui ")).append(tgglHarga).toString());
            }
              goto _L204
label69:
            {
                if (sta_garansi.equals("0") && sta_garansi.equals("") && sta_garansi.equals("-") || !har_infotmbh.equals(""))
                {
                    break label69;
                }
                edtHargaGaransi.setText((new StringBuilder(String.valueOf(sta_garansi))).append("; Diperbarui ").append(tgglHarga).toString());
            }
              goto _L204
label70:
            {
                if (sta_garansi.equals("0") && sta_garansi.equals("-") || har_infotmbh.equals(""))
                {
                    break label70;
                }
                edtHargaGaransi.setText((new StringBuilder(String.valueOf(sta_garansi))).append(" (").append(har_infotmbh).append("); Diperbarui ").append(tgglHarga).toString());
            }
              goto _L204
            edtHargaGaransi.setText("");
            spek_head_Garansi.setVisibility(8);
              goto _L204
            txtValueKetertarikan.setText(Html.fromHtml((new StringBuilder("<b>Ketertarikan</b> ")).append(likepersen).append("% (").append(tnggp_bgs).append(" likes, ").append(tnggp_krg).append(" dislikes)").toString()));
            txtPercentKetertarikan.setText((new StringBuilder(String.valueOf(likepersen))).append("%").toString());
              goto _L205
            Log.e("RivalTask", "1");
            (new RivalTask()).execute(new Void[0]);
            return;
              goto _L20
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
        }


        public SpekLengkapTask()
        {
            this$0 = Hal2Spek.this;
            super();
        }
    }

    public class SubsNewsTask extends AsyncTask
    {

        final Hal2Spek this$0;

        private void parseJSONSubsNews(String s)
        {
            try
            {
                s = new JSONObject(s);
                postStatusSubsNews = s.getString("success");
                postMessageSubsNews = s.getString("message");
                jArray = s.getJSONArray("InPonsel");
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
                queryNews = (new StringBuilder("idhp=")).append(id_hp).append("&idusr=").append(user_id).append("&stat=").append(statSubNews).append("&t=").append(t).toString();
                pushURLNews = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("add_subscribe_news").append(Utility.BASE_FORMAT).append("?").append(queryNews).toString();
                Log.e("pushURL", pushURLNews);
                avoid = HttpPush.getResponse(pushURLNews);
                Log.e("push", (new StringBuilder(String.valueOf(avoid))).append(queryNews).toString());
                res = avoid.toString();
                Log.e("url ", res);
                parseJSONSubsNews(res);
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
            if (postStatusSubsNews.equals("1") || postStatusSubsNews.equals("10"))
            {
                Toast.makeText(getActivity(), postMessageSubsNews, 1).show();
                if (statSubNews.equals("1"))
                {
                    if (sdk < 16)
                    {
                        detail_favoritenews.setBackgroundDrawable(drwKurang);
                    } else
                    {
                        detail_favoritenews.setBackground(drwKurang);
                    }
                } else
                if (sdk < 16)
                {
                    detail_favoritenews.setBackgroundDrawable(drw);
                } else
                {
                    detail_favoritenews.setBackground(drw);
                }
                mDialog.dismiss();
                return;
            }
            if (postStatusSubsNews.equals("00") || postStatusSubsNews.equals("0"))
            {
                Toast.makeText(getActivity(), postMessageSubsNews, 1).show();
                if (statSubNews.equals("1"))
                {
                    if (sdk < 16)
                    {
                        detail_favoritenews.setBackgroundDrawable(drwKurang);
                    } else
                    {
                        detail_favoritenews.setBackground(drwKurang);
                    }
                } else
                if (sdk < 16)
                {
                    detail_favoritenews.setBackgroundDrawable(drw);
                } else
                {
                    detail_favoritenews.setBackground(drw);
                }
                mDialog.dismiss();
                return;
            }
            if (postStatusSubsNews.equals("40404"))
            {
                mDialog.dismiss();
                return;
            }
            Toast.makeText(getActivity(), postMessageSubsNews, 1).show();
            if (sdk < 16)
            {
                detail_favorite.setBackgroundDrawable(drw);
                return;
            } else
            {
                detail_favorite.setBackground(drw);
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            if (statSubNews.equals("1"))
            {
                mDialog = ProgressDialog.show(getActivity(), "", "Menambahkan...", true);
            } else
            {
                mDialog = ProgressDialog.show(getActivity(), "", "Menghapus...", true);
            }
            mDialog.setCancelable(true);
            mDialog.show();
        }

        public SubsNewsTask()
        {
            this$0 = Hal2Spek.this;
            super();
        }
    }


    private static final String FOLDER_NAME = "InPonsel";
    protected static final String TAG = com/inponsel/android/v2/BaseDrawer.getName();
    public static String TEMP_PHOTO_FILE_NAME = "";
    public static TextView detail_text_komentar;
    double DratdobApps;
    double DratdobAudio;
    double DratdobBaterai;
    double DratdobDesain;
    double DratdobHarga;
    double DratdobKamera;
    double DratdobKinerja;
    double DratdobLayar;
    double DratdobLikeDis;
    String ads_finish;
    String ads_finish2;
    String ads_method;
    String ads_method2;
    String ads_start;
    String ads_start2;
    String ads_status;
    String ads_status2;
    Animation animation;
    Animation animationin;
    Animation animationout;
    String bat_bicara;
    String bat_kapasitas;
    String bat_kapasitas_s;
    String bat_model;
    String bat_musik;
    String bat_siaga;
    Button btnAddKomentarHp;
    Button btnAdvDownload;
    Button btnAdvDownload2;
    TextView btnBACA;
    TextView btnBandingkan;
    Button btnBateraiRate;
    TextView btnBerikan;
    Button btnCancel;
    Button btnDesainRate;
    Button btnKameraRate;
    Button btnKinerjaRate;
    Button btnKirimError;
    Button btnKirimNilai;
    Button btnKomentarHp;
    Button btnLayarRate;
    Button btnRefresh;
    Button btnReportInCorrect;
    Button btnSaveSpekImage;
    TextView btnShowComment;
    Button btnSubmit;
    Calendar calendar;
    CallbackManager callbackManager;
    String campaign;
    String campaign2;
    int charCount;
    CircleProgressBar circle_LikeDis;
    CircleProgressBar circle_ReviewFitur;
    ConnectivityManager cm;
    String codename;
    Cursor cursor;
    String dataInAds;
    String dataInAds2;
    String dataNilai;
    String dataRatingAVG;
    String dataRival;
    String dataSpek;
    DatabaseHandler db;
    int decimal2;
    int decimalPlace;
    int decmem;
    ProgressBar det_prog_item;
    ImageView detail_dislike;
    ImageView detail_favorite;
    ImageView detail_favoritenews;
    RelativeLayout detail_lay_dislike;
    RelativeLayout detail_lay_kom;
    RelativeLayout detail_lay_like;
    ImageView detail_like;
    TextView detail_text_dislike;
    TextView detail_text_like;
    TextView detail_txtMerek;
    String details;
    double disAtas;
    double disBawah;
    Drawable drw;
    Drawable drwKurang;
    EditText edtBatBicara;
    EditText edtBatIsiBox;
    EditText edtBatJenis;
    EditText edtBatSiaga;
    EditText edtComment;
    EditText edtHardAllKet;
    EditText edtHardCPU;
    EditText edtHardChipset;
    EditText edtHardGPU;
    EditText edtHargaBaru;
    EditText edtHargaBekas;
    EditText edtHargaGaransi;
    EditText edtHargaInfoTamb;
    EditText edtJar2g;
    EditText edtJar3g;
    EditText edtJar4g;
    EditText edtJarBandwidth;
    EditText edtJarEdge;
    EditText edtJarGPRS;
    EditText edtJarMultiSimCard;
    EditText edtJarSimCard;
    EditText edtKameraDepan;
    EditText edtKameraFitKam;
    EditText edtKameraLamKil;
    EditText edtKameraUtama;
    EditText edtKameraVidRec;
    EditText edtKeteranganTambahan;
    EditText edtKonek35Jack;
    EditText edtKonekBlue;
    EditText edtKonekHDMI;
    EditText edtKonekInfrared;
    EditText edtKonekNFC;
    EditText edtKonekTV;
    EditText edtKonekUSB;
    EditText edtKonekWLAN;
    EditText edtKoreksiUser;
    EditText edtLain2Analog;
    EditText edtLain2Browser;
    EditText edtLain2Fiturlain;
    EditText edtLain2GPS;
    EditText edtLain2Musik;
    EditText edtLain2Pesan;
    EditText edtLain2Radio;
    EditText edtLayarEXT;
    EditText edtLayarMultitouch;
    EditText edtLayarProteksi;
    EditText edtLayarSensor;
    EditText edtLayarTambahan;
    EditText edtLayarTipe;
    EditText edtLayarUkuran;
    EditText edtMemoriAllKet;
    EditText edtMemoriExternal;
    EditText edtMemoriInternal;
    EditText edtMemoriPhoneBook;
    EditText edtNatVidCall;
    EditText edtSoftJava;
    EditText edtSoftOS;
    EditText edtUmumBobot;
    EditText edtUmumDiUm;
    EditText edtUmumDim;
    EditText edtUmumModelHp;
    EditText edtUmumStatus;
    EditText edtUmumWarna;
    EditText edtUser;
    String email_user;
    Bundle extras;
    String fit_browser;
    String fit_browser_status;
    String fit_gps;
    String fit_gps_status;
    String fit_lain;
    String fit_musik;
    String fit_musik_status;
    String fit_pesan;
    String fit_radio;
    String fit_radio_status;
    String fit_tvanalog;
    String fit_tvanalog_ket;
    DecimalFormat fmt;
    DecimalFormatSymbols fmts;
    String formattedDate;
    String gambar;
    String getJson;
    String har_chipset;
    String har_cpu_clock;
    String har_cpu_core;
    String har_cpu_jenpros;
    String har_gpu;
    String har_info;
    String har_infotmbh;
    String hard_all_ket;
    int hargaAtas;
    int hargaBaru;
    int hargaBawah;
    int hargaBekas;
    int hasilQ;
    LinearLayout headPonsel;
    String host;
    String hrg_baru;
    String hrg_baru_arr[];
    String hrg_baru_final;
    String hrg_bekas;
    String id_ads;
    String id_ads2;
    String id_hp;
    String id_merk;
    String id_user;
    String id_user2;
    ImageLoader imageLoader2;
    ImageLoader imageLoaderAds;
    String image_ads;
    String image_ads2;
    ImageView imgAdv;
    ImageView imgAdv2;
    ImageView imgHpDetail;
    ImageView imgWatermark;
    ImageButton imgbtn_share_fb;
    ImageButton imgbtn_share_gplus;
    ImageButton imgbtn_share_mail;
    ImageButton imgbtn_share_more;
    ImageButton imgbtn_share_tw;
    ImageButton imgbtn_share_wa;
    JSONArray inponsel;
    String internal;
    JSONArray jArray;
    String jar_2g_cdma;
    String jar_2g_cdma_status;
    String jar_2g_gsm;
    String jar_2g_gsm_status;
    String jar_2g_status;
    String jar_3g;
    String jar_3g_status;
    String jar_4g;
    String jar_4g_status;
    String jar_bwidth;
    String jar_dualon;
    String jar_edge;
    String jar_edge_status;
    String jar_gprs;
    String jar_gprs_status;
    String jar_multi_ket;
    String jar_multi_status;
    String jar_multi_tipe1;
    String jar_multi_tipe2;
    String jar_sc;
    String jar_sc_ket;
    String jml_komentar;
    String jsonRival;
    String jum_komen;
    String jum_komenLikePon;
    TextView jumlahKomentar;
    String kam_depan;
    String kam_depan_status;
    String kam_fitur;
    String kam_led_flash;
    String kam_led_flash_status;
    String kam_nat_vcall;
    String kam_utama;
    String kam_utama2;
    String kam_utama_ket;
    String kam_utama_status;
    String kam_video;
    String kam_video_hd;
    String kam_video_status;
    String ketamb;
    String komen;
    String kon_35mm_jack;
    String kon_35mm_jack_ket;
    String kon_bluetooth;
    String kon_bluetooth_status;
    String kon_hdmi;
    String kon_hdmi_status;
    String kon_infrared;
    String kon_infrared_ket;
    String kon_nfc;
    String kon_nfc_status;
    String kon_tvoutput;
    String kon_tvoutput_status;
    String kon_usb;
    String kon_usb_status;
    String kon_wlan;
    String kon_wlan_status;
    LinearLayout lay_Ketertarikan;
    RelativeLayout lay_adv_atas;
    RelativeLayout lay_adv_atas2;
    LinearLayout lay_advertising;
    LinearLayout lay_advertising2;
    String lay_ext;
    String lay_multitouch;
    String lay_multitouch_status;
    String lay_proteksi;
    String lay_proteksi_status;
    String lay_sensor;
    String lay_sensor_status;
    String lay_size_diagonal;
    String lay_size_diagonal_ket;
    String lay_size_horizontal;
    String lay_size_ppi;
    String lay_size_status;
    String lay_size_vertikal;
    String lay_tambahan;
    String lay_tipe_layar;
    String lay_touchscreen;
    String lay_touchscreen_status;
    String lay_warna_ket;
    String lay_warna_layar;
    LinearLayout layout_Bandingkan;
    LinearLayout layout_Berita;
    LinearLayout layout_ChatRoom;
    LinearLayout layout_Forum;
    LinearLayout layout_GalleriFoto;
    LinearLayout layout_HpLain;
    LinearLayout layout_KomentarHp;
    LinearLayout layout_RivalTerdekat;
    LinearLayout layout_Room;
    LinearLayout layout_SCTerdekat;
    LinearLayout layout_Twitter;
    LinearLayout layout_VendorProf;
    LinearLayout layout_empty;
    String likepersen;
    FrameLayout linIkhtisar;
    LinearLayout lineColor;
    String link_ads;
    String link_ads2;
    ListView listSAP;
    LinearLayout ll_menu_bottom_spek;
    LinearLayout ll_report_hp;
    LinearLayout ll_spacekosong;
    LinearLayout ll_tinjauan_pengunjung;
    ImageLoaderConfiguration loaderConfiguration;
    ImageLoaderConfiguration loaderConfigurationAds;
    private DisplayImageOptions loaderoptionsAds;
    TextView loadingText;
    ProgressDialog mDialog;
    private File mFileTemp;
    NotificationKomenHelper mNotificationHelper;
    String mem_all_ket;
    String mem_eksternal;
    String mem_eksternal_kap;
    String mem_eksternal_s;
    String mem_ekternal_ket;
    String mem_internal;
    String mem_internal_ket;
    String mem_phonebook;
    String mem_ram;
    String mem_ram_ket;
    String mem_rom;
    String mem_rom_ket;
    String merk;
    CircularProgressBar midProgressBar;
    String model;
    String my_like_pon;
    LinearLayout myroot;
    String nama_asli;
    String namalengkap;
    String namalengkapbgskrg;
    int newBmapHeight;
    int newBmapWidth;
    String nilai_baterai;
    String nilai_desain;
    String nilai_kamera;
    String nilai_kinerja;
    String nilai_layar;
    String nilai_overall;
    String nilbtnApps;
    String nilbtnAudio;
    String nilbtnBaterai;
    String nilbtnDesain;
    String nilbtnHarga;
    String nilbtnKamera;
    String nilbtnKinerja;
    String nilbtnLayar;
    String no_ads;
    String no_ads2;
    String notif;
    NotificationLikeHelper notificationLikeHelper;
    DecimalFormat oneDForm;
    private DisplayImageOptions options;
    LinearLayout parentHardware;
    PonselBaseApp ponselBaseApp;
    String postMessage;
    String postMessageLikePon;
    String postMessageSubsNews;
    String postStatus;
    String postStatusLikePon;
    String postStatusSubsNews;
    ProgressBar progBarBottom;
    ProgressBar progressbar_TERDEKAT;
    ProgressBar progressbar_hplainnya;
    String publisher_name;
    String publisher_name2;
    String pushURLHp;
    String pushURLNews;
    String queryHp;
    String queryNews;
    String querypopkomen;
    String rata2Apps;
    String rata2Audio;
    String rata2Baterai;
    String rata2Desain;
    String rata2Harga;
    String rata2Kamera;
    String rata2Kinerja;
    String rata2Layar;
    TextView rataBaterai;
    TextView rataDesain;
    TextView rataKamera;
    TextView rataKinerja;
    TextView rataLayar;
    double ratdobApps;
    double ratdobAudio;
    double ratdobBaterai;
    double ratdobDesain;
    double ratdobHarga;
    double ratdobKamera;
    double ratdobKinerja;
    double ratdobLayar;
    double ratdobLikeDis;
    ProgressBar ratingBaterai;
    ProgressBar ratingDesain;
    ProgressBar ratingKamera;
    ProgressBar ratingKinerja;
    ProgressBar ratingLayar;
    ProgressBar ratingLikeDis;
    ProgressBar ratingReviewFitur;
    int ratintApps;
    int ratintAudio;
    int ratintBaterai;
    int ratintDesain;
    int ratintHarga;
    int ratintKamera;
    int ratintKinerja;
    int ratintLayar;
    int ratintLikeDis;
    String res;
    String room_kota;
    String room_kota_id;
    String room_prov;
    String scheme;
    int sdk;
    ShareDialog shareDialog;
    String sof_java;
    String sof_java_status;
    String sof_os;
    String sof_os_versi;
    ArrayList spekArray;
    LinearLayout spek_head_2g;
    LinearLayout spek_head_35jack;
    LinearLayout spek_head_3g;
    LinearLayout spek_head_4g;
    LinearLayout spek_head_Bandwidth;
    LinearLayout spek_head_BateraiIsiBox;
    LinearLayout spek_head_BateraiJenis;
    LinearLayout spek_head_BateraiSiaga;
    LinearLayout spek_head_BateraiWakBic;
    LinearLayout spek_head_Bluetooth;
    LinearLayout spek_head_Bobot;
    LinearLayout spek_head_Browser;
    LinearLayout spek_head_CPU;
    LinearLayout spek_head_Chipset;
    LinearLayout spek_head_Dimensi;
    LinearLayout spek_head_Diumumkan;
    LinearLayout spek_head_EDGE;
    LinearLayout spek_head_FitKam;
    LinearLayout spek_head_GPRS;
    LinearLayout spek_head_GPS;
    LinearLayout spek_head_GPU;
    LinearLayout spek_head_Garansi;
    LinearLayout spek_head_HDMI;
    LinearLayout spek_head_HargaBaru;
    LinearLayout spek_head_HargaBekas;
    LinearLayout spek_head_InfoTamb;
    LinearLayout spek_head_Infrared;
    LinearLayout spek_head_Java;
    LinearLayout spek_head_KamDepan;
    LinearLayout spek_head_KamUtama;
    LinearLayout spek_head_Lain2Fit;
    LinearLayout spek_head_LamKil;
    LinearLayout spek_head_Lay_EXT;
    LinearLayout spek_head_Lay_Tambahan;
    LinearLayout spek_head_MemExternal;
    LinearLayout spek_head_MemInternal;
    LinearLayout spek_head_MemPhoneBook;
    LinearLayout spek_head_MemoriAllKet;
    LinearLayout spek_head_ModelHP;
    LinearLayout spek_head_MultiSIM;
    LinearLayout spek_head_Multitouch;
    LinearLayout spek_head_Musik;
    LinearLayout spek_head_NFC;
    LinearLayout spek_head_NatVidCall;
    LinearLayout spek_head_OS;
    LinearLayout spek_head_Pesan;
    LinearLayout spek_head_Proteksi;
    LinearLayout spek_head_Radio;
    LinearLayout spek_head_SIM;
    LinearLayout spek_head_Sensor;
    LinearLayout spek_head_Status;
    LinearLayout spek_head_TV;
    LinearLayout spek_head_TVAnalog;
    LinearLayout spek_head_TipeHP;
    LinearLayout spek_head_USB;
    LinearLayout spek_head_Ukuran;
    LinearLayout spek_head_VidRec;
    LinearLayout spek_head_WLAN;
    LinearLayout spek_head_Warna;
    LinearLayout spek_head_hard_ket;
    LinearLayout spek_head_ketamb;
    String sta_garansi;
    String statFavHp;
    String statSubNews;
    String statusLikeHp;
    String statusLikeKomen;
    String str_share_desc;
    String str_share_diumumkan;
    String str_urlspekshare;
    String suc;
    String suc2;
    String sucads;
    String sucads2;
    String t;
    String tgglHarga;
    String title_ads;
    String title_ads2;
    String tnggp_bgs;
    String tnggp_krg;
    String tot_LikePon;
    String tot_dislike;
    String tot_komen;
    String tot_like;
    TextView totalVotes;
    String total_hits;
    String total_votes;
    String totdis_LikePon;
    String twitter;
    TextView txtAdvDesc;
    TextView txtAdvDesc2;
    TextView txtAdvJudul1;
    TextView txtAdvJudul12;
    TextView txtAdvJudul2;
    TextView txtAdvJudul22;
    TextView txtBagus;
    TextView txtBigBerita;
    TextView txtBigHpLain;
    TextView txtBigKomentarHp;
    TextView txtBigRivalTerdekat;
    TextView txtBigRoom;
    TextView txtBigTwitter;
    TextView txtCountKomen;
    TextView txtDet;
    TextView txtKurang;
    TextView txtLabelDisc;
    TextView txtLabelDisc2;
    TextView txtPercentKetertarikan;
    TextView txtPercentReviewFitur;
    TextView txtValueKetertarikan;
    TextView txtValueReviewFitur;
    TextView txt_empty;
    TextView txt_loadingSaveSpec;
    TextView txt_namalengkap;
    String umu_bobot;
    String umu_bobot_ket;
    String umu_dim_ket;
    String umu_dim_lebar;
    String umu_dim_panjang;
    String umu_dim_tebal;
    String umu_diumumkan;
    String umu_diumumkan_sta;
    String umu_model;
    String umu_status;
    String umu_status_ket;
    String umu_tags;
    String umu_warna_ponsel;
    String update_harga;
    String user;
    UserFunctions userFunction;
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
    ContextThemeWrapper wrapper;
    LinearLayout z;

    public Hal2Spek()
    {
        animation = null;
        nilbtnDesain = "6";
        nilbtnLayar = "6";
        nilbtnKinerja = "6";
        nilbtnApps = "6";
        nilbtnKamera = "6";
        nilbtnAudio = "6";
        nilbtnBaterai = "6";
        nilbtnHarga = "6";
        internal = "";
        rata2Desain = "7.1";
        rata2Layar = "4.5";
        rata2Kinerja = "10";
        rata2Apps = "5.8";
        rata2Kamera = "7.5";
        rata2Audio = "7.8";
        rata2Baterai = "3.3";
        rata2Harga = "6.1";
        oneDForm = new DecimalFormat("#.#");
        scheme = "";
        host = "";
        details = "";
        notif = "000";
        codename = "";
        namalengkapbgskrg = "";
        t = Utility.session(RestClient.pelihara);
        str_share_diumumkan = "";
        str_urlspekshare = "";
        str_share_desc = "";
        hrg_baru_final = "";
        decimalPlace = 1;
        decimal2 = 2;
        decmem = 1;
        postStatusLikePon = "";
        postMessageLikePon = "";
        tot_LikePon = "0";
        totdis_LikePon = "0";
        jum_komenLikePon = "0";
        jum_komen = "";
        user_photo = "";
        username = "";
        spekArray = null;
        user = "";
        komen = "";
        postStatus = "";
        postMessage = "";
        publisher_name = "";
        title_ads = "";
        campaign = "";
        image_ads = "";
        link_ads = "";
        ads_status = "";
        publisher_name2 = "";
        title_ads2 = "";
        campaign2 = "";
        image_ads2 = "";
        link_ads2 = "";
        ads_status2 = "";
        inponsel = null;
        suc = "";
        suc2 = "";
        sucads = "0";
        sucads2 = "0";
        sdk = android.os.Build.VERSION.SDK_INT;
        tot_komen = "";
        room_kota = "";
        room_kota_id = "";
        room_prov = "";
        querypopkomen = "";
        hargaAtas = 0;
        hargaBawah = 0;
    }

    private void LoginPopup(String s, String s1)
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getActivity());
        builder.setTitle(s);
        builder.setMessage(s1);
        builder.setPositiveButton("Login", new android.content.DialogInterface.OnClickListener() {

            final Hal2Spek this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                startActivityForResult(dialoginterface, 0);
                getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = Hal2Spek.this;
                super();
            }
        });
        builder.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

            final Hal2Spek this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                startActivityForResult(dialoginterface, 0);
                getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = Hal2Spek.this;
                super();
            }
        });
        builder.setNegativeButton("Tutup", new android.content.DialogInterface.OnClickListener() {

            final Hal2Spek this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$0 = Hal2Spek.this;
                super();
            }
        });
        builder.show();
    }

    private void OnlineStatGroup(String s, String s1, String s2, String s3, String s4)
    {
        Log.e("sendto2", (new StringBuilder("from ")).append(s1).append(" to ").append(codename).toString());
        s = (new StringBuilder(String.valueOf(Util.BASE_PATH_MSG))).append("online_status_group").append(Utility.BASE_FORMAT).append("?id_user=").append(s).append("&id_conv=").append(codename).append("&stat=").append(s2).append("&t=").append(s3).toString();
        Log.e("OnlineStatGroup", s);
        s = new MyObjectRequest(s, new com.android.volley.Response.Listener() {

            final Hal2Spek this$0;

            public volatile void onResponse(Object obj)
            {
                onResponse((JSONObject)obj);
            }

            public void onResponse(JSONObject jsonobject)
            {
                Log.e("responseGroup", jsonobject.toString());
            }

            
            {
                this$0 = Hal2Spek.this;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final Hal2Spek this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
            }

            
            {
                this$0 = Hal2Spek.this;
                super();
            }
        }, "test", "test");
        PonselBaseApp.getInstance().addToRequestQueue(s, "jobj_req");
    }

    private boolean appInstalledOrNot(String s)
    {
        PackageManager packagemanager = getActivity().getPackageManager();
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

    private File createFolders()
    {
        File file;
        if (android.os.Build.VERSION.SDK_INT < 8)
        {
            file = Environment.getExternalStorageDirectory();
        } else
        {
            file = Environment.getExternalStorageDirectory();
        }
        if (file == null)
        {
            file = Environment.getExternalStorageDirectory();
        } else
        {
            File file1 = new File(file, "InPonsel");
            file = file1;
            if (!file1.exists())
            {
                file = file1;
                if (!file1.mkdirs())
                {
                    return Environment.getExternalStorageDirectory();
                }
            }
        }
        return file;
    }

    private File getNextFileName()
    {
        if (mFileTemp != null && mFileTemp.exists())
        {
            Object obj = markText(getBitmapFromView(linIkhtisar), formattedDate);
            linIkhtisar.setDrawingCacheEnabled(false);
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            ((Bitmap) (obj)).compress(android.graphics.Bitmap.CompressFormat.PNG, 100, bytearrayoutputstream);
            obj = new File(mFileTemp, TEMP_PHOTO_FILE_NAME);
            try
            {
                ((File) (obj)).createNewFile();
                FileOutputStream fileoutputstream = new FileOutputStream(((File) (obj)));
                fileoutputstream.write(bytearrayoutputstream.toByteArray());
                fileoutputstream.close();
            }
            catch (Exception exception)
            {
                return ((File) (obj));
            }
            return ((File) (obj));
        } else
        {
            return null;
        }
    }

    public static Bitmap markText(Bitmap bitmap, String s)
    {
        Bitmap bitmap1 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        Canvas canvas = new Canvas(bitmap1);
        canvas.drawBitmap(bitmap, 0.0F, 0.0F, null);
        bitmap = new Paint();
        bitmap.setColor(-1);
        bitmap.setTextSize(18F);
        bitmap.setAntiAlias(true);
        bitmap.setUnderlineText(false);
        canvas.drawText(s, 10F, 15F, bitmap);
        return bitmap1;
    }

    private void popup_dialog(String s, String s1)
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getActivity());
        builder.setTitle(s);
        builder.setMessage(s1);
        builder.setCancelable(false);
        builder.setPositiveButton("Ok", new android.content.DialogInterface.OnClickListener() {

            final Hal2Spek this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$0 = Hal2Spek.this;
                super();
            }
        });
        builder.show();
    }

    private void share_to_socmed()
    {
        final ShareIntentListAdapter objShareIntentListAdapter = new Intent("android.intent.action.SEND");
        objShareIntentListAdapter.setType("text/plain");
        objShareIntentListAdapter = getActivity().getPackageManager().queryIntentActivities(objShareIntentListAdapter, 0);
        objShareIntentListAdapter = new ShareIntentListAdapter(getActivity(), objShareIntentListAdapter.toArray());
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getActivity());
        builder.setTitle("Bagikan ke");
        builder.setAdapter(objShareIntentListAdapter, new android.content.DialogInterface.OnClickListener() {

            final Hal2Spek this$0;
            private final ShareIntentListAdapter val$objShareIntentListAdapter;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = (ResolveInfo)objShareIntentListAdapter.getItem(i);
                if (((ResolveInfo) (dialoginterface)).activityInfo.packageName.contains("com.facebook") || ((ResolveInfo) (dialoginterface)).activityInfo.packageName.contains("facebook"))
                {
                    Log.e("share", "facebook");
                    dialoginterface = ((com.facebook.share.model.ShareLinkContent.Builder)(new com.facebook.share.model.ShareLinkContent.Builder()).setContentTitle((new StringBuilder(String.valueOf(namalengkap))).append(" - Berita, Spesifikasi, Review, Galeri foto, Harga, Service Center").toString()).setImageUrl(Uri.parse(gambar)).setContentDescription((new StringBuilder("Spesifikasi lengkap ")).append(namalengkap).append(". Diumumkan pada ").append(str_share_diumumkan).append(". Fitur ").append(str_share_desc).toString()).setContentUrl(Uri.parse(str_urlspekshare))).build();
                    shareDialog.show(dialoginterface);
                    return;
                } else
                {
                    Log.e("share", "other");
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.setClassName(((ResolveInfo) (dialoginterface)).activityInfo.packageName, ((ResolveInfo) (dialoginterface)).activityInfo.name);
                    intent.setType("text/plain");
                    intent.putExtra("android.intent.extra.TEXT", (new StringBuilder("Info lengkap ")).append(namalengkap).append(". Spesifikasi, berita, harga,dll. ").append(str_urlspekshare).toString());
                    intent.putExtra("android.intent.extra.SUBJECT", (new StringBuilder("Spesifikasi ")).append(namalengkap).toString());
                    Log.e("share", str_urlspekshare);
                    intent.putExtra("android.intent.extra.TITLE", (new StringBuilder("Spesifikasi ")).append(namalengkap).toString());
                    startActivity(intent);
                    return;
                }
            }

            
            {
                this$0 = Hal2Spek.this;
                objShareIntentListAdapter = shareintentlistadapter;
                super();
            }
        });
        builder.show();
    }

    private void show_popup_komentar()
    {
        View view = LayoutInflater.from(getActivity()).inflate(0x7f030024, null);
        final EditText edt_pop_komen = (EditText)view.findViewById(0x7f0b008c);
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getActivity());
        builder.setTitle(namalengkap);
        builder.setView(view);
        builder.setPositiveButton("Submit", new android.content.DialogInterface.OnClickListener() {

            final Hal2Spek this$0;
            private final EditText val$edt_pop_komen;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                try
                {
                    dialoginterface = URLEncoder.encode(edt_pop_komen.getText().toString(), "utf-8");
                    querypopkomen = (new StringBuilder("rplto=0&idhp=")).append(id_hp).append("&code=").append(codename).append("&email=").append(URLEncoder.encode(email_user, "utf-8")).append("&nama=").append(URLEncoder.encode(username, "utf-8")).append("&komentar=").append(dialoginterface).append("&nmhp=").append(URLEncoder.encode(namalengkap, "utf-8")).append("&top_id=").append("300").append("&t=").append(t).append("&idusr=").append(user_id).toString();
                }
                // Misplaced declaration of an exception variable
                catch (DialogInterface dialoginterface)
                {
                    dialoginterface.printStackTrace();
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
                this$0 = Hal2Spek.this;
                edt_pop_komen = edittext;
                super();
            }
        });
        builder.setNegativeButton("Cancel", new android.content.DialogInterface.OnClickListener() {

            final Hal2Spek this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
            }

            
            {
                this$0 = Hal2Spek.this;
                super();
            }
        });
        builder.show();
    }

    public void InAds2Task()
    {
        dataInAds2 = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("inads").append(Utility.BASE_FORMAT).append("?pver=").append(SplashScreen.curVersion).append("&hal=PL2-02").append("&t=").append(t).toString();
        Log.e("dataInAds2", dataInAds2);
        InAds2Task inads2task = new InAds2Task(null);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            inads2task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            inads2task.execute(new Void[0]);
            return;
        }
    }

    public void InAdsTask()
    {
        dataInAds = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("inads").append(Utility.BASE_FORMAT).append("?pver=").append(SplashScreen.curVersion).append("&hal=PL2-01").append("&t=").append(t).toString();
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

    public void RatingAVGTask()
    {
        dataRatingAVG = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("ratingnilaihpavg").append(Utility.BASE_FORMAT).append("?id=").append(id_hp).append("&t=").append(t).toString();
        Log.e("url", dataRatingAVG);
        RatingAVGTask ratingavgtask = new RatingAVGTask(null);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            ratingavgtask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            ratingavgtask.execute(new Void[0]);
            return;
        }
    }

    public void RivalTask()
    {
        RivalTask rivaltask = new RivalTask();
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            rivaltask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            rivaltask.execute(new Void[0]);
            return;
        }
    }

    public void SpekLengkapTask()
    {
        SpekLengkapTask speklengkaptask = new SpekLengkapTask();
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            speklengkaptask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            speklengkaptask.execute(new Void[0]);
            return;
        }
    }

    public Bitmap getBitmapFromView(View view)
    {
        Bitmap bitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Drawable drawable = view.getBackground();
        if (drawable != null)
        {
            drawable.draw(canvas);
        } else
        {
            canvas.drawColor(getResources().getColor(0x7f080182));
        }
        view.draw(canvas);
        return bitmap;
    }

    void log(String s)
    {
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        setHasOptionsMenu(true);
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        imgAdv.setLayoutParams(new android.widget.LinearLayout.LayoutParams(Utility.getBmapWidth(getActivity()), Utility.getBmapHeight(getActivity())));
        imgAdv.setMaxWidth(Utility.getBmapWidth(getActivity()));
        imgAdv.setMaxHeight(Utility.getBmapHeight(getActivity()));
        imgAdv2.setLayoutParams(new android.widget.LinearLayout.LayoutParams(Utility.getBmapWidth(getActivity()), Utility.getBmapHeight(getActivity())));
        imgAdv2.setMaxWidth(Utility.getBmapWidth(getActivity()));
        imgAdv2.setMaxHeight(Utility.getBmapHeight(getActivity()));
    }

    public void onCreate(Bundle bundle)
    {
        setRetainInstance(true);
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        menuinflater.inflate(0x7f0f0014, menu);
        super.onCreateOptionsMenu(menu, menuinflater);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        setRetainInstance(true);
        try
        {
            viewgroup = ((PonselBaseApp)getActivity().getApplication()).getTracker(com.inponsel.android.adapter.PonselBaseApp.TrackerName.APP_TRACKER);
            viewgroup.setScreenName("Hal2Spek");
            viewgroup.send((new com.google.android.gms.analytics.HitBuilders.AppViewBuilder()).build());
        }
        // Misplaced declaration of an exception variable
        catch (ViewGroup viewgroup)
        {
            viewgroup.printStackTrace();
        }
        layoutinflater = (ViewGroup)layoutinflater.inflate(0x7f03012c, null);
        calendar = Calendar.getInstance();
        formattedDate = (new SimpleDateFormat("dd-MM-yyyy")).format(calendar.getTime());
        wrapper = new ContextThemeWrapper(getActivity(), 0x103006e);
        fmt = new DecimalFormat();
        fmts = new DecimalFormatSymbols();
        fmts.setGroupingSeparator('.');
        fmt.setGroupingSize(3);
        fmt.setGroupingUsed(true);
        fmt.setDecimalFormatSymbols(fmts);
        t = Utility.session(t);
        userFunction = new UserFunctions();
        db = new DatabaseHandler(getActivity());
        cm = (ConnectivityManager)getActivity().getSystemService("connectivity");
        drw = getActivity().getResources().getDrawable(0x7f020240);
        drw.setColorFilter(Color.parseColor("#FFFF5722"), android.graphics.PorterDuff.Mode.SRC_ATOP);
        drwKurang = getActivity().getResources().getDrawable(0x7f0201ea);
        drwKurang.setColorFilter(Color.parseColor("#FFFF5722"), android.graphics.PorterDuff.Mode.SRC_ATOP);
        ponselBaseApp = (PonselBaseApp)getActivity().getApplication();
        ponselBaseApp.getObserver().addObserver(this);
        notificationLikeHelper = new NotificationLikeHelper(getActivity());
        mNotificationHelper = new NotificationKomenHelper(getActivity());
        callbackManager = com.facebook.CallbackManager.Factory.create();
        shareDialog = new ShareDialog(getActivity());
        if (userFunction.isUserLoggedIn(getActivity()))
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
            cursor.close();
        }
        imageLoader2 = ImageLoader.getInstance();
        imageLoader2.init(ImageLoaderConfiguration.createDefault(getActivity()));
        options = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showImageForEmptyUri(0x7f020208).cacheInMemory(true).imageScaleType(ImageScaleType.EXACTLY).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).build();
        ratingLikeDis = (ProgressBar)layoutinflater.findViewById(0x7f0b04a7);
        ratingReviewFitur = (ProgressBar)layoutinflater.findViewById(0x7f0b04a8);
        txtValueKetertarikan = (TextView)layoutinflater.findViewById(0x7f0b023f);
        txtValueReviewFitur = (TextView)layoutinflater.findViewById(0x7f0b04ad);
        txtPercentKetertarikan = (TextView)layoutinflater.findViewById(0x7f0b04aa);
        txtPercentReviewFitur = (TextView)layoutinflater.findViewById(0x7f0b04ac);
        imgbtn_share_fb = (ImageButton)layoutinflater.findViewById(0x7f0b0305);
        imgbtn_share_tw = (ImageButton)layoutinflater.findViewById(0x7f0b0306);
        imgbtn_share_gplus = (ImageButton)layoutinflater.findViewById(0x7f0b0307);
        imgbtn_share_wa = (ImageButton)layoutinflater.findViewById(0x7f0b0308);
        imgbtn_share_mail = (ImageButton)layoutinflater.findViewById(0x7f0b0309);
        imgbtn_share_more = (ImageButton)layoutinflater.findViewById(0x7f0b030a);
        circle_LikeDis = (CircleProgressBar)layoutinflater.findViewById(0x7f0b04a9);
        circle_ReviewFitur = (CircleProgressBar)layoutinflater.findViewById(0x7f0b04ab);
        detail_favorite = (ImageView)layoutinflater.findViewById(0x7f0b04b0);
        detail_favoritenews = (ImageView)layoutinflater.findViewById(0x7f0b04b3);
        layout_ChatRoom = (LinearLayout)layoutinflater.findViewById(0x7f0b0333);
        layout_Forum = (LinearLayout)layoutinflater.findViewById(0x7f0b0334);
        imgWatermark = (ImageView)layoutinflater.findViewById(0x7f0b055c);
        detail_like = (ImageView)layoutinflater.findViewById(0x7f0b049f);
        detail_dislike = (ImageView)layoutinflater.findViewById(0x7f0b04a2);
        imgHpDetail = (ImageView)layoutinflater.findViewById(0x7f0b049d);
        detail_txtMerek = (TextView)layoutinflater.findViewById(0x7f0b0535);
        detail_txtMerek.setSelected(true);
        txtLabelDisc = (TextView)layoutinflater.findViewById(0x7f0b0559);
        txtLabelDisc2 = (TextView)layoutinflater.findViewById(0x7f0b055a);
        txtLabelDisc.setText((new StringBuilder("\n\u2022 ")).append(getResources().getString(0x7f0c00d1)).toString());
        txtLabelDisc2.setText((new StringBuilder("\u2022 ")).append(getResources().getString(0x7f0c00d2)).toString());
        txt_namalengkap = (TextView)layoutinflater.findViewById(0x7f0b049b);
        txt_loadingSaveSpec = (TextView)layoutinflater.findViewById(0x7f0b055b);
        headPonsel = (LinearLayout)layoutinflater.findViewById(0x7f0b049a);
        ll_tinjauan_pengunjung = (LinearLayout)layoutinflater.findViewById(0x7f0b01e3);
        ll_report_hp = (LinearLayout)layoutinflater.findViewById(0x7f0b086f);
        ll_menu_bottom_spek = (LinearLayout)layoutinflater.findViewById(0x7f0b0301);
        lay_Ketertarikan = (LinearLayout)layoutinflater.findViewById(0x7f0b0546);
        headPonsel.setVisibility(0);
        imgWatermark.setVisibility(8);
        ll_tinjauan_pengunjung.setVisibility(8);
        ll_menu_bottom_spek.setVisibility(8);
        ll_report_hp.setVisibility(8);
        ll_spacekosong = (LinearLayout)layoutinflater.findViewById(0x7f0b04bc);
        detail_lay_like = (RelativeLayout)layoutinflater.findViewById(0x7f0b049e);
        detail_lay_dislike = (RelativeLayout)layoutinflater.findViewById(0x7f0b04a1);
        detail_lay_kom = (RelativeLayout)layoutinflater.findViewById(0x7f0b04a4);
        btnRefresh = (Button)layoutinflater.findViewById(0x7f0b04d0);
        btnKomentarHp = (Button)layoutinflater.findViewById(0x7f0b0303);
        btnAddKomentarHp = (Button)layoutinflater.findViewById(0x7f0b0304);
        txtBigKomentarHp = (TextView)layoutinflater.findViewById(0x7f0b0338);
        txtBigHpLain = (TextView)layoutinflater.findViewById(0x7f0b0326);
        txtBigTwitter = (TextView)layoutinflater.findViewById(0x7f0b0322);
        txtBigRivalTerdekat = (TextView)layoutinflater.findViewById(0x7f0b0316);
        txtBigBerita = (TextView)layoutinflater.findViewById(0x7f0b0312);
        txtBigRoom = (TextView)layoutinflater.findViewById(0x7f0b0332);
        layout_Room = (LinearLayout)layoutinflater.findViewById(0x7f0b032f);
        layout_KomentarHp = (LinearLayout)layoutinflater.findViewById(0x7f0b0335);
        layout_KomentarHp.setVisibility(8);
        layout_GalleriFoto = (LinearLayout)layoutinflater.findViewById(0x7f0b030b);
        layout_RivalTerdekat = (LinearLayout)layoutinflater.findViewById(0x7f0b0313);
        layout_Bandingkan = (LinearLayout)layoutinflater.findViewById(0x7f0b031b);
        layout_Berita = (LinearLayout)layoutinflater.findViewById(0x7f0b030f);
        layout_Twitter = (LinearLayout)layoutinflater.findViewById(0x7f0b031f);
        layout_SCTerdekat = (LinearLayout)layoutinflater.findViewById(0x7f0b0317);
        layout_HpLain = (LinearLayout)layoutinflater.findViewById(0x7f0b0323);
        layout_VendorProf = (LinearLayout)layoutinflater.findViewById(0x7f0b0327);
        detail_text_like = (TextView)layoutinflater.findViewById(0x7f0b04a0);
        detail_text_dislike = (TextView)layoutinflater.findViewById(0x7f0b04a3);
        detail_text_komentar = (TextView)layoutinflater.findViewById(0x7f0b04a6);
        det_prog_item = (ProgressBar)layoutinflater.findViewById(0x7f0b049c);
        spekArray = new ArrayList();
        linIkhtisar = (FrameLayout)layoutinflater.findViewById(0x7f0b0556);
        linIkhtisar.setDrawingCacheEnabled(true);
        linIkhtisar.measure(android.view.View.MeasureSpec.makeMeasureSpec(0, 0), android.view.View.MeasureSpec.makeMeasureSpec(0, 0));
        linIkhtisar.layout(0, 0, linIkhtisar.getMeasuredWidth(), linIkhtisar.getMeasuredHeight());
        linIkhtisar.buildDrawingCache(true);
        layout_empty = (LinearLayout)layoutinflater.findViewById(0x7f0b0091);
        layout_empty.setVisibility(0);
        linIkhtisar.setVisibility(8);
        parentHardware = (LinearLayout)layoutinflater.findViewById(0x7f0b0152);
        btnKirimError = (Button)layoutinflater.findViewById(0x7f0b0562);
        btnReportInCorrect = (Button)layoutinflater.findViewById(0x7f0b0302);
        btnKirimError.setEnabled(false);
        btnSaveSpekImage = (Button)layoutinflater.findViewById(0x7f0b055d);
        edtKoreksiUser = (EditText)layoutinflater.findViewById(0x7f0b0561);
        midProgressBar = (CircularProgressBar)layoutinflater.findViewById(0x7f0b00ca);
        imgAdv = (ImageView)layoutinflater.findViewById(0x7f0b006d);
        txtAdvJudul1 = (TextView)layoutinflater.findViewById(0x7f0b006c);
        txtAdvJudul2 = (TextView)layoutinflater.findViewById(0x7f0b006f);
        txtAdvDesc = (TextView)layoutinflater.findViewById(0x7f0b0070);
        btnAdvDownload = (Button)layoutinflater.findViewById(0x7f0b006e);
        lay_advertising = (LinearLayout)layoutinflater.findViewById(0x7f0b006a);
        lay_adv_atas = (RelativeLayout)layoutinflater.findViewById(0x7f0b006b);
        lay_advertising.setVisibility(8);
        imgAdv2 = (ImageView)layoutinflater.findViewById(0x7f0b0074);
        txtAdvJudul12 = (TextView)layoutinflater.findViewById(0x7f0b0073);
        txtAdvJudul22 = (TextView)layoutinflater.findViewById(0x7f0b0076);
        txtAdvDesc2 = (TextView)layoutinflater.findViewById(0x7f0b0077);
        btnAdvDownload2 = (Button)layoutinflater.findViewById(0x7f0b0075);
        lay_advertising2 = (LinearLayout)layoutinflater.findViewById(0x7f0b0071);
        lay_adv_atas2 = (RelativeLayout)layoutinflater.findViewById(0x7f0b0072);
        lay_advertising2.setVisibility(8);
        imageLoaderAds = ImageLoader.getInstance();
        loaderoptionsAds = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showImageForEmptyUri(0x7f020208).cacheInMemory(true).cacheOnDisk(true).imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).build();
        loaderConfigurationAds = (new com.nostra13.universalimageloader.core.ImageLoaderConfiguration.Builder(getActivity())).defaultDisplayImageOptions(loaderoptionsAds).build();
        imageLoaderAds.init(loaderConfigurationAds);
        btnRefresh.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2Spek this$0;

            public void onClick(View view)
            {
                dataSpek = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("detail_spec").append(Utility.BASE_FORMAT).append("?id=").append(id_hp).append("&t=").append(t).append("&idusr=").append(user_id).toString();
                Log.e("urlSpecRet", dataSpek);
                btnRefresh.setVisibility(8);
                midProgressBar.setVisibility(0);
                txt_empty.setText("Memuat");
                SpekLengkapTask();
            }

            
            {
                this$0 = Hal2Spek.this;
                super();
            }
        });
        edtKoreksiUser.addTextChangedListener(new TextWatcher() {

            final Hal2Spek this$0;

            public void afterTextChanged(Editable editable)
            {
            }

            public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i, int j, int k)
            {
                if (edtKoreksiUser.getText().length() < 4)
                {
                    btnKirimError.setEnabled(false);
                    return;
                } else
                {
                    btnKirimError.setEnabled(true);
                    return;
                }
            }

            
            {
                this$0 = Hal2Spek.this;
                super();
            }
        });
        btnShowComment = (TextView)layoutinflater.findViewById(0x7f0b0560);
        txt_empty = (TextView)layoutinflater.findViewById(0x7f0b0093);
        txt_empty.setText(0x7f0c0053);
        btnBerikan = (TextView)layoutinflater.findViewById(0x7f0b055f);
        btnBandingkan = (TextView)layoutinflater.findViewById(0x7f0b055e);
        spek_head_ketamb = (LinearLayout)layoutinflater.findViewById(0x7f0b0557);
        spek_head_2g = (LinearLayout)layoutinflater.findViewById(0x7f0b011a);
        spek_head_3g = (LinearLayout)layoutinflater.findViewById(0x7f0b011d);
        spek_head_4g = (LinearLayout)layoutinflater.findViewById(0x7f0b0120);
        spek_head_GPRS = (LinearLayout)layoutinflater.findViewById(0x7f0b0123);
        spek_head_EDGE = (LinearLayout)layoutinflater.findViewById(0x7f0b0126);
        spek_head_Bandwidth = (LinearLayout)layoutinflater.findViewById(0x7f0b0129);
        spek_head_SIM = (LinearLayout)layoutinflater.findViewById(0x7f0b012c);
        spek_head_MultiSIM = (LinearLayout)layoutinflater.findViewById(0x7f0b012f);
        spek_head_ModelHP = (LinearLayout)layoutinflater.findViewById(0x7f0b0132);
        spek_head_Dimensi = (LinearLayout)layoutinflater.findViewById(0x7f0b0134);
        spek_head_Bobot = (LinearLayout)layoutinflater.findViewById(0x7f0b0137);
        spek_head_Warna = (LinearLayout)layoutinflater.findViewById(0x7f0b013a);
        spek_head_Diumumkan = (LinearLayout)layoutinflater.findViewById(0x7f0b013d);
        spek_head_Status = (LinearLayout)layoutinflater.findViewById(0x7f0b0140);
        spek_head_TipeHP = (LinearLayout)layoutinflater.findViewById(0x7f0b0143);
        spek_head_Ukuran = (LinearLayout)layoutinflater.findViewById(0x7f0b0146);
        spek_head_Multitouch = (LinearLayout)layoutinflater.findViewById(0x7f0b0149);
        spek_head_Sensor = (LinearLayout)layoutinflater.findViewById(0x7f0b014c);
        spek_head_Proteksi = (LinearLayout)layoutinflater.findViewById(0x7f0b014f);
        spek_head_Chipset = (LinearLayout)layoutinflater.findViewById(0x7f0b0153);
        spek_head_CPU = (LinearLayout)layoutinflater.findViewById(0x7f0b0156);
        spek_head_GPU = (LinearLayout)layoutinflater.findViewById(0x7f0b0159);
        spek_head_OS = (LinearLayout)layoutinflater.findViewById(0x7f0b015c);
        spek_head_Java = (LinearLayout)layoutinflater.findViewById(0x7f0b015f);
        spek_head_KamUtama = (LinearLayout)layoutinflater.findViewById(0x7f0b0162);
        spek_head_LamKil = (LinearLayout)layoutinflater.findViewById(0x7f0b0165);
        spek_head_FitKam = (LinearLayout)layoutinflater.findViewById(0x7f0b0168);
        spek_head_VidRec = (LinearLayout)layoutinflater.findViewById(0x7f0b016b);
        spek_head_KamDepan = (LinearLayout)layoutinflater.findViewById(0x7f0b016e);
        spek_head_NatVidCall = (LinearLayout)layoutinflater.findViewById(0x7f0b0171);
        spek_head_MemInternal = (LinearLayout)layoutinflater.findViewById(0x7f0b0174);
        spek_head_MemExternal = (LinearLayout)layoutinflater.findViewById(0x7f0b0177);
        spek_head_MemPhoneBook = (LinearLayout)layoutinflater.findViewById(0x7f0b017a);
        spek_head_Bluetooth = (LinearLayout)layoutinflater.findViewById(0x7f0b017d);
        spek_head_HDMI = (LinearLayout)layoutinflater.findViewById(0x7f0b018c);
        spek_head_TV = (LinearLayout)layoutinflater.findViewById(0x7f0b018f);
        spek_head_Infrared = (LinearLayout)layoutinflater.findViewById(0x7f0b0192);
        spek_head_Musik = (LinearLayout)layoutinflater.findViewById(0x7f0b0195);
        spek_head_Radio = (LinearLayout)layoutinflater.findViewById(0x7f0b0198);
        spek_head_TVAnalog = (LinearLayout)layoutinflater.findViewById(0x7f0b019b);
        spek_head_NFC = (LinearLayout)layoutinflater.findViewById(0x7f0b0189);
        spek_head_GPS = (LinearLayout)layoutinflater.findViewById(0x7f0b019e);
        spek_head_Browser = (LinearLayout)layoutinflater.findViewById(0x7f0b01a1);
        spek_head_Pesan = (LinearLayout)layoutinflater.findViewById(0x7f0b01a4);
        spek_head_Lain2Fit = (LinearLayout)layoutinflater.findViewById(0x7f0b01a7);
        spek_head_BateraiJenis = (LinearLayout)layoutinflater.findViewById(0x7f0b01aa);
        spek_head_BateraiWakBic = (LinearLayout)layoutinflater.findViewById(0x7f0b01ad);
        spek_head_BateraiSiaga = (LinearLayout)layoutinflater.findViewById(0x7f0b01b0);
        spek_head_BateraiIsiBox = (LinearLayout)layoutinflater.findViewById(0x7f0b01b3);
        spek_head_HargaBaru = (LinearLayout)layoutinflater.findViewById(0x7f0b01b6);
        spek_head_HargaBekas = (LinearLayout)layoutinflater.findViewById(0x7f0b01b9);
        spek_head_Garansi = (LinearLayout)layoutinflater.findViewById(0x7f0b01bc);
        spek_head_InfoTamb = (LinearLayout)layoutinflater.findViewById(0x7f0b01bf);
        spek_head_Lay_EXT = (LinearLayout)layoutinflater.findViewById(0x7f0b04b4);
        spek_head_Lay_EXT.setVisibility(8);
        spek_head_Lay_Tambahan = (LinearLayout)layoutinflater.findViewById(0x7f0b04b6);
        spek_head_MemoriAllKet = (LinearLayout)layoutinflater.findViewById(0x7f0b04b8);
        spek_head_hard_ket = (LinearLayout)layoutinflater.findViewById(0x7f0b04ba);
        spek_head_Lay_Tambahan.setVisibility(8);
        t = Utility.session(t);
        edtLayarProteksi = (EditText)layoutinflater.findViewById(0x7f0b0150);
        edtLayarSensor = (EditText)layoutinflater.findViewById(0x7f0b014d);
        edtLayarMultitouch = (EditText)layoutinflater.findViewById(0x7f0b014a);
        edtLayarUkuran = (EditText)layoutinflater.findViewById(0x7f0b0147);
        edtLayarTipe = (EditText)layoutinflater.findViewById(0x7f0b0144);
        edtUmumStatus = (EditText)layoutinflater.findViewById(0x7f0b0141);
        edtUmumDiUm = (EditText)layoutinflater.findViewById(0x7f0b013e);
        edtUmumWarna = (EditText)layoutinflater.findViewById(0x7f0b013b);
        edtUmumBobot = (EditText)layoutinflater.findViewById(0x7f0b0138);
        edtUmumDim = (EditText)layoutinflater.findViewById(0x7f0b0135);
        edtUmumModelHp = (EditText)layoutinflater.findViewById(0x7f0b0133);
        edtJarMultiSimCard = (EditText)layoutinflater.findViewById(0x7f0b0130);
        edtJarSimCard = (EditText)layoutinflater.findViewById(0x7f0b012d);
        edtJarBandwidth = (EditText)layoutinflater.findViewById(0x7f0b012a);
        edtJarEdge = (EditText)layoutinflater.findViewById(0x7f0b0127);
        edtJarGPRS = (EditText)layoutinflater.findViewById(0x7f0b0124);
        edtJar4g = (EditText)layoutinflater.findViewById(0x7f0b0121);
        edtJar3g = (EditText)layoutinflater.findViewById(0x7f0b011e);
        edtJar2g = (EditText)layoutinflater.findViewById(0x7f0b011b);
        edtKeteranganTambahan = (EditText)layoutinflater.findViewById(0x7f0b0558);
        edtHargaBaru = (EditText)layoutinflater.findViewById(0x7f0b01b7);
        edtHargaBekas = (EditText)layoutinflater.findViewById(0x7f0b01ba);
        edtHargaGaransi = (EditText)layoutinflater.findViewById(0x7f0b01bd);
        edtHargaInfoTamb = (EditText)layoutinflater.findViewById(0x7f0b01c0);
        edtBatIsiBox = (EditText)layoutinflater.findViewById(0x7f0b01b4);
        edtBatSiaga = (EditText)layoutinflater.findViewById(0x7f0b01b1);
        edtBatBicara = (EditText)layoutinflater.findViewById(0x7f0b01ae);
        edtBatJenis = (EditText)layoutinflater.findViewById(0x7f0b01ab);
        edtLain2Fiturlain = (EditText)layoutinflater.findViewById(0x7f0b01a8);
        edtLain2Pesan = (EditText)layoutinflater.findViewById(0x7f0b01a5);
        edtLain2Browser = (EditText)layoutinflater.findViewById(0x7f0b01a2);
        edtLain2GPS = (EditText)layoutinflater.findViewById(0x7f0b019f);
        edtLain2Analog = (EditText)layoutinflater.findViewById(0x7f0b019c);
        edtLain2Radio = (EditText)layoutinflater.findViewById(0x7f0b0199);
        edtLain2Musik = (EditText)layoutinflater.findViewById(0x7f0b0196);
        edtKonekInfrared = (EditText)layoutinflater.findViewById(0x7f0b0193);
        edtKonekTV = (EditText)layoutinflater.findViewById(0x7f0b0190);
        edtKonekHDMI = (EditText)layoutinflater.findViewById(0x7f0b018d);
        edtKonekNFC = (EditText)layoutinflater.findViewById(0x7f0b018a);
        edtKonekWLAN = (EditText)layoutinflater.findViewById(0x7f0b0187);
        edtKonek35Jack = (EditText)layoutinflater.findViewById(0x7f0b0184);
        edtKonekUSB = (EditText)layoutinflater.findViewById(0x7f0b0181);
        edtKonekBlue = (EditText)layoutinflater.findViewById(0x7f0b017e);
        edtMemoriPhoneBook = (EditText)layoutinflater.findViewById(0x7f0b017b);
        edtMemoriExternal = (EditText)layoutinflater.findViewById(0x7f0b0178);
        edtMemoriInternal = (EditText)layoutinflater.findViewById(0x7f0b0175);
        edtNatVidCall = (EditText)layoutinflater.findViewById(0x7f0b0172);
        edtKameraDepan = (EditText)layoutinflater.findViewById(0x7f0b016f);
        edtKameraVidRec = (EditText)layoutinflater.findViewById(0x7f0b016c);
        edtKameraFitKam = (EditText)layoutinflater.findViewById(0x7f0b0169);
        edtKameraLamKil = (EditText)layoutinflater.findViewById(0x7f0b0166);
        edtKameraUtama = (EditText)layoutinflater.findViewById(0x7f0b0163);
        edtSoftJava = (EditText)layoutinflater.findViewById(0x7f0b0160);
        edtSoftOS = (EditText)layoutinflater.findViewById(0x7f0b015d);
        edtHardGPU = (EditText)layoutinflater.findViewById(0x7f0b015a);
        edtHardCPU = (EditText)layoutinflater.findViewById(0x7f0b0157);
        edtHardChipset = (EditText)layoutinflater.findViewById(0x7f0b0154);
        edtLayarEXT = (EditText)layoutinflater.findViewById(0x7f0b04b5);
        edtLayarTambahan = (EditText)layoutinflater.findViewById(0x7f0b04b7);
        edtHardAllKet = (EditText)layoutinflater.findViewById(0x7f0b04bb);
        edtMemoriAllKet = (EditText)layoutinflater.findViewById(0x7f0b04b9);
        rataDesain = (TextView)layoutinflater.findViewById(0x7f0b01e6);
        rataLayar = (TextView)layoutinflater.findViewById(0x7f0b01e9);
        rataKinerja = (TextView)layoutinflater.findViewById(0x7f0b01ec);
        rataKamera = (TextView)layoutinflater.findViewById(0x7f0b01ef);
        rataBaterai = (TextView)layoutinflater.findViewById(0x7f0b01f2);
        btnDesainRate = (Button)layoutinflater.findViewById(0x7f0b01e7);
        btnLayarRate = (Button)layoutinflater.findViewById(0x7f0b01ea);
        btnKinerjaRate = (Button)layoutinflater.findViewById(0x7f0b01ed);
        btnKameraRate = (Button)layoutinflater.findViewById(0x7f0b01f0);
        btnBateraiRate = (Button)layoutinflater.findViewById(0x7f0b01f3);
        btnKirimNilai = (Button)layoutinflater.findViewById(0x7f0b01f5);
        totalVotes = (TextView)layoutinflater.findViewById(0x7f0b01f4);
        ratingBaterai = (ProgressBar)layoutinflater.findViewById(0x7f0b01f1);
        ratingKamera = (ProgressBar)layoutinflater.findViewById(0x7f0b01ee);
        ratingKinerja = (ProgressBar)layoutinflater.findViewById(0x7f0b01eb);
        ratingLayar = (ProgressBar)layoutinflater.findViewById(0x7f0b01e8);
        ratingDesain = (ProgressBar)layoutinflater.findViewById(0x7f0b01e5);
        animationin = AnimationUtils.loadAnimation(getActivity(), 0x7f040011);
        animationin.setDuration(500L);
        imgbtn_share_fb.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2Spek this$0;

            public void onClick(View view)
            {
                if (appInstalledOrNot("com.facebook.katana"))
                {
                    Log.e("share", "facebook");
                    view = ((com.facebook.share.model.ShareLinkContent.Builder)(new com.facebook.share.model.ShareLinkContent.Builder()).setContentTitle((new StringBuilder(String.valueOf(namalengkap))).append(" - Berita, Spesifikasi, Review, Galeri foto, Harga, Service Center").toString()).setImageUrl(Uri.parse(gambar)).setContentDescription((new StringBuilder("Spesifikasi lengkap ")).append(namalengkap).append(". Diumumkan pada ").append(str_share_diumumkan).append(". Fitur ").append(str_share_desc).toString()).setContentUrl(Uri.parse(str_urlspekshare))).build();
                    shareDialog.show(view);
                    return;
                } else
                {
                    Log.e("share", "other");
                    popup_dialog("Perhatian", "Aplikasi Facebook tidak tersedia");
                    return;
                }
            }

            
            {
                this$0 = Hal2Spek.this;
                super();
            }
        });
        imgbtn_share_tw.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2Spek this$0;

            public void onClick(View view)
            {
                if (appInstalledOrNot("com.twitter.android"))
                {
                    Log.e("share", "com.twitter.android");
                    view = new Intent("android.intent.action.SEND");
                    view.setType("text/plain");
                    view.setPackage("com.twitter.android");
                    view.putExtra("android.intent.extra.TEXT", (new StringBuilder("Info lengkap ")).append(namalengkap).append(". Spesifikasi, berita, harga,dll. ").append(str_urlspekshare).toString());
                    getActivity().startActivity(view);
                    return;
                } else
                {
                    Log.e("share", "other");
                    popup_dialog("Perhatian", "Aplikasi Twitter tidak tersedia");
                    return;
                }
            }

            
            {
                this$0 = Hal2Spek.this;
                super();
            }
        });
        imgbtn_share_gplus.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2Spek this$0;

            public void onClick(View view)
            {
                if (appInstalledOrNot("com.google.android.apps.plus"))
                {
                    view = new Intent("android.intent.action.SEND");
                    view.setType("text/plain");
                    view.setPackage("com.google.android.apps.plus");
                    view.putExtra("android.intent.extra.TEXT", (new StringBuilder("Info lengkap ")).append(namalengkap).append(". Spesifikasi, berita, harga,dll. ").append(str_urlspekshare).toString());
                    getActivity().startActivity(view);
                    return;
                } else
                {
                    Log.e("share", "other");
                    popup_dialog("Perhatian", "Aplikasi Google Plus tidak tersedia");
                    return;
                }
            }

            
            {
                this$0 = Hal2Spek.this;
                super();
            }
        });
        imgbtn_share_wa.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2Spek this$0;

            public void onClick(View view)
            {
                if (appInstalledOrNot("com.whatsapp"))
                {
                    Log.e("share", "com.whatsapp");
                    view = new Intent("android.intent.action.SEND");
                    view.setType("text/plain");
                    view.setPackage("com.whatsapp");
                    view.putExtra("android.intent.extra.TEXT", (new StringBuilder("Info lengkap ")).append(namalengkap).append(". Spesifikasi, berita, harga,dll. ").append(str_urlspekshare).toString());
                    getActivity().startActivity(view);
                    return;
                } else
                {
                    Log.e("share", "other");
                    popup_dialog("Perhatian", "Aplikasi Whatsapp tidak tersedia");
                    return;
                }
            }

            
            {
                this$0 = Hal2Spek.this;
                super();
            }
        });
        imgbtn_share_mail.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2Spek this$0;

            public void onClick(View view)
            {
                view = (new StringBuilder("Spesifikasi ")).append(namalengkap).toString();
                String s = (new StringBuilder("Info lengkap ")).append(namalengkap).append(". Spesifikasi, berita, harga,dll. ").append(str_urlspekshare).toString();
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("message/rfc822");
                intent.putExtra("android.intent.extra.EMAIL", new String[] {
                    ""
                });
                intent.putExtra("android.intent.extra.SUBJECT", view);
                intent.putExtra("android.intent.extra.TEXT", s);
                getActivity().startActivity(Intent.createChooser(intent, "Pilih email anda:"));
            }

            
            {
                this$0 = Hal2Spek.this;
                super();
            }
        });
        imgbtn_share_more.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2Spek this$0;

            public void onClick(View view)
            {
                share_to_socmed();
            }

            
            {
                this$0 = Hal2Spek.this;
                super();
            }
        });
        layout_Twitter.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2Spek this$0;

            public void onClick(View view)
            {
                view = new Intent(getActivity(), com/inponsel/android/details/TwitterInPonsel);
                view.putExtra("twitter", twitter);
                startActivityForResult(view, 0);
                getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = Hal2Spek.this;
                super();
            }
        });
        btnAddKomentarHp.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2Spek this$0;

            public void onClick(View view)
            {
                if (userFunction.isUserLoggedIn(getActivity()))
                {
                    show_popup_komentar();
                    return;
                } else
                {
                    view = new android.app.AlertDialog.Builder(wrapper);
                    view.setTitle("Perhatian");
                    view.setMessage("Untuk memberi komentar anda harus login terlebih dahulu");
                    view.setPositiveButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls10 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            getActivity().startActivityForResult(dialoginterface, 0);
                            getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls10.this;
                super();
            }
                    });
                    view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls10 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                            getActivity().startActivityForResult(dialoginterface, 0);
                            getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls10.this;
                super();
            }
                    });
                    view.setNegativeButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                        final _cls10 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls10.this;
                super();
            }
                    });
                    view.show();
                    return;
                }
            }


            
            {
                this$0 = Hal2Spek.this;
                super();
            }
        });
        btnKomentarHp.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2Spek this$0;

            public void onClick(View view)
            {
                view = new Intent(getActivity(), com/inponsel/android/v2/KomentarPonsel);
                view.putExtra("id_hph", id_hp);
                view.putExtra("namalengkap", namalengkap);
                view.putExtra("codename", codename);
                view.putExtra("model", model);
                view.putExtra("merk", merk);
                view.putExtra("gambar", gambar);
                view.putExtra("hrg_baru", hrg_baru);
                view.putExtra("hrg_bekas", hrg_bekas);
                view.putExtra("tot_like", tot_like);
                view.putExtra("tot_dislike", tot_dislike);
                view.putExtra("tot_komen", tot_komen);
                startActivityForResult(view, 0);
                getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = Hal2Spek.this;
                super();
            }
        });
        layout_Bandingkan.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2Spek this$0;

            public void onClick(View view)
            {
                view = new Intent(getActivity(), com/inponsel/android/details/PilihPonselBanding);
                view.putExtra("id_hph", id_hp);
                view.putExtra("namalengkap", namalengkap);
                view.putExtra("codename", codename);
                view.putExtra("model", model);
                view.putExtra("merk", merk);
                view.putExtra("gambar", gambar);
                view.putExtra("hrg_baru", hrg_baru);
                view.putExtra("hrg_bekas", hrg_bekas);
                view.putExtra("tot_like", tnggp_bgs);
                view.putExtra("tot_dislike", tnggp_krg);
                view.putExtra("tot_komen", jml_komentar);
                startActivityForResult(view, 0);
                getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = Hal2Spek.this;
                super();
            }
        });
        layout_Berita.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2Spek this$0;

            public void onClick(View view)
            {
                view = new Intent(getActivity(), com/inponsel/android/v2/RSSFeedByTag);
                view.putExtra("tag_code", "5");
                view.putExtra("tag_key", (new StringBuilder("hp:")).append(id_hp).toString());
                view.putExtra("kategori_tag", namalengkap);
                getActivity().startActivityForResult(view, 0);
                getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = Hal2Spek.this;
                super();
            }
        });
        layout_ChatRoom.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2Spek this$0;

            public void onClick(View view)
            {
                if (userFunction.isUserLoggedIn(getActivity()))
                {
                    view = new Intent(getActivity(), com/inponsel/android/v2/RoomChatActivity);
                    view.putExtra("id_from", user_id);
                    view.putExtra("from_name", username);
                    view.putExtra("from_photo", user_photo);
                    view.putExtra("to_photo", gambar);
                    view.putExtra("merk", merk);
                    view.putExtra("model", model);
                    view.putExtra("codename", (new StringBuilder(String.valueOf(codename))).append("-").append(codename).toString());
                    view.putExtra("id_hph", id_hp);
                    OnlineStatGroup(user_id, codename, "1", t, "");
                    startActivityForResult(view, 0);
                    getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                    return;
                } else
                {
                    LoginPopup("Perhatian", "Untuk masuk ke chat room diharuskan login dahulu");
                    return;
                }
            }

            
            {
                this$0 = Hal2Spek.this;
                super();
            }
        });
        layout_Forum.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2Spek this$0;

            public void onClick(View view)
            {
                view = new Intent(getActivity(), com/inponsel/android/tlforum/ForumHPActivity);
                view.putExtra("id_hph", id_hp);
                view.putExtra("namalengkap", namalengkap);
                view.putExtra("codename", codename);
                view.putExtra("model", model);
                view.putExtra("merk", merk);
                view.putExtra("gambar", gambar);
                view.putExtra("kota", room_kota);
                view.putExtra("kota_id", room_kota_id);
                view.putExtra("prov", room_prov);
                startActivityForResult(view, 0);
                getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = Hal2Spek.this;
                super();
            }
        });
        layout_GalleriFoto.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2Spek this$0;

            public void onClick(View view)
            {
                view = new Intent(getActivity(), com/inponsel/android/details/GalleriFotoHp);
                view.putExtra("id_hph", id_hp);
                view.putExtra("namalengkap", namalengkap);
                view.putExtra("codename", codename);
                view.putExtra("model", model);
                view.putExtra("merk", merk);
                view.putExtra("gambar", gambar);
                startActivityForResult(view, 0);
                getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = Hal2Spek.this;
                super();
            }
        });
        layout_HpLain.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2Spek this$0;

            public void onClick(View view)
            {
                view = new Intent(getActivity(), com/inponsel/android/v2/DaftarPonselMerkActivity);
                view.putExtra("merk", id_merk);
                view.putExtra("titlemerek", merk);
                getActivity().startActivityForResult(view, 0);
                getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = Hal2Spek.this;
                super();
            }
        });
        layout_VendorProf.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2Spek this$0;

            public void onClick(View view)
            {
                view = new Intent(getActivity(), com/inponsel/android/details/ProfilPTActivity);
                view.putExtra("id_merk", id_merk);
                view.putExtra("titlemerek", merk);
                getActivity().startActivityForResult(view, 0);
                getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = Hal2Spek.this;
                super();
            }
        });
        layout_SCTerdekat.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2Spek this$0;

            public void onClick(View view)
            {
                view = new Intent(getActivity(), com/inponsel/android/details/SCTerdekatActivity);
                view.putExtra("id_merk", id_merk);
                view.putExtra("titlemerek", merk);
                getActivity().startActivityForResult(view, 0);
                getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = Hal2Spek.this;
                super();
            }
        });
        detail_favorite.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2Spek this$0;

            public void onClick(View view)
            {
                if (userFunction.isUserLoggedIn(getActivity()))
                {
                    if (db.checkIfExist(id_hp))
                    {
                        view = new android.app.AlertDialog.Builder(getActivity());
                        view.setMessage("Hapus perangkat ini dari favorit?");
                        view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                            final _cls20 this$1;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                                statFavHp = "0";
                                (new FavoritTask()).execute(new Void[0]);
                            }

            
            {
                this$1 = _cls20.this;
                super();
            }
                        });
                        view.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                            final _cls20 this$1;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$1 = _cls20.this;
                super();
            }
                        });
                        view.show();
                        return;
                    } else
                    {
                        view = new android.app.AlertDialog.Builder(getActivity());
                        view.setMessage("Favoritkan perangkat ini?");
                        view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                            final _cls20 this$1;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                statFavHp = "1";
                                (new FavoritTask()).execute(new Void[0]);
                            }

            
            {
                this$1 = _cls20.this;
                super();
            }
                        });
                        view.setNeutralButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                            final _cls20 this$1;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$1 = _cls20.this;
                super();
            }
                        });
                        view.show();
                        return;
                    }
                } else
                {
                    view = new android.app.AlertDialog.Builder(getActivity());
                    view.setMessage("Untuk menambahkan ke favorit, diharuskan login.");
                    view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                        final _cls20 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls20.this;
                super();
            }
                    });
                    view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls20 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                            startActivityForResult(dialoginterface, 0);
                            getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls20.this;
                super();
            }
                    });
                    view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls20 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            startActivityForResult(dialoginterface, 0);
                            getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls20.this;
                super();
            }
                    });
                    view.show();
                    return;
                }
            }


            
            {
                this$0 = Hal2Spek.this;
                super();
            }
        });
        detail_favoritenews.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2Spek this$0;

            public void onClick(View view)
            {
                if (userFunction.isUserLoggedIn(getActivity()))
                {
                    if (statSubNews.equals("1"))
                    {
                        view = new android.app.AlertDialog.Builder(getActivity());
                        view.setMessage("Hentikan langganan berita perangkat ini?");
                        view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                            final _cls21 this$1;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                                statSubNews = "0";
                                (new SubsNewsTask()).execute(new Void[0]);
                            }

            
            {
                this$1 = _cls21.this;
                super();
            }
                        });
                        view.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                            final _cls21 this$1;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$1 = _cls21.this;
                super();
            }
                        });
                        view.show();
                        return;
                    } else
                    {
                        view = new android.app.AlertDialog.Builder(getActivity());
                        view.setMessage("Langganan berita perangkat ini?");
                        view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                            final _cls21 this$1;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                statSubNews = "1";
                                (new SubsNewsTask()).execute(new Void[0]);
                            }

            
            {
                this$1 = _cls21.this;
                super();
            }
                        });
                        view.setNeutralButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                            final _cls21 this$1;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$1 = _cls21.this;
                super();
            }
                        });
                        view.show();
                        return;
                    }
                } else
                {
                    view = new android.app.AlertDialog.Builder(getActivity());
                    view.setMessage("Untuk berlangganan berita, diharuskan login.");
                    view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                        final _cls21 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls21.this;
                super();
            }
                    });
                    view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls21 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                            startActivityForResult(dialoginterface, 0);
                            getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls21.this;
                super();
            }
                    });
                    view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls21 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            startActivityForResult(dialoginterface, 0);
                            getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls21.this;
                super();
            }
                    });
                    view.show();
                    return;
                }
            }


            
            {
                this$0 = Hal2Spek.this;
                super();
            }
        });
        btnDesainRate.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2Spek this$0;

            public void onClick(View view)
            {
                if (userFunction.isUserLoggedIn(getActivity()))
                {
                    view = new String[10];
                    view[0] = "1";
                    view[1] = "2";
                    view[2] = "3";
                    view[3] = "4";
                    view[4] = "5";
                    view[5] = "6";
                    view[6] = "7";
                    view[7] = "8";
                    view[8] = "9";
                    view[9] = "10";
                    android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(wrapper);
                    builder.setTitle("Nilai Desain :");
                    builder.setSingleChoiceItems(view, -1, view. new android.content.DialogInterface.OnClickListener() {

                        final _cls22 this$1;
                        private final String val$items[];

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                            btnDesainRate.setText(items[i]);
                            nilbtnDesain = items[i];
                        }

            
            {
                this$1 = final__pcls22;
                items = _5B_Ljava.lang.String_3B_.this;
                super();
            }
                    });
                    builder.show();
                    return;
                } else
                {
                    view = new android.app.AlertDialog.Builder(wrapper);
                    view.setTitle("Perhatian");
                    view.setMessage("Untuk memberi penilaian anda harus login terlebih dahulu");
                    view.setPositiveButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls22 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            getActivity().startActivityForResult(dialoginterface, 0);
                            getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls22.this;
                super();
            }
                    });
                    view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls22 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                            getActivity().startActivityForResult(dialoginterface, 0);
                            getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls22.this;
                super();
            }
                    });
                    view.setNegativeButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                        final _cls22 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls22.this;
                super();
            }
                    });
                    view.show();
                    return;
                }
            }


            
            {
                this$0 = Hal2Spek.this;
                super();
            }
        });
        btnLayarRate.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2Spek this$0;

            public void onClick(View view)
            {
                if (userFunction.isUserLoggedIn(getActivity()))
                {
                    view = new String[10];
                    view[0] = "1";
                    view[1] = "2";
                    view[2] = "3";
                    view[3] = "4";
                    view[4] = "5";
                    view[5] = "6";
                    view[6] = "7";
                    view[7] = "8";
                    view[8] = "9";
                    view[9] = "10";
                    android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(wrapper);
                    builder.setTitle("Nilai Layar :");
                    builder.setSingleChoiceItems(view, -1, view. new android.content.DialogInterface.OnClickListener() {

                        final _cls23 this$1;
                        private final String val$items[];

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                            btnLayarRate.setText(items[i]);
                            nilbtnLayar = items[i];
                        }

            
            {
                this$1 = final__pcls23;
                items = _5B_Ljava.lang.String_3B_.this;
                super();
            }
                    });
                    builder.show();
                    return;
                } else
                {
                    view = new android.app.AlertDialog.Builder(wrapper);
                    view.setTitle("Perhatian");
                    view.setMessage("Untuk memberi penilaian anda harus login terlebih dahulu");
                    view.setPositiveButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls23 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            getActivity().startActivityForResult(dialoginterface, 0);
                            getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls23.this;
                super();
            }
                    });
                    view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls23 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                            getActivity().startActivityForResult(dialoginterface, 0);
                            getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls23.this;
                super();
            }
                    });
                    view.setNegativeButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                        final _cls23 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls23.this;
                super();
            }
                    });
                    view.show();
                    return;
                }
            }


            
            {
                this$0 = Hal2Spek.this;
                super();
            }
        });
        btnKinerjaRate.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2Spek this$0;

            public void onClick(View view)
            {
                if (userFunction.isUserLoggedIn(getActivity()))
                {
                    view = new String[10];
                    view[0] = "1";
                    view[1] = "2";
                    view[2] = "3";
                    view[3] = "4";
                    view[4] = "5";
                    view[5] = "6";
                    view[6] = "7";
                    view[7] = "8";
                    view[8] = "9";
                    view[9] = "10";
                    android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(wrapper);
                    builder.setTitle("Nilai Kinerja :");
                    builder.setSingleChoiceItems(view, -1, view. new android.content.DialogInterface.OnClickListener() {

                        final _cls24 this$1;
                        private final String val$items[];

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                            btnKinerjaRate.setText(items[i]);
                            nilbtnKinerja = items[i];
                        }

            
            {
                this$1 = final__pcls24;
                items = _5B_Ljava.lang.String_3B_.this;
                super();
            }
                    });
                    builder.show();
                    return;
                } else
                {
                    view = new android.app.AlertDialog.Builder(wrapper);
                    view.setTitle("Perhatian");
                    view.setMessage("Untuk memberi penilaian anda harus login terlebih dahulu");
                    view.setPositiveButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls24 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            getActivity().startActivityForResult(dialoginterface, 0);
                            getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls24.this;
                super();
            }
                    });
                    view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls24 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                            getActivity().startActivityForResult(dialoginterface, 0);
                            getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls24.this;
                super();
            }
                    });
                    view.setNegativeButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                        final _cls24 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls24.this;
                super();
            }
                    });
                    view.show();
                    return;
                }
            }


            
            {
                this$0 = Hal2Spek.this;
                super();
            }
        });
        btnKameraRate.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2Spek this$0;

            public void onClick(View view)
            {
                if (userFunction.isUserLoggedIn(getActivity()))
                {
                    view = new String[10];
                    view[0] = "1";
                    view[1] = "2";
                    view[2] = "3";
                    view[3] = "4";
                    view[4] = "5";
                    view[5] = "6";
                    view[6] = "7";
                    view[7] = "8";
                    view[8] = "9";
                    view[9] = "10";
                    android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(wrapper);
                    builder.setTitle("Nilai Kamera :");
                    builder.setSingleChoiceItems(view, -1, view. new android.content.DialogInterface.OnClickListener() {

                        final _cls25 this$1;
                        private final String val$items[];

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                            btnKameraRate.setText(items[i]);
                            nilbtnKamera = items[i];
                        }

            
            {
                this$1 = final__pcls25;
                items = _5B_Ljava.lang.String_3B_.this;
                super();
            }
                    });
                    builder.show();
                    return;
                } else
                {
                    view = new android.app.AlertDialog.Builder(wrapper);
                    view.setTitle("Perhatian");
                    view.setMessage("Untuk memberi penilaian anda harus login terlebih dahulu");
                    view.setPositiveButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls25 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            getActivity().startActivityForResult(dialoginterface, 0);
                            getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls25.this;
                super();
            }
                    });
                    view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls25 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                            getActivity().startActivityForResult(dialoginterface, 0);
                            getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls25.this;
                super();
            }
                    });
                    view.setNegativeButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                        final _cls25 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls25.this;
                super();
            }
                    });
                    view.show();
                    return;
                }
            }


            
            {
                this$0 = Hal2Spek.this;
                super();
            }
        });
        btnBateraiRate.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2Spek this$0;

            public void onClick(View view)
            {
                if (userFunction.isUserLoggedIn(getActivity()))
                {
                    view = new String[10];
                    view[0] = "1";
                    view[1] = "2";
                    view[2] = "3";
                    view[3] = "4";
                    view[4] = "5";
                    view[5] = "6";
                    view[6] = "7";
                    view[7] = "8";
                    view[8] = "9";
                    view[9] = "10";
                    android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(wrapper);
                    builder.setTitle("Nilai Baterai :");
                    builder.setSingleChoiceItems(view, -1, view. new android.content.DialogInterface.OnClickListener() {

                        final _cls26 this$1;
                        private final String val$items[];

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                            btnBateraiRate.setText(items[i]);
                            nilbtnBaterai = items[i];
                        }

            
            {
                this$1 = final__pcls26;
                items = _5B_Ljava.lang.String_3B_.this;
                super();
            }
                    });
                    builder.show();
                    return;
                } else
                {
                    view = new android.app.AlertDialog.Builder(wrapper);
                    view.setTitle("Perhatian");
                    view.setMessage("Untuk memberi penilaian anda harus login terlebih dahulu");
                    view.setPositiveButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls26 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            getActivity().startActivityForResult(dialoginterface, 0);
                            getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls26.this;
                super();
            }
                    });
                    view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls26 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                            getActivity().startActivityForResult(dialoginterface, 0);
                            getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls26.this;
                super();
            }
                    });
                    view.setNegativeButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                        final _cls26 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls26.this;
                super();
            }
                    });
                    view.show();
                    return;
                }
            }


            
            {
                this$0 = Hal2Spek.this;
                super();
            }
        });
        btnKirimNilai.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2Spek this$0;

            public void onClick(View view)
            {
                if (userFunction.isUserLoggedIn(getActivity()))
                {
                    view = new android.app.AlertDialog.Builder(wrapper);
                    view.setTitle((new StringBuilder("Penilaian ")).append(namalengkap).toString());
                    view.setMessage((new StringBuilder("Desain : ")).append(nilbtnDesain).append("\nLayar : ").append(nilbtnLayar).append("\nKinerja : ").append(nilbtnKinerja).append("\nKamera : ").append(nilbtnKamera).append("\nBaterai : ").append(nilbtnBaterai).toString());
                    view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                        final _cls27 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            if (android.os.Build.VERSION.SDK_INT >= 11)
                            {
                                (new PostNilaiTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                                return;
                            }
                            if (android.os.Build.VERSION.SDK_INT >= 11)
                            {
                                (new PostNilaiTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                                return;
                            } else
                            {
                                (new PostNilaiTask()).execute(new Void[0]);
                                return;
                            }
                        }

            
            {
                this$1 = _cls27.this;
                super();
            }
                    });
                    view.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                        final _cls27 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls27.this;
                super();
            }
                    });
                    view.show();
                    return;
                } else
                {
                    view = new android.app.AlertDialog.Builder(wrapper);
                    view.setTitle("Perhatian");
                    view.setMessage("Untuk memberi penilaian anda harus login terlebih dahulu");
                    view.setPositiveButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls27 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            getActivity().startActivityForResult(dialoginterface, 0);
                            getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls27.this;
                super();
            }
                    });
                    view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls27 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                            getActivity().startActivityForResult(dialoginterface, 0);
                            getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls27.this;
                super();
            }
                    });
                    view.setNegativeButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                        final _cls27 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls27.this;
                super();
            }
                    });
                    view.show();
                    return;
                }
            }


            
            {
                this$0 = Hal2Spek.this;
                super();
            }
        });
        btnKirimError.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2Spek this$0;

            public void onClick(View view)
            {
                view = (new StringBuilder("Koreksi (")).append(namalengkap).append(")").toString();
                String s = edtKoreksiUser.getText().toString();
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("message/rfc822");
                intent.putExtra("android.intent.extra.EMAIL", new String[] {
                    "support@inponsel.co.id"
                });
                intent.putExtra("android.intent.extra.SUBJECT", view);
                intent.putExtra("android.intent.extra.TEXT", s);
                getActivity().startActivity(Intent.createChooser(intent, "Pilih email anda:"));
            }

            
            {
                this$0 = Hal2Spek.this;
                super();
            }
        });
        btnReportInCorrect.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2Spek this$0;

            public void onClick(View view)
            {
                view = (new StringBuilder("Koreksi (")).append(namalengkap).append(")").toString();
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("message/rfc822");
                intent.putExtra("android.intent.extra.EMAIL", new String[] {
                    "support@inponsel.co.id"
                });
                intent.putExtra("android.intent.extra.SUBJECT", view);
                intent.putExtra("android.intent.extra.TEXT", "");
                getActivity().startActivity(Intent.createChooser(intent, "Pilih email anda:"));
            }

            
            {
                this$0 = Hal2Spek.this;
                super();
            }
        });
        btnShowComment.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2Spek this$0;

            public void onClick(View view)
            {
                ((DetailsPonsel)getActivity()).getViewPager().setCurrentItem(2);
            }

            
            {
                this$0 = Hal2Spek.this;
                super();
            }
        });
        detail_lay_like.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2Spek this$0;

            public void onClick(View view)
            {
                ponselBaseApp.getObserver().setIndexHp(codename);
                if (userFunction.isUserLoggedIn(getActivity()))
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
                    view = new android.app.AlertDialog.Builder(getActivity());
                    view.setTitle("Perhatian");
                    view.setMessage("Untuk memberi penilaian anda harus login terlebih dahulu");
                    view.setPositiveButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls31 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            startActivityForResult(dialoginterface, 0);
                            getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
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
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                            startActivityForResult(dialoginterface, 0);
                            getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls31.this;
                super();
            }
                    });
                    view.setNegativeButton("Tutup", new android.content.DialogInterface.OnClickListener() {

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
                    view.show();
                    return;
                }
            }


            
            {
                this$0 = Hal2Spek.this;
                super();
            }
        });
        detail_lay_dislike.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2Spek this$0;

            public void onClick(View view)
            {
                ponselBaseApp.getObserver().setIndexHp(codename);
                if (userFunction.isUserLoggedIn(getActivity()))
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
                    view = new android.app.AlertDialog.Builder(getActivity());
                    view.setTitle("Perhatian");
                    view.setMessage("Untuk memberi penilaian anda harus login terlebih dahulu");
                    view.setPositiveButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls32 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            startActivityForResult(dialoginterface, 0);
                            getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls32.this;
                super();
            }
                    });
                    view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls32 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                            startActivityForResult(dialoginterface, 0);
                            getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls32.this;
                super();
            }
                    });
                    view.setNegativeButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                        final _cls32 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls32.this;
                super();
            }
                    });
                    view.show();
                    return;
                }
            }


            
            {
                this$0 = Hal2Spek.this;
                super();
            }
        });
        btnBerikan.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2Spek this$0;

            public void onClick(View view)
            {
                if (userFunction.isUserLoggedIn(getActivity()))
                {
                    view = new Dialog(getActivity());
                    view.requestWindowFeature(1);
                    view.setCancelable(true);
                    view.setContentView(0x7f03001b);
                    lineColor = (LinearLayout)view.findViewById(0x7f0b0065);
                    lineColor.setBackgroundColor(getResources().getColor(0x7f080044));
                    txtCountKomen = (TextView)view.findViewById(0x7f0b0067);
                    edtUser = (EditText)view.findViewById(0x7f0b0064);
                    edtUser.setText(username);
                    edtComment = (EditText)view.findViewById(0x7f0b0066);
                    btnSubmit = (Button)view.findViewById(0x7f0b0069);
                    btnCancel = (Button)view.findViewById(0x7f0b0068);
                    btnCancel.setOnClickListener(view. new android.view.View.OnClickListener() {

                        final _cls33 this$1;
                        private final Dialog val$dialog;

                        public void onClick(View view)
                        {
                            dialog.dismiss();
                            ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                        }

            
            {
                this$1 = final__pcls33;
                dialog = Dialog.this;
                super();
            }
                    });
                    edtComment.addTextChangedListener(new TextWatcher() {

                        final _cls33 this$1;

                        public void afterTextChanged(Editable editable)
                        {
                            if (edtUser.getText().toString().length() == 0 || edtComment.getText().toString().length() == 0 || edtComment.getText().toString().trim().equals(""))
                            {
                                btnSubmit.setEnabled(false);
                                txtCountKomen.setText("512");
                                return;
                            } else
                            {
                                btnSubmit.setEnabled(true);
                                charCount = 512 - edtComment.getText().toString().length();
                                txtCountKomen.setText(String.valueOf(charCount));
                                return;
                            }
                        }

                        public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
                        {
                            if (edtUser.getText().toString().length() == 0 || edtComment.getText().toString().length() == 0 || edtComment.getText().toString().trim().equals(""))
                            {
                                btnSubmit.setEnabled(false);
                                txtCountKomen.setText("512");
                                return;
                            } else
                            {
                                btnSubmit.setEnabled(true);
                                charCount = 512 - edtComment.getText().toString().length();
                                txtCountKomen.setText(String.valueOf(charCount));
                                return;
                            }
                        }

                        public void onTextChanged(CharSequence charsequence, int i, int j, int k)
                        {
                            if (edtUser.getText().toString().length() == 0 || edtComment.getText().toString().length() == 0 || edtComment.getText().toString().trim().equals(""))
                            {
                                btnSubmit.setEnabled(false);
                                txtCountKomen.setText("512");
                                return;
                            } else
                            {
                                btnSubmit.setEnabled(true);
                                charCount = 512 - edtComment.getText().toString().length();
                                txtCountKomen.setText(String.valueOf(charCount));
                                return;
                            }
                        }

            
            {
                this$1 = _cls33.this;
                super();
            }
                    });
                    btnSubmit.setOnClickListener(view. new android.view.View.OnClickListener() {

                        final _cls33 this$1;
                        private final Dialog val$dialog;

                        public void onClick(View view)
                        {
                            if (android.os.Build.VERSION.SDK_INT >= 11)
                            {
                                (new PostKomen()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                            } else
                            {
                                (new PostKomen()).execute(new Void[0]);
                            }
                            dialog.dismiss();
                        }

            
            {
                this$1 = final__pcls33;
                dialog = Dialog.this;
                super();
            }
                    });
                    view.show();
                    return;
                } else
                {
                    view = new android.app.AlertDialog.Builder(wrapper);
                    view.setTitle("Perhatian");
                    view.setMessage("Untuk memberi komentar anda harus login terlebih dahulu");
                    view.setPositiveButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls33 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                            getActivity().startActivityForResult(dialoginterface, 0);
                            getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls33.this;
                super();
            }
                    });
                    view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls33 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                            getActivity().startActivityForResult(dialoginterface, 0);
                            getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls33.this;
                super();
            }
                    });
                    view.setNegativeButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                        final _cls33 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls33.this;
                super();
            }
                    });
                    view.show();
                    return;
                }
            }


            
            {
                this$0 = Hal2Spek.this;
                super();
            }
        });
        btnBandingkan.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2Spek this$0;

            public void onClick(View view)
            {
                ((DetailsPonsel)getActivity()).getViewPager().setCurrentItem(4);
            }

            
            {
                this$0 = Hal2Spek.this;
                super();
            }
        });
        spek_head_ketamb = (LinearLayout)layoutinflater.findViewById(0x7f0b0557);
        spek_head_2g = (LinearLayout)layoutinflater.findViewById(0x7f0b011a);
        spek_head_3g = (LinearLayout)layoutinflater.findViewById(0x7f0b011d);
        spek_head_4g = (LinearLayout)layoutinflater.findViewById(0x7f0b0120);
        spek_head_GPRS = (LinearLayout)layoutinflater.findViewById(0x7f0b0123);
        spek_head_EDGE = (LinearLayout)layoutinflater.findViewById(0x7f0b0126);
        spek_head_Bandwidth = (LinearLayout)layoutinflater.findViewById(0x7f0b0129);
        spek_head_SIM = (LinearLayout)layoutinflater.findViewById(0x7f0b012c);
        spek_head_MultiSIM = (LinearLayout)layoutinflater.findViewById(0x7f0b012f);
        spek_head_ModelHP = (LinearLayout)layoutinflater.findViewById(0x7f0b0132);
        spek_head_Dimensi = (LinearLayout)layoutinflater.findViewById(0x7f0b0134);
        spek_head_Bobot = (LinearLayout)layoutinflater.findViewById(0x7f0b0137);
        spek_head_Warna = (LinearLayout)layoutinflater.findViewById(0x7f0b013a);
        spek_head_Diumumkan = (LinearLayout)layoutinflater.findViewById(0x7f0b013d);
        spek_head_Status = (LinearLayout)layoutinflater.findViewById(0x7f0b0140);
        spek_head_TipeHP = (LinearLayout)layoutinflater.findViewById(0x7f0b0143);
        spek_head_Ukuran = (LinearLayout)layoutinflater.findViewById(0x7f0b0146);
        spek_head_Multitouch = (LinearLayout)layoutinflater.findViewById(0x7f0b0149);
        spek_head_Sensor = (LinearLayout)layoutinflater.findViewById(0x7f0b014c);
        spek_head_Proteksi = (LinearLayout)layoutinflater.findViewById(0x7f0b014f);
        spek_head_Chipset = (LinearLayout)layoutinflater.findViewById(0x7f0b0153);
        spek_head_CPU = (LinearLayout)layoutinflater.findViewById(0x7f0b0156);
        spek_head_GPU = (LinearLayout)layoutinflater.findViewById(0x7f0b0159);
        spek_head_OS = (LinearLayout)layoutinflater.findViewById(0x7f0b015c);
        spek_head_Java = (LinearLayout)layoutinflater.findViewById(0x7f0b015f);
        spek_head_KamUtama = (LinearLayout)layoutinflater.findViewById(0x7f0b0162);
        spek_head_LamKil = (LinearLayout)layoutinflater.findViewById(0x7f0b0165);
        spek_head_FitKam = (LinearLayout)layoutinflater.findViewById(0x7f0b0168);
        spek_head_VidRec = (LinearLayout)layoutinflater.findViewById(0x7f0b016b);
        spek_head_KamDepan = (LinearLayout)layoutinflater.findViewById(0x7f0b016e);
        spek_head_NatVidCall = (LinearLayout)layoutinflater.findViewById(0x7f0b0171);
        spek_head_MemInternal = (LinearLayout)layoutinflater.findViewById(0x7f0b0174);
        spek_head_MemExternal = (LinearLayout)layoutinflater.findViewById(0x7f0b0177);
        spek_head_MemPhoneBook = (LinearLayout)layoutinflater.findViewById(0x7f0b017a);
        spek_head_Bluetooth = (LinearLayout)layoutinflater.findViewById(0x7f0b017d);
        spek_head_HDMI = (LinearLayout)layoutinflater.findViewById(0x7f0b018c);
        spek_head_TV = (LinearLayout)layoutinflater.findViewById(0x7f0b018f);
        spek_head_Infrared = (LinearLayout)layoutinflater.findViewById(0x7f0b0192);
        spek_head_Musik = (LinearLayout)layoutinflater.findViewById(0x7f0b0195);
        spek_head_Radio = (LinearLayout)layoutinflater.findViewById(0x7f0b0198);
        spek_head_TVAnalog = (LinearLayout)layoutinflater.findViewById(0x7f0b019b);
        spek_head_NFC = (LinearLayout)layoutinflater.findViewById(0x7f0b0189);
        spek_head_GPS = (LinearLayout)layoutinflater.findViewById(0x7f0b019e);
        spek_head_Browser = (LinearLayout)layoutinflater.findViewById(0x7f0b01a1);
        spek_head_Pesan = (LinearLayout)layoutinflater.findViewById(0x7f0b01a4);
        spek_head_Lain2Fit = (LinearLayout)layoutinflater.findViewById(0x7f0b01a7);
        spek_head_BateraiJenis = (LinearLayout)layoutinflater.findViewById(0x7f0b01aa);
        spek_head_BateraiWakBic = (LinearLayout)layoutinflater.findViewById(0x7f0b01ad);
        spek_head_BateraiSiaga = (LinearLayout)layoutinflater.findViewById(0x7f0b01b0);
        spek_head_BateraiIsiBox = (LinearLayout)layoutinflater.findViewById(0x7f0b01b3);
        spek_head_HargaBaru = (LinearLayout)layoutinflater.findViewById(0x7f0b01b6);
        spek_head_HargaBekas = (LinearLayout)layoutinflater.findViewById(0x7f0b01b9);
        spek_head_Garansi = (LinearLayout)layoutinflater.findViewById(0x7f0b01bc);
        spek_head_InfoTamb = (LinearLayout)layoutinflater.findViewById(0x7f0b01bf);
        extras = getActivity().getIntent().getExtras();
        DetailsPonsel.dataurlemail = getActivity().getIntent().getData();
        Log.e("DetailsPonsel.dataurlemail", String.valueOf(DetailsPonsel.dataurlemail));
        if (!String.valueOf(DetailsPonsel.dataurlemail).equals("null"))
        {
            scheme = DetailsPonsel.dataurlemail.getScheme();
            host = DetailsPonsel.dataurlemail.getHost();
            viewgroup = DetailsPonsel.dataurlemail.getPathSegments();
            details = (String)viewgroup.get(0);
            id_hp = (String)viewgroup.get(1);
            notif = "email";
        } else
        {
            namalengkap = extras.getString("namalengkap");
            id_hp = extras.getString("id_hph");
            model = extras.getString("model");
            merk = extras.getString("merk");
            gambar = extras.getString("gambar");
            tot_komen = extras.getString("tot_komen");
            if (extras.getString("notif") == null)
            {
                notif = "000";
            } else
            {
                notif = "gcm";
            }
            codename = extras.getString("codename");
        }
        TEMP_PHOTO_FILE_NAME = (new StringBuilder("inponsel_")).append(namalengkap).append(".png").toString();
        txt_namalengkap.setText(namalengkap);
        namalengkapbgskrg = namalengkap;
        if (userFunction.isUserLoggedIn(getActivity()))
        {
            if (db.checkIfExist(id_hp))
            {
                if (sdk < 16)
                {
                    detail_favorite.setBackgroundDrawable(drwKurang);
                } else
                {
                    detail_favorite.setBackground(drwKurang);
                }
            } else
            if (sdk < 16)
            {
                detail_favorite.setBackgroundDrawable(drw);
            } else
            {
                detail_favorite.setBackground(drw);
            }
        } else
        if (sdk < 16)
        {
            detail_favorite.setBackgroundDrawable(drw);
        } else
        {
            detail_favorite.setBackground(drw);
        }
        if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected())
        {
            dataSpek = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("detail_spec").append(Utility.BASE_FORMAT).append("?id=").append(id_hp).append("&t=").append(t).append("&idusr=").append(user_id).toString();
            Log.e("urlSpec", dataSpek);
            midProgressBar.setVisibility(0);
            txt_empty.setText("Memuat");
            SpekLengkapTask();
            try
            {
                viewgroup = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("my_vote_hp").append(Utility.BASE_FORMAT).append("?idhp=").append(id_hp).append("&email=").append(username).append("&t=").append(t).toString();
                Log.e("getnilai", viewgroup);
                (new GetMyNilai()).execute(new String[] {
                    viewgroup
                });
            }
            // Misplaced declaration of an exception variable
            catch (ViewGroup viewgroup)
            {
                viewgroup.printStackTrace();
            }
        } else
        {
            midProgressBar.setVisibility(8);
            layout_empty.setVisibility(0);
            txt_empty.setVisibility(8);
            btnRefresh.setVisibility(0);
        }
        btnSaveSpekImage.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2Spek this$0;

            public void onClick(View view)
            {
                (new SaveSpec()).execute(new Void[0]);
            }

            
            {
                this$0 = Hal2Spek.this;
                super();
            }
        });
        getActivity().invalidateOptionsMenu();
        return layoutinflater;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return true;

        case 16908332: 
            getActivity().finish();
            getActivity().overridePendingTransition(0x7f040001, 0x7f040002);
            return true;

        case 2131429682: 
            menuitem = new Intent(getActivity(), com/inponsel/android/pencariangen/TabPencarian);
            getActivity().startActivityForResult(menuitem, 0);
            getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            return true;

        case 2131429683: 
            Log.e("str_urlspekshare", str_urlspekshare);
            break;
        }
        Log.e("str_share_desc", str_share_desc);
        share_to_socmed();
        return true;
    }

    public void update(Observable observable, Object obj)
    {
        if (ponselBaseApp.getObserver().getUpdateType().contains("likedisPonsel") && ponselBaseApp.getObserver().getIndexHp().equals(codename))
        {
            detail_text_like.setText(ponselBaseApp.getObserver().getTot_LikePon().toString());
            detail_text_dislike.setText(ponselBaseApp.getObserver().getTotdis_LikePon().toString());
            if (ponselBaseApp.getObserver().getStatus_like_ponsel().equals("1"))
            {
                detail_like.setBackgroundResource(0x7f02025b);
                detail_dislike.setBackgroundResource(0x7f0201a3);
                detail_lay_like.setEnabled(false);
                detail_lay_dislike.setEnabled(true);
            } else
            if (ponselBaseApp.getObserver().getStatus_like_ponsel().equals("0"))
            {
                detail_like.setBackgroundResource(0x7f020257);
                detail_dislike.setBackgroundResource(0x7f0201a7);
                detail_lay_like.setEnabled(true);
                detail_lay_dislike.setEnabled(false);
            }
        }
        if (ponselBaseApp.getObserver().getLoginStat().equals("1") && userFunction.isUserLoggedIn(getActivity()))
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
