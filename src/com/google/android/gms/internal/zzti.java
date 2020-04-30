// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

// Referenced classes of package com.google.android.gms.internal:
//            zztl

public class zzti
    implements com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
{

    private zztl zzatK;
    private final zztd.zza zzatU;
    private boolean zzatV;

    public zzti(zztd.zza zza1)
    {
        zzatU = zza1;
        zzatK = null;
        zzatV = true;
    }

    public void onConnected(Bundle bundle)
    {
        zzatK.zzae(false);
        if (zzatV && zzatU != null)
        {
            zzatU.zzrE();
        }
        zzatV = false;
    }

    public void onConnectionFailed(ConnectionResult connectionresult)
    {
        zzatK.zzae(true);
        if (zzatV && zzatU != null)
        {
            if (connectionresult.hasResolution())
            {
                zzatU.zzf(connectionresult.getResolution());
            } else
            {
                zzatU.zzrF();
            }
        }
        zzatV = false;
    }

    public void onConnectionSuspended(int i)
    {
        zzatK.zzae(true);
    }

    public void zza(zztl zztl1)
    {
        zzatK = zztl1;
    }

    public void zzad(boolean flag)
    {
        zzatV = flag;
    }
}
