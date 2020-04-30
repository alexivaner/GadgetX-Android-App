// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.globalforum;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.Html;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.android.volley.VolleyError;
import com.dobmob.dobsliding.DobSlidingMenu;
import com.dobmob.dobsliding.events.OnCollapsedListener;
import com.dobmob.dobsliding.events.OnExpandedListener;
import com.dobmob.dobsliding.exceptions.NoActionBarException;
import com.faizmalkani.floatingactionbutton.FloatingActionButton;
import com.google.android.gms.analytics.Tracker;
import com.inponsel.android.adapter.ItemTimelineHP;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.pencariangen.TabPencarian;
import com.inponsel.android.timelinedetail.Hal1TLDetailActivity;
import com.inponsel.android.timelinedetail.TLKomenTab;
import com.inponsel.android.tlforum.ForumHPActivity;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.MyObjectRequest;
import com.inponsel.android.utils.NotificationLikeRSSHelper;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.ServiceHandler;
import com.inponsel.android.utils.ShowHideOnScroll;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.v2.ImagePagerActivity;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.ProfileOtherUser;
import com.inponsel.android.v2.RegisterActivity;
import com.inponsel.android.v2.RoomMyDraftPost;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.globalforum:
//            ForumInteraksiActivity, PostGlobalForum

public class ForumGlobalActivity extends SherlockFragmentActivity
    implements Observer
{
    public class BenchAdapter extends BaseAdapter
    {

        private Activity activity;
        Context context;
        private ArrayList lm;
        int resource;
        String response;
        final ForumGlobalActivity this$0;

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

        public View getView(int j, View view, ViewGroup viewgroup)
        {
            viewgroup = view;
            ListModel listmodel;
            if (viewgroup == null)
            {
                viewgroup = ((LayoutInflater)activity.getSystemService("layout_inflater")).inflate(resource, null);
                view = new ViewHolder();
                view.imgFoto = (ImageView)viewgroup.findViewById(0x7f0b0634);
                view.imgBench = (ImageView)viewgroup.findViewById(0x7f0b0636);
                view.txt_benchscrore = (TextView)viewgroup.findViewById(0x7f0b0637);
                view.txt_benchname = (TextView)viewgroup.findViewById(0x7f0b0638);
                view.txt_username = (TextView)viewgroup.findViewById(0x7f0b0373);
                view.txt_hp = (TextView)viewgroup.findViewById(0x7f0b0639);
                view.progressbar_Avatar = (ProgressBar)viewgroup.findViewById(0x7f0b0633);
                view.rl_benchscrore = (RelativeLayout)viewgroup.findViewById(0x7f0b0635);
                viewgroup.setTag(view);
            } else
            {
                view = (ViewHolder)viewgroup.getTag();
            }
            listmodel = (ListModel)lm.get(j);
            if (lm != null)
            {
                ((ViewHolder) (view)).rl_benchscrore.setVisibility(0);
                ((ViewHolder) (view)).txt_username.setText(listmodel.getUsername());
                ((ViewHolder) (view)).txt_benchname.setText(listmodel.getForum_tag());
                ((ViewHolder) (view)).txt_hp.setText((new StringBuilder(String.valueOf(listmodel.getMerk()))).append(" ").append(listmodel.getModel()).toString());
                ((ViewHolder) (view)).txt_benchscrore.setText(listmodel.getForum_content_ext());
                ((ViewHolder) (view)).imgFoto.setVisibility(0);
                Picasso.with(activity).load(listmodel.getForum_img_compress().trim()).placeholder(0x7f02033f).error(0x7f020209).into(((ViewHolder) (view)).imgBench);
            }
            return viewgroup;
        }

        void log(String s)
        {
        }

        public void setListArray(ArrayList arraylist)
        {
            lm = arraylist;
        }

        public BenchAdapter(Activity activity1, int j, ArrayList arraylist)
        {
            this$0 = ForumGlobalActivity.this;
            super();
            lm = arraylist;
            activity = activity1;
            resource = j;
        }
    }

    class BenchAdapter.ViewHolder
    {

        ImageView imgBench;
        ImageView imgFoto;
        ProgressBar progressbar_Avatar;
        RelativeLayout rl_benchscrore;
        final BenchAdapter this$1;
        TextView txt_benchname;
        TextView txt_benchscrore;
        TextView txt_hp;
        TextView txt_username;

        BenchAdapter.ViewHolder()
        {
            this$1 = BenchAdapter.this;
            super();
        }
    }

    public class FavoritTask extends AsyncTask
    {

        final ForumGlobalActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            try
            {
                avoid = (new StringBuilder("idartanya=")).append(idkom_pos).append("&idusr=").append(ForumGlobalActivity.user_id).append("&stat=").append(stat).append("&type=").append(id_type).append("&t=").append(t).toString();
                String s = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("add_favartanya").append(Utility.BASE_FORMAT).append("?").append(avoid).toString();
                Log.e("pushURL", s);
                s = HttpPush.getResponse(s);
                Log.e("push", (new StringBuilder(String.valueOf(s))).append(avoid).toString());
                res = s.toString();
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
            updateViewTLFav(idkom_pos, res, str_srclink);
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            if (stat.equals("1"))
            {
                mDialog = ProgressDialog.show(ForumGlobalActivity.this, "", "Menambahkan...", true);
            } else
            {
                mDialog = ProgressDialog.show(ForumGlobalActivity.this, "", "Menghapus...", true);
            }
            mDialog.setCancelable(true);
            mDialog.show();
        }

        public FavoritTask()
        {
            this$0 = ForumGlobalActivity.this;
            super();
        }
    }

    public class FotoKameraAdapter extends BaseAdapter
    {

        private Activity activity;
        Context context;
        private ArrayList lm;
        int resource;
        String response;
        final ForumGlobalActivity this$0;

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

        public View getView(int j, View view, ViewGroup viewgroup)
        {
            viewgroup = view;
            ListModel listmodel;
            if (viewgroup == null)
            {
                viewgroup = ((LayoutInflater)activity.getSystemService("layout_inflater")).inflate(resource, null);
                view = new ViewHolder();
                view.imgFoto = (ImageView)viewgroup.findViewById(0x7f0b0634);
                view.txt_username = (TextView)viewgroup.findViewById(0x7f0b0373);
                view.txt_username = (TextView)viewgroup.findViewById(0x7f0b0373);
                view.txt_hp = (TextView)viewgroup.findViewById(0x7f0b0639);
                view.progressbar_Avatar = (ProgressBar)viewgroup.findViewById(0x7f0b0633);
                viewgroup.setTag(view);
            } else
            {
                view = (ViewHolder)viewgroup.getTag();
            }
            listmodel = (ListModel)lm.get(j);
            if (lm != null)
            {
                ((ViewHolder) (view)).txt_username.setText(listmodel.getUsername());
                ((ViewHolder) (view)).txt_hp.setText((new StringBuilder(String.valueOf(listmodel.getMerk()))).append(" ").append(listmodel.getModel()).toString());
                ((ViewHolder) (view)).txt_username.setSelected(true);
                ((ViewHolder) (view)).txt_hp.setSelected(true);
                Log.e("img_comp", listmodel.getForum_img_compress());
                Picasso.with(activity).load(listmodel.getForum_img_compress().trim()).placeholder(0x7f02033f).error(0x7f020297).into(((ViewHolder) (view)).imgFoto);
            }
            return viewgroup;
        }

        void log(String s)
        {
        }

        public void setListArray(ArrayList arraylist)
        {
            lm = arraylist;
        }

        public FotoKameraAdapter(Activity activity1, int j, ArrayList arraylist)
        {
            this$0 = ForumGlobalActivity.this;
            super();
            lm = arraylist;
            activity = activity1;
            resource = j;
        }
    }

    class FotoKameraAdapter.ViewHolder
    {

        ImageView imgFoto;
        ProgressBar progressbar_Avatar;
        final FotoKameraAdapter this$1;
        TextView txt_hp;
        TextView txt_username;

        FotoKameraAdapter.ViewHolder()
        {
            this$1 = FotoKameraAdapter.this;
            super();
        }
    }

    public class ListPendatangAdapter extends BaseAdapter
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
        String statSubNews;
        String statusLikeHp;
        String t;
        final ForumGlobalActivity this$0;
        String user;
        UserFunctions userFunctions;

        public int getCount()
        {
            return arraylm.size();
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
            return (ListModel)arraylm.get(j);
        }

        public View getView(int j, View view, ViewGroup viewgroup)
        {
            pos = j;
            viewgroup = (LayoutInflater)activity.getSystemService("layout_inflater");
            if (view == null)
            {
                view = viewgroup.inflate(resource, null);
                viewgroup = new ViewHolder();
                viewgroup.imageHp = (ImageView)view.findViewById(0x7f0b023d);
                viewgroup.list_txtMerek = (TextView)view.findViewById(0x7f0b033c);
                viewgroup.list_txtHarga = (TextView)view.findViewById(0x7f0b033d);
                viewgroup.progressbar_item = (ProgressBar)view.findViewById(0x7f0b00b3);
                viewgroup.list_txtCodename = (TextView)view.findViewById(0x7f0b033f);
                viewgroup.txt_NotifHp = (TextView)view.findViewById(0x7f0b0651);
                view.setTag(viewgroup);
            } else
            {
                viewgroup = (ViewHolder)view.getTag();
            }
            lms = (ListModel)arraylm.get(j);
            if (arraylm != null)
            {
                hrg_baru = lms.getHrg_baru();
                hrg_bekas = lms.getHrg_bekas();
                ((ViewHolder) (viewgroup)).list_txtMerek.setText((new StringBuilder(String.valueOf(lms.getMerk()))).append(" ").append(lms.getModel()).toString());
                ((ViewHolder) (viewgroup)).list_txtCodename.setText(lms.getCodename());
                if (lms.getUmu_status().equals("3") || hrg_baru.equals("-") || hrg_baru.equals("0"))
                {
                    ((ViewHolder) (viewgroup)).list_txtHarga.setVisibility(8);
                } else
                {
                    ((ViewHolder) (viewgroup)).list_txtHarga.setVisibility(0);
                    ((ViewHolder) (viewgroup)).list_txtHarga.setText((new StringBuilder()).append(hrg_baru).toString());
                }
                ((ViewHolder) (viewgroup)).txt_NotifHp.setText("Hapus");
                ((ViewHolder) (viewgroup)).txt_NotifHp.setOnClickListener(j. new android.view.View.OnClickListener() {

                    final ListPendatangAdapter this$1;
                    private final int val$position;

                    public void onClick(View view)
                    {
                        if (userFunctions.isUserLoggedIn(_fld0))
                        {
                            view = new android.app.AlertDialog.Builder(_fld0);
                            view.setMessage("Hentikan langganan forum perangkat ini?");
                            view.setPositiveButton("Ya", position. new android.content.DialogInterface.OnClickListener() {

                                final ListPendatangAdapter._cls1 this$2;
                                private final int val$position;

                                public void onClick(DialogInterface dialoginterface, int j)
                                {
                                    dialoginterface.dismiss();
                                    id_hp_del = getListModel(position).getId_hp();
                                    statSubNews = "0";
                                    (new SubsNewsTask()).execute(new Void[0]);
                                }

            
            {
                this$2 = final__pcls1;
                position = I.this;
                super();
            }
                            });
                            view.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                                final ListPendatangAdapter._cls1 this$2;

                                public void onClick(DialogInterface dialoginterface, int j)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = ListPendatangAdapter._cls1.this;
                super();
            }
                            });
                            view.show();
                            return;
                        } else
                        {
                            view = new android.app.AlertDialog.Builder(_fld0);
                            view.setMessage("Untuk berlangganan forum, diharuskan login.");
                            view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                                final ListPendatangAdapter._cls1 this$2;

                                public void onClick(DialogInterface dialoginterface, int j)
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

                                public void onClick(DialogInterface dialoginterface, int j)
                                {
                                    dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                                    startActivityForResult(dialoginterface, 0);
                                    overridePendingTransition(0x7f040003, 0x7f040004);
                                }

            
            {
                this$2 = ListPendatangAdapter._cls1.this;
                super();
            }
                            });
                            view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                                final ListPendatangAdapter._cls1 this$2;

                                public void onClick(DialogInterface dialoginterface, int j)
                                {
                                    dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                                    dialoginterface.putExtra("activity", "main");
                                    startActivityForResult(dialoginterface, 0);
                                    overridePendingTransition(0x7f040003, 0x7f040004);
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


        public ListPendatangAdapter(Activity activity1, int j, ArrayList arraylist)
        {
            this$0 = ForumGlobalActivity.this;
            super();
            fmt = new DecimalFormat();
            fmts = new DecimalFormatSymbols();
            t = Utility.session(RestClient.pelihara);
            user = "";
            komen = "";
            email_user = "";
            indexhp = "";
            finalUrl = "";
            statSubNews = "";
            t = Utility.session(t);
            arraylm = arraylist;
            activity = activity1;
            resource = j;
            t = Utility.session(t);
            try
            {
                imageLoader2 = ImageLoader.getInstance();
                imageLoader2.init(ImageLoaderConfiguration.createDefault(activity.getApplicationContext()));
                options = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showImageForEmptyUri(0x7f020208).cacheInMemory(true).imageScaleType(ImageScaleType.EXACTLY).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).build();
                userFunctions = new UserFunctions();
                db = new DatabaseHandler(activity1);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (ForumGlobalActivity forumglobalactivity)
            {
                return;
            }
        }
    }

    class ListPendatangAdapter.ViewHolder
    {

        ImageView imageHp;
        TextView list_txtCodename;
        TextView list_txtHarga;
        TextView list_txtMerek;
        ProgressBar progressbar_item;
        final ListPendatangAdapter this$1;
        TextView txt_NotifHp;

        ListPendatangAdapter.ViewHolder()
        {
            this$1 = ListPendatangAdapter.this;
            super();
        }
    }

    private class PonselMerkTask extends AsyncTask
    {

        final ForumGlobalActivity this$0;

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
                    break MISSING_BLOCK_LABEL_296;
                }
                ListModel listmodel;
                int j;
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
                        break MISSING_BLOCK_LABEL_303;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_303;
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_303;
                }
                j = 0;
            }
            if (j >= inponsel.length())
            {
                break MISSING_BLOCK_LABEL_303;
            }
            avoid = ForumGlobalActivity.this;
            avoid.counterArray = ((ForumGlobalActivity) (avoid)).counterArray + 1;
            avoid = inponsel.getJSONObject(j);
            listmodel = new ListModel();
            listmodel.setId_hp(avoid.getString("id_hp"));
            listmodel.setModel(avoid.getString("model"));
            listmodel.setMerk(avoid.getString("merk"));
            listmodel.setCodename(avoid.getString("codename"));
            listmodel.setGambar(avoid.getString("gambar"));
            listmodel.setUmu_status(avoid.getString("umu_status"));
            listmodel.setHrg_baru(avoid.getString("hrg_baru"));
            listmodel.setHrg_bekas(avoid.getString("hrg_bekas"));
            ponselMerekArray.add(listmodel);
            j++;
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
            slidingView.findViewById(0x7f0b05db).setVisibility(8);
            Log.e("ponselMerekArraybefore", String.valueOf(ponselMerekArray.size()));
            Log.e("data", dataPonsel);
            Log.e("ponselMerekArrayafter", String.valueOf(ponselMerekArray.size()));
            ponselOsAdapter.notifyDataSetChanged();
            if (ponselMerekArray.size() != 0)
            {
                break MISSING_BLOCK_LABEL_128;
            }
            slidingView.findViewById(0x7f0b05dd).setVisibility(0);
_L1:
            Log.e("counterArray", String.valueOf(ponselMerekArray.size()));
            return;
            try
            {
                slidingView.findViewById(0x7f0b05dd).setVisibility(8);
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
            slidingView.findViewById(0x7f0b05db).setVisibility(0);
            ponselMerekArray.clear();
        }

        private PonselMerkTask()
        {
            this$0 = ForumGlobalActivity.this;
            super();
        }

        PonselMerkTask(PonselMerkTask ponselmerktask)
        {
            this();
        }
    }

    public class PostBagusKurangTask extends AsyncTask
    {

        final ForumGlobalActivity this$0;

        private void parseJSONLikeKom(String s)
        {
            int j;
            try
            {
                s = new JSONObject(s);
                postStatusLikeKom = s.getString("success");
                postMessageLikeKom = s.getString("message");
                Log.e("postMessageLikeKom", postMessageLikeKom);
                jArray = s.getJSONArray("InPonsel");
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
            jum_komen = s.getString("total_komen");
            tot_LikeTL = s.getString("total_like");
            totdis_LikeKom = s.getString("total_dislike");
            Log.e("tot_LikePon", tot_LikeTL);
            Log.e("totdis_LikePon", totdis_LikeKom);
            ponselBaseApp.getObserver().setJum_komenLikeTL(jum_komen);
            ponselBaseApp.getObserver().setTot_LikeTL(tot_LikeTL);
            ponselBaseApp.getObserver().setIndexTL(idkom_pos);
            j++;
            if (false)
            {
            } else
            {
                break MISSING_BLOCK_LABEL_62;
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
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    avoid = StrictMode.getThreadPolicy();
                    StrictMode.setThreadPolicy((new android.os.StrictMode.ThreadPolicy.Builder(avoid)).permitDiskWrites().build());
                    StrictMode.setThreadPolicy(avoid);
                }
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("likedis_artanya.php?").append(querylike).toString();
                Log.e("pushURL", avoid);
                avoid = HttpPush.getResponse(avoid);
                reslike = avoid.toString();
                parseJSONLikeKom(reslike);
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
            ponselBaseApp.getObserver().setStatus_like_ponsel("-");
            Log.e("postStatusLikeKom", postStatusLikeKom);
            if (!postStatusLikeKom.equals("1"))
            {
                break MISSING_BLOCK_LABEL_286;
            }
            if (!id_type.equals("faqhp")) goto _L2; else goto _L1
_L1:
            if (!statuslike.equals("1")) goto _L4; else goto _L3
_L3:
            notificationLikeHelper.completed("Tanya Ponsel", notificationLikeHelper.likefrontKomen);
_L5:
            Log.e("mArrayListData", String.valueOf(mArrayListData.size()));
            Log.e("index_komposlike", idkom_pos);
            updateViewLikeDis(idkom_pos);
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                (new SendMailLikeForumTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                return;
            }
            break MISSING_BLOCK_LABEL_266;
_L4:
            try
            {
                notificationLikeHelper.completed("Tanya Ponsel", notificationLikeHelper.dislikefrontKomen);
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
              goto _L5
_L2:
label0:
            {
                if (!statuslike.equals("1"))
                {
                    break label0;
                }
                notificationLikeHelper.completed("Artikel Ponsel", notificationLikeHelper.likefrontKomen);
            }
              goto _L5
            notificationLikeHelper.completed("Artikel Ponsel", notificationLikeHelper.dislikefrontKomen);
              goto _L5
            (new SendMailLikeForumTask()).execute(new Void[0]);
            return;
            if (!id_type.equals("faqhp"))
            {
                break MISSING_BLOCK_LABEL_356;
            }
            if (statuslike.equals("1"))
            {
                notificationLikeHelper.gagal("Tanya Ponsel", postMessageLikeKom);
                return;
            }
            notificationLikeHelper.gagal("Tanya Ponsel", postMessageLikeKom);
            return;
            if (statuslike.equals("1"))
            {
                notificationLikeHelper.gagal("Artikel Ponsel", postMessageLikeKom);
                return;
            }
            notificationLikeHelper.gagal("Artikel Ponsel", postMessageLikeKom);
            return;
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            if (id_type.equals("faqhp"))
            {
                if (statuslike.equals("1"))
                {
                    notificationLikeHelper.createNotification("Tanya Ponsel", notificationLikeHelper.likefrontKomen);
                    return;
                } else
                {
                    notificationLikeHelper.createNotification("Tanya Ponsel", notificationLikeHelper.dislikefrontKomen);
                    return;
                }
            }
            if (statuslike.equals("1"))
            {
                notificationLikeHelper.createNotification("Artikel Ponsel", notificationLikeHelper.likefrontKomen);
                return;
            } else
            {
                notificationLikeHelper.createNotification("Artikel Ponsel", notificationLikeHelper.dislikefrontKomen);
                return;
            }
        }

        public PostBagusKurangTask()
        {
            this$0 = ForumGlobalActivity.this;
            super();
        }
    }

    public class PostFlagTask extends AsyncTask
    {

        final ForumGlobalActivity this$0;

        private void parseJSONFlag(String s)
        {
            try
            {
                s = new JSONObject(s);
                postStatusFlagKom = s.getString("success");
                postMessageFlagKom = s.getString("message");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
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
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    avoid = StrictMode.getThreadPolicy();
                    StrictMode.setThreadPolicy((new android.os.StrictMode.ThreadPolicy.Builder(avoid)).permitDiskWrites().build());
                    StrictMode.setThreadPolicy(avoid);
                }
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("flag_artanya.php?").append(queryFlag).toString();
                Log.e("pushURLFlag", avoid);
                avoid = HttpPush.getResponse(avoid);
                resFlag = avoid.toString();
                parseJSONFlag(resFlag);
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
            Toast.makeText(ForumGlobalActivity.this, postMessageFlagKom, 1).show();
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            Toast.makeText(ForumGlobalActivity.this, "Mengirim laporan...", 1).show();
        }

        public PostFlagTask()
        {
            this$0 = ForumGlobalActivity.this;
            super();
        }
    }

    public class SendMailLikeForumTask extends AsyncTask
    {

        final ForumGlobalActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            try
            {
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    avoid = StrictMode.getThreadPolicy();
                    StrictMode.setThreadPolicy((new android.os.StrictMode.ThreadPolicy.Builder(avoid)).permitDiskWrites().build());
                    StrictMode.setThreadPolicy(avoid);
                }
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("mail_forum_postlike").append(Utility.BASE_FORMAT).append("?").append(querylike).append("&dens=").append(getResources().getDisplayMetrics().density).toString();
                Log.e("mail_like_com", avoid);
                avoid = HttpPush.getResponse(avoid);
                res = avoid.toString();
                res = res.trim();
                res = res.replaceAll("\\s+", "");
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
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
        }

        public SendMailLikeForumTask()
        {
            this$0 = ForumGlobalActivity.this;
            super();
        }
    }

    public class SubsNewsTask extends AsyncTask
    {

        final ForumGlobalActivity this$0;

        private void parseJSONSubsNews(String s)
        {
            try
            {
                s = new JSONObject(s);
                postStatusSubsNews = s.getString("success");
                postMessageSubsNews = s.getString("message");
                jArray = s.getJSONArray("InPonsel");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
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
                querySubs = (new StringBuilder("idhp=")).append(id_hp_del).append("&idusr=").append(ForumGlobalActivity.user_id).append("&type=").append("all").append("&stat=").append("0").append("&t=").append(t).toString();
                pushURLSubs = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("add_subscribe_artikel").append(Utility.BASE_FORMAT).append("?").append(querySubs).toString();
                Log.e("pushURL", pushURLSubs);
                avoid = HttpPush.getResponse(pushURLSubs);
                Log.e("push", (new StringBuilder(String.valueOf(avoid))).append(querySubs).toString());
                resSubs = avoid.toString();
                Log.e("url ", resSubs);
                parseJSONSubsNews(resSubs);
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
            dataPonsel = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("user_forum_hp").append(Utility.BASE_FORMAT).append("?t=").append(t).append("&id_user=").append(ForumGlobalActivity.user_id).toString();
            Log.e("data", dataPonsel);
            PonselMerkTask();
            if (postStatusSubsNews.equals("1") || postStatusSubsNews.equals("10"))
            {
                Toast.makeText(ForumGlobalActivity.this, postMessageSubsNews, 1).show();
                mDialog.dismiss();
                return;
            }
            if (postStatusSubsNews.equals("00") || postStatusSubsNews.equals("0"))
            {
                Toast.makeText(ForumGlobalActivity.this, postMessageSubsNews, 1).show();
                mDialog.dismiss();
                return;
            }
            if (postStatusSubsNews.equals("40404"))
            {
                mDialog.dismiss();
                return;
            } else
            {
                Toast.makeText(ForumGlobalActivity.this, postMessageSubsNews, 1).show();
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            mDialog = ProgressDialog.show(ForumGlobalActivity.this, "", "Menghapus...", true);
            mDialog.setCancelable(true);
            mDialog.show();
        }

        public SubsNewsTask()
        {
            this$0 = ForumGlobalActivity.this;
            super();
        }
    }


    public static String email_user;
    public static String nama_asli;
    public static String user_id;
    public static String user_jekel;
    public static String user_joindate;
    public static String user_kecamatan;
    public static String user_kota;
    public static String user_photo = "";
    public static String user_ponsel1;
    public static String user_ponsel2;
    public static String user_profile_update;
    public static String user_provider1;
    public static String user_provider2;
    public static String user_provinsi;
    public static String user_ttl;
    public static String username = "";
    ArrayList BenchArrayList;
    private String TAG;
    ActionBar actionBar;
    int actionBarTitleId;
    String benchmark_urutkan[] = {
        "Tertinggi", "Terendah"
    };
    String bottom_id;
    LinearLayout bottom_list;
    FloatingActionButton btnAddArtikel;
    Button btn_sort_benchmark;
    Cursor c;
    int charCount;
    ConnectivityManager cm;
    String codename;
    int countAllKom;
    int countKomOld;
    String counter;
    int counterArray;
    int counterBench;
    int counterFoto;
    Cursor cursor;
    String dataIDMerk;
    String dataPonsel;
    DatabaseHandler db;
    Bundle extras;
    String first_get;
    ArrayList fotoKameraArrayList;
    String gambar;
    boolean get_last;
    GridView grid_benchmark;
    GridView grid_hasilfoto;
    LinearLayout grup_footer;
    LinearLayout grup_footerFoto;
    LinearLayout grup_footerbenchmark;
    Intent i;
    String id_hp;
    String id_hp_del;
    String id_type;
    String idkom_pos;
    ImageView imageArtikelType;
    ImageView imageAvatar;
    ImageView imageMedia;
    ImageView img_empty;
    ImageView img_label_actionbar;
    JSONArray inponsel;
    boolean isExpand;
    JSONArray jArray;
    String json_response;
    String jum_komen;
    LinearLayout lay_quote;
    LinearLayout layout_footerProg;
    LinearLayout layout_footerProgFoto;
    LinearLayout layout_footerProgbenchmark;
    int limit;
    GridView listHpForum;
    RelativeLayout list_lay_favorit;
    RelativeLayout list_lay_flag;
    RelativeLayout list_lay_kom;
    RelativeLayout list_lay_like;
    LinearLayout list_timeline_hp;
    LinearLayout ll_TLTerbaru;
    LinearLayout ll_TLTerkomentari;
    LinearLayout ll_TLTerpopuler;
    RelativeLayout ll_forumlist;
    RelativeLayout ll_forumlistFoto;
    RelativeLayout ll_forumlistbenchmark;
    LinearLayout ll_head_1;
    LinearLayout ll_head_2;
    private ArrayList mArrayListData;
    BenchAdapter mBenchAdapter;
    ProgressDialog mDialog;
    FotoKameraAdapter mFotoKameraAdapter;
    ProgressBar menu_progressbar_item;
    String merk;
    String model;
    String namalengkap;
    String new_load;
    NotificationLikeRSSHelper notificationLikeHelper;
    PonselBaseApp ponselBaseApp;
    public ArrayList ponselMerekArray;
    public ListPendatangAdapter ponselOsAdapter;
    TextView pop_txt_empty;
    String postMessageAddTL;
    String postMessageFlagKom;
    String postMessageLikeKom;
    String postMessageSubsNews;
    String postStatusAddTL;
    String postStatusFlagKom;
    String postStatusLikeKom;
    String postStatusSubsNews;
    ProgressBar progressbar_TimelineHP;
    ProgressBar progressbar_imgcontent;
    String pushURLSubs;
    String pushURLSubsStat;
    String queryFlag;
    String querySubs;
    String querySubsStat;
    String querylike;
    String res;
    String resFlag;
    String resSubs;
    String reslike;
    String resolution;
    RelativeLayout rl_ForumAndroid;
    RelativeLayout rl_ForumBenchmark;
    RelativeLayout rl_ForumBlackberry;
    RelativeLayout rl_ForumFAQ;
    RelativeLayout rl_ForumFoto;
    RelativeLayout rl_ForumIOS;
    RelativeLayout rl_ForumLain;
    RelativeLayout rl_ForumWP;
    RelativeLayout rl_actionbarforum;
    RelativeLayout rl_media;
    ViewGroup scroll_artikel;
    View slidingView;
    String stat;
    String statuslike;
    String strKonekStat;
    String str_srclink;
    String str_urutkan_benchmark;
    String suc;
    String succesStat;
    String t;
    String tag_timeline;
    String tambah_artikel[] = {
        "Topik umum", "Tips & trik", "Hasil foto kamera", "Benchmark", "Aksesori", "Tanya"
    };
    String titleMerek;
    TextView topTextView;
    String top_id;
    String tot_LikePon;
    String tot_LikeTL;
    String totdis_LikeKom;
    String totdis_LikePon;
    TextView txtBenchSkor;
    TextView txtContent;
    TextView txtContentExt;
    TextView txtForumHashTag;
    TextView txtIdHP;
    TextView txtIdKom;
    TextView txtImgAva;
    TextView txtImgMedia;
    TextView txtLikeKom;
    TextView txtTag;
    TextView txtTanggapan;
    TextView txtTitle;
    TextView txtTotalKom;
    TextView txtType;
    TextView txtUsername;
    TextView txtWaktu;
    TextView txt_label_actionbar;
    TextView txt_sublabel_actionbar;
    TextView txtbtnfooter;
    TextView txtbtnfooterFoto;
    TextView txtbtnfooterbenchmark;
    TextView txtdisLikeKom;
    String urlFoto;
    String urlTimelineHPTag;
    String urlTimelineHPTagLast;
    String urlTimelineHPTagOld;
    private boolean useLogo;
    UserFunctions userFunctions;
    private DobSlidingMenu vSlidingMenu;
    ContextThemeWrapper wrapperLight;

    public ForumGlobalActivity()
    {
        useLogo = false;
        actionBarTitleId = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        tag_timeline = "";
        get_last = false;
        postStatusAddTL = "";
        postMessageAddTL = "";
        resolution = "450";
        id_hp_del = "";
        urlTimelineHPTag = "";
        urlTimelineHPTagOld = "";
        urlTimelineHPTagLast = "";
        first_get = "";
        new_load = "";
        bottom_id = "";
        top_id = "0";
        jum_komen = "0";
        tot_LikePon = "";
        totdis_LikePon = "";
        succesStat = "";
        countKomOld = 0;
        countAllKom = 0;
        counterFoto = 0;
        counterBench = 0;
        urlFoto = "";
        limit = 0;
        strKonekStat = "";
        postStatusLikeKom = "";
        postMessageLikeKom = "Gagal mengirim";
        tot_LikeTL = "0";
        totdis_LikeKom = "0";
        queryFlag = "";
        querylike = "";
        postStatusFlagKom = "";
        postMessageFlagKom = "Gagal mengirim";
        resFlag = "";
        counter = "";
        isExpand = false;
        TAG = getClass().getSimpleName();
        ponselMerekArray = null;
        titleMerek = "InPonsel";
        inponsel = null;
        suc = "";
        t = Utility.session(RestClient.pelihara);
        fotoKameraArrayList = null;
        BenchArrayList = null;
        str_urutkan_benchmark = "0";
        json_response = "";
    }

    private void ArtikelTanyaNewTask()
    {
        Log.e("urlTimelineHPTagLast", urlTimelineHPTagLast);
        MyObjectRequest myobjectrequest = new MyObjectRequest(urlTimelineHPTagLast, new com.android.volley.Response.Listener() {

            final ForumGlobalActivity this$0;

            public volatile void onResponse(Object obj)
            {
                onResponse((JSONObject)obj);
            }

            public void onResponse(JSONObject jsonobject)
            {
                mArrayListData.clear();
                parseJSONNew(jsonobject.toString());
                Log.e("succesStat", succesStat);
                if (succesStat.equals("1"))
                {
                    afterParse();
                }
                ponselBaseApp.getObserver().setLoginStat("1");
            }

            
            {
                this$0 = ForumGlobalActivity.this;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final ForumGlobalActivity this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
            }

            
            {
                this$0 = ForumGlobalActivity.this;
                super();
            }
        }, "test", "test");
        PonselBaseApp.getInstance().addToRequestQueue(myobjectrequest, "tag_json_obj");
    }

    private void ArtikelTanyaOLDTask()
    {
        showProgressDialogOLD();
        Log.e("urlTimelineHPTagOld", urlTimelineHPTagOld);
        MyObjectRequest myobjectrequest = new MyObjectRequest(urlTimelineHPTagOld, new com.android.volley.Response.Listener() {

            final ForumGlobalActivity this$0;

            public volatile void onResponse(Object obj)
            {
                onResponse((JSONObject)obj);
            }

            public void onResponse(JSONObject jsonobject)
            {
                parseJSONOLD(jsonobject.toString());
                afterParse();
                hideProgressDialogOLD();
                ponselBaseApp.getObserver().setLoginStat("1");
            }

            
            {
                this$0 = ForumGlobalActivity.this;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final ForumGlobalActivity this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
                hideProgressDialogOLD();
            }

            
            {
                this$0 = ForumGlobalActivity.this;
                super();
            }
        }, "test", "test");
        PonselBaseApp.getInstance().addToRequestQueue(myobjectrequest, "tag_json_obj");
    }

    private void ArtikelTanyaTask()
    {
        showProgressDialog();
        Log.e("urlTimelineHPTag", urlTimelineHPTag);
        MyObjectRequest myobjectrequest = new MyObjectRequest(urlTimelineHPTag, new com.android.volley.Response.Listener() {

            final ForumGlobalActivity this$0;

            public volatile void onResponse(Object obj)
            {
                onResponse((JSONObject)obj);
            }

            public void onResponse(JSONObject jsonobject)
            {
                Log.e("jsonGlobal", jsonobject.toString());
                parseJSON(jsonobject.toString());
                afterParse();
                hideProgressDialog();
                if (succesStat.equals("0"))
                {
                    pop_txt_empty.setVisibility(0);
                    img_empty.setVisibility(0);
                    pop_txt_empty.setText("Konten belum tersedia");
                } else
                {
                    ll_forumlist.setVisibility(0);
                }
                ponselBaseApp.getObserver().setLoginStat("1");
            }

            
            {
                this$0 = ForumGlobalActivity.this;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final ForumGlobalActivity this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
                hideProgressDialog();
            }

            
            {
                this$0 = ForumGlobalActivity.this;
                super();
            }
        }, "test", "test");
        PonselBaseApp.getInstance().addToRequestQueue(myobjectrequest, "tag_json_obj");
    }

    private void GetBenchList(final String nextprev)
    {
        if (nextprev.equals("now"))
        {
            showProgressDialogBench();
            BenchArrayList.clear();
            limit = 0;
            urlFoto = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("timeline_benchmark").append(Utility.BASE_FORMAT).append("?").append("codename=").append(codename).append("&id_user=").append(user_id).append("&tag=").append(tag_timeline).append("&t=").append(t).append("&sort=").append(str_urutkan_benchmark).append("&lmt=0").toString();
        } else
        {
            limit = limit + 8;
            layout_footerProgbenchmark.setVisibility(0);
            txtbtnfooterbenchmark.setVisibility(8);
            urlFoto = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("timeline_benchmark").append(Utility.BASE_FORMAT).append("?").append("codename=").append(codename).append("&id_user=").append(user_id).append("&tag=").append(tag_timeline).append("&bottom_id=").append(bottom_id).append("&t=").append(t).append("&sort=").append(str_urutkan_benchmark).append("&lmt=").append(limit).toString();
        }
        Log.e("urlFoto", urlFoto);
        nextprev = new MyObjectRequest(urlFoto, new com.android.volley.Response.Listener() {

            final ForumGlobalActivity this$0;
            private final String val$nextprev;

            private void parseJSONBenchmark(String s)
            {
                JSONObject jsonobject = new JSONObject(s);
                s = jsonobject.getJSONArray("InPonsel");
                bottom_id = jsonobject.getString("bottom_id");
                top_id = jsonobject.getString("top_id");
                if (jsonobject.getString("success").equals("0"))
                {
                    break MISSING_BLOCK_LABEL_396;
                }
                counterBench = s.length();
                int j = 0;
_L2:
                if (j >= s.length())
                {
                    return;
                }
                JSONObject jsonobject1 = s.getJSONObject(j);
                ListModel listmodel = new ListModel();
                listmodel.setForum_id(jsonobject1.getString("id"));
                listmodel.setId_hp(jsonobject1.getString("id_hp"));
                listmodel.setCodename(jsonobject1.getString("codename"));
                listmodel.setMerk(jsonobject1.getString("merk"));
                listmodel.setModel(jsonobject1.getString("model"));
                listmodel.setId_user(jsonobject1.getString("id_user"));
                listmodel.setUsername(jsonobject1.getString("user_name"));
                listmodel.setKota(jsonobject1.getString("user_kota"));
                listmodel.setImg_height(jsonobject1.getString("height"));
                listmodel.setImg_width(jsonobject1.getString("width"));
                listmodel.setForum_short_content(jsonobject1.getString("short_content"));
                listmodel.setForum_totkomen(jsonobject1.getJSONObject("likedislike").getString("total_komen"));
                listmodel.setForum_tothits(jsonobject1.getJSONObject("likedislike").getString("total_hits"));
                listmodel.setAvatar(jsonobject1.getString("user_photo"));
                listmodel.setForum_content(jsonobject1.getString("content"));
                listmodel.setForum_date(jsonobject1.getString("date"));
                listmodel.setForum_img(jsonobject1.getString("img_url"));
                listmodel.setForum_img_compress(jsonobject1.getString("img_compress"));
                listmodel.setForum_judul(jsonobject1.getString("judul"));
                listmodel.setForum_type(jsonobject1.getString("type"));
                listmodel.setForum_content_ext(jsonobject1.getString("content_ext"));
                listmodel.setForum_like(jsonobject1.getJSONObject("likedislike").getString("total_like"));
                listmodel.setForum_myfav(jsonobject1.getJSONObject("likedislike").getString("my_fav_tl"));
                listmodel.setForum_mylike(jsonobject1.getJSONObject("likedislike").getString("my_like_tl"));
                listmodel.setForum_tag(jsonobject1.getString("tag"));
                BenchArrayList.add(listmodel);
                j++;
                if (true) goto _L2; else goto _L1
_L1:
                s;
                s.printStackTrace();
            }

            public volatile void onResponse(Object obj)
            {
                onResponse((JSONObject)obj);
            }

            public void onResponse(JSONObject jsonobject)
            {
                parseJSONBenchmark(jsonobject.toString());
                mBenchAdapter.setListArray(BenchArrayList);
                grid_benchmark.setVisibility(0);
                ll_forumlistbenchmark.setVisibility(0);
                mBenchAdapter.notifyDataSetChanged();
                Log.e("countter", String.valueOf(BenchArrayList.size()));
                progressbar_TimelineHP.setVisibility(8);
                btn_sort_benchmark.setVisibility(0);
                if (counterBench < 8)
                {
                    txtbtnfooterbenchmark.setVisibility(8);
                    grup_footerbenchmark.setVisibility(8);
                } else
                {
                    layout_footerProgbenchmark.setVisibility(8);
                    txtbtnfooterbenchmark.setVisibility(0);
                }
                if (nextprev.equals("now"))
                {
                    hideProgressDialogBench();
                }
            }

            
            {
                this$0 = ForumGlobalActivity.this;
                nextprev = s;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final ForumGlobalActivity this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
                hideProgressDialog();
            }

            
            {
                this$0 = ForumGlobalActivity.this;
                super();
            }
        }, "test", "test");
        PonselBaseApp.getInstance().addToRequestQueue(nextprev, "Foto");
    }

    private void GetFotoList(final String nextprev)
    {
        if (nextprev.equals("now"))
        {
            showProgressDialogFoto();
            fotoKameraArrayList.clear();
            urlFoto = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("timeline_global_forum_tag").append(Utility.BASE_FORMAT).append("?").append("codename=").append(codename).append("&id_user=").append(user_id).append("&tag=").append(tag_timeline).append("&t=").append(t).toString();
        } else
        {
            progressbar_TimelineHP.setVisibility(8);
            layout_footerProgFoto.setVisibility(0);
            txtbtnfooterFoto.setVisibility(8);
            urlFoto = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("timeline_global_forum_tag").append(Utility.BASE_FORMAT).append("?").append("codename=").append(codename).append("&id_user=").append(user_id).append("&tag=").append(tag_timeline).append("&bottom_id=").append(bottom_id).append("&t=").append(t).toString();
        }
        Log.e("urlFoto", urlFoto);
        nextprev = new MyObjectRequest(urlFoto, new com.android.volley.Response.Listener() {

            final ForumGlobalActivity this$0;
            private final String val$nextprev;

            public volatile void onResponse(Object obj)
            {
                onResponse((JSONObject)obj);
            }

            public void onResponse(JSONObject jsonobject)
            {
                parseJSONFoto(jsonobject.toString());
                mFotoKameraAdapter.setListArray(fotoKameraArrayList);
                grid_hasilfoto.setVisibility(0);
                ll_forumlistFoto.setVisibility(0);
                mFotoKameraAdapter.notifyDataSetChanged();
                Log.e("countter", String.valueOf(fotoKameraArrayList.size()));
                if (counterFoto < 8)
                {
                    txtbtnfooterFoto.setVisibility(8);
                    grup_footerFoto.setVisibility(8);
                } else
                {
                    layout_footerProgFoto.setVisibility(8);
                    txtbtnfooterFoto.setVisibility(0);
                }
                progressbar_TimelineHP.setVisibility(8);
                if (nextprev.equals("now"))
                {
                    hideProgressDialogFoto();
                }
            }

            
            {
                this$0 = ForumGlobalActivity.this;
                nextprev = s;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final ForumGlobalActivity this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
                hideProgressDialog();
            }

            
            {
                this$0 = ForumGlobalActivity.this;
                super();
            }
        }, "test", "test");
        PonselBaseApp.getInstance().addToRequestQueue(nextprev, "Foto");
    }

    private void afterParse()
    {
        View view;
        final String tl_id;
        final String tl_id_hp;
        final String tl_codename;
        final String tl_id_user;
        final String tl_judul;
        final String tl_content;
        final String tl_content_ext;
        final String tl_img_url;
        final String tl_tag;
        final String tl_type;
        final String tl_username;
        final String tl_kota;
        final String tl_userphoto;
        final String tl_date;
        final String total_like;
        final String like_stat;
        final String fav_stat;
        Object obj;
        Object obj1;
        String s;
        String s1;
        int j;
        int k;
        int l;
        if (succesStat.equals("1"))
        {
            Log.e("listcount", String.valueOf(mArrayListData.size()));
            get_last = true;
            j = 0;
        } else
        {
            grup_footer.setVisibility(8);
            progressbar_TimelineHP.setVisibility(8);
            pop_txt_empty.setVisibility(0);
            img_empty.setVisibility(0);
            pop_txt_empty.setText("Konten masih kosong");
            return;
        }
        if (j >= mArrayListData.size())
        {
            progressbar_imgcontent.setVisibility(8);
            return;
        }
        view = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f0300b8, null);
        rl_media = (RelativeLayout)view.findViewById(0x7f0b05f7);
        progressbar_imgcontent = (ProgressBar)view.findViewById(0x7f0b05f4);
        txtUsername = (TextView)view.findViewById(0x7f0b0419);
        txtTitle = (TextView)view.findViewById(0x7f0b05ec);
        imageMedia = (ImageView)view.findViewById(0x7f0b046c);
        imageAvatar = (ImageView)view.findViewById(0x7f0b05e3);
        imageArtikelType = (ImageView)view.findViewById(0x7f0b05e4);
        txtIdKom = (TextView)view.findViewById(0x7f0b054d);
        txtIdHP = (TextView)view.findViewById(0x7f0b05e5);
        txtContent = (TextView)view.findViewById(0x7f0b05ed);
        txtContentExt = (TextView)view.findViewById(0x7f0b05eb);
        txtBenchSkor = (TextView)view.findViewById(0x7f0b05f5);
        txtForumHashTag = (TextView)view.findViewById(0x7f0b05f3);
        txtWaktu = (TextView)view.findViewById(0x7f0b054c);
        txtImgAva = (TextView)view.findViewById(0x7f0b05e9);
        txtImgMedia = (TextView)view.findViewById(0x7f0b05ea);
        txtType = (TextView)view.findViewById(0x7f0b05e7);
        txtTag = (TextView)view.findViewById(0x7f0b05e8);
        obj = (ImageView)view.findViewById(0x7f0b054f);
        obj1 = (ImageView)view.findViewById(0x7f0b05f1);
        txtLikeKom = (TextView)view.findViewById(0x7f0b0551);
        txtdisLikeKom = (TextView)view.findViewById(0x7f0b0554);
        txtTotalKom = (TextView)view.findViewById(0x7f0b034a);
        bottom_list = (LinearLayout)view.findViewById(0x7f0b0341);
        list_lay_like = (RelativeLayout)view.findViewById(0x7f0b0342);
        list_lay_flag = (RelativeLayout)view.findViewById(0x7f0b05ee);
        list_lay_favorit = (RelativeLayout)view.findViewById(0x7f0b05f0);
        list_lay_kom = (RelativeLayout)view.findViewById(0x7f0b0348);
        tl_id = ((ItemTimelineHP)mArrayListData.get(j)).getTimeline_id();
        tl_id_hp = ((ItemTimelineHP)mArrayListData.get(j)).getTimeline_id_hp();
        tl_codename = ((ItemTimelineHP)mArrayListData.get(j)).getTimeline_codename();
        tl_id_user = ((ItemTimelineHP)mArrayListData.get(j)).getTimeline_id_user();
        tl_judul = ((ItemTimelineHP)mArrayListData.get(j)).getTimeline_title();
        tl_content = ((ItemTimelineHP)mArrayListData.get(j)).getTimeline_content();
        tl_content_ext = ((ItemTimelineHP)mArrayListData.get(j)).getTimeline_content_ext();
        s = ((ItemTimelineHP)mArrayListData.get(j)).getTimeline_short_content();
        tl_img_url = ((ItemTimelineHP)mArrayListData.get(j)).getTimeline_img_url();
        k = ((ItemTimelineHP)mArrayListData.get(j)).getTimeline_imgwidth();
        l = ((ItemTimelineHP)mArrayListData.get(j)).getTimeline_imgheight();
        tl_tag = ((ItemTimelineHP)mArrayListData.get(j)).getTimeline_tag();
        tl_type = ((ItemTimelineHP)mArrayListData.get(j)).getTimeline_type();
        tl_username = ((ItemTimelineHP)mArrayListData.get(j)).getTimeline_username();
        tl_kota = ((ItemTimelineHP)mArrayListData.get(j)).getTimeline_userkota();
        tl_userphoto = ((ItemTimelineHP)mArrayListData.get(j)).getTimeline_userphoto();
        tl_date = ((ItemTimelineHP)mArrayListData.get(j)).getTimeline_date();
        total_like = ((ItemTimelineHP)mArrayListData.get(j)).getTimeline_tot_like();
        like_stat = ((ItemTimelineHP)mArrayListData.get(j)).getTimeline_like_stat();
        s1 = ((ItemTimelineHP)mArrayListData.get(j)).getTimeline_tot_komen();
        fav_stat = ((ItemTimelineHP)mArrayListData.get(j)).getTimeline_fav_stat();
        if (tl_type.equals("artikel"))
        {
            txtTitle.setText(Html.fromHtml(tl_judul));
        } else
        {
            try
            {
                txtTitle.setText(Html.fromHtml(tl_judul));
            }
            catch (Exception exception1) { }
        }
        Log.e("tl_content_ext", tl_content_ext);
        txtIdKom.setText(tl_id);
        txtIdHP.setText(tl_id_hp);
        txtUsername.setText(Html.fromHtml((new StringBuilder("<b>")).append(tl_username).append("</b>").append(" di ").append("<b>").append(tl_kota).append("</b>").toString()));
        txtImgMedia.setText(tl_img_url);
        txtType.setText(tl_type);
        txtTag.setText(tl_tag);
        txtForumHashTag.setVisibility(0);
        if (tl_id_hp.equals("0"))
        {
            if (tl_tag.equals("") || tl_tag.equals("0"))
            {
                txtForumHashTag.setText("");
            } else
            {
                txtForumHashTag.setText((new StringBuilder("#")).append(tl_tag.replace(",", "\n#")).toString());
            }
        } else
        {
            Log.e("tl_content_ext", tl_content_ext);
            if (tl_content_ext.equals(""))
            {
                if (tl_codename.equals("") || tl_codename.equals("0"))
                {
                    txtForumHashTag.setText("");
                } else
                {
                    txtForumHashTag.setText((new StringBuilder("#")).append(tl_codename).toString());
                }
            } else
            if (tl_type.equals("hasilkamera"))
            {
                txtForumHashTag.setText((new StringBuilder("#")).append(tl_codename).append("\n").append("#").append(tl_content_ext.replaceAll("\\s+", "").replace("-", "\n#")).toString());
            } else
            if (tl_type.equals("benchmark"))
            {
                txtForumHashTag.setText((new StringBuilder("#")).append(tl_codename).append("\n").append("#").append(tl_tag.replaceAll("\\s+", "")).toString());
            } else
            {
                txtForumHashTag.setText((new StringBuilder("#")).append(tl_codename).append("\n").append("#").append(tl_content_ext).toString());
            }
        }
        if (tl_type.equals("artikel"))
        {
            if (tl_tag.equals("apps"))
            {
                imageArtikelType.setImageResource(0x7f0202cc);
            } else
            if (tl_tag.equals("games"))
            {
                imageArtikelType.setImageResource(0x7f0202d1);
            } else
            if (tl_tag.equals("umum"))
            {
                imageArtikelType.setImageResource(0x7f0202cf);
            } else
            if (tl_tag.equals("hack"))
            {
                imageArtikelType.setImageResource(0x7f0202d2);
            } else
            if (tl_tag.equals("tips"))
            {
                imageArtikelType.setImageResource(0x7f0202da);
            } else
            if (tl_tag.equals("aksesoris"))
            {
                imageArtikelType.setImageResource(0x7f0202cf);
            } else
            if (tl_tag.equals("osfirm"))
            {
                imageArtikelType.setImageResource(0x7f0202ca);
            } else
            {
                imageArtikelType.setImageResource(0x7f020297);
            }
        } else
        if (tl_type.equals("faqhp"))
        {
            imageArtikelType.setImageResource(0x7f0202d9);
        } else
        if (tl_type.equals("benchmark"))
        {
            imageArtikelType.setImageResource(0x7f0202cd);
        } else
        {
            imageArtikelType.setImageResource(0x7f0202d0);
        }
        txtContent.setText(Html.fromHtml(Utility.parseUrl(s)));
        txtContent.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
        if (txtContent.getText().toString().equals(""))
        {
            txtContent.setVisibility(8);
        } else
        {
            txtContent.setVisibility(0);
        }
        if (tl_type.equals("benchmark"))
        {
            txtContentExt.setText((new StringBuilder("Menggunakan aplikasi ")).append(tl_tag).toString());
            txtBenchSkor.setText(Html.fromHtml((new StringBuilder("<html><body>")).append(tl_content_ext).append("<br />").append("<small><small><font color=\"#aaaaaa\">").append(tl_tag).append("</font></small><small></html></body>").toString()));
            txtBenchSkor.setVisibility(0);
        } else
        if (tl_type.equals("hasilkamera"))
        {
            txtContentExt.setText(tl_content_ext);
        } else
        {
            txtContentExt.setVisibility(8);
            txtBenchSkor.setVisibility(8);
        }
        txtLikeKom.setText(total_like);
        txtTotalKom.setText(s1);
        if (like_stat.toString().equals("1"))
        {
            ((ImageView) (obj)).setBackgroundResource(0x7f020264);
            list_lay_like.setEnabled(false);
        } else
        if (like_stat.toString().equals("0"))
        {
            ((ImageView) (obj)).setBackgroundResource(0x7f020265);
            list_lay_like.setEnabled(true);
        } else
        {
            list_lay_like.setEnabled(true);
            list_lay_favorit.setEnabled(true);
            ((ImageView) (obj)).setBackgroundResource(0x7f020265);
            list_lay_like.setBackgroundResource(0x7f020079);
            list_lay_favorit.setBackgroundResource(0x7f020079);
        }
        if (fav_stat.toString().equals("1"))
        {
            ((ImageView) (obj1)).setBackgroundResource(0x7f020303);
        } else
        if (fav_stat.toString().equals("0"))
        {
            ((ImageView) (obj1)).setBackgroundResource(0x7f020302);
        } else
        {
            ((ImageView) (obj1)).setBackgroundResource(0x7f020302);
        }
        if (!((ItemTimelineHP)mArrayListData.get(j)).getTimeline_img_url().trim().equals("")) goto _L2; else goto _L1
_L1:
        rl_media.setVisibility(8);
        imageMedia.setVisibility(8);
        progressbar_imgcontent.setVisibility(8);
_L3:
        progressbar_imgcontent.setVisibility(8);
        Exception exception;
        int i1;
        int j1;
        if (((ItemTimelineHP)mArrayListData.get(j)).getTimeline_userphoto().trim().equals(""))
        {
            imageAvatar.setVisibility(0);
            imageAvatar.setImageResource(0x7f020297);
        } else
        {
            Picasso.with(this).load(((ItemTimelineHP)mArrayListData.get(j)).getTimeline_userphoto()).into(imageAvatar, new Callback() {

                final ForumGlobalActivity this$0;

                public void onError()
                {
                    progressbar_imgcontent.setVisibility(8);
                    imageMedia.setBackgroundResource(0x7f0201b8);
                }

                public void onSuccess()
                {
                    progressbar_imgcontent.setVisibility(8);
                }

            
            {
                this$0 = ForumGlobalActivity.this;
                super();
            }
            });
        }
        Log.e("tl_date", tl_date);
        txtWaktu.setText(Utility.convertDate(tl_date));
        Log.e("new_loadResult", new_load);
        if (new_load.equals("1"))
        {
            list_timeline_hp.addView(view, 0);
        } else
        {
            list_timeline_hp.addView(view);
        }
        imageAvatar.setOnClickListener(new android.view.View.OnClickListener() {

            final ForumGlobalActivity this$0;
            private final String val$tl_username;

            public void onClick(View view1)
            {
                view1 = new Intent(ForumGlobalActivity.this, com/inponsel/android/v2/ProfileOtherUser);
                view1.putExtra("id_user_view", tl_username);
                startActivityForResult(view1, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = ForumGlobalActivity.this;
                tl_username = s;
                super();
            }
        });
        imageMedia.setOnClickListener(new android.view.View.OnClickListener() {

            final ForumGlobalActivity this$0;
            private final String val$tl_img_url;

            public void onClick(View view1)
            {
                view1 = new ArrayList();
                view1.add(tl_img_url);
                view1 = (String[])view1.toArray(new String[view1.size()]);
                Intent intent = new Intent(ForumGlobalActivity.this, com/inponsel/android/v2/ImagePagerActivity);
                intent.putExtra("imgUrl", view1);
                intent.putExtra("pos", 0);
                startActivity(intent);
            }

            
            {
                this$0 = ForumGlobalActivity.this;
                tl_img_url = s;
                super();
            }
        });
        list_lay_like.setOnClickListener(new android.view.View.OnClickListener() {

            final ForumGlobalActivity this$0;
            private final String val$tl_id;
            private final String val$tl_type;

            public void onClick(View view1)
            {
                if (userFunctions.isUserLoggedIn(ForumGlobalActivity.this))
                {
                    statuslike = "1";
                    idkom_pos = tl_id;
                    id_type = tl_type;
                    querylike = (new StringBuilder("status=")).append(statuslike).append("&tl_id=").append(idkom_pos).append("&id_usr=").append(ForumGlobalActivity.user_id).append("&type=").append(id_type).append("&t=").append(t).toString();
                    Log.e("querylike", querylike);
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
                    view1 = new android.app.AlertDialog.Builder(wrapperLight);
                    view1.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                    view1.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                        final _cls34 this$1;

                        public void onClick(DialogInterface dialoginterface, int j)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls34.this;
                super();
            }
                    });
                    view1.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls34 this$1;

                        public void onClick(DialogInterface dialoginterface, int j)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                            startActivity(dialoginterface);
                        }

            
            {
                this$1 = _cls34.this;
                super();
            }
                    });
                    view1.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls34 this$1;

                        public void onClick(DialogInterface dialoginterface, int j)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            startActivity(dialoginterface);
                        }

            
            {
                this$1 = _cls34.this;
                super();
            }
                    });
                    view1.show();
                    return;
                }
            }


            
            {
                this$0 = ForumGlobalActivity.this;
                tl_id = s;
                tl_type = s1;
                super();
            }
        });
        list_lay_flag.setOnClickListener(new android.view.View.OnClickListener() {

            final ForumGlobalActivity this$0;
            private final String val$tl_id;
            private final String val$tl_type;

            public void onClick(View view1)
            {
                idkom_pos = tl_id;
                id_type = tl_type;
                view1 = new android.app.AlertDialog.Builder(ForumGlobalActivity.this);
                view1.setMessage("Laporkan konten ini karena tidak sesuai atau mengandung SARA?");
                view1.setPositiveButton("Ya", tl_type. new android.content.DialogInterface.OnClickListener() {

                    final _cls35 this$1;
                    private final String val$tl_type;

                    public void onClick(DialogInterface dialoginterface, int j)
                    {
                        if (userFunctions.isUserLoggedIn(_fld0))
                        {
                            queryFlag = (new StringBuilder("id_artanya=")).append(idkom_pos).append("&id_usr=").append(ForumGlobalActivity.user_id).append("&type=").append(tl_type).append("&t=").append(t).toString();
                            Log.e("queryFlag", queryFlag);
                            if (android.os.Build.VERSION.SDK_INT >= 11)
                            {
                                (new PostFlagTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                                return;
                            } else
                            {
                                (new PostFlagTask()).execute(new Void[0]);
                                return;
                            }
                        } else
                        {
                            dialoginterface = new android.app.AlertDialog.Builder(_fld0);
                            dialoginterface.setMessage("Untuk memberi laporan harus login terlebih dahulu.");
                            dialoginterface.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                                final _cls1 this$2;

                                public void onClick(DialogInterface dialoginterface, int j)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = _cls1.this;
                super();
            }
                            });
                            dialoginterface.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                                final _cls1 this$2;

                                public void onClick(DialogInterface dialoginterface, int j)
                                {
                                    dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                                    startActivity(dialoginterface);
                                }

            
            {
                this$2 = _cls1.this;
                super();
            }
                            });
                            dialoginterface.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                                final _cls1 this$2;

                                public void onClick(DialogInterface dialoginterface, int j)
                                {
                                    dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                                    dialoginterface.putExtra("activity", "main");
                                    startActivity(dialoginterface);
                                }

            
            {
                this$2 = _cls1.this;
                super();
            }
                            });
                            dialoginterface.show();
                            return;
                        }
                    }


            
            {
                this$1 = final__pcls35;
                tl_type = String.this;
                super();
            }
                });
                view1.setNegativeButton("Batal", new android.content.DialogInterface.OnClickListener() {

                    final _cls35 this$1;

                    public void onClick(DialogInterface dialoginterface, int j)
                    {
                        dialoginterface.dismiss();
                    }

            
            {
                this$1 = _cls35.this;
                super();
            }
                });
                view1.show();
            }


            
            {
                this$0 = ForumGlobalActivity.this;
                tl_id = s;
                tl_type = s1;
                super();
            }
        });
        list_lay_favorit.setOnClickListener(new android.view.View.OnClickListener() {

            final ForumGlobalActivity this$0;
            private final String val$fav_stat;
            private final String val$tl_id;
            private final String val$tl_type;

            public void onClick(View view1)
            {
                idkom_pos = tl_id;
                id_type = tl_type;
                if (userFunctions.isUserLoggedIn(ForumGlobalActivity.this))
                {
                    if (db.checkTimelineExist(idkom_pos) || fav_stat.equals("1"))
                    {
                        view1 = new android.app.AlertDialog.Builder(ForumGlobalActivity.this);
                        if (tl_type.equals("faqhp"))
                        {
                            view1.setMessage("Hapus pertanyaan ini dari favorit?");
                        } else
                        {
                            view1.setMessage("Hapus artikel ini dari favorit?");
                        }
                        view1.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                            final _cls36 this$1;

                            public void onClick(DialogInterface dialoginterface, int j)
                            {
                                dialoginterface.dismiss();
                                stat = "0";
                                (new FavoritTask()).execute(new Void[0]);
                            }

            
            {
                this$1 = _cls36.this;
                super();
            }
                        });
                        view1.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                            final _cls36 this$1;

                            public void onClick(DialogInterface dialoginterface, int j)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$1 = _cls36.this;
                super();
            }
                        });
                        view1.show();
                        return;
                    }
                    view1 = new android.app.AlertDialog.Builder(ForumGlobalActivity.this);
                    if (tl_type.equals("faqhp"))
                    {
                        view1.setMessage("Favoritkan pertanyaan ini?");
                    } else
                    {
                        view1.setMessage("Favoritkan artikel ini?");
                    }
                    view1.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                        final _cls36 this$1;

                        public void onClick(DialogInterface dialoginterface, int j)
                        {
                            stat = "1";
                            (new FavoritTask()).execute(new Void[0]);
                        }

            
            {
                this$1 = _cls36.this;
                super();
            }
                    });
                    view1.setNeutralButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                        final _cls36 this$1;

                        public void onClick(DialogInterface dialoginterface, int j)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls36.this;
                super();
            }
                    });
                    view1.show();
                    return;
                } else
                {
                    view1 = new android.app.AlertDialog.Builder(wrapperLight);
                    view1.setMessage("Untuk menambahkan ke favorit harus login terlebih dahulu.");
                    view1.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                        final _cls36 this$1;

                        public void onClick(DialogInterface dialoginterface, int j)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls36.this;
                super();
            }
                    });
                    view1.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls36 this$1;

                        public void onClick(DialogInterface dialoginterface, int j)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                            startActivity(dialoginterface);
                        }

            
            {
                this$1 = _cls36.this;
                super();
            }
                    });
                    view1.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls36 this$1;

                        public void onClick(DialogInterface dialoginterface, int j)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            startActivity(dialoginterface);
                        }

            
            {
                this$1 = _cls36.this;
                super();
            }
                    });
                    view1.show();
                    return;
                }
            }


            
            {
                this$0 = ForumGlobalActivity.this;
                tl_id = s;
                tl_type = s1;
                fav_stat = s2;
                super();
            }
        });
        list_lay_kom.setOnClickListener(new android.view.View.OnClickListener() {

            final ForumGlobalActivity this$0;
            private final String val$fav_stat;
            private final String val$like_stat;
            private final String val$tl_codename;
            private final String val$tl_content;
            private final String val$tl_content_ext;
            private final String val$tl_date;
            private final String val$tl_id;
            private final String val$tl_id_hp;
            private final String val$tl_id_user;
            private final String val$tl_img_url;
            private final String val$tl_judul;
            private final String val$tl_tag;
            private final String val$tl_type;
            private final String val$tl_username;
            private final String val$tl_userphoto;
            private final String val$total_like;

            public void onClick(View view1)
            {
                idkom_pos = tl_id;
                view1 = new Intent(ForumGlobalActivity.this, com/inponsel/android/timelinedetail/TLKomenTab);
                view1.putExtra("id_artanya", idkom_pos);
                view1.putExtra("act", "komen");
                view1.putExtra("tl_judul", tl_judul);
                view1.putExtra("tl_content", tl_content);
                view1.putExtra("tl_content_ext", tl_content_ext);
                view1.putExtra("tl_codename", tl_codename);
                view1.putExtra("tl_date", tl_date);
                view1.putExtra("tl_id", tl_id);
                view1.putExtra("tl_id_hp", tl_id_hp);
                view1.putExtra("tl_id_user", tl_id_user);
                view1.putExtra("tl_img_url", tl_img_url);
                view1.putExtra("tl_tag", tl_tag);
                view1.putExtra("tl_type", tl_type);
                view1.putExtra("tl_username", tl_username);
                view1.putExtra("tl_userphoto", tl_userphoto);
                view1.putExtra("total_like", total_like);
                view1.putExtra("fav_stat", fav_stat);
                view1.putExtra("like_stat", like_stat);
                view1.putExtra("namalengkap", namalengkap);
                startActivityForResult(view1, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = ForumGlobalActivity.this;
                tl_id = s;
                tl_judul = s1;
                tl_content = s2;
                tl_content_ext = s3;
                tl_codename = s4;
                tl_date = s5;
                tl_id_hp = s6;
                tl_id_user = s7;
                tl_img_url = s8;
                tl_tag = s9;
                tl_type = s10;
                tl_username = s11;
                tl_userphoto = s12;
                total_like = s13;
                fav_stat = s14;
                like_stat = s15;
                super();
            }
        });
        view.setOnClickListener(new android.view.View.OnClickListener() {

            final ForumGlobalActivity this$0;
            private final String val$fav_stat;
            private final String val$like_stat;
            private final String val$tl_codename;
            private final String val$tl_content;
            private final String val$tl_content_ext;
            private final String val$tl_date;
            private final String val$tl_id;
            private final String val$tl_id_hp;
            private final String val$tl_id_user;
            private final String val$tl_img_url;
            private final String val$tl_judul;
            private final String val$tl_kota;
            private final String val$tl_tag;
            private final String val$tl_type;
            private final String val$tl_username;
            private final String val$tl_userphoto;
            private final String val$total_like;

            public void onClick(View view1)
            {
                idkom_pos = tl_id;
                view1 = new Intent(ForumGlobalActivity.this, com/inponsel/android/timelinedetail/Hal1TLDetailActivity);
                view1.putExtra("id_artanya", idkom_pos);
                view1.putExtra("act", "first");
                view1.putExtra("tl_judul", tl_judul);
                view1.putExtra("tl_content", tl_content);
                view1.putExtra("tl_content_ext", tl_content_ext);
                view1.putExtra("tl_codename", tl_codename);
                view1.putExtra("tl_date", tl_date);
                view1.putExtra("tl_id", tl_id);
                view1.putExtra("tl_id_hp", tl_id_hp);
                view1.putExtra("tl_id_user", tl_id_user);
                view1.putExtra("tl_img_url", tl_img_url);
                view1.putExtra("tl_tag", tl_tag);
                view1.putExtra("tl_type", tl_type);
                view1.putExtra("tl_username", tl_username);
                view1.putExtra("tl_kota", tl_kota);
                Log.e("tl_tags", tl_tag);
                view1.putExtra("tl_userphoto", tl_userphoto);
                view1.putExtra("total_like", total_like);
                view1.putExtra("fav_stat", fav_stat);
                view1.putExtra("like_stat", like_stat);
                view1.putExtra("namalengkap", namalengkap);
                view1.putExtra("resolution", resolution);
                startActivityForResult(view1, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = ForumGlobalActivity.this;
                tl_id = s;
                tl_judul = s1;
                tl_content = s2;
                tl_content_ext = s3;
                tl_codename = s4;
                tl_date = s5;
                tl_id_hp = s6;
                tl_id_user = s7;
                tl_img_url = s8;
                tl_tag = s9;
                tl_type = s10;
                tl_username = s11;
                tl_kota = s12;
                tl_userphoto = s13;
                total_like = s14;
                fav_stat = s15;
                like_stat = s16;
                super();
            }
        });
        j++;
        if (false)
        {
            break MISSING_BLOCK_LABEL_2313;
        } else
        {
            break MISSING_BLOCK_LABEL_37;
        }
_L2:
        progressbar_imgcontent.setVisibility(0);
        if (tl_type.contains("benchmark"))
        {
            Picasso.with(this).load((new StringBuilder(String.valueOf(Util.BASE_URL_THUMB_ORI))).append("w=").append(300).append("&src=").append(((ItemTimelineHP)mArrayListData.get(j)).getTimeline_img_url()).toString()).into(imageMedia, new Callback() {

                final ForumGlobalActivity this$0;

                public void onError()
                {
                    progressbar_imgcontent.setVisibility(8);
                    imageMedia.setBackgroundResource(0x7f0201b8);
                }

                public void onSuccess()
                {
                    progressbar_imgcontent.setVisibility(8);
                    imageMedia.setVisibility(0);
                }

            
            {
                this$0 = ForumGlobalActivity.this;
                super();
            }
            });
            progressbar_imgcontent.setVisibility(8);
        } else
        {
            obj = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(((DisplayMetrics) (obj)));
            i1 = ((DisplayMetrics) (obj)).widthPixels;
            j1 = ((DisplayMetrics) (obj)).heightPixels;
            Log.e("scrwh", (new StringBuilder(String.valueOf(String.valueOf(i1)))).append("x").append(String.valueOf(j1)).toString());
            Log.e("wh", (new StringBuilder(String.valueOf(String.valueOf(k)))).append("x").append(String.valueOf(l)).toString());
            if (l > i1 || l == k)
            {
                obj = new android.widget.RelativeLayout.LayoutParams(i1, i1);
                imageMedia.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
                progressbar_imgcontent.setVisibility(0);
                obj = (new StringBuilder(String.valueOf(Util.BASE_URL_THUMB2))).append(Utility.BASE_FORMAT).append("?w=").append(i1).append("&src=").append(((ItemTimelineHP)mArrayListData.get(j)).getTimeline_img_url()).toString();
                obj1 = ((ItemTimelineHP)mArrayListData.get(j)).getTimeline_img_compress();
                Log.e("img_url", ((String) (obj)));
                try
                {
                    Log.e("img_url_compress", ((String) (obj1)));
                    Picasso.with(this).load(((String) (obj1))).into(imageMedia, new Callback() {

                        final ForumGlobalActivity this$0;

                        public void onError()
                        {
                            progressbar_imgcontent.setVisibility(8);
                            imageMedia.setBackgroundResource(0x7f0201b8);
                        }

                        public void onSuccess()
                        {
                            progressbar_imgcontent.setVisibility(8);
                        }

            
            {
                this$0 = ForumGlobalActivity.this;
                super();
            }
                    });
                    progressbar_imgcontent.setVisibility(8);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception)
                {
                    exception.printStackTrace();
                }
            } else
            {
                exception = new android.widget.RelativeLayout.LayoutParams(-1, -2);
                imageMedia.setLayoutParams(exception);
                progressbar_imgcontent.setVisibility(0);
                Log.e("wh", (new StringBuilder(String.valueOf(String.valueOf(i1)))).append("x").append(String.valueOf(j1)).toString());
                exception = (new StringBuilder(String.valueOf(Util.BASE_URL_THUMB2))).append(Utility.BASE_FORMAT).append("?w=").append(i1).append("&src=").append(((ItemTimelineHP)mArrayListData.get(j)).getTimeline_img_url()).toString();
                obj1 = ((ItemTimelineHP)mArrayListData.get(j)).getTimeline_img_compress();
                Log.e("img_url", exception);
                try
                {
                    Log.e("img_url_compress", ((String) (obj1)));
                    Picasso.with(this).load(((String) (obj1))).into(imageMedia, new Callback() {

                        final ForumGlobalActivity this$0;

                        public void onError()
                        {
                            progressbar_imgcontent.setVisibility(8);
                            imageMedia.setBackgroundResource(0x7f0201b8);
                        }

                        public void onSuccess()
                        {
                            progressbar_imgcontent.setVisibility(8);
                        }

            
            {
                this$0 = ForumGlobalActivity.this;
                super();
            }
                    });
                    progressbar_imgcontent.setVisibility(8);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception)
                {
                    exception.printStackTrace();
                }
            }
        }
          goto _L3
    }

    public static int dpToPx(Context context, float f)
    {
        return (int)(f * context.getResources().getDisplayMetrics().density + 0.5F);
    }

    private void hideProgressDialog()
    {
        if (progressbar_TimelineHP.getVisibility() == 0)
        {
            progressbar_TimelineHP.setVisibility(8);
            txtbtnfooter.setVisibility(0);
            Log.e("tasksdsurlSearch", urlTimelineHPTag);
            if (mArrayListData.size() < 8)
            {
                txtbtnfooter.setVisibility(8);
            } else
            {
                txtbtnfooter.setVisibility(0);
            }
        }
        Log.e("counterparse", counter);
        if (counter.equals(""))
        {
            grup_footer.setVisibility(8);
            return;
        } else
        {
            grup_footer.setVisibility(0);
            return;
        }
    }

    private void hideProgressDialogBench()
    {
        if (layout_footerProgbenchmark.getVisibility() == 0)
        {
            progressbar_TimelineHP.setVisibility(8);
            layout_footerProgbenchmark.setVisibility(8);
            txtbtnfooterbenchmark.setVisibility(0);
            Log.e("tasksdsurlSearch", urlTimelineHPTag);
            if (BenchArrayList.size() < 8)
            {
                txtbtnfooterbenchmark.setVisibility(8);
            } else
            {
                txtbtnfooterbenchmark.setVisibility(0);
            }
        }
        Log.e("counterparse", counter);
        if (counter.equals(""))
        {
            grup_footerbenchmark.setVisibility(8);
            return;
        } else
        {
            grup_footerbenchmark.setVisibility(0);
            return;
        }
    }

    private void hideProgressDialogFoto()
    {
        if (layout_footerProgFoto.getVisibility() == 0)
        {
            progressbar_TimelineHP.setVisibility(8);
            layout_footerProgFoto.setVisibility(8);
            txtbtnfooterFoto.setVisibility(0);
            Log.e("tasksdsurlSearch", urlTimelineHPTag);
            if (fotoKameraArrayList.size() < 8)
            {
                txtbtnfooterFoto.setVisibility(8);
            } else
            {
                txtbtnfooterFoto.setVisibility(0);
            }
        }
        Log.e("counterparse", counter);
        if (counter.equals(""))
        {
            grup_footerFoto.setVisibility(8);
            return;
        } else
        {
            grup_footerFoto.setVisibility(0);
            return;
        }
    }

    private void hideProgressDialogOLD()
    {
        if (layout_footerProg.getVisibility() == 0)
        {
            layout_footerProg.setVisibility(8);
            txtbtnfooter.setVisibility(0);
            Log.e("tasksdsurlSearch", urlTimelineHPTagOld);
        }
        if (counter.equals(""))
        {
            grup_footer.setVisibility(8);
            return;
        } else
        {
            grup_footer.setVisibility(0);
            return;
        }
    }

    private void parseJSONAddFav(String s)
    {
        int j;
        try
        {
            s = new JSONObject(s);
            postStatusAddTL = s.getString("success");
            postMessageAddTL = s.getString("message");
            jArray = s.getJSONArray("InPonsel");
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
            ponselBaseApp.getObserver().setFav_stat_TL(stat);
            ponselBaseApp.getObserver().setIndexTL(idkom_pos);
            ponselBaseApp.getObserver().setUpdateType("favrtl");
            ponselBaseApp.getObserver().setStatus_like_ponsel("-");
            return;
        }
        j++;
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_44;
        }
    }

    private void setTranslucentStatus(boolean flag)
    {
        Window window = getWindow();
        android.view.WindowManager.LayoutParams layoutparams = window.getAttributes();
        if (flag)
        {
            layoutparams.flags = layoutparams.flags | 0x4000000;
        } else
        {
            layoutparams.flags = layoutparams.flags & 0xfbffffff;
        }
        window.setAttributes(layoutparams);
    }

    private void showProgressDialog()
    {
        if (progressbar_TimelineHP.getVisibility() != 0)
        {
            progressbar_TimelineHP.setVisibility(0);
            txtbtnfooter.setVisibility(8);
        }
        mArrayListData.clear();
        list_timeline_hp.removeAllViews();
        list_timeline_hp.removeAllViewsInLayout();
    }

    private void showProgressDialogBench()
    {
        if (progressbar_TimelineHP.getVisibility() != 0)
        {
            progressbar_TimelineHP.setVisibility(0);
            txtbtnfooterbenchmark.setVisibility(8);
        }
        mArrayListData.clear();
        list_timeline_hp.removeAllViews();
        list_timeline_hp.removeAllViewsInLayout();
    }

    private void showProgressDialogFoto()
    {
        if (progressbar_TimelineHP.getVisibility() != 0)
        {
            progressbar_TimelineHP.setVisibility(0);
            txtbtnfooterFoto.setVisibility(8);
        }
        mArrayListData.clear();
        list_timeline_hp.removeAllViews();
        list_timeline_hp.removeAllViewsInLayout();
    }

    private void showProgressDialogOLD()
    {
        if (layout_footerProg.getVisibility() != 0)
        {
            txtbtnfooter.setVisibility(8);
            layout_footerProg.setVisibility(0);
        }
        mArrayListData.clear();
    }

    public void PonselMerkTask()
    {
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

    public void TimelineNewTask()
    {
        new_load = "1";
        if (tag_timeline.equals("") || tag_timeline.equals("terbaru"))
        {
            urlTimelineHPTagLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("timeline_global_forum").append(Utility.BASE_FORMAT).append("?").append("codename=").append(codename).append("&id_user=").append(user_id).append("&top_id=").append(top_id).append("&t=").append(t).toString();
        } else
        if (tag_timeline.equals("terkomentari"))
        {
            urlTimelineHPTagLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("timeline_global_forum").append(Utility.BASE_FORMAT).append("?").append("codename=").append(codename).append("&id_user=").append(user_id).append("&top_id=").append(top_id).append("&sort=2").append("&t=").append(t).toString();
        } else
        if (tag_timeline.equals("terpopuler"))
        {
            urlTimelineHPTagLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("timeline_global_forum_hits").append(Utility.BASE_FORMAT).append("?").append("codename=").append(codename).append("&id_user=").append(user_id).append("&top_id=").append(top_id).append("&t=").append(t).toString();
        } else
        {
            urlTimelineHPTagLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("timeline_global_forum_tag").append(Utility.BASE_FORMAT).append("?").append("codename=").append(codename).append("&id_user=").append(user_id).append("&tag=").append(tag_timeline).append("&top_id=").append(top_id).append("&t=").append(t).toString();
        }
        Log.e("urlTimelineHPTagLast", urlTimelineHPTagLast);
        ArtikelTanyaNewTask();
    }

    public void TimelineOLDTask()
    {
        new_load = "0";
        mArrayListData.clear();
        if (tag_timeline.equals("") || tag_timeline.equals("terbaru"))
        {
            urlTimelineHPTagOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("timeline_global_forum").append(Utility.BASE_FORMAT).append("?").append("codename=").append(codename).append("&id_user=").append(user_id).append("&bottom_id=").append(bottom_id).append("&t=").append(t).toString();
        } else
        if (tag_timeline.equals("terkomentari"))
        {
            urlTimelineHPTagOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("timeline_global_forum").append(Utility.BASE_FORMAT).append("?").append("codename=").append(codename).append("&id_user=").append(user_id).append("&bottom_id=").append(bottom_id).append("&sort=2").append("&t=").append(t).toString();
        } else
        if (tag_timeline.equals("terpopuler"))
        {
            urlTimelineHPTagOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("timeline_global_forum_hits").append(Utility.BASE_FORMAT).append("?").append("codename=").append(codename).append("&id_user=").append(user_id).append("&bottom_id=").append(bottom_id).append("&t=").append(t).toString();
        } else
        {
            urlTimelineHPTagOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("timeline_global_forum_tag").append(Utility.BASE_FORMAT).append("?").append("codename=").append(codename).append("&id_user=").append(user_id).append("&tag=").append(tag_timeline).append("&bottom_id=").append(bottom_id).append("&t=").append(t).toString();
        }
        Log.e("urlTimelineHPTagOld", urlTimelineHPTagOld);
        ArtikelTanyaOLDTask();
    }

    public void TimelineTask()
    {
        img_empty.setVisibility(8);
        pop_txt_empty.setVisibility(8);
        mArrayListData.clear();
        first_get = "1";
        new_load = "0";
        btn_sort_benchmark.setVisibility(8);
        try
        {
            Tracker tracker = ((PonselBaseApp)getApplication()).getTracker(com.inponsel.android.adapter.PonselBaseApp.TrackerName.APP_TRACKER);
            tracker.setScreenName((new StringBuilder("Forum Global ")).append(tag_timeline).toString());
            tracker.send((new com.google.android.gms.analytics.HitBuilders.AppViewBuilder()).build());
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        pop_txt_empty.setVisibility(8);
        img_empty.setVisibility(8);
        grid_hasilfoto.setVisibility(8);
        ll_forumlistFoto.setVisibility(8);
        grid_benchmark.setVisibility(8);
        ll_forumlistbenchmark.setVisibility(8);
        ll_forumlist.setVisibility(0);
        if (tag_timeline.equals("") || tag_timeline.equals("terbaru"))
        {
            urlTimelineHPTag = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("timeline_global_forum").append(Utility.BASE_FORMAT).append("?").append("codename=").append(codename).append("&id_user=").append(user_id).append("&t=").append(t).toString();
        } else
        if (tag_timeline.equals("terkomentari"))
        {
            urlTimelineHPTag = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("timeline_global_forum").append(Utility.BASE_FORMAT).append("?").append("codename=").append(codename).append("&id_user=").append(user_id).append("&sort=2").append("&t=").append(t).toString();
        } else
        if (tag_timeline.equals("terpopuler"))
        {
            urlTimelineHPTag = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("timeline_global_forum_hits").append(Utility.BASE_FORMAT).append("?").append("codename=").append(codename).append("&id_user=").append(user_id).append("&t=").append(t).toString();
        } else
        {
            urlTimelineHPTag = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("timeline_global_forum_tag").append(Utility.BASE_FORMAT).append("?").append("codename=").append(codename).append("&id_user=").append(user_id).append("&tag=").append(tag_timeline).append("&t=").append(t).toString();
        }
        Log.e("urlTimelineHPTag", urlTimelineHPTag);
        ArtikelTanyaTask();
    }

    public void onActivityResult(int j, int k, Intent intent)
    {
        super.onActivityResult(j, k, intent);
        Log.e("onActivityResult", "RESULT_OK");
        if (k == -1)
        {
            Log.e("Refresh", "OK");
            mArrayListData.clear();
            intent = intent.getStringExtra("jsonKom");
            Log.e("onActivityResultAct", intent);
            json_response = intent;
            get_last = true;
            TimelineNewTask();
            return;
        } else
        {
            Log.e("Refresh", "false");
            return;
        }
    }

    public void onBackPressed()
    {
        finish();
        overridePendingTransition(0x7f040001, 0x7f040002);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300e0);
        wrapperLight = new ContextThemeWrapper(this, 0x103006e);
        grid_hasilfoto = (GridView)findViewById(0x7f0b06bd);
        grid_benchmark = (GridView)findViewById(0x7f0b06c4);
        ll_forumlist = (RelativeLayout)findViewById(0x7f0b06ba);
        ll_forumlistFoto = (RelativeLayout)findViewById(0x7f0b06bc);
        ll_forumlistbenchmark = (RelativeLayout)findViewById(0x7f0b06c3);
        btn_sort_benchmark = (Button)findViewById(0x7f0b06cb);
        scroll_artikel = (ViewGroup)findViewById(0x7f0b0685);
        topTextView = (TextView)findViewById(0x7f0b06ca);
        topTextView.setVisibility(8);
        fotoKameraArrayList = new ArrayList();
        mFotoKameraAdapter = new FotoKameraAdapter(this, 0x7f0300bd, fotoKameraArrayList);
        grid_hasilfoto.setAdapter(mFotoKameraAdapter);
        BenchArrayList = new ArrayList();
        mBenchAdapter = new BenchAdapter(this, 0x7f0300bd, BenchArrayList);
        grid_benchmark.setAdapter(mBenchAdapter);
        grid_benchmark.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final ForumGlobalActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int k, long l)
            {
                adapterview = new Intent(ForumGlobalActivity.this, com/inponsel/android/timelinedetail/Hal1TLDetailActivity);
                adapterview.putExtra("id_artanya", mBenchAdapter.getListModel(k).getForum_id());
                adapterview.putExtra("act", "first");
                adapterview.putExtra("tl_judul", mBenchAdapter.getListModel(k).getForum_judul());
                adapterview.putExtra("tl_content", mBenchAdapter.getListModel(k).getForum_content());
                adapterview.putExtra("tl_content_ext", mBenchAdapter.getListModel(k).getForum_content_ext());
                adapterview.putExtra("tl_codename", mBenchAdapter.getListModel(k).getCodename());
                adapterview.putExtra("tl_date", mBenchAdapter.getListModel(k).getForum_date());
                adapterview.putExtra("tl_id", mBenchAdapter.getListModel(k).getForum_id());
                adapterview.putExtra("tl_id_hp", mBenchAdapter.getListModel(k).getId_hp());
                adapterview.putExtra("tl_id_user", mBenchAdapter.getListModel(k).getId_user());
                adapterview.putExtra("tl_img_url", mBenchAdapter.getListModel(k).getForum_img());
                adapterview.putExtra("tl_tag", mBenchAdapter.getListModel(k).getForum_tag());
                adapterview.putExtra("tl_type", mBenchAdapter.getListModel(k).getForum_type());
                adapterview.putExtra("tl_username", mBenchAdapter.getListModel(k).getUsername());
                adapterview.putExtra("tl_kota", mBenchAdapter.getListModel(k).getKota());
                adapterview.putExtra("tl_userphoto", mBenchAdapter.getListModel(k).getAvatar());
                adapterview.putExtra("total_like", mBenchAdapter.getListModel(k).getForum_like());
                adapterview.putExtra("fav_stat", mBenchAdapter.getListModel(k).getForum_myfav());
                adapterview.putExtra("like_stat", mBenchAdapter.getListModel(k).getForum_mylike());
                adapterview.putExtra("namalengkap", (new StringBuilder(String.valueOf(mBenchAdapter.getListModel(k).getMerk()))).append(" ").append(mBenchAdapter.getListModel(k).getModel()).toString());
                adapterview.putExtra("resolution", resolution);
                startActivityForResult(adapterview, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = ForumGlobalActivity.this;
                super();
            }
        });
        grid_hasilfoto.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final ForumGlobalActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int k, long l)
            {
                adapterview = new Intent(ForumGlobalActivity.this, com/inponsel/android/timelinedetail/Hal1TLDetailActivity);
                adapterview.putExtra("id_artanya", mFotoKameraAdapter.getListModel(k).getForum_id());
                adapterview.putExtra("act", "first");
                adapterview.putExtra("tl_judul", mFotoKameraAdapter.getListModel(k).getForum_judul());
                adapterview.putExtra("tl_content", mFotoKameraAdapter.getListModel(k).getForum_content());
                adapterview.putExtra("tl_content_ext", mFotoKameraAdapter.getListModel(k).getForum_content_ext());
                adapterview.putExtra("tl_codename", mFotoKameraAdapter.getListModel(k).getCodename());
                adapterview.putExtra("tl_date", mFotoKameraAdapter.getListModel(k).getForum_date());
                adapterview.putExtra("tl_id", mFotoKameraAdapter.getListModel(k).getForum_id());
                adapterview.putExtra("tl_id_hp", mFotoKameraAdapter.getListModel(k).getId_hp());
                adapterview.putExtra("tl_id_user", mFotoKameraAdapter.getListModel(k).getId_user());
                adapterview.putExtra("tl_img_url", mFotoKameraAdapter.getListModel(k).getForum_img());
                adapterview.putExtra("tl_tag", mFotoKameraAdapter.getListModel(k).getForum_tag());
                adapterview.putExtra("tl_type", mFotoKameraAdapter.getListModel(k).getForum_type());
                adapterview.putExtra("tl_username", mFotoKameraAdapter.getListModel(k).getUsername());
                adapterview.putExtra("tl_kota", mFotoKameraAdapter.getListModel(k).getKota());
                adapterview.putExtra("tl_userphoto", mFotoKameraAdapter.getListModel(k).getAvatar());
                adapterview.putExtra("total_like", mFotoKameraAdapter.getListModel(k).getForum_like());
                adapterview.putExtra("fav_stat", mFotoKameraAdapter.getListModel(k).getForum_myfav());
                adapterview.putExtra("like_stat", mFotoKameraAdapter.getListModel(k).getForum_mylike());
                adapterview.putExtra("namalengkap", (new StringBuilder(String.valueOf(mFotoKameraAdapter.getListModel(k).getMerk()))).append(" ").append(mFotoKameraAdapter.getListModel(k).getModel()).toString());
                adapterview.putExtra("resolution", resolution);
                startActivityForResult(adapterview, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = ForumGlobalActivity.this;
                super();
            }
        });
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            setTranslucentStatus(true);
        }
        bundle = new SystemBarTintManager(this);
        bundle.setStatusBarTintEnabled(true);
        bundle.setStatusBarTintResource(0x7f080170);
        actionBar = getSupportActionBar();
        actionBar.setDisplayUseLogoEnabled(useLogo);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setBackgroundDrawable(getResources().getDrawable(0x7f0200e7));
        actionBar.setDisplayShowTitleEnabled(false);
        bundle = LayoutInflater.from(this).inflate(0x7f030018, null);
        Drawable drawable = getResources().getDrawable(0x7f0200ce);
        drawable.setColorFilter(-1, android.graphics.PorterDuff.Mode.SRC_ATOP);
        rl_actionbarforum = (RelativeLayout)bundle.findViewById(0x7f0b005c);
        txt_label_actionbar = (TextView)bundle.findViewById(0x7f0b005d);
        txt_sublabel_actionbar = (TextView)bundle.findViewById(0x7f0b005e);
        txt_label_actionbar.setSelected(true);
        img_label_actionbar = (ImageView)bundle.findViewById(0x7f0b005f);
        int j;
        if (android.os.Build.VERSION.SDK_INT < 16)
        {
            img_label_actionbar.setBackgroundDrawable(drawable);
            txt_sublabel_actionbar.setBackgroundDrawable(drawable);
        } else
        {
            img_label_actionbar.setBackground(drawable);
            txt_sublabel_actionbar.setBackground(drawable);
        }
        txt_label_actionbar.setText("Forum Global");
        txt_sublabel_actionbar.setText("Terbaru");
        actionBar.setCustomView(bundle);
        actionBar.setDisplayShowCustomEnabled(true);
        t = Utility.session(t);
        t = Utility.session(t);
        extras = getIntent().getExtras();
        notificationLikeHelper = new NotificationLikeRSSHelper(this);
        ponselBaseApp = (PonselBaseApp)getApplication();
        ponselBaseApp.getObserver().addObserver(this);
        try
        {
            vSlidingMenu = new DobSlidingMenu(this);
            vSlidingMenu.setSlidingType(com.dobmob.dobsliding.models.SlidingItem.SlidingType.MOVE);
            vSlidingMenu.setSlidingView(0x7f0300ad);
            vSlidingMenu.setUseHandle(false);
            vSlidingMenu.setMaxDuration(500);
            vSlidingMenu.setOnCollapsedListener(new OnCollapsedListener() {

                final ForumGlobalActivity this$0;

                public void onCollapsed()
                {
                    Log.i(TAG, "onCollapsed");
                    isExpand = false;
                }

            
            {
                this$0 = ForumGlobalActivity.this;
                super();
            }
            });
            vSlidingMenu.setOnExpandedListener(new OnExpandedListener() {

                final ForumGlobalActivity this$0;

                public void onExpanded()
                {
                    Log.i(TAG, "onExpanded");
                    isExpand = true;
                }

            
            {
                this$0 = ForumGlobalActivity.this;
                super();
            }
            });
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        rl_actionbarforum.setOnClickListener(new android.view.View.OnClickListener() {

            final ForumGlobalActivity this$0;

            public void onClick(View view)
            {
                if (isExpand)
                {
                    vSlidingMenu.collapse();
                    return;
                } else
                {
                    vSlidingMenu.expand();
                    return;
                }
            }

            
            {
                this$0 = ForumGlobalActivity.this;
                super();
            }
        });
        userFunctions = new UserFunctions();
        db = new DatabaseHandler(this);
        slidingView = vSlidingMenu.getSlidingView();
        ll_head_1 = (LinearLayout)slidingView.findViewById(0x7f0b05bc);
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            ll_head_1.setVisibility(0);
        } else
        {
            ll_head_1.setVisibility(8);
        }
        btnAddArtikel = (FloatingActionButton)findViewById(0x7f0b068b);
        j = getResources().getColor(0x7f08016e);
        btnAddArtikel.setColor(j);
        scroll_artikel.setOnTouchListener(new ShowHideOnScroll(btnAddArtikel));
        progressbar_TimelineHP = (ProgressBar)findViewById(0x7f0b068a);
        mArrayListData = new ArrayList();
        list_timeline_hp = (LinearLayout)findViewById(0x7f0b0686);
        txtbtnfooter = (TextView)findViewById(0x7f0b04d9);
        grup_footer = (LinearLayout)findViewById(0x7f0b00be);
        layout_footerProg = (LinearLayout)findViewById(0x7f0b0688);
        txtbtnfooterFoto = (TextView)findViewById(0x7f0b06bf);
        grup_footerFoto = (LinearLayout)findViewById(0x7f0b06be);
        layout_footerProgFoto = (LinearLayout)findViewById(0x7f0b06c0);
        txtbtnfooterbenchmark = (TextView)findViewById(0x7f0b06c6);
        grup_footerbenchmark = (LinearLayout)findViewById(0x7f0b06c5);
        layout_footerProgbenchmark = (LinearLayout)findViewById(0x7f0b06c7);
        pop_txt_empty = (TextView)findViewById(0x7f0b04cf);
        img_empty = (ImageView)findViewById(0x7f0b06b7);
        menu_progressbar_item = (ProgressBar)findViewById(0x7f0b02a0);
        if (userFunctions.isUserLoggedIn(this))
        {
            cursor = db.getAllData();
            cursor.moveToFirst();
            try
            {
                user_id = EncodeDecodeAES.decrypt(RestClient.pelihara, cursor.getString(1));
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle) { }
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
            slidingView.findViewById(0x7f0b0406).setVisibility(0);
        } else
        {
            slidingView.findViewById(0x7f0b0406).setVisibility(8);
        }
        TimelineTask();
        txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

            final ForumGlobalActivity this$0;

            public void onClick(View view)
            {
                TimelineOLDTask();
            }

            
            {
                this$0 = ForumGlobalActivity.this;
                super();
            }
        });
        txtbtnfooterFoto.setOnClickListener(new android.view.View.OnClickListener() {

            final ForumGlobalActivity this$0;

            public void onClick(View view)
            {
                GetFotoList("previous");
            }

            
            {
                this$0 = ForumGlobalActivity.this;
                super();
            }
        });
        txtbtnfooterbenchmark.setOnClickListener(new android.view.View.OnClickListener() {

            final ForumGlobalActivity this$0;

            public void onClick(View view)
            {
                GetBenchList("previous");
            }

            
            {
                this$0 = ForumGlobalActivity.this;
                super();
            }
        });
        btnAddArtikel.setOnClickListener(new android.view.View.OnClickListener() {

            final ForumGlobalActivity this$0;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(getApplicationContext()))
                {
                    view = new Intent(ForumGlobalActivity.this, com/inponsel/android/globalforum/PostGlobalForum);
                    startActivityForResult(view, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                    return;
                } else
                {
                    view = new android.app.AlertDialog.Builder(wrapperLight);
                    view.setMessage("Untuk membuat artikel harus login terlebih dahulu.");
                    view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                        final _cls9 this$1;

                        public void onClick(DialogInterface dialoginterface, int j)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls9.this;
                super();
            }
                    });
                    view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls9 this$1;

                        public void onClick(DialogInterface dialoginterface, int j)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                            startActivity(dialoginterface);
                        }

            
            {
                this$1 = _cls9.this;
                super();
            }
                    });
                    view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls9 this$1;

                        public void onClick(DialogInterface dialoginterface, int j)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            startActivity(dialoginterface);
                        }

            
            {
                this$1 = _cls9.this;
                super();
            }
                    });
                    view.show();
                    return;
                }
            }


            
            {
                this$0 = ForumGlobalActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b0406).setOnClickListener(new android.view.View.OnClickListener() {

            final ForumGlobalActivity this$0;

            public void onClick(View view)
            {
                view = new Intent(ForumGlobalActivity.this, com/inponsel/android/v2/RoomMyDraftPost);
                view.putExtra("id_hph", id_hp);
                view.putExtra("namalengkap", namalengkap);
                view.putExtra("codename", codename);
                view.putExtra("model", model);
                view.putExtra("merk", merk);
                view.putExtra("gambar", gambar);
                view.putExtra("from", "apps");
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = ForumGlobalActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b03d3).setOnClickListener(new android.view.View.OnClickListener() {

            final ForumGlobalActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Terbaru");
                vSlidingMenu.collapse();
                tag_timeline = "terbaru";
                TimelineTask();
            }

            
            {
                this$0 = ForumGlobalActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b03d4).setOnClickListener(new android.view.View.OnClickListener() {

            final ForumGlobalActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Terpopuler");
                vSlidingMenu.collapse();
                tag_timeline = "terpopuler";
                TimelineTask();
            }

            
            {
                this$0 = ForumGlobalActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b03d5).setOnClickListener(new android.view.View.OnClickListener() {

            final ForumGlobalActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Terkomentari");
                vSlidingMenu.collapse();
                tag_timeline = "terkomentari";
                TimelineTask();
            }

            
            {
                this$0 = ForumGlobalActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b05bd).setOnClickListener(new android.view.View.OnClickListener() {

            final ForumGlobalActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Android");
                vSlidingMenu.collapse();
                tag_timeline = "android";
                TimelineTask();
            }

            
            {
                this$0 = ForumGlobalActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b05c0).setOnClickListener(new android.view.View.OnClickListener() {

            final ForumGlobalActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Blackberry");
                vSlidingMenu.collapse();
                tag_timeline = "blackberry";
                TimelineTask();
            }

            
            {
                this$0 = ForumGlobalActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b05c3).setOnClickListener(new android.view.View.OnClickListener() {

            final ForumGlobalActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("IOS");
                vSlidingMenu.collapse();
                tag_timeline = "ios";
                TimelineTask();
            }

            
            {
                this$0 = ForumGlobalActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b05c6).setOnClickListener(new android.view.View.OnClickListener() {

            final ForumGlobalActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Windows Phone");
                vSlidingMenu.collapse();
                tag_timeline = "windowsphone";
                TimelineTask();
            }

            
            {
                this$0 = ForumGlobalActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b05c9).setOnClickListener(new android.view.View.OnClickListener() {

            final ForumGlobalActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Tips & Trik Umum");
                vSlidingMenu.collapse();
                tag_timeline = "tipsumum";
                TimelineTask();
            }

            
            {
                this$0 = ForumGlobalActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b05d5).setOnClickListener(new android.view.View.OnClickListener() {

            final ForumGlobalActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Opini");
                vSlidingMenu.collapse();
                tag_timeline = "opini";
                TimelineTask();
            }

            
            {
                this$0 = ForumGlobalActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b05cc).setOnClickListener(new android.view.View.OnClickListener() {

            final ForumGlobalActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Pertanyaan Pengunjung");
                vSlidingMenu.collapse();
                tag_timeline = "tanya";
                TimelineTask();
            }

            
            {
                this$0 = ForumGlobalActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b05cf).setOnClickListener(new android.view.View.OnClickListener() {

            final ForumGlobalActivity this$0;

            public void onClick(View view)
            {
                img_empty.setVisibility(8);
                pop_txt_empty.setVisibility(8);
                txt_sublabel_actionbar.setText("Hasil Foto Kamera");
                vSlidingMenu.collapse();
                tag_timeline = "hasilkamera";
                ll_forumlist.setVisibility(8);
                grid_benchmark.setVisibility(8);
                ll_forumlistbenchmark.setVisibility(8);
                GetFotoList("now");
            }

            
            {
                this$0 = ForumGlobalActivity.this;
                super();
            }
        });
        btn_sort_benchmark.setOnClickListener(new android.view.View.OnClickListener() {

            final ForumGlobalActivity this$0;

            public void onClick(View view)
            {
                view = new android.app.AlertDialog.Builder(ForumGlobalActivity.this);
                view.setTitle("Urutkan benchmark :");
                view.setItems(benchmark_urutkan, new android.content.DialogInterface.OnClickListener() {

                    final _cls22 this$1;

                    public void onClick(DialogInterface dialoginterface, int j)
                    {
                        j;
                        JVM INSTR tableswitch 0 1: default 24
                    //                                   0 43
                    //                                   1 73;
                           goto _L1 _L2 _L3
_L1:
                        GetBenchList("now");
                        dialoginterface.dismiss();
                        return;
_L2:
                        btn_sort_benchmark.setText("Berdasarkan skor tertinggi");
                        str_urutkan_benchmark = "1";
                        continue; /* Loop/switch isn't completed */
_L3:
                        btn_sort_benchmark.setText("Berdasarkan skor terendah");
                        str_urutkan_benchmark = "2";
                        if (true) goto _L1; else goto _L4
_L4:
                    }

            
            {
                this$1 = _cls22.this;
                super();
            }
                });
                view.show();
            }


            
            {
                this$0 = ForumGlobalActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b05d2).setOnClickListener(new android.view.View.OnClickListener() {

            final ForumGlobalActivity this$0;

            public void onClick(View view)
            {
                img_empty.setVisibility(8);
                pop_txt_empty.setVisibility(8);
                txt_sublabel_actionbar.setText("Benchmark");
                vSlidingMenu.collapse();
                tag_timeline = "benchmark";
                ll_forumlist.setVisibility(8);
                grid_hasilfoto.setVisibility(8);
                ll_forumlistFoto.setVisibility(8);
                GetBenchList("now");
            }

            
            {
                this$0 = ForumGlobalActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b05d8).setOnClickListener(new android.view.View.OnClickListener() {

            final ForumGlobalActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Kategori Lain");
                vSlidingMenu.collapse();
                tag_timeline = "katlain";
                TimelineTask();
            }

            
            {
                this$0 = ForumGlobalActivity.this;
                super();
            }
        });
        listHpForum = (GridView)findViewById(0x7f0b05dc);
        ponselMerekArray = new ArrayList();
        ponselOsAdapter = new ListPendatangAdapter(this, 0x7f030119, ponselMerekArray);
        listHpForum.setAdapter(ponselOsAdapter);
        listHpForum.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final ForumGlobalActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int k, long l)
            {
                adapterview = ponselOsAdapter.getListModel(k).getId_hp();
                view = ponselOsAdapter.getListModel(k).getMerk();
                String s = ponselOsAdapter.getListModel(k).getModel();
                String s1 = ponselOsAdapter.getListModel(k).getCodename();
                String s2 = ponselOsAdapter.getListModel(k).getGambar();
                Intent intent = new Intent(ForumGlobalActivity.this, com/inponsel/android/tlforum/ForumHPActivity);
                intent.putExtra("id_hph", adapterview);
                intent.putExtra("namalengkap", (new StringBuilder(String.valueOf(view))).append(" ").append(s).toString());
                intent.putExtra("codename", s1);
                intent.putExtra("model", s);
                intent.putExtra("merk", view);
                intent.putExtra("gambar", s2);
                startActivityForResult(intent, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = ForumGlobalActivity.this;
                super();
            }
        });
        cm = (ConnectivityManager)getSystemService("connectivity");
        if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected())
        {
            dataPonsel = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("user_forum_hp").append(Utility.BASE_FORMAT).append("?t=").append(t).append("&id_user=").append(user_id).toString();
            Log.e("data", dataPonsel);
            PonselMerkTask();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getSupportMenuInflater().inflate(0x7f0f0000, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return true;

        case 16908332: 
            finish();
            overridePendingTransition(0x7f040001, 0x7f040002);
            return true;

        case 2131429681: 
            startActivity(new Intent(getApplicationContext(), com/inponsel/android/globalforum/ForumInteraksiActivity));
            return true;

        case 2131429682: 
            startActivity(new Intent(getApplicationContext(), com/inponsel/android/pencariangen/TabPencarian));
            break;
        }
        return true;
    }

    void parseJSON(String s)
    {
        Log.e("RSSAsycTask", "doInBackground");
        JSONObject jsonobject = new JSONObject(s);
        s = jsonobject.getJSONArray("InPonsel");
        bottom_id = jsonobject.getString("bottom_id");
        top_id = jsonobject.getString("top_id");
        succesStat = jsonobject.getString("success");
        counter = jsonobject.getString("top_id");
        resolution = jsonobject.getString("resolution");
        Log.e("counter", counter);
        Log.e("bottom_id", bottom_id);
        Log.e("top_id", top_id);
        Log.e("succesStat", succesStat);
        countKomOld = 0;
        if (!succesStat.equals("1"))
        {
            break MISSING_BLOCK_LABEL_421;
        }
        int j = 0;
_L2:
        if (j >= s.length())
        {
            return;
        }
        countAllKom = countAllKom + 1;
        countKomOld = countKomOld + 1;
        JSONObject jsonobject1 = s.getJSONObject(j);
        Log.e("id", jsonobject1.getString("id"));
        mArrayListData.add(new ItemTimelineHP(jsonobject1.getString("id"), jsonobject1.getString("id_hp"), jsonobject1.getString("codename"), jsonobject1.getString("id_user"), jsonobject1.getString("judul"), jsonobject1.getString("short_content"), jsonobject1.getString("content"), jsonobject1.getString("content_ext"), jsonobject1.getString("img_url"), jsonobject1.getInt("width"), jsonobject1.getInt("height"), jsonobject1.getString("img_compress"), jsonobject1.getString("tag"), jsonobject1.getString("user_name"), jsonobject1.getString("user_kota"), jsonobject1.getString("user_photo"), jsonobject1.getString("type"), jsonobject1.getString("date"), jsonobject1.getJSONObject("likedislike").getString("total_like"), jsonobject1.getJSONObject("likedislike").getString("total_komen"), jsonobject1.getJSONObject("likedislike").getString("total_hits"), jsonobject1.getJSONObject("likedislike").getString("my_like_tl"), jsonobject1.getJSONObject("likedislike").getString("my_fav_tl")));
        j++;
        if (true) goto _L2; else goto _L1
_L1:
        s;
        s.printStackTrace();
        strKonekStat = "0";
        succesStat = "0";
    }

    void parseJSONFoto(String s)
    {
        JSONObject jsonobject = new JSONObject(s);
        s = jsonobject.getJSONArray("InPonsel");
        bottom_id = jsonobject.getString("bottom_id");
        top_id = jsonobject.getString("top_id");
        if (jsonobject.getString("success").equals("0"))
        {
            break MISSING_BLOCK_LABEL_426;
        }
        counterFoto = s.length();
        int j = 0;
_L2:
        if (j >= s.length())
        {
            return;
        }
        JSONObject jsonobject1 = s.getJSONObject(j);
        ListModel listmodel = new ListModel();
        listmodel.setForum_id(jsonobject1.getString("id"));
        listmodel.setId_hp(jsonobject1.getString("id_hp"));
        listmodel.setCodename(jsonobject1.getString("codename"));
        listmodel.setMerk(jsonobject1.getString("merk"));
        listmodel.setModel(jsonobject1.getString("model"));
        listmodel.setId_user(jsonobject1.getString("id_user"));
        listmodel.setUsername(jsonobject1.getString("user_name"));
        listmodel.setKota(jsonobject1.getString("user_kota"));
        listmodel.setImg_height(jsonobject1.getString("height"));
        listmodel.setImg_width(jsonobject1.getString("width"));
        listmodel.setForum_short_content(jsonobject1.getString("short_content"));
        listmodel.setForum_totkomen(jsonobject1.getJSONObject("likedislike").getString("total_komen"));
        listmodel.setForum_tothits(jsonobject1.getJSONObject("likedislike").getString("total_hits"));
        listmodel.setAvatar(jsonobject1.getString("user_photo"));
        listmodel.setForum_content(jsonobject1.getString("content"));
        listmodel.setForum_date(jsonobject1.getString("date"));
        listmodel.setForum_img(jsonobject1.getString("img_url"));
        listmodel.setForum_img_compress(jsonobject1.getString("img_compress"));
        listmodel.setForum_judul(jsonobject1.getString("judul"));
        listmodel.setForum_type(jsonobject1.getString("type"));
        listmodel.setForum_content_ext(jsonobject1.getString("content_ext"));
        listmodel.setForum_like(jsonobject1.getJSONObject("likedislike").getString("total_like"));
        listmodel.setForum_myfav(jsonobject1.getJSONObject("likedislike").getString("my_fav_tl"));
        listmodel.setForum_mylike(jsonobject1.getJSONObject("likedislike").getString("my_like_tl"));
        listmodel.setForum_tag(jsonobject1.getString("tag"));
        fotoKameraArrayList.add(listmodel);
        j++;
        if (true) goto _L2; else goto _L1
_L1:
        s;
        s.printStackTrace();
        counter = "0";
    }

    void parseJSONNew(String s)
    {
        mArrayListData.clear();
        Log.e("mArrayListDataNew", String.valueOf(mArrayListData.size()));
        JSONObject jsonobject = new JSONObject(s);
        s = jsonobject.getJSONArray("InPonsel");
        resolution = jsonobject.getString("resolution");
        top_id = jsonobject.getString("top_id");
        succesStat = jsonobject.getString("success");
        counter = jsonobject.getString("top_id");
        Log.e("top_id", top_id);
        Log.e("counter", counter);
        countKomOld = 0;
        if (!succesStat.equals("1"))
        {
            break MISSING_BLOCK_LABEL_397;
        }
        int j = 0;
_L2:
        if (j >= s.length())
        {
            return;
        }
        countAllKom = countAllKom + 1;
        countKomOld = countKomOld + 1;
        JSONObject jsonobject1 = s.getJSONObject(j);
        Log.e("id", jsonobject1.getString("id"));
        mArrayListData.add(new ItemTimelineHP(jsonobject1.getString("id"), jsonobject1.getString("id_hp"), jsonobject1.getString("codename"), jsonobject1.getString("id_user"), jsonobject1.getString("judul"), jsonobject1.getString("short_content"), jsonobject1.getString("content"), jsonobject1.getString("content_ext"), jsonobject1.getString("img_url"), jsonobject1.getInt("width"), jsonobject1.getInt("height"), jsonobject1.getString("img_compress"), jsonobject1.getString("tag"), jsonobject1.getString("user_name"), jsonobject1.getString("user_kota"), jsonobject1.getString("user_photo"), jsonobject1.getString("type"), jsonobject1.getString("date"), jsonobject1.getJSONObject("likedislike").getString("total_like"), jsonobject1.getJSONObject("likedislike").getString("total_komen"), jsonobject1.getJSONObject("likedislike").getString("total_hits"), jsonobject1.getJSONObject("likedislike").getString("my_like_tl"), jsonobject1.getJSONObject("likedislike").getString("my_fav_tl")));
        j++;
        if (true) goto _L2; else goto _L1
_L1:
        s;
        s.printStackTrace();
        strKonekStat = "0";
    }

    void parseJSONOLD(String s)
    {
        Log.e("RSSAsycTask", "doInBackground");
        JSONObject jsonobject = new JSONObject(s);
        s = jsonobject.getJSONArray("InPonsel");
        bottom_id = jsonobject.getString("bottom_id");
        succesStat = jsonobject.getString("success");
        resolution = jsonobject.getString("resolution");
        counter = jsonobject.getString("count");
        Log.e("bottom_id", bottom_id);
        Log.e("top_id", top_id);
        Log.e("counter", counter);
        countKomOld = 0;
        if (!succesStat.equals("1"))
        {
            break MISSING_BLOCK_LABEL_393;
        }
        int j = 0;
_L2:
        if (j >= s.length())
        {
            return;
        }
        countAllKom = countAllKom + 1;
        countKomOld = countKomOld + 1;
        JSONObject jsonobject1 = s.getJSONObject(j);
        Log.e("id", jsonobject1.getString("id"));
        mArrayListData.add(new ItemTimelineHP(jsonobject1.getString("id"), jsonobject1.getString("id_hp"), jsonobject1.getString("codename"), jsonobject1.getString("id_user"), jsonobject1.getString("judul"), jsonobject1.getString("short_content"), jsonobject1.getString("content"), jsonobject1.getString("content_ext"), jsonobject1.getString("img_url"), jsonobject1.getInt("width"), jsonobject1.getInt("height"), jsonobject1.getString("img_compress"), jsonobject1.getString("tag"), jsonobject1.getString("user_name"), jsonobject1.getString("user_kota"), jsonobject1.getString("user_photo"), jsonobject1.getString("type"), jsonobject1.getString("date"), jsonobject1.getJSONObject("likedislike").getString("total_like"), jsonobject1.getJSONObject("likedislike").getString("total_komen"), jsonobject1.getJSONObject("likedislike").getString("total_hits"), jsonobject1.getJSONObject("likedislike").getString("my_like_tl"), jsonobject1.getJSONObject("likedislike").getString("my_fav_tl")));
        j++;
        if (true) goto _L2; else goto _L1
_L1:
        s;
        s.printStackTrace();
        strKonekStat = "0";
    }

    public void update(Observable observable, Object obj)
    {
        int j;
        if (!ponselBaseApp.getObserver().getUpdateType().equals("liketl"))
        {
            break MISSING_BLOCK_LABEL_228;
        }
        Log.e("id_rssup", ponselBaseApp.getObserver().getIndexTL());
        Log.e("mLinearListView", String.valueOf(list_timeline_hp.getChildCount()));
        j = 0;
_L3:
        if (j < list_timeline_hp.getChildCount()) goto _L2; else goto _L1
_L1:
        if (ponselBaseApp.getObserver().getLoginStat().equals("1"))
        {
            runOnUiThread(new Runnable() {

                final ForumGlobalActivity this$0;

                public void run()
                {
                    Log.e("updateObserverLogin", "MainActivity");
                    if (userFunctions.isUserLoggedIn(getApplicationContext()))
                    {
                        cursor = db.getAllData();
                        cursor.moveToFirst();
                        try
                        {
                            ForumGlobalActivity.user_id = EncodeDecodeAES.decrypt(RestClient.pelihara, cursor.getString(1));
                        }
                        catch (Exception exception) { }
                        ForumGlobalActivity.nama_asli = cursor.getString(2);
                        ForumGlobalActivity.user_photo = (new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(cursor.getString(3)).toString();
                        ForumGlobalActivity.username = cursor.getString(4);
                        ForumGlobalActivity.email_user = cursor.getString(5);
                        ForumGlobalActivity.user_ttl = cursor.getString(6);
                        ForumGlobalActivity.user_provinsi = cursor.getString(7);
                        ForumGlobalActivity.user_kota = cursor.getString(8);
                        ForumGlobalActivity.user_kecamatan = cursor.getString(cursor.getColumnIndex("user_kecamatan"));
                        ForumGlobalActivity.user_jekel = cursor.getString(9);
                        ForumGlobalActivity.user_ponsel1 = cursor.getString(10);
                        ForumGlobalActivity.user_ponsel2 = cursor.getString(11);
                        ForumGlobalActivity.user_provider1 = cursor.getString(12);
                        ForumGlobalActivity.user_provider2 = cursor.getString(13);
                        ForumGlobalActivity.user_joindate = cursor.getString(14);
                        ForumGlobalActivity.user_profile_update = cursor.getString(15);
                    }
                }

            
            {
                this$0 = ForumGlobalActivity.this;
                super();
            }
            });
        }
        return;
_L2:
        Object obj1 = list_timeline_hp.getChildAt(j);
        observable = (TextView)((View) (obj1)).findViewById(0x7f0b054d);
        obj = (TextView)((View) (obj1)).findViewById(0x7f0b0551);
        TextView textview = (TextView)((View) (obj1)).findViewById(0x7f0b034a);
        obj1 = (ImageView)((View) (obj1)).findViewById(0x7f0b054f);
        if (observable.getText().toString().equals(ponselBaseApp.getObserver().getIndexTL()))
        {
            ((TextView) (obj)).setText(ponselBaseApp.getObserver().getTot_LikeTL());
            textview.setText(ponselBaseApp.getObserver().getJum_komenLikeTL());
            ((ImageView) (obj1)).setBackgroundResource(0x7f020264);
        }
        j++;
          goto _L3
        if (ponselBaseApp.getObserver().getUpdateType().equals("favtl"))
        {
            int k = 0;
            while (k < list_timeline_hp.getChildCount()) 
            {
                obj = list_timeline_hp.getChildAt(k);
                observable = (ImageView)((View) (obj)).findViewById(0x7f0b05f1);
                obj = (TextView)((View) (obj)).findViewById(0x7f0b054d);
                Log.e("tlidmatch", (new StringBuilder(String.valueOf(ponselBaseApp.getObserver().getIndexTL()))).append("=").append(((TextView) (obj)).getText().toString()).toString());
                if (((TextView) (obj)).getText().toString().equals(ponselBaseApp.getObserver().getIndexTL()))
                {
                    if (ponselBaseApp.getObserver().getFav_stat_TL().toString().equals("1"))
                    {
                        observable.setBackgroundResource(0x7f020303);
                    } else
                    {
                        observable.setBackgroundResource(0x7f020302);
                    }
                }
                k++;
            }
        } else
        if (ponselBaseApp.getObserver().getUpdateType().equals("komentartl"))
        {
            int l = 0;
            while (l < list_timeline_hp.getChildCount()) 
            {
                obj = list_timeline_hp.getChildAt(l);
                observable = (TextView)((View) (obj)).findViewById(0x7f0b054d);
                obj = (TextView)((View) (obj)).findViewById(0x7f0b034a);
                Log.e("komentartl", (new StringBuilder(String.valueOf(ponselBaseApp.getObserver().getIndexTL()))).append("=").append(observable.getText().toString()).toString());
                if (observable.getText().toString().equals(ponselBaseApp.getObserver().getIndexTL()))
                {
                    ((TextView) (obj)).setText(ponselBaseApp.getObserver().getJum_komenLikeTL());
                }
                l++;
            }
        } else
        {
            ponselBaseApp.getObserver().getUpdateType().equals("refreshtimeline");
        }
          goto _L1
    }

    public void updateViewLikeDis(String s)
    {
        int j;
        Log.e("id_kom", s);
        Log.e("list_timeline_hp", String.valueOf(list_timeline_hp.getChildCount()));
        j = 0;
_L2:
        ImageView imageview;
        Object obj;
        int k;
        if (j >= list_timeline_hp.getChildCount())
        {
            return;
        }
        obj = list_timeline_hp.getChildAt(j);
        TextView textview = (TextView)((View) (obj)).findViewById(0x7f0b054d);
        TextView textview1 = (TextView)((View) (obj)).findViewById(0x7f0b0551);
        imageview = (ImageView)((View) (obj)).findViewById(0x7f0b054f);
        obj = (RelativeLayout)((View) (obj)).findViewById(0x7f0b0342);
        Log.e("id_komsama", (new StringBuilder(String.valueOf(textview.getText().toString()))).append("=").append(s).toString());
        if (textview.getText().toString().equals(s))
        {
            Log.e("statuslikeUpd", statuslike);
            k = Integer.parseInt(statuslike);
            textview1.setText(tot_LikeTL);
            if (k != 1)
            {
                break; /* Loop/switch isn't completed */
            }
            Log.e("int_like_status", statuslike);
            imageview.setBackgroundResource(0x7f02025b);
            ((RelativeLayout) (obj)).setEnabled(false);
        }
_L3:
        j++;
        if (true) goto _L2; else goto _L1
_L1:
        if (k == 0)
        {
            imageview.setBackgroundResource(0x7f020265);
            ((RelativeLayout) (obj)).setEnabled(true);
        } else
        {
            ((RelativeLayout) (obj)).setEnabled(true);
            imageview.setBackgroundResource(0x7f0201e7);
        }
          goto _L3
        if (true) goto _L2; else goto _L4
_L4:
    }

    public void updateViewTLFav(String s, String s1, String s2)
    {
        int j;
        Log.e("id_kom", s);
        Log.e("resstat", s1);
        Log.e("list_timeline_hp", String.valueOf(list_timeline_hp.getChildCount()));
        j = 0;
_L2:
        Object obj;
        if (j >= list_timeline_hp.getChildCount())
        {
            return;
        }
        obj = list_timeline_hp.getChildAt(j);
        s2 = (TextView)((View) (obj)).findViewById(0x7f0b054d);
        TextView textview = (TextView)((View) (obj)).findViewById(0x7f0b05e5);
        TextView textview1 = (TextView)((View) (obj)).findViewById(0x7f0b05ec);
        TextView textview2 = (TextView)((View) (obj)).findViewById(0x7f0b05ed);
        TextView textview3 = (TextView)((View) (obj)).findViewById(0x7f0b054c);
        TextView textview4 = (TextView)((View) (obj)).findViewById(0x7f0b05ea);
        TextView textview5 = (TextView)((View) (obj)).findViewById(0x7f0b05e6);
        TextView textview6 = (TextView)((View) (obj)).findViewById(0x7f0b05e7);
        TextView textview7 = (TextView)((View) (obj)).findViewById(0x7f0b05e8);
        obj = (ImageView)((View) (obj)).findViewById(0x7f0b05f1);
        if (s2.getText().toString().equals(s))
        {
            parseJSONAddFav(s1);
            if (!postStatusAddTL.equals("1") && !postStatusAddTL.equals("10"))
            {
                break; /* Loop/switch isn't completed */
            }
            if (textview4.equals(""))
            {
                db.addArtTanya(s2.getText().toString(), textview.getText().toString(), merk, model, textview5.getText().toString(), textview1.getText().toString(), textview6.getText().toString(), textview7.getText().toString(), "", textview2.getText().toString(), txtContentExt.getText().toString(), textview3.getText().toString());
            } else
            {
                db.addArtTanya(s2.getText().toString(), textview.getText().toString(), merk, model, codename, textview1.getText().toString(), textview6.getText().toString(), textview7.getText().toString(), textview4.getText().toString(), textview2.getText().toString(), txtContentExt.getText().toString(), textview3.getText().toString());
            }
            if (db.getTimelineCount() > 0)
            {
                Toast.makeText(this, postMessageAddTL, 1).show();
                ((ImageView) (obj)).setBackgroundResource(0x7f020303);
            } else
            {
                Toast.makeText(this, postMessageAddTL, 1).show();
                ((ImageView) (obj)).setBackgroundResource(0x7f020302);
            }
            mDialog.dismiss();
        }
_L3:
        j++;
        if (true) goto _L2; else goto _L1
_L1:
        if (postStatusAddTL.equals("00") || postStatusAddTL.equals("0"))
        {
            Toast.makeText(this, "Berhasil menghapus", 1).show();
            db.delete_TLbyID(s2.getText().toString());
            ((ImageView) (obj)).setBackgroundResource(0x7f020302);
            mDialog.dismiss();
        } else
        if (res.equals("40404"))
        {
            mDialog.dismiss();
        } else
        {
            Toast.makeText(this, postMessageAddTL, 1).show();
        }
          goto _L3
        if (true) goto _L2; else goto _L4
_L4:
    }











}
