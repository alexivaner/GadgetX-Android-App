// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.pencariangen;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.DelayedTextWatcher;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.SampleScrollListener;
import com.inponsel.android.utils.ServiceHandler;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.v2.ProfileOtherUser;
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

public class Hal4PencUser extends SherlockFragment
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
        int pos;
        String res;
        int resource;
        String response;
        String status;
        String t;
        final Hal4PencUser this$0;
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
label0:
            {
                pos = i;
                if (view == null)
                {
                    view = ((LayoutInflater)activity.getSystemService("layout_inflater")).inflate(resource, null);
                    holder = new ViewHolder();
                    holder.imageHp = (ImageView)view.findViewById(0x7f0b023d);
                    holder.txt_nama = (TextView)view.findViewById(0x7f0b084d);
                    holder.txt_username = (TextView)view.findViewById(0x7f0b0373);
                    holder.progressbar_item = (ProgressBar)view.findViewById(0x7f0b00b3);
                    holder.rl_circle = (RelativeLayout)view.findViewById(0x7f0b084c);
                    view.setTag(holder);
                } else
                {
                    holder = (ViewHolder)view.getTag();
                }
                lms = (ListModel)lm.get(i);
                if (lm != null)
                {
                    ((ViewHolder) (holder)).txt_nama.setText(lms.getNama_asli());
                    ((ViewHolder) (holder)).txt_username.setText(lms.getUsername());
                    ((ViewHolder) (holder)).txt_nama.setSelected(true);
                    ((ViewHolder) (holder)).rl_circle.setVisibility(8);
                    if (!lms.getAvatar().trim().equals(""))
                    {
                        break label0;
                    }
                    ((ViewHolder) (holder)).imageHp.setVisibility(0);
                    ((ViewHolder) (holder)).imageHp.setImageResource(0x7f020297);
                }
                return view;
            }
            Picasso.with(activity).load(lms.getAvatar().trim()).tag(activity).into(((ViewHolder) (holder)).imageHp, i. new Callback() {

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
            return view;
        }

        public void setListArray(ArrayList arraylist)
        {
            lm = arraylist;
        }

        public ListSCProvAdapter(Activity activity1, int i, ArrayList arraylist)
        {
            this$0 = Hal4PencUser.this;
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
            catch (Hal4PencUser hal4pencuser)
            {
                return;
            }
        }
    }

    class ListSCProvAdapter.ViewHolder
    {

        ImageView imageHp;
        ProgressBar progressbar_item;
        RelativeLayout rl_circle;
        final ListSCProvAdapter this$1;
        TextView txt_nama;
        TextView txt_username;

        ListSCProvAdapter.ViewHolder()
        {
            this$1 = ListSCProvAdapter.this;
            super();
        }
    }

    private class SearchTask extends AsyncTask
    {

        final Hal4PencUser this$0;

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
                    break MISSING_BLOCK_LABEL_200;
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
                    break MISSING_BLOCK_LABEL_207;
                }
                i = 0;
            }
            if (i >= inponsel.length())
            {
                break MISSING_BLOCK_LABEL_207;
            }
            avoid = inponsel.getJSONObject(i);
            listmodel = new ListModel();
            listmodel.setId_user(avoid.getString("id"));
            listmodel.setNama_asli(avoid.getString("nama"));
            listmodel.setUsername(avoid.getString("username"));
            listmodel.setAvatar(avoid.getString("avatar"));
            Log.e("nama: ", avoid.getString("nama"));
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
            if (scpencarianArray.size() != 0) goto _L2; else goto _L1
_L1:
            Log.e("listsc", "gone");
            txt_empty.setText("User tidak ditemukan");
            layout_empty.setVisibility(0);
_L3:
            Log.e("counterArray", String.valueOf(scpencarianArray.size()));
            if (scpencarianArray.size() >= 15)
            {
                break MISSING_BLOCK_LABEL_204;
            }
            grup_header_footer.setVisibility(8);
_L4:
            edtAuto.post(new Runnable() {

                final SearchTask this$1;

                public void run()
                {
                    edtAuto.requestFocus();
                }

            
            {
                this$1 = SearchTask.this;
                super();
            }
            });
            return;
_L2:
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
              goto _L3
            btnMemuatLagi.setVisibility(0);
            grup_header_footer.setVisibility(0);
              goto _L4
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
            this$0 = Hal4PencUser.this;
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
    EditText edtAuto;
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

    public Hal4PencUser()
    {
        scpencarianArray = null;
        strPencMerek = "nil";
        suc = "";
        jumSC = "";
        inponsel = null;
        t = Utility.session(RestClient.pelihara);
        limit = 0;
    }

    public void SearchTask()
    {
        SearchTask searchtask;
        if (limit == 0)
        {
            dataSearch = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("search_engine").append(Utility.BASE_FORMAT).append("?idm=").append(strPencMerek).append("&kat=4").append("&key=").append(key).append("&lmt=0&t=").append(t).toString();
        } else
        {
            dataSearch = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("search_engine").append(Utility.BASE_FORMAT).append("?idm=").append(strPencMerek).append("&kat=4").append("&key=").append(key).append("&lmt=").append(limit).append("&t=").append(t).toString();
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
        edtAuto = (EditText)layoutinflater.findViewById(0x7f0b008d);
        layout_empty = (LinearLayout)layoutinflater.findViewById(0x7f0b0091);
        edtAuto.post(new Runnable() {

            final Hal4PencUser this$0;

            public void run()
            {
                edtAuto.requestFocus();
            }

            
            {
                this$0 = Hal4PencUser.this;
                super();
            }
        });
        progressbar_middleSC = (ProgressBar)layoutinflater.findViewById(0x7f0b00ca);
        cm = (ConnectivityManager)getActivity().getSystemService("connectivity");
        txt_empty = (TextView)layoutinflater.findViewById(0x7f0b0093);
        t = Utility.session(t);
        listSCManual = (ExpandableHeightGridView)layoutinflater.findViewById(0x7f0b052e);
        listSCManual.setOnScrollListener(new SampleScrollListener(getActivity()));
        listSCManual.setExpanded(true);
        scpencarianArray = new ArrayList();
        scpencarianAdapter = new ListSCProvAdapter(getActivity(), 0x7f03011f, scpencarianArray);
        listSCManual.setAdapter(scpencarianAdapter);
        txtcari.setVisibility(8);
        edtAuto.setHint(Html.fromHtml("<small>Ketik: username atau nama pengguna</small>"));
        t = Utility.session(t);
        btnMemuatLagi = (Button)layoutinflater.findViewById(0x7f0b00bc);
        btnMemuatLagi.setText(0x7f0c0054);
        layout_footer = (LinearLayout)layoutinflater.findViewById(0x7f0b00b9);
        grup_header_footer = (LinearLayout)layoutinflater.findViewById(0x7f0b00b7);
        txt_footer = (TextView)layoutinflater.findViewById(0x7f0b00bb);
        txt_footer.setText("Memuat");
        grup_header_footer.setVisibility(8);
        edtAuto.setSingleLine(true);
        edtAuto.addTextChangedListener(new DelayedTextWatcher(2000L) {

            final Hal4PencUser this$0;

            public void afterTextChangedDelayed(Editable editable)
            {
                if (edtAuto.getText().toString().trim().length() == 0)
                {
                    listSCManual.setVisibility(0);
                    return;
                }
                if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected())
                {
                    key = edtAuto.getText().toString();
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
                this$0 = Hal4PencUser.this;
                super(l);
            }
        });
        edtAuto.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

            final Hal4PencUser this$0;

            public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
            {
label0:
                {
                    if (i == 3)
                    {
                        if (edtAuto.getText().toString().trim().length() != 0)
                        {
                            break label0;
                        }
                        listSCManual.setVisibility(0);
                    }
                    return false;
                }
                if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected())
                {
                    key = edtAuto.getText().toString();
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
                    return false;
                } else
                {
                    Toast.makeText(getActivity(), 0x7f0c0059, 0).show();
                    return false;
                }
            }

            
            {
                this$0 = Hal4PencUser.this;
                super();
            }
        });
        btnMemuatLagi.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal4PencUser this$0;

            public void onClick(View view)
            {
                btnMemuatLagi.setVisibility(8);
                if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected())
                {
                    view = edtAuto.getText().toString();
                    try
                    {
                        URLEncoder.encode(view, "utf-8");
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        view.printStackTrace();
                    }
                    view = Hal4PencUser.this;
                    view.limit = ((Hal4PencUser) (view)).limit + 15;
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
                this$0 = Hal4PencUser.this;
                super();
            }
        });
        edtAuto.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

            final Hal4PencUser this$0;

            public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
            {
                if (edtAuto.getText().toString().trim().length() == 0)
                {
                    listSCManual.setVisibility(0);
                    return false;
                }
                if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected())
                {
                    key = edtAuto.getText().toString();
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
                    SearchTask();
                    return false;
                } else
                {
                    Toast.makeText(getActivity(), 0x7f0c0059, 0).show();
                    return false;
                }
            }

            
            {
                this$0 = Hal4PencUser.this;
                super();
            }
        });
        listSCManual.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final Hal4PencUser this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = new Intent(getActivity(), com/inponsel/android/v2/ProfileOtherUser);
                Log.e("user_name", scpencarianAdapter.getListModel(i).getUsername());
                adapterview.putExtra("id_user_view", scpencarianAdapter.getListModel(i).getUsername());
                startActivityForResult(adapterview, 0);
                getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = Hal4PencUser.this;
                super();
            }
        });
        return layoutinflater;
    }
}
