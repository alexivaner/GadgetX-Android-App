// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.ConnectionResult;

// Referenced classes of package com.google.android.gms.internal:
//            zzju

private class <init>
    implements com.google.android.gms.common.api.Client.OnConnectionFailedListener
{

    final zzju zzKG;

    public void onConnectionFailed(ConnectionResult connectionresult)
    {
        zzju.zzb(zzKG);
    }

    private esult(zzju zzju1)
    {
        zzKG = zzju1;
        super();
    }

    zzKG(zzju zzju1, zzKG zzkg)
    {
        this(zzju1);
    }
}
