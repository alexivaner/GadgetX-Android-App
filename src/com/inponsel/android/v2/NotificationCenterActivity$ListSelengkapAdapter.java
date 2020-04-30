// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Utility;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.v2:
//            NotificationCenterActivity

public class t extends BaseAdapter
{
    class ViewHolder
    {

        ImageView imgAvatar;
        ImageView imgAvatarlIKE;
        ProgressBar progressbar_item;
        RelativeLayout rl_root_notif;
        final NotificationCenterActivity.ListSelengkapAdapter this$1;
        TextView txtNotificationDate;
        TextView txtNotificationMsg;

        ViewHolder()
        {
            this$1 = NotificationCenterActivity.ListSelengkapAdapter.this;
            super();
        }
    }


    private Activity activity;
    Context context;
    Cursor cursor;
    DatabaseHandler db;
    String email_user;
    String finalUrl;
    String komen;
    private ArrayList lm;
    ListModel lms;
    int pos;
    String res;
    int resource;
    String response;
    String t;
    final NotificationCenterActivity this$0;
    String user;
    UserFunctions userFunctions;

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
        pos = i;
        holder = (LayoutInflater)activity.getSystemService("layout_inflater");
        if (view == null)
        {
            view = holder.inflate(resource, null);
            holder = new ViewHolder();
            holder.imgAvatar = (ImageView)view.findViewById(0x7f0b06b9);
            holder.imgAvatarlIKE = (ImageView)view.findViewById(0x7f0b0854);
            holder.txtNotificationMsg = (TextView)view.findViewById(0x7f0b0855);
            holder.txtNotificationDate = (TextView)view.findViewById(0x7f0b0856);
            holder.progressbar_item = (ProgressBar)view.findViewById(0x7f0b00b3);
            holder.rl_root_notif = (RelativeLayout)view.findViewById(0x7f0b0853);
            view.setTag(holder);
        } else
        {
            holder = (ViewHolder)view.getTag();
        }
        lms = (ListModel)lm.get(i);
        Log.e("getAvatar", lms.getAvatar());
        if (lms.getNotif_isnew().equals("1"))
        {
            ((ViewHolder) (holder)).rl_root_notif.setBackgroundColor(getResources().getColor(0x7f080179));
        }
        ((ViewHolder) (holder)).txtNotificationDate.setText(lms.getNotif_time());
        if (!lms.getActv_type().equals("like")) goto _L2; else goto _L1
_L1:
        if (lms.getActv_content_type_id().equals("1"))
        {
            ((ViewHolder) (holder)).txtNotificationMsg.setText(Html.fromHtml((new StringBuilder("Seseorang menyukai komentar Anda pada spesifikasi <b>")).append(lms.getMerk()).append(" ").append(lms.getModel()).append("</b>").toString()));
        } else
        if (lms.getActv_content_type_id().equals("2"))
        {
            ((ViewHolder) (holder)).txtNotificationMsg.setText(Html.fromHtml((new StringBuilder("Seseorang menyukai komentar Anda pada berita <b>")).append(lms.getMerk()).append("</b>").toString()));
        } else
        if (lms.getActv_content_type_id().equals("4"))
        {
            ((ViewHolder) (holder)).txtNotificationMsg.setText(Html.fromHtml((new StringBuilder("Seseorang menyukai komentar Anda pada tweet <b>")).append(lms.getMerk()).append("</b>").toString()));
        } else
        if (lms.getActv_content_type_id().equals("5"))
        {
            ((ViewHolder) (holder)).txtNotificationMsg.setText(Html.fromHtml((new StringBuilder("Seseorang menyukai komentar Anda pada artikel <b>")).append(lms.getMerk()).append("</b>").toString()));
        } else
        if (lms.getActv_content_type_id().equals("6"))
        {
            if (lms.getType().toLowerCase().equals("conversation"))
            {
                ((ViewHolder) (holder)).txtNotificationMsg.setText(Html.fromHtml((new StringBuilder("Seseorang menyukai conversation Anda pada <b>")).append(lms.getMerk()).append("</b>").toString()));
            } else
            {
                ((ViewHolder) (holder)).txtNotificationMsg.setText(Html.fromHtml((new StringBuilder("Seseorang menyukai artikel Anda pada <b>")).append(lms.getMerk()).append("</b>").toString()));
            }
        } else
        {
            ((ViewHolder) (holder)).txtNotificationMsg.setText(Html.fromHtml((new StringBuilder("Seseorang menyukai komentar Anda pada <b>")).append(lms.getMerk()).append("</b>").toString()));
        }
_L4:
        Picasso.with(NotificationCenterActivity.this).load(lms.getAvatar()).into(((ViewHolder) (holder)).imgAvatar, new Callback() {

            final NotificationCenterActivity.ListSelengkapAdapter this$1;
            private final ViewHolder val$holder;

            public void onError()
            {
                holder.progressbar_item.setVisibility(8);
                holder.imgAvatar.setVisibility(0);
            }

            public void onSuccess()
            {
                holder.progressbar_item.setVisibility(8);
                holder.imgAvatar.setVisibility(0);
            }

            
            {
                this$1 = NotificationCenterActivity.ListSelengkapAdapter.this;
                holder = viewholder;
                super();
            }
        });
        return view;
_L2:
        if (lms.getActv_type().equals("reply"))
        {
            if (lms.getActv_content_type_id().equals("1"))
            {
                ((ViewHolder) (holder)).txtNotificationMsg.setText(Html.fromHtml((new StringBuilder("<b>")).append(lms.getUsername()).append("</b> membalas komentar anda pada spesifikasi <b>").append(lms.getMerk()).append(" ").append(lms.getModel()).append("</b>").toString()));
            } else
            if (lms.getActv_content_type_id().equals("2"))
            {
                ((ViewHolder) (holder)).txtNotificationMsg.setText(Html.fromHtml((new StringBuilder("<b>")).append(lms.getUsername()).append("</b> membalas komentar anda pada berita <b>").append(lms.getMerk()).append("</b>").toString()));
            } else
            if (lms.getActv_content_type_id().equals("4"))
            {
                ((ViewHolder) (holder)).txtNotificationMsg.setText(Html.fromHtml((new StringBuilder("<b>")).append(lms.getUsername()).append("</b> membalas komentar anda pada tweet <b>").append(lms.getMerk()).append("</b>").toString()));
            } else
            if (lms.getActv_content_type_id().equals("5"))
            {
                if (lms.getType().toLowerCase().equals("conversation"))
                {
                    ((ViewHolder) (holder)).txtNotificationMsg.setText(Html.fromHtml((new StringBuilder("<b>")).append(lms.getUsername()).append("</b> membalas komentar anda pada conversation <b>").append(lms.getMerk()).append("</b>").toString()));
                } else
                {
                    ((ViewHolder) (holder)).txtNotificationMsg.setText(Html.fromHtml((new StringBuilder("<b>")).append(lms.getUsername()).append("</b> membalas komentar anda pada artikel <b>").append(lms.getMerk()).append("</b>").toString()));
                }
            } else
            {
                ((ViewHolder) (holder)).txtNotificationMsg.setText(Html.fromHtml((new StringBuilder("<b>")).append(lms.getUsername()).append("</b> membalas komentar anda pada <b>").append(lms.getMerk()).append("</b>").toString()));
            }
        } else
        if (lms.getActv_type().equals("comment"))
        {
            if (lms.getActv_content_type_id().equals("1"))
            {
                ((ViewHolder) (holder)).txtNotificationMsg.setText(Html.fromHtml((new StringBuilder("<b>")).append(lms.getUsername()).append("</b> mengomentari spesifikasi <b>").append(lms.getMerk()).append(" ").append(lms.getModel()).append("</b>").toString()));
            } else
            if (lms.getActv_content_type_id().equals("3"))
            {
                ((ViewHolder) (holder)).txtNotificationMsg.setText(Html.fromHtml((new StringBuilder("<b>")).append(lms.getUsername()).append("</b> mengomentari berita <b>").append(lms.getMerk()).append("</b>").toString()));
            } else
            if (lms.getActv_content_type_id().equals("4"))
            {
                ((ViewHolder) (holder)).txtNotificationMsg.setText(Html.fromHtml((new StringBuilder("<b>")).append(lms.getUsername()).append("</b> mengomentari tweet <b>").append(lms.getMerk()).append("</b>").toString()));
            } else
            if (lms.getActv_content_type_id().equals("5"))
            {
                if (lms.getType().toLowerCase().equals("conversation"))
                {
                    ((ViewHolder) (holder)).txtNotificationMsg.setText(Html.fromHtml((new StringBuilder("<b>")).append(lms.getUsername()).append("</b> mengomentari conversation <b>").append(lms.getMerk()).append("</b>").toString()));
                } else
                {
                    ((ViewHolder) (holder)).txtNotificationMsg.setText(Html.fromHtml((new StringBuilder("<b>")).append(lms.getUsername()).append("</b> mengomentari artikel <b>").append(lms.getMerk()).append("</b>").toString()));
                }
            } else
            {
                ((ViewHolder) (holder)).txtNotificationMsg.setText(Html.fromHtml((new StringBuilder("<b>")).append(lms.getUsername()).append("</b> mengomentari <b>").append(lms.getMerk()).append("</b>").toString()));
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    void log(String s)
    {
    }

    public void setListArray(ArrayList arraylist)
    {
        lm = arraylist;
    }

    public _cls1.val.holder(Activity activity1, int i, ArrayList arraylist)
    {
        this$0 = NotificationCenterActivity.this;
        super();
        t = Utility.session(RestClient.pelihara);
        user = "";
        komen = "";
        email_user = "";
        finalUrl = "";
        t = Utility.session(t);
        lm = arraylist;
        activity = activity1;
        resource = i;
        try
        {
            userFunctions = new UserFunctions();
            db = new DatabaseHandler(activity1);
            if (userFunctions.isUserLoggedIn(activity1))
            {
                cursor = db.getAllData();
                cursor.moveToFirst();
                username = cursor.getString(4);
                email_user = cursor.getString(5);
            }
            t = Utility.session(t);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (NotificationCenterActivity notificationcenteractivity)
        {
            return;
        }
    }
}
