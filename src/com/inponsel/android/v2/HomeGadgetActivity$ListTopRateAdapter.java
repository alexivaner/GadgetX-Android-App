// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Utility;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.v2:
//            HomeGadgetActivity

public class t extends BaseAdapter
{
    class ViewHolder
    {

        ImageView imageHp;
        ImageView list_dislike;
        RelativeLayout list_lay_dislike;
        RelativeLayout list_lay_kom;
        RelativeLayout list_lay_like;
        ImageView list_like;
        TextView list_text_dislike;
        TextView list_text_komentar;
        TextView list_text_like;
        TextView list_txtCodename;
        TextView list_txtHarga;
        TextView list_txtMerek;
        LinearLayout ll_master_item;
        ProgressBar progressbar_item;
        RatingBar rateRate;
        final HomeGadgetActivity.ListTopRateAdapter this$1;

        ViewHolder()
        {
            this$1 = HomeGadgetActivity.ListTopRateAdapter.this;
            super();
        }
    }


    private Activity activity;
    Context context;
    Cursor cursor;
    DatabaseHandler db;
    String email_user;
    String finalUrl;
    DecimalFormat fmt;
    DecimalFormatSymbols fmts;
    int hargaBaru;
    int hargaBekas;
    String hrg_baru;
    String hrg_bekas;
    String komen;
    private ArrayList lm;
    ListModel lms;
    PonselBaseApp ponselBaseApp;
    int pos;
    String res;
    int resource;
    String response;
    String statusLikeHpSegera;
    String statusSegera;
    String t;
    final HomeGadgetActivity this$0;
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
        if (view == null)
        {
            view = ((LayoutInflater)activity.getSystemService("layout_inflater")).inflate(resource, null);
            viewgroup = new ViewHolder();
            viewgroup.imageHp = (ImageView)view.findViewById(0x7f0b023d);
            viewgroup.list_txtMerek = (TextView)view.findViewById(0x7f0b033c);
            viewgroup.list_txtHarga = (TextView)view.findViewById(0x7f0b033d);
            viewgroup.list_txtCodename = (TextView)view.findViewById(0x7f0b033f);
            viewgroup.list_text_like = (TextView)view.findViewById(0x7f0b0344);
            viewgroup.list_text_dislike = (TextView)view.findViewById(0x7f0b0347);
            viewgroup.list_text_komentar = (TextView)view.findViewById(0x7f0b034a);
            viewgroup.list_like = (ImageView)view.findViewById(0x7f0b0343);
            viewgroup.list_dislike = (ImageView)view.findViewById(0x7f0b0346);
            viewgroup.progressbar_item = (ProgressBar)view.findViewById(0x7f0b00b3);
            viewgroup.ll_master_item = (LinearLayout)view.findViewById(0x7f0b084e);
            viewgroup.list_lay_like = (RelativeLayout)view.findViewById(0x7f0b0342);
            viewgroup.list_lay_dislike = (RelativeLayout)view.findViewById(0x7f0b0345);
            viewgroup.list_lay_kom = (RelativeLayout)view.findViewById(0x7f0b0348);
            viewgroup.rateRate = (RatingBar)view.findViewById(0x7f0b00c9);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        lms = (ListModel)lm.get(i);
        if (lm != null)
        {
            ((ViewHolder) (viewgroup)).ll_master_item.setBackgroundResource(0x7f02007a);
            hrg_baru = lms.getHrg_baru();
            hrg_bekas = lms.getHrg_bekas();
            ((ViewHolder) (viewgroup)).list_txtMerek.setText((new StringBuilder(String.valueOf(lms.getMerk()))).append(" ").append(lms.getModel()).toString());
            ((ViewHolder) (viewgroup)).list_txtCodename.setText(lms.getCodename());
            ((ViewHolder) (viewgroup)).list_text_like.setText(lms.getTotal_like());
            ((ViewHolder) (viewgroup)).list_text_dislike.setText(lms.getTotal_dislike());
            ((ViewHolder) (viewgroup)).list_text_komentar.setText(lms.getTotal_kom());
            ((ViewHolder) (viewgroup)).list_txtHarga.setVisibility(8);
        }
        return view;
    }

    void log(String s)
    {
    }

    public void setListArray(ArrayList arraylist)
    {
        lm = arraylist;
    }

    public ViewHolder.this._cls1(Activity activity1, int i, ArrayList arraylist)
    {
        this$0 = HomeGadgetActivity.this;
        super();
        fmt = new DecimalFormat();
        fmts = new DecimalFormatSymbols();
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
        catch (HomeGadgetActivity homegadgetactivity)
        {
            return;
        }
    }
}
