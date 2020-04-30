// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.conversation;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
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
import android.widget.AbsListView;
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
import com.faizmalkani.floatingactionbutton.FloatingActionButton;
import com.google.android.gms.analytics.Tracker;
import com.inponsel.android.adapter.ItemTimelineHP;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.pencariangen.TabPencarian;
import com.inponsel.android.timelinedetail.TLKomenTab;
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

// Referenced classes of package com.inponsel.android.conversation:
//            ConversationInteraksiActivity, ConversationDetailActivity, ConversationPost

public class ConversationActivity extends SherlockFragmentActivity
    implements Observer, android.widget.AbsListView.OnScrollListener
{
    public class BenchAdapter extends BaseAdapter
    {

        private Activity activity;
        Context context;
        private ArrayList lm;
        int resource;
        String response;
        final ConversationActivity this$0;

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
            ListModel listmodel;
            if (view == null)
            {
                view = ((LayoutInflater)activity.getSystemService("layout_inflater")).inflate(resource, null);
                viewgroup = new ViewHolder();
                viewgroup.imgFoto = (ImageView)view.findViewById(0x7f0b0634);
                viewgroup.imgBench = (ImageView)view.findViewById(0x7f0b0636);
                viewgroup.txt_benchscrore = (TextView)view.findViewById(0x7f0b0637);
                viewgroup.txt_benchname = (TextView)view.findViewById(0x7f0b0638);
                viewgroup.txt_username = (TextView)view.findViewById(0x7f0b0373);
                viewgroup.txt_hp = (TextView)view.findViewById(0x7f0b0639);
                viewgroup.progressbar_Avatar = (ProgressBar)view.findViewById(0x7f0b0633);
                viewgroup.rl_benchscrore = (RelativeLayout)view.findViewById(0x7f0b0635);
                view.setTag(viewgroup);
            } else
            {
                viewgroup = (ViewHolder)view.getTag();
            }
            listmodel = (ListModel)lm.get(j);
            if (lm != null)
            {
                ((ViewHolder) (viewgroup)).rl_benchscrore.setVisibility(0);
                ((ViewHolder) (viewgroup)).txt_username.setText(listmodel.getUsername());
                ((ViewHolder) (viewgroup)).txt_benchname.setText(listmodel.getForum_tag());
                ((ViewHolder) (viewgroup)).txt_hp.setText((new StringBuilder(String.valueOf(listmodel.getMerk()))).append(" ").append(listmodel.getModel()).toString());
                ((ViewHolder) (viewgroup)).txt_benchscrore.setText(listmodel.getForum_content_ext());
                ((ViewHolder) (viewgroup)).imgFoto.setVisibility(0);
                try
                {
                    Picasso.with(activity).load(listmodel.getForum_img_compress().trim()).placeholder(0x7f02033f).error(0x7f020209).into(((ViewHolder) (viewgroup)).imgBench);
                }
                // Misplaced declaration of an exception variable
                catch (ViewGroup viewgroup)
                {
                    viewgroup.printStackTrace();
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

        public BenchAdapter(Activity activity1, int j, ArrayList arraylist)
        {
            this$0 = ConversationActivity.this;
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

        final ConversationActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            try
            {
                avoid = (new StringBuilder("idartanya=")).append(idkom_pos).append("&idusr=").append(ConversationActivity.user_id).append("&stat=").append(stat).append("&type=").append(id_type).append("&t=").append(t).toString();
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
                mDialog = ProgressDialog.show(ConversationActivity.this, "", "Menambahkan...", true);
            } else
            {
                mDialog = ProgressDialog.show(ConversationActivity.this, "", "Menghapus...", true);
            }
            mDialog.setCancelable(true);
            mDialog.show();
        }

        public FavoritTask()
        {
            this$0 = ConversationActivity.this;
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
        final ConversationActivity this$0;

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
            ListModel listmodel;
            if (view == null)
            {
                view = ((LayoutInflater)activity.getSystemService("layout_inflater")).inflate(resource, null);
                viewgroup = new ViewHolder();
                viewgroup.imgFoto = (ImageView)view.findViewById(0x7f0b0634);
                viewgroup.txt_username = (TextView)view.findViewById(0x7f0b0373);
                viewgroup.txt_username = (TextView)view.findViewById(0x7f0b0373);
                viewgroup.txt_hp = (TextView)view.findViewById(0x7f0b0639);
                viewgroup.progressbar_Avatar = (ProgressBar)view.findViewById(0x7f0b0633);
                view.setTag(viewgroup);
            } else
            {
                viewgroup = (ViewHolder)view.getTag();
            }
            listmodel = (ListModel)lm.get(j);
            if (lm != null)
            {
                ((ViewHolder) (viewgroup)).txt_username.setText(listmodel.getUsername());
                ((ViewHolder) (viewgroup)).txt_hp.setText((new StringBuilder(String.valueOf(listmodel.getMerk()))).append(" ").append(listmodel.getModel()).toString());
                ((ViewHolder) (viewgroup)).txt_username.setSelected(true);
                ((ViewHolder) (viewgroup)).txt_hp.setSelected(true);
                try
                {
                    Log.e("img_comp", listmodel.getForum_img_compress());
                    Picasso.with(activity).load(listmodel.getForum_img_compress().trim()).placeholder(0x7f02033f).error(0x7f020297).into(((ViewHolder) (viewgroup)).imgFoto);
                }
                // Misplaced declaration of an exception variable
                catch (ViewGroup viewgroup)
                {
                    viewgroup.printStackTrace();
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

        public FotoKameraAdapter(Activity activity1, int j, ArrayList arraylist)
        {
            this$0 = ConversationActivity.this;
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
        String indexhp;
        String komen;
        ListModel lms;
        PonselBaseApp ponselBaseApp;
        int pos;
        String res;
        int resource;
        String response;
        String statSubNews;
        String statusLikeHp;
        String t;
        final ConversationActivity this$0;
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
                    Picasso.with(activity).load((new StringBuilder(String.valueOf(Util.BASE_PATH_NEWIMAGE))).append(lms.getGambar().trim()).toString()).into(((ViewHolder) (viewgroup)).imageHp, viewgroup. new Callback() {

                        final ListPendatangAdapter this$1;
                        private final ListPendatangAdapter.ViewHolder val$holder;

                        public void onError()
                        {
                            holder.progressbar_item.setVisibility(8);
                        }

                        public void onSuccess()
                        {
                            holder.progressbar_item.setVisibility(8);
                            holder.imageHp.setVisibility(0);
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
            this$0 = ConversationActivity.this;
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
                userFunctions = new UserFunctions();
                db = new DatabaseHandler(activity1);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (ConversationActivity conversationactivity)
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

        final ConversationActivity this$0;

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
                    break MISSING_BLOCK_LABEL_284;
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
                        break MISSING_BLOCK_LABEL_291;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_291;
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_291;
                }
                j = 0;
            }
            if (j >= inponsel.length())
            {
                break MISSING_BLOCK_LABEL_291;
            }
            avoid = ConversationActivity.this;
            avoid.counterArray = ((ConversationActivity) (avoid)).counterArray + 1;
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
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
        }

        private PonselMerkTask()
        {
            this$0 = ConversationActivity.this;
            super();
        }

        PonselMerkTask(PonselMerkTask ponselmerktask)
        {
            this();
        }
    }

    public class PostBagusKurangTask extends AsyncTask
    {

        final ConversationActivity this$0;

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
                notificationLikeHelper.completed("Conversation", notificationLikeHelper.likefrontKomen);
            }
              goto _L5
            notificationLikeHelper.completed("Conversation", notificationLikeHelper.dislikefrontKomen);
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
                notificationLikeHelper.gagal("Conversation", postMessageLikeKom);
                return;
            }
            notificationLikeHelper.gagal("Conversation", postMessageLikeKom);
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
                notificationLikeHelper.createNotification("Conversation", notificationLikeHelper.likefrontKomen);
                return;
            } else
            {
                notificationLikeHelper.createNotification("Conversation", notificationLikeHelper.dislikefrontKomen);
                return;
            }
        }

        public PostBagusKurangTask()
        {
            this$0 = ConversationActivity.this;
            super();
        }
    }

    public class PostFlagTask extends AsyncTask
    {

        final ConversationActivity this$0;

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
            Toast.makeText(ConversationActivity.this, postMessageFlagKom, 1).show();
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            Toast.makeText(ConversationActivity.this, "Mengirim laporan...", 1).show();
        }

        public PostFlagTask()
        {
            this$0 = ConversationActivity.this;
            super();
        }
    }

    public class SendMailLikeForumTask extends AsyncTask
    {

        final ConversationActivity this$0;

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
            this$0 = ConversationActivity.this;
            super();
        }
    }

    public class SubsNewsTask extends AsyncTask
    {

        final ConversationActivity this$0;

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
                querySubs = (new StringBuilder("idhp=")).append(id_hp_del).append("&idusr=").append(ConversationActivity.user_id).append("&type=").append("all").append("&stat=").append("0").append("&t=").append(t).toString();
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
            dataPonsel = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("user_forum_hp").append(Utility.BASE_FORMAT).append("?t=").append(t).append("&id_user=").append(ConversationActivity.user_id).toString();
            Log.e("data", dataPonsel);
            if (postStatusSubsNews.equals("1") || postStatusSubsNews.equals("10"))
            {
                Toast.makeText(ConversationActivity.this, postMessageSubsNews, 1).show();
                mDialog.dismiss();
                return;
            }
            if (postStatusSubsNews.equals("00") || postStatusSubsNews.equals("0"))
            {
                Toast.makeText(ConversationActivity.this, postMessageSubsNews, 1).show();
                mDialog.dismiss();
                return;
            }
            if (postStatusSubsNews.equals("40404"))
            {
                mDialog.dismiss();
                return;
            } else
            {
                Toast.makeText(ConversationActivity.this, postMessageSubsNews, 1).show();
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            mDialog = ProgressDialog.show(ConversationActivity.this, "", "Menghapus...", true);
            mDialog.setCancelable(true);
            mDialog.show();
        }

        public SubsNewsTask()
        {
            this$0 = ConversationActivity.this;
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
    ActionBar actionBar;
    int actionBarTitleId;
    String bottom_id;
    RelativeLayout bottom_list;
    FloatingActionButton btnAddArtikel;
    Button btnRefresh;
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
    Typeface custom_font;
    String dataIDMerk;
    String dataPonsel;
    DatabaseHandler db;
    Bundle extras;
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
    RelativeLayout list_lay_favorit;
    RelativeLayout list_lay_flag;
    RelativeLayout list_lay_kom;
    RelativeLayout list_lay_like;
    LinearLayout list_timeline_hp;
    LinearLayout ll_TLTerbaru;
    LinearLayout ll_TLTerkomentari;
    LinearLayout ll_TLTerpopuler;
    LinearLayout ll_divider;
    RelativeLayout ll_forumlist;
    RelativeLayout ll_forumlistFoto;
    RelativeLayout ll_forumlistbenchmark;
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
    String stat;
    String statuslike;
    String strKonekStat;
    String str_srclink;
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
    TextView txtLabelConversation;
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
    ContextThemeWrapper wrapperLight;

    public ConversationActivity()
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
        titleMerek = "InPonsel";
        inponsel = null;
        suc = "";
        t = Utility.session(RestClient.pelihara);
        fotoKameraArrayList = null;
        BenchArrayList = null;
        json_response = "";
    }

    private void ArtikelTanyaNewTask()
    {
        Log.e("urlTimelineHPTagLast", urlTimelineHPTagLast);
        MyObjectRequest myobjectrequest = new MyObjectRequest(urlTimelineHPTagLast, new com.android.volley.Response.Listener() {

            final ConversationActivity this$0;

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
                this$0 = ConversationActivity.this;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final ConversationActivity this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
            }

            
            {
                this$0 = ConversationActivity.this;
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

            final ConversationActivity this$0;

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
                this$0 = ConversationActivity.this;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final ConversationActivity this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
                hideProgressDialogOLD();
            }

            
            {
                this$0 = ConversationActivity.this;
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

            final ConversationActivity this$0;

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
                this$0 = ConversationActivity.this;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final ConversationActivity this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
                btnRefresh.setVisibility(0);
                pop_txt_empty.setVisibility(0);
                pop_txt_empty.setText("Gagal memuat");
                hideProgressDialog();
            }

            
            {
                this$0 = ConversationActivity.this;
                super();
            }
        }, "test", "test");
        PonselBaseApp.getInstance().addToRequestQueue(myobjectrequest, "tag_json_obj");
    }

    private void GetBenchList(final String nextprev)
    {
        if (nextprev.equals("now"))
        {
            showProgressDialog();
            BenchArrayList.clear();
            urlFoto = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("timeline_global_forum_tag").append(Utility.BASE_FORMAT).append("?").append("codename=").append(codename).append("&id_user=").append(user_id).append("&tag=").append(tag_timeline).append("&t=").append(t).toString();
        } else
        {
            txtbtnfooterbenchmark.setVisibility(8);
            urlFoto = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("timeline_global_forum_tag").append(Utility.BASE_FORMAT).append("?").append("codename=").append(codename).append("&id_user=").append(user_id).append("&tag=").append(tag_timeline).append("&bottom_id=").append(bottom_id).append("&t=").append(t).toString();
        }
        Log.e("urlFoto", urlFoto);
        nextprev = new MyObjectRequest(urlFoto, new com.android.volley.Response.Listener() {

            final ConversationActivity this$0;
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
                    hideProgressDialog();
                }
            }

            
            {
                this$0 = ConversationActivity.this;
                nextprev = s;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final ConversationActivity this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
                hideProgressDialog();
            }

            
            {
                this$0 = ConversationActivity.this;
                super();
            }
        }, "test", "test");
        PonselBaseApp.getInstance().addToRequestQueue(nextprev, "Foto");
    }

    private void GetFotoList(final String nextprev)
    {
        if (nextprev.equals("now"))
        {
            showProgressDialog();
            fotoKameraArrayList.clear();
            urlFoto = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("timeline_global_forum_tag").append(Utility.BASE_FORMAT).append("?").append("codename=").append(codename).append("&id_user=").append(user_id).append("&tag=").append(tag_timeline).append("&t=").append(t).toString();
        } else
        {
            txtbtnfooterFoto.setVisibility(8);
            urlFoto = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("timeline_global_forum_tag").append(Utility.BASE_FORMAT).append("?").append("codename=").append(codename).append("&id_user=").append(user_id).append("&tag=").append(tag_timeline).append("&bottom_id=").append(bottom_id).append("&t=").append(t).toString();
        }
        Log.e("urlFoto", urlFoto);
        nextprev = new MyObjectRequest(urlFoto, new com.android.volley.Response.Listener() {

            final ConversationActivity this$0;
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
                if (nextprev.equals("now"))
                {
                    hideProgressDialog();
                }
            }

            
            {
                this$0 = ConversationActivity.this;
                nextprev = s;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final ConversationActivity this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
                hideProgressDialog();
            }

            
            {
                this$0 = ConversationActivity.this;
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
        String s;
        final String fav_stat;
        ImageView imageview;
        ImageView imageview1;
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
        view = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f0300b7, null);
        rl_media = (RelativeLayout)view.findViewById(0x7f0b05f7);
        progressbar_imgcontent = (ProgressBar)view.findViewById(0x7f0b05f4);
        txtUsername = (TextView)view.findViewById(0x7f0b0419);
        txtTitle = (TextView)view.findViewById(0x7f0b05ec);
        txtTitle.setTextColor(getResources().getColor(0x7f08017f));
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
        ll_divider = (LinearLayout)view.findViewById(0x7f0b05f6);
        ll_divider.setBackgroundColor(Color.parseColor("#DEDEDD"));
        imageview = (ImageView)view.findViewById(0x7f0b054f);
        imageview1 = (ImageView)view.findViewById(0x7f0b05f1);
        txtLikeKom = (TextView)view.findViewById(0x7f0b0551);
        txtdisLikeKom = (TextView)view.findViewById(0x7f0b0554);
        txtTotalKom = (TextView)view.findViewById(0x7f0b034a);
        bottom_list = (RelativeLayout)view.findViewById(0x7f0b0341);
        list_lay_like = (RelativeLayout)view.findViewById(0x7f0b0342);
        list_lay_flag = (RelativeLayout)view.findViewById(0x7f0b05ee);
        list_lay_favorit = (RelativeLayout)view.findViewById(0x7f0b05f0);
        list_lay_favorit.setVisibility(8);
        list_lay_kom = (RelativeLayout)view.findViewById(0x7f0b0348);
        tl_id = ((ItemTimelineHP)mArrayListData.get(j)).getTimeline_id();
        tl_id_hp = ((ItemTimelineHP)mArrayListData.get(j)).getTimeline_id_hp();
        tl_codename = ((ItemTimelineHP)mArrayListData.get(j)).getTimeline_codename();
        tl_id_user = ((ItemTimelineHP)mArrayListData.get(j)).getTimeline_id_user();
        tl_judul = ((ItemTimelineHP)mArrayListData.get(j)).getTimeline_title();
        tl_content = ((ItemTimelineHP)mArrayListData.get(j)).getTimeline_content();
        tl_content_ext = ((ItemTimelineHP)mArrayListData.get(j)).getTimeline_content_ext();
        s1 = ((ItemTimelineHP)mArrayListData.get(j)).getTimeline_short_content();
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
        s = ((ItemTimelineHP)mArrayListData.get(j)).getTimeline_tot_komen();
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
            catch (Exception exception3) { }
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
        txtContent.setText(Html.fromHtml(Utility.parseUrl(s1)));
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
            txtBenchSkor.setText(tl_content_ext);
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
        if (like_stat.toString().equals("1"))
        {
            imageview.setBackgroundResource(0x7f020264);
            list_lay_like.setEnabled(false);
        } else
        if (like_stat.toString().equals("0"))
        {
            imageview.setBackgroundResource(0x7f020265);
            list_lay_like.setEnabled(true);
        } else
        {
            list_lay_like.setEnabled(true);
            list_lay_favorit.setEnabled(true);
            imageview.setBackgroundResource(0x7f020265);
            list_lay_like.setBackgroundResource(0x7f020079);
            list_lay_favorit.setBackgroundResource(0x7f020079);
        }
        if (fav_stat.toString().equals("1"))
        {
            imageview1.setBackgroundResource(0x7f020303);
        } else
        if (fav_stat.toString().equals("0"))
        {
            imageview1.setBackgroundResource(0x7f020302);
        } else
        {
            imageview1.setBackgroundResource(0x7f020302);
        }
        if (((ItemTimelineHP)mArrayListData.get(j)).getTimeline_img_url().trim().equals(""))
        {
            rl_media.setVisibility(8);
            imageMedia.setVisibility(8);
            progressbar_imgcontent.setVisibility(8);
        } else
        {
            rl_media.setVisibility(0);
            DisplayMetrics displaymetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
            int i1 = displaymetrics.widthPixels;
            int j1 = displaymetrics.heightPixels;
            Log.e("scrwh", (new StringBuilder(String.valueOf(String.valueOf(i1)))).append("x").append(String.valueOf(j1)).toString());
            Log.e("wh", (new StringBuilder(String.valueOf(String.valueOf(k)))).append("x").append(String.valueOf(l)).toString());
            if (l > i1 || l == k)
            {
                android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(i1, i1);
                imageMedia.setLayoutParams(layoutparams);
                progressbar_imgcontent.setVisibility(0);
                try
                {
                    Picasso.with(this).load((new StringBuilder(String.valueOf(Util.BASE_URL_THUMB_ORI))).append("w=").append(i1).append("&src=").append(((ItemTimelineHP)mArrayListData.get(j)).getTimeline_img_url()).toString()).into(imageMedia, new Callback() {

                        final ConversationActivity this$0;

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
                this$0 = ConversationActivity.this;
                super();
            }
                    });
                    progressbar_imgcontent.setVisibility(8);
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                }
            } else
            {
                android.widget.RelativeLayout.LayoutParams layoutparams1 = new android.widget.RelativeLayout.LayoutParams(-1, -2);
                imageMedia.setLayoutParams(layoutparams1);
                progressbar_imgcontent.setVisibility(0);
                Log.e("wh", (new StringBuilder(String.valueOf(String.valueOf(i1)))).append("x").append(String.valueOf(j1)).toString());
                try
                {
                    Picasso.with(this).load((new StringBuilder(String.valueOf(Util.BASE_URL_THUMB_ORI))).append("w=").append(300).append("&src=").append(((ItemTimelineHP)mArrayListData.get(j)).getTimeline_img_url()).toString()).into(imageMedia, new Callback() {

                        final ConversationActivity this$0;

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
                this$0 = ConversationActivity.this;
                super();
            }
                    });
                    progressbar_imgcontent.setVisibility(8);
                }
                catch (Exception exception1)
                {
                    exception1.printStackTrace();
                }
            }
        }
        progressbar_imgcontent.setVisibility(8);
        if (!((ItemTimelineHP)mArrayListData.get(j)).getTimeline_userphoto().trim().equals("")) goto _L2; else goto _L1
_L1:
        imageAvatar.setVisibility(0);
        imageAvatar.setImageResource(0x7f020297);
_L3:
        Log.e("tl_date", tl_date);
        txtWaktu.setText(Utility.convertDate(tl_date));
        txtTotalKom.setText((new StringBuilder(String.valueOf(s))).append(" komentar").toString());
        Log.e("new_loadResult", new_load);
        Exception exception2;
        if (new_load.equals("1"))
        {
            list_timeline_hp.addView(view, 0);
        } else
        {
            list_timeline_hp.addView(view);
        }
        imageAvatar.setOnClickListener(new android.view.View.OnClickListener() {

            final ConversationActivity this$0;
            private final String val$tl_username;

            public void onClick(View view1)
            {
                view1 = new Intent(ConversationActivity.this, com/inponsel/android/v2/ProfileOtherUser);
                view1.putExtra("id_user_view", tl_username);
                startActivityForResult(view1, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = ConversationActivity.this;
                tl_username = s;
                super();
            }
        });
        imageMedia.setOnClickListener(new android.view.View.OnClickListener() {

            final ConversationActivity this$0;
            private final String val$tl_img_url;

            public void onClick(View view1)
            {
                view1 = new ArrayList();
                view1.add(tl_img_url);
                view1 = (String[])view1.toArray(new String[view1.size()]);
                Intent intent = new Intent(ConversationActivity.this, com/inponsel/android/v2/ImagePagerActivity);
                intent.putExtra("imgUrl", view1);
                intent.putExtra("pos", 0);
                startActivity(intent);
            }

            
            {
                this$0 = ConversationActivity.this;
                tl_img_url = s;
                super();
            }
        });
        list_lay_like.setOnClickListener(new android.view.View.OnClickListener() {

            final ConversationActivity this$0;
            private final String val$tl_id;
            private final String val$tl_type;

            public void onClick(View view1)
            {
                if (userFunctions.isUserLoggedIn(ConversationActivity.this))
                {
                    Log.e("login", "ok");
                    statuslike = "1";
                    idkom_pos = tl_id;
                    id_type = tl_type;
                    querylike = (new StringBuilder("status=")).append(statuslike).append("&tl_id=").append(idkom_pos).append("&id_usr=").append(ConversationActivity.user_id).append("&type=").append(id_type).append("&t=").append(t).toString();
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
                    Log.e("login", "false");
                    view1 = new android.app.AlertDialog.Builder(wrapperLight);
                    view1.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                    view1.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                        final _cls15 this$1;

                        public void onClick(DialogInterface dialoginterface, int j)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls15.this;
                super();
            }
                    });
                    view1.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls15 this$1;

                        public void onClick(DialogInterface dialoginterface, int j)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                            startActivity(dialoginterface);
                        }

            
            {
                this$1 = _cls15.this;
                super();
            }
                    });
                    view1.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls15 this$1;

                        public void onClick(DialogInterface dialoginterface, int j)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            startActivity(dialoginterface);
                        }

            
            {
                this$1 = _cls15.this;
                super();
            }
                    });
                    view1.show();
                    return;
                }
            }


            
            {
                this$0 = ConversationActivity.this;
                tl_id = s;
                tl_type = s1;
                super();
            }
        });
        list_lay_flag.setOnClickListener(new android.view.View.OnClickListener() {

            final ConversationActivity this$0;
            private final String val$tl_id;
            private final String val$tl_type;

            public void onClick(View view1)
            {
                idkom_pos = tl_id;
                id_type = tl_type;
                if (userFunctions.isUserLoggedIn(ConversationActivity.this))
                {
                    view1 = new android.app.AlertDialog.Builder(ConversationActivity.this);
                    view1.setMessage("Laporkan konten ini karena tidak sesuai atau mengandung SARA?");
                    view1.setPositiveButton("Ya", tl_type. new android.content.DialogInterface.OnClickListener() {

                        final _cls16 this$1;
                        private final String val$tl_type;

                        public void onClick(DialogInterface dialoginterface, int j)
                        {
                            queryFlag = (new StringBuilder("id_artanya=")).append(idkom_pos).append("&id_usr=").append(ConversationActivity.user_id).append("&type=").append(tl_type).append("&t=").append(t).toString();
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
                        }

            
            {
                this$1 = final__pcls16;
                tl_type = String.this;
                super();
            }
                    });
                    view1.setNegativeButton("Batal", new android.content.DialogInterface.OnClickListener() {

                        final _cls16 this$1;

                        public void onClick(DialogInterface dialoginterface, int j)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls16.this;
                super();
            }
                    });
                    view1.show();
                    return;
                } else
                {
                    view1 = new android.app.AlertDialog.Builder(ConversationActivity.this);
                    view1.setMessage("Untuk memberi laporan harus login terlebih dahulu.");
                    view1.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                        final _cls16 this$1;

                        public void onClick(DialogInterface dialoginterface, int j)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls16.this;
                super();
            }
                    });
                    view1.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls16 this$1;

                        public void onClick(DialogInterface dialoginterface, int j)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                            startActivity(dialoginterface);
                        }

            
            {
                this$1 = _cls16.this;
                super();
            }
                    });
                    view1.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls16 this$1;

                        public void onClick(DialogInterface dialoginterface, int j)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            startActivity(dialoginterface);
                        }

            
            {
                this$1 = _cls16.this;
                super();
            }
                    });
                    view1.show();
                    return;
                }
            }


            
            {
                this$0 = ConversationActivity.this;
                tl_id = s;
                tl_type = s1;
                super();
            }
        });
        list_lay_favorit.setOnClickListener(new android.view.View.OnClickListener() {

            final ConversationActivity this$0;
            private final String val$fav_stat;
            private final String val$tl_id;
            private final String val$tl_type;

            public void onClick(View view1)
            {
                idkom_pos = tl_id;
                id_type = tl_type;
                if (userFunctions.isUserLoggedIn(ConversationActivity.this))
                {
                    if (db.checkTimelineExist(idkom_pos) || fav_stat.equals("1"))
                    {
                        view1 = new android.app.AlertDialog.Builder(ConversationActivity.this);
                        if (tl_type.equals("faqhp"))
                        {
                            view1.setMessage("Hapus pertanyaan ini dari favorit?");
                        } else
                        {
                            view1.setMessage("Hapus artikel ini dari favorit?");
                        }
                        view1.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                            final _cls17 this$1;

                            public void onClick(DialogInterface dialoginterface, int j)
                            {
                                dialoginterface.dismiss();
                                stat = "0";
                                (new FavoritTask()).execute(new Void[0]);
                            }

            
            {
                this$1 = _cls17.this;
                super();
            }
                        });
                        view1.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                            final _cls17 this$1;

                            public void onClick(DialogInterface dialoginterface, int j)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$1 = _cls17.this;
                super();
            }
                        });
                        view1.show();
                        return;
                    }
                    view1 = new android.app.AlertDialog.Builder(ConversationActivity.this);
                    if (tl_type.equals("faqhp"))
                    {
                        view1.setMessage("Favoritkan pertanyaan ini?");
                    } else
                    {
                        view1.setMessage("Favoritkan artikel ini?");
                    }
                    view1.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                        final _cls17 this$1;

                        public void onClick(DialogInterface dialoginterface, int j)
                        {
                            stat = "1";
                            (new FavoritTask()).execute(new Void[0]);
                        }

            
            {
                this$1 = _cls17.this;
                super();
            }
                    });
                    view1.setNeutralButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                        final _cls17 this$1;

                        public void onClick(DialogInterface dialoginterface, int j)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls17.this;
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

                        final _cls17 this$1;

                        public void onClick(DialogInterface dialoginterface, int j)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls17.this;
                super();
            }
                    });
                    view1.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls17 this$1;

                        public void onClick(DialogInterface dialoginterface, int j)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                            startActivity(dialoginterface);
                        }

            
            {
                this$1 = _cls17.this;
                super();
            }
                    });
                    view1.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls17 this$1;

                        public void onClick(DialogInterface dialoginterface, int j)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            startActivity(dialoginterface);
                        }

            
            {
                this$1 = _cls17.this;
                super();
            }
                    });
                    view1.show();
                    return;
                }
            }


            
            {
                this$0 = ConversationActivity.this;
                tl_id = s;
                tl_type = s1;
                fav_stat = s2;
                super();
            }
        });
        list_lay_kom.setOnClickListener(new android.view.View.OnClickListener() {

            final ConversationActivity this$0;
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
                view1 = new Intent(ConversationActivity.this, com/inponsel/android/timelinedetail/TLKomenTab);
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
                this$0 = ConversationActivity.this;
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

            final ConversationActivity this$0;
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
                view1 = new Intent(ConversationActivity.this, com/inponsel/android/conversation/ConversationDetailActivity);
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
                this$0 = ConversationActivity.this;
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
            break MISSING_BLOCK_LABEL_2766;
        } else
        {
            break MISSING_BLOCK_LABEL_37;
        }
_L2:
        try
        {
            Picasso.with(this).load(((ItemTimelineHP)mArrayListData.get(j)).getTimeline_userphoto()).into(imageAvatar, new Callback() {

                final ConversationActivity this$0;

                public void onError()
                {
                    progressbar_imgcontent.setVisibility(8);
                    imageMedia.setBackgroundResource(0x7f0201b8);
                }

                public void onSuccess()
                {
                }

            
            {
                this$0 = ConversationActivity.this;
                super();
            }
            });
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception2)
        {
            exception2.printStackTrace();
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
        urlTimelineHPTagLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("conversation_timeline").append(Utility.BASE_FORMAT).append("?").append("codename=").append(codename).append("&id_user=").append(user_id).append("&top_id=").append(top_id).append("&t=").append(t).toString();
        Log.e("urlTimelineHPTagLast", urlTimelineHPTagLast);
        ArtikelTanyaNewTask();
    }

    public void TimelineOLDTask()
    {
        new_load = "0";
        mArrayListData.clear();
        urlTimelineHPTagOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("conversation_timeline").append(Utility.BASE_FORMAT).append("?").append("codename=").append(codename).append("&id_user=").append(user_id).append("&bottom_id=").append(bottom_id).append("&t=").append(t).toString();
        Log.e("urlTimelineHPTagOld", urlTimelineHPTagOld);
        ArtikelTanyaOLDTask();
    }

    public void TimelineTask()
    {
        mArrayListData.clear();
        new_load = "0";
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
        urlTimelineHPTag = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("conversation_timeline").append(Utility.BASE_FORMAT).append("?").append("codename=").append(codename).append("&id_user=").append(user_id).append("&t=").append(t).toString();
        Log.e("urlTimelineHPTag", urlTimelineHPTag);
        ArtikelTanyaTask();
    }

    public void onActivityResult(int j, int k, Intent intent)
    {
        super.onActivityResult(j, k, intent);
        mArrayListData.clear();
        Log.e("onActivityResult", "RESULT_OK");
        if (k == -1)
        {
            Log.e("Refresh", "OK");
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
        btnRefresh = (Button)findViewById(0x7f0b04d0);
        scroll_artikel = (ViewGroup)findViewById(0x7f0b0685);
        scroll_artikel.setBackgroundColor(Color.parseColor("#e0e0e0"));
        topTextView = (TextView)findViewById(0x7f0b06ca);
        topTextView.setVisibility(8);
        txtLabelConversation = (TextView)findViewById(0x7f0b06bb);
        txtLabelConversation.setVisibility(0);
        fotoKameraArrayList = new ArrayList();
        mFotoKameraAdapter = new FotoKameraAdapter(this, 0x7f0300bd, fotoKameraArrayList);
        grid_hasilfoto.setAdapter(mFotoKameraAdapter);
        BenchArrayList = new ArrayList();
        mBenchAdapter = new BenchAdapter(this, 0x7f0300bd, BenchArrayList);
        grid_benchmark.setAdapter(mBenchAdapter);
        grid_benchmark.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final ConversationActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int l, long l1)
            {
                adapterview = new Intent(ConversationActivity.this, com/inponsel/android/conversation/ConversationDetailActivity);
                adapterview.putExtra("id_artanya", mBenchAdapter.getListModel(l).getForum_id());
                adapterview.putExtra("act", "first");
                adapterview.putExtra("tl_judul", mBenchAdapter.getListModel(l).getForum_judul());
                adapterview.putExtra("tl_content", mBenchAdapter.getListModel(l).getForum_content());
                adapterview.putExtra("tl_content_ext", mBenchAdapter.getListModel(l).getForum_content_ext());
                adapterview.putExtra("tl_codename", mBenchAdapter.getListModel(l).getCodename());
                adapterview.putExtra("tl_date", mBenchAdapter.getListModel(l).getForum_date());
                adapterview.putExtra("tl_id", mBenchAdapter.getListModel(l).getForum_id());
                adapterview.putExtra("tl_id_hp", mBenchAdapter.getListModel(l).getId_hp());
                adapterview.putExtra("tl_id_user", mBenchAdapter.getListModel(l).getId_user());
                adapterview.putExtra("tl_img_url", mBenchAdapter.getListModel(l).getForum_img());
                adapterview.putExtra("tl_tag", mBenchAdapter.getListModel(l).getForum_tag());
                adapterview.putExtra("tl_type", mBenchAdapter.getListModel(l).getForum_type());
                adapterview.putExtra("tl_username", mBenchAdapter.getListModel(l).getUsername());
                adapterview.putExtra("tl_kota", mBenchAdapter.getListModel(l).getKota());
                adapterview.putExtra("tl_userphoto", mBenchAdapter.getListModel(l).getAvatar());
                adapterview.putExtra("total_like", mBenchAdapter.getListModel(l).getForum_like());
                adapterview.putExtra("fav_stat", mBenchAdapter.getListModel(l).getForum_myfav());
                adapterview.putExtra("like_stat", mBenchAdapter.getListModel(l).getForum_mylike());
                adapterview.putExtra("namalengkap", (new StringBuilder(String.valueOf(mBenchAdapter.getListModel(l).getMerk()))).append(" ").append(mBenchAdapter.getListModel(l).getModel()).toString());
                adapterview.putExtra("resolution", resolution);
                startActivityForResult(adapterview, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = ConversationActivity.this;
                super();
            }
        });
        grid_hasilfoto.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final ConversationActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int l, long l1)
            {
                adapterview = new Intent(ConversationActivity.this, com/inponsel/android/conversation/ConversationDetailActivity);
                adapterview.putExtra("id_artanya", mFotoKameraAdapter.getListModel(l).getForum_id());
                adapterview.putExtra("act", "first");
                adapterview.putExtra("tl_judul", mFotoKameraAdapter.getListModel(l).getForum_judul());
                adapterview.putExtra("tl_content", mFotoKameraAdapter.getListModel(l).getForum_content());
                adapterview.putExtra("tl_content_ext", mFotoKameraAdapter.getListModel(l).getForum_content_ext());
                adapterview.putExtra("tl_codename", mFotoKameraAdapter.getListModel(l).getCodename());
                adapterview.putExtra("tl_date", mFotoKameraAdapter.getListModel(l).getForum_date());
                adapterview.putExtra("tl_id", mFotoKameraAdapter.getListModel(l).getForum_id());
                adapterview.putExtra("tl_id_hp", mFotoKameraAdapter.getListModel(l).getId_hp());
                adapterview.putExtra("tl_id_user", mFotoKameraAdapter.getListModel(l).getId_user());
                adapterview.putExtra("tl_img_url", mFotoKameraAdapter.getListModel(l).getForum_img());
                adapterview.putExtra("tl_tag", mFotoKameraAdapter.getListModel(l).getForum_tag());
                adapterview.putExtra("tl_type", mFotoKameraAdapter.getListModel(l).getForum_type());
                adapterview.putExtra("tl_username", mFotoKameraAdapter.getListModel(l).getUsername());
                adapterview.putExtra("tl_kota", mFotoKameraAdapter.getListModel(l).getKota());
                adapterview.putExtra("tl_userphoto", mFotoKameraAdapter.getListModel(l).getAvatar());
                adapterview.putExtra("total_like", mFotoKameraAdapter.getListModel(l).getForum_like());
                adapterview.putExtra("fav_stat", mFotoKameraAdapter.getListModel(l).getForum_myfav());
                adapterview.putExtra("like_stat", mFotoKameraAdapter.getListModel(l).getForum_mylike());
                adapterview.putExtra("namalengkap", (new StringBuilder(String.valueOf(mFotoKameraAdapter.getListModel(l).getMerk()))).append(" ").append(mFotoKameraAdapter.getListModel(l).getModel()).toString());
                adapterview.putExtra("resolution", resolution);
                startActivityForResult(adapterview, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = ConversationActivity.this;
                super();
            }
        });
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            setTranslucentStatus(true);
        }
        bundle = new SystemBarTintManager(this);
        bundle.setStatusBarTintEnabled(true);
        bundle.setStatusBarTintResource(0x7f08018a);
        actionBar = getSupportActionBar();
        actionBar.setDisplayUseLogoEnabled(useLogo);
        actionBar.setBackgroundDrawable(getResources().getDrawable(0x7f0200e6));
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        int k = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        int j = k;
        if (k == 0)
        {
            j = 0x7f0b0037;
        }
        getSupportActionBar().setTitle(Html.fromHtml("<font color='##FFFFFF'>Conversation</font>"));
        bundle = (TextView)findViewById(j);
        bundle.setSelected(true);
        bundle.setTextColor(Color.parseColor("#FFFFFF"));
        bundle.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        actionBar.setDisplayShowCustomEnabled(true);
        t = Utility.session(t);
        t = Utility.session(t);
        extras = getIntent().getExtras();
        notificationLikeHelper = new NotificationLikeRSSHelper(this);
        ponselBaseApp = (PonselBaseApp)getApplication();
        ponselBaseApp.getObserver().addObserver(this);
        userFunctions = new UserFunctions();
        db = new DatabaseHandler(this);
        btnAddArtikel = (FloatingActionButton)findViewById(0x7f0b068b);
        j = getResources().getColor(0x7f08018a);
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
        }
        TimelineTask();
        btnRefresh.setOnClickListener(new android.view.View.OnClickListener() {

            final ConversationActivity this$0;

            public void onClick(View view)
            {
                btnRefresh.setVisibility(8);
                pop_txt_empty.setVisibility(8);
                TimelineTask();
            }

            
            {
                this$0 = ConversationActivity.this;
                super();
            }
        });
        txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

            final ConversationActivity this$0;

            public void onClick(View view)
            {
                TimelineOLDTask();
            }

            
            {
                this$0 = ConversationActivity.this;
                super();
            }
        });
        txtbtnfooterFoto.setOnClickListener(new android.view.View.OnClickListener() {

            final ConversationActivity this$0;

            public void onClick(View view)
            {
                GetFotoList("previous");
            }

            
            {
                this$0 = ConversationActivity.this;
                super();
            }
        });
        txtbtnfooterbenchmark.setOnClickListener(new android.view.View.OnClickListener() {

            final ConversationActivity this$0;

            public void onClick(View view)
            {
                GetBenchList("previous");
            }

            
            {
                this$0 = ConversationActivity.this;
                super();
            }
        });
        btnAddArtikel.setOnClickListener(new android.view.View.OnClickListener() {

            final ConversationActivity this$0;

            public void onClick(View view)
            {
                view = new Intent(ConversationActivity.this, com/inponsel/android/conversation/ConversationPost);
                view.putExtra("from", "apps");
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = ConversationActivity.this;
                super();
            }
        });
        cm = (ConnectivityManager)getSystemService("connectivity");
        if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable())
        {
            cm.getActiveNetworkInfo().isConnected();
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
            startActivity(new Intent(getApplicationContext(), com/inponsel/android/conversation/ConversationInteraksiActivity));
            return true;

        case 2131429682: 
            startActivity(new Intent(getApplicationContext(), com/inponsel/android/pencariangen/TabPencarian));
            break;
        }
        return true;
    }

    public void onScroll(AbsListView abslistview, int j, int k, int l)
    {
    }

    public void onScrollStateChanged(AbsListView abslistview, int j)
    {
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
        counter = jsonobject.getString("top_id");
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
            break MISSING_BLOCK_LABEL_247;
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

                final ConversationActivity this$0;

                public void run()
                {
                    Log.e("updateObserverLogin", "MainActivity");
                    if (userFunctions.isUserLoggedIn(getApplicationContext()))
                    {
                        cursor = db.getAllData();
                        cursor.moveToFirst();
                        try
                        {
                            ConversationActivity.user_id = EncodeDecodeAES.decrypt(RestClient.pelihara, cursor.getString(1));
                        }
                        catch (Exception exception) { }
                        ConversationActivity.nama_asli = cursor.getString(2);
                        ConversationActivity.user_photo = (new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(cursor.getString(3)).toString();
                        ConversationActivity.username = cursor.getString(4);
                        ConversationActivity.email_user = cursor.getString(5);
                        ConversationActivity.user_ttl = cursor.getString(6);
                        ConversationActivity.user_provinsi = cursor.getString(7);
                        ConversationActivity.user_kota = cursor.getString(8);
                        ConversationActivity.user_kecamatan = cursor.getString(cursor.getColumnIndex("user_kecamatan"));
                        ConversationActivity.user_jekel = cursor.getString(9);
                        ConversationActivity.user_ponsel1 = cursor.getString(10);
                        ConversationActivity.user_ponsel2 = cursor.getString(11);
                        ConversationActivity.user_provider1 = cursor.getString(12);
                        ConversationActivity.user_provider2 = cursor.getString(13);
                        ConversationActivity.user_joindate = cursor.getString(14);
                        ConversationActivity.user_profile_update = cursor.getString(15);
                    }
                }

            
            {
                this$0 = ConversationActivity.this;
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
            textview.setText((new StringBuilder(String.valueOf(ponselBaseApp.getObserver().getJum_komenLikeTL()))).append(" komentar").toString());
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
                    ((TextView) (obj)).setText((new StringBuilder(String.valueOf(ponselBaseApp.getObserver().getJum_komenLikeTL()))).append(" komentar").toString());
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
