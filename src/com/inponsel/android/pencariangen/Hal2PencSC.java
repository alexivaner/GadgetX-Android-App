// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.pencariangen;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.Html;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.actionbarsherlock.app.SherlockFragment;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.scdetail.SCDetailPager;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.DelayedTextWatcher;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.SampleScrollListener;
import com.inponsel.android.utils.ServiceHandler;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.widget.ExpandableHeightGridView;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Hal2PencSC extends SherlockFragment
{
    public class ListSCProvAdapter extends BaseAdapter
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
        String komen;
        private ArrayList lm;
        ListModel lms;
        ProgressDialog mDialog;
        String no_telp_array[];
        int pos;
        String res;
        int resource;
        String response;
        String status;
        String t;
        final Hal2PencSC this$0;
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

        public View getView(int i, View view, final ViewGroup holder)
        {
            pos = i;
            if (view == null)
            {
                view = ((LayoutInflater)activity.getSystemService("layout_inflater")).inflate(resource, null);
                holder = new ViewHolder();
                holder.imageHp = (ImageView)view.findViewById(0x7f0b023d);
                holder.list_txtMerek = (TextView)view.findViewById(0x7f0b033c);
                holder.list_txtAlamat = (TextView)view.findViewById(0x7f0b033d);
                holder.progressbar_item = (ProgressBar)view.findViewById(0x7f0b00b3);
                holder.list_lay_like = (RelativeLayout)view.findViewById(0x7f0b0342);
                holder.list_lay_dislike = (RelativeLayout)view.findViewById(0x7f0b0345);
                holder.list_lay_kom = (RelativeLayout)view.findViewById(0x7f0b0348);
                holder.headImage = (LinearLayout)view.findViewById(0x7f0b029f);
                view.setTag(holder);
            } else
            {
                holder = (ViewHolder)view.getTag();
            }
            lms = (ListModel)lm.get(i);
            if (lm != null)
            {
                ((ViewHolder) (holder)).list_txtMerek.setText((new StringBuilder(String.valueOf(lms.getSc_merk()))).append(" ").append(lms.getSc_nama()).toString());
                ((ViewHolder) (holder)).list_txtAlamat.setText((new StringBuilder(String.valueOf(lms.getSc_merk()))).append(" ").append(lms.getSc_nama()).toString());
                ((ViewHolder) (holder)).list_txtAlamat.setSelected(true);
                no_telp_array = lms.getSc_no_telp().trim().split(",");
                ((ViewHolder) (holder)).list_lay_like.setOnClickListener(new android.view.View.OnClickListener() {

                    final ListSCProvAdapter this$1;

                    public void onClick(View view)
                    {
                        view = new android.app.AlertDialog.Builder(getActivity());
                        view.setTitle("Nomor Telepon :");
                        view.setSingleChoiceItems(no_telp_array, -1, new android.content.DialogInterface.OnClickListener() {

                            final ListSCProvAdapter._cls1 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent("android.intent.action.DIAL", Uri.parse((new StringBuilder("tel: ")).append(no_telp_array[i].replaceAll("-", "")).toString()));
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = ListSCProvAdapter._cls1.this;
                super();
            }
                        });
                        view.show();
                    }


            
            {
                this$1 = ListSCProvAdapter.this;
                super();
            }
                });
                ((ViewHolder) (holder)).list_lay_dislike.setOnClickListener(new android.view.View.OnClickListener() {

                    final ListSCProvAdapter this$1;

                    public void onClick(View view)
                    {
                    }

            
            {
                this$1 = ListSCProvAdapter.this;
                super();
            }
                });
                ((ViewHolder) (holder)).list_lay_kom.setOnClickListener(new android.view.View.OnClickListener() {

                    final ListSCProvAdapter this$1;

                    public void onClick(View view)
                    {
                    }

            
            {
                this$1 = ListSCProvAdapter.this;
                super();
            }
                });
                Picasso.with(activity).load(lms.getSc_logo().trim()).tag(activity).into(((ViewHolder) (holder)).imageHp, i. new Callback() {

                    final ListSCProvAdapter this$1;
                    private final ListSCProvAdapter.ViewHolder val$holder;
                    private final int val$position;

                    public void onError()
                    {
                        holder.progressbar_item.setVisibility(8);
                    }

                    public void onSuccess()
                    {
                        holder.progressbar_item.setVisibility(8);
                        holder.imageHp.setVisibility(0);
                        Log.e("load", String.valueOf(position));
                    }

            
            {
                this$1 = final_listscprovadapter;
                holder = viewholder;
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


        public ListSCProvAdapter(Activity activity1, int i, ArrayList arraylist)
        {
            this$0 = Hal2PencSC.this;
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
            catch (Hal2PencSC hal2pencsc)
            {
                return;
            }
        }
    }

    class ListSCProvAdapter.ViewHolder
    {

        LinearLayout headImage;
        ImageView imageHp;
        RelativeLayout list_lay_dislike;
        RelativeLayout list_lay_kom;
        RelativeLayout list_lay_like;
        TextView list_txtAlamat;
        TextView list_txtMerek;
        ProgressBar progressbar_item;
        final ListSCProvAdapter this$1;

        ListSCProvAdapter.ViewHolder()
        {
            this$1 = ListSCProvAdapter.this;
            super();
        }
    }

    private class SearchTask extends AsyncTask
    {

        final Hal2PencSC this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            {
                avoid = (new ServiceHandler()).makeServiceCall(dataSearch, 1);
                if (avoid == null)
                {
                    break MISSING_BLOCK_LABEL_433;
                }
                ListModel listmodel;
                int i;
                try
                {
                    avoid = new JSONObject(avoid);
                    suc = avoid.getString("success");
                    jumSC = avoid.getString("count");
                    Log.e("suc", suc);
                    inponsel = avoid.getJSONArray("InPonsel");
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_442;
                }
                i = 0;
            }
            if (i >= inponsel.length())
            {
                break MISSING_BLOCK_LABEL_442;
            }
            avoid = Hal2PencSC.this;
            avoid.counterArray = ((Hal2PencSC) (avoid)).counterArray + 1;
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
            scpencarianArray.add(listmodel);
            i++;
            if (true)
            {
                break MISSING_BLOCK_LABEL_85;
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
            Log.e("tasksdsurlSearch", String.valueOf(scpencarianArray.size()));
            progressbar_middleSC.setVisibility(8);
            scpencarianAdapter.notifyDataSetChanged();
            if (scpencarianArray.size() != 0)
            {
                break MISSING_BLOCK_LABEL_152;
            }
            Log.e("listsc", "gone");
            layout_empty.setVisibility(0);
            txt_empty.setText("Service center tidak ditemukan");
_L1:
            Log.e("counterArray", String.valueOf(scpencarianArray.size()));
            if (scpencarianArray.size() < 15)
            {
                grup_header_footer.setVisibility(8);
                return;
            }
            break MISSING_BLOCK_LABEL_193;
            try
            {
                Log.e("listsc", "visible");
                layout_empty.setVisibility(8);
                listSCManual.setVisibility(0);
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                void1.printStackTrace();
                return;
            }
              goto _L1
            btnMemuatLagi.setVisibility(0);
            grup_header_footer.setVisibility(0);
            return;
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            if (limit == 0)
            {
                scpencarianArray.clear();
                progressbar_middleSC.setVisibility(0);
                return;
            } else
            {
                btnMemuatLagi.setVisibility(8);
                return;
            }
        }

        private SearchTask()
        {
            this$0 = Hal2PencSC.this;
            super();
        }

        SearchTask(SearchTask searchtask)
        {
            this();
        }
    }


    Button btnMemuatLagi;
    Button btn_pop_komen;
    Button btn_pop_login;
    ConnectivityManager cm;
    int counterArray;
    String dataSearch;
    EditText edtAutoSC;
    LinearLayout grup_header_footer;
    JSONArray inponsel;
    String jumSC;
    String key;
    LinearLayout lay_pop_komen;
    LinearLayout layout_empty;
    LinearLayout layout_footer;
    int limit;
    ExpandableHeightGridView listSCManual;
    ProgressBar progressbar_middleSC;
    ListSCProvAdapter scpencarianAdapter;
    ArrayList scpencarianArray;
    String strPencMerek;
    String suc;
    String t;
    TextView txt_empty;
    TextView txt_footer;
    TextView txtcari;

    public Hal2PencSC()
    {
        limit = 0;
        scpencarianArray = null;
        strPencMerek = "nil";
        suc = "";
        jumSC = "";
        inponsel = null;
        t = Utility.session(RestClient.pelihara);
    }

    public void SearchTask()
    {
        SearchTask searchtask;
        if (limit == 0)
        {
            dataSearch = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("search_engine").append(Utility.BASE_FORMAT).append("?idm=").append(strPencMerek).append("&kat=2").append("&key=").append(key).append("&lmt=0&t=").append(t).toString();
        } else
        {
            dataSearch = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("search_engine").append(Utility.BASE_FORMAT).append("?idm=").append(strPencMerek).append("&kat=2").append("&key=").append(key).append("&lmt=").append(limit).append("&t=").append(t).toString();
        }
        Log.e("dataSearch", dataSearch);
        searchtask = new SearchTask(null);
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

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = (ViewGroup)layoutinflater.inflate(0x7f030097, null);
        txtcari = (TextView)layoutinflater.findViewById(0x7f0b052c);
        txt_empty = (TextView)layoutinflater.findViewById(0x7f0b0093);
        layout_empty = (LinearLayout)layoutinflater.findViewById(0x7f0b0091);
        edtAutoSC = (EditText)layoutinflater.findViewById(0x7f0b008d);
        edtAutoSC.requestFocus();
        progressbar_middleSC = (ProgressBar)layoutinflater.findViewById(0x7f0b00ca);
        cm = (ConnectivityManager)getActivity().getSystemService("connectivity");
        t = Utility.session(t);
        listSCManual = (ExpandableHeightGridView)layoutinflater.findViewById(0x7f0b052e);
        listSCManual.setOnScrollListener(new SampleScrollListener(getActivity()));
        listSCManual.setExpanded(true);
        scpencarianArray = new ArrayList();
        scpencarianAdapter = new ListSCProvAdapter(getActivity(), 0x7f030120, scpencarianArray);
        listSCManual.setAdapter(scpencarianAdapter);
        txtcari.setVisibility(8);
        edtAutoSC.setHint("Pencarian Service Center");
        edtAutoSC.setHint(Html.fromHtml("<small>Ketik: merek, provinsi, kota atau kecamatan</small>"));
        t = Utility.session(t);
        btnMemuatLagi = (Button)layoutinflater.findViewById(0x7f0b00bc);
        btnMemuatLagi.setText(0x7f0c0054);
        layout_footer = (LinearLayout)layoutinflater.findViewById(0x7f0b00b9);
        grup_header_footer = (LinearLayout)layoutinflater.findViewById(0x7f0b00b7);
        txt_footer = (TextView)layoutinflater.findViewById(0x7f0b00bb);
        txt_footer.setText("Memuat");
        grup_header_footer.setVisibility(8);
        edtAutoSC.setSingleLine(true);
        edtAutoSC.addTextChangedListener(new DelayedTextWatcher(2000L) {

            final Hal2PencSC this$0;

            public void afterTextChangedDelayed(Editable editable)
            {
                if (edtAutoSC.getText().toString().trim().length() == 0)
                {
                    listSCManual.setVisibility(0);
                    return;
                }
                if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected())
                {
                    key = edtAutoSC.getText().toString();
                    try
                    {
                        key = URLEncoder.encode(key, "utf-8");
                    }
                    // Misplaced declaration of an exception variable
                    catch (Editable editable)
                    {
                        editable.printStackTrace();
                    }
                    Log.e("key", key);
                    limit = 0;
                    SearchTask();
                    return;
                } else
                {
                    Toast.makeText(getActivity(), 0x7f0c0059, 0).show();
                    return;
                }
            }

            
            {
                this$0 = Hal2PencSC.this;
                super(l);
            }
        });
        edtAutoSC.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

            final Hal2PencSC this$0;

            public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
            {
                boolean flag = false;
                if (i == 3)
                {
                    grup_header_footer.setVisibility(8);
                    if (edtAutoSC.getText().toString().trim().length() == 0)
                    {
                        listSCManual.setVisibility(0);
                    } else
                    if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected())
                    {
                        key = edtAutoSC.getText().toString();
                        try
                        {
                            key = URLEncoder.encode(key, "utf-8");
                        }
                        // Misplaced declaration of an exception variable
                        catch (TextView textview)
                        {
                            textview.printStackTrace();
                        }
                        Log.e("key", key);
                        limit = 0;
                        SearchTask();
                    } else
                    {
                        Toast.makeText(getActivity(), 0x7f0c0059, 0).show();
                    }
                    flag = true;
                }
                return flag;
            }

            
            {
                this$0 = Hal2PencSC.this;
                super();
            }
        });
        btnMemuatLagi.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2PencSC this$0;

            public void onClick(View view)
            {
                btnMemuatLagi.setVisibility(8);
                if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected())
                {
                    view = edtAutoSC.getText().toString();
                    try
                    {
                        URLEncoder.encode(view, "utf-8");
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        view.printStackTrace();
                    }
                    view = Hal2PencSC.this;
                    view.limit = ((Hal2PencSC) (view)).limit + 15;
                    Log.e("data", dataSearch);
                    SearchTask();
                    return;
                } else
                {
                    Toast.makeText(getActivity(), getString(0x7f0c005a), 0).show();
                    return;
                }
            }

            
            {
                this$0 = Hal2PencSC.this;
                super();
            }
        });
        listSCManual.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final Hal2PencSC this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = new Intent(getActivity(), com/inponsel/android/scdetail/SCDetailPager);
                adapterview.putExtra("sc_id", scpencarianAdapter.getListModel(i).getId_sc());
                adapterview.putExtra("sc_logo", scpencarianAdapter.getListModel(i).getSc_logo());
                adapterview.putExtra("sc_c_center", scpencarianAdapter.getListModel(i).getSc_c_center());
                adapterview.putExtra("sc_ven_center", scpencarianAdapter.getListModel(i).getSc_ven_center());
                adapterview.putExtra("sc_nama", scpencarianAdapter.getListModel(i).getSc_nama());
                adapterview.putExtra("sc_merk", scpencarianAdapter.getListModel(i).getSc_merk());
                adapterview.putExtra("sc_fb", scpencarianAdapter.getListModel(i).getSc_fb());
                adapterview.putExtra("sc_ytube", scpencarianAdapter.getListModel(i).getSc_ytube());
                adapterview.putExtra("sc_fb_id", scpencarianAdapter.getListModel(i).getSc_fb_id());
                adapterview.putExtra("sc_tw", scpencarianAdapter.getListModel(i).getSc_tw());
                adapterview.putExtra("sc_alamat", scpencarianAdapter.getListModel(i).getSc_alamat());
                adapterview.putExtra("sc_no_telp", scpencarianAdapter.getListModel(i).getSc_no_telp());
                adapterview.putExtra("sc_no_telp_ket", scpencarianAdapter.getListModel(i).getSc_no_telp_ket());
                adapterview.putExtra("sc_email", scpencarianAdapter.getListModel(i).getSc_email());
                adapterview.putExtra("sc_web", scpencarianAdapter.getListModel(i).getSc_web_url());
                adapterview.putExtra("sc_rateAvg", scpencarianAdapter.getListModel(i).getSc_rate());
                adapterview.putExtra("sc_rate1", scpencarianAdapter.getListModel(i).getSc_rate1());
                adapterview.putExtra("sc_rate2", scpencarianAdapter.getListModel(i).getSc_rate2());
                adapterview.putExtra("sc_rate3", scpencarianAdapter.getListModel(i).getSc_rate3());
                adapterview.putExtra("sc_rate4", scpencarianAdapter.getListModel(i).getSc_rate4());
                adapterview.putExtra("sc_rate5", scpencarianAdapter.getListModel(i).getSc_rate5());
                adapterview.putExtra("sc_total_rate", scpencarianAdapter.getListModel(i).getSc_total_rate());
                startActivityForResult(adapterview, 0);
                getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = Hal2PencSC.this;
                super();
            }
        });
        return layoutinflater;
    }
}
