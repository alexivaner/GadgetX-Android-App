// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.tlforum;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.Html;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
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
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.ExpandedGridView;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.MyObjectRequest;
import com.inponsel.android.utils.NotificationLikeRSSHelper;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.ShowHideOnScroll;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.v2.ImagePagerActivity;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.ProfileOtherUser;
import com.inponsel.android.v2.RegisterActivity;
import com.inponsel.android.v2.RoomMyDraftPost;
import com.inponsel.android.v2.RoomPenggunaHp;
import com.inponsel.android.v2.RoomPostArtikel;
import com.inponsel.android.v2.RoomPostBenchmark;
import com.inponsel.android.v2.RoomPostHasilFotoNoCrop;
import com.inponsel.android.v2.RoomPostPertanyaan;
import com.nirhart.parallaxscroll.views.ParallaxScrollView;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.tlforum:
//            InteraksiForumHP

public class ForumHPActivity extends SherlockFragmentActivity
    implements Observer, android.widget.AbsListView.OnScrollListener
{
    public class BenchAdapter extends BaseAdapter
    {

        private Activity activity;
        Context context;
        private ArrayList lm;
        int resource;
        String response;
        final ForumHPActivity this$0;

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
                view.txt_benchscrore = (TextView)viewgroup.findViewById(0x7f0b0637);
                view.imgBench = (ImageView)viewgroup.findViewById(0x7f0b0636);
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
                ((ViewHolder) (view)).imgFoto.setVisibility(8);
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
            this$0 = ForumHPActivity.this;
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

        final ForumHPActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            try
            {
                avoid = (new StringBuilder("idartanya=")).append(idkom_pos).append("&idusr=").append(ForumHPActivity.user_id).append("&stat=").append(stat).append("&type=").append(id_type).append("&t=").append(t).toString();
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
                mDialog = ProgressDialog.show(ForumHPActivity.this, "", "Menambahkan...", true);
            } else
            {
                mDialog = ProgressDialog.show(ForumHPActivity.this, "", "Menghapus...", true);
            }
            mDialog.setCancelable(true);
            mDialog.show();
        }

        public FavoritTask()
        {
            this$0 = ForumHPActivity.this;
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
        final ForumHPActivity this$0;

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
            this$0 = ForumHPActivity.this;
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

    public class GetSubsStatTask extends AsyncTask
    {

        final ForumHPActivity this$0;

        private void parseJSONSubsNews(String s)
        {
            try
            {
                s = new JSONObject(s);
                postStatusSubsStat = s.getString("success");
                postMessageSubsStat = s.getString("sub_status");
                gc_status = s.getString("gc_status");
                kota = s.getString("kota");
                kota_id = s.getString("kota_id");
                prov = s.getString("prov_id");
                Log.e("postMessageSubsStat", postMessageSubsStat);
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
                querySubsStat = (new StringBuilder("idhp=")).append(id_hp).append("&idconv=").append(codename).append("&idusr=").append(ForumHPActivity.user_id).append("&type=").append("all").append("&stat=").append(statSubNews).append("&t=").append(t).toString();
                pushURLSubsStat = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("user_forum_notif").append(Utility.BASE_FORMAT).append("?").append(querySubsStat).toString();
                Log.e("pushURLSubsStat", pushURLSubsStat);
                avoid = HttpPush.getResponse(pushURLSubsStat);
                Log.e("push", (new StringBuilder(String.valueOf(avoid))).append(querySubs).toString());
                resSubsStat = avoid.toString();
                Log.e("url ", resSubsStat);
                parseJSONSubsNews(resSubsStat);
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
            slidingView.findViewById(0x7f0b05db).setVisibility(8);
            Log.e("progbar_roomhp", "gone");
            slidingView.findViewById(0x7f0b040f).setEnabled(true);
            if (userFunctions.isUserLoggedIn(ForumHPActivity.this))
            {
                txtBigRoomPenggunaKota.setText((new StringBuilder("Di ")).append(kota).toString());
            } else
            {
                txtBigRoomPenggunaKota.setText("Di kota anda");
            }
            statJoinChat = gc_status;
            if (postMessageSubsStat.equals("1"))
            {
                img_NotifHp.setBackgroundResource(0x7f02013b);
                img_NotifHp.setText("Hapus");
                img_NotifHp.setTextColor(getResources().getColor(0x7f080182));
                statSubNews = "1";
                return;
            } else
            {
                statSubNews = "0";
                img_NotifHp.setBackgroundResource(0x7f02013a);
                img_NotifHp.setText("Ikuti");
                img_NotifHp.setTextColor(Color.parseColor("#795548"));
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            slidingView.findViewById(0x7f0b05db).setVisibility(0);
            slidingView.findViewById(0x7f0b040f).setEnabled(false);
        }

        public GetSubsStatTask()
        {
            this$0 = ForumHPActivity.this;
            super();
        }
    }

    public class PostBagusKurangTask extends AsyncTask
    {

        final ForumHPActivity this$0;

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
            this$0 = ForumHPActivity.this;
            super();
        }
    }

    public class PostFlagTask extends AsyncTask
    {

        final ForumHPActivity this$0;

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
            Toast.makeText(ForumHPActivity.this, postMessageFlagKom, 1).show();
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            Toast.makeText(ForumHPActivity.this, "Mengirim laporan...", 1).show();
        }

        public PostFlagTask()
        {
            this$0 = ForumHPActivity.this;
            super();
        }
    }

    public class SendMailLikeForumTask extends AsyncTask
    {

        final ForumHPActivity this$0;

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
            this$0 = ForumHPActivity.this;
            super();
        }
    }

    public class SubsNewsTask extends AsyncTask
    {

        final ForumHPActivity this$0;

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
                querySubs = (new StringBuilder("idhp=")).append(id_hp).append("&idusr=").append(ForumHPActivity.user_id).append("&type=").append("all").append("&stat=").append(statSubNews).append("&t=").append(t).toString();
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
            if (postStatusSubsNews.equals("1") || postStatusSubsNews.equals("10"))
            {
                Toast.makeText(ForumHPActivity.this, postMessageSubsNews, 1).show();
                if (statSubNews.equals("1"))
                {
                    img_NotifHp.setBackgroundResource(0x7f02013b);
                    img_NotifHp.setText("Hapus");
                    img_NotifHp.setTextColor(getResources().getColor(0x7f080182));
                } else
                {
                    img_NotifHp.setBackgroundResource(0x7f02013a);
                    img_NotifHp.setText("Ikuti");
                    img_NotifHp.setTextColor(Color.parseColor("#795548"));
                }
                mDialog.dismiss();
                return;
            }
            if (postStatusSubsNews.equals("00") || postStatusSubsNews.equals("0"))
            {
                Toast.makeText(ForumHPActivity.this, postMessageSubsNews, 1).show();
                if (statSubNews.equals("1"))
                {
                    img_NotifHp.setBackgroundResource(0x7f02013b);
                    img_NotifHp.setText("Hapus");
                    img_NotifHp.setTextColor(getResources().getColor(0x7f080182));
                } else
                {
                    img_NotifHp.setBackgroundResource(0x7f02013a);
                    img_NotifHp.setText("Ikuti");
                    img_NotifHp.setTextColor(Color.parseColor("#795548"));
                }
                mDialog.dismiss();
                return;
            }
            if (postStatusSubsNews.equals("40404"))
            {
                mDialog.dismiss();
                return;
            } else
            {
                Toast.makeText(ForumHPActivity.this, postMessageSubsNews, 1).show();
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            if (statSubNews.equals("1"))
            {
                mDialog = ProgressDialog.show(ForumHPActivity.this, "", "Menambahkan...", true);
            } else
            {
                mDialog = ProgressDialog.show(ForumHPActivity.this, "", "Menghapus...", true);
            }
            mDialog.setCancelable(true);
            mDialog.show();
        }

        public SubsNewsTask()
        {
            this$0 = ForumHPActivity.this;
            super();
        }
    }


    public static String email_user;
    public static String nama_asli;
    public static String user_id;
    public static String user_jekel;
    public static String user_joindate;
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
    String bottom_id;
    LinearLayout bottom_list;
    FloatingActionButton btnAddArtikel;
    Cursor c;
    int charCount;
    String codename;
    int countAllKom;
    int countKomOld;
    String counter;
    int counterBench;
    int counterFoto;
    Cursor cursor;
    DatabaseHandler db;
    Bundle extras;
    String first_get;
    ArrayList fotoKameraArrayList;
    String gambar;
    String gambar_hp;
    String gc_status;
    ExpandedGridView grid_benchmark;
    ExpandedGridView grid_hasilfoto;
    LinearLayout grup_footer;
    LinearLayout grup_footerFoto;
    LinearLayout grup_footerbenchmark;
    Intent i;
    String id_hp;
    String id_type;
    String idkom_pos;
    ImageView imageArtikelType;
    ImageView imageAvatar;
    ImageView imageMedia;
    ImageView imgAvatar;
    Button img_NotifHp;
    ImageView img_cover;
    ImageView img_empty;
    ImageView img_label_actionbar;
    boolean isExpand;
    JSONArray jArray;
    String json_response;
    String jum_komen;
    String kota;
    String kota_id;
    LinearLayout lay_quote;
    LinearLayout layout_Aksesori;
    LinearLayout layout_Benchmark;
    LinearLayout layout_ChatRoom;
    LinearLayout layout_HasilFoto;
    LinearLayout layout_OSFirm;
    LinearLayout layout_RoomAplikasi;
    LinearLayout layout_RoomDiskus;
    LinearLayout layout_RoomGames;
    LinearLayout layout_RoomHack;
    LinearLayout layout_RoomKirimArt;
    LinearLayout layout_RoomMyDraft;
    LinearLayout layout_RoomPenggunaHP;
    LinearLayout layout_RoomPenggunaKota;
    LinearLayout layout_RoomTanya;
    LinearLayout layout_RoomTimeline;
    LinearLayout layout_RoomTips;
    LinearLayout layout_TanyaUser;
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
    TextView pop_txt_empty;
    String postMessageAddTL;
    String postMessageFlagKom;
    String postMessageLikeKom;
    String postMessageSubsNews;
    String postMessageSubsStat;
    String postStatusAddTL;
    String postStatusFlagKom;
    String postStatusLikeKom;
    String postStatusSubsNews;
    String postStatusSubsStat;
    SmoothProgressBar progbar_roomhp;
    ProgressBar progressbar_TimelineHP;
    ProgressBar progressbar_cover;
    ProgressBar progressbar_imgcontent;
    String prov;
    String pushURLSubs;
    String pushURLSubsStat;
    String queryFlag;
    String querySubs;
    String querySubsStat;
    String querylike;
    String res;
    String resFlag;
    String resSubs;
    String resSubsStat;
    String reslike;
    String resolution;
    RelativeLayout rl_actionbarforum;
    ParallaxScrollView scroll_artikel;
    View slidingView;
    String stat;
    String statJoinChat;
    String statSubNews;
    String statuslike;
    String strKonekStat;
    String str_img_cover;
    String str_srclink;
    String succesStat;
    String t;
    String tag_timeline;
    String tambah_artikel[] = {
        "Topik umum", "Tips & trik", "Hasil foto kamera", "Benchmark", "Aksesori", "Tanya"
    };
    TextView topTextView;
    String top_id;
    String tot_LikePon;
    String tot_LikeTL;
    String totdis_LikeKom;
    String totdis_LikePon;
    TextView txtBenchSkor;
    TextView txtBigNotifHP;
    TextView txtBigRoomKirimArt;
    TextView txtBigRoomMyDraft;
    TextView txtBigRoomPenggunaHp;
    TextView txtBigRoomPenggunaKota;
    TextView txtBigRoomTanya;
    TextView txtBigTimelineHP;
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
    TextView txt_penggunahp;
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

    public ForumHPActivity()
    {
        postStatusAddTL = "";
        postMessageAddTL = "";
        resolution = "450";
        str_img_cover = "";
        gambar_hp = "";
        first_get = "";
        useLogo = false;
        actionBarTitleId = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        isExpand = false;
        TAG = getClass().getSimpleName();
        tag_timeline = "";
        statSubNews = "";
        statJoinChat = "";
        urlTimelineHPTag = "";
        urlTimelineHPTagOld = "";
        urlTimelineHPTagLast = "";
        kota = "";
        kota_id = "";
        prov = "";
        postMessageSubsStat = "";
        gc_status = "";
        new_load = "";
        bottom_id = "";
        top_id = "0";
        jum_komen = "0";
        tot_LikePon = "";
        totdis_LikePon = "";
        succesStat = "";
        countKomOld = 0;
        countAllKom = 0;
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
        t = Utility.session(RestClient.pelihara);
        fotoKameraArrayList = null;
        BenchArrayList = null;
        counterFoto = 0;
        counterBench = 0;
        urlFoto = "";
        json_response = "";
    }

    private void ArtikelTanyaNewTask()
    {
        Log.e("urlTimelineHPTagLast", urlTimelineHPTagLast);
        MyObjectRequest myobjectrequest = new MyObjectRequest(urlTimelineHPTagLast, new com.android.volley.Response.Listener() {

            final ForumHPActivity this$0;

            public volatile void onResponse(Object obj)
            {
                onResponse((JSONObject)obj);
            }

            public void onResponse(JSONObject jsonobject)
            {
                parseJSONNew(jsonobject.toString());
                Log.e("succesStat", succesStat);
                if (succesStat.equals("1"))
                {
                    afterParseNew();
                }
                ponselBaseApp.getObserver().setLoginStat("1");
            }

            
            {
                this$0 = ForumHPActivity.this;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final ForumHPActivity this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
            }

            
            {
                this$0 = ForumHPActivity.this;
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

            final ForumHPActivity this$0;

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
                this$0 = ForumHPActivity.this;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final ForumHPActivity this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
                hideProgressDialogOLD();
            }

            
            {
                this$0 = ForumHPActivity.this;
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

            final ForumHPActivity this$0;

            public volatile void onResponse(Object obj)
            {
                onResponse((JSONObject)obj);
            }

            public void onResponse(JSONObject jsonobject)
            {
                parseJSON(jsonobject.toString());
                afterParse();
                hideProgressDialog();
                Picasso.with(ForumHPActivity.this).load(str_img_cover).into(img_cover, new Callback() {

                    final _cls28 this$1;

                    public void onError()
                    {
                        progressbar_cover.setVisibility(8);
                    }

                    public void onSuccess()
                    {
                        progressbar_cover.setVisibility(8);
                    }

            
            {
                this$1 = _cls28.this;
                super();
            }
                });
                Picasso.with(ForumHPActivity.this).load(gambar_hp).into(imgAvatar, new Callback() {

                    final _cls28 this$1;

                    public void onError()
                    {
                    }

                    public void onSuccess()
                    {
                    }

            
            {
                this$1 = _cls28.this;
                super();
            }
                });
                ponselBaseApp.getObserver().setLoginStat("1");
            }


            
            {
                this$0 = ForumHPActivity.this;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final ForumHPActivity this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
                hideProgressDialog();
            }

            
            {
                this$0 = ForumHPActivity.this;
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
            urlFoto = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("timeline_roomhp_tag").append(Utility.BASE_FORMAT).append("?").append("codename=").append(codename).append("&id_user=").append(user_id).append("&tag=").append(tag_timeline).append("&t=").append(t).toString();
        } else
        {
            layout_footerProgbenchmark.setVisibility(0);
            txtbtnfooterbenchmark.setVisibility(8);
            progressbar_TimelineHP.setVisibility(8);
            urlFoto = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("timeline_roomhp_tag").append(Utility.BASE_FORMAT).append("?").append("codename=").append(codename).append("&id_user=").append(user_id).append("&tag=").append(tag_timeline).append("&bottom_id=").append(bottom_id).append("&t=").append(t).toString();
        }
        Log.e("urlFoto", urlFoto);
        nextprev = new MyObjectRequest(urlFoto, new com.android.volley.Response.Listener() {

            final ForumHPActivity this$0;
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
                progressbar_TimelineHP.setVisibility(8);
                if (nextprev.equals("now"))
                {
                    if (BenchArrayList.size() == 0)
                    {
                        pop_txt_empty.setVisibility(0);
                        pop_txt_empty.setText("Konten masih kosong");
                        img_empty.setVisibility(0);
                    }
                    hideProgressDialogBench();
                }
            }

            
            {
                this$0 = ForumHPActivity.this;
                nextprev = s;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final ForumHPActivity this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
                hideProgressDialog();
            }

            
            {
                this$0 = ForumHPActivity.this;
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
            urlFoto = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("timeline_roomhp_tag").append(Utility.BASE_FORMAT).append("?").append("codename=").append(codename).append("&id_user=").append(user_id).append("&tag=").append(tag_timeline).append("&t=").append(t).toString();
        } else
        {
            progressbar_TimelineHP.setVisibility(8);
            layout_footerProgFoto.setVisibility(0);
            txtbtnfooterFoto.setVisibility(8);
            urlFoto = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("timeline_roomhp_tag").append(Utility.BASE_FORMAT).append("?").append("codename=").append(codename).append("&id_user=").append(user_id).append("&tag=").append(tag_timeline).append("&bottom_id=").append(bottom_id).append("&t=").append(t).toString();
        }
        Log.e("urlFoto", urlFoto);
        nextprev = new MyObjectRequest(urlFoto, new com.android.volley.Response.Listener() {

            final ForumHPActivity this$0;
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
                    if (fotoKameraArrayList.size() == 0)
                    {
                        pop_txt_empty.setVisibility(0);
                        img_empty.setVisibility(0);
                        pop_txt_empty.setText("Konten masih kosong");
                    }
                    hideProgressDialogFoto();
                }
            }

            
            {
                this$0 = ForumHPActivity.this;
                nextprev = s;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final ForumHPActivity this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
                hideProgressDialog();
            }

            
            {
                this$0 = ForumHPActivity.this;
                super();
            }
        }, "test", "test");
        PonselBaseApp.getInstance().addToRequestQueue(nextprev, "Foto");
    }

    private void LoginPopup(String s, String s1)
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle(s);
        builder.setMessage(s1);
        builder.setPositiveButton("Login", new android.content.DialogInterface.OnClickListener() {

            final ForumHPActivity this$0;

            public void onClick(DialogInterface dialoginterface, int j)
            {
                dialoginterface = new Intent(ForumHPActivity.this, com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                startActivityForResult(dialoginterface, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = ForumHPActivity.this;
                super();
            }
        });
        builder.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

            final ForumHPActivity this$0;

            public void onClick(DialogInterface dialoginterface, int j)
            {
                dialoginterface = new Intent(ForumHPActivity.this, com/inponsel/android/v2/RegisterActivity);
                startActivityForResult(dialoginterface, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = ForumHPActivity.this;
                super();
            }
        });
        builder.setNegativeButton("Tutup", new android.content.DialogInterface.OnClickListener() {

            final ForumHPActivity this$0;

            public void onClick(DialogInterface dialoginterface, int j)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$0 = ForumHPActivity.this;
                super();
            }
        });
        builder.show();
    }

    private void afterParse()
    {
        View view;
        ImageView imageview;
        ImageView imageview1;
        final String tl_id;
        final String tl_id_hp;
        final String tl_codename;
        final String tl_id_user;
        final String tl_judul;
        final String tl_content;
        final String tl_content_ext;
        String s;
        final String tl_img_url;
        final String tl_tag;
        final String tl_type;
        final String tl_username;
        final String tl_kota;
        final String tl_userphoto;
        final String tl_date;
        final String total_like;
        final String like_stat;
        String s1;
        final String fav_stat;
        int j;
        if (succesStat.equals("1"))
        {
            Log.e("listcount", String.valueOf(mArrayListData.size()));
            if (mArrayListData.size() < 5)
            {
                txtbtnfooter.setVisibility(8);
                grup_footer.setVisibility(8);
            } else
            {
                txtbtnfooter.setVisibility(0);
            }
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
        view = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f0300b6, null);
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
        txtForumHashTag = (TextView)view.findViewById(0x7f0b05f3);
        txtBenchSkor = (TextView)view.findViewById(0x7f0b05f5);
        txtWaktu = (TextView)view.findViewById(0x7f0b054c);
        txtImgAva = (TextView)view.findViewById(0x7f0b05e9);
        txtImgMedia = (TextView)view.findViewById(0x7f0b05ea);
        txtType = (TextView)view.findViewById(0x7f0b05e7);
        txtTag = (TextView)view.findViewById(0x7f0b05e8);
        imageview = (ImageView)view.findViewById(0x7f0b054f);
        imageview1 = (ImageView)view.findViewById(0x7f0b05f1);
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
        Log.e("tl_judulloop", tl_judul);
        if (tl_type.equals("artikel"))
        {
            txtTitle.setText(Html.fromHtml(tl_judul));
        } else
        {
            try
            {
                txtTitle.setText(Html.fromHtml(tl_judul));
            }
            catch (Exception exception) { }
        }
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
        if (tl_type.equals("benchmark"))
        {
            txtForumHashTag.setText((new StringBuilder("#")).append(tl_codename).append("\n").append("#").append(tl_tag.replaceAll("\\s+", "")).toString());
        } else
        if (tl_type.equals("hasilkamera"))
        {
            txtForumHashTag.setText((new StringBuilder("#")).append(tl_codename).append("\n").append("#").append(tl_content_ext.replaceAll("\\s+", "").replace("-", "\n#")).toString());
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
        if (txtContent.equals(""))
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
        if (!fav_stat.toString().equals("1")) goto _L2; else goto _L1
_L1:
        imageview1.setBackgroundResource(0x7f020303);
_L3:
        if (((ItemTimelineHP)mArrayListData.get(j)).getTimeline_img_url().trim().equals(""))
        {
            imageMedia.setVisibility(8);
            progressbar_imgcontent.setVisibility(8);
        } else
        {
            progressbar_imgcontent.setVisibility(0);
            Picasso.with(this).load((new StringBuilder(String.valueOf(Util.BASE_URL_THUMB_ORI))).append("w=").append(500).append("&src=").append(((ItemTimelineHP)mArrayListData.get(j)).getTimeline_img_url()).toString()).into(imageMedia, new Callback() {

                final ForumHPActivity this$0;

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
                this$0 = ForumHPActivity.this;
                super();
            }
            });
            progressbar_imgcontent.setVisibility(8);
        }
        progressbar_imgcontent.setVisibility(8);
        if (((ItemTimelineHP)mArrayListData.get(j)).getTimeline_userphoto().trim().equals(""))
        {
            imageAvatar.setVisibility(0);
            imageAvatar.setImageResource(0x7f020297);
        } else
        {
            Picasso.with(this).load(((ItemTimelineHP)mArrayListData.get(j)).getTimeline_userphoto()).into(imageAvatar, new Callback() {

                final ForumHPActivity this$0;

                public void onError()
                {
                    progressbar_imgcontent.setVisibility(8);
                    imageMedia.setBackgroundResource(0x7f0201b8);
                }

                public void onSuccess()
                {
                }

            
            {
                this$0 = ForumHPActivity.this;
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

            final ForumHPActivity this$0;
            private final String val$tl_username;

            public void onClick(View view1)
            {
                view1 = new Intent(ForumHPActivity.this, com/inponsel/android/v2/ProfileOtherUser);
                view1.putExtra("id_user_view", tl_username);
                startActivityForResult(view1, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = ForumHPActivity.this;
                tl_username = s;
                super();
            }
        });
        imageMedia.setOnClickListener(new android.view.View.OnClickListener() {

            final ForumHPActivity this$0;
            private final String val$tl_img_url;

            public void onClick(View view1)
            {
                view1 = new ArrayList();
                view1.add((new StringBuilder(String.valueOf(Util.BASE_URL_THUMB_ORI))).append("w=").append(1000).append("&src=").append(tl_img_url).toString());
                view1 = (String[])view1.toArray(new String[view1.size()]);
                Intent intent = new Intent(ForumHPActivity.this, com/inponsel/android/v2/ImagePagerActivity);
                intent.putExtra("imgUrl", view1);
                intent.putExtra("pos", 0);
                startActivity(intent);
            }

            
            {
                this$0 = ForumHPActivity.this;
                tl_img_url = s;
                super();
            }
        });
        list_lay_like.setOnClickListener(new android.view.View.OnClickListener() {

            final ForumHPActivity this$0;
            private final String val$tl_id;
            private final String val$tl_type;

            public void onClick(View view1)
            {
                if (userFunctions.isUserLoggedIn(ForumHPActivity.this))
                {
                    statuslike = "1";
                    idkom_pos = tl_id;
                    id_type = tl_type;
                    querylike = (new StringBuilder("status=")).append(statuslike).append("&tl_id=").append(idkom_pos).append("&id_usr=").append(ForumHPActivity.user_id).append("&type=").append(id_type).append("&t=").append(t).toString();
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

                        final _cls43 this$1;

                        public void onClick(DialogInterface dialoginterface, int j)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls43.this;
                super();
            }
                    });
                    view1.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls43 this$1;

                        public void onClick(DialogInterface dialoginterface, int j)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                            startActivity(dialoginterface);
                        }

            
            {
                this$1 = _cls43.this;
                super();
            }
                    });
                    view1.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls43 this$1;

                        public void onClick(DialogInterface dialoginterface, int j)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            startActivity(dialoginterface);
                        }

            
            {
                this$1 = _cls43.this;
                super();
            }
                    });
                    view1.show();
                    return;
                }
            }


            
            {
                this$0 = ForumHPActivity.this;
                tl_id = s;
                tl_type = s1;
                super();
            }
        });
        list_lay_flag.setOnClickListener(new android.view.View.OnClickListener() {

            final ForumHPActivity this$0;
            private final String val$tl_id;
            private final String val$tl_type;

            public void onClick(View view1)
            {
                idkom_pos = tl_id;
                id_type = tl_type;
                view1 = new android.app.AlertDialog.Builder(ForumHPActivity.this);
                view1.setMessage("Laporkan konten ini karena tidak sesuai atau mengandung SARA?");
                view1.setPositiveButton("Ya", tl_type. new android.content.DialogInterface.OnClickListener() {

                    final _cls44 this$1;
                    private final String val$tl_type;

                    public void onClick(DialogInterface dialoginterface, int j)
                    {
                        if (userFunctions.isUserLoggedIn(_fld0))
                        {
                            queryFlag = (new StringBuilder("id_artanya=")).append(idkom_pos).append("&id_usr=").append(ForumHPActivity.user_id).append("&type=").append(tl_type).append("&t=").append(t).toString();
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
                this$1 = final__pcls44;
                tl_type = String.this;
                super();
            }
                });
                view1.setNegativeButton("Batal", new android.content.DialogInterface.OnClickListener() {

                    final _cls44 this$1;

                    public void onClick(DialogInterface dialoginterface, int j)
                    {
                        dialoginterface.dismiss();
                    }

            
            {
                this$1 = _cls44.this;
                super();
            }
                });
                view1.show();
            }


            
            {
                this$0 = ForumHPActivity.this;
                tl_id = s;
                tl_type = s1;
                super();
            }
        });
        list_lay_favorit.setOnClickListener(new android.view.View.OnClickListener() {

            final ForumHPActivity this$0;
            private final String val$fav_stat;
            private final String val$tl_id;
            private final String val$tl_type;

            public void onClick(View view1)
            {
                idkom_pos = tl_id;
                id_type = tl_type;
                if (userFunctions.isUserLoggedIn(ForumHPActivity.this))
                {
                    if (db.checkTimelineExist(idkom_pos) || fav_stat.equals("1"))
                    {
                        view1 = new android.app.AlertDialog.Builder(ForumHPActivity.this);
                        if (tl_type.equals("faqhp"))
                        {
                            view1.setMessage("Hapus pertanyaan ini dari favorit?");
                        } else
                        {
                            view1.setMessage("Hapus artikel ini dari favorit?");
                        }
                        view1.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                            final _cls45 this$1;

                            public void onClick(DialogInterface dialoginterface, int j)
                            {
                                dialoginterface.dismiss();
                                stat = "0";
                                (new FavoritTask()).execute(new Void[0]);
                            }

            
            {
                this$1 = _cls45.this;
                super();
            }
                        });
                        view1.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                            final _cls45 this$1;

                            public void onClick(DialogInterface dialoginterface, int j)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$1 = _cls45.this;
                super();
            }
                        });
                        view1.show();
                        return;
                    }
                    view1 = new android.app.AlertDialog.Builder(ForumHPActivity.this);
                    if (tl_type.equals("faqhp"))
                    {
                        view1.setMessage("Favoritkan pertanyaan ini?");
                    } else
                    {
                        view1.setMessage("Favoritkan artikel ini?");
                    }
                    view1.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                        final _cls45 this$1;

                        public void onClick(DialogInterface dialoginterface, int j)
                        {
                            stat = "1";
                            (new FavoritTask()).execute(new Void[0]);
                        }

            
            {
                this$1 = _cls45.this;
                super();
            }
                    });
                    view1.setNeutralButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                        final _cls45 this$1;

                        public void onClick(DialogInterface dialoginterface, int j)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls45.this;
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

                        final _cls45 this$1;

                        public void onClick(DialogInterface dialoginterface, int j)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls45.this;
                super();
            }
                    });
                    view1.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls45 this$1;

                        public void onClick(DialogInterface dialoginterface, int j)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                            startActivity(dialoginterface);
                        }

            
            {
                this$1 = _cls45.this;
                super();
            }
                    });
                    view1.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls45 this$1;

                        public void onClick(DialogInterface dialoginterface, int j)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            startActivity(dialoginterface);
                        }

            
            {
                this$1 = _cls45.this;
                super();
            }
                    });
                    view1.show();
                    return;
                }
            }


            
            {
                this$0 = ForumHPActivity.this;
                tl_id = s;
                tl_type = s1;
                fav_stat = s2;
                super();
            }
        });
        list_lay_kom.setOnClickListener(new android.view.View.OnClickListener() {

            final ForumHPActivity this$0;
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
                view1 = new Intent(ForumHPActivity.this, com/inponsel/android/timelinedetail/TLKomenTab);
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
                this$0 = ForumHPActivity.this;
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

            final ForumHPActivity this$0;
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
                view1 = new Intent(ForumHPActivity.this, com/inponsel/android/timelinedetail/Hal1TLDetailActivity);
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
                this$0 = ForumHPActivity.this;
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
            break MISSING_BLOCK_LABEL_2327;
        } else
        {
            break MISSING_BLOCK_LABEL_61;
        }
_L2:
        if (fav_stat.toString().equals("0"))
        {
            imageview1.setBackgroundResource(0x7f020302);
        } else
        {
            imageview1.setBackgroundResource(0x7f020302);
        }
          goto _L3
    }

    private void afterParseNew()
    {
        View view;
        ImageView imageview;
        ImageView imageview1;
        final String tl_id;
        final String tl_id_hp;
        final String tl_codename;
        final String tl_id_user;
        final String tl_judul;
        final String tl_content;
        final String tl_content_ext;
        String s;
        final String tl_img_url;
        final String tl_tag;
        final String tl_type;
        final String tl_username;
        final String tl_kota;
        final String tl_userphoto;
        final String tl_date;
        final String total_like;
        final String like_stat;
        String s1;
        final String fav_stat;
        int j;
        if (succesStat.equals("1"))
        {
            Log.e("listcount", String.valueOf(mArrayListData.size()));
            if (mArrayListData.size() < 5)
            {
                txtbtnfooter.setVisibility(8);
                grup_footer.setVisibility(8);
            } else
            {
                txtbtnfooter.setVisibility(0);
            }
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
            list_timeline_hp.setVisibility(0);
            return;
        }
        view = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f0300b6, null);
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
        txtForumHashTag = (TextView)view.findViewById(0x7f0b05f3);
        txtBenchSkor = (TextView)view.findViewById(0x7f0b05f5);
        txtWaktu = (TextView)view.findViewById(0x7f0b054c);
        txtImgAva = (TextView)view.findViewById(0x7f0b05e9);
        txtImgMedia = (TextView)view.findViewById(0x7f0b05ea);
        txtType = (TextView)view.findViewById(0x7f0b05e7);
        txtTag = (TextView)view.findViewById(0x7f0b05e8);
        imageview = (ImageView)view.findViewById(0x7f0b054f);
        imageview1 = (ImageView)view.findViewById(0x7f0b05f1);
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
            catch (Exception exception) { }
        }
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
        if (tl_type.equals("benchmark"))
        {
            txtForumHashTag.setText((new StringBuilder("#")).append(tl_codename).append("\n").append("#").append(tl_tag.replaceAll("\\s+", "")).toString());
        } else
        if (tl_type.equals("hasilkamera"))
        {
            txtForumHashTag.setText((new StringBuilder("#")).append(tl_codename).append("\n").append("#").append(tl_content_ext.replaceAll("\\s+", "").replace("-", "\n#")).toString());
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
        if (txtContent.equals(""))
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
        if (!fav_stat.toString().equals("1")) goto _L2; else goto _L1
_L1:
        imageview1.setBackgroundResource(0x7f020303);
_L3:
        if (((ItemTimelineHP)mArrayListData.get(j)).getTimeline_img_url().trim().equals(""))
        {
            imageMedia.setVisibility(8);
            progressbar_imgcontent.setVisibility(8);
        } else
        {
            progressbar_imgcontent.setVisibility(0);
            Picasso.with(this).load((new StringBuilder(String.valueOf(Util.BASE_URL_THUMB_ORI))).append("w=").append(300).append("&src=").append(((ItemTimelineHP)mArrayListData.get(j)).getTimeline_img_url()).toString()).into(imageMedia, new Callback() {

                final ForumHPActivity this$0;

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
                this$0 = ForumHPActivity.this;
                super();
            }
            });
            progressbar_imgcontent.setVisibility(8);
        }
        progressbar_imgcontent.setVisibility(8);
        if (((ItemTimelineHP)mArrayListData.get(j)).getTimeline_userphoto().trim().equals(""))
        {
            imageAvatar.setVisibility(0);
            imageAvatar.setImageResource(0x7f020297);
        } else
        {
            Picasso.with(this).load(((ItemTimelineHP)mArrayListData.get(j)).getTimeline_userphoto()).into(imageAvatar, new Callback() {

                final ForumHPActivity this$0;

                public void onError()
                {
                    progressbar_imgcontent.setVisibility(8);
                    imageMedia.setBackgroundResource(0x7f0201b8);
                }

                public void onSuccess()
                {
                }

            
            {
                this$0 = ForumHPActivity.this;
                super();
            }
            });
        }
        Log.e("tl_date", tl_date);
        txtWaktu.setText(Utility.convertDate(tl_date));
        Log.e("new_loadResult", new_load);
        list_timeline_hp.addView(view, 0);
        imageAvatar.setOnClickListener(new android.view.View.OnClickListener() {

            final ForumHPActivity this$0;
            private final String val$tl_username;

            public void onClick(View view1)
            {
                view1 = new Intent(ForumHPActivity.this, com/inponsel/android/v2/ProfileOtherUser);
                view1.putExtra("id_user_view", tl_username);
                startActivityForResult(view1, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = ForumHPActivity.this;
                tl_username = s;
                super();
            }
        });
        imageMedia.setOnClickListener(new android.view.View.OnClickListener() {

            final ForumHPActivity this$0;
            private final String val$tl_img_url;

            public void onClick(View view1)
            {
                view1 = new ArrayList();
                view1.add((new StringBuilder(String.valueOf(Util.BASE_URL_THUMB_ORI))).append("w=").append(1000).append("&src=").append(tl_img_url).toString());
                view1 = (String[])view1.toArray(new String[view1.size()]);
                Intent intent = new Intent(ForumHPActivity.this, com/inponsel/android/v2/ImagePagerActivity);
                intent.putExtra("imgUrl", view1);
                intent.putExtra("pos", 0);
                startActivity(intent);
            }

            
            {
                this$0 = ForumHPActivity.this;
                tl_img_url = s;
                super();
            }
        });
        list_lay_like.setOnClickListener(new android.view.View.OnClickListener() {

            final ForumHPActivity this$0;
            private final String val$tl_id;
            private final String val$tl_type;

            public void onClick(View view1)
            {
                if (userFunctions.isUserLoggedIn(ForumHPActivity.this))
                {
                    statuslike = "1";
                    idkom_pos = tl_id;
                    id_type = tl_type;
                    querylike = (new StringBuilder("status=")).append(statuslike).append("&tl_id=").append(idkom_pos).append("&id_usr=").append(ForumHPActivity.user_id).append("&type=").append(id_type).append("&t=").append(t).toString();
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
                this$0 = ForumHPActivity.this;
                tl_id = s;
                tl_type = s1;
                super();
            }
        });
        list_lay_flag.setOnClickListener(new android.view.View.OnClickListener() {

            final ForumHPActivity this$0;
            private final String val$tl_id;
            private final String val$tl_type;

            public void onClick(View view1)
            {
                idkom_pos = tl_id;
                id_type = tl_type;
                view1 = new android.app.AlertDialog.Builder(ForumHPActivity.this);
                view1.setMessage("Laporkan konten ini karena tidak sesuai atau mengandung SARA?");
                view1.setPositiveButton("Ya", tl_type. new android.content.DialogInterface.OnClickListener() {

                    final _cls35 this$1;
                    private final String val$tl_type;

                    public void onClick(DialogInterface dialoginterface, int j)
                    {
                        if (userFunctions.isUserLoggedIn(_fld0))
                        {
                            queryFlag = (new StringBuilder("id_artanya=")).append(idkom_pos).append("&id_usr=").append(ForumHPActivity.user_id).append("&type=").append(tl_type).append("&t=").append(t).toString();
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
                this$0 = ForumHPActivity.this;
                tl_id = s;
                tl_type = s1;
                super();
            }
        });
        list_lay_favorit.setOnClickListener(new android.view.View.OnClickListener() {

            final ForumHPActivity this$0;
            private final String val$fav_stat;
            private final String val$tl_id;
            private final String val$tl_type;

            public void onClick(View view1)
            {
                idkom_pos = tl_id;
                id_type = tl_type;
                if (userFunctions.isUserLoggedIn(ForumHPActivity.this))
                {
                    if (db.checkTimelineExist(idkom_pos) || fav_stat.equals("1"))
                    {
                        view1 = new android.app.AlertDialog.Builder(ForumHPActivity.this);
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
                    view1 = new android.app.AlertDialog.Builder(ForumHPActivity.this);
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
                this$0 = ForumHPActivity.this;
                tl_id = s;
                tl_type = s1;
                fav_stat = s2;
                super();
            }
        });
        list_lay_kom.setOnClickListener(new android.view.View.OnClickListener() {

            final ForumHPActivity this$0;
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
                view1 = new Intent(ForumHPActivity.this, com/inponsel/android/timelinedetail/TLKomenTab);
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
                this$0 = ForumHPActivity.this;
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

            final ForumHPActivity this$0;
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
                view1 = new Intent(ForumHPActivity.this, com/inponsel/android/timelinedetail/Hal1TLDetailActivity);
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
                this$0 = ForumHPActivity.this;
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
            break MISSING_BLOCK_LABEL_2314;
        } else
        {
            break MISSING_BLOCK_LABEL_61;
        }
_L2:
        if (fav_stat.toString().equals("0"))
        {
            imageview1.setBackgroundResource(0x7f020302);
        } else
        {
            imageview1.setBackgroundResource(0x7f020302);
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
            if (mArrayListData.size() < 5)
            {
                txtbtnfooter.setVisibility(8);
                grup_footer.setVisibility(8);
            } else
            {
                txtbtnfooter.setVisibility(0);
            }
        }
        Log.e("counterparseartikel", counter);
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

    public void TimelineNewTask()
    {
        new_load = "1";
        first_get = "0";
        if (tag_timeline.equals(""))
        {
            urlTimelineHPTagLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("timeline_roomhp").append(Utility.BASE_FORMAT).append("?").append("codename=").append(codename).append("&id_user=").append(user_id).append("&top_id=").append(top_id).append("&t=").append(t).toString();
        } else
        {
            urlTimelineHPTagLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("timeline_roomhp_tag").append(Utility.BASE_FORMAT).append("?").append("codename=").append(codename).append("&id_user=").append(user_id).append("&tag=").append(tag_timeline).append("&top_id=").append(top_id).append("&t=").append(t).toString();
        }
        Log.e("urlTimelineHPTagLast", urlTimelineHPTagLast);
        ArtikelTanyaNewTask();
    }

    public void TimelineOLDTask()
    {
        first_get = "0";
        new_load = "0";
        mArrayListData.clear();
        if (tag_timeline.equals(""))
        {
            urlTimelineHPTagOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("timeline_roomhp").append(Utility.BASE_FORMAT).append("?").append("codename=").append(codename).append("&id_user=").append(user_id).append("&bottom_id=").append(bottom_id).append("&t=").append(t).toString();
        } else
        {
            urlTimelineHPTagOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("timeline_roomhp_tag").append(Utility.BASE_FORMAT).append("?").append("codename=").append(codename).append("&id_user=").append(user_id).append("&tag=").append(tag_timeline).append("&bottom_id=").append(bottom_id).append("&t=").append(t).toString();
        }
        Log.e("urlTimelineHPTagOld", urlTimelineHPTagOld);
        ArtikelTanyaOLDTask();
    }

    public void TimelineTask()
    {
        img_empty.setVisibility(8);
        pop_txt_empty.setVisibility(8);
        ll_forumlist.setVisibility(0);
        mArrayListData.clear();
        first_get = "1";
        new_load = "0";
        if (tag_timeline.equals("") || tag_timeline.equals("terbaru"))
        {
            urlTimelineHPTag = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("timeline_roomhp").append(Utility.BASE_FORMAT).append("?").append("codename=").append(codename).append("&id_user=").append(user_id).append("&t=").append(t).toString();
        } else
        if (tag_timeline.equals("terkomentari"))
        {
            urlTimelineHPTag = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("timeline_roomhp").append(Utility.BASE_FORMAT).append("?").append("codename=").append(codename).append("&id_user=").append(user_id).append("&sort=2").append("&t=").append(t).toString();
        } else
        if (tag_timeline.equals("terpopuler"))
        {
            urlTimelineHPTag = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("timeline_roomhp_hits").append(Utility.BASE_FORMAT).append("?").append("codename=").append(codename).append("&id_user=").append(user_id).append("&t=").append(t).toString();
        } else
        {
            urlTimelineHPTag = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("timeline_roomhp_tag").append(Utility.BASE_FORMAT).append("?").append("codename=").append(codename).append("&id_user=").append(user_id).append("&tag=").append(tag_timeline).append("&t=").append(t).toString();
        }
        grid_hasilfoto.setVisibility(8);
        ll_forumlistFoto.setVisibility(8);
        grid_benchmark.setVisibility(8);
        ll_forumlistbenchmark.setVisibility(8);
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
            intent = intent.getStringExtra("jsonKom");
            Log.e("onActivityResultAct", intent);
            json_response = intent;
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
        setContentView(0x7f0300df);
        scroll_artikel = (ParallaxScrollView)findViewById(0x7f0b0685);
        topTextView = (TextView)findViewById(0x7f0b06ca);
        topTextView.setVisibility(8);
        imgAvatar = (ImageView)findViewById(0x7f0b06b9);
        img_cover = (ImageView)findViewById(0x7f0b06b6);
        progressbar_cover = (ProgressBar)findViewById(0x7f0b06b5);
        extras = getIntent().getExtras();
        id_hp = extras.getString("id_hph");
        model = extras.getString("model");
        merk = extras.getString("merk");
        namalengkap = (new StringBuilder(String.valueOf(merk))).append(" ").append(model).toString();
        namalengkap = URLDecoder.decode(namalengkap);
        codename = extras.getString("codename");
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
        Object obj = getResources().getDrawable(0x7f0200ce);
        ((Drawable) (obj)).setColorFilter(-1, android.graphics.PorterDuff.Mode.SRC_ATOP);
        rl_actionbarforum = (RelativeLayout)bundle.findViewById(0x7f0b005c);
        txt_label_actionbar = (TextView)bundle.findViewById(0x7f0b005d);
        txt_sublabel_actionbar = (TextView)bundle.findViewById(0x7f0b005e);
        txt_label_actionbar.setSelected(true);
        img_label_actionbar = (ImageView)bundle.findViewById(0x7f0b005f);
        int j;
        if (android.os.Build.VERSION.SDK_INT < 16)
        {
            img_label_actionbar.setBackgroundDrawable(((Drawable) (obj)));
            txt_sublabel_actionbar.setBackgroundDrawable(((Drawable) (obj)));
        } else
        {
            img_label_actionbar.setBackground(((Drawable) (obj)));
            txt_sublabel_actionbar.setBackground(((Drawable) (obj)));
        }
        txt_label_actionbar.setText((new StringBuilder("Forum ")).append(namalengkap).toString());
        txt_sublabel_actionbar.setText("Terbaru");
        try
        {
            obj = ((PonselBaseApp)getApplication()).getTracker(com.inponsel.android.adapter.PonselBaseApp.TrackerName.APP_TRACKER);
            ((Tracker) (obj)).setScreenName((new StringBuilder("Forum ")).append(namalengkap).toString());
            ((Tracker) (obj)).send((new com.google.android.gms.analytics.HitBuilders.AppViewBuilder()).build());
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        actionBar.setCustomView(bundle);
        actionBar.setDisplayShowCustomEnabled(true);
        wrapperLight = new ContextThemeWrapper(this, 0x103006e);
        grid_hasilfoto = (ExpandedGridView)findViewById(0x7f0b06bd);
        grid_benchmark = (ExpandedGridView)findViewById(0x7f0b06c4);
        ll_forumlist = (RelativeLayout)findViewById(0x7f0b06ba);
        ll_forumlistFoto = (RelativeLayout)findViewById(0x7f0b06bc);
        ll_forumlistbenchmark = (RelativeLayout)findViewById(0x7f0b06c3);
        try
        {
            vSlidingMenu = new DobSlidingMenu(this);
            vSlidingMenu.setSlidingType(com.dobmob.dobsliding.models.SlidingItem.SlidingType.MOVE);
            vSlidingMenu.setSlidingView(0x7f0300ae);
            vSlidingMenu.setUseHandle(false);
            vSlidingMenu.setMaxDuration(500);
            vSlidingMenu.setOnCollapsedListener(new OnCollapsedListener() {

                final ForumHPActivity this$0;

                public void onCollapsed()
                {
                    Log.i(TAG, "onCollapsed");
                    isExpand = false;
                }

            
            {
                this$0 = ForumHPActivity.this;
                super();
            }
            });
            vSlidingMenu.setOnExpandedListener(new OnExpandedListener() {

                final ForumHPActivity this$0;

                public void onExpanded()
                {
                    Log.i(TAG, "onExpanded");
                    isExpand = true;
                }

            
            {
                this$0 = ForumHPActivity.this;
                super();
            }
            });
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        slidingView = vSlidingMenu.getSlidingView();
        ll_head_1 = (LinearLayout)slidingView.findViewById(0x7f0b05bc);
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            ll_head_1.setVisibility(0);
        } else
        {
            ll_head_1.setVisibility(8);
        }
        slidingView.findViewById(0x7f0b05db).setVisibility(8);
        rl_actionbarforum.setOnClickListener(new android.view.View.OnClickListener() {

            final ForumHPActivity this$0;

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
                this$0 = ForumHPActivity.this;
                super();
            }
        });
        t = Utility.session(t);
        t = Utility.session(t);
        notificationLikeHelper = new NotificationLikeRSSHelper(this);
        ponselBaseApp = (PonselBaseApp)getApplication();
        ponselBaseApp.getObserver().addObserver(this);
        userFunctions = new UserFunctions();
        db = new DatabaseHandler(this);
        img_NotifHp = (Button)findViewById(0x7f0b03ca);
        progbar_roomhp = (SmoothProgressBar)findViewById(0x7f0b05db);
        progbar_roomhp.setVisibility(8);
        ll_TLTerbaru = (LinearLayout)findViewById(0x7f0b03d3);
        ll_TLTerpopuler = (LinearLayout)findViewById(0x7f0b03d4);
        ll_TLTerkomentari = (LinearLayout)findViewById(0x7f0b03d5);
        txt_penggunahp = (TextView)findViewById(0x7f0b040a);
        txtBigNotifHP = (TextView)findViewById(0x7f0b03c9);
        txtBigRoomPenggunaHp = (TextView)findViewById(0x7f0b040e);
        txtBigRoomPenggunaKota = (TextView)findViewById(0x7f0b0412);
        txtBigRoomKirimArt = (TextView)findViewById(0x7f0b0401);
        txtBigRoomTanya = (TextView)findViewById(0x7f0b0405);
        layout_RoomPenggunaHP = (LinearLayout)findViewById(0x7f0b040b);
        layout_RoomPenggunaKota = (LinearLayout)findViewById(0x7f0b040f);
        layout_ChatRoom = (LinearLayout)findViewById(0x7f0b0333);
        layout_RoomAplikasi = (LinearLayout)findViewById(0x7f0b03da);
        layout_OSFirm = (LinearLayout)findViewById(0x7f0b03e6);
        layout_RoomGames = (LinearLayout)findViewById(0x7f0b03de);
        layout_RoomTips = (LinearLayout)findViewById(0x7f0b03e2);
        layout_RoomHack = (LinearLayout)findViewById(0x7f0b03ea);
        layout_RoomTimeline = (LinearLayout)findViewById(0x7f0b03cf);
        layout_RoomDiskus = (LinearLayout)findViewById(0x7f0b03d6);
        layout_RoomKirimArt = (LinearLayout)findViewById(0x7f0b03fe);
        layout_RoomTanya = (LinearLayout)findViewById(0x7f0b0402);
        layout_HasilFoto = (LinearLayout)findViewById(0x7f0b03ee);
        layout_Benchmark = (LinearLayout)findViewById(0x7f0b03f2);
        layout_Aksesori = (LinearLayout)findViewById(0x7f0b03f6);
        layout_TanyaUser = (LinearLayout)findViewById(0x7f0b03fa);
        layout_RoomMyDraft = (LinearLayout)findViewById(0x7f0b0406);
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
            (new GetSubsStatTask()).execute(new Void[0]);
        } else
        {
            slidingView.findViewById(0x7f0b05db).setVisibility(8);
        }
        fotoKameraArrayList = new ArrayList();
        mFotoKameraAdapter = new FotoKameraAdapter(this, 0x7f0300bd, fotoKameraArrayList);
        grid_hasilfoto.setAdapter(mFotoKameraAdapter);
        BenchArrayList = new ArrayList();
        mBenchAdapter = new BenchAdapter(this, 0x7f0300bd, BenchArrayList);
        grid_benchmark.setAdapter(mBenchAdapter);
        grid_benchmark.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final ForumHPActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int k, long l)
            {
                adapterview = new Intent(ForumHPActivity.this, com/inponsel/android/timelinedetail/Hal1TLDetailActivity);
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
                this$0 = ForumHPActivity.this;
                super();
            }
        });
        grid_hasilfoto.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final ForumHPActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int k, long l)
            {
                adapterview = new Intent(ForumHPActivity.this, com/inponsel/android/timelinedetail/Hal1TLDetailActivity);
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
                this$0 = ForumHPActivity.this;
                super();
            }
        });
        TimelineTask();
        txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

            final ForumHPActivity this$0;

            public void onClick(View view)
            {
                TimelineOLDTask();
            }

            
            {
                this$0 = ForumHPActivity.this;
                super();
            }
        });
        txt_penggunahp.setText("PENGGUNA PERANGKAT INI");
        txtBigRoomPenggunaKota.setText("Di kota anda");
        btnAddArtikel.setOnClickListener(new android.view.View.OnClickListener() {

            final ForumHPActivity this$0;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(ForumHPActivity.this))
                {
                    view = new android.app.AlertDialog.Builder(ForumHPActivity.this);
                    view.setTitle(URLDecoder.decode((new StringBuilder("Kirim Konten ")).append(merk).append(" ").append(model).toString()));
                    view.setItems(tambah_artikel, new android.content.DialogInterface.OnClickListener() {

                        final _cls7 this$1;

                        public void onClick(DialogInterface dialoginterface, int j)
                        {
                            j;
                            JVM INSTR tableswitch 0 5: default 40
                        //                                       0 47
                        //                                       1 231
                        //                                       2 415
                        //                                       3 581
                        //                                       4 747
                        //                                       5 931;
                               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
                            dialoginterface.dismiss();
                            return;
_L2:
                            Intent intent = new Intent(_fld0, com/inponsel/android/v2/RoomPostArtikel);
                            intent.putExtra("action", "post");
                            intent.putExtra("id_hph", id_hp);
                            intent.putExtra("namalengkap", namalengkap);
                            intent.putExtra("codename", codename);
                            intent.putExtra("model", model);
                            intent.putExtra("merk", merk);
                            intent.putExtra("gambar", gambar);
                            intent.putExtra("from", "apps");
                            intent.putExtra("tl_type", "artikel");
                            intent.putExtra("tl_tag", "umum");
                            startActivityForResult(intent, 0);
                            overridePendingTransition(0x7f040003, 0x7f040004);
                            continue; /* Loop/switch isn't completed */
_L3:
                            Intent intent1 = new Intent(_fld0, com/inponsel/android/v2/RoomPostArtikel);
                            intent1.putExtra("action", "post");
                            intent1.putExtra("id_hph", id_hp);
                            intent1.putExtra("namalengkap", namalengkap);
                            intent1.putExtra("codename", codename);
                            intent1.putExtra("model", model);
                            intent1.putExtra("merk", merk);
                            intent1.putExtra("gambar", gambar);
                            intent1.putExtra("from", "apps");
                            intent1.putExtra("tl_type", "artikel");
                            intent1.putExtra("tl_tag", "tips");
                            startActivityForResult(intent1, 0);
                            overridePendingTransition(0x7f040003, 0x7f040004);
                            continue; /* Loop/switch isn't completed */
_L4:
                            Intent intent2 = new Intent(_fld0, com/inponsel/android/v2/RoomPostHasilFotoNoCrop);
                            intent2.putExtra("id_hph", id_hp);
                            intent2.putExtra("namalengkap", namalengkap);
                            intent2.putExtra("codename", codename);
                            intent2.putExtra("model", model);
                            intent2.putExtra("merk", merk);
                            intent2.putExtra("gambar", gambar);
                            intent2.putExtra("from", "apps");
                            intent2.putExtra("type", "fotokamera");
                            startActivityForResult(intent2, 0);
                            overridePendingTransition(0x7f040003, 0x7f040004);
                            continue; /* Loop/switch isn't completed */
_L5:
                            Intent intent3 = new Intent(_fld0, com/inponsel/android/v2/RoomPostBenchmark);
                            intent3.putExtra("id_hph", id_hp);
                            intent3.putExtra("namalengkap", namalengkap);
                            intent3.putExtra("codename", codename);
                            intent3.putExtra("model", model);
                            intent3.putExtra("merk", merk);
                            intent3.putExtra("gambar", gambar);
                            intent3.putExtra("from", "apps");
                            intent3.putExtra("type", "benchmark");
                            startActivityForResult(intent3, 0);
                            overridePendingTransition(0x7f040003, 0x7f040004);
                            continue; /* Loop/switch isn't completed */
_L6:
                            Intent intent4 = new Intent(_fld0, com/inponsel/android/v2/RoomPostArtikel);
                            intent4.putExtra("action", "post");
                            intent4.putExtra("id_hph", id_hp);
                            intent4.putExtra("namalengkap", namalengkap);
                            intent4.putExtra("codename", codename);
                            intent4.putExtra("model", model);
                            intent4.putExtra("merk", merk);
                            intent4.putExtra("gambar", gambar);
                            intent4.putExtra("from", "apps");
                            intent4.putExtra("tl_type", "artikel");
                            intent4.putExtra("tl_tag", "aksesoris");
                            startActivityForResult(intent4, 0);
                            overridePendingTransition(0x7f040003, 0x7f040004);
                            continue; /* Loop/switch isn't completed */
_L7:
                            Intent intent5 = new Intent(_fld0, com/inponsel/android/v2/RoomPostPertanyaan);
                            intent5.putExtra("id_hph", id_hp);
                            intent5.putExtra("namalengkap", namalengkap);
                            intent5.putExtra("codename", codename);
                            intent5.putExtra("model", model);
                            intent5.putExtra("merk", merk);
                            intent5.putExtra("gambar", gambar);
                            intent5.putExtra("from", "apps");
                            intent5.putExtra("type", "faqhp");
                            startActivityForResult(intent5, 0);
                            overridePendingTransition(0x7f040003, 0x7f040004);
                            if (true) goto _L1; else goto _L8
_L8:
                        }

            
            {
                this$1 = _cls7.this;
                super();
            }
                    });
                    view.show();
                    return;
                } else
                {
                    LoginPopup("Perhatian", "Untuk mengirim artikel diharuskan login terlebih dahulu");
                    return;
                }
            }


            
            {
                this$0 = ForumHPActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b03ca).setOnClickListener(new android.view.View.OnClickListener() {

            final ForumHPActivity this$0;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(ForumHPActivity.this))
                {
                    if (statSubNews.equals("1"))
                    {
                        view = new android.app.AlertDialog.Builder(ForumHPActivity.this);
                        view.setMessage("Hentikan langganan forum perangkat ini?");
                        view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                            final _cls8 this$1;

                            public void onClick(DialogInterface dialoginterface, int j)
                            {
                                dialoginterface.dismiss();
                                statSubNews = "0";
                                (new SubsNewsTask()).execute(new Void[0]);
                            }

            
            {
                this$1 = _cls8.this;
                super();
            }
                        });
                        view.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                            final _cls8 this$1;

                            public void onClick(DialogInterface dialoginterface, int j)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$1 = _cls8.this;
                super();
            }
                        });
                        view.show();
                        return;
                    } else
                    {
                        view = new android.app.AlertDialog.Builder(ForumHPActivity.this);
                        view.setMessage("Langganan forum perangkat ini?");
                        view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                            final _cls8 this$1;

                            public void onClick(DialogInterface dialoginterface, int j)
                            {
                                statSubNews = "1";
                                (new SubsNewsTask()).execute(new Void[0]);
                            }

            
            {
                this$1 = _cls8.this;
                super();
            }
                        });
                        view.setNeutralButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                            final _cls8 this$1;

                            public void onClick(DialogInterface dialoginterface, int j)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$1 = _cls8.this;
                super();
            }
                        });
                        view.show();
                        return;
                    }
                } else
                {
                    view = new android.app.AlertDialog.Builder(ForumHPActivity.this);
                    view.setMessage("Untuk berlangganan forum, diharuskan login.");
                    view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                        final _cls8 this$1;

                        public void onClick(DialogInterface dialoginterface, int j)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls8.this;
                super();
            }
                    });
                    view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls8 this$1;

                        public void onClick(DialogInterface dialoginterface, int j)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                            startActivityForResult(dialoginterface, 0);
                            overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls8.this;
                super();
            }
                    });
                    view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls8 this$1;

                        public void onClick(DialogInterface dialoginterface, int j)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            startActivityForResult(dialoginterface, 0);
                            overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls8.this;
                super();
            }
                    });
                    view.show();
                    return;
                }
            }


            
            {
                this$0 = ForumHPActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b040b).setOnClickListener(new android.view.View.OnClickListener() {

            final ForumHPActivity this$0;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(ForumHPActivity.this))
                {
                    view = new Intent(ForumHPActivity.this, com/inponsel/android/v2/RoomPenggunaHp);
                    view.putExtra("kota", "");
                    view.putExtra("kota_id", "");
                    view.putExtra("prov", "");
                    view.putExtra("merk", merk);
                    view.putExtra("model", model);
                    view.putExtra("codename", codename);
                    startActivityForResult(view, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                    return;
                } else
                {
                    LoginPopup("Perhatian", "Untuk masuk ke halaman ini diharuskan login terlebih dahulu");
                    return;
                }
            }

            
            {
                this$0 = ForumHPActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b040f).setOnClickListener(new android.view.View.OnClickListener() {

            final ForumHPActivity this$0;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(ForumHPActivity.this))
                {
                    view = new Intent(ForumHPActivity.this, com/inponsel/android/v2/RoomPenggunaHp);
                    view.putExtra("kota", kota);
                    view.putExtra("kota_id", kota_id);
                    view.putExtra("prov", prov);
                    view.putExtra("merk", merk);
                    view.putExtra("model", model);
                    view.putExtra("codename", codename);
                    startActivityForResult(view, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                    return;
                } else
                {
                    LoginPopup("Perhatian", "Untuk masuk ke halaman ini diharuskan login terlebih dahulu");
                    return;
                }
            }

            
            {
                this$0 = ForumHPActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b03d3).setOnClickListener(new android.view.View.OnClickListener() {

            final ForumHPActivity this$0;

            public void onClick(View view)
            {
                tag_timeline = "terbaru";
                txt_sublabel_actionbar.setText("Terbaru");
                vSlidingMenu.collapse();
                TimelineTask();
            }

            
            {
                this$0 = ForumHPActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b03d4).setOnClickListener(new android.view.View.OnClickListener() {

            final ForumHPActivity this$0;

            public void onClick(View view)
            {
                tag_timeline = "terpopuler";
                txt_label_actionbar.setText((new StringBuilder("Terpopuler ")).append(namalengkap).toString());
                vSlidingMenu.collapse();
                TimelineTask();
            }

            
            {
                this$0 = ForumHPActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b03d5).setOnClickListener(new android.view.View.OnClickListener() {

            final ForumHPActivity this$0;

            public void onClick(View view)
            {
                tag_timeline = "terkomentari";
                txt_sublabel_actionbar.setText("Terkomentari");
                vSlidingMenu.collapse();
                TimelineTask();
            }

            
            {
                this$0 = ForumHPActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b03da).setOnClickListener(new android.view.View.OnClickListener() {

            final ForumHPActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Aplikasi");
                vSlidingMenu.collapse();
                tag_timeline = "apps";
                TimelineTask();
            }

            
            {
                this$0 = ForumHPActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b03e6).setOnClickListener(new android.view.View.OnClickListener() {

            final ForumHPActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Firmware");
                vSlidingMenu.collapse();
                tag_timeline = "osfirm";
                TimelineTask();
            }

            
            {
                this$0 = ForumHPActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b03de).setOnClickListener(new android.view.View.OnClickListener() {

            final ForumHPActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Games");
                vSlidingMenu.collapse();
                tag_timeline = "games";
                TimelineTask();
            }

            
            {
                this$0 = ForumHPActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b03e2).setOnClickListener(new android.view.View.OnClickListener() {

            final ForumHPActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Tips & Trik");
                vSlidingMenu.collapse();
                tag_timeline = "tips";
                TimelineTask();
            }

            
            {
                this$0 = ForumHPActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b03ea).setOnClickListener(new android.view.View.OnClickListener() {

            final ForumHPActivity this$0;

            public void onClick(View view)
            {
                txt_label_actionbar.setText((new StringBuilder("Forum Hack ")).append(namalengkap).toString());
                vSlidingMenu.collapse();
                tag_timeline = "hack";
                TimelineTask();
            }

            
            {
                this$0 = ForumHPActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b03cf).setOnClickListener(new android.view.View.OnClickListener() {

            final ForumHPActivity this$0;

            public void onClick(View view)
            {
            }

            
            {
                this$0 = ForumHPActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b03d6).setOnClickListener(new android.view.View.OnClickListener() {

            final ForumHPActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Topik Umum");
                vSlidingMenu.collapse();
                tag_timeline = "umum";
                TimelineTask();
            }

            
            {
                this$0 = ForumHPActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b03ee).setOnClickListener(new android.view.View.OnClickListener() {

            final ForumHPActivity this$0;

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
                this$0 = ForumHPActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b03f2).setOnClickListener(new android.view.View.OnClickListener() {

            final ForumHPActivity this$0;

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
                this$0 = ForumHPActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b03f6).setOnClickListener(new android.view.View.OnClickListener() {

            final ForumHPActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Aksesoris");
                vSlidingMenu.collapse();
                tag_timeline = "aksesoris";
                TimelineTask();
            }

            
            {
                this$0 = ForumHPActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b03fa).setOnClickListener(new android.view.View.OnClickListener() {

            final ForumHPActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Pertanyaan Pengunjung");
                vSlidingMenu.collapse();
                tag_timeline = "faqhp";
                TimelineTask();
            }

            
            {
                this$0 = ForumHPActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b0406).setOnClickListener(new android.view.View.OnClickListener() {

            final ForumHPActivity this$0;

            public void onClick(View view)
            {
                view = new Intent(ForumHPActivity.this, com/inponsel/android/v2/RoomMyDraftPost);
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
                this$0 = ForumHPActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b03fe).setOnClickListener(new android.view.View.OnClickListener() {

            final ForumHPActivity this$0;

            public void onClick(View view)
            {
                view = new Intent(ForumHPActivity.this, com/inponsel/android/v2/RoomPostArtikel);
                view.putExtra("action", "post");
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
                this$0 = ForumHPActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b0402).setOnClickListener(new android.view.View.OnClickListener() {

            final ForumHPActivity this$0;

            public void onClick(View view)
            {
                view = new Intent(ForumHPActivity.this, com/inponsel/android/v2/RoomPostPertanyaan);
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
                this$0 = ForumHPActivity.this;
                super();
            }
        });
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
            menuitem = new Intent(getApplicationContext(), com/inponsel/android/tlforum/InteraksiForumHP);
            menuitem.putExtra("namalengkap", namalengkap);
            menuitem.putExtra("id_hp", id_hp);
            menuitem.putExtra("codename", codename);
            startActivity(menuitem);
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
        str_img_cover = jsonobject.getString("cover");
        gambar_hp = jsonobject.getString("gambar_hp");
        Log.e("counter", counter);
        Log.e("bottom_id", bottom_id);
        Log.e("top_id", top_id);
        Log.e("succesStat", succesStat);
        countKomOld = 0;
        if (!succesStat.equals("1"))
        {
            break MISSING_BLOCK_LABEL_443;
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
            break MISSING_BLOCK_LABEL_214;
        }
        Log.e("id_rssup", ponselBaseApp.getObserver().getIndexTL());
        Log.e("mLinearListView", String.valueOf(list_timeline_hp.getChildCount()));
        j = 0;
_L3:
        if (j < list_timeline_hp.getChildCount()) goto _L2; else goto _L1
_L1:
        ponselBaseApp.getObserver().getLoginStat().equals("1");
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
