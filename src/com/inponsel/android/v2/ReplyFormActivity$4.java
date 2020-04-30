// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.NotificationManager;
import android.os.AsyncTask;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.inponsel.android.utils.Log;
import com.inponsel.android.widget.DroidWriterEditText;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Calendar;

// Referenced classes of package com.inponsel.android.v2:
//            ReplyFormActivity

class this._cls0
    implements android.view.
{

    final ReplyFormActivity this$0;

    public void onClick(View view)
    {
        if (photo_upload == null)
        {
            if (imgAskHp.getVisibility() == 0)
            {
                btn_send_komen.setEnabled(false);
                Log.e("photo", "oke");
                view = (new StringBuilder(String.valueOf(String.valueOf(now.get(12))))).append(now.get(13)).toString();
                notif_id = Integer.parseInt(view);
                ReplyFormActivity.access$6(ReplyFormActivity.this, (NotificationManager)getSystemService("notification"));
                ReplyFormActivity.access$7(ReplyFormActivity.this, new android.support.v4.app.uilder(ReplyFormActivity.this));
                ReplyFormActivity.access$0(ReplyFormActivity.this).setContentTitle("InPonsel").setContentText("Mengirim komentar... - 0%").setSmallIcon(0x7f0201e4);
                try
                {
                    view = URLEncoder.encode(edt_pop_komen.getText().toString(), "utf-8");
                    querypopkomen = (new StringBuilder("rplto=")).append(parentidkomen).append("&idhp=").append(idhp).append("&code=").append(codename).append("&email=").append(URLEncoder.encode(email_user, "utf-8")).append("&top_id=").append(top_id).append("&nama=").append(URLEncoder.encode(username, "utf-8")).append("&komentar=").append(view).append("&nmhp=").append("&t=").append(t).append("&img=").append(resp).toString();
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    view.printStackTrace();
                }
                (new stKomen(ReplyFormActivity.this)).execute(new Void[0]);
                return;
            }
            if (resp.contains(".jpg") || resp.contains(".jpeg"))
            {
                btn_send_komen.setEnabled(false);
                Log.e("photo", "oke");
                view = (new StringBuilder(String.valueOf(String.valueOf(now.get(12))))).append(now.get(13)).toString();
                notif_id = Integer.parseInt(view);
                ReplyFormActivity.access$6(ReplyFormActivity.this, (NotificationManager)getSystemService("notification"));
                ReplyFormActivity.access$7(ReplyFormActivity.this, new android.support.v4.app.uilder(ReplyFormActivity.this));
                ReplyFormActivity.access$0(ReplyFormActivity.this).setContentTitle("InPonsel").setContentText("Mengirim komentar... - 0%").setSmallIcon(0x7f0201e4);
                try
                {
                    view = URLEncoder.encode(edt_pop_komen.getText().toString(), "utf-8");
                    querypopkomen = (new StringBuilder("rplto=")).append(parentidkomen).append("&idhp=").append(idhp).append("&code=").append(codename).append("&email=").append(URLEncoder.encode(email_user, "utf-8")).append("&top_id=").append(top_id).append("&nama=").append(URLEncoder.encode(username, "utf-8")).append("&komentar=").append(view).append("&nmhp=").append("&t=").append(t).append("&img=").append(resp).toString();
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    view.printStackTrace();
                }
                (new stKomen(ReplyFormActivity.this)).execute(new Void[0]);
                return;
            }
            try
            {
                view = URLEncoder.encode(edt_pop_komen.getText().toString(), "utf-8");
                querypopkomen = (new StringBuilder("rplto=")).append(parentidkomen).append("&idhp=").append(idhp).append("&code=").append(codename).append("&email=").append(URLEncoder.encode(email_user, "utf-8")).append("&top_id=").append(top_id).append("&nama=").append(URLEncoder.encode(username, "utf-8")).append("&komentar=").append(view).append("&nmhp=").append("&t=").append(t).append("&img=-").toString();
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                view.printStackTrace();
            }
            Log.e("querypopkomen", querypopkomen);
            view = (new StringBuilder(String.valueOf(String.valueOf(now.get(12))))).append(now.get(13)).toString();
            notif_id = Integer.parseInt(view);
            ReplyFormActivity.access$6(ReplyFormActivity.this, (NotificationManager)getSystemService("notification"));
            ReplyFormActivity.access$7(ReplyFormActivity.this, new android.support.v4.app.uilder(ReplyFormActivity.this));
            ReplyFormActivity.access$0(ReplyFormActivity.this).setContentTitle("InPonsel").setContentText("Mengirim komentar... - 0%").setSmallIcon(0x7f0201e4);
            if (android.os.T >= 11)
            {
                (new stKomen(ReplyFormActivity.this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                return;
            } else
            {
                (new stKomen(ReplyFormActivity.this)).execute(new Void[0]);
                return;
            }
        } else
        {
            view = (new StringBuilder(String.valueOf(String.valueOf(now.get(12))))).append(now.get(13)).toString();
            notif_id = Integer.parseInt(view);
            ReplyFormActivity.access$6(ReplyFormActivity.this, (NotificationManager)getSystemService("notification"));
            ReplyFormActivity.access$7(ReplyFormActivity.this, new android.support.v4.app.uilder(ReplyFormActivity.this));
            ReplyFormActivity.access$0(ReplyFormActivity.this).setContentTitle("InPonsel").setContentText("Mengirim komentar... - 0%").setSmallIcon(0x7f0201e4);
            (new loadImage(ReplyFormActivity.this, null)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        }
    }

    loadImage()
    {
        this$0 = ReplyFormActivity.this;
        super();
    }
}
