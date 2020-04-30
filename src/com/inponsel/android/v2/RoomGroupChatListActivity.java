// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
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
import com.inponsel.android.adapter.ListGroupMemberAdapter;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.pencariangen.TabPencarian;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.MyObjectRequest;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.sherlock.navigationdrawer.compat.SherlockActionBarDrawerToggle;
import java.util.ArrayList;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            BaseDrawer, RoomChatActivity

public class RoomGroupChatListActivity extends BaseDrawer
    implements android.view.View.OnClickListener, Observer
{
    class MyTimerTask extends TimerTask
    {

        final RoomGroupChatListActivity this$0;

        public void run()
        {
            Log.e("timertask", "running");
            runOnUiThread(new Runnable() {

                final MyTimerTask this$1;

                public void run()
                {
                    if (db.getGroupChatCount() > 0)
                    {
                        if (countRefresh > 0 && netInfo != null && netInfo.isConnected())
                        {
                            Log.e("refresh", "1");
                            pMessageAdapter = new ListGroupMemberAdapter(_fld0, 0x7f0300c1, listpMessageArrayList);
                            listPMessage.setAdapter(pMessageAdapter);
                            GetInboxList();
                            return;
                        } else
                        {
                            Log.e("refresh", "2");
                            RoomGroupChatListActivity roomgroupchatlistactivity = _fld0;
                            roomgroupchatlistactivity.countRefresh = roomgroupchatlistactivity.countRefresh + 1;
                            listpMessageArrayList = loadInboxDB();
                            pMessageAdapter = new ListGroupMemberAdapter(_fld0, 0x7f0300c1, listpMessageArrayList);
                            listPMessage.setAdapter(pMessageAdapter);
                            loadDataInbox();
                            return;
                        }
                    } else
                    {
                        Log.e("refresh", "3");
                        pMessageAdapter = new ListGroupMemberAdapter(_fld0, 0x7f0300c1, listpMessageArrayList);
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
            this$0 = RoomGroupChatListActivity.this;
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
    ListGroupMemberAdapter pMessageAdapter;
    ProgressBar progressbar_middle;
    String t;
    private String tag_json_obj;
    Timer timer;
    String to_name;
    String to_photo;
    TextView txt_empty;
    String unread_msg;

    public RoomGroupChatListActivity()
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
        MyObjectRequest myobjectrequest = new MyObjectRequest((new StringBuilder(String.valueOf(Util.BASE_PATH_MSG))).append("list_chat_group").append(Utility.BASE_FORMAT).append("?").append("id_user=").append(user_id).append("&t=").append(t).toString(), new com.android.volley.Response.Listener() {

            final RoomGroupChatListActivity this$0;

            public volatile void onResponse(Object obj)
            {
                onResponse((JSONObject)obj);
            }

            public void onResponse(JSONObject jsonobject)
            {
                parseJSON(jsonobject.toString());
                pMessageAdapter.setListArray(listpMessageArrayList);
                pMessageAdapter.notifyDataSetChanged();
                hideProgressDialog();
                ponselBaseApp.getObserver().setLoginStat("1");
            }

            
            {
                this$0 = RoomGroupChatListActivity.this;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final RoomGroupChatListActivity this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
                hideProgressDialog();
            }

            
            {
                this$0 = RoomGroupChatListActivity.this;
                super();
            }
        }, "test", "test");
        PonselBaseApp.getInstance().addToRequestQueue(myobjectrequest, tag_json_obj);
    }

    private void JoinLeaveGroup(String s, final String codename, String s1, String s2)
    {
        s = (new StringBuilder(String.valueOf(Util.BASE_PATH_MSG))).append("join_leave_group").append(Utility.BASE_FORMAT).append("?id_user=").append(s).append("&id_conv=").append(codename).append("&stat=").append(s1).append("&t=").append(s2).toString();
        Log.e("urlJoinGroup", s);
        s = new MyObjectRequest(s, new com.android.volley.Response.Listener() {

            final RoomGroupChatListActivity this$0;
            private final String val$codename;

            public volatile void onResponse(Object obj)
            {
                onResponse((JSONObject)obj);
            }

            public void onResponse(JSONObject jsonobject)
            {
                Log.e("responseGroup", jsonobject.toString());
                if (!jsonobject.toString().trim().equals("{\"response\":1}"))
                {
                    db.delete_groupchat(codename);
                }
                ponselBaseApp.getObserver().setLoginStat("1");
            }

            
            {
                this$0 = RoomGroupChatListActivity.this;
                codename = s;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final RoomGroupChatListActivity this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
            }

            
            {
                this$0 = RoomGroupChatListActivity.this;
                super();
            }
        }, "test", "test");
        PonselBaseApp.getInstance().addToRequestQueue(s, "jobj_req");
    }

    private void LoginPopup(String s, String s1, final String codename)
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle(s);
        builder.setMessage(s1);
        Log.e("codenameD", codename);
        builder.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

            final RoomGroupChatListActivity this$0;
            private final String val$codename;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                JoinLeaveGroup(user_id, codename, "0", t);
            }

            
            {
                this$0 = RoomGroupChatListActivity.this;
                codename = s;
                super();
            }
        });
        builder.setNegativeButton("Batal", new android.content.DialogInterface.OnClickListener() {

            final RoomGroupChatListActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$0 = RoomGroupChatListActivity.this;
                super();
            }
        });
        builder.show();
    }

    private void OnlineStatGroup(String s, String s1, String s2, String s3, String s4)
    {
        Log.e("sendto2", (new StringBuilder("from ")).append(s1).append(" to ").append(s1).toString());
        s = (new StringBuilder(String.valueOf(Util.BASE_PATH_MSG))).append("online_status_group").append(Utility.BASE_FORMAT).append("?id_user=").append(s).append("&id_conv=").append(s1).append("&stat=").append(s2).append("&t=").append(s3).toString();
        Log.e("OnlineStatGroup", s);
        s = new MyObjectRequest(s, new com.android.volley.Response.Listener() {

            final RoomGroupChatListActivity this$0;

            public volatile void onResponse(Object obj)
            {
                onResponse((JSONObject)obj);
            }

            public void onResponse(JSONObject jsonobject)
            {
            }

            
            {
                this$0 = RoomGroupChatListActivity.this;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final RoomGroupChatListActivity this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
            }

            
            {
                this$0 = RoomGroupChatListActivity.this;
                super();
            }
        }, "test", "test");
        PonselBaseApp.getInstance().addToRequestQueue(s, tag_json_obj);
    }

    private void hideProgressDialog()
    {
        if (layout_empty.getVisibility() == 0)
        {
            if (chat_avaible.equals("0"))
            {
                layout_empty.setVisibility(0);
                txt_empty.setText("Belum ada Chatroom diikuti");
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
                if (db.getGroupChatCount() <= 0)
                {
                    break label0;
                }
                Log.e("getGroupChatCount", String.valueOf(db.getGroupChatCount()));
                progressbar_middle.setVisibility(8);
                layout_empty.setVisibility(8);
            }
            return;
        }
        Log.e("countRefresh", String.valueOf(countRefresh));
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
        cursor = db.getGroupChatData();
        if (!cursor.moveToFirst()) goto _L2; else goto _L1
_L1:
        do
        {
            ListModel listmodel = new ListModel();
            listmodel.setId_hp(cursor.getString(cursor.getColumnIndex("id_hp")));
            listmodel.setMerk(cursor.getString(cursor.getColumnIndex("merk")));
            listmodel.setModel(cursor.getString(cursor.getColumnIndex("model")));
            listmodel.setFrom_name(cursor.getString(cursor.getColumnIndex("from_name")));
            listmodel.setFrom_photo(cursor.getString(cursor.getColumnIndex("hp_photo")));
            listmodel.setGambar(cursor.getString(cursor.getColumnIndex("hp_photo")));
            listmodel.setCodename(cursor.getString(cursor.getColumnIndex("codename")));
            listmodel.setLast_message(cursor.getString(cursor.getColumnIndex("last_message")));
            listmodel.setMessage_type(cursor.getString(cursor.getColumnIndex("message_type")));
            listmodel.setMsg_date(cursor.getString(cursor.getColumnIndex("post_date")));
            listmodel.setUnread_msg(cursor.getString(cursor.getColumnIndex("unread_msg")));
            listmodel.setMe_message(cursor.getString(cursor.getColumnIndex("message_me")));
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
        menu_GroupChat.setBackgroundResource(0x7f0201cf);
        menu_GroupChat.setEnabled(false);
        int i;
        int j;
        try
        {
            bundle = ((PonselBaseApp)getApplication()).getTracker(com.inponsel.android.adapter.PonselBaseApp.TrackerName.APP_TRACKER);
            bundle.setScreenName("Halaman GroupChat");
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
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFFFFF'>Chat Room</font>"));
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
        pMessageAdapter = new ListGroupMemberAdapter(this, 0x7f0300c1, listpMessageArrayList);
        listPMessage.setAdapter(pMessageAdapter);
        listPMessage.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final RoomGroupChatListActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int k, long l)
            {
                adapterview = new Intent(getApplicationContext(), com/inponsel/android/v2/RoomChatActivity);
                adapterview.putExtra("id_from", user_id);
                adapterview.putExtra("from_name", username);
                adapterview.putExtra("from_photo", pMessageAdapter.getListModel(k).getGambar());
                adapterview.putExtra("to_photo", pMessageAdapter.getListModel(k).getGambar());
                adapterview.putExtra("id_hph", pMessageAdapter.getListModel(k).getId_hp());
                adapterview.putExtra("merk", pMessageAdapter.getListModel(k).getMerk());
                adapterview.putExtra("model", pMessageAdapter.getListModel(k).getModel());
                adapterview.putExtra("codename", (new StringBuilder(String.valueOf(pMessageAdapter.getListModel(k).getCodename()))).append("-").append(pMessageAdapter.getListModel(k).getCodename()).toString());
                OnlineStatGroup(user_id, pMessageAdapter.getListModel(k).getCodename(), "1", t, "");
                startActivityForResult(adapterview, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = RoomGroupChatListActivity.this;
                super();
            }
        });
        listPMessage.setOnItemLongClickListener(new android.widget.AdapterView.OnItemLongClickListener() {

            final RoomGroupChatListActivity this$0;

            public boolean onItemLongClick(AdapterView adapterview, View view, int k, long l)
            {
                LoginPopup("Perhatian", "Berhenti mengikuti chat room ini?", pMessageAdapter.getListModel(k).getCodename().toString());
                return true;
            }

            
            {
                this$0 = RoomGroupChatListActivity.this;
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
        ((ListModel) (obj)).setId_hp(jsonobject.getString("id"));
        ((ListModel) (obj)).setId_msg(jsonobject.getString("id_msg"));
        ((ListModel) (obj)).setMerk(jsonobject.getString("merk"));
        ((ListModel) (obj)).setModel(jsonobject.getString("model"));
        ((ListModel) (obj)).setFrom_name(jsonobject.getString("username"));
        ((ListModel) (obj)).setFrom_photo(jsonobject.getString("hp_gambar"));
        ((ListModel) (obj)).setGambar(jsonobject.getString("hp_gambar"));
        ((ListModel) (obj)).setCodename(jsonobject.getString("codename"));
        ((ListModel) (obj)).setLast_message(jsonobject.getString("message"));
        ((ListModel) (obj)).setMessage_type(jsonobject.getString("type"));
        ((ListModel) (obj)).setMsg_date(jsonobject.getString("post_date"));
        ((ListModel) (obj)).setUnread_msg(jsonobject.getString("unread"));
        ((ListModel) (obj)).setMe_message(jsonobject.getString("me"));
        if (!db.checkIfGroupExist(jsonobject.getString("codename"))) goto _L2; else goto _L1
_L1:
        db.update_groupmsg(jsonobject.getString("codename"), jsonobject.getString("username"), jsonobject.getString("message"), jsonobject.getString("type"), jsonobject.getString("post_date"), jsonobject.getString("me"), jsonobject.getString("unread"));
_L3:
        listpMessageArrayList.add(obj);
        i++;
        break MISSING_BLOCK_LABEL_58;
_L2:
        db.addGroupChat(jsonobject.getString("id"), jsonobject.getString("merk"), jsonobject.getString("model"), jsonobject.getString("codename"), jsonobject.getString("hp_gambar"), jsonobject.getString("username"), jsonobject.getString("message"), jsonobject.getString("type"), jsonobject.getString("unread"), jsonobject.getString("me"), jsonobject.getString("post_date"));
          goto _L3
        obj1;
        ((SQLException) (obj1)).printStackTrace();
          goto _L3
        obj1;
        ((Exception) (obj1)).printStackTrace();
          goto _L3
    }





}
