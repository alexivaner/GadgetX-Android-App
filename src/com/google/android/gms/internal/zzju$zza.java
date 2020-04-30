// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.internal:
//            zzju

private static final class zzKF
    implements com.google.android.gms.cast.icationConnectionResult
{

    private final Status zzHb;
    private final ApplicationMetadata zzKD;
    private final String zzKE;
    private final boolean zzKF;
    private final String zzyL;

    public ApplicationMetadata getApplicationMetadata()
    {
        return zzKD;
    }

    public String getApplicationStatus()
    {
        return zzKE;
    }

    public String getSessionId()
    {
        return zzyL;
    }

    public Status getStatus()
    {
        return zzHb;
    }

    public boolean getWasLaunched()
    {
        return zzKF;
    }

    public tadata(Status status)
    {
        this(status, null, null, null, false);
    }

    public tadata(Status status, ApplicationMetadata applicationmetadata, String s, String s1, boolean flag)
    {
        zzHb = status;
        zzKD = applicationmetadata;
        zzKE = s;
        zzyL = s1;
        zzKF = flag;
    }
}
