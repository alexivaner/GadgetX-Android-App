// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.location.LocationListener;

// Referenced classes of package com.google.android.gms.internal:
//            zzpe

private static class zzamW extends com.google.android.gms.location.zzamW
{

    private Handler zzamW;

    public void onLocationChanged(Location location)
    {
        if (zzamW == null)
        {
            Log.e("LocationClientHelper", "Received a location in client after calling removeLocationUpdates.");
            return;
        } else
        {
            Message message = Message.obtain();
            message.what = 1;
            message.obj = location;
            zzamW.sendMessage(message);
            return;
        }
    }

    public void release()
    {
        zzamW = null;
    }

    istener(LocationListener locationlistener, Looper looper)
    {
        if (looper == null)
        {
            locationlistener = new <init>(locationlistener);
        } else
        {
            locationlistener = new <init>(locationlistener, looper);
        }
        zzamW = locationlistener;
    }
}
