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
import android.widget.TextView;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.inponsel.android.adapter:
//            PonselBaseApp, ModelObserver, ListModel

public class ListAppsAdapter extends BaseAdapter
    implements Observer
{
    static class ViewHolder
    {

        ImageView img_apps_1;
        RatingBar rbar_apps_1;
        TextView txt_apps_name_1;

        ViewHolder()
        {
        }
    }


    private Activity activity;
    Context context;
    int count_number;
    protected Cursor cursor;
    protected DatabaseHandler db;
    protected String email_user;
    private ArrayList lm;
    protected String nama_asli;
    DisplayImageOptions optionsDoodle;
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

    public ListAppsAdapter(Activity activity1, int i, ArrayList arraylist)
    {
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
        optionsDoodle = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showImageOnLoading(0x7f02033f).showImageForEmptyUri(0x7f020209).cacheInMemory(true).cacheOnDisk(true).considerExifParams(true).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).build();
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

    public View getView(int i, final View holder, ViewGroup viewgroup)
    {
        viewgroup = holder;
        ListModel listmodel;
        if (viewgroup == null)
        {
            viewgroup = ((LayoutInflater)activity.getSystemService("layout_inflater")).inflate(resource, null);
            holder = new ViewHolder();
            holder.img_apps_1 = (ImageView)viewgroup.findViewById(0x7f0b08fc);
            holder.txt_apps_name_1 = (TextView)viewgroup.findViewById(0x7f0b08fd);
            holder.rbar_apps_1 = (RatingBar)viewgroup.findViewById(0x7f0b08fe);
            viewgroup.setTag(holder);
        } else
        {
            holder = (ViewHolder)viewgroup.getTag();
        }
        listmodel = (ListModel)lm.get(i);
        if (lm != null)
        {
            ((ViewHolder) (holder)).txt_apps_name_1.setText(listmodel.getAppname());
            ((ViewHolder) (holder)).txt_apps_name_1.setSelected(true);
            float f = Float.parseFloat(listmodel.getAvgrate());
            ((ViewHolder) (holder)).rbar_apps_1.setRating(f);
            Log.e("lms.getAppcover()", listmodel.getAppcover());
            Picasso.with(activity).load(listmodel.getAppcover().trim()).into(((ViewHolder) (holder)).img_apps_1, new Callback() {

                final ListAppsAdapter this$0;
                private final ViewHolder val$holder;

                public void onError()
                {
                }

                public void onSuccess()
                {
                    holder.img_apps_1.setVisibility(0);
                }

            
            {
                this$0 = ListAppsAdapter.this;
                holder = viewholder;
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
