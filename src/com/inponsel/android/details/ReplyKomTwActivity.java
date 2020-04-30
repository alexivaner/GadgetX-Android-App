// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.actionbarsherlock.ActionBarSherlock;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.google.android.gms.analytics.Tracker;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.pencariangen.TabPencarian;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.NotificationKomenHelper;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.v2.ImagePagerActivity;
import com.inponsel.android.v2.ProfileOtherUser;
import com.inponsel.android.widget.DroidWriterEditText;
import com.inponsel.android.widget.TextViewFixTouchConsume;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import org.json.JSONException;
import org.json.JSONObject;

public class ReplyKomTwActivity extends SherlockFragmentActivity
    implements Observer
{
    private static class EmoticonAdapter extends BaseAdapter
    {

        private LayoutInflater mLayoutInflater;

        public int getCount()
        {
            return ReplyKomTwActivity.emotname.length;
        }

        public Object getItem(int j)
        {
            return Integer.valueOf(j);
        }

        public long getItemId(int j)
        {
            return (long)j;
        }

        public View getView(int j, View view, ViewGroup viewgroup)
        {
            if (view == null)
            {
                view = mLayoutInflater.inflate(0x7f0300bc, viewgroup, false);
                viewgroup = new ViewHolder();
                viewgroup.mImageView = (ImageView)view.findViewById(0x7f0b0631);
                viewgroup.mTextView = (TextView)view.findViewById(0x7f0b0632);
                ((ViewHolder) (viewgroup)).mTextView.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
                ((ViewHolder) (viewgroup)).mImageView.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
                ((ViewHolder) (viewgroup)).mImageView.setPadding(8, 8, 8, 8);
                view.setTag(viewgroup);
            } else
            {
                viewgroup = (ViewHolder)view.getTag();
            }
            ((ViewHolder) (viewgroup)).mTextView.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
            ((ViewHolder) (viewgroup)).mTextView.setFocusable(false);
            ((ViewHolder) (viewgroup)).mTextView.setText(ReplyKomTwActivity.emotname[j]);
            return view;
        }

        public EmoticonAdapter(Context context)
        {
            mLayoutInflater = LayoutInflater.from(context);
        }
    }

    public class PostKomen extends AsyncTask
    {

        final ReplyKomTwActivity this$0;

        private void parseJSONKom(String s)
        {
            try
            {
                s = new JSONObject(s);
                postStatus = s.getString("success");
                postMessage = s.getString("message");
                jum_komen = s.getString("total_komen");
                tot_LikePon = s.getString("total_like");
                totdis_LikePon = s.getString("total_dislike");
                ponselBaseApp.getObserver().setJum_komenLikeTw(jum_komen);
                ponselBaseApp.getObserver().setTot_LikeTw(tot_LikePon);
                ponselBaseApp.getObserver().setTotdis_LikeTw(totdis_LikePon);
                ponselBaseApp.getObserver().setIndexTw(id_tw_to);
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
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rep_kom_tw").append(Utility.BASE_FORMAT).append("?").append(querypopkomen).toString();
                Log.e("pushURL", avoid);
                avoid = HttpPush.getResponse(avoid);
                res = avoid.toString();
                parseJSONKom(res);
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
            ponselBaseApp.getObserver().setUpdateType("komentartw");
            ponselBaseApp.getObserver().setStatus_like_ponsel("-");
            btn_send_komen.setEnabled(true);
            edt_pop_komen.setEnabled(true);
            Log.e("postStatus", postStatus);
            if (!postStatus.equals("1"))
            {
                break MISSING_BLOCK_LABEL_241;
            }
            mNotificationHelper.completed(tw_name, mNotificationHelper.SucdiskomStatement);
            edt_pop_komen.setText("");
            ponselBaseApp.getObserver().setUpdateType("komentar");
            ponselBaseApp.getObserver().setStatus_like_ponsel("-");
            if (android.os.Build.VERSION.SDK_INT < 11)
            {
                break MISSING_BLOCK_LABEL_219;
            }
            (new SendMailTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
_L1:
            setResult(-1, (new Intent()).putExtra("jsonKom", res));
            finish();
            return;
            try
            {
                (new SendMailTask()).execute(new Void[0]);
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
              goto _L1
            if (postStatus.equals("040"))
            {
                mNotificationHelper.gagal(tw_name, postMessage);
                void1 = new android.app.AlertDialog.Builder(ctw);
                void1.setMessage(postMessage);
                void1.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                    final PostKomen this$1;

                    public void onClick(DialogInterface dialoginterface, int j)
                    {
                        dialoginterface.dismiss();
                    }

            
            {
                this$1 = PostKomen.this;
                super();
            }
                });
                void1.show();
                return;
            }
            mNotificationHelper.gagal(tw_name, mNotificationHelper.gagalkomStatement);
            return;
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(edt_pop_komen.getWindowToken(), 0);
            mNotificationHelper.createNotification(tw_name, mNotificationHelper.komenPostWords);
            btn_send_komen.setEnabled(false);
            edt_pop_komen.setEnabled(false);
        }

        public PostKomen()
        {
            this$0 = ReplyKomTwActivity.this;
            super();
        }
    }

    public class SendMailTask extends AsyncTask
    {

        final ReplyKomTwActivity this$0;

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
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("mail_tanggap_tw").append(Utility.BASE_FORMAT).append("?").append(querypopkomen).append("&dens=").append(getResources().getDisplayMetrics().density).toString();
                Log.e("pushURLemail", avoid);
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

        public SendMailTask()
        {
            this$0 = ReplyKomTwActivity.this;
            super();
        }
    }

    static class ViewHolder
    {

        ImageView mImageView;
        TextView mTextView;

        ViewHolder()
        {
        }
    }


    public static final String emotname[] = {
        "ae003j", "ae004j", "ae005j", "ae006j", "ae007j", "ae008j", "ae009j", "ae0013j", "ae0014j", "ae0015j", 
        "ae0019j", "ae0020j", "ae0021j", "ae0022j"
    };
    ActionBar actionBar;
    int actionBarTitleId;
    Button btn_pop_emot;
    Button btn_pop_login;
    Button btn_send_komen;
    int charCount;
    ContextThemeWrapper ctw;
    Cursor cursor;
    DatabaseHandler db;
    DroidWriterEditText edt_pop_komen;
    String email_user;
    Bundle extras;
    Intent i;
    String id_komtw_to;
    String id_tw_to;
    ImageView imgHpDetail;
    ImageView img_tanggap_picture;
    String jum_komen;
    String komen_tw_to;
    GridView listEmot;
    NotificationKomenHelper mNotificationHelper;
    ProgressBar menu_progressbar_item;
    String nama_asli;
    PonselBaseApp ponselBaseApp;
    TextView pop_txtCountKomen;
    TextView pop_txt_empty;
    String postMessage;
    String postStatus;
    ProgressBar progressbar_item;
    String querypopkomen;
    String res;
    String succesStat;
    String t;
    String tanggal_kom_to;
    TextView titleDaftarHP;
    String top_id;
    String tot_LikePon;
    String totdis_LikePon;
    String tw_name;
    TextViewFixTouchConsume txtKomentar;
    TextView txtUsername;
    TextView txtWaktu;
    private boolean useLogo;
    UserFunctions userFunctions;
    String user_id;
    String user_jekel;
    String user_joindate;
    String user_kota;
    String user_name_to;
    String user_photo;
    String user_photo_to;
    String user_ponsel1;
    String user_ponsel2;
    String user_profile_update;
    String user_provider1;
    String user_provider2;
    String user_provinsi;
    String user_ttl;
    String username;

    public ReplyKomTwActivity()
    {
        useLogo = false;
        actionBarTitleId = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        t = Utility.session(RestClient.pelihara);
        querypopkomen = "";
        user_photo = "";
        username = "";
        postStatus = "";
        postMessage = "";
        jum_komen = "0";
        tot_LikePon = "";
        totdis_LikePon = "";
        succesStat = "";
        ctw = new ContextThemeWrapper(this, 0x7f0d0055);
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

    public boolean hasFocusable()
    {
        return false;
    }

    public void onBackPressed()
    {
        Log.e("vis", "off");
        finish();
        overridePendingTransition(0x7f040001, 0x7f040002);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300d4);
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            setTranslucentStatus(true);
        }
        bundle = new SystemBarTintManager(this);
        bundle.setStatusBarTintEnabled(true);
        bundle.setStatusBarTintResource(0x7f080160);
        ponselBaseApp = (PonselBaseApp)getApplication();
        ponselBaseApp.getObserver().addObserver(this);
        int j;
        int k;
        try
        {
            bundle = ((PonselBaseApp)getApplication()).getTracker(com.inponsel.android.adapter.PonselBaseApp.TrackerName.APP_TRACKER);
            bundle.setScreenName((new StringBuilder("Tanggapan Komentar Tw ")).append(tw_name).toString());
            bundle.send((new com.google.android.gms.analytics.HitBuilders.AppViewBuilder()).build());
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        mNotificationHelper = new NotificationKomenHelper(this);
        extras = getIntent().getExtras();
        id_tw_to = extras.getString("id_tw");
        id_komtw_to = extras.getString("id_komtw");
        user_name_to = extras.getString("user_name");
        tanggal_kom_to = extras.getString("tanggal_kom");
        komen_tw_to = extras.getString("komen_tw");
        user_photo_to = extras.getString("user_photo");
        tw_name = extras.getString("tw_name");
        top_id = extras.getString("top_id");
        Log.e("top_id", top_id);
        getSherlock().setProgressBarIndeterminateVisibility(true);
        getSherlock().setProgressBarVisibility(true);
        actionBar = getSupportActionBar();
        actionBar.setDisplayUseLogoEnabled(useLogo);
        actionBar.setBackgroundDrawable(getResources().getDrawable(0x7f0200e5));
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        k = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        j = k;
        if (k == 0)
        {
            j = 0x7f0b0037;
        }
        bundle = (TextView)findViewById(j);
        bundle.setSelected(true);
        bundle.setTextColor(Color.parseColor("#FFFFFF"));
        bundle.setText((new StringBuilder("Twiiter ")).append(tw_name).toString());
        bundle.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        userFunctions = new UserFunctions();
        db = new DatabaseHandler(this);
        txtUsername = (TextView)findViewById(0x7f0b0419);
        txtKomentar = (TextViewFixTouchConsume)findViewById(0x7f0b054e);
        txtWaktu = (TextView)findViewById(0x7f0b054c);
        pop_txtCountKomen = (TextView)findViewById(0x7f0b04df);
        t = Utility.session(t);
        btn_send_komen = (Button)findViewById(0x7f0b04e0);
        btn_pop_login = (Button)findViewById(0x7f0b04e1);
        btn_pop_emot = (Button)findViewById(0x7f0b04dc);
        progressbar_item = (ProgressBar)findViewById(0x7f0b00b3);
        listEmot = (GridView)findViewById(0x7f0b0534);
        listEmot.setVisibility(8);
        img_tanggap_picture = (ImageView)findViewById(0x7f0b0681);
        edt_pop_komen = (DroidWriterEditText)findViewById(0x7f0b04de);
        edt_pop_komen.requestFocus();
        edt_pop_komen.setFocusable(true);
        listEmot.setAdapter(new EmoticonAdapter(this));
        listEmot.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final ReplyKomTwActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int l, long l1)
            {
                edt_pop_komen.setImageInsertGrid(ReplyKomTwActivity.emotname[l]);
            }

            
            {
                this$0 = ReplyKomTwActivity.this;
                super();
            }
        });
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
        t = Utility.session(t);
        try
        {
            Picasso.with(this).load(user_photo_to.trim()).into(img_tanggap_picture, new Callback() {

                final ReplyKomTwActivity this$0;

                public void onError()
                {
                }

                public void onSuccess()
                {
                    img_tanggap_picture.setVisibility(0);
                }

            
            {
                this$0 = ReplyKomTwActivity.this;
                super();
            }
            });
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        txtUsername.setText(user_name_to);
        txtWaktu.setText(Utility.convertDate(tanggal_kom_to));
        txtKomentar.setText(Html.fromHtml(Utility.parseTweet(komen_tw_to)));
        txtKomentar.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
        txtKomentar.setFocusable(false);
        btn_send_komen.setOnClickListener(new android.view.View.OnClickListener() {

            final ReplyKomTwActivity this$0;

            public void onClick(View view)
            {
                try
                {
                    view = URLEncoder.encode(edt_pop_komen.getText().toString(), "utf-8");
                    querypopkomen = (new StringBuilder("rplto=")).append(id_komtw_to).append("&komen=").append(view).append("&id_tw=").append(id_tw_to).append("&top_id=").append(top_id).append("&t=").append(t).append("&id_usr=").append(user_id).toString();
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    view.printStackTrace();
                }
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new PostKomen()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new PostKomen()).execute(new Void[0]);
                    return;
                }
            }

            
            {
                this$0 = ReplyKomTwActivity.this;
                super();
            }
        });
        edt_pop_komen.addTextChangedListener(new TextWatcher() {

            final ReplyKomTwActivity this$0;

            public void afterTextChanged(Editable editable)
            {
                if (edt_pop_komen.getText().toString().trim().length() == 0)
                {
                    btn_send_komen.setEnabled(false);
                    pop_txtCountKomen.setText("512");
                    return;
                } else
                {
                    btn_send_komen.setEnabled(true);
                    charCount = 512 - edt_pop_komen.getText().toString().length();
                    pop_txtCountKomen.setText(String.valueOf(charCount));
                    return;
                }
            }

            public void beforeTextChanged(CharSequence charsequence, int l, int i1, int j1)
            {
                if (edt_pop_komen.getText().toString().trim().length() == 0)
                {
                    btn_send_komen.setEnabled(false);
                    pop_txtCountKomen.setText("512");
                    return;
                } else
                {
                    btn_send_komen.setEnabled(true);
                    charCount = 512 - edt_pop_komen.getText().toString().length();
                    pop_txtCountKomen.setText(String.valueOf(charCount));
                    return;
                }
            }

            public void onTextChanged(CharSequence charsequence, int l, int i1, int j1)
            {
                if (edt_pop_komen.getText().toString().trim().length() == 0)
                {
                    btn_send_komen.setEnabled(false);
                    pop_txtCountKomen.setText("512");
                    return;
                } else
                {
                    btn_send_komen.setEnabled(true);
                    charCount = 512 - edt_pop_komen.getText().toString().length();
                    pop_txtCountKomen.setText(String.valueOf(charCount));
                    return;
                }
            }

            
            {
                this$0 = ReplyKomTwActivity.this;
                super();
            }
        });
        img_tanggap_picture.setOnLongClickListener(new android.view.View.OnLongClickListener() {

            final ReplyKomTwActivity this$0;

            public boolean onLongClick(View view)
            {
                view = new ArrayList();
                view.add((new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(user_photo_to.toString().trim()).toString());
                view = (String[])view.toArray(new String[view.size()]);
                Intent intent = new Intent(ReplyKomTwActivity.this, com/inponsel/android/v2/ImagePagerActivity);
                intent.putExtra("imgUrl", view);
                intent.putExtra("pos", 0);
                startActivity(intent);
                return false;
            }

            
            {
                this$0 = ReplyKomTwActivity.this;
                super();
            }
        });
        img_tanggap_picture.setOnClickListener(new android.view.View.OnClickListener() {

            final ReplyKomTwActivity this$0;

            public void onClick(View view)
            {
                view = new Intent(ReplyKomTwActivity.this, com/inponsel/android/v2/ProfileOtherUser);
                view.putExtra("id_user_view", user_name_to);
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = ReplyKomTwActivity.this;
                super();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onKeyDown(int j, KeyEvent keyevent)
    {
        switch (j)
        {
        default:
            return super.onKeyDown(j, keyevent);

        case 82: // 'R'
            return true;
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return true;

        case 16908332: 
            onBackPressed();
            return true;

        case 2131429682: 
            startActivity(new Intent(getApplicationContext(), com/inponsel/android/pencariangen/TabPencarian));
            break;
        }
        return true;
    }

    public void update(Observable observable, Object obj)
    {
        if (ponselBaseApp.getObserver().getLoginStat().equals("1") && userFunctions.isUserLoggedIn(this))
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
