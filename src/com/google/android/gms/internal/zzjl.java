// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.appstate.AppState;
import com.google.android.gms.appstate.AppStateBuffer;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.common.internal.zzx;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zzjn, zzjk

public final class zzjl extends zzk
{
    private static final class zza extends zzjk
    {

        private final com.google.android.gms.common.api.zza.zzb zzHa;

        public void zzi(int i, int j)
        {
            Status status = new Status(i);
            zzHa.zzd(new zzb(status, j));
        }

        public zza(com.google.android.gms.common.api.zza.zzb zzb1)
        {
            zzHa = (com.google.android.gms.common.api.zza.zzb)zzx.zzb(zzb1, "Result holder must not be null");
        }
    }

    private static final class zzb
        implements com.google.android.gms.appstate.AppStateManager.StateDeletedResult
    {

        private final Status zzHb;
        private final int zzHc;

        public int getStateKey()
        {
            return zzHc;
        }

        public Status getStatus()
        {
            return zzHb;
        }

        public zzb(Status status, int i)
        {
            zzHb = status;
            zzHc = i;
        }
    }

    private static final class zzc extends zzjk
    {

        private final com.google.android.gms.common.api.zza.zzb zzHa;

        public void zza(DataHolder dataholder)
        {
            zzHa.zzd(new zzd(dataholder));
        }

        public zzc(com.google.android.gms.common.api.zza.zzb zzb1)
        {
            zzHa = (com.google.android.gms.common.api.zza.zzb)zzx.zzb(zzb1, "Result holder must not be null");
        }
    }

    private static final class zzd extends com.google.android.gms.common.api.zzc
        implements com.google.android.gms.appstate.AppStateManager.StateListResult
    {

        private final AppStateBuffer zzHd;

        public AppStateBuffer getStateBuffer()
        {
            return zzHd;
        }

        public zzd(DataHolder dataholder)
        {
            super(dataholder);
            zzHd = new AppStateBuffer(dataholder);
        }
    }

    private static final class zze extends zzjk
    {

        private final com.google.android.gms.common.api.zza.zzb zzHa;

        public void zza(int i, DataHolder dataholder)
        {
            zzHa.zzd(new zzf(i, dataholder));
        }

        public zze(com.google.android.gms.common.api.zza.zzb zzb1)
        {
            zzHa = (com.google.android.gms.common.api.zza.zzb)zzx.zzb(zzb1, "Result holder must not be null");
        }
    }

    private static final class zzf extends com.google.android.gms.common.api.zzc
        implements com.google.android.gms.appstate.AppStateManager.StateConflictResult, com.google.android.gms.appstate.AppStateManager.StateLoadedResult, com.google.android.gms.appstate.AppStateManager.StateResult
    {

        private final int zzHc;
        private final AppStateBuffer zzHd;

        private boolean zzhf()
        {
            return zzHb.getStatusCode() == 2000;
        }

        public com.google.android.gms.appstate.AppStateManager.StateConflictResult getConflictResult()
        {
            if (zzhf())
            {
                return this;
            } else
            {
                return null;
            }
        }

        public com.google.android.gms.appstate.AppStateManager.StateLoadedResult getLoadedResult()
        {
            zzf zzf1 = this;
            if (zzhf())
            {
                zzf1 = null;
            }
            return zzf1;
        }

        public byte[] getLocalData()
        {
            if (zzHd.getCount() == 0)
            {
                return null;
            } else
            {
                return zzHd.get(0).getLocalData();
            }
        }

        public String getResolvedVersion()
        {
            if (zzHd.getCount() == 0)
            {
                return null;
            } else
            {
                return zzHd.get(0).getConflictVersion();
            }
        }

        public byte[] getServerData()
        {
            if (zzHd.getCount() == 0)
            {
                return null;
            } else
            {
                return zzHd.get(0).getConflictData();
            }
        }

        public int getStateKey()
        {
            return zzHc;
        }

        public void release()
        {
            zzHd.release();
        }

        public zzf(int i, DataHolder dataholder)
        {
            super(dataholder);
            zzHc = i;
            zzHd = new AppStateBuffer(dataholder);
        }
    }

    private static final class zzg extends zzjk
    {

        private final com.google.android.gms.common.api.zza.zzb zzHa;

        public void zzhb()
        {
            Status status = new Status(0);
            zzHa.zzd(status);
        }

        public zzg(com.google.android.gms.common.api.zza.zzb zzb1)
        {
            zzHa = (com.google.android.gms.common.api.zza.zzb)zzx.zzb(zzb1, "Holder must not be null");
        }
    }


    public zzjl(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzf1, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        super(context, looper, 7, connectioncallbacks, onconnectionfailedlistener, zzf1);
    }

    protected zzjn zzL(IBinder ibinder)
    {
        return zzjn.zza.zzN(ibinder);
    }

    public void zza(com.google.android.gms.common.api.zza.zzb zzb1)
        throws RemoteException
    {
        ((zzjn)zzjb()).zza(new zzc(zzb1));
    }

    public void zza(com.google.android.gms.common.api.zza.zzb zzb1, int i)
        throws RemoteException
    {
        ((zzjn)zzjb()).zzb(new zza(zzb1), i);
    }

    public void zza(com.google.android.gms.common.api.zza.zzb zzb1, int i, String s, byte abyte0[])
        throws RemoteException
    {
        ((zzjn)zzjb()).zza(new zze(zzb1), i, s, abyte0);
    }

    public void zza(com.google.android.gms.common.api.zza.zzb zzb1, int i, byte abyte0[])
        throws RemoteException
    {
        if (zzb1 == null)
        {
            zzb1 = null;
        } else
        {
            zzb1 = new zze(zzb1);
        }
        ((zzjn)zzjb()).zza(zzb1, i, abyte0);
    }

    public void zzb(com.google.android.gms.common.api.zza.zzb zzb1)
        throws RemoteException
    {
        ((zzjn)zzjb()).zzb(new zzg(zzb1));
    }

    public void zzb(com.google.android.gms.common.api.zza.zzb zzb1, int i)
        throws RemoteException
    {
        ((zzjn)zzjb()).zza(new zze(zzb1), i);
    }

    protected String zzcF()
    {
        return "com.google.android.gms.appstate.service.START";
    }

    protected String zzcG()
    {
        return "com.google.android.gms.appstate.internal.IAppStateService";
    }

    protected List zzf(List list)
    {
        zzx.zza(list.contains("https://www.googleapis.com/auth/appstate"), String.format("App State APIs requires %s to function.", new Object[] {
            "https://www.googleapis.com/auth/appstate"
        }));
        return list;
    }

    public boolean zzhc()
    {
        return true;
    }

    public int zzhd()
    {
        int i;
        try
        {
            i = ((zzjn)zzjb()).zzhd();
        }
        catch (RemoteException remoteexception)
        {
            Log.w("AppStateClient", "service died");
            return 2;
        }
        return i;
    }

    public int zzhe()
    {
        int i;
        try
        {
            i = ((zzjn)zzjb()).zzhe();
        }
        catch (RemoteException remoteexception)
        {
            Log.w("AppStateClient", "service died");
            return 2;
        }
        return i;
    }

    protected IInterface zzp(IBinder ibinder)
    {
        return zzL(ibinder);
    }
}
