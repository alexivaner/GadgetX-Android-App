// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.pencarianrinci;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.FragmentActivity;
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
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.details.DetailsPonsel;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.NotificationLikeHelper;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.ServiceHandler;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.v2.KomentarPonsel;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;
import com.inponsel.android.widget.DroidWriterEditText;
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

// Referenced classes of package com.inponsel.android.pencarianrinci:
//            Hal1Pencarian, BasePencarianActivity

public class Hal2HasilPencarian extends SherlockFragment
    implements Observer
{
    public class ListStatAdapter extends BaseAdapter
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
        final Hal2HasilPencarian this$0;
        String user;
        UserFunctions userFunctions;

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
                viewgroup.progressbar_item = (ProgressBar)view.findViewById(0x7f0b00b3);
                viewgroup.list_lay_like = (RelativeLayout)view.findViewById(0x7f0b0342);
                viewgroup.list_lay_dislike = (RelativeLayout)view.findViewById(0x7f0b0345);
                viewgroup.list_lay_kom = (RelativeLayout)view.findViewById(0x7f0b0348);
                viewgroup.list_txtCodename = (TextView)view.findViewById(0x7f0b033f);
                viewgroup.list_like = (ImageView)view.findViewById(0x7f0b0343);
                viewgroup.list_dislike = (ImageView)view.findViewById(0x7f0b0346);
                viewgroup.rateRate = (RatingBar)view.findViewById(0x7f0b00c9);
                viewgroup.list_txtBigRight = (TextView)view.findViewById(0x7f0b034d);
                viewgroup.txtNumber = (TextView)view.findViewById(0x7f0b00c6);
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
                ((ViewHolder) (viewgroup)).txtNumber.setVisibility(8);
                ((ViewHolder) (viewgroup)).txtNumber.setText(lms.getNourut());
                ((ViewHolder) (viewgroup)).list_txtMerek.setText((new StringBuilder(String.valueOf(lms.getMerk()))).append(" ").append(lms.getModel()).toString());
                ((ViewHolder) (viewgroup)).list_txtCodename.setText(lms.getCodename());
                ((ViewHolder) (viewgroup)).list_text_like.setText(lms.getTotal_like());
                ((ViewHolder) (viewgroup)).list_text_dislike.setText(lms.getTotal_dislike());
                ((ViewHolder) (viewgroup)).list_text_komentar.setText(lms.getTotal_kom());
                ((ViewHolder) (viewgroup)).list_txtBigRight.setText((new StringBuilder(String.valueOf(lms.getTotal_hits()))).append(" hits").toString());
                ((ViewHolder) (viewgroup)).list_txtBigRight.setTextColor(Color.parseColor("#f2dfc7"));
                ((ViewHolder) (viewgroup)).list_txtBigRight.setVisibility(8);
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

                    final ListStatAdapter this$1;
                    private final int val$position;

                    public void onClick(View view)
                    {
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
                            catch (View view)
                            {
                                view.printStackTrace();
                            }
                            Log.e("finalurl", finalUrl);
                            if (android.os.Build.VERSION.SDK_INT >= 11)
                            {
                                (new ListStatAdapter.PostBagusKurangTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                                return;
                            } else
                            {
                                (new ListStatAdapter.PostBagusKurangTask()).execute(new Void[0]);
                                return;
                            }
                        } else
                        {
                            view = new android.app.AlertDialog.Builder(activity);
                            view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                            view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                                final ListStatAdapter._cls1 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = ListStatAdapter._cls1.this;
                super();
            }
                            });
                            view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                                final ListStatAdapter._cls1 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(activity, com/inponsel/android/v2/RegisterActivity);
                                    activity.startActivity(dialoginterface);
                                }

            
            {
                this$2 = ListStatAdapter._cls1.this;
                super();
            }
                            });
                            view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                                final ListStatAdapter._cls1 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(activity, com/inponsel/android/v2/LoginActivity);
                                    dialoginterface.putExtra("activity", "main");
                                    activity.startActivity(dialoginterface);
                                }

            
            {
                this$2 = ListStatAdapter._cls1.this;
                super();
            }
                            });
                            view.show();
                            return;
                        }
                    }


            
            {
                this$1 = final_liststatadapter;
                position = I.this;
                super();
            }
                });
                ((ViewHolder) (viewgroup)).list_lay_dislike.setOnClickListener(i. new android.view.View.OnClickListener() {

                    final ListStatAdapter this$1;
                    private final int val$position;

                    public void onClick(View view)
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
                            catch (View view)
                            {
                                view.printStackTrace();
                            }
                            Log.e("finalurl", finalUrl);
                            if (android.os.Build.VERSION.SDK_INT >= 11)
                            {
                                (new ListStatAdapter.PostBagusKurangTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                                return;
                            } else
                            {
                                (new ListStatAdapter.PostBagusKurangTask()).execute(new Void[0]);
                                return;
                            }
                        } else
                        {
                            view = new android.app.AlertDialog.Builder(activity);
                            view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                            view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                                final ListStatAdapter._cls2 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = ListStatAdapter._cls2.this;
                super();
            }
                            });
                            view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                                final ListStatAdapter._cls2 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(activity, com/inponsel/android/v2/RegisterActivity);
                                    activity.startActivity(dialoginterface);
                                }

            
            {
                this$2 = ListStatAdapter._cls2.this;
                super();
            }
                            });
                            view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                                final ListStatAdapter._cls2 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(activity, com/inponsel/android/v2/LoginActivity);
                                    dialoginterface.putExtra("activity", "main");
                                    activity.startActivity(dialoginterface);
                                }

            
            {
                this$2 = ListStatAdapter._cls2.this;
                super();
            }
                            });
                            view.show();
                            return;
                        }
                    }


            
            {
                this$1 = final_liststatadapter;
                position = I.this;
                super();
            }
                });
                ((ViewHolder) (viewgroup)).list_lay_kom.setOnClickListener(i. new android.view.View.OnClickListener() {

                    final ListStatAdapter this$1;
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
                this$1 = final_liststatadapter;
                position = I.this;
                super();
            }
                });
                try
                {
                    imageLoader2.displayImage((new StringBuilder(String.valueOf(Util.BASE_PATH_NEWIMAGE))).append(lms.getGambar().trim()).toString(), ((ViewHolder) (viewgroup)).imageHp, options, viewgroup. new ImageLoadingListener() {

                        final ListStatAdapter this$1;
                        private final ListStatAdapter.ViewHolder val$holder;

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
                this$1 = final_liststatadapter;
                holder = ListStatAdapter.ViewHolder.this;
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



        public ListStatAdapter(Activity activity1, int i, ArrayList arraylist)
        {
            this$0 = Hal2HasilPencarian.this;
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
            catch (Hal2HasilPencarian hal2hasilpencarian)
            {
                return;
            }
        }
    }

    public class ListStatAdapter.PostBagusKurangTask extends AsyncTask
    {

        final ListStatAdapter this$1;

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

        public ListStatAdapter.PostBagusKurangTask()
        {
            this$1 = ListStatAdapter.this;
            super();
        }
    }

    class ListStatAdapter.ViewHolder
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
        final ListStatAdapter this$1;
        TextView txtNumber;

        ListStatAdapter.ViewHolder()
        {
            this$1 = ListStatAdapter.this;
            super();
        }
    }

    public class StatistikTask extends AsyncTask
    {

        final Hal2HasilPencarian this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            {
                avoid = (new ServiceHandler()).makeServiceCall(dataStatistik, 1);
                Log.e("Responseharga: ", (new StringBuilder("> ")).append(avoid).toString());
                if (avoid == null)
                {
                    break MISSING_BLOCK_LABEL_333;
                }
                ListModel listmodel;
                int i;
                try
                {
                    avoid = new JSONObject(avoid);
                    inponsel = avoid.getJSONArray("InPonsel");
                    suc = avoid.getString("success");
                    Log.e("suc", suc);
                    counterArray = 0;
                    if (!suc.equals("1"))
                    {
                        break MISSING_BLOCK_LABEL_340;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_340;
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_340;
                }
                i = 0;
            }
            if (i >= inponsel.length())
            {
                break MISSING_BLOCK_LABEL_340;
            }
            avoid = Hal2HasilPencarian.this;
            avoid.counterArray = ((Hal2HasilPencarian) (avoid)).counterArray + 1;
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
            statistikArray.add(listmodel);
            i++;
            if (true)
            {
                break MISSING_BLOCK_LABEL_116;
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
            listStat.setVisibility(0);
            layout_empty.setVisibility(8);
            if (suc.equals("1")) goto _L2; else goto _L1
_L1:
            grup_header_footer.setVisibility(8);
            progressbar_middle.setVisibility(8);
            listStat.setVisibility(0);
            layout_empty.setVisibility(0);
            txt_empty.setText("Data belum tersedia");
_L3:
            lainAdapter.notifyDataSetChanged();
            Log.e("counterArray", String.valueOf(statistikArray.size()));
            if (counterArray >= 10)
            {
                break MISSING_BLOCK_LABEL_190;
            }
            grup_header_footer.setVisibility(8);
_L4:
            getSherlockActivity().setProgressBarIndeterminateVisibility(false);
            getSherlockActivity().setProgressBarVisibility(false);
            return;
_L2:
            try
            {
                listStat.setVisibility(0);
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

        protected void onPreExecute()
        {
            super.onPreExecute();
            if (android.os.Build.VERSION.SDK_INT >= 13)
            {
                getSherlockActivity().setSupportProgressBarIndeterminateVisibility(true);
                getSherlockActivity().setProgressBarVisibility(true);
            }
        }

        public StatistikTask()
        {
            this$0 = Hal2HasilPencarian.this;
            super();
        }
    }


    public static String komencount = "";
    Button btnLoadMore;
    Button btnLoadMoreNext;
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
    Cursor cursor;
    String dataKomen;
    String dataStatistik;
    DatabaseHandler db;
    int decimalPlace;
    DroidWriterEditText edt_pop_komen;
    String email_komentar;
    String email_user;
    LinearLayout footerView;
    String gambar;
    String getJson;
    String getJsonLain;
    LinearLayout grup_header_footer;
    int hasilQ;
    LinearLayout headerView;
    String hrg_baru;
    String hrg_bekas;
    String id_hp;
    String id_hph;
    String id_kom;
    String indexhp;
    JSONArray inponsel;
    String isikomentar;
    JSONArray jArray;
    String jum_komenLikePon;
    ListStatAdapter lainAdapter;
    String lastid;
    LinearLayout lay_pop_komen;
    LayoutInflater layoutInflater;
    LinearLayout layout_empty;
    LinearLayout layout_footer;
    LinearLayout layout_loading;
    LinearLayout layout_loadingNext;
    int limit;
    ListView listKomen;
    ExpandableHeightGridView listStat;
    int lmt;
    String merk;
    String model;
    String nama_asli;
    String namalengkap;
    String namalengkapbgskrg;
    int no;
    NotificationLikeHelper notificationLikeHelper;
    String oldid;
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
    ArrayList statistikArray;
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
    String urutan;
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

    public Hal2HasilPencarian()
    {
        statistikArray = null;
        lmt = 0;
        t = Utility.session(RestClient.pelihara);
        inponsel = null;
        suc = "";
        querypopkomen = "";
        limit = 0;
        oldid = "";
        lastid = "0";
        urlKomen = "";
        urlKomenOld = "";
        urlKomenLast = "";
        countKomOld = 0;
        countAllKom = 0;
        postStatus = "";
        postMessage = "";
        getJson = "";
        getJsonLain = "";
        decimalPlace = 2;
        postStatusLikePon = "";
        postMessageLikePon = "";
        tot_LikePon = "0";
        totdis_LikePon = "0";
        jum_komenLikePon = "0";
        indexhp = "";
        user_photo = "";
        username = "";
    }

    public void StatistikTask()
    {
        statistikArray.clear();
        progressbar_middle.setVisibility(0);
        txt_empty.setText(0x7f0c0053);
        StatistikTask statistiktask = new StatistikTask();
        listStat.setVisibility(8);
        layout_empty.setVisibility(0);
        dataStatistik = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("search_advhp").append(Utility.BASE_FORMAT).append("?limit=").append("0").append("&merek=").append(Hal1Pencarian.strPencMerek).append("&umu_status=").append(Hal1Pencarian.strPencStatus).append("&hrg_baru=").append(Hal1Pencarian.strPencHarga).append("&jar_2g_status=").append(Hal1Pencarian.strPenc2G).append("&jar_3g_status=").append(Hal1Pencarian.strPenc3G).append("&jar_4g_status=").append(Hal1Pencarian.strPenc4G).append("&jar_gprs_status=").append(Hal1Pencarian.strPencGPRS).append("&jar_edge_status=").append(Hal1Pencarian.strPencEDGE).append("&jar_2g_cdma_status=").append(Hal1Pencarian.strPencCDMA).append("&jar_sc=").append(Hal1Pencarian.strPencSIM).append("&jar_multi_status=").append(Hal1Pencarian.strPencMulti).append("&jar_multi_tipe2=").append(Hal1Pencarian.strPencGSMCDMA).append("&kam_nat_vcall=").append(Hal1Pencarian.strPencNative).append("&umu_model=").append(Hal1Pencarian.strPencModel).append("&umu_dim_panjang=").append(Hal1Pencarian.strPencPanjang).append("&umu_dim_lebar=").append(Hal1Pencarian.strPencLebar).append("&umu_dim_tebal=").append(Hal1Pencarian.strPencTebal).append("&umu_bobot=").append(Hal1Pencarian.strPencBobot).append("&sof_os=").append(Hal1Pencarian.strPencSistem).append("&har_cpu_clock=").append(Hal1Pencarian.strPencProsessor).append("&har_cpu_core=").append(Hal1Pencarian.strPencCore).append("&mem_ram=").append(Hal1Pencarian.strPencRAM).append("&mem_internal=").append(Hal1Pencarian.strPencInternal).append("&mem_eksternal=").append(Hal1Pencarian.strPencEksternal).append("&lay_size_diagonal=").append(Hal1Pencarian.strPencUkuranLayar).append("&lay_size_ppi=").append(Hal1Pencarian.strPencKerapatanLayar).append("&lay_touchscreen_status=").append(Hal1Pencarian.strPencLayarSentuh).append("&lay_touchscreen=").append(Hal1Pencarian.strPencJenisSentuh).append("&kam_utama=").append(Hal1Pencarian.strPencKamera).append("&kam_depan_status=").append(Hal1Pencarian.strPencKameraDepan).append("&kam_led_flash_status=").append(Hal1Pencarian.strPencLampu).append("&kam_video=").append(Hal1Pencarian.strPencVideoRecorder).append("&kon_bluetooth_status=").append(Hal1Pencarian.strPencBluetooth).append("&kon_usb_status=").append(Hal1Pencarian.strPencUSB).append("&kon_35mm_jack=").append(Hal1Pencarian.strPenc35).append("&kon_wlan_status=").append(Hal1Pencarian.strPencWiFi).append("&kon_nfc_status=").append(Hal1Pencarian.strPencNFC).append("&kon_hdmi_status=").append(Hal1Pencarian.strPencHDMI).append("&kon_tvoutput_status=").append(Hal1Pencarian.strPencTVOut).append("&kon_infrared=").append(Hal1Pencarian.strPencInfrared).append("&fit_musik_status=").append(Hal1Pencarian.strPencMusik).append("&fit_radio_status=").append(Hal1Pencarian.strPencRadio).append("&fit_tvanalog=").append(Hal1Pencarian.strPencTVAnalog).append("&fit_gps_status=").append(Hal1Pencarian.strPencGPS).append("&bat_kapasitas=").append(Hal1Pencarian.strPencBaterai).append("&t=").append(t).append("&idusr=").append(user_id).toString();
        Log.e("urlhar", dataStatistik);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            statistiktask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            statistiktask.execute(new Void[0]);
            return;
        }
    }

    public void StatistikTaskMore()
    {
        progressbar_middle.setVisibility(0);
        txt_empty.setText(0x7f0c0053);
        limit = limit + 10;
        StatistikTask statistiktask = new StatistikTask();
        dataStatistik = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("search_advhp").append(Utility.BASE_FORMAT).append("?limit=").append(limit).append("&merek=").append(Hal1Pencarian.strPencMerek).append("&umu_status=").append(Hal1Pencarian.strPencStatus).append("&hrg_baru=").append(Hal1Pencarian.strPencHarga).append("&jar_2g_status=").append(Hal1Pencarian.strPenc2G).append("&jar_3g_status=").append(Hal1Pencarian.strPenc3G).append("&jar_4g_status=").append(Hal1Pencarian.strPenc4G).append("&jar_gprs_status=").append(Hal1Pencarian.strPencGPRS).append("&jar_edge_status=").append(Hal1Pencarian.strPencEDGE).append("&jar_2g_cdma_status=").append(Hal1Pencarian.strPencCDMA).append("&jar_sc=").append(Hal1Pencarian.strPencSIM).append("&jar_multi_status=").append(Hal1Pencarian.strPencMulti).append("&jar_multi_tipe2=").append(Hal1Pencarian.strPencGSMCDMA).append("&kam_nat_vcall=").append(Hal1Pencarian.strPencNative).append("&umu_model=").append(Hal1Pencarian.strPencModel).append("&umu_dim_panjang=").append(Hal1Pencarian.strPencPanjang).append("&umu_dim_lebar=").append(Hal1Pencarian.strPencLebar).append("&umu_dim_tebal=").append(Hal1Pencarian.strPencTebal).append("&umu_bobot=").append(Hal1Pencarian.strPencBobot).append("&sof_os=").append(Hal1Pencarian.strPencSistem).append("&har_cpu_clock=").append(Hal1Pencarian.strPencProsessor).append("&har_cpu_core=").append(Hal1Pencarian.strPencCore).append("&mem_ram=").append(Hal1Pencarian.strPencRAM).append("&mem_internal=").append(Hal1Pencarian.strPencInternal).append("&mem_eksternal=").append(Hal1Pencarian.strPencEksternal).append("&lay_size_diagonal=").append(Hal1Pencarian.strPencUkuranLayar).append("&lay_size_ppi=").append(Hal1Pencarian.strPencKerapatanLayar).append("&lay_touchscreen_status=").append(Hal1Pencarian.strPencLayarSentuh).append("&lay_touchscreen=").append(Hal1Pencarian.strPencJenisSentuh).append("&kam_utama=").append(Hal1Pencarian.strPencKamera).append("&kam_depan_status=").append(Hal1Pencarian.strPencKameraDepan).append("&kam_led_flash_status=").append(Hal1Pencarian.strPencLampu).append("&kam_video=").append(Hal1Pencarian.strPencVideoRecorder).append("&kon_bluetooth_status=").append(Hal1Pencarian.strPencBluetooth).append("&kon_usb_status=").append(Hal1Pencarian.strPencUSB).append("&kon_35mm_jack=").append(Hal1Pencarian.strPenc35).append("&kon_wlan_status=").append(Hal1Pencarian.strPencWiFi).append("&kon_nfc_status=").append(Hal1Pencarian.strPencNFC).append("&kon_hdmi_status=").append(Hal1Pencarian.strPencHDMI).append("&kon_tvoutput_status=").append(Hal1Pencarian.strPencTVOut).append("&kon_infrared=").append(Hal1Pencarian.strPencInfrared).append("&fit_musik_status=").append(Hal1Pencarian.strPencMusik).append("&fit_radio_status=").append(Hal1Pencarian.strPencRadio).append("&fit_tvanalog=").append(Hal1Pencarian.strPencTVAnalog).append("&fit_gps_status=").append(Hal1Pencarian.strPencGPS).append("&bat_kapasitas=").append(Hal1Pencarian.strPencBaterai).append("&t=").append(t).append("&idusr=").append(user_id).toString();
        Log.e("urlhar", dataStatistik);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            statistiktask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            statistiktask.execute(new Void[0]);
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = (ViewGroup)layoutinflater.inflate(0x7f0300e2, null);
        viewgroup = getTag();
        ((BasePencarianActivity)getActivity()).setHal2HasilPenc(viewgroup);
        userFunctions = new UserFunctions();
        db = new DatabaseHandler(getActivity());
        ponselBaseApp = (PonselBaseApp)getActivity().getApplication();
        ponselBaseApp.getObserver().addObserver(this);
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
        btnMemuatLagi = (Button)layoutinflater.findViewById(0x7f0b00bc);
        btnMemuatLagi.setText(0x7f0c0054);
        layout_footer = (LinearLayout)layoutinflater.findViewById(0x7f0b00b9);
        grup_header_footer = (LinearLayout)layoutinflater.findViewById(0x7f0b00b7);
        txt_footer = (TextView)layoutinflater.findViewById(0x7f0b00bb);
        txt_footer.setText("Memuat");
        grup_header_footer.setVisibility(8);
        listStat = (ExpandableHeightGridView)layoutinflater.findViewById(0x7f0b06cc);
        listStat.setExpanded(true);
        statistikArray = new ArrayList();
        lainAdapter = new ListStatAdapter(getActivity(), 0x7f03011b, statistikArray);
        listStat.setAdapter(lainAdapter);
        t = Utility.session(t);
        progressbar_middle = (ProgressBar)layoutinflater.findViewById(0x7f0b00ca);
        layout_empty = (LinearLayout)layoutinflater.findViewById(0x7f0b0091);
        layout_empty.setVisibility(0);
        txt_empty = (TextView)layoutinflater.findViewById(0x7f0b0093);
        txt_empty.setText("Silahkan pilih parameter yang diinginkan melalui halaman Pencarian");
        cm = (ConnectivityManager)getActivity().getSystemService("connectivity");
        notificationLikeHelper = new NotificationLikeHelper(getActivity());
        btnMemuatLagi.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2HasilPencarian this$0;

            public void onClick(View view)
            {
                btnMemuatLagi.setVisibility(8);
                if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected())
                {
                    Log.e("data", dataStatistik);
                    StatistikTaskMore();
                    return;
                } else
                {
                    getSherlockActivity().setProgressBarIndeterminateVisibility(false);
                    getSherlockActivity().setProgressBarVisibility(false);
                    return;
                }
            }

            
            {
                this$0 = Hal2HasilPencarian.this;
                super();
            }
        });
        t = Utility.session(t);
        listStat.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final Hal2HasilPencarian this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                listStat.playSoundEffect(0);
                id_hph = lainAdapter.getListModel(i).getId_hp().toString();
                model = lainAdapter.getListModel(i).getModel().toString();
                merk = lainAdapter.getListModel(i).getMerk().toString();
                gambar = lainAdapter.getListModel(i).getGambar().toString();
                tot_like = lainAdapter.getListModel(i).getTotal_like().toString();
                tot_dislike = lainAdapter.getListModel(i).getTotal_dislike().toString();
                tot_komen = lainAdapter.getListModel(i).getTotal_kom().toString();
                hrg_baru = lainAdapter.getListModel(i).getHrg_baru().toString();
                hrg_bekas = lainAdapter.getListModel(i).getHrg_bekas().toString();
                codename = lainAdapter.getListModel(i).getCodename().toString();
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
                this$0 = Hal2HasilPencarian.this;
                super();
            }
        });
        return layoutinflater;
    }

    public void update(Observable observable, Object obj)
    {
        if (ponselBaseApp.getObserver().getLoginStat().equals("1") && userFunctions.isUserLoggedIn(getActivity()))
        {
            cursor = db.getAllData();
            cursor.moveToFirst();
            try
            {
                user_id = EncodeDecodeAES.decrypt(RestClient.pelihara, cursor.getString(1));
            }
            // Misplaced declaration of an exception variable
            catch (Observable observable) { }
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
    }

}
