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
import android.widget.RatingBar;
import android.widget.TextView;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.adapter:
//            ListModel

public class ListAdapter extends BaseAdapter
{
    static class ViewHolder
    {

        TextView homeMerek;
        ImageView imageHp;
        ProgressBar progressbar_item;
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

    public ListAdapter(Activity activity1, int i, ArrayList arraylist)
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
        ListModel listmodel;
        if (view == null)
        {
            view = ((LayoutInflater)activity.getSystemService("layout_inflater")).inflate(resource, null);
            holder = new ViewHolder();
            holder.imageHp = (ImageView)view.findViewById(0x7f0b023d);
            holder.homeMerek = (TextView)view.findViewById(0x7f0b0464);
            holder.progressbar_item = (ProgressBar)view.findViewById(0x7f0b00b3);
            holder.rateRate = (RatingBar)view.findViewById(0x7f0b00c9);
            view.setTag(holder);
        } else
        {
            holder = (ViewHolder)view.getTag();
        }
        listmodel = (ListModel)lm.get(i);
        if (lm != null)
        {
            ((ViewHolder) (holder)).homeMerek.setText((new StringBuilder(String.valueOf(listmodel.getMerk()))).append(" ").append(listmodel.getModel()).toString());
            try
            {
                Picasso.with(activity).load(listmodel.getGambar().trim()).into(((ViewHolder) (holder)).imageHp, new Callback() {

                    final ListAdapter this$0;
                    private final ViewHolder val$holder;

                    public void onError()
                    {
                        holder.progressbar_item.setVisibility(8);
                    }

                    public void onSuccess()
                    {
                        holder.progressbar_item.setVisibility(8);
                        holder.imageHp.setVisibility(0);
                    }

            
            {
                this$0 = ListAdapter.this;
                holder = viewholder;
                super();
            }
                });
            }
            // Misplaced declaration of an exception variable
            catch (final ViewGroup holder)
            {
                return view;
            }
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
}
