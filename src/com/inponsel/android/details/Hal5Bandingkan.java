// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.view.ContextThemeWrapper;
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
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.analytics.Tracker;
import com.google.gson.Gson;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.DelayedTextWatcher;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.NotificationLikeHelper;
import com.inponsel.android.utils.Response;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.v2.BandingkanPonsel;
import com.inponsel.android.v2.KomentarPonsel;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;
import com.inponsel.android.widget.DroidWriterEditText;
import com.inponsel.android.widget.ExpandableHeightGridView;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Hal5Bandingkan extends Fragment
{
    public class ListPencarianAdapter extends BaseAdapter
        implements Observer
    {

        private Activity activity;
        Context context;
        Cursor cursor;
        DatabaseHandler db;
        String email_user;
        DecimalFormat fmt;
        DecimalFormatSymbols fmts;
        int hargaBaru;
        int hargaBekas;
        String hrg_baru;
        String hrg_bekas;
        String komen;
        private ArrayList lm;
        ListModel lms;
        PonselBaseApp ponselBaseApp;
        String ponselLikeDis;
        int pos;
        String res;
        int resource;
        String response;
        String statusLikeHp;
        String t;
        final Hal5Bandingkan this$0;
        String user;
        UserFunctions userFunctions;
        String user_id;
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
                viewgroup.list_txtCodename = (TextView)view.findViewById(0x7f0b033f);
                viewgroup.list_like = (ImageView)view.findViewById(0x7f0b0343);
                viewgroup.list_dislike = (ImageView)view.findViewById(0x7f0b0346);
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
                ((ViewHolder) (viewgroup)).list_text_like.setText(lms.getTotal_like());
                ((ViewHolder) (viewgroup)).list_text_dislike.setText(lms.getTotal_dislike());
                ((ViewHolder) (viewgroup)).list_text_komentar.setText(lms.getTotal_kom());
                ((ViewHolder) (viewgroup)).list_txtCodename.setText(lms.getCodename());
                if (lms.getUmu_status().equals("3") || hrg_baru.equals("-") || hrg_baru.equals("0"))
                {
                    ((ViewHolder) (viewgroup)).list_txtHarga.setVisibility(8);
                } else
                {
                    ((ViewHolder) (viewgroup)).list_txtHarga.setVisibility(0);
                    ((ViewHolder) (viewgroup)).list_txtHarga.setText((new StringBuilder()).append(hrg_baru).toString());
                }
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

                    final ListPencarianAdapter this$1;
                    private final int val$position;

                    public void onClick(View view)
                    {
                        if (userFunctions.isUserLoggedIn(activity))
                        {
                            pos = position;
                            codenameKomen = getListModel(position).getCodename();
                            statusLikeHp = "1";
                            indexhp = getListModel(position).getId_hp();
                            ponselBaseApp.getObserver().setIndexHp(getListModel(position).getCodename());
                            Log.e("getNamalengkap", getListModel(position).getCodename());
                            namalengkapbgskrg = (new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString();
                            ponselBaseApp.getObserver().setId_hp(indexhp);
                            try
                            {
                                ponselLikeDis = (new StringBuilder("idhp=")).append(getListModel(position).getId_hp()).append("&email=").append(username).append("&namalengkap=").append(URLEncoder.encode((new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString(), "utf-8")).append("&status=").append(statusLikeHp).append("&t=").append(t).toString();
                            }
                            // Misplaced declaration of an exception variable
                            catch (View view)
                            {
                                view.printStackTrace();
                            }
                            Log.e("finalurl", ponselLikeDis);
                            if (android.os.Build.VERSION.SDK_INT >= 11)
                            {
                                (new ListPencarianAdapter.PostBagusKurangTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                                return;
                            } else
                            {
                                (new ListPencarianAdapter.PostBagusKurangTask()).execute(new Void[0]);
                                return;
                            }
                        } else
                        {
                            view = new android.app.AlertDialog.Builder(activity);
                            view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                            view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                                final ListPencarianAdapter._cls1 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = ListPencarianAdapter._cls1.this;
                super();
            }
                            });
                            view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                                final ListPencarianAdapter._cls1 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(activity, com/inponsel/android/v2/RegisterActivity);
                                    activity.startActivity(dialoginterface);
                                }

            
            {
                this$2 = ListPencarianAdapter._cls1.this;
                super();
            }
                            });
                            view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                                final ListPencarianAdapter._cls1 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(activity, com/inponsel/android/v2/LoginActivity);
                                    dialoginterface.putExtra("activity", "main");
                                    activity.startActivity(dialoginterface);
                                }

            
            {
                this$2 = ListPencarianAdapter._cls1.this;
                super();
            }
                            });
                            view.show();
                            return;
                        }
                    }


            
            {
                this$1 = final_listpencarianadapter;
                position = I.this;
                super();
            }
                });
                ((ViewHolder) (viewgroup)).list_lay_dislike.setOnClickListener(i. new android.view.View.OnClickListener() {

                    final ListPencarianAdapter this$1;
                    private final int val$position;

                    public void onClick(View view)
                    {
                        codenameKomen = getListModel(position).getCodename();
                        statusLikeHp = "0";
                        indexhp = getListModel(position).getId_hp();
                        ponselBaseApp.getObserver().setIndexHp(getListModel(position).getCodename());
                        Log.e("getNamalengkap", getListModel(position).getCodename());
                        namalengkapbgskrg = (new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString();
                        if (userFunctions.isUserLoggedIn(activity))
                        {
                            pos = position;
                            try
                            {
                                ponselLikeDis = (new StringBuilder("idhp=")).append(getListModel(position).getId_hp()).append("&email=").append(username).append("&namalengkap=").append(URLEncoder.encode((new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString(), "utf-8")).append("&status=").append(statusLikeHp).append("&t=").append(t).toString();
                            }
                            // Misplaced declaration of an exception variable
                            catch (View view)
                            {
                                view.printStackTrace();
                            }
                            Log.e("finalurl", ponselLikeDis);
                            if (android.os.Build.VERSION.SDK_INT >= 11)
                            {
                                (new ListPencarianAdapter.PostBagusKurangTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                                return;
                            } else
                            {
                                (new ListPencarianAdapter.PostBagusKurangTask()).execute(new Void[0]);
                                return;
                            }
                        } else
                        {
                            view = new android.app.AlertDialog.Builder(activity);
                            view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                            view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                                final ListPencarianAdapter._cls2 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = ListPencarianAdapter._cls2.this;
                super();
            }
                            });
                            view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                                final ListPencarianAdapter._cls2 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(activity, com/inponsel/android/v2/RegisterActivity);
                                    activity.startActivity(dialoginterface);
                                }

            
            {
                this$2 = ListPencarianAdapter._cls2.this;
                super();
            }
                            });
                            view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                                final ListPencarianAdapter._cls2 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(activity, com/inponsel/android/v2/LoginActivity);
                                    dialoginterface.putExtra("activity", "main");
                                    activity.startActivity(dialoginterface);
                                }

            
            {
                this$2 = ListPencarianAdapter._cls2.this;
                super();
            }
                            });
                            view.show();
                            return;
                        }
                    }


            
            {
                this$1 = final_listpencarianadapter;
                position = I.this;
                super();
            }
                });
                ((ViewHolder) (viewgroup)).list_lay_kom.setOnClickListener(i. new android.view.View.OnClickListener() {

                    final ListPencarianAdapter this$1;
                    private final int val$position;

                    public void onClick(View view)
                    {
                        view = new Intent(getActivity(), com/inponsel/android/v2/KomentarPonsel);
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
                        getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$1 = final_listpencarianadapter;
                position = I.this;
                super();
            }
                });
                try
                {
                    Picasso.with(getActivity()).load((new StringBuilder(String.valueOf(Util.BASE_PATH_NEWIMAGE))).append(lms.getGambar().trim()).toString()).into(((ViewHolder) (viewgroup)).imageHp, viewgroup. new Callback() {

                        final ListPencarianAdapter this$1;
                        private final ListPencarianAdapter.ViewHolder val$holder;

                        public void onError()
                        {
                            holder.progressbar_item.setVisibility(8);
                            holder.imageHp.setVisibility(0);
                        }

                        public void onSuccess()
                        {
                            holder.imageHp.setVisibility(0);
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

        public void update(Observable observable, Object obj)
        {
            Log.e("getUpdateTypeHargaHp", ponselBaseApp.getObserver().getUpdateType().toString());
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
            Log.e("ChildCount(banding)", String.valueOf(listPencarianHp.getChildCount()));
            Log.e("getFirst(banding)", String.valueOf(listPencarianHp.getFirstVisiblePosition()));
            Log.e("getLast(banding)", String.valueOf(listPencarianHp.getLastVisiblePosition()));
            int i = 0;
            do
            {
                if (i >= listPencarianHp.getChildCount())
                {
                    return;
                }
                Log.e("int i", String.valueOf(i));
                View view = listPencarianHp.getChildAt(i);
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
            Log.e("ChildCount(banding)", String.valueOf(listPencarianHp.getChildCount()));
            Log.e("getFirst(banding)", String.valueOf(listPencarianHp.getFirstVisiblePosition()));
            Log.e("getLast(banding)", String.valueOf(listPencarianHp.getLastVisiblePosition()));
            i = 0;
_L2:
            ImageView imageview;
            ImageView imageview1;
            RelativeLayout relativelayout;
            Object obj;
            if (i >= listPencarianHp.getChildCount())
            {
                return;
            }
            Log.e("int i", String.valueOf(i));
            obj = listPencarianHp.getChildAt(i);
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



        public ListPencarianAdapter(Activity activity1, int i, ArrayList arraylist)
        {
            this$0 = Hal5Bandingkan.this;
            super();
            fmt = new DecimalFormat();
            fmts = new DecimalFormatSymbols();
            t = Utility.session(RestClient.pelihara);
            username = "";
            user_id = "";
            user = "";
            komen = "";
            email_user = "";
            ponselLikeDis = "";
            t = Utility.session(t);
            lm = arraylist;
            activity = activity1;
            resource = i;
            ponselBaseApp = (PonselBaseApp)getActivity().getApplication();
            ponselBaseApp.getObserver().addObserver(this);
            try
            {
                userFunctions = new UserFunctions();
                db = new DatabaseHandler(activity1);
                if (!userFunctions.isUserLoggedIn(activity1))
                {
                    break MISSING_BLOCK_LABEL_241;
                }
                cursor = db.getAllData();
                cursor.moveToFirst();
            }
            // Misplaced declaration of an exception variable
            catch (Hal5Bandingkan hal5bandingkan)
            {
                return;
            }
            try
            {
                user_id = EncodeDecodeAES.decrypt(RestClient.pelihara, cursor.getString(1));
            }
            // Misplaced declaration of an exception variable
            catch (Hal5Bandingkan hal5bandingkan) { }
            username = cursor.getString(4);
            email_user = cursor.getString(5);
            cursor.close();
            t = Utility.session(t);
            return;
        }
    }

    public class ListPencarianAdapter.PostBagusKurangTask extends AsyncTask
    {

        final ListPencarianAdapter this$1;

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
                avoid = ponselLikeDis;
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
            if (postStatusLikePon.equals("1"))
            {
                notificationLikeHelper.completed(namalengkapbgskrg, notificationLikeHelper.SucdislikeStatement);
                if (statusLikeHp.equals("1"))
                {
                    ponselBaseApp.getObserver().setStatus_like_ponsel("1");
                    return;
                } else
                {
                    ponselBaseApp.getObserver().setStatus_like_ponsel("0");
                    return;
                }
            } else
            {
                notificationLikeHelper.gagal(namalengkapbgskrg, notificationLikeHelper.gagallikeStatement);
                return;
            }
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

        public ListPencarianAdapter.PostBagusKurangTask()
        {
            this$1 = ListPencarianAdapter.this;
            super();
        }
    }

    class ListPencarianAdapter.ViewHolder
    {

        LinearLayout headImage;
        ImageView imageHp;
        ImageView list_dislike;
        RelativeLayout list_lay_dislike;
        RelativeLayout list_lay_kom;
        RelativeLayout list_lay_like;
        ImageView list_like;
        TextView list_text_dislike;
        TextView list_text_komentar;
        TextView list_text_like;
        TextView list_txtBigRight;
        TextView list_txtCodename;
        TextView list_txtHarga;
        TextView list_txtMerek;
        ProgressBar progressbar_item;
        RatingBar rateRate;
        final ListPencarianAdapter this$1;
        TextView txtNumber;

        ListPencarianAdapter.ViewHolder()
        {
            this$1 = ListPencarianAdapter.this;
            super();
        }
    }

    private class SearchMoreTask extends AsyncTask
    {

        Response response;
        final Hal5Bandingkan this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            avoid = new HttpGet(dataSearchMore);
            Object obj;
            int i;
            try
            {
                obj = (new DefaultHttpClient()).execute(avoid);
                i = ((HttpResponse) (obj)).getStatusLine().getStatusCode();
            }
            catch (IOException ioexception)
            {
                avoid.abort();
                return null;
            }
            if (i == 200)
            {
                break MISSING_BLOCK_LABEL_89;
            }
            Log.e(getClass().getSimpleName(), (new StringBuilder("Error ")).append(i).append(" for URL ").append(dataSearchMore).toString());
            return null;
            obj = new InputStreamReader(((HttpResponse) (obj)).getEntity().getContent());
            response = (Response)(new Gson()).fromJson(((java.io.Reader) (obj)), com/inponsel/android/utils/Response);
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
            counterArray = 0;
            void1 = response.InPonsel.iterator();
_L3:
            if (void1.hasNext()) goto _L2; else goto _L1
_L1:
            pencarianAdapter.notifyDataSetChanged();
            Log.e("counterArray", String.valueOf(pencarianArray.size()));
            if (pencarianArray.size() >= 20)
            {
                break MISSING_BLOCK_LABEL_248;
            }
            grup_header_footer.setVisibility(8);
_L4:
            getActivity().setProgressBarIndeterminateVisibility(false);
            getActivity().setProgressBarVisibility(false);
            return;
_L2:
            ListModel listmodel;
label0:
            {
                listmodel = (ListModel)void1.next();
                Hal5Bandingkan hal5bandingkan = Hal5Bandingkan.this;
                hal5bandingkan.counterArray = hal5bandingkan.counterArray + 1;
                if (!listmodel.getId_hp().equals("-") || !listmodel.getModel().equals("-"))
                {
                    break label0;
                }
                grup_header_footer.setVisibility(8);
                listPencarianHp.setVisibility(8);
                layout_empty.setVisibility(0);
            }
              goto _L3
            try
            {
                pencarianArray.add(listmodel);
                listPencarianHp.setVisibility(0);
                layout_empty.setVisibility(8);
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
              goto _L3
            btnMemuatLagi.setVisibility(0);
            grup_header_footer.setVisibility(0);
              goto _L4
        }

        private SearchMoreTask()
        {
            this$0 = Hal5Bandingkan.this;
            super();
        }

        SearchMoreTask(SearchMoreTask searchmoretask)
        {
            this();
        }
    }

    private class SearchTask extends AsyncTask
    {

        Response response;
        final Hal5Bandingkan this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            avoid = new HttpGet(dataSearch);
            Object obj;
            int i;
            try
            {
                obj = (new DefaultHttpClient()).execute(avoid);
                i = ((HttpResponse) (obj)).getStatusLine().getStatusCode();
            }
            catch (IOException ioexception)
            {
                avoid.abort();
                return null;
            }
            if (i == 200)
            {
                break MISSING_BLOCK_LABEL_89;
            }
            Log.e(getClass().getSimpleName(), (new StringBuilder("Error ")).append(i).append(" for URL ").append(dataSearch).toString());
            return null;
            obj = new InputStreamReader(((HttpResponse) (obj)).getEntity().getContent());
            response = (Response)(new Gson()).fromJson(((java.io.Reader) (obj)), com/inponsel/android/utils/Response);
            return null;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            super.onPostExecute(void1);
            progressbar_middle.setVisibility(8);
            pencarianArray.clear();
            Log.e("tasksdsurlSearch", dataSearch);
            counterArray = 0;
            void1 = response.InPonsel.iterator();
_L3:
            if (void1.hasNext()) goto _L2; else goto _L1
_L1:
            pencarianAdapter.notifyDataSetChanged();
            Log.e("getChildPencarianPon", String.valueOf(listPencarianHp.getChildCount()));
            Log.e("counterArray", String.valueOf(pencarianArray.size()));
            if (pencarianArray.size() >= 20)
            {
                break MISSING_BLOCK_LABEL_312;
            }
            grup_header_footer.setVisibility(8);
_L4:
            getActivity().setProgressBarIndeterminateVisibility(false);
            getActivity().setProgressBarVisibility(false);
            return;
_L2:
            ListModel listmodel;
label0:
            {
                listmodel = (ListModel)void1.next();
                Hal5Bandingkan hal5bandingkan = Hal5Bandingkan.this;
                hal5bandingkan.counterArray = hal5bandingkan.counterArray + 1;
                if (!listmodel.getId_hp().equals("-") || !listmodel.getModel().equals("-"))
                {
                    break label0;
                }
                grup_header_footer.setVisibility(8);
                progressbar_middle.setVisibility(8);
                listPencarianHp.setVisibility(8);
                layout_empty.setVisibility(0);
                txt_empty.setText("Ponsel belum tersedia");
            }
              goto _L3
            try
            {
                pencarianArray.add(listmodel);
                listPencarianHp.setVisibility(0);
                layout_empty.setVisibility(8);
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
              goto _L3
            btnMemuatLagi.setVisibility(0);
            grup_header_footer.setVisibility(0);
              goto _L4
        }

        private SearchTask()
        {
            this$0 = Hal5Bandingkan.this;
            super();
        }

        SearchTask(SearchTask searchtask)
        {
            this();
        }
    }


    public static String komencount = "";
    Button btnMemuatLagi;
    Button btnSubmit;
    Button btn_pop_komen;
    Button btn_pop_login;
    int charCount;
    ConnectivityManager cm;
    String codename1;
    String codenameKomen;
    int count;
    int countAllKom;
    int countKomOld;
    int counterArray;
    Cursor cursor;
    String dataKomen;
    String dataSearch;
    String dataSearchMore;
    DatabaseHandler db;
    EditText edtAuto;
    EditText edtComment;
    EditText edtUser;
    DroidWriterEditText edt_pop_komen;
    String email_komentar;
    Bundle extras;
    LinearLayout footerView;
    String gambar;
    String gambar1;
    String getJson;
    LinearLayout grup_header_footer;
    LinearLayout headerView;
    String hp1;
    String hp2;
    String hrg_baru1;
    String hrg_bekas1;
    String id_hp;
    String id_hp1;
    String id_hp2;
    String id_kom;
    String indexhp;
    String isikomentar;
    JSONArray jArray;
    String jml;
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
    ExpandableHeightGridView listPencarianHp;
    String merk;
    String merk1;
    String model;
    String model1;
    String namalengkap;
    String namalengkap1;
    String namalengkapbgskrg;
    NotificationLikeHelper notificationLikeHelper;
    String oldid;
    ListPencarianAdapter pencarianAdapter;
    ArrayList pencarianArray;
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
    String statuslike;
    String t;
    String tanggal;
    String tot_LikePon;
    String tot_dislike1;
    String tot_komen1;
    String tot_like1;
    String totdis_LikePon;
    TextView txtEmpty;
    TextView txt_empty;
    TextView txt_footer;
    String urlKomen;
    String urlKomenLast;
    String urlKomenOld;
    UserFunctions userFunctions;
    String user_id;
    String userkomen;
    String userpict;
    ContextThemeWrapper wrapper;

    public Hal5Bandingkan()
    {
        pencarianArray = null;
        getJson = "";
        count = 0;
        t = Utility.session(RestClient.pelihara);
        postStatusLikePon = "";
        postMessageLikePon = "";
        tot_LikePon = "0";
        totdis_LikePon = "0";
        jum_komenLikePon = "0";
        indexhp = "";
        user_id = "";
        limit = 0;
        postStatus = "";
        postMessage = "";
        querypopkomen = "";
        oldid = "";
        lastid = "0";
        urlKomen = "";
        urlKomenOld = "";
        urlKomenLast = "";
        countKomOld = 0;
        countAllKom = 0;
    }

    public void SearchMoreTask()
    {
        SearchMoreTask searchmoretask = new SearchMoreTask(null);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            searchmoretask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            searchmoretask.execute(new Void[0]);
            return;
        }
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

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        setRetainInstance(true);
        try
        {
            viewgroup = ((PonselBaseApp)getActivity().getApplication()).getTracker(com.inponsel.android.adapter.PonselBaseApp.TrackerName.APP_TRACKER);
            viewgroup.setScreenName("Hal5Bandingkan");
            viewgroup.send((new com.google.android.gms.analytics.HitBuilders.AppViewBuilder()).build());
        }
        // Misplaced declaration of an exception variable
        catch (ViewGroup viewgroup)
        {
            viewgroup.printStackTrace();
        }
        userFunctions = new UserFunctions();
        db = new DatabaseHandler(getActivity());
        if (userFunctions.isUserLoggedIn(getActivity()))
        {
            cursor = db.getAllData();
            cursor.moveToFirst();
            try
            {
                user_id = EncodeDecodeAES.decrypt(RestClient.pelihara, cursor.getString(1));
            }
            // Misplaced declaration of an exception variable
            catch (ViewGroup viewgroup) { }
        }
        extras = getActivity().getIntent().getExtras();
        namalengkap1 = extras.getString("namalengkap");
        id_hp1 = extras.getString("id_hph");
        model1 = extras.getString("model");
        merk1 = extras.getString("merk");
        gambar1 = extras.getString("gambar");
        hrg_baru1 = extras.getString("hrg_baru");
        hrg_bekas1 = extras.getString("hrg_bekas");
        tot_like1 = extras.getString("tot_like");
        tot_dislike1 = extras.getString("tot_dislike");
        tot_komen1 = extras.getString("tot_komen");
        layoutinflater = (ViewGroup)layoutinflater.inflate(0x7f03009a, null);
        cm = (ConnectivityManager)getActivity().getSystemService("connectivity");
        wrapper = new ContextThemeWrapper(getActivity(), 0x103006e);
        listPencarianHp = (ExpandableHeightGridView)layoutinflater.findViewById(0x7f0b052e);
        listPencarianHp.setExpanded(true);
        edtAuto = (EditText)layoutinflater.findViewById(0x7f0b008d);
        edtAuto.setFocusable(true);
        edtAuto.setFocusableInTouchMode(true);
        edtAuto.setEnabled(true);
        edtAuto.requestFocus();
        progressbar_middle = (ProgressBar)layoutinflater.findViewById(0x7f0b00ca);
        btnMemuatLagi = (Button)layoutinflater.findViewById(0x7f0b00bc);
        btnMemuatLagi.setText(0x7f0c0054);
        layout_empty = (LinearLayout)layoutinflater.findViewById(0x7f0b0091);
        layout_empty.setVisibility(8);
        layout_footer = (LinearLayout)layoutinflater.findViewById(0x7f0b00b9);
        grup_header_footer = (LinearLayout)layoutinflater.findViewById(0x7f0b00b7);
        txt_footer = (TextView)layoutinflater.findViewById(0x7f0b00bb);
        txt_footer.setText("Memuat");
        grup_header_footer.setVisibility(8);
        notificationLikeHelper = new NotificationLikeHelper(getActivity());
        edtUser = (EditText)layoutinflater.findViewById(0x7f0b0064);
        edtComment = (EditText)layoutinflater.findViewById(0x7f0b0066);
        btnSubmit = (Button)layoutinflater.findViewById(0x7f0b0069);
        txtEmpty = (TextView)layoutinflater.findViewById(0x7f0b0093);
        pencarianArray = new ArrayList();
        t = Utility.session(t);
        pencarianAdapter = new ListPencarianAdapter(getActivity(), 0x7f03011b, pencarianArray);
        listPencarianHp.setAdapter(pencarianAdapter);
        listPencarianHp.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final Hal5Bandingkan this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                listPencarianHp.playSoundEffect(0);
                adapterview = pencarianAdapter.getListModel(i).getId_hp().toString();
                view = pencarianAdapter.getListModel(i).getModel().toString();
                String s = pencarianAdapter.getListModel(i).getMerk().toString();
                String s1 = pencarianAdapter.getListModel(i).getGambar().toString();
                String s2 = pencarianAdapter.getListModel(i).getTotal_like().toString();
                String s3 = pencarianAdapter.getListModel(i).getTotal_dislike().toString();
                String s4 = pencarianAdapter.getListModel(i).getTotal_kom().toString();
                String s5 = pencarianAdapter.getListModel(i).getHrg_baru().toString();
                String s6 = pencarianAdapter.getListModel(i).getHrg_bekas().toString();
                String s7 = pencarianAdapter.getListModel(i).getCodename().toString();
                String s8 = (new StringBuilder(String.valueOf(s))).append(" ").append(view).toString();
                Intent intent = new Intent(getActivity(), com/inponsel/android/v2/BandingkanPonsel);
                intent.putExtra("id_hp2", adapterview);
                intent.putExtra("namalengkap2", s8);
                intent.putExtra("codename2", s7);
                intent.putExtra("model2", view);
                intent.putExtra("merk2", s);
                intent.putExtra("gambar2", s1);
                intent.putExtra("hrg_baru2", s5);
                intent.putExtra("hrg_bekas2", s6);
                intent.putExtra("tot_like2", s2);
                intent.putExtra("tot_dislike2", s3);
                intent.putExtra("tot_komen2", s4);
                intent.putExtra("id_hp1", id_hp1);
                intent.putExtra("namalengkap1", namalengkap1);
                intent.putExtra("codename1", codename1);
                intent.putExtra("model1", model1);
                intent.putExtra("merk1", merk1);
                intent.putExtra("gambar1", gambar1);
                intent.putExtra("hrg_baru1", hrg_baru1);
                intent.putExtra("hrg_bekas1", hrg_bekas1);
                intent.putExtra("tot_like1", tot_like1);
                intent.putExtra("tot_dislike1", tot_dislike1);
                intent.putExtra("tot_komen1", tot_komen1);
                getActivity().startActivityForResult(intent, 0);
                getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = Hal5Bandingkan.this;
                super();
            }
        });
        t = Utility.session(t);
        edtAuto.addTextChangedListener(new DelayedTextWatcher(2000L) {

            final Hal5Bandingkan this$0;

            public void afterTextChangedDelayed(Editable editable)
            {
                if (edtAuto.getText().toString().trim().length() == 0)
                {
                    txtEmpty.setText("Masukan ponsel yang ingin dibandingkan");
                    return;
                }
                if (cm.getActiveNetworkInfo() == null || !cm.getActiveNetworkInfo().isAvailable() || !cm.getActiveNetworkInfo().isConnected()) goto _L2; else goto _L1
_L1:
                layout_empty.setVisibility(0);
                editable = edtAuto.getText().toString();
                String s = URLEncoder.encode(editable, "utf-8");
                editable = s;
_L3:
                progressbar_middle.setVisibility(0);
                txtEmpty.setText(0x7f0c0053);
                dataSearch = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("pencarian_ponsel").append(Utility.BASE_FORMAT).append("?key=").append(editable).append("&lmt=0&t=").append(t).append("&idusr=").append(user_id).toString();
                SearchTask();
                return;
                UnsupportedEncodingException unsupportedencodingexception;
                unsupportedencodingexception;
                unsupportedencodingexception.printStackTrace();
                if (true) goto _L3; else goto _L2
_L2:
                Toast.makeText(getActivity(), 0x7f0c0059, 0).show();
                return;
            }

            
            {
                this$0 = Hal5Bandingkan.this;
                super(l);
            }
        });
        edtAuto.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

            final Hal5Bandingkan this$0;

            public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
            {
                if (edtAuto.getText().toString().trim().length() == 0)
                {
                    txtEmpty.setText("Masukan ponsel yang ingin dibandingkan");
                    return false;
                }
                if (cm.getActiveNetworkInfo() == null || !cm.getActiveNetworkInfo().isAvailable() || !cm.getActiveNetworkInfo().isConnected()) goto _L2; else goto _L1
_L1:
                layout_empty.setVisibility(0);
                textview = edtAuto.getText().toString();
                keyevent = URLEncoder.encode(textview, "utf-8");
                textview = keyevent;
_L3:
                progressbar_middle.setVisibility(0);
                txtEmpty.setText(0x7f0c0053);
                dataSearch = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("pencarian_ponsel").append(Utility.BASE_FORMAT).append("?key=").append(textview).append("&lmt=0&t=").append(t).append("&idusr=").append(user_id).toString();
                SearchTask();
                return false;
                keyevent;
                keyevent.printStackTrace();
                if (true) goto _L3; else goto _L2
_L2:
                Toast.makeText(getActivity(), 0x7f0c0059, 0).show();
                return false;
            }

            
            {
                this$0 = Hal5Bandingkan.this;
                super();
            }
        });
        btnMemuatLagi.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal5Bandingkan this$0;

            public void onClick(View view)
            {
                btnMemuatLagi.setVisibility(8);
                getActivity().setProgressBarIndeterminateVisibility(true);
                getActivity().setProgressBarVisibility(true);
                if (cm.getActiveNetworkInfo() == null || !cm.getActiveNetworkInfo().isAvailable() || !cm.getActiveNetworkInfo().isConnected()) goto _L2; else goto _L1
_L1:
                view = edtAuto.getText().toString();
                String s = URLEncoder.encode(view, "utf-8");
                view = s;
_L3:
                Hal5Bandingkan hal5bandingkan = Hal5Bandingkan.this;
                hal5bandingkan.limit = hal5bandingkan.limit + 20;
                dataSearchMore = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("pencarian_ponsel").append(Utility.BASE_FORMAT).append("?idusr=").append(user_id).append("&key=").append(view).append("&lmt=").append(limit).append("&t=").append(t).toString();
                Log.e("data", dataSearchMore);
                SearchMoreTask();
                return;
                UnsupportedEncodingException unsupportedencodingexception;
                unsupportedencodingexception;
                unsupportedencodingexception.printStackTrace();
                if (true) goto _L3; else goto _L2
_L2:
                getActivity().setProgressBarIndeterminateVisibility(false);
                getActivity().setProgressBarVisibility(false);
                Toast.makeText(getActivity(), getString(0x7f0c005a), 0).show();
                return;
            }

            
            {
                this$0 = Hal5Bandingkan.this;
                super();
            }
        });
        return layoutinflater;
    }

}
