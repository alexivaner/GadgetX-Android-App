// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.google.android.gms.analytics.Tracker;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.adapter.TrafficModel;
import com.inponsel.android.adapter.TwitterAdapter;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.ServiceHandler;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TwitterVendor extends SherlockFragmentActivity
{
    private class TwitterTask extends AsyncTask
    {

        final TwitterVendor this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            {
                avoid = (new ServiceHandler()).makeServiceCall(dataSearch, 1);
                Log.e("Responseharga: ", (new StringBuilder("> ")).append(avoid).toString());
                if (avoid == null)
                {
                    break MISSING_BLOCK_LABEL_200;
                }
                TrafficModel trafficmodel;
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
                    break MISSING_BLOCK_LABEL_207;
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_207;
                }
                i = 0;
            }
            if (i >= inponsel.length())
            {
                break MISSING_BLOCK_LABEL_207;
            }
            avoid = inponsel.getJSONObject(i);
            trafficmodel = new TrafficModel();
            trafficmodel.setScreen_name(avoid.getString("screen_name"));
            trafficmodel.setTweet_content(avoid.getString("tweet_content"));
            trafficmodel.setAvatar(avoid.getString("avatar"));
            trafficmodel.setMedia_url(avoid.getString("media_url"));
            trafficmodel.setTweet_time(avoid.getString("tweet_time"));
            trafficmodel.setSince_id(avoid.getString("since_id"));
            listArray.add(trafficmodel);
            i++;
            if (true)
            {
                break MISSING_BLOCK_LABEL_68;
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
            try
            {
                progressbar_middle.setVisibility(8);
                listAdapter.notifyDataSetChanged();
                Log.e("tasksdsurlSearch", dataSearch);
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

        private TwitterTask()
        {
            this$0 = TwitterVendor.this;
            super();
        }

        TwitterTask(TwitterTask twittertask)
        {
            this();
        }
    }


    ActionBar actionBar;
    int actionBarTitleId;
    String dataSearch;
    Bundle extras;
    String getJson;
    JSONArray inponsel;
    LinearLayout layout_empty;
    LinearLayout layprogBarlist;
    TwitterAdapter listAdapter;
    ArrayList listArray;
    ListView listTMC;
    TextView loadingText;
    ProgressBar progressbar_middle;
    String t;
    String twitter;
    TextView txtEmpty;
    private boolean useLogo;
    ContextThemeWrapper wrapper;

    public TwitterVendor()
    {
        listArray = null;
        inponsel = null;
        dataSearch = "";
        twitter = "";
        t = Utility.session(RestClient.pelihara);
        useLogo = false;
        actionBarTitleId = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        getJson = "";
    }

    private void goBack()
    {
        finish();
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

    public void SearchTask()
    {
        dataSearch = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("vendor_twitter").append(Utility.BASE_FORMAT).append("?uname=").append(twitter).append("&lmt=0&t=").append(t).toString();
        Log.e("dataTweet", dataSearch);
        TwitterTask twittertask = new TwitterTask(null);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            twittertask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            twittertask.execute(new Void[0]);
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030128);
        extras = getIntent().getExtras();
        twitter = extras.getString("twitter");
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            setTranslucentStatus(true);
        }
        bundle = new SystemBarTintManager(this);
        bundle.setStatusBarTintEnabled(true);
        bundle.setStatusBarTintResource(0x7f080160);
        int i;
        int j;
        try
        {
            bundle = ((PonselBaseApp)getApplication()).getTracker(com.inponsel.android.adapter.PonselBaseApp.TrackerName.APP_TRACKER);
            bundle.setScreenName((new StringBuilder("Twitter ")).append(twitter).toString());
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
        j = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        i = j;
        if (j == 0)
        {
            i = 0x7f0b0037;
        }
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFFFFF'>Twitter</font>"));
        bundle = (TextView)findViewById(i);
        bundle.setSelected(true);
        bundle.setTextColor(Color.parseColor("#FFFFFF"));
        bundle.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        wrapper = new ContextThemeWrapper(this, 0x103006e);
        listTMC = (ListView)findViewById(0x7f0b085a);
        listArray = new ArrayList();
        listAdapter = new TwitterAdapter(this, 0x7f030072, listArray);
        t = Utility.session(t);
        progressbar_middle = (ProgressBar)findViewById(0x7f0b00ca);
        txtEmpty = (TextView)findViewById(0x7f0b0093);
        txtEmpty.setText("Memuat...");
        layout_empty = (LinearLayout)findViewById(0x7f0b0091);
        layprogBarlist = (LinearLayout)findViewById(0x7f0b085b);
        listTMC.setEmptyView(txtEmpty);
        listTMC.setAdapter(listAdapter);
        t = Utility.session(t);
        listTMC.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final TwitterVendor this$0;

            public void onItemClick(AdapterView adapterview, View view, int k, long l)
            {
                adapterview = new android.app.AlertDialog.Builder(wrapper);
                adapterview.setMessage("Ingin mengunjungi twitter TMCPoldaMetro?");
                adapterview.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                    final _cls1 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                });
                adapterview.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                    final _cls1 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface.dismiss();
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                });
            }

            
            {
                this$0 = TwitterVendor.this;
                super();
            }
        });
        try
        {
            SearchTask();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            return;
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyevent)
    {
        if (i == 4)
        {
            goBack();
            return true;
        } else
        {
            return super.onKeyUp(i, keyevent);
        }
    }
}
