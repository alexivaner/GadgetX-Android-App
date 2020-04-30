// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.NotificationManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.inponsel.android.utils.Log;
import java.util.Calendar;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

// Referenced classes of package com.inponsel.android.v2:
//            RoomPostHasilFotoNoCrop

class this._cls0
    implements android.view.toNoCrop._cls9
{

    final RoomPostHasilFotoNoCrop this$0;

    public void onClick(View view)
    {
        if (netInfo != null && netInfo.isConnected())
        {
            btnPostAskHp.setEnabled(false);
            if (photo_upload == null)
            {
                Toast.makeText(getApplicationContext(), "Hasil kamera belum diisi", 1).show();
                return;
            }
            if (cahaya_kond.equals(""))
            {
                Toast.makeText(getApplicationContext(), "Kondisi cahaya belum dipilih", 1).show();
                return;
            }
            if (led_flash.equals(""))
            {
                Toast.makeText(getApplicationContext(), "Kondisi LED Flash belum dipilih", 1).show();
                return;
            }
            view = (new StringBuilder(String.valueOf(String.valueOf(now.get(12))))).append(now.get(13)).toString();
            notif_id = Integer.parseInt(view);
            RoomPostHasilFotoNoCrop.access$7(RoomPostHasilFotoNoCrop.this, (NotificationManager)getSystemService("notification"));
            RoomPostHasilFotoNoCrop.access$8(RoomPostHasilFotoNoCrop.this, new android.support.v4.app.(RoomPostHasilFotoNoCrop.this));
            RoomPostHasilFotoNoCrop.access$0(RoomPostHasilFotoNoCrop.this).setContentTitle((new StringBuilder("Hasil kamera: ")).append(namalengkap).toString()).setContentText("Mengirim 0%").setSmallIcon(0x7f0201e4);
            Log.e("photo", "oke");
            if (android.os.mpat.Builder.setSmallIcon >= 11)
            {
                try
                {
                    (new loadImage(RoomPostHasilFotoNoCrop.this, null)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]).get(90L, TimeUnit.SECONDS);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    RoomPostHasilFotoNoCrop.access$9(RoomPostHasilFotoNoCrop.this);
                    view.printStackTrace();
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    RoomPostHasilFotoNoCrop.access$9(RoomPostHasilFotoNoCrop.this);
                    view.printStackTrace();
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    RoomPostHasilFotoNoCrop.access$9(RoomPostHasilFotoNoCrop.this);
                }
                view.printStackTrace();
                return;
            }
            try
            {
                (new loadImage(RoomPostHasilFotoNoCrop.this, null)).execute(new Void[0]).get(90L, TimeUnit.SECONDS);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                RoomPostHasilFotoNoCrop.access$9(RoomPostHasilFotoNoCrop.this);
                view.printStackTrace();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                RoomPostHasilFotoNoCrop.access$9(RoomPostHasilFotoNoCrop.this);
                view.printStackTrace();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                RoomPostHasilFotoNoCrop.access$9(RoomPostHasilFotoNoCrop.this);
            }
            view.printStackTrace();
            return;
        } else
        {
            Toast.makeText(getApplicationContext(), "Tidak ada koneksi internet", 1).show();
            return;
        }
    }

    loadImage()
    {
        this$0 = RoomPostHasilFotoNoCrop.this;
        super();
    }
}
