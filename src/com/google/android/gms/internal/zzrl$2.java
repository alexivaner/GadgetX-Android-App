// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.zze;
import com.google.android.gms.nearby.connection.AppMetadata;

// Referenced classes of package com.google.android.gms.internal:
//            zzrl, zzrk

class eApiClient extends b
{

    final String val$name;
    final AppMetadata zzasX;
    final long zzasY;
    final zze zzasZ;
    final zzrl zzata;

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zzrk));
    }

    protected void zza(zzrk zzrk1)
        throws RemoteException
    {
        zzrk1.zza(this, val$name, zzasX, zzasY, zzasZ);
    }

    eApiClient(GoogleApiClient googleapiclient, String s, AppMetadata appmetadata, long l, zze zze)
    {
        zzata = final_zzrl1;
        val$name = s;
        zzasX = appmetadata;
        zzasY = l;
        zzasZ = zze;
        super(googleapiclient, null);
    }
}
