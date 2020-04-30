// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.Dialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.os.StrictMode;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.google.android.gms.analytics.Tracker;
import com.inponsel.android.BaseImageActivity;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.Log;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import it.sephiroth.android.library.imagezoom.ImageViewTouch;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class ImageFullActivity extends BaseImageActivity
{
    class DownloadFileFromURL extends AsyncTask
    {

        final ImageFullActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient String doInBackground(String as[])
        {
            int i;
            as = new URL(as[0]);
            URLConnection urlconnection = as.openConnection();
            urlconnection.connect();
            i = urlconnection.getContentLength();
            if (!Environment.getExternalStorageState().equals("mounted")) goto _L2; else goto _L1
_L1:
            cacheDir = new File(Environment.getExternalStorageDirectory(), "InPonsel Message");
_L6:
            FileOutputStream fileoutputstream;
            byte abyte0[];
            if (!cacheDir.exists())
            {
                cacheDir.mkdirs();
            }
            as = new BufferedInputStream(as.openStream(), 8192);
            fileoutputstream = new FileOutputStream((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/InPonsel Message/").append(fileName).toString());
            abyte0 = new byte[1024];
            long l = 0L;
_L4:
            int j;
            j = as.read(abyte0);
            break MISSING_BLOCK_LABEL_150;
_L2:
            cacheDir = getCacheDir();
            continue; /* Loop/switch isn't completed */
            if (j == -1)
            {
                try
                {
                    fileoutputstream.flush();
                    fileoutputstream.close();
                    as.close();
                }
                // Misplaced declaration of an exception variable
                catch (String as[])
                {
                    Log.e("Error: ", as.getMessage());
                }
                break; /* Loop/switch isn't completed */
            }
            l += j;
            publishProgress(new String[] {
                (new StringBuilder()).append((int)((100L * l) / (long)i)).toString()
            });
            fileoutputstream.write(abyte0, 0, j);
            if (true) goto _L4; else goto _L3
_L3:
            return null;
            if (true) goto _L6; else goto _L5
_L5:
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((String)obj);
        }

        protected void onPostExecute(String s)
        {
            s = new Intent();
            s.setAction("android.intent.action.VIEW");
            s.setDataAndType(Uri.parse((new StringBuilder("file://")).append(Environment.getExternalStorageDirectory().toString()).append("/InPonsel Message/").append(fileName).toString()), "image/*");
            s = PendingIntent.getActivity(ImageFullActivity.this, 0, s, 0x10000000);
            mBuilder.setContentTitle("InPonsel").setContentText("Download complete").setProgress(0, 0, false).setSmallIcon(0x7f02023f).setContentIntent(s).setAutoCancel(true).setLargeIcon(ImageFullActivity.getBitmapFromURL(imageUrls[pagerPosition], getApplicationContext()));
            mNotifyManager.notify(id, mBuilder.build());
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            mBuilder.setProgress(100, 0, false);
            mNotifyManager.notify(id, mBuilder.build());
        }

        protected volatile transient void onProgressUpdate(Object aobj[])
        {
            onProgressUpdate((String[])aobj);
        }

        protected transient void onProgressUpdate(String as[])
        {
            mBuilder.setProgress(100, Integer.parseInt(as[0]), false);
            mNotifyManager.notify(id, mBuilder.build());
            super.onProgressUpdate(as);
        }

        DownloadFileFromURL()
        {
            this$0 = ImageFullActivity.this;
            super();
        }
    }

    private class ImagePagerAdapter extends PagerAdapter
    {

        private String images[];
        private LayoutInflater inflater;
        final ImageFullActivity this$0;

        public void destroyItem(View view, int i, Object obj)
        {
            ((ViewPager)view).removeView((View)obj);
        }

        public void finishUpdate(View view)
        {
        }

        public int getCount()
        {
            return images.length;
        }

        public Object instantiateItem(View view, int i)
        {
            View view1 = inflater.inflate(0x7f030058, null);
            ImageViewTouch imageviewtouch = (ImageViewTouch)view1.findViewById(0x7f0b007f);
            final ProgressBar spinner = (ProgressBar)view1.findViewById(0x7f0b02a5);
            imageviewtouch.setDisplayType(it.sephiroth.android.library.imagezoom.ImageViewTouchBase.DisplayType.FIT_TO_SCREEN);
            imageLoader.displayImage(images[i], imageviewtouch, options, imageviewtouch. new ImageLoadingListener() {

                final ImagePagerAdapter this$1;
                private final ImageViewTouch val$imageView;
                private final ProgressBar val$spinner;

                public void onLoadingCancelled(String s, View view)
                {
                }

                public void onLoadingComplete(String s, View view, Bitmap bitmap)
                {
                    spinner.setVisibility(8);
                    s = AnimationUtils.loadAnimation(_fld0, 0x7f040009);
                    imageView.setAnimation(s);
                    s.start();
                }

                public void onLoadingFailed(String s, View view, FailReason failreason)
                {
                    Toast.makeText(_fld0, "Gagal memuat gambar", 0).show();
                    spinner.setVisibility(8);
                    imageView.setImageResource(0x108001d);
                }

                public void onLoadingStarted(String s, View view)
                {
                    spinner.setVisibility(0);
                }

            
            {
                this$1 = final_imagepageradapter;
                spinner = progressbar;
                imageView = ImageViewTouch.this;
                super();
            }
            });
            ((ViewPager)view).addView(view1, 0);
            return view1;
        }

        public boolean isViewFromObject(View view, Object obj)
        {
            return view.equals(obj);
        }

        public void restoreState(Parcelable parcelable, ClassLoader classloader)
        {
        }

        public Parcelable saveState()
        {
            return null;
        }

        public void startUpdate(View view)
        {
        }


        ImagePagerAdapter(String as[])
        {
            this$0 = ImageFullActivity.this;
            super();
            images = as;
            inflater = getLayoutInflater();
        }
    }


    public static final int progress_bar_type = 0;
    Button btnDownloadPicture;
    private File cacheDir;
    String fileName;
    int fileSize;
    int id;
    ImageLoader imageLoader;
    String imageUrls[];
    int lastSlash;
    private android.support.v4.app.NotificationCompat.Builder mBuilder;
    private NotificationManager mNotifyManager;
    private DisplayImageOptions options;
    private ProgressDialog pDialog;
    private ViewPager pager;
    int pagerPosition;

    public ImageFullActivity()
    {
        id = 1;
    }

    public static Bitmap getBitmapFromURL(String s, Context context)
    {
        try
        {
            s = (HttpURLConnection)(new URL(s)).openConnection();
            s.setDoInput(true);
            s.connect();
            s = BitmapFactory.decodeStream(s.getInputStream());
            context = context.getResources();
            int i = (int)context.getDimension(0x1050006);
            s = Bitmap.createScaledBitmap(s, (int)context.getDimension(0x1050005), i, false);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    public void onBackPressed()
    {
        Log.e("vis", "off");
        finish();
        overridePendingTransition(0x7f040001, 0x7f040002);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.setThreadPolicy((new android.os.StrictMode.ThreadPolicy.Builder()).permitAll().build());
        }
        setContentView(0x7f030016);
        try
        {
            bundle = ((PonselBaseApp)getApplication()).getTracker(com.inponsel.android.adapter.PonselBaseApp.TrackerName.APP_TRACKER);
            bundle.setScreenName("Gallery Ponsel Zoom");
            bundle.send((new com.google.android.gms.analytics.HitBuilders.AppViewBuilder()).build());
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        bundle = getIntent().getExtras();
        imageUrls = bundle.getStringArray("imgUrl");
        pagerPosition = bundle.getInt("pos", 0);
        Log.e("img", imageUrls[pagerPosition]);
        imageLoader = ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(this));
        options = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showImageForEmptyUri(0x7f020208).cacheInMemory(true).imageScaleType(ImageScaleType.EXACTLY).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).build();
        pager = (ViewPager)findViewById(0x7f0b0059);
        pager.setAdapter(new ImagePagerAdapter(imageUrls));
        pager.setCurrentItem(pagerPosition);
        pager.setOffscreenPageLimit(3);
        btnDownloadPicture = (Button)findViewById(0x7f0b005a);
        btnDownloadPicture.setVisibility(0);
        btnDownloadPicture.setOnClickListener(new android.view.View.OnClickListener() {

            final ImageFullActivity this$0;

            public void onClick(View view)
            {
                lastSlash = imageUrls[pagerPosition].toString().lastIndexOf('/');
                lastSlash = imageUrls[pagerPosition].toString().lastIndexOf('_');
                fileName = "file.bin";
                if (lastSlash >= 0)
                {
                    fileName = imageUrls[pagerPosition].toString().substring(lastSlash + 1);
                }
                if (fileName.equals(""))
                {
                    fileName = "file.bin";
                }
                mNotifyManager = (NotificationManager)getSystemService("notification");
                mBuilder = new android.support.v4.app.NotificationCompat.Builder(ImageFullActivity.this);
                mBuilder.setContentTitle("InPonsel").setContentText("Download image in progress").setSmallIcon(0x7f02023f).setLargeIcon(ImageFullActivity.getBitmapFromURL(imageUrls[pagerPosition], getApplicationContext()));
                (new DownloadFileFromURL()).execute(new String[] {
                    imageUrls[pagerPosition]
                });
            }

            
            {
                this$0 = ImageFullActivity.this;
                super();
            }
        });
    }

    protected Dialog onCreateDialog(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 0: // '\0'
            pDialog = new ProgressDialog(this);
            break;
        }
        pDialog.setMessage("Downloading file. Please wait...");
        pDialog.setIndeterminate(false);
        pDialog.setMax(100);
        pDialog.setProgressStyle(1);
        pDialog.setCancelable(true);
        pDialog.show();
        return pDialog;
    }







}
