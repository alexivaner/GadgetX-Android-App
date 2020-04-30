// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.pencarianrinci;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.actionbarsherlock.app.SherlockFragment;
import com.google.android.gms.analytics.Tracker;
import com.inponsel.android.adapter.ListMerkAdapter;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.pencarianrinci:
//            BasePencarianActivity, Hal2HasilPencarian

public class Hal1Pencarian extends SherlockFragment
{
    private class CoreSync extends AsyncTask
    {

        final Hal1Pencarian this$0;

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
            cpu_hp = new String[cpuArray.size()];
            cpu_hp = (String[])cpuArray.toArray(cpu_hp);
            cpu_hpID = new String[cpuArrayID.size()];
            cpu_hpID = (String[])cpuArrayID.toArray(cpu_hpID);
            saveArray(cpu_hp, "cpuArray", getActivity().getApplicationContext());
            saveArray(cpu_hpID, "cpuArrayID", getActivity().getApplicationContext());
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
            listmodel.setMerk(jsonobject.getString("cpu"));
            listmodel.setId_merk(jsonobject.getString("id"));
            cpu_core = jsonobject.getString("cpu");
            cpu_coreID = jsonobject.getString("id");
            cpuArray.add(cpu_core);
            cpuArrayID.add(cpu_coreID);
            listProvArrayList.add(listmodel);
            i++;
            if (false)
            {
            } else
            {
                break MISSING_BLOCK_LABEL_56;
            }
        }

        private CoreSync()
        {
            this$0 = Hal1Pencarian.this;
            super();
        }

        CoreSync(CoreSync coresync)
        {
            this();
        }
    }

    private class MerkSync extends AsyncTask
    {

        final Hal1Pencarian this$0;

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

        private MerkSync()
        {
            this$0 = Hal1Pencarian.this;
            super();
        }

        MerkSync(MerkSync merksync)
        {
            this();
        }
    }

    private class ModelSync extends AsyncTask
    {

        final Hal1Pencarian this$0;

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
            model_hp = new String[modelArray.size()];
            model_hp = (String[])modelArray.toArray(model_hp);
            model_hpID = new String[modelArrayID.size()];
            model_hpID = (String[])modelArrayID.toArray(model_hpID);
            saveArray(model_hp, "modelArray", getActivity().getApplicationContext());
            saveArray(model_hpID, "modelArrayID", getActivity().getApplicationContext());
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
            listmodel.setMerk(jsonobject.getString("model"));
            listmodel.setId_merk(jsonobject.getString("id"));
            har_model = jsonobject.getString("model");
            har_modelID = jsonobject.getString("id");
            modelArray.add(har_model);
            modelArrayID.add(har_modelID);
            listProvArrayList.add(listmodel);
            i++;
            if (false)
            {
            } else
            {
                break MISSING_BLOCK_LABEL_56;
            }
        }

        private ModelSync()
        {
            this$0 = Hal1Pencarian.this;
            super();
        }

        ModelSync(ModelSync modelsync)
        {
            this();
        }
    }

    private class OSSync extends AsyncTask
    {

        final Hal1Pencarian this$0;

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
            os_hp = new String[osArray.size()];
            os_hp = (String[])osArray.toArray(os_hp);
            os_hpID = new String[osArrayID.size()];
            os_hpID = (String[])osArrayID.toArray(os_hpID);
            saveArray(os_hp, "osArray", getActivity().getApplicationContext());
            saveArray(os_hpID, "osArrayID", getActivity().getApplicationContext());
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
            listmodel.setMerk(jsonobject.getString("os"));
            listmodel.setId_merk(jsonobject.getString("id"));
            sis_os = jsonobject.getString("os");
            sis_osID = jsonobject.getString("id");
            osArray.add(sis_os);
            osArrayID.add(sis_osID);
            listProvArrayList.add(listmodel);
            i++;
            if (false)
            {
            } else
            {
                break MISSING_BLOCK_LABEL_56;
            }
        }

        private OSSync()
        {
            this$0 = Hal1Pencarian.this;
            super();
        }

        OSSync(OSSync ossync)
        {
            this();
        }
    }


    public static android.content.SharedPreferences.Editor editor;
    public static SharedPreferences prefs;
    public static String strPenc2G = "nil";
    public static String strPenc35 = "nil";
    public static String strPenc3G = "nil";
    public static String strPenc4G = "nil";
    public static String strPencBaterai = "nil";
    public static String strPencBluetooth = "nil";
    public static String strPencBobot = "nil";
    public static String strPencCDMA = "nil";
    public static String strPencCore = "nil";
    public static String strPencEDGE = "nil";
    public static String strPencEksternal = "nil";
    public static String strPencGPRS = "nil";
    public static String strPencGPS = "nil";
    public static String strPencGSMCDMA = "nil";
    public static String strPencHDMI = "nil";
    public static String strPencHarga = "nil";
    public static String strPencInfrared = "nil";
    public static String strPencInternal = "nil";
    public static String strPencJenisSentuh = "nil";
    public static String strPencKamera = "nil";
    public static String strPencKameraDepan = "nil";
    public static String strPencKerapatanLayar = "nil";
    public static String strPencLampu = "nil";
    public static String strPencLayarSentuh = "nil";
    public static String strPencLebar = "nil";
    public static String strPencMerek = "nil";
    public static String strPencModel = "nil";
    public static String strPencMulti = "nil";
    public static String strPencMusik = "nil";
    public static String strPencNFC = "nil";
    public static String strPencNative = "nil";
    public static String strPencPanjang = "nil";
    public static String strPencProsessor = "nil";
    public static String strPencRAM = "nil";
    public static String strPencRadio = "nil";
    public static String strPencSIM = "nil";
    public static String strPencSistem = "nil";
    public static String strPencStatus = "nil";
    public static String strPencTVAnalog = "nil";
    public static String strPencTVOut = "nil";
    public static String strPencTebal = "nil";
    public static String strPencUSB = "nil";
    public static String strPencUkuranLayar = "nil";
    public static String strPencVideoRecorder = "nil";
    public static String strPencWiFi = "nil";
    String baterai_hp[] = {
        "Abaikan", "800 mAh", "1000 mAh", "1300 mAh", "1500 mAh", "2000 mAh", "2500 mAh", "3000 mAh", "5000 mAh", "10000 mAh"
    };
    String bobot_hp[] = {
        "Abaikan", "180 gr", "150 gr", "130 gr", "120 gr", "100 gr", "90 gr", "80 gr", "70 gr"
    };
    Button btnAbaikan;
    Button btnCariSubmit;
    Button btnPenc2G;
    Button btnPenc35;
    Button btnPenc3G;
    Button btnPenc4G;
    Button btnPencBaterai;
    Button btnPencBluetooth;
    Button btnPencBobot;
    Button btnPencCDMA;
    Button btnPencCore;
    Button btnPencEDGE;
    Button btnPencEksternal;
    Button btnPencGPRS;
    Button btnPencGPS;
    Button btnPencHDMI;
    Button btnPencHarga;
    Button btnPencInfrared;
    Button btnPencInternal;
    Button btnPencJenisSentuh;
    Button btnPencKamera;
    Button btnPencKameraDepan;
    Button btnPencKerapatanLayar;
    Button btnPencLampu;
    Button btnPencLayarSentuh;
    Button btnPencLebar;
    Button btnPencMerek;
    Button btnPencModel;
    Button btnPencMulti;
    Button btnPencMultiGSMCDMA;
    Button btnPencMusik;
    Button btnPencNFC;
    Button btnPencNative;
    Button btnPencPanjang;
    Button btnPencProsessor;
    Button btnPencRAM;
    Button btnPencRadio;
    Button btnPencSIM;
    Button btnPencSistem;
    Button btnPencStatus;
    Button btnPencTVAnalog;
    Button btnPencTVOut;
    Button btnPencTebal;
    Button btnPencUSB;
    Button btnPencUkuranLayar;
    Button btnPencVideoRecorder;
    Button btnPencWiFi;
    String cdma_hp[] = {
        "Abaikan", "Ya", "Tidak"
    };
    String clock_hp[] = {
        "Abaikan", "600 MHz", "800 MHz", "1 GHz", "1.2 GHz", "1.5 GHz", "2 GHz", "2.5 GHz"
    };
    ConnectivityManager cm;
    ArrayList cpuArray;
    ArrayList cpuArrayID;
    String cpu_core;
    String cpu_coreID;
    String cpu_hp[];
    String cpu_hpID[];
    String edge_hp[] = {
        "Abaikan", "Ya", "Tidak"
    };
    String g2_hp[] = {
        "Abaikan", "Ya", "Tidak"
    };
    String g3_hp[] = {
        "Abaikan", "Ya", "Tidak"
    };
    String g4_hp[] = {
        "Abaikan", "Ya", "Tidak"
    };
    String getJson;
    String gprs_hp[] = {
        "Abaikan", "Ya", "Tidak"
    };
    ViewGroup grup_header_footer;
    String har_model;
    String har_modelID;
    String harga_hp[] = {
        "Abaikan", "Rp. 8.000.000", "Rp. 5.000.000", "Rp. 4.000.000", "Rp. 3.000.000", "Rp. 2.500.000", "Rp. 2.000.000", "Rp. 1.500.000", "Rp. 1.000.000", "Rp. 700.000", 
        "Rp. 500.000", "Rp. 300.000"
    };
    LinearLayout headerView;
    String inch_hp[] = {
        "Abaikan", "2.0 inch", "2.4 inch", "2.8 inch", "3.2 inch", "3.5 inch", "4.0 inch", "4.5 inch", "5.0 inch", "6.0 inch", 
        "7.0 inch", "10.0 inch"
    };
    String internal_hp[] = {
        "Abaikan", "128 MB", "256 MB", "512 MB", "768 MB", "1 GB", "2 GB", "4 GB", "8 GB", "16 GB", 
        "32 GB", "64 GB", "128 GB"
    };
    String jenlayar_hp[] = {
        "Abaikan", "Capacitive", "Resistive"
    };
    String jml;
    String kamera_hp[] = {
        "Abaikan", "VGA", "1 MP", "2 MP", "3 MP", "5 MP", "8 MP", "12 MP"
    };
    LinearLayout layout_empty;
    String lebar_hp[] = {
        "Abaikan", "200 mm", "160 mm", "130 mm", "100 mm", "80 mm", "60 mm", "50 mm", "40 mm"
    };
    ListView listHp;
    ListMerkAdapter listMerkAdapter;
    ArrayList listProvArrayList;
    Dialog mDialog;
    ArrayList merkArray;
    ArrayList merkArrayID;
    String merk_hp[];
    String merk_hpID[];
    String merk_ven;
    String merk_venID;
    ArrayList modelArray;
    ArrayList modelArrayID;
    String model_hp[];
    String model_hpID[];
    String multisim_hp[] = {
        "Abaikan", "Dual SIM", "Triple SIM", "Quad SIM"
    };
    String natcall_hp[] = {
        "Abaikan", "Ya", "Tidak"
    };
    ArrayList osArray;
    ArrayList osArrayID;
    String os_hp[];
    String os_hpID[];
    String panjang_hp[] = {
        "Abaikan", "300 mm", "200 mm", "150 mm", "120 mm", "100 mm", "90 mm", "80 mm"
    };
    String ppi_hp[] = {
        "Abaikan", "130 PPI", "160 PPI", "200 PPI", "240 PPI", "300 PPI", "350 PPI", "400 PPI", "500 PPI"
    };
    ProgressBar progressbar_middle_dialog;
    String queryUrl;
    String ram_hp[] = {
        "Abaikan", "128 MB", "256 MB", "512 MB", "768 MB", "1 GB", "2 GB", "3 GB", "4 GB"
    };
    RelativeLayout rl_Harga;
    RelativeLayout rl_cpu_core;
    RelativeLayout rl_layar_sentuh;
    String simcard[] = {
        "Abaikan", "Micro SIM", "Nano SIM", "Mini SIM"
    };
    String simcardtype[] = {
        "Abaikan", "GSM-GSM", "GSM-CDMA", "CDMA-CDMA"
    };
    String simcardtype3[] = {
        "Abaikan", "GSM-GSM-GSM", "GSM-GSM-CDMA", "GSM-CDMA-CDMA", "CDMA-CDMA-CDMA"
    };
    String simcardtype4[] = {
        "Abaikan", "GSM-GSM-GSM-GSM", "GSM-GSM-GSM-CDMA", "GSM-GSM-CDMA-CDMA", "GSM-CDMA-CDMA-CDMA", "CDMA-CDMA-CDMA-CDMA"
    };
    String sis_os;
    String sis_osID;
    RelativeLayout slideDBProdukPop;
    RelativeLayout slideDaftarHargaPop;
    RelativeLayout slideFAQPop;
    RelativeLayout slideHomePop;
    RelativeLayout slideKebijakanPop;
    RelativeLayout slideLoginPop;
    RelativeLayout slidePencRinciPop;
    RelativeLayout slidePencarianPop;
    RelativeLayout slideProfilePop;
    RelativeLayout slideRegisterPop;
    RelativeLayout slideStatPop;
    RelativeLayout slideTentangPop;
    String status_hp[] = {
        "Abaikan", "Segera Hadir", "Tersedia", "Dihentikan", "Dibatalkan", "Rumor", "Tidak Tersedia"
    };
    String t;
    String tebal_hp[] = {
        "Abaikan", "18 mm", "16 mm", "14 mm", "12 mm", "10 mm", "9 mm", "8 mm"
    };
    TextView titleDaftarHP;
    TextView txtEmpty;
    String video_hp[] = {
        "Abaikan", "Ya", "Tidak", "HD 720p", "HD 1080p", "UHD 2160p"
    };

    public Hal1Pencarian()
    {
        t = Utility.session(RestClient.pelihara);
        queryUrl = "";
        cpuArray = null;
        cpuArrayID = null;
        modelArray = null;
        modelArrayID = null;
        osArray = null;
        osArrayID = null;
        merkArray = null;
        merkArrayID = null;
        listProvArrayList = null;
        getJson = "";
        jml = "";
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
        try
        {
            viewgroup = ((PonselBaseApp)getActivity().getApplication()).getTracker(com.inponsel.android.adapter.PonselBaseApp.TrackerName.APP_TRACKER);
            viewgroup.setScreenName("Pencarian Rinci");
            viewgroup.send((new com.google.android.gms.analytics.HitBuilders.AppViewBuilder()).build());
        }
        // Misplaced declaration of an exception variable
        catch (ViewGroup viewgroup)
        {
            viewgroup.printStackTrace();
        }
        layoutinflater = (ViewGroup)layoutinflater.inflate(0x7f0300f9, null);
        cm = (ConnectivityManager)getActivity().getSystemService("connectivity");
        strPencMerek = "nil";
        strPencStatus = "nil";
        strPencHarga = "nil";
        strPenc2G = "nil";
        strPenc3G = "nil";
        strPenc4G = "nil";
        strPencGPRS = "nil";
        strPencEDGE = "nil";
        strPencCDMA = "nil";
        strPencSIM = "nil";
        strPencMulti = "nil";
        strPencNative = "nil";
        strPencModel = "nil";
        strPencPanjang = "nil";
        strPencLebar = "nil";
        strPencTebal = "nil";
        strPencBobot = "nil";
        strPencSistem = "nil";
        strPencProsessor = "nil";
        strPencCore = "nil";
        strPencRAM = "nil";
        strPencInternal = "nil";
        strPencEksternal = "nil";
        strPencUkuranLayar = "nil";
        strPencLayarSentuh = "nil";
        strPencJenisSentuh = "nil";
        strPencKerapatanLayar = "nil";
        strPencKamera = "nil";
        strPencKameraDepan = "nil";
        strPencLampu = "nil";
        strPencVideoRecorder = "nil";
        strPencBluetooth = "nil";
        strPencUSB = "nil";
        strPenc35 = "nil";
        strPencWiFi = "nil";
        strPencNFC = "nil";
        strPencHDMI = "nil";
        strPencTVOut = "nil";
        strPencInfrared = "nil";
        strPencMusik = "nil";
        strPencRadio = "nil";
        strPencTVAnalog = "nil";
        strPencGPS = "nil";
        strPencBaterai = "nil";
        strPencGSMCDMA = "nil";
        rl_cpu_core = (RelativeLayout)layoutinflater.findViewById(0x7f0b03c3);
        rl_Harga = (RelativeLayout)layoutinflater.findViewById(0x7f0b03b0);
        rl_layar_sentuh = (RelativeLayout)layoutinflater.findViewById(0x7f0b039f);
        btnPencMerek = (Button)layoutinflater.findViewById(0x7f0b03ae);
        btnPencStatus = (Button)layoutinflater.findViewById(0x7f0b03af);
        btnPencHarga = (Button)layoutinflater.findViewById(0x7f0b03b1);
        t = Utility.session(t);
        btnPenc2G = (Button)layoutinflater.findViewById(0x7f0b03b2);
        btnPenc3G = (Button)layoutinflater.findViewById(0x7f0b03b3);
        btnPenc4G = (Button)layoutinflater.findViewById(0x7f0b03b4);
        btnPencGPRS = (Button)layoutinflater.findViewById(0x7f0b03b5);
        btnPencEDGE = (Button)layoutinflater.findViewById(0x7f0b03b6);
        btnPencCDMA = (Button)layoutinflater.findViewById(0x7f0b03b7);
        btnPencSIM = (Button)layoutinflater.findViewById(0x7f0b03b8);
        btnPencMulti = (Button)layoutinflater.findViewById(0x7f0b03b9);
        btnPencNative = (Button)layoutinflater.findViewById(0x7f0b03bb);
        btnPencModel = (Button)layoutinflater.findViewById(0x7f0b03bc);
        btnPencPanjang = (Button)layoutinflater.findViewById(0x7f0b03bd);
        btnPencLebar = (Button)layoutinflater.findViewById(0x7f0b03be);
        btnPencTebal = (Button)layoutinflater.findViewById(0x7f0b03bf);
        btnPencBobot = (Button)layoutinflater.findViewById(0x7f0b03c0);
        btnPencSistem = (Button)layoutinflater.findViewById(0x7f0b03c1);
        btnPencProsessor = (Button)layoutinflater.findViewById(0x7f0b03c2);
        btnPencCore = (Button)layoutinflater.findViewById(0x7f0b03c4);
        btnPencRAM = (Button)layoutinflater.findViewById(0x7f0b03c5);
        btnPencInternal = (Button)layoutinflater.findViewById(0x7f0b03c6);
        btnPencEksternal = (Button)layoutinflater.findViewById(0x7f0b03c7);
        btnPencUkuranLayar = (Button)layoutinflater.findViewById(0x7f0b039d);
        btnPencLayarSentuh = (Button)layoutinflater.findViewById(0x7f0b039e);
        btnPencJenisSentuh = (Button)layoutinflater.findViewById(0x7f0b03a0);
        btnPencKerapatanLayar = (Button)layoutinflater.findViewById(0x7f0b03a1);
        btnPencKamera = (Button)layoutinflater.findViewById(0x7f0b03a2);
        btnPencKameraDepan = (Button)layoutinflater.findViewById(0x7f0b03a3);
        btnPencLampu = (Button)layoutinflater.findViewById(0x7f0b03a4);
        btnPencVideoRecorder = (Button)layoutinflater.findViewById(0x7f0b03a5);
        btnPencBluetooth = (Button)layoutinflater.findViewById(0x7f0b03a6);
        btnPencUSB = (Button)layoutinflater.findViewById(0x7f0b03a7);
        btnPenc35 = (Button)layoutinflater.findViewById(0x7f0b03a8);
        btnPencWiFi = (Button)layoutinflater.findViewById(0x7f0b03a9);
        btnPencNFC = (Button)layoutinflater.findViewById(0x7f0b03aa);
        btnPencHDMI = (Button)layoutinflater.findViewById(0x7f0b03ab);
        btnPencTVOut = (Button)layoutinflater.findViewById(0x7f0b03ac);
        btnPencInfrared = (Button)layoutinflater.findViewById(0x7f0b03ad);
        btnPencMusik = (Button)layoutinflater.findViewById(0x7f0b075e);
        btnPencRadio = (Button)layoutinflater.findViewById(0x7f0b075f);
        btnPencTVAnalog = (Button)layoutinflater.findViewById(0x7f0b0760);
        btnPencGPS = (Button)layoutinflater.findViewById(0x7f0b0761);
        btnPencBaterai = (Button)layoutinflater.findViewById(0x7f0b0762);
        btnPencMultiGSMCDMA = (Button)layoutinflater.findViewById(0x7f0b03ba);
        btnCariSubmit = (Button)layoutinflater.findViewById(0x7f0b0763);
        headerView = (LinearLayout)getActivity().getLayoutInflater().inflate(0x7f030037, null);
        t = Utility.session(t);
        btnAbaikan = (Button)headerView.findViewById(0x7f0b00b8);
        btnPencCore.setEnabled(false);
        btnPencHarga.setEnabled(false);
        rl_Harga.setBackgroundResource(0x7f080176);
        btnPencJenisSentuh.setEnabled(false);
        rl_layar_sentuh.setBackgroundResource(0x7f080176);
        rl_cpu_core.setBackgroundResource(0x7f080176);
        rl_Harga.setBackgroundResource(0x7f080176);
        rl_layar_sentuh.setBackgroundResource(0x7f080176);
        btnPencMerek.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Pencarian this$0;

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
                    listProvArrayList = new ArrayList();
                    merk_hp = loadArray("merkArray", getActivity().getApplicationContext());
                    merk_hpID = loadArray("merkArrayID", getActivity().getApplicationContext());
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
                                btnPencMerek.setText(adapterview);
                                Hal1Pencarian.strPencMerek = merk_hpID[i - 1];
                                Log.e("merk_hpID", merk_hpID[i - 1]);
                                if (btnPencMerek.getText().toString().contains("Apple"))
                                {
                                    btnPencSistem.setEnabled(false);
                                    btnPencSistem.setText("iOS");
                                    Hal1Pencarian.strPencSistem = "5";
                                    Log.e("strPencSistem", Hal1Pencarian.strPencSistem);
                                } else
                                if (btnPencMerek.getText().toString().contains("BlackBerry"))
                                {
                                    btnPencSistem.setEnabled(false);
                                    btnPencSistem.setText("BlackBerry OS");
                                    Hal1Pencarian.strPencSistem = "4";
                                    Log.e("strPencSistem", Hal1Pencarian.strPencSistem);
                                } else
                                {
                                    Log.e("strPencSistem", Hal1Pencarian.strPencSistem);
                                    btnPencSistem.setEnabled(true);
                                    Hal1Pencarian.strPencSistem = "nil";
                                    btnPencSistem.setText("Abaikan");
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
                        listMerkAdapter = new ListMerkAdapter(getActivity(), 0x7f03006e, listProvArrayList);
                        listHp.addHeaderView(headerView);
                        listHp.setAdapter(listMerkAdapter);
                        (new MerkSync(null)).execute(new String[] {
                            (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("daftar_merk").append(Utility.BASE_FORMAT).append("?t=").append(t).toString()
                        });
                        listHp.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                            final _cls1 this$1;

                            public void onItemClick(AdapterView adapterview, View view, int i, long l)
                            {
                                Hal1Pencarian.strPencMerek = listMerkAdapter.getListModel(i - 1).getId_merk().toString();
                                btnPencMerek.setText(listMerkAdapter.getListModel(i - 1).getMerk().toString());
                                if (btnPencMerek.getText().toString().contains("Apple"))
                                {
                                    btnPencSistem.setEnabled(false);
                                    btnPencSistem.setText("iOS");
                                    Hal1Pencarian.strPencSistem = "5";
                                    Log.e("strPencSistem", Hal1Pencarian.strPencSistem);
                                } else
                                if (btnPencMerek.getText().toString().contains("BlackBerry"))
                                {
                                    btnPencSistem.setEnabled(false);
                                    btnPencSistem.setText("BlackBerry OS");
                                    Hal1Pencarian.strPencSistem = "4";
                                    Log.e("strPencSistem", Hal1Pencarian.strPencSistem);
                                } else
                                {
                                    Log.e("strPencSistem", Hal1Pencarian.strPencSistem);
                                    btnPencSistem.setEnabled(true);
                                    Hal1Pencarian.strPencSistem = "nil";
                                    btnPencSistem.setText("Abaikan");
                                }
                                mDialog.dismiss();
                            }

            
            {
                this$1 = _cls1.this;
                super();
            }
                        });
                    }
                    btnAbaikan.setOnClickListener(new android.view.View.OnClickListener() {

                        final _cls1 this$1;

                        public void onClick(View view)
                        {
                            btnPencMerek.setText("Abaikan");
                            Hal1Pencarian.strPencSistem = "nil";
                            mDialog.dismiss();
                        }

            
            {
                this$1 = _cls1.this;
                super();
            }
                    });
                    mDialog = view.create();
                    mDialog.show();
                    return;
                } else
                {
                    Toast.makeText(getActivity(), 0x7f0c0059, 0).show();
                    return;
                }
            }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }
        });
        btnPencCore.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Pencarian this$0;

            public void onClick(View view)
            {
                View view1 = getActivity().getLayoutInflater().inflate(0x7f0300a4, null);
                view = new android.app.AlertDialog.Builder(getActivity());
                view.setView(view1);
                view.setTitle("Pilih Core :");
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
                cpu_hp = loadArray("cpuArray", getActivity().getApplicationContext());
                cpu_hpID = loadArray("cpuArrayID", getActivity().getApplicationContext());
                cpuArray = new ArrayList();
                cpuArray = new ArrayList(Arrays.asList(cpu_hp));
                cpuArrayID = new ArrayList();
                cpuArrayID = new ArrayList(Arrays.asList(cpu_hpID));
                Log.e("cpuArray", String.valueOf(cpuArray.size()));
                if (cpuArray.size() != 0)
                {
                    Log.e("cpuArray", "1");
                    ArrayAdapter arrayadapter = new ArrayAdapter(getActivity(), 0x1090003, cpuArray);
                    listHp.addHeaderView(headerView);
                    listHp.setAdapter(arrayadapter);
                    layout_empty.setVisibility(8);
                    listHp.setVisibility(0);
                    listHp.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                        final _cls2 this$1;

                        public void onItemClick(AdapterView adapterview, View view, int i, long l)
                        {
                            adapterview = ((TextView)view).getText().toString();
                            btnPencCore.setText(adapterview);
                            Hal1Pencarian.strPencCore = cpu_hpID[i - 1];
                            Log.e("cpu_hpID", cpu_hpID[i - 1]);
                            mDialog.dismiss();
                        }

            
            {
                this$1 = _cls2.this;
                super();
            }
                    });
                } else
                {
                    listMerkAdapter = new ListMerkAdapter(getActivity(), 0x7f03006e, listProvArrayList);
                    listHp.addHeaderView(headerView);
                    listHp.setAdapter(listMerkAdapter);
                    (new CoreSync(null)).execute(new String[] {
                        (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("daftar_proc").append(Utility.BASE_FORMAT).append("?t=").append(t).toString()
                    });
                    listHp.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                        final _cls2 this$1;

                        public void onItemClick(AdapterView adapterview, View view, int i, long l)
                        {
                            Hal1Pencarian.strPencCore = listMerkAdapter.getListModel(i - 1).getId_merk().toString();
                            btnPencCore.setText(listMerkAdapter.getListModel(i - 1).getMerk().toString());
                            mDialog.dismiss();
                        }

            
            {
                this$1 = _cls2.this;
                super();
            }
                    });
                }
                btnAbaikan.setOnClickListener(new android.view.View.OnClickListener() {

                    final _cls2 this$1;

                    public void onClick(View view)
                    {
                        Hal1Pencarian.strPencCore = "nil";
                        btnPencCore.setText("Abaikan");
                        mDialog.dismiss();
                    }

            
            {
                this$1 = _cls2.this;
                super();
            }
                });
                mDialog = view.create();
                mDialog.show();
            }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }
        });
        btnPencSistem.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Pencarian this$0;

            public void onClick(View view)
            {
                View view1 = getActivity().getLayoutInflater().inflate(0x7f0300a4, null);
                view = new android.app.AlertDialog.Builder(getActivity());
                view.setView(view1);
                view.setTitle("Pilih Sistem Operasi :");
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
                os_hp = loadArray("osArray", getActivity().getApplicationContext());
                os_hpID = loadArray("osArrayID", getActivity().getApplicationContext());
                osArray = new ArrayList();
                osArray = new ArrayList(Arrays.asList(os_hp));
                osArrayID = new ArrayList();
                osArrayID = new ArrayList(Arrays.asList(os_hpID));
                Log.e("osArray", String.valueOf(osArray.size()));
                if (osArray.size() != 0)
                {
                    Log.e("osArray", "1");
                    ArrayAdapter arrayadapter = new ArrayAdapter(getActivity(), 0x1090003, osArray);
                    listHp.addHeaderView(headerView);
                    listHp.setAdapter(arrayadapter);
                    layout_empty.setVisibility(8);
                    listHp.setVisibility(0);
                    listHp.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                        final _cls3 this$1;

                        public void onItemClick(AdapterView adapterview, View view, int i, long l)
                        {
                            adapterview = ((TextView)view).getText().toString();
                            btnPencSistem.setText(adapterview);
                            Hal1Pencarian.strPencSistem = os_hpID[i - 1];
                            Log.e("os_hpID", os_hpID[i - 1]);
                            mDialog.dismiss();
                        }

            
            {
                this$1 = _cls3.this;
                super();
            }
                    });
                } else
                {
                    listMerkAdapter = new ListMerkAdapter(getActivity(), 0x7f03006e, listProvArrayList);
                    listHp.addHeaderView(headerView);
                    listHp.setAdapter(listMerkAdapter);
                    (new OSSync(null)).execute(new String[] {
                        (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("os_list").append(Utility.BASE_FORMAT).append("?t=").append(t).toString()
                    });
                    listHp.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                        final _cls3 this$1;

                        public void onItemClick(AdapterView adapterview, View view, int i, long l)
                        {
                            Hal1Pencarian.strPencSistem = listMerkAdapter.getListModel(i - 1).getId_merk().toString();
                            btnPencSistem.setText(listMerkAdapter.getListModel(i - 1).getMerk().toString());
                            mDialog.dismiss();
                        }

            
            {
                this$1 = _cls3.this;
                super();
            }
                    });
                }
                btnAbaikan.setOnClickListener(new android.view.View.OnClickListener() {

                    final _cls3 this$1;

                    public void onClick(View view)
                    {
                        Hal1Pencarian.strPencSistem = "nil";
                        btnPencSistem.setText("Abaikan");
                        mDialog.dismiss();
                    }

            
            {
                this$1 = _cls3.this;
                super();
            }
                });
                mDialog = view.create();
                mDialog.show();
            }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }
        });
        btnPencModel.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Pencarian this$0;

            public void onClick(View view)
            {
                View view1 = getActivity().getLayoutInflater().inflate(0x7f0300a4, null);
                view = new android.app.AlertDialog.Builder(getActivity());
                view.setView(view1);
                view.setTitle("Pilih Model :");
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
                model_hp = loadArray("modelArray", getActivity().getApplicationContext());
                model_hpID = loadArray("modelArrayID", getActivity().getApplicationContext());
                modelArray = new ArrayList(Arrays.asList(model_hp));
                modelArrayID = new ArrayList(Arrays.asList(model_hpID));
                Log.e("modelArray", String.valueOf(modelArray.size()));
                if (modelArray.size() != 0)
                {
                    Log.e("modelArray", "1");
                    ArrayAdapter arrayadapter = new ArrayAdapter(getActivity(), 0x1090003, modelArray);
                    listHp.addHeaderView(headerView);
                    listHp.setAdapter(arrayadapter);
                    layout_empty.setVisibility(8);
                    listHp.setVisibility(0);
                    listHp.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                        final _cls4 this$1;

                        public void onItemClick(AdapterView adapterview, View view, int i, long l)
                        {
                            adapterview = ((TextView)view).getText().toString();
                            btnPencModel.setText(adapterview);
                            Hal1Pencarian.strPencModel = model_hpID[i - 1];
                            Log.e("model_hpID", model_hpID[i - 1]);
                            mDialog.dismiss();
                        }

            
            {
                this$1 = _cls4.this;
                super();
            }
                    });
                } else
                {
                    listMerkAdapter = new ListMerkAdapter(getActivity(), 0x7f03006e, listProvArrayList);
                    listHp.addHeaderView(headerView);
                    listHp.setAdapter(listMerkAdapter);
                    (new ModelSync(null)).execute(new String[] {
                        (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("daftar_model").append(Utility.BASE_FORMAT).append("?t=").append(t).toString()
                    });
                    listHp.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                        final _cls4 this$1;

                        public void onItemClick(AdapterView adapterview, View view, int i, long l)
                        {
                            Hal1Pencarian.strPencModel = listMerkAdapter.getListModel(i - 1).getId_merk().toString();
                            btnPencModel.setText(listMerkAdapter.getListModel(i - 1).getMerk().toString());
                            mDialog.dismiss();
                        }

            
            {
                this$1 = _cls4.this;
                super();
            }
                    });
                }
                btnAbaikan.setOnClickListener(new android.view.View.OnClickListener() {

                    final _cls4 this$1;

                    public void onClick(View view)
                    {
                        Hal1Pencarian.strPencModel = "nil";
                        btnPencModel.setText("Abaikan");
                        mDialog.dismiss();
                    }

            
            {
                this$1 = _cls4.this;
                super();
            }
                });
                mDialog = view.create();
                mDialog.show();
            }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }
        });
        btnPencSIM.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Pencarian this$0;

            public void onClick(View view)
            {
                view = new android.app.AlertDialog.Builder(getActivity());
                view.setTitle("Pilih SIM Card:");
                view.setSingleChoiceItems(simcard, -1, new android.content.DialogInterface.OnClickListener() {

                    final _cls5 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        i;
                        JVM INSTR tableswitch 0 3: default 32
                    //                                   0 47
                    //                                   1 80
                    //                                   2 113
                    //                                   3 146;
                           goto _L1 _L2 _L3 _L4 _L5
_L1:
                        Log.e("strPencSIM", Hal1Pencarian.strPencSIM);
                        dialoginterface.dismiss();
                        return;
_L2:
                        btnPencSIM.setText(simcard[0]);
                        Hal1Pencarian.strPencSIM = "nil";
                        continue; /* Loop/switch isn't completed */
_L3:
                        btnPencSIM.setText(simcard[1]);
                        Hal1Pencarian.strPencSIM = "2";
                        continue; /* Loop/switch isn't completed */
_L4:
                        btnPencSIM.setText(simcard[2]);
                        Hal1Pencarian.strPencSIM = "3";
                        continue; /* Loop/switch isn't completed */
_L5:
                        btnPencSIM.setText(simcard[3]);
                        Hal1Pencarian.strPencSIM = "4";
                        if (true) goto _L1; else goto _L6
_L6:
                    }

            
            {
                this$1 = _cls5.this;
                super();
            }
                });
                view.show();
            }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }
        });
        btnPencStatus.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Pencarian this$0;

            public void onClick(View view)
            {
                view = new android.app.AlertDialog.Builder(getActivity());
                view.setTitle("Pilih Status :");
                view.setSingleChoiceItems(status_hp, -1, new android.content.DialogInterface.OnClickListener() {

                    final _cls6 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        i;
                        JVM INSTR tableswitch 0 6: default 44
                    //                                   0 51
                    //                                   1 133
                    //                                   2 215
                    //                                   3 277
                    //                                   4 359
                    //                                   5 441
                    //                                   6 523;
                           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
                        dialoginterface.dismiss();
                        return;
_L2:
                        btnPencStatus.setText(status_hp[0]);
                        Hal1Pencarian.strPencStatus = "nil";
                        btnPencHarga.setEnabled(false);
                        rl_Harga.setBackgroundResource(0x7f080176);
                        btnPencHarga.setText("Abaikan");
                        Hal1Pencarian.strPencHarga = "nil";
                        continue; /* Loop/switch isn't completed */
_L3:
                        btnPencStatus.setText(status_hp[1]);
                        Hal1Pencarian.strPencStatus = "1";
                        btnPencHarga.setEnabled(false);
                        rl_Harga.setBackgroundResource(0x7f080176);
                        btnPencHarga.setText("Abaikan");
                        Hal1Pencarian.strPencHarga = "nil";
                        continue; /* Loop/switch isn't completed */
_L4:
                        btnPencStatus.setText(status_hp[2]);
                        Hal1Pencarian.strPencStatus = "2";
                        btnPencHarga.setEnabled(true);
                        rl_Harga.setBackgroundResource(0x7f08014c);
                        continue; /* Loop/switch isn't completed */
_L5:
                        btnPencStatus.setText(status_hp[3]);
                        Hal1Pencarian.strPencStatus = "3";
                        btnPencHarga.setEnabled(false);
                        rl_Harga.setBackgroundResource(0x7f080176);
                        btnPencHarga.setText("Abaikan");
                        Hal1Pencarian.strPencHarga = "nil";
                        continue; /* Loop/switch isn't completed */
_L6:
                        btnPencStatus.setText(status_hp[4]);
                        Hal1Pencarian.strPencStatus = "4";
                        btnPencHarga.setEnabled(false);
                        rl_Harga.setBackgroundResource(0x7f080176);
                        btnPencHarga.setText("Abaikan");
                        Hal1Pencarian.strPencHarga = "nil";
                        continue; /* Loop/switch isn't completed */
_L7:
                        btnPencStatus.setText(status_hp[5]);
                        Hal1Pencarian.strPencStatus = "5";
                        btnPencHarga.setEnabled(false);
                        rl_Harga.setBackgroundResource(0x7f080176);
                        btnPencHarga.setText("Abaikan");
                        Hal1Pencarian.strPencHarga = "nil";
                        continue; /* Loop/switch isn't completed */
_L8:
                        btnPencStatus.setText(status_hp[6]);
                        Hal1Pencarian.strPencStatus = "6";
                        btnPencHarga.setEnabled(false);
                        rl_Harga.setBackgroundResource(0x7f080176);
                        btnPencHarga.setText("Abaikan");
                        Hal1Pencarian.strPencHarga = "nil";
                        if (true) goto _L1; else goto _L9
_L9:
                    }

            
            {
                this$1 = _cls6.this;
                super();
            }
                });
                view.show();
            }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }
        });
        btnPencHarga.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Pencarian this$0;

            public void onClick(View view)
            {
                view = new android.app.AlertDialog.Builder(getActivity());
                view.setTitle("Pilih Harga Maksimal :");
                view.setSingleChoiceItems(harga_hp, -1, new android.content.DialogInterface.OnClickListener() {

                    final _cls7 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        i;
                        JVM INSTR tableswitch 0 11: default 64
                    //                                   0 71
                    //                                   1 104
                    //                                   2 137
                    //                                   3 170
                    //                                   4 203
                    //                                   5 236
                    //                                   6 269
                    //                                   7 303
                    //                                   8 337
                    //                                   9 371
                    //                                   10 405
                    //                                   11 439;
                           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13
_L1:
                        dialoginterface.dismiss();
                        return;
_L2:
                        btnPencHarga.setText(harga_hp[0]);
                        Hal1Pencarian.strPencHarga = "nil";
                        continue; /* Loop/switch isn't completed */
_L3:
                        btnPencHarga.setText(harga_hp[1]);
                        Hal1Pencarian.strPencHarga = "8000000";
                        continue; /* Loop/switch isn't completed */
_L4:
                        btnPencHarga.setText(harga_hp[2]);
                        Hal1Pencarian.strPencHarga = "5000000";
                        continue; /* Loop/switch isn't completed */
_L5:
                        btnPencHarga.setText(harga_hp[3]);
                        Hal1Pencarian.strPencHarga = "4000000";
                        continue; /* Loop/switch isn't completed */
_L6:
                        btnPencHarga.setText(harga_hp[4]);
                        Hal1Pencarian.strPencHarga = "3000000";
                        continue; /* Loop/switch isn't completed */
_L7:
                        btnPencHarga.setText(harga_hp[5]);
                        Hal1Pencarian.strPencHarga = "2500000";
                        continue; /* Loop/switch isn't completed */
_L8:
                        btnPencHarga.setText(harga_hp[6]);
                        Hal1Pencarian.strPencHarga = "2000000";
                        continue; /* Loop/switch isn't completed */
_L9:
                        btnPencHarga.setText(harga_hp[7]);
                        Hal1Pencarian.strPencHarga = "1500000";
                        continue; /* Loop/switch isn't completed */
_L10:
                        btnPencHarga.setText(harga_hp[8]);
                        Hal1Pencarian.strPencHarga = "1000000";
                        continue; /* Loop/switch isn't completed */
_L11:
                        btnPencHarga.setText(harga_hp[9]);
                        Hal1Pencarian.strPencHarga = "700000";
                        continue; /* Loop/switch isn't completed */
_L12:
                        btnPencHarga.setText(harga_hp[10]);
                        Hal1Pencarian.strPencHarga = "500000";
                        continue; /* Loop/switch isn't completed */
_L13:
                        btnPencHarga.setText(harga_hp[11]);
                        Hal1Pencarian.strPencHarga = "300000";
                        if (true) goto _L1; else goto _L14
_L14:
                    }

            
            {
                this$1 = _cls7.this;
                super();
            }
                });
                view.show();
            }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }
        });
        btnPenc2G.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Pencarian this$0;

            public void onClick(View view)
            {
                view = new android.app.AlertDialog.Builder(getActivity());
                view.setTitle("Pilih 2G :");
                view.setSingleChoiceItems(g2_hp, -1, new android.content.DialogInterface.OnClickListener() {

                    final _cls8 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        i;
                        JVM INSTR tableswitch 0 2: default 28
                    //                                   0 35
                    //                                   1 68
                    //                                   2 101;
                           goto _L1 _L2 _L3 _L4
_L1:
                        dialoginterface.dismiss();
                        return;
_L2:
                        btnPenc2G.setText(g2_hp[0]);
                        Hal1Pencarian.strPenc2G = "nil";
                        continue; /* Loop/switch isn't completed */
_L3:
                        btnPenc2G.setText(g2_hp[1]);
                        Hal1Pencarian.strPenc2G = "1";
                        continue; /* Loop/switch isn't completed */
_L4:
                        btnPenc2G.setText(g2_hp[2]);
                        Hal1Pencarian.strPenc2G = "2";
                        if (true) goto _L1; else goto _L5
_L5:
                    }

            
            {
                this$1 = _cls8.this;
                super();
            }
                });
                view.show();
            }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }
        });
        btnPenc3G.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Pencarian this$0;

            public void onClick(View view)
            {
                view = new android.app.AlertDialog.Builder(getActivity());
                view.setTitle("Pilih 3G :");
                view.setSingleChoiceItems(g3_hp, -1, new android.content.DialogInterface.OnClickListener() {

                    final _cls9 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        i;
                        JVM INSTR tableswitch 0 2: default 28
                    //                                   0 35
                    //                                   1 68
                    //                                   2 101;
                           goto _L1 _L2 _L3 _L4
_L1:
                        dialoginterface.dismiss();
                        return;
_L2:
                        btnPenc3G.setText(g3_hp[0]);
                        Hal1Pencarian.strPenc3G = "nil";
                        continue; /* Loop/switch isn't completed */
_L3:
                        btnPenc3G.setText(g3_hp[1]);
                        Hal1Pencarian.strPenc3G = "1";
                        continue; /* Loop/switch isn't completed */
_L4:
                        btnPenc3G.setText(g3_hp[2]);
                        Hal1Pencarian.strPenc3G = "2";
                        if (true) goto _L1; else goto _L5
_L5:
                    }

            
            {
                this$1 = _cls9.this;
                super();
            }
                });
                view.show();
            }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }
        });
        btnPenc4G.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Pencarian this$0;

            public void onClick(View view)
            {
                view = new android.app.AlertDialog.Builder(getActivity());
                view.setTitle("Pilih 4G :");
                view.setSingleChoiceItems(g4_hp, -1, new android.content.DialogInterface.OnClickListener() {

                    final _cls10 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        i;
                        JVM INSTR tableswitch 0 2: default 28
                    //                                   0 35
                    //                                   1 68
                    //                                   2 101;
                           goto _L1 _L2 _L3 _L4
_L1:
                        dialoginterface.dismiss();
                        return;
_L2:
                        btnPenc4G.setText(g4_hp[0]);
                        Hal1Pencarian.strPenc4G = "nil";
                        continue; /* Loop/switch isn't completed */
_L3:
                        btnPenc4G.setText(g4_hp[1]);
                        Hal1Pencarian.strPenc4G = "1";
                        continue; /* Loop/switch isn't completed */
_L4:
                        btnPenc4G.setText(g4_hp[2]);
                        Hal1Pencarian.strPenc4G = "2";
                        if (true) goto _L1; else goto _L5
_L5:
                    }

            
            {
                this$1 = _cls10.this;
                super();
            }
                });
                view.show();
            }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }
        });
        btnPencGPRS.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Pencarian this$0;

            public void onClick(View view)
            {
                view = new android.app.AlertDialog.Builder(getActivity());
                view.setTitle("Pilih GPRS :");
                view.setSingleChoiceItems(gprs_hp, -1, new android.content.DialogInterface.OnClickListener() {

                    final _cls11 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        i;
                        JVM INSTR tableswitch 0 2: default 28
                    //                                   0 35
                    //                                   1 68
                    //                                   2 101;
                           goto _L1 _L2 _L3 _L4
_L1:
                        dialoginterface.dismiss();
                        return;
_L2:
                        btnPencGPRS.setText(gprs_hp[0]);
                        Hal1Pencarian.strPencGPRS = "nil";
                        continue; /* Loop/switch isn't completed */
_L3:
                        btnPencGPRS.setText(gprs_hp[1]);
                        Hal1Pencarian.strPencGPRS = "1";
                        continue; /* Loop/switch isn't completed */
_L4:
                        btnPencGPRS.setText(gprs_hp[2]);
                        Hal1Pencarian.strPencGPRS = "2";
                        if (true) goto _L1; else goto _L5
_L5:
                    }

            
            {
                this$1 = _cls11.this;
                super();
            }
                });
                view.show();
            }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }
        });
        btnPencEDGE.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Pencarian this$0;

            public void onClick(View view)
            {
                view = new android.app.AlertDialog.Builder(getActivity());
                view.setTitle("Pilih EDGE :");
                view.setSingleChoiceItems(edge_hp, -1, new android.content.DialogInterface.OnClickListener() {

                    final _cls12 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        i;
                        JVM INSTR tableswitch 0 2: default 28
                    //                                   0 35
                    //                                   1 68
                    //                                   2 101;
                           goto _L1 _L2 _L3 _L4
_L1:
                        dialoginterface.dismiss();
                        return;
_L2:
                        btnPencEDGE.setText(edge_hp[0]);
                        Hal1Pencarian.strPencEDGE = "nil";
                        continue; /* Loop/switch isn't completed */
_L3:
                        btnPencEDGE.setText(edge_hp[1]);
                        Hal1Pencarian.strPencEDGE = "1";
                        continue; /* Loop/switch isn't completed */
_L4:
                        btnPencEDGE.setText(edge_hp[2]);
                        Hal1Pencarian.strPencEDGE = "2";
                        if (true) goto _L1; else goto _L5
_L5:
                    }

            
            {
                this$1 = _cls12.this;
                super();
            }
                });
                view.show();
            }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }
        });
        btnPencCDMA.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Pencarian this$0;

            public void onClick(View view)
            {
                view = new android.app.AlertDialog.Builder(getActivity());
                view.setTitle("Pilih CDMA :");
                view.setSingleChoiceItems(cdma_hp, -1, new android.content.DialogInterface.OnClickListener() {

                    final _cls13 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        i;
                        JVM INSTR tableswitch 0 2: default 28
                    //                                   0 35
                    //                                   1 68
                    //                                   2 101;
                           goto _L1 _L2 _L3 _L4
_L1:
                        dialoginterface.dismiss();
                        return;
_L2:
                        btnPencCDMA.setText(cdma_hp[0]);
                        Hal1Pencarian.strPencCDMA = "nil";
                        continue; /* Loop/switch isn't completed */
_L3:
                        btnPencCDMA.setText(cdma_hp[1]);
                        Hal1Pencarian.strPencCDMA = "1";
                        continue; /* Loop/switch isn't completed */
_L4:
                        btnPencCDMA.setText(cdma_hp[2]);
                        Hal1Pencarian.strPencCDMA = "2";
                        if (true) goto _L1; else goto _L5
_L5:
                    }

            
            {
                this$1 = _cls13.this;
                super();
            }
                });
                view.show();
            }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }
        });
        btnPencNative.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Pencarian this$0;

            public void onClick(View view)
            {
                view = new android.app.AlertDialog.Builder(getActivity());
                view.setTitle("Pilih Native :");
                view.setSingleChoiceItems(cdma_hp, -1, new android.content.DialogInterface.OnClickListener() {

                    final _cls14 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        i;
                        JVM INSTR tableswitch 0 2: default 28
                    //                                   0 35
                    //                                   1 68
                    //                                   2 101;
                           goto _L1 _L2 _L3 _L4
_L1:
                        dialoginterface.dismiss();
                        return;
_L2:
                        btnPencNative.setText(cdma_hp[0]);
                        Hal1Pencarian.strPencNative = "nil";
                        continue; /* Loop/switch isn't completed */
_L3:
                        btnPencNative.setText(cdma_hp[1]);
                        Hal1Pencarian.strPencNative = "1";
                        continue; /* Loop/switch isn't completed */
_L4:
                        btnPencNative.setText(cdma_hp[2]);
                        Hal1Pencarian.strPencNative = "2";
                        if (true) goto _L1; else goto _L5
_L5:
                    }

            
            {
                this$1 = _cls14.this;
                super();
            }
                });
                view.show();
            }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }
        });
        btnPencKameraDepan.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Pencarian this$0;

            public void onClick(View view)
            {
                view = new android.app.AlertDialog.Builder(getActivity());
                view.setTitle("Pilih Kamera Depan :");
                view.setSingleChoiceItems(cdma_hp, -1, new android.content.DialogInterface.OnClickListener() {

                    final _cls15 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        i;
                        JVM INSTR tableswitch 0 2: default 28
                    //                                   0 35
                    //                                   1 68
                    //                                   2 101;
                           goto _L1 _L2 _L3 _L4
_L1:
                        dialoginterface.dismiss();
                        return;
_L2:
                        btnPencKameraDepan.setText(cdma_hp[0]);
                        Hal1Pencarian.strPencKameraDepan = "nil";
                        continue; /* Loop/switch isn't completed */
_L3:
                        btnPencKameraDepan.setText(cdma_hp[1]);
                        Hal1Pencarian.strPencKameraDepan = "1";
                        continue; /* Loop/switch isn't completed */
_L4:
                        btnPencKameraDepan.setText(cdma_hp[2]);
                        Hal1Pencarian.strPencKameraDepan = "2";
                        if (true) goto _L1; else goto _L5
_L5:
                    }

            
            {
                this$1 = _cls15.this;
                super();
            }
                });
                view.show();
            }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }
        });
        btnPencLampu.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Pencarian this$0;

            public void onClick(View view)
            {
                view = new android.app.AlertDialog.Builder(getActivity());
                view.setTitle("Pilih Lampu Kilat :");
                view.setSingleChoiceItems(cdma_hp, -1, new android.content.DialogInterface.OnClickListener() {

                    final _cls16 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        i;
                        JVM INSTR tableswitch 0 2: default 28
                    //                                   0 35
                    //                                   1 68
                    //                                   2 101;
                           goto _L1 _L2 _L3 _L4
_L1:
                        dialoginterface.dismiss();
                        return;
_L2:
                        btnPencLampu.setText(cdma_hp[0]);
                        Hal1Pencarian.strPencLampu = "nil";
                        continue; /* Loop/switch isn't completed */
_L3:
                        btnPencLampu.setText(cdma_hp[1]);
                        Hal1Pencarian.strPencLampu = "1";
                        continue; /* Loop/switch isn't completed */
_L4:
                        btnPencLampu.setText(cdma_hp[2]);
                        Hal1Pencarian.strPencLampu = "2";
                        if (true) goto _L1; else goto _L5
_L5:
                    }

            
            {
                this$1 = _cls16.this;
                super();
            }
                });
                view.show();
            }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }
        });
        btnPencLayarSentuh.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Pencarian this$0;

            public void onClick(View view)
            {
                view = new android.app.AlertDialog.Builder(getActivity());
                view.setTitle("Pilih Layar Sentuh :");
                view.setSingleChoiceItems(cdma_hp, -1, new android.content.DialogInterface.OnClickListener() {

                    final _cls17 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        i;
                        JVM INSTR tableswitch 0 2: default 28
                    //                                   0 35
                    //                                   1 117
                    //                                   2 179;
                           goto _L1 _L2 _L3 _L4
_L1:
                        dialoginterface.dismiss();
                        return;
_L2:
                        btnPencLayarSentuh.setText(cdma_hp[0]);
                        Hal1Pencarian.strPencLayarSentuh = "nil";
                        btnPencJenisSentuh.setEnabled(false);
                        rl_layar_sentuh.setBackgroundResource(0x7f080176);
                        btnPencJenisSentuh.setText("Abaikan");
                        Hal1Pencarian.strPencJenisSentuh = "nil";
                        continue; /* Loop/switch isn't completed */
_L3:
                        btnPencLayarSentuh.setText(cdma_hp[1]);
                        Hal1Pencarian.strPencLayarSentuh = "1";
                        btnPencJenisSentuh.setEnabled(true);
                        rl_layar_sentuh.setBackgroundResource(0x7f08014c);
                        continue; /* Loop/switch isn't completed */
_L4:
                        btnPencLayarSentuh.setText(cdma_hp[2]);
                        Hal1Pencarian.strPencLayarSentuh = "2";
                        btnPencJenisSentuh.setEnabled(false);
                        rl_layar_sentuh.setBackgroundResource(0x7f080176);
                        btnPencJenisSentuh.setText("Abaikan");
                        Hal1Pencarian.strPencJenisSentuh = "nil";
                        if (true) goto _L1; else goto _L5
_L5:
                    }

            
            {
                this$1 = _cls17.this;
                super();
            }
                });
                view.show();
            }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }
        });
        btnPencJenisSentuh.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Pencarian this$0;

            public void onClick(View view)
            {
                view = new android.app.AlertDialog.Builder(getActivity());
                view.setTitle("Pilih Jenis Layar:");
                view.setSingleChoiceItems(jenlayar_hp, -1, new android.content.DialogInterface.OnClickListener() {

                    final _cls18 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        i;
                        JVM INSTR tableswitch 0 2: default 28
                    //                                   0 35
                    //                                   1 68
                    //                                   2 101;
                           goto _L1 _L2 _L3 _L4
_L1:
                        dialoginterface.dismiss();
                        return;
_L2:
                        btnPencJenisSentuh.setText(jenlayar_hp[0]);
                        Hal1Pencarian.strPencJenisSentuh = "nil";
                        continue; /* Loop/switch isn't completed */
_L3:
                        btnPencJenisSentuh.setText(jenlayar_hp[1]);
                        Hal1Pencarian.strPencJenisSentuh = "1";
                        continue; /* Loop/switch isn't completed */
_L4:
                        btnPencJenisSentuh.setText(jenlayar_hp[2]);
                        Hal1Pencarian.strPencJenisSentuh = "2";
                        if (true) goto _L1; else goto _L5
_L5:
                    }

            
            {
                this$1 = _cls18.this;
                super();
            }
                });
                view.show();
            }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }
        });
        btnPencVideoRecorder.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Pencarian this$0;

            public void onClick(View view)
            {
                view = new android.app.AlertDialog.Builder(getActivity());
                view.setTitle("Pilih Video Recorder :");
                view.setSingleChoiceItems(video_hp, -1, new android.content.DialogInterface.OnClickListener() {

                    final _cls19 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        i;
                        JVM INSTR tableswitch 0 5: default 40
                    //                                   0 47
                    //                                   1 80
                    //                                   2 113
                    //                                   3 146
                    //                                   4 179
                    //                                   5 212;
                           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
                        dialoginterface.dismiss();
                        return;
_L2:
                        btnPencVideoRecorder.setText(video_hp[0]);
                        Hal1Pencarian.strPencVideoRecorder = "nil";
                        continue; /* Loop/switch isn't completed */
_L3:
                        btnPencVideoRecorder.setText(video_hp[1]);
                        Hal1Pencarian.strPencVideoRecorder = "1";
                        continue; /* Loop/switch isn't completed */
_L4:
                        btnPencVideoRecorder.setText(video_hp[2]);
                        Hal1Pencarian.strPencVideoRecorder = "2";
                        continue; /* Loop/switch isn't completed */
_L5:
                        btnPencVideoRecorder.setText(video_hp[3]);
                        Hal1Pencarian.strPencVideoRecorder = "720";
                        continue; /* Loop/switch isn't completed */
_L6:
                        btnPencVideoRecorder.setText(video_hp[4]);
                        Hal1Pencarian.strPencVideoRecorder = "1080";
                        continue; /* Loop/switch isn't completed */
_L7:
                        btnPencVideoRecorder.setText(video_hp[5]);
                        Hal1Pencarian.strPencVideoRecorder = "2160";
                        if (true) goto _L1; else goto _L8
_L8:
                    }

            
            {
                this$1 = _cls19.this;
                super();
            }
                });
                view.show();
            }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }
        });
        btnPencMulti.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Pencarian this$0;

            public void onClick(View view)
            {
                view = new android.app.AlertDialog.Builder(getActivity());
                view.setTitle("Pilih Multi SIM:");
                view.setSingleChoiceItems(multisim_hp, -1, new android.content.DialogInterface.OnClickListener() {

                    final _cls20 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        i;
                        JVM INSTR tableswitch 0 3: default 32
                    //                                   0 39
                    //                                   1 77
                    //                                   2 124
                    //                                   3 171;
                           goto _L1 _L2 _L3 _L4 _L5
_L1:
                        dialoginterface.dismiss();
                        return;
_L2:
                        btnPencMulti.setText(multisim_hp[0]);
                        Hal1Pencarian.strPencMulti = "nil";
                        Hal1Pencarian.strPencGSMCDMA = "nil";
                        continue; /* Loop/switch isn't completed */
_L3:
                        btnPencMulti.setText(multisim_hp[1]);
                        Hal1Pencarian.strPencMulti = "1";
                        btnPencMultiGSMCDMA.setEnabled(true);
                        continue; /* Loop/switch isn't completed */
_L4:
                        btnPencMulti.setText(multisim_hp[2]);
                        Hal1Pencarian.strPencMulti = "2";
                        btnPencMultiGSMCDMA.setEnabled(true);
                        continue; /* Loop/switch isn't completed */
_L5:
                        btnPencMulti.setText(multisim_hp[3]);
                        Hal1Pencarian.strPencMulti = "3";
                        btnPencMultiGSMCDMA.setEnabled(true);
                        if (true) goto _L1; else goto _L6
_L6:
                    }

            
            {
                this$1 = _cls20.this;
                super();
            }
                });
                view.show();
            }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }
        });
        btnPencMultiGSMCDMA.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Pencarian this$0;

            public void onClick(View view)
            {
                view = new android.app.AlertDialog.Builder(getActivity());
                view.setTitle("Pilih Kombinasi Jaringan:");
                if (!Hal1Pencarian.strPencMulti.equals("1")) goto _L2; else goto _L1
_L1:
                view.setSingleChoiceItems(simcardtype, -1, new android.content.DialogInterface.OnClickListener() {

                    final _cls21 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        i;
                        JVM INSTR tableswitch 0 3: default 32
                    //                                   0 39
                    //                                   1 72
                    //                                   2 105
                    //                                   3 138;
                           goto _L1 _L2 _L3 _L4 _L5
_L1:
                        dialoginterface.dismiss();
                        return;
_L2:
                        btnPencMultiGSMCDMA.setText(simcardtype[0]);
                        Hal1Pencarian.strPencGSMCDMA = "nil";
                        continue; /* Loop/switch isn't completed */
_L3:
                        btnPencMultiGSMCDMA.setText(simcardtype[1]);
                        Hal1Pencarian.strPencGSMCDMA = "1";
                        continue; /* Loop/switch isn't completed */
_L4:
                        btnPencMultiGSMCDMA.setText(simcardtype[2]);
                        Hal1Pencarian.strPencGSMCDMA = "2";
                        continue; /* Loop/switch isn't completed */
_L5:
                        btnPencMultiGSMCDMA.setText(simcardtype[2]);
                        Hal1Pencarian.strPencGSMCDMA = "3";
                        if (true) goto _L1; else goto _L6
_L6:
                    }

            
            {
                this$1 = _cls21.this;
                super();
            }
                });
_L4:
                view.show();
                return;
_L2:
                if (Hal1Pencarian.strPencMulti.equals("2"))
                {
                    view.setSingleChoiceItems(simcardtype3, -1, new android.content.DialogInterface.OnClickListener() {

                        final _cls21 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            i;
                            JVM INSTR tableswitch 0 4: default 36
                        //                                       0 43
                        //                                       1 76
                        //                                       2 109
                        //                                       3 142
                        //                                       4 172;
                               goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
                            dialoginterface.dismiss();
                            return;
_L2:
                            btnPencMultiGSMCDMA.setText(simcardtype3[0]);
                            Hal1Pencarian.strPencGSMCDMA = "nil";
                            continue; /* Loop/switch isn't completed */
_L3:
                            btnPencMultiGSMCDMA.setText(simcardtype3[1]);
                            Hal1Pencarian.strPencGSMCDMA = "4";
                            continue; /* Loop/switch isn't completed */
_L4:
                            btnPencMultiGSMCDMA.setText(simcardtype3[2]);
                            Hal1Pencarian.strPencGSMCDMA = "5";
                            continue; /* Loop/switch isn't completed */
_L5:
                            btnPencMultiGSMCDMA.setText(simcardtype3[2]);
                            Hal1Pencarian.strPencGSMCDMA = "6";
_L6:
                            btnPencMultiGSMCDMA.setText(simcardtype3[2]);
                            Hal1Pencarian.strPencGSMCDMA = "7";
                            if (true) goto _L1; else goto _L7
_L7:
                        }

            
            {
                this$1 = _cls21.this;
                super();
            }
                    });
                } else
                if (Hal1Pencarian.strPencMulti.equals("3"))
                {
                    view.setSingleChoiceItems(simcardtype4, -1, new android.content.DialogInterface.OnClickListener() {

                        final _cls21 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            i;
                            JVM INSTR tableswitch 0 5: default 40
                        //                                       0 47
                        //                                       1 80
                        //                                       2 113
                        //                                       3 146
                        //                                       4 176
                        //                                       5 209;
                               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
                            dialoginterface.dismiss();
                            return;
_L2:
                            btnPencMultiGSMCDMA.setText(simcardtype4[0]);
                            Hal1Pencarian.strPencGSMCDMA = "nil";
                            continue; /* Loop/switch isn't completed */
_L3:
                            btnPencMultiGSMCDMA.setText(simcardtype4[1]);
                            Hal1Pencarian.strPencGSMCDMA = "7";
                            continue; /* Loop/switch isn't completed */
_L4:
                            btnPencMultiGSMCDMA.setText(simcardtype4[2]);
                            Hal1Pencarian.strPencGSMCDMA = "8";
                            continue; /* Loop/switch isn't completed */
_L5:
                            btnPencMultiGSMCDMA.setText(simcardtype4[2]);
                            Hal1Pencarian.strPencGSMCDMA = "9";
_L6:
                            btnPencMultiGSMCDMA.setText(simcardtype4[2]);
                            Hal1Pencarian.strPencGSMCDMA = "10";
                            continue; /* Loop/switch isn't completed */
_L7:
                            btnPencMultiGSMCDMA.setText(simcardtype4[2]);
                            Hal1Pencarian.strPencGSMCDMA = "11";
                            if (true) goto _L1; else goto _L8
_L8:
                        }

            
            {
                this$1 = _cls21.this;
                super();
            }
                    });
                }
                if (true) goto _L4; else goto _L3
_L3:
            }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }
        });
        btnPencEksternal.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Pencarian this$0;

            public void onClick(View view)
            {
                view = new android.app.AlertDialog.Builder(getActivity());
                view.setTitle("Pilih Eksternal SIM:");
                view.setSingleChoiceItems(g2_hp, -1, new android.content.DialogInterface.OnClickListener() {

                    final _cls22 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        i;
                        JVM INSTR tableswitch 0 2: default 28
                    //                                   0 35
                    //                                   1 68
                    //                                   2 101;
                           goto _L1 _L2 _L3 _L4
_L1:
                        dialoginterface.dismiss();
                        return;
_L2:
                        btnPencEksternal.setText(g2_hp[0]);
                        Hal1Pencarian.strPencEksternal = "nil";
                        continue; /* Loop/switch isn't completed */
_L3:
                        btnPencEksternal.setText(g2_hp[1]);
                        Hal1Pencarian.strPencEksternal = "1";
                        continue; /* Loop/switch isn't completed */
_L4:
                        btnPencEksternal.setText(g2_hp[2]);
                        Hal1Pencarian.strPencEksternal = "2";
                        if (true) goto _L1; else goto _L5
_L5:
                    }

            
            {
                this$1 = _cls22.this;
                super();
            }
                });
                view.show();
            }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }
        });
        btnPencPanjang.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Pencarian this$0;

            public void onClick(View view)
            {
                view = new android.app.AlertDialog.Builder(getActivity());
                view.setTitle("Pilih Maksimal Panjang:");
                view.setSingleChoiceItems(panjang_hp, -1, new android.content.DialogInterface.OnClickListener() {

                    final _cls23 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        i;
                        JVM INSTR tableswitch 0 7: default 48
                    //                                   0 55
                    //                                   1 88
                    //                                   2 121
                    //                                   3 154
                    //                                   4 187
                    //                                   5 220
                    //                                   6 253
                    //                                   7 287;
                           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L1:
                        dialoginterface.dismiss();
                        return;
_L2:
                        btnPencPanjang.setText(panjang_hp[0]);
                        Hal1Pencarian.strPencPanjang = "nil";
                        continue; /* Loop/switch isn't completed */
_L3:
                        btnPencPanjang.setText(panjang_hp[1]);
                        Hal1Pencarian.strPencPanjang = "300";
                        continue; /* Loop/switch isn't completed */
_L4:
                        btnPencPanjang.setText(panjang_hp[2]);
                        Hal1Pencarian.strPencPanjang = "200";
                        continue; /* Loop/switch isn't completed */
_L5:
                        btnPencPanjang.setText(panjang_hp[3]);
                        Hal1Pencarian.strPencPanjang = "150";
                        continue; /* Loop/switch isn't completed */
_L6:
                        btnPencPanjang.setText(panjang_hp[4]);
                        Hal1Pencarian.strPencPanjang = "120";
                        continue; /* Loop/switch isn't completed */
_L7:
                        btnPencPanjang.setText(panjang_hp[5]);
                        Hal1Pencarian.strPencPanjang = "100";
                        continue; /* Loop/switch isn't completed */
_L8:
                        btnPencPanjang.setText(panjang_hp[6]);
                        Hal1Pencarian.strPencPanjang = "90";
                        continue; /* Loop/switch isn't completed */
_L9:
                        btnPencPanjang.setText(panjang_hp[7]);
                        Hal1Pencarian.strPencPanjang = "80";
                        if (true) goto _L1; else goto _L10
_L10:
                    }

            
            {
                this$1 = _cls23.this;
                super();
            }
                });
                view.show();
            }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }
        });
        btnPencLebar.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Pencarian this$0;

            public void onClick(View view)
            {
                view = new android.app.AlertDialog.Builder(getActivity());
                view.setTitle("Pilih Maksimal Lebar:");
                view.setSingleChoiceItems(lebar_hp, -1, new android.content.DialogInterface.OnClickListener() {

                    final _cls24 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        i;
                        JVM INSTR tableswitch 0 8: default 52
                    //                                   0 59
                    //                                   1 92
                    //                                   2 125
                    //                                   3 158
                    //                                   4 191
                    //                                   5 224
                    //                                   6 257
                    //                                   7 291
                    //                                   8 325;
                           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L1:
                        dialoginterface.dismiss();
                        return;
_L2:
                        btnPencLebar.setText(lebar_hp[0]);
                        Hal1Pencarian.strPencLebar = "nil";
                        continue; /* Loop/switch isn't completed */
_L3:
                        btnPencLebar.setText(lebar_hp[1]);
                        Hal1Pencarian.strPencLebar = "200";
                        continue; /* Loop/switch isn't completed */
_L4:
                        btnPencLebar.setText(lebar_hp[2]);
                        Hal1Pencarian.strPencLebar = "160";
                        continue; /* Loop/switch isn't completed */
_L5:
                        btnPencLebar.setText(lebar_hp[3]);
                        Hal1Pencarian.strPencLebar = "130";
                        continue; /* Loop/switch isn't completed */
_L6:
                        btnPencLebar.setText(lebar_hp[4]);
                        Hal1Pencarian.strPencLebar = "100";
                        continue; /* Loop/switch isn't completed */
_L7:
                        btnPencLebar.setText(lebar_hp[5]);
                        Hal1Pencarian.strPencLebar = "80";
                        continue; /* Loop/switch isn't completed */
_L8:
                        btnPencLebar.setText(lebar_hp[6]);
                        Hal1Pencarian.strPencLebar = "60";
                        continue; /* Loop/switch isn't completed */
_L9:
                        btnPencLebar.setText(lebar_hp[7]);
                        Hal1Pencarian.strPencLebar = "50";
                        continue; /* Loop/switch isn't completed */
_L10:
                        btnPencLebar.setText(lebar_hp[7]);
                        Hal1Pencarian.strPencLebar = "40";
                        if (true) goto _L1; else goto _L11
_L11:
                    }

            
            {
                this$1 = _cls24.this;
                super();
            }
                });
                view.show();
            }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }
        });
        btnPencTebal.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Pencarian this$0;

            public void onClick(View view)
            {
                view = new android.app.AlertDialog.Builder(getActivity());
                view.setTitle("Pilih Maksimal Tebal:");
                view.setSingleChoiceItems(tebal_hp, -1, new android.content.DialogInterface.OnClickListener() {

                    final _cls25 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        i;
                        JVM INSTR tableswitch 0 7: default 48
                    //                                   0 55
                    //                                   1 88
                    //                                   2 121
                    //                                   3 154
                    //                                   4 187
                    //                                   5 220
                    //                                   6 253
                    //                                   7 287;
                           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L1:
                        dialoginterface.dismiss();
                        return;
_L2:
                        btnPencTebal.setText(tebal_hp[0]);
                        Hal1Pencarian.strPencTebal = "nil";
                        continue; /* Loop/switch isn't completed */
_L3:
                        btnPencTebal.setText(tebal_hp[1]);
                        Hal1Pencarian.strPencTebal = "18";
                        continue; /* Loop/switch isn't completed */
_L4:
                        btnPencTebal.setText(tebal_hp[2]);
                        Hal1Pencarian.strPencTebal = "16";
                        continue; /* Loop/switch isn't completed */
_L5:
                        btnPencTebal.setText(tebal_hp[3]);
                        Hal1Pencarian.strPencTebal = "14";
                        continue; /* Loop/switch isn't completed */
_L6:
                        btnPencTebal.setText(tebal_hp[4]);
                        Hal1Pencarian.strPencTebal = "12";
                        continue; /* Loop/switch isn't completed */
_L7:
                        btnPencTebal.setText(tebal_hp[5]);
                        Hal1Pencarian.strPencTebal = "10";
                        continue; /* Loop/switch isn't completed */
_L8:
                        btnPencTebal.setText(tebal_hp[6]);
                        Hal1Pencarian.strPencTebal = "9";
                        continue; /* Loop/switch isn't completed */
_L9:
                        btnPencTebal.setText(tebal_hp[7]);
                        Hal1Pencarian.strPencTebal = "8";
                        if (true) goto _L1; else goto _L10
_L10:
                    }

            
            {
                this$1 = _cls25.this;
                super();
            }
                });
                view.show();
            }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }
        });
        btnPencBobot.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Pencarian this$0;

            public void onClick(View view)
            {
                view = new android.app.AlertDialog.Builder(getActivity());
                view.setTitle("Pilih Maksimal Bobot:");
                view.setSingleChoiceItems(bobot_hp, -1, new android.content.DialogInterface.OnClickListener() {

                    final _cls26 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        i;
                        JVM INSTR tableswitch 0 8: default 52
                    //                                   0 59
                    //                                   1 92
                    //                                   2 125
                    //                                   3 158
                    //                                   4 191
                    //                                   5 224
                    //                                   6 257
                    //                                   7 291
                    //                                   8 325;
                           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L1:
                        dialoginterface.dismiss();
                        return;
_L2:
                        btnPencBobot.setText(bobot_hp[0]);
                        Hal1Pencarian.strPencBobot = "nil";
                        continue; /* Loop/switch isn't completed */
_L3:
                        btnPencBobot.setText(bobot_hp[1]);
                        Hal1Pencarian.strPencBobot = "180";
                        continue; /* Loop/switch isn't completed */
_L4:
                        btnPencBobot.setText(bobot_hp[2]);
                        Hal1Pencarian.strPencBobot = "150";
                        continue; /* Loop/switch isn't completed */
_L5:
                        btnPencBobot.setText(bobot_hp[3]);
                        Hal1Pencarian.strPencBobot = "130";
                        continue; /* Loop/switch isn't completed */
_L6:
                        btnPencBobot.setText(bobot_hp[4]);
                        Hal1Pencarian.strPencBobot = "120";
                        continue; /* Loop/switch isn't completed */
_L7:
                        btnPencBobot.setText(bobot_hp[5]);
                        Hal1Pencarian.strPencBobot = "100";
                        continue; /* Loop/switch isn't completed */
_L8:
                        btnPencBobot.setText(bobot_hp[6]);
                        Hal1Pencarian.strPencBobot = "90";
                        continue; /* Loop/switch isn't completed */
_L9:
                        btnPencBobot.setText(bobot_hp[7]);
                        Hal1Pencarian.strPencBobot = "80";
                        continue; /* Loop/switch isn't completed */
_L10:
                        btnPencBobot.setText(bobot_hp[8]);
                        Hal1Pencarian.strPencBobot = "70";
                        if (true) goto _L1; else goto _L11
_L11:
                    }

            
            {
                this$1 = _cls26.this;
                super();
            }
                });
                view.show();
            }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }
        });
        btnPencProsessor.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Pencarian this$0;

            public void onClick(View view)
            {
                view = new android.app.AlertDialog.Builder(getActivity());
                view.setTitle("Pilih Minimal Clock:");
                view.setSingleChoiceItems(clock_hp, -1, new android.content.DialogInterface.OnClickListener() {

                    final _cls27 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        i;
                        JVM INSTR tableswitch 0 7: default 48
                    //                                   0 55
                    //                                   1 137
                    //                                   2 199
                    //                                   3 261
                    //                                   4 323
                    //                                   5 385
                    //                                   6 447
                    //                                   7 510;
                           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L1:
                        dialoginterface.dismiss();
                        return;
_L2:
                        btnPencProsessor.setText(clock_hp[0]);
                        Hal1Pencarian.strPencProsessor = "nil";
                        btnPencCore.setEnabled(false);
                        rl_cpu_core.setBackgroundResource(0x7f080176);
                        btnPencCore.setText("Abaikan");
                        Hal1Pencarian.strPencCore = "nil";
                        continue; /* Loop/switch isn't completed */
_L3:
                        btnPencProsessor.setText(clock_hp[1]);
                        Hal1Pencarian.strPencProsessor = "600";
                        btnPencCore.setEnabled(true);
                        rl_cpu_core.setBackgroundResource(0x7f08014c);
                        continue; /* Loop/switch isn't completed */
_L4:
                        btnPencProsessor.setText(clock_hp[2]);
                        Hal1Pencarian.strPencProsessor = "800";
                        btnPencCore.setEnabled(true);
                        rl_cpu_core.setBackgroundResource(0x7f08014c);
                        continue; /* Loop/switch isn't completed */
_L5:
                        btnPencProsessor.setText(clock_hp[3]);
                        Hal1Pencarian.strPencProsessor = "1000";
                        btnPencCore.setEnabled(true);
                        rl_cpu_core.setBackgroundResource(0x7f08014c);
                        continue; /* Loop/switch isn't completed */
_L6:
                        btnPencProsessor.setText(clock_hp[4]);
                        Hal1Pencarian.strPencProsessor = "1200";
                        btnPencCore.setEnabled(true);
                        rl_cpu_core.setBackgroundResource(0x7f08014c);
                        continue; /* Loop/switch isn't completed */
_L7:
                        btnPencProsessor.setText(clock_hp[5]);
                        Hal1Pencarian.strPencProsessor = "1500";
                        btnPencCore.setEnabled(true);
                        rl_cpu_core.setBackgroundResource(0x7f08014c);
                        continue; /* Loop/switch isn't completed */
_L8:
                        btnPencProsessor.setText(clock_hp[6]);
                        Hal1Pencarian.strPencProsessor = "2000";
                        btnPencCore.setEnabled(true);
                        rl_cpu_core.setBackgroundResource(0x7f08014c);
                        continue; /* Loop/switch isn't completed */
_L9:
                        btnPencProsessor.setText(clock_hp[7]);
                        Hal1Pencarian.strPencProsessor = "2500";
                        btnPencCore.setEnabled(true);
                        rl_cpu_core.setBackgroundResource(0x7f08014c);
                        if (true) goto _L1; else goto _L10
_L10:
                    }

            
            {
                this$1 = _cls27.this;
                super();
            }
                });
                view.show();
            }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }
        });
        btnPencRAM.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Pencarian this$0;

            public void onClick(View view)
            {
                view = new android.app.AlertDialog.Builder(getActivity());
                view.setTitle("Pilih Minimal RAM:");
                view.setSingleChoiceItems(ram_hp, -1, new android.content.DialogInterface.OnClickListener() {

                    final _cls28 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        i;
                        JVM INSTR tableswitch 0 8: default 52
                    //                                   0 59
                    //                                   1 92
                    //                                   2 125
                    //                                   3 158
                    //                                   4 191
                    //                                   5 224
                    //                                   6 257
                    //                                   7 291
                    //                                   8 325;
                           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L1:
                        dialoginterface.dismiss();
                        return;
_L2:
                        btnPencRAM.setText(ram_hp[0]);
                        Hal1Pencarian.strPencRAM = "nil";
                        continue; /* Loop/switch isn't completed */
_L3:
                        btnPencRAM.setText(ram_hp[1]);
                        Hal1Pencarian.strPencRAM = "128";
                        continue; /* Loop/switch isn't completed */
_L4:
                        btnPencRAM.setText(ram_hp[2]);
                        Hal1Pencarian.strPencRAM = "256";
                        continue; /* Loop/switch isn't completed */
_L5:
                        btnPencRAM.setText(ram_hp[3]);
                        Hal1Pencarian.strPencRAM = "512";
                        continue; /* Loop/switch isn't completed */
_L6:
                        btnPencRAM.setText(ram_hp[4]);
                        Hal1Pencarian.strPencRAM = "768";
                        continue; /* Loop/switch isn't completed */
_L7:
                        btnPencRAM.setText(ram_hp[5]);
                        Hal1Pencarian.strPencRAM = "1000";
                        continue; /* Loop/switch isn't completed */
_L8:
                        btnPencRAM.setText(ram_hp[6]);
                        Hal1Pencarian.strPencRAM = "2000";
                        continue; /* Loop/switch isn't completed */
_L9:
                        btnPencRAM.setText(ram_hp[7]);
                        Hal1Pencarian.strPencRAM = "3000";
                        continue; /* Loop/switch isn't completed */
_L10:
                        btnPencRAM.setText(ram_hp[8]);
                        Hal1Pencarian.strPencRAM = "4000";
                        if (true) goto _L1; else goto _L11
_L11:
                    }

            
            {
                this$1 = _cls28.this;
                super();
            }
                });
                view.show();
            }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }
        });
        btnPencInternal.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Pencarian this$0;

            public void onClick(View view)
            {
                view = new android.app.AlertDialog.Builder(getActivity());
                view.setTitle("Pilih Minimal Internal:");
                view.setSingleChoiceItems(internal_hp, -1, new android.content.DialogInterface.OnClickListener() {

                    final _cls29 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        i;
                        JVM INSTR tableswitch 0 12: default 68
                    //                                   0 75
                    //                                   1 108
                    //                                   2 141
                    //                                   3 174
                    //                                   4 207
                    //                                   5 240
                    //                                   6 273
                    //                                   7 307
                    //                                   8 341
                    //                                   9 375
                    //                                   10 409
                    //                                   11 443
                    //                                   12 477;
                           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14
_L1:
                        dialoginterface.dismiss();
                        return;
_L2:
                        btnPencInternal.setText(internal_hp[0]);
                        Hal1Pencarian.strPencInternal = "nil";
                        continue; /* Loop/switch isn't completed */
_L3:
                        btnPencInternal.setText(internal_hp[1]);
                        Hal1Pencarian.strPencInternal = "128";
                        continue; /* Loop/switch isn't completed */
_L4:
                        btnPencInternal.setText(internal_hp[2]);
                        Hal1Pencarian.strPencInternal = "256";
                        continue; /* Loop/switch isn't completed */
_L5:
                        btnPencInternal.setText(internal_hp[3]);
                        Hal1Pencarian.strPencInternal = "512";
                        continue; /* Loop/switch isn't completed */
_L6:
                        btnPencInternal.setText(internal_hp[4]);
                        Hal1Pencarian.strPencInternal = "768";
                        continue; /* Loop/switch isn't completed */
_L7:
                        btnPencInternal.setText(internal_hp[5]);
                        Hal1Pencarian.strPencInternal = "1000";
                        continue; /* Loop/switch isn't completed */
_L8:
                        btnPencInternal.setText(internal_hp[6]);
                        Hal1Pencarian.strPencInternal = "2000";
                        continue; /* Loop/switch isn't completed */
_L9:
                        btnPencInternal.setText(internal_hp[7]);
                        Hal1Pencarian.strPencInternal = "4000";
                        continue; /* Loop/switch isn't completed */
_L10:
                        btnPencInternal.setText(internal_hp[8]);
                        Hal1Pencarian.strPencInternal = "8000";
                        continue; /* Loop/switch isn't completed */
_L11:
                        btnPencInternal.setText(internal_hp[9]);
                        Hal1Pencarian.strPencInternal = "16000";
                        continue; /* Loop/switch isn't completed */
_L12:
                        btnPencInternal.setText(internal_hp[10]);
                        Hal1Pencarian.strPencInternal = "32000";
                        continue; /* Loop/switch isn't completed */
_L13:
                        btnPencInternal.setText(internal_hp[11]);
                        Hal1Pencarian.strPencInternal = "64000";
                        continue; /* Loop/switch isn't completed */
_L14:
                        btnPencInternal.setText(internal_hp[12]);
                        Hal1Pencarian.strPencInternal = "128000";
                        if (true) goto _L1; else goto _L15
_L15:
                    }

            
            {
                this$1 = _cls29.this;
                super();
            }
                });
                view.show();
            }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }
        });
        btnPencUkuranLayar.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Pencarian this$0;

            public void onClick(View view)
            {
                view = new android.app.AlertDialog.Builder(getActivity());
                view.setTitle("Pilih Minimal UkuranLayar:");
                view.setSingleChoiceItems(inch_hp, -1, new android.content.DialogInterface.OnClickListener() {

                    final _cls30 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        i;
                        JVM INSTR tableswitch 0 11: default 64
                    //                                   0 71
                    //                                   1 104
                    //                                   2 137
                    //                                   3 170
                    //                                   4 203
                    //                                   5 236
                    //                                   6 269
                    //                                   7 303
                    //                                   8 337
                    //                                   9 371
                    //                                   10 405
                    //                                   11 439;
                           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13
_L1:
                        dialoginterface.dismiss();
                        return;
_L2:
                        btnPencUkuranLayar.setText(inch_hp[0]);
                        Hal1Pencarian.strPencUkuranLayar = "nil";
                        continue; /* Loop/switch isn't completed */
_L3:
                        btnPencUkuranLayar.setText(inch_hp[1]);
                        Hal1Pencarian.strPencUkuranLayar = "2";
                        continue; /* Loop/switch isn't completed */
_L4:
                        btnPencUkuranLayar.setText(inch_hp[2]);
                        Hal1Pencarian.strPencUkuranLayar = "2.4";
                        continue; /* Loop/switch isn't completed */
_L5:
                        btnPencUkuranLayar.setText(inch_hp[3]);
                        Hal1Pencarian.strPencUkuranLayar = "2.8";
                        continue; /* Loop/switch isn't completed */
_L6:
                        btnPencUkuranLayar.setText(inch_hp[4]);
                        Hal1Pencarian.strPencUkuranLayar = "3.2";
                        continue; /* Loop/switch isn't completed */
_L7:
                        btnPencUkuranLayar.setText(inch_hp[5]);
                        Hal1Pencarian.strPencUkuranLayar = "3.5";
                        continue; /* Loop/switch isn't completed */
_L8:
                        btnPencUkuranLayar.setText(inch_hp[6]);
                        Hal1Pencarian.strPencUkuranLayar = "4";
                        continue; /* Loop/switch isn't completed */
_L9:
                        btnPencUkuranLayar.setText(inch_hp[7]);
                        Hal1Pencarian.strPencUkuranLayar = "4.5";
                        continue; /* Loop/switch isn't completed */
_L10:
                        btnPencUkuranLayar.setText(inch_hp[8]);
                        Hal1Pencarian.strPencUkuranLayar = "5";
                        continue; /* Loop/switch isn't completed */
_L11:
                        btnPencUkuranLayar.setText(inch_hp[9]);
                        Hal1Pencarian.strPencUkuranLayar = "6";
                        continue; /* Loop/switch isn't completed */
_L12:
                        btnPencUkuranLayar.setText(inch_hp[10]);
                        Hal1Pencarian.strPencUkuranLayar = "7";
                        continue; /* Loop/switch isn't completed */
_L13:
                        btnPencUkuranLayar.setText(inch_hp[11]);
                        Hal1Pencarian.strPencUkuranLayar = "10";
                        if (true) goto _L1; else goto _L14
_L14:
                    }

            
            {
                this$1 = _cls30.this;
                super();
            }
                });
                view.show();
            }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }
        });
        btnPencKerapatanLayar.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Pencarian this$0;

            public void onClick(View view)
            {
                view = new android.app.AlertDialog.Builder(getActivity());
                view.setTitle("Pilih Kerapatan Layar:");
                view.setSingleChoiceItems(ppi_hp, -1, new android.content.DialogInterface.OnClickListener() {

                    final _cls31 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        i;
                        JVM INSTR tableswitch 0 8: default 52
                    //                                   0 59
                    //                                   1 92
                    //                                   2 125
                    //                                   3 158
                    //                                   4 188
                    //                                   5 221
                    //                                   6 254
                    //                                   7 288
                    //                                   8 322;
                           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L1:
                        dialoginterface.dismiss();
                        return;
_L2:
                        btnPencKerapatanLayar.setText(ppi_hp[0]);
                        Hal1Pencarian.strPencKerapatanLayar = "nil";
                        continue; /* Loop/switch isn't completed */
_L3:
                        btnPencKerapatanLayar.setText(ppi_hp[1]);
                        Hal1Pencarian.strPencKerapatanLayar = "130";
                        continue; /* Loop/switch isn't completed */
_L4:
                        btnPencKerapatanLayar.setText(ppi_hp[2]);
                        Hal1Pencarian.strPencKerapatanLayar = "160";
                        continue; /* Loop/switch isn't completed */
_L5:
                        btnPencKerapatanLayar.setText(ppi_hp[3]);
                        Hal1Pencarian.strPencKerapatanLayar = "200";
_L6:
                        btnPencKerapatanLayar.setText(ppi_hp[4]);
                        Hal1Pencarian.strPencKerapatanLayar = "240";
                        continue; /* Loop/switch isn't completed */
_L7:
                        btnPencKerapatanLayar.setText(ppi_hp[5]);
                        Hal1Pencarian.strPencKerapatanLayar = "300";
                        continue; /* Loop/switch isn't completed */
_L8:
                        btnPencKerapatanLayar.setText(ppi_hp[6]);
                        Hal1Pencarian.strPencKerapatanLayar = "350";
                        continue; /* Loop/switch isn't completed */
_L9:
                        btnPencKerapatanLayar.setText(ppi_hp[7]);
                        Hal1Pencarian.strPencKerapatanLayar = "400";
                        continue; /* Loop/switch isn't completed */
_L10:
                        btnPencKerapatanLayar.setText(ppi_hp[8]);
                        Hal1Pencarian.strPencKerapatanLayar = "500";
                        if (true) goto _L1; else goto _L11
_L11:
                    }

            
            {
                this$1 = _cls31.this;
                super();
            }
                });
                view.show();
            }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }
        });
        btnPencKamera.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Pencarian this$0;

            public void onClick(View view)
            {
                view = new android.app.AlertDialog.Builder(getActivity());
                view.setTitle("Pilih Minimal Kamera:");
                view.setSingleChoiceItems(kamera_hp, -1, new android.content.DialogInterface.OnClickListener() {

                    final _cls32 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        i;
                        JVM INSTR tableswitch 0 7: default 48
                    //                                   0 55
                    //                                   1 88
                    //                                   2 121
                    //                                   3 154
                    //                                   4 187
                    //                                   5 220
                    //                                   6 253
                    //                                   7 287;
                           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L1:
                        dialoginterface.dismiss();
                        return;
_L2:
                        btnPencKamera.setText(kamera_hp[0]);
                        Hal1Pencarian.strPencKamera = "nil";
                        continue; /* Loop/switch isn't completed */
_L3:
                        btnPencKamera.setText(kamera_hp[1]);
                        Hal1Pencarian.strPencKamera = "0.3";
                        continue; /* Loop/switch isn't completed */
_L4:
                        btnPencKamera.setText(kamera_hp[2]);
                        Hal1Pencarian.strPencKamera = "1";
                        continue; /* Loop/switch isn't completed */
_L5:
                        btnPencKamera.setText(kamera_hp[3]);
                        Hal1Pencarian.strPencKamera = "2";
                        continue; /* Loop/switch isn't completed */
_L6:
                        btnPencKamera.setText(kamera_hp[4]);
                        Hal1Pencarian.strPencKamera = "3";
                        continue; /* Loop/switch isn't completed */
_L7:
                        btnPencKamera.setText(kamera_hp[5]);
                        Hal1Pencarian.strPencKamera = "5";
                        continue; /* Loop/switch isn't completed */
_L8:
                        btnPencKamera.setText(kamera_hp[6]);
                        Hal1Pencarian.strPencKamera = "8";
                        continue; /* Loop/switch isn't completed */
_L9:
                        btnPencKamera.setText(kamera_hp[7]);
                        Hal1Pencarian.strPencKamera = "12";
                        if (true) goto _L1; else goto _L10
_L10:
                    }

            
            {
                this$1 = _cls32.this;
                super();
            }
                });
                view.show();
            }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }
        });
        btnPencBluetooth.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Pencarian this$0;

            public void onClick(View view)
            {
                view = new android.app.AlertDialog.Builder(getActivity());
                view.setTitle("Pilih Bluetooth:");
                view.setSingleChoiceItems(cdma_hp, -1, new android.content.DialogInterface.OnClickListener() {

                    final _cls33 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        i;
                        JVM INSTR tableswitch 0 2: default 28
                    //                                   0 35
                    //                                   1 68
                    //                                   2 101;
                           goto _L1 _L2 _L3 _L4
_L1:
                        dialoginterface.dismiss();
                        return;
_L2:
                        btnPencBluetooth.setText(cdma_hp[0]);
                        Hal1Pencarian.strPencBluetooth = "nil";
                        continue; /* Loop/switch isn't completed */
_L3:
                        btnPencBluetooth.setText(cdma_hp[1]);
                        Hal1Pencarian.strPencBluetooth = "1";
                        continue; /* Loop/switch isn't completed */
_L4:
                        btnPencBluetooth.setText(cdma_hp[2]);
                        Hal1Pencarian.strPencBluetooth = "2";
                        if (true) goto _L1; else goto _L5
_L5:
                    }

            
            {
                this$1 = _cls33.this;
                super();
            }
                });
                view.show();
            }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }
        });
        btnPencUSB.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Pencarian this$0;

            public void onClick(View view)
            {
                view = new android.app.AlertDialog.Builder(getActivity());
                view.setTitle("Pilih USB:");
                view.setSingleChoiceItems(cdma_hp, -1, new android.content.DialogInterface.OnClickListener() {

                    final _cls34 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        i;
                        JVM INSTR tableswitch 0 2: default 28
                    //                                   0 35
                    //                                   1 68
                    //                                   2 101;
                           goto _L1 _L2 _L3 _L4
_L1:
                        dialoginterface.dismiss();
                        return;
_L2:
                        btnPencUSB.setText(cdma_hp[0]);
                        Hal1Pencarian.strPencUSB = "nil";
                        continue; /* Loop/switch isn't completed */
_L3:
                        btnPencUSB.setText(cdma_hp[1]);
                        Hal1Pencarian.strPencUSB = "1";
                        continue; /* Loop/switch isn't completed */
_L4:
                        btnPencUSB.setText(cdma_hp[2]);
                        Hal1Pencarian.strPencUSB = "2";
                        if (true) goto _L1; else goto _L5
_L5:
                    }

            
            {
                this$1 = _cls34.this;
                super();
            }
                });
                view.show();
            }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }
        });
        btnPenc35.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Pencarian this$0;

            public void onClick(View view)
            {
                view = new android.app.AlertDialog.Builder(getActivity());
                view.setTitle("Pilih 3.5 Jack:");
                view.setSingleChoiceItems(cdma_hp, -1, new android.content.DialogInterface.OnClickListener() {

                    final _cls35 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        i;
                        JVM INSTR tableswitch 0 2: default 28
                    //                                   0 35
                    //                                   1 68
                    //                                   2 101;
                           goto _L1 _L2 _L3 _L4
_L1:
                        dialoginterface.dismiss();
                        return;
_L2:
                        btnPenc35.setText(cdma_hp[0]);
                        Hal1Pencarian.strPenc35 = "nil";
                        continue; /* Loop/switch isn't completed */
_L3:
                        btnPenc35.setText(cdma_hp[1]);
                        Hal1Pencarian.strPenc35 = "1";
                        continue; /* Loop/switch isn't completed */
_L4:
                        btnPenc35.setText(cdma_hp[2]);
                        Hal1Pencarian.strPenc35 = "2";
                        if (true) goto _L1; else goto _L5
_L5:
                    }

            
            {
                this$1 = _cls35.this;
                super();
            }
                });
                view.show();
            }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }
        });
        btnPencWiFi.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Pencarian this$0;

            public void onClick(View view)
            {
                view = new android.app.AlertDialog.Builder(getActivity());
                view.setTitle("Pilih WiFi:");
                view.setSingleChoiceItems(cdma_hp, -1, new android.content.DialogInterface.OnClickListener() {

                    final _cls36 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        i;
                        JVM INSTR tableswitch 0 2: default 28
                    //                                   0 35
                    //                                   1 68
                    //                                   2 101;
                           goto _L1 _L2 _L3 _L4
_L1:
                        dialoginterface.dismiss();
                        return;
_L2:
                        btnPencWiFi.setText(cdma_hp[0]);
                        Hal1Pencarian.strPencWiFi = "nil";
                        continue; /* Loop/switch isn't completed */
_L3:
                        btnPencWiFi.setText(cdma_hp[1]);
                        Hal1Pencarian.strPencWiFi = "1";
                        continue; /* Loop/switch isn't completed */
_L4:
                        btnPencWiFi.setText(cdma_hp[2]);
                        Hal1Pencarian.strPencWiFi = "2";
                        if (true) goto _L1; else goto _L5
_L5:
                    }

            
            {
                this$1 = _cls36.this;
                super();
            }
                });
                view.show();
            }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }
        });
        btnPencNFC.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Pencarian this$0;

            public void onClick(View view)
            {
                view = new android.app.AlertDialog.Builder(getActivity());
                view.setTitle("Pilih NFC:");
                view.setSingleChoiceItems(cdma_hp, -1, new android.content.DialogInterface.OnClickListener() {

                    final _cls37 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        i;
                        JVM INSTR tableswitch 0 2: default 28
                    //                                   0 35
                    //                                   1 68
                    //                                   2 101;
                           goto _L1 _L2 _L3 _L4
_L1:
                        dialoginterface.dismiss();
                        return;
_L2:
                        btnPencNFC.setText(cdma_hp[0]);
                        Hal1Pencarian.strPencNFC = "nil";
                        continue; /* Loop/switch isn't completed */
_L3:
                        btnPencNFC.setText(cdma_hp[1]);
                        Hal1Pencarian.strPencNFC = "1";
                        continue; /* Loop/switch isn't completed */
_L4:
                        btnPencNFC.setText(cdma_hp[2]);
                        Hal1Pencarian.strPencNFC = "2";
                        if (true) goto _L1; else goto _L5
_L5:
                    }

            
            {
                this$1 = _cls37.this;
                super();
            }
                });
                view.show();
            }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }
        });
        btnPencHDMI.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Pencarian this$0;

            public void onClick(View view)
            {
                view = new android.app.AlertDialog.Builder(getActivity());
                view.setTitle("Pilih HDMI:");
                view.setSingleChoiceItems(cdma_hp, -1, new android.content.DialogInterface.OnClickListener() {

                    final _cls38 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        i;
                        JVM INSTR tableswitch 0 2: default 28
                    //                                   0 35
                    //                                   1 68
                    //                                   2 101;
                           goto _L1 _L2 _L3 _L4
_L1:
                        dialoginterface.dismiss();
                        return;
_L2:
                        btnPencHDMI.setText(cdma_hp[0]);
                        Hal1Pencarian.strPencHDMI = "nil";
                        continue; /* Loop/switch isn't completed */
_L3:
                        btnPencHDMI.setText(cdma_hp[1]);
                        Hal1Pencarian.strPencHDMI = "1";
                        continue; /* Loop/switch isn't completed */
_L4:
                        btnPencHDMI.setText(cdma_hp[2]);
                        Hal1Pencarian.strPencHDMI = "2";
                        if (true) goto _L1; else goto _L5
_L5:
                    }

            
            {
                this$1 = _cls38.this;
                super();
            }
                });
                view.show();
            }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }
        });
        btnPencTVOut.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Pencarian this$0;

            public void onClick(View view)
            {
                view = new android.app.AlertDialog.Builder(getActivity());
                view.setTitle("Pilih TV-Out:");
                view.setSingleChoiceItems(cdma_hp, -1, new android.content.DialogInterface.OnClickListener() {

                    final _cls39 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        i;
                        JVM INSTR tableswitch 0 2: default 28
                    //                                   0 35
                    //                                   1 68
                    //                                   2 101;
                           goto _L1 _L2 _L3 _L4
_L1:
                        dialoginterface.dismiss();
                        return;
_L2:
                        btnPencTVOut.setText(cdma_hp[0]);
                        Hal1Pencarian.strPencTVOut = "nil";
                        continue; /* Loop/switch isn't completed */
_L3:
                        btnPencTVOut.setText(cdma_hp[1]);
                        Hal1Pencarian.strPencTVOut = "1";
                        continue; /* Loop/switch isn't completed */
_L4:
                        btnPencTVOut.setText(cdma_hp[2]);
                        Hal1Pencarian.strPencTVOut = "2";
                        if (true) goto _L1; else goto _L5
_L5:
                    }

            
            {
                this$1 = _cls39.this;
                super();
            }
                });
                view.show();
            }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }
        });
        btnPencInfrared.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Pencarian this$0;

            public void onClick(View view)
            {
                view = new android.app.AlertDialog.Builder(getActivity());
                view.setTitle("Pilih Infrared:");
                view.setSingleChoiceItems(cdma_hp, -1, new android.content.DialogInterface.OnClickListener() {

                    final _cls40 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        i;
                        JVM INSTR tableswitch 0 2: default 28
                    //                                   0 35
                    //                                   1 68
                    //                                   2 101;
                           goto _L1 _L2 _L3 _L4
_L1:
                        dialoginterface.dismiss();
                        return;
_L2:
                        btnPencInfrared.setText(cdma_hp[0]);
                        Hal1Pencarian.strPencInfrared = "nil";
                        continue; /* Loop/switch isn't completed */
_L3:
                        btnPencInfrared.setText(cdma_hp[1]);
                        Hal1Pencarian.strPencInfrared = "1";
                        continue; /* Loop/switch isn't completed */
_L4:
                        btnPencInfrared.setText(cdma_hp[2]);
                        Hal1Pencarian.strPencInfrared = "2";
                        if (true) goto _L1; else goto _L5
_L5:
                    }

            
            {
                this$1 = _cls40.this;
                super();
            }
                });
                view.show();
            }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }
        });
        btnPencMusik.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Pencarian this$0;

            public void onClick(View view)
            {
                view = new android.app.AlertDialog.Builder(getActivity());
                view.setTitle("Pilih Musik:");
                view.setSingleChoiceItems(cdma_hp, -1, new android.content.DialogInterface.OnClickListener() {

                    final _cls41 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        i;
                        JVM INSTR tableswitch 0 2: default 28
                    //                                   0 35
                    //                                   1 68
                    //                                   2 101;
                           goto _L1 _L2 _L3 _L4
_L1:
                        dialoginterface.dismiss();
                        return;
_L2:
                        btnPencMusik.setText(cdma_hp[0]);
                        Hal1Pencarian.strPencMusik = "nil";
                        continue; /* Loop/switch isn't completed */
_L3:
                        btnPencMusik.setText(cdma_hp[1]);
                        Hal1Pencarian.strPencMusik = "1";
                        continue; /* Loop/switch isn't completed */
_L4:
                        btnPencMusik.setText(cdma_hp[2]);
                        Hal1Pencarian.strPencMusik = "2";
                        if (true) goto _L1; else goto _L5
_L5:
                    }

            
            {
                this$1 = _cls41.this;
                super();
            }
                });
                view.show();
            }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }
        });
        btnPencRadio.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Pencarian this$0;

            public void onClick(View view)
            {
                view = new android.app.AlertDialog.Builder(getActivity());
                view.setTitle("Pilih Radio:");
                view.setSingleChoiceItems(cdma_hp, -1, new android.content.DialogInterface.OnClickListener() {

                    final _cls42 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        i;
                        JVM INSTR tableswitch 0 2: default 28
                    //                                   0 35
                    //                                   1 68
                    //                                   2 101;
                           goto _L1 _L2 _L3 _L4
_L1:
                        dialoginterface.dismiss();
                        return;
_L2:
                        btnPencRadio.setText(cdma_hp[0]);
                        Hal1Pencarian.strPencRadio = "nil";
                        continue; /* Loop/switch isn't completed */
_L3:
                        btnPencRadio.setText(cdma_hp[1]);
                        Hal1Pencarian.strPencRadio = "1";
                        continue; /* Loop/switch isn't completed */
_L4:
                        btnPencRadio.setText(cdma_hp[2]);
                        Hal1Pencarian.strPencRadio = "2";
                        if (true) goto _L1; else goto _L5
_L5:
                    }

            
            {
                this$1 = _cls42.this;
                super();
            }
                });
                view.show();
            }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }
        });
        btnPencTVAnalog.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Pencarian this$0;

            public void onClick(View view)
            {
                view = new android.app.AlertDialog.Builder(getActivity());
                view.setTitle("Pilih TV Analog:");
                view.setSingleChoiceItems(cdma_hp, -1, new android.content.DialogInterface.OnClickListener() {

                    final _cls43 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        i;
                        JVM INSTR tableswitch 0 2: default 28
                    //                                   0 35
                    //                                   1 68
                    //                                   2 101;
                           goto _L1 _L2 _L3 _L4
_L1:
                        dialoginterface.dismiss();
                        return;
_L2:
                        btnPencTVAnalog.setText(cdma_hp[0]);
                        Hal1Pencarian.strPencTVAnalog = "nil";
                        continue; /* Loop/switch isn't completed */
_L3:
                        btnPencTVAnalog.setText(cdma_hp[1]);
                        Hal1Pencarian.strPencTVAnalog = "1";
                        continue; /* Loop/switch isn't completed */
_L4:
                        btnPencTVAnalog.setText(cdma_hp[2]);
                        Hal1Pencarian.strPencTVAnalog = "2";
                        if (true) goto _L1; else goto _L5
_L5:
                    }

            
            {
                this$1 = _cls43.this;
                super();
            }
                });
                view.show();
            }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }
        });
        btnPencGPS.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Pencarian this$0;

            public void onClick(View view)
            {
                view = new android.app.AlertDialog.Builder(getActivity());
                view.setTitle("Pilih GPS built-in:");
                view.setSingleChoiceItems(cdma_hp, -1, new android.content.DialogInterface.OnClickListener() {

                    final _cls44 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        i;
                        JVM INSTR tableswitch 0 2: default 28
                    //                                   0 35
                    //                                   1 68
                    //                                   2 101;
                           goto _L1 _L2 _L3 _L4
_L1:
                        dialoginterface.dismiss();
                        return;
_L2:
                        btnPencGPS.setText(cdma_hp[0]);
                        Hal1Pencarian.strPencGPS = "nil";
                        continue; /* Loop/switch isn't completed */
_L3:
                        btnPencGPS.setText(cdma_hp[1]);
                        Hal1Pencarian.strPencGPS = "1";
                        continue; /* Loop/switch isn't completed */
_L4:
                        btnPencGPS.setText(cdma_hp[2]);
                        Hal1Pencarian.strPencGPS = "2";
                        if (true) goto _L1; else goto _L5
_L5:
                    }

            
            {
                this$1 = _cls44.this;
                super();
            }
                });
                view.show();
            }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }
        });
        btnPencBaterai.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Pencarian this$0;

            public void onClick(View view)
            {
                view = new android.app.AlertDialog.Builder(getActivity());
                view.setTitle("Pilih Minimal Baterai:");
                view.setSingleChoiceItems(baterai_hp, -1, new android.content.DialogInterface.OnClickListener() {

                    final _cls45 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        i;
                        JVM INSTR tableswitch 0 9: default 56
                    //                                   0 63
                    //                                   1 96
                    //                                   2 129
                    //                                   3 162
                    //                                   4 195
                    //                                   5 228
                    //                                   6 261
                    //                                   7 295
                    //                                   8 329
                    //                                   9 363;
                           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L1:
                        dialoginterface.dismiss();
                        return;
_L2:
                        btnPencBaterai.setText(baterai_hp[0]);
                        Hal1Pencarian.strPencBaterai = "nil";
                        continue; /* Loop/switch isn't completed */
_L3:
                        btnPencBaterai.setText(baterai_hp[1]);
                        Hal1Pencarian.strPencBaterai = "800";
                        continue; /* Loop/switch isn't completed */
_L4:
                        btnPencBaterai.setText(baterai_hp[2]);
                        Hal1Pencarian.strPencBaterai = "1000";
                        continue; /* Loop/switch isn't completed */
_L5:
                        btnPencBaterai.setText(baterai_hp[3]);
                        Hal1Pencarian.strPencBaterai = "1300";
                        continue; /* Loop/switch isn't completed */
_L6:
                        btnPencBaterai.setText(baterai_hp[4]);
                        Hal1Pencarian.strPencBaterai = "1600";
                        continue; /* Loop/switch isn't completed */
_L7:
                        btnPencBaterai.setText(baterai_hp[5]);
                        Hal1Pencarian.strPencBaterai = "2000";
                        continue; /* Loop/switch isn't completed */
_L8:
                        btnPencBaterai.setText(baterai_hp[6]);
                        Hal1Pencarian.strPencBaterai = "2500";
                        continue; /* Loop/switch isn't completed */
_L9:
                        btnPencBaterai.setText(baterai_hp[7]);
                        Hal1Pencarian.strPencBaterai = "3000";
                        continue; /* Loop/switch isn't completed */
_L10:
                        btnPencBaterai.setText(baterai_hp[8]);
                        Hal1Pencarian.strPencBaterai = "5000";
                        continue; /* Loop/switch isn't completed */
_L11:
                        btnPencBaterai.setText(baterai_hp[9]);
                        Hal1Pencarian.strPencBaterai = "10000";
                        if (true) goto _L1; else goto _L12
_L12:
                    }

            
            {
                this$1 = _cls45.this;
                super();
            }
                });
                view.show();
            }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }
        });
        btnCariSubmit.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Pencarian this$0;

            public void onClick(View view)
            {
                queryUrl = (new StringBuilder("&merek=")).append(Hal1Pencarian.strPencMerek).append("&umu_status=").append(Hal1Pencarian.strPencStatus).append("&hrg_baru=").append(Hal1Pencarian.strPencHarga).append("&jar_2g_status=").append(Hal1Pencarian.strPenc2G).append("&jar_3g_status=").append(Hal1Pencarian.strPenc3G).append("&jar_4g_status=").append(Hal1Pencarian.strPenc4G).append("&jar_gprs_status=").append(Hal1Pencarian.strPencGPRS).append("&jar_edge_status=").append(Hal1Pencarian.strPencEDGE).append("&jar_2g_cdma_status=").append(Hal1Pencarian.strPencCDMA).append("&jar_sc=").append(Hal1Pencarian.strPencSIM).append("&jar_multi_status=").append(Hal1Pencarian.strPencMulti).append("&jar_multi_tipe2=").append(Hal1Pencarian.strPencGSMCDMA).append("&kam_nat_vcall=").append(Hal1Pencarian.strPencNative).append("&umu_model=").append(Hal1Pencarian.strPencModel).append("&umu_dim_panjang=").append(Hal1Pencarian.strPencPanjang).append("&umu_dim_lebar=").append(Hal1Pencarian.strPencLebar).append("&umu_dim_tebal=").append(Hal1Pencarian.strPencTebal).append("&umu_bobot=").append(Hal1Pencarian.strPencBobot).append("&sof_os=").append(Hal1Pencarian.strPencSistem).append("&har_cpu_clock=").append(Hal1Pencarian.strPencProsessor).append("&har_cpu_core=").append(Hal1Pencarian.strPencCore).append("&mem_ram=").append(Hal1Pencarian.strPencRAM).append("&mem_internal=").append(Hal1Pencarian.strPencInternal).append("&mem_eksternal=").append(Hal1Pencarian.strPencEksternal).append("&lay_size_diagonal=").append(Hal1Pencarian.strPencUkuranLayar).append("&lay_size_ppi=").append(Hal1Pencarian.strPencKerapatanLayar).append("&lay_touchscreen_status=").append(Hal1Pencarian.strPencLayarSentuh).append("&lay_touchscreen=").append(Hal1Pencarian.strPencJenisSentuh).append("&kam_utama=").append(Hal1Pencarian.strPencKamera).append("&kam_depan_status=").append(Hal1Pencarian.strPencKameraDepan).append("&kam_led_flash_status=").append(Hal1Pencarian.strPencLampu).append("&kam_video=").append(Hal1Pencarian.strPencVideoRecorder).append("&kon_bluetooth_status=").append(Hal1Pencarian.strPencBluetooth).append("&kon_usb_status=").append(Hal1Pencarian.strPencUSB).append("&kon_35mm_jack=").append(Hal1Pencarian.strPenc35).append("&kon_wlan_status=").append(Hal1Pencarian.strPencWiFi).append("&kon_nfc_status=").append(Hal1Pencarian.strPencNFC).append("&kon_hdmi_status=").append(Hal1Pencarian.strPencHDMI).append("&kon_tvoutput_status=").append(Hal1Pencarian.strPencTVOut).append("&kon_infrared=").append(Hal1Pencarian.strPencInfrared).append("&fit_musik_status=").append(Hal1Pencarian.strPencMusik).append("&fit_radio_status=").append(Hal1Pencarian.strPencRadio).append("&fit_tvanalog=").append(Hal1Pencarian.strPencTVAnalog).append("&fit_gps_status=").append(Hal1Pencarian.strPencGPS).append("&bat_kapasitas=").append(Hal1Pencarian.strPencBaterai).toString();
                view = ((BasePencarianActivity)getActivity()).getHal2HasilPenc();
                ((Hal2HasilPencarian)getActivity().getSupportFragmentManager().findFragmentByTag(view)).StatistikTask();
                BasePencarianActivity.mPager.setCurrentItem(1, true);
            }

            
            {
                this$0 = Hal1Pencarian.this;
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
