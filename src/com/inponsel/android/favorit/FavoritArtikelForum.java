// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.favorit;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.timelinedetail.Hal1TLDetailActivity;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.widget.ExpandableHeightGridView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FavoritArtikelForum extends SherlockFragmentActivity
    implements Observer
{
    private class FavoritHPTask extends AsyncTask
    {

        final FavoritArtikelForum this$0;

        private void parseJSONLangganan(String s)
        {
            int i;
            try
            {
                s = new JSONObject(s);
                jArray = s.getJSONArray("InPonsel");
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
            if (!db.checkTimelineExist(s.getString("id")))
            {
                db.addArtTanya(s.getString("id"), s.getString("id_hp"), s.getString("merk"), s.getString("model"), s.getString("codename"), s.getString("judul"), s.getString("type"), s.getString("tag"), s.getString("img_url"), s.getString("content"), s.getString("content_ext"), s.getString("date"));
            }
            i++;
            if (false)
            {
            } else
            {
                break MISSING_BLOCK_LABEL_24;
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
                avoid = HttpPush.getResponse(dataFav);
                Log.e("push", (new StringBuilder(String.valueOf(avoid))).append(dataFav).toString());
                avoid = avoid.toString();
                Log.e("url ", avoid);
                parseJSONLangganan(avoid);
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
            layout_empty.setVisibility(8);
            loadFromDB();
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            layout_empty.setVisibility(0);
            if (netInfo != null && netInfo.isConnected())
            {
                db.resetTLTables();
            }
        }

        private FavoritHPTask()
        {
            this$0 = FavoritArtikelForum.this;
            super();
        }

        FavoritHPTask(FavoritHPTask favorithptask)
        {
            this();
        }
    }

    public class FavoritTask extends AsyncTask
    {

        final FavoritArtikelForum this$0;

        private void parseJSONDel(String s)
        {
            try
            {
                s = new JSONObject(s);
                postStatusDelTL = s.getString("success");
                postMessageDelTL = s.getString("message");
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
                avoid = (new StringBuilder("idartanya=")).append(id_tl).append("&idusr=").append(FavoritArtikelForum.user_id).append("&stat=").append("0").append("&type=").append(id_type).append("&t=").append(t).toString();
                String s = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("add_favartanya").append(Utility.BASE_FORMAT).append("?").append(avoid).toString();
                Log.e("pushURL", s);
                s = HttpPush.getResponse(s);
                Log.e("push", (new StringBuilder(String.valueOf(s))).append(avoid).toString());
                parseJSONDel(s.toString());
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
            if (postStatusDelTL.equals("1"))
            {
                db.delete_TLbyID(id_tl);
                onResume();
            }
            mDialog.dismiss();
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            mDialog = ProgressDialog.show(FavoritArtikelForum.this, "", "Menghapus...", true);
            mDialog.setCancelable(true);
            mDialog.show();
        }

        public FavoritTask()
        {
            this$0 = FavoritArtikelForum.this;
            super();
        }
    }

    public class ListTanyaAdapter extends BaseAdapter
    {

        private Activity activity;
        Context context;
        Cursor cursor;
        DatabaseHandler db;
        String email_user;
        String finalUrl;
        DecimalFormat fmt;
        DecimalFormatSymbols fmts;
        String komen;
        private ArrayList lm;
        ListModel lms;
        ProgressDialog mDialog;
        String pathImage;
        int pos;
        String res;
        int resource;
        String response;
        String status;
        String t;
        final FavoritArtikelForum this$0;
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
                ((ViewHolder) (viewgroup)).bottom_list.setVisibility(8);
                ((ViewHolder) (viewgroup)).separator.setVisibility(8);
                ((ViewHolder) (viewgroup)).list_txtBigRight.setVisibility(8);
                ((ViewHolder) (viewgroup)).progressbar_item.setVisibility(8);
                ((ViewHolder) (viewgroup)).imageHp.setVisibility(0);
                ((ViewHolder) (viewgroup)).list_txtMerek.setText(lms.getRoom_title());
                ((ViewHolder) (viewgroup)).list_txtHarga.setText((new StringBuilder(String.valueOf(lms.getMerk()))).append(" ").append(lms.getModel()).toString());
                ((ViewHolder) (viewgroup)).list_txtHarga.setMaxLines(2);
                Log.e("pathImage", lms.getRoom_path_image());
                if (lms.getRoom_path_image() == null || lms.getRoom_path_image().equals(""))
                {
                    pathImage = "http://inponsel.com/images/avatar/ic_launcher_gray.png";
                } else
                {
                    pathImage = (new StringBuilder(String.valueOf(Util.BASE_URL_THUMB_ORI))).append("w=250&src=").append(lms.getRoom_path_image()).toString();
                }
                Log.e("pathImage", pathImage);
                Picasso.with(activity).load(pathImage).into(((ViewHolder) (viewgroup)).imageHp, viewgroup. new Callback() {

                    final ListTanyaAdapter this$1;
                    private final ListTanyaAdapter.ViewHolder val$holder;

                    public void onError()
                    {
                        holder.imageHp.setImageResource(0x7f0201b8);
                    }

                    public void onSuccess()
                    {
                    }

            
            {
                this$1 = final_listtanyaadapter;
                holder = ListTanyaAdapter.ViewHolder.this;
                super();
            }
                });
                ((ViewHolder) (viewgroup)).leftdel.setOnClickListener(i. new android.view.View.OnClickListener() {

                    final ListTanyaAdapter this$1;
                    private final int val$position;

                    public void onClick(View view)
                    {
                        id_del = getListModel(position).getId_content();
                        Log.e("id_hp_del", id_del);
                        view = new android.app.AlertDialog.Builder(_fld0);
                        view.setTitle("Peringatan");
                        view.setMessage("Hapus pertanyaan ini?");
                        view.setPositiveButton("Ya", position. new android.content.DialogInterface.OnClickListener() {

                            final ListTanyaAdapter._cls2 this$2;
                            private final int val$position;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                statdel = "0";
                                id_tl = getListModel(position).getId_content();
                                id_type = getListModel(position).getTl_type();
                                (new FavoritTask()).execute(new Void[0]);
                                onResume();
                            }

            
            {
                this$2 = final__pcls2;
                position = I.this;
                super();
            }
                        });
                        view.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                            final ListTanyaAdapter._cls2 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = ListTanyaAdapter._cls2.this;
                super();
            }
                        });
                        view.show();
                    }


            
            {
                this$1 = final_listtanyaadapter;
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


        public ListTanyaAdapter(Activity activity1, int i, ArrayList arraylist)
        {
            this$0 = FavoritArtikelForum.this;
            super();
            fmt = new DecimalFormat();
            fmts = new DecimalFormatSymbols();
            t = Utility.session(RestClient.pelihara);
            username = "";
            user = "";
            komen = "";
            email_user = "";
            finalUrl = "";
            pathImage = "";
            t = Utility.session(t);
            lm = arraylist;
            activity = activity1;
            resource = i;
            try
            {
                userFunctions = new UserFunctions();
                db = new DatabaseHandler(activity1);
                t = Utility.session(t);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (FavoritArtikelForum favoritartikelforum)
            {
                return;
            }
        }
    }

    class ListTanyaAdapter.ViewHolder
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
        final ListTanyaAdapter this$1;

        ListTanyaAdapter.ViewHolder()
        {
            this$1 = ListTanyaAdapter.this;
            super();
        }
    }

    public class ListartikelAdapter extends BaseAdapter
    {

        private Activity activity;
        Context context;
        Cursor cursor;
        DatabaseHandler db;
        String email_user;
        String finalUrl;
        DecimalFormat fmt;
        DecimalFormatSymbols fmts;
        String komen;
        private ArrayList lm;
        ListModel lms;
        ProgressDialog mDialog;
        String pathImage;
        int pos;
        String res;
        int resource;
        String response;
        String status;
        String t;
        final FavoritArtikelForum this$0;
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
                ((ViewHolder) (viewgroup)).bottom_list.setVisibility(8);
                ((ViewHolder) (viewgroup)).separator.setVisibility(8);
                ((ViewHolder) (viewgroup)).list_txtBigRight.setVisibility(8);
                ((ViewHolder) (viewgroup)).progressbar_item.setVisibility(8);
                ((ViewHolder) (viewgroup)).imageHp.setVisibility(0);
                ((ViewHolder) (viewgroup)).list_txtMerek.setText(lms.getRoom_title());
                ((ViewHolder) (viewgroup)).list_txtHarga.setText((new StringBuilder(String.valueOf(lms.getMerk()))).append(" ").append(lms.getModel()).toString());
                ((ViewHolder) (viewgroup)).list_txtHarga.setMaxLines(2);
                Log.e("pathImage", lms.getRoom_path_image());
                if (lms.getRoom_path_image() == null || lms.getRoom_path_image().equals(""))
                {
                    pathImage = "http://inponsel.com/images/avatar/ic_launcher_gray.png";
                } else
                {
                    pathImage = (new StringBuilder(String.valueOf(Util.BASE_URL_THUMB_ORI))).append("w=250&src=").append(lms.getRoom_path_image()).toString();
                }
                Log.e("pathImage", pathImage);
                Picasso.with(activity).load(pathImage).into(((ViewHolder) (viewgroup)).imageHp, viewgroup. new Callback() {

                    final ListartikelAdapter this$1;
                    private final ListartikelAdapter.ViewHolder val$holder;

                    public void onError()
                    {
                        holder.imageHp.setImageResource(0x7f0201b8);
                    }

                    public void onSuccess()
                    {
                    }

            
            {
                this$1 = final_listartikeladapter;
                holder = ListartikelAdapter.ViewHolder.this;
                super();
            }
                });
                ((ViewHolder) (viewgroup)).leftdel.setOnClickListener(i. new android.view.View.OnClickListener() {

                    final ListartikelAdapter this$1;
                    private final int val$position;

                    public void onClick(View view)
                    {
                        id_del = getListModel(position).getId_content();
                        Log.e("id_hp_del", id_del);
                        view = new android.app.AlertDialog.Builder(_fld0);
                        view.setTitle("Peringatan");
                        view.setMessage("Hapus artikel ini?");
                        view.setPositiveButton("Ya", position. new android.content.DialogInterface.OnClickListener() {

                            final ListartikelAdapter._cls2 this$2;
                            private final int val$position;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                statdel = "0";
                                id_tl = getListModel(position).getId_content();
                                id_type = getListModel(position).getTl_type();
                                (new FavoritTask()).execute(new Void[0]);
                                onResume();
                            }

            
            {
                this$2 = final__pcls2;
                position = I.this;
                super();
            }
                        });
                        view.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                            final ListartikelAdapter._cls2 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = ListartikelAdapter._cls2.this;
                super();
            }
                        });
                        view.show();
                    }


            
            {
                this$1 = final_listartikeladapter;
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


        public ListartikelAdapter(Activity activity1, int i, ArrayList arraylist)
        {
            this$0 = FavoritArtikelForum.this;
            super();
            fmt = new DecimalFormat();
            fmts = new DecimalFormatSymbols();
            t = Utility.session(RestClient.pelihara);
            username = "";
            user = "";
            komen = "";
            email_user = "";
            finalUrl = "";
            pathImage = "";
            t = Utility.session(t);
            lm = arraylist;
            activity = activity1;
            resource = i;
            try
            {
                userFunctions = new UserFunctions();
                db = new DatabaseHandler(activity1);
                t = Utility.session(t);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (FavoritArtikelForum favoritartikelforum)
            {
                return;
            }
        }
    }

    class ListartikelAdapter.ViewHolder
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
        final ListartikelAdapter this$1;

        ListartikelAdapter.ViewHolder()
        {
            this$1 = ListartikelAdapter.this;
            super();
        }
    }


    public static String email_user;
    public static String nama_asli;
    public static String user_id;
    public static String user_jekel;
    public static String user_joindate;
    public static String user_kota;
    public static String user_photo = "";
    public static String user_ponsel1;
    public static String user_ponsel2;
    public static String user_profile_update;
    public static String user_provider1;
    public static String user_provider2;
    public static String user_provinsi;
    public static String user_ttl;
    public static String username = "";
    ActionBar actionBar;
    int actionBarTitleId;
    ListartikelAdapter artikelAdapter;
    ArrayList artikelArray;
    ListartikelAdapter benchmarkAdapter;
    ArrayList benchmarkArray;
    ConnectivityManager cm;
    String codename;
    String content;
    String content_ext;
    Cursor cursor;
    String dataFav;
    String date;
    DatabaseHandler db;
    String id_content;
    String id_del;
    String id_hp;
    String id_tl;
    String id_type;
    ImageLoader imageLoader2;
    JSONArray jArray;
    ListartikelAdapter kameraAdapter;
    ArrayList kameraArray;
    LinearLayout layout_empty;
    ExpandableHeightGridView list_Artikel;
    ExpandableHeightGridView list_Tanya;
    ExpandableHeightGridView list_hasilbenchmark;
    ExpandableHeightGridView list_hasilkamera;
    ImageLoaderConfiguration loaderConfiguration;
    ProgressDialog mDialog;
    String merk;
    String model;
    NetworkInfo netInfo;
    DisplayImageOptions options;
    String path_image;
    PonselBaseApp ponselBaseApp;
    String postMessageDelTL;
    String postStatusDelTL;
    ProgressBar progressbar_Artikel;
    ProgressBar progressbar_Tanya;
    ProgressBar progressbar_hasilbenchmark;
    ProgressBar progressbar_hasilkamera;
    String statdel;
    String t;
    String tag_artikel;
    ListTanyaAdapter tanyaAdapter;
    ArrayList tanyaArray;
    String title;
    String tl_type;
    TextView txt_empty_Artikel;
    TextView txt_empty_Tanya;
    TextView txt_empty_hasilbenchmark;
    TextView txt_empty_hasilkamera;
    private boolean useLogo;
    UserFunctions userFunctions;
    ContextThemeWrapper wrapperLight;

    public FavoritArtikelForum()
    {
        id_del = "";
        statdel = "";
        artikelArray = null;
        tanyaArray = null;
        kameraArray = null;
        benchmarkArray = null;
        postStatusDelTL = "";
        postMessageDelTL = "";
        id_tl = "";
        id_type = "";
        dataFav = "";
        t = Utility.session(RestClient.pelihara);
        useLogo = false;
        actionBarTitleId = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
    }

    private void loadFromDB()
    {
        artikelArray = loadArtikelDB();
        artikelAdapter = new ListartikelAdapter(this, 0x7f03011d, artikelArray);
        list_Artikel.setAdapter(artikelAdapter);
        loadDataArtikel();
        tanyaArray = loadTanyaHPDB();
        tanyaAdapter = new ListTanyaAdapter(this, 0x7f03011d, tanyaArray);
        list_Tanya.setAdapter(tanyaAdapter);
        loadTanyaHPDB();
        kameraArray = loadKameraDB();
        kameraAdapter = new ListartikelAdapter(this, 0x7f03011d, kameraArray);
        list_hasilkamera.setAdapter(kameraAdapter);
        loadDataHasilkamera();
        benchmarkArray = loadBenchmarkDB();
        benchmarkAdapter = new ListartikelAdapter(this, 0x7f03011d, benchmarkArray);
        list_hasilbenchmark.setAdapter(benchmarkAdapter);
        loadDataHasilBenchmark();
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
        dataFav = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("list_fav_timeline").append(Utility.BASE_FORMAT).append("?id_user=").append(user_id).append("&t=").append(t).toString();
        Log.e("dataFav", dataFav);
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

    public ArrayList loadArtikelDB()
    {
        ArrayList arraylist;
        Cursor cursor1;
        arraylist = new ArrayList();
        cursor1 = db.getTIMELINEData("artikel");
        if (!cursor1.moveToFirst()) goto _L2; else goto _L1
_L1:
        do
        {
            id_content = cursor1.getString(cursor1.getColumnIndex("id_content"));
            Log.e("getColumnIndex", id_content);
            id_hp = cursor1.getString(cursor1.getColumnIndex("id_hp"));
            merk = cursor1.getString(cursor1.getColumnIndex("merk"));
            model = cursor1.getString(cursor1.getColumnIndex("model"));
            codename = cursor1.getString(cursor1.getColumnIndex("codename"));
            title = cursor1.getString(cursor1.getColumnIndex("title"));
            tag_artikel = cursor1.getString(cursor1.getColumnIndex("tag"));
            path_image = cursor1.getString(cursor1.getColumnIndex("image"));
            content = cursor1.getString(cursor1.getColumnIndex("content"));
            content_ext = cursor1.getString(cursor1.getColumnIndex("ext"));
            tl_type = cursor1.getString(cursor1.getColumnIndex("type"));
            date = cursor1.getString(cursor1.getColumnIndex("date"));
            ListModel listmodel = new ListModel();
            listmodel.setId_content(id_content);
            listmodel.setId_hp(id_hp);
            listmodel.setMerk(merk);
            listmodel.setModel(model);
            listmodel.setCodename(codename);
            listmodel.setRoom_title(title);
            listmodel.setTag_artikel(tag_artikel);
            listmodel.setRoom_path_image(path_image);
            listmodel.setRoom_content(content);
            listmodel.setRoom_content_ext(content_ext);
            listmodel.setRoom_date(date);
            listmodel.setTl_type(tl_type);
            arraylist.add(listmodel);
        } while (cursor1.moveToNext());
        Log.e("bookmark", String.valueOf(arraylist.size()));
        list_Artikel.setVisibility(0);
_L4:
        db.close();
        return arraylist;
_L2:
        try
        {
            Log.e("bookmark", "nol");
            progressbar_Artikel.setVisibility(8);
            txt_empty_Artikel.setVisibility(0);
            txt_empty_Artikel.setText("Belum ada artikel disimpan");
        }
        catch (Exception exception) { }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public ArrayList loadBenchmarkDB()
    {
        ArrayList arraylist;
        Cursor cursor1;
        arraylist = new ArrayList();
        cursor1 = db.getTIMELINEData("benchmark");
        if (!cursor1.moveToFirst()) goto _L2; else goto _L1
_L1:
        do
        {
            id_content = cursor1.getString(cursor1.getColumnIndex("id_content"));
            Log.e("getColumnIndex", id_content);
            id_hp = cursor1.getString(cursor1.getColumnIndex("id_hp"));
            merk = cursor1.getString(cursor1.getColumnIndex("merk"));
            model = cursor1.getString(cursor1.getColumnIndex("model"));
            codename = cursor1.getString(cursor1.getColumnIndex("codename"));
            title = cursor1.getString(cursor1.getColumnIndex("title"));
            tag_artikel = cursor1.getString(cursor1.getColumnIndex("tag"));
            path_image = cursor1.getString(cursor1.getColumnIndex("image"));
            content = cursor1.getString(cursor1.getColumnIndex("content"));
            content_ext = cursor1.getString(cursor1.getColumnIndex("ext"));
            tl_type = cursor1.getString(cursor1.getColumnIndex("type"));
            date = cursor1.getString(cursor1.getColumnIndex("date"));
            ListModel listmodel = new ListModel();
            listmodel.setId_content(id_content);
            listmodel.setId_hp(id_hp);
            listmodel.setMerk(merk);
            listmodel.setModel(model);
            listmodel.setCodename(codename);
            listmodel.setRoom_title(title);
            listmodel.setTag_artikel(tag_artikel);
            listmodel.setRoom_path_image(path_image);
            listmodel.setRoom_content(content);
            listmodel.setRoom_content_ext(content_ext);
            listmodel.setRoom_date(date);
            listmodel.setTl_type(tl_type);
            arraylist.add(listmodel);
        } while (cursor1.moveToNext());
        Log.e("bookmark", String.valueOf(arraylist.size()));
        list_hasilbenchmark.setVisibility(0);
_L4:
        db.close();
        return arraylist;
_L2:
        try
        {
            Log.e("bookmark", "nol");
            progressbar_hasilbenchmark.setVisibility(8);
            txt_empty_hasilbenchmark.setVisibility(0);
            txt_empty_hasilbenchmark.setText("Belum ada hasil benchmark disimpan");
        }
        catch (Exception exception) { }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void loadDataArtikel()
    {
        if (artikelArray.size() == 0)
        {
            txt_empty_Artikel.setVisibility(0);
            txt_empty_Artikel.setText("Belum ada artikel disimpan");
        } else
        {
            txt_empty_Artikel.setVisibility(8);
        }
        progressbar_Artikel.setVisibility(8);
    }

    public void loadDataHasilBenchmark()
    {
        if (benchmarkArray.size() == 0)
        {
            txt_empty_hasilbenchmark.setVisibility(0);
            txt_empty_hasilbenchmark.setText("Belum ada hasil benchmark disimpan");
        } else
        {
            txt_empty_hasilbenchmark.setVisibility(8);
        }
        progressbar_hasilbenchmark.setVisibility(8);
    }

    public void loadDataHasilkamera()
    {
        if (kameraArray.size() == 0)
        {
            txt_empty_hasilkamera.setVisibility(0);
            txt_empty_hasilkamera.setText("Belum ada hasil kamera disimpan");
        } else
        {
            txt_empty_hasilkamera.setVisibility(8);
        }
        progressbar_hasilkamera.setVisibility(8);
    }

    public void loadDataTanyaHP()
    {
        if (tanyaArray.size() == 0)
        {
            txt_empty_Tanya.setVisibility(0);
            txt_empty_Tanya.setText("Belum ada pertanyaan disimpan");
        } else
        {
            txt_empty_Tanya.setVisibility(8);
        }
        progressbar_Tanya.setVisibility(8);
    }

    public ArrayList loadKameraDB()
    {
        ArrayList arraylist;
        Cursor cursor1;
        arraylist = new ArrayList();
        cursor1 = db.getTIMELINEData("hasilkamera");
        if (!cursor1.moveToFirst()) goto _L2; else goto _L1
_L1:
        do
        {
            id_content = cursor1.getString(cursor1.getColumnIndex("id_content"));
            Log.e("getColumnIndex", id_content);
            id_hp = cursor1.getString(cursor1.getColumnIndex("id_hp"));
            merk = cursor1.getString(cursor1.getColumnIndex("merk"));
            model = cursor1.getString(cursor1.getColumnIndex("model"));
            codename = cursor1.getString(cursor1.getColumnIndex("codename"));
            title = cursor1.getString(cursor1.getColumnIndex("title"));
            tag_artikel = cursor1.getString(cursor1.getColumnIndex("tag"));
            path_image = cursor1.getString(cursor1.getColumnIndex("image"));
            content = cursor1.getString(cursor1.getColumnIndex("content"));
            content_ext = cursor1.getString(cursor1.getColumnIndex("ext"));
            tl_type = cursor1.getString(cursor1.getColumnIndex("type"));
            date = cursor1.getString(cursor1.getColumnIndex("date"));
            ListModel listmodel = new ListModel();
            listmodel.setId_content(id_content);
            listmodel.setId_hp(id_hp);
            listmodel.setMerk(merk);
            listmodel.setModel(model);
            listmodel.setCodename(codename);
            listmodel.setRoom_title(title);
            listmodel.setTag_artikel(tag_artikel);
            listmodel.setRoom_path_image(path_image);
            listmodel.setRoom_content(content);
            listmodel.setRoom_content_ext(content_ext);
            listmodel.setRoom_date(date);
            listmodel.setTl_type(tl_type);
            arraylist.add(listmodel);
        } while (cursor1.moveToNext());
        Log.e("bookmark", String.valueOf(arraylist.size()));
        list_hasilkamera.setVisibility(0);
_L4:
        db.close();
        return arraylist;
_L2:
        try
        {
            Log.e("bookmark", "nol");
            progressbar_hasilkamera.setVisibility(8);
            txt_empty_hasilkamera.setVisibility(0);
            txt_empty_hasilkamera.setText("Belum ada hasil kamera disimpan");
        }
        catch (Exception exception) { }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public ArrayList loadTanyaHPDB()
    {
        ArrayList arraylist;
        Cursor cursor1;
        arraylist = new ArrayList();
        cursor1 = db.getTIMELINEData("faqhp");
        if (!cursor1.moveToFirst()) goto _L2; else goto _L1
_L1:
        do
        {
            id_content = cursor1.getString(cursor1.getColumnIndex("id_content"));
            Log.e("getColumnIndex", id_content);
            id_hp = cursor1.getString(cursor1.getColumnIndex("id_hp"));
            merk = cursor1.getString(cursor1.getColumnIndex("merk"));
            model = cursor1.getString(cursor1.getColumnIndex("model"));
            codename = cursor1.getString(cursor1.getColumnIndex("codename"));
            title = cursor1.getString(cursor1.getColumnIndex("title"));
            tag_artikel = cursor1.getString(cursor1.getColumnIndex("tag"));
            path_image = cursor1.getString(cursor1.getColumnIndex("image"));
            content = cursor1.getString(cursor1.getColumnIndex("content"));
            content_ext = cursor1.getString(cursor1.getColumnIndex("ext"));
            tl_type = cursor1.getString(cursor1.getColumnIndex("type"));
            date = cursor1.getString(cursor1.getColumnIndex("date"));
            ListModel listmodel = new ListModel();
            listmodel.setId_content(id_content);
            listmodel.setId_hp(id_hp);
            listmodel.setMerk(merk);
            listmodel.setModel(model);
            listmodel.setCodename(codename);
            listmodel.setRoom_title(title);
            listmodel.setTag_artikel(tag_artikel);
            listmodel.setRoom_path_image(path_image);
            listmodel.setRoom_content(content);
            listmodel.setRoom_content_ext(content_ext);
            listmodel.setRoom_date(date);
            listmodel.setTl_type(tl_type);
            arraylist.add(listmodel);
        } while (cursor1.moveToNext());
        Log.e("bookmark", String.valueOf(arraylist.size()));
        list_Tanya.setVisibility(0);
        txt_empty_Tanya.setVisibility(8);
_L4:
        db.close();
        return arraylist;
_L2:
        try
        {
            Log.e("bookmark", "nol");
            progressbar_Tanya.setVisibility(8);
            txt_empty_Tanya.setVisibility(0);
            txt_empty_Tanya.setText("Belum ada pertanyaan disimpan");
        }
        catch (Exception exception) { }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300e8);
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
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFFFFF'>Favorit Forum</font>"));
        bundle = (TextView)findViewById(i);
        bundle.setSelected(true);
        bundle.setTextColor(Color.parseColor("#FFFFFF"));
        bundle.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        db = new DatabaseHandler(this);
        userFunctions = new UserFunctions();
        t = Utility.session(t);
        cm = (ConnectivityManager)getSystemService("connectivity");
        netInfo = cm.getActiveNetworkInfo();
        ponselBaseApp = (PonselBaseApp)getApplication();
        ponselBaseApp.getObserver().addObserver(this);
        layout_empty = (LinearLayout)findViewById(0x7f0b0091);
        progressbar_Artikel = (ProgressBar)findViewById(0x7f0b06e1);
        progressbar_Artikel.setVisibility(8);
        progressbar_Tanya = (ProgressBar)findViewById(0x7f0b06e4);
        progressbar_Tanya.setVisibility(8);
        t = Utility.session(t);
        progressbar_hasilkamera = (ProgressBar)findViewById(0x7f0b06e7);
        progressbar_hasilkamera.setVisibility(8);
        progressbar_hasilbenchmark = (ProgressBar)findViewById(0x7f0b06ea);
        progressbar_hasilbenchmark.setVisibility(8);
        txt_empty_Tanya = (TextView)findViewById(0x7f0b06e5);
        txt_empty_Artikel = (TextView)findViewById(0x7f0b06e2);
        txt_empty_hasilkamera = (TextView)findViewById(0x7f0b06e8);
        txt_empty_hasilbenchmark = (TextView)findViewById(0x7f0b06eb);
        list_Artikel = (ExpandableHeightGridView)findViewById(0x7f0b06e3);
        list_Tanya = (ExpandableHeightGridView)findViewById(0x7f0b06e6);
        list_hasilkamera = (ExpandableHeightGridView)findViewById(0x7f0b06e9);
        list_hasilbenchmark = (ExpandableHeightGridView)findViewById(0x7f0b06ec);
        list_Artikel.setExpanded(true);
        list_Tanya.setExpanded(true);
        list_hasilkamera.setExpanded(true);
        list_hasilbenchmark.setExpanded(true);
        artikelArray = new ArrayList();
        tanyaArray = new ArrayList();
        kameraArray = new ArrayList();
        benchmarkArray = new ArrayList();
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
        layout_empty.setVisibility(0);
        FavoritHPTask();
        loadFromDB();
        list_Artikel.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final FavoritArtikelForum this$0;

            public void onItemClick(AdapterView adapterview, View view, int k, long l)
            {
                adapterview = new Intent(FavoritArtikelForum.this, com/inponsel/android/timelinedetail/Hal1TLDetailActivity);
                adapterview.putExtra("id_artanya", artikelAdapter.getListModel(k).getId_content());
                adapterview.putExtra("act", "fav");
                adapterview.putExtra("tl_judul", artikelAdapter.getListModel(k).getRoom_title());
                adapterview.putExtra("tl_content", artikelAdapter.getListModel(k).getRoom_content());
                adapterview.putExtra("tl_content_ext", artikelAdapter.getListModel(k).getRoom_content_ext());
                adapterview.putExtra("merk", artikelAdapter.getListModel(k).getMerk());
                adapterview.putExtra("model", artikelAdapter.getListModel(k).getModel());
                adapterview.putExtra("tl_codename", artikelAdapter.getListModel(k).getCodename());
                adapterview.putExtra("tl_date", artikelAdapter.getListModel(k).getRoom_date());
                adapterview.putExtra("tl_id", artikelAdapter.getListModel(k).getId_content());
                adapterview.putExtra("tl_id_hp", artikelAdapter.getListModel(k).getId_hp());
                adapterview.putExtra("tl_id_user", "");
                adapterview.putExtra("tl_img_url", artikelAdapter.getListModel(k).getRoom_path_image());
                adapterview.putExtra("tl_tag", artikelAdapter.getListModel(k).getTag_artikel());
                adapterview.putExtra("tl_type", artikelAdapter.getListModel(k).getTl_type());
                adapterview.putExtra("tl_username", "");
                adapterview.putExtra("tl_userphoto", "");
                adapterview.putExtra("total_like", "");
                adapterview.putExtra("fav_stat", "");
                adapterview.putExtra("like_stat", "");
                Log.e("tl_content_ext", "");
                startActivityForResult(adapterview, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = FavoritArtikelForum.this;
                super();
            }
        });
        list_hasilkamera.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final FavoritArtikelForum this$0;

            public void onItemClick(AdapterView adapterview, View view, int k, long l)
            {
                adapterview = new Intent(FavoritArtikelForum.this, com/inponsel/android/timelinedetail/Hal1TLDetailActivity);
                adapterview.putExtra("id_artanya", kameraAdapter.getListModel(k).getId_content());
                adapterview.putExtra("act", "fav");
                adapterview.putExtra("tl_judul", kameraAdapter.getListModel(k).getRoom_title());
                adapterview.putExtra("tl_content", kameraAdapter.getListModel(k).getRoom_content());
                adapterview.putExtra("tl_content_ext", kameraAdapter.getListModel(k).getRoom_content_ext());
                adapterview.putExtra("merk", kameraAdapter.getListModel(k).getMerk());
                adapterview.putExtra("model", kameraAdapter.getListModel(k).getModel());
                adapterview.putExtra("tl_codename", kameraAdapter.getListModel(k).getCodename());
                adapterview.putExtra("tl_date", kameraAdapter.getListModel(k).getRoom_date());
                adapterview.putExtra("tl_id", kameraAdapter.getListModel(k).getId_content());
                adapterview.putExtra("tl_id_hp", kameraAdapter.getListModel(k).getId_hp());
                adapterview.putExtra("tl_id_user", "");
                adapterview.putExtra("tl_img_url", kameraAdapter.getListModel(k).getRoom_path_image());
                adapterview.putExtra("tl_tag", kameraAdapter.getListModel(k).getTag_artikel());
                adapterview.putExtra("tl_type", kameraAdapter.getListModel(k).getTl_type());
                adapterview.putExtra("tl_username", "");
                adapterview.putExtra("tl_userphoto", "");
                adapterview.putExtra("total_like", "");
                adapterview.putExtra("fav_stat", "");
                adapterview.putExtra("like_stat", "");
                Log.e("tl_content_ext", "");
                startActivityForResult(adapterview, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = FavoritArtikelForum.this;
                super();
            }
        });
        list_hasilbenchmark.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final FavoritArtikelForum this$0;

            public void onItemClick(AdapterView adapterview, View view, int k, long l)
            {
                adapterview = new Intent(FavoritArtikelForum.this, com/inponsel/android/timelinedetail/Hal1TLDetailActivity);
                adapterview.putExtra("id_artanya", artikelAdapter.getListModel(k).getId_content());
                adapterview.putExtra("act", "fav");
                adapterview.putExtra("tl_judul", benchmarkAdapter.getListModel(k).getRoom_title());
                adapterview.putExtra("tl_content", benchmarkAdapter.getListModel(k).getRoom_content());
                adapterview.putExtra("tl_content_ext", benchmarkAdapter.getListModel(k).getRoom_content_ext());
                adapterview.putExtra("merk", benchmarkAdapter.getListModel(k).getMerk());
                adapterview.putExtra("model", benchmarkAdapter.getListModel(k).getModel());
                adapterview.putExtra("tl_codename", benchmarkAdapter.getListModel(k).getCodename());
                adapterview.putExtra("tl_date", benchmarkAdapter.getListModel(k).getRoom_date());
                adapterview.putExtra("tl_id", benchmarkAdapter.getListModel(k).getId_content());
                adapterview.putExtra("tl_id_hp", benchmarkAdapter.getListModel(k).getId_hp());
                adapterview.putExtra("tl_id_user", "");
                adapterview.putExtra("tl_img_url", benchmarkAdapter.getListModel(k).getRoom_path_image());
                adapterview.putExtra("tl_tag", benchmarkAdapter.getListModel(k).getTag_artikel());
                adapterview.putExtra("tl_type", benchmarkAdapter.getListModel(k).getTl_type());
                adapterview.putExtra("tl_username", "");
                adapterview.putExtra("tl_userphoto", "");
                adapterview.putExtra("total_like", "");
                adapterview.putExtra("fav_stat", "");
                adapterview.putExtra("like_stat", "");
                Log.e("tl_content_ext", "");
                startActivityForResult(adapterview, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = FavoritArtikelForum.this;
                super();
            }
        });
        list_Tanya.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final FavoritArtikelForum this$0;

            public void onItemClick(AdapterView adapterview, View view, int k, long l)
            {
                adapterview = new Intent(FavoritArtikelForum.this, com/inponsel/android/timelinedetail/Hal1TLDetailActivity);
                adapterview.putExtra("id_artanya", tanyaAdapter.getListModel(k).getId_content());
                adapterview.putExtra("act", "fav");
                adapterview.putExtra("tl_judul", tanyaAdapter.getListModel(k).getRoom_title());
                adapterview.putExtra("tl_content", tanyaAdapter.getListModel(k).getRoom_content());
                adapterview.putExtra("tl_content_ext", tanyaAdapter.getListModel(k).getRoom_content_ext());
                adapterview.putExtra("merk", tanyaAdapter.getListModel(k).getMerk());
                adapterview.putExtra("model", tanyaAdapter.getListModel(k).getModel());
                adapterview.putExtra("tl_codename", tanyaAdapter.getListModel(k).getCodename());
                adapterview.putExtra("tl_date", tanyaAdapter.getListModel(k).getRoom_date());
                adapterview.putExtra("tl_id", tanyaAdapter.getListModel(k).getId_content());
                adapterview.putExtra("tl_id_hp", tanyaAdapter.getListModel(k).getId_hp());
                adapterview.putExtra("tl_id_user", "");
                adapterview.putExtra("tl_img_url", tanyaAdapter.getListModel(k).getRoom_path_image());
                adapterview.putExtra("tl_tag", tanyaAdapter.getListModel(k).getTag_artikel());
                adapterview.putExtra("tl_type", tanyaAdapter.getListModel(k).getTl_type());
                adapterview.putExtra("tl_username", "");
                adapterview.putExtra("tl_userphoto", "");
                adapterview.putExtra("total_like", "");
                adapterview.putExtra("fav_stat", "");
                adapterview.putExtra("like_stat", "");
                Log.e("tl_content_ext", "");
                startActivityForResult(adapterview, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = FavoritArtikelForum.this;
                super();
            }
        });
        imageLoader2 = ImageLoader.getInstance();
        imageLoader2.init(ImageLoaderConfiguration.createDefault(this));
        options = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showImageForEmptyUri(0x7f020209).cacheInMemory(true).imageScaleType(ImageScaleType.EXACTLY).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).build();
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

    public void onResume()
    {
        super.onResume();
        loadFromDB();
    }

    public void update(Observable observable, Object obj)
    {
    }


}
