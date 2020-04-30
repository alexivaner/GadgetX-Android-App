// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzk;

// Referenced classes of package com.google.android.gms.internal:
//            zzmr

public abstract class zzmy extends zzk
{

    protected zzmy(Context context, Looper looper, int i, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener, zzf zzf)
    {
        super(context, looper, i, connectioncallbacks, onconnectionfailedlistener, zzf);
    }

    public boolean zzhc()
    {
        return !zzmr.zzV(getContext());
    }

    public boolean zzjd()
    {
        return true;
    }
}
