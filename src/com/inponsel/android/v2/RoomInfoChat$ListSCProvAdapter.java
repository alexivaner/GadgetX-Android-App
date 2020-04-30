// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.UserFunctions;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.v2:
//            RoomInfoChat

public class cursor extends BaseAdapter
{
    class ViewHolder
    {

        ImageView imgMediaRoom;
        ProgressBar progressbar_item;
        final RoomInfoChat.ListSCProvAdapter this$1;
        TextView txtMediaRoom;

        ViewHolder()
        {
            this$1 = RoomInfoChat.ListSCProvAdapter.this;
            super();
        }
    }


    private Activity activity;
    Context context;
    Cursor cursor;
    DatabaseHandler db;
    String finalUrl;
    ImageLoader imageLoader2;
    private ArrayList lm;
    ListModel lms;
    ProgressDialog mDialog;
    private DisplayImageOptions options;
    int pos;
    String res;
    int resource;
    String response;
    String status;
    final RoomInfoChat this$0;
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

    public View getView(int i, View view, ViewGroup viewgroup)
    {
label0:
        {
            pos = i;
            if (view == null)
            {
                view = ((LayoutInflater)activity.getSystemService("layout_inflater")).inflate(resource, null);
                viewgroup = new ViewHolder();
                viewgroup.imgMediaRoom = (ImageView)view.findViewById(0x7f0b0851);
                viewgroup.txtMediaRoom = (TextView)view.findViewById(0x7f0b0852);
                view.setTag(viewgroup);
            } else
            {
                viewgroup = (ViewHolder)view.getTag();
            }
            lms = (ListModel)lm.get(i);
            if (lm != null)
            {
                Log.e("urlImage", lms.getLast_message());
                if (!lms.getMessage_type().equals("2"))
                {
                    break label0;
                }
                imageLoader2.displayImage(lms.getExt().trim(), ((ViewHolder) (viewgroup)).imgMediaRoom, options, RoomInfoChat.access$0(RoomInfoChat.this));
            }
            return view;
        }
        imageLoader2.displayImage(lms.getLast_message().trim(), ((ViewHolder) (viewgroup)).imgMediaRoom, options, RoomInfoChat.access$0(RoomInfoChat.this));
        return view;
    }

    public void setListArray(ArrayList arraylist)
    {
        lm = arraylist;
    }

    public eType(Activity activity1, int i, ArrayList arraylist)
    {
        this$0 = RoomInfoChat.this;
        super();
        finalUrl = "";
        lm = arraylist;
        activity = activity1;
        resource = i;
        try
        {
            imageLoader2 = ImageLoader.getInstance();
            imageLoader2.init(ImageLoaderConfiguration.createDefault(activity.getApplicationContext()));
            options = (new com.nostra13.universalimageloader.core.it>()).wImageForEmptyUri(0x7f020297).wImageOnFail(0x7f020297).heInMemory(true).heOnDisk(true).geScaleType(ImageScaleType.EXACTLY).mapConfig(android.graphics.).ld();
            userFunctions = new UserFunctions();
            db = new DatabaseHandler(activity1);
            if (userFunctions.isUserLoggedIn(activity1))
            {
                cursor = db.getAllData();
                cursor.moveToFirst();
                username = cursor.getString(4);
                email_user = cursor.getString(5);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (RoomInfoChat roominfochat)
        {
            return;
        }
    }
}
