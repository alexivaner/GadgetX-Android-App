// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationStatusCodes;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zzow, zzpe, zzot, zzpc

public class zzpf extends zzow
{
    private final class zza extends com.google.android.gms.common.internal.zzk.zzc
    {

        private final int zzLs;
        private final String zzamZ[];
        final zzpf zzana;

        protected void zza(com.google.android.gms.location.zzf.zza zza1)
        {
            if (zza1 != null)
            {
                zza1.zza(zzLs, zzamZ);
            }
        }

        protected void zzi(Object obj)
        {
            zza((com.google.android.gms.location.zzf.zza)obj);
        }

        protected void zzjf()
        {
        }

        public zza(com.google.android.gms.location.zzf.zza zza1, int i, String as[])
        {
            zzana = zzpf.this;
            super(zzpf.this, zza1);
            zzLs = LocationStatusCodes.zzfq(i);
            zzamZ = as;
        }
    }

    private static final class zzb extends zzpb.zza
    {

        private com.google.android.gms.location.zzf.zza zzanb;
        private com.google.android.gms.location.zzf.zzb zzanc;
        private zzpf zzand;

        public void zza(int i, String as[])
            throws RemoteException
        {
            if (zzand == null)
            {
                Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times");
                return;
            } else
            {
                zzpf zzpf1 = zzand;
                zzpf zzpf2 = zzand;
                zzpf2.getClass();
                zzpf1.zza(zzpf2. new zza(zzanb, i, as));
                zzand = null;
                zzanb = null;
                zzanc = null;
                return;
            }
        }

        public void zzb(int i, PendingIntent pendingintent)
        {
            if (zzand == null)
            {
                Log.wtf("LocationClientImpl", "onRemoveGeofencesByPendingIntentResult called multiple times");
                return;
            } else
            {
                zzpf zzpf1 = zzand;
                zzpf zzpf2 = zzand;
                zzpf2.getClass();
                zzpf1.zza(zzpf2. new zzc(1, zzanc, i, pendingintent));
                zzand = null;
                zzanb = null;
                zzanc = null;
                return;
            }
        }

        public void zzb(int i, String as[])
        {
            if (zzand == null)
            {
                Log.wtf("LocationClientImpl", "onRemoveGeofencesByRequestIdsResult called multiple times");
                return;
            } else
            {
                zzpf zzpf1 = zzand;
                zzpf zzpf2 = zzand;
                zzpf2.getClass();
                zzpf1.zza(zzpf2. new zzc(2, zzanc, i, as));
                zzand = null;
                zzanb = null;
                zzanc = null;
                return;
            }
        }

        public zzb(com.google.android.gms.location.zzf.zza zza1, zzpf zzpf1)
        {
            zzanb = zza1;
            zzanc = null;
            zzand = zzpf1;
        }

        public zzb(com.google.android.gms.location.zzf.zzb zzb1, zzpf zzpf1)
        {
            zzanc = zzb1;
            zzanb = null;
            zzand = zzpf1;
        }
    }

    private final class zzc extends com.google.android.gms.common.internal.zzk.zzc
    {

        private final PendingIntent mPendingIntent;
        private final int zzLs;
        private final String zzamZ[];
        final zzpf zzana;
        private final int zzane;

        protected void zza(com.google.android.gms.location.zzf.zzb zzb1)
        {
label0:
            {
label1:
                {
                    if (zzb1 != null)
                    {
                        switch (zzane)
                        {
                        default:
                            Log.wtf("LocationClientImpl", (new StringBuilder()).append("Unsupported action: ").append(zzane).toString());
                            break;

                        case 1: // '\001'
                            break label1;

                        case 2: // '\002'
                            break label0;
                        }
                    }
                    return;
                }
                zzb1.zzb(zzLs, mPendingIntent);
                return;
            }
            zzb1.zzb(zzLs, zzamZ);
        }

        protected void zzi(Object obj)
        {
            zza((com.google.android.gms.location.zzf.zzb)obj);
        }

        protected void zzjf()
        {
        }

        public zzc(int i, com.google.android.gms.location.zzf.zzb zzb1, int j, PendingIntent pendingintent)
        {
            boolean flag = true;
            zzana = zzpf.this;
            super(zzpf.this, zzb1);
            if (i != 1)
            {
                flag = false;
            }
            com.google.android.gms.common.internal.zzb.zzN(flag);
            zzane = i;
            zzLs = LocationStatusCodes.zzfq(j);
            mPendingIntent = pendingintent;
            zzamZ = null;
        }

        public zzc(int i, com.google.android.gms.location.zzf.zzb zzb1, int j, String as[])
        {
            zzana = zzpf.this;
            super(zzpf.this, zzb1);
            boolean flag;
            if (i == 2)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            com.google.android.gms.common.internal.zzb.zzN(flag);
            zzane = i;
            zzLs = LocationStatusCodes.zzfq(j);
            zzamZ = as;
            mPendingIntent = null;
        }
    }

    private static final class zzd extends zzpd.zza
    {

        private com.google.android.gms.common.api.zza.zzb zzanf;

        public void zza(LocationSettingsResult locationsettingsresult)
            throws RemoteException
        {
            zzanf.zzd(locationsettingsresult);
            zzanf = null;
        }

        public zzd(com.google.android.gms.common.api.zza.zzb zzb1)
        {
            boolean flag;
            if (zzb1 != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "listener can't be null.");
            zzanf = zzb1;
        }
    }


    private final zzpe zzamX;
    private final zzot zzamY;

    public zzpf(Context context, Looper looper, String s, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener, String s1)
    {
        this(context, looper, s, connectioncallbacks, onconnectionfailedlistener, s1, null);
    }

    public zzpf(Context context, Looper looper, String s, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener, String s1, String s2)
    {
        this(context, looper, s, connectioncallbacks, onconnectionfailedlistener, s1, s2, null);
    }

    public zzpf(Context context, Looper looper, String s, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener, String s1, String s2, 
            String s3)
    {
        super(context, looper, connectioncallbacks, onconnectionfailedlistener, s1);
        zzamX = new zzpe(context, zzamz);
        zzamY = zzot.zza(context, s2, s3, zzamz);
    }

    public void disconnect()
    {
        zzpe zzpe1 = zzamX;
        zzpe1;
        JVM INSTR monitorenter ;
        boolean flag = isConnected();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        zzamX.removeAllListeners();
        zzamX.zzpy();
_L1:
        super.disconnect();
        zzpe1;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        obj;
        Log.e("LocationClientImpl", "Client disconnected before listeners could be cleaned up", ((Throwable) (obj)));
          goto _L1
        obj;
        zzpe1;
        JVM INSTR monitorexit ;
        throw obj;
    }

    public void zzW(boolean flag)
        throws RemoteException
    {
        zzamX.zzW(flag);
    }

    public void zza(long l, PendingIntent pendingintent)
        throws RemoteException
    {
        zzfc();
        zzx.zzl(pendingintent);
        boolean flag;
        if (l >= 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "detectionIntervalMillis must be >= 0");
        ((zzpc)zzjb()).zza(l, true, pendingintent);
    }

    public void zza(PendingIntent pendingintent)
        throws RemoteException
    {
        zzfc();
        zzx.zzl(pendingintent);
        ((zzpc)zzjb()).zza(pendingintent);
    }

    public void zza(PendingIntent pendingintent, com.google.android.gms.location.zzf.zzb zzb1)
        throws RemoteException
    {
        zzfc();
        zzx.zzb(pendingintent, "PendingIntent must be specified.");
        zzx.zzb(zzb1, "OnRemoveGeofencesResultListener not provided.");
        if (zzb1 == null)
        {
            zzb1 = null;
        } else
        {
            zzb1 = new zzb(zzb1, this);
        }
        ((zzpc)zzjb()).zza(pendingintent, zzb1, getContext().getPackageName());
    }

    public void zza(GeofencingRequest geofencingrequest, PendingIntent pendingintent, com.google.android.gms.location.zzf.zza zza1)
        throws RemoteException
    {
        zzfc();
        zzx.zzb(geofencingrequest, "geofencingRequest can't be null.");
        zzx.zzb(pendingintent, "PendingIntent must be specified.");
        zzx.zzb(zza1, "OnAddGeofencesResultListener not provided.");
        if (zza1 == null)
        {
            zza1 = null;
        } else
        {
            zza1 = new zzb(zza1, this);
        }
        ((zzpc)zzjb()).zza(geofencingrequest, pendingintent, zza1);
    }

    public void zza(LocationListener locationlistener)
        throws RemoteException
    {
        zzamX.zza(locationlistener);
    }

    public void zza(LocationRequest locationrequest, LocationListener locationlistener, Looper looper)
        throws RemoteException
    {
        synchronized (zzamX)
        {
            zzamX.zza(locationrequest, locationlistener, looper);
        }
        return;
        locationrequest;
        zzpe1;
        JVM INSTR monitorexit ;
        throw locationrequest;
    }

    public void zza(LocationSettingsRequest locationsettingsrequest, com.google.android.gms.common.api.zza.zzb zzb1, String s)
        throws RemoteException
    {
        boolean flag1 = true;
        zzfc();
        boolean flag;
        if (locationsettingsrequest != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "locationSettingsRequest can't be null nor empty.");
        if (zzb1 != null)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "listener can't be null.");
        zzb1 = new zzd(zzb1);
        ((zzpc)zzjb()).zza(locationsettingsrequest, zzb1, s);
    }

    public void zza(List list, com.google.android.gms.location.zzf.zzb zzb1)
        throws RemoteException
    {
        zzfc();
        String as[];
        boolean flag;
        if (list != null && list.size() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "geofenceRequestIds can't be null nor empty.");
        zzx.zzb(zzb1, "OnRemoveGeofencesResultListener not provided.");
        as = (String[])list.toArray(new String[0]);
        if (zzb1 == null)
        {
            list = null;
        } else
        {
            list = new zzb(zzb1, this);
        }
        ((zzpc)zzjb()).zza(as, list, getContext().getPackageName());
    }

    public void zzb(Location location)
        throws RemoteException
    {
        zzamX.zzb(location);
    }

    public void zzb(LocationRequest locationrequest, PendingIntent pendingintent)
        throws RemoteException
    {
        zzamX.zzb(locationrequest, pendingintent);
    }

    public void zzd(PendingIntent pendingintent)
        throws RemoteException
    {
        zzamX.zzd(pendingintent);
    }

    public Location zzpx()
    {
        return zzamX.zzpx();
    }
}
