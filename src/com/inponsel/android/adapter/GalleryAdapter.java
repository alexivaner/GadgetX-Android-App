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
import com.inponsel.android.utils.Util;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.adapter:
//            ListModel

public class GalleryAdapter extends BaseAdapter
{
    static class ViewHolder
    {

        ImageView imgCat;
        ProgressBar progressbar_item;

        ViewHolder()
        {
        }
    }


    private Activity activity;
    Context context;
    private ArrayList lm;
    int resource;
    String response;

    public GalleryAdapter(Activity activity1, int i, ArrayList arraylist)
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
            holder.imgCat = (ImageView)view.findViewById(0x7f0b00b4);
            holder.progressbar_item = (ProgressBar)view.findViewById(0x7f0b00b3);
            view.setTag(holder);
        } else
        {
            holder = (ViewHolder)view.getTag();
        }
        listmodel = (ListModel)lm.get(i);
        if (lm != null)
        {
            try
            {
                Picasso.with(activity).load((new StringBuilder(String.valueOf(Util.BASE_PATH_Gallery))).append(listmodel.getGaleriUrl().trim()).toString()).into(((ViewHolder) (holder)).imgCat, new Callback() {

                    final GalleryAdapter this$0;
                    private final ViewHolder val$holder;

                    public void onError()
                    {
                        holder.progressbar_item.setVisibility(8);
                    }

                    public void onSuccess()
                    {
                        holder.progressbar_item.setVisibility(8);
                        holder.imgCat.setVisibility(0);
                    }

            
            {
                this$0 = GalleryAdapter.this;
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
