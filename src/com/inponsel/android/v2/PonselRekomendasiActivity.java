// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.widget.DrawerLayout;
import android.text.Html;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.actionbarsherlock.ActionBarSherlock;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.details.DetailsPonsel;
import com.inponsel.android.pencariangen.TabPencarian;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.NotificationLikeHelper;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.ServiceHandler;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.widget.DroidWriterEditText;
import com.inponsel.android.widget.ExpandableHeightGridView;
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
//            BaseDrawer, RegisterActivity, LoginActivity, KomentarPonsel

public class PonselRekomendasiActivity extends BaseDrawer
    implements android.view.View.OnClickListener, Observer
{
    public class ListPendatangAdapter extends BaseAdapter
        implements Observer
    {

        private Activity activity;
        private ArrayList arraylm;
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
        String indexhp;
        String komen;
        ListModel lms;
        private DisplayImageOptions options;
        PonselBaseApp ponselBaseApp;
        int pos;
        String res;
        int resource;
        String response;
        String statusLikeHp;
        String t;
        final PonselRekomendasiActivity this$0;
        String user;
        UserFunctions userFunctions;

        public int getCount()
        {
            return arraylm.size();
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
            return (ListModel)arraylm.get(i);
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
                viewgroup.list_text_like = (TextView)view.findViewById(0x7f0b0344);
                viewgroup.list_text_dislike = (TextView)view.findViewById(0x7f0b0347);
                viewgroup.list_text_komentar = (TextView)view.findViewById(0x7f0b034a);
                viewgroup.progressbar_item = (ProgressBar)view.findViewById(0x7f0b00b3);
                viewgroup.list_lay_like = (RelativeLayout)view.findViewById(0x7f0b0342);
                viewgroup.list_lay_dislike = (RelativeLayout)view.findViewById(0x7f0b0345);
                viewgroup.list_lay_kom = (RelativeLayout)view.findViewById(0x7f0b0348);
                viewgroup.list_txtCodename = (TextView)view.findViewById(0x7f0b033f);
                viewgroup.list_like = (ImageView)view.findViewById(0x7f0b0343);
                viewgroup.list_dislike = (ImageView)view.findViewById(0x7f0b0346);
                viewgroup.rateRate = (RatingBar)view.findViewById(0x7f0b00c9);
                viewgroup.imgIklan = (ImageView)view.findViewById(0x7f0b0484);
                viewgroup.bottom_list = (LinearLayout)view.findViewById(0x7f0b0341);
                viewgroup.progressbar_item_iklan = (ProgressBar)view.findViewById(0x7f0b0483);
                viewgroup.headHp = (LinearLayout)view.findViewById(0x7f0b0481);
                viewgroup.headImage = (LinearLayout)view.findViewById(0x7f0b029f);
                view.setTag(viewgroup);
            } else
            {
                viewgroup = (ViewHolder)view.getTag();
            }
            lms = (ListModel)arraylm.get(i);
            if (arraylm != null)
            {
                ((ViewHolder) (viewgroup)).bottom_list.setVisibility(8);
                String s = (new StringBuilder(String.valueOf(String.valueOf((double)Math.round(10F * (((float)Integer.parseInt(lms.getTotal_like()) / (float)(Integer.parseInt(lms.getTotal_like()) + Integer.parseInt(lms.getTotal_dislike()))) * 100F)) / 10D)))).append("% (").append(lms.getTotal_like()).append(" likes, ").append(lms.getTotal_dislike()).append(" dislike)").toString();
                String s1 = (new StringBuilder(String.valueOf(lms.getAvg_all()))).append(" (").append(lms.getTotal_votes()).append(" suara)").toString();
                ((ViewHolder) (viewgroup)).list_txtHarga.setText(Html.fromHtml((new StringBuilder("<font color=\"#616161\">Ketertarikan:</font> <font color=\"#aaaaaa\">")).append(s).append("</font><br><font color=\"#616161\">Review pengunjung:</font> <font color=\"#aaaaaa\">").append(s1).append("</font>").toString()));
                hrg_baru = lms.getHrg_baru();
                hrg_bekas = lms.getHrg_bekas();
                ((ViewHolder) (viewgroup)).list_txtMerek.setText((new StringBuilder(String.valueOf(lms.getMerk()))).append(" ").append(lms.getModel()).toString());
                ((ViewHolder) (viewgroup)).list_txtCodename.setText(lms.getCodename());
                ((ViewHolder) (viewgroup)).list_text_like.setText(lms.getTotal_like());
                ((ViewHolder) (viewgroup)).list_text_dislike.setText(lms.getTotal_dislike());
                ((ViewHolder) (viewgroup)).list_text_komentar.setText(lms.getTotal_kom());
                if (lms.getMy_like_pon().toString().equals("1"))
                {
                    ((ViewHolder) (viewgroup)).list_like.setBackgroundResource(0x7f02025b);
                    ((ViewHolder) (viewgroup)).list_dislike.setBackgroundResource(0x7f0201a3);
                    ((ViewHolder) (viewgroup)).list_lay_like.setEnabled(false);
                    ((ViewHolder) (viewgroup)).list_lay_dislike.setEnabled(true);
                } else
                if (lms.getMy_like_pon().toString().equals("0"))
                {
                    ((ViewHolder) (viewgroup)).list_like.setBackgroundResource(0x7f020257);
                    ((ViewHolder) (viewgroup)).list_dislike.setBackgroundResource(0x7f0201a7);
                    ((ViewHolder) (viewgroup)).list_lay_like.setEnabled(true);
                    ((ViewHolder) (viewgroup)).list_lay_dislike.setEnabled(false);
                } else
                {
                    ((ViewHolder) (viewgroup)).list_lay_like.setEnabled(true);
                    ((ViewHolder) (viewgroup)).list_lay_dislike.setEnabled(true);
                    ((ViewHolder) (viewgroup)).list_like.setBackgroundResource(0x7f020257);
                    ((ViewHolder) (viewgroup)).list_dislike.setBackgroundResource(0x7f0201a3);
                    ((ViewHolder) (viewgroup)).list_lay_like.setBackgroundResource(0x7f020079);
                    ((ViewHolder) (viewgroup)).list_lay_dislike.setBackgroundResource(0x7f020079);
                }
                ((ViewHolder) (viewgroup)).list_lay_like.setOnClickListener(i. new android.view.View.OnClickListener() {

                    final ListPendatangAdapter this$1;
                    private final int val$position;

                    public void onClick(View view)
                    {
                        indexhp = getListModel(position).getId_hp();
                        ponselBaseApp.getObserver().setIndexHp(getListModel(position).getCodename());
                        Log.e("getNamalengkap", getListModel(position).getCodename());
                        statusLikeHp = "1";
                        namalengkapbgskrg = (new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString();
                        if (userFunctions.isUserLoggedIn(activity))
                        {
                            pos = position;
                            try
                            {
                                finalUrl = (new StringBuilder("idhp=")).append(getListModel(position).getId_hp()).append("&email=").append(username).append("&namalengkap=").append(URLEncoder.encode((new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString(), "utf-8")).append("&status=").append(statusLikeHp).append("&t=").append(t).toString();
                            }
                            // Misplaced declaration of an exception variable
                            catch (View view)
                            {
                                view.printStackTrace();
                            }
                            Log.e("finalurlpos", String.valueOf(pos));
                            if (android.os.Build.VERSION.SDK_INT >= 11)
                            {
                                (new ListPendatangAdapter.PostBagusKurangTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                                return;
                            } else
                            {
                                (new ListPendatangAdapter.PostBagusKurangTask()).execute(new Void[0]);
                                return;
                            }
                        } else
                        {
                            view = new android.app.AlertDialog.Builder(activity);
                            view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                            view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                                final ListPendatangAdapter._cls1 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = ListPendatangAdapter._cls1.this;
                super();
            }
                            });
                            view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                                final ListPendatangAdapter._cls1 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(activity, com/inponsel/android/v2/RegisterActivity);
                                    activity.startActivity(dialoginterface);
                                }

            
            {
                this$2 = ListPendatangAdapter._cls1.this;
                super();
            }
                            });
                            view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                                final ListPendatangAdapter._cls1 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(activity, com/inponsel/android/v2/LoginActivity);
                                    dialoginterface.putExtra("activity", "main");
                                    activity.startActivity(dialoginterface);
                                }

            
            {
                this$2 = ListPendatangAdapter._cls1.this;
                super();
            }
                            });
                            view.show();
                            return;
                        }
                    }


            
            {
                this$1 = final_listpendatangadapter;
                position = I.this;
                super();
            }
                });
                ((ViewHolder) (viewgroup)).list_lay_dislike.setOnClickListener(i. new android.view.View.OnClickListener() {

                    final ListPendatangAdapter this$1;
                    private final int val$position;

                    public void onClick(View view)
                    {
                        indexhp = getListModel(position).getId_hp();
                        ponselBaseApp.getObserver().setIndexHp(getListModel(position).getCodename());
                        Log.e("getNamalengkap", getListModel(position).getCodename());
                        statusLikeHp = "0";
                        namalengkapbgskrg = (new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString();
                        if (userFunctions.isUserLoggedIn(activity))
                        {
                            pos = position;
                            try
                            {
                                finalUrl = (new StringBuilder("idhp=")).append(getListModel(position).getId_hp()).append("&email=").append(username).append("&namalengkap=").append(URLEncoder.encode((new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString(), "utf-8")).append("&status=").append(statusLikeHp).append("&t=").append(t).toString();
                            }
                            // Misplaced declaration of an exception variable
                            catch (View view)
                            {
                                view.printStackTrace();
                            }
                            Log.e("finalurl", finalUrl);
                            if (android.os.Build.VERSION.SDK_INT >= 11)
                            {
                                (new ListPendatangAdapter.PostBagusKurangTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                                return;
                            } else
                            {
                                (new ListPendatangAdapter.PostBagusKurangTask()).execute(new Void[0]);
                                return;
                            }
                        } else
                        {
                            view = new android.app.AlertDialog.Builder(activity);
                            view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                            view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                                final ListPendatangAdapter._cls2 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = ListPendatangAdapter._cls2.this;
                super();
            }
                            });
                            view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                                final ListPendatangAdapter._cls2 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(activity, com/inponsel/android/v2/RegisterActivity);
                                    activity.startActivity(dialoginterface);
                                }

            
            {
                this$2 = ListPendatangAdapter._cls2.this;
                super();
            }
                            });
                            view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                                final ListPendatangAdapter._cls2 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(activity, com/inponsel/android/v2/LoginActivity);
                                    dialoginterface.putExtra("activity", "main");
                                    activity.startActivity(dialoginterface);
                                }

            
            {
                this$2 = ListPendatangAdapter._cls2.this;
                super();
            }
                            });
                            view.show();
                            return;
                        }
                    }


            
            {
                this$1 = final_listpendatangadapter;
                position = I.this;
                super();
            }
                });
                ((ViewHolder) (viewgroup)).list_lay_kom.setOnClickListener(i. new android.view.View.OnClickListener() {

                    final ListPendatangAdapter this$1;
                    private final int val$position;

                    public void onClick(View view)
                    {
                        view = new Intent(getApplicationContext(), com/inponsel/android/v2/KomentarPonsel);
                        view.putExtra("id_hph", getListModel(position).getId_hp());
                        view.putExtra("namalengkap", getListModel(position).getNamalengkap());
                        view.putExtra("codename", getListModel(position).getCodename());
                        view.putExtra("model", getListModel(position).getModel());
                        view.putExtra("merk", getListModel(position).getMerk());
                        view.putExtra("gambar", getListModel(position).getGambar());
                        view.putExtra("hrg_baru", getListModel(position).getHrg_baru());
                        view.putExtra("hrg_bekas", getListModel(position).getHrg_bekas());
                        view.putExtra("tot_like", getListModel(position).getTotal_like());
                        view.putExtra("tot_dislike", getListModel(position).getTotal_dislike());
                        view.putExtra("tot_komen", getListModel(position).getTotal_kom());
                        startActivityForResult(view, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$1 = final_listpendatangadapter;
                position = I.this;
                super();
            }
                });
                try
                {
                    imageLoader2.displayImage((new StringBuilder(String.valueOf(Util.BASE_PATH_NEWIMAGE))).append(lms.getGambar().trim()).toString(), ((ViewHolder) (viewgroup)).imageHp, options, viewgroup. new ImageLoadingListener() {

                        final ListPendatangAdapter this$1;
                        private final ListPendatangAdapter.ViewHolder val$holder;

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
                this$1 = final_listpendatangadapter;
                holder = ListPendatangAdapter.ViewHolder.this;
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
            arraylm = arraylist;
        }

        public void update(Observable observable, Object obj)
        {
            Log.e("getUpdateType", ponselBaseApp.getObserver().getUpdateType().toString());
            if (ponselBaseApp.getObserver().getUpdateType().toString().equals("komentar"))
            {
                Log.e("updateViewKomenPonsel", ponselBaseApp.getObserver().getUpdateType().toString());
                updateViewKomenPonsel(ponselBaseApp.getObserver().getIndexHp());
            } else
            if (ponselBaseApp.getObserver().getUpdateType().toString().equals("likedisPonsel"))
            {
                Log.e("updateViewLikeDisPonsel", ponselBaseApp.getObserver().getUpdateType().toString());
                updateViewLikeDisPonsel(ponselBaseApp.getObserver().getIndexHp());
                return;
            }
        }

        public void updateViewKomenPonsel(String s)
        {
            Log.e("ponselBaseApp", s);
            Log.e("indexArrayListCarpon", String.valueOf(listPonselOS.getChildCount()));
            Log.e("getCount", String.valueOf(listPonselOS.getCount()));
            Log.e("getChildCount", String.valueOf(listPonselOS.getChildCount()));
            int i = 0;
            do
            {
                if (i >= listPonselOS.getChildCount())
                {
                    return;
                }
                Log.e("int i", String.valueOf(i));
                View view = listPonselOS.getChildAt(i);
                TextView textview = (TextView)view.findViewById(0x7f0b0344);
                TextView textview1 = (TextView)view.findViewById(0x7f0b0347);
                TextView textview2 = (TextView)view.findViewById(0x7f0b034a);
                if (((TextView)view.findViewById(0x7f0b033f)).getText().toString().equals(s))
                {
                    textview.setText(ponselBaseApp.getObserver().getTot_LikePon());
                    textview1.setText(ponselBaseApp.getObserver().getTotdis_LikePon());
                    textview2.setText(ponselBaseApp.getObserver().getJum_komenLikePon());
                }
                i++;
            } while (true);
        }

        public void updateViewLikeDisPonsel(String s)
        {
            int i;
            Log.e("ponselBaseApp", s);
            Log.e("listPonselOS", String.valueOf(listPonselOS.getChildCount()));
            i = 0;
_L2:
            ImageView imageview;
            ImageView imageview1;
            RelativeLayout relativelayout;
            Object obj;
            if (i >= listPonselOS.getChildCount())
            {
                return;
            }
            Log.e("int i", String.valueOf(i));
            obj = listPonselOS.getChildAt(i);
            TextView textview = (TextView)((View) (obj)).findViewById(0x7f0b0344);
            TextView textview1 = (TextView)((View) (obj)).findViewById(0x7f0b0347);
            imageview = (ImageView)((View) (obj)).findViewById(0x7f0b0343);
            imageview1 = (ImageView)((View) (obj)).findViewById(0x7f0b0346);
            TextView textview2 = (TextView)((View) (obj)).findViewById(0x7f0b034a);
            TextView textview3 = (TextView)((View) (obj)).findViewById(0x7f0b033f);
            relativelayout = (RelativeLayout)((View) (obj)).findViewById(0x7f0b0342);
            obj = (RelativeLayout)((View) (obj)).findViewById(0x7f0b0345);
            if (textview3.getText().toString().equals(s))
            {
                Log.e("getTot_LikePon", ponselBaseApp.getObserver().getJum_komenLikePon().toString());
                Log.e("getTot_LikePon", ponselBaseApp.getObserver().getTot_LikePon().toString());
                Log.e("getTotdis_LikePon", ponselBaseApp.getObserver().getTotdis_LikePon().toString());
                textview.setText(ponselBaseApp.getObserver().getTot_LikePon().toString());
                textview1.setText(ponselBaseApp.getObserver().getTotdis_LikePon().toString());
                textview2.setText(ponselBaseApp.getObserver().getJum_komenLikePon().toString());
                Log.e("getUpdateTypeBef", ponselBaseApp.getObserver().getUpdateType().toString());
                if (!ponselBaseApp.getObserver().getStatus_like_ponsel().equals("1"))
                {
                    break; /* Loop/switch isn't completed */
                }
                imageview.setBackgroundResource(0x7f02025b);
                imageview1.setBackgroundResource(0x7f0201a3);
                relativelayout.setEnabled(false);
                ((RelativeLayout) (obj)).setEnabled(true);
            }
_L3:
            i++;
            if (true) goto _L2; else goto _L1
_L1:
            if (ponselBaseApp.getObserver().getStatus_like_ponsel().equals("0"))
            {
                imageview.setBackgroundResource(0x7f020257);
                imageview1.setBackgroundResource(0x7f0201a7);
                relativelayout.setEnabled(true);
                ((RelativeLayout) (obj)).setEnabled(false);
            } else
            {
                relativelayout.setEnabled(true);
                ((RelativeLayout) (obj)).setEnabled(true);
                imageview.setBackgroundResource(0x7f020257);
                imageview1.setBackgroundResource(0x7f0201a3);
                relativelayout.setBackgroundResource(0x7f020079);
                ((RelativeLayout) (obj)).setBackgroundResource(0x7f020079);
            }
              goto _L3
            if (true) goto _L2; else goto _L4
_L4:
        }



        public ListPendatangAdapter(Activity activity1, int i, ArrayList arraylist)
        {
            this$0 = PonselRekomendasiActivity.this;
            super();
            fmt = new DecimalFormat();
            fmts = new DecimalFormatSymbols();
            t = Utility.session(RestClient.pelihara);
            user = "";
            komen = "";
            email_user = "";
            indexhp = "";
            finalUrl = "";
            t = Utility.session(t);
            arraylm = arraylist;
            activity = activity1;
            resource = i;
            t = Utility.session(t);
            ponselBaseApp = (PonselBaseApp)getApplication();
            ponselBaseApp.getObserver().addObserver(this);
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
                return;
            }
            // Misplaced declaration of an exception variable
            catch (PonselRekomendasiActivity ponselrekomendasiactivity)
            {
                return;
            }
        }
    }

    public class ListPendatangAdapter.PostBagusKurangTask extends AsyncTask
    {

        final ListPendatangAdapter this$1;

        private void parseJSONLikePon(String s)
        {
            int i;
            try
            {
                JSONObject jsonobject = new JSONObject(s);
                postStatusLikePon = jsonobject.getString("success");
                postMessageLikePon = jsonobject.getString("message");
                Log.e("postStatusLikePon", s);
                jArray = jsonobject.getJSONArray("InPonsel");
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
            jum_komenLikePon = s.getString("total_kom");
            tot_LikePon = s.getString("total_like");
            totdis_LikePon = s.getString("total_dislike");
            Log.e("jum_komenLikePon", jum_komenLikePon);
            Log.e("tot_LikePon", tot_LikePon);
            Log.e("totdis_LikePon", totdis_LikePon);
            ponselBaseApp.getObserver().setJum_komenLikePon(jum_komenLikePon);
            ponselBaseApp.getObserver().setTot_LikePon(tot_LikePon);
            ponselBaseApp.getObserver().setTotdis_LikePon(totdis_LikePon);
            ponselBaseApp.getObserver().setUpdateType("likedisPonsel");
            i++;
            if (false)
            {
            } else
            {
                break MISSING_BLOCK_LABEL_65;
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
                if (android.os.Build.VERSION.SDK_INT > 9)
                {
                    StrictMode.setThreadPolicy((new android.os.StrictMode.ThreadPolicy.Builder()).permitAll().build());
                }
                Log.e("posA", String.valueOf(pos));
                avoid = finalUrl;
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("likedis_ponsel").append(Utility.BASE_FORMAT).append("?").append(avoid).toString();
                Log.e("pushURL", avoid);
                avoid = HttpPush.getResponse(avoid);
                res = avoid.toString();
                parseJSONLikePon(res);
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
            Log.e("postStatusLikePon", postStatusLikePon);
            if (!postStatusLikePon.equals("1"))
            {
                break MISSING_BLOCK_LABEL_138;
            }
            notificationLikeHelper.completed(namalengkapbgskrg, notificationLikeHelper.SucdislikeStatement);
            if (!statusLikeHp.equals("1"))
            {
                break MISSING_BLOCK_LABEL_120;
            }
            ponselBaseApp.getObserver().setStatus_like_ponsel("1");
_L1:
            Log.e("lmroot", String.valueOf(pos));
            return;
            try
            {
                ponselBaseApp.getObserver().setStatus_like_ponsel("0");
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
              goto _L1
            notificationLikeHelper.gagal(namalengkapbgskrg, notificationLikeHelper.gagallikeStatement);
            return;
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            if (statusLikeHp.equals("1"))
            {
                notificationLikeHelper.createNotification(namalengkapbgskrg, notificationLikeHelper.likeStatement);
                return;
            } else
            {
                notificationLikeHelper.createNotification(namalengkapbgskrg, notificationLikeHelper.dislikeStatement);
                return;
            }
        }

        public ListPendatangAdapter.PostBagusKurangTask()
        {
            this$1 = ListPendatangAdapter.this;
            super();
        }
    }

    class ListPendatangAdapter.ViewHolder
    {

        LinearLayout bottom_list;
        LinearLayout headHp;
        LinearLayout headIklan;
        LinearLayout headImage;
        ImageView imageHp;
        ImageView imgIklan;
        ImageView list_dislike;
        RelativeLayout list_lay_dislike;
        RelativeLayout list_lay_kom;
        RelativeLayout list_lay_like;
        ImageView list_like;
        TextView list_text_dislike;
        TextView list_text_komentar;
        TextView list_text_like;
        TextView list_txtCodename;
        TextView list_txtHarga;
        TextView list_txtMerek;
        ProgressBar progressbar_item;
        ProgressBar progressbar_item_iklan;
        RatingBar rateRate;
        final ListPendatangAdapter this$1;

        ListPendatangAdapter.ViewHolder()
        {
            this$1 = ListPendatangAdapter.this;
            super();
        }
    }

    private class PonselMerkTask extends AsyncTask
    {

        final PonselRekomendasiActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            {
                avoid = (new ServiceHandler()).makeServiceCall(dataPonsel, 1);
                Log.e("Responseharga: ", (new StringBuilder("> ")).append(avoid).toString());
                if (avoid == null)
                {
                    break MISSING_BLOCK_LABEL_366;
                }
                ListModel listmodel;
                int i;
                try
                {
                    avoid = new JSONObject(avoid);
                    inponsel = avoid.getJSONArray("InPonsel");
                    suc = avoid.getString("success");
                    stat = avoid.getString("stat");
                    Log.e("suc", suc);
                    counterArray = 0;
                    if (!suc.equals("1"))
                    {
                        break MISSING_BLOCK_LABEL_373;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_373;
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_373;
                }
                i = 0;
            }
            if (i >= inponsel.length())
            {
                break MISSING_BLOCK_LABEL_373;
            }
            avoid = PonselRekomendasiActivity.this;
            avoid.counterArray = ((PonselRekomendasiActivity) (avoid)).counterArray + 1;
            avoid = inponsel.getJSONObject(i);
            listmodel = new ListModel();
            listmodel.setId_hp(avoid.getString("id_hp"));
            listmodel.setModel(avoid.getString("model"));
            listmodel.setMerk(avoid.getString("merk"));
            listmodel.setCodename(avoid.getString("codename"));
            listmodel.setGambar(avoid.getString("gambar"));
            listmodel.setUmu_status(avoid.getString("umu_status"));
            listmodel.setHrg_baru(avoid.getString("hrg_baru"));
            listmodel.setHrg_bekas(avoid.getString("hrg_bekas"));
            listmodel.setTotal_like(avoid.getString("total_like"));
            listmodel.setTotal_dislike(avoid.getString("total_dislike"));
            listmodel.setTotal_hits(avoid.getString("total_hits"));
            listmodel.setTotal_kom(avoid.getString("total_kom"));
            listmodel.setMy_like_pon(avoid.getString("my_like_pon"));
            listmodel.setTotal_votes(avoid.getString("total_vote"));
            listmodel.setAvg_all(avoid.getString("total_avg"));
            ponselMerekArray.add(listmodel);
            i++;
            if (true)
            {
                break MISSING_BLOCK_LABEL_129;
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
            getSherlock().setProgressBarIndeterminateVisibility(false);
            getSherlock().setProgressBarVisibility(false);
            listPonselOS.setVisibility(0);
            layout_empty.setVisibility(8);
            Log.e("ponselMerekArraybefore", String.valueOf(ponselMerekArray.size()));
            Log.e("data", dataPonsel);
            if (suc.equals("1"))
            {
                break MISSING_BLOCK_LABEL_248;
            }
            grup_header_footer.setVisibility(8);
            progressbar_middle.setVisibility(8);
            listPonselOS.setVisibility(0);
            layout_empty.setVisibility(0);
            txt_empty.setText("Data belum tersedia");
_L1:
            Log.e("ponselMerekArrayafter", String.valueOf(ponselMerekArray.size()));
            ponselOsAdapter.notifyDataSetChanged();
            listPonselOS.invalidateViews();
            listPonselOS.refreshDrawableState();
            Log.e("counterArray", String.valueOf(ponselMerekArray.size()));
            if (counterArray < 10)
            {
                grup_header_footer.setVisibility(8);
                return;
            }
            break MISSING_BLOCK_LABEL_262;
            try
            {
                listPonselOS.setVisibility(0);
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
              goto _L1
            btnMemuatLagi.setVisibility(0);
            return;
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
        }

        private PonselMerkTask()
        {
            this$0 = PonselRekomendasiActivity.this;
            super();
        }

        PonselMerkTask(PonselMerkTask ponselmerktask)
        {
            this();
        }
    }


    private String TAG;
    Button btnLoadMoreKom;
    Button btnLoadMoreNextKom;
    Button btnMemuatLagi;
    Button btn_pop_komen;
    Button btn_pop_login;
    int charCount;
    ConnectivityManager cm;
    String codename;
    String codenameKomen;
    int countAllKom;
    int countKomOld;
    int counterArray;
    String dataIDMerk;
    String dataPonsel;
    DroidWriterEditText edt_pop_komen;
    String email_komentar;
    LinearLayout footerView;
    String gambar;
    LinearLayout grup_header_footer;
    LinearLayout headerView;
    String hrg_baru;
    String hrg_bekas;
    String id_hp;
    String id_hph;
    String id_hpkom;
    String id_kom;
    String idhpstatus;
    LinearLayout imgUserKiri;
    JSONArray inponsel;
    String isikomentar;
    MenuItem itemRefresh;
    JSONArray jArray;
    JSONObject json;
    String jum_komenLikePon;
    String lastid;
    LinearLayout lay_pop_komen;
    LayoutInflater layoutInflater;
    LinearLayout layout_empty;
    LinearLayout layout_footer;
    LinearLayout layout_loading;
    LinearLayout layout_loadingNext;
    int limit;
    ListView listKomen;
    ExpandableHeightGridView listPonselOS;
    String merk;
    String model;
    String namalengkap;
    String namalengkapbgskrg;
    NotificationLikeHelper notificationLikeHelper;
    String oldid;
    public ArrayList ponselMerekArray;
    public ListPendatangAdapter ponselOsAdapter;
    ArrayList popKomenArray;
    LinearLayout pop_layout_empty;
    ProgressBar pop_progressbar_middle;
    TextView pop_txtCountKomen;
    TextView pop_txt_empty;
    int poslike;
    String postMessage;
    String postMessageLikePon;
    String postStatus;
    String postStatusLikePon;
    ProgressBar progressbar_middle;
    String querylike;
    String querypopkomen;
    String res;
    String reslike;
    String stat;
    String statuslike;
    String suc;
    String t;
    String tanggal;
    String tot_LikePon;
    String tot_dislike;
    String tot_komen;
    String tot_like;
    String totdis_LikePon;
    TextView txt_empty;
    TextView txt_footer;
    String urlKomen;
    String urlKomenLast;
    String urlKomenOld;
    String urlSearch;
    String userkomen;
    String userpict;

    public PonselRekomendasiActivity()
    {
        TAG = getClass().getSimpleName();
        ponselMerekArray = null;
        querypopkomen = "";
        postStatusLikePon = "";
        postMessageLikePon = "Gagal mengirim";
        tot_LikePon = "0";
        totdis_LikePon = "0";
        jum_komenLikePon = "0";
        limit = 1;
        oldid = "";
        lastid = "0";
        urlKomen = "";
        urlKomenOld = "";
        urlKomenLast = "";
        countKomOld = 0;
        countAllKom = 0;
        postStatus = "";
        postMessage = "";
        t = Utility.session(RestClient.pelihara);
        inponsel = null;
        suc = "";
        stat = "";
    }

    public void PonselMerkTask()
    {
        getSherlock().setProgressBarIndeterminateVisibility(true);
        getSherlock().setProgressBarVisibility(true);
        PonselMerkTask ponselmerktask = new PonselMerkTask(null);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            ponselmerktask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            ponselmerktask.execute(new Void[0]);
            return;
        }
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
        bundle = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f0300ee, null, false);
        mDrawerLayout.addView(bundle, 0);
        cm = (ConnectivityManager)getSystemService("connectivity");
        notificationLikeHelper = new NotificationLikeHelper(this);
        int i;
        int j;
        try
        {
            bundle = ((PonselBaseApp)getApplication()).getTracker(com.inponsel.android.adapter.PonselBaseApp.TrackerName.APP_TRACKER);
            bundle.setScreenName("Ponsel Berdasrkan Merek");
            bundle.send((new com.google.android.gms.analytics.HitBuilders.AppViewBuilder()).build());
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        getSherlock().setProgressBarIndeterminateVisibility(true);
        getSherlock().setProgressBarVisibility(true);
        actionBar = getSupportActionBar();
        actionBar.setDisplayUseLogoEnabled(useLogo);
        actionBar.setBackgroundDrawable(getResources().getDrawable(0x7f0200e5));
        j = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        i = j;
        if (j == 0)
        {
            i = 0x7f0b0037;
        }
        bundle = (TextView)findViewById(i);
        bundle.setSelected(true);
        bundle.setTextColor(Color.parseColor("#FFFFFF"));
        bundle.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        listPonselOS = (ExpandableHeightGridView)findViewById(0x7f0b052e);
        listPonselOS.setExpanded(true);
        layout_empty = (LinearLayout)findViewById(0x7f0b0091);
        txt_empty = (TextView)findViewById(0x7f0b0093);
        progressbar_middle = (ProgressBar)findViewById(0x7f0b00ca);
        txt_empty.setText("Memuat...");
        ponselMerekArray = new ArrayList();
        ponselOsAdapter = new ListPendatangAdapter(this, 0x7f03011b, ponselMerekArray);
        cm = (ConnectivityManager)getSystemService("connectivity");
        t = Utility.session(t);
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFFFFF'>Rekomendasi Pengunjung</font>"));
        btnMemuatLagi = (Button)findViewById(0x7f0b00bc);
        btnMemuatLagi.setText(0x7f0c0054);
        t = Utility.session(t);
        layout_footer = (LinearLayout)findViewById(0x7f0b00b9);
        grup_header_footer = (LinearLayout)findViewById(0x7f0b00b7);
        txt_footer = (TextView)findViewById(0x7f0b00bb);
        txt_footer.setText("Memuat");
        grup_header_footer.setVisibility(8);
        listPonselOS.setAdapter(ponselOsAdapter);
        btnMemuatLagi.setOnClickListener(new android.view.View.OnClickListener() {

            final PonselRekomendasiActivity this$0;

            public void onClick(View view)
            {
                btnMemuatLagi.setVisibility(8);
                if (android.os.Build.VERSION.SDK_INT >= 13)
                {
                    getSherlock().setProgressBarIndeterminateVisibility(true);
                    getSherlock().setProgressBarVisibility(true);
                }
                if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected())
                {
                    view = PonselRekomendasiActivity.this;
                    view.limit = ((PonselRekomendasiActivity) (view)).limit + 1;
                    dataPonsel = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("ponsel_recomended").append(Utility.BASE_FORMAT).append("?lmt=").append(limit).append("&t=").append(t).append("&idusr=").append(user_id).toString();
                    Log.e("data", dataPonsel);
                    PonselMerkTask();
                    return;
                } else
                {
                    getSherlock().setProgressBarIndeterminateVisibility(false);
                    getSherlock().setProgressBarVisibility(false);
                    return;
                }
            }

            
            {
                this$0 = PonselRekomendasiActivity.this;
                super();
            }
        });
        listPonselOS.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final PonselRekomendasiActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int k, long l)
            {
                listPonselOS.playSoundEffect(0);
                id_hph = ponselOsAdapter.getListModel(k).getId_hp().toString();
                model = ponselOsAdapter.getListModel(k).getModel().toString();
                merk = ponselOsAdapter.getListModel(k).getMerk().toString();
                gambar = ponselOsAdapter.getListModel(k).getGambar().toString();
                tot_like = ponselOsAdapter.getListModel(k).getTotal_like().toString();
                tot_dislike = ponselOsAdapter.getListModel(k).getTotal_dislike().toString();
                tot_komen = ponselOsAdapter.getListModel(k).getTotal_kom().toString();
                hrg_baru = ponselOsAdapter.getListModel(k).getHrg_baru().toString();
                hrg_bekas = ponselOsAdapter.getListModel(k).getHrg_bekas().toString();
                codename = ponselOsAdapter.getListModel(k).getCodename().toString();
                namalengkap = (new StringBuilder(String.valueOf(merk))).append(" ").append(model).toString();
                if (id_hph.contains("iklan"))
                {
                    adapterview = new Intent("android.intent.action.VIEW");
                    adapterview.setData(Uri.parse(codename.replace(" ", "")));
                    startActivity(adapterview);
                    return;
                } else
                {
                    adapterview = new Intent(getApplicationContext(), com/inponsel/android/details/DetailsPonsel);
                    adapterview.putExtra("id_hph", id_hph);
                    adapterview.putExtra("namalengkap", namalengkap);
                    adapterview.putExtra("codename", codename);
                    adapterview.putExtra("model", model);
                    adapterview.putExtra("merk", merk);
                    adapterview.putExtra("gambar", gambar);
                    adapterview.putExtra("hrg_baru", hrg_baru);
                    adapterview.putExtra("hrg_bekas", hrg_bekas);
                    adapterview.putExtra("tot_like", tot_like);
                    adapterview.putExtra("tot_dislike", tot_dislike);
                    adapterview.putExtra("tot_komen", tot_komen);
                    startActivityForResult(adapterview, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                    return;
                }
            }

            
            {
                this$0 = PonselRekomendasiActivity.this;
                super();
            }
        });
        if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected())
        {
            getSherlock().setProgressBarIndeterminateVisibility(true);
            getSherlock().setProgressBarVisibility(true);
            limit = 1;
            dataPonsel = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("ponsel_recomended").append(Utility.BASE_FORMAT).append("?lmt=").append(limit).append("&t=").append(t).append("&idusr=").append(user_id).toString();
            Log.e("dataPonsel", dataPonsel);
            PonselMerkTask();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getSupportMenuInflater().inflate(0x7f0f0002, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void onDestroy()
    {
        super.onDestroy();
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

    public void onStart()
    {
        super.onStart();
        GoogleAnalytics.getInstance(this).reportActivityStart(this);
    }

    public void onStop()
    {
        super.onStop();
        GoogleAnalytics.getInstance(this).reportActivityStart(this);
    }

}
