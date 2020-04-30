// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.adapter;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.inponsel.android.adapter:
//            PonselBaseApp, ModelObserver, ListModel

public class ListAppsHorizontalAdapter extends BaseAdapter
    implements Observer
{
    static class ViewHolder
    {

        ImageView img_apps_1;
        RatingBar rbar_apps_1;
        RelativeLayout rl_download_apps;
        TextView txt_apps_downcount_size;
        TextView txt_apps_name_1;

        ViewHolder()
        {
        }
    }


    private Activity activity;
    String appsize;
    Context context;
    int count_number;
    protected Cursor cursor;
    protected DatabaseHandler db;
    String downloadrange;
    protected String email_user;
    private ArrayList lm;
    protected String nama_asli;
    String partsDownload[];
    PonselBaseApp ponselBaseApp;
    int resource;
    String response;
    protected UserFunctions userFunctions;
    protected String user_id;
    protected String user_jekel;
    protected String user_joindate;
    protected String user_kecamatan;
    protected String user_kota;
    protected String user_photo;
    protected String user_ponsel1;
    protected String user_ponsel2;
    protected String user_profile_update;
    protected String user_provider1;
    protected String user_provider2;
    protected String user_provinsi;
    protected String user_ttl;
    protected String username;

    public ListAppsHorizontalAdapter(Activity activity1, int i, ArrayList arraylist)
    {
        downloadrange = "";
        appsize = "";
        count_number = 0;
        user_id = "";
        user_photo = "";
        username = "";
        nama_asli = "";
        email_user = "";
        user_ttl = "";
        user_kota = "";
        user_kecamatan = "";
        user_provinsi = "";
        user_jekel = "";
        user_ponsel1 = "";
        user_ponsel2 = "";
        user_provider1 = "";
        user_provider2 = "";
        user_joindate = "";
        user_profile_update = "";
        lm = arraylist;
        activity = activity1;
        resource = i;
        db = new DatabaseHandler(activity1);
        userFunctions = new UserFunctions();
        ponselBaseApp = (PonselBaseApp)activity1.getApplication();
        ponselBaseApp.getObserver().addObserver(this);
        if (userFunctions.isUserLoggedIn(activity1))
        {
            cursor = db.getAllData();
            cursor.moveToFirst();
            try
            {
                user_id = EncodeDecodeAES.decrypt(RestClient.pelihara, cursor.getString(1));
            }
            // Misplaced declaration of an exception variable
            catch (Activity activity1) { }
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
    }

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
        ListModel listmodel;
        if (viewgroup == null)
        {
            viewgroup = ((LayoutInflater)activity.getSystemService("layout_inflater")).inflate(resource, null);
            view = new ViewHolder();
            view.img_apps_1 = (ImageView)viewgroup.findViewById(0x7f0b08fc);
            view.txt_apps_name_1 = (TextView)viewgroup.findViewById(0x7f0b08fd);
            view.txt_apps_downcount_size = (TextView)viewgroup.findViewById(0x7f0b0900);
            view.rl_download_apps = (RelativeLayout)viewgroup.findViewById(0x7f0b08ff);
            view.rbar_apps_1 = (RatingBar)viewgroup.findViewById(0x7f0b08fe);
            viewgroup.setTag(view);
        } else
        {
            view = (ViewHolder)viewgroup.getTag();
        }
        listmodel = (ListModel)lm.get(i);
        if (lm != null)
        {
            ((ViewHolder) (view)).txt_apps_name_1.setText(listmodel.getAppname());
            ((ViewHolder) (view)).txt_apps_name_1.setSelected(true);
            try
            {
                ((ViewHolder) (view)).rbar_apps_1.setRating(Float.parseFloat(listmodel.getAvgrate()));
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
            if (listmodel.getDownloadcount().contains("-"))
            {
                downloadrange = listmodel.getDownloadcount();
                partsDownload = downloadrange.split("-");
                if (listmodel.getAppsize().toUpperCase().contains("M"))
                {
                    appsize = (new StringBuilder(String.valueOf(listmodel.getAppsize()))).toString();
                } else
                if (listmodel.getAppsize().toUpperCase().contains("G"))
                {
                    appsize = (new StringBuilder(String.valueOf(listmodel.getAppsize()))).toString();
                } else
                {
                    appsize = listmodel.getAppsize();
                }
                ((ViewHolder) (view)).txt_apps_downcount_size.setText((new StringBuilder(String.valueOf(partsDownload[0]))).append("+ | ").append(appsize).toString());
            } else
            {
                ((ViewHolder) (view)).txt_apps_downcount_size.setText((new StringBuilder(String.valueOf(listmodel.getDownloadcount()))).append("+ | ").append(appsize).toString());
            }
            Picasso.with(activity).load(listmodel.getAppcover().trim()).into(((ViewHolder) (view)).img_apps_1, new Callback() {

                final ListAppsHorizontalAdapter this$0;

                public void onError()
                {
                }

                public void onSuccess()
                {
                }

            
            {
                this$0 = ListAppsHorizontalAdapter.this;
                super();
            }
            });
        }
        return viewgroup;
    }

    void log(String s)
    {
    }

    public void setListArray(ArrayList arraylist)
    {
        lm = arraylist;
    }

    public void update(Observable observable, Object obj)
    {
    }
}
