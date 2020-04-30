// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.zzi;
import java.util.Arrays;

// Referenced classes of package com.google.android.gms.internal:
//            zzpr, zzps

class zc extends com.google.android.gms.location.places.
{

    final zzpr zzaol;
    final String zzaom[];

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zzps));
    }

    protected void zza(zzps zzps1)
        throws RemoteException
    {
        java.util.List list = Arrays.asList(zzaom);
        zzps1.zza(new zzi(this, zzps1.getContext()), list);
    }

    eApiClient(zzpr zzpr1, com.google.android.gms.common.api. , GoogleApiClient googleapiclient, String as[])
    {
        zzaol = zzpr1;
        zzaom = as;
        super(, googleapiclient);
    }
}
