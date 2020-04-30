// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appstate;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzjl;

// Referenced classes of package com.google.android.gms.appstate:
//            AppStateManager

static final class b extends b
{

    final int zzGU;

    public Result createFailedResult(Status status)
    {
        return zze(status);
    }

    protected volatile void zza(com.google.android.gms.common.api.e e)
        throws RemoteException
    {
        zza((zzjl)e);
    }

    protected void zza(zzjl zzjl1)
        throws RemoteException
    {
        zzjl1.zza(this, zzGU);
    }

    public ateDeletedResult zze(Status status)
    {
        return new AppStateManager.StateDeletedResult(status) {

            final Status zzGT;
            final AppStateManager._cls5 zzGW;

            public int getStateKey()
            {
                return zzGW.zzGU;
            }

            public Status getStatus()
            {
                return zzGT;
            }

            
            {
                zzGW = AppStateManager._cls5.this;
                zzGT = status;
                super();
            }
        };
    }

    _cls1.zzGT(GoogleApiClient googleapiclient, int i)
    {
        zzGU = i;
        super(googleapiclient);
    }
}
