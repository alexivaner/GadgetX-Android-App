// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.widget.DrawerLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.actionbarsherlock.ActionBarSherlock;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.android.volley.VolleyError;
import com.google.android.gms.analytics.Tracker;
import com.inponsel.android.adapter.ListChatGroupAdapter;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.AnimateFirstDisplayListener;
import com.inponsel.android.utils.Base64;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.InternalStorageContentProvider;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.MyObjectRequest;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.widget.DroidWriterEditText;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.sherlock.navigationdrawer.compat.SherlockActionBarDrawerToggle;
import eu.janmuller.android.simplecropimage.CropImage;
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            RoomInfoChat, ProfileActivity, RegisterActivity, LoginActivity, 
//            RoomShareLocationActivity, ProfileOtherUser, ImagePagerActivity

public class RoomChatActivity extends SherlockFragmentActivity
    implements android.view.View.OnClickListener, Observer
{
    private class ActionBarHelper
    {

        private final ActionBar mActionBar;
        final RoomChatActivity this$0;

        public void init()
        {
            mActionBar.setDisplayHomeAsUpEnabled(true);
            mActionBar.setHomeButtonEnabled(true);
        }

        public void onDrawerClosed()
        {
        }

        public void onDrawerOpened()
        {
        }

        private ActionBarHelper()
        {
            this$0 = RoomChatActivity.this;
            super();
            mActionBar = getSupportActionBar();
        }

        ActionBarHelper(ActionBarHelper actionbarhelper)
        {
            this();
        }
    }

    private class DemoDrawerListener
        implements android.support.v4.widget.DrawerLayout.DrawerListener
    {

        final RoomChatActivity this$0;

        public void onDrawerClosed(View view)
        {
            mDrawerToggle.onDrawerClosed(view);
            mActionBar.onDrawerClosed();
        }

        public void onDrawerOpened(View view)
        {
            mDrawerToggle.onDrawerOpened(view);
            mActionBar.onDrawerOpened();
        }

        public void onDrawerSlide(View view, float f)
        {
            mDrawerToggle.onDrawerSlide(view, f);
        }

        public void onDrawerStateChanged(int j)
        {
            mDrawerToggle.onDrawerStateChanged(j);
        }

        private DemoDrawerListener()
        {
            this$0 = RoomChatActivity.this;
            super();
        }

        DemoDrawerListener(DemoDrawerListener demodrawerlistener)
        {
            this();
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
        private DisplayImageOptions options;
        int pos;
        String res;
        int resource;
        String response;
        String status;
        String t;
        final RoomChatActivity this$0;
        String user;
        UserFunctions userFunctions;
        String username;

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
            pos = j;
            if (view == null)
            {
                view = ((LayoutInflater)activity.getSystemService("layout_inflater")).inflate(resource, null);
                viewgroup = new ViewHolder();
                viewgroup.root_people = (RelativeLayout)view.findViewById(0x7f0b084b);
                viewgroup.rl_circle = (RelativeLayout)view.findViewById(0x7f0b084c);
                viewgroup.imageHp = (ImageView)view.findViewById(0x7f0b023d);
                viewgroup.txt_nama = (TextView)view.findViewById(0x7f0b084d);
                viewgroup.txt_username = (TextView)view.findViewById(0x7f0b0373);
                viewgroup.progressbar_item = (ProgressBar)view.findViewById(0x7f0b00b3);
                view.setTag(viewgroup);
            } else
            {
                viewgroup = (ViewHolder)view.getTag();
            }
            lms = (ListModel)lm.get(j);
            if (lm != null)
            {
                ((ViewHolder) (viewgroup)).rl_circle.setVisibility(0);
                if (lms.getOnline_stat().equals("1"))
                {
                    ((ViewHolder) (viewgroup)).rl_circle.setBackgroundResource(0x7f020177);
                } else
                {
                    ((ViewHolder) (viewgroup)).rl_circle.setBackgroundResource(0x7f02017a);
                }
                ((ViewHolder) (viewgroup)).txt_nama.setText(lms.getNama_asli());
                ((ViewHolder) (viewgroup)).txt_username.setText(lms.getUsername());
                ((ViewHolder) (viewgroup)).txt_nama.setSelected(true);
                imageLoader2.displayImage(lms.getAvatar().trim(), ((ViewHolder) (viewgroup)).imageHp, options, animateFirstListener);
            }
            return view;
        }

        public void setListArray(ArrayList arraylist)
        {
            lm = arraylist;
        }

        public ListSCProvAdapter(Activity activity1, int j, ArrayList arraylist)
        {
            this$0 = RoomChatActivity.this;
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
            resource = j;
            try
            {
                imageLoader2 = ImageLoader.getInstance();
                imageLoader2.init(ImageLoaderConfiguration.createDefault(activity.getApplicationContext()));
                options = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showImageForEmptyUri(0x7f020297).showImageOnFail(0x7f020297).showImageOnLoading(0x106000d).cacheInMemory(true).imageScaleType(ImageScaleType.EXACTLY).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).build();
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
            catch (RoomChatActivity roomchatactivity)
            {
                return;
            }
        }
    }

    class ListSCProvAdapter.ViewHolder
    {

        ImageView imageHp;
        ProgressBar progressbar_item;
        RelativeLayout rl_circle;
        RelativeLayout root_people;
        final ListSCProvAdapter this$1;
        TextView txt_nama;
        TextView txt_username;

        ListSCProvAdapter.ViewHolder()
        {
            this$1 = ListSCProvAdapter.this;
            super();
        }
    }

    class MyTimerTask extends TimerTask
    {

        final RoomChatActivity this$0;

        public void run()
        {
            Log.e("timertask", "running");
            runOnUiThread(new Runnable() {

                final MyTimerTask this$1;

                public void run()
                {
label0:
                    {
                        RoomChatActivity roomchatactivity = _fld0;
                        roomchatactivity.countRefresh = roomchatactivity.countRefresh + 1;
                        if (netInfo != null && netInfo.isConnected())
                        {
                            Utility.removeMSGNotif(getApplicationContext(), Integer.parseInt((new StringBuilder("-")).append(id_hp).toString()));
                            if (listpMessageArrayList.size() != 0)
                            {
                                break label0;
                            }
                            GetJSONConversation(id_from, codename, t);
                            GetUserOnLine(codename, t);
                        }
                        return;
                    }
                    GetUserOnLine(codename, t);
                    RepeatGetMessage(id_from, codename, t, bottom_id);
                }

            
            {
                this$1 = MyTimerTask.this;
                super();
            }
            });
        }


        MyTimerTask()
        {
            this$0 = RoomChatActivity.this;
            super();
        }
    }

    public class UploadImage extends AsyncTask
    {

        final RoomChatActivity this$0;
        String urlImage;

        protected transient Long doInBackground(URL aurl[])
        {
            aurl = new ByteArrayOutputStream();
            photo_upload.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, aurl);
            String s = Base64.encodeBytes(aurl.toByteArray());
            aurl = new ArrayList();
            aurl.add(new BasicNameValuePair("image", s));
            Log.e("imgto2", (new StringBuilder("from ")).append(RoomChatActivity.user_id).append(" to ").append(codename).toString());
            urlImage = (new StringBuilder(String.valueOf(Util.BASE_PATH_UPLIMGMSG))).append("photo_upload_group").append(Utility.BASE_FORMAT).append("?id_from=").append(RoomChatActivity.user_id).append("&id_to=").append(codename).append("&id_hp=").append(id_hp).append("&bottom_id=").append(bottom_id).append("&t=").append(t).toString();
            Log.e("urlImage", urlImage);
            try
            {
                DefaultHttpClient defaulthttpclient = new DefaultHttpClient();
                HttpPost httppost = new HttpPost(urlImage);
                Log.e("urlImage", urlImage);
                httppost.setEntity(new UrlEncodedFormEntity(aurl));
                aurl = defaulthttpclient.execute(httppost).getEntity();
                inpstream = aurl.getContent();
                resp = RoomChatActivity.inputToString(inpstream);
                Log.e("url", resp);
            }
            // Misplaced declaration of an exception variable
            catch (URL aurl[])
            {
                Log.e("log_tag", (new StringBuilder("Error in http connection ")).append(aurl.toString()).toString());
            }
            return null;
        }

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((URL[])aobj);
        }

        protected void onPostExecute(Long long1)
        {
            super.onPostExecute(long1);
            try
            {
                Log.e("update_byImage", resp);
                hideSmoothProgress();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Long long1)
            {
                return;
            }
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Long)obj);
        }

        protected void onPreExecute()
        {
            showSmoothProgress();
        }

        public UploadImage()
        {
            this$0 = RoomChatActivity.this;
            super();
            urlImage = "";
        }
    }


    private static final String FOLDER_NAME = "InPonsel";
    public static final int REQUEST_CODE_CROP_IMAGE = 3;
    public static final int REQUEST_CODE_GALLERY = 1;
    public static final int REQUEST_CODE_TAKE_PICTURE = 2;
    public static final String TEMP_PHOTO_FILE_NAME = (new StringBuilder("inponsel_")).append(System.currentTimeMillis()).append(".jpg").toString();
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
    ActionBar actionBar;
    int actionBarTitleId;
    Animation animFadein;
    Animation animFadeout;
    private ImageLoadingListener animateFirstListener;
    String bottom_id;
    Button btn_JoinGroupChat;
    Button btn_send_komen;
    int charCount;
    ArrayList chatArray;
    ListChatGroupAdapter chatMsgAdapter;
    String chat_avaible;
    ConnectivityManager cm;
    String codename;
    int countAllKom;
    int countKomOld;
    int countRefresh;
    Cursor cursor;
    DatabaseHandler db;
    DroidWriterEditText edt_pop_komen;
    Bundle extras;
    String from_name;
    String from_photo;
    String gambar;
    Intent i;
    String id_from;
    String id_hp;
    String id_msg;
    ImageLoader imageLoader2;
    ImageView imgHpDetail;
    String img_height;
    ImageView img_user_picture;
    String img_width;
    InputMethodManager imm;
    InputStream inpstream;
    MenuItem itemTurnNotif;
    int jum_msg;
    String komencount;
    String kota;
    String kota_id;
    String last_message;
    RelativeLayout lay_button_send;
    LayoutInflater layoutInflater;
    LinearLayout layout_empty;
    LinearLayout layout_header_msg;
    LinearLayout layout_popup;
    LinearLayout left_drawer;
    ArrayList listInboxDB;
    ListView listMessaging;
    ListView listUserJoin;
    ArrayList listpMessageArrayList;
    LinearLayout ll_UserBack;
    ImageLoaderConfiguration loaderConfiguration;
    private ActionBarHelper mActionBar;
    private DrawerLayout mDrawerLayout;
    private SherlockActionBarDrawerToggle mDrawerToggle;
    private File mFileTemp;
    String me_message;
    ImageView menu_imgProfil;
    TextView menu_ponsel_pengguna;
    RelativeLayout menu_profil;
    ProgressBar menu_progressbar_item;
    TextView menu_sim_pengguna;
    TextView menu_username;
    String merk;
    String message_type;
    String model;
    String msg_date;
    String msg_ext;
    String msg_kordinat;
    MyTimerTask myTimerTask;
    String namalengkap;
    NetworkInfo netInfo;
    String older_count;
    private DisplayImageOptions options;
    private DisplayImageOptions optionsNoRound;
    Bitmap photo_upload;
    PonselBaseApp ponselBaseApp;
    String pop_show;
    TextView pop_txtCountKomen;
    RelativeLayout popupOutside;
    View popupView;
    PopupWindow popupWindow;
    SmoothProgressBar progbar_send;
    ProgressBar progressbar_item;
    ProgressBar progressbar_middle;
    String prov;
    String resp;
    RelativeLayout rl_share_camera;
    RelativeLayout rl_share_galleri;
    RelativeLayout rl_share_location;
    String statJoinChat;
    String t;
    private String tag_json_obj;
    Timer timer;
    String to_name;
    String to_photo;
    String top_id;
    String top_id_msg;
    TextView txtLastSeen;
    TextView txtNotif;
    TextView txtUsername;
    TextView txtWaktu;
    TextView txt_OlderMessage;
    TextView txt_empty;
    TextView txt_new_message;
    String unread_msg;
    String url_thumb;
    UserFunctions userFunctions;
    ListSCProvAdapter userJoinAdapter;

    public RoomChatActivity()
    {
        img_width = "";
        img_height = "";
        actionBarTitleId = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        chatArray = null;
        animateFirstListener = new AnimateFirstDisplayListener();
        countRefresh = 0;
        top_id_msg = "";
        jum_msg = 0;
        statJoinChat = "";
        listpMessageArrayList = null;
        tag_json_obj = "jobj_req";
        bottom_id = "0";
        top_id = "";
        t = Utility.session(RestClient.pelihara);
        older_count = "";
        url_thumb = "";
        chat_avaible = "";
        countKomOld = 0;
        countAllKom = 0;
        komencount = "";
        pop_show = "0";
        kota = "";
        kota_id = "";
        prov = "";
    }

    private void GetJSONConversation(String s, String s1, String s2)
    {
        showProgressDialog();
        s = (new StringBuilder(String.valueOf(Util.BASE_PATH_MSG))).append("chat_group").append(Utility.BASE_FORMAT).append("?from=").append(user_id).append("&to=").append(s1).append("&t=").append(s2).toString();
        Log.e("urlConversation", s);
        s = new MyObjectRequest(s, new com.android.volley.Response.Listener() {

            final RoomChatActivity this$0;

            public volatile void onResponse(Object obj)
            {
                onResponse((JSONObject)obj);
            }

            public void onResponse(JSONObject jsonobject)
            {
                parseJSON(jsonobject.toString());
                chatMsgAdapter.setListArray(listpMessageArrayList);
                if (listpMessageArrayList.size() == 20)
                {
                    txt_OlderMessage.setVisibility(0);
                } else
                {
                    txt_OlderMessage.setVisibility(8);
                }
                if (statJoinChat.equals("1"))
                {
                    btn_JoinGroupChat.setBackgroundResource(0x7f02013b);
                    btn_JoinGroupChat.setText("Hapus");
                    btn_JoinGroupChat.setTextColor(getResources().getColor(0x7f080182));
                    itemTurnNotif.setChecked(true);
                } else
                {
                    btn_JoinGroupChat.setBackgroundResource(0x7f02013a);
                    btn_JoinGroupChat.setText("Ikuti");
                    btn_JoinGroupChat.setTextColor(getResources().getColor(0x7f080181));
                    itemTurnNotif.setChecked(false);
                }
                chatMsgAdapter.notifyDataSetChanged();
                txtLastSeen.setVisibility(8);
                hideProgressDialog();
            }

            
            {
                this$0 = RoomChatActivity.this;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final RoomChatActivity this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
                hideProgressDialog();
            }

            
            {
                this$0 = RoomChatActivity.this;
                super();
            }
        }, "test", "test");
        scrollMyListViewToBottom();
        PonselBaseApp.getInstance().addToRequestQueue(s, tag_json_obj);
    }

    private void GetOlderMessage(String s, String s1, String s2, String s3)
    {
        s = (new StringBuilder(String.valueOf(Util.BASE_PATH_MSG))).append("chat_group").append(Utility.BASE_FORMAT).append("?top_id=").append(s3).append("&from=").append(user_id).append("&to=").append(s1).append("&t=").append(s2).toString();
        Log.e("olderURL", s);
        showOlderProgress();
        s = new MyObjectRequest(s, new com.android.volley.Response.Listener() {

            final RoomChatActivity this$0;

            public volatile void onResponse(Object obj)
            {
                onResponse((JSONObject)obj);
            }

            public void onResponse(JSONObject jsonobject)
            {
label0:
                {
                    parseJSONOlderMessage(jsonobject.toString());
                    Log.e("jum_msg", String.valueOf(jum_msg));
                    if (jum_msg != 0)
                    {
                        chatMsgAdapter.setListArray(listpMessageArrayList);
                        chatMsgAdapter.notifyDataSetChanged();
                    }
                    txtLastSeen.setVisibility(8);
                    Log.e("older_countafter", older_count);
                    if (layout_header_msg.getVisibility() == 0)
                    {
                        if (Integer.parseInt(older_count) != 20)
                        {
                            break label0;
                        }
                        layout_header_msg.setVisibility(8);
                        txt_OlderMessage.setVisibility(0);
                    }
                    return;
                }
                layout_header_msg.setVisibility(8);
                txt_OlderMessage.setVisibility(8);
            }

            
            {
                this$0 = RoomChatActivity.this;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final RoomChatActivity this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
                layout_header_msg.setVisibility(8);
                txt_OlderMessage.setVisibility(0);
            }

            
            {
                this$0 = RoomChatActivity.this;
                super();
            }
        }, "test", "test");
        PonselBaseApp.getInstance().addToRequestQueue(s, tag_json_obj);
    }

    private void GetUserOnLine(String s, String s1)
    {
        s = new MyObjectRequest((new StringBuilder(String.valueOf(Util.BASE_PATH_MSG))).append("online_groupchat").append(Utility.BASE_FORMAT).append("?id_conv=").append(s).append("&t=").append(s1).toString(), new com.android.volley.Response.Listener() {

            final RoomChatActivity this$0;

            private void parseJSONUser(String s2)
            {
                JSONObject jsonobject;
                jsonobject = new JSONObject(s2);
                s2 = jsonobject.getJSONArray("InPonsel");
                chat_avaible = jsonobject.getString("success");
                if (jsonobject.getString("success").equals("0")) goto _L2; else goto _L1
_L1:
                int j = 0;
_L5:
                if (j < s2.length()) goto _L3; else goto _L2
_L2:
                userJoinAdapter.notifyDataSetChanged();
                return;
_L3:
                try
                {
                    JSONObject jsonobject1 = s2.getJSONObject(j);
                    ListModel listmodel = new ListModel();
                    listmodel.setId_user(jsonobject1.getString("id"));
                    listmodel.setUsername(jsonobject1.getString("user_name"));
                    listmodel.setNama_asli(jsonobject1.getString("nama"));
                    listmodel.setAvatar(jsonobject1.getString("user_photo"));
                    listmodel.setLast_seen(jsonobject1.getString("last_seen"));
                    listmodel.setOnline_stat(jsonobject1.getString("status"));
                    chatArray.add(listmodel);
                }
                // Misplaced declaration of an exception variable
                catch (String s2)
                {
                    s2.printStackTrace();
                    return;
                }
                j++;
                if (true) goto _L5; else goto _L4
_L4:
            }

            public volatile void onResponse(Object obj)
            {
                onResponse((JSONObject)obj);
            }

            public void onResponse(JSONObject jsonobject)
            {
                chatArray.clear();
                parseJSONUser(jsonobject.toString());
            }

            
            {
                this$0 = RoomChatActivity.this;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final RoomChatActivity this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
                hideProgressDialog();
            }

            
            {
                this$0 = RoomChatActivity.this;
                super();
            }
        }, "test", "test");
        PonselBaseApp.getInstance().addToRequestQueue(s, tag_json_obj);
    }

    private void JoinLeaveGroup(String s, String s1, String s2, String s3, String s4)
    {
        Log.e("sendto2", (new StringBuilder("from ")).append(s1).append(" to ").append(codename).toString());
        s = (new StringBuilder(String.valueOf(Util.BASE_PATH_MSG))).append("join_leave_group").append(Utility.BASE_FORMAT).append("?id_user=").append(s).append("&id_hp=").append(id_hp).append("&id_conv=").append(codename).append("&stat=").append(s2).append("&t=").append(s3).toString();
        Log.e("urlJoinGroup", s);
        s = new MyObjectRequest(s, new com.android.volley.Response.Listener() {

            final RoomChatActivity this$0;

            public volatile void onResponse(Object obj)
            {
                onResponse((JSONObject)obj);
            }

            public void onResponse(JSONObject jsonobject)
            {
                Log.e("responseGroup", jsonobject.toString());
                if (jsonobject.toString().trim().equals("{\"response\":1}"))
                {
                    btn_JoinGroupChat.setBackgroundResource(0x7f02013b);
                    btn_JoinGroupChat.setText("Hapus");
                    btn_JoinGroupChat.setTextColor(getResources().getColor(0x7f080182));
                    itemTurnNotif.setChecked(true);
                } else
                {
                    db.delete_groupchat(codename);
                    btn_JoinGroupChat.setBackgroundResource(0x7f02013a);
                    btn_JoinGroupChat.setText("Ikuti");
                    btn_JoinGroupChat.setTextColor(getResources().getColor(0x7f080181));
                    itemTurnNotif.setChecked(false);
                }
                ponselBaseApp.getObserver().setLoginStat("1");
            }

            
            {
                this$0 = RoomChatActivity.this;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final RoomChatActivity this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
            }

            
            {
                this$0 = RoomChatActivity.this;
                super();
            }
        }, "test", "test");
        PonselBaseApp.getInstance().addToRequestQueue(s, "jobj_req");
    }

    private void OnlineStatGroup(String s, String s1, final String status, String s2, String s3)
    {
        Log.e("sendto2", (new StringBuilder("from ")).append(s1).append(" to ").append(codename).toString());
        s = (new StringBuilder(String.valueOf(Util.BASE_PATH_MSG))).append("online_status_group").append(Utility.BASE_FORMAT).append("?id_user=").append(s).append("&id_conv=").append(codename).append("&stat=").append(status).append("&t=").append(s2).toString();
        Log.e("OnlineStatGroup", s);
        s = new MyObjectRequest(s, new com.android.volley.Response.Listener() {

            final RoomChatActivity this$0;
            private final String val$status;

            public volatile void onResponse(Object obj)
            {
                onResponse((JSONObject)obj);
            }

            public void onResponse(JSONObject jsonobject)
            {
                status.equals("1");
            }

            
            {
                this$0 = RoomChatActivity.this;
                status = s;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final RoomChatActivity this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
            }

            
            {
                this$0 = RoomChatActivity.this;
                super();
            }
        }, "test", "test");
        scrollMyListViewToBottom();
        PonselBaseApp.getInstance().addToRequestQueue(s, tag_json_obj);
    }

    private void RepeatGetMessage(String s, String s1, String s2, String s3)
    {
        Log.e("chatto2", (new StringBuilder("from ")).append(id_from).append(" to ").append(codename).toString());
        s = (new StringBuilder(String.valueOf(Util.BASE_PATH_MSG))).append("chat_group").append(Utility.BASE_FORMAT).append("?bottom_id=").append(s3).append("&from=").append(user_id).append("&to=").append(s1).append("&t=").append(s2).toString();
        Log.e("repeatURL", s);
        s = new MyObjectRequest(s, new com.android.volley.Response.Listener() {

            final RoomChatActivity this$0;

            public volatile void onResponse(Object obj)
            {
                onResponse((JSONObject)obj);
            }

            public void onResponse(JSONObject jsonobject)
            {
                parseJSONRepeatMessage(jsonobject.toString());
                RoomChatActivity.removeDuplicates(listpMessageArrayList);
                if (jum_msg != 0)
                {
                    chatMsgAdapter.setListArray(listpMessageArrayList);
                    chatMsgAdapter.notifyDataSetChanged();
                }
                if (statJoinChat.equals("1"))
                {
                    btn_JoinGroupChat.setBackgroundResource(0x7f02013b);
                    btn_JoinGroupChat.setText("Hapus");
                    btn_JoinGroupChat.setTextColor(getResources().getColor(0x7f080182));
                    itemTurnNotif.setChecked(true);
                } else
                {
                    btn_JoinGroupChat.setBackgroundResource(0x7f02013a);
                    btn_JoinGroupChat.setText("Ikuti");
                    btn_JoinGroupChat.setTextColor(getResources().getColor(0x7f080181));
                    itemTurnNotif.setChecked(false);
                }
                txtLastSeen.setVisibility(8);
            }

            
            {
                this$0 = RoomChatActivity.this;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final RoomChatActivity this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
            }

            
            {
                this$0 = RoomChatActivity.this;
                super();
            }
        }, "test", "test");
        PonselBaseApp.getInstance().addToRequestQueue(s, tag_json_obj);
    }

    private void SendMessage(String s, String s1, String s2, String s3, String s4)
    {
        Log.e("sendto2", (new StringBuilder("from ")).append(s1).append(" to ").append(codename).toString());
        s = (new StringBuilder(String.valueOf(Util.BASE_PATH_MSG))).append("send_group").append(Utility.BASE_FORMAT).append("?bottom_id=").append(s4).append("&from=").append(user_id).append("&to=").append(codename).append("&id_hp=").append(id_hp).append("&msg=").append(s2).append("&t=").append(s3).toString();
        Log.e("urlSend", s);
        showSmoothProgress();
        s = new MyObjectRequest(s, new com.android.volley.Response.Listener() {

            final RoomChatActivity this$0;

            public volatile void onResponse(Object obj)
            {
                onResponse((JSONObject)obj);
            }

            public void onResponse(JSONObject jsonobject)
            {
                Log.e("response", jsonobject.toString());
                parseJSONSendMessage(jsonobject.toString());
                edt_pop_komen.requestFocus();
                edt_pop_komen.setFocusable(true);
                edt_pop_komen.setText("");
                hideSmoothProgress();
            }

            
            {
                this$0 = RoomChatActivity.this;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final RoomChatActivity this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
                hideSmoothProgress();
            }

            
            {
                this$0 = RoomChatActivity.this;
                super();
            }
        }, "test", "test");
        scrollMyListViewToBottom();
        PonselBaseApp.getInstance().addToRequestQueue(s, tag_json_obj);
    }

    public static void copyStream(InputStream inputstream, OutputStream outputstream)
        throws IOException
    {
        byte abyte0[] = new byte[1024];
        do
        {
            int j = inputstream.read(abyte0);
            if (j == -1)
            {
                return;
            }
            outputstream.write(abyte0, 0, j);
        } while (true);
    }

    private ActionBarHelper createActionBarHelper()
    {
        return new ActionBarHelper(null);
    }

    private File createFolders()
    {
        File file;
        if (android.os.Build.VERSION.SDK_INT < 8)
        {
            file = Environment.getExternalStorageDirectory();
        } else
        {
            file = Environment.getExternalStorageDirectory();
        }
        if (file == null)
        {
            file = Environment.getExternalStorageDirectory();
        } else
        {
            File file1 = new File(file, "InPonsel");
            file = file1;
            if (!file1.exists())
            {
                file = file1;
                if (!file1.mkdirs())
                {
                    return Environment.getExternalStorageDirectory();
                }
            }
        }
        return file;
    }

    private File getNextFileName()
    {
        if (mFileTemp != null && mFileTemp.exists())
        {
            return new File(mFileTemp, TEMP_PHOTO_FILE_NAME);
        } else
        {
            return null;
        }
    }

    private void hideProgressDialog()
    {
        if (progressbar_middle.getVisibility() == 0)
        {
            Log.e("chat_avaible", chat_avaible);
            if (chat_avaible.equals("0"))
            {
                layout_empty.setVisibility(8);
                txt_empty.setText("Belum ada pesan");
            } else
            {
                layout_empty.setVisibility(8);
            }
            progressbar_middle.setVisibility(8);
        }
    }

    private void hideSmoothProgress()
    {
        if (progbar_send.getVisibility() == 0)
        {
            progbar_send.setVisibility(8);
            progbar_send.setVisibility(8);
            if (chat_avaible.equals("0"))
            {
                layout_empty.setVisibility(8);
                txt_empty.setText("Belum ada pesan");
            } else
            {
                layout_empty.setVisibility(8);
            }
        }
        scrollMyListViewToBottom();
    }

    private static String inputToString(InputStream inputstream)
        throws Exception
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (inputstream == null) goto _L2; else goto _L1
_L1:
        inputstream = new BufferedReader(new InputStreamReader(inputstream, "UTF-8"));
_L4:
        String s = inputstream.readLine();
        if (s != null) goto _L3; else goto _L2
_L2:
        return stringbuilder.toString();
_L3:
        stringbuilder.append(s).append('\n');
          goto _L4
        inputstream;
          goto _L2
    }

    private void openGallery()
    {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setType("image/*");
        startActivityForResult(intent, 1);
    }

    private void parseJSONOlderMessage(String s)
    {
        JSONObject jsonobject;
        int j;
        try
        {
            jsonobject = new JSONObject(s);
            s = jsonobject.getJSONArray("InPonsel");
            older_count = jsonobject.getString("total");
            url_thumb = jsonobject.getString("url_thumb");
            Log.e("older_countparse", older_count);
            if (jsonobject.getString("top_id").equals("0"))
            {
                jum_msg = 0;
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return;
        }
        top_id = jsonobject.getString("top_id");
        j = 0;
_L2:
        if (j >= s.length())
        {
            jum_msg = listpMessageArrayList.size();
            return;
        }
        JSONObject jsonobject1 = s.getJSONObject(j);
        ListModel listmodel = new ListModel();
        listmodel.setId_msg(jsonobject1.getString("id"));
        listmodel.setId_from(jsonobject1.getString("id_from"));
        listmodel.setFrom_name(jsonobject1.getString("from_name"));
        listmodel.setFrom_photo(jsonobject1.getString("from_photo"));
        listmodel.setId_to(jsonobject1.getString("id_to"));
        listmodel.setTo_name(jsonobject1.getString("to_name"));
        listmodel.setTo_photo(jsonobject1.getString("to_photo"));
        listmodel.setLast_message(jsonobject1.getString("message"));
        listmodel.setExt(jsonobject1.getString("ext"));
        listmodel.setKordinat(jsonobject1.getString("ext").substring(jsonobject1.getString("ext").lastIndexOf("Intele%7C") + 1).replace("ntele%7C", ""));
        listmodel.setMessage_type(jsonobject1.getString("message_type"));
        listmodel.setMsg_date(jsonobject1.getString("post_date"));
        listmodel.setMe_message(jsonobject1.getString("me"));
        listmodel.setUrl_thumb(url_thumb);
        listmodel.setImg_height(jsonobject1.getString("height"));
        listmodel.setImg_width(jsonobject1.getString("width"));
        if (!db.checkGCMSGIfExist(jsonobject1.getString("id")))
        {
            db.addMSGHP(jsonobject1.getString("id"), jsonobject1.getString("id_from"), jsonobject1.getString("from_name"), jsonobject1.getString("from_photo"), jsonobject1.getString("to_name"), jsonobject1.getString("to_name"), jsonobject1.getString("to_photo"), jsonobject1.getString("message"), jsonobject1.getString("ext"), jsonobject1.getString("message_type"), "", jsonobject1.getString("me"), jsonobject1.getString("post_date"), jsonobject1.getString("width"), jsonobject1.getString("height"));
        }
        listpMessageArrayList.add(0, listmodel);
        j++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void parseJSONRepeatMessage(String s)
    {
        JSONArray jsonarray;
        s = new JSONObject(s);
        jsonarray = s.getJSONArray("InPonsel");
        statJoinChat = s.getString("gc_status");
        Log.e("statJoinChat", statJoinChat);
        if (!statJoinChat.equals("1"))
        {
            break MISSING_BLOCK_LABEL_94;
        }
        itemTurnNotif.setChecked(true);
_L1:
        url_thumb = s.getString("url_thumb");
        if (s.getString("bottom_id").equals("0"))
        {
            jum_msg = 0;
            return;
        }
        break MISSING_BLOCK_LABEL_114;
        try
        {
            itemTurnNotif.setChecked(false);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return;
        }
          goto _L1
        bottom_id = s.getString("bottom_id");
        int j = 0;
_L4:
        if (j >= jsonarray.length())
        {
            jum_msg = listpMessageArrayList.size();
            return;
        }
        JSONObject jsonobject;
        ListModel listmodel;
        jsonobject = jsonarray.getJSONObject(j);
        listmodel = new ListModel();
        listmodel.setId_msg(jsonobject.getString("id"));
        listmodel.setId_from(jsonobject.getString("id_from"));
        listmodel.setFrom_name(jsonobject.getString("from_name"));
        listmodel.setFrom_photo(jsonobject.getString("from_photo"));
        listmodel.setId_to(jsonobject.getString("id_to"));
        listmodel.setTo_name(jsonobject.getString("to_name"));
        listmodel.setTo_photo(jsonobject.getString("to_photo"));
        listmodel.setLast_message(jsonobject.getString("message"));
        listmodel.setExt(jsonobject.getString("ext"));
        listmodel.setKordinat(jsonobject.getString("ext").substring(jsonobject.getString("ext").lastIndexOf("Intele%7C") + 1).replace("ntele%7C", ""));
        listmodel.setMessage_type(jsonobject.getString("message_type"));
        listmodel.setMsg_date(jsonobject.getString("post_date"));
        listmodel.setMe_message(jsonobject.getString("me"));
        listmodel.setUrl_thumb(url_thumb);
        listmodel.setImg_height(jsonobject.getString("height"));
        listmodel.setImg_width(jsonobject.getString("width"));
        if ((listMessaging.getFirstVisiblePosition() != 0 || listMessaging.getChildAt(0).getTop() < 0) && (listMessaging.getLastVisiblePosition() == listMessaging.getAdapter().getCount() - 1 || listMessaging.getChildAt(listMessaging.getChildCount() - 1).getBottom() < listMessaging.getHeight())) goto _L3; else goto _L2
_L2:
        TextView textview;
        txt_new_message.startAnimation(animFadein);
        txt_new_message.setVisibility(0);
        textview = txt_new_message;
        if (!jsonobject.getString("message_type").equals("1"))
        {
            break MISSING_BLOCK_LABEL_682;
        }
        s = (new StringBuilder(String.valueOf(jsonobject.getString("from_name")))).append(": Image").toString();
_L5:
        textview.setText(s);
_L3:
        if (!db.checkGCMSGIfExist(jsonobject.getString("id")))
        {
            db.addMSGHP(jsonobject.getString("id"), jsonobject.getString("id_from"), jsonobject.getString("from_name"), jsonobject.getString("from_photo"), jsonobject.getString("to_name"), jsonobject.getString("to_name"), jsonobject.getString("to_photo"), jsonobject.getString("message"), jsonobject.getString("ext"), jsonobject.getString("message_type"), "", jsonobject.getString("me"), jsonobject.getString("post_date"), jsonobject.getString("width"), jsonobject.getString("height"));
        }
        listpMessageArrayList.add(listpMessageArrayList.size(), listmodel);
        j++;
          goto _L4
        s = (new StringBuilder(String.valueOf(jsonobject.getString("from_name")))).append(": ").append(jsonobject.getString("message")).toString();
          goto _L5
    }

    private void parseJSONSendMessage(String s)
    {
        JSONObject jsonobject1;
        ListModel listmodel;
        int j;
        try
        {
            JSONObject jsonobject = new JSONObject(s);
            s = jsonobject.getJSONArray("InPonsel");
            top_id = jsonobject.getString("top_id");
            bottom_id = jsonobject.getString("bottom_id");
            chat_avaible = jsonobject.getString("success");
            url_thumb = jsonobject.getString("url_thumb");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return;
        }
        j = 0;
        if (j >= s.length())
        {
            return;
        }
        jsonobject1 = s.getJSONObject(j);
        listmodel = new ListModel();
        listmodel.setId_msg(jsonobject1.getString("id"));
        listmodel.setId_from(jsonobject1.getString("id_from"));
        listmodel.setFrom_name(jsonobject1.getString("from_name"));
        listmodel.setFrom_photo(jsonobject1.getString("from_photo"));
        listmodel.setId_to(jsonobject1.getString("id_to"));
        listmodel.setTo_name(jsonobject1.getString("to_name"));
        listmodel.setTo_photo(jsonobject1.getString("to_photo"));
        listmodel.setLast_message(jsonobject1.getString("message"));
        listmodel.setExt(jsonobject1.getString("ext"));
        listmodel.setKordinat(jsonobject1.getString("ext").substring(jsonobject1.getString("ext").lastIndexOf("Intele%7C") + 1).replace("ntele%7C", ""));
        listmodel.setMessage_type(jsonobject1.getString("message_type"));
        listmodel.setMsg_date(jsonobject1.getString("post_date"));
        listmodel.setMe_message(jsonobject1.getString("me"));
        listmodel.setUrl_thumb(url_thumb);
        listmodel.setImg_height(jsonobject1.getString("height"));
        listmodel.setImg_width(jsonobject1.getString("width"));
        listpMessageArrayList.add(listpMessageArrayList.size(), listmodel);
        j++;
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_63;
        }
    }

    public static int removeDuplicates(ArrayList arraylist)
    {
        int k;
        int l;
        int i1;
        l = arraylist.size();
        i1 = 0;
        k = 0;
_L2:
        if (k >= l - 1)
        {
            return i1;
        }
        int j = k + 1;
        do
        {
label0:
            {
                if (j < l)
                {
                    break label0;
                }
                k++;
            }
            if (true)
            {
                continue;
            }
            if (((ListModel)arraylist.get(j)).equals(arraylist.get(k)))
            {
                i1++;
                arraylist.remove(j);
                j--;
                l--;
            }
            j++;
        } while (true);
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void scrollMyListViewToBottom()
    {
        listMessaging.post(new Runnable() {

            final RoomChatActivity this$0;

            public void run()
            {
                listMessaging.setSelection(chatMsgAdapter.getCount() - 1);
            }

            
            {
                this$0 = RoomChatActivity.this;
                super();
            }
        });
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

    private void showOlderProgress()
    {
        if (layout_header_msg.getVisibility() != 0)
        {
            layout_header_msg.setVisibility(0);
        }
        txt_OlderMessage.setVisibility(8);
    }

    private void showProgressDialog()
    {
label0:
        {
            if (progressbar_middle.getVisibility() != 0)
            {
                if (!chat_avaible.equals("0"))
                {
                    break label0;
                }
                progressbar_middle.setVisibility(0);
                layout_empty.setVisibility(8);
                txt_empty.setText("Belum ada pesan");
            }
            return;
        }
        layout_empty.setVisibility(8);
        txt_empty.setText("Belum ada pesan");
    }

    private void showSmoothProgress()
    {
        if (progbar_send.getVisibility() != 0)
        {
            progbar_send.setVisibility(0);
        }
        btn_send_komen.setEnabled(false);
    }

    private void startCropImage()
    {
        Intent intent = new Intent(this, eu/janmuller/android/simplecropimage/CropImage);
        intent.putExtra("image-path", mFileTemp.getPath());
        intent.putExtra("scale", true);
        intent.putExtra("aspectX", 0);
        intent.putExtra("aspectY", 0);
        startActivityForResult(intent, 3);
    }

    private void starttask()
    {
        if (timer != null)
        {
            timer.cancel();
        }
        timer = new Timer();
        myTimerTask = new MyTimerTask();
        timer.schedule(myTimerTask, 1000L, 5000L);
    }

    private void stopTask()
    {
        if (timer != null)
        {
            timer.cancel();
            timer = null;
        }
    }

    private void takePicture()
    {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        Uri uri;
        if (!"mounted".equals(Environment.getExternalStorageState()))
        {
            break MISSING_BLOCK_LABEL_56;
        }
        uri = Uri.fromFile(mFileTemp);
_L1:
        intent.putExtra("output", uri);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, 2);
        return;
        try
        {
            uri = InternalStorageContentProvider.CONTENT_URI;
        }
        catch (ActivityNotFoundException activitynotfoundexception)
        {
            return;
        }
          goto _L1
    }

    public ArrayList loadInboxDB(String s)
    {
        int j = 0;
        if (!s.equals("older")) goto _L2; else goto _L1
_L1:
        Cursor cursor1;
        Log.e("top_id_msg", top_id_msg);
        layout_header_msg.setVisibility(0);
        txt_OlderMessage.setVisibility(8);
        cursor1 = db.getGCOlderMSGData(id_from, codename, top_id_msg);
_L12:
        boolean flag = cursor1.moveToFirst();
        if (!flag) goto _L4; else goto _L3
_L3:
        int k = j + 1;
        id_msg = cursor1.getString(cursor1.getColumnIndex("id_msg"));
        id_from = EncodeDecodeAES.encrypt(RestClient.pelihara, cursor1.getString(cursor1.getColumnIndex("id_from")));
        from_name = cursor1.getString(cursor1.getColumnIndex("from_name"));
        from_photo = cursor1.getString(cursor1.getColumnIndex("from_photo"));
        codename = cursor1.getString(cursor1.getColumnIndex("id_to"));
        to_name = cursor1.getString(cursor1.getColumnIndex("to_name"));
        to_photo = cursor1.getString(cursor1.getColumnIndex("to_photo"));
        last_message = cursor1.getString(cursor1.getColumnIndex("message"));
        last_message = last_message.replace("null,null ", "");
        last_message = last_message.replace("null,null\n", "");
        msg_ext = cursor1.getString(cursor1.getColumnIndex("ext"));
        msg_kordinat = msg_ext.substring(msg_ext.lastIndexOf("Intele%7C") + 1).replace("ntele%7C", "");
        Log.e("msg_kordinat", msg_kordinat);
        message_type = cursor1.getString(cursor1.getColumnIndex("message_type"));
        me_message = cursor1.getString(cursor1.getColumnIndex("message_me"));
        msg_date = cursor1.getString(cursor1.getColumnIndex("post_date"));
        img_width = cursor1.getString(cursor1.getColumnIndex("img_width"));
        img_height = cursor1.getString(cursor1.getColumnIndex("img_height"));
_L13:
        bottom_id = id_msg;
        Log.e("loadinboxLoop", String.valueOf(k));
        if (!s.equals("older")) goto _L6; else goto _L5
_L5:
        if (k != 20)
        {
            break MISSING_BLOCK_LABEL_479;
        }
        top_id_msg = id_msg;
        top_id = id_msg;
_L15:
        Object obj;
        obj = new ListModel();
        ((ListModel) (obj)).setId_msg(id_msg);
        ((ListModel) (obj)).setId_from(id_from);
        ((ListModel) (obj)).setFrom_name(from_name);
        ((ListModel) (obj)).setFrom_photo(from_photo);
        ((ListModel) (obj)).setId_to(codename);
        ((ListModel) (obj)).setTo_name(to_name);
        ((ListModel) (obj)).setTo_photo(to_photo);
        ((ListModel) (obj)).setLast_message(last_message);
        ((ListModel) (obj)).setExt(msg_ext);
        ((ListModel) (obj)).setKordinat(msg_kordinat);
        ((ListModel) (obj)).setMessage_type(message_type);
        ((ListModel) (obj)).setMe_message(me_message);
        ((ListModel) (obj)).setMsg_date(msg_date);
        ((ListModel) (obj)).setUrl_thumb(Util.BASE_URL_THUMB);
        ((ListModel) (obj)).setImg_width(img_width);
        ((ListModel) (obj)).setImg_height(img_height);
        if (!s.equals("older")) goto _L8; else goto _L7
_L7:
        listInboxDB.add(0, obj);
_L16:
        j = k;
        if (cursor1.moveToNext()) goto _L3; else goto _L9
_L9:
        Log.e("getINBOXData", String.valueOf(listInboxDB.size()));
        Log.e("loadinboxLast", String.valueOf(k));
        if (k != 20) goto _L11; else goto _L10
_L10:
        txt_OlderMessage.setVisibility(0);
        layout_header_msg.setVisibility(8);
_L17:
        listMessaging.setVisibility(0);
_L18:
        Log.e("top_id_msg", top_id_msg);
        db.close();
_L19:
        return listInboxDB;
_L2:
        listInboxDB = new ArrayList();
        cursor1 = db.getGCMSGData(id_from, codename);
          goto _L12
        obj;
        ((Exception) (obj)).printStackTrace();
          goto _L13
_L6:
        if (k != 1) goto _L15; else goto _L14
_L14:
        top_id_msg = id_msg;
        top_id = id_msg;
          goto _L15
_L8:
        listInboxDB.add(obj);
          goto _L16
_L11:
        layout_header_msg.setVisibility(8);
        txt_OlderMessage.setVisibility(8);
          goto _L17
_L4:
        Log.e("getINBOXData", "nol");
          goto _L18
        s;
          goto _L19
    }

    public void onActivityResult(int j, int k, Intent intent)
    {
        if (k == -1) goto _L2; else goto _L1
_L1:
        return;
_L2:
        j;
        JVM INSTR tableswitch 1 3: default 32
    //                   1 40
    //                   2 95
    //                   3 102;
           goto _L3 _L4 _L5 _L6
_L3:
        break; /* Loop/switch isn't completed */
_L6:
        continue; /* Loop/switch isn't completed */
_L7:
        super.onActivityResult(j, k, intent);
        return;
_L4:
        try
        {
            InputStream inputstream = getContentResolver().openInputStream(intent.getData());
            FileOutputStream fileoutputstream = new FileOutputStream(mFileTemp);
            copyStream(inputstream, fileoutputstream);
            fileoutputstream.close();
            inputstream.close();
            startCropImage();
        }
        catch (Exception exception) { }
          goto _L7
_L5:
        startCropImage();
          goto _L7
        if (intent.getStringExtra("image-path") == null) goto _L1; else goto _L8
_L8:
        photo_upload = BitmapFactory.decodeFile(mFileTemp.getPath());
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            (new UploadImage()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new URL[0]);
        } else
        {
            (new UploadImage()).execute(new URL[0]);
        }
          goto _L7
        if (true) goto _L1; else goto _L9
_L9:
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
            stopTask();
            OnlineStatGroup(id_from, codename, "0", t, bottom_id);
            finish();
            overridePendingTransition(0x7f040001, 0x7f040002);
            return;
        }
    }

    public void onClick(View view)
    {
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        mDrawerToggle.onConfigurationChanged(configuration);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300db);
        ponselBaseApp = (PonselBaseApp)getApplication();
        ponselBaseApp.getObserver().addObserver(this);
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            setTranslucentStatus(true);
        }
        bundle = new SystemBarTintManager(this);
        bundle.setStatusBarTintEnabled(true);
        bundle.setStatusBarTintResource(0x7f080160);
        imm = (InputMethodManager)getSystemService("input_method");
        animFadein = AnimationUtils.loadAnimation(getApplicationContext(), 0x7f040009);
        animFadeout = AnimationUtils.loadAnimation(getApplicationContext(), 0x7f04000a);
        layoutInflater = (LayoutInflater)getBaseContext().getSystemService("layout_inflater");
        popupView = layoutInflater.inflate(0x7f03007c, null);
        popupWindow = new PopupWindow(popupView, -1, -1);
        popupWindow.setOutsideTouchable(true);
        popupOutside = (RelativeLayout)popupView.findViewById(0x7f0b0485);
        rl_share_camera = (RelativeLayout)popupView.findViewById(0x7f0b048e);
        rl_share_galleri = (RelativeLayout)popupView.findViewById(0x7f0b0491);
        rl_share_location = (RelativeLayout)popupView.findViewById(0x7f0b0494);
        layout_popup = (LinearLayout)findViewById(0x7f0b06ae);
        popupOutside.setOnClickListener(new android.view.View.OnClickListener() {

            final RoomChatActivity this$0;

            public void onClick(View view)
            {
                popupWindow.dismiss();
            }

            
            {
                this$0 = RoomChatActivity.this;
                super();
            }
        });
        rl_share_camera.setOnClickListener(new android.view.View.OnClickListener() {

            final RoomChatActivity this$0;

            public void onClick(View view)
            {
                popupWindow.dismiss();
                imm = (InputMethodManager)getSystemService("input_method");
                imm.hideSoftInputFromWindow(edt_pop_komen.getWindowToken(), 0);
                mFileTemp = createFolders();
                mFileTemp = getNextFileName();
                takePicture();
            }

            
            {
                this$0 = RoomChatActivity.this;
                super();
            }
        });
        rl_share_location.setOnClickListener(new android.view.View.OnClickListener() {

            final RoomChatActivity this$0;

            public void onClick(View view)
            {
                view = new Intent(getApplicationContext(), com/inponsel/android/v2/RoomShareLocationActivity);
                view.putExtra("id_from", RoomChatActivity.user_id);
                view.putExtra("from_name", RoomChatActivity.username);
                view.putExtra("from_photo", RoomChatActivity.user_photo);
                view.putExtra("to_photo", gambar);
                view.putExtra("merk", merk);
                view.putExtra("model", model);
                view.putExtra("codename", codename);
                view.putExtra("id_hph", id_hp);
                view.putExtra("bottom_id", bottom_id);
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
                popupWindow.dismiss();
            }

            
            {
                this$0 = RoomChatActivity.this;
                super();
            }
        });
        rl_share_galleri.setOnClickListener(new android.view.View.OnClickListener() {

            final RoomChatActivity this$0;

            public void onClick(View view)
            {
                popupWindow.dismiss();
                imm = (InputMethodManager)getSystemService("input_method");
                imm.hideSoftInputFromWindow(edt_pop_komen.getWindowToken(), 0);
                mFileTemp = createFolders();
                mFileTemp = getNextFileName();
                openGallery();
            }

            
            {
                this$0 = RoomChatActivity.this;
                super();
            }
        });
        bundle = getSharedPreferences("notif_count_file", 2).edit();
        bundle.putString("notif_count", "0");
        bundle.putString("notif_id", "0");
        bundle.apply();
        cm = (ConnectivityManager)getSystemService("connectivity");
        netInfo = cm.getActiveNetworkInfo();
        extras = getIntent().getExtras();
        id_msg = extras.getString("");
        from_name = extras.getString("from_name");
        from_photo = extras.getString("from_photo");
        to_photo = extras.getString("to_photo");
        id_hp = extras.getString("id_hph");
        model = extras.getString("model");
        merk = extras.getString("merk");
        namalengkap = (new StringBuilder(String.valueOf(merk))).append(" ").append(model).toString();
        namalengkap = URLDecoder.decode(namalengkap);
        try
        {
            bundle = ((PonselBaseApp)getApplication()).getTracker(com.inponsel.android.adapter.PonselBaseApp.TrackerName.APP_TRACKER);
            bundle.setScreenName((new StringBuilder("Halaman GroupChat ")).append(namalengkap).toString());
            bundle.send((new com.google.android.gms.analytics.HitBuilders.AppViewBuilder()).build());
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        codename = extras.getString("codename").split("-")[1];
        kota = extras.getString("kota");
        kota_id = extras.getString("kota_id");
        prov = extras.getString("prov");
        t = Utility.session(t);
        Log.e("id_to", codename);
        getSherlock().setProgressBarIndeterminateVisibility(true);
        getSherlock().setProgressBarVisibility(true);
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setBackgroundDrawable(getResources().getDrawable(0x7f0200e5));
        bundle = LayoutInflater.from(this).inflate(0x7f03006b, null);
        getSupportActionBar().setCustomView(bundle);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        t = Utility.session(t);
        btn_JoinGroupChat = (Button)bundle.findViewById(0x7f0b03ce);
        btn_JoinGroupChat.setVisibility(8);
        img_user_picture = (ImageView)bundle.findViewById(0x7f0b0418);
        ll_UserBack = (LinearLayout)bundle.findViewById(0x7f0b0417);
        txtUsername = (TextView)bundle.findViewById(0x7f0b0419);
        txtUsername.setSelected(true);
        txtLastSeen = (TextView)bundle.findViewById(0x7f0b041a);
        lay_button_send = (RelativeLayout)findViewById(0x7f0b04dd);
        pop_txtCountKomen = (TextView)findViewById(0x7f0b04df);
        edt_pop_komen = (DroidWriterEditText)findViewById(0x7f0b04de);
        pop_txtCountKomen = (TextView)findViewById(0x7f0b04df);
        btn_send_komen = (Button)findViewById(0x7f0b04e0);
        progbar_send = (SmoothProgressBar)findViewById(0x7f0b06b1);
        progbar_send.setVisibility(8);
        progressbar_item = (ProgressBar)bundle.findViewById(0x7f0b00b3);
        userFunctions = new UserFunctions();
        db = new DatabaseHandler(this);
        imageLoader2 = ImageLoader.getInstance();
        imageLoader2.init(ImageLoaderConfiguration.createDefault(this));
        options = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showImageForEmptyUri(0x7f020297).showImageOnFail(0x7f020297).cacheInMemory(true).imageScaleType(ImageScaleType.EXACTLY).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).build();
        optionsNoRound = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showImageForEmptyUri(0x7f020297).showImageOnFail(0x7f020297).cacheInMemory(true).imageScaleType(ImageScaleType.EXACTLY).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).build();
        imageLoader2.displayImage(to_photo.trim(), img_user_picture, optionsNoRound, animateFirstListener);
        txtUsername.setText(namalengkap);
        layout_empty = (LinearLayout)findViewById(0x7f0b0091);
        progressbar_middle = (ProgressBar)findViewById(0x7f0b00ca);
        txt_empty = (TextView)findViewById(0x7f0b0093);
        listMessaging = (ListView)findViewById(0x7f0b06af);
        bundle = View.inflate(this, 0x7f030069, null);
        txt_OlderMessage = (TextView)bundle.findViewById(0x7f0b0416);
        txt_new_message = (TextView)findViewById(0x7f0b06b0);
        txt_new_message.setVisibility(8);
        txt_new_message.setSelected(true);
        layout_header_msg = (LinearLayout)bundle.findViewById(0x7f0b0413);
        txt_OlderMessage.setVisibility(8);
        layout_header_msg.setVisibility(8);
        listpMessageArrayList = new ArrayList();
        chatMsgAdapter = new ListChatGroupAdapter(this, 0x7f0300bb, listpMessageArrayList);
        listMessaging.addHeaderView(bundle);
        listMessaging.setAdapter(chatMsgAdapter);
        mDrawerLayout = (DrawerLayout)findViewById(0x7f0b0079);
        menu_profil = (RelativeLayout)findViewById(0x7f0b029e);
        listUserJoin = (ListView)findViewById(0x7f0b058c);
        left_drawer = (LinearLayout)findViewById(0x7f0b007b);
        if (Utility.isTablet(getApplicationContext()))
        {
            left_drawer.getLayoutParams().width = (int)(getResources().getDisplayMetrics().density * (float)Util.tabletSize + 0.5F);
        } else
        {
            left_drawer.getLayoutParams().width = (int)(getResources().getDisplayMetrics().density * 270F + 0.5F);
        }
        left_drawer.requestLayout();
        chatArray = new ArrayList();
        userJoinAdapter = new ListSCProvAdapter(this, 0x7f030126, chatArray);
        listUserJoin.setAdapter(userJoinAdapter);
        listUserJoin.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final RoomChatActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int j, long l)
            {
                adapterview = new Intent(RoomChatActivity.this, com/inponsel/android/v2/ProfileOtherUser);
                Log.e("user_name", userJoinAdapter.getListModel(j).getUsername());
                adapterview.putExtra("id_user_view", userJoinAdapter.getListModel(j).getUsername());
                startActivityForResult(adapterview, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = RoomChatActivity.this;
                super();
            }
        });
        btn_send_komen.setEnabled(false);
        edt_pop_komen.addTextChangedListener(new TextWatcher() {

            final RoomChatActivity this$0;

            public void afterTextChanged(Editable editable)
            {
                if (edt_pop_komen.getText().toString().trim().length() == 0)
                {
                    btn_send_komen.setEnabled(false);
                    pop_txtCountKomen.setText("512");
                    return;
                }
                btn_send_komen.setEnabled(true);
                charCount = 512 - edt_pop_komen.getText().toString().length();
                komencount = edt_pop_komen.getText().toString();
                pop_txtCountKomen.setText(String.valueOf(charCount));
                if (charCount < 0)
                {
                    btn_send_komen.setEnabled(false);
                    return;
                }
                if (charCount > 0 && charCount < 4)
                {
                    btn_send_komen.setEnabled(false);
                    return;
                } else
                {
                    btn_send_komen.setEnabled(true);
                    return;
                }
            }

            public void beforeTextChanged(CharSequence charsequence, int j, int k, int l)
            {
                if (edt_pop_komen.getText().toString().trim().length() == 0)
                {
                    btn_send_komen.setEnabled(false);
                    pop_txtCountKomen.setText("512");
                    return;
                }
                btn_send_komen.setEnabled(true);
                charCount = 512 - edt_pop_komen.getText().toString().length();
                komencount = edt_pop_komen.getText().toString();
                pop_txtCountKomen.setText(String.valueOf(charCount));
                if (charCount < 0)
                {
                    btn_send_komen.setEnabled(false);
                    return;
                }
                if (charCount > 0 && charCount < 4)
                {
                    btn_send_komen.setEnabled(false);
                    return;
                } else
                {
                    btn_send_komen.setEnabled(true);
                    return;
                }
            }

            public void onTextChanged(CharSequence charsequence, int j, int k, int l)
            {
                komencount = edt_pop_komen.getText().toString();
                if (edt_pop_komen.getText().toString().trim().length() == 0)
                {
                    btn_send_komen.setEnabled(false);
                    pop_txtCountKomen.setText("512");
                    return;
                }
                btn_send_komen.setEnabled(true);
                charCount = 512 - edt_pop_komen.getText().toString().length();
                pop_txtCountKomen.setText(String.valueOf(charCount));
                if (charCount < 0)
                {
                    btn_send_komen.setEnabled(false);
                    return;
                }
                if (charCount > 0 && charCount < 4)
                {
                    btn_send_komen.setEnabled(false);
                    return;
                } else
                {
                    btn_send_komen.setEnabled(true);
                    return;
                }
            }

            
            {
                this$0 = RoomChatActivity.this;
                super();
            }
        });
        btn_send_komen.setOnClickListener(new android.view.View.OnClickListener() {

            final RoomChatActivity this$0;

            public void onClick(View view)
            {
                try
                {
                    Log.e("id_from", id_from);
                    Log.e("id_to", codename);
                    edt_pop_komen.requestFocus();
                    edt_pop_komen.setFocusable(true);
                    SendMessage(id_from, codename, URLEncoder.encode(edt_pop_komen.getText().toString(), "utf-8"), t, bottom_id);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    view.printStackTrace();
                }
            }

            
            {
                this$0 = RoomChatActivity.this;
                super();
            }
        });
        ll_UserBack.setOnClickListener(new android.view.View.OnClickListener() {

            final RoomChatActivity this$0;

            public void onClick(View view)
            {
            }

            
            {
                this$0 = RoomChatActivity.this;
                super();
            }
        });
        menu_profil.setOnClickListener(this);
        mDrawerLayout.setDrawerListener(new DemoDrawerListener(null));
        mDrawerLayout.setDrawerShadow(0x7f0201a9, 0x800003);
        mActionBar = createActionBarHelper();
        mActionBar.init();
        mDrawerToggle = new SherlockActionBarDrawerToggle(this, mDrawerLayout, 0x7f0201f3, 0x7f0c0082, 0x7f0c0083);
        mDrawerToggle.syncState();
        menu_progressbar_item = (ProgressBar)findViewById(0x7f0b02a0);
        menu_username = (TextView)findViewById(0x7f0b02a2);
        menu_ponsel_pengguna = (TextView)findViewById(0x7f0b02a3);
        menu_ponsel_pengguna.setSelected(true);
        menu_sim_pengguna = (TextView)findViewById(0x7f0b02a4);
        menu_imgProfil = (ImageView)findViewById(0x7f0b02a1);
        menu_imgProfil.setOnLongClickListener(new android.view.View.OnLongClickListener() {

            final RoomChatActivity this$0;

            public boolean onLongClick(View view)
            {
                view = new ArrayList();
                view.add(RoomChatActivity.user_photo.trim());
                view = (String[])view.toArray(new String[view.size()]);
                Intent intent = new Intent(getApplicationContext(), com/inponsel/android/v2/ImagePagerActivity);
                intent.putExtra("imgUrl", view);
                intent.putExtra("pos", 0);
                startActivity(intent);
                return false;
            }

            
            {
                this$0 = RoomChatActivity.this;
                super();
            }
        });
        if (userFunctions.isUserLoggedIn(this))
        {
            cursor = db.getAllData();
            cursor.moveToFirst();
            try
            {
                user_id = EncodeDecodeAES.decrypt(RestClient.pelihara, cursor.getString(1));
                id_from = user_id;
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
            menu_profil.setVisibility(0);
            menu_username.setText((new StringBuilder()).append(username).toString());
            menu_ponsel_pengguna.setText((new StringBuilder()).append(user_ponsel1).toString());
            menu_sim_pengguna.setText((new StringBuilder()).append(user_provider1).toString());
            imageLoader2.displayImage(user_photo.trim(), menu_imgProfil, options, animateFirstListener);
            menu_profil.setVisibility(0);
            menu_profil.setOnClickListener(new android.view.View.OnClickListener() {

                final RoomChatActivity this$0;

                public void onClick(View view)
                {
                    i = new Intent(getApplicationContext(), com/inponsel/android/v2/ProfileActivity);
                    startActivityForResult(i, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$0 = RoomChatActivity.this;
                super();
            }
            });
        } else
        {
            menu_profil.setVisibility(8);
        }
        if (db.getGCMSGCount() > 0)
        {
            listpMessageArrayList = loadInboxDB("last");
            chatMsgAdapter = new ListChatGroupAdapter(this, 0x7f0300bb, listpMessageArrayList);
            listMessaging.setAdapter(chatMsgAdapter);
            scrollMyListViewToBottom();
            hideProgressDialog();
            timer = new Timer();
            myTimerTask = new MyTimerTask();
        }
        scrollMyListViewToBottom();
        txt_OlderMessage.setOnClickListener(new android.view.View.OnClickListener() {

            final RoomChatActivity this$0;

            public void onClick(View view)
            {
                if (netInfo != null && netInfo.isConnected())
                {
                    Log.e("GetOlderMessage", "online");
                    GetOlderMessage(id_from, codename, t, top_id);
                    return;
                } else
                {
                    Log.e("GetOlderMessage", "offline");
                    listpMessageArrayList = loadInboxDB("older");
                    chatMsgAdapter.notifyDataSetChanged();
                    return;
                }
            }

            
            {
                this$0 = RoomChatActivity.this;
                super();
            }
        });
        GetUserOnLine(codename, t);
        listMessaging.setOnScrollListener(new android.widget.AbsListView.OnScrollListener() {

            final RoomChatActivity this$0;

            public void onScroll(AbsListView abslistview, int j, int k, int l)
            {
                if (j + k == l)
                {
                    if (txt_new_message.getVisibility() != 8)
                    {
                        txt_new_message.startAnimation(animFadeout);
                    }
                    txt_new_message.setVisibility(8);
                }
            }

            public void onScrollStateChanged(AbsListView abslistview, int j)
            {
            }

            
            {
                this$0 = RoomChatActivity.this;
                super();
            }
        });
        txt_new_message.setOnClickListener(new android.view.View.OnClickListener() {

            final RoomChatActivity this$0;

            public void onClick(View view)
            {
                scrollMyListViewToBottom();
            }

            
            {
                this$0 = RoomChatActivity.this;
                super();
            }
        });
        btn_JoinGroupChat.setOnClickListener(new android.view.View.OnClickListener() {

            final RoomChatActivity this$0;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(RoomChatActivity.this))
                {
                    if (statJoinChat.equals("1"))
                    {
                        view = new android.app.AlertDialog.Builder(RoomChatActivity.this);
                        view.setMessage("Berhenti ikuti aktivitas chat room?");
                        view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                            final _cls14 this$1;

                            public void onClick(DialogInterface dialoginterface, int j)
                            {
                                dialoginterface.dismiss();
                                statJoinChat = "0";
                                JoinLeaveGroup(RoomChatActivity.user_id, codename, "0", t, bottom_id);
                            }

            
            {
                this$1 = _cls14.this;
                super();
            }
                        });
                        view.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                            final _cls14 this$1;

                            public void onClick(DialogInterface dialoginterface, int j)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$1 = _cls14.this;
                super();
            }
                        });
                        view.show();
                        return;
                    } else
                    {
                        view = new android.app.AlertDialog.Builder(RoomChatActivity.this);
                        view.setMessage("Ikuti aktivitas chat room?");
                        view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                            final _cls14 this$1;

                            public void onClick(DialogInterface dialoginterface, int j)
                            {
                                statJoinChat = "1";
                                JoinLeaveGroup(RoomChatActivity.user_id, codename, "1", t, bottom_id);
                            }

            
            {
                this$1 = _cls14.this;
                super();
            }
                        });
                        view.setNeutralButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                            final _cls14 this$1;

                            public void onClick(DialogInterface dialoginterface, int j)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$1 = _cls14.this;
                super();
            }
                        });
                        view.show();
                        return;
                    }
                } else
                {
                    view = new android.app.AlertDialog.Builder(RoomChatActivity.this);
                    view.setMessage("Untuk berlangganan berita, diharuskan login.");
                    view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                        final _cls14 this$1;

                        public void onClick(DialogInterface dialoginterface, int j)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls14.this;
                super();
            }
                    });
                    view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls14 this$1;

                        public void onClick(DialogInterface dialoginterface, int j)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                            startActivityForResult(dialoginterface, 0);
                            overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls14.this;
                super();
            }
                    });
                    view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls14 this$1;

                        public void onClick(DialogInterface dialoginterface, int j)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            startActivityForResult(dialoginterface, 0);
                            overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls14.this;
                super();
            }
                    });
                    view.show();
                    return;
                }
            }


            
            {
                this$0 = RoomChatActivity.this;
                super();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getSupportMenuInflater().inflate(0x7f0f0007, menu);
        itemTurnNotif = menu.findItem(0x7f0b093c);
        if (statJoinChat.equals("1"))
        {
            itemTurnNotif.setChecked(true);
        } else
        {
            itemTurnNotif.setChecked(false);
        }
        return super.onCreateOptionsMenu(menu);
    }

    protected void onDestroy()
    {
        super.onDestroy();
        stopTask();
    }

    public boolean onKeyDown(int j, KeyEvent keyevent)
    {
        switch (j)
        {
        default:
            return super.onKeyDown(j, keyevent);

        case 82: // 'R'
            break;
        }
        if (mDrawerLayout.isDrawerOpen(0x800003))
        {
            mDrawerLayout.closeDrawers();
        } else
        {
            ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(edt_pop_komen.getWindowToken(), 0);
            mDrawerLayout.openDrawer(0x800003);
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        popupWindow.dismiss();
        switch (menuitem.getItemId())
        {
        default:
            return true;

        case 16908332: 
            mDrawerToggle.onOptionsItemSelected(menuitem);
            imm.hideSoftInputFromWindow(edt_pop_komen.getWindowToken(), 0);
            return true;

        case 2131429689: 
            if (popupWindow.isShowing() || pop_show.equals("1"))
            {
                Log.e("show", "show");
                popupWindow.dismiss();
                pop_show = "0";
                return true;
            } else
            {
                pop_show = "1";
                Log.e("dis", "dis");
                popupWindow.showAsDropDown(layout_popup, 40, -10);
                return true;
            }

        case 2131429691: 
            menuitem = new Intent(getApplicationContext(), com/inponsel/android/v2/RoomInfoChat);
            menuitem.putExtra("id_from", user_id);
            menuitem.putExtra("from_name", username);
            menuitem.putExtra("from_photo", user_photo);
            menuitem.putExtra("to_photo", gambar);
            menuitem.putExtra("merk", merk);
            menuitem.putExtra("model", model);
            menuitem.putExtra("codename", codename);
            menuitem.putExtra("id_hph", id_hp);
            startActivityForResult(menuitem, 0);
            overridePendingTransition(0x7f040003, 0x7f040004);
            finish();
            return true;

        case 2131429692: 
            break;
        }
        if (userFunctions.isUserLoggedIn(this))
        {
            if (statJoinChat.equals("1"))
            {
                menuitem = new android.app.AlertDialog.Builder(this);
                menuitem.setMessage("Berhenti ikuti aktivitas chat room?");
                menuitem.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                    final RoomChatActivity this$0;

                    public void onClick(DialogInterface dialoginterface, int j)
                    {
                        dialoginterface.dismiss();
                        statJoinChat = "0";
                        JoinLeaveGroup(RoomChatActivity.user_id, codename, "0", t, bottom_id);
                    }

            
            {
                this$0 = RoomChatActivity.this;
                super();
            }
                });
                menuitem.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                    final RoomChatActivity this$0;

                    public void onClick(DialogInterface dialoginterface, int j)
                    {
                        dialoginterface.dismiss();
                    }

            
            {
                this$0 = RoomChatActivity.this;
                super();
            }
                });
                menuitem.show();
                return true;
            } else
            {
                menuitem = new android.app.AlertDialog.Builder(this);
                menuitem.setMessage("Ikuti aktivitas chat room?");
                menuitem.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                    final RoomChatActivity this$0;

                    public void onClick(DialogInterface dialoginterface, int j)
                    {
                        statJoinChat = "1";
                        JoinLeaveGroup(RoomChatActivity.user_id, codename, "1", t, bottom_id);
                    }

            
            {
                this$0 = RoomChatActivity.this;
                super();
            }
                });
                menuitem.setNeutralButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                    final RoomChatActivity this$0;

                    public void onClick(DialogInterface dialoginterface, int j)
                    {
                        dialoginterface.dismiss();
                    }

            
            {
                this$0 = RoomChatActivity.this;
                super();
            }
                });
                menuitem.show();
                return true;
            }
        } else
        {
            menuitem = new android.app.AlertDialog.Builder(this);
            menuitem.setMessage("Untuk berlangganan berita, diharuskan login.");
            menuitem.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                final RoomChatActivity this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$0 = RoomChatActivity.this;
                super();
            }
            });
            menuitem.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                final RoomChatActivity this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    dialoginterface = new Intent(RoomChatActivity.this, com/inponsel/android/v2/RegisterActivity);
                    startActivityForResult(dialoginterface, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$0 = RoomChatActivity.this;
                super();
            }
            });
            menuitem.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                final RoomChatActivity this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    dialoginterface = new Intent(RoomChatActivity.this, com/inponsel/android/v2/LoginActivity);
                    dialoginterface.putExtra("activity", "main");
                    startActivityForResult(dialoginterface, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$0 = RoomChatActivity.this;
                super();
            }
            });
            menuitem.show();
            return true;
        }
    }

    protected void onPause()
    {
        super.onPause();
        stopTask();
    }

    protected void onResume()
    {
        super.onResume();
        starttask();
    }

    void parseJSON(String s)
    {
        JSONObject jsonobject;
        jsonobject = new JSONObject(s);
        listpMessageArrayList = new ArrayList();
        s = jsonobject.getJSONArray("InPonsel");
        statJoinChat = jsonobject.getString("gc_status");
        Log.e("statJoinChat", statJoinChat);
        if (!statJoinChat.equals("1")) goto _L2; else goto _L1
_L1:
        itemTurnNotif.setChecked(true);
_L8:
        top_id = jsonobject.getString("top_id");
        bottom_id = jsonobject.getString("bottom_id");
        Log.e("top_id", top_id);
        Log.e("bottom_id", bottom_id);
        chat_avaible = jsonobject.getString("success");
        url_thumb = jsonobject.getString("url_thumb");
        if (jsonobject.getString("success").equals("0")) goto _L4; else goto _L3
_L3:
        int j = 0;
_L6:
        try
        {
            if (j >= s.length())
            {
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return;
        }
          goto _L5
_L2:
        itemTurnNotif.setChecked(false);
        continue; /* Loop/switch isn't completed */
_L5:
        JSONObject jsonobject1 = s.getJSONObject(j);
        ListModel listmodel = new ListModel();
        listmodel.setId_msg(jsonobject1.getString("id"));
        listmodel.setId_from(jsonobject1.getString("id_from"));
        listmodel.setFrom_name(jsonobject1.getString("from_name"));
        listmodel.setFrom_photo(jsonobject1.getString("from_photo"));
        listmodel.setId_to(jsonobject1.getString("id_to"));
        listmodel.setTo_name(jsonobject1.getString("to_name"));
        listmodel.setTo_photo(jsonobject1.getString("to_photo"));
        listmodel.setLast_message(jsonobject1.getString("message"));
        listmodel.setExt(jsonobject1.getString("ext"));
        listmodel.setKordinat(jsonobject1.getString("ext").substring(jsonobject1.getString("ext").lastIndexOf("Intele%7C") + 1).replace("ntele%7C", ""));
        listmodel.setMessage_type(jsonobject1.getString("message_type"));
        listmodel.setMsg_date(jsonobject1.getString("post_date"));
        listmodel.setMe_message(jsonobject1.getString("me"));
        listmodel.setUrl_thumb(url_thumb);
        listmodel.setImg_height(jsonobject1.getString("height"));
        listmodel.setImg_width(jsonobject1.getString("width"));
        if (!db.checkGCMSGIfExist(jsonobject1.getString("id")))
        {
            db.addMSGHP(jsonobject1.getString("id"), jsonobject1.getString("id_from"), jsonobject1.getString("from_name"), jsonobject1.getString("from_photo"), jsonobject1.getString("to_name"), jsonobject1.getString("to_name"), jsonobject1.getString("to_photo"), jsonobject1.getString("message"), jsonobject1.getString("ext"), jsonobject1.getString("message_type"), "", jsonobject1.getString("me"), jsonobject1.getString("post_date"), jsonobject1.getString("width"), jsonobject1.getString("height"));
        }
        listpMessageArrayList.add(listmodel);
        j++;
        if (true) goto _L6; else goto _L4
_L4:
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public void update(Observable observable, Object obj)
    {
        if (ponselBaseApp.getObserver().getLoginStat().equals("1"))
        {
            runOnUiThread(new Runnable() {

                final RoomChatActivity this$0;

                public void run()
                {
                    if (userFunctions.isUserLoggedIn(getApplicationContext()))
                    {
                        cursor = db.getAllData();
                        cursor.moveToFirst();
                        try
                        {
                            RoomChatActivity.user_id = EncodeDecodeAES.decrypt(RestClient.pelihara, cursor.getString(1));
                        }
                        catch (Exception exception) { }
                        RoomChatActivity.nama_asli = cursor.getString(2);
                        RoomChatActivity.user_photo = (new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(cursor.getString(3)).toString();
                        RoomChatActivity.username = cursor.getString(4);
                        RoomChatActivity.email_user = cursor.getString(5);
                        RoomChatActivity.user_ttl = cursor.getString(6);
                        RoomChatActivity.user_provinsi = cursor.getString(7);
                        RoomChatActivity.user_kota = cursor.getString(8);
                        RoomChatActivity.user_jekel = cursor.getString(9);
                        RoomChatActivity.user_ponsel1 = cursor.getString(10);
                        RoomChatActivity.user_ponsel2 = cursor.getString(11);
                        RoomChatActivity.user_provider1 = cursor.getString(12);
                        RoomChatActivity.user_provider2 = cursor.getString(13);
                        RoomChatActivity.user_joindate = cursor.getString(14);
                        RoomChatActivity.user_profile_update = cursor.getString(15);
                        menu_profil.setVisibility(0);
                        menu_username.setText((new StringBuilder()).append(RoomChatActivity.username).toString());
                        menu_ponsel_pengguna.setText((new StringBuilder()).append(RoomChatActivity.user_ponsel1).toString());
                        menu_sim_pengguna.setText((new StringBuilder()).append(RoomChatActivity.user_provider1).toString());
                        imageLoader2.displayImage(RoomChatActivity.user_photo.trim(), menu_imgProfil, options, animateFirstListener);
                        menu_profil.setVisibility(0);
                        return;
                    } else
                    {
                        menu_profil.setVisibility(8);
                        return;
                    }
                }

            
            {
                this$0 = RoomChatActivity.this;
                super();
            }
            });
        }
    }
























}
