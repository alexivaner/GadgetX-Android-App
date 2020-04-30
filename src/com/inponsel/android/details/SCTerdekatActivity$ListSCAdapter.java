// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Utility;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.details:
//            SCTerdekatActivity

public class t extends BaseAdapter
{
    class ViewHolder
    {

        LinearLayout headImage;
        ImageView imageHp;
        RelativeLayout list_lay_dislike;
        RelativeLayout list_lay_kom;
        RelativeLayout list_lay_like;
        TextView list_txtAlamat;
        TextView list_txtMerek;
        ProgressBar progressbar_item;
        final SCTerdekatActivity.ListSCAdapter this$1;

        ViewHolder()
        {
            this$1 = SCTerdekatActivity.ListSCAdapter.this;
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
    String no_telp_array[];
    int pos;
    String res;
    int resource;
    String response;
    String status;
    String t;
    final SCTerdekatActivity this$0;
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

    public View getView(int i, View view, final ViewGroup holder)
    {
        pos = i;
        if (view == null)
        {
            view = ((LayoutInflater)activity.getSystemService("layout_inflater")).inflate(resource, null);
            holder = new ViewHolder();
            holder.imageHp = (ImageView)view.findViewById(0x7f0b023d);
            holder.list_txtMerek = (TextView)view.findViewById(0x7f0b033c);
            holder.list_txtAlamat = (TextView)view.findViewById(0x7f0b033d);
            holder.progressbar_item = (ProgressBar)view.findViewById(0x7f0b00b3);
            holder.list_lay_like = (RelativeLayout)view.findViewById(0x7f0b0342);
            holder.list_lay_dislike = (RelativeLayout)view.findViewById(0x7f0b0345);
            holder.list_lay_kom = (RelativeLayout)view.findViewById(0x7f0b0348);
            holder.headImage = (LinearLayout)view.findViewById(0x7f0b029f);
            view.setTag(holder);
        } else
        {
            holder = (ViewHolder)view.getTag();
        }
        lms = (ListModel)lm.get(i);
        if (lm != null)
        {
            ((ViewHolder) (holder)).list_txtMerek.setText((new StringBuilder(String.valueOf(lms.getSc_merk()))).append(" ").append(lms.getSc_nama()).toString());
            ((ViewHolder) (holder)).list_txtAlamat.setText((new StringBuilder(String.valueOf(lms.getSc_merk()))).append(" ").append(lms.getSc_nama()).toString());
            ((ViewHolder) (holder)).list_txtAlamat.setSelected(true);
            no_telp_array = lms.getSc_no_telp().trim().split(",");
            ((ViewHolder) (holder)).list_lay_like.setOnClickListener(new android.view.View.OnClickListener() {

                final SCTerdekatActivity.ListSCAdapter this$1;

                public void onClick(View view1)
                {
                    view1 = new android.app.AlertDialog.Builder(this$0);
                    view1.setTitle("Nomor Telepon :");
                    view1.setSingleChoiceItems(no_telp_array, -1, new android.content.DialogInterface.OnClickListener() {

                        final _cls1 this$2;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent("android.intent.action.DIAL", Uri.parse((new StringBuilder("tel: ")).append(no_telp_array[i].replaceAll("-", "")).toString()));
                            startActivity(dialoginterface);
                        }

            
            {
                this$2 = _cls1.this;
                super();
            }
                    });
                    view1.show();
                }


            
            {
                this$1 = SCTerdekatActivity.ListSCAdapter.this;
                super();
            }
            });
            ((ViewHolder) (holder)).list_lay_dislike.setOnClickListener(new android.view.View.OnClickListener() {

                final SCTerdekatActivity.ListSCAdapter this$1;

                public void onClick(View view1)
                {
                }

            
            {
                this$1 = SCTerdekatActivity.ListSCAdapter.this;
                super();
            }
            });
            ((ViewHolder) (holder)).list_lay_kom.setOnClickListener(new android.view.View.OnClickListener() {

                final SCTerdekatActivity.ListSCAdapter this$1;

                public void onClick(View view1)
                {
                }

            
            {
                this$1 = SCTerdekatActivity.ListSCAdapter.this;
                super();
            }
            });
            try
            {
                Picasso.with(activity).load(lms.getSc_logo().trim()).into(((ViewHolder) (holder)).imageHp, new Callback() {

                    final SCTerdekatActivity.ListSCAdapter this$1;
                    private final ViewHolder val$holder;

                    public void onError()
                    {
                    }

                    public void onSuccess()
                    {
                        holder.imageHp.setVisibility(0);
                    }

            
            {
                this$1 = SCTerdekatActivity.ListSCAdapter.this;
                holder = viewholder;
                super();
            }
                });
            }
            // Misplaced declaration of an exception variable
            catch (final ViewGroup holder)
            {
                holder.printStackTrace();
                return view;
            }
        }
        return view;
    }

    public void setListArray(ArrayList arraylist)
    {
        lm = arraylist;
    }


    public _cls4.val.holder(Activity activity1, int i, ArrayList arraylist)
    {
        this$0 = SCTerdekatActivity.this;
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
        catch (SCTerdekatActivity scterdekatactivity)
        {
            return;
        }
    }
}
