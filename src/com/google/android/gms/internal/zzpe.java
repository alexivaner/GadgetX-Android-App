// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.zzh;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            zzpm, zzpc, zzpi, zzpg

public class zzpe
{
    private static class zza extends Handler
    {

        private final LocationListener zzamV;

        public void handleMessage(Message message)
        {
            switch (message.what)
            {
            default:
                Log.e("LocationClientHelper", "unknown message in LocationHandler.handleMessage");
                return;

            case 1: // '\001'
                message = new Location((Location)message.obj);
                break;
            }
            zzamV.onLocationChanged(message);
        }

        public zza(LocationListener locationlistener)
        {
            zzamV = locationlistener;
        }

        public zza(LocationListener locationlistener, Looper looper)
        {
            super(looper);
            zzamV = locationlistener;
        }
    }

    private static class zzb extends com.google.android.gms.location.zzd.zza
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

        zzb(LocationListener locationlistener, Looper looper)
        {
            if (looper == null)
            {
                locationlistener = new zza(locationlistener);
            } else
            {
                locationlistener = new zza(locationlistener, looper);
            }
            zzamW = locationlistener;
        }
    }

    private static class zzc extends com.google.android.gms.location.zze.zza
    {

        private Handler zzamW;

        public void zza(zzh zzh)
        {
            if (zzamW == null)
            {
                Log.e("LocationClientHelper", "Received a location in client after calling removeLocationUpdates.");
                return;
            } else
            {
                Message message = Message.obtain();
                message.obj = zzh;
                zzamW.sendMessage(message);
                return;
            }
        }
    }


    private final Context mContext;
    private Map zzZH;
    private ContentProviderClient zzamS;
    private boolean zzamT;
    private Map zzamU;
    private final zzpm zzamz;

    public zzpe(Context context, zzpm zzpm1)
    {
        zzamS = null;
        zzamT = false;
        zzZH = new HashMap();
        zzamU = new HashMap();
        mContext = context;
        zzamz = zzpm1;
    }

    private zzb zza(LocationListener locationlistener, Looper looper)
    {
        if (looper == null)
        {
            zzx.zzb(Looper.myLooper(), "Can't create handler inside thread that has not called Looper.prepare()");
        }
        Map map = zzZH;
        map;
        JVM INSTR monitorenter ;
        zzb zzb2 = (zzb)zzZH.get(locationlistener);
        zzb zzb1;
        zzb1 = zzb2;
        if (zzb2 != null)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        zzb1 = new zzb(locationlistener, looper);
        zzZH.put(locationlistener, zzb1);
        map;
        JVM INSTR monitorexit ;
        return zzb1;
        locationlistener;
        map;
        JVM INSTR monitorexit ;
        throw locationlistener;
    }

    public void removeAllListeners()
    {
        Object obj = zzZH;
        obj;
        JVM INSTR monitorenter ;
        Iterator iterator = zzZH.values().iterator();
_L2:
        Object obj1;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_84;
            }
            obj1 = (zzb)iterator.next();
        } while (obj1 == null);
        ((zzpc)zzamz.zzjb()).zza(zzpi.zzb(((com.google.android.gms.location.zzd) (obj1))));
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw exception;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new IllegalStateException(((Throwable) (obj)));
        }
        zzZH.clear();
        exception = zzamU.values().iterator();
_L3:
        do
        {
            if (!exception.hasNext())
            {
                break MISSING_BLOCK_LABEL_155;
            }
            obj1 = (zzc)exception.next();
        } while (obj1 == null);
        ((zzpc)zzamz.zzjb()).zza(zzpi.zza(((com.google.android.gms.location.zze) (obj1))));
          goto _L3
        zzamU.clear();
        obj;
        JVM INSTR monitorexit ;
    }

    public void zzW(boolean flag)
        throws RemoteException
    {
        zzamz.zzfc();
        ((zzpc)zzamz.zzjb()).zzW(flag);
        zzamT = flag;
    }

    public void zza(LocationListener locationlistener)
        throws RemoteException
    {
        zzamz.zzfc();
        zzx.zzb(locationlistener, "Invalid null listener");
        Map map = zzZH;
        map;
        JVM INSTR monitorenter ;
        locationlistener = (zzb)zzZH.remove(locationlistener);
        if (zzamS != null && zzZH.isEmpty())
        {
            zzamS.release();
            zzamS = null;
        }
        if (locationlistener == null)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        locationlistener.release();
        ((zzpc)zzamz.zzjb()).zza(zzpi.zzb(locationlistener));
        map;
        JVM INSTR monitorexit ;
        return;
        locationlistener;
        map;
        JVM INSTR monitorexit ;
        throw locationlistener;
    }

    public void zza(LocationRequest locationrequest, LocationListener locationlistener, Looper looper)
        throws RemoteException
    {
        zzamz.zzfc();
        locationlistener = zza(locationlistener, looper);
        ((zzpc)zzamz.zzjb()).zza(zzpi.zzb(zzpg.zzb(locationrequest), locationlistener));
    }

    public void zzb(Location location)
        throws RemoteException
    {
        zzamz.zzfc();
        ((zzpc)zzamz.zzjb()).zzb(location);
    }

    public void zzb(LocationRequest locationrequest, PendingIntent pendingintent)
        throws RemoteException
    {
        zzamz.zzfc();
        ((zzpc)zzamz.zzjb()).zza(zzpi.zzb(zzpg.zzb(locationrequest), pendingintent));
    }

    public void zzd(PendingIntent pendingintent)
        throws RemoteException
    {
        zzamz.zzfc();
        ((zzpc)zzamz.zzjb()).zza(zzpi.zze(pendingintent));
    }

    public Location zzpx()
    {
        zzamz.zzfc();
        Location location;
        try
        {
            location = ((zzpc)zzamz.zzjb()).zzcj(mContext.getPackageName());
        }
        catch (RemoteException remoteexception)
        {
            throw new IllegalStateException(remoteexception);
        }
        return location;
    }

    public void zzpy()
    {
        if (!zzamT)
        {
            break MISSING_BLOCK_LABEL_12;
        }
        zzW(false);
        return;
        RemoteException remoteexception;
        remoteexception;
        throw new IllegalStateException(remoteexception);
    }
}
