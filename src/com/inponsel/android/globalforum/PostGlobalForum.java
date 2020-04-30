// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.globalforum;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;
import com.google.android.gms.analytics.Tracker;
import com.inponsel.android.adapter.ListAdapter;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.ClickSpan;
import com.inponsel.android.utils.DelayedTextWatcher;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;
import com.inponsel.android.v2.RoomPostArtikel;
import com.inponsel.android.v2.RoomPostBenchmark;
import com.inponsel.android.v2.RoomPostHasilFotoNoCrop;
import com.inponsel.android.v2.RoomPostPertanyaan;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PostGlobalForum extends SherlockFragmentActivity
{
    private class SearchHpSync extends AsyncTask
    {

        String suc;
        final PostGlobalForum this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient Void doInBackground(String as[])
        {
            int i;
            int j;
            j = as.length;
            i = 0;
_L3:
            if (i >= j)
            {
                return null;
            }
            Object obj = new RestClient(as[i]);
            ((RestClient) (obj)).Execute(com.inponsel.android.utils.RestClient.RequestMethod.GET);
_L1:
            Exception exception1;
            try
            {
                obj = ((RestClient) (obj)).getResponse();
                getJson = ((String) (obj));
                parseJSON(((String) (obj)));
            }
            catch (Exception exception) { }
            break MISSING_BLOCK_LABEL_65;
            exception1;
            exception1.printStackTrace();
              goto _L1
            i++;
            if (true) goto _L3; else goto _L2
_L2:
        }

        void log(String s)
        {
            Log.e("Near", s);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            super.onPostExecute(void1);
            progressbar_search.setVisibility(8);
            if (!suc.equals("0"))
            {
                break MISSING_BLOCK_LABEL_173;
            }
            if (android.os.Build.VERSION.SDK_INT < 13)
            {
                txtEmpty.setTextColor(-1);
            }
            txtEmpty.setText("Tidak temukan silahkan tulis ponsel anda di bawah ini");
            layout_empty.setVisibility(0);
            btnSubmitHp.setVisibility(0);
            btnSubmitHp.setVisibility(0);
            edtHpKetik.setVisibility(0);
            listHp.setVisibility(8);
_L1:
            log((new StringBuilder("lenght arrayList : ")).append(listArrayList.size()).toString());
            listAdapter.setListArray(listArrayList);
            listAdapter.notifyDataSetChanged();
            return;
            try
            {
                layout_empty.setVisibility(8);
                btnSubmitHp.setVisibility(8);
                edtHpKetik.setVisibility(8);
                listHp.setVisibility(0);
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
              goto _L1
        }

        protected void onPreExcute()
        {
            super.onPreExecute();
            Log.e("search", (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("home_search").append(Utility.BASE_FORMAT).append("?lmt=0&key=").append(edtAuto.getText().toString()).append("&t=").append(t).toString());
        }

        void parseJSON(String s)
        {
            JSONObject jsonobject1;
            ListModel listmodel;
            int i;
            try
            {
                JSONObject jsonobject = new JSONObject(s);
                listArrayList = new ArrayList();
                s = jsonobject.getJSONArray("InPonsel");
                suc = jsonobject.getString("success");
                log((new StringBuilder("lenght: ")).append(s.length()).toString());
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                return;
            }
            i = 0;
            if (i >= s.length())
            {
                return;
            }
            jsonobject1 = s.getJSONObject(i);
            listmodel = new ListModel();
            listmodel.setId_hp(jsonobject1.getString("id_hp"));
            listmodel.setGambar(jsonobject1.getString("gambar"));
            listmodel.setNamalengkap((new StringBuilder(String.valueOf(jsonobject1.getString("merk")))).append(" ").append(jsonobject1.getString("model")).toString());
            listmodel.setModel(jsonobject1.getString("model"));
            listmodel.setMerk(jsonobject1.getString("merk"));
            listmodel.setCodename(jsonobject1.getString("codename"));
            listArrayList.add(listmodel);
            i++;
            if (false)
            {
            } else
            {
                break MISSING_BLOCK_LABEL_66;
            }
        }

        private SearchHpSync()
        {
            this$0 = PostGlobalForum.this;
            super();
        }

        SearchHpSync(SearchHpSync searchhpsync)
        {
            this();
        }
    }


    ActionBar actionBar;
    int actionBarTitleId;
    Button btnPostForumNext;
    Button btnSubmitHp;
    CheckBox cb_ForumAndroid;
    CheckBox cb_ForumBlackberry;
    CheckBox cb_ForumIOS;
    CheckBox cb_ForumWP;
    Dialog dialog;
    EditText edtAuto;
    EditText edtHpKetik;
    String forum_tag;
    String getJson;
    LinearLayout layout_empty;
    ListAdapter listAdapter;
    ArrayList listArrayList;
    ListView listHp;
    ProgressBar progressbar_middle_dialog;
    ProgressBar progressbar_search;
    RelativeLayout rl_PostForumKatLain;
    RelativeLayout rl_PostForumOpini;
    RelativeLayout rl_PostForumTanya;
    RelativeLayout rl_PostForumTipsUmum;
    String t;
    String tambah_artikel[] = {
        "Topik umum", "Tips & trik", "Hasil foto kamera", "Benchmark", "Aksesori", "Tanya"
    };
    TextView txtEmpty;
    TextView txtPostForumHP;
    private boolean useLogo;
    UserFunctions userFunctions;
    ContextThemeWrapper wrapper;

    public PostGlobalForum()
    {
        listArrayList = null;
        t = Utility.session(RestClient.pelihara);
        getJson = "";
        useLogo = false;
        actionBarTitleId = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        forum_tag = "";
    }

    private void LoginPopup(String s, String s1)
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle(s);
        builder.setMessage(s1);
        builder.setPositiveButton("Login", new android.content.DialogInterface.OnClickListener() {

            final PostGlobalForum this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(PostGlobalForum.this, com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                startActivityForResult(dialoginterface, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = PostGlobalForum.this;
                super();
            }
        });
        builder.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

            final PostGlobalForum this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(PostGlobalForum.this, com/inponsel/android/v2/RegisterActivity);
                startActivityForResult(dialoginterface, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = PostGlobalForum.this;
                super();
            }
        });
        builder.setNegativeButton("Tutup", new android.content.DialogInterface.OnClickListener() {

            final PostGlobalForum this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$0 = PostGlobalForum.this;
                super();
            }
        });
        builder.show();
    }

    public static void clickify(TextView textview, String s, com.inponsel.android.utils.ClickSpan.OnClickListener onclicklistener)
    {
        CharSequence charsequence = textview.getText();
        String s1 = charsequence.toString();
        onclicklistener = new ClickSpan(onclicklistener);
        int i = s1.indexOf(s);
        int j = i + s.length();
        if (i != -1)
        {
            if (charsequence instanceof Spannable)
            {
                ((Spannable)charsequence).setSpan(onclicklistener, i, j, 33);
            } else
            {
                s = SpannableString.valueOf(charsequence);
                s.setSpan(onclicklistener, i, j, 33);
                textview.setText(s);
            }
            s = textview.getMovementMethod();
            if (s == null || !(s instanceof LinkMovementMethod))
            {
                textview.setMovementMethod(LinkMovementMethod.getInstance());
                return;
            }
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

    private void show_ponsel()
    {
        Log.e("click", "custom dialog");
        View view = getLayoutInflater().inflate(0x7f030026, null);
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(wrapper);
        builder.setView(view);
        builder.setTitle("Pilih Ponsel :");
        progressbar_middle_dialog = (ProgressBar)view.findViewById(0x7f0b0092);
        progressbar_middle_dialog.setVisibility(8);
        layout_empty = (LinearLayout)view.findViewById(0x7f0b0091);
        edtAuto = (EditText)view.findViewById(0x7f0b008d);
        edtHpKetik = (EditText)view.findViewById(0x7f0b0094);
        btnSubmitHp = (Button)view.findViewById(0x7f0b0095);
        listHp = (ListView)view.findViewById(0x7f0b008f);
        if (android.os.Build.VERSION.SDK_INT < 13)
        {
            edtAuto.setTextColor(-1);
            listHp.setBackgroundColor(-1);
        }
        progressbar_search = (ProgressBar)view.findViewById(0x7f0b008e);
        txtEmpty = (TextView)view.findViewById(0x7f0b0093);
        txtEmpty.setText("Masukkan ponsel yang dicari");
        listArrayList = new ArrayList();
        listAdapter = new ListAdapter(this, 0x7f03006e, listArrayList);
        listHp.setAdapter(listAdapter);
        edtAuto.setSingleLine(true);
        edtAuto.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

            final PostGlobalForum this$0;

            public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
            {
                if (i != 3) goto _L2; else goto _L1
_L1:
                if (edtAuto.getText().length() == 0)
                {
                    txtEmpty.setText("Masukan ponsel yang ingin dicari");
                    return true;
                }
                progressbar_search.setVisibility(0);
                textview = edtAuto.getText().toString();
                keyevent = URLEncoder.encode(textview, "utf-8");
                textview = keyevent;
_L3:
                (new SearchHpSync(null)).execute(new String[] {
                    (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("home_search").append(Utility.BASE_FORMAT).append("?lmt=0&key=").append(textview).append("&t=").append(t).toString()
                });
                return true;
                keyevent;
                keyevent.printStackTrace();
                if (true) goto _L3; else goto _L2
_L2:
                return false;
            }

            
            {
                this$0 = PostGlobalForum.this;
                super();
            }
        });
        edtAuto.addTextChangedListener(new DelayedTextWatcher(2000L) {

            final PostGlobalForum this$0;

            public void afterTextChangedDelayed(Editable editable)
            {
                if (edtAuto.getText().length() == 0)
                {
                    txtEmpty.setText("Masukan ponsel yang ingin dicari");
                    return;
                }
                progressbar_search.setVisibility(0);
                editable = edtAuto.getText().toString();
                String s = URLEncoder.encode(editable, "utf-8");
                editable = s;
_L2:
                (new SearchHpSync(null)).execute(new String[] {
                    (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("home_search").append(Utility.BASE_FORMAT).append("?lmt=0&key=").append(editable).append("&t=").append(t).toString()
                });
                return;
                UnsupportedEncodingException unsupportedencodingexception;
                unsupportedencodingexception;
                unsupportedencodingexception.printStackTrace();
                if (true) goto _L2; else goto _L1
_L1:
            }

            
            {
                this$0 = PostGlobalForum.this;
                super(l);
            }
        });
        listHp.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final PostGlobalForum this$0;

            public void onItemClick(final AdapterView id_hp, final View codename, int i, long l)
            {
                ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(edtAuto.getWindowToken(), 0);
                id_hp = listAdapter.getListModel(i).getId_hp();
                codename = listAdapter.getListModel(i).getCodename();
                final String merk = listAdapter.getListModel(i).getMerk();
                final String model = listAdapter.getListModel(i).getModel();
                String s = listAdapter.getListModel(i).getGambar();
                final String namalengkap = (new StringBuilder(String.valueOf(merk))).append(" ").append(model).toString();
                dialog.dismiss();
                if (userFunctions.isUserLoggedIn(PostGlobalForum.this))
                {
                    android.app.AlertDialog.Builder builder1 = new android.app.AlertDialog.Builder(PostGlobalForum.this);
                    builder1.setTitle((new StringBuilder("Kirim Konten ")).append(merk).append(" ").append(model).toString());
                    builder1.setItems(tambah_artikel, s. new android.content.DialogInterface.OnClickListener() {

                        final _cls13 this$1;
                        private final String val$codename;
                        private final String val$gambar;
                        private final String val$id_hp;
                        private final String val$merk;
                        private final String val$model;
                        private final String val$namalengkap;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            i;
                            JVM INSTR tableswitch 0 5: default 40
                        //                                       0 47
                        //                                       1 195
                        //                                       2 343
                        //                                       3 473
                        //                                       4 603
                        //                                       5 751;
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
                this$1 = final__pcls13;
                id_hp = s;
                namalengkap = s1;
                codename = s2;
                model = s3;
                merk = s4;
                gambar = String.this;
                super();
            }
                    });
                    builder1.show();
                    return;
                } else
                {
                    LoginPopup("Perhatian", "Untuk mengirim artikel diharuskan login terlebih dahulu");
                    return;
                }
            }


            
            {
                this$0 = PostGlobalForum.this;
                super();
            }
        });
        btnSubmitHp.setOnClickListener(new android.view.View.OnClickListener() {

            final PostGlobalForum this$0;

            public void onClick(View view1)
            {
                ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(edtAuto.getWindowToken(), 0);
                dialog.dismiss();
            }

            
            {
                this$0 = PostGlobalForum.this;
                super();
            }
        });
        dialog = builder.create();
        dialog.show();
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        Log.e("onActivityResult", "RESULT_OK");
        if (j == -1)
        {
            Log.e("Refresh", "OK");
            intent = intent.getStringExtra("jsonKom");
            Log.e("onActivityResultAct", intent);
            if (intent.length() > 10)
            {
                setResult(-1, (new Intent()).putExtra("jsonKom", intent));
                finish();
            }
            return;
        } else
        {
            Log.e("Refresh", "false");
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300f6);
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            setTranslucentStatus(true);
        }
        bundle = new SystemBarTintManager(this);
        bundle.setStatusBarTintEnabled(true);
        bundle.setStatusBarTintResource(0x7f080173);
        actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayUseLogoEnabled(useLogo);
        actionBar.setBackgroundDrawable(getResources().getDrawable(0x7f0200e7));
        int j = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        int i = j;
        if (j == 0)
        {
            i = 0x7f0b0037;
        }
        bundle = (TextView)findViewById(i);
        bundle.setSelected(true);
        bundle.setTextColor(Color.parseColor("#FFFFFF"));
        bundle.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFFFFF'>Kirim artikel</font>"));
        userFunctions = new UserFunctions();
        wrapper = new ContextThemeWrapper(this, 0x103006e);
        cb_ForumAndroid = (CheckBox)findViewById(0x7f0b0718);
        cb_ForumBlackberry = (CheckBox)findViewById(0x7f0b0719);
        cb_ForumIOS = (CheckBox)findViewById(0x7f0b071a);
        cb_ForumWP = (CheckBox)findViewById(0x7f0b071b);
        t = Utility.session(t);
        btnPostForumNext = (Button)findViewById(0x7f0b071c);
        btnPostForumNext.setEnabled(false);
        rl_PostForumTipsUmum = (RelativeLayout)findViewById(0x7f0b071f);
        rl_PostForumTanya = (RelativeLayout)findViewById(0x7f0b071d);
        rl_PostForumKatLain = (RelativeLayout)findViewById(0x7f0b0723);
        rl_PostForumOpini = (RelativeLayout)findViewById(0x7f0b0721);
        txtPostForumHP = (TextView)findViewById(0x7f0b0725);
        t = Utility.session(t);
        try
        {
            bundle = ((PonselBaseApp)getApplication()).getTracker(com.inponsel.android.adapter.PonselBaseApp.TrackerName.APP_TRACKER);
            bundle.setScreenName("Post Forum Global");
            bundle.send((new com.google.android.gms.analytics.HitBuilders.AppViewBuilder()).build());
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        cb_ForumAndroid.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final PostGlobalForum this$0;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                if (cb_ForumAndroid.isChecked())
                {
                    compoundbutton = PostGlobalForum.this;
                    compoundbutton.forum_tag = (new StringBuilder(String.valueOf(((PostGlobalForum) (compoundbutton)).forum_tag))).append("android,").toString();
                } else
                {
                    forum_tag = forum_tag.replace("android,", "");
                }
                if (cb_ForumAndroid.isChecked() || cb_ForumBlackberry.isChecked() || cb_ForumIOS.isChecked() || cb_ForumWP.isChecked())
                {
                    btnPostForumNext.setEnabled(true);
                    return;
                } else
                {
                    btnPostForumNext.setEnabled(false);
                    return;
                }
            }

            
            {
                this$0 = PostGlobalForum.this;
                super();
            }
        });
        cb_ForumBlackberry.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final PostGlobalForum this$0;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                if (cb_ForumBlackberry.isChecked())
                {
                    compoundbutton = PostGlobalForum.this;
                    compoundbutton.forum_tag = (new StringBuilder(String.valueOf(((PostGlobalForum) (compoundbutton)).forum_tag))).append("blackberry,").toString();
                } else
                {
                    forum_tag = forum_tag.replace("blackberry,", "");
                }
                if (cb_ForumAndroid.isChecked() || cb_ForumBlackberry.isChecked() || cb_ForumIOS.isChecked() || cb_ForumWP.isChecked())
                {
                    btnPostForumNext.setEnabled(true);
                    return;
                } else
                {
                    btnPostForumNext.setEnabled(false);
                    return;
                }
            }

            
            {
                this$0 = PostGlobalForum.this;
                super();
            }
        });
        cb_ForumIOS.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final PostGlobalForum this$0;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                if (cb_ForumIOS.isChecked())
                {
                    compoundbutton = PostGlobalForum.this;
                    compoundbutton.forum_tag = (new StringBuilder(String.valueOf(((PostGlobalForum) (compoundbutton)).forum_tag))).append("ios,").toString();
                } else
                {
                    forum_tag = forum_tag.replace("ios,", "");
                }
                if (cb_ForumAndroid.isChecked() || cb_ForumBlackberry.isChecked() || cb_ForumIOS.isChecked() || cb_ForumWP.isChecked())
                {
                    btnPostForumNext.setEnabled(true);
                    return;
                } else
                {
                    btnPostForumNext.setEnabled(false);
                    return;
                }
            }

            
            {
                this$0 = PostGlobalForum.this;
                super();
            }
        });
        cb_ForumWP.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final PostGlobalForum this$0;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                if (cb_ForumWP.isChecked())
                {
                    compoundbutton = PostGlobalForum.this;
                    compoundbutton.forum_tag = (new StringBuilder(String.valueOf(((PostGlobalForum) (compoundbutton)).forum_tag))).append("windowsphone,").toString();
                } else
                {
                    forum_tag = forum_tag.replace("windowsphone,", "");
                }
                if (cb_ForumAndroid.isChecked() || cb_ForumBlackberry.isChecked() || cb_ForumIOS.isChecked() || cb_ForumWP.isChecked())
                {
                    btnPostForumNext.setEnabled(true);
                    return;
                } else
                {
                    btnPostForumNext.setEnabled(false);
                    return;
                }
            }

            
            {
                this$0 = PostGlobalForum.this;
                super();
            }
        });
        btnPostForumNext.setOnClickListener(new android.view.View.OnClickListener() {

            final PostGlobalForum this$0;

            public void onClick(View view)
            {
                Log.e("forum_tag", forum_tag.replaceAll(",$", ""));
                view = new Intent(getApplicationContext(), com/inponsel/android/v2/RoomPostArtikel);
                view.putExtra("action", "post");
                view.putExtra("id_hph", "0");
                view.putExtra("namalengkap", "");
                view.putExtra("codename", "");
                view.putExtra("model", "");
                view.putExtra("merk", "");
                view.putExtra("gambar", "");
                view.putExtra("from", "apps");
                view.putExtra("tl_type", "global");
                view.putExtra("tl_tag", forum_tag);
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = PostGlobalForum.this;
                super();
            }
        });
        rl_PostForumTanya.setOnClickListener(new android.view.View.OnClickListener() {

            final PostGlobalForum this$0;

            public void onClick(View view)
            {
                view = new Intent(getApplicationContext(), com/inponsel/android/v2/RoomPostPertanyaan);
                view.putExtra("action", "post");
                view.putExtra("id_hph", "0");
                view.putExtra("namalengkap", "");
                view.putExtra("codename", "");
                view.putExtra("model", "");
                view.putExtra("merk", "");
                view.putExtra("gambar", "");
                view.putExtra("from", "apps");
                view.putExtra("tl_type", "global");
                view.putExtra("tl_tag", "tanya");
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = PostGlobalForum.this;
                super();
            }
        });
        rl_PostForumKatLain.setOnClickListener(new android.view.View.OnClickListener() {

            final PostGlobalForum this$0;

            public void onClick(View view)
            {
                view = new Intent(getApplicationContext(), com/inponsel/android/v2/RoomPostArtikel);
                view.putExtra("action", "post");
                view.putExtra("id_hph", "0");
                view.putExtra("namalengkap", "");
                view.putExtra("codename", "");
                view.putExtra("model", "");
                view.putExtra("merk", "");
                view.putExtra("gambar", "");
                view.putExtra("from", "apps");
                view.putExtra("tl_type", "global");
                view.putExtra("tl_tag", "katlain");
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = PostGlobalForum.this;
                super();
            }
        });
        rl_PostForumOpini.setOnClickListener(new android.view.View.OnClickListener() {

            final PostGlobalForum this$0;

            public void onClick(View view)
            {
                view = new Intent(getApplicationContext(), com/inponsel/android/v2/RoomPostArtikel);
                view.putExtra("action", "post");
                view.putExtra("id_hph", "0");
                view.putExtra("namalengkap", "");
                view.putExtra("codename", "");
                view.putExtra("model", "");
                view.putExtra("merk", "");
                view.putExtra("gambar", "");
                view.putExtra("from", "apps");
                view.putExtra("tl_type", "global");
                view.putExtra("tl_tag", "opini");
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = PostGlobalForum.this;
                super();
            }
        });
        rl_PostForumTipsUmum.setOnClickListener(new android.view.View.OnClickListener() {

            final PostGlobalForum this$0;

            public void onClick(View view)
            {
                view = new Intent(getApplicationContext(), com/inponsel/android/v2/RoomPostArtikel);
                view.putExtra("action", "post");
                view.putExtra("id_hph", "0");
                view.putExtra("namalengkap", "");
                view.putExtra("codename", "");
                view.putExtra("model", "");
                view.putExtra("merk", "");
                view.putExtra("gambar", "");
                view.putExtra("from", "apps");
                view.putExtra("tl_type", "global");
                view.putExtra("tl_tag", "tipsumum");
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = PostGlobalForum.this;
                super();
            }
        });
        txtPostForumHP.setText(Html.fromHtml("Jika konten berhubungan dengan tipe ponsel tertentu, seperti hasil foto kamera dan uji benchmark, <u><font  color=\"blue\">klik disini</font></u>"));
        clickify(txtPostForumHP, "klik disini", new com.inponsel.android.utils.ClickSpan.OnClickListener() {

            final PostGlobalForum this$0;

            public void onClick()
            {
                show_ponsel();
            }

            
            {
                this$0 = PostGlobalForum.this;
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
