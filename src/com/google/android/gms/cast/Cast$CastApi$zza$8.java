// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzju;
import com.google.android.gms.internal.zzjy;

// Referenced classes of package com.google.android.gms.cast:
//            Cast

class nt extends zzjy
{

    final zzah zzIt;

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zzju));
    }

    protected void zza(zzju zzju1)
        throws RemoteException
    {
        try
        {
            zzju1.zza("", this);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (zzju zzju1)
        {
            zzah(2001);
        }
    }

    nt(nt nt, GoogleApiClient googleapiclient)
    {
        zzIt = nt;
        super(googleapiclient);
    }
}
