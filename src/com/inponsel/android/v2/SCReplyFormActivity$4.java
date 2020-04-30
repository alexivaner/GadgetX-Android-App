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
//            SCReplyFormActivity

class this._cls0
    implements android.view.Activity._cls4
{

    final SCReplyFormActivity this$0;

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
                SCReplyFormActivity.access$6(SCReplyFormActivity.this, (NotificationManager)getSystemService("notification"));
                SCReplyFormActivity.access$7(SCReplyFormActivity.this, new android.support.v4.app.lder(SCReplyFormActivity.this));
                SCReplyFormActivity.access$0(SCReplyFormActivity.this).setContentTitle("InPonsel").setContentText("Mengirim komentar... - 0%").setSmallIcon(0x7f0201e4);
                try
                {
                    view = URLEncoder.encode(edt_pop_komen.getText().toString(), "utf-8");
                    querypopkomen = (new StringBuilder("idsc=")).append(id_sc).append("&idusr=").append(user_id).append("&kom=").append(view).append("&rplto=").append(parentidkomen).append("&top_id=").append(top_id).append("&t=").append(t).append("&img=").append(resp).toString();
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    view.printStackTrace();
                }
                (new stKomen(SCReplyFormActivity.this)).execute(new Void[0]);
                return;
            }
            if (resp.contains(".jpg") || resp.contains(".jpeg"))
            {
                btn_send_komen.setEnabled(false);
                Log.e("photo", "oke");
                view = (new StringBuilder(String.valueOf(String.valueOf(now.get(12))))).append(now.get(13)).toString();
                notif_id = Integer.parseInt(view);
                SCReplyFormActivity.access$6(SCReplyFormActivity.this, (NotificationManager)getSystemService("notification"));
                SCReplyFormActivity.access$7(SCReplyFormActivity.this, new android.support.v4.app.lder(SCReplyFormActivity.this));
                SCReplyFormActivity.access$0(SCReplyFormActivity.this).setContentTitle("InPonsel").setContentText("Mengirim komentar... - 0%").setSmallIcon(0x7f0201e4);
                try
                {
                    view = URLEncoder.encode(edt_pop_komen.getText().toString(), "utf-8");
                    querypopkomen = (new StringBuilder("idsc=")).append(id_sc).append("&idusr=").append(user_id).append("&kom=").append(view).append("&rplto=").append(parentidkomen).append("&top_id=").append(top_id).append("&t=").append(t).append("&img=").append(resp).toString();
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    view.printStackTrace();
                }
                (new stKomen(SCReplyFormActivity.this)).execute(new Void[0]);
                return;
            }
            try
            {
                view = URLEncoder.encode(edt_pop_komen.getText().toString(), "utf-8");
                querypopkomen = (new StringBuilder("idsc=")).append(id_sc).append("&idusr=").append(user_id).append("&kom=").append(view).append("&rplto=").append(parentidkomen).append("&top_id=").append(top_id).append("&t=").append(t).append("&img=-").toString();
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                view.printStackTrace();
            }
            Log.e("querypopkomen", querypopkomen);
            view = (new StringBuilder(String.valueOf(String.valueOf(now.get(12))))).append(now.get(13)).toString();
            notif_id = Integer.parseInt(view);
            SCReplyFormActivity.access$6(SCReplyFormActivity.this, (NotificationManager)getSystemService("notification"));
            SCReplyFormActivity.access$7(SCReplyFormActivity.this, new android.support.v4.app.lder(SCReplyFormActivity.this));
            SCReplyFormActivity.access$0(SCReplyFormActivity.this).setContentTitle("InPonsel").setContentText("Mengirim komentar... - 0%").setSmallIcon(0x7f0201e4);
            if (android.os.allIcon >= 11)
            {
                (new stKomen(SCReplyFormActivity.this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                return;
            } else
            {
                (new stKomen(SCReplyFormActivity.this)).execute(new Void[0]);
                return;
            }
        } else
        {
            view = (new StringBuilder(String.valueOf(String.valueOf(now.get(12))))).append(now.get(13)).toString();
            notif_id = Integer.parseInt(view);
            SCReplyFormActivity.access$6(SCReplyFormActivity.this, (NotificationManager)getSystemService("notification"));
            SCReplyFormActivity.access$7(SCReplyFormActivity.this, new android.support.v4.app.lder(SCReplyFormActivity.this));
            SCReplyFormActivity.access$0(SCReplyFormActivity.this).setContentTitle("InPonsel").setContentText("Mengirim komentar... - 0%").setSmallIcon(0x7f0201e4);
            (new loadImage(SCReplyFormActivity.this, null)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        }
    }

    loadImage()
    {
        this$0 = SCReplyFormActivity.this;
        super();
    }
}
