// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.rssfeeddetail;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.rssfeeddetail:
//            Hal1RSSDetail

public class this._cls0 extends AsyncTask
{

    final Hal1RSSDetail this$0;

    private void parseJSONSubsNews(String s)
    {
        try
        {
            s = new JSONObject(s);
            postStatusSubsNews = s.getString("success");
            postMessageSubsNews = s.getString("message");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
    }

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        try
        {
            avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("add_subscribe_news").append(Utility.BASE_FORMAT).append("?").append(query).toString();
            Log.e("pushURLsubscribe", avoid);
            avoid = HttpPush.getResponse(avoid);
            Log.e("push", (new StringBuilder(String.valueOf(avoid))).append(query).toString());
            avoid = avoid.toString();
            Log.e("url ", avoid);
            parseJSONSubsNews(avoid);
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            avoid.printStackTrace();
        }
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        super.onPostExecute(void1);
        if (!postStatusSubsNews.equals("1") && !postStatusSubsNews.equals("10")) goto _L2; else goto _L1
_L1:
        Toast.makeText(getActivity(), postMessageSubsNews, 1).show();
        if (!type.equals("general")) goto _L4; else goto _L3
_L3:
        int i;
        Log.e("tag_id", String.valueOf(Hal1RSSDetail.access$11(Hal1RSSDetail.this).getChildCount()));
        i = 0;
_L9:
        if (i < Hal1RSSDetail.access$11(Hal1RSSDetail.this).getChildCount()) goto _L6; else goto _L5
_L5:
        mDialog.dismiss();
        return;
_L6:
        Object obj = Hal1RSSDetail.access$11(Hal1RSSDetail.this).getChildAt(i);
        void1 = (TextView)((View) (obj)).findViewById(0x7f0b0774);
        TextView textview = (TextView)((View) (obj)).findViewById(0x7f0b0775);
        ((ImageView)((View) (obj)).findViewById(0x7f0b0772)).setImageResource(0x7f02032a);
        obj = (Button)((View) (obj)).findViewById(0x7f0b0771);
        ((Button) (obj)).setVisibility(0);
        Log.e("tag_id", (new StringBuilder(String.valueOf(void1.getText().toString()))).append("=").append(tag_id).toString());
        if (void1.getText().toString().equals(tag_id))
        {
            if (subs_status.equals("1"))
            {
                textview.setText("1");
                ((Button) (obj)).setBackground(drwKurang);
            } else
            {
                textview.setText("0");
                ((Button) (obj)).setBackground(drw);
            }
        }
        i++;
        continue; /* Loop/switch isn't completed */
_L4:
        if (type.equals("brand"))
        {
            Log.e("tag_id", String.valueOf(Hal1RSSDetail.access$12(Hal1RSSDetail.this).getChildCount()));
            int j = 0;
            while (j < Hal1RSSDetail.access$12(Hal1RSSDetail.this).getChildCount()) 
            {
                Object obj1 = Hal1RSSDetail.access$12(Hal1RSSDetail.this).getChildAt(j);
                void1 = (TextView)((View) (obj1)).findViewById(0x7f0b0774);
                TextView textview1 = (TextView)((View) (obj1)).findViewById(0x7f0b0775);
                ((ImageView)((View) (obj1)).findViewById(0x7f0b0772)).setImageResource(0x7f02032a);
                obj1 = (Button)((View) (obj1)).findViewById(0x7f0b0771);
                ((Button) (obj1)).setVisibility(0);
                Log.e("tag_id", (new StringBuilder(String.valueOf(void1.getText().toString()))).append("=").append(tag_id).toString());
                if (void1.getText().toString().equals(tag_id))
                {
                    if (subs_status.equals("1"))
                    {
                        textview1.setText("1");
                        ((Button) (obj1)).setBackground(drwKurang);
                    } else
                    {
                        textview1.setText("0");
                        ((Button) (obj1)).setBackground(drw);
                    }
                }
                j++;
            }
        } else
        if (type.equals("os"))
        {
            Log.e("tag_id", String.valueOf(Hal1RSSDetail.access$13(Hal1RSSDetail.this).getChildCount()));
            int k = 0;
            while (k < Hal1RSSDetail.access$13(Hal1RSSDetail.this).getChildCount()) 
            {
                Object obj2 = Hal1RSSDetail.access$13(Hal1RSSDetail.this).getChildAt(k);
                void1 = (TextView)((View) (obj2)).findViewById(0x7f0b0774);
                TextView textview2 = (TextView)((View) (obj2)).findViewById(0x7f0b0775);
                ((ImageView)((View) (obj2)).findViewById(0x7f0b0772)).setImageResource(0x7f02032a);
                obj2 = (Button)((View) (obj2)).findViewById(0x7f0b0771);
                ((Button) (obj2)).setVisibility(0);
                Log.e("tag_id", (new StringBuilder(String.valueOf(void1.getText().toString()))).append("=").append(tag_id).toString());
                if (void1.getText().toString().equals(tag_id))
                {
                    if (subs_status.equals("1"))
                    {
                        textview2.setText("1");
                        ((Button) (obj2)).setBackground(drwKurang);
                    } else
                    {
                        textview2.setText("0");
                        ((Button) (obj2)).setBackground(drw);
                    }
                }
                k++;
            }
        } else
        {
            if (!type.equals("op"))
            {
                continue; /* Loop/switch isn't completed */
            }
            Log.e("tag_id", String.valueOf(Hal1RSSDetail.access$14(Hal1RSSDetail.this).getChildCount()));
            int l = 0;
            while (l < Hal1RSSDetail.access$14(Hal1RSSDetail.this).getChildCount()) 
            {
                Object obj3 = Hal1RSSDetail.access$14(Hal1RSSDetail.this).getChildAt(l);
                void1 = (TextView)((View) (obj3)).findViewById(0x7f0b0774);
                TextView textview3 = (TextView)((View) (obj3)).findViewById(0x7f0b0775);
                ((ImageView)((View) (obj3)).findViewById(0x7f0b0772)).setImageResource(0x7f02032a);
                obj3 = (Button)((View) (obj3)).findViewById(0x7f0b0771);
                ((Button) (obj3)).setVisibility(0);
                Log.e("tag_id", (new StringBuilder(String.valueOf(void1.getText().toString()))).append("=").append(tag_id).toString());
                if (void1.getText().toString().equals(tag_id))
                {
                    if (subs_status.equals("1"))
                    {
                        textview3.setText("1");
                        ((Button) (obj3)).setBackground(drwKurang);
                    } else
                    {
                        textview3.setText("0");
                        ((Button) (obj3)).setBackground(drw);
                    }
                }
                l++;
            }
        }
        continue; /* Loop/switch isn't completed */
        if (!type.equals("hp")) goto _L5; else goto _L7
_L7:
        Log.e("tag_id", String.valueOf(Hal1RSSDetail.access$15(Hal1RSSDetail.this).getChildCount()));
        int i1 = 0;
        while (i1 < Hal1RSSDetail.access$15(Hal1RSSDetail.this).getChildCount()) 
        {
            Object obj4 = Hal1RSSDetail.access$15(Hal1RSSDetail.this).getChildAt(i1);
            void1 = (TextView)((View) (obj4)).findViewById(0x7f0b0774);
            TextView textview4 = (TextView)((View) (obj4)).findViewById(0x7f0b0775);
            ((ImageView)((View) (obj4)).findViewById(0x7f0b0772)).setImageResource(0x7f02032a);
            obj4 = (Button)((View) (obj4)).findViewById(0x7f0b0771);
            ((Button) (obj4)).setVisibility(0);
            Log.e("tag_id", (new StringBuilder(String.valueOf(void1.getText().toString()))).append("=").append(tag_id).toString());
            if (void1.getText().toString().equals(tag_id))
            {
                if (subs_status.equals("1"))
                {
                    textview4.setText("1");
                    ((Button) (obj4)).setBackground(drwKurang);
                } else
                {
                    textview4.setText("0");
                    ((Button) (obj4)).setBackground(drw);
                }
            }
            i1++;
        }
        if (true) goto _L5; else goto _L2
_L2:
        if (postStatusSubsNews.equals("00") || postStatusSubsNews.equals("0"))
        {
            Toast.makeText(getActivity(), postMessageSubsNews, 1).show();
            statSubNews.equals("1");
            mDialog.dismiss();
            return;
        }
        if (postStatusSubsNews.equals("40404"))
        {
            mDialog.dismiss();
            return;
        }
        Toast.makeText(getActivity(), postMessageSubsNews, 1).show();
        return;
        if (true) goto _L9; else goto _L8
_L8:
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        if (subs_status.equals("1"))
        {
            mDialog = ProgressDialog.show(getActivity(), "", "Menambahkan...", true);
        } else
        {
            mDialog = ProgressDialog.show(getActivity(), "", "Menghapus...", true);
        }
        mDialog.setCancelable(true);
        mDialog.show();
    }

    public ()
    {
        this$0 = Hal1RSSDetail.this;
        super();
    }
}
