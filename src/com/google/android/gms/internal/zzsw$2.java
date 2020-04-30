// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

// Referenced classes of package com.google.android.gms.internal:
//            zzsw, zzsv

class eApiClient extends a
{

    final Uri zzatx;
    final zzsw zzaty;

    protected void zza(Context context, zzsv zzsv)
        throws RemoteException
    {
        zzsw.zzb(context, zzsv, new b(this), zzatx, null);
    }

    eApiClient(zzsw zzsw1, GoogleApiClient googleapiclient, Uri uri)
    {
        zzaty = zzsw1;
        zzatx = uri;
        super(googleapiclient);
    }
}
