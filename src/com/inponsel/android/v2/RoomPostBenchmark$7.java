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
//            RoomPostBenchmark

class this._cls0
    implements android.view.
{

    final RoomPostBenchmark this$0;

    public void onClick(View view)
    {
        if (netInfo != null && netInfo.isConnected())
        {
            btnPostAskHp.setEnabled(false);
            if (photo_upload == null)
            {
                Toast.makeText(getApplicationContext(), "Screenshoot benchmark belum diisi", 1).show();
                return;
            }
            if (benchmark_apps.equals(""))
            {
                Toast.makeText(getApplicationContext(), "Aplikasi benchmark belum diisi", 1).show();
                return;
            }
            Log.e("photo", "oke");
            view = (new StringBuilder(String.valueOf(String.valueOf(now.get(12))))).append(now.get(13)).toString();
            notif_id = Integer.parseInt(view);
            RoomPostBenchmark.access$12(RoomPostBenchmark.this, (NotificationManager)getSystemService("notification"));
            RoomPostBenchmark.access$13(RoomPostBenchmark.this, new android.support.v4.app.uilder(RoomPostBenchmark.this));
            RoomPostBenchmark.access$0(RoomPostBenchmark.this).setContentTitle((new StringBuilder("Benchmark ")).append(namalengkap).append(" - ").append(benchmark_apps).toString()).setContentText("Mengirim 0%").setSmallIcon(0x7f0201e4);
            if (android.os.T >= 11)
            {
                try
                {
                    (new loadImage(RoomPostBenchmark.this, null)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]).get(90L, TimeUnit.SECONDS);
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
                (new loadImage(RoomPostBenchmark.this, null)).execute(new Void[0]).get(90L, TimeUnit.SECONDS);
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
        } else
        {
            Toast.makeText(getApplicationContext(), "Tidak ada koneksi internet", 1).show();
            return;
        }
    }

    loadImage()
    {
        this$0 = RoomPostBenchmark.this;
        super();
    }
}
