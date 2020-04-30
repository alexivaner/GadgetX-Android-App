// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

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
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.v2:
//            SCUserActivity

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
        final SCUserActivity.ListSCAdapter this$1;

        ViewHolder()
        {
            this$1 = SCUserActivity.ListSCAdapter.this;
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
    ImageLoader imageLoader2;
    String komen;
    private ArrayList lm;
    ListModel lms;
    ProgressDialog mDialog;
    String no_telp_array[];
    private DisplayImageOptions options;
    int pos;
    String res;
    int resource;
    String response;
    String status;
    String t;
    final SCUserActivity this$0;
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
        pos = i;
        if (view == null)
        {
            view = ((LayoutInflater)activity.getSystemService("layout_inflater")).inflate(resource, null);
            viewgroup = new ViewHolder();
            viewgroup.imageHp = (ImageView)view.findViewById(0x7f0b023d);
            viewgroup.list_txtMerek = (TextView)view.findViewById(0x7f0b033c);
            viewgroup.list_txtAlamat = (TextView)view.findViewById(0x7f0b033d);
            viewgroup.progressbar_item = (ProgressBar)view.findViewById(0x7f0b00b3);
            viewgroup.list_lay_like = (RelativeLayout)view.findViewById(0x7f0b0342);
            viewgroup.list_lay_dislike = (RelativeLayout)view.findViewById(0x7f0b0345);
            viewgroup.list_lay_kom = (RelativeLayout)view.findViewById(0x7f0b0348);
            viewgroup.headImage = (LinearLayout)view.findViewById(0x7f0b029f);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        lms = (ListModel)lm.get(i);
        if (lm != null)
        {
            ((ViewHolder) (viewgroup)).list_txtMerek.setText((new StringBuilder(String.valueOf(lms.getSc_merk()))).append(" ").append(lms.getSc_nama()).toString());
            ((ViewHolder) (viewgroup)).list_txtAlamat.setText((new StringBuilder(String.valueOf(lms.getSc_merk()))).append(" ").append(lms.getSc_nama()).toString());
            ((ViewHolder) (viewgroup)).list_txtAlamat.setSelected(true);
            no_telp_array = lms.getSc_no_telp().trim().split(",");
            ((ViewHolder) (viewgroup)).list_lay_like.setOnClickListener(new android.view.View.OnClickListener() {

                final SCUserActivity.ListSCAdapter this$1;

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
                this$1 = SCUserActivity.ListSCAdapter.this;
                super();
            }
            });
            ((ViewHolder) (viewgroup)).list_lay_dislike.setOnClickListener(new android.view.View.OnClickListener() {

                final SCUserActivity.ListSCAdapter this$1;

                public void onClick(View view1)
                {
                }

            
            {
                this$1 = SCUserActivity.ListSCAdapter.this;
                super();
            }
            });
            ((ViewHolder) (viewgroup)).list_lay_kom.setOnClickListener(new android.view.View.OnClickListener() {

                final SCUserActivity.ListSCAdapter this$1;

                public void onClick(View view1)
                {
                }

            
            {
                this$1 = SCUserActivity.ListSCAdapter.this;
                super();
            }
            });
            imageLoader2.displayImage(lms.getSc_logo().trim(), ((ViewHolder) (viewgroup)).imageHp, options, animateFirstListener);
        }
        return view;
    }

    public void setListArray(ArrayList arraylist)
    {
        lm = arraylist;
    }


    public aleType(Activity activity1, int i, ArrayList arraylist)
    {
        this$0 = SCUserActivity.this;
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
            imageLoader2 = ImageLoader.getInstance();
            imageLoader2.init(ImageLoaderConfiguration.createDefault(activity.getApplicationContext()));
            options = (new com.nostra13.universalimageloader.core.init>()).howImageForEmptyUri(0x7f020208).acheInMemory(true).mageScaleType(ImageScaleType.EXACTLY).itmapConfig(android.graphics.nfig).uild();
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
        catch (SCUserActivity scuseractivity)
        {
            return;
        }
    }
}
