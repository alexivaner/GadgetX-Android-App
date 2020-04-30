// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.actionbarsherlock.app.SherlockFragment;
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
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

// Referenced classes of package com.inponsel.android.details:
//            DetailsPonsel

public class Hal4Galleri extends SherlockFragment
{
    private class GalleryTask extends AsyncTask
    {

        Response response;
        final Hal4Galleri this$0;

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
            this$0 = Hal4Galleri.this;
            super();
        }

        GalleryTask(GalleryTask gallerytask)
        {
            this();
        }
    }


    Button btnRefresh;
    ConnectivityManager cm;
    String codename;
    String dataGallery;
    String details;
    Bundle extras;
    GalleryAdapter galleryAdapter;
    String getJson;
    ArrayList gridArray;
    GridView gridGallery;
    String hasil;
    String host;
    String id_hp;
    String image[];
    ArrayList imgArray;
    String imgUrl;
    String imgUrlFull;
    LinearLayout layout_empty;
    ProgressBar midProgressBar;
    String notif;
    String scheme;
    String t;
    TextView txtEmpty;

    public Hal4Galleri()
    {
        gridArray = null;
        imgArray = null;
        getJson = "";
        scheme = "";
        host = "";
        details = "";
        notif = "000";
        t = Utility.session(RestClient.pelihara);
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

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        setRetainInstance(true);
        setHasOptionsMenu(true);
        try
        {
            viewgroup = ((PonselBaseApp)getActivity().getApplication()).getTracker(com.inponsel.android.adapter.PonselBaseApp.TrackerName.APP_TRACKER);
            viewgroup.setScreenName("Hal4Galeri");
            viewgroup.send((new com.google.android.gms.analytics.HitBuilders.AppViewBuilder()).build());
        }
        // Misplaced declaration of an exception variable
        catch (ViewGroup viewgroup)
        {
            viewgroup.printStackTrace();
        }
        layoutinflater = (ViewGroup)layoutinflater.inflate(0x7f03009e, null);
        cm = (ConnectivityManager)getActivity().getSystemService("connectivity");
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
            Log.e("scheme", scheme);
            Log.e("host", host);
            Log.e("id_hph", id_hp);
        } else
        {
            id_hp = extras.getString("id_hph");
            if (extras.getString("notif") == null)
            {
                notif = "000";
            } else
            {
                notif = "gcm";
            }
            codename = extras.getString("codename");
        }
        t = Utility.session(t);
        midProgressBar = (ProgressBar)layoutinflater.findViewById(0x7f0b00ca);
        txtEmpty = (TextView)layoutinflater.findViewById(0x7f0b0093);
        layout_empty = (LinearLayout)layoutinflater.findViewById(0x7f0b0091);
        btnRefresh = (Button)layoutinflater.findViewById(0x7f0b04d0);
        gridGallery = (GridView)layoutinflater.findViewById(0x7f0b053b);
        gridArray = new ArrayList();
        imgArray = new ArrayList();
        galleryAdapter = new GalleryAdapter(getActivity(), 0x7f030035, gridArray);
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

            final Hal4Galleri this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = new Intent(getActivity(), com/inponsel/android/v2/ImagePagerActivity);
                adapterview.putExtra("imgUrl", image);
                adapterview.putExtra("pos", i);
                startActivity(adapterview);
            }

            
            {
                this$0 = Hal4Galleri.this;
                super();
            }
        });
        btnRefresh.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal4Galleri this$0;

            public void onClick(View view)
            {
                dataGallery = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("gallery_hp").append(Utility.BASE_FORMAT).append("?id_hp=").append(id_hp).append("&t=").append(t).toString();
                Log.e("dataGallery", dataGallery);
                midProgressBar.setVisibility(0);
                GalleryTask();
            }

            
            {
                this$0 = Hal4Galleri.this;
                super();
            }
        });
        return layoutinflater;
    }
}
