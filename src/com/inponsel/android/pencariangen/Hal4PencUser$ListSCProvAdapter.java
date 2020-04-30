// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.pencariangen;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Utility;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.pencariangen:
//            Hal4PencUser

public class t extends BaseAdapter
{
    class ViewHolder
    {

        ImageView imageHp;
        ProgressBar progressbar_item;
        RelativeLayout rl_circle;
        final Hal4PencUser.ListSCProvAdapter this$1;
        TextView txt_nama;
        TextView txt_username;

        ViewHolder()
        {
            this$1 = Hal4PencUser.ListSCProvAdapter.this;
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
    final Hal4PencUser this$0;
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

    public View getView(final int position, View view, final ViewGroup holder)
    {
label0:
        {
            pos = position;
            if (view == null)
            {
                view = ((LayoutInflater)activity.getSystemService("layout_inflater")).inflate(resource, null);
                holder = new ViewHolder();
                holder.imageHp = (ImageView)view.findViewById(0x7f0b023d);
                holder.txt_nama = (TextView)view.findViewById(0x7f0b084d);
                holder.txt_username = (TextView)view.findViewById(0x7f0b0373);
                holder.progressbar_item = (ProgressBar)view.findViewById(0x7f0b00b3);
                holder.rl_circle = (RelativeLayout)view.findViewById(0x7f0b084c);
                view.setTag(holder);
            } else
            {
                holder = (ViewHolder)view.getTag();
            }
            lms = (ListModel)lm.get(position);
            if (lm != null)
            {
                ((ViewHolder) (holder)).txt_nama.setText(lms.getNama_asli());
                ((ViewHolder) (holder)).txt_username.setText(lms.getUsername());
                ((ViewHolder) (holder)).txt_nama.setSelected(true);
                ((ViewHolder) (holder)).rl_circle.setVisibility(8);
                if (!lms.getAvatar().trim().equals(""))
                {
                    break label0;
                }
                ((ViewHolder) (holder)).imageHp.setVisibility(0);
                ((ViewHolder) (holder)).imageHp.setImageResource(0x7f020297);
            }
            return view;
        }
        Picasso.with(activity).load(lms.getAvatar().trim()).tag(activity).into(((ViewHolder) (holder)).imageHp, new Callback() {

            final Hal4PencUser.ListSCProvAdapter this$1;
            private final ViewHolder val$holder;
            private final int val$position;

            public void onError()
            {
                holder.progressbar_item.setVisibility(8);
            }

            public void onSuccess()
            {
                holder.progressbar_item.setVisibility(8);
                holder.imageHp.setVisibility(0);
                Log.e("load", String.valueOf(position));
            }

            
            {
                this$1 = Hal4PencUser.ListSCProvAdapter.this;
                holder = viewholder;
                position = i;
                super();
            }
        });
        return view;
    }

    public void setListArray(ArrayList arraylist)
    {
        lm = arraylist;
    }

    public _cls1.val.position(Activity activity1, int i, ArrayList arraylist)
    {
        this$0 = Hal4PencUser.this;
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
        catch (Hal4PencUser hal4pencuser)
        {
            return;
        }
    }
}
