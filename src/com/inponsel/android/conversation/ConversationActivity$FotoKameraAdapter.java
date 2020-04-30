// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.conversation;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.utils.Log;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.conversation:
//            ConversationActivity

public class resource extends BaseAdapter
{
    class ViewHolder
    {

        ImageView imgFoto;
        ProgressBar progressbar_Avatar;
        final ConversationActivity.FotoKameraAdapter this$1;
        TextView txt_hp;
        TextView txt_username;

        ViewHolder()
        {
            this$1 = ConversationActivity.FotoKameraAdapter.this;
            super();
        }
    }


    private Activity activity;
    Context context;
    private ArrayList lm;
    int resource;
    String response;
    final ConversationActivity this$0;

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
        ListModel listmodel;
        if (view == null)
        {
            view = ((LayoutInflater)activity.getSystemService("layout_inflater")).inflate(resource, null);
            viewgroup = new ViewHolder();
            viewgroup.imgFoto = (ImageView)view.findViewById(0x7f0b0634);
            viewgroup.txt_username = (TextView)view.findViewById(0x7f0b0373);
            viewgroup.txt_username = (TextView)view.findViewById(0x7f0b0373);
            viewgroup.txt_hp = (TextView)view.findViewById(0x7f0b0639);
            viewgroup.progressbar_Avatar = (ProgressBar)view.findViewById(0x7f0b0633);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        listmodel = (ListModel)lm.get(i);
        if (lm != null)
        {
            ((ViewHolder) (viewgroup)).txt_username.setText(listmodel.getUsername());
            ((ViewHolder) (viewgroup)).txt_hp.setText((new StringBuilder(String.valueOf(listmodel.getMerk()))).append(" ").append(listmodel.getModel()).toString());
            ((ViewHolder) (viewgroup)).txt_username.setSelected(true);
            ((ViewHolder) (viewgroup)).txt_hp.setSelected(true);
            try
            {
                Log.e("img_comp", listmodel.getForum_img_compress());
                Picasso.with(activity).load(listmodel.getForum_img_compress().trim()).placeholder(0x7f02033f).error(0x7f020297).into(((ViewHolder) (viewgroup)).imgFoto);
            }
            // Misplaced declaration of an exception variable
            catch (ViewGroup viewgroup)
            {
                viewgroup.printStackTrace();
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

    public ViewHolder.this._cls1(Activity activity1, int i, ArrayList arraylist)
    {
        this$0 = ConversationActivity.this;
        super();
        lm = arraylist;
        activity = activity1;
        resource = i;
    }
}
