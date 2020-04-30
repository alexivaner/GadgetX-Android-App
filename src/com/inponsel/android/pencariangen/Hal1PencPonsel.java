// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.pencariangen;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.actionbarsherlock.app.SherlockFragment;
import com.android.volley.VolleyError;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.details.DetailsPonsel;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.MyObjectRequest;
import com.inponsel.android.utils.NotificationLikeHelper;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.SampleScrollListener;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.v2.KomentarPonsel;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;
import com.inponsel.android.widget.DroidWriterEditText;
import com.inponsel.android.widget.ExpandableHeightGridView;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Hal1PencPonsel extends SherlockFragment
    implements Observer
{
    public class ListPencarianAdapter extends BaseAdapter
        implements Observer
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
        String komen;
        private ArrayList lm;
        ListModel lms;
        PonselBaseApp ponselBaseApp;
        int pos;
        String res;
        int resource;
        String response;
        String statusLikeHp;
        String t;
        final Hal1PencPonsel this$0;
        String umu_status;
        String user;
        UserFunctions userFunctions;

        public int getCount()
        {
            return lm.size();
        }

        public Object getItem(int j)
        {
            return null;
        }

        public long getItemId(int j)
        {
            return 0L;
        }

        public ListModel getListModel(int j)
        {
            return (ListModel)lm.get(j);
        }

        public View getView(int j, View view, final ViewGroup holder)
        {
            pos = j;
            if (view == null)
            {
                view = ((LayoutInflater)activity.getSystemService("layout_inflater")).inflate(resource, null);
                holder = new ViewHolder();
                holder.imageHp = (ImageView)view.findViewById(0x7f0b023d);
                holder.list_txtMerek = (TextView)view.findViewById(0x7f0b033c);
                holder.list_txtHarga = (TextView)view.findViewById(0x7f0b033d);
                holder.list_txtCodename = (TextView)view.findViewById(0x7f0b033f);
                holder.list_like = (ImageView)view.findViewById(0x7f0b0343);
                holder.list_dislike = (ImageView)view.findViewById(0x7f0b0346);
                holder.list_text_like = (TextView)view.findViewById(0x7f0b0344);
                holder.list_text_dislike = (TextView)view.findViewById(0x7f0b0347);
                holder.list_text_komentar = (TextView)view.findViewById(0x7f0b034a);
                holder.progressbar_item = (ProgressBar)view.findViewById(0x7f0b00b3);
                holder.list_lay_like = (RelativeLayout)view.findViewById(0x7f0b0342);
                holder.list_lay_dislike = (RelativeLayout)view.findViewById(0x7f0b0345);
                holder.list_lay_kom = (RelativeLayout)view.findViewById(0x7f0b0348);
                holder.rateRate = (RatingBar)view.findViewById(0x7f0b00c9);
                holder.headImage = (LinearLayout)view.findViewById(0x7f0b029f);
                view.setTag(holder);
            } else
            {
                holder = (ViewHolder)view.getTag();
            }
            lms = (ListModel)lm.get(j);
            if (lm != null)
            {
                hrg_baru = lms.getHrg_baru();
                hrg_bekas = lms.getHrg_bekas();
                umu_status = lms.getUmu_status();
                ((ViewHolder) (holder)).list_txtMerek.setText((new StringBuilder(String.valueOf(lms.getMerk()))).append(" ").append(lms.getModel()).toString());
                ((ViewHolder) (holder)).list_txtCodename.setText(lms.getCodename());
                ((ViewHolder) (holder)).list_text_like.setText(lms.getTotal_like());
                ((ViewHolder) (holder)).list_text_dislike.setText(lms.getTotal_dislike());
                ((ViewHolder) (holder)).list_text_komentar.setText(lms.getTotal_kom());
                if (lms.getUmu_status().equals("3") || hrg_baru.equals("-") || hrg_baru.equals("0"))
                {
                    ((ViewHolder) (holder)).list_txtHarga.setVisibility(8);
                } else
                {
                    ((ViewHolder) (holder)).list_txtHarga.setVisibility(0);
                    ((ViewHolder) (holder)).list_txtHarga.setText((new StringBuilder()).append(hrg_baru).toString());
                }
                if (lms.getMy_like_pon().toString().equals("1"))
                {
                    ((ViewHolder) (holder)).list_like.setBackgroundResource(0x7f02025b);
                    ((ViewHolder) (holder)).list_dislike.setBackgroundResource(0x7f0201a3);
                    ((ViewHolder) (holder)).list_lay_like.setEnabled(false);
                    ((ViewHolder) (holder)).list_lay_dislike.setEnabled(true);
                } else
                if (lms.getMy_like_pon().toString().equals("0"))
                {
                    ((ViewHolder) (holder)).list_like.setBackgroundResource(0x7f020257);
                    ((ViewHolder) (holder)).list_dislike.setBackgroundResource(0x7f0201a7);
                    ((ViewHolder) (holder)).list_lay_like.setEnabled(true);
                    ((ViewHolder) (holder)).list_lay_dislike.setEnabled(false);
                } else
                {
                    ((ViewHolder) (holder)).list_lay_like.setEnabled(true);
                    ((ViewHolder) (holder)).list_lay_dislike.setEnabled(true);
                    ((ViewHolder) (holder)).list_like.setBackgroundResource(0x7f020257);
                    ((ViewHolder) (holder)).list_dislike.setBackgroundResource(0x7f0201a3);
                    ((ViewHolder) (holder)).list_lay_like.setBackgroundResource(0x7f020079);
                    ((ViewHolder) (holder)).list_lay_dislike.setBackgroundResource(0x7f020079);
                }
                ((ViewHolder) (holder)).list_lay_like.setOnClickListener(j. new android.view.View.OnClickListener() {

                    final ListPencarianAdapter this$1;
                    private final int val$position;

                    public void onClick(View view)
                    {
                        indexhp = getListModel(position).getId_hp();
                        ponselBaseApp.getObserver().setIndexHp(getListModel(position).getCodename());
                        Log.e("getNamalengkap", getListModel(position).getCodename());
                        statusLikeHp = "1";
                        namalengkapbgskrg = (new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString();
                        ponselBaseApp.getObserver().setId_hp(indexhp);
                        if (userFunctions.isUserLoggedIn(activity))
                        {
                            pos = position;
                            finalUrl = (new StringBuilder("idhp=")).append(getListModel(position).getId_hp()).append("&email=").append(username).append("&status=").append(statusLikeHp).append("&t=").append(t).toString();
                            Log.e("finalurl", finalUrl);
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

                                public void onClick(DialogInterface dialoginterface, int j)
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

                                public void onClick(DialogInterface dialoginterface, int j)
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

                                public void onClick(DialogInterface dialoginterface, int j)
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
                ((ViewHolder) (holder)).list_lay_dislike.setOnClickListener(j. new android.view.View.OnClickListener() {

                    final ListPencarianAdapter this$1;
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
                            finalUrl = (new StringBuilder("idhp=")).append(getListModel(position).getId_hp()).append("&email=").append(username).append("&status=").append(statusLikeHp).append("&t=").append(t).toString();
                            Log.e("finalurl", finalUrl);
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

                                public void onClick(DialogInterface dialoginterface, int j)
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

                                public void onClick(DialogInterface dialoginterface, int j)
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

                                public void onClick(DialogInterface dialoginterface, int j)
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
                ((ViewHolder) (holder)).list_lay_kom.setOnClickListener(j. new android.view.View.OnClickListener() {

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
                    Picasso.with(activity).load(lms.getGambar().trim()).tag(activity).into(((ViewHolder) (holder)).imageHp, j. new Callback() {

                        final ListPencarianAdapter this$1;
                        private final ListPencarianAdapter.ViewHolder val$holder;
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
                this$1 = final_listpencarianadapter;
                holder = viewholder;
                position = I.this;
                super();
            }
                    });
                }
                // Misplaced declaration of an exception variable
                catch (final ViewGroup holder)
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
            Log.e("indexArrayListCarpon", String.valueOf(listPencarianHp.getChildCount()));
            int j = 0;
            do
            {
                if (j >= listPencarianHp.getChildCount())
                {
                    return;
                }
                Log.e("int i", String.valueOf(j));
                View view = listPencarianHp.getChildAt(j);
                TextView textview = (TextView)view.findViewById(0x7f0b0344);
                TextView textview1 = (TextView)view.findViewById(0x7f0b0347);
                TextView textview2 = (TextView)view.findViewById(0x7f0b034a);
                if (((TextView)view.findViewById(0x7f0b033f)).getText().toString().equals(s))
                {
                    textview.setText(ponselBaseApp.getObserver().getTot_LikePon());
                    textview1.setText(ponselBaseApp.getObserver().getTotdis_LikePon());
                    textview2.setText(ponselBaseApp.getObserver().getJum_komenLikePon());
                }
                j++;
            } while (true);
        }

        public void updateViewLikeDisPonsel(String s)
        {
            int j;
            Log.e("ponselBaseApp", s);
            Log.e("indexArrayListCarpon", String.valueOf(listPencarianHp.getChildCount()));
            j = 0;
_L2:
            ImageView imageview;
            ImageView imageview1;
            RelativeLayout relativelayout;
            Object obj;
            if (j >= listPencarianHp.getChildCount())
            {
                return;
            }
            Log.e("int i", String.valueOf(j));
            obj = listPencarianHp.getChildAt(j);
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
            j++;
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



        public ListPencarianAdapter(Activity activity1, int j, ArrayList arraylist)
        {
            this$0 = Hal1PencPonsel.this;
            super();
            fmt = new DecimalFormat();
            fmts = new DecimalFormatSymbols();
            t = Utility.session(RestClient.pelihara);
            user = "";
            komen = "";
            email_user = "";
            finalUrl = "";
            t = Utility.session(t);
            lm = arraylist;
            activity = activity1;
            resource = j;
            ponselBaseApp = (PonselBaseApp)getActivity().getApplication();
            ponselBaseApp.getObserver().addObserver(this);
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
            catch (Hal1PencPonsel hal1pencponsel)
            {
                return;
            }
        }
    }

    public class ListPencarianAdapter.PostBagusKurangTask extends AsyncTask
    {

        final ListPencarianAdapter this$1;

        private void parseJSONLikePon(String s)
        {
            int j;
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
            j = 0;
            if (j >= jArray.length())
            {
                return;
            }
            s = jArray.getJSONObject(j);
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
            j++;
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
                break MISSING_BLOCK_LABEL_121;
            }
            notificationLikeHelper.completed(namalengkapbgskrg, notificationLikeHelper.SucdislikeStatement);
            if (statusLikeHp.equals("1"))
            {
                ponselBaseApp.getObserver().setStatus_like_ponsel("1");
                return;
            }
            try
            {
                ponselBaseApp.getObserver().setStatus_like_ponsel("0");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
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
        TextView list_txtCodename;
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


    Button btnLoadMore;
    Button btnLoadMoreKom;
    Button btnLoadMoreNextKom;
    Button btnMemuatLagi;
    Button btn_pop_komen;
    Button btn_pop_login;
    Cursor c;
    int charCount;
    ConnectivityManager cm;
    String codename;
    String codenameKomen;
    int count;
    int countAllKom;
    int countKomOld;
    int counterArray;
    Cursor cursor;
    String dataSearch;
    String dataSpek;
    DatabaseHandler db;
    EditText edtAuto;
    DroidWriterEditText edt_pop_komen;
    String email_komentar;
    String email_user;
    Bundle extras;
    LinearLayout footerView;
    String gambar;
    String getJson;
    LinearLayout grup_header_footer;
    LinearLayout headerView;
    String hp1;
    String hp2;
    String hrg_baru;
    String hrg_bekas;
    Intent i;
    String id_hp;
    String id_hph;
    String id_hpkom;
    String id_kom;
    LinearLayout imgUserKiri;
    String indexhp;
    int indexkom;
    JSONArray inponsel;
    String isikomentar;
    JSONArray jArray;
    String jml;
    String jum_komen;
    String jum_komenLikePon;
    String lastid;
    LinearLayout lay_pop_komen;
    LayoutInflater layoutInflater;
    LinearLayout layout_empty;
    LinearLayout layout_footer;
    LinearLayout layout_loading;
    LinearLayout layout_loadingNext;
    ExpandableHeightGridView listPencarianHp;
    String merk;
    String model;
    String nama_asli;
    String namalengkap;
    String namalengkapbgskrg;
    NotificationLikeHelper notificationLikeHelper;
    String oldid;
    int page;
    ListPencarianAdapter pencarianAdapter;
    ArrayList pencarianArray;
    PonselBaseApp ponselBaseApp;
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
    private TextWatcher searchTextWatcher;
    String statuslike;
    String suc;
    String t;
    String tanggal;
    private Timer timer;
    String tot_LikePon;
    String tot_dislike;
    String tot_komen;
    String tot_like;
    String totdis_LikePon;
    TextView txt_empty;
    TextView txt_footer;
    TextView txtcari;
    String urlKomen;
    String urlKomenLast;
    String urlKomenOld;
    UserFunctions userFunctions;
    String user_id;
    String user_jekel;
    String user_joindate;
    String user_kota;
    String user_photo;
    String user_ponsel1;
    String user_ponsel2;
    String user_profile_update;
    String user_provider1;
    String user_provider2;
    String user_provinsi;
    String user_ttl;
    String userkomen;
    String username;
    String userpict;
    ContextThemeWrapper wrapper;

    public Hal1PencPonsel()
    {
        indexhp = "";
        pencarianArray = null;
        getJson = "";
        count = 0;
        indexkom = 0;
        t = Utility.session(RestClient.pelihara);
        page = 1;
        oldid = "";
        lastid = "0";
        urlKomen = "";
        urlKomenOld = "";
        urlKomenLast = "";
        countKomOld = 0;
        countAllKom = 0;
        postStatus = "";
        postMessage = "";
        jum_komen = "0";
        postStatusLikePon = "";
        postMessageLikePon = "Gagal mengirim";
        tot_LikePon = "0";
        totdis_LikePon = "0";
        jum_komenLikePon = "0";
        querypopkomen = "";
        user_photo = "";
        username = "";
        inponsel = null;
        suc = "";
        searchTextWatcher = new TextWatcher() {

            final Hal1PencPonsel this$0;

            public void afterTextChanged(Editable editable)
            {
                timer = new Timer();
                timer.schedule(new TimerTask() {

                    final _cls1 this$1;

                    public void run()
                    {
                        getActivity().runOnUiThread(new Runnable() {

                            final _cls1 this$2;

                            public void run()
                            {
                                search_hp();
                            }

            
            {
                this$2 = _cls1.this;
                super();
            }
                        });
                        try
                        {
                            Thread.sleep(2000L);
                        }
                        catch (InterruptedException interruptedexception)
                        {
                            interruptedexception.printStackTrace();
                        }
                        getActivity().runOnUiThread(new Runnable() {

                            final _cls1 this$2;

                            public void run()
                            {
                            }

            
            {
                this$2 = _cls1.this;
                super();
            }
                        });
                    }


            
            {
                this$1 = _cls1.this;
                super();
            }
                }, 600L);
            }

            public void beforeTextChanged(CharSequence charsequence, int j, int k, int l)
            {
            }

            public void onTextChanged(CharSequence charsequence, int j, int k, int l)
            {
                if (timer != null)
                {
                    timer.cancel();
                }
            }


            
            {
                this$0 = Hal1PencPonsel.this;
                super();
            }
        };
    }

    private void SearchPonsel()
    {
        if (page == 1)
        {
            showProgressDialog();
            pencarianArray.clear();
        }
        Log.e("dataSearch", dataSearch);
        MyObjectRequest myobjectrequest = new MyObjectRequest(dataSearch, new com.android.volley.Response.Listener() {

            final Hal1PencPonsel this$0;

            public volatile void onResponse(Object obj)
            {
                onResponse((JSONObject)obj);
            }

            public void onResponse(JSONObject jsonobject)
            {
                parseJSON(jsonobject.toString());
                if (page == 1)
                {
                    hideProgressDialog();
                    if (suc.equals("1"))
                    {
                        progressbar_middle.setVisibility(8);
                        listPencarianHp.setVisibility(0);
                        layout_empty.setVisibility(8);
                    } else
                    {
                        grup_header_footer.setVisibility(8);
                        progressbar_middle.setVisibility(8);
                        listPencarianHp.setVisibility(8);
                        layout_empty.setVisibility(0);
                        txt_empty.setText("Ponsel belum tersedia");
                    }
                }
                pencarianAdapter.notifyDataSetChanged();
                Log.e("getChildPencarianPon", String.valueOf(listPencarianHp.getChildCount()));
                Log.e("counterArray", String.valueOf(pencarianArray.size()));
                if (counterArray < 30)
                {
                    grup_header_footer.setVisibility(8);
                    return;
                } else
                {
                    btnMemuatLagi.setVisibility(0);
                    grup_header_footer.setVisibility(0);
                    return;
                }
            }

            
            {
                this$0 = Hal1PencPonsel.this;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final Hal1PencPonsel this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
                hideProgressDialog();
            }

            
            {
                this$0 = Hal1PencPonsel.this;
                super();
            }
        }, "test", "test");
        PonselBaseApp.getInstance().addToRequestQueue(myobjectrequest, "tag_json_obj");
    }

    private void hideProgressDialog()
    {
        if (progressbar_middle.getVisibility() == 0)
        {
            progressbar_middle.setVisibility(8);
            Log.e("tasksdsurlSearch", dataSearch);
        }
    }

    private void search_hp()
    {
        grup_header_footer.setVisibility(8);
        if (edtAuto.getText().toString().trim().length() == 0)
        {
            txt_empty.setText("Masukan ponsel yang ingin dicari");
            layout_empty.setVisibility(8);
            listPencarianHp.setVisibility(0);
            return;
        }
        if (cm.getActiveNetworkInfo() == null || !cm.getActiveNetworkInfo().isAvailable() || !cm.getActiveNetworkInfo().isConnected()) goto _L2; else goto _L1
_L1:
        String s;
        progressbar_middle.setVisibility(0);
        txt_empty.setText(0x7f0c0053);
        s = edtAuto.getText().toString();
        String s1 = URLEncoder.encode(s, "utf-8");
        s = s1;
_L3:
        Log.e("key", s);
        page = 1;
        dataSearch = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("search_hp").append(Utility.BASE_FORMAT).append("?idusr=").append(user_id).append("&kat=1").append("&key=").append(s).append("&page=").append(page).append("&t=").append(t).toString();
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

    public static void setKeyboardFocus(final EditText primaryTextField)
    {
        (new Handler()).postDelayed(new Runnable() {

            private final EditText val$primaryTextField;

            public void run()
            {
                primaryTextField.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, 0.0F, 0.0F, 0));
                primaryTextField.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, 0.0F, 0.0F, 0));
            }

            
            {
                primaryTextField = edittext;
                super();
            }
        }, 100L);
    }

    private void showProgressDialog()
    {
        if (progressbar_middle.getVisibility() != 0)
        {
            progressbar_middle.setVisibility(0);
        }
        pencarianArray.clear();
    }

    public void SearchTask()
    {
        SearchPonsel();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = (ViewGroup)layoutinflater.inflate(0x7f030097, null);
        txtcari = (TextView)layoutinflater.findViewById(0x7f0b052c);
        edtAuto = (EditText)layoutinflater.findViewById(0x7f0b008d);
        txtcari.setVisibility(8);
        edtAuto.setHint("Pencarian Ponsel");
        edtAuto.addTextChangedListener(searchTextWatcher);
        edtAuto.post(new Runnable() {

            final Hal1PencPonsel this$0;

            public void run()
            {
                edtAuto.requestFocus();
            }

            
            {
                this$0 = Hal1PencPonsel.this;
                super();
            }
        });
        userFunctions = new UserFunctions();
        db = new DatabaseHandler(getActivity());
        ponselBaseApp = (PonselBaseApp)getActivity().getApplication();
        ponselBaseApp.getObserver().addObserver(this);
        extras = getActivity().getIntent().getExtras();
        notificationLikeHelper = new NotificationLikeHelper(getActivity());
        listPencarianHp = (ExpandableHeightGridView)layoutinflater.findViewById(0x7f0b052e);
        listPencarianHp.setOnScrollListener(new SampleScrollListener(getActivity()));
        listPencarianHp.setExpanded(true);
        progressbar_middle = (ProgressBar)layoutinflater.findViewById(0x7f0b00ca);
        cm = (ConnectivityManager)getActivity().getSystemService("connectivity");
        layout_empty = (LinearLayout)layoutinflater.findViewById(0x7f0b0091);
        txt_empty = (TextView)layoutinflater.findViewById(0x7f0b0093);
        btnMemuatLagi = (Button)layoutinflater.findViewById(0x7f0b00bc);
        btnMemuatLagi.setText(0x7f0c0054);
        layout_footer = (LinearLayout)layoutinflater.findViewById(0x7f0b00b9);
        grup_header_footer = (LinearLayout)layoutinflater.findViewById(0x7f0b00b7);
        txt_footer = (TextView)layoutinflater.findViewById(0x7f0b00bb);
        txt_footer.setText("Memuat");
        grup_header_footer.setVisibility(8);
        pencarianArray = new ArrayList();
        t = Utility.session(t);
        pencarianAdapter = new ListPencarianAdapter(getActivity(), 0x7f03011b, pencarianArray);
        listPencarianHp.setAdapter(pencarianAdapter);
        listPencarianHp.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final Hal1PencPonsel this$0;

            public void onItemClick(AdapterView adapterview, View view, int j, long l)
            {
                listPencarianHp.playSoundEffect(0);
                id_hph = pencarianAdapter.getListModel(j).getId_hp().toString();
                model = pencarianAdapter.getListModel(j).getModel().toString();
                merk = pencarianAdapter.getListModel(j).getMerk().toString();
                gambar = pencarianAdapter.getListModel(j).getGambar().toString();
                tot_like = pencarianAdapter.getListModel(j).getTotal_like().toString();
                tot_dislike = pencarianAdapter.getListModel(j).getTotal_dislike().toString();
                tot_komen = pencarianAdapter.getListModel(j).getTotal_kom().toString();
                hrg_baru = pencarianAdapter.getListModel(j).getHrg_baru().toString();
                hrg_bekas = pencarianAdapter.getListModel(j).getHrg_bekas().toString();
                codename = pencarianAdapter.getListModel(j).getCodename().toString();
                namalengkap = (new StringBuilder(String.valueOf(merk))).append(" ").append(model).toString();
                adapterview = new Intent(getActivity(), com/inponsel/android/details/DetailsPonsel);
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
                getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = Hal1PencPonsel.this;
                super();
            }
        });
        t = Utility.session(t);
        edtAuto.setSingleLine(true);
        edtAuto.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

            final Hal1PencPonsel this$0;

            public boolean onEditorAction(TextView textview, int j, KeyEvent keyevent)
            {
                boolean flag = false;
                if (j != 3) goto _L2; else goto _L1
_L1:
                grup_header_footer.setVisibility(8);
                if (edtAuto.getText().toString().trim().length() != 0) goto _L4; else goto _L3
_L3:
                txt_empty.setText("Masukan ponsel yang ingin dicari");
                layout_empty.setVisibility(8);
                listPencarianHp.setVisibility(0);
_L9:
                flag = true;
_L2:
                return flag;
_L4:
                if (cm.getActiveNetworkInfo() == null || !cm.getActiveNetworkInfo().isAvailable() || !cm.getActiveNetworkInfo().isConnected()) goto _L6; else goto _L5
_L5:
                progressbar_middle.setVisibility(0);
                txt_empty.setText(0x7f0c0053);
                textview = edtAuto.getText().toString();
                keyevent = URLEncoder.encode(textview, "utf-8");
                textview = keyevent;
_L7:
                Log.e("key", textview);
                page = 0;
                dataSearch = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("search_hp").append(Utility.BASE_FORMAT).append("?idusr=").append(user_id).append("&kat=1").append("&key=").append(textview).append("&page=").append(page).append("&t=").append(t).toString();
                SearchTask();
                continue; /* Loop/switch isn't completed */
                keyevent;
                keyevent.printStackTrace();
                if (true) goto _L7; else goto _L6
_L6:
                Toast.makeText(getActivity(), 0x7f0c0059, 0).show();
                if (true) goto _L9; else goto _L8
_L8:
            }

            
            {
                this$0 = Hal1PencPonsel.this;
                super();
            }
        });
        btnMemuatLagi.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1PencPonsel this$0;

            public void onClick(View view)
            {
                btnMemuatLagi.setVisibility(8);
                if (cm.getActiveNetworkInfo() == null || !cm.getActiveNetworkInfo().isAvailable() || !cm.getActiveNetworkInfo().isConnected()) goto _L2; else goto _L1
_L1:
                view = edtAuto.getText().toString();
                String s = URLEncoder.encode(view, "utf-8");
                view = s;
_L3:
                Hal1PencPonsel hal1pencponsel = Hal1PencPonsel.this;
                hal1pencponsel.page = hal1pencponsel.page + 1;
                dataSearch = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("search_hp").append(Utility.BASE_FORMAT).append("?idusr=").append(user_id).append("&kat=1").append("&key=").append(view).append("&page=").append(page).append("&t=").append(t).toString();
                Log.e("data", dataSearch);
                SearchTask();
                return;
                UnsupportedEncodingException unsupportedencodingexception;
                unsupportedencodingexception;
                unsupportedencodingexception.printStackTrace();
                if (true) goto _L3; else goto _L2
_L2:
                Toast.makeText(getActivity(), getString(0x7f0c005a), 0).show();
                return;
            }

            
            {
                this$0 = Hal1PencPonsel.this;
                super();
            }
        });
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
            nama_asli = cursor.getString(2);
            user_photo = (new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(cursor.getString(3)).toString();
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
        }
        return layoutinflater;
    }

    void parseJSON(String s)
    {
        s = new JSONObject(s);
        inponsel = s.getJSONArray("InPonsel");
        suc = s.getString("success");
        Log.e("suc", suc);
        counterArray = 0;
        if (!suc.equals("1"))
        {
            break MISSING_BLOCK_LABEL_270;
        }
        int j = 0;
_L2:
        if (j >= inponsel.length())
        {
            return;
        }
        counterArray = counterArray + 1;
        s = inponsel.getJSONObject(j);
        ListModel listmodel = new ListModel();
        listmodel.setId_hp(s.getString("id_hp"));
        listmodel.setModel(s.getString("model"));
        listmodel.setMerk(s.getString("merk"));
        listmodel.setCodename(s.getString("codename"));
        listmodel.setGambar(s.getString("gambar"));
        listmodel.setUmu_status(s.getString("umu_status"));
        listmodel.setHrg_baru(s.getString("hrg_baru"));
        listmodel.setHrg_bekas(s.getString("hrg_bekas"));
        listmodel.setTotal_like(s.getString("total_like"));
        listmodel.setTotal_dislike(s.getString("total_dislike"));
        listmodel.setTotal_hits(s.getString("total_hits"));
        listmodel.setTotal_kom(s.getString("total_kom"));
        listmodel.setMy_like_pon(s.getString("my_like_pon"));
        pencarianArray.add(listmodel);
        j++;
        if (true) goto _L2; else goto _L1
_L1:
        s;
        s.printStackTrace();
        return;
        s;
        s.printStackTrace();
    }

    public void update(Observable observable, Object obj)
    {
    }




}
