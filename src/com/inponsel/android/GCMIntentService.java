// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.SQLException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.RemoteViews;
import com.android.volley.VolleyError;
import com.google.android.gcm.GCMBaseIntentService;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.conversation.ConversationDetailActivity;
import com.inponsel.android.details.DetailsPonsel;
import com.inponsel.android.details.KomentarTwitter;
import com.inponsel.android.rssfeeddetail.RSSDetailTab;
import com.inponsel.android.scdetail.SCDetailPager;
import com.inponsel.android.timelinedetail.Hal1TLDetailActivity;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.MyObjectRequest;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.v2.HomeNewMainActivity;
import com.inponsel.android.v2.MessageActivity;
import com.inponsel.android.v2.RoomChatActivity;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android:
//            CommonUtilities, SplashScreen, ServerUtilities

public class GCMIntentService extends GCMBaseIntentService
    implements Observer
{

    private static final String TAG = "GCMIntentService";
    static Context context;
    static String sc_alamat = "";
    static String sc_c_center = "";
    static String sc_email = "";
    static String sc_fb = "";
    static String sc_fb_id = "";
    static String sc_id = "";
    static String sc_kot = "";
    static String sc_logo = "";
    static String sc_merk = "";
    static String sc_merk_kettamb = "";
    static String sc_nama = "";
    static String sc_no_telp = "";
    static String sc_no_telp_ket = "";
    static String sc_prov = "";
    static String sc_tw = "";
    static String sc_ven_center = "";
    static String sc_web = "";
    static String sc_ytube = "";
    String chat_avaible;
    String codename;
    String content;
    Cursor cursor;
    DatabaseHandler db;
    String from_name;
    String gambar;
    String hp_photo;
    String id_content;
    String id_hp;
    String id_msg;
    String id_to;
    String idcontent;
    String img_url;
    String last_seen;
    String me_message;
    String merk;
    String message;
    String model;
    String msg_type;
    String namalengkap;
    int notif_count;
    int pixeldens;
    PonselBaseApp ponselBaseApp;
    String post_date;
    String t;
    String title;
    String to_name;
    String to_photo;
    String tw_time;
    String type_msg;
    String unread;
    UserFunctions userFunctions;
    String user_id;
    String user_photo;

    public GCMIntentService()
    {
        super(new String[] {
            "546843258034"
        });
        pixeldens = 95;
        notif_count = 0;
        chat_avaible = "";
        t = Utility.session(RestClient.pelihara);
        content = "";
        img_url = "";
        user_photo = "";
        tw_time = "";
    }

    private void GetInboxList()
    {
        t = Utility.session(t);
        t = Utility.session(t);
        MyObjectRequest myobjectrequest = new MyObjectRequest((new StringBuilder(String.valueOf(Util.BASE_PATH_MSG))).append("list_chat_group").append(Utility.BASE_FORMAT).append("?").append("id_user=").append(user_id).append("&t=").append(t).toString(), new com.android.volley.Response.Listener() {

            final GCMIntentService this$0;

            public volatile void onResponse(Object obj)
            {
                onResponse((JSONObject)obj);
            }

            public void onResponse(JSONObject jsonobject)
            {
                parseJSON(jsonobject.toString());
                ponselBaseApp.getObserver().setLoginStat("1");
            }

            
            {
                this$0 = GCMIntentService.this;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final GCMIntentService this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
            }

            
            {
                this$0 = GCMIntentService.this;
                super();
            }
        }, "test", "test");
        PonselBaseApp.getInstance().addToRequestQueue(myobjectrequest, "tag_json_obj");
    }

    private void GetSC()
    {
        Object obj = Utility.session(Utility.session(Utility.session(RestClient.pelihara)));
        obj = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("get_sc_details").append(Utility.BASE_FORMAT).append("?").append("id_sc=").append(id_content).append("&t=").append(((String) (obj))).toString();
        Log.e("urlGetSC", ((String) (obj)));
        obj = new MyObjectRequest(((String) (obj)), new com.android.volley.Response.Listener() {

            final GCMIntentService this$0;

            public volatile void onResponse(Object obj1)
            {
                onResponse((JSONObject)obj1);
            }

            public void onResponse(JSONObject jsonobject)
            {
                parseJSONSC(jsonobject.toString());
                ponselBaseApp.getObserver().setLoginStat("1");
            }

            
            {
                this$0 = GCMIntentService.this;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final GCMIntentService this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
            }

            
            {
                this$0 = GCMIntentService.this;
                super();
            }
        }, "test", "test");
        PonselBaseApp.getInstance().addToRequestQueue(((com.android.volley.Request) (obj)), "tag_json_obj");
    }

    private static void generateNotification(Context context1, String s, String s1, String s2, String s3, String s4)
    {
        if (!Utility.isTabletMDPI(context1));
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            long l = System.currentTimeMillis();
            NotificationManager notificationmanager = (NotificationManager)context1.getSystemService("notification");
            Notification notification = (new android.app.Notification.Builder(context1)).setContentTitle("Message").setContentText(s).setWhen(l).setSmallIcon(0x7f02023f).setLargeIcon(getBitmapFromURLAvatar((new StringBuilder(String.valueOf(Util.BASE_PATH_NEWIMAGE))).append(s3).toString(), context1)).setTicker(s).setStyle((new android.app.Notification.BigTextStyle()).bigText(s)).build();
            Intent intent = new Intent();
            if (s4.equals("1"))
            {
                intent.setClass(context1, com/inponsel/android/details/DetailsPonsel);
                intent.setFlags(0x24000000);
                Log.e("generateDetail", (new StringBuilder(String.valueOf(s1))).append("+").append(s).append("+").append(s4).toString());
                intent.putExtra("id_hph", s2);
                intent.putExtra("namalengkap", s1);
                intent.putExtra("gambar", s3);
                intent.putExtra("message", s);
                intent.putExtra("notif", "gcm");
            } else
            if (s4.equals("pm"))
            {
                intent.setClass(context1, com/inponsel/android/v2/MessageActivity);
                intent.setFlags(0x24000000);
                Log.e("generateMessage", (new StringBuilder(String.valueOf(s1))).append("+").append(s).append("+").append(s4).toString());
                intent.putExtra("id_to", s2);
                intent.putExtra("to_name", s1);
                intent.putExtra("to_photo", s3);
                intent.putExtra("last_message", s);
                intent.putExtra("notif", "gcm");
                intent.putExtra("id_msg", "");
                intent.putExtra("id_from", "");
                intent.putExtra("my_name", "");
                intent.putExtra("my_photo", "");
                intent.putExtra("message_type", "");
                intent.putExtra("unread_msg", "");
                intent.putExtra("msg_date", "");
            } else
            {
                intent.setClass(context1, com/inponsel/android/v2/HomeNewMainActivity);
                intent.setFlags(0x24000000);
                Log.e("generateMain", (new StringBuilder(String.valueOf(s1))).append("+").append(s).append("+").append(s4).toString());
                intent.putExtra("title", s1);
                intent.putExtra("message", s);
                intent.putExtra("notif", s4);
            }
            notification.contentIntent = PendingIntent.getActivity(context1, 0, intent, 0x48000000);
            notification.flags = notification.flags | 0x10;
            notification.ledARGB = notification.ledARGB | 0xffff9900;
            notification.flags = notification.flags | 1;
            notification.ledOnMS = notification.ledOnMS | 0x64;
            notification.ledOffMS = notification.ledOffMS | 0x64;
            notificationmanager.notify(0, notification);
            return;
        }
        long l1 = System.currentTimeMillis();
        NotificationManager notificationmanager1 = (NotificationManager)context1.getSystemService("notification");
        Notification notification1 = new Notification(0x7f02023f, s1, l1);
        Object obj = new RemoteViews(context1.getPackageName(), 0x7f030023);
        ((RemoteViews) (obj)).setImageViewResource(0x7f0b007f, 0x7f02023f);
        ((RemoteViews) (obj)).setTextViewText(0x7f0b0088, s1);
        ((RemoteViews) (obj)).setTextViewText(0x7f0b0089, s);
        notification1.contentView = ((RemoteViews) (obj));
        obj = new Intent();
        if (s4.equals("1"))
        {
            ((Intent) (obj)).setClass(context1, com/inponsel/android/details/DetailsPonsel);
            ((Intent) (obj)).setFlags(0x24000000);
            Log.e("generateDetail", (new StringBuilder(String.valueOf(s1))).append("+").append(s).append("+").append(s4).toString());
            ((Intent) (obj)).putExtra("id_hph", s2);
            ((Intent) (obj)).putExtra("namalengkap", s1);
            ((Intent) (obj)).putExtra("gambar", s3);
            ((Intent) (obj)).putExtra("message", s);
            ((Intent) (obj)).putExtra("notif", s4);
        } else
        {
            ((Intent) (obj)).setClass(context1, com/inponsel/android/v2/HomeNewMainActivity);
            ((Intent) (obj)).setFlags(0x24000000);
            Log.e("generateMain", (new StringBuilder(String.valueOf(s1))).append("+").append(s).append("+").append(s4).toString());
            ((Intent) (obj)).putExtra("title", s1);
            ((Intent) (obj)).putExtra("message", s);
            ((Intent) (obj)).putExtra("notif", s4);
        }
        notification1.contentIntent = PendingIntent.getActivity(context1, 0, ((Intent) (obj)), 0x48000000);
        notification1.flags = notification1.flags | 0x10;
        notification1.ledARGB = notification1.ledARGB | 0xffff9900;
        notification1.flags = notification1.flags | 1;
        notification1.ledOnMS = notification1.ledOnMS | 0x64;
        notification1.ledOffMS = notification1.ledOffMS | 0x64;
        notificationmanager1.notify(0, notification1);
    }

    private static void generateNotificationForum(Context context1, String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8)
    {
        String s9 = "";
        if (!Utility.isTabletMDPI(context1));
        Log.e("gambar", s6);
        if (s7.equals("1"))
        {
            s9 = s6;
        }
        Log.e("bigPicture", s9);
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            s7 = (NotificationManager)context1.getSystemService("notification");
            if (!s6.equals(""))
            {
                Log.e("imageUrl", s6);
                Log.e("user_photo", s4);
                s3 = new android.support.v4.app.NotificationCompat.BigPictureStyle();
                s3.setBigContentTitle(s1);
                s3.setSummaryText("InPonsel");
                s5 = (new StringBuilder(String.valueOf(s5))).append(" memposting sebuah artikel di forum yang berjudul '").append(s2).append("'").toString();
                s3.bigPicture(getBitmapContentFromURL(s6));
                s3 = (new android.support.v4.app.NotificationCompat.Builder(context1)).setSmallIcon(0x7f02023f).setAutoCancel(true).setLargeIcon(getBitmapFromURLAvatar((new StringBuilder(String.valueOf(Util.BASE_PATH_NEWIMAGE))).append(s4).toString(), context1)).setContentTitle(s1).setContentText(s5).setStyle(s3).build();
            } else
            {
                Log.e("Pesan", s6);
                s3 = new android.support.v4.app.NotificationCompat.BigTextStyle();
                s3.setBigContentTitle(s1);
                s3.setSummaryText("InPonsel");
                s5 = (new StringBuilder(String.valueOf(s5))).append(" memposting sebuah artikel di forum yang berjudul '").append(s2).append("'").toString();
                s3.bigText(s5);
                s3 = (new android.support.v4.app.NotificationCompat.Builder(context1)).setSmallIcon(0x7f02023f).setAutoCancel(true).setLargeIcon(getBitmapFromURLAvatar((new StringBuilder(String.valueOf(Util.BASE_PATH_NEWIMAGE))).append(s4).toString(), context1)).setContentTitle(s1).setContentText(s5).setStyle(s3).build();
            }
            s4 = new Intent();
            s4.setClass(context1, com/inponsel/android/timelinedetail/Hal1TLDetailActivity);
            s4.setFlags(0x24000000);
            Log.e("generateMessage", (new StringBuilder(String.valueOf(s2))).append("+").append(s6).append("+").append(s8).toString());
            s4.putExtra("tl_id", s);
            s4.putExtra("act", "gcm");
            s4.putExtra("tl_judul", s2);
            s4.putExtra("namalengkap", s1);
            s3.contentIntent = PendingIntent.getActivity(context1, Integer.parseInt((new StringBuilder("-3")).append(s).toString()), s4, 0x48000000);
            s3.flags = ((Notification) (s3)).flags | 0x10;
            s3.ledARGB = ((Notification) (s3)).ledARGB | 0xffff9900;
            s3.flags = ((Notification) (s3)).flags | 1;
            s3.ledOnMS = ((Notification) (s3)).ledOnMS | 0x3e8;
            s3.ledOffMS = ((Notification) (s3)).ledOffMS | 0x2710;
            s7.notify(Integer.parseInt((new StringBuilder("-3")).append(s).toString()), s3);
            return;
        } else
        {
            long l = System.currentTimeMillis();
            s4 = (NotificationManager)context1.getSystemService("notification");
            s5 = new Notification(0x7f02023f, s2, l);
            s7 = new RemoteViews(context1.getPackageName(), 0x7f030023);
            s7.setImageViewResource(0x7f0b007f, 0x7f02023f);
            s7.setTextViewText(0x7f0b0088, s2);
            s7.setTextViewText(0x7f0b0089, s3);
            s5.contentView = s7;
            s3 = new Intent();
            s3.setClass(context1, com/inponsel/android/timelinedetail/Hal1TLDetailActivity);
            s3.setFlags(0x24000000);
            Log.e("generateMessage", (new StringBuilder(String.valueOf(s2))).append("+").append(s6).append("+").append(s8).toString());
            s3.putExtra("tl_id", s);
            s3.putExtra("act", "gcm");
            s3.putExtra("tl_judul", s2);
            s3.putExtra("namalengkap", s1);
            s5.contentIntent = PendingIntent.getActivity(context1, Integer.parseInt((new StringBuilder("-3")).append(s).toString()), s3, 0x48000000);
            s5.flags = ((Notification) (s5)).flags | 0x10;
            s5.ledARGB = ((Notification) (s5)).ledARGB | 0xffff9900;
            s5.flags = ((Notification) (s5)).flags | 1;
            s5.ledOnMS = ((Notification) (s5)).ledOnMS | 0x64;
            s5.ledOffMS = ((Notification) (s5)).ledOffMS | 0x64;
            s4.notify(Integer.parseInt((new StringBuilder("-3")).append(s).toString()), s5);
            return;
        }
    }

    private static void generateNotificationForumLike(Context context1, String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8)
    {
        s1 = "";
        if (!Utility.isTabletMDPI(context1));
        Log.e("gambar", s6);
        if (s7.equals("1"))
        {
            s1 = s6;
        }
        Log.e("bigPicture", s1);
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            s5 = (NotificationManager)context1.getSystemService("notification");
            if (!"".equals(""))
            {
                Log.e("imageUrl", "");
                Log.e("user_photo", s4);
                s1 = new android.support.v4.app.NotificationCompat.BigPictureStyle();
                s1.setBigContentTitle(s2);
                s1.setSummaryText("InPonsel");
                s1.bigPicture(getBitmapContentFromURL(""));
                s1 = (new android.support.v4.app.NotificationCompat.Builder(context1)).setSmallIcon(0x7f02023f).setAutoCancel(true).setLargeIcon(getBitmapFromURLHP((new StringBuilder(String.valueOf(Util.BASE_PATH_NEWIMAGE))).append(s4).toString(), context1)).setContentTitle(s2).setContentText(s3).setStyle(s1).build();
            } else
            {
                Log.e("user_photo", s4);
                s1 = new android.support.v4.app.NotificationCompat.BigTextStyle();
                s1.setBigContentTitle(s2);
                s1.setSummaryText("InPonsel");
                s1.bigText(s3);
                s1 = (new android.support.v4.app.NotificationCompat.Builder(context1)).setSmallIcon(0x7f02023f).setAutoCancel(true).setLargeIcon(getBitmapFromURLHP((new StringBuilder(String.valueOf(Util.BASE_PATH_NEWIMAGE))).append(s4).toString(), context1)).setContentTitle(s2).setContentText(s3).setStyle(s1).build();
            }
            s3 = new Intent();
            if (s7.contains("conversation"))
            {
                s3.setClass(context1, com/inponsel/android/conversation/ConversationDetailActivity);
            } else
            {
                s3.setClass(context1, com/inponsel/android/timelinedetail/Hal1TLDetailActivity);
            }
            s3.setFlags(0x24000000);
            s3.putExtra("tl_id", s);
            s3.putExtra("act", "gcm");
            s3.putExtra("tl_judul", s2);
            s3.putExtra("namalengkap", "");
            s1.contentIntent = PendingIntent.getActivity(context1, Integer.parseInt((new StringBuilder("-3")).append(s).toString()), s3, 0x48000000);
            s1.ledARGB = ((Notification) (s1)).ledARGB | 0xffff9900;
            s1.flags = ((Notification) (s1)).flags | 1;
            s1.ledOnMS = ((Notification) (s1)).ledOnMS | 0x3e8;
            s1.ledOffMS = ((Notification) (s1)).ledOffMS | 0x2710;
            s5.notify(Integer.parseInt((new StringBuilder("-3")).append(s).toString()), s1);
            return;
        } else
        {
            long l = System.currentTimeMillis();
            s1 = (NotificationManager)context1.getSystemService("notification");
            s4 = new Notification(0x7f02023f, s2, l);
            s5 = new RemoteViews(context1.getPackageName(), 0x7f030023);
            s5.setImageViewResource(0x7f0b007f, 0x7f02023f);
            s5.setTextViewText(0x7f0b0088, s2);
            s5.setTextViewText(0x7f0b0089, s3);
            s4.contentView = s5;
            s2 = new Intent();
            s4.contentIntent = PendingIntent.getActivity(context1, Integer.parseInt((new StringBuilder("-3")).append(s).toString()), s2, 0x48000000);
            s4.flags = ((Notification) (s4)).flags | 0x10;
            s4.ledARGB = ((Notification) (s4)).ledARGB | 0xffff9900;
            s4.flags = ((Notification) (s4)).flags | 1;
            s4.ledOnMS = ((Notification) (s4)).ledOnMS | 0x64;
            s4.ledOffMS = ((Notification) (s4)).ledOffMS | 0x64;
            s1.notify(Integer.parseInt((new StringBuilder("-3")).append(s).toString()), s4);
            return;
        }
    }

    private static void generateNotificationGroupChat(Context context1, String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8, String s9, String s10, String s11)
    {
        s9 = "";
        s10 = (new StringBuilder(String.valueOf(s1))).append(" ").append(s2).toString();
        if (!Utility.isTabletMDPI(context1));
        Log.e("gambar", s4);
        s8 = s6;
        if (s7.equals("1"))
        {
            s8 = "Gambar";
            s9 = s6;
        }
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            NotificationManager notificationmanager = (NotificationManager)context1.getSystemService("notification");
            if (s7.equals("1"))
            {
                Log.e("imageUrl", s8);
                s6 = new android.support.v4.app.NotificationCompat.BigPictureStyle();
                s6.setBigContentTitle(s10);
                s6.setSummaryText("InPonsel");
                s7 = (new StringBuilder(String.valueOf(s5))).append(": ").append("Gambar").toString();
                s6.bigPicture(getBitmapContentFromURL(s9));
                s6 = (new android.support.v4.app.NotificationCompat.Builder(context1)).setSmallIcon(0x7f020227).setAutoCancel(true).setLargeIcon(getBitmapFromURLAvatar((new StringBuilder(String.valueOf(Util.BASE_PATH_NEWIMAGE))).append(s4).toString(), context1)).setContentTitle(s10).setContentText(s7).setStyle(s6).build();
            } else
            {
                Log.e("Pesan", s8);
                s6 = new android.support.v4.app.NotificationCompat.BigTextStyle();
                s6.setBigContentTitle(s10);
                s6.setSummaryText("InPonsel");
                s6.bigText((new StringBuilder(String.valueOf(s5))).append(": ").append(s8).toString());
                s6 = (new android.support.v4.app.NotificationCompat.Builder(context1)).setSmallIcon(0x7f020227).setAutoCancel(true).setLargeIcon(getBitmapFromURLHP((new StringBuilder(String.valueOf(Util.BASE_PATH_NEWIMAGE))).append(s4).toString(), context1)).setContentTitle(s10).setContentText((new StringBuilder(String.valueOf(s5))).append(": ").append(s8).toString()).setStyle(s6).build();
            }
            s7 = new Intent();
            s7.setClass(context1, com/inponsel/android/v2/RoomChatActivity);
            s7.setFlags(0x24000000);
            Log.e("generateMessage", (new StringBuilder(String.valueOf(s10))).append("+").append(s8).append("+").append(s11).toString());
            s7.putExtra("from_name", s5);
            s7.putExtra("from_photo", s4);
            s7.putExtra("to_photo", s4);
            s7.putExtra("id_hph", s);
            s7.putExtra("merk", s1);
            s7.putExtra("model", s2);
            s7.putExtra("codename", (new StringBuilder("-")).append(s3).toString());
            s6.contentIntent = PendingIntent.getActivity(context1, Integer.parseInt((new StringBuilder("-")).append(s).toString()), s7, 0x48000000);
            s6.flags = ((Notification) (s6)).flags | 0x10;
            s6.ledARGB = ((Notification) (s6)).ledARGB | 0xffff9900;
            s6.flags = ((Notification) (s6)).flags | 1;
            s6.ledOnMS = ((Notification) (s6)).ledOnMS | 0x3e8;
            s6.ledOffMS = ((Notification) (s6)).ledOffMS | 0x2710;
            s6.sound = Uri.parse((new StringBuilder("android.resource://")).append(context1.getPackageName()).append("/raw/hangouts_message").toString());
            notificationmanager.notify(Integer.parseInt((new StringBuilder("-")).append(s).toString()), s6);
            return;
        } else
        {
            long l = System.currentTimeMillis();
            s6 = (NotificationManager)context1.getSystemService("notification");
            s7 = new Notification(0x7f020227, s10, l);
            s9 = new RemoteViews(context1.getPackageName(), 0x7f030023);
            s9.setImageViewResource(0x7f0b007f, 0x7f020227);
            s9.setTextViewText(0x7f0b0088, s10);
            s9.setTextViewText(0x7f0b0089, s8);
            s7.contentView = s9;
            s9 = new Intent();
            s9.setClass(context1, com/inponsel/android/v2/MessageActivity);
            s9.setFlags(0x24000000);
            Log.e("generateMessage", (new StringBuilder(String.valueOf(s10))).append("+").append(s8).append("+").append(s11).toString());
            s9.putExtra("from_name", s5);
            s9.putExtra("from_photo", s4);
            s9.putExtra("to_photo", s4);
            s9.putExtra("id_hph", s);
            s9.putExtra("merk", s1);
            s9.putExtra("model", s2);
            s9.putExtra("codename", (new StringBuilder("-")).append(s3).toString());
            s7.contentIntent = PendingIntent.getActivity(context1, Integer.parseInt((new StringBuilder("-")).append(s).toString()), s9, 0x48000000);
            s7.flags = ((Notification) (s7)).flags | 0x10;
            s7.ledARGB = ((Notification) (s7)).ledARGB | 0xffff9900;
            s7.flags = ((Notification) (s7)).flags | 1;
            s7.ledOnMS = ((Notification) (s7)).ledOnMS | 0x64;
            s7.ledOffMS = ((Notification) (s7)).ledOffMS | 0x64;
            s7.sound = Uri.parse((new StringBuilder("android.resource://")).append(context1.getPackageName()).append("/raw/hangouts_message").toString());
            s6.notify(Integer.parseInt((new StringBuilder("-")).append(s).toString()), s7);
            return;
        }
    }

    private static void generateNotificationKomentarHP(Context context1, String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7)
    {
        String s9 = "";
        if (!Utility.isTabletMDPI(context1));
        Log.e("gambar", s3);
        String s8 = s5;
        if (s6.equals("1"))
        {
            s8 = "Gambar";
            s9 = s5;
        }
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            NotificationManager notificationmanager = (NotificationManager)context1.getSystemService("notification");
            if (s6.equals("1"))
            {
                Log.e("imageUrl", s8);
                s5 = new android.support.v4.app.NotificationCompat.BigPictureStyle();
                s5.setBigContentTitle(s2);
                s5.setSummaryText("InPonsel");
                s4 = (new StringBuilder(String.valueOf(s4))).append(": ").append("Gambar").toString();
                s5.bigPicture(getBitmapContentFromURL(s9));
                s4 = (new android.support.v4.app.NotificationCompat.Builder(context1)).setSmallIcon(0x7f02023f).setAutoCancel(true).setLargeIcon(getBitmapFromURLHP((new StringBuilder(String.valueOf(Util.BASE_PATH_NEWIMAGE))).append(s3).toString(), context1)).setContentTitle(s2).setContentText(s4).setStyle(s5).build();
            } else
            {
                Log.e("Pesan", s8);
                android.support.v4.app.NotificationCompat.BigTextStyle bigtextstyle = new android.support.v4.app.NotificationCompat.BigTextStyle();
                bigtextstyle.setBigContentTitle(s2);
                bigtextstyle.setSummaryText("InPonsel");
                if (s6.equals("hptanggap"))
                {
                    s4 = (new StringBuilder("Tanggapan dari ")).append(s4).append(": ").append(s8).toString();
                    s5 = s4;
                } else
                {
                    s4 = (new StringBuilder(String.valueOf(s4))).append(": ").append(s8).toString();
                    s5 = s4;
                }
                bigtextstyle.bigText(s4);
                s4 = (new android.support.v4.app.NotificationCompat.Builder(context1)).setSmallIcon(0x7f02023f).setAutoCancel(true).setLargeIcon(getBitmapFromURLHP((new StringBuilder(String.valueOf(Util.BASE_PATH_NEWIMAGE))).append(s3).toString(), context1)).setContentTitle(s2).setContentText(s5).setStyle(bigtextstyle).build();
            }
            s5 = new Intent();
            s5.setClass(context1, com/inponsel/android/details/DetailsPonsel);
            s5.setFlags(0x24000000);
            Log.e("generateMessage", (new StringBuilder(String.valueOf(s2))).append("+").append(s8).append("+").append(s7).toString());
            s5.putExtra("id_hph", s);
            s5.putExtra("namalengkap", s2);
            s5.putExtra("codename", s1);
            s5.putExtra("model", "");
            s5.putExtra("merk", "");
            s5.putExtra("gambar", s3);
            s5.putExtra("hrg_baru", "");
            s5.putExtra("hrg_bekas", "");
            s5.putExtra("tot_like", "");
            s5.putExtra("tot_dislike", "");
            s5.putExtra("tot_komen", "");
            s5.putExtra("actfrom", "komen");
            s4.contentIntent = PendingIntent.getActivity(context1, Integer.parseInt((new StringBuilder("-1")).append(s).toString()), s5, 0x48000000);
            s4.flags = ((Notification) (s4)).flags | 0x10;
            s4.ledARGB = ((Notification) (s4)).ledARGB | 0xffff9900;
            s4.flags = ((Notification) (s4)).flags | 1;
            s4.ledOnMS = ((Notification) (s4)).ledOnMS | 0x3e8;
            s4.ledOffMS = ((Notification) (s4)).ledOffMS | 0x2710;
            notificationmanager.notify(Integer.parseInt((new StringBuilder("-1")).append(s).toString()), s4);
            return;
        } else
        {
            long l = System.currentTimeMillis();
            s4 = (NotificationManager)context1.getSystemService("notification");
            s5 = new Notification(0x7f02023f, s2, l);
            s6 = new RemoteViews(context1.getPackageName(), 0x7f030023);
            s6.setImageViewResource(0x7f0b007f, 0x7f02023f);
            s6.setTextViewText(0x7f0b0088, s2);
            s6.setTextViewText(0x7f0b0089, s8);
            s5.contentView = s6;
            s6 = new Intent();
            s6.setClass(context1, com/inponsel/android/details/DetailsPonsel);
            s6.setFlags(0x24000000);
            Log.e("generateMessage", (new StringBuilder(String.valueOf(s2))).append("+").append(s8).append("+").append(s7).toString());
            s6.putExtra("id_hph", s);
            s6.putExtra("namalengkap", s2);
            s6.putExtra("codename", s1);
            s6.putExtra("model", "");
            s6.putExtra("merk", "");
            s6.putExtra("gambar", s3);
            s6.putExtra("hrg_baru", "");
            s6.putExtra("hrg_bekas", "");
            s6.putExtra("tot_like", "");
            s6.putExtra("tot_dislike", "");
            s6.putExtra("tot_komen", "");
            s6.putExtra("actfrom", "komen");
            s5.contentIntent = PendingIntent.getActivity(context1, Integer.parseInt((new StringBuilder("-1")).append(s).toString()), s6, 0x48000000);
            s5.flags = ((Notification) (s5)).flags | 0x10;
            s5.ledARGB = ((Notification) (s5)).ledARGB | 0xffff9900;
            s5.flags = ((Notification) (s5)).flags | 1;
            s5.ledOnMS = ((Notification) (s5)).ledOnMS | 0x64;
            s5.ledOffMS = ((Notification) (s5)).ledOffMS | 0x64;
            s4.notify(Integer.parseInt((new StringBuilder("-1")).append(s).toString()), s5);
            return;
        }
    }

    private static void generateNotificationKomentarRSS(Context context1, String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7)
    {
        String s8 = "";
        if (!Utility.isTabletMDPI(context1));
        Log.e("gambar", s3);
        s1 = s5;
        if (s6.equals("1"))
        {
            s1 = "Gambar";
            s8 = s5;
        }
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            NotificationManager notificationmanager = (NotificationManager)context1.getSystemService("notification");
            if (s6.equals("1"))
            {
                Log.e("imageUrl", s1);
                s5 = new android.support.v4.app.NotificationCompat.BigPictureStyle();
                s5.setBigContentTitle(s2);
                s5.setSummaryText("InPonsel");
                s4 = (new StringBuilder(String.valueOf(s4))).append(": ").append("Gambar").toString();
                s5.bigPicture(getBitmapContentFromURL(s8));
                s3 = (new android.support.v4.app.NotificationCompat.Builder(context1)).setSmallIcon(0x7f02023f).setAutoCancel(true).setLargeIcon(getBitmapFromURLHP((new StringBuilder(String.valueOf(Util.BASE_PATH_NEWIMAGE))).append(s3).toString(), context1)).setContentTitle(s2).setContentText(s4).setStyle(s5).build();
            } else
            {
                Log.e("Pesan", s1);
                android.support.v4.app.NotificationCompat.BigTextStyle bigtextstyle = new android.support.v4.app.NotificationCompat.BigTextStyle();
                bigtextstyle.setBigContentTitle(s2);
                bigtextstyle.setSummaryText("InPonsel");
                if (s6.equals("rsstanggap"))
                {
                    s4 = (new StringBuilder("Tanggapan dari ")).append(s4).append(": ").append(s1).toString();
                    s5 = s4;
                } else
                {
                    s4 = (new StringBuilder(String.valueOf(s4))).append(": ").append(s1).toString();
                    s5 = s4;
                }
                bigtextstyle.bigText(s4);
                s3 = (new android.support.v4.app.NotificationCompat.Builder(context1)).setSmallIcon(0x7f02023f).setAutoCancel(true).setLargeIcon(getBitmapFromURLHP((new StringBuilder(String.valueOf(Util.BASE_PATH_NEWIMAGE))).append(s3).toString(), context1)).setContentTitle(s2).setContentText(s5).setStyle(bigtextstyle).build();
            }
            s4 = new Intent();
            s4.setClass(context1, com/inponsel/android/rssfeeddetail/RSSDetailTab);
            s4.setFlags(0x24000000);
            Log.e("generateMessage", (new StringBuilder(String.valueOf(s2))).append("+").append(s1).append("+").append(s7).toString());
            s4.putExtra("id_rss", s);
            s4.putExtra("rss_title", s2);
            s4.putExtra("notif", "gcm");
            s4.putExtra("actfrom", "rssfeed");
            s4.putExtra("act", "firsttab");
            s3.contentIntent = PendingIntent.getActivity(context1, Integer.parseInt((new StringBuilder("-2")).append(s).toString()), s4, 0x48000000);
            s3.flags = ((Notification) (s3)).flags | 0x10;
            s3.ledARGB = ((Notification) (s3)).ledARGB | 0xffff9900;
            s3.flags = ((Notification) (s3)).flags | 1;
            s3.ledOnMS = ((Notification) (s3)).ledOnMS | 0x3e8;
            s3.ledOffMS = ((Notification) (s3)).ledOffMS | 0x2710;
            notificationmanager.notify(Integer.parseInt((new StringBuilder("-2")).append(s).toString()), s3);
            return;
        } else
        {
            long l = System.currentTimeMillis();
            s3 = (NotificationManager)context1.getSystemService("notification");
            s4 = new Notification(0x7f02023f, s2, l);
            s5 = new RemoteViews(context1.getPackageName(), 0x7f030023);
            s5.setImageViewResource(0x7f0b007f, 0x7f02023f);
            s5.setTextViewText(0x7f0b0088, s2);
            s5.setTextViewText(0x7f0b0089, s1);
            s4.contentView = s5;
            s5 = new Intent();
            s5.setClass(context1, com/inponsel/android/rssfeeddetail/RSSDetailTab);
            s5.setFlags(0x24000000);
            Log.e("generateMessage", (new StringBuilder(String.valueOf(s2))).append("+").append(s1).append("+").append(s7).toString());
            s5.putExtra("id_rss", s);
            s5.putExtra("rss_title", s2);
            s5.putExtra("notif", "gcm");
            s5.putExtra("actfrom", "rssfeed");
            s5.putExtra("act", "firsttab");
            s4.contentIntent = PendingIntent.getActivity(context1, Integer.parseInt((new StringBuilder("-2")).append(s).toString()), s5, 0x48000000);
            s4.flags = ((Notification) (s4)).flags | 0x10;
            s4.ledARGB = ((Notification) (s4)).ledARGB | 0xffff9900;
            s4.flags = ((Notification) (s4)).flags | 1;
            s4.ledOnMS = ((Notification) (s4)).ledOnMS | 0x64;
            s4.ledOffMS = ((Notification) (s4)).ledOffMS | 0x64;
            s3.notify(Integer.parseInt((new StringBuilder("-2")).append(s).toString()), s4);
            return;
        }
    }

    private static void generateNotificationKomentarSC(Context context1, String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7)
    {
        String s8 = "";
        if (!Utility.isTabletMDPI(context1));
        Log.e("gambar", s3);
        s1 = s5;
        if (s6.equals("1"))
        {
            s1 = "Gambar";
            s8 = s5;
        }
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            NotificationManager notificationmanager = (NotificationManager)context1.getSystemService("notification");
            if (s6.equals("1"))
            {
                Log.e("imageUrl", s1);
                s5 = new android.support.v4.app.NotificationCompat.BigPictureStyle();
                s5.setBigContentTitle(s2);
                s5.setSummaryText("InPonsel");
                s4 = (new StringBuilder(String.valueOf(s4))).append(": ").append("Gambar").toString();
                s5.bigPicture(getBitmapContentFromURL(s8));
                s3 = (new android.support.v4.app.NotificationCompat.Builder(context1)).setSmallIcon(0x7f02023f).setAutoCancel(true).setLargeIcon(getBitmapFromURLHP((new StringBuilder(String.valueOf(Util.BASE_PATH_NEWIMAGE))).append(s3).toString(), context1)).setContentTitle(s2).setContentText(s4).setStyle(s5).build();
            } else
            {
                Log.e("Pesan", s1);
                android.support.v4.app.NotificationCompat.BigTextStyle bigtextstyle = new android.support.v4.app.NotificationCompat.BigTextStyle();
                bigtextstyle.setBigContentTitle(s2);
                bigtextstyle.setSummaryText("InPonsel");
                if (s6.equals("sctanggap"))
                {
                    s4 = (new StringBuilder("Tanggapan dari ")).append(s4).append(": ").append(s1).toString();
                    s5 = s4;
                } else
                {
                    s4 = (new StringBuilder(String.valueOf(s4))).append(": ").append(s1).toString();
                    s5 = s4;
                }
                bigtextstyle.bigText(s4);
                s3 = (new android.support.v4.app.NotificationCompat.Builder(context1)).setSmallIcon(0x7f02023f).setAutoCancel(true).setLargeIcon(getBitmapFromURLHP((new StringBuilder(String.valueOf(Util.BASE_PATH_NEWIMAGE))).append(s3).toString(), context1)).setContentTitle(s2).setContentText(s5).setStyle(bigtextstyle).build();
            }
            s4 = new Intent();
            s4.setClass(context1, com/inponsel/android/scdetail/SCDetailPager);
            s4.setFlags(0x24000000);
            Log.e("generateMessage", (new StringBuilder(String.valueOf(s2))).append("+").append(s1).append("+").append(s7).toString());
            s4.putExtra("sc_id", sc_id);
            s4.putExtra("sc_logo", sc_logo);
            s4.putExtra("sc_c_center", sc_c_center);
            s4.putExtra("sc_ven_center", sc_ven_center);
            s4.putExtra("sc_nama", sc_nama);
            s4.putExtra("sc_merk", sc_merk);
            s4.putExtra("sc_fb", sc_fb);
            s4.putExtra("sc_ytube", sc_ytube);
            s4.putExtra("sc_fb_id", sc_fb_id);
            s4.putExtra("sc_tw", sc_tw);
            s4.putExtra("sc_alamat", sc_alamat);
            s4.putExtra("sc_no_telp", sc_no_telp);
            s4.putExtra("sc_no_telp_ket", sc_no_telp_ket);
            s4.putExtra("sc_email", sc_email);
            s4.putExtra("sc_web", sc_web);
            s4.putExtra("sc_rateAvg", "");
            s4.putExtra("sc_rate1", "");
            s4.putExtra("sc_rate2", "");
            s4.putExtra("sc_rate3", "");
            s4.putExtra("sc_rate4", "");
            s4.putExtra("sc_rate5", "");
            s4.putExtra("sc_total_rate", "");
            s3.contentIntent = PendingIntent.getActivity(context1, Integer.parseInt((new StringBuilder("-3")).append(s).toString()), s4, 0x48000000);
            s3.flags = ((Notification) (s3)).flags | 0x10;
            s3.ledARGB = ((Notification) (s3)).ledARGB | 0xffff9900;
            s3.flags = ((Notification) (s3)).flags | 1;
            s3.ledOnMS = ((Notification) (s3)).ledOnMS | 0x3e8;
            s3.ledOffMS = ((Notification) (s3)).ledOffMS | 0x2710;
            notificationmanager.notify(Integer.parseInt((new StringBuilder("-3")).append(s).toString()), s3);
            return;
        } else
        {
            long l = System.currentTimeMillis();
            s3 = (NotificationManager)context1.getSystemService("notification");
            s4 = new Notification(0x7f02023f, s2, l);
            s5 = new RemoteViews(context1.getPackageName(), 0x7f030023);
            s5.setImageViewResource(0x7f0b007f, 0x7f02023f);
            s5.setTextViewText(0x7f0b0088, s2);
            s5.setTextViewText(0x7f0b0089, s1);
            s4.contentView = s5;
            s5 = new Intent();
            s5.setClass(context1, com/inponsel/android/scdetail/SCDetailPager);
            s5.setFlags(0x24000000);
            Log.e("generateMessage", (new StringBuilder(String.valueOf(s2))).append("+").append(s1).append("+").append(s7).toString());
            s5.putExtra("sc_id", sc_id);
            s5.putExtra("sc_logo", sc_logo);
            s5.putExtra("sc_c_center", sc_c_center);
            s5.putExtra("sc_ven_center", sc_ven_center);
            s5.putExtra("sc_nama", sc_nama);
            s5.putExtra("sc_merk", sc_merk);
            s5.putExtra("sc_fb", sc_fb);
            s5.putExtra("sc_ytube", sc_ytube);
            s5.putExtra("sc_fb_id", sc_fb_id);
            s5.putExtra("sc_tw", sc_tw);
            s5.putExtra("sc_alamat", sc_alamat);
            s5.putExtra("sc_no_telp", sc_no_telp);
            s5.putExtra("sc_no_telp_ket", sc_no_telp_ket);
            s5.putExtra("sc_email", sc_email);
            s5.putExtra("sc_web", sc_web);
            s5.putExtra("sc_rateAvg", "");
            s5.putExtra("sc_rate1", "");
            s5.putExtra("sc_rate2", "");
            s5.putExtra("sc_rate3", "");
            s5.putExtra("sc_rate4", "");
            s5.putExtra("sc_rate5", "");
            s5.putExtra("sc_total_rate", "");
            s4.contentIntent = PendingIntent.getActivity(context1, Integer.parseInt((new StringBuilder("-3")).append(s).toString()), s5, 0x48000000);
            s4.flags = ((Notification) (s4)).flags | 0x10;
            s4.ledARGB = ((Notification) (s4)).ledARGB | 0xffff9900;
            s4.flags = ((Notification) (s4)).flags | 1;
            s4.ledOnMS = ((Notification) (s4)).ledOnMS | 0x64;
            s4.ledOffMS = ((Notification) (s4)).ledOffMS | 0x64;
            s3.notify(Integer.parseInt((new StringBuilder("-3")).append(s).toString()), s4);
            return;
        }
    }

    private static void generateNotificationKomentarTL(Context context1, String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7)
    {
        String s9 = "";
        if (!Utility.isTabletMDPI(context1));
        Log.e("gambar", s3);
        String s8 = s5;
        if (s6.equals("1"))
        {
            s8 = "Gambar";
            s9 = s5;
        }
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            NotificationManager notificationmanager = (NotificationManager)context1.getSystemService("notification");
            if (s6.equals("1"))
            {
                Log.e("imageUrl", s8);
                s5 = new android.support.v4.app.NotificationCompat.BigPictureStyle();
                s5.setBigContentTitle(s2);
                s5.setSummaryText("InPonsel");
                s4 = (new StringBuilder(String.valueOf(s4))).append(": ").append("Gambar").toString();
                s5.bigPicture(getBitmapContentFromURL(s9));
                s3 = (new android.support.v4.app.NotificationCompat.Builder(context1)).setSmallIcon(0x7f02023f).setAutoCancel(true).setLargeIcon(getBitmapFromURLHP((new StringBuilder(String.valueOf(Util.BASE_PATH_NEWIMAGE))).append(s3).toString(), context1)).setContentTitle(s2).setContentText(s4).setStyle(s5).build();
            } else
            {
                Log.e("Pesan", s8);
                android.support.v4.app.NotificationCompat.BigTextStyle bigtextstyle = new android.support.v4.app.NotificationCompat.BigTextStyle();
                bigtextstyle.setBigContentTitle(s2);
                bigtextstyle.setSummaryText("InPonsel");
                if (s6.equals("tltanggap"))
                {
                    s4 = (new StringBuilder("Tanggapan dari ")).append(s4).append(": ").append(s8).toString();
                    s5 = s4;
                } else
                {
                    s4 = (new StringBuilder(String.valueOf(s4))).append(": ").append(s8).toString();
                    s5 = s4;
                }
                bigtextstyle.bigText(s4);
                s3 = (new android.support.v4.app.NotificationCompat.Builder(context1)).setSmallIcon(0x7f02023f).setAutoCancel(true).setLargeIcon(getBitmapFromURLHP((new StringBuilder(String.valueOf(Util.BASE_PATH_NEWIMAGE))).append(s3).toString(), context1)).setContentTitle(s2).setContentText(s5).setStyle(bigtextstyle).build();
            }
            s4 = new Intent();
            if (s6.contains("conversation"))
            {
                s4.setClass(context1, com/inponsel/android/conversation/ConversationDetailActivity);
            } else
            {
                s4.setClass(context1, com/inponsel/android/timelinedetail/Hal1TLDetailActivity);
            }
            s4.setFlags(0x24000000);
            Log.e("generateMessage", (new StringBuilder(String.valueOf(s2))).append("+").append(s8).append("+").append(s7).toString());
            s4.putExtra("tl_id", s);
            s4.putExtra("act", "gcm");
            s4.putExtra("tl_judul", s2);
            s4.putExtra("namalengkap", s1);
            s3.contentIntent = PendingIntent.getActivity(context1, Integer.parseInt((new StringBuilder("-3")).append(s).toString()), s4, 0x48000000);
            s3.flags = ((Notification) (s3)).flags | 0x10;
            s3.ledARGB = ((Notification) (s3)).ledARGB | 0xffff9900;
            s3.flags = ((Notification) (s3)).flags | 1;
            s3.ledOnMS = ((Notification) (s3)).ledOnMS | 0x3e8;
            s3.ledOffMS = ((Notification) (s3)).ledOffMS | 0x2710;
            notificationmanager.notify(Integer.parseInt((new StringBuilder("-3")).append(s).toString()), s3);
            return;
        } else
        {
            long l = System.currentTimeMillis();
            s3 = (NotificationManager)context1.getSystemService("notification");
            s4 = new Notification(0x7f02023f, s2, l);
            s5 = new RemoteViews(context1.getPackageName(), 0x7f030023);
            s5.setImageViewResource(0x7f0b007f, 0x7f02023f);
            s5.setTextViewText(0x7f0b0088, s2);
            s5.setTextViewText(0x7f0b0089, s8);
            s4.contentView = s5;
            s5 = new Intent();
            s5.setClass(context1, com/inponsel/android/timelinedetail/Hal1TLDetailActivity);
            s5.setFlags(0x24000000);
            Log.e("generateMessage", (new StringBuilder(String.valueOf(s2))).append("+").append(s8).append("+").append(s7).toString());
            s5.putExtra("tl_id", s);
            s5.putExtra("act", "gcm");
            s5.putExtra("tl_judul", s2);
            s5.putExtra("namalengkap", s1);
            s4.contentIntent = PendingIntent.getActivity(context1, Integer.parseInt((new StringBuilder("-3")).append(s).toString()), s5, 0x48000000);
            s4.flags = ((Notification) (s4)).flags | 0x10;
            s4.ledARGB = ((Notification) (s4)).ledARGB | 0xffff9900;
            s4.flags = ((Notification) (s4)).flags | 1;
            s4.ledOnMS = ((Notification) (s4)).ledOnMS | 0x64;
            s4.ledOffMS = ((Notification) (s4)).ledOffMS | 0x64;
            s3.notify(Integer.parseInt((new StringBuilder("-3")).append(s).toString()), s4);
            return;
        }
    }

    private static void generateNotificationKomentarTW(Context context1, String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8, String s9)
    {
        String s10 = "";
        if (!Utility.isTabletMDPI(context1));
        Log.e("gambar", s4);
        if (s8.equals("1"))
        {
            s10 = s5;
        }
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            NotificationManager notificationmanager = (NotificationManager)context1.getSystemService("notification");
            if (s8.equals("1"))
            {
                Log.e("imageUrl", s7);
                s8 = new android.support.v4.app.NotificationCompat.BigPictureStyle();
                s8.setBigContentTitle(s2);
                s8.setSummaryText("InPonsel");
                s6 = (new StringBuilder(String.valueOf(s6))).append(": ").append(s7).toString();
                s8.bigPicture(getBitmapContentFromURL(s10));
                s6 = (new android.support.v4.app.NotificationCompat.Builder(context1)).setSmallIcon(0x7f02023f).setAutoCancel(true).setLargeIcon(getBitmapFromURLHP((new StringBuilder(String.valueOf(Util.BASE_PATH_NEWIMAGE))).append(s4).toString(), context1)).setContentTitle(s2).setContentText(s6).setStyle(s8).build();
            } else
            {
                Log.e("Pesan", s7);
                android.support.v4.app.NotificationCompat.BigTextStyle bigtextstyle = new android.support.v4.app.NotificationCompat.BigTextStyle();
                bigtextstyle.setBigContentTitle(s2);
                bigtextstyle.setSummaryText("InPonsel");
                if (s8.equals("twtanggap"))
                {
                    s6 = (new StringBuilder("Tanggapan dari ")).append(s6).append(": ").append(s7).toString();
                    s8 = s6;
                } else
                {
                    s6 = (new StringBuilder(String.valueOf(s6))).append(": ").append(s7).toString();
                    s8 = s6;
                }
                bigtextstyle.bigText(s6);
                s6 = (new android.support.v4.app.NotificationCompat.Builder(context1)).setSmallIcon(0x7f02023f).setAutoCancel(true).setLargeIcon(getBitmapFromURLHP((new StringBuilder(String.valueOf(Util.BASE_PATH_NEWIMAGE))).append(s4).toString(), context1)).setContentTitle(s2).setContentText(s8).setStyle(bigtextstyle).build();
            }
            s8 = new Intent();
            s8.setClass(context1, com/inponsel/android/details/KomentarTwitter);
            s8.setFlags(0x24000000);
            Log.e("generateMessage", (new StringBuilder(String.valueOf(s2))).append("+").append(s7).append("+").append(s9).toString());
            s8.putExtra("tw_name", s2);
            s8.putExtra("id_tw", s1);
            s8.putExtra("tweet_content", s3);
            s8.putExtra("media_url", s5);
            s8.putExtra("avatar", s4);
            s8.putExtra("tweet_time", s);
            s8.putExtra("screen_name", s2);
            s6.contentIntent = PendingIntent.getActivity(context1, Integer.parseInt((new StringBuilder("-3")).append(s1.substring(0, 5)).toString()), s8, 0x48000000);
            s6.flags = ((Notification) (s6)).flags | 0x10;
            s6.ledARGB = ((Notification) (s6)).ledARGB | 0xffff9900;
            s6.flags = ((Notification) (s6)).flags | 1;
            s6.ledOnMS = ((Notification) (s6)).ledOnMS | 0x3e8;
            s6.ledOffMS = ((Notification) (s6)).ledOffMS | 0x2710;
            notificationmanager.notify(Integer.parseInt((new StringBuilder("-3")).append(s1.substring(0, 5)).toString()), s6);
            return;
        } else
        {
            long l = System.currentTimeMillis();
            s6 = (NotificationManager)context1.getSystemService("notification");
            s8 = new Notification(0x7f02023f, s2, l);
            Object obj = new RemoteViews(context1.getPackageName(), 0x7f030023);
            ((RemoteViews) (obj)).setImageViewResource(0x7f0b007f, 0x7f02023f);
            ((RemoteViews) (obj)).setTextViewText(0x7f0b0088, s2);
            ((RemoteViews) (obj)).setTextViewText(0x7f0b0089, s7);
            s8.contentView = ((RemoteViews) (obj));
            obj = new Intent();
            ((Intent) (obj)).setClass(context1, com/inponsel/android/details/KomentarTwitter);
            ((Intent) (obj)).setFlags(0x24000000);
            Log.e("generateMessage", (new StringBuilder(String.valueOf(s2))).append("+").append(s7).append("+").append(s9).toString());
            ((Intent) (obj)).putExtra("tw_name", s2);
            ((Intent) (obj)).putExtra("id_tw", s1);
            ((Intent) (obj)).putExtra("tweet_content", s3);
            ((Intent) (obj)).putExtra("media_url", s5);
            ((Intent) (obj)).putExtra("avatar", s4);
            ((Intent) (obj)).putExtra("tweet_time", s);
            ((Intent) (obj)).putExtra("screen_name", s2);
            s8.contentIntent = PendingIntent.getActivity(context1, Integer.parseInt((new StringBuilder("-3")).append(s1.substring(0, 5)).toString()), ((Intent) (obj)), 0x48000000);
            s8.flags = ((Notification) (s8)).flags | 0x10;
            s8.ledARGB = ((Notification) (s8)).ledARGB | 0xffff9900;
            s8.flags = ((Notification) (s8)).flags | 1;
            s8.ledOnMS = ((Notification) (s8)).ledOnMS | 0x64;
            s8.ledOffMS = ((Notification) (s8)).ledOffMS | 0x64;
            s6.notify(Integer.parseInt((new StringBuilder("-3")).append(s1.substring(0, 5)).toString()), s8);
            return;
        }
    }

    private static void generateNotificationLikeKom(Context context1, String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7)
    {
        String s8 = "";
        if (!Utility.isTabletMDPI(context1));
        Log.e("gambar", s3);
        s1 = s5;
        if (s6.equals("1"))
        {
            s1 = "Gambar";
            s8 = s5;
        }
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            s5 = (NotificationManager)context1.getSystemService("notification");
            if (s6.equals("1"))
            {
                Log.e("imageUrl", s1);
                s6 = new android.support.v4.app.NotificationCompat.BigPictureStyle();
                s6.setBigContentTitle(s2);
                s6.setSummaryText("InPonsel");
                s4 = (new StringBuilder(String.valueOf(s4))).append(": ").append("Gambar").toString();
                s6.bigPicture(getBitmapContentFromURL(s8));
                s3 = (new android.support.v4.app.NotificationCompat.Builder(context1)).setSmallIcon(0x7f02023f).setAutoCancel(true).setLargeIcon(getBitmapFromURLHP((new StringBuilder(String.valueOf(Util.BASE_PATH_NEWIMAGE))).append(s3).toString(), context1)).setContentTitle(s2).setContentText(s4).setStyle(s6).build();
            } else
            {
                Log.e("Pesan", s1);
                s4 = new android.support.v4.app.NotificationCompat.BigTextStyle();
                s4.setBigContentTitle(s2);
                s4.setSummaryText("InPonsel");
                s4.bigText(s1);
                s3 = (new android.support.v4.app.NotificationCompat.Builder(context1)).setSmallIcon(0x7f02023f).setAutoCancel(true).setLargeIcon(getBitmapFromURLHP((new StringBuilder(String.valueOf(Util.BASE_PATH_NEWIMAGE))).append(s3).toString(), context1)).setContentTitle(s2).setContentText(s1).setStyle(s4).build();
            }
            s4 = new Intent();
            Log.e("generateMessage", (new StringBuilder(String.valueOf(s2))).append("+").append(s1).append("+").append(s7).toString());
            s3.contentIntent = PendingIntent.getActivity(context1, Integer.parseInt((new StringBuilder("-12")).append(s).toString()), s4, 0x48000000);
            s3.flags = ((Notification) (s3)).flags | 0x10;
            s3.ledARGB = ((Notification) (s3)).ledARGB | 0xffff9900;
            s3.flags = ((Notification) (s3)).flags | 1;
            s3.ledOnMS = ((Notification) (s3)).ledOnMS | 0x3e8;
            s3.ledOffMS = ((Notification) (s3)).ledOffMS | 0x2710;
            s5.notify(Integer.parseInt((new StringBuilder("-12")).append(s).toString()), s3);
            return;
        } else
        {
            long l = System.currentTimeMillis();
            s3 = (NotificationManager)context1.getSystemService("notification");
            s4 = new Notification(0x7f02023f, s2, l);
            s5 = new RemoteViews(context1.getPackageName(), 0x7f030023);
            s5.setImageViewResource(0x7f0b007f, 0x7f02023f);
            s5.setTextViewText(0x7f0b0088, s2);
            s5.setTextViewText(0x7f0b0089, s1);
            s4.contentView = s5;
            s5 = new Intent();
            Log.e("generateMessage", (new StringBuilder(String.valueOf(s2))).append("+").append(s1).append("+").append(s7).toString());
            s4.contentIntent = PendingIntent.getActivity(context1, Integer.parseInt((new StringBuilder("-12")).append(s).toString()), s5, 0x48000000);
            s4.flags = ((Notification) (s4)).flags | 0x10;
            s4.ledARGB = ((Notification) (s4)).ledARGB | 0xffff9900;
            s4.flags = ((Notification) (s4)).flags | 1;
            s4.ledOnMS = ((Notification) (s4)).ledOnMS | 0x64;
            s4.ledOffMS = ((Notification) (s4)).ledOffMS | 0x64;
            s3.notify(Integer.parseInt((new StringBuilder("-12")).append(s).toString()), s4);
            return;
        }
    }

    private static void generateNotificationPM(Context context1, String s, String s1, String s2, String s3, String s4, String s5, String s6)
    {
        Log.e("id_to", s3);
        Log.e("id_from", s2);
        String s8 = "";
        if (!Utility.isTabletMDPI(context1));
        String s7 = s;
        if (s5.equals("1"))
        {
            s7 = "Gambar";
            s8 = s;
        }
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            NotificationManager notificationmanager = (NotificationManager)context1.getSystemService("notification");
            if (s5.equals("1"))
            {
                Log.e("imageUrl", s7);
                s = new android.support.v4.app.NotificationCompat.BigPictureStyle();
                s.setBigContentTitle(s1);
                s.setSummaryText("InPonsel");
                s.bigPicture(getBitmapContentFromURL(s8));
                s = (new android.support.v4.app.NotificationCompat.Builder(context1)).setSmallIcon(0x7f020227).setAutoCancel(true).setLargeIcon(getBitmapFromURLAvatar((new StringBuilder(String.valueOf(Util.BASE_PATH_NEWIMAGE))).append(s4).toString(), context1)).setContentTitle(s1).setContentText("Gambar").setStyle(s).build();
            } else
            {
                Log.e("Pesan", s7);
                s = new android.support.v4.app.NotificationCompat.BigTextStyle();
                s.setBigContentTitle(s1);
                s.setSummaryText("InPonsel");
                s.bigText(s7);
                s = (new android.support.v4.app.NotificationCompat.Builder(context1)).setSmallIcon(0x7f020227).setAutoCancel(true).setLargeIcon(getBitmapFromURLAvatar((new StringBuilder(String.valueOf(Util.BASE_PATH_NEWIMAGE))).append(s4).toString(), context1)).setContentTitle(s1).setContentText(s7).setStyle(s).build();
            }
            s5 = new Intent();
            s5.setClass(context1, com/inponsel/android/v2/MessageActivity);
            s5.setFlags(0x24000000);
            Log.e("generateMessage", (new StringBuilder(String.valueOf(s1))).append("+").append(s7).append("+").append(s6).toString());
            s5.putExtra("id_to", s3);
            s5.putExtra("to_name", "");
            s5.putExtra("to_photo", "");
            s5.putExtra("last_message", s7);
            s5.putExtra("notif", "gcm");
            s5.putExtra("id_msg", "");
            s5.putExtra("id_from", s2);
            s5.putExtra("from_name", s1);
            s5.putExtra("from_photo", s4);
            s5.putExtra("message_type", "");
            s5.putExtra("unread_msg", "");
            s5.putExtra("msg_date", "");
            s.contentIntent = PendingIntent.getActivity(context1, Integer.parseInt(s3), s5, 0x48000000);
            s.flags = ((Notification) (s)).flags | 0x10;
            s.ledARGB = ((Notification) (s)).ledARGB | 0xffff9900;
            s.flags = ((Notification) (s)).flags | 1;
            s.ledOnMS = ((Notification) (s)).ledOnMS | 0x3e8;
            s.ledOffMS = ((Notification) (s)).ledOffMS | 0x2710;
            s.sound = Uri.parse((new StringBuilder("android.resource://")).append(context1.getPackageName()).append("/raw/hangouts_message").toString());
            notificationmanager.notify(Integer.parseInt(s3), s);
            return;
        } else
        {
            long l = System.currentTimeMillis();
            s = (NotificationManager)context1.getSystemService("notification");
            s5 = new Notification(0x7f020227, s1, l);
            Object obj = new RemoteViews(context1.getPackageName(), 0x7f030023);
            ((RemoteViews) (obj)).setImageViewResource(0x7f0b007f, 0x7f020227);
            ((RemoteViews) (obj)).setTextViewText(0x7f0b0088, s1);
            ((RemoteViews) (obj)).setTextViewText(0x7f0b0089, s7);
            s5.contentView = ((RemoteViews) (obj));
            obj = new Intent();
            ((Intent) (obj)).setClass(context1, com/inponsel/android/v2/MessageActivity);
            ((Intent) (obj)).setFlags(0x24000000);
            Log.e("generateMessage", (new StringBuilder(String.valueOf(s1))).append("+").append(s7).append("+").append(s6).toString());
            ((Intent) (obj)).putExtra("id_to", s3);
            ((Intent) (obj)).putExtra("to_name", "");
            ((Intent) (obj)).putExtra("to_photo", s4);
            ((Intent) (obj)).putExtra("last_message", s7);
            ((Intent) (obj)).putExtra("notif", "gcm");
            ((Intent) (obj)).putExtra("id_msg", "");
            ((Intent) (obj)).putExtra("id_from", s2);
            ((Intent) (obj)).putExtra("from_name", s1);
            ((Intent) (obj)).putExtra("from_photo", s4);
            ((Intent) (obj)).putExtra("message_type", "");
            ((Intent) (obj)).putExtra("unread_msg", "");
            ((Intent) (obj)).putExtra("msg_date", "");
            s5.contentIntent = PendingIntent.getActivity(context1, Integer.parseInt(s3), ((Intent) (obj)), 0x48000000);
            s5.flags = ((Notification) (s5)).flags | 0x10;
            s5.ledARGB = ((Notification) (s5)).ledARGB | 0xffff9900;
            s5.flags = ((Notification) (s5)).flags | 1;
            s5.ledOnMS = ((Notification) (s5)).ledOnMS | 0x64;
            s5.ledOffMS = ((Notification) (s5)).ledOffMS | 0x64;
            s5.sound = Uri.parse((new StringBuilder("android.resource://")).append(context1.getPackageName()).append("/raw/hangouts_message").toString());
            s.notify(Integer.parseInt(s2), s5);
            return;
        }
    }

    private static void generateNotificationRSS(Context context1, String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7)
    {
        s4 = "";
        if (!Utility.isTabletMDPI(context1));
        Log.e("gambar", s3);
        s1 = s5;
        if (s6.equals("1"))
        {
            s4 = s5;
            s1 = "Gambar";
        }
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            s5 = (NotificationManager)context1.getSystemService("notification");
            if (s6.equals("1"))
            {
                Log.e("imageUrl", s1);
                s6 = new android.support.v4.app.NotificationCompat.BigPictureStyle();
                s6.setBigContentTitle(s2);
                s6.setSummaryText("InPonsel");
                s6.bigPicture(getBitmapContentFromURL(s4));
                s3 = (new android.support.v4.app.NotificationCompat.Builder(context1)).setSmallIcon(0x7f02023f).setAutoCancel(true).setLargeIcon(getBitmapFromURLHP((new StringBuilder(String.valueOf(Util.BASE_PATH_NEWIMAGE))).append(s3).toString(), context1)).setContentTitle(s2).setContentText("Gambar").setStyle(s6).build();
            } else
            {
                Log.e("Pesan", s1);
                s4 = new android.support.v4.app.NotificationCompat.BigTextStyle();
                s4.setBigContentTitle(s2);
                s4.setSummaryText("InPonsel");
                if (!s6.equals("rsstanggap"));
                s4.bigText(s1);
                s3 = (new android.support.v4.app.NotificationCompat.Builder(context1)).setSmallIcon(0x7f02023f).setAutoCancel(true).setLargeIcon(getBitmapFromURLHP((new StringBuilder(String.valueOf(Util.BASE_PATH_NEWIMAGE))).append(s3).toString(), context1)).setContentTitle(s2).setContentText(s1).setStyle(s4).build();
            }
            s4 = new Intent();
            s4.setClass(context1, com/inponsel/android/rssfeeddetail/RSSDetailTab);
            s4.setFlags(0x24000000);
            Log.e("generateMessage", (new StringBuilder(String.valueOf(s2))).append("+").append(s1).append("+").append(s7).toString());
            s4.putExtra("id_rss", s);
            s4.putExtra("rss_title", s2);
            s4.putExtra("notif", "gcm");
            s4.putExtra("actfrom", "rssfeed");
            s4.putExtra("act", "firsttab");
            s3.contentIntent = PendingIntent.getActivity(context1, Integer.parseInt((new StringBuilder("-2")).append(s).toString()), s4, 0x48000000);
            s3.flags = ((Notification) (s3)).flags | 0x10;
            s3.ledARGB = ((Notification) (s3)).ledARGB | 0xffff9900;
            s3.flags = ((Notification) (s3)).flags | 1;
            s3.ledOnMS = ((Notification) (s3)).ledOnMS | 0x3e8;
            s3.ledOffMS = ((Notification) (s3)).ledOffMS | 0x2710;
            s5.notify(Integer.parseInt((new StringBuilder("-2")).append(s).toString()), s3);
            return;
        } else
        {
            long l = System.currentTimeMillis();
            s3 = (NotificationManager)context1.getSystemService("notification");
            s4 = new Notification(0x7f02023f, s2, l);
            s5 = new RemoteViews(context1.getPackageName(), 0x7f030023);
            s5.setImageViewResource(0x7f0b007f, 0x7f02023f);
            s5.setTextViewText(0x7f0b0088, s2);
            s5.setTextViewText(0x7f0b0089, s1);
            s4.contentView = s5;
            s5 = new Intent();
            s5.setClass(context1, com/inponsel/android/rssfeeddetail/RSSDetailTab);
            s5.setFlags(0x24000000);
            Log.e("generateMessage", (new StringBuilder(String.valueOf(s2))).append("+").append(s1).append("+").append(s7).toString());
            s5.putExtra("id_rss", s);
            s5.putExtra("rss_title", s2);
            s5.putExtra("notif", "gcm");
            s5.putExtra("actfrom", "rssfeed");
            s5.putExtra("act", "firsttab");
            s4.contentIntent = PendingIntent.getActivity(context1, Integer.parseInt((new StringBuilder("-2")).append(s).toString()), s5, 0x48000000);
            s4.flags = ((Notification) (s4)).flags | 0x10;
            s4.ledARGB = ((Notification) (s4)).ledARGB | 0xffff9900;
            s4.flags = ((Notification) (s4)).flags | 1;
            s4.ledOnMS = ((Notification) (s4)).ledOnMS | 0x64;
            s4.ledOffMS = ((Notification) (s4)).ledOffMS | 0x64;
            s3.notify(Integer.parseInt((new StringBuilder("-2")).append(s).toString()), s4);
            return;
        }
    }

    public static Bitmap getBitmapContentFromURL(String s)
    {
        try
        {
            s = (HttpURLConnection)(new URL(s)).openConnection();
            s.setDoInput(true);
            s.connect();
            s = BitmapFactory.decodeStream(s.getInputStream());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    public static Bitmap getBitmapFromURLAvatar(String s, Context context1)
    {
        try
        {
            s = (HttpURLConnection)(new URL(s)).openConnection();
            s.setDoInput(true);
            s.connect();
            s = BitmapFactory.decodeStream(s.getInputStream());
            context1 = context1.getResources();
            int i = (int)context1.getDimension(0x1050006);
            s = Bitmap.createScaledBitmap(s, (int)context1.getDimension(0x1050005), i, false);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    public static Bitmap getBitmapFromURLHP(String s, Context context1)
    {
        try
        {
            s = (HttpURLConnection)(new URL(s)).openConnection();
            s.setDoInput(true);
            s.connect();
            s = BitmapFactory.decodeStream(s.getInputStream());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        return s;
    }

    public Bitmap getResizedBitmap(Bitmap bitmap, int i, int j)
    {
        int k = bitmap.getWidth();
        int l = bitmap.getHeight();
        float f = (float)j / (float)k;
        float f1 = (float)i / (float)l;
        Matrix matrix = new Matrix();
        matrix.postScale(f, f1);
        return Bitmap.createBitmap(bitmap, 0, 0, k, l, matrix, false);
    }

    protected void onDeletedMessages(Context context1, int i)
    {
        Log.i("GCMIntentService", "Received deleted messages notification");
        String s = getString(0x7f0c008d, new Object[] {
            Integer.valueOf(i)
        });
        String s1 = getString(0x7f0c008d, new Object[] {
            Integer.valueOf(i)
        });
        String s2 = getString(0x7f0c008d, new Object[] {
            Integer.valueOf(i)
        });
        String s3 = getString(0x7f0c008d, new Object[] {
            Integer.valueOf(i)
        });
        String s4 = getString(0x7f0c008d, new Object[] {
            Integer.valueOf(i)
        });
        CommonUtilities.displayMessage(context1, s, s1);
        generateNotification(context1, s, s1, s3, s2, s4);
    }

    public void onError(Context context1, String s)
    {
        Log.i("GCMIntentService", (new StringBuilder("Received error: ")).append(s).toString());
        CommonUtilities.displayMessage(context1, getString(0x7f0c008b, new Object[] {
            s
        }), getString(0x7f0c008b, new Object[] {
            s
        }));
    }

    protected void onMessage(Context context1, Intent intent)
    {
        String s;
        Log.i("GCMIntentService", "Received message");
        ponselBaseApp = (PonselBaseApp)getApplication();
        ponselBaseApp.getObserver().addObserver(this);
        Object obj;
        if ((double)getResources().getDisplayMetrics().density == 0.75D)
        {
            pixeldens = 35;
        } else
        if (getResources().getDisplayMetrics().density == 1.0F)
        {
            pixeldens = 47;
        } else
        if ((double)getResources().getDisplayMetrics().density == 1.5D)
        {
            pixeldens = 71;
        } else
        if ((double)getResources().getDisplayMetrics().density == 2D)
        {
            pixeldens = 95;
        } else
        if ((double)getResources().getDisplayMetrics().density == 3D)
        {
            pixeldens = 143;
        } else
        if ((double)getResources().getDisplayMetrics().density == 4D)
        {
            pixeldens = 191;
        }
        s = intent.getExtras().getString("notif");
        if (!intent.getExtras().getString("notif").equals("pm")) goto _L2; else goto _L1
_L1:
        title = intent.getExtras().getString("title");
        idcontent = intent.getExtras().getString("id_content");
        gambar = intent.getExtras().getString("gambar");
        id_to = intent.getExtras().getString("id_to");
        msg_type = intent.getExtras().getString("msg_type");
        id_msg = intent.getExtras().getString("id_msg");
        me_message = intent.getExtras().getString("me_message");
        post_date = intent.getExtras().getString("post_date");
        unread = intent.getExtras().getString("unread");
        message = intent.getExtras().getString("message");
        to_name = intent.getExtras().getString("to_name");
        to_photo = intent.getExtras().getString("to_photo");
        id_msg = intent.getExtras().getString("id_msg");
_L9:
        Log.e("onmesage", s);
_L14:
        obj = getSharedPreferences("notif_count_file", 0);
        intent = ((SharedPreferences) (obj)).getString("notif_count", String.valueOf(notif_count));
        obj = ((SharedPreferences) (obj)).getString("notif_id", "0");
        notif_count = Integer.parseInt(intent);
        if (!((String) (obj)).equals(id_to))
        {
            notif_count = notif_count + 1;
        }
        intent = getSharedPreferences("notif_count_file", 2).edit();
        intent.putString("notif_count", String.valueOf(notif_count));
        intent.putString("notif_id", id_to);
        intent.apply();
        CommonUtilities.displayMessage(context1, message, title);
        userFunctions = new UserFunctions();
        db = new DatabaseHandler(this);
        cursor = db.getAllData();
        cursor.moveToFirst();
        try
        {
            user_id = EncodeDecodeAES.decrypt(RestClient.pelihara, cursor.getString(1));
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent) { }
        if (!userFunctions.isUserLoggedIn(getApplicationContext()) || user_id.equals("id_to")) goto _L4; else goto _L3
_L3:
        if (!s.equals("pm")) goto _L6; else goto _L5
_L5:
        Log.e("str_notif_count", (new StringBuilder(String.valueOf(id_to))).append("=").append(idcontent).toString());
        if (!db.checkIfInboxExist(id_to)) goto _L8; else goto _L7
_L7:
        Log.e("checkIfMSGExist", (new StringBuilder("unread=")).append(unread).toString());
        db.update_usrmsg(id_to, message, msg_type, post_date, me_message, unread);
_L13:
        db.checkMSGIfExist(id_msg);
        ponselBaseApp.getObserver().setLoginStat("1");
        generateNotificationPM(context1, message, title, idcontent, id_to, gambar, msg_type, s);
_L4:
        return;
_L2:
label0:
        {
            if (!intent.getExtras().getString("notif").equals("pmgroup"))
            {
                break label0;
            }
            id_to = intent.getExtras().getString("id_to");
            id_hp = intent.getExtras().getString("id_hp");
            merk = intent.getExtras().getString("merk");
            model = intent.getExtras().getString("model");
            codename = intent.getExtras().getString("codename");
            hp_photo = intent.getExtras().getString("hp_photo");
            from_name = intent.getExtras().getString("from_name");
            gambar = intent.getExtras().getString("hp_photo");
            message = intent.getExtras().getString("message");
            type_msg = intent.getExtras().getString("type_msg");
            me_message = intent.getExtras().getString("me_message");
            unread = intent.getExtras().getString("unread");
        }
          goto _L9
label1:
        {
            if (!intent.getExtras().getString("notif").equals("komentar"))
            {
                break label1;
            }
            id_content = intent.getExtras().getString("id_content");
            codename = intent.getExtras().getString("codename");
            title = intent.getExtras().getString("title");
            gambar = (new StringBuilder(String.valueOf(Util.BASE_URL_THUMB_ORI))).append("w=").append(pixeldens).append("&src=").append(intent.getExtras().getString("photo")).toString();
            from_name = intent.getExtras().getString("user_name");
            message = intent.getExtras().getString("message");
            type_msg = intent.getExtras().getString("type_msg");
        }
          goto _L9
label2:
        {
            if (!intent.getExtras().getString("notif").equals("komentartw"))
            {
                break label2;
            }
            tw_time = intent.getExtras().getString("tw_time");
            id_content = intent.getExtras().getString("id_content");
            title = intent.getExtras().getString("title");
            gambar = (new StringBuilder(String.valueOf(Util.BASE_URL_THUMB_ORI))).append("w=").append(pixeldens).append("&src=").append(intent.getExtras().getString("avatar")).toString();
            from_name = intent.getExtras().getString("user_name");
            message = intent.getExtras().getString("komentar");
            content = intent.getExtras().getString("content");
            img_url = intent.getExtras().getString("img_url");
            type_msg = intent.getExtras().getString("type_msg");
        }
          goto _L9
label3:
        {
            if (!intent.getExtras().getString("notif").equals("forum"))
            {
                break label3;
            }
            id_content = intent.getExtras().getString("id_content");
            content = intent.getExtras().getString("content");
            title = intent.getExtras().getString("title");
            user_photo = intent.getExtras().getString("user_photo");
            from_name = intent.getExtras().getString("user_name");
            img_url = intent.getExtras().getString("img_url");
            type_msg = intent.getExtras().getString("type_msg");
            namalengkap = intent.getExtras().getString("namalengkap");
        }
          goto _L9
label4:
        {
            if (!intent.getExtras().getString("notif").equals("likekomen"))
            {
                break label4;
            }
            id_content = intent.getExtras().getString("id_content");
            codename = intent.getExtras().getString("codename");
            title = intent.getExtras().getString("title");
            gambar = (new StringBuilder(String.valueOf(Util.BASE_URL_THUMB_ORI))).append("w=").append(pixeldens).append("&src=").append(intent.getExtras().getString("photo")).toString();
            from_name = intent.getExtras().getString("user_name");
            message = intent.getExtras().getString("message");
            type_msg = intent.getExtras().getString("type_msg");
        }
          goto _L9
        if (!intent.getExtras().getString("notif").equals("likeforum")) goto _L11; else goto _L10
_L10:
        id_content = intent.getExtras().getString("id_content");
        content = intent.getExtras().getString("message");
        title = intent.getExtras().getString("title");
        user_photo = (new StringBuilder(String.valueOf(Util.BASE_URL_THUMB_ORI))).append("w=").append(pixeldens).append("&src=").append(intent.getExtras().getString("photo")).toString();
        from_name = intent.getExtras().getString("user_name");
        img_url = intent.getExtras().getString("img_url");
        type_msg = intent.getExtras().getString("type_msg");
        namalengkap = intent.getExtras().getString("title");
        type_msg = intent.getExtras().getString("type_msg");
          goto _L9
_L11:
        if (!intent.getExtras().getString("notif").equals("rssfav")) goto _L9; else goto _L12
_L12:
        id_content = intent.getExtras().getString("id_content");
        codename = intent.getExtras().getString("codename");
        title = intent.getExtras().getString("title");
        gambar = (new StringBuilder(String.valueOf(Util.BASE_URL_THUMB_ORI))).append("w=").append(pixeldens).append("&src=").append(intent.getExtras().getString("photo")).toString();
        from_name = intent.getExtras().getString("user_name");
        message = intent.getExtras().getString("message");
        type_msg = intent.getExtras().getString("type_msg");
          goto _L9
_L8:
        try
        {
            Log.e("checkIfMSGExist", (new StringBuilder("false")).append(idcontent).toString());
            db.addInbox(id_msg, id_to, title, gambar, idcontent, to_name, to_photo, message, msg_type, last_seen, unread, me_message, post_date);
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            intent.printStackTrace();
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            intent.printStackTrace();
        }
          goto _L13
_L6:
        if (s.equals("pmgroup"))
        {
            try
            {
                intent = getApplicationContext().getSharedPreferences("UnreadGroup", 0).edit();
                intent.putString("unread_group", unread);
                intent.commit();
                GetInboxList();
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent)
            {
                intent.printStackTrace();
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent)
            {
                intent.printStackTrace();
            }
            ponselBaseApp.getObserver().setLoginStat("1");
            generateNotificationGroupChat(context1, id_hp, merk, model, codename, gambar, from_name, message, type_msg, unread, me_message, post_date, s);
            return;
        }
        if (s.equals("komentar"))
        {
            if (type_msg.equals("hp") || type_msg.equals("hptanggap"))
            {
                generateNotificationKomentarHP(context1, id_content, codename, title, gambar, from_name, message, type_msg, s);
                return;
            }
            if (type_msg.equals("rss") || type_msg.equals("rsstanggap"))
            {
                generateNotificationKomentarRSS(context1, id_content, codename, title, gambar, from_name, message, type_msg, s);
                return;
            }
            if (type_msg.contains("tl") || type_msg.equals("tltanggap"))
            {
                generateNotificationKomentarTL(context1, id_content, codename, title, gambar, from_name, message, type_msg, s);
                return;
            }
            if (type_msg.equals("tw") || type_msg.equals("twtanggap"))
            {
                generateNotificationKomentarTW(context1, tw_time, id_content, title, content, gambar, img_url, from_name, message, type_msg, s);
                return;
            }
            if (type_msg.equals("sc") || type_msg.equals("sctanggap"))
            {
                GetSC();
                generateNotificationKomentarSC(context1, id_content, codename, title, gambar, from_name, message, type_msg, s);
                return;
            }
        } else
        {
            if (s.equals("komentartw"))
            {
                generateNotificationKomentarTW(context1, tw_time, id_content, title, content, gambar, img_url, from_name, message, type_msg, s);
                return;
            }
            if (s.equals("forum"))
            {
                generateNotificationForum(context1, id_content, namalengkap, title, content, user_photo, from_name, img_url, type_msg, s);
                return;
            }
            if (s.equals("likeforum"))
            {
                generateNotificationForumLike(context1, id_content, namalengkap, title, content, user_photo, from_name, img_url, type_msg, s);
                return;
            }
            if (s.equals("likekomen"))
            {
                generateNotificationLikeKom(context1, id_content, codename, title, gambar, from_name, message, type_msg, s);
                return;
            }
            if (s.equals("rssfav"))
            {
                generateNotificationRSS(context1, id_content, codename, title, gambar, from_name, message, type_msg, s);
                return;
            }
        }
          goto _L4
        intent;
          goto _L14
    }

    protected boolean onRecoverableError(Context context1, String s)
    {
        Log.i("GCMIntentService", (new StringBuilder("Received recoverable error: ")).append(s).toString());
        CommonUtilities.displayMessage(context1, getString(0x7f0c008c, new Object[] {
            s
        }), getString(0x7f0c008c, new Object[] {
            s
        }));
        return super.onRecoverableError(context1, s);
    }

    protected void onRegistered(Context context1, String s)
    {
        Log.i("GCMIntentService", (new StringBuilder("Device registered: regId = ")).append(s).toString());
        CommonUtilities.displayMessage(context1, "Your device registred with GCM", "Success");
        Log.d("NAME", SplashScreen.name);
        ServerUtilities.register(context1, SplashScreen.name, SplashScreen.email, s);
    }

    protected void onUnregistered(Context context1, String s)
    {
        Log.i("GCMIntentService", "Device unregistered");
        CommonUtilities.displayMessage(context1, getString(0x7f0c0089), getString(0x7f0c0089));
        ServerUtilities.unregister(context1, s);
    }

    void parseJSON(String s)
    {
        JSONObject jsonobject;
        jsonobject = new JSONObject(s);
        s = jsonobject.getJSONArray("InPonsel");
        chat_avaible = jsonobject.getString("success");
        if (jsonobject.getString("success").equals("0")) goto _L2; else goto _L1
_L1:
        int i = 0;
_L7:
        Object obj;
        try
        {
            if (i >= s.length())
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
        jsonobject = s.getJSONObject(i);
        if (!db.checkIfGroupExist(jsonobject.getString("codename"))) goto _L4; else goto _L3
_L3:
        db.update_groupmsg(jsonobject.getString("codename"), jsonobject.getString("username"), jsonobject.getString("message"), jsonobject.getString("type"), jsonobject.getString("post_date"), jsonobject.getString("me"), jsonobject.getString("unread"));
          goto _L5
_L4:
        db.addGroupChat(jsonobject.getString("id"), jsonobject.getString("merk"), jsonobject.getString("model"), jsonobject.getString("codename"), jsonobject.getString("hp_gambar"), jsonobject.getString("username"), jsonobject.getString("message"), jsonobject.getString("type"), jsonobject.getString("unread"), jsonobject.getString("me"), jsonobject.getString("post_date"));
          goto _L5
        obj;
        ((SQLException) (obj)).printStackTrace();
          goto _L5
        obj;
        ((Exception) (obj)).printStackTrace();
          goto _L5
_L2:
        return;
_L5:
        i++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    void parseJSONSC(String s)
    {
        JSONObject jsonobject = new JSONObject(s);
        s = jsonobject.getJSONArray("InPonsel");
        if (jsonobject.getString("success").equals("0"))
        {
            break MISSING_BLOCK_LABEL_287;
        }
        int i = 0;
_L1:
        JSONObject jsonobject1;
        Object obj;
        try
        {
            if (i >= s.length())
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
        jsonobject1 = s.getJSONObject(i);
        sc_id = jsonobject1.getString("id_sc");
        sc_nama = jsonobject1.getString("sc_nama");
        sc_merk = jsonobject1.getString("sc_merk");
        sc_fb = jsonobject1.getString("sc_fb");
        sc_ytube = jsonobject1.getString("sc_ytube");
        sc_fb_id = jsonobject1.getString("sc_fb_id");
        sc_tw = jsonobject1.getString("sc_tw");
        sc_logo = (new StringBuilder(String.valueOf(Util.BASE_PATH_BRANDS))).append(jsonobject1.getString("sc_logo")).toString();
        sc_merk_kettamb = jsonobject1.getString("ket_tambahan");
        sc_prov = jsonobject1.getString("provinsi");
        sc_kot = jsonobject1.getString("kota");
        sc_alamat = jsonobject1.getString("alamat");
        sc_no_telp = jsonobject1.getString("no_telp");
        sc_no_telp_ket = jsonobject1.getString("no_telp_ket");
        sc_ven_center = jsonobject1.getString("c_center");
        sc_c_center = jsonobject1.getString("sc_c_center");
        sc_email = jsonobject1.getString("email");
        sc_web = jsonobject1.getString("web_url");
        Log.e("sc_nama", sc_nama);
_L2:
        i++;
          goto _L1
        obj;
        ((SQLException) (obj)).printStackTrace();
          goto _L2
        obj;
        ((Exception) (obj)).printStackTrace();
          goto _L2
    }

    public void update(Observable observable, Object obj)
    {
        ponselBaseApp.getObserver().getLoginStat();
    }

}
