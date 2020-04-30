// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.favorit;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;
import com.google.gson.Gson;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.DelayedTextWatcher;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Response;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.ServiceHandler;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.v2.RSSFeedByTag;
import com.inponsel.android.widget.ExpandableHeightGridView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.readystatesoftware.systembartint.SystemBarTintManager;
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

public class LanggananBeritaAll extends SherlockFragmentActivity
    implements Observer
{
    public class DelLanggananTask extends AsyncTask
    {

        final LanggananBeritaAll this$0;

        private void parseJSONLangganan(String s)
        {
            try
            {
                s = new JSONObject(s);
                postStatusLikeKom = s.getString("success");
                postMessageLikeKom = s.getString("message");
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
                querydel = (new StringBuilder("idhp=")).append(id_hp_del).append("&idusr=").append(user_id).append("&stat=").append("0").append("&type=").append(type).append("&t=").append(t).toString();
                pushURLdel = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("add_subscribe_news").append(Utility.BASE_FORMAT).append("?").append(querydel).toString();
                Log.e("pushURL", pushURLdel);
                avoid = HttpPush.getResponse(pushURLdel);
                Log.e("push", (new StringBuilder(String.valueOf(avoid))).append(querydel).toString());
                resdel = avoid.toString();
                Log.e("url ", resdel);
                parseJSONLangganan(resdel);
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
            if (!postStatusLikeKom.equals("1") && !postStatusLikeKom.equals("10"))
            {
                break MISSING_BLOCK_LABEL_96;
            }
            Toast.makeText(LanggananBeritaAll.this, postMessageLikeKom, 0).show();
            if (!type.equals("hp"))
            {
                break MISSING_BLOCK_LABEL_86;
            }
            LanggananTask();
_L1:
            mDialog.dismiss();
            return;
            try
            {
                LanggananMerekTask();
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
              goto _L1
            if (postStatusLikeKom.equals("00") || postStatusLikeKom.equals("0"))
            {
                Toast.makeText(LanggananBeritaAll.this, postMessageLikeKom, 0).show();
                mDialog.dismiss();
                return;
            }
            if (postStatusLikeKom.equals("40404"))
            {
                mDialog.dismiss();
                return;
            }
            Toast.makeText(LanggananBeritaAll.this, postMessageLikeKom, 0).show();
            return;
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            statusdel = "";
            if (statdel.equals("1"))
            {
                mDialog = ProgressDialog.show(LanggananBeritaAll.this, "", "Menambahkan...", true);
            } else
            {
                mDialog = ProgressDialog.show(LanggananBeritaAll.this, "", "Menghapus...", true);
            }
            mDialog.setCancelable(true);
            mDialog.show();
        }

        public DelLanggananTask()
        {
            this$0 = LanggananBeritaAll.this;
            super();
        }
    }

    private class FavoritSearchTask extends AsyncTask
    {

        final LanggananBeritaAll this$0;

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
                    break MISSING_BLOCK_LABEL_264;
                }
                ListModel listmodel;
                int i;
                try
                {
                    avoid = new JSONObject(avoid);
                    inponsel = avoid.getJSONArray("InPonsel");
                    suc = avoid.getString("success");
                    stat = avoid.getString("stat");
                    counterArray = 0;
                    if (!suc.equals("1"))
                    {
                        break MISSING_BLOCK_LABEL_271;
                    }
                    listSearchArrayList.clear();
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_271;
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_271;
                }
                i = 0;
            }
            if (i >= inponsel.length())
            {
                break MISSING_BLOCK_LABEL_271;
            }
            avoid = LanggananBeritaAll.this;
            avoid.counterArray = ((LanggananBeritaAll) (avoid)).counterArray + 1;
            avoid = inponsel.getJSONObject(i);
            listmodel = new ListModel();
            listmodel.setUni_id(avoid.getString("id"));
            listmodel.setUni_name(avoid.getString("nama"));
            listmodel.setUni_gambar(avoid.getString("gambar"));
            listmodel.setUni_type(avoid.getString("type"));
            listmodel.setUni_stat(avoid.getString("favorit"));
            listSearchArrayList.add(listmodel);
            i++;
            if (true)
            {
                break MISSING_BLOCK_LABEL_127;
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
                progressbar_search.setVisibility(8);
                listSearchAdapter.notifyDataSetChanged();
                listFindDev.setVisibility(0);
                Log.e("counterArray", String.valueOf(listSearchArrayList.size()));
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

        private FavoritSearchTask()
        {
            this$0 = LanggananBeritaAll.this;
            super();
        }

        FavoritSearchTask(FavoritSearchTask favoritsearchtask)
        {
            this();
        }
    }

    private class LanggananKatsusTask extends AsyncTask
    {

        final LanggananBeritaAll this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            {
                avoid = (new ServiceHandler()).makeServiceCall(dataKatsus, 1);
                Log.e("Responseharga: ", (new StringBuilder("> ")).append(avoid).toString());
                if (avoid == null)
                {
                    break MISSING_BLOCK_LABEL_312;
                }
                ListModel listmodel;
                int i;
                try
                {
                    avoid = new JSONObject(avoid);
                    inponselKatsus = avoid.getJSONArray("InPonsel");
                    sucKatsus = avoid.getString("success");
                    statKatsus = avoid.getString("stat");
                    count_first_katsus = avoid.getInt("count_first");
                    count_all_katsus = avoid.getInt("count_all");
                    Log.e("suc", sucKatsus);
                    counterKatsusArray = 0;
                    if (!sucKatsus.equals("1"))
                    {
                        break MISSING_BLOCK_LABEL_319;
                    }
                    langganKatsusArray.clear();
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_319;
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_319;
                }
                i = 0;
            }
            if (i >= inponselKatsus.length())
            {
                break MISSING_BLOCK_LABEL_319;
            }
            avoid = LanggananBeritaAll.this;
            avoid.counterKatsusArray = ((LanggananBeritaAll) (avoid)).counterKatsusArray + 1;
            avoid = inponselKatsus.getJSONObject(i);
            listmodel = new ListModel();
            listmodel.setId_hp(avoid.getString("id_hp"));
            listmodel.setModel("");
            listmodel.setMerk(avoid.getString("merk"));
            listmodel.setCodename("");
            listmodel.setGambar(avoid.getString("gambar"));
            listmodel.setUmu_status("-");
            listmodel.setHrg_baru("");
            listmodel.setHrg_bekas("");
            langganKatsusArray.add(listmodel);
            i++;
            if (true)
            {
                break MISSING_BLOCK_LABEL_165;
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
                Log.e("favHpArraybefore", String.valueOf(langganKatsusArray.size()));
                Log.e("data", dataKatsus);
                Log.e("langganKatsusArray", String.valueOf(langganKatsusArray.size()));
                langganKatsusAdapter.notifyDataSetChanged();
                Log.e("counterKatsusArray", String.valueOf(langganKatsusArray.size()));
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
            langganKatsusArray.clear();
        }

        private LanggananKatsusTask()
        {
            this$0 = LanggananBeritaAll.this;
            super();
        }

        LanggananKatsusTask(LanggananKatsusTask langganankatsustask)
        {
            this();
        }
    }

    private class LanggananMerekTask extends AsyncTask
    {

        Response response;
        final LanggananBeritaAll this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            avoid = new HttpGet(dataMerek);
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
            Log.e(getClass().getSimpleName(), (new StringBuilder("Error ")).append(i).append(" for URL ").append(dataFav).toString());
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
_L3:
            if (void1.hasNext()) goto _L2; else goto _L1
_L1:
            mereknAdapter.notifyDataSetChanged();
            listLanggananMerek.setVisibility(0);
            Log.e("listLangganan", String.valueOf(merekArray.size()));
_L4:
            progressbar_Merek.setVisibility(8);
            return;
_L2:
            ListModel listmodel;
            listmodel = (ListModel)void1.next();
            if (!listmodel.getId_hp().equals("-") || !listmodel.getModel().equals("-"))
            {
                break MISSING_BLOCK_LABEL_157;
            }
            progressbar_Merek.setVisibility(8);
            txt_empty_merek.setText("Belum langganan berita");
            txt_empty_merek.setVisibility(0);
              goto _L3
            void1;
            void1.printStackTrace();
              goto _L4
            txt_empty_merek.setVisibility(8);
            id_hph = listmodel.getId_hp();
            merk = listmodel.getMerk();
            model = listmodel.getModel();
            gambar = listmodel.getGambar();
            type = listmodel.getType();
            merekArray.add(listmodel);
              goto _L3
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            progressbar_Merek.setVisibility(0);
            merekArray.clear();
        }

        private LanggananMerekTask()
        {
            this$0 = LanggananBeritaAll.this;
            super();
        }

        LanggananMerekTask(LanggananMerekTask langgananmerektask)
        {
            this();
        }
    }

    private class LanggananNewsTask extends AsyncTask
    {

        Response response;
        final LanggananBeritaAll this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            avoid = new HttpGet(dataLangganan);
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
            Log.e(getClass().getSimpleName(), (new StringBuilder("Error ")).append(i).append(" for URL ").append(dataFav).toString());
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
            langgananArray.clear();
            void1 = response.InPonsel.iterator();
_L3:
            if (void1.hasNext()) goto _L2; else goto _L1
_L1:
            langgananAdapter.notifyDataSetChanged();
            listLanggananPonsel.setVisibility(0);
            Log.e("listLangganan", String.valueOf(langgananArray.size()));
_L4:
            progressbar_langganan.setVisibility(8);
            return;
_L2:
            ListModel listmodel;
            listmodel = (ListModel)void1.next();
            if (!listmodel.getId_hp().equals("-") || !listmodel.getModel().equals("-"))
            {
                break MISSING_BLOCK_LABEL_167;
            }
            progressbar_langganan.setVisibility(8);
            txt_empty_langganan.setText("Belum langganan berita");
            txt_empty_langganan.setVisibility(0);
              goto _L3
            void1;
            void1.printStackTrace();
              goto _L4
            txt_empty_langganan.setVisibility(8);
            langgananArray.add(listmodel);
              goto _L3
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            progressbar_langganan.setVisibility(0);
        }

        private LanggananNewsTask()
        {
            this$0 = LanggananBeritaAll.this;
            super();
        }

        LanggananNewsTask(LanggananNewsTask langganannewstask)
        {
            this();
        }
    }

    private class LanggananOpTask extends AsyncTask
    {

        final LanggananBeritaAll this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            {
                avoid = (new ServiceHandler()).makeServiceCall(dataBrand, 1);
                Log.e("Responseharga: ", (new StringBuilder("> ")).append(avoid).toString());
                if (avoid == null)
                {
                    break MISSING_BLOCK_LABEL_312;
                }
                ListModel listmodel;
                int i;
                try
                {
                    avoid = new JSONObject(avoid);
                    inponsel = avoid.getJSONArray("InPonsel");
                    suc = avoid.getString("success");
                    stat = avoid.getString("stat");
                    count_first_favbrand = avoid.getInt("count_first");
                    count_all_favbrand = avoid.getInt("count_all");
                    Log.e("suc", suc);
                    counterArray = 0;
                    if (!suc.equals("1"))
                    {
                        break MISSING_BLOCK_LABEL_319;
                    }
                    langgananOpArray.clear();
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_319;
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_319;
                }
                i = 0;
            }
            if (i >= inponsel.length())
            {
                break MISSING_BLOCK_LABEL_319;
            }
            avoid = LanggananBeritaAll.this;
            avoid.counterArray = ((LanggananBeritaAll) (avoid)).counterArray + 1;
            avoid = inponsel.getJSONObject(i);
            listmodel = new ListModel();
            listmodel.setId_hp(avoid.getString("id_hp"));
            listmodel.setModel("");
            listmodel.setMerk(avoid.getString("merk"));
            listmodel.setCodename("");
            listmodel.setGambar(avoid.getString("gambar"));
            listmodel.setUmu_status("-");
            listmodel.setHrg_baru("");
            listmodel.setHrg_bekas("");
            langgananOpArray.add(listmodel);
            i++;
            if (true)
            {
                break MISSING_BLOCK_LABEL_165;
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
                Log.e("favHpArraybefore", String.valueOf(langgananOpArray.size()));
                Log.e("data", dataBrand);
                Log.e("langgananOpArray", String.valueOf(langgananOpArray.size()));
                langgananOpAdapter.notifyDataSetChanged();
                Log.e("counterArray", String.valueOf(langgananOpArray.size()));
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
            langgananOpArray.clear();
        }

        private LanggananOpTask()
        {
            this$0 = LanggananBeritaAll.this;
            super();
        }

        LanggananOpTask(LanggananOpTask langgananoptask)
        {
            this();
        }
    }

    public class ListLanggananAdapter extends BaseAdapter
    {

        private Activity activity;
        Context context;
        Cursor cursor;
        DatabaseHandler db;
        String email_user;
        String finalUrl;
        DecimalFormat fmt;
        DecimalFormatSymbols fmts;
        ImageLoader imageLoader2;
        String komen;
        private ArrayList lm;
        ListModel lms;
        ProgressDialog mDialog;
        private DisplayImageOptions options;
        int pos;
        String res;
        int resource;
        String response;
        String status;
        String t;
        final LanggananBeritaAll this$0;
        String user;
        UserFunctions userFunctions;
        String username;

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
            if (view == null)
            {
                view = viewgroup.inflate(resource, null);
                viewgroup = new ViewHolder();
                viewgroup.imageHp = (ImageView)view.findViewById(0x7f0b023d);
                viewgroup.list_txtMerek = (TextView)view.findViewById(0x7f0b033c);
                viewgroup.list_txtHarga = (TextView)view.findViewById(0x7f0b033d);
                viewgroup.progressbar_item = (ProgressBar)view.findViewById(0x7f0b00b3);
                viewgroup.rateRate = (RatingBar)view.findViewById(0x7f0b00c9);
                viewgroup.imgIklan = (ImageView)view.findViewById(0x7f0b0484);
                viewgroup.headIklan = (LinearLayout)view.findViewById(0x7f0b0482);
                viewgroup.progressbar_item_iklan = (ProgressBar)view.findViewById(0x7f0b0483);
                viewgroup.headHp = (LinearLayout)view.findViewById(0x7f0b0481);
                viewgroup.separator = (LinearLayout)view.findViewById(0x7f0b0340);
                viewgroup.bottom_list = (LinearLayout)view.findViewById(0x7f0b0341);
                viewgroup.headImage = (LinearLayout)view.findViewById(0x7f0b029f);
                viewgroup.list_txtBigRight = (TextView)view.findViewById(0x7f0b034d);
                viewgroup.leftdel = (RelativeLayout)view.findViewById(0x7f0b0480);
                view.setTag(viewgroup);
            } else
            {
                viewgroup = (ViewHolder)view.getTag();
            }
            lms = (ListModel)lm.get(i);
            if (lm != null)
            {
                ((ViewHolder) (viewgroup)).list_txtHarga.setVisibility(8);
                ((ViewHolder) (viewgroup)).bottom_list.setVisibility(8);
                ((ViewHolder) (viewgroup)).separator.setVisibility(8);
                ((ViewHolder) (viewgroup)).list_txtBigRight.setVisibility(8);
                ((ViewHolder) (viewgroup)).list_txtMerek.setText((new StringBuilder(String.valueOf(lms.getMerk()))).append(" ").append(lms.getModel()).toString());
                try
                {
                    imageLoader2.displayImage((new StringBuilder(String.valueOf(Util.BASE_PATH_NEWIMAGE))).append(lms.getGambar().trim()).toString(), ((ViewHolder) (viewgroup)).imageHp, options, viewgroup. new ImageLoadingListener() {

                        final ListLanggananAdapter this$1;
                        private final ListLanggananAdapter.ViewHolder val$holder;

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
                this$1 = final_listlanggananadapter;
                holder = ListLanggananAdapter.ViewHolder.this;
                super();
            }
                    });
                }
                catch (Exception exception) { }
                ((ViewHolder) (viewgroup)).leftdel.setOnClickListener(i. new android.view.View.OnClickListener() {

                    final ListLanggananAdapter this$1;
                    private final int val$position;

                    public void onClick(View view)
                    {
                        id_hp_del = getListModel(position).getId_hp();
                        Log.e("id_hp_del", id_hp_del);
                        view = new android.app.AlertDialog.Builder(_fld0);
                        view.setTitle("Peringatan");
                        view.setMessage("Berhenti berlangganan?");
                        view.setPositiveButton("Ya", position. new android.content.DialogInterface.OnClickListener() {

                            final ListLanggananAdapter._cls2 this$2;
                            private final int val$position;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                statdel = "0";
                                if (getListModel(position).getType().equals("hp"))
                                {
                                    type = "hp";
                                } else
                                {
                                    type = "brand";
                                }
                                if (netInfo != null && netInfo.isConnected())
                                {
                                    (new DelLanggananTask()).execute(new Void[0]);
                                    return;
                                } else
                                {
                                    Toast.makeText(_fld0, "Tidak ada koneksi internet", 0).show();
                                    return;
                                }
                            }

            
            {
                this$2 = final__pcls2;
                position = I.this;
                super();
            }
                        });
                        view.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                            final ListLanggananAdapter._cls2 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = ListLanggananAdapter._cls2.this;
                super();
            }
                        });
                        view.show();
                    }


            
            {
                this$1 = final_listlanggananadapter;
                position = I.this;
                super();
            }
                });
            }
            return view;
        }

        public void setListArray(ArrayList arraylist)
        {
            lm = arraylist;
        }


        public ListLanggananAdapter(Activity activity1, int i, ArrayList arraylist)
        {
            this$0 = LanggananBeritaAll.this;
            super();
            fmt = new DecimalFormat();
            fmts = new DecimalFormatSymbols();
            t = Utility.session(RestClient.pelihara);
            username = "";
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
                imageLoader2 = ImageLoader.getInstance();
                imageLoader2.init(ImageLoaderConfiguration.createDefault(activity.getApplicationContext()));
                options = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showImageForEmptyUri(0x7f020208).cacheInMemory(true).imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).build();
                userFunctions = new UserFunctions();
                db = new DatabaseHandler(activity1);
                t = Utility.session(t);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (LanggananBeritaAll langgananberitaall)
            {
                return;
            }
        }
    }

    class ListLanggananAdapter.ViewHolder
    {

        LinearLayout bottom_list;
        LinearLayout headHp;
        LinearLayout headIklan;
        LinearLayout headImage;
        ImageView imageHp;
        ImageView imgIklan;
        RelativeLayout leftdel;
        TextView list_txtBigRight;
        TextView list_txtHarga;
        TextView list_txtMerek;
        ProgressBar progressbar_item;
        ProgressBar progressbar_item_iklan;
        RatingBar rateRate;
        LinearLayout separator;
        final ListLanggananAdapter this$1;

        ListLanggananAdapter.ViewHolder()
        {
            this$1 = ListLanggananAdapter.this;
            super();
        }
    }

    public class ListSearchAdapter extends BaseAdapter
    {

        private Activity activity;
        Context context;
        Cursor cursor;
        DatabaseHandler db;
        Drawable drwAdd;
        Drawable drwDel;
        String email_user;
        String finalUrl;
        DecimalFormat fmt;
        DecimalFormatSymbols fmts;
        ImageLoader imageLoader2;
        String komen;
        private ArrayList lm;
        ListModel lms;
        ProgressDialog mDialog;
        private DisplayImageOptions options;
        int pos;
        String res;
        int resource;
        String response;
        String status;
        String t;
        final LanggananBeritaAll this$0;
        String user;
        UserFunctions userFunctions;
        String username;

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
            if (view == null)
            {
                view = viewgroup.inflate(resource, null);
                viewgroup = new ViewHolder();
                viewgroup.imageHp = (ImageView)view.findViewById(0x7f0b023d);
                viewgroup.list_txtMerek = (TextView)view.findViewById(0x7f0b033c);
                viewgroup.list_txtHarga = (TextView)view.findViewById(0x7f0b033d);
                viewgroup.progressbar_item = (ProgressBar)view.findViewById(0x7f0b00b3);
                viewgroup.img_delete = (ImageView)view.findViewById(0x7f0b0645);
                viewgroup.img_tambah = (ImageView)view.findViewById(0x7f0b0647);
                viewgroup.headImage = (LinearLayout)view.findViewById(0x7f0b029f);
                viewgroup.leftdel = (RelativeLayout)view.findViewById(0x7f0b0480);
                viewgroup.leftadd = (RelativeLayout)view.findViewById(0x7f0b0646);
                view.setTag(viewgroup);
            } else
            {
                viewgroup = (ViewHolder)view.getTag();
            }
            lms = (ListModel)lm.get(i);
            if (lm != null)
            {
                drwAdd = getResources().getDrawable(0x7f020240);
                drwAdd.setColorFilter(Color.parseColor("#FFFF5722"), android.graphics.PorterDuff.Mode.SRC_ATOP);
                drwDel = getResources().getDrawable(0x7f0201a1);
                drwDel.setColorFilter(Color.parseColor("#FFFF5722"), android.graphics.PorterDuff.Mode.SRC_ATOP);
                if (android.os.Build.VERSION.SDK_INT < 16)
                {
                    ((ViewHolder) (viewgroup)).img_delete.setBackgroundDrawable(drwDel);
                    ((ViewHolder) (viewgroup)).img_tambah.setBackgroundDrawable(drwAdd);
                } else
                {
                    ((ViewHolder) (viewgroup)).img_delete.setBackground(drwDel);
                    ((ViewHolder) (viewgroup)).img_tambah.setBackground(drwAdd);
                }
                ((ViewHolder) (viewgroup)).list_txtHarga.setVisibility(8);
                ((ViewHolder) (viewgroup)).list_txtMerek.setText(lms.getUni_name());
                if (lms.getUni_stat().equals("1"))
                {
                    ((ViewHolder) (viewgroup)).leftdel.setVisibility(8);
                    ((ViewHolder) (viewgroup)).img_delete.setVisibility(8);
                    ((ViewHolder) (viewgroup)).img_tambah.setVisibility(8);
                    ((ViewHolder) (viewgroup)).leftadd.setVisibility(8);
                } else
                {
                    ((ViewHolder) (viewgroup)).leftdel.setVisibility(8);
                    ((ViewHolder) (viewgroup)).img_delete.setVisibility(8);
                    ((ViewHolder) (viewgroup)).img_tambah.setVisibility(0);
                    ((ViewHolder) (viewgroup)).leftadd.setVisibility(0);
                }
                try
                {
                    imageLoader2.displayImage((new StringBuilder(String.valueOf(Util.BASE_PATH_NEWIMAGE))).append(lms.getUni_gambar().trim()).toString(), ((ViewHolder) (viewgroup)).imageHp, options, viewgroup. new ImageLoadingListener() {

                        final ListSearchAdapter this$1;
                        private final ListSearchAdapter.ViewHolder val$holder;

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
                this$1 = final_listsearchadapter;
                holder = ListSearchAdapter.ViewHolder.this;
                super();
            }
                    });
                }
                catch (Exception exception) { }
                ((ViewHolder) (viewgroup)).leftadd.setOnClickListener(i. new android.view.View.OnClickListener() {

                    final ListSearchAdapter this$1;
                    private final int val$position;

                    public void onClick(View view)
                    {
                        id_hp_del = getListModel(position).getUni_id();
                        uni_type = getListModel(position).getUni_type();
                        Log.e("id_hp_del", id_hp_del);
                        view = new android.app.AlertDialog.Builder(_fld0);
                        view.setTitle("Peringatan");
                        if (!uni_type.equals("hp")) goto _L2; else goto _L1
_L1:
                        view.setMessage("Langganan berita ponsel ini?");
_L4:
                        view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                            final ListSearchAdapter._cls2 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                statdel = "1";
                                if (netInfo != null && netInfo.isConnected())
                                {
                                    (new ListSearchAdapter.AddDelSearchTask()).execute(new Void[0]);
                                    return;
                                } else
                                {
                                    Toast.makeText(_fld0, "Tidak ada koneksi internet", 0).show();
                                    return;
                                }
                            }

            
            {
                this$2 = ListSearchAdapter._cls2.this;
                super();
            }
                        });
                        view.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                            final ListSearchAdapter._cls2 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = ListSearchAdapter._cls2.this;
                super();
            }
                        });
                        view.show();
                        return;
_L2:
                        if (uni_type.equals("merk"))
                        {
                            view.setMessage("Langganan berita merek ini?");
                        } else
                        if (uni_type.equals("operator"))
                        {
                            view.setMessage("Langganan berita operator ini?");
                        } else
                        if (uni_type.equals("general"))
                        {
                            view.setMessage("Langganan berita kategori ini?");
                        }
                        if (true) goto _L4; else goto _L3
_L3:
                    }


            
            {
                this$1 = final_listsearchadapter;
                position = I.this;
                super();
            }
                });
            }
            return view;
        }

        public void setListArray(ArrayList arraylist)
        {
            lm = arraylist;
        }


        public ListSearchAdapter(Activity activity1, int i, ArrayList arraylist)
        {
            this$0 = LanggananBeritaAll.this;
            super();
            fmt = new DecimalFormat();
            fmts = new DecimalFormatSymbols();
            t = Utility.session(RestClient.pelihara);
            username = "";
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
                imageLoader2 = ImageLoader.getInstance();
                imageLoader2.init(ImageLoaderConfiguration.createDefault(LanggananBeritaAll.this));
                options = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showImageForEmptyUri(0x7f020208).cacheInMemory(true).imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).build();
                userFunctions = new UserFunctions();
                db = new DatabaseHandler(activity1);
                t = Utility.session(t);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (LanggananBeritaAll langgananberitaall)
            {
                return;
            }
        }
    }

    public class ListSearchAdapter.AddDelSearchTask extends AsyncTask
    {

        final ListSearchAdapter this$1;

        private void parseJSONSubsNews(String s)
        {
            try
            {
                s = new JSONObject(s);
                postStatusSubsNews = s.getString("success");
                postMessageSubsNews = s.getString("message");
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
            if (!uni_type.equals("hp")) goto _L2; else goto _L1
_L1:
            querydel = (new StringBuilder("idhp=")).append(id_hp_del).append("&idusr=").append(user_id).append("&stat=").append("1").append("&t=").append(t).toString();
            pushURLdel = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("add_subscribe_news").append(Utility.BASE_FORMAT).append("?").append(querydel).toString();
_L4:
            Log.e("pushURL", pushURLdel);
            avoid = HttpPush.getResponse(pushURLdel);
            Log.e("push", (new StringBuilder(String.valueOf(avoid))).append(querydel).toString());
            resdel = avoid.toString();
            Log.e("url ", resdel);
            parseJSONSubsNews(resdel);
            break MISSING_BLOCK_LABEL_894;
_L2:
            if (uni_type.equals("merk"))
            {
                querydel = (new StringBuilder("idhp=")).append(id_hp_del).append("&idusr=").append(user_id).append("&stat=").append("1").append("&t=").append(t).toString();
                pushURLdel = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("add_subscribe_brand").append(Utility.BASE_FORMAT).append("?").append(querydel).toString();
                continue; /* Loop/switch isn't completed */
            }
            if (uni_type.equals("operator"))
            {
                querydel = (new StringBuilder("idhp=")).append(id_hp_del).append("&idusr=").append(user_id).append("&stat=").append("1").append("&type=").append("op").append("&t=").append(t).toString();
                pushURLdel = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("add_subscribe_news").append(Utility.BASE_FORMAT).append("?").append(querydel).toString();
                continue; /* Loop/switch isn't completed */
            }
            if (uni_type.equals("general"))
            {
                querydel = (new StringBuilder("idhp=")).append(id_hp_del).append("&idusr=").append(user_id).append("&stat=").append("1").append("&type=").append("general").append("&t=").append(t).toString();
                pushURLdel = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("add_subscribe_news").append(Utility.BASE_FORMAT).append("?").append(querydel).toString();
                continue; /* Loop/switch isn't completed */
            }
            try
            {
                querydel = (new StringBuilder("idhp=")).append(id_hp_del).append("&idusr=").append(user_id).append("&stat=").append("1").append("&type=").append("os").append("&t=").append(t).toString();
                pushURLdel = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("add_subscribe_news").append(Utility.BASE_FORMAT).append("?").append(querydel).toString();
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                avoid.printStackTrace();
                break MISSING_BLOCK_LABEL_894;
            }
            if (true) goto _L4; else goto _L3
_L3:
            return null;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            super.onPostExecute(void1);
            mDialog.dismiss();
            dialog.dismiss();
            if (!postStatusSubsNews.equals("1") && !postStatusSubsNews.equals("10"))
            {
                break MISSING_BLOCK_LABEL_220;
            }
            Toast.makeText(_fld0, postMessageSubsNews, 0).show();
            if (!uni_type.equals("hp")) goto _L2; else goto _L1
_L1:
            LanggananTask();
_L3:
            mDialog.dismiss();
            return;
_L2:
label0:
            {
                if (!uni_type.equals("merk"))
                {
                    break label0;
                }
                LanggananMerekTask();
            }
              goto _L3
            if (!uni_type.equals("operator")) goto _L5; else goto _L4
_L4:
            LanggananOpTask();
              goto _L3
_L5:
            if (!uni_type.equals("general")) goto _L3; else goto _L6
_L6:
            LanggananKatsusTask();
              goto _L3
            try
            {
                if (postStatusSubsNews.equals("00") || postStatusSubsNews.equals("0"))
                {
                    Toast.makeText(_fld0, postMessageSubsNews, 0).show();
                    mDialog.dismiss();
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
            if (postStatusSubsNews.equals("40404"))
            {
                mDialog.dismiss();
                return;
            }
            Toast.makeText(_fld0, postMessageSubsNews, 0).show();
            return;
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            statusdel = "";
            if (statdel.equals("1"))
            {
                mDialog = ProgressDialog.show(_fld0, "", "Menambahkan...", true);
            } else
            {
                mDialog = ProgressDialog.show(_fld0, "", "Menghapus...", true);
            }
            mDialog.setCancelable(true);
            mDialog.show();
        }

        public ListSearchAdapter.AddDelSearchTask()
        {
            this$1 = ListSearchAdapter.this;
            super();
        }
    }

    class ListSearchAdapter.ViewHolder
    {

        LinearLayout headImage;
        ImageView imageHp;
        ImageView img_delete;
        ImageView img_tambah;
        RelativeLayout leftadd;
        RelativeLayout leftdel;
        TextView list_txtHarga;
        TextView list_txtMerek;
        ProgressBar progressbar_item;
        final ListSearchAdapter this$1;

        ListSearchAdapter.ViewHolder()
        {
            this$1 = ListSearchAdapter.this;
            super();
        }
    }

    public class ListlangganKatsusAdapter extends BaseAdapter
    {

        private Activity activity;
        Context context;
        Cursor cursor;
        DatabaseHandler db;
        String email_user;
        String finalUrl;
        DecimalFormat fmt;
        DecimalFormatSymbols fmts;
        ImageLoader imageLoader2;
        String komen;
        private ArrayList lm;
        ListModel lms;
        ProgressDialog mDialog;
        private DisplayImageOptions options;
        int pos;
        String res;
        int resource;
        String response;
        String status;
        String t;
        final LanggananBeritaAll this$0;
        String user;
        UserFunctions userFunctions;
        String username;

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
            if (view == null)
            {
                view = viewgroup.inflate(resource, null);
                viewgroup = new ViewHolder();
                viewgroup.imageHp = (ImageView)view.findViewById(0x7f0b023d);
                viewgroup.list_txtMerek = (TextView)view.findViewById(0x7f0b033c);
                viewgroup.list_txtHarga = (TextView)view.findViewById(0x7f0b033d);
                viewgroup.progressbar_item = (ProgressBar)view.findViewById(0x7f0b00b3);
                viewgroup.rateRate = (RatingBar)view.findViewById(0x7f0b00c9);
                viewgroup.imgIklan = (ImageView)view.findViewById(0x7f0b0484);
                viewgroup.headIklan = (LinearLayout)view.findViewById(0x7f0b0482);
                viewgroup.progressbar_item_iklan = (ProgressBar)view.findViewById(0x7f0b0483);
                viewgroup.headHp = (LinearLayout)view.findViewById(0x7f0b0481);
                viewgroup.separator = (LinearLayout)view.findViewById(0x7f0b0340);
                viewgroup.bottom_list = (LinearLayout)view.findViewById(0x7f0b0341);
                viewgroup.headImage = (LinearLayout)view.findViewById(0x7f0b029f);
                viewgroup.list_txtBigRight = (TextView)view.findViewById(0x7f0b034d);
                viewgroup.leftdel = (RelativeLayout)view.findViewById(0x7f0b0480);
                view.setTag(viewgroup);
            } else
            {
                viewgroup = (ViewHolder)view.getTag();
            }
            lms = (ListModel)lm.get(i);
            if (lm != null)
            {
                ((ViewHolder) (viewgroup)).list_txtHarga.setVisibility(8);
                ((ViewHolder) (viewgroup)).bottom_list.setVisibility(8);
                ((ViewHolder) (viewgroup)).separator.setVisibility(8);
                ((ViewHolder) (viewgroup)).list_txtBigRight.setVisibility(8);
                ((ViewHolder) (viewgroup)).list_txtMerek.setText((new StringBuilder(String.valueOf(lms.getMerk()))).append(" ").append(lms.getModel()).toString());
                try
                {
                    imageLoader2.displayImage((new StringBuilder(String.valueOf(Util.BASE_PATH_NEWIMAGE))).append(lms.getGambar().trim()).toString(), ((ViewHolder) (viewgroup)).imageHp, options, viewgroup. new ImageLoadingListener() {

                        final ListlangganKatsusAdapter this$1;
                        private final ListlangganKatsusAdapter.ViewHolder val$holder;

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
                this$1 = final_listlanggankatsusadapter;
                holder = ListlangganKatsusAdapter.ViewHolder.this;
                super();
            }
                    });
                }
                catch (Exception exception) { }
                ((ViewHolder) (viewgroup)).leftdel.setOnClickListener(i. new android.view.View.OnClickListener() {

                    final ListlangganKatsusAdapter this$1;
                    private final int val$position;

                    public void onClick(View view)
                    {
                        id_hp_del = getListModel(position).getId_hp();
                        Log.e("id_hp_del", id_hp_del);
                        view = new android.app.AlertDialog.Builder(_fld0);
                        view.setTitle("Peringatan");
                        view.setMessage("Berhenti berlangganan kategori ini?");
                        view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                            final ListlangganKatsusAdapter._cls2 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                statdel = "0";
                                if (netInfo != null && netInfo.isConnected())
                                {
                                    (new ListlangganKatsusAdapter.AddDelLanggananKatsusTask()).execute(new Void[0]);
                                    return;
                                } else
                                {
                                    Toast.makeText(_fld0, "Tidak ada koneksi internet", 0).show();
                                    return;
                                }
                            }

            
            {
                this$2 = ListlangganKatsusAdapter._cls2.this;
                super();
            }
                        });
                        view.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                            final ListlangganKatsusAdapter._cls2 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = ListlangganKatsusAdapter._cls2.this;
                super();
            }
                        });
                        view.show();
                    }


            
            {
                this$1 = final_listlanggankatsusadapter;
                position = I.this;
                super();
            }
                });
            }
            return view;
        }

        public void setListArray(ArrayList arraylist)
        {
            lm = arraylist;
        }


        public ListlangganKatsusAdapter(Activity activity1, int i, ArrayList arraylist)
        {
            this$0 = LanggananBeritaAll.this;
            super();
            fmt = new DecimalFormat();
            fmts = new DecimalFormatSymbols();
            t = Utility.session(RestClient.pelihara);
            username = "";
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
                imageLoader2 = ImageLoader.getInstance();
                imageLoader2.init(ImageLoaderConfiguration.createDefault(LanggananBeritaAll.this));
                options = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showImageForEmptyUri(0x7f020208).cacheInMemory(true).imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).build();
                userFunctions = new UserFunctions();
                db = new DatabaseHandler(activity1);
                t = Utility.session(t);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (LanggananBeritaAll langgananberitaall)
            {
                return;
            }
        }
    }

    public class ListlangganKatsusAdapter.AddDelLanggananKatsusTask extends AsyncTask
    {

        final ListlangganKatsusAdapter this$1;

        private void parseJSONSubsNews(String s)
        {
            try
            {
                s = new JSONObject(s);
                postStatusKatSubsNews = s.getString("success");
                postMessageSubsKatNews = s.getString("message");
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
                querydel = (new StringBuilder("idhp=")).append(id_hp_del).append("&idusr=").append(user_id).append("&stat=").append("0").append("&type=general").append("&t=").append(t).toString();
                pushURLdel = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("add_subscribe_news").append(Utility.BASE_FORMAT).append("?").append(querydel).toString();
                Log.e("pushURL", pushURLdel);
                avoid = HttpPush.getResponse(pushURLdel);
                Log.e("push", (new StringBuilder(String.valueOf(avoid))).append(querydel).toString());
                resdel = avoid.toString();
                Log.e("url ", resdel);
                parseJSONSubsNews(resdel);
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
            if (!postStatusKatSubsNews.equals("1") && !postStatusKatSubsNews.equals("10")) goto _L2; else goto _L1
_L1:
            mDialog.dismiss();
            Toast.makeText(_fld0, postMessageSubsKatNews, 0).show();
            LanggananKatsusTask();
_L3:
            langganKatsusAdapter.notifyDataSetChanged();
            return;
_L2:
label0:
            {
                if (!postStatusKatSubsNews.equals("00") && !postStatusKatSubsNews.equals("0"))
                {
                    break label0;
                }
                mDialog.dismiss();
                Toast.makeText(_fld0, postMessageSubsKatNews, 0).show();
            }
              goto _L3
label1:
            {
                if (!resdel.equals("40404"))
                {
                    break label1;
                }
                mDialog.dismiss();
                Toast.makeText(_fld0, postMessageSubsKatNews, 0).show();
            }
              goto _L3
            try
            {
                Toast.makeText(_fld0, postMessageSubsKatNews, 0).show();
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
              goto _L3
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            statusdel = "";
            if (statdel.equals("1"))
            {
                mDialog = ProgressDialog.show(_fld0, "", "Menambahkan...", true);
            } else
            {
                mDialog = ProgressDialog.show(_fld0, "", "Menghapus...", true);
            }
            mDialog.setCancelable(true);
            mDialog.show();
        }

        public ListlangganKatsusAdapter.AddDelLanggananKatsusTask()
        {
            this$1 = ListlangganKatsusAdapter.this;
            super();
        }
    }

    class ListlangganKatsusAdapter.ViewHolder
    {

        LinearLayout bottom_list;
        LinearLayout headHp;
        LinearLayout headIklan;
        LinearLayout headImage;
        ImageView imageHp;
        ImageView imgIklan;
        RelativeLayout leftdel;
        TextView list_txtBigRight;
        TextView list_txtHarga;
        TextView list_txtMerek;
        ProgressBar progressbar_item;
        ProgressBar progressbar_item_iklan;
        RatingBar rateRate;
        LinearLayout separator;
        final ListlangganKatsusAdapter this$1;

        ListlangganKatsusAdapter.ViewHolder()
        {
            this$1 = ListlangganKatsusAdapter.this;
            super();
        }
    }

    public class ListlanggananOpAdapter extends BaseAdapter
    {

        private Activity activity;
        Context context;
        Cursor cursor;
        DatabaseHandler db;
        String email_user;
        String finalUrl;
        DecimalFormat fmt;
        DecimalFormatSymbols fmts;
        ImageLoader imageLoader2;
        String komen;
        private ArrayList lm;
        ListModel lms;
        ProgressDialog mDialog;
        private DisplayImageOptions options;
        int pos;
        String res;
        int resource;
        String response;
        String status;
        String t;
        final LanggananBeritaAll this$0;
        String user;
        UserFunctions userFunctions;
        String username;

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
            if (view == null)
            {
                view = viewgroup.inflate(resource, null);
                viewgroup = new ViewHolder();
                viewgroup.imageHp = (ImageView)view.findViewById(0x7f0b023d);
                viewgroup.list_txtMerek = (TextView)view.findViewById(0x7f0b033c);
                viewgroup.list_txtHarga = (TextView)view.findViewById(0x7f0b033d);
                viewgroup.progressbar_item = (ProgressBar)view.findViewById(0x7f0b00b3);
                viewgroup.rateRate = (RatingBar)view.findViewById(0x7f0b00c9);
                viewgroup.imgIklan = (ImageView)view.findViewById(0x7f0b0484);
                viewgroup.headIklan = (LinearLayout)view.findViewById(0x7f0b0482);
                viewgroup.progressbar_item_iklan = (ProgressBar)view.findViewById(0x7f0b0483);
                viewgroup.headHp = (LinearLayout)view.findViewById(0x7f0b0481);
                viewgroup.separator = (LinearLayout)view.findViewById(0x7f0b0340);
                viewgroup.bottom_list = (LinearLayout)view.findViewById(0x7f0b0341);
                viewgroup.headImage = (LinearLayout)view.findViewById(0x7f0b029f);
                viewgroup.list_txtBigRight = (TextView)view.findViewById(0x7f0b034d);
                viewgroup.leftdel = (RelativeLayout)view.findViewById(0x7f0b0480);
                view.setTag(viewgroup);
            } else
            {
                viewgroup = (ViewHolder)view.getTag();
            }
            lms = (ListModel)lm.get(i);
            if (lm != null)
            {
                ((ViewHolder) (viewgroup)).list_txtHarga.setVisibility(8);
                ((ViewHolder) (viewgroup)).bottom_list.setVisibility(8);
                ((ViewHolder) (viewgroup)).separator.setVisibility(8);
                ((ViewHolder) (viewgroup)).list_txtBigRight.setVisibility(8);
                ((ViewHolder) (viewgroup)).list_txtMerek.setText((new StringBuilder(String.valueOf(lms.getMerk()))).append(" ").append(lms.getModel()).toString());
                try
                {
                    imageLoader2.displayImage((new StringBuilder(String.valueOf(Util.BASE_PATH_NEWIMAGE))).append(lms.getGambar().trim()).toString(), ((ViewHolder) (viewgroup)).imageHp, options, viewgroup. new ImageLoadingListener() {

                        final ListlanggananOpAdapter this$1;
                        private final ListlanggananOpAdapter.ViewHolder val$holder;

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
                this$1 = final_listlanggananopadapter;
                holder = ListlanggananOpAdapter.ViewHolder.this;
                super();
            }
                    });
                }
                catch (Exception exception) { }
                ((ViewHolder) (viewgroup)).leftdel.setOnClickListener(i. new android.view.View.OnClickListener() {

                    final ListlanggananOpAdapter this$1;
                    private final int val$position;

                    public void onClick(View view)
                    {
                        id_hp_del = getListModel(position).getId_hp();
                        Log.e("id_hp_del", id_hp_del);
                        view = new android.app.AlertDialog.Builder(_fld0);
                        view.setTitle("Peringatan");
                        view.setMessage("Berhenti berlangganan berita operator ini?");
                        view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                            final ListlanggananOpAdapter._cls2 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                statdel = "0";
                                if (netInfo != null && netInfo.isConnected())
                                {
                                    (new ListlanggananOpAdapter.AddDelLanggananOpTask()).execute(new Void[0]);
                                    return;
                                } else
                                {
                                    Toast.makeText(_fld0, "Tidak ada koneksi internet", 0).show();
                                    return;
                                }
                            }

            
            {
                this$2 = ListlanggananOpAdapter._cls2.this;
                super();
            }
                        });
                        view.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                            final ListlanggananOpAdapter._cls2 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = ListlanggananOpAdapter._cls2.this;
                super();
            }
                        });
                        view.show();
                    }


            
            {
                this$1 = final_listlanggananopadapter;
                position = I.this;
                super();
            }
                });
            }
            return view;
        }

        public void setListArray(ArrayList arraylist)
        {
            lm = arraylist;
        }


        public ListlanggananOpAdapter(Activity activity1, int i, ArrayList arraylist)
        {
            this$0 = LanggananBeritaAll.this;
            super();
            fmt = new DecimalFormat();
            fmts = new DecimalFormatSymbols();
            t = Utility.session(RestClient.pelihara);
            username = "";
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
                imageLoader2 = ImageLoader.getInstance();
                imageLoader2.init(ImageLoaderConfiguration.createDefault(LanggananBeritaAll.this));
                options = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showImageForEmptyUri(0x7f020208).cacheInMemory(true).imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).build();
                userFunctions = new UserFunctions();
                db = new DatabaseHandler(activity1);
                t = Utility.session(t);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (LanggananBeritaAll langgananberitaall)
            {
                return;
            }
        }
    }

    public class ListlanggananOpAdapter.AddDelLanggananOpTask extends AsyncTask
    {

        final ListlanggananOpAdapter this$1;

        private void parseJSONSubsNews(String s)
        {
            try
            {
                s = new JSONObject(s);
                postStatusSubsNews = s.getString("success");
                postMessageSubsNews = s.getString("message");
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
                querydel = (new StringBuilder("idhp=")).append(id_hp_del).append("&idusr=").append(user_id).append("&stat=").append("0").append("&type=op").append("&t=").append(t).toString();
                pushURLdel = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("add_subscribe_news").append(Utility.BASE_FORMAT).append("?").append(querydel).toString();
                Log.e("pushURL", pushURLdel);
                avoid = HttpPush.getResponse(pushURLdel);
                Log.e("push", (new StringBuilder(String.valueOf(avoid))).append(querydel).toString());
                resdel = avoid.toString();
                Log.e("url ", resdel);
                parseJSONSubsNews(resdel);
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
            if (!postStatusSubsNews.equals("1") && !postStatusSubsNews.equals("10")) goto _L2; else goto _L1
_L1:
            mDialog.dismiss();
            Toast.makeText(_fld0, postMessageSubsNews, 0).show();
            LanggananOpTask();
_L3:
            langgananOpAdapter.notifyDataSetChanged();
            return;
_L2:
label0:
            {
                if (!postStatusSubsNews.equals("00") && !postStatusSubsNews.equals("0"))
                {
                    break label0;
                }
                mDialog.dismiss();
                Toast.makeText(_fld0, postMessageSubsNews, 0).show();
            }
              goto _L3
label1:
            {
                if (!resdel.equals("40404"))
                {
                    break label1;
                }
                mDialog.dismiss();
                Toast.makeText(_fld0, postMessageSubsNews, 0).show();
            }
              goto _L3
            try
            {
                Toast.makeText(_fld0, postMessageSubsNews, 0).show();
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
              goto _L3
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            statusdel = "";
            if (statdel.equals("1"))
            {
                mDialog = ProgressDialog.show(_fld0, "", "Menambahkan...", true);
            } else
            {
                mDialog = ProgressDialog.show(_fld0, "", "Menghapus...", true);
            }
            mDialog.setCancelable(true);
            mDialog.show();
        }

        public ListlanggananOpAdapter.AddDelLanggananOpTask()
        {
            this$1 = ListlanggananOpAdapter.this;
            super();
        }
    }

    class ListlanggananOpAdapter.ViewHolder
    {

        LinearLayout bottom_list;
        LinearLayout headHp;
        LinearLayout headIklan;
        LinearLayout headImage;
        ImageView imageHp;
        ImageView imgIklan;
        RelativeLayout leftdel;
        TextView list_txtBigRight;
        TextView list_txtHarga;
        TextView list_txtMerek;
        ProgressBar progressbar_item;
        ProgressBar progressbar_item_iklan;
        RatingBar rateRate;
        LinearLayout separator;
        final ListlanggananOpAdapter this$1;

        ListlanggananOpAdapter.ViewHolder()
        {
            this$1 = ListlanggananOpAdapter.this;
            super();
        }
    }


    ActionBar actionBar;
    int actionBarTitleId;
    Button btnSubmitHp;
    ConnectivityManager cm;
    String codename;
    int count_all_favbrand;
    int count_all_katsus;
    int count_first_favbrand;
    int count_first_katsus;
    int counterArray;
    int counterKatsusArray;
    Cursor cursor;
    String dataBrand;
    String dataFav;
    String dataKatsus;
    String dataLangganan;
    String dataMerek;
    String dataSearch;
    DatabaseHandler db;
    Dialog dialog;
    EditText edtAuto;
    EditText edtHpKetik;
    String email_user;
    String gambar;
    String id_hp_del;
    String id_hph;
    String idkom_pos;
    String idrss_pos;
    JSONArray inponsel;
    JSONArray inponselKatsus;
    JSONArray jArray;
    ListlangganKatsusAdapter langganKatsusAdapter;
    ArrayList langganKatsusArray;
    ListLanggananAdapter langgananAdapter;
    ArrayList langgananArray;
    ListlanggananOpAdapter langgananOpAdapter;
    ArrayList langgananOpArray;
    ListView listFindDev;
    ExpandableHeightGridView listKatsus;
    ExpandableHeightGridView listLanggananMerek;
    ExpandableHeightGridView listLanggananOperator;
    ExpandableHeightGridView listLanggananPonsel;
    ListSearchAdapter listSearchAdapter;
    ArrayList listSearchArrayList;
    String listtwitter;
    ProgressDialog mDialog;
    ArrayList merekArray;
    ListLanggananAdapter mereknAdapter;
    String merk;
    String model;
    String nama_asli;
    String namalengkap;
    NetworkInfo netInfo;
    PonselBaseApp ponselBaseApp;
    String postMessageLikeKom;
    String postMessageSubsKatNews;
    String postMessageSubsNews;
    String postStatusKatSubsNews;
    String postStatusLikeKom;
    String postStatusSubsNews;
    ProgressBar progressbar_Merek;
    ProgressBar progressbar_langganan;
    ProgressBar progressbar_search;
    String pushURL;
    String pushURLdel;
    String querydel;
    String resdel;
    String reslike;
    RelativeLayout rl_langganan_merek;
    String stat;
    String statKatsus;
    String statdel;
    String statusdel;
    String str_srclink;
    String suc;
    String sucKatsus;
    String t;
    String tot_LikeKom;
    String totdis_LikeKom;
    String twitter;
    TextView txtFavDevice;
    TextView txt_empty;
    TextView txt_empty_langganan;
    TextView txt_empty_merek;
    String type;
    String uni_type;
    private boolean useLogo;
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
    String username;
    ContextThemeWrapper wrapperLight;

    public LanggananBeritaAll()
    {
        langgananArray = null;
        merekArray = null;
        langgananOpArray = null;
        pushURL = "";
        dataLangganan = "";
        dataMerek = "";
        user_photo = "";
        username = "";
        t = Utility.session(RestClient.pelihara);
        twitter = "";
        listtwitter = "";
        idkom_pos = "";
        idrss_pos = "";
        str_srclink = "";
        dataFav = "";
        id_hp_del = "";
        statdel = "";
        statusdel = "";
        dataBrand = "";
        type = "";
        useLogo = false;
        actionBarTitleId = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        count_first_favbrand = 0;
        count_all_favbrand = 0;
        inponsel = null;
        suc = "";
        stat = "";
        count_first_katsus = 0;
        count_all_katsus = 0;
        inponselKatsus = null;
        sucKatsus = "";
        statKatsus = "";
        langganKatsusArray = null;
        dataKatsus = "";
        listSearchArrayList = null;
        uni_type = "";
        dataSearch = "";
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

    public void FavoritSearchTask(String s)
    {
        dataSearch = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("list_langganan_union").append(Utility.BASE_FORMAT).append("?id_user=").append(user_id).append("&key=").append(s).append("&sort=hp").append("&t=").append(t).toString();
        Log.e("dataSearch", dataSearch);
        s = new FavoritSearchTask(null);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            s.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            s.execute(new Void[0]);
            return;
        }
    }

    public void LanggananKatsusTask()
    {
        dataKatsus = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("user_rssfollow_katsus").append(Utility.BASE_FORMAT).append("?t=").append(t).append("&idusr=").append(user_id).append("&lmt=1").toString();
        Log.e("dataKatsus", dataKatsus);
        LanggananKatsusTask langganankatsustask = new LanggananKatsusTask(null);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            langganankatsustask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            langganankatsustask.execute(new Void[0]);
            return;
        }
    }

    public void LanggananMerekTask()
    {
        dataMerek = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("subscribe_news_merek").append(Utility.BASE_FORMAT).append("?idusr=").append(user_id).append("&t=").append(t).toString();
        Log.e("dataMerek", dataMerek);
        LanggananMerekTask langgananmerektask = new LanggananMerekTask(null);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            langgananmerektask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            langgananmerektask.execute(new Void[0]);
            return;
        }
    }

    public void LanggananOpTask()
    {
        dataBrand = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("user_rssfollow_op").append(Utility.BASE_FORMAT).append("?t=").append(t).append("&idusr=").append(user_id).append("&lmt=1").toString();
        Log.e("dataBrand", dataBrand);
        LanggananOpTask langgananoptask = new LanggananOpTask(null);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            langgananoptask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            langgananoptask.execute(new Void[0]);
            return;
        }
    }

    public void LanggananTask()
    {
        dataLangganan = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("subscribe_news_list").append(Utility.BASE_FORMAT).append("?idusr=").append(user_id).append("&t=").append(t).append("&lmt=1").toString();
        Log.e("dataLangganan", dataLangganan);
        LanggananNewsTask langganannewstask = new LanggananNewsTask(null);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            langganannewstask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            langganannewstask.execute(new Void[0]);
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        ponselBaseApp = (PonselBaseApp)getApplication();
        ponselBaseApp.getObserver().addObserver(this);
        setContentView(0x7f0300e4);
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            setTranslucentStatus(true);
        }
        bundle = new SystemBarTintManager(this);
        bundle.setStatusBarTintEnabled(true);
        bundle.setStatusBarTintResource(0x7f080160);
        actionBar = getSupportActionBar();
        actionBar.setDisplayUseLogoEnabled(useLogo);
        actionBar.setBackgroundDrawable(getResources().getDrawable(0x7f0200e5));
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        int j = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        int i = j;
        if (j == 0)
        {
            i = 0x7f0b0037;
        }
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFFFFF'>Langganan Berita</font>"));
        bundle = (TextView)findViewById(i);
        bundle.setSelected(true);
        bundle.setTextColor(Color.parseColor("#FFFFFF"));
        bundle.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        wrapperLight = new ContextThemeWrapper(this, 0x103006e);
        t = Utility.session(t);
        cm = (ConnectivityManager)getSystemService("connectivity");
        netInfo = cm.getActiveNetworkInfo();
        userFunctions = new UserFunctions();
        db = new DatabaseHandler(this);
        t = Utility.session(t);
        if (userFunctions.isUserLoggedIn(this))
        {
            cursor = db.getAllData();
            cursor.moveToFirst();
            try
            {
                user_id = EncodeDecodeAES.decrypt(RestClient.pelihara, cursor.getString(1));
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle) { }
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
        listLanggananPonsel = (ExpandableHeightGridView)findViewById(0x7f0b06d7);
        progressbar_langganan = (ProgressBar)findViewById(0x7f0b06cd);
        txt_empty_langganan = (TextView)findViewById(0x7f0b06d0);
        langgananArray = new ArrayList();
        langgananAdapter = new ListLanggananAdapter(this, 0x7f03011d, langgananArray);
        listLanggananPonsel.setAdapter(langgananAdapter);
        rl_langganan_merek = (RelativeLayout)findViewById(0x7f0b06d2);
        listLanggananMerek = (ExpandableHeightGridView)findViewById(0x7f0b06d8);
        listLanggananMerek.setVisibility(8);
        rl_langganan_merek.setVisibility(8);
        progressbar_Merek = (ProgressBar)findViewById(0x7f0b06ce);
        txt_empty_merek = (TextView)findViewById(0x7f0b06d3);
        merekArray = new ArrayList();
        mereknAdapter = new ListLanggananAdapter(this, 0x7f03011e, merekArray);
        listLanggananMerek.setAdapter(mereknAdapter);
        listLanggananOperator = (ExpandableHeightGridView)findViewById(0x7f0b06d9);
        listKatsus = (ExpandableHeightGridView)findViewById(0x7f0b06da);
        langgananOpArray = new ArrayList();
        langgananOpAdapter = new ListlanggananOpAdapter(this, 0x7f0300b9, langgananOpArray);
        listLanggananOperator.setAdapter(langgananOpAdapter);
        langganKatsusArray = new ArrayList();
        langganKatsusAdapter = new ListlangganKatsusAdapter(this, 0x7f0300b9, langganKatsusArray);
        listKatsus.setAdapter(langganKatsusAdapter);
        listKatsus.setExpanded(true);
        listLanggananMerek.setExpanded(true);
        listLanggananOperator.setExpanded(true);
        listLanggananPonsel.setExpanded(true);
        txtFavDevice = (TextView)findViewById(0x7f0b06d6);
        txtFavDevice.setText(Html.fromHtml("<small>Ketik tipe ponsel, merek atau operator</small>"));
        LanggananTask();
        LanggananMerekTask();
        LanggananOpTask();
        LanggananKatsusTask();
        listLanggananPonsel.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final LanggananBeritaAll this$0;

            public void onItemClick(AdapterView adapterview, View view, int k, long l)
            {
                adapterview = new Intent(LanggananBeritaAll.this, com/inponsel/android/v2/RSSFeedByTag);
                adapterview.putExtra("tag_code", "5");
                adapterview.putExtra("tag_key", (new StringBuilder("hp:")).append(langgananAdapter.getListModel(k).getId_hp()).toString());
                adapterview.putExtra("kategori_tag", (new StringBuilder(String.valueOf(langgananAdapter.getListModel(k).getMerk()))).append(" ").append(langgananAdapter.getListModel(k).getModel()).toString());
                startActivityForResult(adapterview, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = LanggananBeritaAll.this;
                super();
            }
        });
        listLanggananMerek.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final LanggananBeritaAll this$0;

            public void onItemClick(AdapterView adapterview, View view, int k, long l)
            {
                adapterview = new Intent(LanggananBeritaAll.this, com/inponsel/android/v2/RSSFeedByTag);
                adapterview.putExtra("tag_code", "2");
                adapterview.putExtra("tag_key", (new StringBuilder("br:")).append(mereknAdapter.getListModel(k).getId_hp()).toString());
                adapterview.putExtra("kategori_tag", mereknAdapter.getListModel(k).getMerk());
                startActivityForResult(adapterview, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = LanggananBeritaAll.this;
                super();
            }
        });
        listLanggananOperator.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final LanggananBeritaAll this$0;

            public void onItemClick(AdapterView adapterview, View view, int k, long l)
            {
                listLanggananOperator.playSoundEffect(0);
                adapterview = new Intent(LanggananBeritaAll.this, com/inponsel/android/v2/RSSFeedByTag);
                adapterview.putExtra("tag_code", "4");
                adapterview.putExtra("tag_key", (new StringBuilder("op:")).append(langgananOpAdapter.getListModel(k).getId_hp()).toString());
                adapterview.putExtra("kategori_tag", langgananOpAdapter.getListModel(k).getMerk());
                startActivityForResult(adapterview, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = LanggananBeritaAll.this;
                super();
            }
        });
        listKatsus.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final LanggananBeritaAll this$0;

            public void onItemClick(AdapterView adapterview, View view, int k, long l)
            {
                listKatsus.playSoundEffect(0);
                adapterview = new Intent(LanggananBeritaAll.this, com/inponsel/android/v2/RSSFeedByTag);
                adapterview.putExtra("tag_code", "0");
                adapterview.putExtra("tag_key", (new StringBuilder("gn:")).append(langganKatsusAdapter.getListModel(k).getId_hp()).toString());
                adapterview.putExtra("kategori_tag", langganKatsusAdapter.getListModel(k).getMerk());
                startActivityForResult(adapterview, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = LanggananBeritaAll.this;
                super();
            }
        });
        txtFavDevice.setOnClickListener(new android.view.View.OnClickListener() {

            final LanggananBeritaAll this$0;

            public void onClick(View view)
            {
                Log.e("click", "custom dialog");
                view = getLayoutInflater().inflate(0x7f030025, null);
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(wrapperLight);
                builder.setView(view);
                edtAuto = (EditText)view.findViewById(0x7f0b008d);
                listFindDev = (ListView)view.findViewById(0x7f0b008f);
                if (android.os.Build.VERSION.SDK_INT < 13)
                {
                    edtAuto.setTextColor(-1);
                    listFindDev.setBackgroundColor(-1);
                }
                progressbar_search = (ProgressBar)view.findViewById(0x7f0b008e);
                progressbar_search.setVisibility(8);
                listSearchArrayList = new ArrayList();
                listSearchAdapter = new ListSearchAdapter(LanggananBeritaAll.this, 0x7f0300c2, listSearchArrayList);
                listFindDev.setAdapter(listSearchAdapter);
                edtAuto.setSingleLine(true);
                edtAuto.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

                    final _cls5 this$1;

                    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
                    {
                        boolean flag = false;
                        if (i != 3) goto _L2; else goto _L1
_L1:
                        if (edtAuto.getText().toString().length() < 2) goto _L4; else goto _L3
_L3:
                        progressbar_search.setVisibility(0);
                        textview = edtAuto.getText().toString();
                        keyevent = URLEncoder.encode(textview, "utf-8");
                        textview = keyevent;
_L6:
                        FavoritSearchTask(textview);
_L4:
                        flag = true;
_L2:
                        return flag;
                        keyevent;
                        keyevent.printStackTrace();
                        if (true) goto _L6; else goto _L5
_L5:
                    }

            
            {
                this$1 = _cls5.this;
                super();
            }
                });
                edtAuto.addTextChangedListener(new DelayedTextWatcher(2000L) {

                    final _cls5 this$1;

                    public void afterTextChangedDelayed(Editable editable)
                    {
                        if (edtAuto.getText().toString().length() < 2) goto _L2; else goto _L1
_L1:
                        progressbar_search.setVisibility(0);
                        editable = edtAuto.getText().toString();
                        String s = URLEncoder.encode(editable, "utf-8");
                        editable = s;
_L4:
                        FavoritSearchTask(editable);
_L2:
                        return;
                        UnsupportedEncodingException unsupportedencodingexception;
                        unsupportedencodingexception;
                        unsupportedencodingexception.printStackTrace();
                        if (true) goto _L4; else goto _L3
_L3:
                    }

            
            {
                this$1 = _cls5.this;
                super(l);
            }
                });
                dialog = builder.create();
                dialog.show();
            }


            
            {
                this$0 = LanggananBeritaAll.this;
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

    public void update(Observable observable, Object obj)
    {
    }
}
