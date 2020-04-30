// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.conversation;

import android.app.NotificationManager;
import android.os.AsyncTask;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import com.inponsel.android.utils.Log;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

// Referenced classes of package com.inponsel.android.conversation:
//            ConversationPost

class this._cls0
    implements android.view.r
{

    final ConversationPost this$0;

    public void onClick(View view)
    {
        if (photo_upload == null)
        {
            Log.e("photo", "not");
            view = (new StringBuilder(String.valueOf(String.valueOf(now.get(12))))).append(now.get(13)).toString();
            notif_id = Integer.parseInt(view);
            ConversationPost.access$8(ConversationPost.this, (NotificationManager)getSystemService("notification"));
            ConversationPost.access$9(ConversationPost.this, new android.support.v4.app.Builder(ConversationPost.this));
            ConversationPost.access$0(ConversationPost.this).setContentTitle(edtJudulAskHp.getText().toString()).setContentText("Mengirim conversation... - 0%").setSmallIcon(0x7f0201e4);
            try
            {
                ConversationPost.access$2(ConversationPost.this, id_hp, user_id, URLEncoder.encode(edtJudulAskHp.getText().toString(), "utf-8"), URLEncoder.encode(edtPertanyaan.getText().toString(), "utf-8"), str_img_url, t);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                view.printStackTrace();
            }
            return;
        }
        Log.e("photo", "oke");
        view = (new StringBuilder(String.valueOf(String.valueOf(now.get(12))))).append(now.get(13)).toString();
        notif_id = Integer.parseInt(view);
        ConversationPost.access$8(ConversationPost.this, (NotificationManager)getSystemService("notification"));
        ConversationPost.access$9(ConversationPost.this, new android.support.v4.app.Builder(ConversationPost.this));
        ConversationPost.access$0(ConversationPost.this).setContentTitle(edtJudulAskHp.getText().toString()).setContentText("Mengirim conversation... - 0%").setSmallIcon(0x7f0201e4);
        if (android.os.NT >= 11)
        {
            try
            {
                (new loadImage(ConversationPost.this, null)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]).get(90L, TimeUnit.SECONDS);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                notifGagal();
                view.printStackTrace();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                notifGagal();
                view.printStackTrace();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                notifGagal();
            }
            view.printStackTrace();
            return;
        }
        try
        {
            (new loadImage(ConversationPost.this, null)).execute(new Void[0]).get(90L, TimeUnit.SECONDS);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            notifGagal();
            view.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            notifGagal();
            view.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            notifGagal();
        }
        view.printStackTrace();
    }

    loadImage()
    {
        this$0 = ConversationPost.this;
        super();
    }
}
