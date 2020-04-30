// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import com.andraskindler.quickscroll.Scrollable;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.details.ProfilPTActivity;
import com.inponsel.android.details.TwitterInPonsel;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            MerekActivity, RegisterActivity, LoginActivity, DaftarPonselMerkActivity, 
//            RSSFeedByTag, SCMerkActivity

public class t extends BaseAdapter
    implements Scrollable
{
    public class FavHPTask extends AsyncTask
    {

        final MerekActivity.ListPendatangAdapter this$1;

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
                query = (new StringBuilder("idhp=")).append(id_brand).append("&idusr=").append(user_id).append("&stat=").append(statFavNews).append("&t=").append(t).toString();
                pushURL = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("add_fav_brand").append(Utility.BASE_FORMAT).append("?").append(query).toString();
                Log.e("pushURL", pushURL);
                avoid = HttpPush.getResponse(pushURL);
                Log.e("push", (new StringBuilder(String.valueOf(avoid))).append(query).toString());
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
            Log.e("postStatusSubsNews", postStatusSubsNews);
            Log.e("statFavNews", statFavNews);
            if (postStatusSubsNews.equals("1") || postStatusSubsNews.equals("10"))
            {
                Toast.makeText(activity, postMessageSubsNews, 1).show();
                updateViewFavBrand(brandFav, statFavNews);
                mDialog.dismiss();
                ponselBaseApp.getObserver().setUpdateType("sidemenufav");
                ponselBaseApp.getObserver().setLoginStat("1");
                return;
            }
            if (postStatusSubsNews.equals("00") || postStatusSubsNews.equals("0"))
            {
                Toast.makeText(activity, postMessageSubsNews, 1).show();
                mDialog.dismiss();
                return;
            }
            if (postStatusSubsNews.equals("40404"))
            {
                mDialog.dismiss();
                return;
            } else
            {
                Toast.makeText(activity, postMessageSubsNews, 1).show();
                holder.imgFavoritBrand.setBackgroundResource(0x7f020240);
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            if (statFavNews.equals("1"))
            {
                mDialog = ProgressDialog.show(activity, "", "Menambahkan...", true);
            } else
            {
                mDialog = ProgressDialog.show(activity, "", "Menghapus...", true);
            }
            mDialog.setCancelable(true);
            mDialog.show();
        }

        public FavHPTask()
        {
            this$1 = MerekActivity.ListPendatangAdapter.this;
            super();
        }
    }

    public class SubsNewsTask extends AsyncTask
    {

        final MerekActivity.ListPendatangAdapter this$1;

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
                query = (new StringBuilder("idhp=")).append(id_brand).append("&idusr=").append(user_id).append("&stat=").append(statSubNews).append("&t=").append(t).toString();
                pushURL = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("add_subscribe_brand").append(Utility.BASE_FORMAT).append("?").append(query).toString();
                Log.e("pushURL", pushURL);
                avoid = HttpPush.getResponse(pushURL);
                Log.e("push", (new StringBuilder(String.valueOf(avoid))).append(query).toString());
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
            Log.e("postStatusSubsNews", postStatusSubsNews);
            Log.e("statSubNews", statSubNews);
            if (postStatusSubsNews.equals("1") || postStatusSubsNews.equals("10"))
            {
                Toast.makeText(activity, postMessageSubsNews, 1).show();
                updateViewSubsBrand(brandSubNews, statSubNews);
                mDialog.dismiss();
                ponselBaseApp.getObserver().setUpdateType("sidemenufav");
                ponselBaseApp.getObserver().setLoginStat("1"