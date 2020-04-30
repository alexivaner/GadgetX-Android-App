// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
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
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.pencariangen.TabPencarian;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.widget.ExpandableHeightGridView;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import java.io.File;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.v2:
//            RoomPostArtikel, RoomPostHasilFotoNoCrop, RoomPostBenchmark, RoomPostPertanyaan

public class RoomMyDraftPost extends SherlockFragmentActivity
{
    public class ListTanyaAdapter extends BaseAdapter
    {

        private Activity activity;
        Context context;
        Cursor cursor;
        DatabaseHandler db;
        String email_user;
        String finalUrl;
        DecimalFormat fmt;
        DecimalFormatSymbols fmts;
        String komen;
        private ArrayList lm;
        ListModel lms;
        ProgressDialog mDialog;
        int pos;
        String res;
        int resource;
        String response;
        String status;
        String t;
        final RoomMyDraftPost this$0;
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
            viewgroup = view;
            pos = i;
            view = (LayoutInflater)activity.getSystemService("layout_inflater");
            if (viewgroup == null)
            {
                viewgroup = view.inflate(resource, null);
                view = new ViewHolder();
                view.imageHp = (ImageView)viewgroup.findViewById(0x7f0b023d);
                view.list_txtMerek = (TextView)viewgroup.findViewById(0x7f0b033c);
                view.list_txtHarga = (TextView)viewgroup.findViewById(0x7f0b033d);
                view.progressbar_item = (ProgressBar)viewgroup.findViewById(0x7f0b00b3);
                view.rateRate = (RatingBar)viewgroup.findViewById(0x7f0b00c9);
                view.imgIklan = (ImageView)viewgroup.findViewById(0x7f0b0484);
                view.headIklan = (LinearLayout)viewgroup.findViewById(0x7f0b0482);
                view.progressbar_item_iklan = (ProgressBar)viewgroup.findViewById(0x7f0b0483);
                view.headHp = (LinearLayout)viewgroup.findViewById(0x7f0b0481);
                view.separator = (LinearLayout)viewgroup.findViewById(0x7f0b0340);
                view.bottom_list = (LinearLayout)viewgroup.findViewById(0x7f0b0341);
                view.headImage = (LinearLayout)viewgroup.findViewById(0x7f0b029f);
                view.list_txtBigRight = (TextView)viewgroup.findViewById(0x7f0b034d);
                view.leftdel = (RelativeLayout)viewgroup.findViewById(0x7f0b0480);
                viewgroup.setTag(view);
            } else
            {
                view = (ViewHolder)viewgroup.getTag();
            }
            lms = (ListModel)lm.get(i);
            if (lm != null)
            {
                ((ViewHolder) (view)).bottom_list.setVisibility(8);
                ((ViewHolder) (view)).separator.setVisibility(8);
                ((ViewHolder) (view)).list_txtBigRight.setVisibility(8);
                ((ViewHolder) (view)).progressbar_item.setVisibility(8);
                ((ViewHolder) (view)).imageHp.setVisibility(0);
                String as[] = lms.getCodename().split("-");
                ((ViewHolder) (view)).list_txtMerek.setText((new StringBuilder(String.valueOf(as[0]))).append(" - ").append(lms.getRoom_title()).toString());
                ((ViewHolder) (view)).list_txtHarga.setText(lms.getRoom_content());
                Object obj = new File(lms.getRoom_path_image());
                if (((File) (obj)).exists())
                {
                    obj = BitmapFactory.decodeFile(((File) (obj)).getAbsolutePath());
                    ((ViewHolder) (view)).imageHp.setImageBitmap(((android.graphics.Bitmap) (obj)));
                } else
                {
                    ((ViewHolder) (view)).imageHp.setImageResource(0x7f020073);
                }
                ((ViewHolder) (view)).leftdel.setOnClickListener(i. new android.view.View.OnClickListener() {

                    final ListTanyaAdapter this$1;
                    private final int val$position;

                    public void onClick(View view)
                    {
                        id_del = getListModel(position).getId_content();
                        Log.e("id_hp_del", id_del);
                        view = new android.app.AlertDialog.Builder(_fld0);
                        view.setTitle("Peringatan");
                        view.setMessage("Hapus pertanyaan ini?");
                        view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                            final ListTanyaAdapter._cls1 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                statdel = "0";
                                db.delete_byARTID(lms.getRoom_date(), lms.getRoom_title());
                                onResume();
                            }

            
            {
                this$2 = ListTanyaAdapter._cls1.this;
                super();
            }
                        });
                        view.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                            final ListTanyaAdapter._cls1 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = ListTanyaAdapter._cls1.this;
                super();
            }
                        });
                        view.show();
                    }


            
            {
                this$1 = final_listtanyaadapter;
                position = I.this;
                super();
            }
                });
            }
            return viewgroup;
        }

        public void setListArray(ArrayList arraylist)
        {
            lm = arraylist;
        }


        public ListTanyaAdapter(Activity activity1, int i, ArrayList arraylist)
        {
            this$0 = RoomMyDraftPost.this;
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
            resource = i;
            try
            {
                userFunctions = new UserFunctions();
                db = new DatabaseHandler(activity1);
                t = Utility.session(t);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (RoomMyDraftPost roommydraftpost)
            {
                return;
            }
        }
    }

    class ListTanyaAdapter.ViewHolder
    {

        LinearLayout bottom_list;
        LinearLayout headHp;
        LinearLayout headIklan;
        LinearLayout headImage;
        ImageView imageHp;
        ImageView imgIklan;
        RelativeLayout leftdel;
        TextView list_txtBigRight;
        TextView list_txtHarga;
        TextView list_txtMerek;
        ProgressBar progressbar_item;
        ProgressBar progressbar_item_iklan;
        RatingBar rateRate;
        LinearLayout separator;
        final ListTanyaAdapter this$1;

        ListTanyaAdapter.ViewHolder()
        {
            this$1 = ListTanyaAdapter.this;
            super();
        }
    }

    public class ListartikelAdapter extends BaseAdapter
    {

        private Activity activity;
        Context context;
        Cursor cursor;
        DatabaseHandler db;
        String email_user;
        String finalUrl;
        DecimalFormat fmt;
        DecimalFormatSymbols fmts;
        String komen;
        private ArrayList lm;
        ListModel lms;
        ProgressDialog mDialog;
        int pos;
        String res;
        int resource;
        String response;
        String status;
        String t;
        final RoomMyDraftPost this$0;
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
            viewgroup = view;
            pos = i;
            view = (LayoutInflater)activity.getSystemService("layout_inflater");
            if (viewgroup == null)
            {
                viewgroup = view.inflate(resource, null);
                view = new ViewHolder();
                view.imageHp = (ImageView)viewgroup.findViewById(0x7f0b023d);
                view.list_txtMerek = (TextView)viewgroup.findViewById(0x7f0b033c);
                view.list_txtHarga = (TextView)viewgroup.findViewById(0x7f0b033d);
                view.progressbar_item = (ProgressBar)viewgroup.findViewById(0x7f0b00b3);
                view.rateRate = (RatingBar)viewgroup.findViewById(0x7f0b00c9);
                view.imgIklan = (ImageView)viewgroup.findViewById(0x7f0b0484);
                view.headIklan = (LinearLayout)viewgroup.findViewById(0x7f0b0482);
                view.progressbar_item_iklan = (ProgressBar)viewgroup.findViewById(0x7f0b0483);
                view.headHp = (LinearLayout)viewgroup.findViewById(0x7f0b0481);
                view.separator = (LinearLayout)viewgroup.findViewById(0x7f0b0340);
                view.bottom_list = (LinearLayout)viewgroup.findViewById(0x7f0b0341);
                view.headImage = (LinearLayout)viewgroup.findViewById(0x7f0b029f);
                view.list_txtBigRight = (TextView)viewgroup.findViewById(0x7f0b034d);
                view.leftdel = (RelativeLayout)viewgroup.findViewById(0x7f0b0480);
                viewgroup.setTag(view);
            } else
            {
                view = (ViewHolder)viewgroup.getTag();
            }
            lms = (ListModel)lm.get(i);
            if (lm != null)
            {
                ((ViewHolder) (view)).bottom_list.setVisibility(8);
                ((ViewHolder) (view)).separator.setVisibility(8);
                ((ViewHolder) (view)).list_txtBigRight.setVisibility(8);
                ((ViewHolder) (view)).progressbar_item.setVisibility(8);
                ((ViewHolder) (view)).imageHp.setVisibility(0);
                String as[] = lms.getCodename().split("-");
                ((ViewHolder) (view)).list_txtMerek.setText((new StringBuilder(String.valueOf(as[0]))).append(" - ").append(lms.getRoom_title()).toString());
                ((ViewHolder) (view)).list_txtHarga.setText(lms.getRoom_content());
                Object obj = new File(lms.getRoom_path_image());
                if (((File) (obj)).exists())
                {
                    obj = BitmapFactory.decodeFile(((File) (obj)).getAbsolutePath());
                    ((ViewHolder) (view)).imageHp.setImageBitmap(((android.graphics.Bitmap) (obj)));
                } else
                {
                    ((ViewHolder) (view)).imageHp.setImageResource(0x7f020073);
                }
                ((ViewHolder) (view)).leftdel.setOnClickListener(i. new android.view.View.OnClickListener() {

                    final ListartikelAdapter this$1;
                    private final int val$position;

                    public void onClick(View view)
                    {
                        id_del = getListModel(position).getId_content();
                        Log.e("id_hp_del", id_del);
                        view = new android.app.AlertDialog.Builder(_fld0);
                        view.setTitle("Peringatan");
                        view.setMessage("Hapus artikel ini?");
                        view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                            final ListartikelAdapter._cls1 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                statdel = "0";
                                db.delete_byARTID(lms.getRoom_date(), lms.getRoom_title());
                                onResume();
                            }

            
            {
                this$2 = ListartikelAdapter._cls1.this;
                super();
            }
                        });
                        view.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                            final ListartikelAdapter._cls1 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = ListartikelAdapter._cls1.this;
                super();
            }
                        });
                        view.show();
                    }


            
            {
                this$1 = final_listartikeladapter;
                position = I.this;
                super();
            }
                });
            }
            return viewgroup;
        }

        public void setListArray(ArrayList arraylist)
        {
            lm = arraylist;
        }


        public ListartikelAdapter(Activity activity1, int i, ArrayList arraylist)
        {
            this$0 = RoomMyDraftPost.this;
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
            resource = i;
            try
            {
                userFunctions = new UserFunctions();
                db = new DatabaseHandler(activity1);
                t = Utility.session(t);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (RoomMyDraftPost roommydraftpost)
            {
                return;
            }
        }
    }

    class ListartikelAdapter.ViewHolder
    {

        LinearLayout bottom_list;
        LinearLayout headHp;
        LinearLayout headIklan;
        LinearLayout headImage;
        ImageView imageHp;
        ImageView imgIklan;
        RelativeLayout leftdel;
        TextView list_txtBigRight;
        TextView list_txtHarga;
        TextView list_txtMerek;
        ProgressBar progressbar_item;
        ProgressBar progressbar_item_iklan;
        RatingBar rateRate;
        LinearLayout separator;
        final ListartikelAdapter this$1;

        ListartikelAdapter.ViewHolder()
        {
            this$1 = ListartikelAdapter.this;
            super();
        }
    }


    ActionBar actionBar;
    int actionBarTitleId;
    ListartikelAdapter artikelAdapter;
    ArrayList artikelArray;
    ListartikelAdapter benchmarkAdapter;
    ArrayList benchmarkArray;
    String codename;
    String content;
    String content_ext;
    Cursor cursor;
    String date;
    DatabaseHandler db;
    String email_user;
    String id_content;
    String id_del;
    String id_hp;
    ListartikelAdapter kameraAdapter;
    ArrayList kameraArray;
    ExpandableHeightGridView list_Artikel;
    ExpandableHeightGridView list_Tanya;
    ExpandableHeightGridView list_hasilbenchmark;
    ExpandableHeightGridView list_hasilkamera;
    String nama_asli;
    String path_image;
    ProgressBar progressbar_Artikel;
    ProgressBar progressbar_Tanya;
    ProgressBar progressbar_hasilbenchmark;
    ProgressBar progressbar_hasilkamera;
    String statdel;
    String tag_artikel;
    ListTanyaAdapter tanyaAdapter;
    ArrayList tanyaArray;
    String title;
    TextView txt_empty_Artikel;
    TextView txt_empty_Tanya;
    TextView txt_empty_hasilbenchmark;
    TextView txt_empty_hasilkamera;
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

    public RoomMyDraftPost()
    {
        id_del = "";
        statdel = "";
        artikelArray = null;
        tanyaArray = null;
        kameraArray = null;
        benchmarkArray = null;
        actionBarTitleId = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        user_photo = "";
        username = "";
        useLogo = false;
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

    public ArrayList loadArtikelDB()
    {
        ArrayList arraylist;
        Cursor cursor1;
        arraylist = new ArrayList();
        cursor1 = db.getArtikelData("artikel");
        if (!cursor1.moveToFirst()) goto _L2; else goto _L1
_L1:
        do
        {
            id_content = String.valueOf(cursor1.getString(0));
            id_hp = String.valueOf(cursor1.getString(1));
            codename = String.valueOf(cursor1.getString(2));
            title = String.valueOf(cursor1.getString(4));
            tag_artikel = String.valueOf(cursor1.getString(5));
            path_image = String.valueOf(cursor1.getString(6));
            content = String.valueOf(cursor1.getString(7));
            content_ext = String.valueOf(cursor1.getString(8));
            date = String.valueOf(cursor1.getString(9));
            ListModel listmodel = new ListModel();
            listmodel.setId_content(id_content);
            listmodel.setId_hp(id_hp);
            listmodel.setCodename(codename);
            listmodel.setRoom_title(title);
            listmodel.setTag_artikel(tag_artikel);
            listmodel.setRoom_path_image(path_image);
            listmodel.setRoom_content(content);
            listmodel.setRoom_content_ext(content_ext);
            listmodel.setRoom_date(date);
            arraylist.add(listmodel);
        } while (cursor1.moveToNext());
        Log.e("bookmark", String.valueOf(arraylist.size()));
        list_Artikel.setVisibility(0);
_L4:
        db.close();
        return arraylist;
_L2:
        try
        {
            Log.e("bookmark", "nol");
            progressbar_Artikel.setVisibility(8);
            txt_empty_Artikel.setVisibility(0);
            txt_empty_Artikel.setText("Belum ada artikel disimpan");
        }
        catch (Exception exception) { }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public ArrayList loadBenchmarkDB()
    {
        ArrayList arraylist;
        Cursor cursor1;
        arraylist = new ArrayList();
        cursor1 = db.getArtikelData("benchmark");
        if (!cursor1.moveToFirst()) goto _L2; else goto _L1
_L1:
        do
        {
            id_content = String.valueOf(cursor1.getString(0));
            id_hp = String.valueOf(cursor1.getString(1));
            codename = String.valueOf(cursor1.getString(2));
            title = String.valueOf(cursor1.getString(4));
            tag_artikel = String.valueOf(cursor1.getString(5));
            path_image = String.valueOf(cursor1.getString(6));
            content = String.valueOf(cursor1.getString(7));
            content_ext = String.valueOf(cursor1.getString(8));
            date = String.valueOf(cursor1.getString(9));
            ListModel listmodel = new ListModel();
            listmodel.setId_content(id_content);
            listmodel.setId_hp(id_hp);
            listmodel.setCodename(codename);
            listmodel.setRoom_title(title);
            listmodel.setTag_artikel(tag_artikel);
            listmodel.setRoom_path_image(path_image);
            listmodel.setRoom_content(content);
            listmodel.setRoom_content_ext(content_ext);
            listmodel.setRoom_date(date);
            arraylist.add(listmodel);
        } while (cursor1.moveToNext());
        Log.e("bookmark", String.valueOf(arraylist.size()));
        list_hasilbenchmark.setVisibility(0);
_L4:
        db.close();
        return arraylist;
_L2:
        try
        {
            Log.e("bookmark", "nol");
            progressbar_hasilbenchmark.setVisibility(8);
            txt_empty_hasilbenchmark.setVisibility(0);
            txt_empty_hasilbenchmark.setText("Belum ada hasil benchmark disimpan");
        }
        catch (Exception exception) { }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void loadDataArtikel()
    {
        if (artikelArray.size() == 0)
        {
            txt_empty_Artikel.setVisibility(0);
            txt_empty_Artikel.setText("Belum ada artikel disimpan");
        } else
        {
            txt_empty_Artikel.setVisibility(8);
        }
        progressbar_Artikel.setVisibility(8);
    }

    public void loadDataHasilBenchmark()
    {
        if (benchmarkArray.size() == 0)
        {
            txt_empty_hasilbenchmark.setVisibility(0);
            txt_empty_hasilbenchmark.setText("Belum ada hasil benchmark disimpan");
        } else
        {
            txt_empty_hasilbenchmark.setVisibility(8);
        }
        progressbar_hasilbenchmark.setVisibility(8);
    }

    public void loadDataHasilkamera()
    {
        if (kameraArray.size() == 0)
        {
            txt_empty_hasilkamera.setVisibility(0);
            txt_empty_hasilkamera.setText("Belum ada hasil kamera disimpan");
        } else
        {
            txt_empty_hasilkamera.setVisibility(8);
        }
        progressbar_hasilkamera.setVisibility(8);
    }

    public void loadDataTanyaHP()
    {
        if (tanyaArray.size() == 0)
        {
            txt_empty_Tanya.setVisibility(0);
            txt_empty_Tanya.setText("Belum ada pertanyaan disimpan");
        } else
        {
            txt_empty_Tanya.setVisibility(8);
        }
        progressbar_Tanya.setVisibility(8);
    }

    public ArrayList loadKameraDB()
    {
        ArrayList arraylist;
        Cursor cursor1;
        arraylist = new ArrayList();
        cursor1 = db.getArtikelData("hasilkamera");
        if (!cursor1.moveToFirst()) goto _L2; else goto _L1
_L1:
        do
        {
            id_content = String.valueOf(cursor1.getString(0));
            id_hp = String.valueOf(cursor1.getString(1));
            codename = String.valueOf(cursor1.getString(2));
            title = String.valueOf(cursor1.getString(4));
            tag_artikel = String.valueOf(cursor1.getString(5));
            path_image = String.valueOf(cursor1.getString(6));
            content = String.valueOf(cursor1.getString(7));
            content_ext = String.valueOf(cursor1.getString(8));
            date = String.valueOf(cursor1.getString(9));
            ListModel listmodel = new ListModel();
            listmodel.setId_content(id_content);
            listmodel.setId_hp(id_hp);
            listmodel.setCodename(codename);
            listmodel.setRoom_title(title);
            listmodel.setTag_artikel(tag_artikel);
            listmodel.setRoom_path_image(path_image);
            listmodel.setRoom_content(content);
            listmodel.setRoom_content_ext(content_ext);
            listmodel.setRoom_date(date);
            arraylist.add(listmodel);
        } while (cursor1.moveToNext());
        Log.e("bookmark", String.valueOf(arraylist.size()));
        list_hasilkamera.setVisibility(0);
_L4:
        db.close();
        return arraylist;
_L2:
        try
        {
            Log.e("bookmark", "nol");
            progressbar_hasilkamera.setVisibility(8);
            txt_empty_hasilkamera.setVisibility(0);
            txt_empty_hasilkamera.setText("Belum ada hasil kamera disimpan");
        }
        catch (Exception exception) { }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public ArrayList loadTanyaHPDB()
    {
        ArrayList arraylist;
        Cursor cursor1;
        arraylist = new ArrayList();
        cursor1 = db.getArtikelData("faqhp");
        if (!cursor1.moveToFirst()) goto _L2; else goto _L1
_L1:
        do
        {
            id_content = String.valueOf(cursor1.getString(0));
            id_hp = String.valueOf(cursor1.getString(1));
            codename = String.valueOf(cursor1.getString(2));
            title = String.valueOf(cursor1.getString(4));
            tag_artikel = String.valueOf(cursor1.getString(5));
            path_image = String.valueOf(cursor1.getString(6));
            content = String.valueOf(cursor1.getString(7));
            content_ext = String.valueOf(cursor1.getString(8));
            date = String.valueOf(cursor1.getString(9));
            ListModel listmodel = new ListModel();
            listmodel.setId_content(id_content);
            listmodel.setId_hp(id_hp);
            listmodel.setCodename(codename);
            listmodel.setRoom_title(title);
            listmodel.setRoom_path_image(path_image);
            listmodel.setRoom_content(content);
            listmodel.setRoom_content_ext(content_ext);
            listmodel.setRoom_date(date);
            arraylist.add(listmodel);
        } while (cursor1.moveToNext());
        Log.e("bookmark", String.valueOf(arraylist.size()));
        list_Tanya.setVisibility(0);
_L4:
        db.close();
        return arraylist;
_L2:
        try
        {
            Log.e("bookmark", "nol");
            progressbar_Tanya.setVisibility(8);
            txt_empty_Tanya.setVisibility(0);
            txt_empty_Tanya.setText("Belum ada pertanyaan disimpan");
        }
        catch (Exception exception) { }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onBackPressed()
    {
        finish();
        overridePendingTransition(0x7f040001, 0x7f040002);
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300eb);
        db = new DatabaseHandler(this);
        userFunctions = new UserFunctions();
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            setTranslucentStatus(true);
        }
        bundle = new SystemBarTintManager(this);
        bundle.setStatusBarTintEnabled(true);
        bundle.setStatusBarTintResource(0x7f08016e);
        actionBar = getSupportActionBar();
        actionBar.setDisplayUseLogoEnabled(useLogo);
        actionBar.setBackgroundDrawable(getResources().getDrawable(0x7f0200e7));
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        int j = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        int i = j;
        if (j == 0)
        {
            i = 0x7f0b0037;
        }
        bundle = new StringBuilder();
        bundle.append("<font color='#FFFFFF'>");
        bundle.append("Draft");
        bundle.append("</font>");
        getSupportActionBar().setTitle(Html.fromHtml(bundle.toString()));
        bundle = (TextView)findViewById(i);
        bundle.setSelected(true);
        bundle.setTextColor(Color.parseColor("#FFFFFF"));
        bundle.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        progressbar_Artikel = (ProgressBar)findViewById(0x7f0b06e1);
        progressbar_Artikel.setVisibility(8);
        progressbar_Tanya = (ProgressBar)findViewById(0x7f0b06e4);
        progressbar_Tanya.setVisibility(8);
        progressbar_hasilkamera = (ProgressBar)findViewById(0x7f0b06e7);
        progressbar_hasilkamera.setVisibility(8);
        progressbar_hasilbenchmark = (ProgressBar)findViewById(0x7f0b06ea);
        progressbar_hasilbenchmark.setVisibility(8);
        txt_empty_Tanya = (TextView)findViewById(0x7f0b06e5);
        txt_empty_Artikel = (TextView)findViewById(0x7f0b06e2);
        txt_empty_hasilkamera = (TextView)findViewById(0x7f0b06e8);
        txt_empty_hasilbenchmark = (TextView)findViewById(0x7f0b06eb);
        list_Artikel = (ExpandableHeightGridView)findViewById(0x7f0b06e3);
        list_Tanya = (ExpandableHeightGridView)findViewById(0x7f0b06e6);
        list_hasilkamera = (ExpandableHeightGridView)findViewById(0x7f0b06e9);
        list_hasilbenchmark = (ExpandableHeightGridView)findViewById(0x7f0b06ec);
        list_Artikel.setExpanded(true);
        list_Tanya.setExpanded(true);
        list_hasilkamera.setExpanded(true);
        list_hasilbenchmark.setExpanded(true);
        artikelArray = new ArrayList();
        tanyaArray = new ArrayList();
        kameraArray = new ArrayList();
        benchmarkArray = new ArrayList();
        artikelArray = loadArtikelDB();
        artikelAdapter = new ListartikelAdapter(this, 0x7f03011d, artikelArray);
        list_Artikel.setAdapter(artikelAdapter);
        loadDataArtikel();
        tanyaArray = loadTanyaHPDB();
        tanyaAdapter = new ListTanyaAdapter(this, 0x7f03011d, tanyaArray);
        list_Tanya.setAdapter(tanyaAdapter);
        loadTanyaHPDB();
        kameraArray = loadKameraDB();
        kameraAdapter = new ListartikelAdapter(this, 0x7f03011d, kameraArray);
        list_hasilkamera.setAdapter(kameraAdapter);
        loadDataHasilkamera();
        benchmarkArray = loadBenchmarkDB();
        benchmarkAdapter = new ListartikelAdapter(this, 0x7f03011d, benchmarkArray);
        list_hasilbenchmark.setAdapter(benchmarkAdapter);
        loadDataHasilBenchmark();
        list_Artikel.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final RoomMyDraftPost this$0;

            public void onItemClick(AdapterView adapterview, View view, int k, long l)
            {
                adapterview = new Intent(getApplicationContext(), com/inponsel/android/v2/RoomPostArtikel);
                adapterview.putExtra("action", "edit");
                adapterview.putExtra("id_content", artikelAdapter.getListModel(k).getId_content());
                adapterview.putExtra("id_hph", artikelAdapter.getListModel(k).getId_hp());
                adapterview.putExtra("codename", artikelAdapter.getListModel(k).getCodename());
                adapterview.putExtra("from", "notif");
                adapterview.putExtra("model", "");
                adapterview.putExtra("merk", "");
                adapterview.putExtra("id_date", artikelAdapter.getListModel(k).getRoom_date());
                Log.e("id_content", artikelAdapter.getListModel(k).getId_content());
                startActivityForResult(adapterview, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = RoomMyDraftPost.this;
                super();
            }
        });
        list_hasilkamera.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final RoomMyDraftPost this$0;

            public void onItemClick(AdapterView adapterview, View view, int k, long l)
            {
                adapterview = new Intent(getApplicationContext(), com/inponsel/android/v2/RoomPostHasilFotoNoCrop);
                adapterview.putExtra("id_content", kameraAdapter.getListModel(k).getId_content());
                adapterview.putExtra("action", "edit");
                adapterview.putExtra("id_hph", kameraAdapter.getListModel(k).getId_hp());
                adapterview.putExtra("codename", kameraAdapter.getListModel(k).getCodename());
                adapterview.putExtra("from", "notif");
                adapterview.putExtra("model", "");
                adapterview.putExtra("merk", "");
                adapterview.putExtra("id_date", kameraAdapter.getListModel(k).getRoom_date());
                Log.e("id_content", kameraAdapter.getListModel(k).getId_content());
                startActivityForResult(adapterview, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = RoomMyDraftPost.this;
                super();
            }
        });
        list_hasilbenchmark.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final RoomMyDraftPost this$0;

            public void onItemClick(AdapterView adapterview, View view, int k, long l)
            {
                adapterview = new Intent(getApplicationContext(), com/inponsel/android/v2/RoomPostBenchmark);
                adapterview.putExtra("id_content", benchmarkAdapter.getListModel(k).getId_content());
                adapterview.putExtra("action", "edit");
                adapterview.putExtra("id_hph", benchmarkAdapter.getListModel(k).getId_hp());
                adapterview.putExtra("codename", benchmarkAdapter.getListModel(k).getCodename());
                adapterview.putExtra("from", "notif");
                adapterview.putExtra("model", "");
                adapterview.putExtra("merk", "");
                adapterview.putExtra("id_date", benchmarkAdapter.getListModel(k).getRoom_date());
                Log.e("id_content", benchmarkAdapter.getListModel(k).getId_content());
                startActivityForResult(adapterview, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = RoomMyDraftPost.this;
                super();
            }
        });
        list_Tanya.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final RoomMyDraftPost this$0;

            public void onItemClick(AdapterView adapterview, View view, int k, long l)
            {
                adapterview = new Intent(getApplicationContext(), com/inponsel/android/v2/RoomPostPertanyaan);
                adapterview.putExtra("id_content", tanyaAdapter.getListModel(k).getId_content());
                adapterview.putExtra("action", "edit");
                adapterview.putExtra("id_hph", tanyaAdapter.getListModel(k).getId_hp());
                adapterview.putExtra("codename", tanyaAdapter.getListModel(k).getCodename());
                adapterview.putExtra("from", "notif");
                adapterview.putExtra("model", "");
                adapterview.putExtra("merk", "");
                adapterview.putExtra("id_date", tanyaAdapter.getListModel(k).getRoom_date());
                Log.e("id_date", tanyaAdapter.getListModel(k).getRoom_date());
                startActivityForResult(adapterview, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = RoomMyDraftPost.this;
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
        default:
            return true;

        case 16908332: 
            finish();
            return true;

        case 2131429682: 
            startActivity(new Intent(getApplicationContext(), com/inponsel/android/pencariangen/TabPencarian));
            break;
        }
        return true;
    }

    protected void onResume()
    {
        super.onResume();
        artikelArray = new ArrayList();
        tanyaArray = new ArrayList();
        kameraArray = new ArrayList();
        benchmarkArray = new ArrayList();
        artikelArray = loadArtikelDB();
        artikelAdapter = new ListartikelAdapter(this, 0x7f03011d, artikelArray);
        list_Artikel.setAdapter(artikelAdapter);
        loadDataArtikel();
        tanyaArray = loadTanyaHPDB();
        tanyaAdapter = new ListTanyaAdapter(this, 0x7f03011d, tanyaArray);
        list_Tanya.setAdapter(tanyaAdapter);
        loadTanyaHPDB();
        kameraArray = loadKameraDB();
        kameraAdapter = new ListartikelAdapter(this, 0x7f03011d, kameraArray);
        list_hasilkamera.setAdapter(kameraAdapter);
        loadDataHasilkamera();
        benchmarkArray = loadBenchmarkDB();
        benchmarkAdapter = new ListartikelAdapter(this, 0x7f03011d, benchmarkArray);
        list_hasilbenchmark.setAdapter(benchmarkAdapter);
        loadDataHasilBenchmark();
    }
}
