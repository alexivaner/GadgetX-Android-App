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
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.adapter:
//            ListModel

public class ListOperatorAdapter extends BaseAdapter
{
    static class ViewHolder
    {

        LinearLayout headImage;
        TextView homeMerek;
        ImageView imageHp;
        RatingBar rateRate;

        ViewHolder()
        {
        }
    }


    private Activity activity;
    Context context;
    private ArrayList lm;
    int resource;
    String response;

    public ListOperatorAdapter(Activity activity1, int i, ArrayList arraylist)
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
            view.imageHp = (ImageView)viewgroup.findViewById(0x7f0b023d);
            view.homeMerek = (TextView)viewgroup.findViewById(0x7f0b0464);
            view.headImage = (LinearLayout)viewgroup.findViewById(0x7f0b029f);
            ((ViewHolder) (view)).headImage.setVisibility(8);
            viewgroup.setTag(view);
        } else
        {
            view = (ViewHolder)viewgroup.getTag();
        }
        ((ViewHolder) (view)).headImage.setVisibility(8);
        listmodel = (ListModel)lm.get(i);
        if (lm != null)
        {
            ((ViewHolder) (view)).homeMerek.setText(listmodel.getNm_op());
            ((ViewHolder) (view)).headImage.setVisibility(8);
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
