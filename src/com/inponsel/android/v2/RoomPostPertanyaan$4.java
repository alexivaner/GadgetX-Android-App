// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

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

// Referenced classes of package com.inponsel.android.v2:
//            RoomPostPertanyaan

class this._cls0
    implements android.view.rtanyaan._cls4
{

    final RoomPostPertanyaan this$0;

    public void onClick(View view)
    {
        if (photo_upload == null)
        {
            Log.e("photo", "not");
            view = (new StringBuilder(String.valueOf(String.valueOf(now.get(12))))).append(now.get(13)).toString();
            notif_id = Integer.parseInt(view);
            RoomPostPertanyaan.access$8(RoomPostPertanyaan.this, (NotificationManager)getSystemService("notification"));
            RoomPostPertanyaan.access$9(RoomPostPertanyaan.this, new android.support.v4.app.ilder(RoomPostPertanyaan.this));
            RoomPostPertanyaan.access$0(RoomPostPertanyaan.this).setContentTitle(edtJudulAskHp.getText().toString()).setContentText("Mengirim pertanyaan... - 0%").setSmallIcon(0x7f0201e4);
            try
            {
                RoomPostPertanyaan.access$2(RoomPostPertanyaan.this, id_hp, user_id, URLEncoder.encode((new StringBuilder("Tanya: ")).append(edtJudulAskHp.getText().toString()).toString(), "utf-8"), URLEncoder.encode(edtPertanyaan.getText().toString(), "utf-8"), str_img_url, t);
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
        RoomPostPertanyaan.access$8(RoomPostPertanyaan.this, (NotificationManager)getSystemService("notification"));
        RoomPostPertanyaan.access$9(RoomPostPertanyaan.this, new android.support.v4.app.ilder(RoomPostPertanyaan.this));
        RoomPostPertanyaan.access$0(RoomPostPertanyaan.this).setContentTitle(edtJudulAskHp.getText().toString()).setContentText("Mengirim pertanyaan... - 0%").setSmallIcon(0x7f0201e4);
        if (android.os. >= 11)
        {
            try
            {
                (new loadImage(RoomPostPertanyaan.this, null)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]).get(90L, TimeUnit.SECONDS);
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
            (new loadImage(RoomPostPertanyaan.this, null)).execute(new Void[0]).get(90L, TimeUnit.SECONDS);
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
        this$0 = RoomPostPertanyaan.this;
        super();
    }
}
