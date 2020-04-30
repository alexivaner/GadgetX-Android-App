// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.android.volley.VolleyError;
import com.google.android.gms.analytics.Tracker;
import com.inponsel.android.adapter.ListHPPeopleAdapter;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.pencariangen.TabPencarian;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.MyObjectRequest;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import java.net.URLDecoder;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            ProfileOtherUser

public class RoomPenggunaHp extends SherlockFragmentActivity
{

    ActionBar actionBar;
    int actionBarTitleId;
    String bottom_id;
    String codename;
    int countRefresh;
    Cursor cursor;
    DatabaseHandler db;
    String email_user;
    Bundle extras;
    GridView gridPeople;
    LinearLayout grup_footer;
    ListHPPeopleAdapter hpPeopleAdapter;
    ArrayList hpPeopleArrayList;
    String kota;
    String kota_id;
    LinearLayout layout_empty;
    LinearLayout layout_footerProg;
    String merk;
    String model;
    String nama_asli;
    String namalengkap;
    String people_count;
    ProgressBar progressbar_middle;
    String prov;
    String t;
    private String tag_json_obj;
    String top_id;
    TextView txt_empty;
    TextView txtbtnfooter;
    String urlPenggunaHp;
    private boolean useLogo;
    protected UserFunctions userFunctions;
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

    public RoomPenggunaHp()
    {
        tag_json_obj = "jobj_req";
        people_count = "";
        bottom_id = "";
        top_id = "";
        codename = "";
        kota = "";
        kota_id = "";
        prov = "";
        merk = "";
        model = "";
        namalengkap = "";
        user_photo = "";
        username = "";
        urlPenggunaHp = "";
        countRefresh = 0;
        hpPeopleArrayList = null;
        useLogo = false;
        actionBarTitleId = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        t = Utility.session(RestClient.pelihara);
    }

    private void GetPeopleList()
    {
        showProgressDialog();
        Log.e("kota", kota);
        if (kota.equals(""))
        {
            MyObjectRequest myobjectrequest;
            try
            {
                Tracker tracker = ((PonselBaseApp)getApplication()).getTracker(com.inponsel.android.adapter.PonselBaseApp.TrackerName.APP_TRACKER);
                tracker.setScreenName((new StringBuilder("Pengguna ")).append(namalengkap).toString());
                tracker.send((new com.google.android.gms.analytics.HitBuilders.AppViewBuilder()).build());
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
            urlPenggunaHp = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("pengguna_hp").append(Utility.BASE_FORMAT).append("?").append("codename=").append(codename).append("&t=").append(t).toString();
        } else
        {
            try
            {
                Tracker tracker1 = ((PonselBaseApp)getApplication()).getTracker(com.inponsel.android.adapter.PonselBaseApp.TrackerName.APP_TRACKER);
                tracker1.setScreenName((new StringBuilder("Pengguna ")).append(namalengkap).append(" di ").append(kota).toString());
                tracker1.send((new com.google.android.gms.analytics.HitBuilders.AppViewBuilder()).build());
            }
            catch (Exception exception1)
            {
                exception1.printStackTrace();
            }
            urlPenggunaHp = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("pengguna_hp_kota").append(Utility.BASE_FORMAT).append("?").append("codename=").append(codename).append("&kota=").append(kota_id).append("&prov=").append(prov).append("&t=").append(t).toString();
        }
        Log.e("urlPenggunaHp", urlPenggunaHp);
        myobjectrequest = new MyObjectRequest(urlPenggunaHp, new com.android.volley.Response.Listener() {

            final RoomPenggunaHp this$0;

            public volatile void onResponse(Object obj)
            {
                onResponse((JSONObject)obj);
            }

            public void onResponse(JSONObject jsonobject)
            {
                parseJSON(jsonobject.toString());
                hpPeopleAdapter.setListArray(hpPeopleArrayList);
                hpPeopleAdapter.notifyDataSetChanged();
                Log.e("countter", String.valueOf(hpPeopleArrayList.size()));
                if (hpPeopleArrayList.size() < 20)
                {
                    grup_footer.setVisibility(8);
                } else
                {
                    grup_footer.setVisibility(0);
                }
                hideProgressDialog();
            }

            
            {
                this$0 = RoomPenggunaHp.this;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final RoomPenggunaHp this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
                hideProgressDialog();
            }

            
            {
                this$0 = RoomPenggunaHp.this;
                super();
            }
        }, "test", "test");
        PonselBaseApp.getInstance().addToRequestQueue(myobjectrequest, tag_json_obj);
    }

    private void GetPeopleNextList()
    {
        txtbtnfooter.setVisibility(8);
        MyObjectRequest myobjectrequest;
        if (kota.equals(""))
        {
            urlPenggunaHp = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("pengguna_hp").append(Utility.BASE_FORMAT).append("?").append("codename=").append(codename).append("&t=").append(t).append("&bottom_id=").append(bottom_id).toString();
        } else
        {
            urlPenggunaHp = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("pengguna_hp_kota").append(Utility.BASE_FORMAT).append("?").append("codename=").append(codename).append("&kota=").append(kota_id).append("&prov=").append(prov).append("&t=").append(t).append("&bottom_id=").append(bottom_id).toString();
        }
        Log.e("urlPenggunaHp", urlPenggunaHp);
        myobjectrequest = new MyObjectRequest(urlPenggunaHp, new com.android.volley.Response.Listener() {

            final RoomPenggunaHp this$0;

            public volatile void onResponse(Object obj)
            {
                onResponse((JSONObject)obj);
            }

            public void onResponse(JSONObject jsonobject)
            {
                parseJSON(jsonobject.toString());
                hpPeopleAdapter.setListArray(hpPeopleArrayList);
                hpPeopleAdapter.notifyDataSetChanged();
                Log.e("countter", String.valueOf(hpPeopleArrayList.size()));
                if (hpPeopleArrayList.size() < 20)
                {
                    layout_footerProg.setVisibility(8);
                    grup_footer.setVisibility(8);
                    return;
                } else
                {
                    layout_footerProg.setVisibility(8);
                    txtbtnfooter.setVisibility(0);
                    grup_footer.setVisibility(0);
                    return;
                }
            }

            
            {
                this$0 = RoomPenggunaHp.this;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final RoomPenggunaHp this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
                txtbtnfooter.setVisibility(0);
            }

            
            {
                this$0 = RoomPenggunaHp.this;
                super();
            }
        }, "test", "test");
        PonselBaseApp.getInstance().addToRequestQueue(myobjectrequest, tag_json_obj);
    }

    private void hideProgressDialog()
    {
        if (layout_empty.getVisibility() == 0)
        {
            if (people_count.equals("0"))
            {
                layout_empty.setVisibility(0);
                txt_empty.setText("Tidak ada pengguna");
            } else
            {
                layout_empty.setVisibility(8);
                gridPeople.setVisibility(0);
            }
            progressbar_middle.setVisibility(8);
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

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300d7);
        db = new DatabaseHandler(this);
        userFunctions = new UserFunctions();
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            setTranslucentStatus(true);
        }
        bundle = new SystemBarTintManager(this);
        bundle.setStatusBarTintEnabled(true);
        bundle.setStatusBarTintResource(0x7f080170);
        extras = getIntent().getExtras();
        t = Utility.session(t);
        t = Utility.session(t);
        codename = extras.getString("codename");
        kota = extras.getString("kota");
        kota_id = extras.getString("kota_id");
        prov = extras.getString("prov");
        model = extras.getString("model");
        merk = extras.getString("merk");
        namalengkap = (new StringBuilder(String.valueOf(merk))).append(" ").append(model).toString();
        namalengkap = URLDecoder.decode(namalengkap);
        actionBar = getSupportActionBar();
        actionBar.setDisplayUseLogoEnabled(useLogo);
        actionBar.setBackgroundDrawable(getResources().getDrawable(0x7f0200e7));
        int j = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        int i = j;
        if (j == 0)
        {
            i = 0x7f0b0037;
        }
        ActionBar actionbar = getSupportActionBar();
        if (kota.equals(""))
        {
            bundle = (new StringBuilder("<font color='#FFFFFF'>Pengguna ")).append(namalengkap).append("</font>").toString();
        } else
        {
            bundle = (new StringBuilder("<font color='#FFFFFF'>Pengguna ")).append(namalengkap).append(" di ").append(kota).append("</font>").toString();
        }
        actionbar.setTitle(Html.fromHtml(bundle));
        bundle = (TextView)findViewById(i);
        bundle.setSelected(true);
        bundle.setTextColor(Color.parseColor("#FFFFFF"));
        bundle.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        txtbtnfooter = (TextView)findViewById(0x7f0b04d9);
        grup_footer = (LinearLayout)findViewById(0x7f0b00be);
        layout_footerProg = (LinearLayout)findViewById(0x7f0b0688);
        layout_empty = (LinearLayout)findViewById(0x7f0b0091);
        progressbar_middle = (ProgressBar)findViewById(0x7f0b00ca);
        txt_empty = (TextView)findViewById(0x7f0b0093);
        gridPeople = (GridView)findViewById(0x7f0b068c);
        hpPeopleArrayList = new ArrayList();
        hpPeopleAdapter = new ListHPPeopleAdapter(this, 0x7f0300c4, hpPeopleArrayList);
        gridPeople.setAdapter(hpPeopleAdapter);
        gridPeople.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final RoomPenggunaHp this$0;

            public void onItemClick(AdapterView adapterview, View view, int k, long l)
            {
                adapterview = new Intent(getApplicationContext(), com/inponsel/android/v2/ProfileOtherUser);
                adapterview.putExtra("id_user_view", hpPeopleAdapter.getListModel(k).getUsername());
                startActivityForResult(adapterview, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = RoomPenggunaHp.this;
                super();
            }
        });
        GetPeopleList();
        txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

            final RoomPenggunaHp this$0;

            public void onClick(View view)
            {
                txtbtnfooter.setVisibility(8);
                layout_footerProg.setVisibility(0);
                GetPeopleNextList();
            }

            
            {
                this$0 = RoomPenggunaHp.this;
                super();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getSupportMenuInflater().inflate(0x7f0f0002, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        case 16908332: 
        default:
            return true;

        case 2131429682: 
            startActivity(new Intent(getApplicationContext(), com/inponsel/android/pencariangen/TabPencarian));
            break;
        }
        return true;
    }

    void parseJSON(String s)
    {
        JSONObject jsonobject = new JSONObject(s);
        s = jsonobject.getJSONArray("InPonsel");
        people_count = jsonobject.getString("success");
        bottom_id = jsonobject.getString("bottom_id");
        top_id = jsonobject.getString("top_id");
        if (jsonobject.getString("success").equals("0"))
        {
            break MISSING_BLOCK_LABEL_182;
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
        hpPeopleArrayList.add(listmodel);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        s;
        s.printStackTrace();
    }


}
