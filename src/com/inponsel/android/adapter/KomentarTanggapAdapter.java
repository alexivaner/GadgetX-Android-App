// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
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
import java.util.regex.Pattern;

// Referenced classes of package com.inponsel.android.adapter:
//            ListModel

public class KomentarTanggapAdapter extends BaseAdapter
{
    static class ViewHolder
    {

        LinearLayout headName;
        ImageView imageLeft;
        ImageView imageRight;
        TextView imgLike;
        TextView imgTanggapan;
        ImageView img_kom_picture;
        TextView imgdisLike;
        ProgressBar progressbar_item;
        TextView txtKomentar;
        TextView txtUsername;
        TextView txtWaktu;

        ViewHolder()
        {
        }
    }


    public static String email_user;
    public static String nama_asli;
    public static String user_id;
    public static String user_jekel;
    public static String user_joindate;
    public static String user_kota;
    public static String user_ponsel1;
    public static String user_ponsel2;
    public static String user_profile_update;
    public static String user_provider1;
    public static String user_provider2;
    public static String user_provinsi;
    public static String user_ttl;
    public static String username = "";
    private Activity activity;
    Context context;
    Cursor cursor;
    DatabaseHandler db;
    private ArrayList lm;
    int resource;
    String response;
    UserFunctions userFunctions;

    public KomentarTanggapAdapter(Activity activity1, int i, ArrayList arraylist)
    {
        lm = arraylist;
        activity = activity1;
        resource = i;
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

    public View getView(int i, View view, final ViewGroup holder)
    {
        userFunctions = new UserFunctions();
        db = new DatabaseHandler(activity);
        if (userFunctions.isUserLoggedIn(activity))
        {
            cursor = db.getAllData();
            cursor.moveToFirst();
            ListModel listmodel;
            Object obj;
            String s;
            String s1;
            try
            {
                user_id = EncodeDecodeAES.decrypt(RestClient.pelihara, cursor.getString(1));
            }
            // Misplaced declaration of an exception variable
            catch (final ViewGroup holder) { }
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
        }
        if (view == null)
        {
            view = ((LayoutInflater)activity.getSystemService("layout_inflater")).inflate(resource, null);
            holder = new ViewHolder();
            holder.txtUsername = (TextView)view.findViewById(0x7f0b0419);
            holder.txtKomentar = (TextView)view.findViewById(0x7f0b054e);
            holder.txtWaktu = (TextView)view.findViewById(0x7f0b054c);
            holder.imgTanggapan = (TextView)view.findViewById(0x7f0b0555);
            ((ViewHolder) (holder)).imgTanggapan.setVisibility(8);
            holder.imgLike = (TextView)view.findViewById(0x7f0b0550);
            holder.imgdisLike = (TextView)view.findViewById(0x7f0b0553);
            holder.img_kom_picture = (ImageView)view.findViewById(0x7f0b054b);
            holder.headName = (LinearLayout)view.findViewById(0x7f0b0549);
            holder.progressbar_item = (ProgressBar)view.findViewById(0x7f0b00b3);
            view.setTag(holder);
        } else
        {
            holder = (ViewHolder)view.getTag();
        }
        listmodel = (ListModel)lm.get(i);
        if (lm == null) goto _L2; else goto _L1
_L1:
        obj = listmodel.getTanggal_komentar().toString();
        s = listmodel.getNama_komentar().toString();
        s1 = listmodel.getEmail_komentar().toString();
        if (!s.contains("admin")) goto _L4; else goto _L3
_L3:
        ((ViewHolder) (holder)).headName.setBackgroundResource(0x7f080052);
        ((ViewHolder) (holder)).txtUsername.setTextColor(activity.getResources().getColor(0x7f080052));
        ((ViewHolder) (holder)).txtWaktu.setTextColor(activity.getResources().getColor(0x7f080052));
_L5:
        ((ViewHolder) (holder)).txtUsername.setText(s);
        ((ViewHolder) (holder)).imgLike.setText(listmodel.getTanggapLike());
        ((ViewHolder) (holder)).imgdisLike.setText(listmodel.getTanggapDisLike());
        ((ViewHolder) (holder)).txtKomentar.setText(listmodel.getTanggapan());
        ((ViewHolder) (holder)).txtWaktu.setText(((CharSequence) (obj)));
        obj = Pattern.compile("(@[a-zA-Z0-9_]+)");
        Linkify.addLinks(((ViewHolder) (holder)).txtKomentar, ((Pattern) (obj)), "http://twitter.com/");
        obj = Pattern.compile("#([A-Za-z0-9_-]+)");
        Linkify.addLinks(((ViewHolder) (holder)).txtKomentar, ((Pattern) (obj)), "http://twitter.com/#!/search/");
        if (!listmodel.getTanggapan_pict().contains(".jpg") && !listmodel.getTanggapan_pict().contains(".png") && !listmodel.getTanggapan_pict().contains(".jpeg"))
        {
            break MISSING_BLOCK_LABEL_866;
        }
        Picasso.with(activity).load((new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(listmodel.getTanggapan_pict().trim()).toString()).into(((ViewHolder) (holder)).img_kom_picture, new Callback() {

            final KomentarTanggapAdapter this$0;
            private final ViewHolder val$holder;

            public void onError()
            {
                holder.progressbar_item.setVisibility(8);
            }

            public void onSuccess()
            {
                holder.progressbar_item.setVisibility(8);
                holder.img_kom_picture.setVisibility(0);
            }

            
            {
                this$0 = KomentarTanggapAdapter.this;
                holder = viewholder;
                super();
            }
        });
_L6:
        Linkify.addLinks(((ViewHolder) (holder)).txtKomentar, 15);
_L2:
        return view;
_L4:
label0:
        {
            if (!s1.equals(email_user))
            {
                break label0;
            }
            ((ViewHolder) (holder)).headName.setBackgroundResource(0x7f080045);
            ((ViewHolder) (holder)).txtUsername.setTextColor(activity.getResources().getColor(0x7f080045));
            ((ViewHolder) (holder)).txtWaktu.setTextColor(activity.getResources().getColor(0x7f080045));
        }
          goto _L5
        try
        {
            ((ViewHolder) (holder)).headName.setBackgroundResource(0x7f08003a);
            ((ViewHolder) (holder)).txtUsername.setTextColor(activity.getResources().getColor(0x7f08003a));
            ((ViewHolder) (holder)).txtWaktu.setTextColor(activity.getResources().getColor(0x7f08003a));
        }
        // Misplaced declaration of an exception variable
        catch (final ViewGroup holder)
        {
            holder.printStackTrace();
            return view;
        }
          goto _L5
        ((ViewHolder) (holder)).img_kom_picture.setImageResource(0x7f020297);
          goto _L6
    }

    void log(String s)
    {
    }

    public void setListArray(ArrayList arraylist)
    {
        lm = arraylist;
    }

}
