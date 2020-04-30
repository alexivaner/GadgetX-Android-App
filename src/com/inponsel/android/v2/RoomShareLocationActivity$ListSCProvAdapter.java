// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.utils.Log;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.v2:
//            RoomShareLocationActivity

public class resource extends BaseAdapter
{
    class ViewHolder
    {

        RelativeLayout rl_circle;
        RelativeLayout root_people;
        final RoomShareLocationActivity.ListSCProvAdapter this$1;
        TextView txt_nama;
        TextView txt_username;

        ViewHolder()
        {
            this$1 = RoomShareLocationActivity.ListSCProvAdapter.this;
            super();
        }
    }


    private Activity activity;
    Context context;
    Cursor cursor;
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
    final RoomShareLocationActivity this$0;
    String user;
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
            viewgroup.root_people = (RelativeLayout)view.findViewById(0x7f0b084b);
            viewgroup.rl_circle = (RelativeLayout)view.findViewById(0x7f0b084c);
            viewgroup.txt_nama = (TextView)view.findViewById(0x7f0b084d);
            viewgroup.txt_username = (TextView)view.findViewById(0x7f0b0373);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        lms = (ListModel)lm.get(i);
        if (lm != null)
        {
            ((ViewHolder) (viewgroup)).rl_circle.setVisibility(0);
            Log.e("alamat", lms.getAddress());
            ((ViewHolder) (viewgroup)).txt_nama.setText(lms.getPlaces());
            ((ViewHolder) (viewgroup)).txt_username.setText(lms.getAddress());
            ((ViewHolder) (viewgroup)).txt_nama.setSelected(true);
        }
        return view;
    }

    public void setListArray(ArrayList arraylist)
    {
        lm = arraylist;
    }

    public ViewHolder.this._cls1(Activity activity1, int i, ArrayList arraylist)
    {
        this$0 = RoomShareLocationActivity.this;
        super();
        fmt = new DecimalFormat();
        fmts = new DecimalFormatSymbols();
        username = "";
        user = "";
        komen = "";
        email_user = "";
        finalUrl = "";
        lm = arraylist;
        activity = activity1;
        resource = i;
    }
}
