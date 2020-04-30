// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.servicenter;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.scdetail.SCDetailPager;
import com.inponsel.android.utils.AnimateFirstDisplayListener;
import com.inponsel.android.utils.DatabaseHandler;
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
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.servicenter:
//            SCPencarian

public class Hal2SCHasil extends SherlockFragment
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
        final Hal2SCHasil this$0;
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
                        view = new android.app.AlertDialog.Builder(getActivity());
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
            this$0 = Hal2SCHasil.this;
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
            catch (Hal2SCHasil hal2schasil)
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

    private class SearchTask extends AsyncTask
    {

        final Hal2SCHasil this$0;

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
                    break MISSING_BLOCK_LABEL_405;
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
                    break MISSING_BLOCK_LABEL_412;
                }
                i = 0;
            }
            if (i >= inponsel.length())
            {
                break MISSING_BLOCK_LABEL_412;
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
                break MISSING_BLOCK_LABEL_72;
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
            progressbar_middleSC.setVisibility(8);
            if (pencarianArray.size() != 0)
            {
                break MISSING_BLOCK_LABEL_140;
            }
            Log.e("listsc", "gone");
            listSCManual.setVisibility(8);
            layout_empty_sc.setVisibility(0);
            txt_empty_sc.setText("Service center belum tersedia");
_L1:
            pencarianAdapter.notifyDataSetChanged();
            getSherlockActivity().setProgressBarIndeterminateVisibility(false);
            getSherlockActivity().setProgressBarVisibility(false);
            return;
            try
            {
                Log.e("listsc", "visible");
                listSCManual.setVisibility(0);
                layout_empty_sc.setVisibility(8);
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
              goto _L1
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            pencarianArray.clear();
            layout_empty_sc.setVisibility(0);
            txt_empty_sc.setText("Memuat");
            progressbar_middleSC.setVisibility(0);
        }

        private SearchTask()
        {
            this$0 = Hal2SCHasil.this;
            super();
        }

        SearchTask(SearchTask searchtask)
        {
            this();
        }
    }


    private ImageLoadingListener animateFirstListener;
    ConnectivityManager cm;
    String dataSearch;
    EditText edtAutoSC;
    String getJson;
    JSONArray inponsel;
    String key;
    LinearLayout layout_empty_sc;
    ListView listSCManual;
    ListPencarianAdapter pencarianAdapter;
    ArrayList pencarianArray;
    ProgressBar progressbar_middleSC;
    String strPencMerek;
    String suc;
    String t;
    TextView txt_empty_sc;

    public Hal2SCHasil()
    {
        t = Utility.session(RestClient.pelihara);
        pencarianArray = null;
        getJson = "";
        inponsel = null;
        suc = "";
        animateFirstListener = new AnimateFirstDisplayListener();
    }

    public void SearchManualTask()
    {
        Log.e("SearchManualTask", dataSearch);
        progressbar_middleSC.setVisibility(0);
        getSherlockActivity().setProgressBarIndeterminateVisibility(true);
        getSherlockActivity().setProgressBarVisibility(true);
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

    public void SearchTask()
    {
        dataSearch = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("servicenter").append(Utility.BASE_FORMAT).append("?idm=").append(strPencMerek).append("&key=").append(key).append("&lmt=0&t=").append(t).toString();
        Log.e("dataSearch", dataSearch);
        progressbar_middleSC.setVisibility(0);
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

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = (ViewGroup)layoutinflater.inflate(0x7f030109, null);
        viewgroup = getTag();
        ((SCPencarian)getActivity()).setHal2SCHasil(viewgroup);
        edtAutoSC = (EditText)layoutinflater.findViewById(0x7f0b081e);
        edtAutoSC.setHint(Html.fromHtml("<small>Ketik: merek, provinsi, kota atau kecamatan</small>"));
        t = Utility.session(t);
        progressbar_middleSC = (ProgressBar)layoutinflater.findViewById(0x7f0b081f);
        cm = (ConnectivityManager)getActivity().getSystemService("connectivity");
        layout_empty_sc = (LinearLayout)layoutinflater.findViewById(0x7f0b0530);
        listSCManual = (ListView)layoutinflater.findViewById(0x7f0b0820);
        txt_empty_sc = (TextView)layoutinflater.findViewById(0x7f0b0531);
        pencarianArray = new ArrayList();
        t = Utility.session(t);
        pencarianAdapter = new ListPencarianAdapter(getActivity(), 0x7f030120, pencarianArray);
        listSCManual.setAdapter(pencarianAdapter);
        listSCManual.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final Hal2SCHasil this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = new Intent(getActivity(), com/inponsel/android/scdetail/SCDetailPager);
                adapterview.putExtra("sc_id", pencarianAdapter.getListModel(i).getId_sc());
                adapterview.putExtra("sc_logo", pencarianAdapter.getListModel(i).getSc_logo());
                adapterview.putExtra("sc_c_center", pencarianAdapter.getListModel(i).getSc_c_center());
                adapterview.putExtra("sc_ven_center", pencarianAdapter.getListModel(i).getSc_ven_center());
                adapterview.putExtra("sc_nama", pencarianAdapter.getListModel(i).getSc_nama());
                adapterview.putExtra("sc_merk", pencarianAdapter.getListModel(i).getSc_merk());
                adapterview.putExtra("sc_fb", pencarianAdapter.getListModel(i).getSc_fb());
                adapterview.putExtra("sc_ytube", pencarianAdapter.getListModel(i).getSc_ytube());
                adapterview.putExtra("sc_fb_id", pencarianAdapter.getListModel(i).getSc_fb_id());
                adapterview.putExtra("sc_fb_id", pencarianAdapter.getListModel(i).getSc_fb_id());
                adapterview.putExtra("sc_tw", pencarianAdapter.getListModel(i).getSc_tw());
                adapterview.putExtra("sc_alamat", pencarianAdapter.getListModel(i).getSc_alamat());
                adapterview.putExtra("sc_no_telp", pencarianAdapter.getListModel(i).getSc_no_telp());
                adapterview.putExtra("sc_no_telp_ket", pencarianAdapter.getListModel(i).getSc_no_telp_ket());
                adapterview.putExtra("sc_email", pencarianAdapter.getListModel(i).getSc_email());
                adapterview.putExtra("sc_web", pencarianAdapter.getListModel(i).getSc_web_url());
                adapterview.putExtra("sc_rateAvg", pencarianAdapter.getListModel(i).getSc_rate());
                adapterview.putExtra("sc_rate1", pencarianAdapter.getListModel(i).getSc_rate1());
                adapterview.putExtra("sc_rate2", pencarianAdapter.getListModel(i).getSc_rate2());
                adapterview.putExtra("sc_rate3", pencarianAdapter.getListModel(i).getSc_rate3());
                adapterview.putExtra("sc_rate4", pencarianAdapter.getListModel(i).getSc_rate4());
                adapterview.putExtra("sc_rate5", pencarianAdapter.getListModel(i).getSc_rate5());
                adapterview.putExtra("sc_total_rate", pencarianAdapter.getListModel(i).getSc_total_rate());
                startActivityForResult(adapterview, 0);
                getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = Hal2SCHasil.this;
                super();
            }
        });
        return layoutinflater;
    }

    public void sc_updateParam(String s, String s1, String s2)
    {
        dataSearch = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("sc_pen_manual").append(Utility.BASE_FORMAT).append("?idm=").append(s).append("&idp=").append(s1).append("&idk=").append(s2).append("&t=").append(t).toString();
    }

}
