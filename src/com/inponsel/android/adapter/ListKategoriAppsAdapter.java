// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.inponsel.android.widget.CircleView;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.adapter:
//            ListModel

public class ListKategoriAppsAdapter extends BaseAdapter
{
    static class ViewHolder
    {

        CircleView img_hp_circle;
        RelativeLayout rl_pil_1;
        TextView txt_kat_name;
        TextView txt_no_apps;

        ViewHolder()
        {
        }
    }


    private Activity activity;
    Context context;
    int count_number;
    private ArrayList lm;
    int resource;
    String response;

    public ListKategoriAppsAdapter(Activity activity1, int i, ArrayList arraylist)
    {
        count_number = 0;
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
            view.txt_no_apps = (TextView)viewgroup.findViewById(0x7f0b0905);
            view.txt_kat_name = (TextView)viewgroup.findViewById(0x7f0b0906);
            view.rl_pil_1 = (RelativeLayout)viewgroup.findViewById(0x7f0b0903);
            view.img_hp_circle = (CircleView)viewgroup.findViewById(0x7f0b0904);
            viewgroup.setTag(view);
        } else
        {
            view = (ViewHolder)viewgroup.getTag();
        }
        listmodel = (ListModel)lm.get(i);
        if (lm != null)
        {
            ((ViewHolder) (view)).txt_no_apps.setText(String.valueOf(i + 1));
            ((ViewHolder) (view)).txt_kat_name.setText(listmodel.getKat_apps_name());
            ((ViewHolder) (view)).img_hp_circle.setCircleColor(Color.parseColor(listmodel.getKat_apps_background()));
            ((ViewHolder) (view)).img_hp_circle.setLabelColor(0);
            ((ViewHolder) (view)).img_hp_circle.setLabelText("");
            count_number = count_number + 1;
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
