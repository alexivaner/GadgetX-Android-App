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

class zzGT
    implements eDeletedResult
{

    final Status zzGT;
    final zzGT zzGW;

    public int getStateKey()
    {
        return zzGW.GU;
    }

    public Status getStatus()
    {
        return zzGT;
    }

    <init>(<init> <init>1, Status status)
    {
        zzGW = <init>1;
        zzGT = status;
        super();
    }

    // Unreferenced inner class com/google/android/gms/appstate/AppStateManager$5

/* anonymous class */
    static final class AppStateManager._cls5 extends AppStateManager.zzb
    {

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

        public AppStateManager.StateDeletedResult zze(Status status)
        {
            return new AppStateManager._cls5._cls1(this, status);
        }

            
            {
                zzGU = i;
                super(googleapiclient);
            }
    }

}
