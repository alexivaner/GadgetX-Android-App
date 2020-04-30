// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.internal:
//            zzkb

public abstract class zzjr extends com.google.android.gms.common.api.zza.zza
{

    public zzjr(GoogleApiClient googleapiclient)
    {
        super(zzkb.zzGR, googleapiclient);
    }

    public void zzah(int i)
    {
        setResult(createFailedResult(new Status(i)));
    }

    public void zzd(int i, String s)
    {
        setResult(createFailedResult(new Status(i, s, null)));
    }
}
