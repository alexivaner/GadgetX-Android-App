// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.servicenter;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.actionbarsherlock.app.SherlockFragment;
import com.inponsel.android.adapter.ListMerkAdapter;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.adapter.ListOperatorAdapter;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.servicenter:
//            SCPencarian, Hal2SCHasil

public class Hal1SCManual extends SherlockFragment
{
    private class KotaSync extends AsyncTask
    {

        final Hal1SCManual this$0;

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
            kota_strarray = new String[kotaArray.size()];
            kota_strarray = (String[])kotaArray.toArray(kota_strarray);
            kota_strarrayID = new String[kotaArrayID.size()];
            kota_strarrayID = (String[])kotaArrayID.toArray(kota_strarrayID);
            Log.e("preference", provinsiprefrence);
            saveArray(kota_strarray, provinsiprefrence, getActivity());
            saveArray(kota_strarrayID, provinsiidprefrence, getActivity());
            progressbar_search.setVisibility(8);
            if (jml != 0)
            {
                break MISSING_BLOCK_LABEL_271;
            }
            txtEmpty.setText(0x7f0c0058);
            layout_empty.setVisibility(0);
_L1:
            log((new StringBuilder("lenght arrayList : ")).append(listKotaArrayList.size()).toString());
            listOperatorAdapter.setListArray(listKotaArrayList);
            listOperatorAdapter.notifyDataSetChanged();
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
                listKotaArrayList = new ArrayList();
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
                jml = s.length();
                Log.e("jarray", String.valueOf(jml));
                return;
            }
            jsonobject = s.getJSONObject(i);
            listmodel = new ListModel();
            listmodel.setKota_id(jsonobject.getString("id"));
            listmodel.setProvinsi_id(jsonobject.getString("provinsi_id"));
            listmodel.setNm_op(jsonobject.getString("kota"));
            kota_str = jsonobject.getString("kota");
            kota_strID = jsonobject.getString("id");
            kotaArray.add(kota_str);
            kotaArrayID.add(kota_strID);
            listKotaArrayList.add(listmodel);
            i++;
            if (false)
            {
            } else
            {
                break MISSING_BLOCK_LABEL_56;
            }
        }

        private KotaSync()
        {
            this$0 = Hal1SCManual.this;
            super();
        }

        KotaSync(KotaSync kotasync)
        {
            this();
        }
    }

    private class MerkSync extends AsyncTask
    {

        final Hal1SCManual this$0;

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
            saveArray(merk_hp, "merkArray", getActivity().getApplicationContext());
            saveArray(merk_hpID, "merkArrayID", getActivity().getApplicationContext());
            progressbar_middle_dialog.setVisibility(8);
            if (listMerkArrayList.size() != 0)
            {
                break MISSING_BLOCK_LABEL_218;
            }
            txtEmpty.setText(0x7f0c0059);
_L1:
            listMerkAdapter.setListArray(listMerkArrayList);
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
                void1.printStackTrace();
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
                listMerkArrayList = new ArrayList();
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
            listMerkArrayList.add(listmodel);
            i++;
            if (false)
            {
            } else
            {
                break MISSING_BLOCK_LABEL_56;
            }
        }

        private MerkSync()
        {
            this$0 = Hal1SCManual.this;
            super();
        }

        MerkSync(MerkSync merksync)
        {
            this();
        }
    }

    private class ProvinsiSync extends AsyncTask
    {

        final Hal1SCManual this$0;

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
            provinsi_strarray = new String[provinsiArray.size()];
            provinsi_strarray = (String[])provinsiArray.toArray(provinsi_strarray);
            provinsi_strarrayID = new String[provinsiArrayID.size()];
            provinsi_strarrayID = (String[])provinsiArrayID.toArray(provinsi_strarrayID);
            saveArray(provinsi_strarray, "provinsiArray", getActivity());
            saveArray(provinsi_strarrayID, "provinsiArrayID", getActivity());
            progressbar_search.setVisibility(8);
            if (jml != 0)
            {
                break MISSING_BLOCK_LABEL_249;
            }
            txtEmpty.setText(0x7f0c0058);
            layout_empty.setVisibility(0);
_L1:
            log((new StringBuilder("lenght arrayList : ")).append(listProvArrayList.size()).toString());
            listOperatorAdapter.setListArray(listProvArrayList);
            listOperatorAdapter.notifyDataSetChanged();
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
                jml = s.length();
                Log.e("jarray", String.valueOf(jml));
                return;
            }
            jsonobject = s.getJSONObject(i);
            listmodel = new ListModel();
            listmodel.setProvinsi_id(jsonobject.getString("id"));
            listmodel.setNm_op(jsonobject.getString("provinsi"));
            provinsi_str = jsonobject.getString("provinsi");
            provinsi_strID = jsonobject.getString("id");
            provinsiArray.add(provinsi_str);
            provinsiArrayID.add(provinsi_strID);
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
            this$0 = Hal1SCManual.this;
            super();
        }

        ProvinsiSync(ProvinsiSync provinsisync)
        {
            this();
        }
    }


    public static android.content.SharedPreferences.Editor editor;
    public static SharedPreferences prefs;
    Button btnAbaikan;
    Button btnSCPencHasil;
    Button btnSCPencKota;
    Button btnSCPencMerek;
    Button btnSCPencProv;
    ConnectivityManager cm;
    Dialog dialog;
    EditText edtAuto;
    String getJson;
    LinearLayout headerView;
    int jml;
    String keyscsearch;
    ArrayList kotaArray;
    ArrayList kotaArrayID;
    String kotaProfile;
    String kota_id;
    String kota_str;
    String kota_strID;
    String kota_strarray[];
    String kota_strarrayID[];
    LayoutInflater layoutInflater;
    LinearLayout layout_empty;
    ListView listHp;
    ArrayList listKotaArrayList;
    ListMerkAdapter listMerkAdapter;
    ArrayList listMerkArrayList;
    ListOperatorAdapter listOperatorAdapter;
    ArrayList listProvArrayList;
    ArrayList merkArray;
    ArrayList merkArrayID;
    String merk_hp[];
    String merk_hpID[];
    String merk_ven;
    String merk_venID;
    String opera[];
    ProgressBar progressbar_middle_dialog;
    ProgressBar progressbar_search;
    String prov[];
    ArrayList provinsiArray;
    ArrayList provinsiArrayID;
    String provinsiProfile;
    String provinsi_id;
    String provinsi_str;
    String provinsi_strID;
    String provinsi_strarray[];
    String provinsi_strarrayID[];
    String provinsiidprefrence;
    String provinsiprefrence;
    String strPencMerek;
    String t;
    TextView txtEmpty;

    public Hal1SCManual()
    {
        jml = 0;
        listProvArrayList = null;
        listKotaArrayList = null;
        listMerkArrayList = null;
        provinsiArray = null;
        provinsiArrayID = null;
        provinsiprefrence = "";
        provinsiidprefrence = "";
        t = Utility.session(RestClient.pelihara);
        merkArray = null;
        merkArrayID = null;
        getJson = "";
        provinsiProfile = "";
        kotaProfile = "";
        prov = null;
        opera = null;
        provinsi_id = "";
        kota_id = "";
        strPencMerek = "";
        kotaArray = null;
        kotaArrayID = null;
        keyscsearch = "";
    }

    public static void clearSharedPreferences(Context context)
    {
        File file = new File((new StringBuilder(String.valueOf(context.getFilesDir().getParent()))).append("/shared_prefs/").toString());
        String as[] = file.list();
        int i = 0;
        do
        {
label0:
            {
label1:
                {
                    {
                        if (i < as.length)
                        {
                            break label1;
                        }
                        try
                        {
                            Thread.sleep(1000L);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Context context) { }
                        i = 0;
                    }
                    if (i >= as.length)
                    {
                        return;
                    }
                    break label0;
                }
                context.getSharedPreferences(as[i].replace(".xml", ""), 0).edit().clear().commit();
                i++;
            }
        } while (true);
        (new File(file, as[i])).delete();
        i++;
        break MISSING_BLOCK_LABEL_54;
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

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = (ViewGroup)layoutinflater.inflate(0x7f030108, null);
        t = Utility.session(t);
        provinsi_id = "";
        kota_id = "";
        strPencMerek = "";
        btnSCPencMerek = (Button)layoutinflater.findViewById(0x7f0b081a);
        btnSCPencProv = (Button)layoutinflater.findViewById(0x7f0b081b);
        btnSCPencKota = (Button)layoutinflater.findViewById(0x7f0b081c);
        btnSCPencHasil = (Button)layoutinflater.findViewById(0x7f0b081d);
        t = Utility.session(t);
        cm = (ConnectivityManager)getActivity().getSystemService("connectivity");
        headerView = (LinearLayout)getActivity().getLayoutInflater().inflate(0x7f030037, null);
        btnAbaikan = (Button)headerView.findViewById(0x7f0b00b8);
        btnSCPencMerek.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1SCManual this$0;

            public void onClick(View view)
            {
                if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected())
                {
                    View view1 = getActivity().getLayoutInflater().inflate(0x7f0300a4, null);
                    view = new android.app.AlertDialog.Builder(getActivity());
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
                    btnAbaikan.setText("Seluruh merek ponsel");
                    listMerkArrayList = new ArrayList();
                    merk_hp = loadArray("merkArray", getActivity());
                    merk_hpID = loadArray("merkArrayID", getActivity());
                    merkArray = new ArrayList();
                    merkArray = new ArrayList(Arrays.asList(merk_hp));
                    merkArrayID = new ArrayList();
                    merkArrayID = new ArrayList(Arrays.asList(merk_hpID));
                    Log.e("merkArray", String.valueOf(merkArray.size()));
                    if (merkArray.size() != 0)
                    {
                        Log.e("merkArray", "1");
                        ArrayAdapter arrayadapter = new ArrayAdapter(getActivity(), 0x1090003, merkArray);
                        listHp.addHeaderView(headerView);
                        listHp.setAdapter(arrayadapter);
                        layout_empty.setVisibility(8);
                        listHp.setVisibility(0);
                        listHp.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                            final _cls1 this$1;

                            public void onItemClick(AdapterView adapterview, View view, int i, long l)
                            {
                                adapterview = ((TextView)view).getText().toString();
                                btnSCPencMerek.setText(adapterview);
                                strPencMerek = merk_hpID[i - 1];
                                Log.e("merk_hpID", merk_hpID[i - 1]);
                                dialog.dismiss();
                            }

            
            {
                this$1 = _cls1.this;
                super();
            }
                        });
                    } else
                    {
                        listMerkAdapter = new ListMerkAdapter(getActivity(), 0x7f03006e, listMerkArrayList);
                        listHp.addHeaderView(headerView);
                        listHp.setAdapter(listMerkAdapter);
                        (new MerkSync(null)).execute(new String[] {
                            (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("daftar_merk").append(Utility.BASE_FORMAT).append("?t=").append(t).toString()
                        });
                        listHp.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                            final _cls1 this$1;

                            public void onItemClick(AdapterView adapterview, View view, int i, long l)
                            {
                                strPencMerek = listMerkAdapter.getListModel(i - 1).getId_merk().toString();
                                btnSCPencMerek.setText(listMerkAdapter.getListModel(i - 1).getMerk().toString());
                                dialog.dismiss();
                            }

            
            {
                this$1 = _cls1.this;
                super();
            }
                        });
                    }
                    dialog = view.create();
                    dialog.show();
                } else
                {
                    Toast.makeText(getActivity(), 0x7f0c0059, 0).show();
                }
                btnAbaikan.setOnClickListener(new android.view.View.OnClickListener() {

                    final _cls1 this$1;

                    public void onClick(View view)
                    {
                        btnSCPencMerek.setText("Seluruh merek ponsel");
                        strPencMerek = "nil";
                        dialog.dismiss();
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                });
            }


            
            {
                this$0 = Hal1SCManual.this;
                super();
            }
        });
        btnSCPencProv.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1SCManual this$0;

            public void onClick(View view)
            {
                View view1 = getActivity().getLayoutInflater().inflate(0x7f030026, null);
                view = new android.app.AlertDialog.Builder(getActivity());
                view.setView(view1);
                view.setTitle("Pilih Provinsi :");
                layout_empty = (LinearLayout)view1.findViewById(0x7f0b0091);
                edtAuto = (EditText)view1.findViewById(0x7f0b008d);
                edtAuto.setVisibility(8);
                listHp = (ListView)view1.findViewById(0x7f0b008f);
                progressbar_search = (ProgressBar)view1.findViewById(0x7f0b008e);
                txtEmpty = (TextView)view1.findViewById(0x7f0b0093);
                btnAbaikan.setText("Seluruh provinsi di Indonesia");
                txtEmpty.setText(0x7f0c0053);
                if (android.os.Build.VERSION.SDK_INT < 13)
                {
                    listHp.setBackgroundColor(-1);
                }
                listProvArrayList = new ArrayList();
                provinsi_strarray = loadArray("provinsiArray", getActivity());
                provinsi_strarrayID = loadArray("provinsiArrayID", getActivity());
                provinsiArray = new ArrayList();
                provinsiArray = new ArrayList(Arrays.asList(provinsi_strarray));
                provinsiArrayID = new ArrayList();
                provinsiArrayID = new ArrayList(Arrays.asList(provinsi_strarrayID));
                if (provinsiArray.size() != 0)
                {
                    Log.e("provinsiArray", "1");
                    ArrayAdapter arrayadapter = new ArrayAdapter(getActivity(), 0x1090003, provinsiArray);
                    listHp.addHeaderView(headerView);
                    listHp.setAdapter(arrayadapter);
                    layout_empty.setVisibility(8);
                    listHp.setVisibility(0);
                    listHp.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                        final _cls2 this$1;

                        public void onItemClick(AdapterView adapterview, View view, int i, long l)
                        {
                            adapterview = ((TextView)view).getText().toString();
                            provinsi_id = provinsi_strarrayID[i - 1];
                            provinsiProfile = adapterview;
                            btnSCPencProv.setText(provinsiProfile);
                            btnSCPencKota.setEnabled(true);
                            provinsiprefrence = provinsiProfile.toString().trim();
                            provinsiidprefrence = provinsi_id;
                            dialog.dismiss();
                        }

            
            {
                this$1 = _cls2.this;
                super();
            }
                    });
                } else
                {
                    listOperatorAdapter = new ListOperatorAdapter(getActivity(), 0x7f03006e, listProvArrayList);
                    listHp.addHeaderView(headerView);
                    listHp.setAdapter(listOperatorAdapter);
                    Log.e("prov", (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("tinggal_provinsi").append(Utility.BASE_FORMAT).append("?t=").append(t).toString());
                    (new ProvinsiSync(null)).execute(new String[] {
                        (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("tinggal_provinsi").append(Utility.BASE_FORMAT).append("?t=").append(t).toString()
                    });
                    listHp.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                        final _cls2 this$1;

                        public void onItemClick(AdapterView adapterview, View view, int i, long l)
                        {
                            ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(edtAuto.getWindowToken(), 0);
                            provinsiProfile = listOperatorAdapter.getListModel(i - 1).getNm_op().toString();
                            provinsi_id = listOperatorAdapter.getListModel(i - 1).getProvinsi_id().toString();
                            Log.e("provinsi", provinsiProfile);
                            btnSCPencProv.setText(provinsiProfile);
                            provinsiprefrence = provinsiProfile.toString().trim();
                            provinsiidprefrence = provinsi_id;
                            btnSCPencKota.setEnabled(true);
                            dialog.dismiss();
                        }

            
            {
                this$1 = _cls2.this;
                super();
            }
                    });
                }
                dialog = view.create();
                dialog.show();
                btnAbaikan.setOnClickListener(new android.view.View.OnClickListener() {

                    final _cls2 this$1;

                    public void onClick(View view)
                    {
                        provinsi_id = "nil";
                        kota_id = "nil";
                        btnSCPencProv.setText("Seluruh provinsi di Indonesia");
                        dialog.dismiss();
                    }

            
            {
                this$1 = _cls2.this;
                super();
            }
                });
            }


            
            {
                this$0 = Hal1SCManual.this;
                super();
            }
        });
        btnSCPencKota.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1SCManual this$0;

            public void onClick(View view)
            {
                if (provinsi_id.equals("") || provinsi_id.equals("nil"))
                {
                    Toast.makeText(getActivity(), "Pilih provinsi terlebih dahulu", 1).show();
                    return;
                }
                View view1 = getActivity().getLayoutInflater().inflate(0x7f030026, null);
                view = new android.app.AlertDialog.Builder(getActivity());
                view.setView(view1);
                view.setTitle("Pilih Kota :");
                layout_empty = (LinearLayout)view1.findViewById(0x7f0b0091);
                edtAuto = (EditText)view1.findViewById(0x7f0b008d);
                edtAuto.setVisibility(8);
                listHp = (ListView)view1.findViewById(0x7f0b008f);
                progressbar_search = (ProgressBar)view1.findViewById(0x7f0b008e);
                txtEmpty = (TextView)view1.findViewById(0x7f0b0093);
                txtEmpty.setText(0x7f0c0053);
                btnAbaikan.setText((new StringBuilder("Seluruh kota di ")).append(provinsiProfile).toString());
                if (android.os.Build.VERSION.SDK_INT < 13)
                {
                    listHp.setBackgroundColor(-1);
                }
                listKotaArrayList = new ArrayList();
                kota_strarray = loadArray(provinsiprefrence, getActivity());
                kota_strarrayID = loadArray(provinsiidprefrence, getActivity());
                kotaArray = new ArrayList();
                kotaArray = new ArrayList(Arrays.asList(kota_strarray));
                kotaArrayID = new ArrayList();
                kotaArrayID = new ArrayList(Arrays.asList(kota_strarrayID));
                if (kotaArray.size() != 0)
                {
                    Log.e("kotaArray", "1");
                    ArrayAdapter arrayadapter = new ArrayAdapter(getActivity(), 0x1090003, kotaArray);
                    listHp.addHeaderView(headerView);
                    listHp.setAdapter(arrayadapter);
                    layout_empty.setVisibility(8);
                    listHp.setVisibility(0);
                    listHp.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                        final _cls3 this$1;

                        public void onItemClick(AdapterView adapterview, View view, int i, long l)
                        {
                            adapterview = ((TextView)view).getText().toString();
                            kota_id = kota_strarrayID[i - 1];
                            kotaProfile = adapterview;
                            btnSCPencKota.setText(kotaProfile);
                            dialog.dismiss();
                        }

            
            {
                this$1 = _cls3.this;
                super();
            }
                    });
                } else
                {
                    listOperatorAdapter = new ListOperatorAdapter(getActivity(), 0x7f03006e, listKotaArrayList);
                    listHp.addHeaderView(headerView);
                    listHp.setAdapter(listOperatorAdapter);
                    (new KotaSync(null)).execute(new String[] {
                        (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("tinggal_kota").append(Utility.BASE_FORMAT).append("?provinsi_id=").append(provinsi_id).append("&t=").append(t).toString()
                    });
                    listHp.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                        final _cls3 this$1;

                        public void onItemClick(AdapterView adapterview, View view, int i, long l)
                        {
                            ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(edtAuto.getWindowToken(), 0);
                            kotaProfile = listOperatorAdapter.getListModel(i - 1).getNm_op().toString();
                            kota_id = listOperatorAdapter.getListModel(i - 1).getKota_id().toString();
                            Log.e("kota", kotaProfile);
                            btnSCPencKota.setText(kotaProfile);
                            dialog.dismiss();
                        }

            
            {
                this$1 = _cls3.this;
                super();
            }
                    });
                }
                dialog = view.create();
                dialog.show();
                btnAbaikan.setOnClickListener(new android.view.View.OnClickListener() {

                    final _cls3 this$1;

                    public void onClick(View view)
                    {
                        kota_id = "nil";
                        btnSCPencKota.setText((new StringBuilder("Seluruh kota di ")).append(provinsiProfile).toString());
                        dialog.dismiss();
                    }

            
            {
                this$1 = _cls3.this;
                super();
            }
                });
            }


            
            {
                this$0 = Hal1SCManual.this;
                super();
            }
        });
        btnSCPencHasil.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1SCManual this$0;

            public void onClick(View view)
            {
                view = ((SCPencarian)getActivity()).getHal2SCHasil();
                view = (Hal2SCHasil)getActivity().getSupportFragmentManager().findFragmentByTag(view);
                view.sc_updateParam(strPencMerek, provinsi_id, kota_id);
                view.SearchManualTask();
                SCPencarian.mViewPager.setCurrentItem(1, true);
            }

            
            {
                this$0 = Hal1SCManual.this;
                super();
            }
        });
        return layoutinflater;
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
