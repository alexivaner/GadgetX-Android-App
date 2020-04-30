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

public class ListGroupMemberAdapter extends BaseAdapter
{
    static class ViewHolder
    {

        ImageView img_arrow;
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

    public ListGroupMemberAdapter(Activity activity1, int i, ArrayList arraylist)
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
            holder.img_user_picture = (ImageView)view.findViewById(0x7f0b0418);
            holder.img_arrow = (ImageView)view.findViewById(0x7f0b0641);
            holder.txtUsername = (TextView)view.findViewById(0x7f0b0419);
            holder.txtWaktu = (TextView)view.findViewById(0x7f0b054c);
            holder.txtLastMessage = (TextView)view.findViewById(0x7f0b0643);
            holder.txtNotif = (TextView)view.findViewById(0x7f0b0644);
            holder.progressbar_item = (ProgressBar)view.findViewById(0x7f0b00b3);
            holder.myroot = (RelativeLayout)view.findViewById(0x7f0b0063);
            view.setTag(holder);
        } else
        {
            holder = (ViewHolder)view.getTag();
        }
        listmodel = (ListModel)lm.get(i);
        if (lm != null)
        {
            ((ViewHolder) (holder)).txtUsername.setText((new StringBuilder(String.valueOf(listmodel.getMerk()))).append(" ").append(listmodel.getModel()).toString());
            ((ViewHolder) (holder)).txtWaktu.setText(Utility.convertDate(listmodel.getMsg_date()));
            if (listmodel.getMessage_type().equals("1"))
            {
                if (listmodel.getLast_message().equals(""))
                {
                    ((ViewHolder) (holder)).txtLastMessage.setText("");
                    ((ViewHolder) (holder)).img_arrow.setVisibility(8);
                } else
                if (listmodel.getMe_message().equals("yes"))
                {
                    ((ViewHolder) (holder)).txtLastMessage.setText((new StringBuilder(String.valueOf(listmodel.getFrom_name()))).append(": Gambar").toString());
                    ((ViewHolder) (holder)).img_arrow.setVisibility(8);
                } else
                {
                    ((ViewHolder) (holder)).txtLastMessage.setText((new StringBuilder(String.valueOf(listmodel.getFrom_name()))).append(": Gambar").toString());
                    ((ViewHolder) (holder)).img_arrow.setVisibility(0);
                }
            } else
            if (listmodel.getLast_message().equals(""))
            {
                ((ViewHolder) (holder)).txtLastMessage.setText("");
                ((ViewHolder) (holder)).img_arrow.setVisibility(8);
            } else
            if (listmodel.getMe_message().equals("yes"))
            {
                ((ViewHolder) (holder)).txtLastMessage.setText((new StringBuilder(String.valueOf(listmodel.getFrom_name()))).append(": ").append(listmodel.getLast_message()).toString());
                ((ViewHolder) (holder)).img_arrow.setVisibility(8);
            } else
            {
                ((ViewHolder) (holder)).txtLastMessage.setText((new StringBuilder(String.valueOf(listmodel.getFrom_name()))).append(": ").append(listmodel.getLast_message()).toString());
                ((ViewHolder) (holder)).img_arrow.setVisibility(0);
            }
            if (listmodel.getUnread_msg().equals("0"))
            {
                ((ViewHolder) (holder)).txtNotif.setVisibility(8);
            } else
            {
                ((ViewHolder) (holder)).txtNotif.setText(listmodel.getUnread_msg());
            }
            try
            {
                Picasso.with(activity).load(listmodel.getGambar().trim()).into(((ViewHolder) (holder)).img_user_picture, new Callback() {

                    final ListGroupMemberAdapter this$0;
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
                this$0 = ListGroupMemberAdapter.this;
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
