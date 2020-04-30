// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Environment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.conversation.ConversationDetailActivity;
import com.inponsel.android.details.KomentarTwitter;
import com.inponsel.android.rssfeeddetail.RSSDetailTab;
import com.inponsel.android.scdetail.SCDetailPager;
import com.inponsel.android.timelinedetail.Hal1TLDetailActivity;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.widget.ExpandableHeightListView2;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            KomentarPonsel

public class NotificationCenterActivity extends SherlockFragmentActivity
{
    public class ListSelengkapAdapter extends BaseAdapter
    {

        private Activity activity;
        Context context;
        Cursor cursor;
        DatabaseHandler db;
        String email_user;
        String finalUrl;
        String komen;
        private ArrayList lm;
        ListModel lms;
        int pos;
        String res;
        int resource;
        String response;
        String t;
        final NotificationCenterActivity this$0;
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

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            pos = i;
            viewgroup = (LayoutInflater)activity.getSystemService("layout_inflater");
            if (view == null)
            {
                view = viewgroup.inflate(resource, null);
                viewgroup = new ViewHolder();
                viewgroup.imgAvatar = (ImageView)view.findViewById(0x7f0b06b9);
                viewgroup.imgAvatarlIKE = (ImageView)view.findViewById(0x7f0b0854);
                viewgroup.txtNotificationMsg = (TextView)view.findViewById(0x7f0b0855);
                viewgroup.txtNotificationDate = (TextView)view.findViewById(0x7f0b0856);
                viewgroup.progressbar_item = (ProgressBar)view.findViewById(0x7f0b00b3);
                viewgroup.rl_root_notif = (RelativeLayout)view.findViewById(0x7f0b0853);
                view.setTag(viewgroup);
            } else
            {
                viewgroup = (ViewHolder)view.getTag();
            }
            lms = (ListModel)lm.get(i);
            Log.e("getAvatar", lms.getAvatar());
            if (lms.getNotif_isnew().equals("1"))
            {
                ((ViewHolder) (viewgroup)).rl_root_notif.setBackgroundColor(getResources().getColor(0x7f080179));
            }
            ((ViewHolder) (viewgroup)).txtNotificationDate.setText(lms.getNotif_time());
            if (!lms.getActv_type().equals("like")) goto _L2; else goto _L1
_L1:
            if (lms.getActv_content_type_id().equals("1"))
            {
                ((ViewHolder) (viewgroup)).txtNotificationMsg.setText(Html.fromHtml((new StringBuilder("Seseorang menyukai komentar Anda pada spesifikasi <b>")).append(lms.getMerk()).append(" ").append(lms.getModel()).append("</b>").toString()));
            } else
            if (lms.getActv_content_type_id().equals("2"))
            {
                ((ViewHolder) (viewgroup)).txtNotificationMsg.setText(Html.fromHtml((new StringBuilder("Seseorang menyukai komentar Anda pada berita <b>")).append(lms.getMerk()).append("</b>").toString()));
            } else
            if (lms.getActv_content_type_id().equals("4"))
            {
                ((ViewHolder) (viewgroup)).txtNotificationMsg.setText(Html.fromHtml((new StringBuilder("Seseorang menyukai komentar Anda pada tweet <b>")).append(lms.getMerk()).append("</b>").toString()));
            } else
            if (lms.getActv_content_type_id().equals("5"))
            {
                ((ViewHolder) (viewgroup)).txtNotificationMsg.setText(Html.fromHtml((new StringBuilder("Seseorang menyukai komentar Anda pada artikel <b>")).append(lms.getMerk()).append("</b>").toString()));
            } else
            if (lms.getActv_content_type_id().equals("6"))
            {
                if (lms.getType().toLowerCase().equals("conversation"))
                {
                    ((ViewHolder) (viewgroup)).txtNotificationMsg.setText(Html.fromHtml((new StringBuilder("Seseorang menyukai conversation Anda pada <b>")).append(lms.getMerk()).append("</b>").toString()));
                } else
                {
                    ((ViewHolder) (viewgroup)).txtNotificationMsg.setText(Html.fromHtml((new StringBuilder("Seseorang menyukai artikel Anda pada <b>")).append(lms.getMerk()).append("</b>").toString()));
                }
            } else
            {
                ((ViewHolder) (viewgroup)).txtNotificationMsg.setText(Html.fromHtml((new StringBuilder("Seseorang menyukai komentar Anda pada <b>")).append(lms.getMerk()).append("</b>").toString()));
            }
_L4:
            Picasso.with(NotificationCenterActivity.this).load(lms.getAvatar()).into(((ViewHolder) (viewgroup)).imgAvatar, viewgroup. new Callback() {

                final ListSelengkapAdapter this$1;
                private final ListSelengkapAdapter.ViewHolder val$holder;

                public void onError()
                {
                    holder.progressbar_item.setVisibility(8);
                    holder.imgAvatar.setVisibility(0);
                }

                public void onSuccess()
                {
                    holder.progressbar_item.setVisibility(8);
                    holder.imgAvatar.setVisibility(0);
                }

            
            {
                this$1 = final_listselengkapadapter;
                holder = ListSelengkapAdapter.ViewHolder.this;
                super();
            }
            });
            return view;
_L2:
            if (lms.getActv_type().equals("reply"))
            {
                if (lms.getActv_content_type_id().equals("1"))
                {
                    ((ViewHolder) (viewgroup)).txtNotificationMsg.setText(Html.fromHtml((new StringBuilder("<b>")).append(lms.getUsername()).append("</b> membalas komentar anda pada spesifikasi <b>").append(lms.getMerk()).append(" ").append(lms.getModel()).append("</b>").toString()));
                } else
                if (lms.getActv_content_type_id().equals("2"))
                {
                    ((ViewHolder) (viewgroup)).txtNotificationMsg.setText(Html.fromHtml((new StringBuilder("<b>")).append(lms.getUsername()).append("</b> membalas komentar anda pada berita <b>").append(lms.getMerk()).append("</b>").toString()));
                } else
                if (lms.getActv_content_type_id().equals("4"))
                {
                    ((ViewHolder) (viewgroup)).txtNotificationMsg.setText(Html.fromHtml((new StringBuilder("<b>")).append(lms.getUsername()).append("</b> membalas komentar anda pada tweet <b>").append(lms.getMerk()).append("</b>").toString()));
                } else
                if (lms.getActv_content_type_id().equals("5"))
                {
                    if (lms.getType().toLowerCase().equals("conversation"))
                    {
                        ((ViewHolder) (viewgroup)).txtNotificationMsg.setText(Html.fromHtml((new StringBuilder("<b>")).append(lms.getUsername()).append("</b> membalas komentar anda pada conversation <b>").append(lms.getMerk()).append("</b>").toString()));
                    } else
                    {
                        ((ViewHolder) (viewgroup)).txtNotificationMsg.setText(Html.fromHtml((new StringBuilder("<b>")).append(lms.getUsername()).append("</b> membalas komentar anda pada artikel <b>").append(lms.getMerk()).append("</b>").toString()));
                    }
                } else
                {
                    ((ViewHolder) (viewgroup)).txtNotificationMsg.setText(Html.fromHtml((new StringBuilder("<b>")).append(lms.getUsername()).append("</b> membalas komentar anda pada <b>").append(lms.getMerk()).append("</b>").toString()));
                }
            } else
            if (lms.getActv_type().equals("comment"))
            {
                if (lms.getActv_content_type_id().equals("1"))
                {
                    ((ViewHolder) (viewgroup)).txtNotificationMsg.setText(Html.fromHtml((new StringBuilder("<b>")).append(lms.getUsername()).append("</b> mengomentari spesifikasi <b>").append(lms.getMerk()).append(" ").append(lms.getModel()).append("</b>").toString()));
                } else
                if (lms.getActv_content_type_id().equals("3"))
                {
                    ((ViewHolder) (viewgroup)).txtNotificationMsg.setText(Html.fromHtml((new StringBuilder("<b>")).append(lms.getUsername()).append("</b> mengomentari berita <b>").append(lms.getMerk()).append("</b>").toString()));
                } else
                if (lms.getActv_content_type_id().equals("4"))
                {
                    ((ViewHolder) (viewgroup)).txtNotificationMsg.setText(Html.fromHtml((new StringBuilder("<b>")).append(lms.getUsername()).append("</b> mengomentari tweet <b>").append(lms.getMerk()).append("</b>").toString()));
                } else
                if (lms.getActv_content_type_id().equals("5"))
                {
                    if (lms.getType().toLowerCase().equals("conversation"))
                    {
                        ((ViewHolder) (viewgroup)).txtNotificationMsg.setText(Html.fromHtml((new StringBuilder("<b>")).append(lms.getUsername()).append("</b> mengomentari conversation <b>").append(lms.getMerk()).append("</b>").toString()));
                    } else
                    {
                        ((ViewHolder) (viewgroup)).txtNotificationMsg.setText(Html.fromHtml((new StringBuilder("<b>")).append(lms.getUsername()).append("</b> mengomentari artikel <b>").append(lms.getMerk()).append("</b>").toString()));
                    }
                } else
                {
                    ((ViewHolder) (viewgroup)).txtNotificationMsg.setText(Html.fromHtml((new StringBuilder("<b>")).append(lms.getUsername()).append("</b> mengomentari <b>").append(lms.getMerk()).append("</b>").toString()));
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        void log(String s)
        {
        }

        public void setListArray(ArrayList arraylist)
        {
            lm = arraylist;
        }

        public ListSelengkapAdapter(Activity activity1, int i, ArrayList arraylist)
        {
            this$0 = NotificationCenterActivity.this;
            super();
            t = Utility.session(RestClient.pelihara);
            user = "";
            komen = "";
            email_user = "";
            finalUrl = "";
            t = Utility.session(t);
            lm = arraylist;
            activity = activity1;
            resource = i;
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
            catch (NotificationCenterActivity notificationcenteractivity)
            {
                return;
            }
        }
    }

    class ListSelengkapAdapter.ViewHolder
    {

        ImageView imgAvatar;
        ImageView imgAvatarlIKE;
        ProgressBar progressbar_item;
        RelativeLayout rl_root_notif;
        final ListSelengkapAdapter this$1;
        TextView txtNotificationDate;
        TextView txtNotificationMsg;

        ListSelengkapAdapter.ViewHolder()
        {
            this$1 = ListSelengkapAdapter.this;
            super();
        }
    }


    protected ActionBar actionBar;
    int actionBarTitleId;
    String actv_content_type;
    String actv_content_type_id;
    String actv_type;
    String avatar;
    private BufferedReader breader;
    ConnectivityManager cm;
    String codename;
    protected Cursor cursor;
    protected DatabaseHandler db;
    protected String email_user;
    public ArrayList hpMoreArray;
    String id_hp;
    String key;
    LinearLayout layout_empty;
    ExpandableHeightListView2 listNotifikasi;
    String merk;
    String model;
    protected String nama_asli;
    String notif_msg;
    String notif_time;
    ProgressBar progressbar_middle;
    String rss_id;
    String rss_title;
    String sc_additional_info;
    String sc_address;
    String sc_alamat;
    String sc_call_center;
    String sc_channels;
    String sc_email;
    String sc_facebook;
    String sc_facebook_id;
    String sc_kota;
    String sc_logo;
    String sc_phone;
    String sc_phone_info;
    String sc_prov;
    String sc_twitter;
    String sc_url;
    String sc_youtube;
    public ListSelengkapAdapter selengkapAdapter;
    String t;
    String tw_avatar;
    String tw_content;
    String tw_id;
    String tw_media_url;
    String tw_real_name;
    String tw_screen_name;
    String tw_time;
    TextView txt_empty;
    String type_artikel;
    String url_notif;
    protected boolean useLogo;
    protected UserFunctions userFunctions;
    protected String user_id;
    protected String user_jekel;
    protected String user_joindate;
    protected String user_kecamatan;
    protected String user_kota;
    String user_name;
    protected String user_photo;
    protected String user_ponsel1;
    protected String user_ponsel2;
    protected String user_profile_update;
    protected String user_provider1;
    protected String user_provider2;
    protected String user_provinsi;
    protected String user_ttl;
    protected String username;

    public NotificationCenterActivity()
    {
        hpMoreArray = null;
        url_notif = "";
        useLogo = false;
        actionBarTitleId = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        t = Utility.session(RestClient.pelihara);
        user_photo = "";
        username = "";
        type_artikel = "";
    }

    private void loadFromNetwork()
    {
        AsyncHttpClient asynchttpclient = new AsyncHttpClient();
        asynchttpclient.setMaxRetriesAndTimeout(5, 30000);
        asynchttpclient.get(url_notif, new AsyncHttpResponseHandler() {

            final NotificationCenterActivity this$0;

            public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
            {
                progressbar_middle.setVisibility(8);
                txt_empty.setText("Gagal terhubung ke server");
            }

            public void onRetry(int i)
            {
            }

            public void onStart()
            {
            }

            public void onSuccess(int i, Header aheader[], byte abyte0[])
            {
                aheader = new String(abyte0);
                try
                {
                    hpMoreArray.clear();
                    saveJson("343212312", aheader);
                }
                // Misplaced declaration of an exception variable
                catch (byte abyte0[])
                {
                    abyte0.printStackTrace();
                }
                loadJSONData(aheader);
            }

            
            {
                this$0 = NotificationCenterActivity.this;
                super();
            }
        });
    }

    private void loadJSONData(String s)
    {
        ListModel listmodel;
        JSONObject jsonobject;
        final JSONArray data;
        int i;
        try
        {
            data = (new JSONObject(s)).getJSONObject("InPonsel").getJSONArray("data");
            Log.e("jsonLenght2", String.valueOf(data.length()));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            progressbar_middle.setVisibility(8);
            txt_empty.setText("Gagal terhubung ke server");
            return;
        }
        i = 0;
        if (i >= data.length())
        {
            runOnUiThread(new Runnable() {

                final NotificationCenterActivity this$0;
                private final JSONArray val$data;

                public void run()
                {
                    if (data.length() == 0)
                    {
                        progressbar_middle.setVisibility(8);
                        txt_empty.setText("Belum ada notifikasi");
                        return;
                    } else
                    {
                        listNotifikasi.setVisibility(0);
                        layout_empty.setVisibility(8);
                        selengkapAdapter.notifyDataSetChanged();
                        return;
                    }
                }

            
            {
                this$0 = NotificationCenterActivity.this;
                data = jsonarray;
                super();
            }
            });
            return;
        }
        listmodel = new ListModel();
        jsonobject = data.getJSONObject(i);
        listmodel.setNotif_isnew(jsonobject.getString("is_new"));
        actv_type = jsonobject.getString("actv_type");
        actv_content_type = jsonobject.getString("actv_content_type");
        actv_content_type_id = jsonobject.getString("actv_content_type_id");
        if (!actv_content_type_id.equals("1")) goto _L2; else goto _L1
_L1:
        user_name = jsonobject.getJSONObject("user").getString("username");
        avatar = jsonobject.getJSONObject("user").getString("avatar");
        id_hp = jsonobject.getJSONObject("content_parent").getString("handphone_id");
        merk = jsonobject.getJSONObject("content_parent").getString("vendor_name");
        model = jsonobject.getJSONObject("content_parent").getString("model");
        codename = jsonobject.getJSONObject("content_parent").getString("codename");
        listmodel.setId_hp(id_hp);
        listmodel.setMerk(merk);
        listmodel.setModel(model);
        listmodel.setCodename(codename);
_L5:
        if (!actv_content_type_id.equals("6"))
        {
            notif_msg = jsonobject.getJSONObject("content_detail").getString("comments");
        }
        notif_time = jsonobject.getString("time");
        notif_time = Utility.convertDateUnix(notif_time);
        listmodel.setUsername(user_name);
        if (!actv_type.equals("like")) goto _L4; else goto _L3
_L3:
        listmodel.setAvatar("http://static.inponsel.co.id/images/avatar/ic_thumb_up.png");
_L44:
        listmodel.setActv_type(actv_type);
        listmodel.setActv_content_type(actv_content_type);
        listmodel.setActv_content_type_id(actv_content_type_id);
        listmodel.setNotif_message(notif_msg);
        listmodel.setNotif_time(notif_time);
        hpMoreArray.add(listmodel);
        i++;
        break MISSING_BLOCK_LABEL_34;
_L2:
label0:
        {
            if (!actv_content_type_id.equals("2"))
            {
                break label0;
            }
            user_name = jsonobject.getJSONObject("user").getString("username");
            avatar = jsonobject.getJSONObject("user").getString("avatar");
            rss_id = jsonobject.getJSONObject("content_parent").getString("rss_id");
            rss_title = jsonobject.getJSONObject("content_parent").getString("title");
            listmodel.setId_hp(rss_id);
            listmodel.setMerk(rss_title);
        }
          goto _L5
        if (!actv_content_type_id.equals("3"))
        {
            break MISSING_BLOCK_LABEL_1514;
        }
        user_name = jsonobject.getJSONObject("user").getString("username");
        avatar = jsonobject.getJSONObject("user").getString("avatar");
        rss_id = jsonobject.getJSONObject("content_parent").getString("servicenter_id");
        rss_title = (new StringBuilder(String.valueOf(jsonobject.getJSONObject("content_parent").getString("name")))).append(", ").append(jsonobject.getJSONObject("content_parent").getString("city")).toString();
        sc_url = jsonobject.getJSONObject("content_parent").getString("url");
        sc_additional_info = jsonobject.getJSONObject("content_parent").getString("additional_info");
        sc_address = jsonobject.getJSONObject("content_parent").getString("address");
        sc_phone = jsonobject.getJSONObject("content_parent").getString("phone");
        sc_phone_info = jsonobject.getJSONObject("content_parent").getString("phone_info");
        sc_call_center = jsonobject.getJSONObject("content_parent").getString("call_center");
        sc_email = jsonobject.getJSONObject("content_parent").getString("email");
        sc_channels = jsonobject.getJSONObject("content_parent").getJSONObject("vendor").getJSONObject("socials").getString("channels");
        sc_facebook = jsonobject.getJSONObject("content_parent").getJSONObject("vendor").getJSONObject("socials").getString("facebook");
        sc_facebook_id = jsonobject.getJSONObject("content_parent").getJSONObject("vendor").getJSONObject("socials").getString("facebook_id");
        sc_twitter = jsonobject.getJSONObject("content_parent").getJSONObject("vendor").getJSONObject("socials").getString("twitter");
        sc_youtube = jsonobject.getJSONObject("content_parent").getJSONObject("vendor").getJSONObject("socials").getString("youtube");
        sc_logo = jsonobject.getJSONObject("content_parent").getJSONObject("vendor").getString("image");
        sc_prov = jsonobject.getJSONObject("content_parent").getString("province");
        sc_kota = jsonobject.getJSONObject("content_parent").getString("city");
        sc_alamat = jsonobject.getJSONObject("content_parent").getString("address");
        listmodel.setId_hp(rss_id);
        listmodel.setMerk(rss_title);
        listmodel.setId_sc(rss_id);
        listmodel.setSc_nama(jsonobject.getJSONObject("content_parent").getString("name"));
        listmodel.setSc_merk(jsonobject.getJSONObject("content_parent").getJSONObject("vendor").getString("name"));
        if (!sc_facebook.equals("null")) goto _L7; else goto _L6
_L6:
        s = "Tidak ada informasi";
_L28:
        listmodel.setSc_fb(s);
        if (!sc_youtube.equals("null")) goto _L9; else goto _L8
_L8:
        s = "Tidak ada informasi";
_L29:
        listmodel.setSc_ytube(s);
        if (!sc_facebook_id.equals("null")) goto _L11; else goto _L10
_L10:
        s = "";
_L30:
        listmodel.setSc_fb_id(s);
        if (!sc_twitter.equals("null")) goto _L13; else goto _L12
_L12:
        s = "Tidak ada informasi";
_L31:
        listmodel.setSc_tw(s);
        listmodel.setSc_logo(sc_logo);
        if (!sc_additional_info.equals("null")) goto _L15; else goto _L14
_L14:
        s = "Tidak ada informasi";
_L32:
        listmodel.setSc_ket_tambahan(s);
        listmodel.setSc_provinsi(sc_prov);
        listmodel.setSc_kota(sc_kota);
        if (!sc_alamat.equals("null")) goto _L17; else goto _L16
_L16:
        s = "Tidak ada informasi";
_L33:
        listmodel.setSc_alamat(s);
        if (!sc_phone.equals("null")) goto _L19; else goto _L18
_L18:
        s = "Tidak ada informasi";
_L34:
        listmodel.setSc_no_telp(s);
        if (!sc_phone_info.equals("null")) goto _L21; else goto _L20
_L20:
        s = "Tidak ada informasi";
_L35:
        listmodel.setSc_no_telp_ket(s);
        if (!sc_call_center.equals("null")) goto _L23; else goto _L22
_L22:
        s = "Tidak ada informasi";
_L36:
        listmodel.setSc_c_center(s);
        if (!sc_call_center.equals("null")) goto _L25; else goto _L24
_L24:
        s = "Tidak ada informasi";
_L37:
        listmodel.setSc_ven_center(s);
        if (!sc_email.equals("null")) goto _L27; else goto _L26
_L26:
        s = "Tidak ada informasi";
_L38:
        listmodel.setSc_email(s);
        if (!sc_url.equals("null"))
        {
            break MISSING_BLOCK_LABEL_1506;
        }
        s = "Tidak ada informasi";
_L39:
        listmodel.setSc_web_url(s);
        listmodel.setSc_rate("0");
        listmodel.setSc_rate5("0");
        listmodel.setSc_rate4("0");
        listmodel.setSc_rate3("0");
        listmodel.setSc_rate2("0");
        listmodel.setSc_rate1("0");
        listmodel.setSc_total_rate("0");
          goto _L5
_L7:
        s = sc_facebook;
          goto _L28
_L9:
        s = sc_youtube;
          goto _L29
_L11:
        s = sc_facebook_id;
          goto _L30
_L13:
        s = sc_twitter;
          goto _L31
_L15:
        s = sc_additional_info;
          goto _L32
_L17:
        s = sc_alamat;
          goto _L33
_L19:
        s = sc_phone;
          goto _L34
_L21:
        s = sc_phone_info;
          goto _L35
_L23:
        s = sc_call_center;
          goto _L36
_L25:
        s = sc_call_center;
          goto _L37
_L27:
        s = sc_email;
          goto _L38
        s = sc_url;
          goto _L39
        if (!actv_content_type_id.equals("4"))
        {
            break MISSING_BLOCK_LABEL_1777;
        }
        user_name = jsonobject.getJSONObject("user").getString("username");
        avatar = jsonobject.getJSONObject("user").getString("avatar");
        tw_screen_name = jsonobject.getJSONObject("content_parent").getString("screen_name");
        tw_media_url = jsonobject.getJSONObject("content_parent").getString("media_url");
        tw_avatar = jsonobject.getJSONObject("content_parent").getString("avatar");
        tw_real_name = jsonobject.getJSONObject("content_parent").getString("real_name");
        tw_time = jsonobject.getJSONObject("content_parent").getString("tweet_time");
        tw_id = jsonobject.getJSONObject("content_parent").getString("str_id");
        tw_content = jsonobject.getJSONObject("content_parent").getString("tweet_content");
        listmodel.setId_hp(tw_id);
        listmodel.setMerk(tw_content);
        listmodel.setTweet_content(tw_content);
        if (!tw_media_url.equals("null"))
        {
            break MISSING_BLOCK_LABEL_1769;
        }
        s = "";
_L40:
        listmodel.setMedia_urltw(s);
        listmodel.setAvatartw(tw_avatar);
        listmodel.setTweet_time(tw_time);
        listmodel.setReal_nametw(tw_real_name);
        listmodel.setScreen_nametw(tw_screen_name);
          goto _L5
        s = tw_media_url;
          goto _L40
        if (!actv_content_type_id.equals("5")) goto _L42; else goto _L41
_L41:
        user_name = jsonobject.getJSONObject("user").getString("username");
        avatar = jsonobject.getJSONObject("user").getString("avatar");
        rss_id = jsonobject.getJSONObject("content_parent").getString("id");
        rss_title = jsonobject.getJSONObject("content_parent").getString("title");
        type_artikel = jsonobject.getJSONObject("content_parent").getString("type");
        listmodel.setType(type_artikel);
        listmodel.setCodename("");
        listmodel.setId_hp(rss_id);
        listmodel.setMerk(rss_title);
          goto _L5
_L42:
        if (!actv_content_type_id.equals("6")) goto _L5; else goto _L43
_L43:
        user_name = jsonobject.getJSONObject("user").getString("username");
        avatar = jsonobject.getJSONObject("user").getString("avatar");
        rss_id = jsonobject.getJSONObject("content_parent").getString("id");
        rss_title = jsonobject.getJSONObject("content_parent").getString("title");
        type_artikel = jsonobject.getJSONObject("content_parent").getString("type");
        listmodel.setType(type_artikel);
        listmodel.setCodename("");
        listmodel.setId_hp(rss_id);
        listmodel.setMerk(rss_title);
          goto _L5
_L4:
        if (!avatar.equals("null"))
        {
            break MISSING_BLOCK_LABEL_2072;
        }
        s = "http://static.inponsel.co.id/images/avatar/noavatar.png";
_L45:
        listmodel.setAvatar(s);
          goto _L44
        s = avatar;
          goto _L45
    }

    private void loadOfflineFirst()
    {
        try
        {
            loadJSONData(getJSONFile("343212312"));
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    private void saveJson(String s, String s1)
        throws Exception
    {
        Object obj = new File((new StringBuilder("/sdcard/Android/data/")).append(getPackageName()).toString());
        if (((File) (obj)).isDirectory())
        {
            ((File) (obj)).mkdir();
            obj = new File((new StringBuilder("/sdcard/Android/data/")).append(getPackageName()).append("/cache").toString());
            if (((File) (obj)).isDirectory())
            {
                ((File) (obj)).mkdir();
            }
        }
        s = new File((new StringBuilder("/sdcard/Android/data/")).append(getPackageName()).append("/cache/").append(s).toString());
        s.createNewFile();
        s = new FileOutputStream(s);
        obj = new OutputStreamWriter(s);
        EncodeDecodeAES.encrypt(RestClient.pelihara, s1);
        ((OutputStreamWriter) (obj)).append(EncodeDecodeAES.encrypt(RestClient.pelihara, s1));
        ((OutputStreamWriter) (obj)).close();
        s.close();
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

    public boolean fileExist(String s)
    {
        return (new File((new StringBuilder("/sdcard/Android/data/")).append(getPackageName()).append("/cache/").append(s).toString())).exists();
    }

    public String getJSONFile(String s)
        throws Exception
    {
        File file = new File(Environment.getExternalStorageDirectory(), (new StringBuilder("/Android/data/")).append(getPackageName()).append("/cache/").append(s).toString());
        s = new StringBuilder();
        breader = new BufferedReader(new FileReader(file));
        do
        {
            String s1 = breader.readLine();
            if (s1 == null)
            {
                return EncodeDecodeAES.decrypt(RestClient.pelihara, String.valueOf(s));
            }
            s.append(s1);
            s.append('\n');
        } while (true);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300ec);
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            setTranslucentStatus(true);
        }
        bundle = new SystemBarTintManager(this);
        bundle.setStatusBarTintEnabled(true);
        bundle.setStatusBarTintResource(0x7f080160);
        db = new DatabaseHandler(this);
        userFunctions = new UserFunctions();
        if (userFunctions.isUserLoggedIn(this))
        {
            cursor = db.getAllData();
            cursor.moveToFirst();
            int i;
            int j;
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
            user_kecamatan = cursor.getString(cursor.getColumnIndex("user_kecamatan"));
            user_jekel = cursor.getString(9);
            user_ponsel1 = cursor.getString(10);
            user_ponsel2 = cursor.getString(11);
            user_provider1 = cursor.getString(12);
            user_provider2 = cursor.getString(13);
            user_joindate = cursor.getString(14);
            user_profile_update = cursor.getString(15);
        }
        i = android.os.Build.VERSION.SDK_INT;
        actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayUseLogoEnabled(useLogo);
        actionBar.setBackgroundDrawable(getResources().getDrawable(0x7f0200e5));
        j = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        i = j;
        if (j == 0)
        {
            i = 0x7f0b0037;
        }
        bundle = (TextView)findViewById(i);
        bundle.setSelected(true);
        bundle.setTextColor(Color.parseColor("#FFFFFF"));
        bundle.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFFFFF'>Notifikasi</font>"));
        t = Utility.session(t);
        listNotifikasi = (ExpandableHeightListView2)findViewById(0x7f0b06f0);
        listNotifikasi.setExpanded(true);
        layout_empty = (LinearLayout)findViewById(0x7f0b0091);
        txt_empty = (TextView)findViewById(0x7f0b0093);
        progressbar_middle = (ProgressBar)findViewById(0x7f0b00ca);
        txt_empty.setText("Memuat...");
        t = Utility.session(t);
        hpMoreArray = new ArrayList();
        selengkapAdapter = new ListSelengkapAdapter(this, 0x7f030124, hpMoreArray);
        listNotifikasi.setAdapter(selengkapAdapter);
        cm = (ConnectivityManager)getSystemService("connectivity");
        url_notif = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("user_notif_activity").append(Utility.BASE_FORMAT).append("?").append("lmt=0&t=").append(t).append("&idusr=").append(user_id).toString();
        Log.e("url_notif", url_notif);
        if (fileExist("343212312"))
        {
            Log.e("fileExist", "true");
            loadOfflineFirst();
            loadFromNetwork();
        } else
        {
            Log.e("fileExist", "false");
            loadFromNetwork();
        }
        listNotifikasi.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final NotificationCenterActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int k, long l)
            {
                adapterview = selengkapAdapter.getListModel(k).getActv_type();
                view = selengkapAdapter.getListModel(k).getActv_content_type_id();
                if (!adapterview.equals("like")) goto _L2; else goto _L1
_L1:
                if (!view.equals("6")) goto _L4; else goto _L3
_L3:
                adapterview = new Intent();
                if (selengkapAdapter.getListModel(k).getType().toLowerCase().equals("conversation"))
                {
                    adapterview.setClass(getApplicationContext(), com/inponsel/android/conversation/ConversationDetailActivity);
                } else
                {
                    adapterview.setClass(getApplicationContext(), com/inponsel/android/timelinedetail/Hal1TLDetailActivity);
                }
                adapterview.putExtra("tl_id", selengkapAdapter.getListModel(k).getId_hp());
                adapterview.putExtra("act", "gcm");
                adapterview.putExtra("tl_judul", selengkapAdapter.getListModel(k).getMerk());
                adapterview.putExtra("namalengkap", selengkapAdapter.getListModel(k).getCodename());
                startActivityForResult(adapterview, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
_L6:
                return;
_L4:
                if (view.equals("1"))
                {
                    adapterview = new Intent(getApplicationContext(), com/inponsel/android/v2/KomentarPonsel);
                    adapterview.putExtra("id_hph", selengkapAdapter.getListModel(k).getId_hp());
                    adapterview.putExtra("namalengkap", (new StringBuilder(String.valueOf(selengkapAdapter.getListModel(k).getMerk()))).append(" ").append(selengkapAdapter.getListModel(k).getModel()).toString());
                    adapterview.putExtra("codename", selengkapAdapter.getListModel(k).getCodename());
                    adapterview.putExtra("model", selengkapAdapter.getListModel(k).getModel());
                    adapterview.putExtra("merk", selengkapAdapter.getListModel(k).getMerk());
                    adapterview.putExtra("gambar", "");
                    adapterview.putExtra("hrg_baru", "");
                    adapterview.putExtra("hrg_bekas", "");
                    adapterview.putExtra("tot_like", "");
                    adapterview.putExtra("tot_dislike", "");
                    adapterview.putExtra("tot_komen", "");
                    adapterview.putExtra("actfrom", "komen");
                    startActivityForResult(adapterview, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                    return;
                }
                continue; /* Loop/switch isn't completed */
_L2:
                if (!adapterview.equals("reply"))
                {
                    continue; /* Loop/switch isn't completed */
                }
                if (view.equals("1"))
                {
                    adapterview = new Intent(getApplicationContext(), com/inponsel/android/v2/KomentarPonsel);
                    adapterview.putExtra("id_hph", selengkapAdapter.getListModel(k).getId_hp());
                    adapterview.putExtra("namalengkap", (new StringBuilder(String.valueOf(selengkapAdapter.getListModel(k).getMerk()))).append(" ").append(selengkapAdapter.getListModel(k).getModel()).toString());
                    adapterview.putExtra("codename", selengkapAdapter.getListModel(k).getCodename());
                    adapterview.putExtra("model", selengkapAdapter.getListModel(k).getModel());
                    adapterview.putExtra("merk", selengkapAdapter.getListModel(k).getMerk());
                    adapterview.putExtra("gambar", "");
                    adapterview.putExtra("hrg_baru", "");
                    adapterview.putExtra("hrg_bekas", "");
                    adapterview.putExtra("tot_like", "");
                    adapterview.putExtra("tot_dislike", "");
                    adapterview.putExtra("tot_komen", "");
                    adapterview.putExtra("actfrom", "komen");
                    startActivityForResult(adapterview, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                    return;
                }
                if (view.equals("2"))
                {
                    adapterview = new Intent();
                    adapterview.setClass(getApplicationContext(), com/inponsel/android/rssfeeddetail/RSSDetailTab);
                    adapterview.putExtra("id_rss", selengkapAdapter.getListModel(k).getId_hp());
                    adapterview.putExtra("rss_title", selengkapAdapter.getListModel(k).getMerk());
                    adapterview.putExtra("notif", "gcm");
                    adapterview.putExtra("actfrom", "rssfeed");
                    adapterview.putExtra("act", "firsttab");
                    startActivityForResult(adapterview, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                    return;
                }
                if (view.equals("3"))
                {
                    adapterview = new Intent(getApplicationContext(), com/inponsel/android/scdetail/SCDetailPager);
                    adapterview.putExtra("sc_id", selengkapAdapter.getListModel(k).getId_sc());
                    adapterview.putExtra("sc_logo", selengkapAdapter.getListModel(k).getSc_logo());
                    adapterview.putExtra("sc_c_center", selengkapAdapter.getListModel(k).getSc_c_center());
                    adapterview.putExtra("sc_ven_center", selengkapAdapter.getListModel(k).getSc_ven_center());
                    adapterview.putExtra("sc_nama", selengkapAdapter.getListModel(k).getSc_nama());
                    adapterview.putExtra("sc_merk", selengkapAdapter.getListModel(k).getSc_merk());
                    adapterview.putExtra("sc_fb", selengkapAdapter.getListModel(k).getSc_fb());
                    adapterview.putExtra("sc_ytube", selengkapAdapter.getListModel(k).getSc_ytube());
                    adapterview.putExtra("sc_fb_id", selengkapAdapter.getListModel(k).getSc_fb_id());
                    adapterview.putExtra("sc_tw", selengkapAdapter.getListModel(k).getSc_tw());
                    adapterview.putExtra("sc_alamat", selengkapAdapter.getListModel(k).getSc_alamat());
                    adapterview.putExtra("sc_no_telp", selengkapAdapter.getListModel(k).getSc_no_telp());
                    adapterview.putExtra("sc_no_telp_ket", selengkapAdapter.getListModel(k).getSc_no_telp_ket());
                    adapterview.putExtra("sc_email", selengkapAdapter.getListModel(k).getSc_email());
                    adapterview.putExtra("sc_web", selengkapAdapter.getListModel(k).getSc_web_url());
                    adapterview.putExtra("sc_rateAvg", selengkapAdapter.getListModel(k).getSc_rate());
                    adapterview.putExtra("sc_rate1", selengkapAdapter.getListModel(k).getSc_rate1());
                    adapterview.putExtra("sc_rate2", selengkapAdapter.getListModel(k).getSc_rate2());
                    adapterview.putExtra("sc_rate3", selengkapAdapter.getListModel(k).getSc_rate3());
                    adapterview.putExtra("sc_rate4", selengkapAdapter.getListModel(k).getSc_rate4());
                    adapterview.putExtra("sc_rate5", selengkapAdapter.getListModel(k).getSc_rate5());
                    adapterview.putExtra("sc_total_rate", selengkapAdapter.getListModel(k).getSc_total_rate());
                    startActivityForResult(adapterview, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                    return;
                }
                if (view.equals("4"))
                {
                    adapterview = new Intent(NotificationCenterActivity.this, com/inponsel/android/details/KomentarTwitter);
                    adapterview.putExtra("tw_name", selengkapAdapter.getListModel(k).getScreen_nametw());
                    adapterview.putExtra("id_tw", selengkapAdapter.getListModel(k).getId_hp());
                    adapterview.putExtra("tweet_content", selengkapAdapter.getListModel(k).getTweet_content());
                    adapterview.putExtra("media_url", selengkapAdapter.getListModel(k).getMedia_urltw());
                    adapterview.putExtra("avatar", selengkapAdapter.getListModel(k).getAvatartw());
                    adapterview.putExtra("tweet_time", selengkapAdapter.getListModel(k).getTweet_time());
                    adapterview.putExtra("screen_name", selengkapAdapter.getListModel(k).getReal_nametw());
                    startActivityForResult(adapterview, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                    return;
                }
                if (view.equals("5"))
                {
                    adapterview = new Intent();
                    if (selengkapAdapter.getListModel(k).getType().toLowerCase().equals("conversation"))
                    {
                        adapterview.setClass(getApplicationContext(), com/inponsel/android/conversation/ConversationDetailActivity);
                    } else
                    {
                        adapterview.setClass(getApplicationContext(), com/inponsel/android/timelinedetail/Hal1TLDetailActivity);
                    }
                    adapterview.putExtra("tl_id", selengkapAdapter.getListModel(k).getId_hp());
                    adapterview.putExtra("act", "gcm");
                    adapterview.putExtra("tl_judul", selengkapAdapter.getListModel(k).getMerk());
                    adapterview.putExtra("namalengkap", selengkapAdapter.getListModel(k).getCodename());
                    startActivityForResult(adapterview, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                    return;
                }
                continue; /* Loop/switch isn't completed */
                if (!adapterview.equals("comment")) goto _L6; else goto _L5
_L5:
                if (view.equals("1"))
                {
                    adapterview = new Intent(getApplicationContext(), com/inponsel/android/v2/KomentarPonsel);
                    adapterview.putExtra("id_hph", selengkapAdapter.getListModel(k).getId_hp());
                    adapterview.putExtra("namalengkap", (new StringBuilder(String.valueOf(selengkapAdapter.getListModel(k).getMerk()))).append(" ").append(selengkapAdapter.getListModel(k).getModel()).toString());
                    adapterview.putExtra("codename", selengkapAdapter.getListModel(k).getCodename());
                    adapterview.putExtra("model", selengkapAdapter.getListModel(k).getModel());
                    adapterview.putExtra("merk", selengkapAdapter.getListModel(k).getMerk());
                    adapterview.putExtra("gambar", "");
                    adapterview.putExtra("hrg_baru", "");
                    adapterview.putExtra("hrg_bekas", "");
                    adapterview.putExtra("tot_like", "");
                    adapterview.putExtra("tot_dislike", "");
                    adapterview.putExtra("tot_komen", "");
                    adapterview.putExtra("actfrom", "komen");
                    startActivityForResult(adapterview, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                    return;
                }
                if (view.equals("2"))
                {
                    adapterview = new Intent();
                    adapterview.setClass(getApplicationContext(), com/inponsel/android/rssfeeddetail/RSSDetailTab);
                    adapterview.putExtra("id_rss", selengkapAdapter.getListModel(k).getId_hp());
                    adapterview.putExtra("rss_title", selengkapAdapter.getListModel(k).getMerk());
                    adapterview.putExtra("notif", "gcm");
                    adapterview.putExtra("actfrom", "rssfeed");
                    adapterview.putExtra("act", "firsttab");
                    startActivityForResult(adapterview, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                    return;
                }
                if (view.equals("3"))
                {
                    adapterview = new Intent(getApplicationContext(), com/inponsel/android/scdetail/SCDetailPager);
                    adapterview.putExtra("sc_id", selengkapAdapter.getListModel(k).getId_sc());
                    adapterview.putExtra("sc_logo", selengkapAdapter.getListModel(k).getSc_logo());
                    adapterview.putExtra("sc_c_center", selengkapAdapter.getListModel(k).getSc_c_center());
                    adapterview.putExtra("sc_ven_center", selengkapAdapter.getListModel(k).getSc_ven_center());
                    adapterview.putExtra("sc_nama", selengkapAdapter.getListModel(k).getSc_nama());
                    adapterview.putExtra("sc_merk", selengkapAdapter.getListModel(k).getSc_merk());
                    adapterview.putExtra("sc_fb", selengkapAdapter.getListModel(k).getSc_fb());
                    adapterview.putExtra("sc_ytube", selengkapAdapter.getListModel(k).getSc_ytube());
                    adapterview.putExtra("sc_fb_id", selengkapAdapter.getListModel(k).getSc_fb_id());
                    adapterview.putExtra("sc_tw", selengkapAdapter.getListModel(k).getSc_tw());
                    adapterview.putExtra("sc_alamat", selengkapAdapter.getListModel(k).getSc_alamat());
                    adapterview.putExtra("sc_no_telp", selengkapAdapter.getListModel(k).getSc_no_telp());
                    adapterview.putExtra("sc_no_telp_ket", selengkapAdapter.getListModel(k).getSc_no_telp_ket());
                    adapterview.putExtra("sc_email", selengkapAdapter.getListModel(k).getSc_email());
                    adapterview.putExtra("sc_web", selengkapAdapter.getListModel(k).getSc_web_url());
                    adapterview.putExtra("sc_rateAvg", selengkapAdapter.getListModel(k).getSc_rate());
                    adapterview.putExtra("sc_rate1", selengkapAdapter.getListModel(k).getSc_rate1());
                    adapterview.putExtra("sc_rate2", selengkapAdapter.getListModel(k).getSc_rate2());
                    adapterview.putExtra("sc_rate3", selengkapAdapter.getListModel(k).getSc_rate3());
                    adapterview.putExtra("sc_rate4", selengkapAdapter.getListModel(k).getSc_rate4());
                    adapterview.putExtra("sc_rate5", selengkapAdapter.getListModel(k).getSc_rate5());
                    adapterview.putExtra("sc_total_rate", selengkapAdapter.getListModel(k).getSc_total_rate());
                    startActivityForResult(adapterview, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                    return;
                }
                if (view.equals("4"))
                {
                    adapterview = new Intent(NotificationCenterActivity.this, com/inponsel/android/details/KomentarTwitter);
                    adapterview.putExtra("tw_name", selengkapAdapter.getListModel(k).getScreen_nametw());
                    adapterview.putExtra("id_tw", selengkapAdapter.getListModel(k).getId_hp());
                    adapterview.putExtra("tweet_content", selengkapAdapter.getListModel(k).getTweet_content());
                    adapterview.putExtra("media_url", selengkapAdapter.getListModel(k).getMedia_urltw());
                    adapterview.putExtra("avatar", selengkapAdapter.getListModel(k).getAvatartw());
                    adapterview.putExtra("tweet_time", selengkapAdapter.getListModel(k).getTweet_time());
                    adapterview.putExtra("screen_name", selengkapAdapter.getListModel(k).getReal_nametw());
                    startActivityForResult(adapterview, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                    return;
                }
                if (view.equals("5"))
                {
                    adapterview = new Intent();
                    if (selengkapAdapter.getListModel(k).getType().toLowerCase().equals("conversation"))
                    {
                        adapterview.setClass(getApplicationContext(), com/inponsel/android/conversation/ConversationDetailActivity);
                    } else
                    {
                        adapterview.setClass(getApplicationContext(), com/inponsel/android/timelinedetail/Hal1TLDetailActivity);
                    }
                    adapterview.putExtra("tl_id", selengkapAdapter.getListModel(k).getId_hp());
                    adapterview.putExtra("act", "gcm");
                    adapterview.putExtra("tl_judul", selengkapAdapter.getListModel(k).getMerk());
                    adapterview.putExtra("namalengkap", selengkapAdapter.getListModel(k).getCodename());
                    startActivityForResult(adapterview, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                    return;
                }
                if (true) goto _L6; else goto _L7
_L7:
            }

            
            {
                this$0 = NotificationCenterActivity.this;
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


}
