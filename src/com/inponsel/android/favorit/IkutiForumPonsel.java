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
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.tlforum.ForumHPActivity;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.DelayedTextWatcher;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.ServiceHandler;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.widget.ExpandableHeightGridView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.readystatesoftware.systembartint.SystemBarTintManager;
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

public class IkutiForumPonsel extends SherlockFragmentActivity
    implements Observer
{
    private class FavoritHPTask extends AsyncTask
    {

        final IkutiForumPonsel this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            {
                avoid = (new ServiceHandler()).makeServiceCall(dataForumPonsel, 1);
                Log.e("Responseharga: ", (new StringBuilder("> ")).append(avoid).toString());
                if (avoid == null)
                {
                    break MISSING_BLOCK_LABEL_320;
                }
                ListModel listmodel;
                int i;
                try
                {
                    avoid = new JSONObject(avoid);
                    inponsel = avoid.getJSONArray("InPonsel");
                    suc = avoid.getString("success");
                    stat = avoid.getString("stat");
                    count_first_HPForum = avoid.getInt("count_first");
                    count_all_HPForum = avoid.getInt("count_all");
                    Log.e("suc", suc);
                    counterArray = 0;
                    if (!suc.equals("1"))
                    {
                        break MISSING_BLOCK_LABEL_327;
                    }
                    ForumHpArray.clear();
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_327;
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_327;
                }
                i = 0;
            }
            if (i >= inponsel.length())
            {
                break MISSING_BLOCK_LABEL_327;
            }
            avoid = IkutiForumPonsel.this;
            avoid.counterArray = ((IkutiForumPonsel) (avoid)).counterArray + 1;
            avoid = inponsel.getJSONObject(i);
            listmodel = new ListModel();
            listmodel.setId_hp(avoid.getString("id_hp"));
            listmodel.setModel(avoid.getString("model"));
            listmodel.setMerk(avoid.getString("merk"));
            listmodel.setCodename(avoid.getString("codename"));
            listmodel.setGambar(avoid.getString("gambar"));
            listmodel.setUmu_status("");
            listmodel.setHrg_baru("");
            listmodel.setHrg_bekas("");
            ForumHpArray.add(listmodel);
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
                Log.e("ForumHpArray", String.valueOf(ForumHpArray.size()));
                Log.e("dataForumPonsel", dataForumPonsel);
                Log.e("ForumHpArray", String.valueOf(ForumHpArray.size()));
                ForumHpAdapter.notifyDataSetChanged();
                Log.e("counterArray", String.valueOf(ForumHpArray.size()));
            }
            // Misplaced declaration of an exception variable
            catch (Void void1) { }
            progressbar_middle.setVisibility(8);
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            progressbar_middle.setVisibility(0);
        }

        private FavoritHPTask()
        {
            this$0 = IkutiForumPonsel.this;
            super();
        }

        FavoritHPTask(FavoritHPTask favorithptask)
        {
            this();
        }
    }

    private class FavoritSearchTask extends AsyncTask
    {

        final IkutiForumPonsel this$0;

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
            avoid = IkutiForumPonsel.this;
            avoid.counterArray = ((IkutiForumPonsel) (avoid)).counterArray + 1;
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
            this$0 = IkutiForumPonsel.this;
            super();
        }

        FavoritSearchTask(FavoritSearchTask favoritsearchtask)
        {
            this();
        }
    }

    public class ListForumHpAdapter extends BaseAdapter
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
        final IkutiForumPonsel this$0;
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

                        final ListForumHpAdapter this$1;
                        private final ListForumHpAdapter.ViewHolder val$holder;

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
                this$1 = final_listforumhpadapter;
                holder = ListForumHpAdapter.ViewHolder.this;
                super();
            }
                    });
                }
                catch (Exception exception) { }
                ((ViewHolder) (viewgroup)).leftdel.setOnClickListener(i. new android.view.View.OnClickListener() {

                    final ListForumHpAdapter this$1;
                    private final int val$position;

                    public void onClick(View view)
                    {
                        id_hp_del = getListModel(position).getId_hp();
                        codename = getListModel(position).getCodename();
                        Log.e("id_hp_del", id_hp_del);
                        view = new android.app.AlertDialog.Builder(_fld0);
                        view.setTitle("Peringatan");
                        view.setMessage("Hapus perangkat ini dari favorit?");
                        view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                            final ListForumHpAdapter._cls2 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                statdel = "0";
                                if (netInfo != null && netInfo.isConnected())
                                {
                                    (new ListForumHpAdapter.AddDelFavoritHPTask()).execute(new Void[0]);
                                    return;
                                } else
                                {
                                    Toast.makeText(_fld0, "Tidak ada koneksi internet", 1).show();
                                    return;
                                }
                            }

            
            {
                this$2 = ListForumHpAdapter._cls2.this;
                super();
            }
                        });
                        view.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                            final ListForumHpAdapter._cls2 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = ListForumHpAdapter._cls2.this;
                super();
            }
                        });
                        view.show();
                    }


            
            {
                this$1 = final_listforumhpadapter;
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


        public ListForumHpAdapter(Activity activity1, int i, ArrayList arraylist)
        {
            this$0 = IkutiForumPonsel.this;
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
                imageLoader2.init(ImageLoaderConfiguration.createDefault(IkutiForumPonsel.this));
                options = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showImageForEmptyUri(0x7f020208).cacheInMemory(true).imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).build();
                userFunctions = new UserFunctions();
                db = new DatabaseHandler(activity1);
                t = Utility.session(t);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (IkutiForumPonsel ikutiforumponsel)
            {
                return;
            }
        }
    }

    public class ListForumHpAdapter.AddDelFavoritHPTask extends AsyncTask
    {

        final ListForumHpAdapter this$1;

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
                querydel = (new StringBuilder("idhp=")).append(id_hp_del).append("&idusr=").append(user_id).append("&idconv=").append(codename).append("&stat=0").append("&type=").append("all").append("&t=").append(t).toString();
                pushURLdel = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("add_subscribe_artikel").append(Utility.BASE_FORMAT).append("?").append(querydel).toString();
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
            try
            {
                if (postStatusSubsNews.equals("1") || postStatusSubsNews.equals("10"))
                {
                    mDialog.dismiss();
                    Toast.makeText(_fld0, postMessageSubsNews, 1).show();
                    FavoritHPTask();
                    ponselBaseApp.getObserver().setUpdateType("sidemenufav");
                    ponselBaseApp.getObserver().setLoginStat("1");
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
            if (postStatusSubsNews.equals("00") || postStatusSubsNews.equals("0"))
            {
                Toast.makeText(_fld0, postMessageSubsNews, 1).show();
                ForumHpAdapter.notifyDataSetChanged();
                mDialog.dismiss();
                return;
            }
            if (postStatusSubsNews.equals("40404"))
            {
                Toast.makeText(_fld0, postMessageSubsNews, 1).show();
                mDialog.dismiss();
                return;
            }
            Toast.makeText(_fld0, postMessageSubsNews, 1).show();
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

        public ListForumHpAdapter.AddDelFavoritHPTask()
        {
            this$1 = ListForumHpAdapter.this;
            super();
        }
    }

    class ListForumHpAdapter.ViewHolder
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
        final ListForumHpAdapter this$1;

        ListForumHpAdapter.ViewHolder()
        {
            this$1 = ListForumHpAdapter.this;
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
        final IkutiForumPonsel this$0;
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
                        view.setMessage("Ikuti aktifitas forum ponsel ini?");
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
                                    Toast.makeText(_fld0, "Tidak ada koneksi internet", 1).show();
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
            this$0 = IkutiForumPonsel.this;
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
                imageLoader2.init(ImageLoaderConfiguration.createDefault(IkutiForumPonsel.this));
                options = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showImageForEmptyUri(0x7f020208).cacheInMemory(true).imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).build();
                userFunctions = new UserFunctions();
                db = new DatabaseHandler(activity1);
                t = Utility.session(t);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (IkutiForumPonsel ikutiforumponsel)
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
            try
            {
                querydel = (new StringBuilder("idhp=")).append(id_hp_del).append("&idusr=").append(user_id).append("&type=").append("all").append("&stat=1").append("&t=").append(t).toString();
                pushURLdel = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("add_subscribe_artikel").append(Utility.BASE_FORMAT).append("?").append(querydel).toString();
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
            mDialog.dismiss();
            dialog.dismiss();
            try
            {
                if (postStatusSubsNews.equals("1") || postStatusSubsNews.equals("10"))
                {
                    Toast.makeText(_fld0, postMessageSubsNews, 1).show();
                    FavoritHPTask();
                    ponselBaseApp.getObserver().setUpdateType("sidemenufav");
                    ponselBaseApp.getObserver().setLoginStat("1");
                    mDialog.dismiss();
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
            if (postStatusSubsNews.equals("00") || postStatusSubsNews.equals("0"))
            {
                Toast.makeText(_fld0, postMessageSubsNews, 1).show();
                mDialog.dismiss();
                return;
            }
            if (postStatusSubsNews.equals("40404"))
            {
                mDialog.dismiss();
                return;
            }
            Toast.makeText(_fld0, postMessageSubsNews, 1).show();
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


    ListForumHpAdapter ForumHpAdapter;
    ArrayList ForumHpArray;
    ActionBar actionBar;
    int actionBarTitleId;
    Button btnSubmitHp;
    ConnectivityManager cm;
    String codename;
    int count_all_HPForum;
    int count_first_HPForum;
    int counterArray;
    Cursor cursor;
    String dataForumPonsel;
    String dataSearch;
    DatabaseHandler db;
    Dialog dialog;
    EditText edtAuto;
    EditText edtHpKetik;
    String email_user;
    String gambar;
    String id_hp_del;
    String id_hph;
    JSONArray inponsel;
    ListView listFindDev;
    ExpandableHeightGridView listPendatang;
    ListSearchAdapter listSearchAdapter;
    ArrayList listSearchArrayList;
    String merk;
    String model;
    String nama_asli;
    String namalengkap;
    NetworkInfo netInfo;
    PonselBaseApp ponselBaseApp;
    String postMessageSubsNews;
    String postStatusSubsNews;
    ProgressBar progressbar_middle;
    ProgressBar progressbar_search;
    String pushURL;
    String pushURLdel;
    String querydel;
    String resdel;
    String stat;
    String statdel;
    String statusdel;
    String suc;
    String t;
    TextView txtFavDevice;
    TextView txt_empty;
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

    public IkutiForumPonsel()
    {
        id_hp_del = "";
        dataSearch = "";
        ForumHpArray = null;
        inponsel = null;
        suc = "";
        stat = "";
        count_first_HPForum = 0;
        count_all_HPForum = 0;
        user_photo = "";
        username = "";
        t = Utility.session(RestClient.pelihara);
        useLogo = false;
        actionBarTitleId = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        pushURL = "";
        listSearchArrayList = null;
        uni_type = "";
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

    public void FavoritHPTask()
    {
        dataForumPonsel = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("user_ikutiforum_hp").append(Utility.BASE_FORMAT).append("?t=").append(t).append("&id_user=").append(user_id).append("&lmt=1").toString();
        Log.e("dataForumPonsel", dataForumPonsel);
        FavoritHPTask favorithptask = new FavoritHPTask(null);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            favorithptask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            favorithptask.execute(new Void[0]);
            return;
        }
    }

    public void FavoritSearchTask(String s)
    {
        dataSearch = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("list_favorit_union").append(Utility.BASE_FORMAT).append("?id_user=").append(user_id).append("&key=").append(s).append("&sort=hp").append("&t=").append(t).toString();
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

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300ea);
        ponselBaseApp = (PonselBaseApp)getApplication();
        ponselBaseApp.getObserver().addObserver(this);
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            setTranslucentStatus(true);
        }
        bundle = new SystemBarTintManager(this);
        bundle.setStatusBarTintEnabled(true);
        bundle.setStatusBarTintResource(0x7f080160);
        wrapperLight = new ContextThemeWrapper(this, 0x103006e);
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
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFFFFF'>Forum Diikuti</font>"));
        bundle = (TextView)findViewById(i);
        bundle.setSelected(true);
        bundle.setTextColor(Color.parseColor("#FFFFFF"));
        bundle.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        t = Utility.session(t);
        cm = (ConnectivityManager)getSystemService("connectivity");
        netInfo = cm.getActiveNetworkInfo();
        userFunctions = new UserFunctions();
        db = new DatabaseHandler(this);
        t = Utility.session(t);
        ForumHpArray = new ArrayList();
        progressbar_middle = (ProgressBar)findViewById(0x7f0b00ca);
        listPendatang = (ExpandableHeightGridView)findViewById(0x7f0b052e);
        listPendatang.setExpanded(true);
        txt_empty = (TextView)findViewById(0x7f0b0093);
        txtFavDevice = (TextView)findViewById(0x7f0b06d6);
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
        ForumHpAdapter = new ListForumHpAdapter(this, 0x7f03011d, ForumHpArray);
        listPendatang.setAdapter(ForumHpAdapter);
        FavoritHPTask();
        listPendatang.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final IkutiForumPonsel this$0;

            public void onItemClick(AdapterView adapterview, View view, int k, long l)
            {
                listPendatang.playSoundEffect(0);
                adapterview = new Intent(IkutiForumPonsel.this, com/inponsel/android/tlforum/ForumHPActivity);
                adapterview.putExtra("id_hph", ForumHpAdapter.getListModel(k).getId_hp());
                adapterview.putExtra("namalengkap", (new StringBuilder(String.valueOf(ForumHpAdapter.getListModel(k).getMerk()))).append(" ").append(ForumHpAdapter.getListModel(k).getModel()).toString());
                adapterview.putExtra("codename", ForumHpAdapter.getListModel(k).getCodename());
                adapterview.putExtra("model", ForumHpAdapter.getListModel(k).getModel());
                adapterview.putExtra("merk", ForumHpAdapter.getListModel(k).getMerk());
                adapterview.putExtra("gambar", ForumHpAdapter.getListModel(k).getGambar());
                startActivityForResult(adapterview, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = IkutiForumPonsel.this;
                super();
            }
        });
        txtFavDevice.setOnClickListener(new android.view.View.OnClickListener() {

            final IkutiForumPonsel this$0;

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
                listSearchAdapter = new ListSearchAdapter(IkutiForumPonsel.this, 0x7f0300c2, listSearchArrayList);
                listFindDev.setAdapter(listSearchAdapter);
                edtAuto.setSingleLine(true);
                edtAuto.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

                    final _cls2 this$1;

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
                this$1 = _cls2.this;
                super();
            }
                });
                edtAuto.addTextChangedListener(new DelayedTextWatcher(2000L) {

                    final _cls2 this$1;

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
                this$1 = _cls2.this;
                super(l);
            }
                });
                dialog = builder.create();
                dialog.show();
            }


            
            {
                this$0 = IkutiForumPonsel.this;
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
