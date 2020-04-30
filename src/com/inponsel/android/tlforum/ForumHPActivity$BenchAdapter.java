// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.tlforum;

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
import com.inponsel.android.adapter.ListModel;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.tlforum:
//            ForumHPActivity

public class resource extends BaseAdapter
{
    class ViewHolder
    {

        ImageView imgBench;
        ImageView imgFoto;
        ProgressBar progressbar_Avatar;
        RelativeLayout rl_benchscrore;
        final ForumHPActivity.BenchAdapter this$1;
        TextView txt_benchname;
        TextView txt_benchscrore;
        TextView txt_hp;
        TextView txt_username;

        ViewHolder()
        {
            this$1 = ForumHPActivity.BenchAdapter.this;
            super();
        }
    }


    private Activity activity;
    Context context;
    private ArrayList lm;
    int resource;
    String response;
    final ForumHPActivity this$0;

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
            view.imgFoto = (ImageView)viewgroup.findViewById(0x7f0b0634);
            view.txt_benchscrore = (TextView)viewgroup.findViewById(0x7f0b0637);
            view.imgBench = (ImageView)viewgroup.findViewById(0x7f0b0636);
            view.txt_benchname = (TextView)viewgroup.findViewById(0x7f0b0638);
            view.txt_username = (TextView)viewgroup.findViewById(0x7f0b0373);
            view.txt_hp = (TextView)viewgroup.findViewById(0x7f0b0639);
            view.progressbar_Avatar = (ProgressBar)viewgroup.findViewById(0x7f0b0633);
            view.rl_benchscrore = (RelativeLayout)viewgroup.findViewById(0x7f0b0635);
            viewgroup.setTag(view);
        } else
        {
            view = (ViewHolder)viewgroup.getTag();
        }
        listmodel = (ListModel)lm.get(i);
        if (lm != null)
        {
            ((ViewHolder) (view)).rl_benchscrore.setVisibility(0);
            ((ViewHolder) (view)).txt_username.setText(listmodel.getUsername());
            ((ViewHolder) (view)).txt_benchname.setText(listmodel.getForum_tag());
            ((ViewHolder) (view)).txt_hp.setText((new StringBuilder(String.valueOf(listmodel.getMerk()))).append(" ").append(listmodel.getModel()).toString());
            ((ViewHolder) (view)).txt_benchscrore.setText(listmodel.getForum_content_ext());
            ((ViewHolder) (view)).imgFoto.setVisibility(8);
            Picasso.with(activity).load(listmodel.getForum_img_compress().trim()).placeholder(0x7f02033f).error(0x7f020209).into(((ViewHolder) (view)).imgBench);
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

    public ViewHolder.this._cls1(Activity activity1, int i, ArrayList arraylist)
    {
        this$0 = ForumHPActivity.this;
        super();
        lm = arraylist;
        activity = activity1;
        resource = i;
    }
}
