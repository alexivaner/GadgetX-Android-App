// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.adapter;

import android.app.Activity;
import android.content.Intent;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.inponsel.android.v2.ImagePagerActivity;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;

// Referenced classes of package com.inponsel.android.adapter:
//            TrafficModel

public class TwitterAdapter extends BaseAdapter
{
    static class ViewHolder
    {

        ImageView imageMedia;
        ImageView img;
        TextView tweet;
        TextView txtTimeTweet;
        TextView txtUserName;

        ViewHolder()
        {
        }
    }


    Activity activity;
    Calendar c;
    int day;
    private ArrayList lm;
    int month;
    int resource;
    String response;
    public LayoutInflater vi;
    int year;

    public TwitterAdapter(Activity activity1, int i, ArrayList arraylist)
    {
        lm = arraylist;
        activity = activity1;
        resource = i;
        vi = (LayoutInflater)activity.getSystemService("layout_inflater");
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

    public TrafficModel getListModel(int i)
    {
        return (TrafficModel)lm.get(i);
    }

    public View getView(int i, View view, final ViewGroup holder)
    {
        Object obj;
        final TrafficModel lms;
        Date date;
        String s;
        String s1;
        if (view == null)
        {
            view = vi.inflate(0x7f030072, null);
            holder = new ViewHolder();
            holder.txtUserName = (TextView)view.findViewById(0x7f0b0469);
            holder.txtTimeTweet = (TextView)view.findViewById(0x7f0b046a);
            holder.tweet = (TextView)view.findViewById(0x7f0b046b);
            holder.img = (ImageView)view.findViewById(0x7f0b007f);
            holder.imageMedia = (ImageView)view.findViewById(0x7f0b046c);
            view.setTag(holder);
        } else
        {
            holder = (ViewHolder)view.getTag();
        }
        lms = (TrafficModel)lm.get(i);
        if (lm == null) goto _L2; else goto _L1
_L1:
        ((ViewHolder) (holder)).tweet.setText(lms.getTweet_content());
        ((ViewHolder) (holder)).txtUserName.setText(lms.getScreen_name());
        c = Calendar.getInstance();
        year = c.get(1);
        month = c.get(2) + 1;
        day = c.get(5);
        date = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(lms.getTweet_time());
        new SimpleDateFormat("dd MMMM yyyy HH:mm");
        obj = new SimpleDateFormat("yyyy-MM-dd");
        s = ((SimpleDateFormat) (obj)).format(date);
        s1 = (new StringBuilder(String.valueOf(String.valueOf(year)))).append("-").append(String.valueOf(month)).append("-").append(String.valueOf(day)).toString();
        if (!((SimpleDateFormat) (obj)).parse(s).equals(((SimpleDateFormat) (obj)).parse(s1))) goto _L4; else goto _L3
_L3:
        obj = new SimpleDateFormat("HH:mm", Locale.US);
_L9:
        obj = ((SimpleDateFormat) (obj)).format(date).replace("January", "Jan").replace("February", "Feb").replace("March", "Mar").replace("April", "Apr").replace("May", "Mei").replace("June", "Jun").replace("July", "Jul").replace("August", "Ags").replace("September", "Sep").replace("October", "Okt").replace("November", "Nov").replace("December", "Des");
        ((ViewHolder) (holder)).txtTimeTweet.setText(((CharSequence) (obj)));
_L7:
        if (!lms.getMedia_url().equals("")) goto _L6; else goto _L5
_L5:
        ((ViewHolder) (holder)).imageMedia.setVisibility(8);
_L2:
        return view;
_L4:
        obj = new SimpleDateFormat("dd MMMM yyyy HH:mm", Locale.US);
        continue; /* Loop/switch isn't completed */
        ParseException parseexception;
        parseexception;
        try
        {
            parseexception.printStackTrace();
        }
        // Misplaced declaration of an exception variable
        catch (final ViewGroup holder)
        {
            holder.printStackTrace();
            return view;
        }
          goto _L7
_L6:
        Picasso.with(activity).load(lms.getMedia_url().trim()).into(((ViewHolder) (holder)).imageMedia, new Callback() {

            final TwitterAdapter this$0;
            private final ViewHolder val$holder;

            public void onError()
            {
            }

            public void onSuccess()
            {
                holder.imageMedia.setVisibility(0);
            }

            
            {
                this$0 = TwitterAdapter.this;
                holder = viewholder;
                super();
            }
        });
        Picasso.with(activity).load(lms.getAvatar().trim()).into(((ViewHolder) (holder)).img, new Callback() {

            final TwitterAdapter this$0;
            private final ViewHolder val$holder;

            public void onError()
            {
            }

            public void onSuccess()
            {
                holder.img.setVisibility(0);
            }

            
            {
                this$0 = TwitterAdapter.this;
                holder = viewholder;
                super();
            }
        });
        ((ViewHolder) (holder)).imageMedia.setOnClickListener(new android.view.View.OnClickListener() {

            final TwitterAdapter this$0;
            private final TrafficModel val$lms;

            public void onClick(View view1)
            {
                view1 = new ArrayList();
                view1.add(lms.getMedia_url().trim());
                view1 = (String[])view1.toArray(new String[view1.size()]);
                Intent intent = new Intent(activity, com/inponsel/android/v2/ImagePagerActivity);
                intent.putExtra("imgUrl", view1);
                intent.putExtra("pos", 0);
                activity.startActivity(intent);
            }

            
            {
                this$0 = TwitterAdapter.this;
                lms = trafficmodel;
                super();
            }
        });
        Pattern pattern = Pattern.compile("(@[a-zA-Z0-9_]+)");
        Linkify.addLinks(((ViewHolder) (holder)).tweet, pattern, "http://twitter.com/");
        pattern = Pattern.compile("#([A-Za-z0-9_-]+)");
        Linkify.addLinks(((ViewHolder) (holder)).tweet, pattern, "http://twitter.com/#!/search/");
        pattern = Pattern.compile("\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]");
        Linkify.addLinks(((ViewHolder) (holder)).tweet, pattern, null);
        return view;
        if (true) goto _L9; else goto _L8
_L8:
    }

    void log(String s)
    {
    }

    public void setListArray(ArrayList arraylist)
    {
        lm = arraylist;
    }
}
