// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;

// Referenced classes of package com.google.android.gms.internal:
//            zzsw, zzsu

static final class a extends a
{

    final Uri zzatx;
    final zzsu zzatz;
    final Context zznK;

    public void zza(int i, Bundle bundle, int j, Intent intent)
        throws RemoteException
    {
        zzsw.zzb(zznK, zzatx);
        zzatz.zza(i, bundle, j, intent);
    }

    a(Context context, Uri uri, zzsu zzsu1)
    {
        zznK = context;
        zzatx = uri;
        zzatz = zzsu1;
        super();
    }
}
