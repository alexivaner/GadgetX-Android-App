// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Intent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;

class zzsy
    implements com.google.android.gms.panorama.PanoramaApi.PanoramaResult
{

    private final Status zzHb;
    private final Intent zzatA;

    public zzsy(Status status, Intent intent)
    {
        zzHb = (Status)zzx.zzl(status);
        zzatA = intent;
    }

    public Status getStatus()
    {
        return zzHb;
    }

    public Intent getViewerIntent()
    {
        return zzatA;
    }
}
