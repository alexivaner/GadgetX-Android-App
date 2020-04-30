// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.daftarharga;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.actionbarsherlock.app.SherlockFragment;
import com.google.android.gms.analytics.Tracker;
import com.inponsel.android.adapter.ListMerkAdapter;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.pencarianrinci.PencarianRinciPonsel;
import com.inponsel.android.utils.ClickSpan;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.daftarharga:
//            BaseDaftarActivity, Hal2Hasil

public class Hal1Preference extends SherlockFragment
{
    private class OSSync extends AsyncTask
    {

        final Hal1Preference this$0;

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
            if (listProvArrayList.size() != 0)
            {
                break MISSING_BLOCK_LABEL_247;
            }
            txtEmpty.setText("Gagal terhubung ke server");
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
                Toast.makeText(getActivity(), getString(0x7f0c005a), 0).show();
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
            this$0 = Hal1Preference.this;
            super();
        }

        OSSync(OSSync ossync)
        {
            this();
        }
    }


    public static String devices = "67";
    public static android.content.SharedPreferences.Editor editor;
    public static String hargaAtas;
    public static String hargaBawah;
    public static String os = "000";
    public static SharedPreferences prefs;
    Button btnAbaikan;
    ImageButton btnCari;
    Button btnRangeHarga;
    ImageButton btnRangeHargaSearch;
    ConnectivityManager cm;
    int count;
    private DecimalFormat df;
    private DecimalFormat dfnd;
    Dialog dialog;
    String display;
    EditText edtHarga;
    Button edtOS;
    String getJson;
    private boolean hasFractionalPart;
    LinearLayout headerView;
    LayoutInflater layoutInflater;
    LinearLayout layout_empty;
    ListView listHp;
    ListMerkAdapter listMerkAdapter;
    ArrayList listProvArrayList;
    ArrayList osArray;
    ArrayList osArrayID;
    String os_hp[];
    String os_hpID[];
    ProgressBar progressbar_middle_dialog;
    String range[] = {
        "Tampil semua", "Dibawah 500.000", "500.000 s/d 1.500.000", "1.500.000 s/d 2.500.000", "2.500.000 s/d 3.500.000", "3.500.000 s/d 4.500.000", "4.500.000 s/d 5.500.000", "Diatas 5.500.000"
    };
    RadioButton rbPonsel;
    RadioButton rbPonselTablet;
    RadioButton rbTablet;
    RadioGroup rgDevices;
    String sis_os;
    String sis_osID;
    String t;
    TextView titleDaftarHP;
    TextView txtEmpty;
    TextView txtPencarianHarga;
    String v;

    public Hal1Preference()
    {
        t = Utility.session(RestClient.pelihara);
        listProvArrayList = null;
        osArray = null;
        osArrayID = null;
    }

    public static void clickify(TextView textview, String s, com.inponsel.android.utils.ClickSpan.OnClickListener onclicklistener)
    {
        CharSequence charsequence = textview.getText();
        String s1 = charsequence.toString();
        onclicklistener = new ClickSpan(onclicklistener);
        int i = s1.indexOf(s);
        int j = i + s.length();
        if (i != -1)
        {
            if (charsequence instanceof Spannable)
            {
                ((Spannable)charsequence).setSpan(onclicklistener, i, j, 33);
            } else
            {
                s = SpannableString.valueOf(charsequence);
                s.setSpan(onclicklistener, i, j, 33);
                textview.setText(s);
            }
            s = textview.getMovementMethod();
            if (s == null || !(s instanceof LinkMovementMethod))
            {
                textview.setMovementMethod(LinkMovementMethod.getInstance());
                return;
            }
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

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        try
        {
            viewgroup = ((PonselBaseApp)getActivity().getApplication()).getTracker(com.inponsel.android.adapter.PonselBaseApp.TrackerName.APP_TRACKER);
            viewgroup.setScreenName("Daftar Harga");
            viewgroup.send((new com.google.android.gms.analytics.HitBuilders.AppViewBuilder()).build());
        }
        // Misplaced declaration of an exception variable
        catch (ViewGroup viewgroup)
        {
            viewgroup.printStackTrace();
        }
        layoutinflater = (ViewGroup)layoutinflater.inflate(0x7f030099, null);
        os = "000";
        devices = "67";
        hargaBawah = "";
        hargaAtas = "";
        t = Utility.session(t);
        rgDevices = (RadioGroup)layoutinflater.findViewById(0x7f0b00dd);
        rbPonselTablet = (RadioButton)layoutinflater.findViewById(0x7f0b00de);
        rbPonselTablet.setText(" Ponsel & Tablet PC");
        rbPonsel = (RadioButton)layoutinflater.findViewById(0x7f0b00df);
        rbTablet = (RadioButton)layoutinflater.findViewById(0x7f0b00e0);
        headerView = (LinearLayout)getActivity().getLayoutInflater().inflate(0x7f030037, null);
        btnAbaikan = (Button)headerView.findViewById(0x7f0b00b8);
        edtOS = (Button)layoutinflater.findViewById(0x7f0b00e1);
        edtHarga = (EditText)layoutinflater.findViewById(0x7f0b00e4);
        cm = (ConnectivityManager)getActivity().getSystemService("connectivity");
        btnRangeHarga = (Button)layoutinflater.findViewById(0x7f0b00e3);
        t = Utility.session(t);
        btnCari = (ImageButton)layoutinflater.findViewById(0x7f0b00e5);
        btnCari.setEnabled(false);
        btnRangeHargaSearch = (ImageButton)layoutinflater.findViewById(0x7f0b00e6);
        btnRangeHargaSearch.setEnabled(false);
        txtPencarianHarga = (TextView)layoutinflater.findViewById(0x7f0b00e7);
        txtPencarianHarga.setText("Ingin pencarian lebih akurat? Klik disini");
        clickify(txtPencarianHarga, "Klik disini", new com.inponsel.android.utils.ClickSpan.OnClickListener() {

            final Hal1Preference this$0;

            public void onClick()
            {
                Intent intent = new Intent(getActivity(), com/inponsel/android/pencarianrinci/PencarianRinciPonsel);
                startActivityForResult(intent, 0);
                getActivity().overridePendingTransition(0x7f040001, 0x7f040002);
            }

            
            {
                this$0 = Hal1Preference.this;
                super();
            }
        });
        rbPonselTablet.setChecked(true);
        rgDevices.setOnCheckedChangeListener(new android.widget.RadioGroup.OnCheckedChangeListener() {

            final Hal1Preference this$0;

            public void onCheckedChanged(RadioGroup radiogroup, int i)
            {
                if (rbPonselTablet.isChecked())
                {
                    Hal1Preference.devices = "67";
                    return;
                }
                if (rbTablet.isChecked())
                {
                    Hal1Preference.devices = "7";
                    return;
                } else
                {
                    Hal1Preference.devices = "6";
                    return;
                }
            }

            
            {
                this$0 = Hal1Preference.this;
                super();
            }
        });
        edtOS.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Preference this$0;

            public void onClick(View view)
            {
                ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(edtOS.getWindowToken(), 0);
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
                            edtOS.setText(adapterview);
                            Hal1Preference.os = os_hpID[i - 1];
                            Log.e("os_hpID", os_hpID[i - 1]);
                            dialog.dismiss();
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
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new OSSync(null)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[] {
                            (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("os_list").append(Utility.BASE_FORMAT).append("?t=").append(t).toString()
                        });
                    } else
                    {
                        (new OSSync(null)).execute(new String[] {
                            (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("os_list").append(Utility.BASE_FORMAT).append("?t=").append(t).toString()
                        });
                    }
                    listHp.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                        final _cls3 this$1;

                        public void onItemClick(AdapterView adapterview, View view, int i, long l)
                        {
                            Hal1Preference.os = listMerkAdapter.getListModel(i - 1).getId_merk().toString();
                            edtOS.setText(listMerkAdapter.getListModel(i - 1).getMerk().toString());
                            dialog.dismiss();
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
                        edtOS.setText("Sistem Operasi : Abaikan");
                        Hal1Preference.os = "000";
                        dialog.dismiss();
                    }

            
            {
                this$1 = _cls3.this;
                super();
            }
                });
                dialog = view.create();
                dialog.show();
            }


            
            {
                this$0 = Hal1Preference.this;
                super();
            }
        });
        btnRangeHarga.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Preference this$0;

            public void onClick(View view)
            {
                view = new android.app.AlertDialog.Builder(getActivity());
                view.setTitle("Pilih Harga Maksimal :");
                view.setSingleChoiceItems(range, -1, new android.content.DialogInterface.OnClickListener() {

                    final _cls4 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        i;
                        JVM INSTR tableswitch 0 7: default 48
                    //                                   0 69
                    //                                   1 107
                    //                                   2 145
                    //                                   3 183
                    //                                   4 221
                    //                                   5 259
                    //                                   6 297
                    //                                   7 336;
                           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L1:
                        btnRangeHargaSearch.setEnabled(true);
                        dialoginterface.dismiss();
                        return;
_L2:
                        btnRangeHarga.setText(range[0]);
                        Hal1Preference.hargaBawah = "10";
                        Hal1Preference.hargaAtas = "5000000000";
                        continue; /* Loop/switch isn't completed */
_L3:
                        btnRangeHarga.setText(range[1]);
                        Hal1Preference.hargaBawah = "10";
                        Hal1Preference.hargaAtas = "500000";
                        continue; /* Loop/switch isn't completed */
_L4:
                        btnRangeHarga.setText(range[2]);
                        Hal1Preference.hargaBawah = "500000";
                        Hal1Preference.hargaAtas = "1500000";
                        continue; /* Loop/switch isn't completed */
_L5:
                        btnRangeHarga.setText(range[3]);
                        Hal1Preference.hargaBawah = "1500000";
                        Hal1Preference.hargaAtas = "2500000";
                        continue; /* Loop/switch isn't completed */
_L6:
                        btnRangeHarga.setText(range[4]);
                        Hal1Preference.hargaBawah = "2500000";
                        Hal1Preference.hargaAtas = "3500000";
                        continue; /* Loop/switch isn't completed */
_L7:
                        btnRangeHarga.setText(range[5]);
                        Hal1Preference.hargaBawah = "3500000";
                        Hal1Preference.hargaAtas = "4500000";
                        continue; /* Loop/switch isn't completed */
_L8:
                        btnRangeHarga.setText(range[6]);
                        Hal1Preference.hargaBawah = "4500000";
                        Hal1Preference.hargaAtas = "5500000";
                        continue; /* Loop/switch isn't completed */
_L9:
                        btnRangeHarga.setText(range[7]);
                        Hal1Preference.hargaBawah = "5500000";
                        Hal1Preference.hargaAtas = "1000000000";
                        if (true) goto _L1; else goto _L10
_L10:
                    }

            
            {
                this$1 = _cls4.this;
                super();
            }
                });
                view.show();
            }


            
            {
                this$0 = Hal1Preference.this;
                super();
            }
        });
        btnCari.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Preference this$0;

            public void onClick(View view)
            {
                if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected())
                {
                    if (edtHarga.getText().length() == 0)
                    {
                        Toast.makeText(getActivity(), "Harga belum diisi", 1).show();
                        return;
                    }
                    Hal1Preference.hargaBawah = "10";
                    Hal1Preference.hargaAtas = edtHarga.getText().toString().trim();
                    Hal1Preference.hargaAtas = Hal1Preference.hargaAtas.replace(".", "").trim();
                    if (Integer.parseInt(Hal1Preference.hargaAtas) < 0x186a0)
                    {
                        Toast.makeText(getActivity(), "Budget minimal 100.000", 1).show();
                        return;
                    }
                    ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(edtHarga.getWindowToken(), 0);
                    int i = Integer.parseInt(Hal1Preference.hargaAtas);
                    int j;
                    if (i >= 0x7a120 && i <= 0xf4240)
                    {
                        j = i - 0x249f0;
                        i += 0x249f0;
                    } else
                    if (i >= 0xf4240 && i <= 0x1e8480)
                    {
                        j = i - 0x2ab98;
                        i += 0x2ab98;
                    } else
                    if (i >= 0x1e8480 && i <= 0x2dc6c0)
                    {
                        j = i - 0x3d090;
                        i += 0x3d090;
                    } else
                    if (i >= 0x2dc6c0 && i <= 0x3d0900)
                    {
                        j = i - 0x55730;
                        i += 0x55730;
                    } else
                    if (i >= 0x3d0900 && i <= 0x53ec60)
                    {
                        j = i - 0x6ddd0;
                        i += 0x6ddd0;
                    } else
                    if (i >= 0x53ec60)
                    {
                        j = i - 0x86470;
                        i += 0x86470;
                    } else
                    {
                        j = i - (i - 10000);
                        i += i - 10000;
                    }
                    Hal1Preference.hargaBawah = String.valueOf(j);
                    Hal1Preference.hargaAtas = String.valueOf(i);
                    count = 0;
                    view = ((BaseDaftarActivity)getActivity()).getHal2Hasil();
                    ((Hal2Hasil)getActivity().getSupportFragmentManager().findFragmentByTag(view)).HargaHpTask();
                    BaseDaftarActivity.mPager.setCurrentItem(1, true);
                    return;
                } else
                {
                    Toast.makeText(getActivity(), "Tidak ada koneksi internet", 0).show();
                    return;
                }
            }

            
            {
                this$0 = Hal1Preference.this;
                super();
            }
        });
        edtHarga.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

            final Hal1Preference this$0;

            public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
            {
                Hal1Preference.hargaBawah = "10";
                Hal1Preference.hargaAtas = edtHarga.getText().toString().trim();
                Hal1Preference.hargaAtas = Hal1Preference.hargaAtas.replace(".", "").trim();
                if (edtHarga.getText().length() != 0) goto _L2; else goto _L1
_L1:
                Toast.makeText(getActivity(), "Harga belum diisi", 1).show();
_L4:
                return false;
_L2:
                int j;
                if (Integer.parseInt(Hal1Preference.hargaAtas) < 0x186a0)
                {
                    Toast.makeText(getActivity(), "Budget minimal 100.000", 1).show();
                    continue; /* Loop/switch isn't completed */
                }
                ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(edtHarga.getWindowToken(), 0);
                i = Integer.parseInt(Hal1Preference.hargaAtas);
                if (i < 0x7a120 || i > 0xf4240)
                {
                    break; /* Loop/switch isn't completed */
                }
                j = i - 0x249f0;
                i += 0x249f0;
_L5:
                Hal1Preference.hargaBawah = String.valueOf(j);
                Hal1Preference.hargaAtas = String.valueOf(i);
                count = 0;
                textview = ((BaseDaftarActivity)getActivity()).getHal2Hasil();
                ((Hal2Hasil)getActivity().getSupportFragmentManager().findFragmentByTag(textview)).HargaHpTask();
                BaseDaftarActivity.mPager.setCurrentItem(1, true);
                if (true) goto _L4; else goto _L3
_L3:
                if (i >= 0xf4240 && i <= 0x1e8480)
                {
                    j = i - 0x2ab98;
                    i += 0x2ab98;
                } else
                if (i >= 0x1e8480 && i <= 0x2dc6c0)
                {
                    j = i - 0x3d090;
                    i += 0x3d090;
                } else
                if (i >= 0x2dc6c0 && i <= 0x3d0900)
                {
                    j = i - 0x55730;
                    i += 0x55730;
                } else
                if (i >= 0x3d0900 && i <= 0x53ec60)
                {
                    j = i - 0x6ddd0;
                    i += 0x6ddd0;
                } else
                if (i >= 0x53ec60)
                {
                    j = i - 0x86470;
                    i += 0x86470;
                } else
                {
                    j = i - (i - 10000);
                    i += i - 10000;
                }
                  goto _L5
                if (true) goto _L4; else goto _L6
_L6:
            }

            
            {
                this$0 = Hal1Preference.this;
                super();
            }
        });
        df = new DecimalFormat("#,###.##");
        df.setDecimalSeparatorAlwaysShown(true);
        dfnd = new DecimalFormat("#,###");
        hasFractionalPart = false;
        edtHarga.addTextChangedListener(new TextWatcher() {

            final Hal1Preference this$0;

            public void afterTextChanged(Editable editable)
            {
                int i;
                int j;
                if (edtHarga.getText().toString().length() < 6)
                {
                    btnCari.setEnabled(false);
                } else
                {
                    btnCari.setEnabled(true);
                }
                edtHarga.removeTextChangedListener(this);
                i = edtHarga.getText().length();
                v = editable.toString().substring(0, i);
                v = v.replace(".", ",");
                v = v.replace(String.valueOf(df.getDecimalFormatSymbols().getGroupingSeparator()), "");
                editable = df.parse(v);
                j = edtHarga.getSelectionStart();
                if (!hasFractionalPart) goto _L2; else goto _L1
_L1:
                display = df.format(editable);
                display = display.replace(",", ".");
                display = display.substring(0, display.length() - 1);
                edtHarga.setText(display);
_L3:
                i = j + (edtHarga.getText().length() - i);
                if (i <= 0)
                {
                    break MISSING_BLOCK_LABEL_399;
                }
                if (i > edtHarga.getText().length())
                {
                    break MISSING_BLOCK_LABEL_399;
                }
                edtHarga.setSelection(i);
_L4:
                edtHarga.addTextChangedListener(this);
                return;
_L2:
                display = dfnd.format(editable);
                display = display.replace(",", ".");
                edtHarga.setText(display);
                  goto _L3
                try
                {
                    edtHarga.setSelection(edtHarga.getText().length() - 1);
                }
                // Misplaced declaration of an exception variable
                catch (Editable editable) { }
                // Misplaced declaration of an exception variable
                catch (Editable editable) { }
                  goto _L4
            }

            public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
            {
                if (edtHarga.getText().toString().length() < 6)
                {
                    btnCari.setEnabled(false);
                } else
                {
                    btnCari.setEnabled(true);
                }
                if (charsequence.toString().contains(String.valueOf(df.getDecimalFormatSymbols().getDecimalSeparator())))
                {
                    hasFractionalPart = true;
                    return;
                } else
                {
                    hasFractionalPart = false;
                    return;
                }
            }

            public void onTextChanged(CharSequence charsequence, int i, int j, int k)
            {
                if (edtHarga.getText().toString().length() < 6)
                {
                    btnCari.setEnabled(false);
                    return;
                } else
                {
                    btnCari.setEnabled(true);
                    return;
                }
            }

            
            {
                this$0 = Hal1Preference.this;
                super();
            }
        });
        btnRangeHargaSearch.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1Preference this$0;

            public void onClick(View view)
            {
                if (btnRangeHarga.getText().toString().contains("Pilih rentang harga"))
                {
                    Toast.makeText(getActivity(), "Rentang harga belum dipilih", 1).show();
                    return;
                } else
                {
                    view = ((BaseDaftarActivity)getActivity()).getHal2Hasil();
                    ((Hal2Hasil)getActivity().getSupportFragmentManager().findFragmentByTag(view)).HargaHpTask();
                    BaseDaftarActivity.mPager.setCurrentItem(1, true);
                    return;
                }
            }

            
            {
                this$0 = Hal1Preference.this;
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
