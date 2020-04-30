// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.view.ContextThemeWrapper;
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
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;
import com.android.volley.VolleyError;
import com.google.android.gms.analytics.Tracker;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.AnimateFirstDisplayListener;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.MyObjectRequest;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.widget.HorizontalListView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import java.net.URLDecoder;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            ProfileOtherUser, ImagePagerActivity, RegisterActivity, LoginActivity

public class RoomInfoChat extends SherlockFragmentActivity
{
    public class GetSubsStatTask extends AsyncTask
    {

        final RoomInfoChat this$0;

        private void parseJSONSubsNews(String s)
        {
            try
            {
                s = new JSONObject(s);
                gc_status = s.getString("gc_status");
                kota = s.getString("kota");
                kota_id = s.getString("kota_id");
                prov = s.getString("prov_id");
                statJoinChat = s.getString("gc_status");
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
                querySubsStat = (new StringBuilder("idhp=")).append(id_hp).append("&idconv=").append(codename).append("&idusr=").append(user_id).append("&type=").append("all").append("&t=").append(t).toString();
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
            txtBigAnggotaDiKota.setText((new StringBuilder("Anggota di ")).append(kota).toString());
            if (gc_status.equals("1"))
            {
                btn_AktifkanNotifikasi.setBackgroundResource(0x7f02013b);
                btn_AktifkanNotifikasi.setText("Hapus");
                btn_AktifkanNotifikasi.setTextColor(getResources().getColor(0x7f080182));
            } else
            {
                btn_AktifkanNotifikasi.setBackgroundResource(0x7f02013a);
                btn_AktifkanNotifikasi.setText("Ikuti");
                btn_AktifkanNotifikasi.setTextColor(getResources().getColor(0x7f080181));
            }
            GetPeopleList();
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
        }

        public GetSubsStatTask()
        {
            this$0 = RoomInfoChat.this;
            super();
        }
    }

    public class ListAnggotaKotaAdapter extends BaseAdapter
    {

        private Activity activity;
        Context context;
        Cursor cursor;
        DatabaseHandler db;
        String finalUrl;
        ImageLoader imageLoader2;
        private ArrayList lm;
        ListModel lms;
        ProgressDialog mDialog;
        private DisplayImageOptions options;
        int pos;
        String res;
        int resource;
        String response;
        String status;
        final RoomInfoChat this$0;
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

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            pos = i;
            if (view == null)
            {
                view = ((LayoutInflater)activity.getSystemService("layout_inflater")).inflate(resource, null);
                viewgroup = new ViewHolder();
                viewgroup.imageHp = (ImageView)view.findViewById(0x7f0b023d);
                viewgroup.txt_nama = (TextView)view.findViewById(0x7f0b084d);
                viewgroup.txt_username = (TextView)view.findViewById(0x7f0b0373);
                viewgroup.progressbar_item = (ProgressBar)view.findViewById(0x7f0b00b3);
                view.setTag(viewgroup);
            } else
            {
                viewgroup = (ViewHolder)view.getTag();
            }
            lms = (ListModel)lm.get(i);
            if (lm != null)
            {
                ((ViewHolder) (viewgroup)).txt_nama.setText(lms.getRealname());
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

        public ListAnggotaKotaAdapter(Activity activity1, int i, ArrayList arraylist)
        {
            this$0 = RoomInfoChat.this;
            super();
            finalUrl = "";
            lm = arraylist;
            activity = activity1;
            resource = i;
            try
            {
                imageLoader2 = ImageLoader.getInstance();
                imageLoader2.init(ImageLoaderConfiguration.createDefault(activity.getApplicationContext()));
                options = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showImageForEmptyUri(0x7f020297).showImageOnFail(0x7f020297).cacheInMemory(true).imageScaleType(ImageScaleType.EXACTLY).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).build();
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
            catch (RoomInfoChat roominfochat)
            {
                return;
            }
        }
    }

    class ListAnggotaKotaAdapter.ViewHolder
    {

        ImageView imageHp;
        ProgressBar progressbar_item;
        final ListAnggotaKotaAdapter this$1;
        TextView txt_nama;
        TextView txt_username;

        ListAnggotaKotaAdapter.ViewHolder()
        {
            this$1 = ListAnggotaKotaAdapter.this;
            super();
        }
    }

    public class ListMemberRoomAdapter extends BaseAdapter
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
        final RoomInfoChat this$0;
        String user;
        UserFunctions userFunctions;
        String username;

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
            lms = (ListModel)lm.get(i);
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

        public ListMemberRoomAdapter(Activity activity1, int i, ArrayList arraylist)
        {
            this$0 = RoomInfoChat.this;
            super();
            fmt = new DecimalFormat();
            fmts = new DecimalFormatSymbols();
            username = "";
            user = "";
            komen = "";
            email_user = "";
            finalUrl = "";
            lm = arraylist;
            activity = activity1;
            resource = i;
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
                return;
            }
            // Misplaced declaration of an exception variable
            catch (RoomInfoChat roominfochat)
            {
                return;
            }
        }
    }

    class ListMemberRoomAdapter.ViewHolder
    {

        ImageView imageHp;
        ProgressBar progressbar_item;
        RelativeLayout rl_circle;
        RelativeLayout root_people;
        final ListMemberRoomAdapter this$1;
        TextView txt_nama;
        TextView txt_username;

        ListMemberRoomAdapter.ViewHolder()
        {
            this$1 = ListMemberRoomAdapter.this;
            super();
        }
    }

    public class ListSCProvAdapter extends BaseAdapter
    {

        private Activity activity;
        Context context;
        Cursor cursor;
        DatabaseHandler db;
        String finalUrl;
        ImageLoader imageLoader2;
        private ArrayList lm;
        ListModel lms;
        ProgressDialog mDialog;
        private DisplayImageOptions options;
        int pos;
        String res;
        int resource;
        String response;
        String status;
        final RoomInfoChat this$0;
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

        public View getView(int i, View view, ViewGroup viewgroup)
        {
label0:
            {
                pos = i;
                if (view == null)
                {
                    view = ((LayoutInflater)activity.getSystemService("layout_inflater")).inflate(resource, null);
                    viewgroup = new ViewHolder();
                    viewgroup.imgMediaRoom = (ImageView)view.findViewById(0x7f0b0851);
                    viewgroup.txtMediaRoom = (TextView)view.findViewById(0x7f0b0852);
                    view.setTag(viewgroup);
                } else
                {
                    viewgroup = (ViewHolder)view.getTag();
                }
                lms = (ListModel)lm.get(i);
                if (lm != null)
                {
                    Log.e("urlImage", lms.getLast_message());
                    if (!lms.getMessage_type().equals("2"))
                    {
                        break label0;
                    }
                    imageLoader2.displayImage(lms.getExt().trim(), ((ViewHolder) (viewgroup)).imgMediaRoom, options, animateFirstListener);
                }
                return view;
            }
            imageLoader2.displayImage(lms.getLast_message().trim(), ((ViewHolder) (viewgroup)).imgMediaRoom, options, animateFirstListener);
            return view;
        }

        public void setListArray(ArrayList arraylist)
        {
            lm = arraylist;
        }

        public ListSCProvAdapter(Activity activity1, int i, ArrayList arraylist)
        {
            this$0 = RoomInfoChat.this;
            super();
            finalUrl = "";
            lm = arraylist;
            activity = activity1;
            resource = i;
            try
            {
                imageLoader2 = ImageLoader.getInstance();
                imageLoader2.init(ImageLoaderConfiguration.createDefault(activity.getApplicationContext()));
                options = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showImageForEmptyUri(0x7f020297).showImageOnFail(0x7f020297).cacheInMemory(true).cacheOnDisk(true).imageScaleType(ImageScaleType.EXACTLY).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).build();
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
            catch (RoomInfoChat roominfochat)
            {
                return;
            }
        }
    }

    class ListSCProvAdapter.ViewHolder
    {

        ImageView imgMediaRoom;
        ProgressBar progressbar_item;
        final ListSCProvAdapter this$1;
        TextView txtMediaRoom;

        ListSCProvAdapter.ViewHolder()
        {
            this$1 = ListSCProvAdapter.this;
            super();
        }
    }


    ActionBar actionBar;
    int actionBarTitleId;
    ListAnggotaKotaAdapter anggotaKotaAdapter;
    ArrayList anggotaKotaArray;
    private ImageLoadingListener animateFirstListener;
    String bottom_id;
    Button btn_AktifkanNotifikasi;
    String chat_avaible;
    ConnectivityManager cm;
    String codename;
    Cursor cursor;
    DatabaseHandler db;
    String email_user;
    Bundle extras;
    String gambar;
    String gc_status;
    String id_hp;
    String image[];
    ImageLoader imageLoader2;
    ArrayList imgArray;
    String imgUrlFull;
    InputMethodManager imm;
    String kota;
    String kota_id;
    LinearLayout layout_emptyAnggotaDiKota;
    LinearLayout layout_emptyDaftarAnggotaRoom;
    LinearLayout layout_emptyMediaRoom;
    GridView listAnggotaDiKota;
    GridView listDaftarAnggotaRoom;
    HorizontalListView listMediaRoom;
    ArrayList memberRoomArray;
    String member_count;
    String merk;
    String model;
    String nama_asli;
    String namalengkap;
    NetworkInfo netInfo;
    DisplayImageOptions options;
    String people_count;
    ProgressBar progressbar_AnggotaDiKota;
    ProgressBar progressbar_DaftarAnggotaRoom;
    ProgressBar progressbar_MediaRoom;
    String prov;
    String pushURLSubsStat;
    String querySubs;
    String querySubsStat;
    String resSubsStat;
    ListSCProvAdapter scpencarianAdapter;
    ArrayList scpencarianArray;
    String statJoinChat;
    String t;
    String top_id;
    TextView txtBigAnggotaDiKota;
    TextView txtBigTotalAnggotaRoom;
    TextView txt_emptyAnggotaDiKota;
    TextView txt_emptyDaftarAnggotaRoom;
    TextView txt_emptyMediaRoom;
    String urlPenggunaHp;
    String url_thumb;
    private boolean useLogo;
    UserFunctions userFunctions;
    ListMemberRoomAdapter userJoinAdapter;
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
    String username;
    ContextThemeWrapper wrapperLight;

    public RoomInfoChat()
    {
        animateFirstListener = new AnimateFirstDisplayListener();
        useLogo = false;
        actionBarTitleId = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        user_photo = "";
        username = "";
        t = Utility.session(RestClient.pelihara);
        memberRoomArray = null;
        member_count = "";
        statJoinChat = "";
        kota = "";
        kota_id = "";
        prov = "";
        gc_status = "";
        querySubsStat = "";
        pushURLSubsStat = "";
        resSubsStat = "";
        querySubs = "";
        anggotaKotaArray = null;
        people_count = "";
        imgArray = null;
        imgUrlFull = "";
        scpencarianArray = null;
        url_thumb = "";
        chat_avaible = "";
        top_id = "";
        bottom_id = "";
    }

    private void GetMedia(String s, String s1, String s2)
    {
        s = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("info_room_media").append(Utility.BASE_FORMAT).append("?from=").append(s).append("&to=").append(s1).append("&t=").append(s2).toString();
        Log.e("urlConversation", s);
        s = new MyObjectRequest(s, new com.android.volley.Response.Listener() {

            final RoomInfoChat this$0;

            public volatile void onResponse(Object obj)
            {
                onResponse((JSONObject)obj);
            }

            public void onResponse(JSONObject jsonobject)
            {
                parseJSONMedia(jsonobject.toString());
                scpencarianAdapter.notifyDataSetChanged();
                hideProgressDialogMedia();
            }

            
            {
                this$0 = RoomInfoChat.this;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final RoomInfoChat this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
                hideProgressDialogMedia();
            }

            
            {
                this$0 = RoomInfoChat.this;
                super();
            }
        }, "test", "test");
        PonselBaseApp.getInstance().addToRequestQueue(s, "media");
    }

    private void GetPeopleList()
    {
        urlPenggunaHp = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("info_room_kota").append(Utility.BASE_FORMAT).append("?").append("codename=").append(codename).append("&kota=").append(kota_id).append("&prov=").append(prov).append("&t=").append(t).toString();
        Log.e("urlPenggunaAnggota", urlPenggunaHp);
        MyObjectRequest myobjectrequest = new MyObjectRequest(urlPenggunaHp, new com.android.volley.Response.Listener() {

            final RoomInfoChat this$0;

            public volatile void onResponse(Object obj)
            {
                onResponse((JSONObject)obj);
            }

            public void onResponse(JSONObject jsonobject)
            {
                parseJSON(jsonobject.toString());
                anggotaKotaAdapter.setListArray(anggotaKotaArray);
                anggotaKotaAdapter.notifyDataSetChanged();
                hideProgressDialogPenggunaHp();
            }

            
            {
                this$0 = RoomInfoChat.this;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final RoomInfoChat this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
                hideProgressDialogPenggunaHp();
            }

            
            {
                this$0 = RoomInfoChat.this;
                super();
            }
        }, "test", "test");
        PonselBaseApp.getInstance().addToRequestQueue(myobjectrequest, "PenggunaKota");
    }

    private void GetUserOnLine(String s, String s1)
    {
        s = (new StringBuilder(String.valueOf(Util.BASE_PATH_MSG))).append("online_groupchat").append(Utility.BASE_FORMAT).append("?id_conv=").append(s).append("&t=").append(s1).toString();
        Log.e("urlOnline", s);
        s = new MyObjectRequest(s, new com.android.volley.Response.Listener() {

            final RoomInfoChat this$0;

            private void parseJSONUser(String s2)
            {
                JSONObject jsonobject;
                jsonobject = new JSONObject(s2);
                s2 = jsonobject.getJSONArray("InPonsel");
                member_count = jsonobject.getString("success");
                if (jsonobject.getString("success").equals("0")) goto _L2; else goto _L1
_L1:
                int i = 0;
_L5:
                if (i < s2.length()) goto _L3; else goto _L2
_L2:
                userJoinAdapter.notifyDataSetChanged();
                hideProgressDialog();
                return;
_L3:
                try
                {
                    JSONObject jsonobject1 = s2.getJSONObject(i);
                    ListModel listmodel = new ListModel();
                    listmodel.setId_user(jsonobject1.getString("id"));
                    listmodel.setUsername(jsonobject1.getString("user_name"));
                    listmodel.setNama_asli(jsonobject1.getString("nama"));
                    listmodel.setAvatar(jsonobject1.getString("user_photo"));
                    listmodel.setLast_seen(jsonobject1.getString("last_seen"));
                    listmodel.setOnline_stat(jsonobject1.getString("status"));
                    memberRoomArray.add(listmodel);
                }
                // Misplaced declaration of an exception variable
                catch (String s2)
                {
                    s2.printStackTrace();
                    return;
                }
                i++;
                if (true) goto _L5; else goto _L4
_L4:
            }

            public volatile void onResponse(Object obj)
            {
                onResponse((JSONObject)obj);
            }

            public void onResponse(JSONObject jsonobject)
            {
                memberRoomArray.clear();
                parseJSONUser(jsonobject.toString());
                txtBigTotalAnggotaRoom.setText((new StringBuilder("Total Anggota : ")).append(String.valueOf(memberRoomArray.size())).toString());
            }

            
            {
                this$0 = RoomInfoChat.this;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final RoomInfoChat this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
                hideProgressDialog();
            }

            
            {
                this$0 = RoomInfoChat.this;
                super();
            }
        }, "test", "test");
        PonselBaseApp.getInstance().addToRequestQueue(s, "tag_json_obj");
    }

    private void JoinLeaveGroup(String s, String s1, String s2, String s3, String s4)
    {
        Log.e("sendto2", (new StringBuilder("from ")).append(s1).append(" to ").append(codename).toString());
        s = (new StringBuilder(String.valueOf(Util.BASE_PATH_MSG))).append("join_leave_group").append(Utility.BASE_FORMAT).append("?id_user=").append(s).append("&id_hp=").append(id_hp).append("&id_conv=").append(codename).append("&stat=").append(s2).append("&t=").append(s3).toString();
        Log.e("urlJoinGroup", s);
        s = new MyObjectRequest(s, new com.android.volley.Response.Listener() {

            final RoomInfoChat this$0;

            public volatile void onResponse(Object obj)
            {
                onResponse((JSONObject)obj);
            }

            public void onResponse(JSONObject jsonobject)
            {
                Log.e("responseGroup", jsonobject.toString());
                if (jsonobject.toString().trim().equals("{\"response\":1}"))
                {
                    btn_AktifkanNotifikasi.setBackgroundResource(0x7f02013b);
                    btn_AktifkanNotifikasi.setText("Hapus");
                    btn_AktifkanNotifikasi.setTextColor(getResources().getColor(0x7f080182));
                    return;
                } else
                {
                    db.delete_groupchat(codename);
                    btn_AktifkanNotifikasi.setBackgroundResource(0x7f02013a);
                    btn_AktifkanNotifikasi.setText("Ikuti");
                    btn_AktifkanNotifikasi.setTextColor(getResources().getColor(0x7f080181));
                    return;
                }
            }

            
            {
                this$0 = RoomInfoChat.this;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final RoomInfoChat this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
            }

            
            {
                this$0 = RoomInfoChat.this;
                super();
            }
        }, "test", "test");
        PonselBaseApp.getInstance().addToRequestQueue(s, "jobj_req");
    }

    private void hideProgressDialog()
    {
        if (progressbar_DaftarAnggotaRoom.getVisibility() == 0)
        {
            Log.e("member_count", member_count);
            if (member_count.equals("0"))
            {
                layout_emptyDaftarAnggotaRoom.setVisibility(0);
                txt_emptyDaftarAnggotaRoom.setText("Belum ada anggota");
            } else
            {
                layout_emptyDaftarAnggotaRoom.setVisibility(8);
            }
            progressbar_DaftarAnggotaRoom.setVisibility(8);
        }
    }

    private void hideProgressDialogMedia()
    {
        if (progressbar_MediaRoom.getVisibility() == 0)
        {
            if (scpencarianArray.size() == 0)
            {
                layout_emptyMediaRoom.setVisibility(0);
                txt_emptyMediaRoom.setText("Belum ada media");
            } else
            {
                txt_emptyMediaRoom.setVisibility(8);
                layout_emptyMediaRoom.setVisibility(8);
                listMediaRoom.setVisibility(0);
            }
            progressbar_MediaRoom.setVisibility(8);
        }
    }

    private void hideProgressDialogPenggunaHp()
    {
label0:
        {
            if (progressbar_AnggotaDiKota.getVisibility() == 0)
            {
                Log.e("people_count", people_count);
                progressbar_AnggotaDiKota.setVisibility(8);
                if (!people_count.equals("1"))
                {
                    break label0;
                }
                layout_emptyAnggotaDiKota.setVisibility(8);
                txt_emptyAnggotaDiKota.setVisibility(8);
            }
            return;
        }
        layout_emptyAnggotaDiKota.setVisibility(0);
        txt_emptyAnggotaDiKota.setText("Belum ada anggota");
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

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300d8);
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            setTranslucentStatus(true);
        }
        bundle = new SystemBarTintManager(this);
        bundle.setStatusBarTintEnabled(true);
        bundle.setStatusBarTintResource(0x7f080160);
        wrapperLight = new ContextThemeWrapper(this, 0x103006e);
        cm = (ConnectivityManager)getSystemService("connectivity");
        netInfo = cm.getActiveNetworkInfo();
        extras = getIntent().getExtras();
        id_hp = extras.getString("id_hph");
        model = extras.getString("model");
        merk = extras.getString("merk");
        namalengkap = (new StringBuilder(String.valueOf(merk))).append(" ").append(model).toString();
        namalengkap = URLDecoder.decode(namalengkap);
        codename = extras.getString("codename");
        userFunctions = new UserFunctions();
        db = new DatabaseHandler(this);
        imm = (InputMethodManager)getSystemService("input_method");
        cm = (ConnectivityManager)getSystemService("connectivity");
        t = Utility.session(t);
        extras = getIntent().getExtras();
        int i;
        int j;
        try
        {
            bundle = ((PonselBaseApp)getApplication()).getTracker(com.inponsel.android.adapter.PonselBaseApp.TrackerName.APP_TRACKER);
            bundle.setScreenName((new StringBuilder("Info Chat ")).append(namalengkap).toString());
            bundle.send((new com.google.android.gms.analytics.HitBuilders.AppViewBuilder()).build());
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        t = Utility.session(t);
        actionBar = getSupportActionBar();
        actionBar.setDisplayUseLogoEnabled(useLogo);
        actionBar.setBackgroundDrawable(getResources().getDrawable(0x7f0200e5));
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        j = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        i = j;
        if (j == 0)
        {
            i = 0x7f0b0037;
        }
        getSupportActionBar().setTitle(Html.fromHtml((new StringBuilder("<font color='#FFFFFF'>")).append(URLDecoder.decode("Info Chatroom")).append("</font>").toString()));
        bundle = (TextView)findViewById(i);
        bundle.setSelected(true);
        bundle.setTextColor(Color.parseColor("#FFFFFF"));
        bundle.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        imageLoader2 = ImageLoader.getInstance();
        imageLoader2.init(ImageLoaderConfiguration.createDefault(getApplicationContext()));
        options = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showStubImage(0x7f020297).showImageOnLoading(0x7f020209).showImageForEmptyUri(0x7f020297).showImageOnFail(0x7f020297).showImageOnFail(0x7f020209).cacheInMemory(true).imageScaleType(ImageScaleType.EXACTLY_STRETCHED).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).build();
        progressbar_MediaRoom = (ProgressBar)findViewById(0x7f0b069a);
        progressbar_AnggotaDiKota = (ProgressBar)findViewById(0x7f0b06a2);
        progressbar_DaftarAnggotaRoom = (ProgressBar)findViewById(0x7f0b06aa);
        btn_AktifkanNotifikasi = (Button)findViewById(0x7f0b0690);
        txtBigTotalAnggotaRoom = (TextView)findViewById(0x7f0b0694);
        txtBigAnggotaDiKota = (TextView)findViewById(0x7f0b06a0);
        txt_emptyMediaRoom = (TextView)findViewById(0x7f0b069b);
        txt_emptyAnggotaDiKota = (TextView)findViewById(0x7f0b06a3);
        txt_emptyDaftarAnggotaRoom = (TextView)findViewById(0x7f0b06ab);
        listAnggotaDiKota = (GridView)findViewById(0x7f0b06a4);
        listDaftarAnggotaRoom = (GridView)findViewById(0x7f0b06ac);
        layout_emptyDaftarAnggotaRoom = (LinearLayout)findViewById(0x7f0b06a9);
        layout_emptyAnggotaDiKota = (LinearLayout)findViewById(0x7f0b06a1);
        layout_emptyMediaRoom = (LinearLayout)findViewById(0x7f0b06a9);
        memberRoomArray = new ArrayList();
        userJoinAdapter = new ListMemberRoomAdapter(this, 0x7f030126, memberRoomArray);
        listDaftarAnggotaRoom.setAdapter(userJoinAdapter);
        anggotaKotaArray = new ArrayList();
        anggotaKotaAdapter = new ListAnggotaKotaAdapter(this, 0x7f030114, anggotaKotaArray);
        listAnggotaDiKota.setAdapter(anggotaKotaAdapter);
        imgArray = new ArrayList();
        listMediaRoom = (HorizontalListView)findViewById(0x7f0b069c);
        listMediaRoom.setVisibility(8);
        scpencarianArray = new ArrayList();
        scpencarianAdapter = new ListSCProvAdapter(this, 0x7f030123, scpencarianArray);
        listMediaRoom.setAdapter(scpencarianAdapter);
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
            cursor.close();
        }
        listDaftarAnggotaRoom.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final RoomInfoChat this$0;

            public void onItemClick(AdapterView adapterview, View view, int k, long l)
            {
                adapterview = new Intent(RoomInfoChat.this, com/inponsel/android/v2/ProfileOtherUser);
                Log.e("user_name", userJoinAdapter.getListModel(k).getUsername());
                adapterview.putExtra("id_user_view", userJoinAdapter.getListModel(k).getUsername());
                startActivityForResult(adapterview, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = RoomInfoChat.this;
                super();
            }
        });
        listMediaRoom.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final RoomInfoChat this$0;

            public void onItemClick(AdapterView adapterview, View view, int k, long l)
            {
                adapterview = new Intent(RoomInfoChat.this, com/inponsel/android/v2/ImagePagerActivity);
                adapterview.putExtra("imgUrl", image);
                adapterview.putExtra("pos", k);
                startActivity(adapterview);
            }

            
            {
                this$0 = RoomInfoChat.this;
                super();
            }
        });
        GetMedia(user_id, codename, t);
        (new GetSubsStatTask()).execute(new Void[0]);
        GetUserOnLine(codename, t);
        btn_AktifkanNotifikasi.setOnClickListener(new android.view.View.OnClickListener() {

            final RoomInfoChat this$0;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(RoomInfoChat.this))
                {
                    if (statJoinChat.equals("1"))
                    {
                        view = new android.app.AlertDialog.Builder(RoomInfoChat.this);
                        view.setMessage("Berhenti ikuti aktivitas chat room?");
                        view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                            final _cls3 this$1;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                                statJoinChat = "0";
                                JoinLeaveGroup(user_id, codename, "0", t, bottom_id);
                            }

            
            {
                this$1 = _cls3.this;
                super();
            }
                        });
                        view.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                            final _cls3 this$1;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$1 = _cls3.this;
                super();
            }
                        });
                        view.show();
                        return;
                    } else
                    {
                        view = new android.app.AlertDialog.Builder(RoomInfoChat.this);
                        view.setMessage("Ikuti aktivitas chat room?");
                        view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                            final _cls3 this$1;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                statJoinChat = "1";
                                JoinLeaveGroup(user_id, codename, "1", t, bottom_id);
                            }

            
            {
                this$1 = _cls3.this;
                super();
            }
                        });
                        view.setNeutralButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                            final _cls3 this$1;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$1 = _cls3.this;
                super();
            }
                        });
                        view.show();
                        return;
                    }
                } else
                {
                    view = new android.app.AlertDialog.Builder(RoomInfoChat.this);
                    view.setMessage("Untuk berlangganan berita, diharuskan login.");
                    view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                        final _cls3 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls3.this;
                super();
            }
                    });
                    view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls3 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                            startActivityForResult(dialoginterface, 0);
                            overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls3.this;
                super();
            }
                    });
                    view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls3 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            startActivityForResult(dialoginterface, 0);
                            overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls3.this;
                super();
            }
                    });
                    view.show();
                    return;
                }
            }


            
            {
                this$0 = RoomInfoChat.this;
                super();
            }
        });
    }

    public boolean onMenuItemSelected(int i, MenuItem menuitem)
    {
        menuitem.getItemId();
        JVM INSTR tableswitch 16908332 16908332: default 24
    //                   16908332 26;
           goto _L1 _L2
_L1:
        return true;
_L2:
        finish();
        overridePendingTransition(0x7f040001, 0x7f040002);
        if (true) goto _L1; else goto _L3
_L3:
    }

    void parseJSON(String s)
    {
        JSONObject jsonobject = new JSONObject(s);
        s = jsonobject.getJSONArray("InPonsel");
        people_count = jsonobject.getString("success");
        if (jsonobject.getString("success").equals("0"))
        {
            break MISSING_BLOCK_LABEL_161;
        }
        int i = 0;
_L2:
        if (i >= s.length())
        {
            return;
        }
        JSONObject jsonobject1 = s.getJSONObject(i);
        ListModel listmodel = new ListModel();
        listmodel.setId_user(jsonobject1.getString("id_user"));
        listmodel.setUsername(jsonobject1.getString("username"));
        listmodel.setRealname(jsonobject1.getString("realname"));
        listmodel.setKota(jsonobject1.getString("kota"));
        listmodel.setProvinsi(jsonobject1.getString("provinsi"));
        listmodel.setAvatar(jsonobject1.getString("avatar"));
        anggotaKotaArray.add(listmodel);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        s;
        s.printStackTrace();
    }

    void parseJSONMedia(String s)
    {
        JSONObject jsonobject;
        jsonobject = new JSONObject(s);
        s = jsonobject.getJSONArray("InPonsel");
        top_id = jsonobject.getString("top_id");
        bottom_id = jsonobject.getString("bottom_id");
        Log.e("top_id", top_id);
        Log.e("bottom_id", bottom_id);
        chat_avaible = jsonobject.getString("success");
        url_thumb = jsonobject.getString("url_thumb");
        if (jsonobject.getString("success").equals("0")) goto _L2; else goto _L1
_L1:
        int i = 0;
_L8:
        if (i >= s.length())
        {
            return;
        }
        ListModel listmodel;
        jsonobject = s.getJSONObject(i);
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
        if (!jsonobject.getString("message_type").equals("2")) goto _L4; else goto _L3
_L3:
        imgUrlFull = jsonobject.getString("ext");
_L6:
        imgArray.add(imgUrlFull);
        image = new String[imgArray.size()];
        image = (String[])imgArray.toArray(image);
        scpencarianArray.add(listmodel);
        i++;
        continue; /* Loop/switch isn't completed */
_L4:
        if (!jsonobject.getString("message_type").equals("1")) goto _L6; else goto _L5
_L5:
        imgUrlFull = jsonobject.getString("message");
          goto _L6
        s;
        s.printStackTrace();
_L2:
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }






}
