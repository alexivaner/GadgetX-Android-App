// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.adapter:
//            ListModel

public class ListHPPeopleAdapter extends BaseAdapter
{
    static class ViewHolder
    {

        ImageView imgProfil;
        RelativeLayout myroot;
        ProgressBar progressbar_Avatar;
        TextView txt_lokasi;
        TextView txt_name;
        TextView txt_username;

        ViewHolder()
        {
        }
    }


    private Activity activity;
    Context context;
    private ArrayList lm;
    int resource;
    String response;

    public ListHPPeopleAdapter(Activity activity1, int i, ArrayList arraylist)
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

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        viewgroup = view;
        ListModel listmodel;
        if (viewgroup == null)
        {
            viewgroup = ((LayoutInflater)activity.getSystemService("layout_inflater")).inflate(resource, null);
            view = new ViewHolder();
            view.imgProfil = (ImageView)viewgroup.findViewById(0x7f0b064d);
            view.txt_username = (TextView)viewgroup.findViewById(0x7f0b0373);
            view.txt_name = (TextView)viewgroup.findViewById(0x7f0b064e);
            view.txt_lokasi = (TextView)viewgroup.findViewById(0x7f0b064f);
            view.progressbar_Avatar = (ProgressBar)viewgroup.findViewById(0x7f0b0633);
            view.myroot = (RelativeLayout)viewgroup.findViewById(0x7f0b0063);
            viewgroup.setTag(view);
        } else
        {
            view = (ViewHolder)viewgroup.getTag();
        }
        listmodel = (ListModel)lm.get(i);
        if (lm != null)
        {
            ((ViewHolder) (view)).txt_username.setText(listmodel.getUsername());
            ((ViewHolder) (view)).txt_name.setText(listmodel.getRealname());
            ((ViewHolder) (view)).txt_lokasi.setText(listmodel.getKota());
            ((ViewHolder) (view)).txt_username.setSelected(true);
            ((ViewHolder) (view)).txt_name.setSelected(true);
            ((ViewHolder) (view)).txt_lokasi.setSelected(true);
            Picasso.with(activity).load(listmodel.getAvatar().trim()).placeholder(0x7f02033f).error(0x7f020297).into(((ViewHolder) (view)).imgProfil);
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
}
