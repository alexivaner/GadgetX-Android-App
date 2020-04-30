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
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.text.Editable;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RatingBar;
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
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.details.DetailsPonsel;
import com.inponsel.android.pencariangen.TabPencarian;
import com.inponsel.android.scdetail.SCDetailPager;
import com.inponsel.android.servicenter.SCPencarian;
import com.inponsel.android.utils.ClickSpan;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.DelayedTextWatcher;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.ExpandedListView;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.ServiceHandler;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.sherlock.navigationdrawer.compat.SherlockActionBarDrawerToggle;
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

// Referenced classes of package com.inponsel.android.v2:
//            BaseDrawer, LoginActivity, SCMoreActivity, SCMerkActivity

public class SCUserActivity extends BaseDrawer
    implements android.view.View.OnClickListener, Observer
{
    private class HpUserTask extends AsyncTask
    {

        final SCUserActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            {
                avoid = (new ServiceHandler()).makeServiceCall(dataHpUser, 1);
                if (avoid == null)
                {
                    break MISSING_BLOCK_LABEL_364;
                }
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
                    break MISSING_BLOCK_LABEL_371;
                }
                i = 0;
            }
            if (i >= inponsel.length())
            {
                break MISSING_BLOCK_LABEL_371;
            }
            avoid = inponsel.getJSONObject(i);
            id_hph = avoid.getString("id_hp");
            id_merk = avoid.getString("id_merk");
            model = avoid.getString("model");
            merk = avoid.getString("merk");
            codename = avoid.getString("codename");
            gambar = avoid.getString("gambar");
            umu_status = avoid.getString("umu_status");
            hrg_baru = avoid.getString("hrg_baru");
            hrg_bekas = avoid.getString("hrg_bekas");
            if (!avoid.getString("id_hp2").equals("0"))
            {
                id_hph2 = avoid.getString("id_hp2");
                id_merk2 = avoid.getString("id_merk2");
                model2 = avoid.getString("model2");
                merk2 = avoid.getString("merk2");
                codename2 = avoid.getString("codename2");
                gambar2 = avoid.getString("gambar2");
                umu_status2 = avoid.getString("umu_status2");
                hrg_baru2 = avoid.getString("hrg_baru2");
                hrg_bekas2 = avoid.getString("hrg_bekas2");
            }
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
            Log.e("tasksdsurlSearch", dataHpUser);
            layout_sc_Merek1.setVisibility(0);
            progressbar_hp_user.setVisibility(8);
            list_txtMerek.setText((new StringBuilder(String.valueOf(merk))).append(" ").append(model).toString());
            if (!hrg_baru.equals("") && !hrg_baru.equals("0") && !hrg_baru.equals("-")) goto _L2; else goto _L1
_L1:
            list_txtHarga.setVisibility(8);
_L5:
            imageLoader2.displayImage(gambar.trim(), imgHp, optionsNotRound, new ImageLoadingListener() {

                final HpUserTask this$1;

                public void onLoadingCancelled(String s, View view)
                {
                }

                public void onLoadingComplete(String s, View view, Bitmap bitmap)
                {
                    progressbar_item.setVisibility(8);
                    imgHp.setVisibility(0);
                }

                public void onLoadingFailed(String s, View view, FailReason failreason)
                {
                    progressbar_item.setVisibility(8);
                    imgHp.setVisibility(0);
                }

                public void onLoadingStarted(String s, View view)
                {
                    progressbar_item.setVisibility(0);
                    imgHp.setVisibility(8);
                }

            
            {
                this$1 = HpUserTask.this;
                super();
            }
            });
            txtBigsc_Merek1.setText((new StringBuilder("Tampilkan semua service center ")).append(merk).toString());
            mainLayout.setOnClickListener(new android.view.View.OnClickListener() {

                final HpUserTask this$1;

                public void onClick(View view)
                {
                    view = new Intent(getApplicationContext(), com/inponsel/android/details/DetailsPonsel);
                    view.putExtra("id_hph", id_hph);
                    view.putExtra("namalengkap", (new StringBuilder(String.valueOf(merk))).append(" ").append(model).toString());
                    view.putExtra("codename", codename);
                    view.putExtra("model", model);
                    view.putExtra("merk", merk);
                    view.putExtra("gambar", gambar);
                    view.putExtra("hrg_baru", hrg_baru);
                    view.putExtra("hrg_bekas", hrg_bekas);
                    view.putExtra("tot_like", "");
                    view.putExtra("tot_dislike", "");
                    view.putExtra("tot_komen", "");
                    startActivityForResult(view, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$1 = HpUserTask.this;
                super();
            }
            });
            mainLayout.setVisibility(0);
            if (!id_hph2.equals("0")) goto _L4; else goto _L3
_L3:
            sc_separator.setVisibility(8);
            mainLayout2.setVisibility(8);
            layout_sc_Merek2.setVisibility(8);
_L6:
            getSherlock().setProgressBarIndeterminateVisibility(false);
            return;
_L2:
            try
            {
                list_txtHarga.setText(hrg_baru);
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                void1.printStackTrace();
                return;
            }
              goto _L5
_L4:
            sc_separator.setVisibility(0);
            list_txtMerek2.setText((new StringBuilder(String.valueOf(merk2))).append(" ").append(model2).toString());
            if (!hrg_baru2.equals("") && !hrg_baru2.equals("0") && !hrg_baru2.equals("-"))
            {
                break MISSING_BLOCK_LABEL_566;
            }
            list_txtHarga2.setVisibility(8);
_L7:
            imageLoader2.displayImage(gambar2.trim(), imgHp2, optionsNotRound, new ImageLoadingListener() {

                final HpUserTask this$1;

                public void onLoadingCancelled(String s, View view)
                {
                }

                public void onLoadingComplete(String s, View view, Bitmap bitmap)
                {
                    progressbar_item2.setVisibility(8);
                    imgHp2.setVisibility(0);
                }

                public void onLoadingFailed(String s, View view, FailReason failreason)
                {
                    progressbar_item2.setVisibility(8);
                    imgHp2.setVisibility(0);
                }

                public void onLoadingStarted(String s, View view)
                {
                    progressbar_item2.setVisibility(0);
                    imgHp2.setVisibility(8);
                }

            
            {
                this$1 = HpUserTask.this;
                super();
            }
            });
            txtBigsc_Merek2.setText((new StringBuilder("Tampilkan semua service center ")).append(merk2).toString());
            mainLayout2.setOnClickListener(new android.view.View.OnClickListener() {

                final HpUserTask this$1;

                public void onClick(View view)
                {
                    view = new Intent(getApplicationContext(), com/inponsel/android/details/DetailsPonsel);
                    view.putExtra("id_hph", id_hph2);
                    view.putExtra("namalengkap", (new StringBuilder(String.valueOf(merk2))).append(" ").append(model2).toString());
                    view.putExtra("codename", codename2);
                    view.putExtra("model", model2);
                    view.putExtra("merk", merk2);
                    view.putExtra("gambar", gambar2);
                    view.putExtra("hrg_baru", hrg_baru2);
                    view.putExtra("hrg_bekas", hrg_bekas);
                    view.putExtra("tot_like", "");
                    view.putExtra("tot_dislike", "");
                    view.putExtra("tot_komen", "");
                    startActivityForResult(view, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$1 = HpUserTask.this;
                super();
            }
            });
            layout_sc_Merek2.setVisibility(0);
            mainLayout2.setVisibility(0);
              goto _L6
            list_txtHarga2.setText(hrg_baru2);
              goto _L7
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            progressbar_hp_user.setVisibility(0);
            mainLayout.setVisibility(8);
        }


        private HpUserTask()
        {
            this$0 = SCUserActivity.this;
            super();
        }

        HpUserTask(HpUserTask hpusertask)
        {
            this();
        }
    }

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
        String hrg_baru;
        String hrg_bekas;
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
        String statusPenc;
        String t;
        final SCUserActivity this$0;
        String user;
        UserFunctions userFunctions;
        String username;

        public void formatToRupiah()
        {
            fmts.setGroupingSeparator('.');
            fmt.setGroupingSize(3);
            fmt.setGroupingUsed(true);
            fmt.setDecimalFormatSymbols(fmts);
            hargaBaru = Integer.parseInt(hrg_baru);
            hargaBekas = Integer.parseInt(hrg_bekas);
            hrg_baru = fmt.format(hargaBaru);
            hrg_bekas = fmt.format(hargaBekas);
        }

        public void formatToRupiahBaru()
        {
            fmts.setGroupingSeparator('.');
            fmt.setGroupingSize(3);
            fmt.setGroupingUsed(true);
            fmt.setDecimalFormatSymbols(fmts);
            hargaBaru = Integer.parseInt(hrg_baru);
            hrg_baru = fmt.format(hargaBaru);
        }

        public void formatToRupiahBekas()
        {
            hargaBekas = Integer.parseInt(hrg_bekas);
            hrg_bekas = fmt.format(hargaBekas);
        }

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
                viewgroup.list_txtHarga = (TextView)view.findViewById(0x7f0b033d);
                viewgroup.list_text_like = (TextView)view.findViewById(0x7f0b0344);
                viewgroup.list_text_dislike = (TextView)view.findViewById(0x7f0b0347);
                viewgroup.list_text_komentar = (TextView)view.findViewById(0x7f0b034a);
                viewgroup.progressbar_item = (ProgressBar)view.findViewById(0x7f0b00b3);
                viewgroup.list_lay_like = (RelativeLayout)view.findViewById(0x7f0b0342);
                viewgroup.list_lay_dislike = (RelativeLayout)view.findViewById(0x7f0b0345);
                viewgroup.list_lay_kom = (RelativeLayout)view.findViewById(0x7f0b0348);
                viewgroup.rateRate = (RatingBar)view.findViewById(0x7f0b00c9);
                viewgroup.headImage = (LinearLayout)view.findViewById(0x7f0b029f);
                view.setTag(viewgroup);
            } else
            {
                viewgroup = (ViewHolder)view.getTag();
            }
            lms = (ListModel)lm.get(i);
            if (lm != null)
            {
                hrg_baru = lms.getHrg_baru();
                hrg_bekas = lms.getHrg_bekas();
                ((ViewHolder) (viewgroup)).list_txtMerek.setText((new StringBuilder(String.valueOf(lms.getMerk()))).append(" ").append(lms.getModel()).toString());
                ((ViewHolder) (viewgroup)).list_lay_like.setVisibility(8);
                ((ViewHolder) (viewgroup)).list_lay_dislike.setVisibility(8);
                ((ViewHolder) (viewgroup)).list_lay_kom.setVisibility(8);
                if (lms.getUmu_status().equals("3") || hrg_baru.equals("-") || hrg_baru.equals("0"))
                {
                    ((ViewHolder) (viewgroup)).list_txtHarga.setVisibility(8);
                } else
                {
                    formatToRupiahBaru();
                    ((ViewHolder) (viewgroup)).list_txtHarga.setVisibility(0);
                    ((ViewHolder) (viewgroup)).list_txtHarga.setText((new StringBuilder("Baru\t: Rp. ")).append(hrg_baru).toString());
                }
                try
                {
                    imageLoader2.displayImage((new StringBuilder(String.valueOf(Util.BASE_PATH_NEWIMAGE))).append(lms.getGambar().trim()).toString(), ((ViewHolder) (viewgroup)).imageHp, options, viewgroup. new ImageLoadingListener() {

                        final ListPencarianAdapter this$1;
                        private final ListPencarianAdapter.ViewHolder val$holder;

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
                this$1 = final_listpencarianadapter;
                holder = ListPencarianAdapter.ViewHolder.this;
                super();
            }
                    });
                }
                // Misplaced declaration of an exception variable
                catch (ViewGroup viewgroup)
                {
                    return view;
                }
            }
            return view;
        }

        void log(String s)
        {
        }

        public void setListArray(ArrayList arraylist)
        {
            lm = arraylist;
        }

        public ListPencarianAdapter(Activity activity1, int i, ArrayList arraylist)
        {
            this$0 = SCUserActivity.this;
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
            catch (SCUserActivity scuseractivity)
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
        TextView list_text_dislike;
        TextView list_text_komentar;
        TextView list_text_like;
        TextView list_txtHarga;
        TextView list_txtMerek;
        ProgressBar progressbar_item;
        RatingBar rateRate;
        final ListPencarianAdapter this$1;

        ListPencarianAdapter.ViewHolder()
        {
            this$1 = ListPencarianAdapter.this;
            super();
        }
    }

    public class ListSCAdapter extends BaseAdapter
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
        final SCUserActivity this$0;
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

                    final ListSCAdapter this$1;

                    public void onClick(View view)
                    {
                        view = new android.app.AlertDialog.Builder(_fld0);
                        view.setTitle("Nomor Telepon :");
                        view.setSingleChoiceItems(no_telp_array, -1, new android.content.DialogInterface.OnClickListener() {

                            final ListSCAdapter._cls1 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent("android.intent.action.DIAL", Uri.parse((new StringBuilder("tel: ")).append(no_telp_array[i].replaceAll("-", "")).toString()));
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = ListSCAdapter._cls1.this;
                super();
            }
                        });
                        view.show();
                    }


            
            {
                this$1 = ListSCAdapter.this;
                super();
            }
                });
                ((ViewHolder) (viewgroup)).list_lay_dislike.setOnClickListener(new android.view.View.OnClickListener() {

                    final ListSCAdapter this$1;

                    public void onClick(View view)
                    {
                    }

            
            {
                this$1 = ListSCAdapter.this;
                super();
            }
                });
                ((ViewHolder) (viewgroup)).list_lay_kom.setOnClickListener(new android.view.View.OnClickListener() {

                    final ListSCAdapter this$1;

                    public void onClick(View view)
                    {
                    }

            
            {
                this$1 = ListSCAdapter.this;
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


        public ListSCAdapter(Activity activity1, int i, ArrayList arraylist)
        {
            this$0 = SCUserActivity.this;
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
            catch (SCUserActivity scuseractivity)
            {
                return;
            }
        }
    }

    class ListSCAdapter.ViewHolder
    {

        LinearLayout headImage;
        ImageView imageHp;
        RelativeLayout list_lay_dislike;
        RelativeLayout list_lay_kom;
        RelativeLayout list_lay_like;
        TextView list_txtAlamat;
        TextView list_txtMerek;
        ProgressBar progressbar_item;
        final ListSCAdapter this$1;

        ListSCAdapter.ViewHolder()
        {
            this$1 = ListSCAdapter.this;
            super();
        }
    }

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
        final SCUserActivity this$0;
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

                    final ListSCProvAdapter this$1;

                    public void onClick(View view)
                    {
                        view = new android.app.AlertDialog.Builder(_fld0);
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
                ((ViewHolder) (viewgroup)).list_lay_dislike.setOnClickListener(new android.view.View.OnClickListener() {

                    final ListSCProvAdapter this$1;

                    public void onClick(View view)
                    {
                    }

            
            {
                this$1 = ListSCProvAdapter.this;
                super();
            }
                });
                ((ViewHolder) (viewgroup)).list_lay_kom.setOnClickListener(new android.view.View.OnClickListener() {

                    final ListSCProvAdapter this$1;

                    public void onClick(View view)
                    {
                    }

            
            {
                this$1 = ListSCProvAdapter.this;
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


        public ListSCProvAdapter(Activity activity1, int i, ArrayList arraylist)
        {
            this$0 = SCUserActivity.this;
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
            catch (SCUserActivity scuseractivity)
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

    private class SCKotaTask extends AsyncTask
    {

        final SCUserActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            {
                avoid = (new ServiceHandler()).makeServiceCall(dataSCKota, 1);
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
            scKotaArray.add(listmodel);
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
            Log.e("tasksdsurlSearch", dataSCKota);
            Log.e("tasksdsurlSearch", String.valueOf(scKotaArray.size()));
            progressbar_sc_kota.setVisibility(8);
            if (scKotaArray.size() != 0)
            {
                break MISSING_BLOCK_LABEL_107;
            }
            listsc_kota.setVisibility(8);
            txtemptysc_kota.setVisibility(0);
_L1:
            scAdapter.notifyDataSetChanged();
            getSherlock().setProgressBarIndeterminateVisibility(false);
            return;
            try
            {
                listsc_kota.setVisibility(0);
                txtemptysc_kota.setVisibility(8);
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
            scKotaArray.clear();
            progressbar_sc_kota.setVisibility(0);
        }

        private SCKotaTask()
        {
            this$0 = SCUserActivity.this;
            super();
        }

        SCKotaTask(SCKotaTask sckotatask)
        {
            this();
        }
    }

    private class SCProvTask extends AsyncTask
    {

        final SCUserActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            {
                avoid = (new ServiceHandler()).makeServiceCall(dataSCProv, 1);
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
            scProvArray.add(listmodel);
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
            Log.e("tasksdsurlSearch", dataSCProv);
            Log.e("tasksdsurlSearch", String.valueOf(scProvArray.size()));
            progressbar_sc_provinsi.setVisibility(8);
            if (scProvArray.size() != 0)
            {
                break MISSING_BLOCK_LABEL_107;
            }
            listsc_provinsi.setVisibility(8);
            txtemptysc_provinsi.setVisibility(0);
_L1:
            scProvAdapter.notifyDataSetChanged();
            getSherlock().setProgressBarIndeterminateVisibility(false);
            return;
            try
            {
                listsc_provinsi.setVisibility(0);
                txtemptysc_provinsi.setVisibility(8);
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
            scProvArray.clear();
            progressbar_sc_provinsi.setVisibility(0);
        }

        private SCProvTask()
        {
            this$0 = SCUserActivity.this;
            super();
        }

        SCProvTask(SCProvTask scprovtask)
        {
            this();
        }
    }

    private class SearchTask extends AsyncTask
    {

        final SCUserActivity this$0;

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
                    break MISSING_BLOCK_LABEL_418;
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
                    break MISSING_BLOCK_LABEL_425;
                }
                i = 0;
            }
            if (i >= inponsel.length())
            {
                break MISSING_BLOCK_LABEL_425;
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
            if (Integer.parseInt(jumSC) <= 5) goto _L2; else goto _L1
_L1:
            txtMoreSCManual.setVisibility(0);
            txtMoreSCManual.setText((new StringBuilder(String.valueOf(jumSC))).append(" Lainnya").toString());
_L3:
            if (scpencarianArray.size() != 0)
            {
                break MISSING_BLOCK_LABEL_184;
            }
            Log.e("listsc", "gone");
            txtMoreSCManual.setVisibility(8);
_L4:
            setProgressBarIndeterminateVisibility(false);
            return;
_L2:
            try
            {
                txtMoreSCManual.setVisibility(8);
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                void1.printStackTrace();
                return;
            }
              goto _L3
            Log.e("listsc", "visible");
            listSCManual.setVisibility(0);
              goto _L4
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            scpencarianArray.clear();
            progressbar_middleSC.setVisibility(0);
            txtMoreSCManual.setVisibility(8);
        }

        private SearchTask()
        {
            this$0 = SCUserActivity.this;
            super();
        }

        SearchTask(SearchTask searchtask)
        {
            this();
        }
    }


    public static android.content.SharedPreferences.Editor editor;
    public static SharedPreferences prefs;
    ConnectivityManager cm;
    String codename;
    String codename2;
    int counterArray;
    String dataHpUser;
    String dataSCKota;
    String dataSCProv;
    String dataSearch;
    EditText edtAutoSC;
    String gambar;
    String gambar2;
    String getJson;
    LinearLayout headImage;
    LinearLayout headImage2;
    String hrg_baru;
    String hrg_baru2;
    String hrg_bekas;
    String hrg_bekas2;
    String id_hph;
    String id_hph2;
    String id_merk;
    String id_merk2;
    ImageView imgHp;
    ImageView imgHp2;
    JSONArray inponsel;
    String jml;
    String jumSC;
    String key;
    LinearLayout layout_hp_user;
    LinearLayout layout_sc_Manual;
    LinearLayout layout_sc_Merek1;
    LinearLayout layout_sc_Merek2;
    LinearLayout layout_sc_kota;
    LinearLayout layout_sc_provinsi;
    ListMerkAdapter listMerkAdapter;
    ArrayList listProvArrayList;
    ExpandedListView listSCManual;
    TextView list_txtHarga;
    TextView list_txtHarga2;
    TextView list_txtMerek;
    TextView list_txtMerek2;
    ExpandedListView listsc_kota;
    ExpandedListView listsc_provinsi;
    Dialog mDialog;
    LinearLayout mainLayout;
    LinearLayout mainLayout2;
    String merk;
    String merk2;
    ArrayList merkArray;
    ArrayList merkArrayID;
    String merk_hp[];
    String merk_hpID[];
    String merk_ven;
    String merk_venID;
    String model;
    String model2;
    LinearLayout mylaylogin;
    String namalengkap;
    String namalengkap2;
    private DisplayImageOptions optionsNotRound;
    PonselBaseApp ponselBaseApp;
    ProgressBar progressbar_hp_user;
    ProgressBar progressbar_item;
    ProgressBar progressbar_item2;
    ProgressBar progressbar_middleSC;
    ProgressBar progressbar_middle_dialog;
    ProgressBar progressbar_sc_kota;
    ProgressBar progressbar_sc_provinsi;
    ListSCAdapter scAdapter;
    ArrayList scKotaArray;
    ListSCProvAdapter scProvAdapter;
    ArrayList scProvArray;
    LinearLayout sc_separator;
    ListSCProvAdapter scpencarianAdapter;
    ArrayList scpencarianArray;
    String strPencMerek;
    String suc;
    String t;
    String tot_dislike;
    String tot_dislike2;
    String tot_komen;
    String tot_komen2;
    String tot_like;
    String tot_like2;
    TextView txtBigsc_Merek1;
    TextView txtBigsc_Merek2;
    TextView txtEmpty;
    TextView txtMoreSCManual;
    TextView txtNotLoginsc_kota;
    TextView txtSCNotLogin;
    TextView txt_empty;
    TextView txtemptysc_kota;
    TextView txtemptysc_provinsi;
    String umu_status;
    String umu_status2;

    public SCUserActivity()
    {
        t = Utility.session(RestClient.pelihara);
        scKotaArray = null;
        scProvArray = null;
        getJson = "";
        inponsel = null;
        suc = "";
        jumSC = "";
        strPencMerek = "nil";
        scpencarianArray = null;
        listProvArrayList = null;
        merkArray = null;
        merkArrayID = null;
        jml = "";
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

    public void HpUserTask()
    {
        dataHpUser = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("sc_hp_user").append(Utility.BASE_FORMAT).append("?idusr=").append(user_id).append("&t=").append(t).toString();
        Log.e("dataHpUser", dataHpUser);
        HpUserTask hpusertask = new HpUserTask(null);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            hpusertask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            hpusertask.execute(new Void[0]);
            return;
        }
    }

    public void SCKotaTask()
    {
        dataSCKota = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("sc_kota_user").append(Utility.BASE_FORMAT).append("?idusr=").append(user_id).append("&t=").append(t).toString();
        SCKotaTask sckotatask = new SCKotaTask(null);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            sckotatask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            sckotatask.execute(new Void[0]);
            return;
        }
    }

    public void SCProvTask()
    {
        dataSCProv = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("sc_provinsi_user").append(Utility.BASE_FORMAT).append("?idusr=").append(user_id).append("&t=").append(t).toString();
        SCProvTask scprovtask = new SCProvTask(null);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            scprovtask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            scprovtask.execute(new Void[0]);
            return;
        }
    }

    public void SearchTask()
    {
        dataSearch = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("sc_more").append(Utility.BASE_FORMAT).append("?idm=").append(strPencMerek).append("&key=").append(key).append("&lmt=0&t=").append(t).toString();
        Log.e("dataSearch", dataSearch);
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
        bundle = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f03010d, null, false);
        mDrawerLayout.addView(bundle, 0);
        menu_PusatLayanan.setBackgroundResource(0x7f0201cf);
        menu_PusatLayanan.setEnabled(false);
        mainLayout = (LinearLayout)findViewById(0x7f0b00c4);
        mainLayout2 = (LinearLayout)findViewById(0x7f0b083b);
        sc_separator = (LinearLayout)findViewById(0x7f0b083a);
        list_txtMerek = (TextView)findViewById(0x7f0b033c);
        list_txtMerek2 = (TextView)findViewById(0x7f0b0840);
        list_txtHarga = (TextView)findViewById(0x7f0b033d);
        list_txtHarga2 = (TextView)findViewById(0x7f0b0841);
        progressbar_item = (ProgressBar)findViewById(0x7f0b00b3);
        progressbar_item2 = (ProgressBar)findViewById(0x7f0b0524);
        imgHp = (ImageView)findViewById(0x7f0b023d);
        imgHp2 = (ImageView)findViewById(0x7f0b083d);
        ponselBaseApp = (PonselBaseApp)getApplication();
        ponselBaseApp.getObserver().addObserver(this);
        int i;
        int j;
        try
        {
            bundle = ((PonselBaseApp)getApplication()).getTracker(com.inponsel.android.adapter.PonselBaseApp.TrackerName.APP_TRACKER);
            bundle.setScreenName("SC Halaman Utama");
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
        optionsNotRound = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showImageForEmptyUri(0x7f020208).showImageOnFail(0x7f020297).cacheInMemory(true).imageScaleType(ImageScaleType.EXACTLY).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).build();
        t = Utility.session(t);
        cm = (ConnectivityManager)getSystemService("connectivity");
        mylaylogin = (LinearLayout)findViewById(0x7f0b0824);
        layout_hp_user = (LinearLayout)findViewById(0x7f0b0839);
        layout_sc_kota = (LinearLayout)findViewById(0x7f0b0825);
        layout_sc_provinsi = (LinearLayout)findViewById(0x7f0b082b);
        listsc_provinsi = (ExpandedListView)findViewById(0x7f0b0830);
        listsc_kota = (ExpandedListView)findViewById(0x7f0b082a);
        progressbar_hp_user = (ProgressBar)findViewById(0x7f0b0384);
        progressbar_sc_kota = (ProgressBar)findViewById(0x7f0b0828);
        progressbar_sc_provinsi = (ProgressBar)findViewById(0x7f0b082e);
        layout_sc_Merek1 = (LinearLayout)findViewById(0x7f0b0831);
        layout_sc_Merek2 = (LinearLayout)findViewById(0x7f0b0844);
        layout_sc_Manual = (LinearLayout)findViewById(0x7f0b0835);
        layout_sc_Manual.setVisibility(0);
        txtBigsc_Merek1 = (TextView)findViewById(0x7f0b0833);
        txtBigsc_Merek2 = (TextView)findViewById(0x7f0b0846);
        txtMoreSCManual = (TextView)findViewById(0x7f0b0821);
        txtMoreSCManual.setVisibility(8);
        txtemptysc_kota = (TextView)findViewById(0x7f0b0829);
        txtemptysc_provinsi = (TextView)findViewById(0x7f0b082f);
        txtSCNotLogin = (TextView)findViewById(0x7f0b0823);
        txtNotLoginsc_kota = (TextView)findViewById(0x7f0b0822);
        scKotaArray = new ArrayList();
        scProvArray = new ArrayList();
        t = Utility.session(t);
        scAdapter = new ListSCAdapter(this, 0x7f030120, scKotaArray);
        scProvAdapter = new ListSCProvAdapter(this, 0x7f030120, scProvArray);
        listsc_kota.setAdapter(scAdapter);
        listsc_provinsi.setAdapter(scProvAdapter);
        if (userFunctions.isUserLoggedIn(this))
        {
            mylaylogin.setVisibility(0);
            txtSCNotLogin.setVisibility(8);
            txtNotLoginsc_kota.setVisibility(8);
        } else
        {
            mylaylogin.setVisibility(8);
            txtSCNotLogin.setVisibility(0);
            txtNotLoginsc_kota.setVisibility(0);
            txtSCNotLogin.setText("Fitur ini hanya untuk pengguna terdaftar. Silahkan daftar / login disini");
            clickify(txtSCNotLogin, "disini", new com.inponsel.android.utils.ClickSpan.OnClickListener() {

                final SCUserActivity this$0;

                public void onClick()
                {
                    Intent intent = new Intent(getApplicationContext(), com/inponsel/android/v2/LoginActivity);
                    intent.putExtra("activity", "main");
                    startActivityForResult(intent, 0);
                    overridePendingTransition(0x7f040001, 0x7f040002);
                }

            
            {
                this$0 = SCUserActivity.this;
                super();
            }
            });
        }
        edtAutoSC = (EditText)findViewById(0x7f0b081e);
        edtAutoSC.setHint(Html.fromHtml("<small>Ketik: merek, provinsi, kota atau kecamatan</small>"));
        txtMoreSCManual.setOnClickListener(new android.view.View.OnClickListener() {

            final SCUserActivity this$0;

            public void onClick(View view)
            {
                view = new Intent(getApplicationContext(), com/inponsel/android/v2/SCMoreActivity);
                view.putExtra("strKey", edtAutoSC.getText().toString());
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = SCUserActivity.this;
                super();
            }
        });
        progressbar_middleSC = (ProgressBar)findViewById(0x7f0b081f);
        listSCManual = (ExpandedListView)findViewById(0x7f0b0820);
        scpencarianArray = new ArrayList();
        scpencarianAdapter = new ListSCProvAdapter(this, 0x7f030120, scpencarianArray);
        listSCManual.setAdapter(scpencarianAdapter);
        edtAutoSC.addTextChangedListener(new DelayedTextWatcher(1000L) {

            final SCUserActivity this$0;

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
                    setProgressBarIndeterminateVisibility(true);
                    setProgressBarVisibility(true);
                    SearchTask();
                    return;
                } else
                {
                    Toast.makeText(getApplicationContext(), 0x7f0c0059, 0).show();
                    return;
                }
            }

            
            {
                this$0 = SCUserActivity.this;
                super(l);
            }
        });
        edtAutoSC.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

            final SCUserActivity this$0;

            public boolean onEditorAction(TextView textview, int k, KeyEvent keyevent)
            {
                if (edtAutoSC.getText().toString().trim().length() == 0)
                {
                    listSCManual.setVisibility(0);
                    return false;
                }
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
                    setProgressBarIndeterminateVisibility(true);
                    setProgressBarVisibility(true);
                    SearchTask();
                    return false;
                } else
                {
                    Toast.makeText(getApplicationContext(), 0x7f0c0059, 0).show();
                    return false;
                }
            }

            
            {
                this$0 = SCUserActivity.this;
                super();
            }
        });
        listsc_kota.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final SCUserActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int k, long l)
            {
                adapterview = new Intent(getApplicationContext(), com/inponsel/android/scdetail/SCDetailPager);
                adapterview.putExtra("sc_id", scAdapter.getListModel(k).getId_sc());
                adapterview.putExtra("sc_logo", scAdapter.getListModel(k).getSc_logo());
                adapterview.putExtra("sc_c_center", scAdapter.getListModel(k).getSc_c_center());
                adapterview.putExtra("sc_ven_center", scAdapter.getListModel(k).getSc_ven_center());
                adapterview.putExtra("sc_nama", scAdapter.getListModel(k).getSc_nama());
                adapterview.putExtra("sc_merk", scAdapter.getListModel(k).getSc_merk());
                adapterview.putExtra("sc_fb", scAdapter.getListModel(k).getSc_fb());
                adapterview.putExtra("sc_ytube", scAdapter.getListModel(k).getSc_ytube());
                adapterview.putExtra("sc_fb_id", scAdapter.getListModel(k).getSc_fb_id());
                adapterview.putExtra("sc_tw", scAdapter.getListModel(k).getSc_tw());
                adapterview.putExtra("sc_alamat", scAdapter.getListModel(k).getSc_alamat());
                adapterview.putExtra("sc_no_telp", scAdapter.getListModel(k).getSc_no_telp());
                adapterview.putExtra("sc_no_telp_ket", scAdapter.getListModel(k).getSc_no_telp_ket());
                adapterview.putExtra("sc_email", scAdapter.getListModel(k).getSc_email());
                adapterview.putExtra("sc_web", scAdapter.getListModel(k).getSc_web_url());
                adapterview.putExtra("sc_rateAvg", scAdapter.getListModel(k).getSc_rate());
                adapterview.putExtra("sc_rate1", scAdapter.getListModel(k).getSc_rate1());
                adapterview.putExtra("sc_rate2", scAdapter.getListModel(k).getSc_rate2());
                adapterview.putExtra("sc_rate3", scAdapter.getListModel(k).getSc_rate3());
                adapterview.putExtra("sc_rate4", scAdapter.getListModel(k).getSc_rate4());
                adapterview.putExtra("sc_rate5", scAdapter.getListModel(k).getSc_rate5());
                adapterview.putExtra("sc_total_rate", scAdapter.getListModel(k).getSc_total_rate());
                startActivityForResult(adapterview, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = SCUserActivity.this;
                super();
            }
        });
        listsc_provinsi.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final SCUserActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int k, long l)
            {
                adapterview = new Intent(getApplicationContext(), com/inponsel/android/scdetail/SCDetailPager);
                adapterview.putExtra("sc_id", scProvAdapter.getListModel(k).getId_sc());
                adapterview.putExtra("sc_logo", scProvAdapter.getListModel(k).getSc_logo());
                adapterview.putExtra("sc_c_center", scProvAdapter.getListModel(k).getSc_c_center());
                adapterview.putExtra("sc_ven_center", scProvAdapter.getListModel(k).getSc_ven_center());
                adapterview.putExtra("sc_nama", scProvAdapter.getListModel(k).getSc_nama());
                adapterview.putExtra("sc_merk", scProvAdapter.getListModel(k).getSc_merk());
                adapterview.putExtra("sc_fb", scProvAdapter.getListModel(k).getSc_fb());
                adapterview.putExtra("sc_ytube", scProvAdapter.getListModel(k).getSc_ytube());
                adapterview.putExtra("sc_fb_id", scProvAdapter.getListModel(k).getSc_fb_id());
                adapterview.putExtra("sc_tw", scProvAdapter.getListModel(k).getSc_tw());
                adapterview.putExtra("sc_alamat", scProvAdapter.getListModel(k).getSc_alamat());
                adapterview.putExtra("sc_no_telp", scProvAdapter.getListModel(k).getSc_no_telp());
                adapterview.putExtra("sc_no_telp_ket", scProvAdapter.getListModel(k).getSc_no_telp_ket());
                adapterview.putExtra("sc_email", scProvAdapter.getListModel(k).getSc_email());
                adapterview.putExtra("sc_web", scProvAdapter.getListModel(k).getSc_web_url());
                adapterview.putExtra("sc_rateAvg", scProvAdapter.getListModel(k).getSc_rate());
                adapterview.putExtra("sc_rate1", scProvAdapter.getListModel(k).getSc_rate1());
                adapterview.putExtra("sc_rate2", scProvAdapter.getListModel(k).getSc_rate2());
                adapterview.putExtra("sc_rate3", scProvAdapter.getListModel(k).getSc_rate3());
                adapterview.putExtra("sc_rate4", scProvAdapter.getListModel(k).getSc_rate4());
                adapterview.putExtra("sc_rate5", scProvAdapter.getListModel(k).getSc_rate5());
                adapterview.putExtra("sc_total_rate", scProvAdapter.getListModel(k).getSc_total_rate());
                startActivityForResult(adapterview, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = SCUserActivity.this;
                super();
            }
        });
        listSCManual.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final SCUserActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int k, long l)
            {
                adapterview = new Intent(getApplicationContext(), com/inponsel/android/scdetail/SCDetailPager);
                adapterview.putExtra("sc_id", scpencarianAdapter.getListModel(k).getId_sc());
                adapterview.putExtra("sc_logo", scpencarianAdapter.getListModel(k).getSc_logo());
                adapterview.putExtra("sc_c_center", scpencarianAdapter.getListModel(k).getSc_c_center());
                adapterview.putExtra("sc_ven_center", scpencarianAdapter.getListModel(k).getSc_ven_center());
                adapterview.putExtra("sc_nama", scpencarianAdapter.getListModel(k).getSc_nama());
                adapterview.putExtra("sc_merk", scpencarianAdapter.getListModel(k).getSc_merk());
                adapterview.putExtra("sc_fb", scpencarianAdapter.getListModel(k).getSc_fb());
                adapterview.putExtra("sc_ytube", scpencarianAdapter.getListModel(k).getSc_ytube());
                adapterview.putExtra("sc_fb_id", scpencarianAdapter.getListModel(k).getSc_fb_id());
                adapterview.putExtra("sc_tw", scpencarianAdapter.getListModel(k).getSc_tw());
                adapterview.putExtra("sc_alamat", scpencarianAdapter.getListModel(k).getSc_alamat());
                adapterview.putExtra("sc_no_telp", scpencarianAdapter.getListModel(k).getSc_no_telp());
                adapterview.putExtra("sc_no_telp_ket", scpencarianAdapter.getListModel(k).getSc_no_telp_ket());
                adapterview.putExtra("sc_email", scpencarianAdapter.getListModel(k).getSc_email());
                adapterview.putExtra("sc_web", scpencarianAdapter.getListModel(k).getSc_web_url());
                adapterview.putExtra("sc_rateAvg", scpencarianAdapter.getListModel(k).getSc_rate());
                adapterview.putExtra("sc_rate1", scpencarianAdapter.getListModel(k).getSc_rate1());
                adapterview.putExtra("sc_rate2", scpencarianAdapter.getListModel(k).getSc_rate2());
                adapterview.putExtra("sc_rate3", scpencarianAdapter.getListModel(k).getSc_rate3());
                adapterview.putExtra("sc_rate4", scpencarianAdapter.getListModel(k).getSc_rate4());
                adapterview.putExtra("sc_rate5", scpencarianAdapter.getListModel(k).getSc_rate5());
                adapterview.putExtra("sc_total_rate", scpencarianAdapter.getListModel(k).getSc_total_rate());
                startActivityForResult(adapterview, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = SCUserActivity.this;
                super();
            }
        });
        layout_sc_Merek1.setVisibility(8);
        layout_sc_Merek2.setVisibility(8);
        HpUserTask();
        SCKotaTask();
        SCProvTask();
        layout_sc_Merek1.setOnClickListener(new android.view.View.OnClickListener() {

            final SCUserActivity this$0;

            public void onClick(View view)
            {
                Log.e("sc_idmerk1", id_merk);
                view = new Intent(getApplicationContext(), com/inponsel/android/v2/SCMerkActivity);
                view.putExtra("sc_id_merk", id_merk);
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = SCUserActivity.this;
                super();
            }
        });
        layout_sc_Merek2.setOnClickListener(new android.view.View.OnClickListener() {

            final SCUserActivity this$0;

            public void onClick(View view)
            {
                Log.e("sc_idmerk2", id_merk2);
                view = new Intent(getApplicationContext(), com/inponsel/android/v2/SCMerkActivity);
                view.putExtra("sc_id_merk", id_merk2);
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = SCUserActivity.this;
                super();
            }
        });
        layout_sc_Manual.setOnClickListener(new android.view.View.OnClickListener() {

            final SCUserActivity this$0;

            public void onClick(View view)
            {
                view = new Intent(getApplicationContext(), com/inponsel/android/servicenter/SCPencarian);
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = SCUserActivity.this;
                super();
            }
        });
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

    public void update(Observable observable, Object obj)
    {
        if (ponselBaseApp.getObserver().getLoginStat().equals("1"))
        {
            runOnUiThread(new Runnable() {

                final SCUserActivity this$0;

                public void run()
                {
                    if (userFunctions.isUserLoggedIn(getApplicationContext()))
                    {
                        cursor = db.getAllData();
                        cursor.moveToFirst();
                        try
                        {
                            user_id = EncodeDecodeAES.decrypt(RestClient.pelihara, cursor.getString(1));
                        }
                        catch (Exception exception) { }
                        nama_asli = cursor.getString(2);
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
                        cursor.close();
                    }
                    if (userFunctions.isUserLoggedIn(getApplicationContext()))
                    {
                        HpUserTask();
                        SCKotaTask();
                        SCProvTask();
                        mylaylogin.setVisibility(0);
                        txtSCNotLogin.setVisibility(8);
                        txtNotLoginsc_kota.setVisibility(8);
                        return;
                    } else
                    {
                        mylaylogin.setVisibility(8);
                        txtSCNotLogin.setVisibility(0);
                        txtNotLoginsc_kota.setVisibility(0);
                        txtSCNotLogin.setText("Fitur ini hanya untuk pengguna terdaftar. Silahkan daftar / login disini");
                        SCUserActivity.clickify(txtSCNotLogin, "disini", new com.inponsel.android.utils.ClickSpan.OnClickListener() {

                            final _cls11 this$1;

                            public void onClick()
                            {
                                Intent intent = new Intent(getApplicationContext(), com/inponsel/android/v2/LoginActivity);
                                intent.putExtra("activity", "main");
                                startActivityForResult(intent, 0);
                                overridePendingTransition(0x7f040001, 0x7f040002);
                            }

            
            {
                this$1 = _cls11.this;
                super();
            }
                        });
                        return;
                    }
                }


            
            {
                this$0 = SCUserActivity.this;
                super();
            }
            });
        }
    }


}
