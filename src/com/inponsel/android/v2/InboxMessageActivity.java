// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.SQLException;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.android.volley.VolleyError;
import com.google.android.gms.analytics.Tracker;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.adapter.ListUserMessageAdapter;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.pencariangen.TabPencarian;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.MyObjectRequest;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.sherlock.navigationdrawer.compat.SherlockActionBarDrawerToggle;
import java.util.ArrayList;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            BaseDrawer, MessageActivity

public class InboxMessageActivity extends BaseDrawer
    implements android.view.View.OnClickListener, Observer
{
    class MyTimerTask extends TimerTask
    {

        final InboxMessageActivity this$0;

        public void run()
        {
            Log.e("timertask", "running");
            runOnUiThread(new Runnable() {

                final MyTimerTask this$1;

                public void run()
                {
                    if (db.getInBoxCount() > 0)
                    {
                        listpMessageArrayList = loadInboxDB();
                        pMessageAdapter = new ListUserMessageAdapter(_fld0, 0x7f0300c0, listpMessageArrayList);
                        listPMessage.setAdapter(pMessageAdapter);
                        loadDataInbox();
                        return;
                    } else
                    {
                        InboxMessageActivity inboxmessageactivity = _fld0;
                        inboxmessageactivity.countRefresh = inboxmessageactivity.countRefresh + 1;
                        pMessageAdapter = new ListUserMessageAdapter(_fld0, 0x7f0300c0, listpMessageArrayList);
                        listPMessage.setAdapter(pMessageAdapter);
                        GetInboxList();
                        return;
                    }
                }

            
            {
                this$1 = MyTimerTask.this;
                super();
            }
            });
        }


        MyTimerTask()
        {
            this$0 = InboxMessageActivity.this;
            super();
        }
    }


    String chat_avaible;
    ConnectivityManager cm;
    int countRefresh;
    String from_name;
    String from_photo;
    String id_from;
    String id_msg;
    String id_to;
    String last_message;
    String last_seen;
    LinearLayout layout_empty;
    ListView listPMessage;
    ArrayList listpMessageArrayList;
    String me_message;
    String message_type;
    String msg_date;
    MyTimerTask myTimerTask;
    NetworkInfo netInfo;
    ListUserMessageAdapter pMessageAdapter;
    ProgressBar progressbar_middle;
    String t;
    private String tag_json_obj;
    Timer timer;
    String to_name;
    String to_photo;
    TextView txt_empty;
    String unread_msg;

    public InboxMessageActivity()
    {
        tag_json_obj = "jobj_req";
        countRefresh = 0;
        listpMessageArrayList = null;
        chat_avaible = "";
        t = Utility.session(RestClient.pelihara);
    }

    private void GetInboxList()
    {
        showProgressDialog();
        Object obj = (new StringBuilder(String.valueOf(Util.BASE_PATH_MSG))).append("list_chat").append(Utility.BASE_FORMAT).append("?").append("to=").append(user_id).append("&t=").append(t).toString();
        Log.e("urlGetInbox", ((String) (obj)));
        obj = new MyObjectRequest(((String) (obj)), new com.android.volley.Response.Listener() {

            final InboxMessageActivity this$0;

            public volatile void onResponse(Object obj1)
            {
                onResponse((JSONObject)obj1);
            }

            public void onResponse(JSONObject jsonobject)
            {
                parseJSON(jsonobject.toString());
                pMessageAdapter.setListArray(listpMessageArrayList);
                pMessageAdapter.notifyDataSetChanged();
                hideProgressDialog();
                ponselBaseApp.getObserver().setUpdateType("inboxchatroom");
                ponselBaseApp.getObserver().setLoginStat("1");
            }

            
            {
                this$0 = InboxMessageActivity.this;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final InboxMessageActivity this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
                hideProgressDialog();
            }

            
            {
                this$0 = InboxMessageActivity.this;
                super();
            }
        }, "test", "test");
        PonselBaseApp.getInstance().addToRequestQueue(((com.android.volley.Request) (obj)), tag_json_obj);
    }

    private void hideProgressDialog()
    {
        if (layout_empty.getVisibility() == 0)
        {
            if (chat_avaible.equals("0"))
            {
                layout_empty.setVisibility(0);
                txt_empty.setText("Belum ada pesan");
            } else
            {
                layout_empty.setVisibility(8);
            }
            progressbar_middle.setVisibility(8);
        }
    }

    private void showProgressDialog()
    {
label0:
        {
            if (layout_empty.getVisibility() != 0)
            {
                if (db.getInBoxCount() <= 0)
                {
                    break label0;
                }
                progressbar_middle.setVisibility(8);
                layout_empty.setVisibility(8);
            }
            return;
        }
        if (countRefresh > 1)
        {
            progressbar_middle.setVisibility(8);
        } else
        {
            progressbar_middle.setVisibility(0);
        }
        layout_empty.setVisibility(0);
    }

    private void starttask()
    {
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

    public void loadDataInbox()
    {
        listpMessageArrayList.size();
        if (netInfo != null && netInfo.isConnected())
        {
            GetInboxList();
        }
    }

    public ArrayList loadInboxDB()
    {
        ArrayList arraylist;
        Cursor cursor;
        arraylist = new ArrayList();
        cursor = db.getINBOXData();
        if (!cursor.moveToFirst()) goto _L2; else goto _L1
_L1:
        do
        {
            id_msg = String.valueOf(cursor.getString(1));
            id_from = EncodeDecodeAES.decrypt(RestClient.pelihara, String.valueOf(cursor.getString(2)));
            from_name = String.valueOf(cursor.getString(3));
            from_photo = String.valueOf(cursor.getString(4));
            id_to = EncodeDecodeAES.decrypt(RestClient.pelihara, String.valueOf(cursor.getString(5)));
            to_name = String.valueOf(cursor.getString(6));
            to_photo = String.valueOf(cursor.getString(7));
            last_message = String.valueOf(cursor.getString(8));
            message_type = String.valueOf(cursor.getString(9));
            last_seen = String.valueOf(cursor.getString(10));
            unread_msg = String.valueOf(cursor.getString(11));
            me_message = String.valueOf(cursor.getString(12));
            msg_date = String.valueOf(cursor.getString(13));
            ListModel listmodel = new ListModel();
            listmodel.setId_msg(id_msg);
            listmodel.setId_from(id_from);
            listmodel.setFrom_name(from_name);
            listmodel.setFrom_photo(from_photo);
            listmodel.setId_to(id_to);
            listmodel.setTo_name(to_name);
            listmodel.setTo_photo(to_photo);
            listmodel.setLast_message(last_message);
            listmodel.setMessage_type(message_type);
            listmodel.setLast_seen(last_seen);
            listmodel.setUnread_msg(unread_msg);
            listmodel.setMe_message(me_message);
            listmodel.setMsg_date(msg_date);
            arraylist.add(listmodel);
        } while (cursor.moveToNext());
        listPMessage.setVisibility(0);
_L4:
        db.close();
        return arraylist;
_L2:
        try
        {
            Log.e("getINBOXData", "nol");
        }
        catch (Exception exception) { }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        pMessageAdapter.notifyDataSetChanged();
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
            finish();
            overridePendingTransition(0x7f040001, 0x7f040002);
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f0300dc, null, false);
        mDrawerLayout.addView(bundle, 0);
        menu_pesan.setBackgroundResource(0x7f0201cf);
        menu_pesan.setEnabled(false);
        int i;
        int j;
        try
        {
            bundle = ((PonselBaseApp)getApplication()).getTracker(com.inponsel.android.adapter.PonselBaseApp.TrackerName.APP_TRACKER);
            bundle.setScreenName("Inbox");
            bundle.send((new com.google.android.gms.analytics.HitBuilders.AppViewBuilder()).build());
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        bundle = getSharedPreferences("notif_count_file", 2).edit();
        bundle.putString("notif_count", "0");
        bundle.putString("notif_id", "0");
        bundle.apply();
        Utility.removeMSGNotif(getApplicationContext(), 0);
        Utility.removeMSGNotif(getApplicationContext(), 999);
        cm = (ConnectivityManager)getSystemService("connectivity");
        netInfo = cm.getActiveNetworkInfo();
        imageLoader2 = ImageLoader.getInstance();
        imageLoader2.init(ImageLoaderConfiguration.createDefault(this));
        options = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showImageForEmptyUri(0x7f020297).showImageOnFail(0x7f020297).cacheInMemory(true).imageScaleType(ImageScaleType.EXACTLY).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).build();
        t = Utility.session(t);
        actionBar = getSupportActionBar();
        actionBar.setDisplayUseLogoEnabled(useLogo);
        actionBar.setBackgroundDrawable(getResources().getDrawable(0x7f0200e5));
        j = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        i = j;
        if (j == 0)
        {
            i = 0x7f0b0037;
        }
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFFFFF'>Inbox</font>"));
        bundle = (TextView)findViewById(i);
        bundle.setSelected(true);
        bundle.setTextColor(Color.parseColor("#FFFFFF"));
        bundle.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        t = Utility.session(t);
        layout_empty = (LinearLayout)findViewById(0x7f0b0091);
        layout_empty.setVisibility(8);
        progressbar_middle = (ProgressBar)findViewById(0x7f0b00ca);
        txt_empty = (TextView)findViewById(0x7f0b0093);
        listPMessage = (ListView)findViewById(0x7f0b06b2);
        listpMessageArrayList = new ArrayList();
        pMessageAdapter = new ListUserMessageAdapter(this, 0x7f0300c0, listpMessageArrayList);
        listPMessage.setAdapter(pMessageAdapter);
        listPMessage.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final InboxMessageActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int k, long l)
            {
                adapterview = new Intent(getApplicationContext(), com/inponsel/android/v2/MessageActivity);
                pMessageAdapter.getListModel(k).setUnread_msg("0");
                id_msg = pMessageAdapter.getListModel(k).getId_msg();
                id_to = pMessageAdapter.getListModel(k).getId_from();
                from_name = pMessageAdapter.getListModel(k).getFrom_name();
                from_photo = pMessageAdapter.getListModel(k).getFrom_photo();
                id_from = pMessageAdapter.getListModel(k).getId_to();
                to_name = pMessageAdapter.getListModel(k).getTo_name();
                to_photo = pMessageAdapter.getListModel(k).getTo_photo();
                last_message = pMessageAdapter.getListModel(k).getLast_message();
                message_type = pMessageAdapter.getListModel(k).getMessage_type();
                unread_msg = pMessageAdapter.getListModel(k).getUnread_msg();
                msg_date = pMessageAdapter.getListModel(k).getMsg_date();
                adapterview.putExtra("id_msg", id_msg);
                adapterview.putExtra("id_from", id_from);
                adapterview.putExtra("from_name", from_name);
                adapterview.putExtra("from_photo", from_photo);
                adapterview.putExtra("id_to", id_to);
                adapterview.putExtra("to_name", to_name);
                adapterview.putExtra("to_photo", to_photo);
                adapterview.putExtra("last_message", last_message);
                adapterview.putExtra("message_type", message_type);
                adapterview.putExtra("unread_msg", unread_msg);
                adapterview.putExtra("msg_date", msg_date);
                Log.e("id_to", id_to);
                Log.e("id_from", id_from);
                startActivityForResult(adapterview, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = InboxMessageActivity.this;
                super();
            }
        });
        timer = new Timer();
        myTimerTask = new MyTimerTask();
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getSupportMenuInflater().inflate(0x7f0f0002, menu);
        return super.onCreateOptionsMenu(menu);
    }

    protected void onDestroy()
    {
        super.onDestroy();
        stopTask();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return true;

        case 16908332: 
            mDrawerToggle.onOptionsItemSelected(menuitem);
            return true;

        case 2131429682: 
            startActivity(new Intent(getApplicationContext(), com/inponsel/android/pencariangen/TabPencarian));
            break;
        }
        return true;
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
        Object obj;
        obj = new JSONObject(s);
        listpMessageArrayList = new ArrayList();
        s = ((JSONObject) (obj)).getJSONArray("InPonsel");
        chat_avaible = ((JSONObject) (obj)).getString("success");
        JSONObject jsonobject;
        Object obj1;
        int i;
        if (!((JSONObject) (obj)).getString("success").equals("0"))
        {
            i = 0;
        } else
        {
            return;
        }
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
        obj = new ListModel();
        ((ListModel) (obj)).setId_msg(jsonobject.getString("id"));
        ((ListModel) (obj)).setId_from(jsonobject.getString("id_from"));
        ((ListModel) (obj)).setFrom_name(jsonobject.getString("from_name"));
        ((ListModel) (obj)).setFrom_photo(jsonobject.getString("from_photo"));
        ((ListModel) (obj)).setId_to(jsonobject.getString("id_to"));
        ((ListModel) (obj)).setTo_name(jsonobject.getString("to_name"));
        ((ListModel) (obj)).setTo_photo(jsonobject.getString("to_photo"));
        ((ListModel) (obj)).setLast_message(jsonobject.getString("last_message"));
        ((ListModel) (obj)).setMessage_type(jsonobject.getString("message_type"));
        ((ListModel) (obj)).setMsg_date(jsonobject.getString("post_date"));
        ((ListModel) (obj)).setUnread_msg(jsonobject.getString("unread"));
        ((ListModel) (obj)).setMe_message(jsonobject.getString("me"));
        if (!db.checkIfInboxExist(jsonobject.getString("id_from"))) goto _L2; else goto _L1
_L1:
        db.update_usrmsg(jsonobject.getString("id_from"), jsonobject.getString("last_message"), jsonobject.getString("message_type"), jsonobject.getString("post_date"), jsonobject.getString("me"), jsonobject.getString("unread"));
_L3:
        listpMessageArrayList.add(obj);
        i++;
        break MISSING_BLOCK_LABEL_57;
_L2:
        db.addInbox(jsonobject.getString("id"), jsonobject.getString("id_from"), jsonobject.getString("from_name"), jsonobject.getString("from_photo"), jsonobject.getString("id_to"), jsonobject.getString("to_name"), jsonobject.getString("to_photo"), jsonobject.getString("last_message"), jsonobject.getString("message_type"), jsonobject.getString("last_seen"), jsonobject.getString("unread"), jsonobject.getString("me"), jsonobject.getString("post_date"));
          goto _L3
        obj1;
        ((SQLException) (obj1)).printStackTrace();
          goto _L3
        obj1;
        ((Exception) (obj1)).printStackTrace();
          goto _L3
    }


}
