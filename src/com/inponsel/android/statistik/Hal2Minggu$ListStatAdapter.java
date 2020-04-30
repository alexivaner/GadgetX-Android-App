// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.statistik;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.NotificationLikeHelper;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.v2.KomentarPonsel;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;
import com.inponsel.android.widget.ExpandableHeightGridView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
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

// Referenced classes of package com.inponsel.android.statistik:
//            Hal2Minggu

public class t extends BaseAdapter
    implements Observer
{
    public class PostBagusKurangTask extends AsyncTask
    {

        final Hal2Minggu.ListStatAdapter this$1;

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

        public PostBagusKurangTask()
        {
            this$1 = Hal2Minggu.ListStatAdapter.this;
            super();
        }
    }

    class ViewHolder
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
        final Hal2Minggu.ListStatAdapter this$1;
        TextView txtNumber;

        ViewHolder()
        {
            this$1 = Hal2Minggu.ListStatAdapter.this;
            super();
        }
    }


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
    private DisplayImageOptions options;
    PonselBaseApp ponselBaseApp;
    int pos;
    String res;
    int resource;
    String response;
    String statusLikeHp;
    String t;
    final Hal2Minggu this$0;
    String user;
    UserFunctions userFunctions;

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

    public View getView(final int position, View view, final ViewGroup holder)
    {
        pos = position;
        if (view == null)
        {
            view = ((LayoutInflater)activity.getSystemService("layout_inflater")).inflate(resource, null);
            holder = new ViewHolder();
            holder.imageHp = (ImageView)view.findViewById(0x7f0b023d);
            holder.list_txtMerek = (TextView)view.findViewById(0x7f0b033c);
            holder.list_txtHarga = (TextView)view.findViewById(0x7f0b033d);
            holder.list_text_like = (TextView)view.findViewById(0x7f0b0344);
            holder.list_text_dislike = (TextView)view.findViewById(0x7f0b0347);
            holder.list_text_komentar = (TextView)view.findViewById(0x7f0b034a);
            holder.list_txtCodename = (TextView)view.findViewById(0x7f0b033f);
            holder.list_like = (ImageView)view.findViewById(0x7f0b0343);
            holder.list_dislike = (ImageView)view.findViewById(0x7f0b0346);
            holder.progressbar_item = (ProgressBar)view.findViewById(0x7f0b00b3);
            holder.list_lay_like = (RelativeLayout)view.findViewById(0x7f0b0342);
            holder.list_lay_dislike = (RelativeLayout)view.findViewById(0x7f0b0345);
            holder.list_lay_kom = (RelativeLayout)view.findViewById(0x7f0b0348);
            holder.rateRate = (RatingBar)view.findViewById(0x7f0b00c9);
            holder.list_txtBigRight = (TextView)view.findViewById(0x7f0b034d);
            holder.txtNumber = (TextView)view.findViewById(0x7f0b00c6);
            holder.headImage = (LinearLayout)view.findViewById(0x7f0b029f);
            view.setTag(holder);
        } else
        {
            holder = (ViewHolder)view.getTag();
        }
        lms = (ListModel)lm.get(position);
        if (lm != null)
        {
            hrg_baru = lms.getHrg_baru();
            hrg_bekas = lms.getHrg_bekas();
            ((ViewHolder) (holder)).txtNumber.setVisibility(8);
            ((ViewHolder) (holder)).txtNumber.setText(lms.getNourut());
            ((ViewHolder) (holder)).list_txtMerek.setText((new StringBuilder(String.valueOf(lms.getNourut()))).append(". ").append(lms.getMerk()).append(" ").append(lms.getModel()).toString());
            ((ViewHolder) (holder)).list_txtCodename.setText(lms.getCodename());
            ((ViewHolder) (holder)).list_text_like.setText(lms.getTotal_like());
            ((ViewHolder) (holder)).list_text_dislike.setText(lms.getTotal_dislike());
            ((ViewHolder) (holder)).list_text_komentar.setText(lms.getTotal_kom());
            ((ViewHolder) (holder)).list_txtBigRight.setText((new StringBuilder(String.valueOf(lms.getTotal_hits()))).append(" hits").toString());
            ((ViewHolder) (holder)).list_txtBigRight.setTextColor(Color.parseColor("#80f2dfc7"));
            ((ViewHolder) (holder)).list_txtBigRight.setVisibility(0);
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
            ((ViewHolder) (holder)).list_lay_like.setOnClickListener(new android.view.View.OnClickListener() {

                final Hal2Minggu.ListStatAdapter this$1;
                private final int val$position;

                public void onClick(View view1)
                {
                    Log.e("position", String.valueOf(position));
                    if (userFunctions.isUserLoggedIn(activity))
                    {
                        pos = position;
                        statusLikeHp = "1";
                        indexhp = getListModel(position).getId_hp();
                        ponselBaseApp.getObserver().setIndexHp(getListModel(position).getCodename());
                        Log.e("getNamalengkap", getListModel(position).getCodename());
                        namalengkapbgskrg = (new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString();
                        ponselBaseApp.getObserver().setId_hp(indexhp);
                        try
                        {
                            finalUrl = (new StringBuilder("idhp=")).append(getListModel(position).getId_hp()).append("&email=").append(username).append("&namalengkap=").append(URLEncoder.encode((new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString(), "utf-8")).append("&status=").append(statusLikeHp).append("&t=").append(t).toString();
                        }
                        // Misplaced declaration of an exception variable
                        catch (View view1)
                        {
                            view1.printStackTrace();
                        }
                        Log.e("finalurl", finalUrl);
                        if (android.os.Build.VERSION.SDK_INT >= 11)
                        {
                            (new PostBagusKurangTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                            return;
                        } else
                        {
                            (new PostBagusKurangTask()).execute(new Void[0]);
                            return;
                        }
                    } else
                    {
                        view1 = new android.app.AlertDialog.Builder(activity);
                        view1.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                        view1.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                            final _cls1 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = _cls1.this;
                super();
            }
                        });
                        view1.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                            final _cls1 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(activity, com/inponsel/android/v2/RegisterActivity);
                                activity.startActivity(dialoginterface);
                            }

            
            {
                this$2 = _cls1.this;
                super();
            }
                        });
                        view1.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                            final _cls1 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(activity, com/inponsel/android/v2/LoginActivity);
                                dialoginterface.putExtra("activity", "main");
                                activity.startActivity(dialoginterface);
                            }

            
            {
                this$2 = _cls1.this;
                super();
            }
                        });
                        view1.show();
                        return;
                    }
                }


            
            {
                this$1 = Hal2Minggu.ListStatAdapter.this;
                position = i;
                super();
            }
            });
            ((ViewHolder) (holder)).list_lay_dislike.setOnClickListener(new android.view.View.OnClickListener() {

                final Hal2Minggu.ListStatAdapter this$1;
                private final int val$position;

                public void onClick(View view1)
                {
                    if (userFunctions.isUserLoggedIn(activity))
                    {
                        pos = position;
                        statusLikeHp = "0";
                        indexhp = getListModel(position).getId_hp();
                        ponselBaseApp.getObserver().setIndexHp(getListModel(position).getCodename());
                        Log.e("getNamalengkap", getListModel(position).getCodename());
                        namalengkapbgskrg = (new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString();
                        ponselBaseApp.getObserver().setId_hp(indexhp);
                        try
                        {
                            finalUrl = (new StringBuilder("idhp=")).append(getListModel(position).getId_hp()).append("&email=").append(username).append("&namalengkap=").append(URLEncoder.encode((new StringBuilder(String.valueOf(getListModel(position).getMerk()))).append(" ").append(getListModel(position).getModel()).toString(), "utf-8")).append("&status=").append(statusLikeHp).append("&t=").append(t).toString();
                        }
                        // Misplaced declaration of an exception variable
                        catch (View view1)
                        {
                            view1.printStackTrace();
                        }
                        Log.e("finalurl", finalUrl);
                        if (android.os.Build.VERSION.SDK_INT >= 11)
                        {
                            (new PostBagusKurangTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                            return;
                        } else
                        {
                            (new PostBagusKurangTask()).execute(new Void[0]);
                            return;
                        }
                    } else
                    {
                        view1 = new android.app.AlertDialog.Builder(activity);
                        view1.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                        view1.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                            final _cls2 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = _cls2.this;
                super();
            }
                        });
                        view1.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                            final _cls2 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(activity, com/inponsel/android/v2/RegisterActivity);
                                activity.startActivity(dialoginterface);
                            }

            
            {
                this$2 = _cls2.this;
                super();
            }
                        });
                        view1.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                            final _cls2 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(activity, com/inponsel/android/v2/LoginActivity);
                                dialoginterface.putExtra("activity", "main");
                                activity.startActivity(dialoginterface);
                            }

            
            {
                this$2 = _cls2.this;
                super();
            }
                        });
                        view1.show();
                        return;
                    }
                }


            
            {
                this$1 = Hal2Minggu.ListStatAdapter.this;
                position = i;
                super();
            }
            });
            ((ViewHolder) (holder)).list_lay_kom.setOnClickListener(new android.view.View.OnClickListener() {

                final Hal2Minggu.ListStatAdapter this$1;
                private final int val$position;

                public void onClick(View view1)
                {
                    view1 = new Intent(getActivity(), com/inponsel/android/v2/KomentarPonsel);
                    view1.putExtra("id_hph", getListModel(position).getId_hp());
                    view1.putExtra("namalengkap", getListModel(position).getNamalengkap());
                    view1.putExtra("codename", getListModel(position).getCodename());
                    view1.putExtra("model", getListModel(position).getModel());
                    view1.putExtra("merk", getListModel(position).getMerk());
                    view1.putExtra("gambar", getListModel(position).getGambar());
                    view1.putExtra("hrg_baru", getListModel(position).getHrg_baru());
                    view1.putExtra("hrg_bekas", getListModel(position).getHrg_bekas());
                    view1.putExtra("tot_like", getListModel(position).getTotal_like());
                    view1.putExtra("tot_dislike", getListModel(position).getTotal_dislike());
                    view1.putExtra("tot_komen", getListModel(position).getTotal_kom());
                    startActivityForResult(view1, 0);
                    getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$1 = Hal2Minggu.ListStatAdapter.this;
                position = i;
                super();
            }
            });
            try
            {
                imageLoader2.displayImage((new StringBuilder(String.valueOf(Util.BASE_PATH_NEWIMAGE))).append(lms.getGambar().trim()).toString(), ((ViewHolder) (holder)).imageHp, options, new ImageLoadingListener() {

                    final Hal2Minggu.ListStatAdapter this$1;
                    private final ViewHolder val$holder;

                    public void onLoadingCancelled(String s, View view1)
                    {
                    }

                    public void onLoadingComplete(String s, View view1, Bitmap bitmap)
                    {
                        holder.progressbar_item.setVisibility(8);
                        holder.imageHp.setVisibility(0);
                    }

                    public void onLoadingFailed(String s, View view1, FailReason failreason)
                    {
                        holder.progressbar_item.setVisibility(8);
                        holder.imageHp.setVisibility(0);
                    }

                    public void onLoadingStarted(String s, View view1)
                    {
                        holder.progressbar_item.setVisibility(0);
                        holder.imageHp.setVisibility(8);
                    }

            
            {
                this$1 = Hal2Minggu.ListStatAdapter.this;
                holder = viewholder;
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
        int i = 0;
        do
        {
            if (i >= listStat.getChildCount())
            {
                return;
            }
            Log.e("int i", String.valueOf(i));
            View view = listStat.getChildAt(i);
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
        i = 0;
_L2:
        ImageView imageview;
        ImageView imageview1;
        RelativeLayout relativelayout;
        Object obj;
        if (i >= listStat.getChildCount())
        {
            return;
        }
        Log.e("int i", String.valueOf(i));
        obj = listStat.getChildAt(i);
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



    public pe(Activity activity1, int i, ArrayList arraylist)
    {
        this$0 = Hal2Minggu.this;
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
        resource = i;
        ponselBaseApp = (PonselBaseApp)getActivity().getApplication();
        ponselBaseApp.getObserver().addObserver(this);
        try
        {
            imageLoader2 = ImageLoader.getInstance();
            imageLoader2.init(ImageLoaderConfiguration.createDefault(activity.getApplicationContext()));
            options = (new com.nostra13.universalimageloader.core.()).showImageForEmptyUri(0x7f020208).cacheInMemory(true).imageScaleType(ImageScaleType.EXACTLY).bitmapConfig(android.graphics.apConfig).build();
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
        catch (Hal2Minggu hal2minggu)
        {
            return;
        }
    }
}
