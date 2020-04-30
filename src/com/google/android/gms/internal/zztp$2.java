// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.plus.internal.zze;

// Referenced classes of package com.google.android.gms.internal:
//            zztp

class eApiClient extends a
{

    final int zzagk;
    final zztp zzauJ;
    final String zzauK;
    final Uri zzauL;
    final String zzauM;
    final String zzauN;

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zze));
    }

    protected void zza(zze zze1)
    {
        zze1.zza(this, zzagk, zzauK, zzauL, zzauM, zzauN);
    }

    eApiClient(zztp zztp1, GoogleApiClient googleapiclient, int i, String s, Uri uri, String s1, String s2)
    {
        zzauJ = zztp1;
        zzagk = i;
        zzauK = s;
        zzauL = uri;
        zzauM = s1;
        zzauN = s2;
        super(googleapiclient, null);
    }
}
