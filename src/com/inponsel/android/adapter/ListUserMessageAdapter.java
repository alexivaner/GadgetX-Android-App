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
import com.inponsel.android.utils.Utility;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.adapter:
//            ListModel

public class ListUserMessageAdapter extends BaseAdapter
{
    static class ViewHolder
    {

        ImageView img_arrow;
        ImageView img_type;
        ImageView img_user_picture;
        RelativeLayout myroot;
        ProgressBar progressbar_item;
        TextView txtLastMessage;
        TextView txtNotif;
        TextView txtUsername;
        TextView txtWaktu;

        ViewHolder()
        {
        }
    }


    private Activity activity;
    Context context;
    private ArrayList lm;
    int resource;
    String response;

    public ListUserMessageAdapter(Activity activity1, int i, ArrayList arraylist)
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

    public View getView(int i, final View holder, ViewGroup viewgroup)
    {
        viewgroup = holder;
        ListModel listmodel;
        if (viewgroup == null)
        {
            viewgroup = ((LayoutInflater)activity.getSystemService("layout_inflater")).inflate(resource, null);
            holder = new ViewHolder();
            holder.img_user_picture = (ImageView)viewgroup.findViewById(0x7f0b0418);
            holder.img_arrow = (ImageView)viewgroup.findViewById(0x7f0b0641);
            holder.img_type = (ImageView)viewgroup.findViewById(0x7f0b0642);
            holder.txtUsername = (TextView)viewgroup.findViewById(0x7f0b0419);
            holder.txtWaktu = (TextView)viewgroup.findViewById(0x7f0b054c);
            holder.txtLastMessage = (TextView)viewgroup.findViewById(0x7f0b0643);
            holder.txtNotif = (TextView)viewgroup.findViewById(0x7f0b0644);
            holder.progressbar_item = (ProgressBar)viewgroup.findViewById(0x7f0b00b3);
            holder.myroot = (RelativeLayout)viewgroup.findViewById(0x7f0b0063);
            viewgroup.setTag(holder);
        } else
        {
            holder = (ViewHolder)viewgroup.getTag();
        }
        listmodel = (ListModel)lm.get(i);
        if (lm != null)
        {
            ((ViewHolder) (holder)).txtUsername.setText(listmodel.getFrom_name());
            ((ViewHolder) (holder)).txtWaktu.setText(Utility.convertDate(listmodel.getMsg_date()));
            if (listmodel.getMessage_type().equals("1"))
            {
                if (listmodel.getMe_message().equals("yes"))
                {
                    ((ViewHolder) (holder)).txtLastMessage.setText("Gambar");
                    ((ViewHolder) (holder)).img_arrow.setVisibility(8);
                    ((ViewHolder) (holder)).img_type.setVisibility(0);
                    ((ViewHolder) (holder)).img_type.setBackgroundResource(0x7f02016e);
                } else
                {
                    ((ViewHolder) (holder)).txtLastMessage.setText("Gambar");
                    ((ViewHolder) (holder)).img_arrow.setVisibility(0);
                    ((ViewHolder) (holder)).img_type.setVisibility(0);
                    ((ViewHolder) (holder)).img_type.setBackgroundResource(0x7f02016e);
                }
            } else
            if (listmodel.getMessage_type().equals("2"))
            {
                if (listmodel.getMe_message().equals("yes"))
                {
                    ((ViewHolder) (holder)).txtLastMessage.setText((new StringBuilder()).append(listmodel.getLast_message()).toString());
                    ((ViewHolder) (holder)).img_arrow.setVisibility(8);
                    ((ViewHolder) (holder)).img_type.setVisibility(0);
                    ((ViewHolder) (holder)).img_type.setBackgroundResource(0x7f02016f);
                } else
                {
                    ((ViewHolder) (holder)).txtLastMessage.setText((new StringBuilder()).append(listmodel.getLast_message()).toString());
                    ((ViewHolder) (holder)).img_arrow.setVisibility(0);
                    ((ViewHolder) (holder)).img_type.setVisibility(0);
                    ((ViewHolder) (holder)).img_type.setBackgroundResource(0x7f02016f);
                }
            } else
            if (listmodel.getMe_message().equals("yes"))
            {
                ((ViewHolder) (holder)).txtLastMessage.setText((new StringBuilder()).append(listmodel.getLast_message()).toString());
                ((ViewHolder) (holder)).img_arrow.setVisibility(8);
            } else
            {
                ((ViewHolder) (holder)).txtLastMessage.setText((new StringBuilder()).append(listmodel.getLast_message()).toString());
                ((ViewHolder) (holder)).img_arrow.setVisibility(0);
            }
            if (listmodel.getUnread_msg().equals("0"))
            {
                ((ViewHolder) (holder)).txtNotif.setVisibility(8);
            } else
            {
                ((ViewHolder) (holder)).txtNotif.setText(listmodel.getUnread_msg());
            }
            Picasso.with(activity).load(listmodel.getFrom_photo().trim()).into(((ViewHolder) (holder)).img_user_picture, new Callback() {

                final ListUserMessageAdapter this$0;
                private final ViewHolder val$holder;

                public void onError()
                {
                    holder.progressbar_item.setVisibility(8);
                }

                public void onSuccess()
                {
                    holder.progressbar_item.setVisibility(8);
                    holder.img_user_picture.setVisibility(0);
                }

            
            {
                this$0 = ListUserMessageAdapter.this;
                holder = viewholder;
                super();
            }
            });
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
