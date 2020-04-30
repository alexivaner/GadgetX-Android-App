// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appstate;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzjl;

// Referenced classes of package com.google.android.gms.appstate:
//            AppStateBuffer

public final class AppStateManager
{
    public static interface StateConflictResult
        extends Releasable, Result
    {

        public abstract byte[] getLocalData();

        public abstract String getResolvedVersion();

        public abstract byte[] getServerData();

        public abstract int getStateKey();
    }

    public static interface StateDeletedResult
        extends Result
    {

        public abstract int getStateKey();
    }

    public static interface StateListResult
        extends Result
    {

        public abstract AppStateBuffer getStateBuffer();
    }

    public static interface StateLoadedResult
        extends Releasable, Result
    {

        public abstract byte[] getLocalData();

        public abstract int getStateKey();
    }

    public static interface StateResult
        extends Releasable, Result
    {

        public abstract StateConflictResult getConflictResult();

        public abstract StateLoadedResult getLoadedResult();
    }

    public static abstract class zza extends com.google.android.gms.common.api.zza.zza
    {

        public zza(GoogleApiClient googleapiclient)
        {
            super(AppStateManager.zzGR, googleapiclient);
        }
    }

    private static abstract class zzb extends zza
    {

        zzb(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }
    }

    private static abstract class zzc extends zza
    {

        public Result createFailedResult(Status status)
        {
            return zzf(status);
        }

        public StateListResult zzf(Status status)
        {
            return new StateListResult(this, status) {

                final Status zzGT;
                final zzc zzGZ;

                public AppStateBuffer getStateBuffer()
                {
                    return new AppStateBuffer(null);
                }

                public Status getStatus()
                {
                    return zzGT;
                }

            
            {
                zzGZ = zzc1;
                zzGT = status;
                super();
            }
            };
        }

        public zzc(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }
    }

    private static abstract class zzd extends zza
    {

        public Result createFailedResult(Status status)
        {
            return zzb(status);
        }

        public Status zzb(Status status)
        {
            return status;
        }

        public zzd(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }
    }

    private static abstract class zze extends zza
    {

        public Result createFailedResult(Status status)
        {
            return zzg(status);
        }

        public StateResult zzg(Status status)
        {
            return AppStateManager.zzd(status);
        }

        public zze(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }
    }


    public static final Api API;
    public static final Scope SCOPE_APP_STATE;
    static final com.google.android.gms.common.api.Api.zzc zzGR;
    private static final com.google.android.gms.common.api.Api.zzb zzGS;

    private AppStateManager()
    {
    }

    public static PendingResult delete(GoogleApiClient googleapiclient, int i)
    {
        return googleapiclient.zzb(new zzb(googleapiclient, i) {

            final int zzGU;

            public Result createFailedResult(Status status)
            {
                return zze(status);
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zzjl)zza1);
            }

            protected void zza(zzjl zzjl1)
                throws RemoteException
            {
                zzjl1.zza(this, zzGU);
            }

            public StateDeletedResult zze(Status status)
            {
                return new StateDeletedResult(this, status) {

                    final Status zzGT;
                    final _cls5 zzGW;

                    public int getStateKey()
                    {
                        return zzGW.zzGU;
                    }

                    public Status getStatus()
                    {
                        return zzGT;
                    }

            
            {
                zzGW = _pcls5;
                zzGT = status;
                super();
            }
                };
            }

            
            {
                zzGU = i;
                super(googleapiclient);
            }
        });
    }

    public static int getMaxNumKeys(GoogleApiClient googleapiclient)
    {
        return zza(googleapiclient).zzhe();
    }

    public static int getMaxStateSize(GoogleApiClient googleapiclient)
    {
        return zza(googleapiclient).zzhd();
    }

    public static PendingResult list(GoogleApiClient googleapiclient)
    {
        return googleapiclient.zza(new zzc(googleapiclient) {

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zzjl)zza1);
            }

            protected void zza(zzjl zzjl1)
                throws RemoteException
            {
                zzjl1.zza(this);
            }

        });
    }

    public static PendingResult load(GoogleApiClient googleapiclient, int i)
    {
        return googleapiclient.zza(new zze(googleapiclient, i) {

            final int zzGU;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zzjl)zza1);
            }

            protected void zza(zzjl zzjl1)
                throws RemoteException
            {
                zzjl1.zzb(this, zzGU);
            }

            
            {
                zzGU = i;
                super(googleapiclient);
            }
        });
    }

    public static PendingResult resolve(GoogleApiClient googleapiclient, int i, String s, byte abyte0[])
    {
        return googleapiclient.zzb(new zze(googleapiclient, i, s, abyte0) {

            final int zzGU;
            final String zzGX;
            final byte zzGY[];

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zzjl)zza1);
            }

            protected void zza(zzjl zzjl1)
                throws RemoteException
            {
                zzjl1.zza(this, zzGU, zzGX, zzGY);
            }

            
            {
                zzGU = i;
                zzGX = s;
                zzGY = abyte0;
                super(googleapiclient);
            }
        });
    }

    public static PendingResult signOut(GoogleApiClient googleapiclient)
    {
        return googleapiclient.zzb(new zzd(googleapiclient) {

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zzjl)zza1);
            }

            protected void zza(zzjl zzjl1)
                throws RemoteException
            {
                zzjl1.zzb(this);
            }

        });
    }

    public static void update(GoogleApiClient googleapiclient, int i, byte abyte0[])
    {
        googleapiclient.zzb(new zze(googleapiclient, i, abyte0) {

            final int zzGU;
            final byte zzGV[];

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zzjl)zza1);
            }

            protected void zza(zzjl zzjl1)
                throws RemoteException
            {
                zzjl1.zza(null, zzGU, zzGV);
            }

            
            {
                zzGU = i;
                zzGV = abyte0;
                super(googleapiclient);
            }
        });
    }

    public static PendingResult updateImmediate(GoogleApiClient googleapiclient, int i, byte abyte0[])
    {
        return googleapiclient.zzb(new zze(googleapiclient, i, abyte0) {

            final int zzGU;
            final byte zzGV[];

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zzjl)zza1);
            }

            protected void zza(zzjl zzjl1)
                throws RemoteException
            {
                zzjl1.zza(this, zzGU, zzGV);
            }

            
            {
                zzGU = i;
                zzGV = abyte0;
                super(googleapiclient);
            }
        });
    }

    public static zzjl zza(GoogleApiClient googleapiclient)
    {
        boolean flag;
        if (googleapiclient != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "GoogleApiClient parameter is required.");
        zzx.zza(googleapiclient.isConnected(), "GoogleApiClient must be connected.");
        zzx.zza(googleapiclient.zza(API), "GoogleApiClient is not configured to use the AppState API. Pass AppStateManager.API into GoogleApiClient.Builder#addApi() to use this feature.");
        return (zzjl)googleapiclient.zza(zzGR);
    }

    private static StateResult zzc(Status status)
    {
        return new StateResult(status) {

            final Status zzGT;

            public StateConflictResult getConflictResult()
            {
                return null;
            }

            public StateLoadedResult getLoadedResult()
            {
                return null;
            }

            public Status getStatus()
            {
                return zzGT;
            }

            public void release()
            {
            }

            
            {
                zzGT = status;
                super();
            }
        };
    }

    static StateResult zzd(Status status)
    {
        return zzc(status);
    }

    static 
    {
        zzGR = new com.google.android.gms.common.api.Api.zzc();
        zzGS = new com.google.android.gms.common.api.Api.zzb() {

            public int getPriority()
            {
                return 0x7fffffff;
            }

            public com.google.android.gms.common.api.Api.zza zza(Context context, Looper looper, zzf zzf, Object obj, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
            {
                return zzb(context, looper, zzf, (com.google.android.gms.common.api.Api.ApiOptions.NoOptions)obj, connectioncallbacks, onconnectionfailedlistener);
            }

            public zzjl zzb(Context context, Looper looper, zzf zzf, com.google.android.gms.common.api.Api.ApiOptions.NoOptions nooptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
            {
                return new zzjl(context, looper, zzf, connectioncallbacks, onconnectionfailedlistener);
            }

        };
        SCOPE_APP_STATE = new Scope("https://www.googleapis.com/auth/appstate");
        API = new Api(zzGS, zzGR, new Scope[] {
            SCOPE_APP_STATE
        });
    }
}
