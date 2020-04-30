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
import com.inponsel.android.utils.Log;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.adapter:
//            ListModel

public class ScreenshootAdapter extends BaseAdapter
{
    static class ViewHolder
    {

        ImageView imgCat;

        ViewHolder()
        {
        }
    }


    private Activity activity;
    Context context;
    private ArrayList lm;
    int resource;
    String response;

    public ScreenshootAdapter(Activity activity1, int i, ArrayList arraylist)
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
            view.setTag(holder);
        } else
        {
            holder = (ViewHolder)view.getTag();
        }
        listmodel = (ListModel)lm.get(i);
        if (lm != null)
        {
            Log.e("imgUrl", listmodel.getImg_screen().trim());
            try
            {
                Picasso.with(activity).load(listmodel.getImg_screen().trim()).into(((ViewHolder) (holder)).imgCat, new Callback() {

                    final ScreenshootAdapter this$0;
                    private final ViewHolder val$holder;

                    public void onError()
                    {
                    }

                    public void onSuccess()
                    {
                        holder.imgCat.setVisibility(0);
                    }

            
            {
                this$0 = ScreenshootAdapter.this;
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

    void log(String s)
    {
    }

    public void setListArray(ArrayList arraylist)
    {
        lm = arraylist;
    }
}
