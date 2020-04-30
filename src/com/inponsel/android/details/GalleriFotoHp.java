// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;
import com.google.android.gms.analytics.Tracker;
import com.google.gson.Gson;
import com.inponsel.android.adapter.GalleryAdapter;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Response;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.v2.ImagePagerActivity;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class GalleriFotoHp extends SherlockFragmentActivity
{
    private class GalleryTask extends AsyncTask
    {

        Response response;
        final GalleriFotoHp this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            avoid = new HttpGet(dataGallery);
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
            Log.e(getClass().getSimpleName(), (new StringBuilder("Error ")).append(i).append(" for URL ").append(dataGallery).toString());
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
                image = new String[imgArray.size()];
                image = (String[])imgArray.toArray(image);
                return;
            }
            ListModel listmodel;
label0:
            {
                listmodel = (ListModel)void1.next();
                imgUrl = (new StringBuilder(String.valueOf(Util.BASE_PATH_FULL))).append(listmodel.getGaleriUrl()).toString();
                imgUrlFull = (new StringBuilder(String.valueOf(Util.BASE_PATH_FULL))).append(listmodel.getGaleriUrlFull()).toString();
                if (!listmodel.getGaleriUrl().equals("-"))
                {
                    break label0;
                }
                txtEmpty.setText("Galeri belum tersedia");
                midProgressBar.setVisibility(8);
                gridGallery.setVisibility(8);
            }
              goto _L1
            try
            {
                imgArray.add(imgUrlFull);
                gridArray.add(listmodel);
                layout_empty.setVisibility(8);
                gridGallery.setVisibility(0);
                galleryAdapter.notifyDataSetChanged();
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                btnRefresh.setVisibility(0);
                midProgressBar.setVisibility(8);
                return;
            }
              goto _L1
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
        }

        private GalleryTask()
        {
            this$0 = GalleriFotoHp.this;
            super();
        }

        GalleryTask(GalleryTask gallerytask)
        {
            this();
        }
    }


    private String TAG;
    ActionBar actionBar;
    int actionBarTitleId;
    Button btnRefresh;
    ConnectivityManager cm;
    String codename;
    String dataGallery;
    String details;
    String email_komentar;
    Bundle extras;
    GalleryAdapter galleryAdapter;
    String gambar;
    String getJson;
    ArrayList gridArray;
    GridView gridGallery;
    String hasil;
    String host;
    String id_hp;
    String id_kom;
    String image[];
    ArrayList imgArray;
    String imgUrl;
    String imgUrlFull;
    String isikomentar;
    LinearLayout layout_empty;
    String merk;
    ProgressBar midProgressBar;
    String model;
    String namalengkap;
    String namalengkapbgskrg;
    String notif;
    String scheme;
    String t;
    String tanggal;
    String tot_komen;
    TextView txtEmpty;
    private boolean useLogo;
    String userkomen;
    String userpict;

    public GalleriFotoHp()
    {
        TAG = getClass().getSimpleName();
        gridArray = null;
        imgArray = null;
        getJson = "";
        scheme = "";
        host = "";
        details = "";
        notif = "000";
        t = Utility.session(RestClient.pelihara);
        useLogo = false;
        actionBarTitleId = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        tot_komen = "";
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

    public void GalleryTask()
    {
        GalleryTask gallerytask = new GalleryTask(null);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            gallerytask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            gallerytask.execute(new Void[0]);
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03009e);
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            setTranslucentStatus(true);
        }
        bundle = new SystemBarTintManager(this);
        bundle.setStatusBarTintEnabled(true);
        bundle.setStatusBarTintResource(0x7f080160);
        extras = getIntent().getExtras();
        id_hp = extras.getString("id_hph");
        model = extras.getString("model");
        merk = extras.getString("merk");
        gambar = extras.getString("gambar");
        codename = extras.getString("codename");
        namalengkap = (new StringBuilder(String.valueOf(merk))).append(" ").append(model).toString();
        int i;
        int j;
        try
        {
            bundle = ((PonselBaseApp)getApplication()).getTracker(com.inponsel.android.adapter.PonselBaseApp.TrackerName.APP_TRACKER);
            bundle.setScreenName((new StringBuilder("Galeri Foto ")).append(URLDecoder.decode(namalengkap)).toString());
            bundle.send((new com.google.android.gms.analytics.HitBuilders.AppViewBuilder()).build());
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        actionBar = getSupportActionBar();
        actionBar.setDisplayUseLogoEnabled(useLogo);
        actionBar.setBackgroundDrawable(getResources().getDrawable(0x7f0200e5));
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        j = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        i = j;
        if (j == 0)
        {
            i = 0x7f0b0037;
        }
        getSupportActionBar().setTitle(Html.fromHtml((new StringBuilder("<font color='#FFFFFF'>")).append(URLDecoder.decode(namalengkap)).append("</font>").toString()));
        bundle = (TextView)findViewById(i);
        bundle.setSelected(true);
        bundle.setTextColor(Color.parseColor("#FFFFFF"));
        bundle.setText(URLDecoder.decode(namalengkap));
        bundle.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        cm = (ConnectivityManager)getSystemService("connectivity");
        if (extras.getString("notif") == null)
        {
            notif = "000";
        } else
        {
            notif = "gcm";
        }
        t = Utility.session(t);
        midProgressBar = (ProgressBar)findViewById(0x7f0b00ca);
        txtEmpty = (TextView)findViewById(0x7f0b0093);
        layout_empty = (LinearLayout)findViewById(0x7f0b0091);
        btnRefresh = (Button)findViewById(0x7f0b04d0);
        gridGallery = (GridView)findViewById(0x7f0b053b);
        gridArray = new ArrayList();
        imgArray = new ArrayList();
        galleryAdapter = new GalleryAdapter(this, 0x7f030035, gridArray);
        gridGallery.setAdapter(galleryAdapter);
        t = Utility.session(t);
        if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected())
        {
            dataGallery = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("gallery_hp").append(Utility.BASE_FORMAT).append("?id_hp=").append(id_hp).append("&t=").append(t).toString();
            Log.e("dataGallery", dataGallery);
            midProgressBar.setVisibility(0);
            GalleryTask();
        } else
        {
            midProgressBar.setVisibility(8);
            btnRefresh.setVisibility(0);
        }
        gridGallery.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final GalleriFotoHp this$0;

            public void onItemClick(AdapterView adapterview, View view, int k, long l)
            {
                adapterview = new Intent(GalleriFotoHp.this, com/inponsel/android/v2/ImagePagerActivity);
                adapterview.putExtra("imgUrl", image);
                adapterview.putExtra("pos", k);
                startActivity(adapterview);
            }

            
            {
                this$0 = GalleriFotoHp.this;
                super();
            }
        });
        btnRefresh.setOnClickListener(new android.view.View.OnClickListener() {

            final GalleriFotoHp this$0;

            public void onClick(View view)
            {
                dataGallery = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("gallery_hp").append(Utility.BASE_FORMAT).append("?id_hp=").append(id_hp).append("&t=").append(t).toString();
                Log.e("dataGallery", dataGallery);
                midProgressBar.setVisibility(0);
                GalleryTask();
            }

            
            {
                this$0 = GalleriFotoHp.this;
                super();
            }
        });
    }

    public boolean onMenuItemSelected(int i, MenuItem menuitem)
    {
        menuitem.getItemId();
        JVM INSTR tableswitch 16908332 16908332: default 24
    //                   16908332 26;
           goto _L1 _L2
_L1:
        return true;
_L2:
        finish();
        overridePendingTransition(0x7f040001, 0x7f040002);
        if (true) goto _L1; else goto _L3
_L3:
    }
}
