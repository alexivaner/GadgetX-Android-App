// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.text.Editable;
import android.text.Html;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.actionbarsherlock.ActionBarSherlock;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.google.android.gms.analytics.Tracker;
import com.inponsel.android.adapter.ListMerkAdapter;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.pencariangen.TabPencarian;
import com.inponsel.android.scdetail.SCDetailPager;
import com.inponsel.android.utils.Connectivity;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.DelayedTextWatcher;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.ServiceHandler;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.sherlock.navigationdrawer.compat.SherlockActionBarDrawerToggle;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            BaseDrawer

public class SCMoreActivity extends BaseDrawer
    implements android.view.View.OnClickListener, Observer
{
    public class ListPencarianAdapter extends BaseAdapter
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
        ImageLoader imageLoader2;
        String komen;
        private ArrayList lm;
        ListModel lms;
        ProgressDialog mDialog;
        String no_telp_array[];
        private DisplayImageOptions options;
        int pos;
        String res;
        int resource;
        String response;
        String status;
        String t;
        final SCMoreActivity this$0;
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
            if (view == null)
            {
                view = ((LayoutInflater)activity.getSystemService("layout_inflater")).inflate(resource, null);
                viewgroup = new ViewHolder();
                viewgroup.imageHp = (ImageView)view.findViewById(0x7f0b023d);
                viewgroup.list_txtMerek = (TextView)view.findViewById(0x7f0b033c);
                viewgroup.list_txtAlamat = (TextView)view.findViewById(0x7f0b033d);
                viewgroup.progressbar_item = (ProgressBar)view.findViewById(0x7f0b00b3);
                viewgroup.list_lay_like = (RelativeLayout)view.findViewById(0x7f0b0342);
                viewgroup.list_lay_dislike = (RelativeLayout)view.findViewById(0x7f0b0345);
                viewgroup.list_lay_kom = (RelativeLayout)view.findViewById(0x7f0b0348);
                viewgroup.headImage = (LinearLayout)view.findViewById(0x7f0b029f);
                view.setTag(viewgroup);
            } else
            {
                viewgroup = (ViewHolder)view.getTag();
            }
            lms = (ListModel)lm.get(i);
            if (lm != null)
            {
                ((ViewHolder) (viewgroup)).list_txtMerek.setText((new StringBuilder(String.valueOf(lms.getSc_merk()))).append(" ").append(lms.getSc_nama()).toString());
                ((ViewHolder) (viewgroup)).list_txtAlamat.setText((new StringBuilder(String.valueOf(lms.getSc_merk()))).append(" ").append(lms.getSc_nama()).toString());
                ((ViewHolder) (viewgroup)).list_txtAlamat.setSelected(true);
                no_telp_array = lms.getSc_no_telp().trim().split(",");
                ((ViewHolder) (viewgroup)).list_lay_like.setOnClickListener(new android.view.View.OnClickListener() {

                    final ListPencarianAdapter this$1;

                    public void onClick(View view)
                    {
                        view = new android.app.AlertDialog.Builder(_fld0);
                        view.setTitle("Nomor Telepon :");
                        view.setSingleChoiceItems(no_telp_array, -1, new android.content.DialogInterface.OnClickListener() {

                            final ListPencarianAdapter._cls1 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent("android.intent.action.DIAL", Uri.parse((new StringBuilder("tel: ")).append(no_telp_array[i].replaceAll("-", "")).toString()));
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = ListPencarianAdapter._cls1.this;
                super();
            }
                        });
                        view.show();
                    }


            
            {
                this$1 = ListPencarianAdapter.this;
                super();
            }
                });
                ((ViewHolder) (viewgroup)).list_lay_dislike.setOnClickListener(new android.view.View.OnClickListener() {

                    final ListPencarianAdapter this$1;

                    public void onClick(View view)
                    {
                    }

            
            {
                this$1 = ListPencarianAdapter.this;
                super();
            }
                });
                ((ViewHolder) (viewgroup)).list_lay_kom.setOnClickListener(new android.view.View.OnClickListener() {

                    final ListPencarianAdapter this$1;

                    public void onClick(View view)
                    {
                    }

            
            {
                this$1 = ListPencarianAdapter.this;
                super();
            }
                });
                imageLoader2.displayImage(lms.getSc_logo().trim(), ((ViewHolder) (viewgroup)).imageHp, options, animateFirstListener);
            }
            return view;
        }

        public void setListArray(ArrayList arraylist)
        {
            lm = arraylist;
        }


        public ListPencarianAdapter(Activity activity1, int i, ArrayList arraylist)
        {
            this$0 = SCMoreActivity.this;
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
            catch (SCMoreActivity scmoreactivity)
            {
                return;
            }
        }
    }

    class ListPencarianAdapter.ViewHolder
    {

        LinearLayout headImage;
        ImageView imageHp;
        RelativeLayout list_lay_dislike;
        RelativeLayout list_lay_kom;
        RelativeLayout list_lay_like;
        TextView list_txtAlamat;
        TextView list_txtMerek;
        ProgressBar progressbar_item;
        final ListPencarianAdapter this$1;

        ListPencarianAdapter.ViewHolder()
        {
            this$1 = ListPencarianAdapter.this;
            super();
        }
    }

    private class ProvinsiSync extends AsyncTask
    {

        final SCMoreActivity this$0;

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

        void log(String s)
        {
            Log.e("Near", s);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            super.onPostExecute(void1);
            merk_hp = new String[merkArray.size()];
            merk_hp = (String[])merkArray.toArray(merk_hp);
            merk_hpID = new String[merkArrayID.size()];
            merk_hpID = (String[])merkArrayID.toArray(merk_hpID);
            saveArray(merk_hp, "merkArray", getApplicationContext().getApplicationContext());
            saveArray(merk_hpID, "merkArrayID", getApplicationContext().getApplicationContext());
            progressbar_middle_dialog.setVisibility(8);
            jml = String.valueOf(listProvArrayList.size());
            if (!jml.equals("") && !jml.equals("0"))
            {
                break MISSING_BLOCK_LABEL_284;
            }
            txtEmpty.setText(0x7f0c0059);
_L1:
            log((new StringBuilder("lenght arrayList : ")).append(listProvArrayList.size()).toString());
            listMerkAdapter.setListArray(listProvArrayList);
            listMerkAdapter.notifyDataSetChanged();
            return;
            try
            {
                layout_empty.setVisibility(8);
                listHp.setVisibility(0);
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
              goto _L1
        }

        protected void onPreExcute()
        {
            super.onPreExecute();
        }

        void parseJSON(String s)
        {
            JSONObject jsonobject;
            ListModel listmodel;
            int i;
            try
            {
                s = new JSONObject(s);
                listProvArrayList = new ArrayList();
                s = s.getJSONArray("InPonsel");
                log((new StringBuilder("lenght: ")).append(s.length()).toString());
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                return;
            }
            i = 0;
            if (i >= s.length())
            {
                jml = String.valueOf(s.length());
                Log.e("jarray", jml);
                return;
            }
            jsonobject = s.getJSONObject(i);
            listmodel = new ListModel();
            listmodel.setMerk(jsonobject.getString("merk"));
            listmodel.setId_merk(jsonobject.getString("id_merk"));
            merk_ven = jsonobject.getString("merk");
            merk_venID = jsonobject.getString("id_merk");
            merkArray.add(merk_ven);
            merkArrayID.add(merk_venID);
            listProvArrayList.add(listmodel);
            i++;
            if (false)
            {
            } else
            {
                break MISSING_BLOCK_LABEL_56;
            }
        }

        private ProvinsiSync()
        {
            this$0 = SCMoreActivity.this;
            super();
        }

        ProvinsiSync(ProvinsiSync provinsisync)
        {
            this();
        }
    }

    private class SearchTask extends AsyncTask
    {

        final SCMoreActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            {
                avoid = (new ServiceHandler()).makeServiceCall(dataSearch, 1);
                Log.d("urlSearch", (new StringBuilder("> ")).append(dataSearch).toString());
                Log.d("Response: ", (new StringBuilder("> ")).append(avoid).toString());
                if (avoid == null)
                {
                    break MISSING_BLOCK_LABEL_453;
                }
                ListModel listmodel;
                int i;
                try
                {
                    avoid = new JSONObject(avoid);
                    suc = avoid.getString("success");
                    Log.e("suc", suc);
                    inponsel = avoid.getJSONArray("InPonsel");
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_462;
                }
                i = 0;
            }
            if (i >= inponsel.length())
            {
                break MISSING_BLOCK_LABEL_462;
            }
            avoid = inponsel.getJSONObject(i);
            listmodel = new ListModel();
            listmodel.setId_sc(avoid.getString("id_sc"));
            listmodel.setSc_nama(avoid.getString("sc_nama"));
            listmodel.setSc_merk(avoid.getString("sc_merk"));
            listmodel.setSc_fb(avoid.getString("sc_fb"));
            listmodel.setSc_ytube(avoid.getString("sc_ytube"));
            listmodel.setSc_fb_id(avoid.getString("sc_fb_id"));
            listmodel.setSc_tw(avoid.getString("sc_tw"));
            listmodel.setSc_logo((new StringBuilder(String.valueOf(Util.BASE_PATH_BRANDS))).append(avoid.getString("sc_logo")).toString());
            listmodel.setSc_ket_tambahan(avoid.getString("ket_tambahan"));
            listmodel.setSc_provinsi(avoid.getString("provinsi"));
            listmodel.setSc_kota(avoid.getString("kota"));
            listmodel.setSc_alamat(avoid.getString("alamat"));
            listmodel.setSc_no_telp(avoid.getString("no_telp"));
            listmodel.setSc_no_telp_ket(avoid.getString("no_telp_ket"));
            listmodel.setSc_c_center(avoid.getString("c_center"));
            listmodel.setSc_ven_center(avoid.getString("sc_c_center"));
            listmodel.setSc_email(avoid.getString("email"));
            listmodel.setSc_web_url(avoid.getString("web_url"));
            listmodel.setSc_rate(avoid.getString("sc_rateAvg"));
            listmodel.setSc_rate5(avoid.getString("sc_rate5"));
            listmodel.setSc_rate4(avoid.getString("sc_rate4"));
            listmodel.setSc_rate3(avoid.getString("sc_rate3"));
            listmodel.setSc_rate2(avoid.getString("sc_rate2"));
            listmodel.setSc_rate1(avoid.getString("sc_rate1"));
            listmodel.setSc_total_rate(avoid.getString("total_rate"));
            pencarianArray.add(listmodel);
            i++;
            if (true)
            {
                break MISSING_BLOCK_LABEL_120;
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
            Log.e("tasksdsurlSearch", dataSearch);
            Log.e("tasksdsurlSearch", String.valueOf(pencarianArray.size()));
            progressbar_middle.setVisibility(8);
            if (pencarianArray.size() != 0)
            {
                break MISSING_BLOCK_LABEL_129;
            }
            Log.e("listsc", "gone");
            listPencarianHp.setVisibility(8);
            layout_empty_sc.setVisibility(0);
            txt_empty_sc.setText("Service center belum tersedia");
_L1:
            pencarianAdapter.notifyDataSetChanged();
            getSherlock().setProgressBarIndeterminateVisibility(false);
            return;
            try
            {
                Log.e("listsc", "visible");
                listPencarianHp.setVisibility(0);
                layout_empty_sc.setVisibility(8);
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                void1.printStackTrace();
                return;
            }
              goto _L1
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            pencarianArray.clear();
            progressbar_middle.setVisibility(0);
        }

        private SearchTask()
        {
            this$0 = SCMoreActivity.this;
            super();
        }

        SearchTask(SearchTask searchtask)
        {
            this();
        }
    }


    public static android.content.SharedPreferences.Editor editor;
    public static SharedPreferences prefs;
    ActionBar actionBar;
    int actionBarTitleId;
    Button btnPencMerek;
    Cursor c;
    ConnectivityManager cm;
    int counterArray;
    String dataSearch;
    DatabaseHandler db;
    EditText edtAuto;
    Bundle extras;
    String getJson;
    JSONArray inponsel;
    String jml;
    LinearLayout layout_empty;
    LinearLayout layout_empty_sc;
    ListView listHp;
    ListMerkAdapter listMerkAdapter;
    ListView listPencarianHp;
    ArrayList listProvArrayList;
    Dialog mDialog;
    ArrayList merkArray;
    ArrayList merkArrayID;
    String merk_hp[];
    String merk_hpID[];
    String merk_ven;
    String merk_venID;
    ListPencarianAdapter pencarianAdapter;
    ArrayList pencarianArray;
    ProgressBar progressbar_middle;
    ProgressBar progressbar_middle_dialog;
    String strKey;
    String strPencMerek;
    String suc;
    String t;
    TextView txtEmpty;
    TextView txt_empty;
    TextView txt_empty_sc;
    private boolean useLogo;
    UserFunctions userFunctions;

    public SCMoreActivity()
    {
        useLogo = false;
        actionBarTitleId = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        t = Utility.session(RestClient.pelihara);
        pencarianArray = null;
        getJson = "";
        inponsel = null;
        suc = "";
        strPencMerek = "";
        listProvArrayList = null;
        merkArray = null;
        merkArrayID = null;
        jml = "";
        strKey = "";
    }

    public void SearchTask()
    {
        SearchTask searchtask = new SearchTask(null);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            searchtask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            searchtask.execute(new Void[0]);
            return;
        }
    }

    public String[] loadArray(String s, Context context)
    {
        prefs = context.getSharedPreferences("inponsel_preference", 0);
        int j = prefs.getInt((new StringBuilder(String.valueOf(s))).append("_size").toString(), 0);
        context = new String[j];
        int i = 0;
        do
        {
            if (i >= j)
            {
                return context;
            }
            context[i] = prefs.getString((new StringBuilder(String.valueOf(s))).append("_").append(i).toString(), null);
            i++;
        } while (true);
    }

    public void onBackPressed()
    {
        if (mDrawerLayout.isDrawerOpen(0x800003))
        {
            mDrawerLayout.closeDrawers();
            Log.e("vis", "on");
            return;
        } else
        {
            Log.e("vis", "off");
            finish();
            overridePendingTransition(0x7f040001, 0x7f040002);
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f030098, null, false);
        mDrawerLayout.addView(bundle, 0);
        String s;
        int i;
        int j;
        try
        {
            bundle = ((PonselBaseApp)getApplication()).getTracker(com.inponsel.android.adapter.PonselBaseApp.TrackerName.APP_TRACKER);
            bundle.setScreenName("SC Lain");
            bundle.send((new com.google.android.gms.analytics.HitBuilders.AppViewBuilder()).build());
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        getSherlock().setProgressBarIndeterminateVisibility(false);
        getSherlock().setProgressBarVisibility(false);
        actionBar = getSupportActionBar();
        actionBar.setDisplayUseLogoEnabled(useLogo);
        actionBar.setBackgroundDrawable(getResources().getDrawable(0x7f0200e5));
        j = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        i = j;
        if (j == 0)
        {
            i = 0x7f0b0037;
        }
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFFFFF'>Service Center</font>"));
        bundle = (TextView)findViewById(i);
        bundle.setSelected(true);
        bundle.setTextColor(Color.parseColor("#FFFFFF"));
        bundle.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        userFunctions = new UserFunctions();
        db = new DatabaseHandler(this);
        imageLoader2 = ImageLoader.getInstance();
        imageLoader2.init(ImageLoaderConfiguration.createDefault(this));
        options = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showImageForEmptyUri(0x7f020208).showImageOnFail(0x7f020297).cacheInMemory(true).imageScaleType(ImageScaleType.EXACTLY).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).build();
        btnPencMerek = (Button)findViewById(0x7f0b03ae);
        btnPencMerek.setVisibility(8);
        listPencarianHp = (ListView)findViewById(0x7f0b052e);
        edtAuto = (EditText)findViewById(0x7f0b008d);
        edtAuto.requestFocus();
        edtAuto.requestFocusFromTouch();
        t = Utility.session(t);
        progressbar_middle = (ProgressBar)findViewById(0x7f0b00ca);
        cm = (ConnectivityManager)getSystemService("connectivity");
        layout_empty_sc = (LinearLayout)findViewById(0x7f0b0530);
        txt_empty_sc = (TextView)findViewById(0x7f0b0531);
        pencarianArray = new ArrayList();
        t = Utility.session(t);
        extras = getIntent().getExtras();
        strKey = extras.getString("strKey");
        pencarianAdapter = new ListPencarianAdapter(this, 0x7f030120, pencarianArray);
        listPencarianHp.setAdapter(pencarianAdapter);
        btnPencMerek.setOnClickListener(new android.view.View.OnClickListener() {

            final SCMoreActivity this$0;

            public void onClick(View view)
            {
                if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected())
                {
                    View view1 = getLayoutInflater().inflate(0x7f0300a4, null);
                    view = new android.app.AlertDialog.Builder(SCMoreActivity.this);
                    view.setView(view1);
                    view.setTitle("Pilih Merek :");
                    layout_empty = (LinearLayout)view1.findViewById(0x7f0b0091);
                    listHp = (ListView)view1.findViewById(0x7f0b008f);
                    if (android.os.Build.VERSION.SDK_INT < 13)
                    {
                        listHp.setBackgroundColor(-1);
                    }
                    progressbar_middle_dialog = (ProgressBar)view1.findViewById(0x7f0b0092);
                    txtEmpty = (TextView)view1.findViewById(0x7f0b0093);
                    txtEmpty.setText(0x7f0c0053);
                    listProvArrayList = new ArrayList();
                    merk_hp = loadArray("merkArray", getApplicationContext().getApplicationContext());
                    merk_hpID = loadArray("merkArrayID", getApplicationContext().getApplicationContext());
                    merkArray = new ArrayList();
                    merkArray = new ArrayList(Arrays.asList(merk_hp));
                    merkArrayID = new ArrayList();
                    merkArrayID = new ArrayList(Arrays.asList(merk_hpID));
                    Log.e("merkArray", String.valueOf(merkArray.size()));
                    if (merkArray.size() != 0)
                    {
                        Log.e("merkArray", "1");
                        ArrayAdapter arrayadapter = new ArrayAdapter(SCMoreActivity.this, 0x1090003, merkArray);
                        listHp.setAdapter(arrayadapter);
                        layout_empty.setVisibility(8);
                        listHp.setVisibility(0);
                        listHp.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                            final _cls1 this$1;

                            public void onItemClick(AdapterView adapterview, View view, int i, long l)
                            {
                                adapterview = ((TextView)view).getText().toString();
                                btnPencMerek.setText(adapterview);
                                strPencMerek = merk_hpID[i];
                                Log.e("merk_hpID", merk_hpID[i]);
                                if (Connectivity.isConnectedWifi(_fld0))
                                {
                                    try
                                    {
                                        dataSearch = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("servicenter").append(Utility.BASE_FORMAT).append("?idm=").append(strPencMerek).append("&key=").append(URLEncoder.encode(strKey, "utf-8")).append("&lmt=0&t=").append(t).toString();
                                        getSherlock().setProgressBarIndeterminateVisibility(true);
                                        getSherlock().setProgressBarVisibility(true);
                                    }
                                    // Misplaced declaration of an exception variable
                                    catch (AdapterView adapterview) { }
                                    SearchTask();
                                }
                                mDialog.dismiss();
                            }

            
            {
                this$1 = _cls1.this;
                super();
            }
                        });
                    } else
                    {
                        listMerkAdapter = new ListMerkAdapter(SCMoreActivity.this, 0x7f03006e, listProvArrayList);
                        listHp.setAdapter(listMerkAdapter);
                        (new ProvinsiSync(null)).execute(new String[] {
                            (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("daftar_merk").append(Utility.BASE_FORMAT).append("?t=").append(t).toString()
                        });
                        listHp.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                            final _cls1 this$1;

                            public void onItemClick(AdapterView adapterview, View view, int i, long l)
                            {
                                strPencMerek = listMerkAdapter.getListModel(i - 1).getId_merk().toString();
                                btnPencMerek.setText(listMerkAdapter.getListModel(i - 1).getMerk().toString());
                                if (Connectivity.isConnectedWifi(_fld0))
                                {
                                    dataSearch = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("servicenter").append(Utility.BASE_FORMAT).append("?idm=").append(strPencMerek).append("&key=").append("&lmt=0&t=").append(t).toString();
                                    getSherlock().setProgressBarIndeterminateVisibility(true);
                                    getSherlock().setProgressBarVisibility(true);
                                    SearchTask();
                                }
                            }

            
            {
                this$1 = _cls1.this;
                super();
            }
                        });
                    }
                    mDialog = view.create();
                    mDialog.show();
                    return;
                } else
                {
                    Toast.makeText(getApplicationContext(), 0x7f0c0059, 0).show();
                    return;
                }
            }


            
            {
                this$0 = SCMoreActivity.this;
                super();
            }
        });
        edtAuto.setText(strKey);
        edtAuto.setHint(Html.fromHtml("<small>Ketik: merek, provinsi, kota atau kecamatan</small>"));
        if (edtAuto.getText().length() <= 0) goto _L2; else goto _L1
_L1:
        if (cm.getActiveNetworkInfo() == null || !cm.getActiveNetworkInfo().isAvailable() || !cm.getActiveNetworkInfo().isConnected())
        {
            break MISSING_BLOCK_LABEL_763;
        }
        txt_empty_sc.setText(0x7f0c0053);
        bundle = edtAuto.getText().toString();
        s = URLEncoder.encode(bundle, "utf-8");
        bundle = s;
_L3:
        Log.e("key", bundle);
        dataSearch = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("servicenter").append(Utility.BASE_FORMAT).append("?idm=").append(strPencMerek).append("&key=").append(bundle).append("&lmt=0&t=").append(t).toString();
        Log.e("dataSearch", dataSearch);
        getSherlock().setProgressBarIndeterminateVisibility(true);
        getSherlock().setProgressBarVisibility(true);
        SearchTask();
_L2:
        edtAuto.addTextChangedListener(new DelayedTextWatcher(1000L) {

            final SCMoreActivity this$0;

            public void afterTextChangedDelayed(Editable editable)
            {
                if (edtAuto.getText().toString().trim().length() == 0)
                {
                    layout_empty_sc.setVisibility(8);
                    listPencarianHp.setVisibility(0);
                    return;
                }
                if (cm.getActiveNetworkInfo() == null || !cm.getActiveNetworkInfo().isAvailable() || !cm.getActiveNetworkInfo().isConnected()) goto _L2; else goto _L1
_L1:
                txt_empty_sc.setText(0x7f0c0053);
                editable = edtAuto.getText().toString();
                String s1 = URLEncoder.encode(editable, "utf-8");
                editable = s1;
_L3:
                Log.e("key", editable);
                dataSearch = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("servicenter").append(Utility.BASE_FORMAT).append("?idm=").append(strPencMerek).append("&key=").append(editable).append("&lmt=0&t=").append(t).toString();
                Log.e("dataSearch", dataSearch);
                getSherlock().setProgressBarIndeterminateVisibility(true);
                getSherlock().setProgressBarVisibility(true);
                SearchTask();
                return;
                UnsupportedEncodingException unsupportedencodingexception1;
                unsupportedencodingexception1;
                unsupportedencodingexception1.printStackTrace();
                if (true) goto _L3; else goto _L2
_L2:
                Toast.makeText(getApplicationContext(), 0x7f0c0059, 0).show();
                return;
            }

            
            {
                this$0 = SCMoreActivity.this;
                super(l);
            }
        });
        listPencarianHp.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final SCMoreActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int k, long l)
            {
                adapterview = new Intent(getApplicationContext(), com/inponsel/android/scdetail/SCDetailPager);
                adapterview.putExtra("sc_id", pencarianAdapter.getListModel(k).getId_sc());
                adapterview.putExtra("sc_logo", pencarianAdapter.getListModel(k).getSc_logo());
                adapterview.putExtra("sc_c_center", pencarianAdapter.getListModel(k).getSc_c_center());
                adapterview.putExtra("sc_ven_center", pencarianAdapter.getListModel(k).getSc_ven_center());
                adapterview.putExtra("sc_nama", pencarianAdapter.getListModel(k).getSc_nama());
                adapterview.putExtra("sc_merk", pencarianAdapter.getListModel(k).getSc_merk());
                adapterview.putExtra("sc_fb", pencarianAdapter.getListModel(k).getSc_fb());
                adapterview.putExtra("sc_ytube", pencarianAdapter.getListModel(k).getSc_ytube());
                adapterview.putExtra("sc_fb_id", pencarianAdapter.getListModel(k).getSc_fb_id());
                adapterview.putExtra("sc_tw", pencarianAdapter.getListModel(k).getSc_tw());
                adapterview.putExtra("sc_alamat", pencarianAdapter.getListModel(k).getSc_alamat());
                adapterview.putExtra("sc_no_telp", pencarianAdapter.getListModel(k).getSc_no_telp());
                adapterview.putExtra("sc_no_telp_ket", pencarianAdapter.getListModel(k).getSc_no_telp_ket());
                adapterview.putExtra("sc_email", pencarianAdapter.getListModel(k).getSc_email());
                adapterview.putExtra("sc_web", pencarianAdapter.getListModel(k).getSc_web_url());
                adapterview.putExtra("sc_rateAvg", pencarianAdapter.getListModel(k).getSc_rate());
                adapterview.putExtra("sc_rate1", pencarianAdapter.getListModel(k).getSc_rate1());
                adapterview.putExtra("sc_rate2", pencarianAdapter.getListModel(k).getSc_rate2());
                adapterview.putExtra("sc_rate3", pencarianAdapter.getListModel(k).getSc_rate3());
                adapterview.putExtra("sc_rate4", pencarianAdapter.getListModel(k).getSc_rate4());
                adapterview.putExtra("sc_rate5", pencarianAdapter.getListModel(k).getSc_rate5());
                adapterview.putExtra("sc_total_rate", pencarianAdapter.getListModel(k).getSc_total_rate());
                startActivityForResult(adapterview, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = SCMoreActivity.this;
                super();
            }
        });
        return;
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        unsupportedencodingexception.printStackTrace();
          goto _L3
        Toast.makeText(getApplicationContext(), 0x7f0c0059, 0).show();
          goto _L2
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getSupportMenuInflater().inflate(0x7f0f0002, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        switch (i)
        {
        default:
            return super.onKeyDown(i, keyevent);

        case 82: // 'R'
            break;
        }
        if (mDrawerLayout.isDrawerOpen(0x800003))
        {
            mDrawerLayout.closeDrawers();
        } else
        {
            mDrawerLayout.openDrawer(0x800003);
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return true;

        case 16908332: 
            mDrawerToggle.onOptionsItemSelected(menuitem);
            return true;

        case 2131429682: 
            startActivity(new Intent(getApplicationContext(), com/inponsel/android/pencariangen/TabPencarian));
            break;
        }
        return true;
    }

    public boolean saveArray(String as[], String s, Context context)
    {
        prefs = context.getSharedPreferences("inponsel_preference", 0);
        editor = prefs.edit();
        editor.putInt((new StringBuilder(String.valueOf(s))).append("_size").toString(), as.length);
        int i = 0;
        do
        {
            if (i >= as.length)
            {
                return editor.commit();
            }
            editor.putString((new StringBuilder(String.valueOf(s))).append("_").append(i).toString(), as[i]);
            i++;
        } while (true);
    }

}
